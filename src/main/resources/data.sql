--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5
-- Dumped by pg_dump version 14.5

-- Started on 2024-10-30 15:29:56

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
-- TOC entry 218 (class 1259 OID 37098)
-- Name: hard_skill_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hard_skill_entity (
    hard_skill_id bigint NOT NULL,
    hard_skill_name character varying(255),
    hard_skill_value character varying(255)
);


ALTER TABLE public.hard_skill_entity OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 37097)
-- Name: hard_skill_entity_hard_skill_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hard_skill_entity_hard_skill_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hard_skill_entity_hard_skill_id_seq OWNER TO postgres;

--
-- TOC entry 3381 (class 0 OID 0)
-- Dependencies: 217
-- Name: hard_skill_entity_hard_skill_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.hard_skill_entity_hard_skill_id_seq OWNED BY public.hard_skill_entity.hard_skill_id;


--
-- TOC entry 210 (class 1259 OID 37015)
-- Name: project_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.project_entity (
    project_id bigint NOT NULL,
    project_created_at timestamp(6) without time zone,
    project_description text,
    project_finished_at timestamp(6) without time zone,
    project_hard_skills smallint[],
    project_representative character varying(255),
    project_representative_email character varying(255),
    project_soft_skills smallint[],
    project_status smallint,
    project_technologies smallint[],
    project_title character varying(255),
    project_types smallint[],
    project_updated_at timestamp(6) without time zone
);


ALTER TABLE public.project_entity OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 37106)
-- Name: project_entity_hard_skill_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.project_entity_hard_skill_entity (
    project_entity_project_id bigint NOT NULL,
    project_hard_skills_hard_skill_id bigint NOT NULL
);


ALTER TABLE public.project_entity_hard_skill_entity OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 37014)
-- Name: project_entity_project_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.project_entity_project_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.project_entity_project_id_seq OWNER TO postgres;

--
-- TOC entry 3382 (class 0 OID 0)
-- Dependencies: 209
-- Name: project_entity_project_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.project_entity_project_id_seq OWNED BY public.project_entity.project_id;


--
-- TOC entry 215 (class 1259 OID 37071)
-- Name: project_entity_project_type_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.project_entity_project_type_entity (
    project_entity_project_id bigint NOT NULL,
    project_types_project_type_id bigint NOT NULL
);


ALTER TABLE public.project_entity_project_type_entity OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 37119)
-- Name: project_entity_soft_skill_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.project_entity_soft_skill_entity (
    project_entity_project_id bigint NOT NULL,
    project_soft_skills_soft_skill_id bigint NOT NULL
);


ALTER TABLE public.project_entity_soft_skill_entity OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 37074)
-- Name: project_entity_technology_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.project_entity_technology_entity (
    project_entity_project_id bigint NOT NULL,
    project_technologies_technology_id bigint NOT NULL
);


ALTER TABLE public.project_entity_technology_entity OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 37051)
-- Name: project_type_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.project_type_entity (
    project_type_id bigint NOT NULL,
    project_type_name character varying(255),
    project_type_value character varying(255)
);


ALTER TABLE public.project_type_entity OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 37050)
-- Name: project_type_entity_project_type_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.project_type_entity_project_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.project_type_entity_project_type_id_seq OWNER TO postgres;

--
-- TOC entry 3383 (class 0 OID 0)
-- Dependencies: 213
-- Name: project_type_entity_project_type_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.project_type_entity_project_type_id_seq OWNED BY public.project_type_entity.project_type_id;


--
-- TOC entry 222 (class 1259 OID 37123)
-- Name: soft_skill_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.soft_skill_entity (
    soft_skill_id bigint NOT NULL,
    soft_skill_name character varying(255),
    soft_skill_value character varying(255)
);


ALTER TABLE public.soft_skill_entity OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 37122)
-- Name: soft_skill_entity_soft_skill_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.soft_skill_entity_soft_skill_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.soft_skill_entity_soft_skill_id_seq OWNER TO postgres;

--
-- TOC entry 3384 (class 0 OID 0)
-- Dependencies: 221
-- Name: soft_skill_entity_soft_skill_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.soft_skill_entity_soft_skill_id_seq OWNED BY public.soft_skill_entity.soft_skill_id;


--
-- TOC entry 212 (class 1259 OID 37024)
-- Name: technology_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.technology_entity (
    technology_id bigint NOT NULL,
    technology_name character varying(255),
    technology_value character varying(255)
);


ALTER TABLE public.technology_entity OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 37023)
-- Name: technology_entity_technology_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.technology_entity_technology_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.technology_entity_technology_id_seq OWNER TO postgres;

