--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.2

-- Started on 2017-04-05 13:58:39

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

--
-- TOC entry 2119 (class 0 OID 16391)
-- Dependencies: 185
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO product (id, stock, prix, nom_product, type_product, descrption) VALUES (1, 15, 3, 'Steak', 'Viande', 'Du bon steak');
INSERT INTO product (id, stock, prix, nom_product, type_product, descrption) VALUES (2, 15, 3, 'Licorne', 'Animal', 'Un licorne rose. Pas manger c''est trop jolie pour.');
INSERT INTO product (id, stock, prix, nom_product, type_product, descrption) VALUES (3, 8, 15.99, 'Entrecote', 'Viande', 'Une entrecote de luxe.');


SET default_tablespace = '';

--
-- TOC entry 2001 (class 2606 OID 16398)
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


-- Completed on 2017-04-05 13:58:39

--
-- PostgreSQL database dump complete
--

