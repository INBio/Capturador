--
-- PostgreSQL database dump
--

-- Started on 2008-07-15 17:10:19

SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- TOC entry 6 (class 2615 OID 24669)
-- Name: ara; Type: SCHEMA; Schema: -; Owner: ara
--

CREATE SCHEMA ara;


ALTER SCHEMA ara OWNER TO ara;

--
-- TOC entry 2799 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA ara; Type: COMMENT; Schema: -; Owner: ara
--

COMMENT ON SCHEMA ara IS 'Standard ara schema';


SET search_path = ara, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 1866 (class 1259 OID 26642)
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
-- TOC entry 1867 (class 1259 OID 26647)
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
-- TOC entry 1868 (class 1259 OID 26652)
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
-- TOC entry 1869 (class 1259 OID 26657)
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
-- TOC entry 1870 (class 1259 OID 26662)
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
-- TOC entry 1871 (class 1259 OID 26667)
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
-- TOC entry 1872 (class 1259 OID 26672)
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
-- TOC entry 1873 (class 1259 OID 26677)
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
-- TOC entry 1874 (class 1259 OID 26682)
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
-- TOC entry 1875 (class 1259 OID 26687)
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
-- TOC entry 1876 (class 1259 OID 26692)
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
-- TOC entry 1877 (class 1259 OID 26697)
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
-- TOC entry 1878 (class 1259 OID 26702)
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
-- TOC entry 1879 (class 1259 OID 26707)
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
-- TOC entry 1880 (class 1259 OID 26712)
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
-- TOC entry 1881 (class 1259 OID 26717)
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
-- TOC entry 1882 (class 1259 OID 26722)
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
-- TOC entry 1883 (class 1259 OID 26727)
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
-- TOC entry 1884 (class 1259 OID 26732)
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
-- TOC entry 1885 (class 1259 OID 26737)
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
-- TOC entry 1886 (class 1259 OID 26742)
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
-- TOC entry 1887 (class 1259 OID 26747)
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
-- TOC entry 1888 (class 1259 OID 26752)
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
-- TOC entry 1889 (class 1259 OID 26757)
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
-- TOC entry 1890 (class 1259 OID 26762)
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
-- TOC entry 1891 (class 1259 OID 26767)
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
-- TOC entry 1892 (class 1259 OID 26772)
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
-- TOC entry 1893 (class 1259 OID 26777)
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
-- TOC entry 1894 (class 1259 OID 26782)
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
-- TOC entry 1895 (class 1259 OID 26787)
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
-- TOC entry 1896 (class 1259 OID 26792)
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
-- TOC entry 1897 (class 1259 OID 26797)
-- Dependencies: 6
-- Name: gathering_observation_detail; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE gathering_observation_detail (
    gathering_observation_detail_person_id numeric NOT NULL,
    gathering_observation_detail_number character varying(100) NOT NULL,
    gathering_observation_id numeric NOT NULL,
    morphological_description_id numeric,
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
-- TOC entry 1898 (class 1259 OID 26802)
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
-- TOC entry 1899 (class 1259 OID 26807)
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
-- TOC entry 1900 (class 1259 OID 26812)
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
-- TOC entry 1901 (class 1259 OID 26817)
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
-- TOC entry 1902 (class 1259 OID 26822)
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
-- TOC entry 1903 (class 1259 OID 26827)
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
-- TOC entry 1904 (class 1259 OID 26832)
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
-- TOC entry 1905 (class 1259 OID 26837)
-- Dependencies: 6
-- Name: id_gen; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE id_gen (
    gen_key character varying NOT NULL,
    gen_value numeric NOT NULL
);


ALTER TABLE ara.id_gen OWNER TO ara;

--
-- TOC entry 1906 (class 1259 OID 26842)
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
    valuer_person_id numeric,
    data_entry_error character varying(1),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    identification_status_id numeric NOT NULL
);


ALTER TABLE ara.identification OWNER TO ara;

--
-- TOC entry 1907 (class 1259 OID 26847)
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
    taxon_id numeric,
    valuer_person_id numeric,
    data_entry_error character varying(1),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL,
    identification_status_id numeric
);


ALTER TABLE ara.identification_history OWNER TO ara;