--
-- TOC entry 3385 (class 0 OID 0)
-- Dependencies: 211
-- Name: technology_entity_technology_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.technology_entity_technology_id_seq OWNED BY public.technology_entity.technology_id;


--
-- TOC entry 3203 (class 2604 OID 37101)
-- Name: hard_skill_entity hard_skill_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hard_skill_entity ALTER COLUMN hard_skill_id SET DEFAULT nextval('public.hard_skill_entity_hard_skill_id_seq'::regclass);


--
-- TOC entry 3200 (class 2604 OID 37018)
-- Name: project_entity project_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_entity ALTER COLUMN project_id SET DEFAULT nextval('public.project_entity_project_id_seq'::regclass);


--
-- TOC entry 3202 (class 2604 OID 37054)
-- Name: project_type_entity project_type_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_type_entity ALTER COLUMN project_type_id SET DEFAULT nextval('public.project_type_entity_project_type_id_seq'::regclass);


--
-- TOC entry 3204 (class 2604 OID 37126)
-- Name: soft_skill_entity soft_skill_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.soft_skill_entity ALTER COLUMN soft_skill_id SET DEFAULT nextval('public.soft_skill_entity_soft_skill_id_seq'::regclass);


--
-- TOC entry 3201 (class 2604 OID 37027)
-- Name: technology_entity technology_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.technology_entity ALTER COLUMN technology_id SET DEFAULT nextval('public.technology_entity_technology_id_seq'::regclass);


--
-- TOC entry 3371 (class 0 OID 37098)
-- Dependencies: 218
-- Data for Name: hard_skill_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hard_skill_entity (hard_skill_id, hard_skill_name, hard_skill_value) FROM stdin;
1	Architektur	SOFTWARE_ARCHITECTURE
2	Testen	TESTING
3	Version	VERSION_CONTROL
4	Doku	DOCUMENTATION
5	Datenbank	DATABASE_MANAGEMENT
6	Entwicklung	PROGRAMMING
7	Agilität	AGILE
8	Sicherheit	SECURITY
9	DevOps	DEVOPS
10	Andere	OTHER
\.


