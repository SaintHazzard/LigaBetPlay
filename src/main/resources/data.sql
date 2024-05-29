--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2
-- Dumped by pg_dump version 16.2

-- Started on 2024-05-29 09:07:44

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
-- TOC entry 215 (class 1259 OID 34669)
-- Name: equipo; Type: TABLE; Schema: public; Owner: hazzard
--

CREATE TABLE public.equipo (
    id bigint NOT NULL,
    diferencia_goles integer NOT NULL,
    goles_contra integer NOT NULL,
    goles_favor integer NOT NULL,
    nombre character varying(255),
    partidos_empatados integer NOT NULL,
    partidos_ganados integer NOT NULL,
    partidos_jugados integer NOT NULL,
    partidos_perdidos integer NOT NULL,
    total_puntos integer NOT NULL
);


ALTER TABLE public.equipo OWNER TO hazzard;

--
-- TOC entry 217 (class 1259 OID 34681)
-- Name: equipo_seq; Type: SEQUENCE; Schema: public; Owner: hazzard
--

CREATE SEQUENCE public.equipo_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.equipo_seq OWNER TO hazzard;

--
-- TOC entry 216 (class 1259 OID 34674)
-- Name: partido; Type: TABLE; Schema: public; Owner: hazzard
--

CREATE TABLE public.partido (
    id bigint NOT NULL,
    goles_local integer NOT NULL,
    goles_visitante integer NOT NULL,
    jugado boolean NOT NULL,
    equipo_local_id bigint,
    equipo_visitante_id bigint,
    fecha_partido date
);


ALTER TABLE public.partido OWNER TO hazzard;

--
-- TOC entry 218 (class 1259 OID 34682)
-- Name: partido_seq; Type: SEQUENCE; Schema: public; Owner: hazzard
--

CREATE SEQUENCE public.partido_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.partido_seq OWNER TO hazzard;

--
-- TOC entry 4844 (class 0 OID 34669)
-- Dependencies: 215
-- Data for Name: equipo; Type: TABLE DATA; Schema: public; Owner: hazzard
--

COPY public.equipo (id, diferencia_goles, goles_contra, goles_favor, nombre, partidos_empatados, partidos_ganados, partidos_jugados, partidos_perdidos, total_puntos) FROM stdin;
56	-4	5	1	Medellin	0	0	1	1	0
55	-6	8	2	Suenio FE	0	0	3	3	0
51	0	1	1	Nacional	2	0	2	0	2
53	19	4	23	Llaneros	0	6	6	0	18
151	-1	3	2	Alianza petrolera	0	0	1	1	0
101	0	6	6	Tolima	0	1	2	1	3
201	3	0	3	PSG	0	1	1	0	3
152	-7	10	3	Liverpool	0	0	3	3	0
52	-10	12	2	Millonarios	1	0	4	3	1
102	-88	100	12	Real MaDrios	0	1	2	1	3
54	7	9	16	Bucaramanchester	1	4	5	0	13
251	93	9	102	Real madrid	0	1	2	1	3
\.


--
-- TOC entry 4845 (class 0 OID 34674)
-- Dependencies: 216
-- Data for Name: partido; Type: TABLE DATA; Schema: public; Owner: hazzard
--

COPY public.partido (id, goles_local, goles_visitante, jugado, equipo_local_id, equipo_visitante_id, fecha_partido) FROM stdin;
51	1	5	t	56	53	2024-05-04
52	1	1	t	52	51	2024-05-31
101	1	3	t	55	54	2024-05-31
151	2	1	t	101	55	2024-05-08
152	0	3	t	55	53	2024-05-31
153	0	0	t	54	51	2024-05-28
201	3	0	t	53	52	2024-05-13
202	5	0	t	53	52	2024-05-13
251	1	3	t	152	53	2024-05-09
252	2	4	t	152	53	2024-05-31
301	3	2	t	54	151	2024-05-30
351	5	4	t	54	101	2024-05-29
154	8	0	t	102	52	2024-05-27
401	3	0	t	201	152	2024-05-09
451	100	4	t	251	102	2024-05-21
452	5	2	t	54	251	2024-05-31
\.


--
-- TOC entry 4853 (class 0 OID 0)
-- Dependencies: 217
-- Name: equipo_seq; Type: SEQUENCE SET; Schema: public; Owner: hazzard
--

SELECT pg_catalog.setval('public.equipo_seq', 300, true);


--
-- TOC entry 4854 (class 0 OID 0)
-- Dependencies: 218
-- Name: partido_seq; Type: SEQUENCE SET; Schema: public; Owner: hazzard
--

SELECT pg_catalog.setval('public.partido_seq', 500, true);


--
-- TOC entry 4694 (class 2606 OID 34673)
-- Name: equipo equipo_pkey; Type: CONSTRAINT; Schema: public; Owner: hazzard
--

ALTER TABLE ONLY public.equipo
    ADD CONSTRAINT equipo_pkey PRIMARY KEY (id);


--
-- TOC entry 4698 (class 2606 OID 34678)
-- Name: partido partido_pkey; Type: CONSTRAINT; Schema: public; Owner: hazzard
--

ALTER TABLE ONLY public.partido
    ADD CONSTRAINT partido_pkey PRIMARY KEY (id);


--
-- TOC entry 4696 (class 2606 OID 34680)
-- Name: equipo ukl0ojfog3r4a4ppf9kju1y70j7; Type: CONSTRAINT; Schema: public; Owner: hazzard
--

ALTER TABLE ONLY public.equipo
    ADD CONSTRAINT ukl0ojfog3r4a4ppf9kju1y70j7 UNIQUE (nombre);


--
-- TOC entry 4699 (class 2606 OID 34683)
-- Name: partido fk7d0ff294y8ul2ego1km5r0tmq; Type: FK CONSTRAINT; Schema: public; Owner: hazzard
--

ALTER TABLE ONLY public.partido
    ADD CONSTRAINT fk7d0ff294y8ul2ego1km5r0tmq FOREIGN KEY (equipo_local_id) REFERENCES public.equipo(id);


--
-- TOC entry 4700 (class 2606 OID 34688)
-- Name: partido fkksi4gq2o9almp8a1gfnadjfu1; Type: FK CONSTRAINT; Schema: public; Owner: hazzard
--

ALTER TABLE ONLY public.partido
    ADD CONSTRAINT fkksi4gq2o9almp8a1gfnadjfu1 FOREIGN KEY (equipo_visitante_id) REFERENCES public.equipo(id);


-- Completed on 2024-05-29 09:07:44

--
-- PostgreSQL database dump complete
--

