CREATE TABLE address
(
    id uuid NOT NULL DEFAULT md5(random()::text || clock_timestamp()::text)::uuid,
    secret character varying(255) COLLATE pg_catalog."default" NOT NULL,
    zip_code character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT address_pk PRIMARY KEY (id)
);

CREATE TABLE person
(
    id uuid NOT NULL DEFAULT md5(random()::text || clock_timestamp()::text)::uuid,    
    id_address uuid NOT NULL,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT person_pk PRIMARY KEY (id),
    CONSTRAINT person_address_fk FOREIGN KEY (id_address)
    REFERENCES public.address (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
);

CREATE TABLE author
(
    id uuid NOT NULL DEFAULT md5(random()::text || clock_timestamp()::text)::uuid,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT author_pk PRIMARY KEY (id)
);

CREATE TABLE book
(
    id uuid NOT NULL DEFAULT md5(random()::text || clock_timestamp()::text)::uuid,
    title character varying(255) COLLATE pg_catalog."default" NOT NULL,
    id_author uuid NOT NULL,
    date_of_parution timestamp without time zone NOT NULL,
    CONSTRAINT book_pk PRIMARY KEY (id),
    CONSTRAINT book_author_fk FOREIGN KEY (id_author)
    REFERENCES public.author (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
);