--
-- TOC entry 3363 (class 0 OID 37015)
-- Dependencies: 210
-- Data for Name: project_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.project_entity (project_id, project_created_at, project_description, project_finished_at, project_hard_skills, project_representative, project_representative_email, project_soft_skills, project_status, project_technologies, project_title, project_types, project_updated_at) FROM stdin;
2	2024-10-23 15:14:39.122	Marktpreise 2024222	\N	{0,8,4,5}	Matteo Kleemann222	matteoachim.kleemann@dataport.de2	{2,3}	0	{0,2,4,3}	Marktpreise 20242222	\N	2024-10-23 15:15:21.917
3	2024-10-23 15:34:34.622	DUMMY	\N	{0,8,4,5}	DUMMY	matteoachim.kleemann@dataport.de	{2,3}	2	{0,2,4,3}	DUMMY	{0}	\N
4	2024-10-23 15:34:36.035	DUMMY	\N	{0,8,4,5}	DUMMY	matteoachim.kleemann@dataport.de	{2,3}	2	{0,2,4,3}	DUMMY	{0}	\N
20	2024-10-25 02:33:44.192	wdfvertzhujikoil	\N	{0,4}	wdfvertzhujikoil	wdfvertzhujikoil	{3}	0	\N	wdfvertzhujikoil	{1}	\N
6	2024-10-23 15:44:49.797	Eine Projektbeschreibung ist die aussagekräftige Beschreibung eines Vorhabens. Ausgangspunkt dafür ist die Projektidee. Die Projektbeschreibung informiert potenzielle Auftraggeber, Drittmittelgeber und Entscheider über die Projektidee, Ausgangslage, Anforderungen, Beteiligte, Zielsetzungen, Finanzen und andere Rahmenbedingungen. Häufig wird eine ausführliche und eine Kurzbeschreibung nachgefragt.	\N	{5,8}	John Doe	johndoe@example.com	{2,4}	0	{0,3,2}	AI-based Project	{0,2,1}	2024-10-23 16:44:23.403
7	2024-10-23 17:34:12.266	Eine Projektbeschreibung ist die aussagekräftige Beschreibung eines Vorhabens. Ausgangspunkt dafür ist die Projektidee. Die Projektbeschreibung informiert potenzielle Auftraggeber, Drittmittelgeber und Entscheider über die Projektidee, Ausgangslage, Anforderungen, Beteiligte, Zielsetzungen, Finanzen und andere Rahmenbedingungen. Häufig wird eine ausführliche und eine Kurzbeschreibung nachgefragt.	\N	{5,8}	John Doe	johndoe@example.com	{2,4}	0	{0,3,2}	AI-based Project	{0,2,1}	\N
8	2024-10-23 17:34:13.064	Eine Projektbeschreibung ist die aussagekräftige Beschreibung eines Vorhabens. Ausgangspunkt dafür ist die Projektidee. Die Projektbeschreibung informiert potenzielle Auftraggeber, Drittmittelgeber und Entscheider über die Projektidee, Ausgangslage, Anforderungen, Beteiligte, Zielsetzungen, Finanzen und andere Rahmenbedingungen. Häufig wird eine ausführliche und eine Kurzbeschreibung nachgefragt.	\N	{5,8}	John Doe	johndoe@example.com	{2,4}	0	{0,3,2}	AI-based Project	{0,2,1}	\N
9	2024-10-23 17:34:13.701	Eine Projektbeschreibung ist die aussagekräftige Beschreibung eines Vorhabens. Ausgangspunkt dafür ist die Projektidee. Die Projektbeschreibung informiert potenzielle Auftraggeber, Drittmittelgeber und Entscheider über die Projektidee, Ausgangslage, Anforderungen, Beteiligte, Zielsetzungen, Finanzen und andere Rahmenbedingungen. Häufig wird eine ausführliche und eine Kurzbeschreibung nachgefragt.	\N	{5,8}	John Doe	johndoe@example.com	{2,4}	0	{0,3,2}	AI-based Project	{0,2,1}	\N
10	2024-10-23 17:34:14.279	Eine Projektbeschreibung ist die aussagekräftige Beschreibung eines Vorhabens. Ausgangspunkt dafür ist die Projektidee. Die Projektbeschreibung informiert potenzielle Auftraggeber, Drittmittelgeber und Entscheider über die Projektidee, Ausgangslage, Anforderungen, Beteiligte, Zielsetzungen, Finanzen und andere Rahmenbedingungen. Häufig wird eine ausführliche und eine Kurzbeschreibung nachgefragt.	\N	{5,8}	John Doe	johndoe@example.com	{2,4}	0	{0,3,2}	AI-based Project	{0,2,1}	\N
11	2024-10-24 03:12:26.03	DUMMY_CREATE2	\N	{4}	DUMMY_CREATE3	DUMMY_CREATE4	{2}	0	{0}	DUMMY_CREATE	{1}	\N
12	2024-10-24 03:12:57.406	DUMMY_CREATE333	\N	{8,5,4,1}	DUMMY_CREATE444	DUMMY_CREATE555	{2,1,0}	1	{0,4,2}	DUMMY_CREATE2	{0,2,1}	\N
13	2024-10-25 01:12:42.598	adadada	\N	{4,0}	dada	adada	{1}	0	{0,4}	dadad	{1}	\N
14	2024-10-25 01:13:49.232	dada	\N	{5,7}	dada	dada	{2}	0	{0,4}	dada	{1}	\N
15	2024-10-25 01:15:04.422	dadada	\N	{4}	dada	dada	{3}	0	{1}	dada	{2}	\N
16	2024-10-25 01:18:25.103	rtgzhuio	\N	{}	frtghzui	zufhjikl	{3}	0	{1}	retzu	{2}	\N
17	2024-10-25 01:19:25.222	fhzgjikol	\N	{3,6,7,4,5,8,2,0,1}	rgthz	zhujikl	{6,0,2,1,4,5,3}	0	{0,4,2,7,6,1,5,3}	sdfgfhzugjhikio	{2,3,1,0}	\N
18	2024-10-25 02:22:55.627	frtzhuikolp	\N	{0,4}	frtzhuikolp	frtzhuikolp	{2}	0	\N	frtzhuikolp	{1}	\N
25	2024-10-25 18:01:50.55	ManyToMany	\N	{2,8}	ManyToMany	ManyToMany	{0,6}	0	\N	ManyToMany	\N	\N
26	2024-10-25 18:40:25.951	HARD_SKILL_TEST	\N	\N	HARD_SKILL_TEST	HARD_SKILL_TEST	{}	0	\N	HARD_SKILL_TEST	\N	\N
27	2024-10-25 19:18:28.613	SOFT_SKILL_DUMMY	\N	\N	SOFT_SKILL_DUMMY	SOFT_SKILL_DUMMY	\N	1	\N	SOFT_SKILL_DUMMY	\N	\N
28	2024-10-26 00:16:14.394	SNACKBAR_DUMMy	\N	\N	SNACKBAR_DUMMy	SNACKBAR_DUMMy	\N	1	\N	SNACKBAR_DUMMy	\N	\N
29	2024-10-26 01:43:37.483	da	\N	\N	da	dada	\N	0	\N	dada	\N	\N
30	2024-10-26 01:44:38.292	dada	\N	\N	dadada	dada	\N	0	\N	rtgzhui	\N	\N
31	2024-10-28 15:17:07.29	dada	\N	\N	addad	adada	\N	0	\N	ada	\N	\N
\.


