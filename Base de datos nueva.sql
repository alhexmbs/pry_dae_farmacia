CREATE TABLE FORMA_FARMACEUTICA (id_frm_farma SERIAL NOT NULL, forma_farmaceutica varchar(150) NOT NULL, estado bool NOT NULL, PRIMARY KEY (id_frm_farma));
CREATE TABLE PRODUCTO_FARMACEUTICO (id_producto SERIAL NOT NULL, nombre varchar(200) NOT NULL, nro_reg_sanitario char(6) NOT NULL UNIQUE, condicion_venta varchar(150) NOT NULL, id_promocion int4, id_rubro int4 NOT NULL, PRIMARY KEY (id_producto));
CREATE TABLE PEDIDO (id_pedido SERIAL NOT NULL, fecha_hora timestamp NOT NULL, estado_pedido varchar(20) NOT NULL, subTotal numeric(10, 2) NOT NULL, id_usuario int4 NOT NULL, id_cliente int4 NOT NULL, PRIMARY KEY (id_pedido));
CREATE TABLE USUARIO (id_usuario SERIAL NOT NULL, nombre varchar(100) NOT NULL, ape_paterno varchar(100) NOT NULL, ape_materno varchar(100) NOT NULL, nro_documento varchar(15) NOT NULL UNIQUE, fecha_nacimiento date NOT NULL, direccion varchar(200) NOT NULL, nro_celular char(9) NOT NULL UNIQUE, sexo bool NOT NULL, sueldo numeric(10, 2) NOT NULL, horario varchar(200) NOT NULL, username varchar(100) NOT NULL, email varchar(200) NOT NULL, contrasena varchar(50) NOT NULL, ultimo_login timestamp NOT NULL, estado bool NOT NULL, id_rol int4 NOT NULL, id_tipo_doc int4 NOT NULL, PRIMARY KEY (id_usuario));
CREATE TABLE CLIENTE (id_cliente SERIAL NOT NULL, nro_documento varchar(15) NOT NULL UNIQUE, nombre varchar(100), ape_paterno varchar(100), ape_materno varchar(100), fecha_nacimiento date, sexo bool NOT NULL, email varchar(200), estado bool NOT NULL, id_tipo_doc int4 NOT NULL, PRIMARY KEY (id_cliente));
CREATE TABLE ROL (id_rol SERIAL NOT NULL, rol varchar(100) NOT NULL, descripcion varchar(200) NOT NULL, estado bool NOT NULL, PRIMARY KEY (id_rol));
CREATE TABLE COMPROBANTE_VENTA (id_comprobante SERIAL NOT NULL, serie_nro_comprobante varchar(10) NOT NULL UNIQUE, fecha_hora date NOT NULL, importe_total numeric(10, 2) NOT NULL, id_cliente int4 NOT NULL, id_usuario int4 NOT NULL, id_tipo_comprobante int4 NOT NULL, id_pedido int4 NOT NULL, PRIMARY KEY (id_comprobante));
CREATE TABLE TIPO_DOC (id_tipo_doc SERIAL NOT NULL, tipo_doc varchar(50) NOT NULL, PRIMARY KEY (id_tipo_doc));
CREATE TABLE PROMOCION (id_promocion SERIAL NOT NULL, dscto int4 NOT NULL, fecha_inicio date NOT NULL, fecha_fin date NOT NULL, estado bool NOT NULL, PRIMARY KEY (id_promocion));
CREATE TABLE PAGO (id_pago SERIAL NOT NULL, monto_pago numeric(10, 2) NOT NULL, estado_pago varchar(15) NOT NULL, id_pedido int4 NOT NULL, id_usuario int4 NOT NULL, id_cliente int4 NOT NULL, id_metodo_pago int4 NOT NULL, PRIMARY KEY (id_pago));
CREATE TABLE METODO_PAGO (id_metodo_pago SERIAL NOT NULL, metodo_pago varchar(15) NOT NULL, descripcion varchar(150) NOT NULL, estado bool NOT NULL, PRIMARY KEY (id_metodo_pago));
CREATE TABLE FABRICANTE (id_fabricante SERIAL NOT NULL, nombre_fabricante varchar(150) NOT NULL, estado bool NOT NULL, PRIMARY KEY (id_fabricante));
CREATE TABLE RUBRO (id_rubro SERIAL NOT NULL, nombre_rubro varchar(255) NOT NULL, estado bool NOT NULL, PRIMARY KEY (id_rubro));
CREATE TABLE TIPO_COMPROBANTE (id_tipo_comprobante SERIAL NOT NULL, tipo_comprobante varchar(50) NOT NULL, PRIMARY KEY (id_tipo_comprobante));
CREATE TABLE LOTE (id_lote SERIAL NOT NULL, fecha_entrada date NOT NULL, cantidad_lote int4 NOT NULL, precio_compra numeric(10, 2) NOT NULL, numero_lote varchar(100) NOT NULL, estado bool NOT NULL, fecha_vencimiento date NOT NULL, id_usuario int4 NOT NULL, id_frm_farma int4 NOT NULL, id_producto int4 NOT NULL, PRIMARY KEY (id_lote));
CREATE TABLE CAJA (id_caja SERIAL NOT NULL, numero_caja varchar(20) NOT NULL, estado bool NOT NULL, PRIMARY KEY (id_caja));
CREATE TABLE USUARIO_CAJA (id_usuario int4 NOT NULL, id_caja int4 NOT NULL, monto_inicial numeric(10, 2) NOT NULL, monto_final numeric(10, 2) NOT NULL, fecha_hora_apertura timestamp NOT NULL, fecha_hora_cierre timestamp NOT NULL, transacciones_realizadas int4 NOT NULL, PRIMARY KEY (id_usuario, id_caja));
CREATE TABLE DETALLE_PRODUCTO_FORMA (id_frm_farma int4 NOT NULL, id_producto int4 NOT NULL, stock int4 NOT NULL, precio_venta numeric(10, 2) NOT NULL, estado char(1) NOT NULL, principio_activo varchar(150) NOT NULL, dosis varchar(10) NOT NULL, id_fabricante int4 NOT NULL, PRIMARY KEY (id_frm_farma, id_producto));
CREATE TABLE PEDIDO_DETALLE_PRODUCTO_FORMA (id_pedido int4 NOT NULL, id_frm_farma int4 NOT NULL, id_producto int4 NOT NULL, cantidad int4 NOT NULL, precio_unitario numeric(10, 2) NOT NULL, dscto_aplicado int4 NOT NULL, precio_final numeric(10, 2) NOT NULL, PRIMARY KEY (id_pedido, id_frm_farma, id_producto));
ALTER TABLE USUARIO ADD CONSTRAINT FKUSUARIO4727 FOREIGN KEY (id_rol) REFERENCES ROL (id_rol);
ALTER TABLE PEDIDO ADD CONSTRAINT FKPEDIDO686910 FOREIGN KEY (id_usuario) REFERENCES USUARIO (id_usuario);
ALTER TABLE PEDIDO ADD CONSTRAINT FKPEDIDO358717 FOREIGN KEY (id_cliente) REFERENCES CLIENTE (id_cliente);
ALTER TABLE COMPROBANTE_VENTA ADD CONSTRAINT FKCOMPROBANT782445 FOREIGN KEY (id_cliente) REFERENCES CLIENTE (id_cliente);
ALTER TABLE COMPROBANTE_VENTA ADD CONSTRAINT FKCOMPROBANT889360 FOREIGN KEY (id_usuario) REFERENCES USUARIO (id_usuario);
ALTER TABLE LOTE ADD CONSTRAINT FKLOTE471877 FOREIGN KEY (id_usuario) REFERENCES USUARIO (id_usuario);
ALTER TABLE USUARIO ADD CONSTRAINT FKUSUARIO697242 FOREIGN KEY (id_tipo_doc) REFERENCES TIPO_DOC (id_tipo_doc);
ALTER TABLE CLIENTE ADD CONSTRAINT FKCLIENTE736018 FOREIGN KEY (id_tipo_doc) REFERENCES TIPO_DOC (id_tipo_doc);
ALTER TABLE PRODUCTO_FARMACEUTICO ADD CONSTRAINT FKPRODUCTO_F81140 FOREIGN KEY (id_promocion) REFERENCES PROMOCION (id_promocion);
ALTER TABLE PAGO ADD CONSTRAINT FKPAGO690333 FOREIGN KEY (id_pedido) REFERENCES PEDIDO (id_pedido);
ALTER TABLE PAGO ADD CONSTRAINT FKPAGO577194 FOREIGN KEY (id_usuario) REFERENCES USUARIO (id_usuario);
ALTER TABLE PAGO ADD CONSTRAINT FKPAGO905387 FOREIGN KEY (id_cliente) REFERENCES CLIENTE (id_cliente);
ALTER TABLE COMPROBANTE_VENTA ADD CONSTRAINT FKCOMPROBANT448696 FOREIGN KEY (id_tipo_comprobante) REFERENCES TIPO_COMPROBANTE (id_tipo_comprobante);
ALTER TABLE COMPROBANTE_VENTA ADD CONSTRAINT FKCOMPROBANT997499 FOREIGN KEY (id_pedido) REFERENCES PEDIDO (id_pedido);
ALTER TABLE PAGO ADD CONSTRAINT FKPAGO631040 FOREIGN KEY (id_metodo_pago) REFERENCES METODO_PAGO (id_metodo_pago);
ALTER TABLE USUARIO_CAJA ADD CONSTRAINT FKUSUARIO_CA736146 FOREIGN KEY (id_usuario) REFERENCES USUARIO (id_usuario);
ALTER TABLE USUARIO_CAJA ADD CONSTRAINT FKUSUARIO_CA801807 FOREIGN KEY (id_caja) REFERENCES CAJA (id_caja);
ALTER TABLE DETALLE_PRODUCTO_FORMA ADD CONSTRAINT FKDETALLE_PR312525 FOREIGN KEY (id_frm_farma) REFERENCES FORMA_FARMACEUTICA (id_frm_farma);
ALTER TABLE DETALLE_PRODUCTO_FORMA ADD CONSTRAINT FKDETALLE_PR73294 FOREIGN KEY (id_producto) REFERENCES PRODUCTO_FARMACEUTICO (id_producto);
ALTER TABLE DETALLE_PRODUCTO_FORMA ADD CONSTRAINT FKDETALLE_PR728963 FOREIGN KEY (id_fabricante) REFERENCES FABRICANTE (id_fabricante);
ALTER TABLE PEDIDO_DETALLE_PRODUCTO_FORMA ADD CONSTRAINT FKPEDIDO_DET309548 FOREIGN KEY (id_pedido) REFERENCES PEDIDO (id_pedido);
ALTER TABLE PEDIDO_DETALLE_PRODUCTO_FORMA ADD CONSTRAINT FKPEDIDO_DET993544 FOREIGN KEY (id_frm_farma, id_producto) REFERENCES DETALLE_PRODUCTO_FORMA (id_frm_farma, id_producto);
ALTER TABLE PRODUCTO_FARMACEUTICO ADD CONSTRAINT FKPRODUCTO_F552915 FOREIGN KEY (id_rubro) REFERENCES RUBRO (id_rubro);
ALTER TABLE LOTE ADD CONSTRAINT FKLOTE901019 FOREIGN KEY (id_frm_farma, id_producto) REFERENCES DETALLE_PRODUCTO_FORMA (id_frm_farma, id_producto);


--inserts
INSERT INTO TIPO_DOC VALUES (1, 'DNI');

INSERT INTO ROL VALUES (1, 'Administrador', 'El que administra', TRUE);
INSERT INTO ROL VALUES (2, 'Vendedor', 'El que vende', TRUE);

INSERT INTO USUARIO VALUES (1, 'Juan', 'Perez', 'Lopez', '12345678', '1980-05-10', 'Calle Falsa 123', '987654321', TRUE, 1500.00, '9:00 a 18:00', 'juanp', 'juan@example.com', 'juanito123', NOW(), TRUE, 1, 1);
INSERT INTO USUARIO VALUES (2, 'Pepe', 'Fernandez', 'Gomez', '22335578', '2000-06-06', 'Calle Falsa 333', '987456321', TRUE, 1500.00, '9:00 a 18:00', 'pepepo', 'pepe@example.com', 'pepito123', NOW(), TRUE, 2, 1);
