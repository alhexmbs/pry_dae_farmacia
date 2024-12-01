-- Reporte Mensual de Ventas de Productos con Variación y Stock
WITH ventas_mensuales AS (
    SELECT
        EXTRACT(MONTH FROM p.fecha_hora) AS mes,  -- Extraer solo el número del mes (1-12)
        pf.nombre AS producto,                     -- Nombre del producto
        ff.forma_farmaceutica AS forma_producto,   -- Forma farmacéutica del producto
        SUM(d.cantidad * d.precio_final) AS total_ventas, -- Sumar cantidad * precio_final para obtener total de ventas por producto
        SUM(d.cantidad) AS cantidad_vendida        -- Sumar las cantidades vendidas
    FROM 
        pedido p
    INNER JOIN 
        pedido_detalle_producto_forma d ON p.id_pedido = d.id_pedido
    INNER JOIN 
        producto_farmaceutico pf ON d.id_producto = pf.id_producto
    INNER JOIN
        forma_farmaceutica ff ON d.id_frm_farma = ff.id_frm_farma  -- Unimos con la forma farmacéutica
    WHERE 
        EXTRACT(YEAR FROM p.fecha_hora) = 2024  -- Filtrar por el año 2024
        AND pf.nombre IN ('Amoxicilina')  -- Filtrar por productos
        AND ff.forma_farmaceutica IN ('Jarabe')  -- Filtrar por formas farmacéuticas
    GROUP BY 
        mes, producto, forma_producto  -- Agrupamos por mes, producto y forma
    ORDER BY 
        mes
),
variacion_ventas AS (
    SELECT
        vm.mes,
        vm.producto,
        vm.forma_producto,
        vm.total_ventas,
        vm.cantidad_vendida,
        COALESCE(LAG(vm.total_ventas) OVER (PARTITION BY vm.producto, vm.forma_producto ORDER BY vm.mes), 0) AS ventas_previas,  -- COALESCE para ventas previas
        COALESCE(
            CASE
                WHEN LAG(vm.total_ventas) OVER (PARTITION BY vm.producto, vm.forma_producto ORDER BY vm.mes) IS NULL THEN 0
                ELSE ROUND(((vm.total_ventas - LAG(vm.total_ventas) OVER (PARTITION BY vm.producto, vm.forma_producto ORDER BY vm.mes)) / LAG(vm.total_ventas) OVER (PARTITION BY vm.producto, vm.forma_producto ORDER BY vm.mes)) * 100, 2)
            END, 
            0
        ) AS variacion_porcentual  -- COALESCE para variación porcentual
    FROM 
        ventas_mensuales vm
)
SELECT
    vv.mes,
    vv.producto,
    vv.forma_producto,
    vv.cantidad_vendida,
    vv.total_ventas,
    vv.ventas_previas,
    vv.variacion_porcentual
FROM 
    variacion_ventas vv
ORDER BY 
    vv.mes;



-----------------------------------------------------------------------------------------
--------------------------------------------------
----------------------------------------------------------------------------------

WITH productos_proximos_vencer AS (
    SELECT
        pf.id_producto,                       -- ID del producto
        pf.nombre AS producto,                -- Nombre del producto
        ff.forma_farmaceutica,                -- Forma farmacéutica del producto
        l.fecha_vencimiento,                  -- Fecha de vencimiento del lote
        SUM(d.cantidad) AS stock_vendido,     -- Total de la cantidad vendida del producto
        SUM(l.cantidad_lote) AS stock_total   -- Stock total disponible del producto
    FROM 
        producto_farmaceutico pf
    INNER JOIN 
        pedido_detalle_producto_forma d ON pf.id_producto = d.id_producto  -- Relación con detalle de pedido
    INNER JOIN 
        pedido p ON d.id_pedido = p.id_pedido
    LEFT JOIN 
        lote l ON pf.id_producto = l.id_producto  -- Relación con el lote
    LEFT JOIN 
        forma_farmaceutica ff ON l.id_frm_farma = ff.id_frm_farma  -- Relación con la forma farmacéutica desde lote
    WHERE 
        EXTRACT(YEAR FROM p.fecha_hora) = EXTRACT(YEAR FROM CURRENT_DATE)  -- Filtramos por el año actual
        AND l.fecha_vencimiento BETWEEN '2022-01-01' AND '2024-12-30'  -- Rango de fecha de vencimiento
    GROUP BY 
        pf.id_producto, pf.nombre, ff.forma_farmaceutica, l.fecha_vencimiento
    ORDER BY
        l.fecha_vencimiento  -- Ordenamos por fecha de vencimiento
)
SELECT 
    ppv.producto, 
    ppv.forma_farmaceutica, 
    TO_CHAR(ppv.fecha_vencimiento, 'YYYY-MM-DD') AS fecha_vencimiento,
    ppv.stock_total, 
    ppv.stock_vendido, 
    ppv.stock_total - ppv.stock_vendido AS stock_disponible,
    CASE
        WHEN ppv.stock_total - ppv.stock_vendido < 10 THEN 'Promoción urgente'
        WHEN ppv.fecha_vencimiento <= CURRENT_DATE + INTERVAL '30 days' THEN 'Promoción de venta rápida'
        WHEN ppv.stock_total - ppv.stock_vendido >= 50 THEN 'Redistribución'
        ELSE 'Sin acción sugerida'
    END AS accion_sugerida  -- Sugerencias de acciones basadas en el stock disponible
FROM 
    productos_proximos_vencer ppv;