--
-- TOC entry 2005 (class 1259 OID 53082)
-- Dependencies: 6
-- Name: identification_status; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE identification_status (
    identification_status_id numeric NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(500),
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.identification_status OWNER TO ara;

--
-- TOC entry 1908 (class 1259 OID 26852)
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
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.identification_type OWNER TO ara;

--
-- TOC entry 2007 (class 1259 OID 53249)
-- Dependencies: 6
-- Name: identifier; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE identifier (
    specimen_id numeric NOT NULL,
    identification_sequence numeric NOT NULL,
    identifier_sequence numeric NOT NULL,
    initial_timestamp date NOT NULL,
    identifier_person_id numeric NOT NULL,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.identifier OWNER TO ara;

--
-- TOC entry 1909 (class 1259 OID 26862)
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
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.identifier_history OWNER TO ara;

--
-- TOC entry 1910 (class 1259 OID 26867)
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
-- TOC entry 1911 (class 1259 OID 26872)
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
-- TOC entry 1912 (class 1259 OID 26877)
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
-- TOC entry 1913 (class 1259 OID 26882)
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
-- TOC entry 1914 (class 1259 OID 26887)
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
-- TOC entry 1915 (class 1259 OID 26892)
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
-- TOC entry 1916 (class 1259 OID 26897)
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
-- TOC entry 1917 (class 1259 OID 26902)
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
-- TOC entry 1918 (class 1259 OID 26907)
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
-- TOC entry 1919 (class 1259 OID 26912)
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
-- TOC entry 1920 (class 1259 OID 26917)
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
-- TOC entry 1921 (class 1259 OID 26922)
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
-- TOC entry 1922 (class 1259 OID 26927)
-- Dependencies: 6
-- Name: morphological_description; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE morphological_description (
    morphological_description_id numeric NOT NULL,
    contents character varying(4000),
    description_date date,
    description_person_id numeric,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL
);


ALTER TABLE ara.morphological_description OWNER TO ara;

--
-- TOC entry 1923 (class 1259 OID 26932)
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
-- TOC entry 1924 (class 1259 OID 26937)
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
-- TOC entry 1925 (class 1259 OID 26942)
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
-- TOC entry 1926 (class 1259 OID 26947)
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
-- TOC entry 1927 (class 1259 OID 26952)
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
-- TOC entry 1928 (class 1259 OID 26957)
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
-- TOC entry 1929 (class 1259 OID 26962)
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
-- TOC entry 1930 (class 1259 OID 26967)
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
-- TOC entry 1931 (class 1259 OID 26972)
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
-- TOC entry 1932 (class 1259 OID 26977)
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
-- TOC entry 1933 (class 1259 OID 26982)
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
-- TOC entry 1934 (class 1259 OID 26987)
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
-- TOC entry 1935 (class 1259 OID 26992)
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
-- TOC entry 1936 (class 1259 OID 26997)
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
-- TOC entry 1937 (class 1259 OID 27002)
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
-- TOC entry 1938 (class 1259 OID 27007)
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
-- TOC entry 1939 (class 1259 OID 27012)
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
-- TOC entry 1940 (class 1259 OID 27017)
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
-- TOC entry 1941 (class 1259 OID 27022)
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
-- TOC entry 1942 (class 1259 OID 27027)
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
-- TOC entry 1943 (class 1259 OID 27032)
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
-- TOC entry 1944 (class 1259 OID 27037)
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
-- TOC entry 1945 (class 1259 OID 27042)
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
-- TOC entry 1946 (class 1259 OID 27047)
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
-- TOC entry 1947 (class 1259 OID 27052)
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
-- TOC entry 1948 (class 1259 OID 27057)
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
-- TOC entry 1949 (class 1259 OID 27062)
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
-- TOC entry 1950 (class 1259 OID 27067)
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
-- TOC entry 1951 (class 1259 OID 27072)
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
-- TOC entry 1952 (class 1259 OID 27077)
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
-- TOC entry 1953 (class 1259 OID 27082)
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
-- TOC entry 1954 (class 1259 OID 27087)
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
-- TOC entry 1955 (class 1259 OID 27092)
-- Dependencies: 6
-- Name: site_coordinate; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE site_coordinate (
    site_coordinate_id numeric NOT NULL,
    site_id numeric NOT NULL,
    longitude numeric(9,6) NOT NULL,
    latitude numeric(9,6) NOT NULL,
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
-- TOC entry 1956 (class 1259 OID 27097)
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
-- TOC entry 2006 (class 1259 OID 53109)
-- Dependencies: 6
-- Name: specimen; Type: TABLE; Schema: ara; Owner: ara; Tablespace: 
--

CREATE TABLE specimen (
    specimen_id numeric NOT NULL,
    gathering_observation_id numeric,
    discarded character varying(1),
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
    extraction_type_id numeric,
    obj_version numeric NOT NULL,
    created_by character varying(100) NOT NULL,
    creation_date date NOT NULL,
    last_modification_by character varying(100) NOT NULL,
    last_modification_date date NOT NULL,
    collection_id numeric,
    external_specimen character varying(1),
    gathering_observation_method_id numeric,
    certainty_level numeric,
    date_time timestamp without time zone,
    gathering_observation_detail_id numeric
);


ALTER TABLE ara.specimen OWNER TO ara;

--
-- TOC entry 1957 (class 1259 OID 27107)
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
-- TOC entry 1958 (class 1259 OID 27112)
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
-- TOC entry 1959 (class 1259 OID 27117)
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
-- TOC entry 1960 (class 1259 OID 27122)
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
-- TOC entry 1961 (class 1259 OID 27127)
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
-- TOC entry 1962 (class 1259 OID 27132)
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
-- TOC entry 1963 (class 1259 OID 27137)
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
-- TOC entry 1964 (class 1259 OID 27142)
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
-- TOC entry 1965 (class 1259 OID 27147)
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
-- TOC entry 1966 (class 1259 OID 27152)
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
-- TOC entry 1967 (class 1259 OID 27157)
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
-- TOC entry 1968 (class 1259 OID 27162)
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
-- TOC entry 1969 (class 1259 OID 27167)
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
-- TOC entry 1970 (class 1259 OID 27172)
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
-- TOC entry 1971 (class 1259 OID 27177)
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
-- TOC entry 1972 (class 1259 OID 27182)
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
-- TOC entry 1973 (class 1259 OID 27187)
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
-- TOC entry 1974 (class 1259 OID 27192)
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
-- TOC entry 1975 (class 1259 OID 27197)
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
-- TOC entry 1976 (class 1259 OID 27202)
-- Dependencies: 2338 6
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
-- TOC entry 1977 (class 1259 OID 27208)
-- Dependencies: 2339 6
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
-- TOC entry 1978 (class 1259 OID 27214)
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
-- TOC entry 1979 (class 1259 OID 27219)
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
-- TOC entry 1980 (class 1259 OID 27224)
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
-- TOC entry 1981 (class 1259 OID 27229)
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
-- TOC entry 1982 (class 1259 OID 27234)
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
-- TOC entry 1983 (class 1259 OID 27239)
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
-- TOC entry 1984 (class 1259 OID 27244)
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
-- TOC entry 1985 (class 1259 OID 27249)
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
-- TOC entry 1986 (class 1259 OID 27254)
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
-- TOC entry 1987 (class 1259 OID 27259)
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
-- TOC entry 1988 (class 1259 OID 27264)
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
-- TOC entry 1989 (class 1259 OID 27269)
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
-- TOC entry 1990 (class 1259 OID 27274)
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
-- TOC entry 1991 (class 1259 OID 27279)
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
-- TOC entry 1992 (class 1259 OID 27284)
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
-- TOC entry 1993 (class 1259 OID 27289)
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
-- TOC entry 1994 (class 1259 OID 27294)
-- Dependencies: 2340 2341 2342 6
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
-- TOC entry 1995 (class 1259 OID 27302)
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
-- TOC entry 1996 (class 1259 OID 27307)
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
-- TOC entry 1997 (class 1259 OID 27312)
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
-- TOC entry 1998 (class 1259 OID 27317)
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
-- TOC entry 1999 (class 1259 OID 27322)
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
-- TOC entry 2000 (class 1259 OID 27327)
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
-- TOC entry 2001 (class 1259 OID 27332)
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
-- TOC entry 2002 (class 1259 OID 27337)
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
-- TOC entry 2003 (class 1259 OID 27342)
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
-- TOC entry 2004 (class 1259 OID 27347)
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
-- TOC entry 2547 (class 2606 OID 27353)
-- Dependencies: 1970 1970
-- Name: SYSTEM_OPTION_PK; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY system_option
    ADD CONSTRAINT "SYSTEM_OPTION_PK" PRIMARY KEY (option_id);


--
-- TOC entry 2555 (class 2606 OID 27355)
-- Dependencies: 1974 1974 1974
-- Name: SYSTEM_USER_OPTION_PK; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY system_user_option
    ADD CONSTRAINT "SYSTEM_USER_OPTION_PK" PRIMARY KEY (user_id, option_id);


--
-- TOC entry 2344 (class 2606 OID 27357)
-- Dependencies: 1866 1866
-- Name: altitude_floor_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY altitude_floor
    ADD CONSTRAINT altitude_floor_pk PRIMARY KEY (altitude_floor_id);


--
-- TOC entry 2346 (class 2606 OID 27359)
-- Dependencies: 1867 1867
-- Name: annotation_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY annotation
    ADD CONSTRAINT annotation_pk PRIMARY KEY (annotation_id);


--
-- TOC entry 2350 (class 2606 OID 27361)
-- Dependencies: 1869 1869
-- Name: base_projection_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY base_projection
    ADD CONSTRAINT base_projection_pk PRIMARY KEY (base_projection_id);


--
-- TOC entry 2352 (class 2606 OID 27363)
-- Dependencies: 1870 1870
-- Name: biotic_unit_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY biotic_unit
    ADD CONSTRAINT biotic_unit_pk PRIMARY KEY (biotic_unit_id);


--
-- TOC entry 2356 (class 2606 OID 27365)
-- Dependencies: 1872 1872
-- Name: canton_ifam_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY canton_ifam
    ADD CONSTRAINT canton_ifam_pk PRIMARY KEY (canton_ifam_id);


--
-- TOC entry 2354 (class 2606 OID 27367)
-- Dependencies: 1871 1871
-- Name: canton_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY canton
    ADD CONSTRAINT canton_pk PRIMARY KEY (canton_id);


--
-- TOC entry 2358 (class 2606 OID 27369)
-- Dependencies: 1873 1873
-- Name: collecting_area_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY collecting_area
    ADD CONSTRAINT collecting_area_pk PRIMARY KEY (collecting_area_id);


--
-- TOC entry 2362 (class 2606 OID 27371)
-- Dependencies: 1875 1875 1875
-- Name: collection_protocol_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY collection_protocol
    ADD CONSTRAINT collection_protocol_pk PRIMARY KEY (collection_id, protocol_attribute_id);


--
-- TOC entry 2364 (class 2606 OID 44884)
-- Dependencies: 1876 1876 1876
-- Name: collector_observer_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY collector_observer
    ADD CONSTRAINT collector_observer_pk PRIMARY KEY (gathering_observation_id, collector_person_id);


--
-- TOC entry 2368 (class 2606 OID 27375)
-- Dependencies: 1878 1878
-- Name: component_part_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY component_part
    ADD CONSTRAINT component_part_pk PRIMARY KEY (component_part_id);


--
-- TOC entry 2366 (class 2606 OID 27377)
-- Dependencies: 1877 1877
-- Name: component_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY component
    ADD CONSTRAINT component_pk PRIMARY KEY (component_id);


--
-- TOC entry 2372 (class 2606 OID 27379)
-- Dependencies: 1880 1880
-- Name: conservation_area_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY conservation_area
    ADD CONSTRAINT conservation_area_pk PRIMARY KEY (conservation_area_id);


--
-- TOC entry 2378 (class 2606 OID 27381)
-- Dependencies: 1883 1883
-- Name: culture_medium_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY culture_medium
    ADD CONSTRAINT culture_medium_pk PRIMARY KEY (culture_medium_id);


--
-- TOC entry 2376 (class 2606 OID 27383)
-- Dependencies: 1882 1882 1882
-- Name: culture_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY culture
    ADD CONSTRAINT culture_pk PRIMARY KEY (specimen_id, replica_number);


--
-- TOC entry 2380 (class 2606 OID 27385)
-- Dependencies: 1884 1884
-- Name: culture_storage_medium_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY culture_storage_medium
    ADD CONSTRAINT culture_storage_medium_pk PRIMARY KEY (culture_storage_medium_id);


--
-- TOC entry 2382 (class 2606 OID 27387)
-- Dependencies: 1885 1885
-- Name: determination_type_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY determination_type
    ADD CONSTRAINT determination_type_pk PRIMARY KEY (determination_type_id);


--
-- TOC entry 2384 (class 2606 OID 27389)
-- Dependencies: 1886 1886
-- Name: district_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY district
    ADD CONSTRAINT district_pk PRIMARY KEY (district_id);


--
-- TOC entry 2386 (class 2606 OID 27391)
-- Dependencies: 1887 1887
-- Name: ecological_region_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY ecological_region
    ADD CONSTRAINT ecological_region_pk PRIMARY KEY (ecological_region_id);


--
-- TOC entry 2388 (class 2606 OID 27393)
-- Dependencies: 1888 1888
-- Name: ecological_variable_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY ecological_variable
    ADD CONSTRAINT ecological_variable_pk PRIMARY KEY (ecological_variable_id);


--
-- TOC entry 2390 (class 2606 OID 27395)
-- Dependencies: 1889 1889
-- Name: ecological_variable_value_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY ecological_variable_value
    ADD CONSTRAINT ecological_variable_value_pk PRIMARY KEY (ecological_variable_value_id);


--
-- TOC entry 2392 (class 2606 OID 27397)
-- Dependencies: 1890 1890
-- Name: ecosystem_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY ecosystem
    ADD CONSTRAINT ecosystem_pk PRIMARY KEY (ecosystem_id);


--
-- TOC entry 2394 (class 2606 OID 27399)
-- Dependencies: 1891 1891
-- Name: elevation_band_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY elevation_band
    ADD CONSTRAINT elevation_band_pk PRIMARY KEY (elevation_band_id);


--
-- TOC entry 2396 (class 2606 OID 27401)
-- Dependencies: 1892 1892
-- Name: exposition_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY exposition
    ADD CONSTRAINT exposition_pk PRIMARY KEY (exposition_id);


--
-- TOC entry 2398 (class 2606 OID 27403)
-- Dependencies: 1893 1893
-- Name: extraction_type_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY extraction_type
    ADD CONSTRAINT extraction_type_pk PRIMARY KEY (extraction_type_id);


--
-- TOC entry 2400 (class 2606 OID 27405)
-- Dependencies: 1894 1894
-- Name: feature_type_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY feature_type
    ADD CONSTRAINT feature_type_pk PRIMARY KEY (feature_type_id);


--
-- TOC entry 2408 (class 2606 OID 27409)
-- Dependencies: 1899 1899
-- Name: gathering_method_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY gathering_observation_method
    ADD CONSTRAINT gathering_method_pk PRIMARY KEY (gathering_observation_method_id);


--
-- TOC entry 2404 (class 2606 OID 36692)
-- Dependencies: 1896 1896 1896
-- Name: gathering_observation_collection_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY gathering_observation_collection
    ADD CONSTRAINT gathering_observation_collection_pk PRIMARY KEY (gathering_observation_id, collection_id);


--
-- TOC entry 2406 (class 2606 OID 53076)
-- Dependencies: 1897 1897
-- Name: gathering_observation_detail_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY gathering_observation_detail
    ADD CONSTRAINT gathering_observation_detail_pk PRIMARY KEY (gathering_observation_detail_id);


--
-- TOC entry 2410 (class 2606 OID 27413)
-- Dependencies: 1900 1900 1900
-- Name: gathering_observation_project_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY gathering_observation_project
    ADD CONSTRAINT gathering_observation_project_pk PRIMARY KEY (gathering_observation_id, project_id);


--
-- TOC entry 2402 (class 2606 OID 27415)
-- Dependencies: 1895 1895
-- Name: gathering_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY gathering_observation
    ADD CONSTRAINT gathering_pk PRIMARY KEY (gathering_observation_id);


--
-- TOC entry 2416 (class 2606 OID 27417)
-- Dependencies: 1903 1903
-- Name: geographic_layer_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY geographic_layer
    ADD CONSTRAINT geographic_layer_pk PRIMARY KEY (geographic_layer_id);


--
-- TOC entry 2418 (class 2606 OID 27419)
-- Dependencies: 1904 1904 1904 1904
-- Name: georeferenced_site_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY georeferenced_site
    ADD CONSTRAINT georeferenced_site_pk PRIMARY KEY (site_id, geographic_layer_id, geographic_site_id);


--
-- TOC entry 2420 (class 2606 OID 27421)
-- Dependencies: 1905 1905
-- Name: id_gen_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY id_gen
    ADD CONSTRAINT id_gen_pk PRIMARY KEY (gen_key);


--
-- TOC entry 2424 (class 2606 OID 27423)
-- Dependencies: 1907 1907
-- Name: identification_history_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY identification_history
    ADD CONSTRAINT identification_history_pk PRIMARY KEY (identification_history_id);


--
-- TOC entry 2422 (class 2606 OID 27425)
-- Dependencies: 1906 1906 1906 1906
-- Name: identification_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY identification
    ADD CONSTRAINT identification_pk PRIMARY KEY (specimen_id, identification_sequence, initial_timestamp);


--
-- TOC entry 2617 (class 2606 OID 53088)
-- Dependencies: 2005 2005
-- Name: identification_status_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY identification_status
    ADD CONSTRAINT identification_status_pk PRIMARY KEY (identification_status_id);


--
-- TOC entry 2426 (class 2606 OID 27427)
-- Dependencies: 1908 1908
-- Name: identification_type_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY identification_type
    ADD CONSTRAINT identification_type_pk PRIMARY KEY (identification_type_id);


--
-- TOC entry 2428 (class 2606 OID 27429)
-- Dependencies: 1909 1909
-- Name: identifier_history_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY identifier_history
    ADD CONSTRAINT identifier_history_pk PRIMARY KEY (identifier_history_id);


--
-- TOC entry 2621 (class 2606 OID 53255)
-- Dependencies: 2007 2007 2007 2007 2007
-- Name: identifier_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY identifier
    ADD CONSTRAINT identifier_pk PRIMARY KEY (specimen_id, identification_sequence, initial_timestamp, identifier_person_id);


--
-- TOC entry 2430 (class 2606 OID 27433)
-- Dependencies: 1910 1910 1910 1910 1910
-- Name: inmediate_precedecessor_history; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY inmediate_predecessor_history
    ADD CONSTRAINT inmediate_precedecessor_history PRIMARY KEY (taxon_id, initial_timestamp, final_timestamp, predecessor_taxon_id);


--
-- TOC entry 2436 (class 2606 OID 27435)
-- Dependencies: 1913 1913
-- Name: label_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY label
    ADD CONSTRAINT label_pk PRIMARY KEY (label_id);


--
-- TOC entry 2438 (class 2606 OID 27437)
-- Dependencies: 1915 1915
-- Name: land_cover_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY land_cover
    ADD CONSTRAINT land_cover_pk PRIMARY KEY (land_cover_id);


--
-- TOC entry 2442 (class 2606 OID 27439)
-- Dependencies: 1917 1917
-- Name: life_form_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY life_form
    ADD CONSTRAINT life_form_pk PRIMARY KEY (life_form_id);


--
-- TOC entry 2444 (class 2606 OID 27441)
-- Dependencies: 1918 1918
-- Name: life_stage_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY life_stage
    ADD CONSTRAINT life_stage_pk PRIMARY KEY (life_stage_id);


--
-- TOC entry 2446 (class 2606 OID 27443)
-- Dependencies: 1919 1919
-- Name: life_zone_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY life_zone
    ADD CONSTRAINT life_zone_pk PRIMARY KEY (life_zone_id);


--
-- TOC entry 2450 (class 2606 OID 28500)
-- Dependencies: 1921 1921 1921 1921
-- Name: list_table_collection_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY list_table_collection
    ADD CONSTRAINT list_table_collection_pk PRIMARY KEY (list_table_id, collection_id, value_id);


--
-- TOC entry 2448 (class 2606 OID 27447)
-- Dependencies: 1920 1920
-- Name: list_table_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY list_table
    ADD CONSTRAINT list_table_pk PRIMARY KEY (list_table_id);


--
-- TOC entry 2452 (class 2606 OID 27449)
-- Dependencies: 1922 1922
-- Name: morphological_description_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY morphological_description
    ADD CONSTRAINT morphological_description_pk PRIMARY KEY (morphological_description_id);


--
-- TOC entry 2454 (class 2606 OID 27451)
-- Dependencies: 1923 1923
-- Name: natural_region_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY natural_region
    ADD CONSTRAINT natural_region_pk PRIMARY KEY (natural_region_id);


--
-- TOC entry 2456 (class 2606 OID 27453)
-- Dependencies: 1924 1924
-- Name: nomenclatural_group_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY nomenclatural_group
    ADD CONSTRAINT nomenclatural_group_pk PRIMARY KEY (nomenclatural_group_id);


--
-- TOC entry 2458 (class 2606 OID 27455)
-- Dependencies: 1925 1925 1925
-- Name: nomenclatural_group_region_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY nomenclatural_group_region
    ADD CONSTRAINT nomenclatural_group_region_pk PRIMARY KEY (region_id, nomenclatural_group_id);


--
-- TOC entry 2460 (class 2606 OID 27457)
-- Dependencies: 1926 1926
-- Name: ocean_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY ocean
    ADD CONSTRAINT ocean_pk PRIMARY KEY (ocean_id);


--
-- TOC entry 2462 (class 2606 OID 27459)
-- Dependencies: 1927 1927
-- Name: origin_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY origin
    ADD CONSTRAINT origin_pk PRIMARY KEY (origin_id);


--
-- TOC entry 2464 (class 2606 OID 27461)
-- Dependencies: 1928 1928
-- Name: origincal_label_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY original_label
    ADD CONSTRAINT origincal_label_pk PRIMARY KEY (original_label_id);


--
-- TOC entry 2474 (class 2606 OID 27463)
-- Dependencies: 1933 1933
-- Name: pg_ts_cfg_pkey; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY pg_ts_cfg
    ADD CONSTRAINT pg_ts_cfg_pkey PRIMARY KEY (ts_name);


--
-- TOC entry 2476 (class 2606 OID 27465)
-- Dependencies: 1934 1934 1934
-- Name: pg_ts_cfgmap_pkey; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY pg_ts_cfgmap
    ADD CONSTRAINT pg_ts_cfgmap_pkey PRIMARY KEY (ts_name, tok_alias);


--
-- TOC entry 2478 (class 2606 OID 27467)
-- Dependencies: 1935 1935
-- Name: pg_ts_dict_pkey; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY pg_ts_dict
    ADD CONSTRAINT pg_ts_dict_pkey PRIMARY KEY (dict_name);


--
-- TOC entry 2480 (class 2606 OID 27469)
-- Dependencies: 1936 1936
-- Name: pg_ts_parser_pkey; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY pg_ts_parser
    ADD CONSTRAINT pg_ts_parser_pkey PRIMARY KEY (prs_name);


--
-- TOC entry 2348 (class 2606 OID 27471)
-- Dependencies: 1868 1868
-- Name: pk_arao_meta_id; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY audience
    ADD CONSTRAINT pk_arao_meta_id PRIMARY KEY (audience_id);


--
-- TOC entry 2360 (class 2606 OID 27473)
-- Dependencies: 1874 1874
-- Name: pk_collection_id; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY collection
    ADD CONSTRAINT pk_collection_id PRIMARY KEY (collection_id);


--
-- TOC entry 2370 (class 2606 OID 27475)
-- Dependencies: 1879 1879
-- Name: pk_concept; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY concept
    ADD CONSTRAINT pk_concept PRIMARY KEY (concept_id);


--
-- TOC entry 2374 (class 2606 OID 27477)
-- Dependencies: 1881 1881
-- Name: pk_country_id; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY country
    ADD CONSTRAINT pk_country_id PRIMARY KEY (country_id);


--
-- TOC entry 2412 (class 2606 OID 27479)
-- Dependencies: 1901 1901
-- Name: pk_geographic_catalogue; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY geographic_catalogue
    ADD CONSTRAINT pk_geographic_catalogue PRIMARY KEY (geographic_catalogue_id);


--
-- TOC entry 2414 (class 2606 OID 27481)
-- Dependencies: 1902 1902
-- Name: pk_geographic_entity; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY geographic_entity
    ADD CONSTRAINT pk_geographic_entity PRIMARY KEY (geographic_entity_id);


--
-- TOC entry 2432 (class 2606 OID 27483)
-- Dependencies: 1911 1911
-- Name: pk_institution_id; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY institution
    ADD CONSTRAINT pk_institution_id PRIMARY KEY (institution_id);


--
-- TOC entry 2434 (class 2606 OID 27485)
-- Dependencies: 1912 1912
-- Name: pk_interaction_type; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY interaction_type
    ADD CONSTRAINT pk_interaction_type PRIMARY KEY (interaction_type_id);


--
-- TOC entry 2440 (class 2606 OID 27487)
-- Dependencies: 1916 1916
-- Name: pk_language_id; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY "language"
    ADD CONSTRAINT pk_language_id PRIMARY KEY (language_id);


--
-- TOC entry 2466 (class 2606 OID 27489)
-- Dependencies: 1929 1929
-- Name: pk_person_id; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY person
    ADD CONSTRAINT pk_person_id PRIMARY KEY (person_id);


--
-- TOC entry 2468 (class 2606 OID 27491)
-- Dependencies: 1930 1930 1930
-- Name: pk_person_id_institution_id; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY person_institution
    ADD CONSTRAINT pk_person_id_institution_id PRIMARY KEY (person_id, institution_id);


--
-- TOC entry 2470 (class 2606 OID 27493)
-- Dependencies: 1931 1931 1931
-- Name: pk_person_id_profile_id; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY person_profile
    ADD CONSTRAINT pk_person_id_profile_id PRIMARY KEY (person_id, profile_id);


--
-- TOC entry 2472 (class 2606 OID 27495)
-- Dependencies: 1932 1932 1932 1932
-- Name: pk_person_profile_taxon; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY person_profile_taxon
    ADD CONSTRAINT pk_person_profile_taxon PRIMARY KEY (person_id, profile_id, taxon_id);


--
-- TOC entry 2486 (class 2606 OID 27497)
-- Dependencies: 1939 1939
-- Name: pk_profile_id; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY profile
    ADD CONSTRAINT pk_profile_id PRIMARY KEY (profile_id);


--
-- TOC entry 2502 (class 2606 OID 27499)
-- Dependencies: 1947 1947
-- Name: pk_reference_element; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY reference_element
    ADD CONSTRAINT pk_reference_element PRIMARY KEY (reference_element_id);


--
-- TOC entry 2508 (class 2606 OID 27501)
-- Dependencies: 1950 1950
-- Name: pk_region_id; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY region
    ADD CONSTRAINT pk_region_id PRIMARY KEY (region_id);


--
-- TOC entry 2585 (class 2606 OID 27503)
-- Dependencies: 1989 1989
-- Name: pk_species_record_stage; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_description_stage
    ADD CONSTRAINT pk_species_record_stage PRIMARY KEY (taxon_description_stage_id);


--
-- TOC entry 2520 (class 2606 OID 27505)
-- Dependencies: 1956 1956 1956
-- Name: pk_species_record_stage_prof; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY species_record_stage_profile
    ADD CONSTRAINT pk_species_record_stage_prof PRIMARY KEY (species_record_stage_id, profile_id);


--
-- TOC entry 2539 (class 2606 OID 27507)
-- Dependencies: 1966 1966 1966
-- Name: pk_stage_transition_digraph; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY stage_transition_digraph
    ADD CONSTRAINT pk_stage_transition_digraph PRIMARY KEY (species_record_stage_from_id, species_record_stage_to_id);


--
-- TOC entry 2563 (class 2606 OID 27509)
-- Dependencies: 1978 1978
-- Name: pk_taxon_author_connector; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_author_connector
    ADD CONSTRAINT pk_taxon_author_connector PRIMARY KEY (taxon_author_connector_id);


--
-- TOC entry 2561 (class 2606 OID 27511)
-- Dependencies: 1977 1977 1977 1977
-- Name: pk_taxon_cate_author_sequence; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_author
    ADD CONSTRAINT pk_taxon_cate_author_sequence PRIMARY KEY (taxon_id, category, taxon_author_sequence);


--
-- TOC entry 2565 (class 2606 OID 27513)
-- Dependencies: 1979 1979
-- Name: pk_taxon_category_id; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_category
    ADD CONSTRAINT pk_taxon_category_id PRIMARY KEY (taxon_category_id);


--
-- TOC entry 2571 (class 2606 OID 27515)
-- Dependencies: 1982 1982
-- Name: pk_taxon_description_category; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_description_category
    ADD CONSTRAINT pk_taxon_description_category PRIMARY KEY (taxon_description_category_id);


--
-- TOC entry 2573 (class 2606 OID 27517)
-- Dependencies: 1983 1983
-- Name: pk_taxon_description_datatype; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_description_datatype
    ADD CONSTRAINT pk_taxon_description_datatype PRIMARY KEY (taxon_description_datatype_id);


--
-- TOC entry 2575 (class 2606 OID 27519)
-- Dependencies: 1984 1984
-- Name: pk_taxon_description_type_id; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_description_element
    ADD CONSTRAINT pk_taxon_description_type_id PRIMARY KEY (taxon_description_element_id);


--
-- TOC entry 2559 (class 2606 OID 27521)
-- Dependencies: 1976 1976
-- Name: pk_taxon_id; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT pk_taxon_id PRIMARY KEY (taxon_id);


--
-- TOC entry 2595 (class 2606 OID 27523)
-- Dependencies: 1994 1994
-- Name: pk_taxonomical_node_id; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxonomical_range
    ADD CONSTRAINT pk_taxonomical_node_id PRIMARY KEY (taxonomical_range_id);


--
-- TOC entry 2593 (class 2606 OID 27525)
-- Dependencies: 1993 1993 1993
-- Name: pk_taxorangnod_pretaxorangnod; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxonomical_hierarchy
    ADD CONSTRAINT pk_taxorangnod_pretaxorangnod PRIMARY KEY (taxonomical_range_id, ancestor_taxonomical_id);


--
-- TOC entry 2482 (class 2606 OID 27527)
-- Dependencies: 1937 1937
-- Name: preparation_method_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY preparation_method
    ADD CONSTRAINT preparation_method_pk PRIMARY KEY (preparation_method_id);


--
-- TOC entry 2484 (class 2606 OID 27529)
-- Dependencies: 1938 1938
-- Name: preservation_medium_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY preservation_medium
    ADD CONSTRAINT preservation_medium_pk PRIMARY KEY (preservation_medium_id);


--
-- TOC entry 2488 (class 2606 OID 27531)
-- Dependencies: 1940 1940
-- Name: project_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY project
    ADD CONSTRAINT project_pk PRIMARY KEY (project_id);


--
-- TOC entry 2490 (class 2606 OID 27533)
-- Dependencies: 1941 1941
-- Name: projection_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY projection
    ADD CONSTRAINT projection_pk PRIMARY KEY (projection_id);


--
-- TOC entry 2492 (class 2606 OID 27535)
-- Dependencies: 1942 1942
-- Name: protected_area_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY protected_area
    ADD CONSTRAINT protected_area_pk PRIMARY KEY (protected_area_id);


--
-- TOC entry 2494 (class 2606 OID 27537)
-- Dependencies: 1943 1943
-- Name: protected_area_type_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY protected_area_type
    ADD CONSTRAINT protected_area_type_pk PRIMARY KEY (protected_area_type_id);


--
-- TOC entry 2496 (class 2606 OID 27539)
-- Dependencies: 1944 1944
-- Name: protocol_attribute_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY protocol_attribute
    ADD CONSTRAINT protocol_attribute_pk PRIMARY KEY (protocol_attribute_id);


--
-- TOC entry 2498 (class 2606 OID 27541)
-- Dependencies: 1945 1945
-- Name: province_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY province
    ADD CONSTRAINT province_pk PRIMARY KEY (province_id);


--
-- TOC entry 2504 (class 2606 OID 27543)
-- Dependencies: 1948 1948 1948
-- Name: reference_element_value_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY reference_element_value
    ADD CONSTRAINT reference_element_value_pk PRIMARY KEY (reference_id, reference_element_id);


--
-- TOC entry 2500 (class 2606 OID 27545)
-- Dependencies: 1946 1946
-- Name: reference_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY reference
    ADD CONSTRAINT reference_pk PRIMARY KEY (reference_id);


--
-- TOC entry 2506 (class 2606 OID 27547)
-- Dependencies: 1949 1949
-- Name: reference_type_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY reference_type
    ADD CONSTRAINT reference_type_pk PRIMARY KEY (reference_type_id);


--
-- TOC entry 2510 (class 2606 OID 27549)
-- Dependencies: 1951 1951
-- Name: sampling_type_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY sampling_type
    ADD CONSTRAINT sampling_type_pk PRIMARY KEY (sampling_type_id);


--
-- TOC entry 2512 (class 2606 OID 27551)
-- Dependencies: 1952 1952
-- Name: sex_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY sex
    ADD CONSTRAINT sex_pk PRIMARY KEY (sex_id);


--
-- TOC entry 2516 (class 2606 OID 27553)
-- Dependencies: 1954 1954
-- Name: site_calculation_method_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY site_calculation_method
    ADD CONSTRAINT site_calculation_method_pk PRIMARY KEY (site_calculation_method_id);


--
-- TOC entry 2518 (class 2606 OID 27555)
-- Dependencies: 1955 1955
-- Name: site_coordinates_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY site_coordinate
    ADD CONSTRAINT site_coordinates_pk PRIMARY KEY (site_coordinate_id);


--
-- TOC entry 2514 (class 2606 OID 27557)
-- Dependencies: 1953 1953
-- Name: site_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY site
    ADD CONSTRAINT site_pk PRIMARY KEY (site_id);


--
-- TOC entry 2577 (class 2606 OID 27559)
-- Dependencies: 1985 1985 1985 1985
-- Name: species_record_institution_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_description_institution
    ADD CONSTRAINT species_record_institution_pk PRIMARY KEY (taxon_id, taxon_description_sequence, institution_id);


--
-- TOC entry 2579 (class 2606 OID 27561)
-- Dependencies: 1986 1986 1986 1986 1986
-- Name: species_record_person_profile_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_description_person_profile
    ADD CONSTRAINT species_record_person_profile_pk PRIMARY KEY (taxon_id, taxon_description_sequence, person_id, profile_id);


--
-- TOC entry 2522 (class 2606 OID 27563)
-- Dependencies: 1957 1957 1957
-- Name: specimen_annotation_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY specimen_annotation
    ADD CONSTRAINT specimen_annotation_pk PRIMARY KEY (specimen_id, annotation_id);


--
-- TOC entry 2524 (class 2606 OID 27565)
-- Dependencies: 1958 1958
-- Name: specimen_category_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY specimen_category
    ADD CONSTRAINT specimen_category_pk PRIMARY KEY (specimen_category_id);


--
-- TOC entry 2526 (class 2606 OID 27567)
-- Dependencies: 1960 1960 1960
-- Name: specimen_life_form_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY specimen_life_form
    ADD CONSTRAINT specimen_life_form_pk PRIMARY KEY (specimen_id, life_form_id);


--
-- TOC entry 2528 (class 2606 OID 27569)
-- Dependencies: 1961 1961 1961 1961
-- Name: specimen_life_stage_sex_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY specimen_life_stage_sex
    ADD CONSTRAINT specimen_life_stage_sex_pk PRIMARY KEY (specimen_id, life_stage_id, sex_id);


--
-- TOC entry 2619 (class 2606 OID 53115)
-- Dependencies: 2006 2006
-- Name: specimen_pk2; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY specimen
    ADD CONSTRAINT specimen_pk2 PRIMARY KEY (specimen_id);


--
-- TOC entry 2530 (class 2606 OID 27573)
-- Dependencies: 1962 1962
-- Name: specimen_type_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY specimen_type
    ADD CONSTRAINT specimen_type_pk PRIMARY KEY (specimen_type_id);


--
-- TOC entry 2532 (class 2606 OID 27575)
-- Dependencies: 1963 1963
-- Name: specimen_variable_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY specimen_variable
    ADD CONSTRAINT specimen_variable_pk PRIMARY KEY (specimen_variable_id);


--
-- TOC entry 2534 (class 2606 OID 27577)
-- Dependencies: 1964 1964
-- Name: specimen_variable_value_id; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY specimen_variable_value
    ADD CONSTRAINT specimen_variable_value_id PRIMARY KEY (specimen_variable_value_id);


--
-- TOC entry 2537 (class 2606 OID 27579)
-- Dependencies: 1965 1965 1965 1965 1965
-- Name: stage_transition_date_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY stage_transition_date
    ADD CONSTRAINT stage_transition_date_pk PRIMARY KEY (taxon_id, taxon_description_sequence, taxon_description_stage_id, transition_date);


--
-- TOC entry 2541 (class 2606 OID 27581)
-- Dependencies: 1967 1967
-- Name: storage_type_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY storage_type
    ADD CONSTRAINT storage_type_pk PRIMARY KEY (storage_type_id);


--
-- TOC entry 2543 (class 2606 OID 27583)
-- Dependencies: 1968 1968
-- Name: substrate_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY substrate
    ADD CONSTRAINT substrate_pk PRIMARY KEY (substrate_id);


--
-- TOC entry 2545 (class 2606 OID 27585)
-- Dependencies: 1969 1969
-- Name: system_module_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY system_module
    ADD CONSTRAINT system_module_pk PRIMARY KEY (module_id);


--
-- TOC entry 2549 (class 2606 OID 27587)
-- Dependencies: 1971 1971
-- Name: system_option_type_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY system_option_type
    ADD CONSTRAINT system_option_type_pk PRIMARY KEY (system_option_type_id);


--
-- TOC entry 2551 (class 2606 OID 27589)
-- Dependencies: 1972 1972
-- Name: system_subsystem_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY system_subsystem
    ADD CONSTRAINT system_subsystem_pk PRIMARY KEY (subsystem_id);


--
-- TOC entry 2553 (class 2606 OID 27591)
-- Dependencies: 1973 1973
-- Name: system_user_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY system_user
    ADD CONSTRAINT system_user_pk PRIMARY KEY (user_id);


--
-- TOC entry 2557 (class 2606 OID 27593)
-- Dependencies: 1975 1975
-- Name: system_user_type_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY system_user_type
    ADD CONSTRAINT system_user_type_pk PRIMARY KEY (user_type_id);


--
-- TOC entry 2569 (class 2606 OID 27595)
-- Dependencies: 1981 1981 1981 1981
-- Name: taxon_description_audience_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_description_audience
    ADD CONSTRAINT taxon_description_audience_pk PRIMARY KEY (taxon_id, taxon_description_sequence, audience_id);


--
-- TOC entry 2567 (class 2606 OID 27597)
-- Dependencies: 1980 1980 1980
-- Name: taxon_description_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_description
    ADD CONSTRAINT taxon_description_pk PRIMARY KEY (taxon_description_sequence, taxon_id);


--
-- TOC entry 2581 (class 2606 OID 27599)
-- Dependencies: 1987 1987
-- Name: taxon_description_record_id_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_description_record
    ADD CONSTRAINT taxon_description_record_id_pk PRIMARY KEY (taxon_description_record_id);


--
-- TOC entry 2583 (class 2606 OID 27601)
-- Dependencies: 1988 1988 1988
-- Name: taxon_description_record_reference_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_description_record_reference
    ADD CONSTRAINT taxon_description_record_reference_pk PRIMARY KEY (taxon_description_record_id, reference_id);


--
-- TOC entry 2587 (class 2606 OID 27603)
-- Dependencies: 1990 1990 1990 1990
-- Name: taxon_name_history_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_name_history
    ADD CONSTRAINT taxon_name_history_pk PRIMARY KEY (taxon_id, initial_timestamp, final_timestamp);


--
-- TOC entry 2589 (class 2606 OID 27605)
-- Dependencies: 1991 1991 1991
-- Name: taxon_nomenclatural_group_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_nomenclatural_group
    ADD CONSTRAINT taxon_nomenclatural_group_pk PRIMARY KEY (taxon_id, nomenclatural_group_id);


--
-- TOC entry 2591 (class 2606 OID 27607)
-- Dependencies: 1992 1992 1992
-- Name: taxon_reference_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY taxon_reference
    ADD CONSTRAINT taxon_reference_pk PRIMARY KEY (taxon_id, reference_id);


--
-- TOC entry 2597 (class 2606 OID 27609)
-- Dependencies: 1995 1995
-- Name: topographic_sheet_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY topographic_sheet
    ADD CONSTRAINT topographic_sheet_pk PRIMARY KEY (topographic_sheet_id);


--
-- TOC entry 2599 (class 2606 OID 27611)
-- Dependencies: 1996 1996 1996
-- Name: transacted_specimen_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY transacted_specimen
    ADD CONSTRAINT transacted_specimen_pk PRIMARY KEY (transaction_id, specimen_id);


--
-- TOC entry 2601 (class 2606 OID 27613)
-- Dependencies: 1997 1997
-- Name: transacted_specimen_status_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY transacted_specimen_status
    ADD CONSTRAINT transacted_specimen_status_pk PRIMARY KEY (transacted_specimen_status_id);


--
-- TOC entry 2603 (class 2606 OID 27615)
-- Dependencies: 1998 1998
-- Name: transaction_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY "transaction"
    ADD CONSTRAINT transaction_pk PRIMARY KEY (transaction_id);


--
-- TOC entry 2605 (class 2606 OID 27617)
-- Dependencies: 1999 1999
-- Name: transaction_type_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY transaction_type
    ADD CONSTRAINT transaction_type_pk PRIMARY KEY (transaction_type_id);


--
-- TOC entry 2607 (class 2606 OID 27619)
-- Dependencies: 2000 2000
-- Name: type_specimen_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY type_specimen
    ADD CONSTRAINT type_specimen_pk PRIMARY KEY (type_specimen_id);


--
-- TOC entry 2609 (class 2606 OID 27621)
-- Dependencies: 2001 2001
-- Name: type_specimen_type_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY type_specimen_type
    ADD CONSTRAINT type_specimen_type_pk PRIMARY KEY (type_specimen_type_id);


--
-- TOC entry 2611 (class 2606 OID 27623)
-- Dependencies: 2002 2002 2002 2002
-- Name: user_nomenclatural_group_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY user_nomenclatural_group
    ADD CONSTRAINT user_nomenclatural_group_pk PRIMARY KEY (nomenclatural_group_id, user_id, "sequence");


--
-- TOC entry 2613 (class 2606 OID 27625)
-- Dependencies: 2003 2003 2003 2003
-- Name: user_taxon_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY user_taxon
    ADD CONSTRAINT user_taxon_pk PRIMARY KEY (taxon_id, user_id, "sequence");


--
-- TOC entry 2615 (class 2606 OID 27627)
-- Dependencies: 2004 2004
-- Name: versant_pk; Type: CONSTRAINT; Schema: ara; Owner: ara; Tablespace: 
--

ALTER TABLE ONLY versant
    ADD CONSTRAINT versant_pk PRIMARY KEY (versant_id);


--
-- TOC entry 2535 (class 1259 OID 27628)
-- Dependencies: 1965 1965
-- Name: fki_taxon_description_stage_transition_date_fk; Type: INDEX; Schema: ara; Owner: ara; Tablespace: 
--

CREATE INDEX fki_taxon_description_stage_transition_date_fk ON stage_transition_date USING btree (taxon_id, taxon_description_sequence);


--
-- TOC entry 2711 (class 2606 OID 27629)
-- Dependencies: 2544 1969 1970
-- Name: SYSTEM_MODULE_OPTION_FK; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY system_option
    ADD CONSTRAINT "SYSTEM_MODULE_OPTION_FK" FOREIGN KEY (module_id) REFERENCES system_module(module_id);


--
-- TOC entry 2622 (class 2606 OID 27634)
-- Dependencies: 2469 1867 1867 1931 1931
-- Name: annotation_person_profile; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY annotation
    ADD CONSTRAINT annotation_person_profile FOREIGN KEY (annotator_person_id, annotator_profile_id) REFERENCES person_profile(person_id, profile_id);


--
-- TOC entry 2691 (class 2606 OID 27639)
-- Dependencies: 1941 1953 2489
-- Name: base_projection_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY site
    ADD CONSTRAINT base_projection_fk FOREIGN KEY (base_projection_id) REFERENCES projection(projection_id);


--
-- TOC entry 2624 (class 2606 OID 27644)
-- Dependencies: 1945 1872 2497
-- Name: canton_ifam_province; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY canton_ifam
    ADD CONSTRAINT canton_ifam_province FOREIGN KEY (province_id) REFERENCES province(province_id);


--
-- TOC entry 2623 (class 2606 OID 27649)
-- Dependencies: 1871 1945 2497
-- Name: canton_province; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY canton
    ADD CONSTRAINT canton_province FOREIGN KEY (province_id) REFERENCES province(province_id);


--
-- TOC entry 2668 (class 2606 OID 27654)
-- Dependencies: 2359 1921 1874
-- Name: collection_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY list_table_collection
    ADD CONSTRAINT collection_fk FOREIGN KEY (collection_id) REFERENCES collection(collection_id);


--
-- TOC entry 2627 (class 2606 OID 27659)
-- Dependencies: 2359 1875 1874
-- Name: collection_protocol_collection_pk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY collection_protocol
    ADD CONSTRAINT collection_protocol_collection_pk FOREIGN KEY (collection_id) REFERENCES collection(collection_id);


--
-- TOC entry 2626 (class 2606 OID 27664)
-- Dependencies: 1944 2495 1875
-- Name: collection_protocol_protocol_attribute_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY collection_protocol
    ADD CONSTRAINT collection_protocol_protocol_attribute_fk FOREIGN KEY (protocol_attribute_id) REFERENCES protocol_attribute(protocol_attribute_id);


--
-- TOC entry 2628 (class 2606 OID 44885)
-- Dependencies: 2465 1876 1929
-- Name: collector_observer_person_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY collector_observer
    ADD CONSTRAINT collector_observer_person_fk FOREIGN KEY (collector_person_id) REFERENCES person(person_id);


--
-- TOC entry 2632 (class 2606 OID 27674)
-- Dependencies: 1877 1878 2367
-- Name: component_part_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY component
    ADD CONSTRAINT component_part_fk FOREIGN KEY (component_part_id) REFERENCES component_part(component_part_id);


--
-- TOC entry 2631 (class 2606 OID 27679)
-- Dependencies: 2481 1877 1937
-- Name: component_preparation_method_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY component
    ADD CONSTRAINT component_preparation_method_fk FOREIGN KEY (preparation_method_id) REFERENCES preparation_method(preparation_method_id);


--
-- TOC entry 2630 (class 2606 OID 53309)
-- Dependencies: 2618 1877 2006
-- Name: component_specimen_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY component
    ADD CONSTRAINT component_specimen_fk FOREIGN KEY (specimen_id) REFERENCES specimen(specimen_id);


--
-- TOC entry 2635 (class 2606 OID 27689)
-- Dependencies: 1883 1882 2377
-- Name: culture_medium_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY culture
    ADD CONSTRAINT culture_medium_fk FOREIGN KEY (culture_medium_id) REFERENCES culture_medium(culture_medium_id);


--
-- TOC entry 2634 (class 2606 OID 27694)
-- Dependencies: 1931 1882 1882 1931 2469
-- Name: culture_responsible_person_profile; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY culture
    ADD CONSTRAINT culture_responsible_person_profile FOREIGN KEY (responsible_person_id, responsible_profile_id) REFERENCES person_profile(person_id, profile_id);


--
-- TOC entry 2633 (class 2606 OID 27699)
-- Dependencies: 2379 1882 1884
-- Name: culture_storage_medium_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY culture
    ADD CONSTRAINT culture_storage_medium_fk FOREIGN KEY (culture_storage_medium_id) REFERENCES culture_storage_medium(culture_storage_medium_id);


--
-- TOC entry 2636 (class 2606 OID 27704)
-- Dependencies: 1871 1886 2353
-- Name: district_canton_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY district
    ADD CONSTRAINT district_canton_fk FOREIGN KEY (canton_id) REFERENCES canton(canton_id);


--
-- TOC entry 2637 (class 2606 OID 27709)
-- Dependencies: 1888 1889 2387
-- Name: ecological_variable_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY ecological_variable_value
    ADD CONSTRAINT ecological_variable_fk FOREIGN KEY (ecological_variable_id) REFERENCES ecological_variable(ecological_variable_id);


--
-- TOC entry 2653 (class 2606 OID 27714)
-- Dependencies: 2389 1898 1889
-- Name: ecological_variable_value_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation_ecological_var
    ADD CONSTRAINT ecological_variable_value_fk FOREIGN KEY (ecological_variable_value_id) REFERENCES ecological_variable_value(ecological_variable_value_id);


--
-- TOC entry 2644 (class 2606 OID 27719)
-- Dependencies: 2395 1895 1892
-- Name: exposition_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation
    ADD CONSTRAINT exposition_fk FOREIGN KEY (exposition_id) REFERENCES exposition(exposition_id);


--
-- TOC entry 2690 (class 2606 OID 27724)
-- Dependencies: 2399 1953 1894
-- Name: feature_type_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY site
    ADD CONSTRAINT feature_type_fk FOREIGN KEY (feature_type_id) REFERENCES feature_type(feature_type_id);


--
-- TOC entry 2745 (class 2606 OID 27729)
-- Dependencies: 1977 2562 1978
-- Name: fk132_taxon_author_connector; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_author
    ADD CONSTRAINT fk132_taxon_author_connector FOREIGN KEY (taxon_author_connector_id) REFERENCES taxon_author_connector(taxon_author_connector_id);


--
-- TOC entry 2742 (class 2606 OID 27734)
-- Dependencies: 2558 1976 1976
-- Name: fk67_ancestor_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_ancestor_id FOREIGN KEY (ancestor_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2741 (class 2606 OID 27739)
-- Dependencies: 1976 1976 2558
-- Name: fk67_class_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_class_taxon_id FOREIGN KEY (class_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2740 (class 2606 OID 27744)
-- Dependencies: 1874 1976 2359
-- Name: fk67_collection_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_collection_id FOREIGN KEY (collection_id) REFERENCES collection(collection_id);


--
-- TOC entry 2739 (class 2606 OID 27749)
-- Dependencies: 2558 1976 1976
-- Name: fk67_dominium_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_dominium_taxon_id FOREIGN KEY (dominium_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2738 (class 2606 OID 27754)
-- Dependencies: 1976 1976 2558
-- Name: fk67_family_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_family_taxon_id FOREIGN KEY (family_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2737 (class 2606 OID 27759)
-- Dependencies: 2558 1976 1976
-- Name: fk67_genus_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_genus_taxon_id FOREIGN KEY (genus_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2736 (class 2606 OID 27764)
-- Dependencies: 1976 1976 2558
-- Name: fk67_kingdom_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_kingdom_taxon_id FOREIGN KEY (kingdom_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2735 (class 2606 OID 27769)
-- Dependencies: 1976 2558 1976
-- Name: fk67_order_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_order_taxon_id FOREIGN KEY (order_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2734 (class 2606 OID 27774)
-- Dependencies: 1976 1976 2558
-- Name: fk67_phylum_division_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_phylum_division_taxon_id FOREIGN KEY (phylum_division_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2733 (class 2606 OID 27779)
-- Dependencies: 1976 1976 2558
-- Name: fk67_section_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_section_taxon_id FOREIGN KEY (section_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2732 (class 2606 OID 27784)
-- Dependencies: 2558 1976 1976
-- Name: fk67_species_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_species_taxon_id FOREIGN KEY (species_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2731 (class 2606 OID 27789)
-- Dependencies: 2558 1976 1976
-- Name: fk67_stirps_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_stirps_taxon_id FOREIGN KEY (stirps_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2730 (class 2606 OID 27794)
-- Dependencies: 1976 1976 2558
-- Name: fk67_subclass_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_subclass_taxon_id FOREIGN KEY (subclass_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2729 (class 2606 OID 27799)
-- Dependencies: 1976 1976 2558
-- Name: fk67_subfamily_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_subfamily_taxon_id FOREIGN KEY (subfamily_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2728 (class 2606 OID 27804)
-- Dependencies: 1976 1976 2558
-- Name: fk67_subgenus_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_subgenus_taxon_id FOREIGN KEY (subgenus_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2727 (class 2606 OID 27809)
-- Dependencies: 1976 1976 2558
-- Name: fk67_suborder_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_suborder_taxon_id FOREIGN KEY (suborder_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2726 (class 2606 OID 27814)
-- Dependencies: 1976 1976 2558
-- Name: fk67_subphylum_subdiv_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_subphylum_subdiv_taxon_id FOREIGN KEY (subphylum_subdivision_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2725 (class 2606 OID 27819)
-- Dependencies: 1976 1976 2558
-- Name: fk67_subsection_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_subsection_taxon_id FOREIGN KEY (subsection_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2724 (class 2606 OID 27824)
-- Dependencies: 1976 1976 2558
-- Name: fk67_subspecies_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_subspecies_taxon_id FOREIGN KEY (subspecies_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2723 (class 2606 OID 27829)
-- Dependencies: 1976 1976 2558
-- Name: fk67_subtribe_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_subtribe_taxon_id FOREIGN KEY (subtribe_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2722 (class 2606 OID 27834)
-- Dependencies: 1976 1976 2558
-- Name: fk67_superfamily_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_superfamily_taxon_id FOREIGN KEY (superfamily_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2721 (class 2606 OID 27839)
-- Dependencies: 1976 2558 1976
-- Name: fk67_synonym_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_synonym_taxon_id FOREIGN KEY (synonym_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2720 (class 2606 OID 27844)
-- Dependencies: 1979 1976 2564
-- Name: fk67_taxon_category_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_taxon_category_id FOREIGN KEY (taxon_category_id) REFERENCES taxon_category(taxon_category_id);


--
-- TOC entry 2719 (class 2606 OID 27849)
-- Dependencies: 1976 1994 2594
-- Name: fk67_taxonomical_range_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_taxonomical_range_id FOREIGN KEY (taxonomical_range_id) REFERENCES taxonomical_range(taxonomical_range_id);


--
-- TOC entry 2718 (class 2606 OID 27854)
-- Dependencies: 2558 1976 1976
-- Name: fk67_tribe_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_tribe_taxon_id FOREIGN KEY (tribe_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2717 (class 2606 OID 27859)
-- Dependencies: 1976 1976 2558
-- Name: fk67_variety_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk67_variety_taxon_id FOREIGN KEY (variety_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2762 (class 2606 OID 27864)
-- Dependencies: 1994 1993 2594
-- Name: fk70_prede_range_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxonomical_hierarchy
    ADD CONSTRAINT fk70_prede_range_id FOREIGN KEY (ancestor_taxonomical_id) REFERENCES taxonomical_range(taxonomical_range_id);


--
-- TOC entry 2761 (class 2606 OID 27869)
-- Dependencies: 1994 2594 1993
-- Name: fk70_taxonomical_range_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxonomical_hierarchy
    ADD CONSTRAINT fk70_taxonomical_range_id FOREIGN KEY (taxonomical_range_id) REFERENCES taxonomical_range(taxonomical_range_id);


--
-- TOC entry 2744 (class 2606 OID 27874)
-- Dependencies: 1976 1977 2558
-- Name: fk74_taxon_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_author
    ADD CONSTRAINT fk74_taxon_id FOREIGN KEY (taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2749 (class 2606 OID 27879)
-- Dependencies: 2570 1982 1984
-- Name: fk76_taxon_desc_category; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_description_element
    ADD CONSTRAINT fk76_taxon_desc_category FOREIGN KEY (taxon_description_category_id) REFERENCES taxon_description_category(taxon_description_category_id);


--
-- TOC entry 2675 (class 2606 OID 27884)
-- Dependencies: 2431 1930 1911
-- Name: fk7_institution_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY person_institution
    ADD CONSTRAINT fk7_institution_id FOREIGN KEY (institution_id) REFERENCES institution(institution_id);


--
-- TOC entry 2677 (class 2606 OID 27889)
-- Dependencies: 1931 1929 2465
-- Name: fk7_person_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY person_profile
    ADD CONSTRAINT fk7_person_id FOREIGN KEY (person_id) REFERENCES person(person_id);


--
-- TOC entry 2674 (class 2606 OID 27894)
-- Dependencies: 1930 1929 2465
-- Name: fk7_person_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY person_institution
    ADD CONSTRAINT fk7_person_id FOREIGN KEY (person_id) REFERENCES person(person_id);


--
-- TOC entry 2676 (class 2606 OID 27899)
-- Dependencies: 1931 1939 2485
-- Name: fk7_profile_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY person_profile
    ADD CONSTRAINT fk7_profile_id FOREIGN KEY (profile_id) REFERENCES profile(profile_id);


--
-- TOC entry 2681 (class 2606 OID 27904)
-- Dependencies: 2465 1929 1932
-- Name: fk8_person_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY person_profile_taxon
    ADD CONSTRAINT fk8_person_id FOREIGN KEY (person_id) REFERENCES person(person_id);


--
-- TOC entry 2680 (class 2606 OID 27909)
-- Dependencies: 2469 1931 1931 1932 1932
-- Name: fk8_person_profile; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY person_profile_taxon
    ADD CONSTRAINT fk8_person_profile FOREIGN KEY (person_id, profile_id) REFERENCES person_profile(person_id, profile_id);


--
-- TOC entry 2679 (class 2606 OID 27914)
-- Dependencies: 1939 1932 2485
-- Name: fk8_profile_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY person_profile_taxon
    ADD CONSTRAINT fk8_profile_id FOREIGN KEY (profile_id) REFERENCES profile(profile_id);


--
-- TOC entry 2666 (class 2606 OID 27919)
-- Dependencies: 2369 1879 1916
-- Name: fk_language_reference_concept; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY "language"
    ADD CONSTRAINT fk_language_reference_concept FOREIGN KEY (concept_id) REFERENCES concept(concept_id);


--
-- TOC entry 2678 (class 2606 OID 27924)
-- Dependencies: 2558 1976 1932
-- Name: fk_person_p_fk8_taxon_taxon; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY person_profile_taxon
    ADD CONSTRAINT fk_person_p_fk8_taxon_taxon FOREIGN KEY (taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2743 (class 2606 OID 27929)
-- Dependencies: 1977 1931 2469 1977 1931
-- Name: fk_person_profile_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_author
    ADD CONSTRAINT fk_person_profile_id FOREIGN KEY (taxon_author_person_id, taxon_author_person_profile_id) REFERENCES person_profile(person_id, profile_id);


--
-- TOC entry 2694 (class 2606 OID 27934)
-- Dependencies: 1956 2584 1989
-- Name: fk_species__ref_72892_species_; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY species_record_stage_profile
    ADD CONSTRAINT fk_species__ref_72892_species_ FOREIGN KEY (species_record_stage_id) REFERENCES taxon_description_stage(taxon_description_stage_id);


--
-- TOC entry 2693 (class 2606 OID 27939)
-- Dependencies: 1956 2485 1939
-- Name: fk_species__ref_72896_profile; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY species_record_stage_profile
    ADD CONSTRAINT fk_species__ref_72896_profile FOREIGN KEY (profile_id) REFERENCES profile(profile_id);


--
-- TOC entry 2708 (class 2606 OID 27944)
-- Dependencies: 1966 1989 2584
-- Name: fk_stage_tr_ref_65607_species_; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY stage_transition_digraph
    ADD CONSTRAINT fk_stage_tr_ref_65607_species_ FOREIGN KEY (species_record_stage_from_id) REFERENCES taxon_description_stage(taxon_description_stage_id);


--
-- TOC entry 2707 (class 2606 OID 27949)
-- Dependencies: 1989 1966 2584
-- Name: fk_stage_tr_ref_65613_species_; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY stage_transition_digraph
    ADD CONSTRAINT fk_stage_tr_ref_65613_species_ FOREIGN KEY (species_record_stage_to_id) REFERENCES taxon_description_stage(taxon_description_stage_id);


--
-- TOC entry 2748 (class 2606 OID 27954)
-- Dependencies: 2572 1984 1983
-- Name: fk_taxon_de_reference_taxon_aa; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_description_element
    ADD CONSTRAINT fk_taxon_de_reference_taxon_aa FOREIGN KEY (taxon_description_datatype_id) REFERENCES taxon_description_datatype(taxon_description_datatype_id);


--
-- TOC entry 2716 (class 2606 OID 27959)
-- Dependencies: 2373 1976 1881
-- Name: fk_taxon_fk76_taxo_country; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT fk_taxon_fk76_taxo_country FOREIGN KEY (country_id) REFERENCES country(country_id);


--
-- TOC entry 2646 (class 2606 OID 27964)
-- Dependencies: 1896 1874 2359
-- Name: gathering_collection_collection_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation_collection
    ADD CONSTRAINT gathering_collection_collection_fk FOREIGN KEY (collection_id) REFERENCES collection(collection_id);


--
-- TOC entry 2643 (class 2606 OID 27969)
-- Dependencies: 1895 1874 2359
-- Name: gathering_collection_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation
    ADD CONSTRAINT gathering_collection_fk FOREIGN KEY (collection_id) REFERENCES collection(collection_id);


--
-- TOC entry 2645 (class 2606 OID 27974)
-- Dependencies: 1896 1895 2401
-- Name: gathering_collection_gathering_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation_collection
    ADD CONSTRAINT gathering_collection_gathering_fk FOREIGN KEY (gathering_observation_id) REFERENCES gathering_observation(gathering_observation_id);


--
-- TOC entry 2629 (class 2606 OID 27984)
-- Dependencies: 2401 1876 1895
-- Name: gathering_collector_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY collector_observer
    ADD CONSTRAINT gathering_collector_fk FOREIGN KEY (gathering_observation_id) REFERENCES gathering_observation(gathering_observation_id);


--
-- TOC entry 2651 (class 2606 OID 27989)
-- Dependencies: 2359 1897 1874
-- Name: gathering_detail_collection_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation_detail
    ADD CONSTRAINT gathering_detail_collection_fk FOREIGN KEY (collection_id) REFERENCES collection(collection_id);


--
-- TOC entry 2650 (class 2606 OID 27994)
-- Dependencies: 1897 2401 1895
-- Name: gathering_detail_gathering_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation_detail
    ADD CONSTRAINT gathering_detail_gathering_fk FOREIGN KEY (gathering_observation_id) REFERENCES gathering_observation(gathering_observation_id);


--
-- TOC entry 2649 (class 2606 OID 27999)
-- Dependencies: 1897 2435 1913
-- Name: gathering_detail_label; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation_detail
    ADD CONSTRAINT gathering_detail_label FOREIGN KEY (label_id) REFERENCES label(label_id);


--
-- TOC entry 2648 (class 2606 OID 28004)
-- Dependencies: 2451 1922 1897
-- Name: gathering_detail_morphological_description; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation_detail
    ADD CONSTRAINT gathering_detail_morphological_description FOREIGN KEY (morphological_description_id) REFERENCES morphological_description(morphological_description_id);


--
-- TOC entry 2647 (class 2606 OID 28009)
-- Dependencies: 1897 1928 2463
-- Name: gathering_detail_original_label_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation_detail
    ADD CONSTRAINT gathering_detail_original_label_fk FOREIGN KEY (original_label_id) REFERENCES original_label(original_label_id);


--
-- TOC entry 2642 (class 2606 OID 28014)
-- Dependencies: 1913 2435 1895
-- Name: gathering_label_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation
    ADD CONSTRAINT gathering_label_fk FOREIGN KEY (label_id) REFERENCES label(label_id);


--
-- TOC entry 2655 (class 2606 OID 28019)
-- Dependencies: 1900 1895 2401
-- Name: gathering_observation_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation_project
    ADD CONSTRAINT gathering_observation_fk FOREIGN KEY (gathering_observation_id) REFERENCES gathering_observation(gathering_observation_id);


--
-- TOC entry 2652 (class 2606 OID 28024)
-- Dependencies: 1895 1898 2401
-- Name: gathering_observation_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation_ecological_var
    ADD CONSTRAINT gathering_observation_fk FOREIGN KEY (gathering_observation_id) REFERENCES gathering_observation(gathering_observation_id);


--
-- TOC entry 2794 (class 2606 OID 53116)
-- Dependencies: 2006 1899 2407
-- Name: gathering_observation_method_fk2; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen
    ADD CONSTRAINT gathering_observation_method_fk2 FOREIGN KEY (gathering_observation_method_id) REFERENCES gathering_observation_method(gathering_observation_method_id);


--
-- TOC entry 2641 (class 2606 OID 28034)
-- Dependencies: 1928 1895 2463
-- Name: gathering_original_label_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation
    ADD CONSTRAINT gathering_original_label_fk FOREIGN KEY (original_label_id) REFERENCES original_label(original_label_id);


--
-- TOC entry 2640 (class 2606 OID 28039)
-- Dependencies: 1929 2465 1895
-- Name: gathering_responsible_person_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation
    ADD CONSTRAINT gathering_responsible_person_fk FOREIGN KEY (responsible_person_id) REFERENCES person(person_id);


--
-- TOC entry 2639 (class 2606 OID 28044)
-- Dependencies: 1895 1951 2509
-- Name: gathering_sampling_type_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation
    ADD CONSTRAINT gathering_sampling_type_fk FOREIGN KEY (sampling_type_id) REFERENCES sampling_type(sampling_type_id);


--
-- TOC entry 2638 (class 2606 OID 28049)
-- Dependencies: 1895 1953 2513
-- Name: gathering_site_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation
    ADD CONSTRAINT gathering_site_fk FOREIGN KEY (site_id) REFERENCES site(site_id);


--
-- TOC entry 2657 (class 2606 OID 28054)
-- Dependencies: 1904 2415 1903
-- Name: geographic_layer_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY georeferenced_site
    ADD CONSTRAINT geographic_layer_fk FOREIGN KEY (geographic_layer_id) REFERENCES geographic_layer(geographic_layer_id);


--
-- TOC entry 2659 (class 2606 OID 53202)
-- Dependencies: 1929 2465 1906
-- Name: identification_person_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY identification
    ADD CONSTRAINT identification_person_fk FOREIGN KEY (valuer_person_id) REFERENCES person(person_id);


--
-- TOC entry 2658 (class 2606 OID 53207)
-- Dependencies: 1906 2618 2006
-- Name: identification_specimen_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY identification
    ADD CONSTRAINT identification_specimen_fk FOREIGN KEY (specimen_id) REFERENCES specimen(specimen_id);


--
-- TOC entry 2660 (class 2606 OID 53089)
-- Dependencies: 2005 1906 2616
-- Name: identification_status_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY identification
    ADD CONSTRAINT identification_status_fk FOREIGN KEY (identification_status_id) REFERENCES identification_status(identification_status_id);


--
-- TOC entry 2662 (class 2606 OID 28064)
-- Dependencies: 1976 2558 1906
-- Name: identification_taxon_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY identification
    ADD CONSTRAINT identification_taxon_fk FOREIGN KEY (taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2661 (class 2606 OID 28069)
-- Dependencies: 2425 1906 1908
-- Name: identification_type_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY identification
    ADD CONSTRAINT identification_type_fk FOREIGN KEY (identification_type_id) REFERENCES identification_type(identification_type_id);


--
-- TOC entry 2796 (class 2606 OID 53256)
-- Dependencies: 2007 2007 1906 2421 1906 1906 2007
-- Name: identifier_identification_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY identifier
    ADD CONSTRAINT identifier_identification_fk FOREIGN KEY (specimen_id, identification_sequence, initial_timestamp) REFERENCES identification(specimen_id, identification_sequence, initial_timestamp);


--
-- TOC entry 2795 (class 2606 OID 53261)
-- Dependencies: 1929 2465 2007
-- Name: identifier_person_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY identifier
    ADD CONSTRAINT identifier_person_fk FOREIGN KEY (identifier_person_id) REFERENCES person(person_id);


--
-- TOC entry 2665 (class 2606 OID 28089)
-- Dependencies: 1976 2558 1910
-- Name: inmediate_predecessor_history_predecessor_taxon_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY inmediate_predecessor_history
    ADD CONSTRAINT inmediate_predecessor_history_predecessor_taxon_fk FOREIGN KEY (predecessor_taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2664 (class 2606 OID 28094)
-- Dependencies: 1910 2558 1976
-- Name: inmediate_predecessor_history_taxon_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY inmediate_predecessor_history
    ADD CONSTRAINT inmediate_predecessor_history_taxon_fk FOREIGN KEY (taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2663 (class 2606 OID 28099)
-- Dependencies: 2594 1994 1910
-- Name: inmediate_predecessor_history_taxonomical_range_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY inmediate_predecessor_history
    ADD CONSTRAINT inmediate_predecessor_history_taxonomical_range_fk FOREIGN KEY (taxon_taxonomical_range_id) REFERENCES taxonomical_range(taxonomical_range_id);


--
-- TOC entry 2700 (class 2606 OID 28104)
-- Dependencies: 1960 2441 1917
-- Name: life_form_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen_life_form
    ADD CONSTRAINT life_form_fk FOREIGN KEY (life_form_id) REFERENCES life_form(life_form_id);


--
-- TOC entry 2703 (class 2606 OID 28109)
-- Dependencies: 1961 2443 1918
-- Name: life_stage_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen_life_stage_sex
    ADD CONSTRAINT life_stage_fk FOREIGN KEY (life_stage_id) REFERENCES life_stage(life_stage_id);


--
-- TOC entry 2667 (class 2606 OID 28114)
-- Dependencies: 1920 2447 1921
-- Name: list_table_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY list_table_collection
    ADD CONSTRAINT list_table_fk FOREIGN KEY (list_table_id) REFERENCES list_table(list_table_id);


--
-- TOC entry 2669 (class 2606 OID 53077)
-- Dependencies: 2465 1929 1922
-- Name: morphological_description_person_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY morphological_description
    ADD CONSTRAINT morphological_description_person_fk FOREIGN KEY (description_person_id) REFERENCES person(person_id);


--
-- TOC entry 2625 (class 2606 OID 28124)
-- Dependencies: 1923 1873 2453
-- Name: natural_region_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY collecting_area
    ADD CONSTRAINT natural_region_fk FOREIGN KEY (natural_region_id) REFERENCES natural_region(natural_region_id);


--
-- TOC entry 2671 (class 2606 OID 53278)
-- Dependencies: 1924 1929 2465
-- Name: nomenclatural_group_person_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY nomenclatural_group
    ADD CONSTRAINT nomenclatural_group_person_fk FOREIGN KEY (certificator_person_id) REFERENCES person(person_id);


--
-- TOC entry 2673 (class 2606 OID 28134)
-- Dependencies: 2455 1925 1924
-- Name: nomenclatural_group_region_nomenclatural_group_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY nomenclatural_group_region
    ADD CONSTRAINT nomenclatural_group_region_nomenclatural_group_fk FOREIGN KEY (nomenclatural_group_id) REFERENCES nomenclatural_group(nomenclatural_group_id);


--
-- TOC entry 2672 (class 2606 OID 28139)
-- Dependencies: 1925 1950 2507
-- Name: nomenclatural_group_region_taxon_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY nomenclatural_group_region
    ADD CONSTRAINT nomenclatural_group_region_taxon_fk FOREIGN KEY (region_id) REFERENCES region(region_id);


--
-- TOC entry 2710 (class 2606 OID 28144)
-- Dependencies: 1970 1971 2548
-- Name: option_option_type_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY system_option
    ADD CONSTRAINT option_option_type_fk FOREIGN KEY (type_id) REFERENCES system_option_type(system_option_type_id);


--
-- TOC entry 2689 (class 2606 OID 28149)
-- Dependencies: 1953 2489 1941
-- Name: original_projection_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY site
    ADD CONSTRAINT original_projection_fk FOREIGN KEY (original_projection_id) REFERENCES projection(projection_id);


--
-- TOC entry 2654 (class 2606 OID 28154)
-- Dependencies: 2487 1900 1940
-- Name: project_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY gathering_observation_project
    ADD CONSTRAINT project_fk FOREIGN KEY (project_id) REFERENCES project(project_id);


--
-- TOC entry 2682 (class 2606 OID 28159)
-- Dependencies: 1942 1943 2493
-- Name: protected_area_type_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY protected_area
    ADD CONSTRAINT protected_area_type_fk FOREIGN KEY (protected_area_type_id) REFERENCES protected_area_type(protected_area_type_id);


--
-- TOC entry 2683 (class 2606 OID 28164)
-- Dependencies: 2373 1945 1881
-- Name: province_country; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY province
    ADD CONSTRAINT province_country FOREIGN KEY (country_id) REFERENCES country(country_id);


--
-- TOC entry 2687 (class 2606 OID 28169)
-- Dependencies: 1947 1948 2501
-- Name: reference_element_value_reference_element_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY reference_element_value
    ADD CONSTRAINT reference_element_value_reference_element_fk FOREIGN KEY (reference_element_id) REFERENCES reference_element(reference_element_id);


--
-- TOC entry 2686 (class 2606 OID 28174)
-- Dependencies: 1946 1948 2499
-- Name: reference_element_value_reference_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY reference_element_value
    ADD CONSTRAINT reference_element_value_reference_fk FOREIGN KEY (reference_id) REFERENCES reference(reference_id);


--
-- TOC entry 2685 (class 2606 OID 28179)
-- Dependencies: 1946 1916 2439
-- Name: reference_language; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY reference
    ADD CONSTRAINT reference_language FOREIGN KEY (language_id) REFERENCES "language"(language_id);


--
-- TOC entry 2684 (class 2606 OID 28184)
-- Dependencies: 1946 1949 2505
-- Name: reference_type_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY reference
    ADD CONSTRAINT reference_type_fk FOREIGN KEY (reference_type_id) REFERENCES reference_type(reference_type_id);


--
-- TOC entry 2702 (class 2606 OID 28189)
-- Dependencies: 2511 1952 1961
-- Name: sex_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen_life_stage_sex
    ADD CONSTRAINT sex_fk FOREIGN KEY (sex_id) REFERENCES sex(sex_id);


--
-- TOC entry 2688 (class 2606 OID 28194)
-- Dependencies: 2515 1954 1953
-- Name: site_calculation_method_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY site
    ADD CONSTRAINT site_calculation_method_fk FOREIGN KEY (site_calculation_method_id) REFERENCES site_calculation_method(site_calculation_method_id);


--
-- TOC entry 2692 (class 2606 OID 28199)
-- Dependencies: 1955 1953 2513
-- Name: site_coordinate_site; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY site_coordinate
    ADD CONSTRAINT site_coordinate_site FOREIGN KEY (site_id) REFERENCES site(site_id);


--
-- TOC entry 2656 (class 2606 OID 28204)
-- Dependencies: 1904 2513 1953
-- Name: site_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY georeferenced_site
    ADD CONSTRAINT site_fk FOREIGN KEY (site_id) REFERENCES site(site_id);


--
-- TOC entry 2752 (class 2606 OID 28209)
-- Dependencies: 1931 1986 2469 1931 1986
-- Name: species_record_person_profile_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_description_person_profile
    ADD CONSTRAINT species_record_person_profile_fk FOREIGN KEY (person_id, profile_id) REFERENCES person_profile(person_id, profile_id);


--
-- TOC entry 2696 (class 2606 OID 28214)
-- Dependencies: 1957 1867 2345
-- Name: specimen_annotation_annotation_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen_annotation
    ADD CONSTRAINT specimen_annotation_annotation_fk FOREIGN KEY (annotation_id) REFERENCES annotation(annotation_id);


--
-- TOC entry 2695 (class 2606 OID 53304)
-- Dependencies: 2618 1957 2006
-- Name: specimen_annotation_specimen_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen_annotation
    ADD CONSTRAINT specimen_annotation_specimen_fk FOREIGN KEY (specimen_id) REFERENCES specimen(specimen_id);


--
-- TOC entry 2793 (class 2606 OID 53121)
-- Dependencies: 2006 2523 1958
-- Name: specimen_category_fk2; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen
    ADD CONSTRAINT specimen_category_fk2 FOREIGN KEY (specimen_category_id) REFERENCES specimen_category(specimen_category_id);


--
-- TOC entry 2792 (class 2606 OID 53126)
-- Dependencies: 2006 2359 1874
-- Name: specimen_collection_fk3; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen
    ADD CONSTRAINT specimen_collection_fk3 FOREIGN KEY (collection_id) REFERENCES collection(collection_id);


--
-- TOC entry 2791 (class 2606 OID 53131)
-- Dependencies: 2006 2397 1893
-- Name: specimen_extraction_type_fk2; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen
    ADD CONSTRAINT specimen_extraction_type_fk2 FOREIGN KEY (extraction_type_id) REFERENCES extraction_type(extraction_type_id);


--
-- TOC entry 2697 (class 2606 OID 53299)
-- Dependencies: 2006 2618 1959
-- Name: specimen_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen_description
    ADD CONSTRAINT specimen_fk FOREIGN KEY (specimen_id) REFERENCES specimen(specimen_id);


--
-- TOC entry 2790 (class 2606 OID 53136)
-- Dependencies: 2401 1895 2006
-- Name: specimen_gathering_fk2; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen
    ADD CONSTRAINT specimen_gathering_fk2 FOREIGN KEY (gathering_observation_id) REFERENCES gathering_observation(gathering_observation_id);


--
-- TOC entry 2789 (class 2606 OID 53141)
-- Dependencies: 2006 2405 1897
-- Name: specimen_gathering_observation_detail_fk2; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen
    ADD CONSTRAINT specimen_gathering_observation_detail_fk2 FOREIGN KEY (gathering_observation_detail_id) REFERENCES gathering_observation_detail(gathering_observation_detail_id);


--
-- TOC entry 2699 (class 2606 OID 53192)
-- Dependencies: 2006 2618 1960
-- Name: specimen_life_form_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen_life_form
    ADD CONSTRAINT specimen_life_form_fk FOREIGN KEY (specimen_id) REFERENCES specimen(specimen_id);


--
-- TOC entry 2788 (class 2606 OID 53146)
-- Dependencies: 1918 2006 2443
-- Name: specimen_life_stage_fk2; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen
    ADD CONSTRAINT specimen_life_stage_fk2 FOREIGN KEY (life_stage_id) REFERENCES life_stage(life_stage_id);


--
-- TOC entry 2701 (class 2606 OID 53197)
-- Dependencies: 2006 2618 1961
-- Name: specimen_life_stage_sex_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen_life_stage_sex
    ADD CONSTRAINT specimen_life_stage_sex_fk FOREIGN KEY (specimen_id) REFERENCES specimen(specimen_id);


--
-- TOC entry 2787 (class 2606 OID 53151)
-- Dependencies: 2006 1922 2451
-- Name: specimen_morphological_description_fk2; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen
    ADD CONSTRAINT specimen_morphological_description_fk2 FOREIGN KEY (morphological_description_id) REFERENCES morphological_description(morphological_description_id);


--
-- TOC entry 2786 (class 2606 OID 53156)
-- Dependencies: 2006 2461 1927
-- Name: specimen_origin_fk2; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen
    ADD CONSTRAINT specimen_origin_fk2 FOREIGN KEY (origin_id) REFERENCES origin(origin_id);


--
-- TOC entry 2785 (class 2606 OID 53161)
-- Dependencies: 2483 2006 1938
-- Name: specimen_preservation_medium_fk2; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen
    ADD CONSTRAINT specimen_preservation_medium_fk2 FOREIGN KEY (preservation_medium_id) REFERENCES preservation_medium(preservation_medium_id);


--
-- TOC entry 2784 (class 2606 OID 53166)
-- Dependencies: 2511 2006 1952
-- Name: specimen_sex_fk2; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen
    ADD CONSTRAINT specimen_sex_fk2 FOREIGN KEY (sex_id) REFERENCES sex(sex_id);


--
-- TOC entry 2783 (class 2606 OID 53171)
-- Dependencies: 2006 2540 1967
-- Name: specimen_storage_type_fk2; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen
    ADD CONSTRAINT specimen_storage_type_fk2 FOREIGN KEY (storage_type_id) REFERENCES storage_type(storage_type_id);


--
-- TOC entry 2782 (class 2606 OID 53176)
-- Dependencies: 2006 2542 1968
-- Name: specimen_substrate_fk2; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen
    ADD CONSTRAINT specimen_substrate_fk2 FOREIGN KEY (substrate_id) REFERENCES substrate(substrate_id);


--
-- TOC entry 2781 (class 2606 OID 53181)
-- Dependencies: 2529 1962 2006
-- Name: specimen_type_fk2; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen
    ADD CONSTRAINT specimen_type_fk2 FOREIGN KEY (specimen_type_id) REFERENCES specimen_type(specimen_type_id);


--
-- TOC entry 2704 (class 2606 OID 28299)
-- Dependencies: 2531 1964 1963
-- Name: specimen_variable_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen_variable_value
    ADD CONSTRAINT specimen_variable_fk FOREIGN KEY (specimen_variable_id) REFERENCES specimen_variable(specimen_variable_id);


--
-- TOC entry 2698 (class 2606 OID 28304)
-- Dependencies: 1964 1959 2533
-- Name: specimen_variable_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY specimen_description
    ADD CONSTRAINT specimen_variable_fk FOREIGN KEY (specimen_variable_value_id) REFERENCES specimen_variable_value(specimen_variable_value_id);


--
-- TOC entry 2706 (class 2606 OID 28309)
-- Dependencies: 1989 1965 2584
-- Name: stage_transition_date_taxon_description_stage_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY stage_transition_date
    ADD CONSTRAINT stage_transition_date_taxon_description_stage_fk FOREIGN KEY (taxon_description_stage_id) REFERENCES taxon_description_stage(taxon_description_stage_id);


--
-- TOC entry 2709 (class 2606 OID 28314)
-- Dependencies: 1969 2550 1972
-- Name: subsystem_module_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY system_module
    ADD CONSTRAINT subsystem_module_fk FOREIGN KEY (subsystem_id) REFERENCES system_subsystem(subsystem_id) ON DELETE RESTRICT;


--
-- TOC entry 2715 (class 2606 OID 28319)
-- Dependencies: 2546 1974 1970
-- Name: system_option_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY system_user_option
    ADD CONSTRAINT system_option_fk FOREIGN KEY (option_id) REFERENCES system_option(option_id);


--
-- TOC entry 2714 (class 2606 OID 28324)
-- Dependencies: 1973 1974 2552
-- Name: system_user_fr; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY system_user_option
    ADD CONSTRAINT system_user_fr FOREIGN KEY (user_id) REFERENCES system_user(user_id) ON DELETE CASCADE;


--
-- TOC entry 2751 (class 2606 OID 28329)
-- Dependencies: 2566 1980 1986 1986 1980
-- Name: taxon_description_person_profile_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_description_person_profile
    ADD CONSTRAINT taxon_description_person_profile_fk FOREIGN KEY (taxon_id, taxon_description_sequence) REFERENCES taxon_description(taxon_id, taxon_description_sequence);


--
-- TOC entry 2756 (class 2606 OID 28334)
-- Dependencies: 1988 1946 2499
-- Name: taxon_description_record_reference_reference_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_description_record_reference
    ADD CONSTRAINT taxon_description_record_reference_reference_fk FOREIGN KEY (reference_id) REFERENCES reference(reference_id);


--
-- TOC entry 2755 (class 2606 OID 28339)
-- Dependencies: 1988 1987 2580
-- Name: taxon_description_record_reference_taxon_description_record_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_description_record_reference
    ADD CONSTRAINT taxon_description_record_reference_taxon_description_record_fk FOREIGN KEY (taxon_description_record_id) REFERENCES taxon_description_record(taxon_description_record_id);


--
-- TOC entry 2754 (class 2606 OID 28344)
-- Dependencies: 1984 2574 1987
-- Name: taxon_description_record_taxon_description_element_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_description_record
    ADD CONSTRAINT taxon_description_record_taxon_description_element_fk FOREIGN KEY (taxon_description_element_id) REFERENCES taxon_description_element(taxon_description_element_id);


--
-- TOC entry 2753 (class 2606 OID 28349)
-- Dependencies: 1980 2566 1987 1987 1980
-- Name: taxon_description_record_taxon_description_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_description_record
    ADD CONSTRAINT taxon_description_record_taxon_description_fk FOREIGN KEY (taxon_id, taxon_description_sequence) REFERENCES taxon_description(taxon_id, taxon_description_sequence);


--
-- TOC entry 2750 (class 2606 OID 28354)
-- Dependencies: 1980 1985 1985 2566 1980
-- Name: taxon_description_species_record_institution; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_description_institution
    ADD CONSTRAINT taxon_description_species_record_institution FOREIGN KEY (taxon_id, taxon_description_sequence) REFERENCES taxon_description(taxon_id, taxon_description_sequence);


--
-- TOC entry 2747 (class 2606 OID 28359)
-- Dependencies: 2584 1980 1989
-- Name: taxon_description_stage_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_description
    ADD CONSTRAINT taxon_description_stage_fk FOREIGN KEY (taxon_description_stage_id) REFERENCES taxon_description_stage(taxon_description_stage_id);


--
-- TOC entry 2705 (class 2606 OID 28364)
-- Dependencies: 2566 1980 1980 1965 1965
-- Name: taxon_description_stage_transition_date_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY stage_transition_date
    ADD CONSTRAINT taxon_description_stage_transition_date_fk FOREIGN KEY (taxon_id, taxon_description_sequence) REFERENCES taxon_description(taxon_id, taxon_description_sequence);


--
-- TOC entry 2746 (class 2606 OID 28369)
-- Dependencies: 1980 2558 1976
-- Name: taxon_description_taxon_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_description
    ADD CONSTRAINT taxon_description_taxon_fk FOREIGN KEY (taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2758 (class 2606 OID 28374)
-- Dependencies: 2455 1924 1991
-- Name: taxon_nomenclatural_group_nomenclatural_group_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_nomenclatural_group
    ADD CONSTRAINT taxon_nomenclatural_group_nomenclatural_group_fk FOREIGN KEY (nomenclatural_group_id) REFERENCES nomenclatural_group(nomenclatural_group_id);


--
-- TOC entry 2757 (class 2606 OID 28379)
-- Dependencies: 1991 2558 1976
-- Name: taxon_nomenclatural_group_taxon_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_nomenclatural_group
    ADD CONSTRAINT taxon_nomenclatural_group_taxon_fk FOREIGN KEY (taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2760 (class 2606 OID 28384)
-- Dependencies: 1946 2499 1992
-- Name: taxon_reference_reference_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_reference
    ADD CONSTRAINT taxon_reference_reference_fk FOREIGN KEY (reference_id) REFERENCES reference(reference_id);


--
-- TOC entry 2759 (class 2606 OID 28389)
-- Dependencies: 2558 1976 1992
-- Name: taxon_reference_taxon_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY taxon_reference
    ADD CONSTRAINT taxon_reference_taxon_fk FOREIGN KEY (taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2763 (class 2606 OID 53294)
-- Dependencies: 2006 1996 2618
-- Name: transacted_specimen_specimen_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY transacted_specimen
    ADD CONSTRAINT transacted_specimen_specimen_fk FOREIGN KEY (specimen_id) REFERENCES specimen(specimen_id);


--
-- TOC entry 2766 (class 2606 OID 28399)
-- Dependencies: 1996 1997 2600
-- Name: transacted_specimen_status_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY transacted_specimen
    ADD CONSTRAINT transacted_specimen_status_fk FOREIGN KEY (transacted_specimen_status_id) REFERENCES transacted_specimen_status(transacted_specimen_status_id);


--
-- TOC entry 2765 (class 2606 OID 28404)
-- Dependencies: 1998 2602 1996
-- Name: transacted_specimen_transaction_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY transacted_specimen
    ADD CONSTRAINT transacted_specimen_transaction_fk FOREIGN KEY (transaction_id) REFERENCES "transaction"(transaction_id);


--
-- TOC entry 2764 (class 2606 OID 28409)
-- Dependencies: 1999 2604 1996
-- Name: transacted_specimen_type_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY transacted_specimen
    ADD CONSTRAINT transacted_specimen_type_fk FOREIGN KEY (transaction_type_id) REFERENCES transaction_type(transaction_type_id);


--
-- TOC entry 2772 (class 2606 OID 28414)
-- Dependencies: 2359 1874 1998
-- Name: transaction_collection_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY "transaction"
    ADD CONSTRAINT transaction_collection_fk FOREIGN KEY (collection_id) REFERENCES collection(collection_id);


--
-- TOC entry 2771 (class 2606 OID 28419)
-- Dependencies: 1911 1998 2431
-- Name: transaction_receiver_institution_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY "transaction"
    ADD CONSTRAINT transaction_receiver_institution_fk FOREIGN KEY (receiver_institution_id) REFERENCES institution(institution_id);


--
-- TOC entry 2770 (class 2606 OID 28424)
-- Dependencies: 1929 2465 1998
-- Name: transaction_receiver_person_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY "transaction"
    ADD CONSTRAINT transaction_receiver_person_id FOREIGN KEY (receiver_person_id) REFERENCES person(person_id);


--
-- TOC entry 2769 (class 2606 OID 28429)
-- Dependencies: 2431 1911 1998
-- Name: transaction_sender_institution_id; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY "transaction"
    ADD CONSTRAINT transaction_sender_institution_id FOREIGN KEY (sender_institution_id) REFERENCES institution(institution_id);


--
-- TOC entry 2768 (class 2606 OID 28434)
-- Dependencies: 1998 2465 1929
-- Name: transaction_sender_person_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY "transaction"
    ADD CONSTRAINT transaction_sender_person_fk FOREIGN KEY (sender_person_id) REFERENCES person(person_id);


--
-- TOC entry 2767 (class 2606 OID 28439)
-- Dependencies: 1998 1999 2604
-- Name: transaction_type_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY "transaction"
    ADD CONSTRAINT transaction_type_fk FOREIGN KEY (transaction_type_id) REFERENCES transaction_type(transaction_type_id);


--
-- TOC entry 2776 (class 2606 OID 28444)
-- Dependencies: 1911 2431 2000
-- Name: type_specimen_institution_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY type_specimen
    ADD CONSTRAINT type_specimen_institution_fk FOREIGN KEY (institution_id) REFERENCES institution(institution_id);


--
-- TOC entry 2773 (class 2606 OID 53289)
-- Dependencies: 2618 2006 2000
-- Name: type_specimen_specimen_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY type_specimen
    ADD CONSTRAINT type_specimen_specimen_fk FOREIGN KEY (specimen_id) REFERENCES specimen(specimen_id);


--
-- TOC entry 2775 (class 2606 OID 28454)
-- Dependencies: 2000 1976 2558
-- Name: type_specimen_taxon_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY type_specimen
    ADD CONSTRAINT type_specimen_taxon_fk FOREIGN KEY (taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2774 (class 2606 OID 28459)
-- Dependencies: 2001 2000 2608
-- Name: type_specimen_type_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY type_specimen
    ADD CONSTRAINT type_specimen_type_fk FOREIGN KEY (type_specimen_type_id) REFERENCES type_specimen_type(type_specimen_type_id);


--
-- TOC entry 2713 (class 2606 OID 28464)
-- Dependencies: 1973 1973 2552
-- Name: user_group_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY system_user
    ADD CONSTRAINT user_group_fk FOREIGN KEY (user_group_id) REFERENCES system_user(user_id);


--
-- TOC entry 2778 (class 2606 OID 28469)
-- Dependencies: 2455 2002 1924
-- Name: user_nomenclatural_group_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY user_nomenclatural_group
    ADD CONSTRAINT user_nomenclatural_group_fk FOREIGN KEY (nomenclatural_group_id) REFERENCES nomenclatural_group(nomenclatural_group_id);


--
-- TOC entry 2777 (class 2606 OID 28474)
-- Dependencies: 2002 2552 1973
-- Name: user_nomenclatural_group_user_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY user_nomenclatural_group
    ADD CONSTRAINT user_nomenclatural_group_user_fk FOREIGN KEY (user_id) REFERENCES system_user(user_id);


--
-- TOC entry 2780 (class 2606 OID 28479)
-- Dependencies: 2558 1976 2003
-- Name: user_taxon_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY user_taxon
    ADD CONSTRAINT user_taxon_fk FOREIGN KEY (taxon_id) REFERENCES taxon(taxon_id);


--
-- TOC entry 2779 (class 2606 OID 28484)
-- Dependencies: 2003 2552 1973
-- Name: user_taxon_user_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY user_taxon
    ADD CONSTRAINT user_taxon_user_fk FOREIGN KEY (user_id) REFERENCES system_user(user_id);


--
-- TOC entry 2712 (class 2606 OID 28489)
-- Dependencies: 1975 2556 1973
-- Name: user_type_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY system_user
    ADD CONSTRAINT user_type_fk FOREIGN KEY (user_type_id) REFERENCES system_user_type(user_type_id);


--
-- TOC entry 2670 (class 2606 OID 28494)
-- Dependencies: 2004 2614 1923
-- Name: versant_fk; Type: FK CONSTRAINT; Schema: ara; Owner: ara
--

ALTER TABLE ONLY natural_region
    ADD CONSTRAINT versant_fk FOREIGN KEY (versant_id) REFERENCES versant(versant_id);


--
-- TOC entry 2800 (class 0 OID 0)
-- Dependencies: 6
-- Name: ara; Type: ACL; Schema: -; Owner: ara
--

REVOKE ALL ON SCHEMA ara FROM PUBLIC;
REVOKE ALL ON SCHEMA ara FROM ara;
GRANT ALL ON SCHEMA ara TO ara;
GRANT ALL ON SCHEMA ara TO postgres;


--
-- TOC entry 2801 (class 0 OID 0)
-- Dependencies: 1866
-- Name: altitude_floor; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE altitude_floor FROM PUBLIC;
REVOKE ALL ON TABLE altitude_floor FROM ara;
GRANT ALL ON TABLE altitude_floor TO ara;
GRANT ALL ON TABLE altitude_floor TO postgres;


--
-- TOC entry 2802 (class 0 OID 0)
-- Dependencies: 1867
-- Name: annotation; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE annotation FROM PUBLIC;
REVOKE ALL ON TABLE annotation FROM ara;
GRANT ALL ON TABLE annotation TO ara;
GRANT ALL ON TABLE annotation TO postgres;


--
-- TOC entry 2803 (class 0 OID 0)
-- Dependencies: 1868
-- Name: audience; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE audience FROM PUBLIC;
REVOKE ALL ON TABLE audience FROM ara;
GRANT ALL ON TABLE audience TO ara;
GRANT ALL ON TABLE audience TO postgres;


--
-- TOC entry 2804 (class 0 OID 0)
-- Dependencies: 1869
-- Name: base_projection; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE base_projection FROM PUBLIC;
REVOKE ALL ON TABLE base_projection FROM ara;
GRANT ALL ON TABLE base_projection TO ara;
GRANT ALL ON TABLE base_projection TO postgres;


--
-- TOC entry 2805 (class 0 OID 0)
-- Dependencies: 1870
-- Name: biotic_unit; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE biotic_unit FROM PUBLIC;
REVOKE ALL ON TABLE biotic_unit FROM ara;
GRANT ALL ON TABLE biotic_unit TO ara;
GRANT ALL ON TABLE biotic_unit TO PUBLIC;


--
-- TOC entry 2806 (class 0 OID 0)
-- Dependencies: 1871
-- Name: canton; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE canton FROM PUBLIC;
REVOKE ALL ON TABLE canton FROM ara;
GRANT ALL ON TABLE canton TO ara;
GRANT ALL ON TABLE canton TO PUBLIC;


--
-- TOC entry 2807 (class 0 OID 0)
-- Dependencies: 1872
-- Name: canton_ifam; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE canton_ifam FROM PUBLIC;
REVOKE ALL ON TABLE canton_ifam FROM ara;
GRANT ALL ON TABLE canton_ifam TO ara;
GRANT ALL ON TABLE canton_ifam TO PUBLIC;


--
-- TOC entry 2808 (class 0 OID 0)
-- Dependencies: 1873
-- Name: collecting_area; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE collecting_area FROM PUBLIC;
REVOKE ALL ON TABLE collecting_area FROM ara;
GRANT ALL ON TABLE collecting_area TO ara;
GRANT ALL ON TABLE collecting_area TO PUBLIC;


--
-- TOC entry 2809 (class 0 OID 0)
-- Dependencies: 1874
-- Name: collection; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE collection FROM PUBLIC;
REVOKE ALL ON TABLE collection FROM ara;
GRANT ALL ON TABLE collection TO ara;
GRANT ALL ON TABLE collection TO postgres;


--
-- TOC entry 2810 (class 0 OID 0)
-- Dependencies: 1875
-- Name: collection_protocol; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE collection_protocol FROM PUBLIC;
REVOKE ALL ON TABLE collection_protocol FROM ara;
GRANT ALL ON TABLE collection_protocol TO ara;
GRANT ALL ON TABLE collection_protocol TO postgres;


--
-- TOC entry 2811 (class 0 OID 0)
-- Dependencies: 1876
-- Name: collector_observer; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE collector_observer FROM PUBLIC;
REVOKE ALL ON TABLE collector_observer FROM ara;
GRANT ALL ON TABLE collector_observer TO ara;
GRANT ALL ON TABLE collector_observer TO PUBLIC;


--
-- TOC entry 2812 (class 0 OID 0)
-- Dependencies: 1877
-- Name: component; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE component FROM PUBLIC;
REVOKE ALL ON TABLE component FROM ara;
GRANT ALL ON TABLE component TO ara;
GRANT ALL ON TABLE component TO postgres;


--
-- TOC entry 2813 (class 0 OID 0)
-- Dependencies: 1878
-- Name: component_part; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE component_part FROM PUBLIC;
REVOKE ALL ON TABLE component_part FROM ara;
GRANT ALL ON TABLE component_part TO ara;
GRANT ALL ON TABLE component_part TO postgres;


--
-- TOC entry 2814 (class 0 OID 0)
-- Dependencies: 1879
-- Name: concept; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE concept FROM PUBLIC;
REVOKE ALL ON TABLE concept FROM ara;
GRANT ALL ON TABLE concept TO ara;
GRANT ALL ON TABLE concept TO postgres;


--
-- TOC entry 2815 (class 0 OID 0)
-- Dependencies: 1880
-- Name: conservation_area; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE conservation_area FROM PUBLIC;
REVOKE ALL ON TABLE conservation_area FROM ara;
GRANT ALL ON TABLE conservation_area TO ara;
GRANT ALL ON TABLE conservation_area TO PUBLIC;


--
-- TOC entry 2816 (class 0 OID 0)
-- Dependencies: 1881
-- Name: country; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE country FROM PUBLIC;
REVOKE ALL ON TABLE country FROM ara;
GRANT ALL ON TABLE country TO ara;
GRANT ALL ON TABLE country TO postgres;


--
-- TOC entry 2817 (class 0 OID 0)
-- Dependencies: 1882
-- Name: culture; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE culture FROM PUBLIC;
REVOKE ALL ON TABLE culture FROM ara;
GRANT ALL ON TABLE culture TO ara;
GRANT ALL ON TABLE culture TO postgres;


--
-- TOC entry 2818 (class 0 OID 0)
-- Dependencies: 1883
-- Name: culture_medium; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE culture_medium FROM PUBLIC;
REVOKE ALL ON TABLE culture_medium FROM ara;
GRANT ALL ON TABLE culture_medium TO ara;
GRANT ALL ON TABLE culture_medium TO postgres;


--
-- TOC entry 2819 (class 0 OID 0)
-- Dependencies: 1884
-- Name: culture_storage_medium; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE culture_storage_medium FROM PUBLIC;
REVOKE ALL ON TABLE culture_storage_medium FROM ara;
GRANT ALL ON TABLE culture_storage_medium TO ara;
GRANT ALL ON TABLE culture_storage_medium TO postgres;


--
-- TOC entry 2820 (class 0 OID 0)
-- Dependencies: 1885
-- Name: determination_type; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE determination_type FROM PUBLIC;
REVOKE ALL ON TABLE determination_type FROM ara;
GRANT ALL ON TABLE determination_type TO ara;
GRANT ALL ON TABLE determination_type TO postgres;


--
-- TOC entry 2821 (class 0 OID 0)
-- Dependencies: 1886
-- Name: district; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE district FROM PUBLIC;
REVOKE ALL ON TABLE district FROM ara;
GRANT ALL ON TABLE district TO ara;
GRANT ALL ON TABLE district TO PUBLIC;


--
-- TOC entry 2822 (class 0 OID 0)
-- Dependencies: 1887
-- Name: ecological_region; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE ecological_region FROM PUBLIC;
REVOKE ALL ON TABLE ecological_region FROM ara;
GRANT ALL ON TABLE ecological_region TO ara;
GRANT ALL ON TABLE ecological_region TO PUBLIC;


--
-- TOC entry 2823 (class 0 OID 0)
-- Dependencies: 1888
-- Name: ecological_variable; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE ecological_variable FROM PUBLIC;
REVOKE ALL ON TABLE ecological_variable FROM ara;
GRANT ALL ON TABLE ecological_variable TO ara;
GRANT ALL ON TABLE ecological_variable TO postgres;


--
-- TOC entry 2824 (class 0 OID 0)
-- Dependencies: 1889
-- Name: ecological_variable_value; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE ecological_variable_value FROM PUBLIC;
REVOKE ALL ON TABLE ecological_variable_value FROM ara;
GRANT ALL ON TABLE ecological_variable_value TO ara;
GRANT ALL ON TABLE ecological_variable_value TO postgres;


--
-- TOC entry 2825 (class 0 OID 0)
-- Dependencies: 1890
-- Name: ecosystem; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE ecosystem FROM PUBLIC;
REVOKE ALL ON TABLE ecosystem FROM ara;
GRANT ALL ON TABLE ecosystem TO ara;
GRANT ALL ON TABLE ecosystem TO PUBLIC;


--
-- TOC entry 2826 (class 0 OID 0)
-- Dependencies: 1891
-- Name: elevation_band; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE elevation_band FROM PUBLIC;
REVOKE ALL ON TABLE elevation_band FROM ara;
GRANT ALL ON TABLE elevation_band TO ara;
GRANT ALL ON TABLE elevation_band TO PUBLIC;


--
-- TOC entry 2827 (class 0 OID 0)
-- Dependencies: 1892
-- Name: exposition; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE exposition FROM PUBLIC;
REVOKE ALL ON TABLE exposition FROM ara;
GRANT ALL ON TABLE exposition TO ara;
GRANT ALL ON TABLE exposition TO postgres;


--
-- TOC entry 2828 (class 0 OID 0)
-- Dependencies: 1893
-- Name: extraction_type; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE extraction_type FROM PUBLIC;
REVOKE ALL ON TABLE extraction_type FROM ara;
GRANT ALL ON TABLE extraction_type TO ara;
GRANT ALL ON TABLE extraction_type TO postgres;


--
-- TOC entry 2829 (class 0 OID 0)
-- Dependencies: 1894
-- Name: feature_type; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE feature_type FROM PUBLIC;
REVOKE ALL ON TABLE feature_type FROM ara;
GRANT ALL ON TABLE feature_type TO ara;
GRANT ALL ON TABLE feature_type TO postgres;


--
-- TOC entry 2830 (class 0 OID 0)
-- Dependencies: 1895
-- Name: gathering_observation; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE gathering_observation FROM PUBLIC;
REVOKE ALL ON TABLE gathering_observation FROM ara;
GRANT ALL ON TABLE gathering_observation TO ara;


--
-- TOC entry 2831 (class 0 OID 0)
-- Dependencies: 1896
-- Name: gathering_observation_collection; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE gathering_observation_collection FROM PUBLIC;
REVOKE ALL ON TABLE gathering_observation_collection FROM ara;
GRANT ALL ON TABLE gathering_observation_collection TO ara;


--
-- TOC entry 2832 (class 0 OID 0)
-- Dependencies: 1897
-- Name: gathering_observation_detail; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE gathering_observation_detail FROM PUBLIC;
REVOKE ALL ON TABLE gathering_observation_detail FROM ara;
GRANT ALL ON TABLE gathering_observation_detail TO ara;


--
-- TOC entry 2833 (class 0 OID 0)
-- Dependencies: 1898
-- Name: gathering_observation_ecological_var; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE gathering_observation_ecological_var FROM PUBLIC;
REVOKE ALL ON TABLE gathering_observation_ecological_var FROM ara;
GRANT ALL ON TABLE gathering_observation_ecological_var TO ara;
GRANT ALL ON TABLE gathering_observation_ecological_var TO postgres;


--
-- TOC entry 2834 (class 0 OID 0)
-- Dependencies: 1899
-- Name: gathering_observation_method; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE gathering_observation_method FROM PUBLIC;
REVOKE ALL ON TABLE gathering_observation_method FROM ara;
GRANT ALL ON TABLE gathering_observation_method TO ara;


--
-- TOC entry 2835 (class 0 OID 0)
-- Dependencies: 1900
-- Name: gathering_observation_project; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE gathering_observation_project FROM PUBLIC;
REVOKE ALL ON TABLE gathering_observation_project FROM ara;
GRANT ALL ON TABLE gathering_observation_project TO ara;
GRANT ALL ON TABLE gathering_observation_project TO postgres;


--
-- TOC entry 2836 (class 0 OID 0)
-- Dependencies: 1901
-- Name: geographic_catalogue; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE geographic_catalogue FROM PUBLIC;
REVOKE ALL ON TABLE geographic_catalogue FROM ara;
GRANT ALL ON TABLE geographic_catalogue TO ara;
GRANT ALL ON TABLE geographic_catalogue TO postgres;


--
-- TOC entry 2837 (class 0 OID 0)
-- Dependencies: 1902
-- Name: geographic_entity; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE geographic_entity FROM PUBLIC;
REVOKE ALL ON TABLE geographic_entity FROM ara;
GRANT ALL ON TABLE geographic_entity TO ara;
GRANT ALL ON TABLE geographic_entity TO postgres;


--
-- TOC entry 2838 (class 0 OID 0)
-- Dependencies: 1903
-- Name: geographic_layer; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE geographic_layer FROM PUBLIC;
REVOKE ALL ON TABLE geographic_layer FROM ara;
GRANT ALL ON TABLE geographic_layer TO ara;
GRANT ALL ON TABLE geographic_layer TO PUBLIC;


--
-- TOC entry 2839 (class 0 OID 0)
-- Dependencies: 1904
-- Name: georeferenced_site; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE georeferenced_site FROM PUBLIC;
REVOKE ALL ON TABLE georeferenced_site FROM ara;
GRANT ALL ON TABLE georeferenced_site TO ara;
GRANT ALL ON TABLE georeferenced_site TO PUBLIC;


--
-- TOC entry 2840 (class 0 OID 0)
-- Dependencies: 1905
-- Name: id_gen; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE id_gen FROM PUBLIC;
REVOKE ALL ON TABLE id_gen FROM ara;
GRANT ALL ON TABLE id_gen TO ara;


--
-- TOC entry 2841 (class 0 OID 0)
-- Dependencies: 1906
-- Name: identification; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE identification FROM PUBLIC;
REVOKE ALL ON TABLE identification FROM ara;
GRANT ALL ON TABLE identification TO ara;
GRANT ALL ON TABLE identification TO postgres;


--
-- TOC entry 2842 (class 0 OID 0)
-- Dependencies: 1907
-- Name: identification_history; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE identification_history FROM PUBLIC;
REVOKE ALL ON TABLE identification_history FROM ara;
GRANT ALL ON TABLE identification_history TO ara;
GRANT ALL ON TABLE identification_history TO postgres;


--
-- TOC entry 2843 (class 0 OID 0)
-- Dependencies: 2005
-- Name: identification_status; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE identification_status FROM PUBLIC;
REVOKE ALL ON TABLE identification_status FROM ara;
GRANT ALL ON TABLE identification_status TO ara;
GRANT ALL ON TABLE identification_status TO postgres;


--
-- TOC entry 2844 (class 0 OID 0)
-- Dependencies: 1908
-- Name: identification_type; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE identification_type FROM PUBLIC;
REVOKE ALL ON TABLE identification_type FROM ara;
GRANT ALL ON TABLE identification_type TO ara;
GRANT ALL ON TABLE identification_type TO postgres;


--
-- TOC entry 2845 (class 0 OID 0)
-- Dependencies: 2007
-- Name: identifier; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE identifier FROM PUBLIC;
REVOKE ALL ON TABLE identifier FROM ara;
GRANT ALL ON TABLE identifier TO ara;
GRANT ALL ON TABLE identifier TO postgres;


--
-- TOC entry 2846 (class 0 OID 0)
-- Dependencies: 1909
-- Name: identifier_history; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE identifier_history FROM PUBLIC;
REVOKE ALL ON TABLE identifier_history FROM ara;
GRANT ALL ON TABLE identifier_history TO ara;
GRANT ALL ON TABLE identifier_history TO postgres;


--
-- TOC entry 2847 (class 0 OID 0)
-- Dependencies: 1910
-- Name: inmediate_predecessor_history; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE inmediate_predecessor_history FROM PUBLIC;
REVOKE ALL ON TABLE inmediate_predecessor_history FROM ara;
GRANT ALL ON TABLE inmediate_predecessor_history TO ara;
GRANT ALL ON TABLE inmediate_predecessor_history TO postgres;


--
-- TOC entry 2848 (class 0 OID 0)
-- Dependencies: 1911
-- Name: institution; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE institution FROM PUBLIC;
REVOKE ALL ON TABLE institution FROM ara;
GRANT ALL ON TABLE institution TO ara;
GRANT ALL ON TABLE institution TO postgres;


--
-- TOC entry 2849 (class 0 OID 0)
-- Dependencies: 1912
-- Name: interaction_type; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE interaction_type FROM PUBLIC;
REVOKE ALL ON TABLE interaction_type FROM ara;
GRANT ALL ON TABLE interaction_type TO ara;
GRANT ALL ON TABLE interaction_type TO postgres;


--
-- TOC entry 2850 (class 0 OID 0)
-- Dependencies: 1913
-- Name: label; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE label FROM PUBLIC;
REVOKE ALL ON TABLE label FROM ara;
GRANT ALL ON TABLE label TO ara;
GRANT ALL ON TABLE label TO postgres;


--
-- TOC entry 2851 (class 0 OID 0)
-- Dependencies: 1914
-- Name: label_history; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE label_history FROM PUBLIC;
REVOKE ALL ON TABLE label_history FROM ara;
GRANT ALL ON TABLE label_history TO ara;
GRANT ALL ON TABLE label_history TO postgres;


--
-- TOC entry 2852 (class 0 OID 0)
-- Dependencies: 1915
-- Name: land_cover; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE land_cover FROM PUBLIC;
REVOKE ALL ON TABLE land_cover FROM ara;
GRANT ALL ON TABLE land_cover TO ara;
GRANT ALL ON TABLE land_cover TO PUBLIC;


--
-- TOC entry 2853 (class 0 OID 0)
-- Dependencies: 1916
-- Name: language; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE "language" FROM PUBLIC;
REVOKE ALL ON TABLE "language" FROM ara;
GRANT ALL ON TABLE "language" TO ara;
GRANT ALL ON TABLE "language" TO postgres;


--
-- TOC entry 2854 (class 0 OID 0)
-- Dependencies: 1917
-- Name: life_form; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE life_form FROM PUBLIC;
REVOKE ALL ON TABLE life_form FROM ara;
GRANT ALL ON TABLE life_form TO ara;
GRANT ALL ON TABLE life_form TO postgres;


--
-- TOC entry 2855 (class 0 OID 0)
-- Dependencies: 1918
-- Name: life_stage; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE life_stage FROM PUBLIC;
REVOKE ALL ON TABLE life_stage FROM ara;
GRANT ALL ON TABLE life_stage TO ara;
GRANT ALL ON TABLE life_stage TO postgres;


--
-- TOC entry 2856 (class 0 OID 0)
-- Dependencies: 1919
-- Name: life_zone; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE life_zone FROM PUBLIC;
REVOKE ALL ON TABLE life_zone FROM ara;
GRANT ALL ON TABLE life_zone TO ara;
GRANT ALL ON TABLE life_zone TO PUBLIC;


--
-- TOC entry 2857 (class 0 OID 0)
-- Dependencies: 1922
-- Name: morphological_description; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE morphological_description FROM PUBLIC;
REVOKE ALL ON TABLE morphological_description FROM ara;
GRANT ALL ON TABLE morphological_description TO ara;
GRANT ALL ON TABLE morphological_description TO postgres;


--
-- TOC entry 2858 (class 0 OID 0)
-- Dependencies: 1923
-- Name: natural_region; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE natural_region FROM PUBLIC;
REVOKE ALL ON TABLE natural_region FROM ara;
GRANT ALL ON TABLE natural_region TO ara;
GRANT ALL ON TABLE natural_region TO PUBLIC;


--
-- TOC entry 2859 (class 0 OID 0)
-- Dependencies: 1924
-- Name: nomenclatural_group; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE nomenclatural_group FROM PUBLIC;
REVOKE ALL ON TABLE nomenclatural_group FROM ara;
GRANT ALL ON TABLE nomenclatural_group TO ara;
GRANT ALL ON TABLE nomenclatural_group TO postgres;


--
-- TOC entry 2860 (class 0 OID 0)
-- Dependencies: 1925
-- Name: nomenclatural_group_region; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE nomenclatural_group_region FROM PUBLIC;
REVOKE ALL ON TABLE nomenclatural_group_region FROM ara;
GRANT ALL ON TABLE nomenclatural_group_region TO ara;
GRANT ALL ON TABLE nomenclatural_group_region TO postgres;


--
-- TOC entry 2861 (class 0 OID 0)
-- Dependencies: 1926
-- Name: ocean; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE ocean FROM PUBLIC;
REVOKE ALL ON TABLE ocean FROM ara;
GRANT ALL ON TABLE ocean TO ara;
GRANT ALL ON TABLE ocean TO PUBLIC;


--
-- TOC entry 2862 (class 0 OID 0)
-- Dependencies: 1927
-- Name: origin; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE origin FROM PUBLIC;
REVOKE ALL ON TABLE origin FROM ara;
GRANT ALL ON TABLE origin TO ara;
GRANT ALL ON TABLE origin TO postgres;


--
-- TOC entry 2863 (class 0 OID 0)
-- Dependencies: 1928
-- Name: original_label; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE original_label FROM PUBLIC;
REVOKE ALL ON TABLE original_label FROM ara;
GRANT ALL ON TABLE original_label TO ara;
GRANT ALL ON TABLE original_label TO postgres;


--
-- TOC entry 2864 (class 0 OID 0)
-- Dependencies: 1929
-- Name: person; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE person FROM PUBLIC;
REVOKE ALL ON TABLE person FROM ara;
GRANT ALL ON TABLE person TO ara;
GRANT ALL ON TABLE person TO postgres;


--
-- TOC entry 2865 (class 0 OID 0)
-- Dependencies: 1930
-- Name: person_institution; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE person_institution FROM PUBLIC;
REVOKE ALL ON TABLE person_institution FROM ara;
GRANT ALL ON TABLE person_institution TO ara;
GRANT ALL ON TABLE person_institution TO postgres;


--
-- TOC entry 2866 (class 0 OID 0)
-- Dependencies: 1931
-- Name: person_profile; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE person_profile FROM PUBLIC;
REVOKE ALL ON TABLE person_profile FROM ara;
GRANT ALL ON TABLE person_profile TO ara;
GRANT ALL ON TABLE person_profile TO postgres;


--
-- TOC entry 2867 (class 0 OID 0)
-- Dependencies: 1932
-- Name: person_profile_taxon; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE person_profile_taxon FROM PUBLIC;
REVOKE ALL ON TABLE person_profile_taxon FROM ara;
GRANT ALL ON TABLE person_profile_taxon TO ara;
GRANT ALL ON TABLE person_profile_taxon TO postgres;


--
-- TOC entry 2868 (class 0 OID 0)
-- Dependencies: 1933
-- Name: pg_ts_cfg; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE pg_ts_cfg FROM PUBLIC;
REVOKE ALL ON TABLE pg_ts_cfg FROM ara;
GRANT ALL ON TABLE pg_ts_cfg TO ara;
GRANT ALL ON TABLE pg_ts_cfg TO postgres;


--
-- TOC entry 2869 (class 0 OID 0)
-- Dependencies: 1934
-- Name: pg_ts_cfgmap; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE pg_ts_cfgmap FROM PUBLIC;
REVOKE ALL ON TABLE pg_ts_cfgmap FROM ara;
GRANT ALL ON TABLE pg_ts_cfgmap TO ara;
GRANT ALL ON TABLE pg_ts_cfgmap TO postgres;


--
-- TOC entry 2870 (class 0 OID 0)
-- Dependencies: 1935
-- Name: pg_ts_dict; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE pg_ts_dict FROM PUBLIC;
REVOKE ALL ON TABLE pg_ts_dict FROM ara;
GRANT ALL ON TABLE pg_ts_dict TO ara;
GRANT ALL ON TABLE pg_ts_dict TO postgres;


--
-- TOC entry 2871 (class 0 OID 0)
-- Dependencies: 1936
-- Name: pg_ts_parser; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE pg_ts_parser FROM PUBLIC;
REVOKE ALL ON TABLE pg_ts_parser FROM ara;
GRANT ALL ON TABLE pg_ts_parser TO ara;
GRANT ALL ON TABLE pg_ts_parser TO postgres;


--
-- TOC entry 2872 (class 0 OID 0)
-- Dependencies: 1937
-- Name: preparation_method; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE preparation_method FROM PUBLIC;
REVOKE ALL ON TABLE preparation_method FROM ara;
GRANT ALL ON TABLE preparation_method TO ara;
GRANT ALL ON TABLE preparation_method TO postgres;


--
-- TOC entry 2873 (class 0 OID 0)
-- Dependencies: 1938
-- Name: preservation_medium; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE preservation_medium FROM PUBLIC;
REVOKE ALL ON TABLE preservation_medium FROM ara;
GRANT ALL ON TABLE preservation_medium TO ara;
GRANT ALL ON TABLE preservation_medium TO postgres;


--
-- TOC entry 2874 (class 0 OID 0)
-- Dependencies: 1939
-- Name: profile; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE profile FROM PUBLIC;
REVOKE ALL ON TABLE profile FROM ara;
GRANT ALL ON TABLE profile TO ara;
GRANT ALL ON TABLE profile TO postgres;


--
-- TOC entry 2875 (class 0 OID 0)
-- Dependencies: 1940
-- Name: project; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE project FROM PUBLIC;
REVOKE ALL ON TABLE project FROM ara;
GRANT ALL ON TABLE project TO ara;
GRANT ALL ON TABLE project TO postgres;


--
-- TOC entry 2876 (class 0 OID 0)
-- Dependencies: 1941
-- Name: projection; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE projection FROM PUBLIC;
REVOKE ALL ON TABLE projection FROM ara;
GRANT ALL ON TABLE projection TO ara;
GRANT ALL ON TABLE projection TO postgres;


--
-- TOC entry 2877 (class 0 OID 0)
-- Dependencies: 1942
-- Name: protected_area; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE protected_area FROM PUBLIC;
REVOKE ALL ON TABLE protected_area FROM ara;
GRANT ALL ON TABLE protected_area TO ara;
GRANT ALL ON TABLE protected_area TO PUBLIC;


--
-- TOC entry 2878 (class 0 OID 0)
-- Dependencies: 1943
-- Name: protected_area_type; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE protected_area_type FROM PUBLIC;
REVOKE ALL ON TABLE protected_area_type FROM ara;
GRANT ALL ON TABLE protected_area_type TO ara;
GRANT ALL ON TABLE protected_area_type TO postgres;


--
-- TOC entry 2879 (class 0 OID 0)
-- Dependencies: 1944
-- Name: protocol_attribute; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE protocol_attribute FROM PUBLIC;
REVOKE ALL ON TABLE protocol_attribute FROM ara;
GRANT ALL ON TABLE protocol_attribute TO ara;
GRANT ALL ON TABLE protocol_attribute TO postgres;


--
-- TOC entry 2880 (class 0 OID 0)
-- Dependencies: 1945
-- Name: province; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE province FROM PUBLIC;
REVOKE ALL ON TABLE province FROM ara;
GRANT ALL ON TABLE province TO ara;
GRANT ALL ON TABLE province TO PUBLIC;


--
-- TOC entry 2881 (class 0 OID 0)
-- Dependencies: 1946
-- Name: reference; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE reference FROM PUBLIC;
REVOKE ALL ON TABLE reference FROM ara;
GRANT ALL ON TABLE reference TO ara;
GRANT ALL ON TABLE reference TO postgres;


--
-- TOC entry 2882 (class 0 OID 0)
-- Dependencies: 1947
-- Name: reference_element; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE reference_element FROM PUBLIC;
REVOKE ALL ON TABLE reference_element FROM ara;
GRANT ALL ON TABLE reference_element TO ara;
GRANT ALL ON TABLE reference_element TO postgres;


--
-- TOC entry 2883 (class 0 OID 0)
-- Dependencies: 1948
-- Name: reference_element_value; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE reference_element_value FROM PUBLIC;
REVOKE ALL ON TABLE reference_element_value FROM ara;
GRANT ALL ON TABLE reference_element_value TO ara;
GRANT ALL ON TABLE reference_element_value TO postgres;


--
-- TOC entry 2884 (class 0 OID 0)
-- Dependencies: 1949
-- Name: reference_type; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE reference_type FROM PUBLIC;
REVOKE ALL ON TABLE reference_type FROM ara;
GRANT ALL ON TABLE reference_type TO ara;
GRANT ALL ON TABLE reference_type TO postgres;


--
-- TOC entry 2885 (class 0 OID 0)
-- Dependencies: 1950
-- Name: region; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE region FROM PUBLIC;
REVOKE ALL ON TABLE region FROM ara;
GRANT ALL ON TABLE region TO ara;
GRANT ALL ON TABLE region TO postgres;


--
-- TOC entry 2886 (class 0 OID 0)
-- Dependencies: 1951
-- Name: sampling_type; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE sampling_type FROM PUBLIC;
REVOKE ALL ON TABLE sampling_type FROM ara;
GRANT ALL ON TABLE sampling_type TO ara;
GRANT ALL ON TABLE sampling_type TO postgres;


--
-- TOC entry 2887 (class 0 OID 0)
-- Dependencies: 1952
-- Name: sex; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE sex FROM PUBLIC;
REVOKE ALL ON TABLE sex FROM ara;
GRANT ALL ON TABLE sex TO ara;
GRANT ALL ON TABLE sex TO postgres;


--
-- TOC entry 2888 (class 0 OID 0)
-- Dependencies: 1953
-- Name: site; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE site FROM PUBLIC;
REVOKE ALL ON TABLE site FROM ara;
GRANT ALL ON TABLE site TO ara;
GRANT ALL ON TABLE site TO postgres;


--
-- TOC entry 2889 (class 0 OID 0)
-- Dependencies: 1954
-- Name: site_calculation_method; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE site_calculation_method FROM PUBLIC;
REVOKE ALL ON TABLE site_calculation_method FROM ara;
GRANT ALL ON TABLE site_calculation_method TO ara;
GRANT ALL ON TABLE site_calculation_method TO postgres;


--
-- TOC entry 2890 (class 0 OID 0)
-- Dependencies: 1955
-- Name: site_coordinate; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE site_coordinate FROM PUBLIC;
REVOKE ALL ON TABLE site_coordinate FROM ara;
GRANT ALL ON TABLE site_coordinate TO ara;
GRANT ALL ON TABLE site_coordinate TO PUBLIC;


--
-- TOC entry 2891 (class 0 OID 0)
-- Dependencies: 1956
-- Name: species_record_stage_profile; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE species_record_stage_profile FROM PUBLIC;
REVOKE ALL ON TABLE species_record_stage_profile FROM ara;
GRANT ALL ON TABLE species_record_stage_profile TO ara;
GRANT ALL ON TABLE species_record_stage_profile TO postgres;


--
-- TOC entry 2892 (class 0 OID 0)
-- Dependencies: 2006
-- Name: specimen; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE specimen FROM PUBLIC;
REVOKE ALL ON TABLE specimen FROM ara;
GRANT ALL ON TABLE specimen TO ara;
GRANT ALL ON TABLE specimen TO postgres;


--
-- TOC entry 2893 (class 0 OID 0)
-- Dependencies: 1957
-- Name: specimen_annotation; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE specimen_annotation FROM PUBLIC;
REVOKE ALL ON TABLE specimen_annotation FROM ara;
GRANT ALL ON TABLE specimen_annotation TO ara;
GRANT ALL ON TABLE specimen_annotation TO postgres;


--
-- TOC entry 2894 (class 0 OID 0)
-- Dependencies: 1958
-- Name: specimen_category; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE specimen_category FROM PUBLIC;
REVOKE ALL ON TABLE specimen_category FROM ara;
GRANT ALL ON TABLE specimen_category TO ara;
GRANT ALL ON TABLE specimen_category TO postgres;


--
-- TOC entry 2895 (class 0 OID 0)
-- Dependencies: 1959
-- Name: specimen_description; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE specimen_description FROM PUBLIC;
REVOKE ALL ON TABLE specimen_description FROM ara;
GRANT ALL ON TABLE specimen_description TO ara;
GRANT ALL ON TABLE specimen_description TO postgres;


--
-- TOC entry 2896 (class 0 OID 0)
-- Dependencies: 1962
-- Name: specimen_type; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE specimen_type FROM PUBLIC;
REVOKE ALL ON TABLE specimen_type FROM ara;
GRANT ALL ON TABLE specimen_type TO ara;
GRANT ALL ON TABLE specimen_type TO postgres;


--
-- TOC entry 2897 (class 0 OID 0)
-- Dependencies: 1963
-- Name: specimen_variable; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE specimen_variable FROM PUBLIC;
REVOKE ALL ON TABLE specimen_variable FROM ara;
GRANT ALL ON TABLE specimen_variable TO ara;
GRANT ALL ON TABLE specimen_variable TO postgres;


--
-- TOC entry 2898 (class 0 OID 0)
-- Dependencies: 1964
-- Name: specimen_variable_value; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE specimen_variable_value FROM PUBLIC;
REVOKE ALL ON TABLE specimen_variable_value FROM ara;
GRANT ALL ON TABLE specimen_variable_value TO ara;
GRANT ALL ON TABLE specimen_variable_value TO postgres;


--
-- TOC entry 2899 (class 0 OID 0)
-- Dependencies: 1965
-- Name: stage_transition_date; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE stage_transition_date FROM PUBLIC;
REVOKE ALL ON TABLE stage_transition_date FROM ara;
GRANT ALL ON TABLE stage_transition_date TO ara;
GRANT ALL ON TABLE stage_transition_date TO postgres;


--
-- TOC entry 2900 (class 0 OID 0)
-- Dependencies: 1966
-- Name: stage_transition_digraph; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE stage_transition_digraph FROM PUBLIC;
REVOKE ALL ON TABLE stage_transition_digraph FROM ara;
GRANT ALL ON TABLE stage_transition_digraph TO ara;
GRANT ALL ON TABLE stage_transition_digraph TO postgres;


--
-- TOC entry 2901 (class 0 OID 0)
-- Dependencies: 1967
-- Name: storage_type; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE storage_type FROM PUBLIC;
REVOKE ALL ON TABLE storage_type FROM ara;
GRANT ALL ON TABLE storage_type TO ara;
GRANT ALL ON TABLE storage_type TO postgres;


--
-- TOC entry 2902 (class 0 OID 0)
-- Dependencies: 1968
-- Name: substrate; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE substrate FROM PUBLIC;
REVOKE ALL ON TABLE substrate FROM ara;
GRANT ALL ON TABLE substrate TO ara;
GRANT ALL ON TABLE substrate TO postgres;


--
-- TOC entry 2903 (class 0 OID 0)
-- Dependencies: 1969
-- Name: system_module; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE system_module FROM PUBLIC;
REVOKE ALL ON TABLE system_module FROM ara;
GRANT ALL ON TABLE system_module TO ara;
GRANT ALL ON TABLE system_module TO postgres;


--
-- TOC entry 2904 (class 0 OID 0)
-- Dependencies: 1970
-- Name: system_option; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE system_option FROM PUBLIC;
REVOKE ALL ON TABLE system_option FROM ara;
GRANT ALL ON TABLE system_option TO ara;
GRANT ALL ON TABLE system_option TO postgres;


--
-- TOC entry 2905 (class 0 OID 0)
-- Dependencies: 1971
-- Name: system_option_type; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE system_option_type FROM PUBLIC;
REVOKE ALL ON TABLE system_option_type FROM ara;
GRANT ALL ON TABLE system_option_type TO ara;
GRANT ALL ON TABLE system_option_type TO postgres;


--
-- TOC entry 2906 (class 0 OID 0)
-- Dependencies: 1972
-- Name: system_subsystem; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE system_subsystem FROM PUBLIC;
REVOKE ALL ON TABLE system_subsystem FROM ara;
GRANT ALL ON TABLE system_subsystem TO ara;
GRANT ALL ON TABLE system_subsystem TO postgres;


--
-- TOC entry 2907 (class 0 OID 0)
-- Dependencies: 1973
-- Name: system_user; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE system_user FROM PUBLIC;
REVOKE ALL ON TABLE system_user FROM ara;
GRANT ALL ON TABLE system_user TO ara;
GRANT ALL ON TABLE system_user TO postgres;


--
-- TOC entry 2908 (class 0 OID 0)
-- Dependencies: 1974
-- Name: system_user_option; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE system_user_option FROM PUBLIC;
REVOKE ALL ON TABLE system_user_option FROM ara;
GRANT ALL ON TABLE system_user_option TO ara;
GRANT ALL ON TABLE system_user_option TO postgres;


--
-- TOC entry 2909 (class 0 OID 0)
-- Dependencies: 1975
-- Name: system_user_type; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE system_user_type FROM PUBLIC;
REVOKE ALL ON TABLE system_user_type FROM ara;
GRANT ALL ON TABLE system_user_type TO ara;
GRANT ALL ON TABLE system_user_type TO postgres;


--
-- TOC entry 2910 (class 0 OID 0)
-- Dependencies: 1976
-- Name: taxon; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon FROM PUBLIC;
REVOKE ALL ON TABLE taxon FROM ara;
GRANT ALL ON TABLE taxon TO ara;
GRANT ALL ON TABLE taxon TO postgres;


--
-- TOC entry 2911 (class 0 OID 0)
-- Dependencies: 1977
-- Name: taxon_author; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon_author FROM PUBLIC;
REVOKE ALL ON TABLE taxon_author FROM ara;
GRANT ALL ON TABLE taxon_author TO ara;
GRANT ALL ON TABLE taxon_author TO postgres;


--
-- TOC entry 2912 (class 0 OID 0)
-- Dependencies: 1978
-- Name: taxon_author_connector; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon_author_connector FROM PUBLIC;
REVOKE ALL ON TABLE taxon_author_connector FROM ara;
GRANT ALL ON TABLE taxon_author_connector TO ara;
GRANT ALL ON TABLE taxon_author_connector TO postgres;


--
-- TOC entry 2913 (class 0 OID 0)
-- Dependencies: 1979
-- Name: taxon_category; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon_category FROM PUBLIC;
REVOKE ALL ON TABLE taxon_category FROM ara;
GRANT ALL ON TABLE taxon_category TO ara;
GRANT ALL ON TABLE taxon_category TO postgres;


--
-- TOC entry 2914 (class 0 OID 0)
-- Dependencies: 1980
-- Name: taxon_description; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon_description FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description FROM ara;
GRANT ALL ON TABLE taxon_description TO ara;
GRANT ALL ON TABLE taxon_description TO postgres;


--
-- TOC entry 2915 (class 0 OID 0)
-- Dependencies: 1981
-- Name: taxon_description_audience; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon_description_audience FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_audience FROM ara;
GRANT ALL ON TABLE taxon_description_audience TO ara;
GRANT ALL ON TABLE taxon_description_audience TO postgres;


--
-- TOC entry 2916 (class 0 OID 0)
-- Dependencies: 1982
-- Name: taxon_description_category; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon_description_category FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_category FROM ara;
GRANT ALL ON TABLE taxon_description_category TO ara;
GRANT ALL ON TABLE taxon_description_category TO postgres;


--
-- TOC entry 2917 (class 0 OID 0)
-- Dependencies: 1983
-- Name: taxon_description_datatype; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon_description_datatype FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_datatype FROM ara;
GRANT ALL ON TABLE taxon_description_datatype TO ara;
GRANT ALL ON TABLE taxon_description_datatype TO postgres;


--
-- TOC entry 2918 (class 0 OID 0)
-- Dependencies: 1984
-- Name: taxon_description_element; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon_description_element FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_element FROM ara;
GRANT ALL ON TABLE taxon_description_element TO ara;
GRANT ALL ON TABLE taxon_description_element TO postgres;


--
-- TOC entry 2919 (class 0 OID 0)
-- Dependencies: 1985
-- Name: taxon_description_institution; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon_description_institution FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_institution FROM ara;
GRANT ALL ON TABLE taxon_description_institution TO ara;
GRANT ALL ON TABLE taxon_description_institution TO postgres;


--
-- TOC entry 2920 (class 0 OID 0)
-- Dependencies: 1987
-- Name: taxon_description_record; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon_description_record FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_record FROM ara;
GRANT ALL ON TABLE taxon_description_record TO ara;
GRANT ALL ON TABLE taxon_description_record TO postgres;


--
-- TOC entry 2921 (class 0 OID 0)
-- Dependencies: 1988
-- Name: taxon_description_record_reference; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon_description_record_reference FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_record_reference FROM ara;
GRANT ALL ON TABLE taxon_description_record_reference TO ara;
GRANT ALL ON TABLE taxon_description_record_reference TO postgres;


--
-- TOC entry 2922 (class 0 OID 0)
-- Dependencies: 1989
-- Name: taxon_description_stage; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon_description_stage FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_stage FROM ara;
GRANT ALL ON TABLE taxon_description_stage TO ara;
GRANT ALL ON TABLE taxon_description_stage TO postgres;


--
-- TOC entry 2923 (class 0 OID 0)
-- Dependencies: 1990
-- Name: taxon_name_history; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon_name_history FROM PUBLIC;
REVOKE ALL ON TABLE taxon_name_history FROM ara;
GRANT ALL ON TABLE taxon_name_history TO ara;
GRANT ALL ON TABLE taxon_name_history TO postgres;


--
-- TOC entry 2924 (class 0 OID 0)
-- Dependencies: 1991
-- Name: taxon_nomenclatural_group; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon_nomenclatural_group FROM PUBLIC;
REVOKE ALL ON TABLE taxon_nomenclatural_group FROM ara;
GRANT ALL ON TABLE taxon_nomenclatural_group TO ara;
GRANT ALL ON TABLE taxon_nomenclatural_group TO postgres;


--
-- TOC entry 2925 (class 0 OID 0)
-- Dependencies: 1992
-- Name: taxon_reference; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxon_reference FROM PUBLIC;
REVOKE ALL ON TABLE taxon_reference FROM ara;
GRANT ALL ON TABLE taxon_reference TO ara;
GRANT ALL ON TABLE taxon_reference TO postgres;


--
-- TOC entry 2926 (class 0 OID 0)
-- Dependencies: 1993
-- Name: taxonomical_hierarchy; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxonomical_hierarchy FROM PUBLIC;
REVOKE ALL ON TABLE taxonomical_hierarchy FROM ara;
GRANT ALL ON TABLE taxonomical_hierarchy TO ara;
GRANT ALL ON TABLE taxonomical_hierarchy TO postgres;


--
-- TOC entry 2927 (class 0 OID 0)
-- Dependencies: 1994
-- Name: taxonomical_range; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE taxonomical_range FROM PUBLIC;
REVOKE ALL ON TABLE taxonomical_range FROM ara;
GRANT ALL ON TABLE taxonomical_range TO ara;
GRANT ALL ON TABLE taxonomical_range TO postgres;


--
-- TOC entry 2928 (class 0 OID 0)
-- Dependencies: 1995
-- Name: topographic_sheet; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE topographic_sheet FROM PUBLIC;
REVOKE ALL ON TABLE topographic_sheet FROM ara;
GRANT ALL ON TABLE topographic_sheet TO ara;
GRANT ALL ON TABLE topographic_sheet TO PUBLIC;


--
-- TOC entry 2929 (class 0 OID 0)
-- Dependencies: 1996
-- Name: transacted_specimen; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE transacted_specimen FROM PUBLIC;
REVOKE ALL ON TABLE transacted_specimen FROM ara;
GRANT ALL ON TABLE transacted_specimen TO ara;
GRANT ALL ON TABLE transacted_specimen TO postgres;


--
-- TOC entry 2930 (class 0 OID 0)
-- Dependencies: 1997
-- Name: transacted_specimen_status; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE transacted_specimen_status FROM PUBLIC;
REVOKE ALL ON TABLE transacted_specimen_status FROM ara;
GRANT ALL ON TABLE transacted_specimen_status TO ara;
GRANT ALL ON TABLE transacted_specimen_status TO postgres;


--
-- TOC entry 2931 (class 0 OID 0)
-- Dependencies: 1998
-- Name: transaction; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE "transaction" FROM PUBLIC;
REVOKE ALL ON TABLE "transaction" FROM ara;
GRANT ALL ON TABLE "transaction" TO ara;
GRANT ALL ON TABLE "transaction" TO postgres;


--
-- TOC entry 2932 (class 0 OID 0)
-- Dependencies: 1999
-- Name: transaction_type; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE transaction_type FROM PUBLIC;
REVOKE ALL ON TABLE transaction_type FROM ara;
GRANT ALL ON TABLE transaction_type TO ara;
GRANT ALL ON TABLE transaction_type TO postgres;


--
-- TOC entry 2933 (class 0 OID 0)
-- Dependencies: 2000
-- Name: type_specimen; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE type_specimen FROM PUBLIC;
REVOKE ALL ON TABLE type_specimen FROM ara;
GRANT ALL ON TABLE type_specimen TO ara;
GRANT ALL ON TABLE type_specimen TO postgres;


--
-- TOC entry 2934 (class 0 OID 0)
-- Dependencies: 2001
-- Name: type_specimen_type; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE type_specimen_type FROM PUBLIC;
REVOKE ALL ON TABLE type_specimen_type FROM ara;
GRANT ALL ON TABLE type_specimen_type TO ara;
GRANT ALL ON TABLE type_specimen_type TO postgres;


--
-- TOC entry 2935 (class 0 OID 0)
-- Dependencies: 2004
-- Name: versant; Type: ACL; Schema: ara; Owner: ara
--

REVOKE ALL ON TABLE versant FROM PUBLIC;
REVOKE ALL ON TABLE versant FROM ara;
GRANT ALL ON TABLE versant TO ara;
GRANT ALL ON TABLE versant TO PUBLIC;


-- Completed on 2008-07-15 17:10:19

--
-- PostgreSQL database dump complete
--

