-- Reporte Mensual de Ventas de Productos con Variación y Stock
WITH ventas_mensuales AS (
    SELECT
        DATE_TRUNC('month', p.fecha_hora) AS mes,
        pf.nombre AS producto,
        SUM(d.cantidad) AS cantidad_vendida,
        SUM(d.precio_final) AS total_ventas
    FROM 
        pedido p
    INNER JOIN 
        pedido_detalle_producto_forma d ON p.id_pedido = d.id_pedido
    INNER JOIN 
        producto_farmaceutico pf ON d.id_producto = pf.id_producto
    WHERE 
        EXTRACT(YEAR FROM p.fecha_hora) = 2024 -- Filtrar por año
    GROUP BY 
        mes, producto
    ORDER BY 
        mes
),
variacion_ventas AS (
    SELECT
        vm.mes,
        vm.producto,
        vm.cantidad_vendida,
        vm.total_ventas,
        LAG(vm.total_ventas) OVER (PARTITION BY vm.producto ORDER BY vm.mes) AS ventas_previas,
        -- Cálculo de variación porcentual
        CASE
            WHEN LAG(vm.total_ventas) OVER (PARTITION BY vm.producto ORDER BY vm.mes) IS NULL THEN NULL
            ELSE ROUND(((vm.total_ventas - LAG(vm.total_ventas) OVER (PARTITION BY vm.producto ORDER BY vm.mes)) / LAG(vm.total_ventas) OVER (PARTITION BY vm.producto ORDER BY vm.mes)) * 100, 2)
        END AS variacion_porcentual
    FROM 
        ventas_mensuales vm
)
SELECT
    vv.mes,
    vv.producto,
    vv.cantidad_vendida,
    vv.total_ventas,
    COALESCE(vv.variacion_porcentual, 0) AS variacion_porcentual,
    l.cantidad_lote AS stock_actual, -- Stock actual del producto
    -- Proyección simple: Sugerencia de compra basada en la venta promedio de los últimos 3 meses
    ROUND(vv.cantidad_vendida * 1.2) AS compra_sugerida -- Ejemplo de regla de negocio
FROM 
    variacion_ventas vv
LEFT JOIN 
    lote l ON vv.producto = (SELECT nombre FROM producto_farmaceutico WHERE id_producto = l.id_producto)
ORDER BY 
    vv.mes, vv.producto;


-- Reporte de Productos Próximos a Vencer y Análisis de Stock
WITH productos_vencer AS (
    SELECT
        l.id_lote,
        p.nombre AS producto,
        l.fecha_vencimiento,
        l.cantidad_lote AS stock_actual,
        (l.fecha_vencimiento - CURRENT_DATE) AS dias_para_vencer -- Diferencia de días entre hoy y vencimiento
    FROM 
        lote l
    INNER JOIN 
        producto_farmaceutico p ON l.id_producto = p.id_producto
    WHERE 
        l.fecha_vencimiento > CURRENT_DATE -- Solo productos aún no vencidos
        AND (l.fecha_vencimiento - CURRENT_DATE) <= 30 -- Próximos 30 días
),
ventas_recientes AS (
    SELECT
        dp.id_producto,
        SUM(dp.cantidad) AS cantidad_vendida,
        COUNT(*) AS numero_ventas
    FROM 
        pedido_detalle_producto_forma dp -- Usar el nombre correcto de la tabla detalle
    INNER JOIN 
        pedido p ON dp.id_pedido = p.id_pedido -- Relación entre pedido y detalle
    WHERE 
        p.fecha_hora >= CURRENT_DATE - INTERVAL '30 days' -- Ventas de los últimos 30 días
    GROUP BY 
        dp.id_producto
)
SELECT
    pv.producto,
    pv.fecha_vencimiento,
    pv.dias_para_vencer,
    pv.stock_actual,
    COALESCE(vr.cantidad_vendida, 0) AS ventas_ultimos_30_dias,
    CASE
        WHEN vr.cantidad_vendida IS NULL OR vr.cantidad_vendida = 0 THEN 'Baja Rotación'
        WHEN vr.cantidad_vendida / pv.stock_actual > 1 THEN 'Alta Demanda'
        ELSE 'Rotación Media'
    END AS clasificacion_rotacion
FROM 
    productos_vencer pv
LEFT JOIN 
    ventas_recientes vr ON pv.id_lote = vr.id_producto
ORDER BY 
    pv.dias_para_vencer ASC, pv.producto;



