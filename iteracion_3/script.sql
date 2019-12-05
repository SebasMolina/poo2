
CREATE SEQUENCE public.ingrediente_ingredienteid_seq_1;

CREATE TABLE public.ingrediente (
                ingredienteId INTEGER NOT NULL DEFAULT nextval('public.ingrediente_ingredienteid_seq_1'),
                nombre VARCHAR NOT NULL,
                cantidad INTEGER NOT NULL,
                CONSTRAINT ingrediente_pk PRIMARY KEY (ingredienteId)
);


ALTER SEQUENCE public.ingrediente_ingredienteid_seq_1 OWNED BY public.ingrediente.ingredienteId;

CREATE SEQUENCE public.persona_id_seq;

CREATE TABLE public.persona (
                personaId INTEGER NOT NULL DEFAULT nextval('public.persona_id_seq'),
                nombre VARCHAR NOT NULL,
                apellido VARCHAR NOT NULL,
                mail VARCHAR NOT NULL,
                contrasenia VARCHAR NOT NULL,
                tipoPersona INTEGER NOT NULL,
                CONSTRAINT persona_pk PRIMARY KEY (personaId)
);


ALTER SEQUENCE public.persona_id_seq OWNED BY public.persona.personaId;

CREATE TABLE public.proveedor (
                proveedorId INTEGER NOT NULL,
                telefono VARCHAR NOT NULL,
                razonSocial VARCHAR NOT NULL,
                horaInicio TIME NOT NULL,
                horaCierre TIME NOT NULL,
                ciudad VARCHAR NOT NULL,
                CONSTRAINT proveedor_pk PRIMARY KEY (proveedorId)
);


CREATE SEQUENCE public.producto_productoid_seq;

CREATE TABLE public.producto (
                productoId INTEGER NOT NULL DEFAULT nextval('public.producto_productoid_seq'),
                nombre VARCHAR NOT NULL,
                proveedorId INTEGER NOT NULL,
                cantidad INTEGER NOT NULL,
                ingredienteSeleccion BOOLEAN DEFAULT false NOT NULL,
                precio DOUBLE PRECISION NOT NULL,
                CONSTRAINT producto_pk PRIMARY KEY (productoId)
);


ALTER SEQUENCE public.producto_productoid_seq OWNED BY public.producto.productoId;

CREATE SEQUENCE public.ingredientexproducto_ingredientexproductoid_seq;

CREATE TABLE public.ingredientexproducto (
                ingredientexproductoid INTEGER NOT NULL DEFAULT nextval('public.ingredientexproducto_ingredientexproductoid_seq'),
                ingredienteId INTEGER NOT NULL,
                productoId INTEGER NOT NULL,
                CONSTRAINT ingredientexproducto_pk PRIMARY KEY (ingredientexproductoid)
);


ALTER SEQUENCE public.ingredientexproducto_ingredientexproductoid_seq OWNED BY public.ingredientexproducto.ingredientexproductoid;

CREATE TABLE public.direccion (
                personaId INTEGER NOT NULL,
                calle VARCHAR NOT NULL,
                numero VARCHAR,
                cp VARCHAR NOT NULL,
                piso VARCHAR,
                dpto VARCHAR,
                CONSTRAINT direccion_pk PRIMARY KEY (personaId)
);


CREATE TABLE public.usuario (
                usuarioId INTEGER NOT NULL,
                nombreUsuario VARCHAR NOT NULL,
                telefono VARCHAR NOT NULL,
                CONSTRAINT usuario_pk PRIMARY KEY (usuarioId)
);


CREATE TABLE public.pedido (
                pedidoId INTEGER NOT NULL,
                notas VARCHAR NOT NULL,
                usuarioId INTEGER NOT NULL,
                CONSTRAINT pedido_pk PRIMARY KEY (pedidoId)
);


CREATE SEQUENCE public.productoxpedido_productoxpedido_seq;

CREATE TABLE public.productoxpedido (
                productoxpedido INTEGER NOT NULL DEFAULT nextval('public.productoxpedido_productoxpedido_seq'),
                productoId INTEGER NOT NULL,
                pedidoId INTEGER NOT NULL,
                CONSTRAINT productoxpedido_pk PRIMARY KEY (productoxpedido)
);


