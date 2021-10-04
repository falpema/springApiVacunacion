-- Table: public.t_empleado

-- DROP TABLE public.t_empleado;

CREATE TABLE IF NOT EXISTS public.t_empleado
(
    apellidos character(40) COLLATE pg_catalog."default" NOT NULL,
    cedula character(15) COLLATE pg_catalog."default" NOT NULL,
    nombres character(30) COLLATE pg_catalog."default" NOT NULL,
    email character(30) COLLATE pg_catalog."default" NOT NULL,
    "fechaNacimiento" date,
    direccion character(50) COLLATE pg_catalog."default",
    "telefonoMovil" character(15) COLLATE pg_catalog."default",
    vacunado character(2) COLLATE pg_catalog."default",
    usuario character(12)[] COLLATE pg_catalog."default",
    password character(12)[] COLLATE pg_catalog."default",
    CONSTRAINT t_empleado_pkey PRIMARY KEY (cedula)
)

TABLESPACE pg_default;

ALTER TABLE public.t_empleado
    OWNER to postgres;

COMMENT ON COLUMN public.t_empleado."fechaNacimiento"
    IS 'Fecha de Nacimiento del Empleado';

COMMENT ON COLUMN public.t_empleado.direccion
    IS 'Direccion del Domicilio';

COMMENT ON COLUMN public.t_empleado."telefonoMovil"
    IS 'telefono movil del empleado';

COMMENT ON COLUMN public.t_empleado.vacunado
    IS 'campo para conocer si esta vacunado S/N';

COMMENT ON COLUMN public.t_empleado.usuario
    IS 'usuario del empleado';

COMMENT ON COLUMN public.t_empleado.password
    IS 'clave del empleado';



    -- Table: public.t_tipo_vacuna

-- DROP TABLE public.t_tipo_vacuna;

CREATE TABLE IF NOT EXISTS public.t_tipo_vacuna
(
    codigo character(4) COLLATE pg_catalog."default" NOT NULL,
    descripcion character(20) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT t_tipo_vacuna_pkey PRIMARY KEY (codigo)
)

TABLESPACE pg_default;

ALTER TABLE public.t_tipo_vacuna
    OWNER to postgres;

COMMENT ON TABLE public.t_tipo_vacuna
    IS 'tabla de los tipos de vacuna';

COMMENT ON COLUMN public.t_tipo_vacuna.codigo
    IS 'Codigo de la vacuna';

COMMENT ON COLUMN public.t_tipo_vacuna.descripcion
    IS 'nombre de la vacuna';



    -- Table: public.t_empleado_vacuna

-- DROP TABLE public.t_empleado_vacuna;

CREATE TABLE IF NOT EXISTS public.t_empleado_vacuna
(
    cedula character(15) COLLATE pg_catalog."default" NOT NULL,
    tipo_vacuna character(4) COLLATE pg_catalog."default" NOT NULL,
    nro_dosis numeric,
    fecha_vacuna date,
    CONSTRAINT t_empleado_vacuna_pkey PRIMARY KEY (cedula, tipo_vacuna),
    CONSTRAINT fk_emp FOREIGN KEY (cedula)
        REFERENCES public.t_empleado (cedula) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_tipo_vacuna FOREIGN KEY (tipo_vacuna)
        REFERENCES public.t_tipo_vacuna (codigo) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public.t_empleado_vacuna
    OWNER to postgres;

COMMENT ON CONSTRAINT fk_tipo_vacuna ON public.t_empleado_vacuna
    IS 'tipo vacuna';