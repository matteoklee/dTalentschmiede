--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5
-- Dumped by pg_dump version 14.5

-- Started on 2024-11-05 02:58:18

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
-- TOC entry 214 (class 1259 OID 37098)
-- Name: hard_skill_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hard_skill_entity (
    hard_skill_id bigint NOT NULL,
    hard_skill_name character varying(255),
    hard_skill_value character varying(255)
);


ALTER TABLE public.hard_skill_entity OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 37097)
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
-- Dependencies: 213
-- Name: hard_skill_entity_hard_skill_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.hard_skill_entity_hard_skill_id_seq OWNED BY public.hard_skill_entity.hard_skill_id;


--
-- TOC entry 218 (class 1259 OID 37142)
-- Name: project_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.project_entity (
    project_id bigint NOT NULL,
    project_created_at timestamp(6) without time zone,
    project_description text,
    project_finished_at timestamp(6) without time zone,
    project_representative character varying(255),
    project_representative_email character varying(255),
    project_status smallint,
    project_title character varying(255),
    project_updated_at timestamp(6) without time zone
);


ALTER TABLE public.project_entity OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 37150)
-- Name: project_entity_hard_skill_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.project_entity_hard_skill_entity (
    project_entity_project_id bigint NOT NULL,
    project_hard_skills_hard_skill_id bigint NOT NULL
);


ALTER TABLE public.project_entity_hard_skill_entity OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 37141)
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
-- Dependencies: 217
-- Name: project_entity_project_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.project_entity_project_id_seq OWNED BY public.project_entity.project_id;


--
-- TOC entry 220 (class 1259 OID 37153)
-- Name: project_entity_project_type_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.project_entity_project_type_entity (
    project_entity_project_id bigint NOT NULL,
    project_types_project_type_id bigint NOT NULL
);


ALTER TABLE public.project_entity_project_type_entity OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 37156)
-- Name: project_entity_soft_skill_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.project_entity_soft_skill_entity (
    project_entity_project_id bigint NOT NULL,
    project_soft_skills_soft_skill_id bigint NOT NULL
);


ALTER TABLE public.project_entity_soft_skill_entity OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 37159)
-- Name: project_entity_technology_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.project_entity_technology_entity (
    project_entity_project_id bigint NOT NULL,
    project_technologies_technology_id bigint NOT NULL
);


ALTER TABLE public.project_entity_technology_entity OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 37051)
-- Name: project_type_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.project_type_entity (
    project_type_id bigint NOT NULL,
    project_type_name character varying(255),
    project_type_value character varying(255)
);


ALTER TABLE public.project_type_entity OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 37050)
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
-- Dependencies: 211
-- Name: project_type_entity_project_type_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.project_type_entity_project_type_id_seq OWNED BY public.project_type_entity.project_type_id;


--
-- TOC entry 216 (class 1259 OID 37123)
-- Name: soft_skill_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.soft_skill_entity (
    soft_skill_id bigint NOT NULL,
    soft_skill_name character varying(255),
    soft_skill_value character varying(255)
);


ALTER TABLE public.soft_skill_entity OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 37122)
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
-- Dependencies: 215
-- Name: soft_skill_entity_soft_skill_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.soft_skill_entity_soft_skill_id_seq OWNED BY public.soft_skill_entity.soft_skill_id;


--
-- TOC entry 210 (class 1259 OID 37024)
-- Name: technology_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.technology_entity (
    technology_id bigint NOT NULL,
    technology_name character varying(255),
    technology_value character varying(255)
);


ALTER TABLE public.technology_entity OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 37023)
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
-- Dependencies: 209
-- Name: technology_entity_technology_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.technology_entity_technology_id_seq OWNED BY public.technology_entity.technology_id;


--
-- TOC entry 3202 (class 2604 OID 37101)
-- Name: hard_skill_entity hard_skill_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hard_skill_entity ALTER COLUMN hard_skill_id SET DEFAULT nextval('public.hard_skill_entity_hard_skill_id_seq'::regclass);


--
-- TOC entry 3204 (class 2604 OID 37145)
-- Name: project_entity project_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_entity ALTER COLUMN project_id SET DEFAULT nextval('public.project_entity_project_id_seq'::regclass);


--
-- TOC entry 3201 (class 2604 OID 37054)
-- Name: project_type_entity project_type_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_type_entity ALTER COLUMN project_type_id SET DEFAULT nextval('public.project_type_entity_project_type_id_seq'::regclass);