--
-- TOC entry 3372 (class 0 OID 37106)
-- Dependencies: 219
-- Data for Name: project_entity_hard_skill_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.project_entity_hard_skill_entity (project_entity_project_id, project_hard_skills_hard_skill_id) FROM stdin;
26	1
26	2
26	3
26	4
26	6
26	5
26	10
26	9
26	8
26	7
27	10
27	9
27	8
27	7
27	3
27	4
27	5
27	6
27	1
27	2
28	1
29	4
30	3
31	3
31	2
\.


--
-- TOC entry 3368 (class 0 OID 37071)
-- Dependencies: 215
-- Data for Name: project_entity_project_type_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.project_entity_project_type_entity (project_entity_project_id, project_types_project_type_id) FROM stdin;
25	1
25	2
26	2
26	1
26	3
26	4
27	2
27	1
27	3
27	4
28	1
28	2
29	3
30	2
31	2
31	1
\.


--
-- TOC entry 3373 (class 0 OID 37119)
-- Dependencies: 220
-- Data for Name: project_entity_soft_skill_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.project_entity_soft_skill_entity (project_entity_project_id, project_soft_skills_soft_skill_id) FROM stdin;
27	3
27	2
27	1
27	7
27	4
27	6
27	5
28	1
29	5
30	3
31	3
\.


--
-- TOC entry 3369 (class 0 OID 37074)
-- Dependencies: 216
-- Data for Name: project_entity_technology_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.project_entity_technology_entity (project_entity_project_id, project_technologies_technology_id) FROM stdin;
25	7
26	8
26	2
26	5
26	6
26	4
26	3
26	1
26	7
27	1
27	2
27	8
27	3
27	4
27	5
27	6
27	7
28	1
29	4
30	3
31	2
\.


--
-- TOC entry 3367 (class 0 OID 37051)
-- Dependencies: 214
-- Data for Name: project_type_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.project_type_entity (project_type_id, project_type_name, project_type_value) FROM stdin;
1	Projekt	PROJECT
2	Praxisstation	PRACTICE
3	Thesis	THESIS
4	Andere	OTHER
\.


--
-- TOC entry 3375 (class 0 OID 37123)
-- Dependencies: 222
-- Data for Name: soft_skill_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.soft_skill_entity (soft_skill_id, soft_skill_name, soft_skill_value) FROM stdin;
1	Anforderung	REQUIREMENTS_ENGINEERING
2	Planung	PROJECT_MANAGEMENT
3	Kunden	CLIENT_INTERACTION
4	Lösung	PROBLEM_SOLVING
5	Team	TEAMWORK
6	Zeit	TIME_MANAGEMENT
7	Andere	OTHER
\.


--
-- TOC entry 3365 (class 0 OID 37024)
-- Dependencies: 212
-- Data for Name: technology_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.technology_entity (technology_id, technology_name, technology_value) FROM stdin;
1	Vue.js	VUE_JS
2	Java	JAVA
3	JavaScript	JAVASCRIPT
4	Spring Boot	SPRING_BOOT
5	Vuetify	VUETIFY
6	Node.js	NODE_JS
7	Docker	DOCKER
8	Andere	OTHER
\.


--
-- TOC entry 3386 (class 0 OID 0)
-- Dependencies: 217
-- Name: hard_skill_entity_hard_skill_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hard_skill_entity_hard_skill_id_seq', 10, true);


--
-- TOC entry 3387 (class 0 OID 0)
-- Dependencies: 209
-- Name: project_entity_project_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.project_entity_project_id_seq', 31, true);


--
-- TOC entry 3388 (class 0 OID 0)
-- Dependencies: 213
-- Name: project_type_entity_project_type_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.project_type_entity_project_type_id_seq', 4, true);


--
-- TOC entry 3389 (class 0 OID 0)
-- Dependencies: 221
-- Name: soft_skill_entity_soft_skill_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.soft_skill_entity_soft_skill_id_seq', 7, true);


