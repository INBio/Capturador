--
-- PostgreSQL database dump
--

-- Started on 2008-05-30 15:17:21

SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- TOC entry 6 (class 2615 OID 97715)
-- Name: ara; Type: SCHEMA; Schema: -; Owner: ara
--

CREATE SCHEMA ara;


ALTER SCHEMA ara OWNER TO ara;

--
-- TOC entry 2477 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA ara; Type: COMMENT; Schema: -; Owner: ara
--

COMMENT ON SCHEMA ara IS 'Standard ara schema';


SET search_path = ara, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 1549 (class 1259 OID 97716)
-- Dependencies: 6
-- Name: altitude_floor; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE altitude_floor (
    altitude_floor_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.altitude_floor OWNER TO ara;

--
-- TOC entry 1550 (class 1259 OID 97721)
-- Dependencies: 6
-- Name: annotation; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE annotation (
    annotation_id numeric NOT NULL,
    contents character varying(4000),
    annotation_date date NOT NULL,
    annotator_person_id numeric NOT NULL,
    annotator_profile_id numeric NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.annotation OWNER TO ara;

--
-- TOC entry 1551 (class 1259 OID 97726)
-- Dependencies: 6
-- Name: audience; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE audience (
    audience_id numeric NOT NULL,
    name character varying(80) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.audience OWNER TO ara;

--
-- TOC entry 1552 (class 1259 OID 97731)
-- Dependencies: 6
-- Name: base_projection; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE base_projection (
    base_projection_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.base_projection OWNER TO ara;

--
-- TOC entry 1553 (class 1259 OID 97736)
-- Dependencies: 6
-- Name: biotic_unit; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE biotic_unit (
    biotic_unit_id numeric NOT NULL,
    value character varying(80) NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(20) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(20) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.biotic_unit OWNER TO ara;

--
-- TOC entry 1554 (class 1259 OID 97741)
-- Dependencies: 6
-- Name: canton; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE canton (
    canton_id numeric NOT NULL,
    province_id numeric NOT NULL,
    value character varying(80) NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(20) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(20) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.canton OWNER TO ara;

--
-- TOC entry 1555 (class 1259 OID 97746)
-- Dependencies: 6
-- Name: canton_ifam; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE canton_ifam (
    canton_ifam_id numeric NOT NULL,
    province_id numeric NOT NULL,
    value character varying(80) NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(20) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(20) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.canton_ifam OWNER TO ara;

--
-- TOC entry 1556 (class 1259 OID 97751)
-- Dependencies: 6
-- Name: collecting_area; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE collecting_area (
    collecting_area_id numeric NOT NULL,
    value character varying(80) NOT NULL,
    natural_region_id numeric NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(20) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(20) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.collecting_area OWNER TO ara;

--
-- TOC entry 1557 (class 1259 OID 97756)
-- Dependencies: 6
-- Name: collection; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE collection (
    collection_id numeric NOT NULL,
    name character varying(80) NOT NULL,
    description character varying(500),
    creation_date date,
    created_by character varying(100),
    last_modification_date date,
    last_modification_by character varying(100),
    obj_version numeric NOT NULL
);


ALTER TABLE ara.collection OWNER TO ara;

--
-- TOC entry 1558 (class 1259 OID 97761)
-- Dependencies: 6
-- Name: collection_protocol; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE collection_protocol (
    collection_id numeric NOT NULL,
    protocol_attribute_id numeric NOT NULL,
    value character varying(500) NOT NULL,
    obj_version numeric,
    created_by character varying(20),
    creation_date date,
    last_modification_by character varying(20),
    last_modification_date date
);


ALTER TABLE ara.collection_protocol OWNER TO ara;

--
-- TOC entry 1559 (class 1259 OID 97766)
-- Dependencies: 6
-- Name: collector_observer; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE collector_observer (
    gathering_observation_id numeric NOT NULL,
    collector_person_id numeric NOT NULL,
    "sequence" numeric NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.collector_observer OWNER TO ara;

--
-- TOC entry 1560 (class 1259 OID 97771)
-- Dependencies: 6
-- Name: component; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE component (
    component_id numeric NOT NULL,
    specimen_id numeric NOT NULL,
    component_sequence numeric NOT NULL,
    component_part_id numeric NOT NULL,
    preparation_method_id numeric NOT NULL,
    component_date date NOT NULL,
    component_type character varying(1) NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.component OWNER TO ara;

--
-- TOC entry 1561 (class 1259 OID 97776)
-- Dependencies: 6
-- Name: component_part; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE component_part (
    component_part_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.component_part OWNER TO ara;

--
-- TOC entry 1562 (class 1259 OID 97781)
-- Dependencies: 6
-- Name: concept; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE concept (
    concept_id numeric NOT NULL,
    created_by character varying(80),
    creation_date date,
    last_modification_by character varying(80),
    last_modification_date date,
    obj_version numeric NOT NULL,
    name character varying(1000),
    description character varying(1000)
);


ALTER TABLE ara.concept OWNER TO ara;

--
-- TOC entry 1563 (class 1259 OID 97786)
-- Dependencies: 6
-- Name: conservation_area; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE conservation_area (
    conservation_area_id numeric NOT NULL,
    value character varying(80) NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(20) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(20) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.conservation_area OWNER TO ara;

--
-- TOC entry 1564 (class 1259 OID 97791)
-- Dependencies: 6
-- Name: country; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE country (
    country_id numeric NOT NULL,
    value character varying(80) NOT NULL,
    creation_date date,
    created_by character varying(100),
    last_modification_date date,
    last_modification_by character varying(100),
    obj_version numeric NOT NULL
);


ALTER TABLE ara.country OWNER TO ara;

--
-- TOC entry 1565 (class 1259 OID 97796)
-- Dependencies: 6
-- Name: culture; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE culture (
    specimen_id numeric NOT NULL,
    replica_number numeric NOT NULL,
    culture_date date NOT NULL,
    description character varying(1000),
    responsible_person_id numeric NOT NULL,
    responsible_profile_id numeric NOT NULL,
    culture_storage_medium_id numeric NOT NULL,
    culture_medium_id numeric NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.culture OWNER TO ara;

--
-- TOC entry 1566 (class 1259 OID 97801)
-- Dependencies: 6
-- Name: culture_medium; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE culture_medium (
    culture_medium_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.culture_medium OWNER TO ara;

--
-- TOC entry 1567 (class 1259 OID 97806)
-- Dependencies: 6
-- Name: culture_storage_medium; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE culture_storage_medium (
    culture_storage_medium_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.culture_storage_medium OWNER TO ara;

--
-- TOC entry 1568 (class 1259 OID 97811)
-- Dependencies: 6
-- Name: determination_type; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE determination_type (
    determination_type_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.determination_type OWNER TO ara;

--
-- TOC entry 1569 (class 1259 OID 97816)
-- Dependencies: 6
-- Name: district; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE district (
    district_id numeric NOT NULL,
    canton_id numeric NOT NULL,
    value character varying(80) NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(20) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(20) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.district OWNER TO ara;

--
-- TOC entry 1570 (class 1259 OID 97821)
-- Dependencies: 6
-- Name: ecological_region; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE ecological_region (
    ecological_region_id numeric NOT NULL,
    value character varying(80) NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(20) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(20) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.ecological_region OWNER TO ara;

--
-- TOC entry 1571 (class 1259 OID 97826)
-- Dependencies: 6
-- Name: ecological_variable; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE ecological_variable (
    ecological_variable_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    value_list numeric(1,0) NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.ecological_variable OWNER TO ara;

--
-- TOC entry 1572 (class 1259 OID 97831)
-- Dependencies: 6
-- Name: ecological_variable_value; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE ecological_variable_value (
    ecological_variable_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL,
    ecological_variable_value_id numeric NOT NULL
);


ALTER TABLE ara.ecological_variable_value OWNER TO ara;

--
-- TOC entry 1573 (class 1259 OID 97836)
-- Dependencies: 6
-- Name: ecosystem; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE ecosystem (
    ecosystem_id numeric NOT NULL,
    value character varying(80) NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(20) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(20) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.ecosystem OWNER TO ara;

--
-- TOC entry 1574 (class 1259 OID 97841)
-- Dependencies: 6
-- Name: elevation_band; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE elevation_band (
    elevation_band_id numeric NOT NULL,
    value character varying(80) NOT NULL,
    obj_version numeric NOT NULL,
    lower_bound numeric NOT NULL,
    upper_bound numeric NOT NULL,
    created_by character varying(20) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(20) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.elevation_band OWNER TO ara;

--
-- TOC entry 1575 (class 1259 OID 97846)
-- Dependencies: 6
-- Name: exposition; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE exposition (
    exposition_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.exposition OWNER TO ara;

--
-- TOC entry 1576 (class 1259 OID 97851)
-- Dependencies: 6
-- Name: extraction_type; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE extraction_type (
    extraction_type_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.extraction_type OWNER TO ara;

--
-- TOC entry 1577 (class 1259 OID 97856)
-- Dependencies: 6
-- Name: feature_type; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE feature_type (
    feature_type_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.feature_type OWNER TO ara;

--
-- TOC entry 1578 (class 1259 OID 97861)
-- Dependencies: 6
-- Name: gathering_observation; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE gathering_observation (
    gathering_observation_id numeric NOT NULL,
    site_id numeric NOT NULL,
    responsible_person_id numeric NOT NULL,
    initial_date date,
    final_date date,
    surroundings_description character varying(4000),
    minimum_elevation numeric,
    maximum_elevation numeric,
    collection_id numeric NOT NULL,
    label_id numeric,
    original_label_id numeric,
    site_description character varying(4000),
    sampling_type_id numeric,
    gradient_percentage numeric,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL,
    minimum_depth numeric,
    maximum_depth numeric,
    exposition_id numeric
);


ALTER TABLE ara.gathering_observation OWNER TO ara;

--
-- TOC entry 1579 (class 1259 OID 97866)
-- Dependencies: 6
-- Name: gathering_observation_collection; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE gathering_observation_collection (
    gathering_observation_id numeric NOT NULL,
    collection_id numeric NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.gathering_observation_collection OWNER TO ara;

--
-- TOC entry 1580 (class 1259 OID 97871)
-- Dependencies: 6
-- Name: gathering_observation_detail; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE gathering_observation_detail (
    gathering_observation_detail_person_id numeric NOT NULL,
    gathering_observation_detail_number character varying(100) NOT NULL,
    gathering_observation_id numeric NOT NULL,
    morphological_description_id numeric NOT NULL,
    collection_id numeric NOT NULL,
    label_id numeric,
    original_label_id numeric,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL,
    gathering_observation_detail_id numeric NOT NULL
);


ALTER TABLE ara.gathering_observation_detail OWNER TO ara;

--
-- TOC entry 1581 (class 1259 OID 97876)
-- Dependencies: 6
-- Name: gathering_observation_ecological_var; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE gathering_observation_ecological_var (
    gathering_observation_id numeric NOT NULL,
    ecological_variable_value_id numeric NOT NULL,
    value character varying(2000),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.gathering_observation_ecological_var OWNER TO ara;

--
-- TOC entry 1582 (class 1259 OID 97881)
-- Dependencies: 6
-- Name: gathering_observation_method; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE gathering_observation_method (
    gathering_observation_method_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.gathering_observation_method OWNER TO ara;

--
-- TOC entry 1583 (class 1259 OID 97886)
-- Dependencies: 6
-- Name: gathering_observation_project; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE gathering_observation_project (
    gathering_observation_id numeric NOT NULL,
    project_id numeric NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.gathering_observation_project OWNER TO ara;

--
-- TOC entry 1584 (class 1259 OID 97891)
-- Dependencies: 6
-- Name: geographic_catalogue; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE geographic_catalogue (
    geographic_catalogue_id numeric NOT NULL,
    name character varying(80) NOT NULL,
    description character varying(500),
    creation_date date,
    created_by character varying(100),
    last_modification_date date,
    last_modification_by character varying(100),
    obj_version numeric NOT NULL
);


ALTER TABLE ara.geographic_catalogue OWNER TO ara;

--
-- TOC entry 1585 (class 1259 OID 97896)
-- Dependencies: 6
-- Name: geographic_entity; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE geographic_entity (
    geographic_entity_id numeric NOT NULL,
    name character varying(80) NOT NULL,
    description character varying(500),
    creation_date date,
    created_by character varying(100),
    last_modification_date date,
    last_modification_by character varying(100),
    obj_version numeric NOT NULL
);


ALTER TABLE ara.geographic_entity OWNER TO ara;

--
-- TOC entry 1586 (class 1259 OID 97901)
-- Dependencies: 6
-- Name: geographic_layer; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE geographic_layer (
    geographic_layer_id numeric NOT NULL,
    name character varying(80) NOT NULL,
    description character varying(200),
    file_name character varying(200),
    key_field character varying(200),
    main_value_field character varying(200),
    required character varying(1),
    table_name character varying(200),
    color character varying(200),
    fill character varying(200),
    default_sequence character varying(200),
    visible character varying(1),
    obj_version numeric NOT NULL,
    created_by character varying(20) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(20) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.geographic_layer OWNER TO ara;

--
-- TOC entry 1587 (class 1259 OID 97906)
-- Dependencies: 6
-- Name: georeferenced_site; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE georeferenced_site (
    site_id numeric NOT NULL,
    geographic_layer_id numeric NOT NULL,
    geographic_site_id numeric NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(20) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(20) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.georeferenced_site OWNER TO ara;

--
-- TOC entry 1588 (class 1259 OID 97911)
-- Dependencies: 6
-- Name: id_gen; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE id_gen (
    gen_key character varying NOT NULL,
    gen_value numeric NOT NULL
);


ALTER TABLE ara.id_gen OWNER TO ara;

--
-- TOC entry 1589 (class 1259 OID 97916)
-- Dependencies: 6
-- Name: identification; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE identification (
    specimen_id numeric NOT NULL,
    taxon_id numeric NOT NULL,
    identification_date date NOT NULL,
    identification_sequence numeric NOT NULL,
    initial_timestamp date NOT NULL,
    identification_type_id numeric,
    identification_status character varying(1),
    valuer_person_id numeric NOT NULL,
    data_entry_error character varying(1),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    valuer_person_profile_id numeric NOT NULL
);


ALTER TABLE ara.identification OWNER TO ara;

--
-- TOC entry 1590 (class 1259 OID 97921)
-- Dependencies: 6
-- Name: identification_history; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE identification_history (
    identification_history_id numeric NOT NULL,
    specimen_id numeric,
    identification_sequence numeric,
    identification_history_date date,
    initial_timestamp date,
    final_timestamp date,
    identification_type_id numeric,
    identification_status character varying(1),
    taxon_id numeric,
    valuer_person_id numeric,
    data_entry_error numeric,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.identification_history OWNER TO ara;

--
-- TOC entry 1591 (class 1259 OID 97926)
-- Dependencies: 6
-- Name: identification_type; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE identification_type (
    identification_type_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL
);


ALTER TABLE ara.identification_type OWNER TO ara;

--
-- TOC entry 1592 (class 1259 OID 97931)
-- Dependencies: 6
-- Name: identifier; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE identifier (
    specimen_id numeric NOT NULL,
    identification_sequence numeric NOT NULL,
    identifier_sequence numeric NOT NULL,
    initial_timestamp date NOT NULL,
    identifier_person_id numeric NOT NULL,
    identifier_profile_id numeric NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.identifier OWNER TO ara;

--
-- TOC entry 1593 (class 1259 OID 97936)
-- Dependencies: 6
-- Name: identifier_history; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE identifier_history (
    identifier_history_id numeric NOT NULL,
    specimen_id numeric NOT NULL,
    identification_sequence numeric NOT NULL,
    identifier_sequence numeric NOT NULL,
    initial_timestamp date NOT NULL,
    identifier_person_id numeric NOT NULL,
    identifier_profile_id numeric NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.identifier_history OWNER TO ara;

--
-- TOC entry 1594 (class 1259 OID 97941)
-- Dependencies: 6
-- Name: inmediate_predecessor_history; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE inmediate_predecessor_history (
    taxon_id numeric NOT NULL,
    initial_timestamp date NOT NULL,
    final_timestamp date NOT NULL,
    predecessor_taxon_id numeric NOT NULL,
    taxon_taxonomical_range_id numeric NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.inmediate_predecessor_history OWNER TO ara;

--
-- TOC entry 1595 (class 1259 OID 97946)
-- Dependencies: 6
-- Name: institution; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE institution (
    institution_id numeric NOT NULL,
    name character varying(80) NOT NULL,
    telephone character varying(100),
    fax character varying(100),
    street_address character varying(500),
    city character varying(100),
    state_province character varying(100),
    country character varying(100),
    acronym character varying(10),
    url character varying(500),
    multimedia_id numeric,
    creation_date date,
    created_by character varying(100),
    last_modification_date date,
    last_modification_by character varying(100),
    obj_version numeric NOT NULL
);


ALTER TABLE ara.institution OWNER TO ara;

--
-- TOC entry 1596 (class 1259 OID 97951)
-- Dependencies: 6
-- Name: interaction_type; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE interaction_type (
    interaction_type_id numeric NOT NULL,
    name character varying(80) NOT NULL,
    description character varying(500),
    creation_date date,
    created_by character varying(100),
    last_modification_date date,
    last_modification_by character varying(100),
    obj_version numeric NOT NULL
);


ALTER TABLE ara.interaction_type OWNER TO ara;

--
-- TOC entry 1597 (class 1259 OID 97956)
-- Dependencies: 6
-- Name: label; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE label (
    label_id numeric NOT NULL,
    initial_date date,
    contents character varying(4000),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.label OWNER TO ara;

--
-- TOC entry 1598 (class 1259 OID 97961)
-- Dependencies: 6
-- Name: label_history; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE label_history (
    label_id numeric NOT NULL,
    initial_date date,
    final_date date,
    contents character varying(4000),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.label_history OWNER TO ara;

--
-- TOC entry 1599 (class 1259 OID 97966)
-- Dependencies: 6
-- Name: land_cover; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE land_cover (
    land_cover_id numeric NOT NULL,
    value character varying(80) NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(20) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(20) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.land_cover OWNER TO ara;

--
-- TOC entry 1600 (class 1259 OID 97971)
-- Dependencies: 6
-- Name: language; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE "language" (
    language_id numeric NOT NULL,
    concept_id numeric,
    obj_version numeric NOT NULL,
    creation_date date NOT NULL,
    last_modification_date date NOT NULL,
    created_by character varying(100) NOT NULL,
    last_modification_by character varying(100) NOT NULL
);


ALTER TABLE ara."language" OWNER TO ara;

--
-- TOC entry 1601 (class 1259 OID 97976)
-- Dependencies: 6
-- Name: life_form; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE life_form (
    life_form_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.life_form OWNER TO ara;

--
-- TOC entry 1602 (class 1259 OID 97981)
-- Dependencies: 6
-- Name: life_stage; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE life_stage (
    life_stage_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.life_stage OWNER TO ara;

--
-- TOC entry 1603 (class 1259 OID 97986)
-- Dependencies: 6
-- Name: life_zone; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE life_zone (
    life_zone_id numeric NOT NULL,
    value character varying(80) NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(20) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(20) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.life_zone OWNER TO ara;

--
-- TOC entry 1604 (class 1259 OID 97991)
-- Dependencies: 6
-- Name: list_table; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE list_table (
    list_table_id numeric NOT NULL,
    description character varying(200),
    obj_version numeric NOT NULL,
    created_by character varying(20) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(20) NOT NULL,
    last_modification_date date NOT NULL,
    name character varying(100) NOT NULL,
    key_field_name character varying(50) NOT NULL
);


ALTER TABLE ara.list_table OWNER TO ara;

--
-- TOC entry 1605 (class 1259 OID 97996)
-- Dependencies: 6
-- Name: list_table_collection; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE list_table_collection (
    list_table_id numeric NOT NULL,
    collection_id numeric NOT NULL,
    value_id numeric NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(20) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(20) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.list_table_collection OWNER TO ara;

--
-- TOC entry 1606 (class 1259 OID 98001)
-- Dependencies: 6
-- Name: morphological_description; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE morphological_description (
    morphological_description_id numeric NOT NULL,
    contents character varying(4000),
    description_date date,
    description_person_id numeric,
    description_profile_id numeric,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.morphological_description OWNER TO ara;

--
-- TOC entry 1607 (class 1259 OID 98006)
-- Dependencies: 6
-- Name: natural_region; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE natural_region (
    natural_region_id numeric NOT NULL,
    value character varying(80) NOT NULL,
    versant_id numeric NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(20) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(20) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.natural_region OWNER TO ara;

--
-- TOC entry 1608 (class 1259 OID 98011)
-- Dependencies: 6
-- Name: nomenclatural_group; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE nomenclatural_group (
    nomenclatural_group_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    temporality character varying(500),
    common_name character varying(1) NOT NULL,
    certificator_person_id numeric NOT NULL,
    collection_id numeric,
    notes character varying(4000),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.nomenclatural_group OWNER TO ara;

--
-- TOC entry 1689 (class 1259 OID 99609)
-- Dependencies: 6
-- Name: nomenclatural_group_region; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE nomenclatural_group_region (
    nomenclatural_group_id numeric NOT NULL,
    region_id numeric NOT NULL,
    "sequence" numeric NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.nomenclatural_group_region OWNER TO ara;

--
-- TOC entry 1609 (class 1259 OID 98016)
-- Dependencies: 6
-- Name: ocean; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE ocean (
    ocean_id numeric NOT NULL,
    value character varying(80) NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(20) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(20) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.ocean OWNER TO ara;

--
-- TOC entry 1610 (class 1259 OID 98021)
-- Dependencies: 6
-- Name: origin; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE origin (
    origin_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.origin OWNER TO ara;

--
-- TOC entry 1611 (class 1259 OID 98026)
-- Dependencies: 6
-- Name: original_label; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE original_label (
    original_label_id numeric NOT NULL,
    contents character varying(4000),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.original_label OWNER TO ara;

--
-- TOC entry 1612 (class 1259 OID 98031)
-- Dependencies: 6
-- Name: person; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE person (
    person_id numeric NOT NULL,
    first_name character varying(500),
    last_name character varying(500) NOT NULL,
    initials character varying(100),
    birth_year numeric,
    death_year numeric,
    occupation character varying(500),
    telephone character varying(100),
    fax character varying(100),
    street_address character varying(500),
    city character varying(100),
    state_province character varying(100),
    country character varying(100),
    email character varying(100),
    url character varying(500),
    creation_date date,
    created_by character varying(100) NOT NULL,
    last_modification_date date,
    last_modification_by character varying(100) NOT NULL,
    second_last_name character varying(500),
    obj_version numeric
);


ALTER TABLE ara.person OWNER TO ara;

--
-- TOC entry 1613 (class 1259 OID 98036)
-- Dependencies: 6
-- Name: person_institution; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE person_institution (
    person_id numeric NOT NULL,
    institution_id numeric NOT NULL,
    creation_date date,
    created_by character varying(100),
    last_modification_date date,
    last_modification_by character varying(100),
    obj_version numeric NOT NULL
);


ALTER TABLE ara.person_institution OWNER TO ara;

--
-- TOC entry 1614 (class 1259 OID 98041)
-- Dependencies: 6
-- Name: person_profile; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE person_profile (
    person_id numeric NOT NULL,
    profile_id numeric NOT NULL,
    short_name character varying(100),
    valid_from numeric,
    valid_to numeric,
    creation_date date,
    created_by character varying(100),
    last_modification_date date,
    last_modification_by character varying(100),
    obj_version numeric NOT NULL
);


ALTER TABLE ara.person_profile OWNER TO ara;

--
-- TOC entry 1615 (class 1259 OID 98046)
-- Dependencies: 6
-- Name: person_profile_taxon; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE person_profile_taxon (
    person_id numeric NOT NULL,
    profile_id numeric NOT NULL,
    taxon_id numeric NOT NULL,
    creation_date date,
    created_by character varying(100),
    last_modification_date date,
    last_modification_by character varying(100),
    obj_version numeric NOT NULL
);


ALTER TABLE ara.person_profile_taxon OWNER TO ara;

SET default_with_oids = true;

--
-- TOC entry 1616 (class 1259 OID 98051)
-- Dependencies: 6
-- Name: pg_ts_cfg; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE pg_ts_cfg (
    ts_name text NOT NULL,
    prs_name text NOT NULL,
    locale text
);


ALTER TABLE ara.pg_ts_cfg OWNER TO ara;

--
-- TOC entry 1617 (class 1259 OID 98056)
-- Dependencies: 6
-- Name: pg_ts_cfgmap; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE pg_ts_cfgmap (
    ts_name text NOT NULL,
    tok_alias text NOT NULL,
    dict_name text[]
);


ALTER TABLE ara.pg_ts_cfgmap OWNER TO ara;

--
-- TOC entry 1618 (class 1259 OID 98061)
-- Dependencies: 6
-- Name: pg_ts_dict; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE pg_ts_dict (
    dict_name text NOT NULL,
    dict_init regprocedure,
    dict_initoption text,
    dict_lexize regprocedure NOT NULL,
    dict_comment text
);


ALTER TABLE ara.pg_ts_dict OWNER TO ara;

--
-- TOC entry 1619 (class 1259 OID 98066)
-- Dependencies: 6
-- Name: pg_ts_parser; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE pg_ts_parser (
    prs_name text NOT NULL,
    prs_start regprocedure NOT NULL,
    prs_nexttoken regprocedure NOT NULL,
    prs_end regprocedure NOT NULL,
    prs_headline regprocedure NOT NULL,
    prs_lextype regprocedure NOT NULL,
    prs_comment text
);


ALTER TABLE ara.pg_ts_parser OWNER TO ara;

SET default_with_oids = false;

--
-- TOC entry 1620 (class 1259 OID 98071)
-- Dependencies: 6
-- Name: preparation_method; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE preparation_method (
    preparation_method_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.preparation_method OWNER TO ara;

--
-- TOC entry 1621 (class 1259 OID 98076)
-- Dependencies: 6
-- Name: preservation_medium; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE preservation_medium (
    preservation_medium_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.preservation_medium OWNER TO ara;

--
-- TOC entry 1622 (class 1259 OID 98081)
-- Dependencies: 6
-- Name: profile; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE profile (
    profile_id numeric NOT NULL,
    name character varying(80) NOT NULL,
    description character varying(500),
    creation_date date,
    created_by character varying(100),
    last_modification_date date,
    last_modification_by character varying(100),
    obj_version numeric NOT NULL
);


ALTER TABLE ara.profile OWNER TO ara;

--
-- TOC entry 1623 (class 1259 OID 98086)
-- Dependencies: 6
-- Name: project; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE project (
    project_id numeric NOT NULL,
    description character varying(500) NOT NULL,
    project_manager_name character varying(500) NOT NULL,
    initial_date date,
    final_date date,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.project OWNER TO ara;

--
-- TOC entry 1624 (class 1259 OID 98091)
-- Dependencies: 6
-- Name: projection; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE projection (
    projection_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.projection OWNER TO ara;

--
-- TOC entry 1625 (class 1259 OID 98096)
-- Dependencies: 6
-- Name: protected_area; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE protected_area (
    protected_area_id numeric NOT NULL,
    value character varying(80) NOT NULL,
    protected_area_type_id numeric NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(20) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(20) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.protected_area OWNER TO ara;

--
-- TOC entry 1626 (class 1259 OID 98101)
-- Dependencies: 6
-- Name: protected_area_type; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE protected_area_type (
    protected_area_type_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.protected_area_type OWNER TO ara;

--
-- TOC entry 1627 (class 1259 OID 98106)
-- Dependencies: 6
-- Name: protocol_attribute; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE protocol_attribute (
    protocol_attribute_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.protocol_attribute OWNER TO ara;

--
-- TOC entry 1628 (class 1259 OID 98111)
-- Dependencies: 6
-- Name: province; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE province (
    province_id numeric NOT NULL,
    country_id numeric NOT NULL,
    value character varying(80) NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(20) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(20) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.province OWNER TO ara;

--
-- TOC entry 1629 (class 1259 OID 98116)
-- Dependencies: 6
-- Name: reference; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE reference (
    reference_id numeric NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying NOT NULL,
    last_modification_date date NOT NULL,
    title character varying(500) NOT NULL,
    description character varying(500),
    publication_date date,
    identifier character varying(500),
    reference_type_id numeric NOT NULL,
    language_id numeric NOT NULL
);


ALTER TABLE ara.reference OWNER TO ara;

--
-- TOC entry 1630 (class 1259 OID 98121)
-- Dependencies: 6
-- Name: reference_element; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE reference_element (
    reference_element_id numeric NOT NULL,
    name character varying(80) NOT NULL,
    created_by character varying(100),
    creation_date date,
    last_modification_by character varying(100),
    last_modification_date date,
    obj_version numeric NOT NULL,
    "sequence" numeric NOT NULL,
    description character varying(500)
);


ALTER TABLE ara.reference_element OWNER TO ara;

--
-- TOC entry 1631 (class 1259 OID 98126)
-- Dependencies: 6
-- Name: reference_element_value; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE reference_element_value (
    reference_id numeric NOT NULL,
    reference_element_id numeric NOT NULL,
    "sequence" numeric NOT NULL,
    contents character varying(1000) NOT NULL,
    created_by character varying(20) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(20) NOT NULL,
    last_modification_date date NOT NULL,
    obj_version numeric NOT NULL
);


ALTER TABLE ara.reference_element_value OWNER TO ara;

--
-- TOC entry 1632 (class 1259 OID 98131)
-- Dependencies: 6
-- Name: reference_type; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE reference_type (
    reference_type_id numeric NOT NULL,
    name character varying(500) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    creation_date date NOT NULL,
    created_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL
);


ALTER TABLE ara.reference_type OWNER TO ara;

--
-- TOC entry 1688 (class 1259 OID 99590)
-- Dependencies: 6
-- Name: region; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE region (
    region_id numeric NOT NULL,
    name character varying(80) NOT NULL,
    description character varying(500),
    creation_date date,
    created_by character varying(100),
    last_modification_date date,
    last_modification_by character varying(100),
    obj_version numeric NOT NULL
);


ALTER TABLE ara.region OWNER TO ara;

--
-- TOC entry 1633 (class 1259 OID 98136)
-- Dependencies: 6
-- Name: sampling_type; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE sampling_type (
    sampling_type_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.sampling_type OWNER TO ara;

--
-- TOC entry 1634 (class 1259 OID 98141)
-- Dependencies: 6
-- Name: sex; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE sex (
    sex_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.sex OWNER TO ara;

--
-- TOC entry 1635 (class 1259 OID 98146)
-- Dependencies: 6
-- Name: site; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE site (
    site_id numeric NOT NULL,
    description character varying(1000) NOT NULL,
    base_projection_id numeric NOT NULL,
    site_calculation_method_id numeric NOT NULL,
    "precision" numeric,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL,
    name character varying(80),
    original_projection_id numeric NOT NULL,
    geodetic_datum numeric,
    feature_type_id numeric NOT NULL
);


ALTER TABLE ara.site OWNER TO ara;

--
-- TOC entry 1636 (class 1259 OID 98151)
-- Dependencies: 6
-- Name: site_calculation_method; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE site_calculation_method (
    site_calculation_method_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.site_calculation_method OWNER TO ara;

--
-- TOC entry 1637 (class 1259 OID 98156)
-- Dependencies: 6
-- Name: site_coordinate; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE site_coordinate (
    site_coordinate_id numeric NOT NULL,
    site_id numeric NOT NULL,
    longitude numeric NOT NULL,
    latitude numeric NOT NULL,
    "sequence" numeric NOT NULL,
    original_x character varying(30),
    original_y character varying(30),
    obj_version numeric NOT NULL,
    created_by character varying(20) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(20) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.site_coordinate OWNER TO ara;

--
-- TOC entry 1638 (class 1259 OID 98161)
-- Dependencies: 6
-- Name: species_record_stage_profile; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE species_record_stage_profile (
    species_record_stage_id numeric NOT NULL,
    profile_id numeric NOT NULL,
    editable numeric,
    erasable numeric,
    created_by character varying(100),
    creation_date date,
    last_modification_by character varying(100),
    last_modification_date date,
    obj_version numeric NOT NULL,
    visible numeric
);


ALTER TABLE ara.species_record_stage_profile OWNER TO ara;

--
-- TOC entry 1639 (class 1259 OID 98166)
-- Dependencies: 6
-- Name: specimen; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE specimen (
    specimen_id numeric NOT NULL,
    gathering_observation_id numeric NOT NULL,
    discarded character varying(1) NOT NULL,
    specimen_category_id numeric,
    specimen_type_id numeric,
    storage_type_id numeric,
    substrate_id numeric,
    origin_id numeric,
    preservation_medium_id numeric,
    morphological_description_id numeric,
    life_stage_id numeric,
    sex_id numeric,
    number_whole numeric,
    number_fragments numeric,
    extration_type_id numeric,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL,
    collection_id numeric,
    external_specimen numeric(1,0),
    gathering_observation_method_id numeric NOT NULL,
    certainty_level numeric,
    date_time timestamp without time zone,
    gathering_observation_detail_id numeric NOT NULL
);


ALTER TABLE ara.specimen OWNER TO ara;

--
-- TOC entry 1640 (class 1259 OID 98171)
-- Dependencies: 6
-- Name: specimen_annotation; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE specimen_annotation (
    specimen_id numeric NOT NULL,
    annotation_id numeric NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL
);


ALTER TABLE ara.specimen_annotation OWNER TO ara;

--
-- TOC entry 1641 (class 1259 OID 98176)
-- Dependencies: 6
-- Name: specimen_category; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE specimen_category (
    specimen_category_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.specimen_category OWNER TO ara;

--
-- TOC entry 1642 (class 1259 OID 98181)
-- Dependencies: 6
-- Name: specimen_description; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE specimen_description (
    specimen_id numeric NOT NULL,
    specimen_variable_value_id numeric NOT NULL,
    value character varying(2000),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.specimen_description OWNER TO ara;

--
-- TOC entry 1643 (class 1259 OID 98186)
-- Dependencies: 6
-- Name: specimen_life_form; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE specimen_life_form (
    specimen_id numeric NOT NULL,
    life_form_id numeric NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(20) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(20) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.specimen_life_form OWNER TO ara;

--
-- TOC entry 1644 (class 1259 OID 98191)
-- Dependencies: 6
-- Name: specimen_life_stage_sex; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE specimen_life_stage_sex (
    specimen_id numeric NOT NULL,
    life_stage_id numeric NOT NULL,
    sex_id numeric NOT NULL,
    quantity numeric NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(20) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(20) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.specimen_life_stage_sex OWNER TO ara;

--
-- TOC entry 1645 (class 1259 OID 98196)
-- Dependencies: 6
-- Name: specimen_type; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE specimen_type (
    specimen_type_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.specimen_type OWNER TO ara;

--
-- TOC entry 1646 (class 1259 OID 98201)
-- Dependencies: 6
-- Name: specimen_variable; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE specimen_variable (
    specimen_variable_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    value_list numeric(1,0) NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.specimen_variable OWNER TO ara;

--
-- TOC entry 1647 (class 1259 OID 98206)
-- Dependencies: 6
-- Name: specimen_variable_value; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE specimen_variable_value (
    specimen_variable_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL,
    specimen_variable_value_id numeric NOT NULL
);


ALTER TABLE ara.specimen_variable_value OWNER TO ara;

--
-- TOC entry 1648 (class 1259 OID 98211)
-- Dependencies: 6
-- Name: stage_transition_date; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE stage_transition_date (
    transition_date date NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL,
    taxon_id numeric NOT NULL,
    taxon_description_sequence numeric NOT NULL,
    taxon_description_stage_id numeric NOT NULL
);


ALTER TABLE ara.stage_transition_date OWNER TO ara;

--
-- TOC entry 1649 (class 1259 OID 98216)
-- Dependencies: 6
-- Name: stage_transition_digraph; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE stage_transition_digraph (
    species_record_stage_from_id numeric NOT NULL,
    species_record_stage_to_id numeric NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.stage_transition_digraph OWNER TO ara;

--
-- TOC entry 1650 (class 1259 OID 98221)
-- Dependencies: 6
-- Name: storage_type; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE storage_type (
    storage_type_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.storage_type OWNER TO ara;

--
-- TOC entry 1651 (class 1259 OID 98226)
-- Dependencies: 6
-- Name: substrate; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE substrate (
    substrate_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.substrate OWNER TO ara;

--
-- TOC entry 1652 (class 1259 OID 98231)
-- Dependencies: 6
-- Name: system_module; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE system_module (
    module_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL,
    obj_version numeric NOT NULL,
    subsystem_id numeric
);


ALTER TABLE ara.system_module OWNER TO ara;

--
-- TOC entry 1653 (class 1259 OID 98236)
-- Dependencies: 6
-- Name: system_option; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE system_option (
    option_id numeric NOT NULL,
    module_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500) NOT NULL,
    type_id numeric NOT NULL,
    obj_version numeric NOT NULL,
    navigation_rule character varying(500) NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date timestamp without time zone NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date timestamp without time zone NOT NULL
);


ALTER TABLE ara.system_option OWNER TO ara;

--
-- TOC entry 1654 (class 1259 OID 98241)
-- Dependencies: 6
-- Name: system_option_type; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE system_option_type (
    system_option_type_id numeric NOT NULL,
    name character varying(80) NOT NULL,
    description text,
    created_by character varying(100) NOT NULL,
    creation_date timestamp without time zone NOT NULL,
    last_modification_by character varying(80) NOT NULL,
    last_modification_date timestamp without time zone NOT NULL,
    obj_version numeric
);


ALTER TABLE ara.system_option_type OWNER TO ara;

--
-- TOC entry 1655 (class 1259 OID 98246)
-- Dependencies: 6
-- Name: system_subsystem; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE system_subsystem (
    subsystem_id numeric NOT NULL,
    name character varying(500) NOT NULL,
    description character varying(500),
    "sequence" smallint NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.system_subsystem OWNER TO ara;

--
-- TOC entry 1656 (class 1259 OID 98251)
-- Dependencies: 6
-- Name: system_user; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE system_user (
    user_id numeric NOT NULL,
    username character varying(100) NOT NULL,
    fullname character varying(500) NOT NULL,
    passwd character varying(500) NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL,
    enabled numeric NOT NULL,
    obj_version numeric NOT NULL,
    user_type_id numeric NOT NULL,
    user_group_id numeric
);


ALTER TABLE ara.system_user OWNER TO ara;

--
-- TOC entry 1657 (class 1259 OID 98256)
-- Dependencies: 6
-- Name: system_user_option; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE system_user_option (
    user_id numeric NOT NULL,
    option_id numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL,
    obj_version numeric NOT NULL
);


ALTER TABLE ara.system_user_option OWNER TO ara;

--
-- TOC entry 1658 (class 1259 OID 98261)
-- Dependencies: 6
-- Name: system_user_type; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE system_user_type (
    user_type_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    creation_date date NOT NULL,
    created_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    obj_version numeric NOT NULL
);


ALTER TABLE ara.system_user_type OWNER TO ara;

--
-- TOC entry 1659 (class 1259 OID 98266)
-- Dependencies: 2020 6
-- Name: taxon; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE taxon (
    taxon_id numeric NOT NULL,
    taxonomical_range_id numeric NOT NULL,
    current_name character varying(80) NOT NULL,
    current_name_timestamp date NOT NULL,
    default_name character varying(500) NOT NULL,
    current_predecessor_timestamp date,
    taxon_category_id numeric NOT NULL,
    dominium_taxon_id numeric,
    kingdom_taxon_id numeric,
    phylum_division_taxon_id numeric,
    subphylum_subdivision_taxon_id numeric,
    class_taxon_id numeric,
    subclass_taxon_id numeric,
    order_taxon_id numeric,
    suborder_taxon_id numeric,
    superfamily_taxon_id numeric,
    family_taxon_id numeric,
    subfamily_taxon_id numeric,
    tribe_taxon_id numeric,
    subtribe_taxon_id numeric,
    genus_taxon_id numeric,
    subgenus_taxon_id numeric,
    section_taxon_id numeric,
    subsection_taxon_id numeric,
    stirps_taxon_id numeric,
    species_taxon_id numeric,
    subspecies_taxon_id numeric,
    variety_taxon_id numeric,
    description_month numeric,
    description_year numeric,
    synonym_taxon_id numeric,
    author_format_parenthesis numeric(1,0) NOT NULL,
    creation_date date,
    created_by character varying(100),
    last_modification_date date,
    last_modification_by character varying(100),
    collection_id numeric,
    ancestor_id numeric,
    basionym character varying(100),
    country_id numeric,
    obj_version numeric NOT NULL,
    subkingdom_taxon_id numeric,
    infrakingdom_taxon_id numeric,
    superphylum_taxon_id numeric,
    infraphylum_infradivision_taxon_id numeric,
    superclass_taxon_id numeric,
    superorder_taxon_id numeric,
    CONSTRAINT ckc_author_format_par_taxon CHECK (((author_format_parenthesis = (0)::numeric) OR (author_format_parenthesis = (1)::numeric)))
);


ALTER TABLE ara.taxon OWNER TO ara;

--
-- TOC entry 1660 (class 1259 OID 98272)
-- Dependencies: 2021 6
-- Name: taxon_author; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE taxon_author (
    taxon_id numeric NOT NULL,
    category character varying(1) NOT NULL,
    taxon_author_sequence numeric NOT NULL,
    taxon_author_connector_id numeric,
    taxon_author_person_id numeric,
    creation_date date,
    created_by character varying(100),
    last_modification_date date,
    last_modification_by character varying(100),
    obj_version numeric NOT NULL,
    taxon_author_person_profile_id numeric NOT NULL,
    CONSTRAINT ckc_category_taxon_au CHECK ((((category)::text = 'o'::text) OR ((category)::text = 'm'::text)))
);


ALTER TABLE ara.taxon_author OWNER TO ara;

--
-- TOC entry 1661 (class 1259 OID 98278)
-- Dependencies: 6
-- Name: taxon_author_connector; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE taxon_author_connector (
    taxon_author_connector_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    creation_date date,
    created_by character varying(100),
    last_modification_date date,
    last_modification_by character varying(100),
    obj_version numeric NOT NULL
);


ALTER TABLE ara.taxon_author_connector OWNER TO ara;

--
-- TOC entry 1662 (class 1259 OID 98283)
-- Dependencies: 6
-- Name: taxon_category; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE taxon_category (
    taxon_category_id numeric NOT NULL,
    name character varying(80) NOT NULL,
    description character varying(500),
    creation_date date,
    created_by character varying(100),
    last_modification_date date,
    last_modification_by character varying(100),
    obj_version numeric NOT NULL
);


ALTER TABLE ara.taxon_category OWNER TO ara;

--
-- TOC entry 1663 (class 1259 OID 98288)
-- Dependencies: 6
-- Name: taxon_description; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE taxon_description (
    taxon_id numeric NOT NULL,
    taxon_description_sequence numeric NOT NULL,
    taxon_description_stage_id numeric NOT NULL,
    url character varying(500),
    title character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date,
    language_id numeric
);


ALTER TABLE ara.taxon_description OWNER TO ara;

--
-- TOC entry 1664 (class 1259 OID 98293)
-- Dependencies: 6
-- Name: taxon_description_audience; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE taxon_description_audience (
    taxon_id numeric NOT NULL,
    taxon_description_sequence numeric NOT NULL,
    audience_id numeric NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.taxon_description_audience OWNER TO ara;

--
-- TOC entry 1665 (class 1259 OID 98298)
-- Dependencies: 6
-- Name: taxon_description_category; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE taxon_description_category (
    taxon_description_category_id numeric NOT NULL,
    name character varying(80) NOT NULL,
    description character varying(500),
    "sequence" numeric,
    ancestor_id numeric,
    "repeatable" numeric(1,0),
    mandatory numeric(1,0),
    creation_date date,
    created_by character varying(100),
    last_modification_date date,
    last_modification_by character varying(100),
    obj_version numeric NOT NULL
);


ALTER TABLE ara.taxon_description_category OWNER TO ara;

--
-- TOC entry 1666 (class 1259 OID 98303)
-- Dependencies: 6
-- Name: taxon_description_datatype; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE taxon_description_datatype (
    taxon_description_datatype_id numeric NOT NULL,
    name character varying(80),
    description character varying(500),
    created_by character varying(100),
    creation_date date,
    last_modification_by character varying(100),
    last_modification_date date,
    obj_version numeric NOT NULL
);


ALTER TABLE ara.taxon_description_datatype OWNER TO ara;

--
-- TOC entry 1667 (class 1259 OID 98308)
-- Dependencies: 6
-- Name: taxon_description_element; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE taxon_description_element (
    taxon_description_category_id numeric,
    taxon_description_element_id numeric NOT NULL,
    name character varying(80) NOT NULL,
    mandatory numeric(1,0),
    description character varying(500),
    taxon_description_datatype_id numeric,
    "repeatable" numeric(1,0),
    table_name character varying(100),
    key_field character varying(100),
    main_field_name character varying(100),
    "sequence" numeric,
    creation_date date,
    created_by character varying(100),
    last_modification_date date,
    last_modification_by character varying(100),
    obj_version numeric NOT NULL
);


ALTER TABLE ara.taxon_description_element OWNER TO ara;

--
-- TOC entry 1668 (class 1259 OID 98313)
-- Dependencies: 6
-- Name: taxon_description_institution; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE taxon_description_institution (
    taxon_id numeric NOT NULL,
    taxon_description_sequence numeric NOT NULL,
    institution_id numeric NOT NULL,
    "sequence" numeric NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL,
    description character varying(500)
);


ALTER TABLE ara.taxon_description_institution OWNER TO ara;

--
-- TOC entry 1669 (class 1259 OID 98318)
-- Dependencies: 6
-- Name: taxon_description_person_profile; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE taxon_description_person_profile (
    taxon_id numeric NOT NULL,
    taxon_description_sequence numeric NOT NULL,
    person_id numeric NOT NULL,
    profile_id numeric NOT NULL,
    "sequence" numeric NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.taxon_description_person_profile OWNER TO ara;

--
-- TOC entry 1670 (class 1259 OID 98323)
-- Dependencies: 6
-- Name: taxon_description_record; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE taxon_description_record (
    taxon_description_record_id numeric NOT NULL,
    taxon_id numeric NOT NULL,
    taxon_description_sequence numeric NOT NULL,
    taxon_description_element_id numeric NOT NULL,
    "sequence" numeric NOT NULL,
    contents_text character varying(4000),
    contents_numeric numeric,
    taxonomical_timestamp date NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.taxon_description_record OWNER TO ara;

--
-- TOC entry 1671 (class 1259 OID 98328)
-- Dependencies: 6
-- Name: taxon_description_record_reference; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE taxon_description_record_reference (
    taxon_description_record_id numeric NOT NULL,
    reference_id numeric NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.taxon_description_record_reference OWNER TO ara;

--
-- TOC entry 1672 (class 1259 OID 98333)
-- Dependencies: 6
-- Name: taxon_description_stage; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE taxon_description_stage (
    taxon_description_stage_id numeric NOT NULL,
    name character varying(80) NOT NULL,
    description character varying(500),
    created_by character varying(100),
    creation_date date,
    last_modification_by character varying(100),
    last_modification_date date,
    obj_version numeric NOT NULL
);


ALTER TABLE ara.taxon_description_stage OWNER TO ara;

--
-- TOC entry 1673 (class 1259 OID 98338)
-- Dependencies: 6
-- Name: taxon_name_history; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE taxon_name_history (
    taxon_id numeric NOT NULL,
    initial_timestamp date NOT NULL,
    final_timestamp date NOT NULL,
    historic_name character varying(80) NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL
);


ALTER TABLE ara.taxon_name_history OWNER TO ara;

--
-- TOC entry 1674 (class 1259 OID 98343)
-- Dependencies: 6
-- Name: taxon_nomenclatural_group; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE taxon_nomenclatural_group (
    nomenclatural_group_id numeric NOT NULL,
    taxon_id numeric NOT NULL,
    taxonomical_timestamp date,
    "sequence" numeric NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.taxon_nomenclatural_group OWNER TO ara;

--
-- TOC entry 1675 (class 1259 OID 98348)
-- Dependencies: 6
-- Name: taxon_reference; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE taxon_reference (
    taxon_id numeric NOT NULL,
    reference_id numeric NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.taxon_reference OWNER TO ara;

--
-- TOC entry 1676 (class 1259 OID 98353)
-- Dependencies: 6
-- Name: taxonomical_hierarchy; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE taxonomical_hierarchy (
    taxonomical_range_id numeric NOT NULL,
    ancestor_taxonomical_id numeric NOT NULL,
    creation_date date,
    created_by character varying(100),
    last_modification_date date,
    last_modification_by character varying(100),
    obj_version numeric NOT NULL
);


ALTER TABLE ara.taxonomical_hierarchy OWNER TO ara;

--
-- TOC entry 1677 (class 1259 OID 98358)
-- Dependencies: 2022 2023 2024 6
-- Name: taxonomical_range; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE taxonomical_range (
    taxonomical_range_id numeric NOT NULL,
    name character varying(80) NOT NULL,
    prefix character varying(100),
    parenthesis numeric(1,0) NOT NULL,
    taxonomical_range_category character varying(1) NOT NULL,
    field_name character varying(100),
    taxonomical_hierarchy_level numeric,
    mandatory_level numeric(1,0) NOT NULL,
    creation_date date,
    created_by character varying(100),
    last_modification_date date,
    last_modification_by character varying(100),
    obj_version numeric NOT NULL,
    CONSTRAINT ckc_mandatory_level_taxonomi CHECK (((mandatory_level = (0)::numeric) OR (mandatory_level = (1)::numeric))),
    CONSTRAINT ckc_parenthesis_taxonomi CHECK (((parenthesis = (0)::numeric) OR (parenthesis = (1)::numeric))),
    CONSTRAINT ckc_taxonomical_range_taxonomi CHECK ((((((((taxonomical_range_category)::text = 'e'::text) OR ((taxonomical_range_category)::text = 'g'::text)) OR ((taxonomical_range_category)::text = 'f'::text)) OR ((taxonomical_range_category)::text = 'r'::text)) OR ((taxonomical_range_category)::text = 'n'::text)) OR ((taxonomical_range_category)::text = 'k'::text)))
);


ALTER TABLE ara.taxonomical_range OWNER TO ara;

--
-- TOC entry 1678 (class 1259 OID 98366)
-- Dependencies: 6
-- Name: topographic_sheet; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE topographic_sheet (
    topographic_sheet_id numeric NOT NULL,
    value character varying(80) NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(20) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(20) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.topographic_sheet OWNER TO ara;

--
-- TOC entry 1679 (class 1259 OID 98371)
-- Dependencies: 6
-- Name: transacted_specimen; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE transacted_specimen (
    specimen_id numeric NOT NULL,
    transaction_id numeric NOT NULL,
    delivery_date date NOT NULL,
    receiving_date date,
    transacted_specimen_status_id numeric NOT NULL,
    transaction_type_id numeric,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100),
    last_modification_date date NOT NULL
);


ALTER TABLE ara.transacted_specimen OWNER TO ara;

--
-- TOC entry 1680 (class 1259 OID 98376)
-- Dependencies: 6
-- Name: transacted_specimen_status; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE transacted_specimen_status (
    transacted_specimen_status_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.transacted_specimen_status OWNER TO ara;

--
-- TOC entry 1681 (class 1259 OID 98381)
-- Dependencies: 6
-- Name: transaction; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE "transaction" (
    transaction_id numeric NOT NULL,
    transaction_date date NOT NULL,
    invoice_number character varying(500),
    estimated_specimen_count numeric,
    description character varying(500),
    expiration_date date,
    sender_person_id numeric NOT NULL,
    sender_institution_id numeric,
    receiver_person_id numeric,
    receiver_institution_id numeric,
    collection_id numeric NOT NULL,
    transaction_type_id numeric NOT NULL,
    obj_version numeric NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL,
    created_by character varying(100) NOT NULL
);


ALTER TABLE ara."transaction" OWNER TO ara;

--
-- TOC entry 1682 (class 1259 OID 98386)
-- Dependencies: 6
-- Name: transaction_type; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE transaction_type (
    transaction_type_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.transaction_type OWNER TO ara;

--
-- TOC entry 1683 (class 1259 OID 98391)
-- Dependencies: 6
-- Name: type_specimen; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE type_specimen (
    type_specimen_id numeric NOT NULL,
    specimen_id numeric NOT NULL,
    taxon_id numeric NOT NULL,
    identification_sequence numeric NOT NULL,
    taxonomical_timestamp date NOT NULL,
    institution_id numeric NOT NULL,
    type_specimen_type_id numeric NOT NULL,
    initial_timestamp date NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.type_specimen OWNER TO ara;

--
-- TOC entry 1684 (class 1259 OID 98396)
-- Dependencies: 6
-- Name: type_specimen_type; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE type_specimen_type (
    type_specimen_type_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.type_specimen_type OWNER TO ara;

--
-- TOC entry 1686 (class 1259 OID 99545)
-- Dependencies: 6
-- Name: user_nomenclatural_group; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE user_nomenclatural_group (
    nomenclatural_group_id numeric NOT NULL,
    user_id numeric NOT NULL,
    "sequence" numeric NOT NULL,
    obj_version numeric NOT NULL,
    creation_date date NOT NULL,
    created_by character varying(20) NOT NULL,
    last_modification_date date NOT NULL,
    last_modification_by character varying(20) NOT NULL
);


ALTER TABLE ara.user_nomenclatural_group OWNER TO ara;

--
-- TOC entry 1687 (class 1259 OID 99569)
-- Dependencies: 6
-- Name: user_taxon; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE user_taxon (
    taxon_id numeric NOT NULL,
    user_id numeric NOT NULL,
    "sequence" numeric NOT NULL,
    obj_version numeric NOT NULL,
    creation_date date NOT NULL,
    created_by character varying(20) NOT NULL,
    last_modification_date date NOT NULL,
    last_modification_by character varying(20) NOT NULL
);


ALTER TABLE ara.user_taxon OWNER TO ara;

--
-- TOC entry 1685 (class 1259 OID 98401)
-- Dependencies: 6
-- Name: versant; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE versant (
    versant_id numeric NOT NULL,
    value character varying(80) NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(20) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(20) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.versant OWNER TO ara;

--
-- TOC entry 2229 (class 2606 OID 98407)
-- Dependencies: 1653 1653
-- Name: SYSTEM_OPTION_PK; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY system_option
    ADD CONSTRAINT "SYSTEM_OPTION_PK" PRIMARY KEY (option_id);


--
-- TOC entry 2237 (class 2606 OID 98409)
-- Dependencies: 1657 1657 1657
-- Name: SYSTEM_USER_OPTION_PK; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY system_user_option
    ADD CONSTRAINT "SYSTEM_USER_OPTION_PK" PRIMARY KEY (user_id, option_id);


--
-- TOC entry 2026 (class 2606 OID 98411)
-- Dependencies: 1549 1549
-- Name: altitude_floor_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY altitude_floor
    ADD CONSTRAINT altitude_floor_pk PRIMARY KEY (altitude_floor_id);


--
-- TOC entry 2028 (class 2606 OID 98413)
-- Dependencies: 1550 1550
-- Name: annotation_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY annotation
    ADD CONSTRAINT annotation_pk PRIMARY KEY (annotation_id);


--
-- TOC entry 2032 (class 2606 OID 98415)
-- Dependencies: 1552 1552
-- Name: base_projection_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY base_projection
    ADD CONSTRAINT base_projection_pk PRIMARY KEY (base_projection_id);


--
-- TOC entry 2034 (class 2606 OID 98417)
-- Dependencies: 1553 1553
-- Name: biotic_unit_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY biotic_unit
    ADD CONSTRAINT biotic_unit_pk PRIMARY KEY (biotic_unit_id);


--
-- TOC entry 2038 (class 2606 OID 98419)
-- Dependencies: 1555 1555
-- Name: canton_ifam_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY canton_ifam
    ADD CONSTRAINT canton_ifam_pk PRIMARY KEY (canton_ifam_id);


--
-- TOC entry 2036 (class 2606 OID 98421)
-- Dependencies: 1554 1554
-- Name: canton_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY canton
    ADD CONSTRAINT canton_pk PRIMARY KEY (canton_id);


--
-- TOC entry 2040 (class 2606 OID 98423)
-- Dependencies: 1556 1556
-- Name: collecting_area_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY collecting_area
    ADD CONSTRAINT collecting_area_pk PRIMARY KEY (collecting_area_id);


--
-- TOC entry 2044 (class 2606 OID 98425)
-- Dependencies: 1558 1558 1558
-- Name: collection_protocol_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY collection_protocol
    ADD CONSTRAINT collection_protocol_pk PRIMARY KEY (collection_id, protocol_attribute_id);


--
-- TOC entry 2046 (class 2606 OID 99632)
-- Dependencies: 1559 1559 1559
-- Name: collector_observer_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY collector_observer
    ADD CONSTRAINT collector_observer_pk PRIMARY KEY (gathering_observation_id, collector_person_id);


--
-- TOC entry 2050 (class 2606 OID 98429)
-- Dependencies: 1561 1561
-- Name: component_part_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY component_part
    ADD CONSTRAINT component_part_pk PRIMARY KEY (component_part_id);


--
-- TOC entry 2048 (class 2606 OID 98431)
-- Dependencies: 1560 1560
-- Name: component_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY component
    ADD CONSTRAINT component_pk PRIMARY KEY (component_id);


--
-- TOC entry 2054 (class 2606 OID 98433)
-- Dependencies: 1563 1563
-- Name: conservation_area_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY conservation_area
    ADD CONSTRAINT conservation_area_pk PRIMARY KEY (conservation_area_id);


--
-- TOC entry 2060 (class 2606 OID 98435)
-- Dependencies: 1566 1566
-- Name: culture_medium_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY culture_medium
    ADD CONSTRAINT culture_medium_pk PRIMARY KEY (culture_medium_id);


--
-- TOC entry 2058 (class 2606 OID 98437)
-- Dependencies: 1565 1565 1565
-- Name: culture_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY culture
    ADD CONSTRAINT culture_pk PRIMARY KEY (specimen_id, replica_number);


--
-- TOC entry 2062 (class 2606 OID 98439)
-- Dependencies: 1567 1567
-- Name: culture_storage_medium_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY culture_storage_medium
    ADD CONSTRAINT culture_storage_medium_pk PRIMARY KEY (culture_storage_medium_id);


--
-- TOC entry 2064 (class 2606 OID 98441)
-- Dependencies: 1568 1568
-- Name: determination_type_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY determination_type
    ADD CONSTRAINT determination_type_pk PRIMARY KEY (determination_type_id);


--
-- TOC entry 2066 (class 2606 OID 98443)
-- Dependencies: 1569 1569
-- Name: district_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY district
    ADD CONSTRAINT district_pk PRIMARY KEY (district_id);


--
-- TOC entry 2068 (class 2606 OID 98445)
-- Dependencies: 1570 1570
-- Name: ecological_region_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY ecological_region
    ADD CONSTRAINT ecological_region_pk PRIMARY KEY (ecological_region_id);


--
-- TOC entry 2070 (class 2606 OID 98447)
-- Dependencies: 1571 1571
-- Name: ecological_variable_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY ecological_variable
    ADD CONSTRAINT ecological_variable_pk PRIMARY KEY (ecological_variable_id);


--
-- TOC entry 2072 (class 2606 OID 99534)
-- Dependencies: 1572 1572
-- Name: ecological_variable_value_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY ecological_variable_value
    ADD CONSTRAINT ecological_variable_value_pk PRIMARY KEY (ecological_variable_value_id);


--
-- TOC entry 2074 (class 2606 OID 98451)
-- Dependencies: 1573 1573
-- Name: ecosystem_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY ecosystem
    ADD CONSTRAINT ecosystem_pk PRIMARY KEY (ecosystem_id);


--
-- TOC entry 2076 (class 2606 OID 98453)
-- Dependencies: 1574 1574
-- Name: elevation_band_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY elevation_band
    ADD CONSTRAINT elevation_band_pk PRIMARY KEY (elevation_band_id);


--
-- TOC entry 2078 (class 2606 OID 98455)
-- Dependencies: 1575 1575
-- Name: exposition_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY exposition
    ADD CONSTRAINT exposition_pk PRIMARY KEY (exposition_id);


--
-- TOC entry 2080 (class 2606 OID 98457)
-- Dependencies: 1576 1576
-- Name: extraction_type_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY extraction_type
    ADD CONSTRAINT extraction_type_pk PRIMARY KEY (extraction_type_id);


--
-- TOC entry 2082 (class 2606 OID 98459)
-- Dependencies: 1577 1577
-- Name: feature_type_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY feature_type
    ADD CONSTRAINT feature_type_pk PRIMARY KEY (feature_type_id);


--
-- TOC entry 2090 (class 2606 OID 98465)
-- Dependencies: 1582 1582
-- Name: gathering_method_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY gathering_observation_method
    ADD CONSTRAINT gathering_method_pk PRIMARY KEY (gathering_observation_method_id);


--
-- TOC entry 2086 (class 2606 OID 99641)
-- Dependencies: 1579 1579 1579
-- Name: gathering_observation_collection_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY gathering_observation_collection
    ADD CONSTRAINT gathering_observation_collection_pk PRIMARY KEY (gathering_observation_id, collection_id);


--
-- TOC entry 2088 (class 2606 OID 99530)
-- Dependencies: 1580 1580
-- Name: gathering_observation_detail_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY gathering_observation_detail
    ADD CONSTRAINT gathering_observation_detail_pk PRIMARY KEY (gathering_observation_detail_person_id);


--
-- TOC entry 2092 (class 2606 OID 98469)
-- Dependencies: 1583 1583 1583
-- Name: gathering_observation_project_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY gathering_observation_project
    ADD CONSTRAINT gathering_observation_project_pk PRIMARY KEY (gathering_observation_id, project_id);


--
-- TOC entry 2084 (class 2606 OID 98471)
-- Dependencies: 1578 1578
-- Name: gathering_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY gathering_observation
    ADD CONSTRAINT gathering_pk PRIMARY KEY (gathering_observation_id);


--
-- TOC entry 2098 (class 2606 OID 98473)
-- Dependencies: 1586 1586
-- Name: geographic_layer_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY geographic_layer
    ADD CONSTRAINT geographic_layer_pk PRIMARY KEY (geographic_layer_id);


--
-- TOC entry 2100 (class 2606 OID 98475)
-- Dependencies: 1587 1587 1587 1587
-- Name: georeferenced_site_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY georeferenced_site
    ADD CONSTRAINT georeferenced_site_pk PRIMARY KEY (site_id, geographic_layer_id, geographic_site_id);


--
-- TOC entry 2102 (class 2606 OID 98477)
-- Dependencies: 1588 1588
-- Name: id_gen_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY id_gen
    ADD CONSTRAINT id_gen_pk PRIMARY KEY (gen_key);


--
-- TOC entry 2106 (class 2606 OID 98479)
-- Dependencies: 1590 1590
-- Name: identification_history_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY identification_history
    ADD CONSTRAINT identification_history_pk PRIMARY KEY (identification_history_id);


--
-- TOC entry 2104 (class 2606 OID 98481)
-- Dependencies: 1589 1589 1589 1589
-- Name: identification_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY identification
    ADD CONSTRAINT identification_pk PRIMARY KEY (specimen_id, identification_sequence, initial_timestamp);


--
-- TOC entry 2108 (class 2606 OID 98483)
-- Dependencies: 1591 1591
-- Name: identification_type_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY identification_type
    ADD CONSTRAINT identification_type_pk PRIMARY KEY (identification_type_id);


--
-- TOC entry 2112 (class 2606 OID 98485)
-- Dependencies: 1593 1593
-- Name: identifier_history_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY identifier_history
    ADD CONSTRAINT identifier_history_pk PRIMARY KEY (identifier_history_id);


--
-- TOC entry 2110 (class 2606 OID 98487)
-- Dependencies: 1592 1592 1592 1592 1592 1592
-- Name: identifier_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY identifier
    ADD CONSTRAINT identifier_pk PRIMARY KEY (specimen_id, identification_sequence, initial_timestamp, identifier_person_id, identifier_profile_id);


--
-- TOC entry 2114 (class 2606 OID 98489)
-- Dependencies: 1594 1594 1594 1594 1594
-- Name: inmediate_precedecessor_history; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY inmediate_predecessor_history
    ADD CONSTRAINT inmediate_precedecessor_history PRIMARY KEY (taxon_id, initial_timestamp, final_timestamp, predecessor_taxon_id);


--
-- TOC entry 2120 (class 2606 OID 98491)
-- Dependencies: 1597 1597
-- Name: label_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY label
    ADD CONSTRAINT label_pk PRIMARY KEY (label_id);


--
-- TOC entry 2122 (class 2606 OID 98493)
-- Dependencies: 1599 1599
-- Name: land_cover_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY land_cover
    ADD CONSTRAINT land_cover_pk PRIMARY KEY (land_cover_id);


--
-- TOC entry 2126 (class 2606 OID 98495)
-- Dependencies: 1601 1601
-- Name: life_form_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY life_form
    ADD CONSTRAINT life_form_pk PRIMARY KEY (life_form_id);


--
-- TOC entry 2128 (class 2606 OID 98497)
-- Dependencies: 1602 1602
-- Name: life_stage_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY life_stage
    ADD CONSTRAINT life_stage_pk PRIMARY KEY (life_stage_id);


--
-- TOC entry 2130 (class 2606 OID 98499)
-- Dependencies: 1603 1603
-- Name: life_zone_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY life_zone
    ADD CONSTRAINT life_zone_pk PRIMARY KEY (life_zone_id);


--
-- TOC entry 2134 (class 2606 OID 99639)
-- Dependencies: 1605 1605 1605 1605
-- Name: list_table_collection_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY list_table_collection
    ADD CONSTRAINT list_table_collection_pk PRIMARY KEY (list_table_id, collection_id, value_id);


--
-- TOC entry 2132 (class 2606 OID 98503)
-- Dependencies: 1604 1604
-- Name: list_table_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY list_table
    ADD CONSTRAINT list_table_pk PRIMARY KEY (list_table_id);


--
-- TOC entry 2136 (class 2606 OID 98505)
-- Dependencies: 1606 1606
-- Name: morphological_description_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY morphological_description
    ADD CONSTRAINT morphological_description_pk PRIMARY KEY (morphological_description_id);


--
-- TOC entry 2138 (class 2606 OID 98507)
-- Dependencies: 1607 1607
-- Name: natural_region_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY natural_region
    ADD CONSTRAINT natural_region_pk PRIMARY KEY (natural_region_id);


--
-- TOC entry 2140 (class 2606 OID 98509)
-- Dependencies: 1608 1608
-- Name: nomenclatural_group_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY nomenclatural_group
    ADD CONSTRAINT nomenclatural_group_pk PRIMARY KEY (nomenclatural_group_id);


--
-- TOC entry 2301 (class 2606 OID 99615)
-- Dependencies: 1689 1689 1689
-- Name: nomenclatural_group_region_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY nomenclatural_group_region
    ADD CONSTRAINT nomenclatural_group_region_pk PRIMARY KEY (region_id, nomenclatural_group_id);


--
-- TOC entry 2142 (class 2606 OID 98511)
-- Dependencies: 1609 1609
-- Name: ocean_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY ocean
    ADD CONSTRAINT ocean_pk PRIMARY KEY (ocean_id);


--
-- TOC entry 2144 (class 2606 OID 98513)
-- Dependencies: 1610 1610
-- Name: origin_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY origin
    ADD CONSTRAINT origin_pk PRIMARY KEY (origin_id);


--
-- TOC entry 2146 (class 2606 OID 98515)
-- Dependencies: 1611 1611
-- Name: origincal_label_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY original_label
    ADD CONSTRAINT origincal_label_pk PRIMARY KEY (original_label_id);


--
-- TOC entry 2156 (class 2606 OID 98517)
-- Dependencies: 1616 1616
-- Name: pg_ts_cfg_pkey; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY pg_ts_cfg
    ADD CONSTRAINT pg_ts_cfg_pkey PRIMARY KEY (ts_name);


--
-- TOC entry 2158 (class 2606 OID 98519)
-- Dependencies: 1617 1617 1617
-- Name: pg_ts_cfgmap_pkey; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY pg_ts_cfgmap
    ADD CONSTRAINT pg_ts_cfgmap_pkey PRIMARY KEY (ts_name, tok_alias);


--
-- TOC entry 2160 (class 2606 OID 98521)
-- Dependencies: 1618 1618
-- Name: pg_ts_dict_pkey; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY pg_ts_dict
    ADD CONSTRAINT pg_ts_dict_pkey PRIMARY KEY (dict_name);


--
-- TOC entry 2162 (class 2606 OID 98523)
-- Dependencies: 1619 1619
-- Name: pg_ts_parser_pkey; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY pg_ts_parser
    ADD CONSTRAINT pg_ts_parser_pkey PRIMARY KEY (prs_name);


--
-- TOC entry 2030 (class 2606 OID 98525)
-- Dependencies: 1551 1551
-- Name: pk_arao_meta_id; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY audience
    ADD CONSTRAINT pk_arao_meta_id PRIMARY KEY (audience_id);


--
-- TOC entry 2042 (class 2606 OID 98527)
-- Dependencies: 1557 1557
-- Name: pk_collection_id; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY collection
    ADD CONSTRAINT pk_collection_id PRIMARY KEY (collection_id);


--
-- TOC entry 2052 (class 2606 OID 98529)
-- Dependencies: 1562 1562
-- Name: pk_concept; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY concept
    ADD CONSTRAINT pk_concept PRIMARY KEY (concept_id);


--
-- TOC entry 2056 (class 2606 OID 98531)
-- Dependencies: 1564 1564
-- Name: pk_country_id; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY country
    ADD CONSTRAINT pk_country_id PRIMARY KEY (country_id);


--
-- TOC entry 2094 (class 2606 OID 98533)
-- Dependencies: 1584 1584
-- Name: pk_geographic_catalogue; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY geographic_catalogue
    ADD CONSTRAINT pk_geographic_catalogue PRIMARY KEY (geographic_catalogue_id);


--
-- TOC entry 2096 (class 2606 OID 98535)
-- Dependencies: 1585 1585
-- Name: pk_geographic_entity; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY geographic_entity
    ADD CONSTRAINT pk_geographic_entity PRIMARY KEY (geographic_entity_id);


--
-- TOC entry 2116 (class 2606 OID 98537)
-- Dependencies: 1595 1595
-- Name: pk_institution_id; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY institution
    ADD CONSTRAINT pk_institution_id PRIMARY KEY (institution_id);


--
-- TOC entry 2118 (class 2606 OID 98539)
-- Dependencies: 1596 1596
-- Name: pk_interaction_type; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY interaction_type
    ADD CONSTRAINT pk_interaction_type PRIMARY KEY (interaction_type_id);


--
-- TOC entry 2124 (class 2606 OID 98541)
-- Dependencies: 1600 1600
-- Name: pk_language_id; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY "language"
    ADD CONSTRAINT pk_language_id PRIMARY KEY (language_id);


--
-- TOC entry 2148 (class 2606 OID 98543)
-- Dependencies: 1612 1612
-- Name: pk_person_id; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY person
    ADD CONSTRAINT pk_person_id PRIMARY KEY (person_id);


--
-- TOC entry 2150 (class 2606 OID 98545)
-- Dependencies: 1613 1613 1613
-- Name: pk_person_id_institution_id; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY person_institution
    ADD CONSTRAINT pk_person_id_institution_id PRIMARY KEY (person_id, institution_id);


--
-- TOC entry 2152 (class 2606 OID 98547)
-- Dependencies: 1614 1614 1614
-- Name: pk_person_id_profile_id; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY person_profile
    ADD CONSTRAINT pk_person_id_profile_id PRIMARY KEY (person_id, profile_id);


--
-- TOC entry 2154 (class 2606 OID 98549)
-- Dependencies: 1615 1615 1615 1615
-- Name: pk_person_profile_taxon; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY person_profile_taxon
    ADD CONSTRAINT pk_person_profile_taxon PRIMARY KEY (person_id, profile_id, taxon_id);


--
-- TOC entry 2168 (class 2606 OID 98551)
-- Dependencies: 1622 1622
-- Name: pk_profile_id; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY profile
    ADD CONSTRAINT pk_profile_id PRIMARY KEY (profile_id);


--
-- TOC entry 2184 (class 2606 OID 98553)
-- Dependencies: 1630 1630
-- Name: pk_reference_element; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY reference_element
    ADD CONSTRAINT pk_reference_element PRIMARY KEY (reference_element_id);


--
-- TOC entry 2299 (class 2606 OID 99596)
-- Dependencies: 1688 1688
-- Name: pk_region_id; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY region
    ADD CONSTRAINT pk_region_id PRIMARY KEY (region_id);


--
-- TOC entry 2267 (class 2606 OID 98555)
-- Dependencies: 1672 1672
-- Name: pk_species_record_stage; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_description_stage
    ADD CONSTRAINT pk_species_record_stage PRIMARY KEY (taxon_description_stage_id);


--
-- TOC entry 2200 (class 2606 OID 98557)
-- Dependencies: 1638 1638 1638
-- Name: pk_species_record_stage_prof; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY species_record_stage_profile
    ADD CONSTRAINT pk_species_record_stage_prof PRIMARY KEY (species_record_stage_id, profile_id);


--
-- TOC entry 2221 (class 2606 OID 98559)
-- Dependencies: 1649 1649 1649
-- Name: pk_stage_transition_digraph; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY stage_transition_digraph
    ADD CONSTRAINT pk_stage_transition_digraph PRIMARY KEY (species_record_stage_from_id, species_record_stage_to_id);


--
-- TOC entry 2245 (class 2606 OID 98561)
-- Dependencies: 1661 1661
-- Name: pk_taxon_author_connector; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_author_connector
    ADD CONSTRAINT pk_taxon_author_connector PRIMARY KEY (taxon_author_connector_id);


--
-- TOC entry 2243 (class 2606 OID 98563)
-- Dependencies: 1660 1660 1660 1660
-- Name: pk_taxon_cate_author_sequence; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_author
    ADD CONSTRAINT pk_taxon_cate_author_sequence PRIMARY KEY (taxon_id, category, taxon_author_sequence);


--
-- TOC entry 2247 (class 2606 OID 98565)
-- Dependencies: 1662 1662
-- Name: pk_taxon_category_id; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_category
    ADD CONSTRAINT pk_taxon_category_id PRIMARY KEY (taxon_category_id);


--
-- TOC entry 2253 (class 2606 OID 98567)
-- Dependencies: 1665 1665
-- Name: pk_taxon_description_category; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_description_category
    ADD CONSTRAINT pk_taxon_description_category PRIMARY KEY (taxon_description_category_id);


--
-- TOC entry 2255 (class 2606 OID 98569)
-- Dependencies: 1666 1666
-- Name: pk_taxon_description_datatype; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_description_datatype
    ADD CONSTRAINT pk_taxon_description_datatype PRIMARY KEY (taxon_description_datatype_id);


--
-- TOC entry 2257 (class 2606 OID 98571)
-- Dependencies: 1667 1667
-- Name: pk_taxon_description_type_id; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_description_element
    ADD CONSTRAINT pk_taxon_description_type_id PRIMARY KEY (taxon_description_element_id);


--
-- TOC entry 2241 (class 2606 OID 98573)
-- Dependencies: 1659 1659
-- Name: pk_taxon_id; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT pk_taxon_id PRIMARY KEY (taxon_id);


--
-- TOC entry 2277 (class 2606 OID 98575)
-- Dependencies: 1677 1677
-- Name: pk_taxonomical_node_id; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxonomical_range
    ADD CONSTRAINT pk_taxonomical_node_id PRIMARY KEY (taxonomical_range_id);


--
-- TOC entry 2275 (class 2606 OID 98577)
-- Dependencies: 1676 1676 1676
-- Name: pk_taxorangnod_pretaxorangnod; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxonomical_hierarchy
    ADD CONSTRAINT pk_taxorangnod_pretaxorangnod PRIMARY KEY (taxonomical_range_id, ancestor_taxonomical_id);


--
-- TOC entry 2164 (class 2606 OID 98579)
-- Dependencies: 1620 1620
-- Name: preparation_method_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY preparation_method
    ADD CONSTRAINT preparation_method_pk PRIMARY KEY (preparation_method_id);


--
-- TOC entry 2166 (class 2606 OID 98581)
-- Dependencies: 1621 1621
-- Name: preservation_medium_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY preservation_medium
    ADD CONSTRAINT preservation_medium_pk PRIMARY KEY (preservation_medium_id);


--
-- TOC entry 2170 (class 2606 OID 98583)
-- Dependencies: 1623 1623
-- Name: project_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY project
    ADD CONSTRAINT project_pk PRIMARY KEY (project_id);


--
-- TOC entry 2172 (class 2606 OID 98585)
-- Dependencies: 1624 1624
-- Name: projection_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY projection
    ADD CONSTRAINT projection_pk PRIMARY KEY (projection_id);


--
-- TOC entry 2174 (class 2606 OID 98587)
-- Dependencies: 1625 1625
-- Name: protected_area_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY protected_area
    ADD CONSTRAINT protected_area_pk PRIMARY KEY (protected_area_id);


--
-- TOC entry 2176 (class 2606 OID 98589)
-- Dependencies: 1626 1626
-- Name: protected_area_type_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY protected_area_type
    ADD CONSTRAINT protected_area_type_pk PRIMARY KEY (protected_area_type_id);


--
-- TOC entry 2178 (class 2606 OID 98591)
-- Dependencies: 1627 1627
-- Name: protocol_attribute_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY protocol_attribute
    ADD CONSTRAINT protocol_attribute_pk PRIMARY KEY (protocol_attribute_id);


--
-- TOC entry 2180 (class 2606 OID 98593)
-- Dependencies: 1628 1628
-- Name: province_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY province
    ADD CONSTRAINT province_pk PRIMARY KEY (province_id);


--
-- TOC entry 2186 (class 2606 OID 98595)
-- Dependencies: 1631 1631 1631
-- Name: reference_element_value_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY reference_element_value
    ADD CONSTRAINT reference_element_value_pk PRIMARY KEY (reference_id, reference_element_id);


--
-- TOC entry 2182 (class 2606 OID 98597)
-- Dependencies: 1629 1629
-- Name: reference_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY reference
    ADD CONSTRAINT reference_pk PRIMARY KEY (reference_id);


--
-- TOC entry 2188 (class 2606 OID 98599)
-- Dependencies: 1632 1632
-- Name: reference_type_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY reference_type
    ADD CONSTRAINT reference_type_pk PRIMARY KEY (reference_type_id);


--
-- TOC entry 2190 (class 2606 OID 98601)
-- Dependencies: 1633 1633
-- Name: sampling_type_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY sampling_type
    ADD CONSTRAINT sampling_type_pk PRIMARY KEY (sampling_type_id);


--
-- TOC entry 2192 (class 2606 OID 98603)
-- Dependencies: 1634 1634
-- Name: sex_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY sex
    ADD CONSTRAINT sex_pk PRIMARY KEY (sex_id);


--
-- TOC entry 2196 (class 2606 OID 98605)
-- Dependencies: 1636 1636
-- Name: site_calculation_method_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY site_calculation_method
    ADD CONSTRAINT site_calculation_method_pk PRIMARY KEY (site_calculation_method_id);


--
-- TOC entry 2198 (class 2606 OID 98607)
-- Dependencies: 1637 1637
-- Name: site_coordinates_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY site_coordinate
    ADD CONSTRAINT site_coordinates_pk PRIMARY KEY (site_coordinate_id);


--
-- TOC entry 2194 (class 2606 OID 98609)
-- Dependencies: 1635 1635
-- Name: site_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY site
    ADD CONSTRAINT site_pk PRIMARY KEY (site_id);


--
-- TOC entry 2259 (class 2606 OID 98611)
-- Dependencies: 1668 1668 1668 1668
-- Name: species_record_institution_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_description_institution
    ADD CONSTRAINT species_record_institution_pk PRIMARY KEY (taxon_id, taxon_description_sequence, institution_id);


--
-- TOC entry 2261 (class 2606 OID 98613)
-- Dependencies: 1669 1669 1669 1669 1669
-- Name: species_record_person_profile_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_description_person_profile
    ADD CONSTRAINT species_record_person_profile_pk PRIMARY KEY (taxon_id, taxon_description_sequence, person_id, profile_id);


--
-- TOC entry 2204 (class 2606 OID 98615)
-- Dependencies: 1640 1640 1640
-- Name: specimen_annotation_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY specimen_annotation
    ADD CONSTRAINT specimen_annotation_pk PRIMARY KEY (specimen_id, annotation_id);


--
-- TOC entry 2206 (class 2606 OID 98617)
-- Dependencies: 1641 1641
-- Name: specimen_category_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY specimen_category
    ADD CONSTRAINT specimen_category_pk PRIMARY KEY (specimen_category_id);


--
-- TOC entry 2208 (class 2606 OID 98621)
-- Dependencies: 1643 1643 1643
-- Name: specimen_life_form_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY specimen_life_form
    ADD CONSTRAINT specimen_life_form_pk PRIMARY KEY (specimen_id, life_form_id);


--
-- TOC entry 2210 (class 2606 OID 98623)
-- Dependencies: 1644 1644 1644 1644
-- Name: specimen_life_stage_sex_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY specimen_life_stage_sex
    ADD CONSTRAINT specimen_life_stage_sex_pk PRIMARY KEY (specimen_id, life_stage_id, sex_id);


--
-- TOC entry 2202 (class 2606 OID 98625)
-- Dependencies: 1639 1639
-- Name: specimen_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY specimen
    ADD CONSTRAINT specimen_pk PRIMARY KEY (specimen_id);


--
-- TOC entry 2212 (class 2606 OID 98627)
-- Dependencies: 1645 1645
-- Name: specimen_type_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY specimen_type
    ADD CONSTRAINT specimen_type_pk PRIMARY KEY (specimen_type_id);


--
-- TOC entry 2214 (class 2606 OID 98629)
-- Dependencies: 1646 1646
-- Name: specimen_variable_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY specimen_variable
    ADD CONSTRAINT specimen_variable_pk PRIMARY KEY (specimen_variable_id);


--
-- TOC entry 2216 (class 2606 OID 99532)
-- Dependencies: 1647 1647
-- Name: specimen_variable_value_id; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY specimen_variable_value
    ADD CONSTRAINT specimen_variable_value_id PRIMARY KEY (specimen_variable_value_id);


--
-- TOC entry 2219 (class 2606 OID 98633)
-- Dependencies: 1648 1648 1648 1648 1648
-- Name: stage_transition_date_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY stage_transition_date
    ADD CONSTRAINT stage_transition_date_pk PRIMARY KEY (taxon_id, taxon_description_sequence, taxon_description_stage_id, transition_date);


--
-- TOC entry 2223 (class 2606 OID 98635)
-- Dependencies: 1650 1650
-- Name: storage_type_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY storage_type
    ADD CONSTRAINT storage_type_pk PRIMARY KEY (storage_type_id);


--
-- TOC entry 2225 (class 2606 OID 98637)
-- Dependencies: 1651 1651
-- Name: substrate_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY substrate
    ADD CONSTRAINT substrate_pk PRIMARY KEY (substrate_id);


--
-- TOC entry 2227 (class 2606 OID 98639)
-- Dependencies: 1652 1652
-- Name: system_module_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY system_module
    ADD CONSTRAINT system_module_pk PRIMARY KEY (module_id);


--
-- TOC entry 2231 (class 2606 OID 98641)
-- Dependencies: 1654 1654
-- Name: system_option_type_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY system_option_type
    ADD CONSTRAINT system_option_type_pk PRIMARY KEY (system_option_type_id);


--
-- TOC entry 2233 (class 2606 OID 98643)
-- Dependencies: 1655 1655
-- Name: system_subsystem_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY system_subsystem
    ADD CONSTRAINT system_subsystem_pk PRIMARY KEY (subsystem_id);


--
-- TOC entry 2235 (class 2606 OID 98645)
-- Dependencies: 1656 1656
-- Name: system_user_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY system_user
    ADD CONSTRAINT system_user_pk PRIMARY KEY (user_id);


--
-- TOC entry 2239 (class 2606 OID 98647)
-- Dependencies: 1658 1658
-- Name: system_user_type_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY system_user_type
    ADD CONSTRAINT system_user_type_pk PRIMARY KEY (user_type_id);


--
-- TOC entry 2251 (class 2606 OID 98649)
-- Dependencies: 1664 1664 1664 1664
-- Name: taxon_description_audience_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_description_audience
    ADD CONSTRAINT taxon_description_audience_pk PRIMARY KEY (taxon_id, taxon_description_sequence, audience_id);


--
-- TOC entry 2249 (class 2606 OID 98651)
-- Dependencies: 1663 1663 1663
-- Name: taxon_description_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_description
    ADD CONSTRAINT taxon_description_pk PRIMARY KEY (taxon_description_sequence, taxon_id);


--
-- TOC entry 2263 (class 2606 OID 98653)
-- Dependencies: 1670 1670
-- Name: taxon_description_record_id_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_description_record
    ADD CONSTRAINT taxon_description_record_id_pk PRIMARY KEY (taxon_description_record_id);


--
-- TOC entry 2265 (class 2606 OID 98655)
-- Dependencies: 1671 1671 1671
-- Name: taxon_description_record_reference_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_description_record_reference
    ADD CONSTRAINT taxon_description_record_reference_pk PRIMARY KEY (taxon_description_record_id, reference_id);


--
-- TOC entry 2269 (class 2606 OID 98657)
-- Dependencies: 1673 1673 1673 1673
-- Name: taxon_name_history_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_name_history
    ADD CONSTRAINT taxon_name_history_pk PRIMARY KEY (taxon_id, initial_timestamp, final_timestamp);


--
-- TOC entry 2271 (class 2606 OID 98659)
-- Dependencies: 1674 1674 1674
-- Name: taxon_nomenclatural_group_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_nomenclatural_group
    ADD CONSTRAINT taxon_nomenclatural_group_pk PRIMARY KEY (taxon_id, nomenclatural_group_id);


--
-- TOC entry 2273 (class 2606 OID 98661)
-- Dependencies: 1675 1675 1675
-- Name: taxon_reference_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_reference
    ADD CONSTRAINT taxon_reference_pk PRIMARY KEY (taxon_id, reference_id);


--
-- TOC entry 2279 (class 2606 OID 98663)
-- Dependencies: 1678 1678
-- Name: topographic_sheet_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY topographic_sheet
    ADD CONSTRAINT topographic_sheet_pk PRIMARY KEY (topographic_sheet_id);


--
-- TOC entry 2281 (class 2606 OID 98665)
-- Dependencies: 1679 1679 1679
-- Name: transacted_specimen_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY transacted_specimen
    ADD CONSTRAINT transacted_specimen_pk PRIMARY KEY (transaction_id, specimen_id);


--
-- TOC entry 2283 (class 2606 OID 98667)
-- Dependencies: 1680 1680
-- Name: transacted_specimen_status_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY transacted_specimen_status
    ADD CONSTRAINT transacted_specimen_status_pk PRIMARY KEY (transacted_specimen_status_id);


--
-- TOC entry 2285 (class 2606 OID 98669)
-- Dependencies: 1681 1681
-- Name: transaction_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY "transaction"
    ADD CONSTRAINT transaction_pk PRIMARY KEY (transaction_id);


--
-- TOC entry 2287 (class 2606 OID 98671)
-- Dependencies: 1682 1682
-- Name: transaction_type_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY transaction_type
    ADD CONSTRAINT transaction_type_pk PRIMARY KEY (transaction_type_id);


--
-- TOC entry 2289 (class 2606 OID 98673)
-- Dependencies: 1683 1683
-- Name: type_specimen_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY type_specimen
    ADD CONSTRAINT type_specimen_pk PRIMARY KEY (type_specimen_id);


--
-- TOC entry 2291 (class 2606 OID 98675)
-- Dependencies: 1684 1684
-- Name: type_specimen_type_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY type_specimen_type
    ADD CONSTRAINT type_specimen_type_pk PRIMARY KEY (type_specimen_type_id);


--
-- TOC entry 2295 (class 2606 OID 99587)
-- Dependencies: 1686 1686 1686 1686
-- Name: user_nomenclatural_group_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY user_nomenclatural_group
    ADD CONSTRAINT user_nomenclatural_group_pk PRIMARY KEY (nomenclatural_group_id, user_id, "sequence");


--
-- TOC entry 2297 (class 2606 OID 99589)
-- Dependencies: 1687 1687 1687 1687
-- Name: user_taxon_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY user_taxon
    ADD CONSTRAINT user_taxon_pk PRIMARY KEY (taxon_id, user_id, "sequence");


--
-- TOC entry 2293 (class 2606 OID 98677)
-- Dependencies: 1685 1685
-- Name: versant_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY versant
    ADD CONSTRAINT versant_pk PRIMARY KEY (versant_id);


--
-- TOC entry 2217 (class 1259 OID 98678)
-- Dependencies: 1648 1648
-- Name: fki_taxon_description_stage_transition_date_fk; Type: INDEX; Schema: ara; Owner: ara; Tablespace: 
--

CREATE INDEX fki_taxon_description_stage_transition_date_fk ON stage_transition_date USING btree (taxon_id, taxon_description_sequence);


--
-- TOC entry 2402 (class 2606 OID 98679)
-- Dependencies: 1653 1652 2226
-- Name: SYSTEM_MODULE_OPTION_FK; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY system_option
    ADD CONSTRAINT "SYSTEM_MODULE_OPTION_FK" FOREIGN KEY (module_id) REFERENCES system_module(module_id);


--
-- TOC entry 2302 (class 2606 OID 98684)
-- Dependencies: 1550 1550 1614 1614 2151
-- Name: annotation_person_profile; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY annotation
    ADD CONSTRAINT annotation_person_profile FOREIGN KEY (annotator_person_id, annotator_profile_id) REFERENCES person_profile(person_id, profile_id);


--
-- TOC entry 2367 (class 2606 OID 98689)
-- Dependencies: 1635 1624 2171
-- Name: base_projection_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY site
    ADD CONSTRAINT base_projection_fk FOREIGN KEY (base_projection_id) REFERENCES projection(projection_id);


--
-- TOC entry 2304 (class 2606 OID 98694)
-- Dependencies: 1555 1628 2179
-- Name: canton_ifam_province; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY canton_ifam
    ADD CONSTRAINT canton_ifam_province FOREIGN KEY (province_id) REFERENCES province(province_id);


--
-- TOC entry 2303 (class 2606 OID 98699)
-- Dependencies: 1554 1628 2179
-- Name: canton_province; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY canton
    ADD CONSTRAINT canton_province FOREIGN KEY (province_id) REFERENCES province(province_id);


--
-- TOC entry 2348 (class 2606 OID 98704)
-- Dependencies: 1605 1557 2041
-- Name: collection_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY list_table_collection
    ADD CONSTRAINT collection_fk FOREIGN KEY (collection_id) REFERENCES collection(collection_id);


--
-- TOC entry 2306 (class 2606 OID 98709)
-- Dependencies: 1558 1557 2041
-- Name: collection_protocol_collection_pk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY collection_protocol
    ADD CONSTRAINT collection_protocol_collection_pk FOREIGN KEY (collection_id) REFERENCES collection(collection_id);


--
-- TOC entry 2307 (class 2606 OID 98714)
-- Dependencies: 1558 1627 2177
-- Name: collection_protocol_protocol_attribute_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY collection_protocol
    ADD CONSTRAINT collection_protocol_protocol_attribute_fk FOREIGN KEY (protocol_attribute_id) REFERENCES protocol_attribute(protocol_attribute_id);


--
-- TOC entry 2310 (class 2606 OID 98724)
-- Dependencies: 1560 1561 2049
-- Name: component_part_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY component
    ADD CONSTRAINT component_part_fk FOREIGN KEY (component_part_id) REFERENCES component_part(component_part_id);


--
-- TOC entry 2311 (class 2606 OID 98729)
-- Dependencies: 1560 1620 2163
-- Name: component_preparation_method_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY component
    ADD CONSTRAINT component_preparation_method_fk FOREIGN KEY (preparation_method_id) REFERENCES preparation_method(preparation_method_id);


--
-- TOC entry 2312 (class 2606 OID 98734)
-- Dependencies: 1560 1639 2201
-- Name: component_specimen_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY component
    ADD CONSTRAINT component_specimen_fk FOREIGN KEY (specimen_id) REFERENCES specimen(specimen_id);


--
-- TOC entry 2313 (class 2606 OID 98739)
-- Dependencies: 2059 1565 1566
-- Name: culture_medium_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY culture
    ADD CONSTRAINT culture_medium_fk FOREIGN KEY (culture_medium_id) REFERENCES culture_medium(culture_medium_id);


--
-- TOC entry 2314 (class 2606 OID 98744)
-- Dependencies: 1565 1565 1614 1614 2151
-- Name: culture_responsible_person_profile; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY culture
    ADD CONSTRAINT culture_responsible_person_profile FOREIGN KEY (responsible_person_id, responsible_profile_id) REFERENCES person_profile(person_id, profile_id);


--
-- TOC entry 2315 (class 2606 OID 98749)
-- Dependencies: 1565 1567 2061
-- Name: culture_storage_medium_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY culture
    ADD CONSTRAINT culture_storage_medium_fk FOREIGN KEY (culture_storage_medium_id) REFERENCES culture_storage_medium(culture_storage_medium_id);


--
-- TOC entry 2316 (class 2606 OID 98754)
-- Dependencies: 1569 1554 2035
-- Name: district_canton_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY district
    ADD CONSTRAINT district_canton_fk FOREIGN KEY (canton_id) REFERENCES canton(canton_id);


--
-- TOC entry 2317 (class 2606 OID 98759)
-- Dependencies: 1572 1571 2069
-- Name: ecological_variable_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY ecological_variable_value
    ADD CONSTRAINT ecological_variable_fk FOREIGN KEY (ecological_variable_id) REFERENCES ecological_variable(ecological_variable_id);


--
-- TOC entry 2333 (class 2606 OID 99535)
-- Dependencies: 2071 1572 1581
-- Name: ecological_variable_value_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation_ecological_var
    ADD CONSTRAINT ecological_variable_value_fk FOREIGN KEY (ecological_variable_value_id) REFERENCES ecological_variable_value(ecological_variable_value_id);


--
-- TOC entry 2318 (class 2606 OID 98769)
-- Dependencies: 1578 1575 2077
-- Name: exposition_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation
    ADD CONSTRAINT exposition_fk FOREIGN KEY (exposition_id) REFERENCES exposition(exposition_id);


--
-- TOC entry 2368 (class 2606 OID 98774)
-- Dependencies: 1635 1577 2081
-- Name: feature_type_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY site
    ADD CONSTRAINT feature_type_fk FOREIGN KEY (feature_type_id) REFERENCES feature_type(feature_type_id);


--
-- TOC entry 2435 (class 2606 OID 98779)
-- Dependencies: 1660 1661 2244
-- Name: fk132_taxon_author_connector; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_author
    ADD CONSTRAINT fk132_taxon_author_connector FOREIGN KEY (taxon_author_connector_id) REFERENCES taxon_author_connector(taxon_author_connector_id);


--
-- TOC entry 2408 (class 2606 OID 98784)
-- Dependencies: 1659 1659 2240
-- Name: fk67_ancestor_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_ancestor_id FOREIGN KEY (ancestor_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2409 (class 2606 OID 98789)
-- Dependencies: 1659 1659 2240
-- Name: fk67_class_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_class_taxon_id FOREIGN KEY (class_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2410 (class 2606 OID 98794)
-- Dependencies: 1659 1557 2041
-- Name: fk67_collection_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_collection_id FOREIGN KEY (collection_id) REFERENCES collection(collection_id);


--
-- TOC entry 2411 (class 2606 OID 98799)
-- Dependencies: 1659 1659 2240
-- Name: fk67_dominium_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_dominium_taxon_id FOREIGN KEY (dominium_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2412 (class 2606 OID 98804)
-- Dependencies: 1659 1659 2240
-- Name: fk67_family_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_family_taxon_id FOREIGN KEY (family_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2413 (class 2606 OID 98809)
-- Dependencies: 1659 1659 2240
-- Name: fk67_genus_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_genus_taxon_id FOREIGN KEY (genus_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2414 (class 2606 OID 98814)
-- Dependencies: 1659 1659 2240
-- Name: fk67_kingdom_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_kingdom_taxon_id FOREIGN KEY (kingdom_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2415 (class 2606 OID 98819)
-- Dependencies: 1659 1659 2240
-- Name: fk67_order_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_order_taxon_id FOREIGN KEY (order_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2416 (class 2606 OID 98824)
-- Dependencies: 1659 1659 2240
-- Name: fk67_phylum_division_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_phylum_division_taxon_id FOREIGN KEY (phylum_division_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2417 (class 2606 OID 98829)
-- Dependencies: 1659 1659 2240
-- Name: fk67_section_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_section_taxon_id FOREIGN KEY (section_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2418 (class 2606 OID 98834)
-- Dependencies: 1659 1659 2240
-- Name: fk67_species_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_species_taxon_id FOREIGN KEY (species_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2419 (class 2606 OID 98839)
-- Dependencies: 1659 1659 2240
-- Name: fk67_stirps_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_stirps_taxon_id FOREIGN KEY (stirps_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2420 (class 2606 OID 98844)
-- Dependencies: 1659 1659 2240
-- Name: fk67_subclass_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_subclass_taxon_id FOREIGN KEY (subclass_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2421 (class 2606 OID 98849)
-- Dependencies: 1659 1659 2240
-- Name: fk67_subfamily_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_subfamily_taxon_id FOREIGN KEY (subfamily_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2422 (class 2606 OID 98854)
-- Dependencies: 1659 1659 2240
-- Name: fk67_subgenus_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_subgenus_taxon_id FOREIGN KEY (subgenus_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2423 (class 2606 OID 98859)
-- Dependencies: 1659 1659 2240
-- Name: fk67_suborder_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_suborder_taxon_id FOREIGN KEY (suborder_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2424 (class 2606 OID 98864)
-- Dependencies: 1659 1659 2240
-- Name: fk67_subphylum_subdiv_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_subphylum_subdiv_taxon_id FOREIGN KEY (subphylum_subdivision_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2425 (class 2606 OID 98869)
-- Dependencies: 1659 1659 2240
-- Name: fk67_subsection_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_subsection_taxon_id FOREIGN KEY (subsection_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2426 (class 2606 OID 98874)
-- Dependencies: 1659 1659 2240
-- Name: fk67_subspecies_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_subspecies_taxon_id FOREIGN KEY (subspecies_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2427 (class 2606 OID 98879)
-- Dependencies: 1659 1659 2240
-- Name: fk67_subtribe_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_subtribe_taxon_id FOREIGN KEY (subtribe_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2428 (class 2606 OID 98884)
-- Dependencies: 1659 1659 2240
-- Name: fk67_superfamily_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_superfamily_taxon_id FOREIGN KEY (superfamily_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2429 (class 2606 OID 98889)
-- Dependencies: 1659 1659 2240
-- Name: fk67_synonym_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_synonym_taxon_id FOREIGN KEY (synonym_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2430 (class 2606 OID 98894)
-- Dependencies: 1659 1662 2246
-- Name: fk67_taxon_category_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_taxon_category_id FOREIGN KEY (taxon_category_id) REFERENCES taxon_category(taxon_category_id);


--
-- TOC entry 2431 (class 2606 OID 98899)
-- Dependencies: 1659 1677 2276
-- Name: fk67_taxonomical_range_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_taxonomical_range_id FOREIGN KEY (taxonomical_range_id) REFERENCES taxonomical_range(taxonomical_range_id);


--
-- TOC entry 2432 (class 2606 OID 98904)
-- Dependencies: 1659 1659 2240
-- Name: fk67_tribe_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_tribe_taxon_id FOREIGN KEY (tribe_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2433 (class 2606 OID 98909)
-- Dependencies: 1659 1659 2240
-- Name: fk67_variety_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_variety_taxon_id FOREIGN KEY (variety_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2453 (class 2606 OID 98914)
-- Dependencies: 1676 1677 2276
-- Name: fk70_prede_range_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxonomical_hierarchy
    ADD CONSTRAINT fk70_prede_range_id FOREIGN KEY (ancestor_taxonomical_id) REFERENCES taxonomical_range(taxonomical_range_id);


--
-- TOC entry 2454 (class 2606 OID 98919)
-- Dependencies: 1676 1677 2276
-- Name: fk70_taxonomical_range_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxonomical_hierarchy
    ADD CONSTRAINT fk70_taxonomical_range_id FOREIGN KEY (taxonomical_range_id) REFERENCES taxonomical_range(taxonomical_range_id);


--
-- TOC entry 2436 (class 2606 OID 98924)
-- Dependencies: 1660 1659 2240
-- Name: fk74_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_author
    ADD CONSTRAINT fk74_taxon_id FOREIGN KEY (taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2440 (class 2606 OID 98929)
-- Dependencies: 1667 1665 2252
-- Name: fk76_taxon_desc_category; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_description_element
    ADD CONSTRAINT fk76_taxon_desc_category FOREIGN KEY (taxon_description_category_id) REFERENCES taxon_description_category(taxon_description_category_id);


--
-- TOC entry 2353 (class 2606 OID 98934)
-- Dependencies: 1613 1595 2115
-- Name: fk7_institution_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY person_institution
    ADD CONSTRAINT fk7_institution_id FOREIGN KEY (institution_id) REFERENCES institution(institution_id);


--
-- TOC entry 2355 (class 2606 OID 98939)
-- Dependencies: 1614 1612 2147
-- Name: fk7_person_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY person_profile
    ADD CONSTRAINT fk7_person_id FOREIGN KEY (person_id) REFERENCES person(person_id);


--
-- TOC entry 2354 (class 2606 OID 98944)
-- Dependencies: 1613 1612 2147
-- Name: fk7_person_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY person_institution
    ADD CONSTRAINT fk7_person_id FOREIGN KEY (person_id) REFERENCES person(person_id);


--
-- TOC entry 2356 (class 2606 OID 98949)
-- Dependencies: 1614 1622 2167
-- Name: fk7_profile_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY person_profile
    ADD CONSTRAINT fk7_profile_id FOREIGN KEY (profile_id) REFERENCES profile(profile_id);


--
-- TOC entry 2357 (class 2606 OID 98954)
-- Dependencies: 1615 1612 2147
-- Name: fk8_person_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY person_profile_taxon
    ADD CONSTRAINT fk8_person_id FOREIGN KEY (person_id) REFERENCES person(person_id);


--
-- TOC entry 2358 (class 2606 OID 98959)
-- Dependencies: 1615 1615 1614 1614 2151
-- Name: fk8_person_profile; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY person_profile_taxon
    ADD CONSTRAINT fk8_person_profile FOREIGN KEY (person_id, profile_id) REFERENCES person_profile(person_id, profile_id);


--
-- TOC entry 2359 (class 2606 OID 98964)
-- Dependencies: 1615 1622 2167
-- Name: fk8_profile_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY person_profile_taxon
    ADD CONSTRAINT fk8_profile_id FOREIGN KEY (profile_id) REFERENCES profile(profile_id);


--
-- TOC entry 2347 (class 2606 OID 98969)
-- Dependencies: 1600 1562 2051
-- Name: fk_language_reference_concept; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY "language"
    ADD CONSTRAINT fk_language_reference_concept FOREIGN KEY (concept_id) REFERENCES concept(concept_id);


--
-- TOC entry 2360 (class 2606 OID 98974)
-- Dependencies: 1615 1659 2240
-- Name: fk_person_p_fk8_taxon_taxon; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY person_profile_taxon
    ADD CONSTRAINT fk_person_p_fk8_taxon_taxon FOREIGN KEY (taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2437 (class 2606 OID 98979)
-- Dependencies: 1660 1660 1614 1614 2151
-- Name: fk_person_profile_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_author
    ADD CONSTRAINT fk_person_profile_id FOREIGN KEY (taxon_author_person_id, taxon_author_person_profile_id) REFERENCES person_profile(person_id, profile_id);


--
-- TOC entry 2372 (class 2606 OID 98984)
-- Dependencies: 1638 1672 2266
-- Name: fk_species__ref_72892_species_; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY species_record_stage_profile
    ADD CONSTRAINT fk_species__ref_72892_species_ FOREIGN KEY (species_record_stage_id) REFERENCES taxon_description_stage(taxon_description_stage_id);


--
-- TOC entry 2373 (class 2606 OID 98989)
-- Dependencies: 1638 1622 2167
-- Name: fk_species__ref_72896_profile; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY species_record_stage_profile
    ADD CONSTRAINT fk_species__ref_72896_profile FOREIGN KEY (profile_id) REFERENCES profile(profile_id);


--
-- TOC entry 2399 (class 2606 OID 98994)
-- Dependencies: 1649 1672 2266
-- Name: fk_stage_tr_ref_65607_species_; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY stage_transition_digraph
    ADD CONSTRAINT fk_stage_tr_ref_65607_species_ FOREIGN KEY (species_record_stage_from_id) REFERENCES taxon_description_stage(taxon_description_stage_id);


--
-- TOC entry 2400 (class 2606 OID 98999)
-- Dependencies: 1649 1672 2266
-- Name: fk_stage_tr_ref_65613_species_; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY stage_transition_digraph
    ADD CONSTRAINT fk_stage_tr_ref_65613_species_ FOREIGN KEY (species_record_stage_to_id) REFERENCES taxon_description_stage(taxon_description_stage_id);


--
-- TOC entry 2441 (class 2606 OID 99004)
-- Dependencies: 1667 1666 2254
-- Name: fk_taxon_de_reference_taxon_aa; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_description_element
    ADD CONSTRAINT fk_taxon_de_reference_taxon_aa FOREIGN KEY (taxon_description_datatype_id) REFERENCES taxon_description_datatype(taxon_description_datatype_id);


--
-- TOC entry 2434 (class 2606 OID 99009)
-- Dependencies: 1659 1564 2055
-- Name: fk_taxon_fk76_taxo_country; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk_taxon_fk76_taxo_country FOREIGN KEY (country_id) REFERENCES country(country_id);


--
-- TOC entry 2325 (class 2606 OID 99014)
-- Dependencies: 1579 1557 2041
-- Name: gathering_collection_collection_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation_collection
    ADD CONSTRAINT gathering_collection_collection_fk FOREIGN KEY (collection_id) REFERENCES collection(collection_id);


--
-- TOC entry 2319 (class 2606 OID 99019)
-- Dependencies: 1578 1557 2041
-- Name: gathering_collection_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation
    ADD CONSTRAINT gathering_collection_fk FOREIGN KEY (collection_id) REFERENCES collection(collection_id);


--
-- TOC entry 2326 (class 2606 OID 99024)
-- Dependencies: 1579 1578 2083
-- Name: gathering_collection_gathering_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation_collection
    ADD CONSTRAINT gathering_collection_gathering_fk FOREIGN KEY (gathering_observation_id) REFERENCES gathering_observation(gathering_observation_id);


--
-- TOC entry 2308 (class 2606 OID 99034)
-- Dependencies: 1578 2083 1559
-- Name: gathering_collector_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY collector_observer
    ADD CONSTRAINT gathering_collector_fk FOREIGN KEY (gathering_observation_id) REFERENCES gathering_observation(gathering_observation_id);


--
-- TOC entry 2309 (class 2606 OID 99633)
-- Dependencies: 2147 1559 1612
-- Name: gathering_collector_person_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY collector_observer
    ADD CONSTRAINT gathering_collector_person_fk FOREIGN KEY (collector_person_id) REFERENCES person(person_id);


--
-- TOC entry 2327 (class 2606 OID 99039)
-- Dependencies: 1580 1557 2041
-- Name: gathering_detail_collection_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation_detail
    ADD CONSTRAINT gathering_detail_collection_fk FOREIGN KEY (collection_id) REFERENCES collection(collection_id);


--
-- TOC entry 2328 (class 2606 OID 99044)
-- Dependencies: 2083 1580 1578
-- Name: gathering_detail_gathering_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation_detail
    ADD CONSTRAINT gathering_detail_gathering_fk FOREIGN KEY (gathering_observation_id) REFERENCES gathering_observation(gathering_observation_id);


--
-- TOC entry 2329 (class 2606 OID 99049)
-- Dependencies: 1597 1580 2119
-- Name: gathering_detail_label; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation_detail
    ADD CONSTRAINT gathering_detail_label FOREIGN KEY (label_id) REFERENCES label(label_id);


--
-- TOC entry 2330 (class 2606 OID 99054)
-- Dependencies: 1606 1580 2135
-- Name: gathering_detail_morphological_description; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation_detail
    ADD CONSTRAINT gathering_detail_morphological_description FOREIGN KEY (morphological_description_id) REFERENCES morphological_description(morphological_description_id);


--
-- TOC entry 2331 (class 2606 OID 99059)
-- Dependencies: 1611 1580 2145
-- Name: gathering_detail_original_label_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation_detail
    ADD CONSTRAINT gathering_detail_original_label_fk FOREIGN KEY (original_label_id) REFERENCES original_label(original_label_id);


--
-- TOC entry 2320 (class 2606 OID 99064)
-- Dependencies: 1597 1578 2119
-- Name: gathering_label_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation
    ADD CONSTRAINT gathering_label_fk FOREIGN KEY (label_id) REFERENCES label(label_id);


--
-- TOC entry 2334 (class 2606 OID 99069)
-- Dependencies: 1578 1583 2083
-- Name: gathering_observation_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation_project
    ADD CONSTRAINT gathering_observation_fk FOREIGN KEY (gathering_observation_id) REFERENCES gathering_observation(gathering_observation_id);


--
-- TOC entry 2332 (class 2606 OID 99074)
-- Dependencies: 1578 1581 2083
-- Name: gathering_observation_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation_ecological_var
    ADD CONSTRAINT gathering_observation_fk FOREIGN KEY (gathering_observation_id) REFERENCES gathering_observation(gathering_observation_id);


--
-- TOC entry 2374 (class 2606 OID 99079)
-- Dependencies: 1582 1639 2089
-- Name: gathering_observation_method_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen
    ADD CONSTRAINT gathering_observation_method_fk FOREIGN KEY (gathering_observation_method_id) REFERENCES gathering_observation_method(gathering_observation_method_id);


--
-- TOC entry 2321 (class 2606 OID 99084)
-- Dependencies: 1578 1611 2145
-- Name: gathering_original_label_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation
    ADD CONSTRAINT gathering_original_label_fk FOREIGN KEY (original_label_id) REFERENCES original_label(original_label_id);


--
-- TOC entry 2322 (class 2606 OID 99089)
-- Dependencies: 1578 1612 2147
-- Name: gathering_responsible_person_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation
    ADD CONSTRAINT gathering_responsible_person_fk FOREIGN KEY (responsible_person_id) REFERENCES person(person_id);


--
-- TOC entry 2323 (class 2606 OID 99094)
-- Dependencies: 2189 1578 1633
-- Name: gathering_sampling_type_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation
    ADD CONSTRAINT gathering_sampling_type_fk FOREIGN KEY (sampling_type_id) REFERENCES sampling_type(sampling_type_id);


--
-- TOC entry 2324 (class 2606 OID 99099)
-- Dependencies: 1635 1578 2193
-- Name: gathering_site_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation
    ADD CONSTRAINT gathering_site_fk FOREIGN KEY (site_id) REFERENCES site(site_id);


--
-- TOC entry 2336 (class 2606 OID 99104)
-- Dependencies: 1586 1587 2097
-- Name: geographic_layer_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY georeferenced_site
    ADD CONSTRAINT geographic_layer_fk FOREIGN KEY (geographic_layer_id) REFERENCES geographic_layer(geographic_layer_id);


--
-- TOC entry 2338 (class 2606 OID 99109)
-- Dependencies: 1639 1589 2201
-- Name: identification_specimen_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY identification
    ADD CONSTRAINT identification_specimen_fk FOREIGN KEY (specimen_id) REFERENCES specimen(specimen_id);


--
-- TOC entry 2339 (class 2606 OID 99114)
-- Dependencies: 1659 1589 2240
-- Name: identification_taxon_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY identification
    ADD CONSTRAINT identification_taxon_fk FOREIGN KEY (taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2340 (class 2606 OID 99119)
-- Dependencies: 1591 1589 2107
-- Name: identification_type_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY identification
    ADD CONSTRAINT identification_type_fk FOREIGN KEY (identification_type_id) REFERENCES identification_type(identification_type_id);


--
-- TOC entry 2341 (class 2606 OID 99124)
-- Dependencies: 1614 1589 1589 2151 1614
-- Name: identification_valuer_person_profile_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY identification
    ADD CONSTRAINT identification_valuer_person_profile_fk FOREIGN KEY (valuer_person_id, valuer_person_profile_id) REFERENCES person_profile(person_id, profile_id);


--
-- TOC entry 2342 (class 2606 OID 99129)
-- Dependencies: 1592 1592 1592 1589 1589 1589 2103
-- Name: identifier_identification_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY identifier
    ADD CONSTRAINT identifier_identification_fk FOREIGN KEY (specimen_id, identification_sequence, initial_timestamp) REFERENCES identification(specimen_id, identification_sequence, initial_timestamp);


--
-- TOC entry 2343 (class 2606 OID 99134)
-- Dependencies: 2151 1592 1592 1614 1614
-- Name: identifier_person_profile; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY identifier
    ADD CONSTRAINT identifier_person_profile FOREIGN KEY (identifier_person_id, identifier_profile_id) REFERENCES person_profile(person_id, profile_id);


--
-- TOC entry 2344 (class 2606 OID 99139)
-- Dependencies: 1659 1594 2240
-- Name: inmediate_predecessor_history_predecessor_taxon_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY inmediate_predecessor_history
    ADD CONSTRAINT inmediate_predecessor_history_predecessor_taxon_fk FOREIGN KEY (predecessor_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2345 (class 2606 OID 99144)
-- Dependencies: 1659 1594 2240
-- Name: inmediate_predecessor_history_taxon_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY inmediate_predecessor_history
    ADD CONSTRAINT inmediate_predecessor_history_taxon_fk FOREIGN KEY (taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2346 (class 2606 OID 99149)
-- Dependencies: 1677 1594 2276
-- Name: inmediate_predecessor_history_taxonomical_range_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY inmediate_predecessor_history
    ADD CONSTRAINT inmediate_predecessor_history_taxonomical_range_fk FOREIGN KEY (taxon_taxonomical_range_id) REFERENCES taxonomical_range(taxonomical_range_id);


--
-- TOC entry 2391 (class 2606 OID 99154)
-- Dependencies: 1601 1643 2125
-- Name: life_form_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen_life_form
    ADD CONSTRAINT life_form_fk FOREIGN KEY (life_form_id) REFERENCES life_form(life_form_id);


--
-- TOC entry 2393 (class 2606 OID 99159)
-- Dependencies: 1602 1644 2127
-- Name: life_stage_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen_life_stage_sex
    ADD CONSTRAINT life_stage_fk FOREIGN KEY (life_stage_id) REFERENCES life_stage(life_stage_id);


--
-- TOC entry 2349 (class 2606 OID 99164)
-- Dependencies: 1604 1605 2131
-- Name: list_table_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY list_table_collection
    ADD CONSTRAINT list_table_fk FOREIGN KEY (list_table_id) REFERENCES list_table(list_table_id);


--
-- TOC entry 2350 (class 2606 OID 99169)
-- Dependencies: 1614 1606 1606 1614 2151
-- Name: morphological_description_person_profile_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY morphological_description
    ADD CONSTRAINT morphological_description_person_profile_fk FOREIGN KEY (description_person_id, description_profile_id) REFERENCES person_profile(person_id, profile_id);


--
-- TOC entry 2305 (class 2606 OID 99174)
-- Dependencies: 1556 1607 2137
-- Name: natural_region_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY collecting_area
    ADD CONSTRAINT natural_region_fk FOREIGN KEY (natural_region_id) REFERENCES natural_region(natural_region_id);


--
-- TOC entry 2352 (class 2606 OID 99626)
-- Dependencies: 1612 2147 1608
-- Name: nomenclatura_group_person; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY nomenclatural_group
    ADD CONSTRAINT nomenclatura_group_person FOREIGN KEY (certificator_person_id) REFERENCES person(person_id);


--
-- TOC entry 2473 (class 2606 OID 99616)
-- Dependencies: 1608 1689 2139
-- Name: nomenclatural_group_region_nomenclatural_group_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY nomenclatural_group_region
    ADD CONSTRAINT nomenclatural_group_region_nomenclatural_group_fk FOREIGN KEY (nomenclatural_group_id) REFERENCES nomenclatural_group(nomenclatural_group_id);


--
-- TOC entry 2474 (class 2606 OID 99621)
-- Dependencies: 1689 2298 1688
-- Name: nomenclatural_group_region_taxon_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY nomenclatural_group_region
    ADD CONSTRAINT nomenclatural_group_region_taxon_fk FOREIGN KEY (region_id) REFERENCES region(region_id);


--
-- TOC entry 2403 (class 2606 OID 99184)
-- Dependencies: 2230 1653 1654
-- Name: option_option_type_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY system_option
    ADD CONSTRAINT option_option_type_fk FOREIGN KEY (type_id) REFERENCES system_option_type(system_option_type_id);


--
-- TOC entry 2369 (class 2606 OID 99189)
-- Dependencies: 1624 1635 2171
-- Name: original_projection_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY site
    ADD CONSTRAINT original_projection_fk FOREIGN KEY (original_projection_id) REFERENCES projection(projection_id);


--
-- TOC entry 2335 (class 2606 OID 99194)
-- Dependencies: 2169 1583 1623
-- Name: project_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation_project
    ADD CONSTRAINT project_fk FOREIGN KEY (project_id) REFERENCES project(project_id);


--
-- TOC entry 2361 (class 2606 OID 99199)
-- Dependencies: 1625 1626 2175
-- Name: protected_area_type_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY protected_area
    ADD CONSTRAINT protected_area_type_fk FOREIGN KEY (protected_area_type_id) REFERENCES protected_area_type(protected_area_type_id);


--
-- TOC entry 2362 (class 2606 OID 99204)
-- Dependencies: 2055 1628 1564
-- Name: province_country; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY province
    ADD CONSTRAINT province_country FOREIGN KEY (country_id) REFERENCES country(country_id);


--
-- TOC entry 2365 (class 2606 OID 99209)
-- Dependencies: 1630 1631 2183
-- Name: reference_element_value_reference_element_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY reference_element_value
    ADD CONSTRAINT reference_element_value_reference_element_fk FOREIGN KEY (reference_element_id) REFERENCES reference_element(reference_element_id);


--
-- TOC entry 2366 (class 2606 OID 99214)
-- Dependencies: 2181 1631 1629
-- Name: reference_element_value_reference_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY reference_element_value
    ADD CONSTRAINT reference_element_value_reference_fk FOREIGN KEY (reference_id) REFERENCES reference(reference_id);


--
-- TOC entry 2363 (class 2606 OID 99219)
-- Dependencies: 1600 2123 1629
-- Name: reference_language; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY reference
    ADD CONSTRAINT reference_language FOREIGN KEY (language_id) REFERENCES "language"(language_id);


--
-- TOC entry 2364 (class 2606 OID 99224)
-- Dependencies: 1629 1632 2187
-- Name: reference_type_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY reference
    ADD CONSTRAINT reference_type_fk FOREIGN KEY (reference_type_id) REFERENCES reference_type(reference_type_id);


--
-- TOC entry 2394 (class 2606 OID 99229)
-- Dependencies: 1644 1634 2191
-- Name: sex_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen_life_stage_sex
    ADD CONSTRAINT sex_fk FOREIGN KEY (sex_id) REFERENCES sex(sex_id);


--
-- TOC entry 2370 (class 2606 OID 99234)
-- Dependencies: 2195 1635 1636
-- Name: site_calculation_method_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY site
    ADD CONSTRAINT site_calculation_method_fk FOREIGN KEY (site_calculation_method_id) REFERENCES site_calculation_method(site_calculation_method_id);


--
-- TOC entry 2371 (class 2606 OID 99239)
-- Dependencies: 1635 1637 2193
-- Name: site_coordinate_site; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY site_coordinate
    ADD CONSTRAINT site_coordinate_site FOREIGN KEY (site_id) REFERENCES site(site_id);


--
-- TOC entry 2337 (class 2606 OID 99244)
-- Dependencies: 1635 1587 2193
-- Name: site_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY georeferenced_site
    ADD CONSTRAINT site_fk FOREIGN KEY (site_id) REFERENCES site(site_id);


--
-- TOC entry 2443 (class 2606 OID 99249)
-- Dependencies: 1614 1669 1669 1614 2151
-- Name: species_record_person_profile_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_description_person_profile
    ADD CONSTRAINT species_record_person_profile_fk FOREIGN KEY (person_id, profile_id) REFERENCES person_profile(person_id, profile_id);


--
-- TOC entry 2387 (class 2606 OID 99254)
-- Dependencies: 1550 1640 2027
-- Name: specimen_annotation_annotation_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen_annotation
    ADD CONSTRAINT specimen_annotation_annotation_fk FOREIGN KEY (annotation_id) REFERENCES annotation(annotation_id);


--
-- TOC entry 2388 (class 2606 OID 99259)
-- Dependencies: 1639 1640 2201
-- Name: specimen_annotation_specimen_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen_annotation
    ADD CONSTRAINT specimen_annotation_specimen_fk FOREIGN KEY (specimen_id) REFERENCES specimen(specimen_id);


--
-- TOC entry 2375 (class 2606 OID 99264)
-- Dependencies: 1641 1639 2205
-- Name: specimen_category_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen
    ADD CONSTRAINT specimen_category_fk FOREIGN KEY (specimen_category_id) REFERENCES specimen_category(specimen_category_id);


--
-- TOC entry 2376 (class 2606 OID 99274)
-- Dependencies: 1557 1639 2041
-- Name: specimen_collection_fk2; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen
    ADD CONSTRAINT specimen_collection_fk2 FOREIGN KEY (collection_id) REFERENCES collection(collection_id);


--
-- TOC entry 2377 (class 2606 OID 99279)
-- Dependencies: 1639 1576 2079
-- Name: specimen_extraction_type_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen
    ADD CONSTRAINT specimen_extraction_type_fk FOREIGN KEY (extration_type_id) REFERENCES extraction_type(extraction_type_id);


--
-- TOC entry 2395 (class 2606 OID 99284)
-- Dependencies: 2201 1644 1639
-- Name: specimen_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen_life_stage_sex
    ADD CONSTRAINT specimen_fk FOREIGN KEY (specimen_id) REFERENCES specimen(specimen_id);


--
-- TOC entry 2392 (class 2606 OID 99289)
-- Dependencies: 1639 1643 2201
-- Name: specimen_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen_life_form
    ADD CONSTRAINT specimen_fk FOREIGN KEY (specimen_id) REFERENCES specimen(specimen_id);


--
-- TOC entry 2389 (class 2606 OID 99294)
-- Dependencies: 1639 1642 2201
-- Name: specimen_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen_description
    ADD CONSTRAINT specimen_fk FOREIGN KEY (specimen_id) REFERENCES specimen(specimen_id);


--
-- TOC entry 2378 (class 2606 OID 99304)
-- Dependencies: 1578 1639 2083
-- Name: specimen_gathering_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen
    ADD CONSTRAINT specimen_gathering_fk FOREIGN KEY (gathering_observation_id) REFERENCES gathering_observation(gathering_observation_id);


--
-- TOC entry 2379 (class 2606 OID 99309)
-- Dependencies: 1602 1639 2127
-- Name: specimen_life_stage_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen
    ADD CONSTRAINT specimen_life_stage_fk FOREIGN KEY (life_stage_id) REFERENCES life_stage(life_stage_id);


--
-- TOC entry 2380 (class 2606 OID 99314)
-- Dependencies: 1606 1639 2135
-- Name: specimen_morphological_description_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen
    ADD CONSTRAINT specimen_morphological_description_fk FOREIGN KEY (morphological_description_id) REFERENCES morphological_description(morphological_description_id);


--
-- TOC entry 2381 (class 2606 OID 99319)
-- Dependencies: 1610 1639 2143
-- Name: specimen_origin_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen
    ADD CONSTRAINT specimen_origin_fk FOREIGN KEY (origin_id) REFERENCES origin(origin_id);


--
-- TOC entry 2382 (class 2606 OID 99324)
-- Dependencies: 2165 1639 1621
-- Name: specimen_preservation_medium_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen
    ADD CONSTRAINT specimen_preservation_medium_fk FOREIGN KEY (preservation_medium_id) REFERENCES preservation_medium(preservation_medium_id);


--
-- TOC entry 2383 (class 2606 OID 99329)
-- Dependencies: 2191 1639 1634
-- Name: specimen_sex_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen
    ADD CONSTRAINT specimen_sex_fk FOREIGN KEY (sex_id) REFERENCES sex(sex_id);


--
-- TOC entry 2384 (class 2606 OID 99334)
-- Dependencies: 1639 1650 2222
-- Name: specimen_storage_type_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen
    ADD CONSTRAINT specimen_storage_type_fk FOREIGN KEY (storage_type_id) REFERENCES storage_type(storage_type_id);


--
-- TOC entry 2385 (class 2606 OID 99339)
-- Dependencies: 2224 1639 1651
-- Name: specimen_substrate_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen
    ADD CONSTRAINT specimen_substrate_fk FOREIGN KEY (substrate_id) REFERENCES substrate(substrate_id);


--
-- TOC entry 2386 (class 2606 OID 99344)
-- Dependencies: 1645 1639 2211
-- Name: specimen_type_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen
    ADD CONSTRAINT specimen_type_fk FOREIGN KEY (specimen_type_id) REFERENCES specimen_type(specimen_type_id);


--
-- TOC entry 2396 (class 2606 OID 99349)
-- Dependencies: 1646 1647 2213
-- Name: specimen_variable_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen_variable_value
    ADD CONSTRAINT specimen_variable_fk FOREIGN KEY (specimen_variable_id) REFERENCES specimen_variable(specimen_variable_id);


--
-- TOC entry 2390 (class 2606 OID 99540)
-- Dependencies: 1642 2215 1647
-- Name: specimen_variable_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen_description
    ADD CONSTRAINT specimen_variable_fk FOREIGN KEY (specimen_variable_value_id) REFERENCES specimen_variable_value(specimen_variable_value_id);


--
-- TOC entry 2397 (class 2606 OID 99359)
-- Dependencies: 1672 1648 2266
-- Name: stage_transition_date_taxon_description_stage_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY stage_transition_date
    ADD CONSTRAINT stage_transition_date_taxon_description_stage_fk FOREIGN KEY (taxon_description_stage_id) REFERENCES taxon_description_stage(taxon_description_stage_id);


--
-- TOC entry 2401 (class 2606 OID 99364)
-- Dependencies: 1655 1652 2232
-- Name: subsystem_module_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY system_module
    ADD CONSTRAINT subsystem_module_fk FOREIGN KEY (subsystem_id) REFERENCES system_subsystem(subsystem_id) ON DELETE RESTRICT;


--
-- TOC entry 2406 (class 2606 OID 99369)
-- Dependencies: 1653 1657 2228
-- Name: system_option_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY system_user_option
    ADD CONSTRAINT system_option_fk FOREIGN KEY (option_id) REFERENCES system_option(option_id);


--
-- TOC entry 2407 (class 2606 OID 99374)
-- Dependencies: 1656 1657 2234
-- Name: system_user_fr; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY system_user_option
    ADD CONSTRAINT system_user_fr FOREIGN KEY (user_id) REFERENCES system_user(user_id) ON DELETE CASCADE;


--
-- TOC entry 2444 (class 2606 OID 99379)
-- Dependencies: 2248 1669 1669 1663 1663
-- Name: taxon_description_person_profile_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_description_person_profile
    ADD CONSTRAINT taxon_description_person_profile_fk FOREIGN KEY (taxon_id, taxon_description_sequence) REFERENCES taxon_description(taxon_id, taxon_description_sequence);


--
-- TOC entry 2447 (class 2606 OID 99384)
-- Dependencies: 1671 1629 2181
-- Name: taxon_description_record_reference_reference_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_description_record_reference
    ADD CONSTRAINT taxon_description_record_reference_reference_fk FOREIGN KEY (reference_id) REFERENCES reference(reference_id);


--
-- TOC entry 2448 (class 2606 OID 99389)
-- Dependencies: 2262 1671 1670
-- Name: taxon_description_record_reference_taxon_description_record_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_description_record_reference
    ADD CONSTRAINT taxon_description_record_reference_taxon_description_record_fk FOREIGN KEY (taxon_description_record_id) REFERENCES taxon_description_record(taxon_description_record_id);


--
-- TOC entry 2445 (class 2606 OID 99394)
-- Dependencies: 1667 1670 2256
-- Name: taxon_description_record_taxon_description_element_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_description_record
    ADD CONSTRAINT taxon_description_record_taxon_description_element_fk FOREIGN KEY (taxon_description_element_id) REFERENCES taxon_description_element(taxon_description_element_id);


--
-- TOC entry 2446 (class 2606 OID 99399)
-- Dependencies: 1663 1670 1670 1663 2248
-- Name: taxon_description_record_taxon_description_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_description_record
    ADD CONSTRAINT taxon_description_record_taxon_description_fk FOREIGN KEY (taxon_id, taxon_description_sequence) REFERENCES taxon_description(taxon_id, taxon_description_sequence);


--
-- TOC entry 2442 (class 2606 OID 99404)
-- Dependencies: 1663 1668 1668 1663 2248
-- Name: taxon_description_species_record_institution; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_description_institution
    ADD CONSTRAINT taxon_description_species_record_institution FOREIGN KEY (taxon_id, taxon_description_sequence) REFERENCES taxon_description(taxon_id, taxon_description_sequence);


--
-- TOC entry 2438 (class 2606 OID 99409)
-- Dependencies: 1672 1663 2266
-- Name: taxon_description_stage_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_description
    ADD CONSTRAINT taxon_description_stage_fk FOREIGN KEY (taxon_description_stage_id) REFERENCES taxon_description_stage(taxon_description_stage_id);


--
-- TOC entry 2398 (class 2606 OID 99414)
-- Dependencies: 1663 1648 1648 1663 2248
-- Name: taxon_description_stage_transition_date_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY stage_transition_date
    ADD CONSTRAINT taxon_description_stage_transition_date_fk FOREIGN KEY (taxon_id, taxon_description_sequence) REFERENCES taxon_description(taxon_id, taxon_description_sequence);


--
-- TOC entry 2439 (class 2606 OID 99419)
-- Dependencies: 1663 2240 1659
-- Name: taxon_description_taxon_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_description
    ADD CONSTRAINT taxon_description_taxon_fk FOREIGN KEY (taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2449 (class 2606 OID 99424)
-- Dependencies: 1674 2139 1608
-- Name: taxon_nomenclatural_group_nomenclatural_group_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_nomenclatural_group
    ADD CONSTRAINT taxon_nomenclatural_group_nomenclatural_group_fk FOREIGN KEY (nomenclatural_group_id) REFERENCES nomenclatural_group(nomenclatural_group_id);


--
-- TOC entry 2450 (class 2606 OID 99429)
-- Dependencies: 1674 1659 2240
-- Name: taxon_nomenclatural_group_taxon_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_nomenclatural_group
    ADD CONSTRAINT taxon_nomenclatural_group_taxon_fk FOREIGN KEY (taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2451 (class 2606 OID 99434)
-- Dependencies: 1629 2181 1675
-- Name: taxon_reference_reference_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_reference
    ADD CONSTRAINT taxon_reference_reference_fk FOREIGN KEY (reference_id) REFERENCES reference(reference_id);


--
-- TOC entry 2452 (class 2606 OID 99439)
-- Dependencies: 2240 1675 1659
-- Name: taxon_reference_taxon_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_reference
    ADD CONSTRAINT taxon_reference_taxon_fk FOREIGN KEY (taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2455 (class 2606 OID 99444)
-- Dependencies: 1639 2201 1679
-- Name: transacted_specimen_specimen_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY transacted_specimen
    ADD CONSTRAINT transacted_specimen_specimen_fk FOREIGN KEY (specimen_id) REFERENCES specimen(specimen_id);


--
-- TOC entry 2456 (class 2606 OID 99449)
-- Dependencies: 1679 1680 2282
-- Name: transacted_specimen_status_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY transacted_specimen
    ADD CONSTRAINT transacted_specimen_status_fk FOREIGN KEY (transacted_specimen_status_id) REFERENCES transacted_specimen_status(transacted_specimen_status_id);


--
-- TOC entry 2457 (class 2606 OID 99454)
-- Dependencies: 1681 1679 2284
-- Name: transacted_specimen_transaction_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY transacted_specimen
    ADD CONSTRAINT transacted_specimen_transaction_fk FOREIGN KEY (transaction_id) REFERENCES "transaction"(transaction_id);


--
-- TOC entry 2458 (class 2606 OID 99459)
-- Dependencies: 1682 2286 1679
-- Name: transacted_specimen_type_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY transacted_specimen
    ADD CONSTRAINT transacted_specimen_type_fk FOREIGN KEY (transaction_type_id) REFERENCES transaction_type(transaction_type_id);


--
-- TOC entry 2459 (class 2606 OID 99464)
-- Dependencies: 2041 1557 1681
-- Name: transaction_collection_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY "transaction"
    ADD CONSTRAINT transaction_collection_fk FOREIGN KEY (collection_id) REFERENCES collection(collection_id);


--
-- TOC entry 2460 (class 2606 OID 99469)
-- Dependencies: 1681 2115 1595
-- Name: transaction_receiver_institution_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY "transaction"
    ADD CONSTRAINT transaction_receiver_institution_fk FOREIGN KEY (receiver_institution_id) REFERENCES institution(institution_id);


--
-- TOC entry 2461 (class 2606 OID 99474)
-- Dependencies: 1612 2147 1681
-- Name: transaction_receiver_person_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY "transaction"
    ADD CONSTRAINT transaction_receiver_person_id FOREIGN KEY (receiver_person_id) REFERENCES person(person_id);


--
-- TOC entry 2462 (class 2606 OID 99479)
-- Dependencies: 1595 1681 2115
-- Name: transaction_sender_institution_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY "transaction"
    ADD CONSTRAINT transaction_sender_institution_id FOREIGN KEY (sender_institution_id) REFERENCES institution(institution_id);


--
-- TOC entry 2463 (class 2606 OID 99484)
-- Dependencies: 1681 2147 1612
-- Name: transaction_sender_person_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY "transaction"
    ADD CONSTRAINT transaction_sender_person_fk FOREIGN KEY (sender_person_id) REFERENCES person(person_id);


--
-- TOC entry 2464 (class 2606 OID 99489)
-- Dependencies: 1681 2286 1682
-- Name: transaction_type_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY "transaction"
    ADD CONSTRAINT transaction_type_fk FOREIGN KEY (transaction_type_id) REFERENCES transaction_type(transaction_type_id);


--
-- TOC entry 2465 (class 2606 OID 99494)
-- Dependencies: 2115 1683 1595
-- Name: type_specimen_institution_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY type_specimen
    ADD CONSTRAINT type_specimen_institution_fk FOREIGN KEY (institution_id) REFERENCES institution(institution_id);


--
-- TOC entry 2466 (class 2606 OID 99499)
-- Dependencies: 2201 1639 1683
-- Name: type_specimen_specimen_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY type_specimen
    ADD CONSTRAINT type_specimen_specimen_fk FOREIGN KEY (specimen_id) REFERENCES specimen(specimen_id);


--
-- TOC entry 2467 (class 2606 OID 99504)
-- Dependencies: 1683 1659 2240
-- Name: type_specimen_taxon_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY type_specimen
    ADD CONSTRAINT type_specimen_taxon_fk FOREIGN KEY (taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2468 (class 2606 OID 99509)
-- Dependencies: 1683 1684 2290
-- Name: type_specimen_type_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY type_specimen
    ADD CONSTRAINT type_specimen_type_fk FOREIGN KEY (type_specimen_type_id) REFERENCES type_specimen_type(type_specimen_type_id);


--
-- TOC entry 2404 (class 2606 OID 99514)
-- Dependencies: 2234 1656 1656
-- Name: user_group_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY system_user
    ADD CONSTRAINT user_group_fk FOREIGN KEY (user_group_id) REFERENCES system_user(user_id);


--
-- TOC entry 2470 (class 2606 OID 99557)
-- Dependencies: 1686 1608 2139
-- Name: user_nomenclatural_group_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY user_nomenclatural_group
    ADD CONSTRAINT user_nomenclatural_group_fk FOREIGN KEY (nomenclatural_group_id) REFERENCES nomenclatural_group(nomenclatural_group_id);


--
-- TOC entry 2469 (class 2606 OID 99552)
-- Dependencies: 2234 1656 1686
-- Name: user_nomenclatural_group_user_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY user_nomenclatural_group
    ADD CONSTRAINT user_nomenclatural_group_user_fk FOREIGN KEY (user_id) REFERENCES system_user(user_id);


--
-- TOC entry 2471 (class 2606 OID 99576)
-- Dependencies: 1659 2240 1687
-- Name: user_taxon_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY user_taxon
    ADD CONSTRAINT user_taxon_fk FOREIGN KEY (taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2472 (class 2606 OID 99581)
-- Dependencies: 2234 1687 1656
-- Name: user_taxon_user_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY user_taxon
    ADD CONSTRAINT user_taxon_user_fk FOREIGN KEY (user_id) REFERENCES system_user(user_id);


--
-- TOC entry 2405 (class 2606 OID 99519)
-- Dependencies: 1658 2238 1656
-- Name: user_type_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY system_user
    ADD CONSTRAINT user_type_fk FOREIGN KEY (user_type_id) REFERENCES system_user_type(user_type_id);


--
-- TOC entry 2351 (class 2606 OID 99524)
-- Dependencies: 1607 1685 2292
-- Name: versant_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY natural_region
    ADD CONSTRAINT versant_fk FOREIGN KEY (versant_id) REFERENCES versant(versant_id);


--
-- TOC entry 2478 (class 0 OID 0)
-- Dependencies: 6
-- Name: ara; Type: ACL; Schema: -; Owner: ara
--

REVOKE ALL ON SCHEMA ara FROM PUBLIC;
REVOKE ALL ON SCHEMA ara FROM ara;
GRANT ALL ON SCHEMA ara TO ara;
GRANT ALL ON SCHEMA ara TO postgres;


--
-- TOC entry 2479 (class 0 OID 0)
-- Dependencies: 1549
-- Name: altitude_floor; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE altitude_floor FROM PUBLIC;
REVOKE ALL ON TABLE altitude_floor FROM ara;
GRANT ALL ON TABLE altitude_floor TO ara;
GRANT ALL ON TABLE altitude_floor TO postgres;


--
-- TOC entry 2480 (class 0 OID 0)
-- Dependencies: 1550
-- Name: annotation; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE annotation FROM PUBLIC;
REVOKE ALL ON TABLE annotation FROM ara;
GRANT ALL ON TABLE annotation TO ara;
GRANT ALL ON TABLE annotation TO postgres;


--
-- TOC entry 2481 (class 0 OID 0)
-- Dependencies: 1551
-- Name: audience; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE audience FROM PUBLIC;
REVOKE ALL ON TABLE audience FROM ara;
GRANT ALL ON TABLE audience TO ara;
GRANT ALL ON TABLE audience TO postgres;


--
-- TOC entry 2482 (class 0 OID 0)
-- Dependencies: 1552
-- Name: base_projection; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE base_projection FROM PUBLIC;
REVOKE ALL ON TABLE base_projection FROM ara;
GRANT ALL ON TABLE base_projection TO ara;
GRANT ALL ON TABLE base_projection TO postgres;


--
-- TOC entry 2483 (class 0 OID 0)
-- Dependencies: 1553
-- Name: biotic_unit; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE biotic_unit FROM PUBLIC;
REVOKE ALL ON TABLE biotic_unit FROM ara;
GRANT ALL ON TABLE biotic_unit TO ara;
GRANT ALL ON TABLE biotic_unit TO PUBLIC;


--
-- TOC entry 2484 (class 0 OID 0)
-- Dependencies: 1554
-- Name: canton; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE canton FROM PUBLIC;
REVOKE ALL ON TABLE canton FROM ara;
GRANT ALL ON TABLE canton TO ara;
GRANT ALL ON TABLE canton TO PUBLIC;


--
-- TOC entry 2485 (class 0 OID 0)
-- Dependencies: 1555
-- Name: canton_ifam; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE canton_ifam FROM PUBLIC;
REVOKE ALL ON TABLE canton_ifam FROM ara;
GRANT ALL ON TABLE canton_ifam TO ara;
GRANT ALL ON TABLE canton_ifam TO PUBLIC;


--
-- TOC entry 2486 (class 0 OID 0)
-- Dependencies: 1556
-- Name: collecting_area; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE collecting_area FROM PUBLIC;
REVOKE ALL ON TABLE collecting_area FROM ara;
GRANT ALL ON TABLE collecting_area TO ara;
GRANT ALL ON TABLE collecting_area TO PUBLIC;


--
-- TOC entry 2487 (class 0 OID 0)
-- Dependencies: 1557
-- Name: collection; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE collection FROM PUBLIC;
REVOKE ALL ON TABLE collection FROM ara;
GRANT ALL ON TABLE collection TO ara;
GRANT ALL ON TABLE collection TO postgres;


--
-- TOC entry 2488 (class 0 OID 0)
-- Dependencies: 1558
-- Name: collection_protocol; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE collection_protocol FROM PUBLIC;
REVOKE ALL ON TABLE collection_protocol FROM ara;
GRANT ALL ON TABLE collection_protocol TO ara;
GRANT ALL ON TABLE collection_protocol TO postgres;


--
-- TOC entry 2489 (class 0 OID 0)
-- Dependencies: 1559
-- Name: collector_observer; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE collector_observer FROM PUBLIC;
REVOKE ALL ON TABLE collector_observer FROM ara;
GRANT ALL ON TABLE collector_observer TO ara;


--
-- TOC entry 2490 (class 0 OID 0)
-- Dependencies: 1560
-- Name: component; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE component FROM PUBLIC;
REVOKE ALL ON TABLE component FROM ara;
GRANT ALL ON TABLE component TO ara;
GRANT ALL ON TABLE component TO postgres;


--
-- TOC entry 2491 (class 0 OID 0)
-- Dependencies: 1561
-- Name: component_part; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE component_part FROM PUBLIC;
REVOKE ALL ON TABLE component_part FROM ara;
GRANT ALL ON TABLE component_part TO ara;
GRANT ALL ON TABLE component_part TO postgres;


--
-- TOC entry 2492 (class 0 OID 0)
-- Dependencies: 1562
-- Name: concept; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE concept FROM PUBLIC;
REVOKE ALL ON TABLE concept FROM ara;
GRANT ALL ON TABLE concept TO ara;
GRANT ALL ON TABLE concept TO postgres;


--
-- TOC entry 2493 (class 0 OID 0)
-- Dependencies: 1563
-- Name: conservation_area; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE conservation_area FROM PUBLIC;
REVOKE ALL ON TABLE conservation_area FROM ara;
GRANT ALL ON TABLE conservation_area TO ara;
GRANT ALL ON TABLE conservation_area TO PUBLIC;


--
-- TOC entry 2494 (class 0 OID 0)
-- Dependencies: 1564
-- Name: country; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE country FROM PUBLIC;
REVOKE ALL ON TABLE country FROM ara;
GRANT ALL ON TABLE country TO ara;
GRANT ALL ON TABLE country TO postgres;


--
-- TOC entry 2495 (class 0 OID 0)
-- Dependencies: 1565
-- Name: culture; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE culture FROM PUBLIC;
REVOKE ALL ON TABLE culture FROM ara;
GRANT ALL ON TABLE culture TO ara;
GRANT ALL ON TABLE culture TO postgres;


--
-- TOC entry 2496 (class 0 OID 0)
-- Dependencies: 1566
-- Name: culture_medium; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE culture_medium FROM PUBLIC;
REVOKE ALL ON TABLE culture_medium FROM ara;
GRANT ALL ON TABLE culture_medium TO ara;
GRANT ALL ON TABLE culture_medium TO postgres;


--
-- TOC entry 2497 (class 0 OID 0)
-- Dependencies: 1567
-- Name: culture_storage_medium; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE culture_storage_medium FROM PUBLIC;
REVOKE ALL ON TABLE culture_storage_medium FROM ara;
GRANT ALL ON TABLE culture_storage_medium TO ara;
GRANT ALL ON TABLE culture_storage_medium TO postgres;


--
-- TOC entry 2498 (class 0 OID 0)
-- Dependencies: 1568
-- Name: determination_type; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE determination_type FROM PUBLIC;
REVOKE ALL ON TABLE determination_type FROM ara;
GRANT ALL ON TABLE determination_type TO ara;
GRANT ALL ON TABLE determination_type TO postgres;


--
-- TOC entry 2499 (class 0 OID 0)
-- Dependencies: 1569
-- Name: district; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE district FROM PUBLIC;
REVOKE ALL ON TABLE district FROM ara;
GRANT ALL ON TABLE district TO ara;
GRANT ALL ON TABLE district TO PUBLIC;


--
-- TOC entry 2500 (class 0 OID 0)
-- Dependencies: 1570
-- Name: ecological_region; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE ecological_region FROM PUBLIC;
REVOKE ALL ON TABLE ecological_region FROM ara;
GRANT ALL ON TABLE ecological_region TO ara;
GRANT ALL ON TABLE ecological_region TO PUBLIC;


--
-- TOC entry 2501 (class 0 OID 0)
-- Dependencies: 1571
-- Name: ecological_variable; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE ecological_variable FROM PUBLIC;
REVOKE ALL ON TABLE ecological_variable FROM ara;
GRANT ALL ON TABLE ecological_variable TO ara;
GRANT ALL ON TABLE ecological_variable TO postgres;


--
-- TOC entry 2502 (class 0 OID 0)
-- Dependencies: 1572
-- Name: ecological_variable_value; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE ecological_variable_value FROM PUBLIC;
REVOKE ALL ON TABLE ecological_variable_value FROM ara;
GRANT ALL ON TABLE ecological_variable_value TO ara;
GRANT ALL ON TABLE ecological_variable_value TO postgres;


--
-- TOC entry 2503 (class 0 OID 0)
-- Dependencies: 1573
-- Name: ecosystem; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE ecosystem FROM PUBLIC;
REVOKE ALL ON TABLE ecosystem FROM ara;
GRANT ALL ON TABLE ecosystem TO ara;
GRANT ALL ON TABLE ecosystem TO PUBLIC;


--
-- TOC entry 2504 (class 0 OID 0)
-- Dependencies: 1574
-- Name: elevation_band; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE elevation_band FROM PUBLIC;
REVOKE ALL ON TABLE elevation_band FROM ara;
GRANT ALL ON TABLE elevation_band TO ara;
GRANT ALL ON TABLE elevation_band TO PUBLIC;


--
-- TOC entry 2505 (class 0 OID 0)
-- Dependencies: 1575
-- Name: exposition; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE exposition FROM PUBLIC;
REVOKE ALL ON TABLE exposition FROM ara;
GRANT ALL ON TABLE exposition TO ara;
GRANT ALL ON TABLE exposition TO postgres;


--
-- TOC entry 2506 (class 0 OID 0)
-- Dependencies: 1576
-- Name: extraction_type; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE extraction_type FROM PUBLIC;
REVOKE ALL ON TABLE extraction_type FROM ara;
GRANT ALL ON TABLE extraction_type TO ara;
GRANT ALL ON TABLE extraction_type TO postgres;


--
-- TOC entry 2507 (class 0 OID 0)
-- Dependencies: 1577
-- Name: feature_type; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE feature_type FROM PUBLIC;
REVOKE ALL ON TABLE feature_type FROM ara;
GRANT ALL ON TABLE feature_type TO ara;
GRANT ALL ON TABLE feature_type TO postgres;


--
-- TOC entry 2508 (class 0 OID 0)
-- Dependencies: 1578
-- Name: gathering_observation; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE gathering_observation FROM PUBLIC;
REVOKE ALL ON TABLE gathering_observation FROM ara;
GRANT ALL ON TABLE gathering_observation TO ara;


--
-- TOC entry 2509 (class 0 OID 0)
-- Dependencies: 1579
-- Name: gathering_observation_collection; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE gathering_observation_collection FROM PUBLIC;
REVOKE ALL ON TABLE gathering_observation_collection FROM ara;
GRANT ALL ON TABLE gathering_observation_collection TO ara;


--
-- TOC entry 2510 (class 0 OID 0)
-- Dependencies: 1580
-- Name: gathering_observation_detail; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE gathering_observation_detail FROM PUBLIC;
REVOKE ALL ON TABLE gathering_observation_detail FROM ara;
GRANT ALL ON TABLE gathering_observation_detail TO ara;


--
-- TOC entry 2511 (class 0 OID 0)
-- Dependencies: 1581
-- Name: gathering_observation_ecological_var; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE gathering_observation_ecological_var FROM PUBLIC;
REVOKE ALL ON TABLE gathering_observation_ecological_var FROM ara;
GRANT ALL ON TABLE gathering_observation_ecological_var TO ara;
GRANT ALL ON TABLE gathering_observation_ecological_var TO postgres;


--
-- TOC entry 2512 (class 0 OID 0)
-- Dependencies: 1582
-- Name: gathering_observation_method; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE gathering_observation_method FROM PUBLIC;
REVOKE ALL ON TABLE gathering_observation_method FROM ara;
GRANT ALL ON TABLE gathering_observation_method TO ara;


--
-- TOC entry 2513 (class 0 OID 0)
-- Dependencies: 1583
-- Name: gathering_observation_project; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE gathering_observation_project FROM PUBLIC;
REVOKE ALL ON TABLE gathering_observation_project FROM ara;
GRANT ALL ON TABLE gathering_observation_project TO ara;
GRANT ALL ON TABLE gathering_observation_project TO postgres;


--
-- TOC entry 2514 (class 0 OID 0)
-- Dependencies: 1584
-- Name: geographic_catalogue; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE geographic_catalogue FROM PUBLIC;
REVOKE ALL ON TABLE geographic_catalogue FROM ara;
GRANT ALL ON TABLE geographic_catalogue TO ara;
GRANT ALL ON TABLE geographic_catalogue TO postgres;


--
-- TOC entry 2515 (class 0 OID 0)
-- Dependencies: 1585
-- Name: geographic_entity; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE geographic_entity FROM PUBLIC;
REVOKE ALL ON TABLE geographic_entity FROM ara;
GRANT ALL ON TABLE geographic_entity TO ara;
GRANT ALL ON TABLE geographic_entity TO postgres;


--
-- TOC entry 2516 (class 0 OID 0)
-- Dependencies: 1586
-- Name: geographic_layer; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE geographic_layer FROM PUBLIC;
REVOKE ALL ON TABLE geographic_layer FROM ara;
GRANT ALL ON TABLE geographic_layer TO ara;
GRANT ALL ON TABLE geographic_layer TO PUBLIC;


--
-- TOC entry 2517 (class 0 OID 0)
-- Dependencies: 1587
-- Name: georeferenced_site; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE georeferenced_site FROM PUBLIC;
REVOKE ALL ON TABLE georeferenced_site FROM ara;
GRANT ALL ON TABLE georeferenced_site TO ara;
GRANT ALL ON TABLE georeferenced_site TO PUBLIC;


--
-- TOC entry 2518 (class 0 OID 0)
-- Dependencies: 1588
-- Name: id_gen; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE id_gen FROM PUBLIC;
REVOKE ALL ON TABLE id_gen FROM ara;
GRANT ALL ON TABLE id_gen TO ara;


--
-- TOC entry 2519 (class 0 OID 0)
-- Dependencies: 1589
-- Name: identification; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE identification FROM PUBLIC;
REVOKE ALL ON TABLE identification FROM ara;
GRANT ALL ON TABLE identification TO ara;
GRANT ALL ON TABLE identification TO postgres;


--
-- TOC entry 2520 (class 0 OID 0)
-- Dependencies: 1590
-- Name: identification_history; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE identification_history FROM PUBLIC;
REVOKE ALL ON TABLE identification_history FROM ara;
GRANT ALL ON TABLE identification_history TO ara;
GRANT ALL ON TABLE identification_history TO postgres;


--
-- TOC entry 2521 (class 0 OID 0)
-- Dependencies: 1591
-- Name: identification_type; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE identification_type FROM PUBLIC;
REVOKE ALL ON TABLE identification_type FROM ara;
GRANT ALL ON TABLE identification_type TO ara;
GRANT ALL ON TABLE identification_type TO postgres;


--
-- TOC entry 2522 (class 0 OID 0)
-- Dependencies: 1592
-- Name: identifier; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE identifier FROM PUBLIC;
REVOKE ALL ON TABLE identifier FROM ara;
GRANT ALL ON TABLE identifier TO ara;
GRANT ALL ON TABLE identifier TO postgres;


--
-- TOC entry 2523 (class 0 OID 0)
-- Dependencies: 1593
-- Name: identifier_history; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE identifier_history FROM PUBLIC;
REVOKE ALL ON TABLE identifier_history FROM ara;
GRANT ALL ON TABLE identifier_history TO ara;
GRANT ALL ON TABLE identifier_history TO postgres;


--
-- TOC entry 2524 (class 0 OID 0)
-- Dependencies: 1594
-- Name: inmediate_predecessor_history; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE inmediate_predecessor_history FROM PUBLIC;
REVOKE ALL ON TABLE inmediate_predecessor_history FROM ara;
GRANT ALL ON TABLE inmediate_predecessor_history TO ara;
GRANT ALL ON TABLE inmediate_predecessor_history TO postgres;


--
-- TOC entry 2525 (class 0 OID 0)
-- Dependencies: 1595
-- Name: institution; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE institution FROM PUBLIC;
REVOKE ALL ON TABLE institution FROM ara;
GRANT ALL ON TABLE institution TO ara;
GRANT ALL ON TABLE institution TO postgres;


--
-- TOC entry 2526 (class 0 OID 0)
-- Dependencies: 1596
-- Name: interaction_type; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE interaction_type FROM PUBLIC;
REVOKE ALL ON TABLE interaction_type FROM ara;
GRANT ALL ON TABLE interaction_type TO ara;
GRANT ALL ON TABLE interaction_type TO postgres;


--
-- TOC entry 2527 (class 0 OID 0)
-- Dependencies: 1597
-- Name: label; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE label FROM PUBLIC;
REVOKE ALL ON TABLE label FROM ara;
GRANT ALL ON TABLE label TO ara;
GRANT ALL ON TABLE label TO postgres;


--
-- TOC entry 2528 (class 0 OID 0)
-- Dependencies: 1598
-- Name: label_history; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE label_history FROM PUBLIC;
REVOKE ALL ON TABLE label_history FROM ara;
GRANT ALL ON TABLE label_history TO ara;
GRANT ALL ON TABLE label_history TO postgres;


--
-- TOC entry 2529 (class 0 OID 0)
-- Dependencies: 1599
-- Name: land_cover; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE land_cover FROM PUBLIC;
REVOKE ALL ON TABLE land_cover FROM ara;
GRANT ALL ON TABLE land_cover TO ara;
GRANT ALL ON TABLE land_cover TO PUBLIC;


--
-- TOC entry 2530 (class 0 OID 0)
-- Dependencies: 1600
-- Name: language; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE "language" FROM PUBLIC;
REVOKE ALL ON TABLE "language" FROM ara;
GRANT ALL ON TABLE "language" TO ara;
GRANT ALL ON TABLE "language" TO postgres;


--
-- TOC entry 2531 (class 0 OID 0)
-- Dependencies: 1601
-- Name: life_form; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE life_form FROM PUBLIC;
REVOKE ALL ON TABLE life_form FROM ara;
GRANT ALL ON TABLE life_form TO ara;
GRANT ALL ON TABLE life_form TO postgres;


--
-- TOC entry 2532 (class 0 OID 0)
-- Dependencies: 1602
-- Name: life_stage; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE life_stage FROM PUBLIC;
REVOKE ALL ON TABLE life_stage FROM ara;
GRANT ALL ON TABLE life_stage TO ara;
GRANT ALL ON TABLE life_stage TO postgres;


--
-- TOC entry 2533 (class 0 OID 0)
-- Dependencies: 1603
-- Name: life_zone; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE life_zone FROM PUBLIC;
REVOKE ALL ON TABLE life_zone FROM ara;
GRANT ALL ON TABLE life_zone TO ara;
GRANT ALL ON TABLE life_zone TO PUBLIC;


--
-- TOC entry 2534 (class 0 OID 0)
-- Dependencies: 1606
-- Name: morphological_description; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE morphological_description FROM PUBLIC;
REVOKE ALL ON TABLE morphological_description FROM ara;
GRANT ALL ON TABLE morphological_description TO ara;
GRANT ALL ON TABLE morphological_description TO postgres;


--
-- TOC entry 2535 (class 0 OID 0)
-- Dependencies: 1607
-- Name: natural_region; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE natural_region FROM PUBLIC;
REVOKE ALL ON TABLE natural_region FROM ara;
GRANT ALL ON TABLE natural_region TO ara;
GRANT ALL ON TABLE natural_region TO PUBLIC;


--
-- TOC entry 2536 (class 0 OID 0)
-- Dependencies: 1608
-- Name: nomenclatural_group; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE nomenclatural_group FROM PUBLIC;
REVOKE ALL ON TABLE nomenclatural_group FROM ara;
GRANT ALL ON TABLE nomenclatural_group TO ara;
GRANT ALL ON TABLE nomenclatural_group TO postgres;


--
-- TOC entry 2537 (class 0 OID 0)
-- Dependencies: 1689
-- Name: nomenclatural_group_region; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE nomenclatural_group_region FROM PUBLIC;
REVOKE ALL ON TABLE nomenclatural_group_region FROM ara;
GRANT ALL ON TABLE nomenclatural_group_region TO ara;
GRANT ALL ON TABLE nomenclatural_group_region TO postgres;


--
-- TOC entry 2538 (class 0 OID 0)
-- Dependencies: 1609
-- Name: ocean; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE ocean FROM PUBLIC;
REVOKE ALL ON TABLE ocean FROM ara;
GRANT ALL ON TABLE ocean TO ara;
GRANT ALL ON TABLE ocean TO PUBLIC;


--
-- TOC entry 2539 (class 0 OID 0)
-- Dependencies: 1610
-- Name: origin; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE origin FROM PUBLIC;
REVOKE ALL ON TABLE origin FROM ara;
GRANT ALL ON TABLE origin TO ara;
GRANT ALL ON TABLE origin TO postgres;


--
-- TOC entry 2540 (class 0 OID 0)
-- Dependencies: 1611
-- Name: original_label; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE original_label FROM PUBLIC;
REVOKE ALL ON TABLE original_label FROM ara;
GRANT ALL ON TABLE original_label TO ara;
GRANT ALL ON TABLE original_label TO postgres;


--
-- TOC entry 2541 (class 0 OID 0)
-- Dependencies: 1612
-- Name: person; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE person FROM PUBLIC;
REVOKE ALL ON TABLE person FROM ara;
GRANT ALL ON TABLE person TO ara;
GRANT ALL ON TABLE person TO postgres;


--
-- TOC entry 2542 (class 0 OID 0)
-- Dependencies: 1613
-- Name: person_institution; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE person_institution FROM PUBLIC;
REVOKE ALL ON TABLE person_institution FROM ara;
GRANT ALL ON TABLE person_institution TO ara;
GRANT ALL ON TABLE person_institution TO postgres;


--
-- TOC entry 2543 (class 0 OID 0)
-- Dependencies: 1614
-- Name: person_profile; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE person_profile FROM PUBLIC;
REVOKE ALL ON TABLE person_profile FROM ara;
GRANT ALL ON TABLE person_profile TO ara;
GRANT ALL ON TABLE person_profile TO postgres;


--
-- TOC entry 2544 (class 0 OID 0)
-- Dependencies: 1615
-- Name: person_profile_taxon; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE person_profile_taxon FROM PUBLIC;
REVOKE ALL ON TABLE person_profile_taxon FROM ara;
GRANT ALL ON TABLE person_profile_taxon TO ara;
GRANT ALL ON TABLE person_profile_taxon TO postgres;


--
-- TOC entry 2545 (class 0 OID 0)
-- Dependencies: 1616
-- Name: pg_ts_cfg; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE pg_ts_cfg FROM PUBLIC;
REVOKE ALL ON TABLE pg_ts_cfg FROM ara;
GRANT ALL ON TABLE pg_ts_cfg TO ara;
GRANT ALL ON TABLE pg_ts_cfg TO postgres;


--
-- TOC entry 2546 (class 0 OID 0)
-- Dependencies: 1617
-- Name: pg_ts_cfgmap; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE pg_ts_cfgmap FROM PUBLIC;
REVOKE ALL ON TABLE pg_ts_cfgmap FROM ara;
GRANT ALL ON TABLE pg_ts_cfgmap TO ara;
GRANT ALL ON TABLE pg_ts_cfgmap TO postgres;


--
-- TOC entry 2547 (class 0 OID 0)
-- Dependencies: 1618
-- Name: pg_ts_dict; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE pg_ts_dict FROM PUBLIC;
REVOKE ALL ON TABLE pg_ts_dict FROM ara;
GRANT ALL ON TABLE pg_ts_dict TO ara;
GRANT ALL ON TABLE pg_ts_dict TO postgres;


--
-- TOC entry 2548 (class 0 OID 0)
-- Dependencies: 1619
-- Name: pg_ts_parser; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE pg_ts_parser FROM PUBLIC;
REVOKE ALL ON TABLE pg_ts_parser FROM ara;
GRANT ALL ON TABLE pg_ts_parser TO ara;
GRANT ALL ON TABLE pg_ts_parser TO postgres;


--
-- TOC entry 2549 (class 0 OID 0)
-- Dependencies: 1620
-- Name: preparation_method; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE preparation_method FROM PUBLIC;
REVOKE ALL ON TABLE preparation_method FROM ara;
GRANT ALL ON TABLE preparation_method TO ara;
GRANT ALL ON TABLE preparation_method TO postgres;


--
-- TOC entry 2550 (class 0 OID 0)
-- Dependencies: 1621
-- Name: preservation_medium; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE preservation_medium FROM PUBLIC;
REVOKE ALL ON TABLE preservation_medium FROM ara;
GRANT ALL ON TABLE preservation_medium TO ara;
GRANT ALL ON TABLE preservation_medium TO postgres;


--
-- TOC entry 2551 (class 0 OID 0)
-- Dependencies: 1622
-- Name: profile; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE profile FROM PUBLIC;
REVOKE ALL ON TABLE profile FROM ara;
GRANT ALL ON TABLE profile TO ara;
GRANT ALL ON TABLE profile TO postgres;


--
-- TOC entry 2552 (class 0 OID 0)
-- Dependencies: 1623
-- Name: project; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE project FROM PUBLIC;
REVOKE ALL ON TABLE project FROM ara;
GRANT ALL ON TABLE project TO ara;
GRANT ALL ON TABLE project TO postgres;


--
-- TOC entry 2553 (class 0 OID 0)
-- Dependencies: 1624
-- Name: projection; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE projection FROM PUBLIC;
REVOKE ALL ON TABLE projection FROM ara;
GRANT ALL ON TABLE projection TO ara;
GRANT ALL ON TABLE projection TO postgres;


--
-- TOC entry 2554 (class 0 OID 0)
-- Dependencies: 1625
-- Name: protected_area; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE protected_area FROM PUBLIC;
REVOKE ALL ON TABLE protected_area FROM ara;
GRANT ALL ON TABLE protected_area TO ara;
GRANT ALL ON TABLE protected_area TO PUBLIC;


--
-- TOC entry 2555 (class 0 OID 0)
-- Dependencies: 1626
-- Name: protected_area_type; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE protected_area_type FROM PUBLIC;
REVOKE ALL ON TABLE protected_area_type FROM ara;
GRANT ALL ON TABLE protected_area_type TO ara;
GRANT ALL ON TABLE protected_area_type TO postgres;


--
-- TOC entry 2556 (class 0 OID 0)
-- Dependencies: 1627
-- Name: protocol_attribute; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE protocol_attribute FROM PUBLIC;
REVOKE ALL ON TABLE protocol_attribute FROM ara;
GRANT ALL ON TABLE protocol_attribute TO ara;
GRANT ALL ON TABLE protocol_attribute TO postgres;


--
-- TOC entry 2557 (class 0 OID 0)
-- Dependencies: 1628
-- Name: province; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE province FROM PUBLIC;
REVOKE ALL ON TABLE province FROM ara;
GRANT ALL ON TABLE province TO ara;
GRANT ALL ON TABLE province TO PUBLIC;


--
-- TOC entry 2558 (class 0 OID 0)
-- Dependencies: 1629
-- Name: reference; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE reference FROM PUBLIC;
REVOKE ALL ON TABLE reference FROM ara;
GRANT ALL ON TABLE reference TO ara;
GRANT ALL ON TABLE reference TO postgres;


--
-- TOC entry 2559 (class 0 OID 0)
-- Dependencies: 1630
-- Name: reference_element; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE reference_element FROM PUBLIC;
REVOKE ALL ON TABLE reference_element FROM ara;
GRANT ALL ON TABLE reference_element TO ara;
GRANT ALL ON TABLE reference_element TO postgres;


--
-- TOC entry 2560 (class 0 OID 0)
-- Dependencies: 1631
-- Name: reference_element_value; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE reference_element_value FROM PUBLIC;
REVOKE ALL ON TABLE reference_element_value FROM ara;
GRANT ALL ON TABLE reference_element_value TO ara;
GRANT ALL ON TABLE reference_element_value TO postgres;


--
-- TOC entry 2561 (class 0 OID 0)
-- Dependencies: 1632
-- Name: reference_type; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE reference_type FROM PUBLIC;
REVOKE ALL ON TABLE reference_type FROM ara;
GRANT ALL ON TABLE reference_type TO ara;
GRANT ALL ON TABLE reference_type TO postgres;


--
-- TOC entry 2562 (class 0 OID 0)
-- Dependencies: 1688
-- Name: region; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE region FROM PUBLIC;
REVOKE ALL ON TABLE region FROM ara;
GRANT ALL ON TABLE region TO ara;
GRANT ALL ON TABLE region TO postgres;


--
-- TOC entry 2563 (class 0 OID 0)
-- Dependencies: 1633
-- Name: sampling_type; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE sampling_type FROM PUBLIC;
REVOKE ALL ON TABLE sampling_type FROM ara;
GRANT ALL ON TABLE sampling_type TO ara;
GRANT ALL ON TABLE sampling_type TO postgres;


--
-- TOC entry 2564 (class 0 OID 0)
-- Dependencies: 1634
-- Name: sex; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE sex FROM PUBLIC;
REVOKE ALL ON TABLE sex FROM ara;
GRANT ALL ON TABLE sex TO ara;
GRANT ALL ON TABLE sex TO postgres;


--
-- TOC entry 2565 (class 0 OID 0)
-- Dependencies: 1635
-- Name: site; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE site FROM PUBLIC;
REVOKE ALL ON TABLE site FROM ara;
GRANT ALL ON TABLE site TO ara;
GRANT ALL ON TABLE site TO postgres;


--
-- TOC entry 2566 (class 0 OID 0)
-- Dependencies: 1636
-- Name: site_calculation_method; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE site_calculation_method FROM PUBLIC;
REVOKE ALL ON TABLE site_calculation_method FROM ara;
GRANT ALL ON TABLE site_calculation_method TO ara;
GRANT ALL ON TABLE site_calculation_method TO postgres;


--
-- TOC entry 2567 (class 0 OID 0)
-- Dependencies: 1637
-- Name: site_coordinate; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE site_coordinate FROM PUBLIC;
REVOKE ALL ON TABLE site_coordinate FROM ara;
GRANT ALL ON TABLE site_coordinate TO ara;
GRANT ALL ON TABLE site_coordinate TO PUBLIC;


--
-- TOC entry 2568 (class 0 OID 0)
-- Dependencies: 1638
-- Name: species_record_stage_profile; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE species_record_stage_profile FROM PUBLIC;
REVOKE ALL ON TABLE species_record_stage_profile FROM ara;
GRANT ALL ON TABLE species_record_stage_profile TO ara;
GRANT ALL ON TABLE species_record_stage_profile TO postgres;


--
-- TOC entry 2569 (class 0 OID 0)
-- Dependencies: 1639
-- Name: specimen; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE specimen FROM PUBLIC;
REVOKE ALL ON TABLE specimen FROM ara;
GRANT ALL ON TABLE specimen TO ara;
GRANT ALL ON TABLE specimen TO postgres;


--
-- TOC entry 2570 (class 0 OID 0)
-- Dependencies: 1640
-- Name: specimen_annotation; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE specimen_annotation FROM PUBLIC;
REVOKE ALL ON TABLE specimen_annotation FROM ara;
GRANT ALL ON TABLE specimen_annotation TO ara;
GRANT ALL ON TABLE specimen_annotation TO postgres;


--
-- TOC entry 2571 (class 0 OID 0)
-- Dependencies: 1641
-- Name: specimen_category; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE specimen_category FROM PUBLIC;
REVOKE ALL ON TABLE specimen_category FROM ara;
GRANT ALL ON TABLE specimen_category TO ara;
GRANT ALL ON TABLE specimen_category TO postgres;


--
-- TOC entry 2572 (class 0 OID 0)
-- Dependencies: 1642
-- Name: specimen_description; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE specimen_description FROM PUBLIC;
REVOKE ALL ON TABLE specimen_description FROM ara;
GRANT ALL ON TABLE specimen_description TO ara;
GRANT ALL ON TABLE specimen_description TO postgres;


--
-- TOC entry 2573 (class 0 OID 0)
-- Dependencies: 1645
-- Name: specimen_type; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE specimen_type FROM PUBLIC;
REVOKE ALL ON TABLE specimen_type FROM ara;
GRANT ALL ON TABLE specimen_type TO ara;
GRANT ALL ON TABLE specimen_type TO postgres;


--
-- TOC entry 2574 (class 0 OID 0)
-- Dependencies: 1646
-- Name: specimen_variable; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE specimen_variable FROM PUBLIC;
REVOKE ALL ON TABLE specimen_variable FROM ara;
GRANT ALL ON TABLE specimen_variable TO ara;
GRANT ALL ON TABLE specimen_variable TO postgres;


--
-- TOC entry 2575 (class 0 OID 0)
-- Dependencies: 1647
-- Name: specimen_variable_value; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE specimen_variable_value FROM PUBLIC;
REVOKE ALL ON TABLE specimen_variable_value FROM ara;
GRANT ALL ON TABLE specimen_variable_value TO ara;
GRANT ALL ON TABLE specimen_variable_value TO postgres;


--
-- TOC entry 2576 (class 0 OID 0)
-- Dependencies: 1648
-- Name: stage_transition_date; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE stage_transition_date FROM PUBLIC;
REVOKE ALL ON TABLE stage_transition_date FROM ara;
GRANT ALL ON TABLE stage_transition_date TO ara;
GRANT ALL ON TABLE stage_transition_date TO postgres;


--
-- TOC entry 2577 (class 0 OID 0)
-- Dependencies: 1649
-- Name: stage_transition_digraph; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE stage_transition_digraph FROM PUBLIC;
REVOKE ALL ON TABLE stage_transition_digraph FROM ara;
GRANT ALL ON TABLE stage_transition_digraph TO ara;
GRANT ALL ON TABLE stage_transition_digraph TO postgres;


--
-- TOC entry 2578 (class 0 OID 0)
-- Dependencies: 1650
-- Name: storage_type; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE storage_type FROM PUBLIC;
REVOKE ALL ON TABLE storage_type FROM ara;
GRANT ALL ON TABLE storage_type TO ara;
GRANT ALL ON TABLE storage_type TO postgres;


--
-- TOC entry 2579 (class 0 OID 0)
-- Dependencies: 1651
-- Name: substrate; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE substrate FROM PUBLIC;
REVOKE ALL ON TABLE substrate FROM ara;
GRANT ALL ON TABLE substrate TO ara;
GRANT ALL ON TABLE substrate TO postgres;


--
-- TOC entry 2580 (class 0 OID 0)
-- Dependencies: 1652
-- Name: system_module; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE system_module FROM PUBLIC;
REVOKE ALL ON TABLE system_module FROM ara;
GRANT ALL ON TABLE system_module TO ara;
GRANT ALL ON TABLE system_module TO postgres;


--
-- TOC entry 2581 (class 0 OID 0)
-- Dependencies: 1653
-- Name: system_option; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE system_option FROM PUBLIC;
REVOKE ALL ON TABLE system_option FROM ara;
GRANT ALL ON TABLE system_option TO ara;
GRANT ALL ON TABLE system_option TO postgres;


--
-- TOC entry 2582 (class 0 OID 0)
-- Dependencies: 1654
-- Name: system_option_type; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE system_option_type FROM PUBLIC;
REVOKE ALL ON TABLE system_option_type FROM ara;
GRANT ALL ON TABLE system_option_type TO ara;
GRANT ALL ON TABLE system_option_type TO postgres;


--
-- TOC entry 2583 (class 0 OID 0)
-- Dependencies: 1655
-- Name: system_subsystem; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE system_subsystem FROM PUBLIC;
REVOKE ALL ON TABLE system_subsystem FROM ara;
GRANT ALL ON TABLE system_subsystem TO ara;
GRANT ALL ON TABLE system_subsystem TO postgres;


--
-- TOC entry 2584 (class 0 OID 0)
-- Dependencies: 1656
-- Name: system_user; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE system_user FROM PUBLIC;
REVOKE ALL ON TABLE system_user FROM ara;
GRANT ALL ON TABLE system_user TO ara;
GRANT ALL ON TABLE system_user TO postgres;


--
-- TOC entry 2585 (class 0 OID 0)
-- Dependencies: 1657
-- Name: system_user_option; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE system_user_option FROM PUBLIC;
REVOKE ALL ON TABLE system_user_option FROM ara;
GRANT ALL ON TABLE system_user_option TO ara;
GRANT ALL ON TABLE system_user_option TO postgres;


--
-- TOC entry 2586 (class 0 OID 0)
-- Dependencies: 1658
-- Name: system_user_type; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE system_user_type FROM PUBLIC;
REVOKE ALL ON TABLE system_user_type FROM ara;
GRANT ALL ON TABLE system_user_type TO ara;
GRANT ALL ON TABLE system_user_type TO postgres;


--
-- TOC entry 2587 (class 0 OID 0)
-- Dependencies: 1659
-- Name: taxon; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon FROM PUBLIC;
REVOKE ALL ON TABLE taxon FROM ara;
GRANT ALL ON TABLE taxon TO ara;
GRANT ALL ON TABLE taxon TO postgres;


--
-- TOC entry 2588 (class 0 OID 0)
-- Dependencies: 1660
-- Name: taxon_author; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon_author FROM PUBLIC;
REVOKE ALL ON TABLE taxon_author FROM ara;
GRANT ALL ON TABLE taxon_author TO ara;
GRANT ALL ON TABLE taxon_author TO postgres;


--
-- TOC entry 2589 (class 0 OID 0)
-- Dependencies: 1661
-- Name: taxon_author_connector; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon_author_connector FROM PUBLIC;
REVOKE ALL ON TABLE taxon_author_connector FROM ara;
GRANT ALL ON TABLE taxon_author_connector TO ara;
GRANT ALL ON TABLE taxon_author_connector TO postgres;


--
-- TOC entry 2590 (class 0 OID 0)
-- Dependencies: 1662
-- Name: taxon_category; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon_category FROM PUBLIC;
REVOKE ALL ON TABLE taxon_category FROM ara;
GRANT ALL ON TABLE taxon_category TO ara;
GRANT ALL ON TABLE taxon_category TO postgres;


--
-- TOC entry 2591 (class 0 OID 0)
-- Dependencies: 1663
-- Name: taxon_description; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon_description FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description FROM ara;
GRANT ALL ON TABLE taxon_description TO ara;
GRANT ALL ON TABLE taxon_description TO postgres;


--
-- TOC entry 2592 (class 0 OID 0)
-- Dependencies: 1664
-- Name: taxon_description_audience; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon_description_audience FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_audience FROM ara;
GRANT ALL ON TABLE taxon_description_audience TO ara;
GRANT ALL ON TABLE taxon_description_audience TO postgres;


--
-- TOC entry 2593 (class 0 OID 0)
-- Dependencies: 1665
-- Name: taxon_description_category; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon_description_category FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_category FROM ara;
GRANT ALL ON TABLE taxon_description_category TO ara;
GRANT ALL ON TABLE taxon_description_category TO postgres;


--
-- TOC entry 2594 (class 0 OID 0)
-- Dependencies: 1666
-- Name: taxon_description_datatype; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon_description_datatype FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_datatype FROM ara;
GRANT ALL ON TABLE taxon_description_datatype TO ara;
GRANT ALL ON TABLE taxon_description_datatype TO postgres;


--
-- TOC entry 2595 (class 0 OID 0)
-- Dependencies: 1667
-- Name: taxon_description_element; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon_description_element FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_element FROM ara;
GRANT ALL ON TABLE taxon_description_element TO ara;
GRANT ALL ON TABLE taxon_description_element TO postgres;


--
-- TOC entry 2596 (class 0 OID 0)
-- Dependencies: 1668
-- Name: taxon_description_institution; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon_description_institution FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_institution FROM ara;
GRANT ALL ON TABLE taxon_description_institution TO ara;
GRANT ALL ON TABLE taxon_description_institution TO postgres;


--
-- TOC entry 2597 (class 0 OID 0)
-- Dependencies: 1670
-- Name: taxon_description_record; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon_description_record FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_record FROM ara;
GRANT ALL ON TABLE taxon_description_record TO ara;
GRANT ALL ON TABLE taxon_description_record TO postgres;


--
-- TOC entry 2598 (class 0 OID 0)
-- Dependencies: 1671
-- Name: taxon_description_record_reference; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon_description_record_reference FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_record_reference FROM ara;
GRANT ALL ON TABLE taxon_description_record_reference TO ara;
GRANT ALL ON TABLE taxon_description_record_reference TO postgres;


--
-- TOC entry 2599 (class 0 OID 0)
-- Dependencies: 1672
-- Name: taxon_description_stage; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon_description_stage FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_stage FROM ara;
GRANT ALL ON TABLE taxon_description_stage TO ara;
GRANT ALL ON TABLE taxon_description_stage TO postgres;


--
-- TOC entry 2600 (class 0 OID 0)
-- Dependencies: 1673
-- Name: taxon_name_history; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon_name_history FROM PUBLIC;
REVOKE ALL ON TABLE taxon_name_history FROM ara;
GRANT ALL ON TABLE taxon_name_history TO ara;
GRANT ALL ON TABLE taxon_name_history TO postgres;


--
-- TOC entry 2601 (class 0 OID 0)
-- Dependencies: 1674
-- Name: taxon_nomenclatural_group; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon_nomenclatural_group FROM PUBLIC;
REVOKE ALL ON TABLE taxon_nomenclatural_group FROM ara;
GRANT ALL ON TABLE taxon_nomenclatural_group TO ara;
GRANT ALL ON TABLE taxon_nomenclatural_group TO postgres;


--
-- TOC entry 2602 (class 0 OID 0)
-- Dependencies: 1675
-- Name: taxon_reference; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon_reference FROM PUBLIC;
REVOKE ALL ON TABLE taxon_reference FROM ara;
GRANT ALL ON TABLE taxon_reference TO ara;
GRANT ALL ON TABLE taxon_reference TO postgres;


--
-- TOC entry 2603 (class 0 OID 0)
-- Dependencies: 1676
-- Name: taxonomical_hierarchy; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxonomical_hierarchy FROM PUBLIC;
REVOKE ALL ON TABLE taxonomical_hierarchy FROM ara;
GRANT ALL ON TABLE taxonomical_hierarchy TO ara;
GRANT ALL ON TABLE taxonomical_hierarchy TO postgres;


--
-- TOC entry 2604 (class 0 OID 0)
-- Dependencies: 1677
-- Name: taxonomical_range; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxonomical_range FROM PUBLIC;
REVOKE ALL ON TABLE taxonomical_range FROM ara;
GRANT ALL ON TABLE taxonomical_range TO ara;
GRANT ALL ON TABLE taxonomical_range TO postgres;


--
-- TOC entry 2605 (class 0 OID 0)
-- Dependencies: 1678
-- Name: topographic_sheet; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE topographic_sheet FROM PUBLIC;
REVOKE ALL ON TABLE topographic_sheet FROM ara;
GRANT ALL ON TABLE topographic_sheet TO ara;
GRANT ALL ON TABLE topographic_sheet TO PUBLIC;


--
-- TOC entry 2606 (class 0 OID 0)
-- Dependencies: 1679
-- Name: transacted_specimen; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE transacted_specimen FROM PUBLIC;
REVOKE ALL ON TABLE transacted_specimen FROM ara;
GRANT ALL ON TABLE transacted_specimen TO ara;
GRANT ALL ON TABLE transacted_specimen TO postgres;


--
-- TOC entry 2607 (class 0 OID 0)
-- Dependencies: 1680
-- Name: transacted_specimen_status; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE transacted_specimen_status FROM PUBLIC;
REVOKE ALL ON TABLE transacted_specimen_status FROM ara;
GRANT ALL ON TABLE transacted_specimen_status TO ara;
GRANT ALL ON TABLE transacted_specimen_status TO postgres;


--
-- TOC entry 2608 (class 0 OID 0)
-- Dependencies: 1681
-- Name: transaction; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE "transaction" FROM PUBLIC;
REVOKE ALL ON TABLE "transaction" FROM ara;
GRANT ALL ON TABLE "transaction" TO ara;
GRANT ALL ON TABLE "transaction" TO postgres;


--
-- TOC entry 2609 (class 0 OID 0)
-- Dependencies: 1682
-- Name: transaction_type; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE transaction_type FROM PUBLIC;
REVOKE ALL ON TABLE transaction_type FROM ara;
GRANT ALL ON TABLE transaction_type TO ara;
GRANT ALL ON TABLE transaction_type TO postgres;


--
-- TOC entry 2610 (class 0 OID 0)
-- Dependencies: 1683
-- Name: type_specimen; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE type_specimen FROM PUBLIC;
REVOKE ALL ON TABLE type_specimen FROM ara;
GRANT ALL ON TABLE type_specimen TO ara;
GRANT ALL ON TABLE type_specimen TO postgres;


--
-- TOC entry 2611 (class 0 OID 0)
-- Dependencies: 1684
-- Name: type_specimen_type; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE type_specimen_type FROM PUBLIC;
REVOKE ALL ON TABLE type_specimen_type FROM ara;
GRANT ALL ON TABLE type_specimen_type TO ara;
GRANT ALL ON TABLE type_specimen_type TO postgres;


--
-- TOC entry 2612 (class 0 OID 0)
-- Dependencies: 1685
-- Name: versant; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE versant FROM PUBLIC;
REVOKE ALL ON TABLE versant FROM ara;
GRANT ALL ON TABLE versant TO ara;
GRANT ALL ON TABLE versant TO PUBLIC;


-- Completed on 2008-05-30 15:17:21

--
-- PostgreSQL database dump complete
--