--
-- TOC entry 3203 (class 2604 OID 37126)
-- Name: soft_skill_entity soft_skill_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.soft_skill_entity ALTER COLUMN soft_skill_id SET DEFAULT nextval('public.soft_skill_entity_soft_skill_id_seq'::regclass);


--
-- TOC entry 3200 (class 2604 OID 37027)
-- Name: technology_entity technology_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.technology_entity ALTER COLUMN technology_id SET DEFAULT nextval('public.technology_entity_technology_id_seq'::regclass);


--
-- TOC entry 3367 (class 0 OID 37098)
-- Dependencies: 214
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
-- TOC entry 3371 (class 0 OID 37142)
-- Dependencies: 218
-- Data for Name: project_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.project_entity (project_id, project_created_at, project_description, project_finished_at, project_representative, project_representative_email, project_status, project_title, project_updated_at) FROM stdin;
1	2024-11-05 02:11:13.48	Entwicklung eines internen Portals für die Mitarbeiterkommunikation. Das Projekt umfasst ein Dashboard für Ankündigungen, ein Forum für Diskussionen und die Integration eines Kalenders zur Terminplanung. Der aktuelle Stand: Design abgeschlossen, Implementierung des Dashboards läuft.	\N	Alex Schmidt	alex.schmidt@dataport.de	0	Intranet-Portal für Mitarbeiterkommunikation	\N
3	2024-11-05 02:13:30.672	Eine native Mobile App, die es Mitarbeitern ermöglicht, ihre Arbeitszeiten einfach zu erfassen. Aktuell in der Testphase, werden Benutzerfeedback und Optimierungen gesammelt.	\N	Mara Weber	mara.weber@dataport.de	1	Mobile App zur Zeiterfassung	\N
4	2024-11-05 02:14:55.877	Erforschung und Entwicklung von Machine-Learning-Algorithmen, die Marketingdaten analysieren und Kundenverhalten vorhersagen können. Derzeit sind Prototypen implementiert, und die Evaluierung läuft.	\N	Jonas Müller	jonas.mueller@dataport.de	2	Machine-Learning-Analyse für Marketing-Daten	2024-11-05 02:15:04.481
5	2024-11-05 02:16:21.105	Entwicklung eines Self-Service-Portals für Kunden, um Service-Tickets einzureichen und den Bearbeitungsstatus zu verfolgen. Derzeit im Entwicklungsstadium, die erste Version des Portals ist als MVP bereit.	\N	Kathrin Fischer	kathrin.fischer@dataport.de	0	Kundenportal zur Verwaltung von Service-Tickets	\N
7	2024-11-05 02:21:05.746	Entwicklung eines Systems zur Überwachung und Analyse des Energieverbrauchs in Bürogebäuden. Ziel ist es, mit Sensoren und Software den Energieverbrauch in Echtzeit zu verfolgen und Einsparpotenziale zu identifizieren. Der Prototyp des Dashboards ist fertiggestellt, und die nächste Phase umfasst die Integration der Sensoren und die Implementierung von Analyse-Tools.	\N	Clara Schmidt	clara.schmidt@dataport.de	1	Energieeffizientes Gebäudemanagement	\N
8	2024-11-05 02:21:48.75	Ein KI-basierter Chatbot, der Kundenanfragen rund um die Uhr beantwortet und häufig gestellte Fragen bearbeitet. Der Chatbot ist darauf ausgelegt, häufige Anfragen zu Produkten und Dienstleistungen zu verstehen und einfache Fragen ohne menschliche Hilfe zu lösen. Derzeit befindet sich das Projekt in der Testphase, in der das Modell auf Basis realer Kundenanfragen optimiert wird.	\N	Tim Bauer	tim.bauer@dataport.de	0	Chatbot zur Kundenunterstützung	\N
10	2024-11-05 02:23:20.985	Dieses Projekt zielt darauf ab, ein virtuelles Lernsystem zu entwickeln, das neue Mitarbeiter in den ersten Wochen begleitet. Das System bietet E-Learning-Kurse, interaktive Inhalte und Aufgaben zur Einführung in Unternehmensprozesse. Der aktuelle Stand ist die erste Testphase mit einer Beta-Gruppe neuer Mitarbeiter.	\N	Laura Braun	laura.braun@dataport.de	0	Virtuelles Lernsystem für Einarbeitung neuer Mitarbeiter	\N
6	2024-11-05 02:20:15.014	Dieses Projekt zielt darauf ab, ein intelligentes System zur Bestandsverwaltung zu entwickeln, das Echtzeit-Updates über Lagerbestände liefert und automatische Benachrichtigungen für Nachbestellungen sendet. Das System wird mit IoT-Sensoren verbunden, um die genaue Position und Menge der Produkte zu erfassen. Aktuell ist das Design der Systemarchitektur abgeschlossen, und die Implementierung der Sensorintegration läuft.	\N	Lukas Meier	lukas.meier@dataport.de	2	Intelligente Bestandsverwaltung für Lagerhäuser	2024-11-05 02:25:22.603
2	2024-11-05 02:12:33.709	Ziel ist es, ein automatisiertes Reporting-Tool zu entwickeln, das auf Knopfdruck aktuelle Kundendaten auswertet und visualisiert. Momentan wurde die Datenbankstruktur entworfen, und die Backend-Schnittstellen sind in Entwicklung.	\N	Lena Bergmann	lena.bergmann@dataport.de	2	Automatisiertes Reporting für Kundendaten	2024-11-05 02:25:29.363
9	2024-11-05 02:22:33.292	Entwicklung einer Plattform zur Verfolgung der Lieferkette, die Unternehmen ermöglicht, Informationen über Herkunft und Nachhaltigkeit von Materialien zu teilen. Geplant ist, verschiedene Lieferanteninformationen zu visualisieren und ein Bewertungssystem für nachhaltige Praktiken zu integrieren. Das Backend steht bereits, und das Frontend wird aktuell entworfen.	2024-11-05 02:25:59.18	Nina Krüger	nina.krueger@dataport.de	3	Plattform zur Lieferketten-Transparenz	2024-11-05 02:25:59.18
\.