ALTER SEQUENCE public.productoxpedido_productoxpedido_seq OWNED BY public.productoxpedido.productoxpedido;

CREATE SEQUENCE public.detallecomprobante_detalleid_seq_1;

CREATE TABLE public.detalleComprobante (
                detalleId INTEGER NOT NULL DEFAULT nextval('public.detallecomprobante_detalleid_seq_1'),
                total DOUBLE PRECISION NOT NULL,
                pedidoId INTEGER NOT NULL,
                CONSTRAINT detallecomprobante_pk PRIMARY KEY (detalleId)
);


ALTER SEQUENCE public.detallecomprobante_detalleid_seq_1 OWNED BY public.detalleComprobante.detalleId;

CREATE SEQUENCE public.comprobante_comprobanteid_seq;

CREATE TABLE public.comprobante (
                comprobanteId INTEGER NOT NULL DEFAULT nextval('public.comprobante_comprobanteid_seq'),
                proveedorId INTEGER NOT NULL,
                usuarioId INTEGER NOT NULL,
                hora TIME NOT NULL,
                detalleId INTEGER NOT NULL,
                CONSTRAINT comprobante_pk PRIMARY KEY (comprobanteId)
);


ALTER SEQUENCE public.comprobante_comprobanteid_seq OWNED BY public.comprobante.comprobanteId;

CREATE TABLE public.opinion (
                OpinionId INTEGER NOT NULL,
                usuarioId INTEGER NOT NULL,
                proveedorId INTEGER NOT NULL,
                valoracion INTEGER NOT NULL,
                descripcion VARCHAR NOT NULL,
                CONSTRAINT opinion_pk PRIMARY KEY (OpinionId)
);


ALTER TABLE public.ingredientexproducto ADD CONSTRAINT ingrediente_ingredientexproducto_fk
FOREIGN KEY (ingredienteId)
REFERENCES public.ingrediente (ingredienteId)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.usuario ADD CONSTRAINT persona_usuario_fk
FOREIGN KEY (usuarioId)
REFERENCES public.persona (personaId)
ON DELETE CASCADE
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.direccion ADD CONSTRAINT persona_direccion_fk
FOREIGN KEY (personaId)
REFERENCES public.persona (personaId)
ON DELETE CASCADE
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.proveedor ADD CONSTRAINT persona_proveedor_fk
FOREIGN KEY (proveedorId)
REFERENCES public.persona (personaId)
ON DELETE CASCADE
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.opinion ADD CONSTRAINT proveedor_opinion_fk
FOREIGN KEY (proveedorId)
REFERENCES public.proveedor (proveedorId)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.producto ADD CONSTRAINT proveedor_producto_fk
FOREIGN KEY (proveedorId)
REFERENCES public.proveedor (proveedorId)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.comprobante ADD CONSTRAINT proveedor_comprobante_fk
FOREIGN KEY (proveedorId)
REFERENCES public.proveedor (proveedorId)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.productoxpedido ADD CONSTRAINT producto_productoxpedido_fk
FOREIGN KEY (productoId)
REFERENCES public.producto (productoId)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.ingredientexproducto ADD CONSTRAINT producto_ingredientexproducto_fk
FOREIGN KEY (productoId)
REFERENCES public.producto (productoId)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.opinion ADD CONSTRAINT usuario_opinion_fk
FOREIGN KEY (usuarioId)
REFERENCES public.usuario (usuarioId)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.comprobante ADD CONSTRAINT usuario_comprobante_fk
FOREIGN KEY (usuarioId)
REFERENCES public.usuario (usuarioId)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.pedido ADD CONSTRAINT usuario_pedido_fk
FOREIGN KEY (usuarioId)
REFERENCES public.usuario (usuarioId)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.detalleComprobante ADD CONSTRAINT pedido_detallecomprobante_fk
FOREIGN KEY (pedidoId)
REFERENCES public.pedido (pedidoId)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.productoxpedido ADD CONSTRAINT pedido_productoxpedido_fk
FOREIGN KEY (pedidoId)
REFERENCES public.pedido (pedidoId)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.comprobante ADD CONSTRAINT detallecomprobante_comprobante_fk
FOREIGN KEY (detalleId)
REFERENCES public.detalleComprobante (detalleId)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