--
-- TOC entry 3390 (class 0 OID 0)
-- Dependencies: 211
-- Name: technology_entity_technology_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.technology_entity_technology_id_seq', 8, true);


--
-- TOC entry 3212 (class 2606 OID 37105)
-- Name: hard_skill_entity hard_skill_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hard_skill_entity
    ADD CONSTRAINT hard_skill_entity_pkey PRIMARY KEY (hard_skill_id);


--
-- TOC entry 3206 (class 2606 OID 37022)
-- Name: project_entity project_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_entity
    ADD CONSTRAINT project_entity_pkey PRIMARY KEY (project_id);


--
-- TOC entry 3210 (class 2606 OID 37058)
-- Name: project_type_entity project_type_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_type_entity
    ADD CONSTRAINT project_type_entity_pkey PRIMARY KEY (project_type_id);


--
-- TOC entry 3214 (class 2606 OID 37130)
-- Name: soft_skill_entity soft_skill_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.soft_skill_entity
    ADD CONSTRAINT soft_skill_entity_pkey PRIMARY KEY (soft_skill_id);


--
-- TOC entry 3208 (class 2606 OID 37031)
-- Name: technology_entity technology_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.technology_entity
    ADD CONSTRAINT technology_entity_pkey PRIMARY KEY (technology_id);


--
-- TOC entry 3215 (class 2606 OID 37077)
-- Name: project_entity_project_type_entity fka3oj2yu2ajumh1jdkvfdcj7jr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_entity_project_type_entity
    ADD CONSTRAINT fka3oj2yu2ajumh1jdkvfdcj7jr FOREIGN KEY (project_types_project_type_id) REFERENCES public.project_type_entity(project_type_id);


--
-- TOC entry 3216 (class 2606 OID 37082)
-- Name: project_entity_project_type_entity fkiem6wsf1j060j4h5prmp3nf2w; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_entity_project_type_entity
    ADD CONSTRAINT fkiem6wsf1j060j4h5prmp3nf2w FOREIGN KEY (project_entity_project_id) REFERENCES public.project_entity(project_id);


--
-- TOC entry 3222 (class 2606 OID 37136)
-- Name: project_entity_soft_skill_entity fklh8id10j1he44atnnu1p1i1il; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_entity_soft_skill_entity
    ADD CONSTRAINT fklh8id10j1he44atnnu1p1i1il FOREIGN KEY (project_entity_project_id) REFERENCES public.project_entity(project_id);


--
-- TOC entry 3221 (class 2606 OID 37131)
-- Name: project_entity_soft_skill_entity fklm6hi4rjd3yjie17mqhy8p7lp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_entity_soft_skill_entity
    ADD CONSTRAINT fklm6hi4rjd3yjie17mqhy8p7lp FOREIGN KEY (project_soft_skills_soft_skill_id) REFERENCES public.soft_skill_entity(soft_skill_id);


--
-- TOC entry 3220 (class 2606 OID 37114)
-- Name: project_entity_hard_skill_entity fkottalr2oabpbq87magxo3xbds; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_entity_hard_skill_entity
    ADD CONSTRAINT fkottalr2oabpbq87magxo3xbds FOREIGN KEY (project_entity_project_id) REFERENCES public.project_entity(project_id);


--
-- TOC entry 3219 (class 2606 OID 37109)
-- Name: project_entity_hard_skill_entity fkpr2juyc156qaxhl3bsitlrcw3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_entity_hard_skill_entity
    ADD CONSTRAINT fkpr2juyc156qaxhl3bsitlrcw3 FOREIGN KEY (project_hard_skills_hard_skill_id) REFERENCES public.hard_skill_entity(hard_skill_id);


--
-- TOC entry 3218 (class 2606 OID 37092)
-- Name: project_entity_technology_entity fksvdj4plxrrqj3hboo5hq1bc0t; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_entity_technology_entity
    ADD CONSTRAINT fksvdj4plxrrqj3hboo5hq1bc0t FOREIGN KEY (project_entity_project_id) REFERENCES public.project_entity(project_id);


--
-- TOC entry 3217 (class 2606 OID 37087)
-- Name: project_entity_technology_entity fktkequo4te01p2geh73jcwdp30; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_entity_technology_entity
    ADD CONSTRAINT fktkequo4te01p2geh73jcwdp30 FOREIGN KEY (project_technologies_technology_id) REFERENCES public.technology_entity(technology_id);


-- Completed on 2024-10-30 15:29:57

--
-- PostgreSQL database dump complete
--