--
-- TOC entry 3372 (class 0 OID 37150)
-- Dependencies: 219
-- Data for Name: project_entity_hard_skill_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.project_entity_hard_skill_entity (project_entity_project_id, project_hard_skills_hard_skill_id) FROM stdin;
1	5
3	6
4	6
5	5
7	7
10	4
6	1
2	1
9	5
\.


--
-- TOC entry 3373 (class 0 OID 37153)
-- Dependencies: 220
-- Data for Name: project_entity_project_type_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.project_entity_project_type_entity (project_entity_project_id, project_types_project_type_id) FROM stdin;
1	1
3	2
4	3
5	1
7	3
8	1
10	4
6	1
2	1
9	1
\.


--
-- TOC entry 3374 (class 0 OID 37156)
-- Dependencies: 221
-- Data for Name: project_entity_soft_skill_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.project_entity_soft_skill_entity (project_entity_project_id, project_soft_skills_soft_skill_id) FROM stdin;
1	2
3	5
4	4
5	3
7	4
8	3
10	1
6	6
2	4
9	5
\.


--
-- TOC entry 3375 (class 0 OID 37159)
-- Dependencies: 222
-- Data for Name: project_entity_technology_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.project_entity_technology_entity (project_entity_project_id, project_technologies_technology_id) FROM stdin;
1	2
1	4
3	3
3	6
4	2
4	8
5	4
5	3
7	4
7	1
8	8
10	1
10	3
6	2
6	6
6	7
2	2
2	7
9	5
9	7
\.


--
-- TOC entry 3365 (class 0 OID 37051)
-- Dependencies: 212
-- Data for Name: project_type_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.project_type_entity (project_type_id, project_type_name, project_type_value) FROM stdin;
1	Projekt	PROJECT
2	Praxisstation	PRACTICE
3	Thesis	THESIS
4	Andere	OTHER
\.


--
-- TOC entry 3369 (class 0 OID 37123)
-- Dependencies: 216
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
-- TOC entry 3363 (class 0 OID 37024)
-- Dependencies: 210
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
-- Dependencies: 213
-- Name: hard_skill_entity_hard_skill_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hard_skill_entity_hard_skill_id_seq', 10, true);


--
-- TOC entry 3387 (class 0 OID 0)
-- Dependencies: 217
-- Name: project_entity_project_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.project_entity_project_id_seq', 10, true);


--
-- TOC entry 3388 (class 0 OID 0)
-- Dependencies: 211
-- Name: project_type_entity_project_type_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.project_type_entity_project_type_id_seq', 4, true);


--
-- TOC entry 3389 (class 0 OID 0)
-- Dependencies: 215
-- Name: soft_skill_entity_soft_skill_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.soft_skill_entity_soft_skill_id_seq', 7, true);


