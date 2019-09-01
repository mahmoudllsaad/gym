CREATE TABLE public.trainer
(
    trainer_id integer NOT NULL DEFAULT nextval('trainer_trainer_id_seq'::regclass),
    trainer_name character varying(20) COLLATE pg_catalog."default" NOT NULL,
    trianer_email character varying(36) COLLATE pg_catalog."default" NOT NULL,
    trainer_cost numeric NOT NULL,
    CONSTRAINT trainer_pk PRIMARY KEY (trainer_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.trainer
    OWNER to postgres;


--------------------------------------------------


CREATE TABLE public.trainee
(
    trainee_id integer NOT NULL DEFAULT nextval('trainee_trainee_id_seq'::regclass),
    trainee_name character varying(20) COLLATE pg_catalog."default" NOT NULL,
    trianee_email character varying(36) COLLATE pg_catalog."default" NOT NULL,
    trianer_fk bigint NOT NULL,
    CONSTRAINT trainee_pk PRIMARY KEY (trainee_id),
    CONSTRAINT trianee_fk FOREIGN KEY (trianer_fk)
        REFERENCES public.trainer (trainer_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.trainee
    OWNER to postgres;