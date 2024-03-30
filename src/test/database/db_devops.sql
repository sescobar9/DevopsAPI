--
-- PostgreSQL database dump
--

-- Dumped from database version 13.4
-- Dumped by pg_dump version 13.4

-- Started on 2024-03-30 10:19:48

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 201 (class 1259 OID 33164)
-- Name: curso; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.curso (
    id_curso bigint NOT NULL,
    decripcion character varying(100),
    nombre_curso character varying(255)
);


ALTER TABLE public.curso OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 33162)
-- Name: curso_id_curso_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.curso_id_curso_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.curso_id_curso_seq OWNER TO postgres;

--
-- TOC entry 3013 (class 0 OID 0)
-- Dependencies: 200
-- Name: curso_id_curso_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.curso_id_curso_seq OWNED BY public.curso.id_curso;


--
-- TOC entry 203 (class 1259 OID 33172)
-- Name: profesor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.profesor (
    id_profesor bigint NOT NULL,
    email character varying(255),
    nombre_profesor character varying(255)
);


ALTER TABLE public.profesor OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 33181)
-- Name: profesor_curso; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.profesor_curso (
    id_profesor bigint NOT NULL,
    id_curso bigint NOT NULL
);


ALTER TABLE public.profesor_curso OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 33170)
-- Name: profesor_id_profesor_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.profesor_id_profesor_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.profesor_id_profesor_seq OWNER TO postgres;

--
-- TOC entry 3014 (class 0 OID 0)
-- Dependencies: 202
-- Name: profesor_id_profesor_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.profesor_id_profesor_seq OWNED BY public.profesor.id_profesor;


--
-- TOC entry 2861 (class 2604 OID 33167)
-- Name: curso id_curso; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.curso ALTER COLUMN id_curso SET DEFAULT nextval('public.curso_id_curso_seq'::regclass);


--
-- TOC entry 2862 (class 2604 OID 33175)
-- Name: profesor id_profesor; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profesor ALTER COLUMN id_profesor SET DEFAULT nextval('public.profesor_id_profesor_seq'::regclass);


--
-- TOC entry 3004 (class 0 OID 33164)
-- Dependencies: 201
-- Data for Name: curso; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.curso (id_curso, decripcion, nombre_curso) VALUES (3, 'aprenderemos derivadas', 'matematicas');
INSERT INTO public.curso (id_curso, decripcion, nombre_curso) VALUES (2, 'hacer pipeline', 'devops');


--
-- TOC entry 3006 (class 0 OID 33172)
-- Dependencies: 203
-- Data for Name: profesor; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.profesor (id_profesor, email, nombre_profesor) VALUES (2, 'sergio@udem.com', 'sergio');


--
-- TOC entry 3007 (class 0 OID 33181)
-- Dependencies: 204
-- Data for Name: profesor_curso; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.profesor_curso (id_profesor, id_curso) VALUES (2, 3);


--
-- TOC entry 3015 (class 0 OID 0)
-- Dependencies: 200
-- Name: curso_id_curso_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.curso_id_curso_seq', 3, true);


--
-- TOC entry 3016 (class 0 OID 0)
-- Dependencies: 202
-- Name: profesor_id_profesor_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.profesor_id_profesor_seq', 2, true);


--
-- TOC entry 2864 (class 2606 OID 33169)
-- Name: curso curso_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.curso
    ADD CONSTRAINT curso_pkey PRIMARY KEY (id_curso);


--
-- TOC entry 2870 (class 2606 OID 33185)
-- Name: profesor_curso profesor_curso_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profesor_curso
    ADD CONSTRAINT profesor_curso_pkey PRIMARY KEY (id_profesor, id_curso);


--
-- TOC entry 2866 (class 2606 OID 33180)
-- Name: profesor profesor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profesor
    ADD CONSTRAINT profesor_pkey PRIMARY KEY (id_profesor);


--
-- TOC entry 2868 (class 2606 OID 33187)
-- Name: profesor uk_n0cxx7qsaxhxjhib2aq054nip; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profesor
    ADD CONSTRAINT uk_n0cxx7qsaxhxjhib2aq054nip UNIQUE (email);


--
-- TOC entry 2872 (class 2606 OID 33193)
-- Name: profesor_curso fk3gv8va6swmlpb6gwqcm6km8fc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profesor_curso
    ADD CONSTRAINT fk3gv8va6swmlpb6gwqcm6km8fc FOREIGN KEY (id_profesor) REFERENCES public.profesor(id_profesor);


--
-- TOC entry 2871 (class 2606 OID 33188)
-- Name: profesor_curso fk3wdaa10qm4bys6llfg4d09tdn; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profesor_curso
    ADD CONSTRAINT fk3wdaa10qm4bys6llfg4d09tdn FOREIGN KEY (id_curso) REFERENCES public.curso(id_curso);


-- Completed on 2024-03-30 10:19:49

--
-- PostgreSQL database dump complete
--