--
-- TOC entry 3390 (class 0 OID 0)
-- Dependencies: 209
-- Name: technology_entity_technology_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.technology_entity_technology_id_seq', 8, true);


--
-- TOC entry 3210 (class 2606 OID 37105)
-- Name: hard_skill_entity hard_skill_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hard_skill_entity
    ADD CONSTRAINT hard_skill_entity_pkey PRIMARY KEY (hard_skill_id);


--
-- TOC entry 3214 (class 2606 OID 37149)
-- Name: project_entity project_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_entity
    ADD CONSTRAINT project_entity_pkey PRIMARY KEY (project_id);


--
-- TOC entry 3208 (class 2606 OID 37058)
-- Name: project_type_entity project_type_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_type_entity
    ADD CONSTRAINT project_type_entity_pkey PRIMARY KEY (project_type_id);


--
-- TOC entry 3212 (class 2606 OID 37130)
-- Name: soft_skill_entity soft_skill_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.soft_skill_entity
    ADD CONSTRAINT soft_skill_entity_pkey PRIMARY KEY (soft_skill_id);


--
-- TOC entry 3206 (class 2606 OID 37031)
-- Name: technology_entity technology_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.technology_entity
    ADD CONSTRAINT technology_entity_pkey PRIMARY KEY (technology_id);


--
-- TOC entry 3217 (class 2606 OID 37172)
-- Name: project_entity_project_type_entity fka3oj2yu2ajumh1jdkvfdcj7jr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_entity_project_type_entity
    ADD CONSTRAINT fka3oj2yu2ajumh1jdkvfdcj7jr FOREIGN KEY (project_types_project_type_id) REFERENCES public.project_type_entity(project_type_id);


--
-- TOC entry 3218 (class 2606 OID 37177)
-- Name: project_entity_project_type_entity fkiem6wsf1j060j4h5prmp3nf2w; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_entity_project_type_entity
    ADD CONSTRAINT fkiem6wsf1j060j4h5prmp3nf2w FOREIGN KEY (project_entity_project_id) REFERENCES public.project_entity(project_id);


--
-- TOC entry 3220 (class 2606 OID 37187)
-- Name: project_entity_soft_skill_entity fklh8id10j1he44atnnu1p1i1il; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_entity_soft_skill_entity
    ADD CONSTRAINT fklh8id10j1he44atnnu1p1i1il FOREIGN KEY (project_entity_project_id) REFERENCES public.project_entity(project_id);


--
-- TOC entry 3219 (class 2606 OID 37182)
-- Name: project_entity_soft_skill_entity fklm6hi4rjd3yjie17mqhy8p7lp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_entity_soft_skill_entity
    ADD CONSTRAINT fklm6hi4rjd3yjie17mqhy8p7lp FOREIGN KEY (project_soft_skills_soft_skill_id) REFERENCES public.soft_skill_entity(soft_skill_id);


--
-- TOC entry 3216 (class 2606 OID 37167)
-- Name: project_entity_hard_skill_entity fkottalr2oabpbq87magxo3xbds; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_entity_hard_skill_entity
    ADD CONSTRAINT fkottalr2oabpbq87magxo3xbds FOREIGN KEY (project_entity_project_id) REFERENCES public.project_entity(project_id);


--
-- TOC entry 3215 (class 2606 OID 37162)
-- Name: project_entity_hard_skill_entity fkpr2juyc156qaxhl3bsitlrcw3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_entity_hard_skill_entity
    ADD CONSTRAINT fkpr2juyc156qaxhl3bsitlrcw3 FOREIGN KEY (project_hard_skills_hard_skill_id) REFERENCES public.hard_skill_entity(hard_skill_id);


--
-- TOC entry 3222 (class 2606 OID 37197)
-- Name: project_entity_technology_entity fksvdj4plxrrqj3hboo5hq1bc0t; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_entity_technology_entity
    ADD CONSTRAINT fksvdj4plxrrqj3hboo5hq1bc0t FOREIGN KEY (project_entity_project_id) REFERENCES public.project_entity(project_id);


--
-- TOC entry 3221 (class 2606 OID 37192)
-- Name: project_entity_technology_entity fktkequo4te01p2geh73jcwdp30; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_entity_technology_entity
    ADD CONSTRAINT fktkequo4te01p2geh73jcwdp30 FOREIGN KEY (project_technologies_technology_id) REFERENCES public.technology_entity(technology_id);


-- Completed on 2024-11-05 02:58:18

--
-- PostgreSQL database dump complete
--

