SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;
CREATE SCHEMA ara;
ALTER SCHEMA ara OWNER TO ara;
COMMENT ON SCHEMA ara IS 'Standard ara schema';
COMMENT ON SCHEMA public IS 'Standard public schema';
SET search_path = ara, pg_catalog;
SET default_tablespace = '';
SET default_with_oids = false;
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
CREATE TABLE gathering_observation (
gathering_observation_id numeric NOT NULL,
site_id numeric NOT NULL,
responsible_person_id numeric NOT NULL,
initial_date date ,
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
CREATE TABLE id_gen (
gen_key character varying NOT NULL,
gen_value numeric NOT NULL
);
ALTER TABLE ara.id_gen OWNER TO ara;
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
CREATE TABLE institution (
institution_id numeric NOT NULL,
institution_code character varying(20) NOT NULL,
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
CREATE TABLE nomenclatural_group (
nomenclatural_group_id numeric NOT NULL,
name character varying(100) NOT NULL,
description character varying(500),
temporality character varying(500),
common_name character varying(1) NOT NULL,
certificator_person_id numeric,
collection_id numeric,
notes character varying(4000),
obj_version numeric NOT NULL,
created_by character varying(100) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(100) NOT NULL,
last_modification_date date NOT NULL
);
ALTER TABLE ara.nomenclatural_group OWNER TO ara;
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
CREATE TABLE pg_ts_cfg (
ts_name text NOT NULL,
prs_name text NOT NULL,
locale text
);
ALTER TABLE ara.pg_ts_cfg OWNER TO ara;
CREATE TABLE pg_ts_cfgmap (
ts_name text NOT NULL,
tok_alias text NOT NULL,
dict_name text[]
);
ALTER TABLE ara.pg_ts_cfgmap OWNER TO ara;
CREATE TABLE pg_ts_dict (
dict_name text NOT NULL,
dict_init regprocedure,
dict_initoption text,
dict_lexize regprocedure NOT NULL,
dict_comment text
);
ALTER TABLE ara.pg_ts_dict OWNER TO ara;
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
CREATE TABLE specimen (
specimen_id numeric NOT NULL,
Institution_id numeric NOT NULL,
Catalog_Number numeric NOT NULL,
gathering_observation_id numeric NOT NULL,
discarded character varying(1)  NOT NULL,
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
external_specimen character varying(100),
gathering_observation_method_id numeric,
certainty_level numeric,
date_time timestamp without time zone,
gathering_observation_detail_id numeric
);
ALTER TABLE ara.specimen OWNER TO ara;
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
CREATE TABLE system_option_bak (
option_id numeric,
module_id numeric,
name character varying(100),
description character varying(500),
type_id numeric,
obj_version numeric,
navigation_rule character varying(500),
created_by character varying(100),
creation_date timestamp without time zone,
last_modification_by character varying(100),
last_modification_date timestamp without time zone
);
ALTER TABLE ara.system_option_bak OWNER TO postgres;
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
CREATE TABLE taxon_description_category (
taxon_description_category_id numeric NOT NULL,
name character varying(80) NOT NULL,
description character varying(500),
"sequence" numeric,
ancestor_id numeric,
"repeatable" numeric(1,0),
mandatory numeric(1,0),
STANDARD_CONCEPT character varying(100),
creation_date date,
created_by character varying(100),
last_modification_date date,
last_modification_by character varying(100),
obj_version numeric NOT NULL
);
ALTER TABLE ara.taxon_description_category OWNER TO ara;
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
create table ara.DARWIN_CORE_1_4
( GlobalUniqueIdentifier varchar,
 DateLastModified timestamp,
 InstitutionCode varchar,
 CollectionCode varchar,
 CatalogNumber varchar,
 CatalogNumberNumeric  numeric,
 ScientificName varchar,
 BasisOfRecord varchar,
 InformationWithheld varchar,
 KingdomId numeric, 
 Phylum_id numeric, 
 Class_id numeric, 
 Orders_id numeric, 
 Family_id numeric, 
 Genus_id numeric, 
 SpecificEpithet_id numeric, 
 InfraSpecificEpithet_id numeric,
 HigherTaxon varchar,
 Kingdom varchar,
 Phylum varchar,
 Class varchar,
 Orders varchar,
 Family varchar,
 Genus varchar,
 SpecificEpithet varchar, 
 InfraSpecificEpithet varchar,
 InfraspecificRank varchar,
 AuthorYearOfScientificName varchar,
 NomenclaturalCode varchar,
 IdentificationQualifier varchar,
 IdentifiedBy varchar,
 DateIdentified timestamp, 
 TypeStatus varchar,
 CollectingMethod varchar,
 ValidDistributionFlag varchar,
 CollectorNumber varchar,
 FieldNumber  varchar,
 Collector varchar,
 EarliestDateCollected timestamp,
 LatestDateCollected timestamp,
 VerbatimCollectingDate varchar,
 DayOfYear numeric,
 FieldNotes varchar,
 HigherGeography varchar,
 Continent varchar,
 WaterBody varchar,
 IslandGroup varchar,
 Island varchar,
 Country varchar,
 StateProvince  varchar,
 County varchar,
 Locality varchar,
 DecimalLongitude varchar,
 VerbatimLongitude varchar,
 DecimalLatitude varchar,
 VerbatimLatitude varchar,
 GeodeticDatum varchar,
 VerbatimCoordinateSystem varchar,
 GeoreferenceProtocol varchar,
 CoordinateUncertaintyInMeters varchar,
 GeoreferenceRemarks varchar,
 FootprintWKT varchar,
 MinimumElevationInMeters double precision,
 MaximumElevationInMeters double precision,
 VerbatimElevation double precision,
 MinimumDepthInMeters double precision,
 MaximumDepthInMeters double precision,
 Sex varchar,
 LifeStage varchar,
 Preparations varchar,
 IndividualCount numeric,
 GenBankNum varchar,
 OtherCatalogNumbers varchar,
 RelatedCatalogItems varchar,
 Remarks varchar,
 Attributes  varchar,
 ImageURL varchar,
 RelatedInformation varchar,
 Disposition varchar,
 PointRadiusSpatialFit decimal,
 FootprintSpatialFit  decimal,
 VerbatimCoordinates varchar,
 GeoreferenceSources varchar,
 GeoreferenceVerificationStatus varchar,
 PRIMARY KEY ( GlobalUniqueIdentifier));
ALTER TABLE ara.DARWIN_CORE_1_4 OWNER TO ara;
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;
SET search_path = ara, pg_catalog;
INSERT INTO audience (audience_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (2, 'Público general', 'All users', 0, 'ara', '2008-04-02', 'ara', '2008-04-02');
INSERT INTO audience (audience_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (3, 'Educadores, estudiantes y formadores de opinión de distintos niveles', 'profesores, monitores, periodistas, religiosos o afines', 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO audience (audience_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (6, 'Tomadores de decisiones', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO audience (audience_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (1, 'Investigadores de biodiversidad', 'Científicos, taxónomos, biólogos, técnicos especialistas, bioquímicos, profesionales de salud, educadores y estudiantes universitarios o afines', 1, 'ara', '2008-04-02', 'ara', '2008-04-02');
INSERT INTO audience (audience_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (4, 'Productores que hacen un uso sustentable del recurso', NULL , 1, 'ara', '2008-04-02', 'ara', '2008-04-02');
INSERT INTO audience (audience_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (5, 'Profesionales de campos fuera de la biodiversidad', ' (Autores literarios, historiadores, etnógrafos) y usuarios gráficos (Ilustradores, pintores, diseñadores o afines)' , 1, 'ara', '2008-04-02', 'ara', '2008-04-02');
INSERT INTO collection (collection_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (11, 'Mollusca', NULL, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO collection (collection_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (12, 'Plantae', NULL, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO collection (collection_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (13, 'Arachnida', NULL, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO collection (collection_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (14, 'Fungi', NULL, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO collection (collection_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (9, 'Chordata', 'Vertebrates', '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO collection (collection_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (10, 'Insecta', NULL, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO protocol_attribute (protocol_attribute_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (1, 'Usa detalles de recolección', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO protocol_attribute (protocol_attribute_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (2, 'Proyección por defecto', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO protocol_attribute (protocol_attribute_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (3, 'Método de recolección usado por defecto', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO protocol_attribute (protocol_attribute_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (4, 'Permite el uso de sinónimos en identificaciones', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO protocol_attribute (protocol_attribute_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (5, 'Utiliza formas de vida', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO protocol_attribute (protocol_attribute_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (6, 'Nombre del módulo que utiliza la colección para manejar las descripciones morfológicas', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO protocol_attribute (protocol_attribute_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (7, 'Utiliza cultivos', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO protocol_attribute (protocol_attribute_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (8, 'Comparte secuencias de detalles de recolección con otras colecciones', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO protocol_attribute (protocol_attribute_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (9, 'Permite administrar observaiones de especímenes', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO protocol_attribute (protocol_attribute_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (10, 'La modificación de un taxón puede generar la reidentificación de los especímenes asociados', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO collection_protocol (collection_id, protocol_attribute_id, value, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (9, 2, '1', 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO collection_protocol (collection_id, protocol_attribute_id, value, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (9, 3, '1', 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO collection_protocol (collection_id, protocol_attribute_id, value, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (9, 4, 'false', 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO collection_protocol (collection_id, protocol_attribute_id, value, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (9, 7, 'false', 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO collection_protocol (collection_id, protocol_attribute_id, value, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (9, 8, 'false', 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO collection_protocol (collection_id, protocol_attribute_id, value, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (9, 9, 'false', 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO collection_protocol (collection_id, protocol_attribute_id, value, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (9, 10, 'true', 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO collection_protocol (collection_id, protocol_attribute_id, value, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (9, 5, 'true', 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO collection_protocol (collection_id, protocol_attribute_id, value, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (9, 6, 'gatheringDetail', 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO collection_protocol (collection_id, protocol_attribute_id, value, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (9, 1, 'true', 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO concept (concept_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version, name, description) VALUES (1, 'ara', '2007-01-01', 'ara', '2007-01-01', 0, 'Español', 'español');
INSERT INTO concept (concept_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version, name, description) VALUES (2, 'ara', '2007-01-01', 'ara', '2007-01-01', 0, 'English', 'inglés');
INSERT INTO concept (concept_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version, name, description) VALUES (3, 'ara', '2007-01-01', 'ara', '2007-01-01', 0, 'Portuguese', 'portugués');
INSERT INTO country (country_id, value, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (1, 'CRA', '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO country (country_id, value, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (3, 'USA', '2007-09-02', 'ara', '2007-09-02', 'ara', 0);
INSERT INTO country (country_id, value, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (2, 'PNA', '2007-01-01', 'ara', '2007-09-02', 'ara', 2);
INSERT INTO exposition (exposition_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (1, 'Este', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO exposition (exposition_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (2, 'Norte', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO exposition (exposition_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (3, 'Sur', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO exposition (exposition_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (4, 'Oeste', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO extraction_type (extraction_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (1, 'Método modificado de decantación y cribado de Cobb', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO extraction_type (extraction_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (2, 'Método de Oostenbrink', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO feature_type (feature_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (1, 'Punto', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO feature_type (feature_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (2, 'Polígono', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO feature_type (feature_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (3, 'Línea', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO gathering_observation_method (gathering_observation_method_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (4, 'Recolecta Manual', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO gathering_observation_method (gathering_observation_method_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (1, 'Observación directa', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO gathering_observation_method (gathering_observation_method_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (2, 'Evidencias - pistas', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO gathering_observation_method (gathering_observation_method_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (3, 'Determinación auditiva', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO gathering_observation_method (gathering_observation_method_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (5, 'Trampa de Foso', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO gathering_observation_method (gathering_observation_method_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (6, 'Trampa de Malaise', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO geographic_entity (geographic_entity_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (1, 'America Central', NULL, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO geographic_entity (geographic_entity_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (2, 'Mesoamerica', NULL, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO geographic_entity (geographic_entity_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (3, 'Región Caribe', NULL, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO geographic_entity (geographic_entity_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (4, 'Norteamérica', NULL, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO geographic_entity (geographic_entity_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (5, 'Sudamerica', NULL, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO geographic_entity (geographic_entity_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (6, 'América', NULL, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
insert into ara.id_gen (gen_key,gen_value) values ('taxon_description_stage', 2);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('user_type_id', 3);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('reference_element_id', 1);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('country_id', 4);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('taxon_author_connector_id', 10);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('TAXON_DESCRIPTION_DATATYPE_ID', 13);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('profile_id', 19);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('audience_id', 7);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('user_id', 72);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('nomenclatural_group_id', 11);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('identification_history_id', 1);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('identifier_history_id', 1);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('site_id', 1);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('taxon_id', 6);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('institution_id', 1);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('person_id', 1);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('taxon_description_record_id', 1);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('site_coordinate_id', 1);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('reference_id', 1);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('gathering_observation_id', 1);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('morphological_description_id', 1);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('gathering_observation_detail_id', 1);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('specimen_id', 1);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('type_specimen_id', 1);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('type_specimen_type_id', 18);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('collection_id', 15);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('protocol_attribute_id', 11);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('exposition_id', 5);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('extraction_type_id', 3);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('gathering_observation_method_id', 7);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('identification_type_id', 8);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('interaction_type_id', 7);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('life_form_id', 12);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('life_stage_id', 5);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('origin_id', 6);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('preservation_medium_id', 12);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('reference_type_id', 3);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('sex_id', 6);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('storage_type_id', 8);
INSERT INTO id_gen (gen_key, gen_value) VALUES ('substrate_id', 3);
INSERT INTO identification_status (identification_status_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (2, 'Temporal', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO identification_status (identification_status_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (1, 'Valida', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO identification_type (identification_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (1, 'aff', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO identification_type (identification_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (2, 'cf', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO identification_type (identification_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (3, 'Sensu lato', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO identification_type (identification_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (4, 'Sensu stricto', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO identification_type (identification_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (6, 'Auditiva', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO identification_type (identification_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (7, 'Evidencia / pistas', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO identification_type (identification_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (5, 'Visual', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO interaction_type (interaction_type_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (1, 'Neutralismo', NULL, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO interaction_type (interaction_type_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (2, 'Amensalismo', NULL, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO interaction_type (interaction_type_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (3, 'Comensalismo', NULL, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO interaction_type (interaction_type_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (4, 'Competencia', NULL, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO interaction_type (interaction_type_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (5, 'Mutualismo', NULL, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO interaction_type (interaction_type_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (6, 'Predación o parasitismo', NULL, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO "language" (language_id, concept_id, obj_version, creation_date, last_modification_date, created_by, last_modification_by) VALUES (1, 1, 0, '2007-01-01', '2007-01-01', 'ara', 'ara');
INSERT INTO "language" (language_id, concept_id, obj_version, creation_date, last_modification_date, created_by, last_modification_by) VALUES (2, 2, 0, '2007-01-01', '2007-01-01', 'ara', 'ara');
INSERT INTO "language" (language_id, concept_id, obj_version, creation_date, last_modification_date, created_by, last_modification_by) VALUES (3, 3, 0, '2007-01-01', '2007-01-01', 'ara', 'ara');
INSERT INTO life_form (life_form_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (1, 'Árbol', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO life_form (life_form_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (2, 'Arbusto', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO life_form (life_form_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (3, 'Hierba', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO life_form (life_form_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (4, 'Bejuco', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO life_form (life_form_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (5, 'Epífita', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO life_form (life_form_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (6, 'Parásita', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO life_form (life_form_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (7, 'Briófita', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO life_form (life_form_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (8, 'Saprófita', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO life_form (life_form_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (9, 'Helecho', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO life_form (life_form_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (10, 'Palma', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO life_form (life_form_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (11, 'Liana', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO life_stage (life_stage_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (2, 'Larva', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO life_stage (life_stage_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (4, 'Ninfa', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO life_stage (life_stage_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (1, 'Adulto', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO life_stage (life_stage_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (3, 'Juvenil', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO list_table (list_table_id, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date, name, key_field_name) VALUES (1, 'Método de observación o recolecta', 0, 'ara', '2008-01-01', 'ara', '2008-01-01', 'gathering_observation_method', 'gathering_observation_method_id');
INSERT INTO list_table (list_table_id, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date, name, key_field_name) VALUES (2, 'Specimen categories', 0, 'ara', '2008-01-01', 'ara', '2008-01-01', 'specimen_category', 'specimen_category_id');
INSERT INTO list_table (list_table_id, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date, name, key_field_name) VALUES (3, 'Tipo de espécimen', 0, 'ara', '2008-01-01', 'ara', '2008-01-01', 'specimen_type', 'specimen_type_id');
INSERT INTO list_table (list_table_id, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date, name, key_field_name) VALUES (4, 'Origen del espécimen', 0, 'ara', '2008-01-01', 'ara', '2008-01-01', 'origin', 'origin_id');
INSERT INTO list_table (list_table_id, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date, name, key_field_name) VALUES (5, 'Método de preserva del espécimen', 0, 'ara', '2008-01-01', 'ara', '2008-01-01', 'preservation_medium', 'preservation_medium_id');
INSERT INTO list_table (list_table_id, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date, name, key_field_name) VALUES (6, 'Tipo de almacenamiento de los especímenes', 0, 'ara', '2008-01-01', 'ara', '2008-01-01', 'storage_type', 'storage_type_id');
INSERT INTO list_table (list_table_id, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date, name, key_field_name) VALUES (7, 'Estadio', 0, 'ara', '2008-01-01', 'ara', '2008-01-01', 'life_stage', 'life_stage_id');
INSERT INTO list_table (list_table_id, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date, name, key_field_name) VALUES (8, 'Sexo del espécimen', 0, 'ara', '2008-01-01', 'ara', '2008-01-01', 'sex', 'sex_id');
INSERT INTO list_table (list_table_id, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date, name, key_field_name) VALUES (9, 'Substrato', 0, 'ara', '2008-01-01', 'ara', '2008-01-01', 'substrate', 'substrate_id');
INSERT INTO list_table (list_table_id, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date, name, key_field_name) VALUES (10, 'Tipo de identificación', 0, 'ara', '2008-01-01', 'ara', '2008-01-01', 'identification_type', 'identification_type_id');
INSERT INTO list_table (list_table_id, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date, name, key_field_name) VALUES (11, 'Forma de vida', 0, 'ara', '2008-01-01', 'ara', '2008-01-01', 'life_form', 'life_form_id');
INSERT INTO list_table (list_table_id, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date, name, key_field_name) VALUES (13, 'Tipo de extracción', 0, 'ARA', '2008-01-01', 'ARA', '2008-01-01', 'extraction_type', 'extraction_type_id');
INSERT INTO list_table (list_table_id, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date, name, key_field_name) VALUES (14, 'Partes de componentes asociados a especímenes', 0, 'ARA', '2008-01-01', 'ARA', '2008-01-01', 'component_part', 'component_part_id');
INSERT INTO list_table (list_table_id, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date, name, key_field_name) VALUES (17, 'Método de preparación del espécimen', 0, 'ara', '2008-01-01', 'ara', '2008-01-01', 'preparation_method', 'preparation_method_id');
INSERT INTO list_table (list_table_id, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date, name, key_field_name) VALUES (18, 'Método de muestreo', 0, 'ara', '2008-01-01', 'ara', '2008-01-01', 'sampling_type', 'sampling_type_id');
INSERT INTO list_table (list_table_id, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date, name, key_field_name) VALUES (19, 'Conectores para los nombres taxonómicos', 0, 'ara', '2008-01-01', 'ara', '2008-01-01', 'taxon_author_connector', 'taxon_author_connector_id');
INSERT INTO list_table (list_table_id, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date, name, key_field_name) VALUES (20, 'Tipo de espécimen tipo', 0, 'ara', '2008-01-01', 'ara', '2008-01-01', 'type_specimen_type', 'type_specimen_type_id');
INSERT INTO list_table (list_table_id, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date, name, key_field_name) VALUES (21, 'Tipo de referencias', 0, 'ara', '2008-01-01', 'ara', '2008-01-01', 'reference_type', 'reference_type_id');
INSERT INTO list_table (list_table_id, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date, name, key_field_name) VALUES (22, 'Método para calcular el sitio', 0, 'ara', '2008-01-01', 'ara', '2008-01-01', 'site_calculation_method', 'site_calculation_method_id'); 
INSERT INTO list_table (list_table_id, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date, name, key_field_name) VALUES (23, 'Exposición', 0, 'ara', '2008-01-01', 'ara', '2008-01-01', 'exposition', 'exposition_id'); 
INSERT INTO list_table (list_table_id, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date, name, key_field_name) VALUES (24, 'Tipo de interacción', 0, 'ara', '2008-01-01', 'ara', '2008-01-01', 'interaction_type', 'interaction_type_id');  
INSERT INTO list_table (list_table_id, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date, name, key_field_name) VALUES (25, 'Catálogo geográfico', 0, 'ara', '2008-01-01', 'ara', '2008-01-01', 'geographic_catalogue', 'geographic_catalogue_id');  
INSERT INTO list_table (list_table_id, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date, name, key_field_name) VALUES (26, 'Estado de la identificación', 0, 'ara', '2008-01-01', 'ara', '2008-01-01', 'identification_status', 'identification_status_id');  
INSERT INTO list_table_collection (list_table_id, collection_id, value_id, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (1, 9, 1, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO list_table_collection (list_table_id, collection_id, value_id, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (1, 9, 2, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO list_table_collection (list_table_id, collection_id, value_id, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (1, 9, 3, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO list_table_collection (list_table_id, collection_id, value_id, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (3, 9, 1, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO list_table_collection (list_table_id, collection_id, value_id, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (4, 9, 4, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO list_table_collection (list_table_id, collection_id, value_id, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (4, 9, 3, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO list_table_collection (list_table_id, collection_id, value_id, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (5, 9, 3, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO list_table_collection (list_table_id, collection_id, value_id, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (5, 9, 10, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO list_table_collection (list_table_id, collection_id, value_id, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (6, 9, 7, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO list_table_collection (list_table_id, collection_id, value_id, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (7, 9, 1, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO list_table_collection (list_table_id, collection_id, value_id, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (8, 9, 1, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO list_table_collection (list_table_id, collection_id, value_id, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (8, 9, 2, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO list_table_collection (list_table_id, collection_id, value_id, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (9, 9, 1, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO list_table_collection (list_table_id, collection_id, value_id, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (10, 9, 5, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO list_table_collection (list_table_id, collection_id, value_id, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (10, 9, 6, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO list_table_collection (list_table_id, collection_id, value_id, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (10, 9, 7, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO list_table_collection (list_table_id, collection_id, value_id, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (11, 9, 1, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO list_table_collection (list_table_id, collection_id, value_id, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (11, 9, 2, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO list_table_collection (list_table_id, collection_id, value_id, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (3, 9, 2, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO list_table_collection (list_table_id, collection_id, value_id, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (2, 9, 2, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO list_table_collection (list_table_id, collection_id, value_id, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (2, 9, 4, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO list_table_collection (list_table_id, collection_id, value_id, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (2, 9, 1, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO list_table_collection (list_table_id, collection_id, value_id, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (2, 9, 3, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO list_table_collection (list_table_id, collection_id, value_id, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (26, 9, 1, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO list_table_collection (list_table_id, collection_id, value_id, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (26, 9, 2, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO nomenclatural_group (nomenclatural_group_id, name, description, temporality, common_name, certificator_person_id, collection_id, notes, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (6, 'Vertebrados', 'CR vertebrates', 'Permanent', 'y', NULL, 9, NULL, 0, 'ara', '2008-06-30', 'ara', '2008-06-30');
INSERT INTO nomenclatural_group (nomenclatural_group_id, name, description, temporality, common_name, certificator_person_id, collection_id, notes, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (7, 'Reptiles', 'Reptiles', NULL, 'y', NULL, 9, NULL, 0, 'ara', '2008-07-14', 'ara', '2008-07-14');
INSERT INTO nomenclatural_group_region (nomenclatural_group_id, region_id, "sequence", obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (6, 1, 1, 0, 'ara', '2008-08-04', 'ara', '2008-08-04');
INSERT INTO nomenclatural_group_region (nomenclatural_group_id, region_id, "sequence", obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (7, 1, 1, 0, 'ara', '2008-08-05', 'ara', '2008-08-05');
INSERT INTO origin (origin_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (4, 'Silvestre', 'Silvestre', 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO origin (origin_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (5, 'Silvestre - criado', 'Silvestre - criado', 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO origin (origin_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (3, 'Domestico', 'Domestico', 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO origin (origin_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (2, 'Cultivado', 'Cultivado', 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO origin (origin_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (1, 'Criado', 'Criado', 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO preservation_medium (preservation_medium_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (1, 'Alcohol', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO preservation_medium (preservation_medium_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (2, 'Bouin', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO preservation_medium (preservation_medium_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (5, 'Ethanol', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO preservation_medium (preservation_medium_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (7, 'Formol', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO preservation_medium (preservation_medium_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (3, 'Congelado', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO preservation_medium (preservation_medium_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (4, 'unknown', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO preservation_medium (preservation_medium_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (6, 'Formalina al 4%', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO preservation_medium (preservation_medium_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (8, 'Lámina fija', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO preservation_medium (preservation_medium_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (9, 'Seco', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO preservation_medium (preservation_medium_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (11, 'Vivo', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO preservation_medium (preservation_medium_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (10, 'Sobres', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO profile (profile_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (9, 'Responsable de recolecciones', NULL, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO profile (profile_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (10, 'Autor taxonómico', NULL, '2007-07-13', 'ara', '2007-09-03', 'ara', 3);
INSERT INTO profile (profile_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (13, 'Colector de especímenes', 'Specimens collector', '2007-09-03', 'ara', '2008-04-03', 'ara', 1);
INSERT INTO profile (profile_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (14, 'Autor de registros de especies', 'Specimens record author', '2007-01-01', 'ara', '2008-03-31', 'ara', 4);
INSERT INTO profile (profile_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (15, 'Autor de descripciones morfológicas', NULL, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO profile (profile_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (16, 'Validador de identificationes', 'Determination validator', '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO profile (profile_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (18, 'Certificador de grupos nomenclaturales', NULL, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO profile (profile_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (17, 'Determinador', 'Identificador', '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO projection (projection_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (1, 'Mercator', 'Mercator', 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO reference_type (reference_type_id, name, description, obj_version, creation_date, created_by, last_modification_date, last_modification_by) VALUES (1, 'Libros', 'Libros', 0, '2008-01-01', 'ara', '2008-01-01', 'ara');
INSERT INTO reference_type (reference_type_id, name, description, obj_version, creation_date, created_by, last_modification_date, last_modification_by) VALUES (2, 'URL', 'Libros', 0, '2008-01-01', 'ara', '2008-01-01', 'ara');
INSERT INTO region (region_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (1, 'Costa Rica', NULL, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO sex (sex_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (4, 'Desconocido', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO sex (sex_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (5, 'Hermafrodita', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO sex (sex_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (3, 'N/A', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO sex (sex_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (2, 'Hembra', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO sex (sex_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (1, 'Macho', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO site_calculation_method (site_calculation_method_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (1, 'Hoja Cartográfica', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO site_calculation_method (site_calculation_method_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (2, 'GPS', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO specimen_category (specimen_category_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (2, 'Individual', 'Individual', 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO specimen_category (specimen_category_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (4, 'Agrupado multi-taxón', 'Multiple taxon grouped', 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO specimen_category (specimen_category_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (3, 'Agrupado uni-taxón', 'Single taxon grouped', 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO specimen_category (specimen_category_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (1, 'Observación', 'Observation', 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO specimen_type (specimen_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (2, 'Multiples individuos', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO specimen_type (specimen_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (1, 'Organismo', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO storage_type (storage_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (7, 'Viva', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO storage_type (storage_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (6, 'Seca', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO storage_type (storage_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (2, 'Húmeda', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO storage_type (storage_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (4, 'Montaje para microscopía', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO storage_type (storage_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (1, 'Base para microscopía electrónica', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO storage_type (storage_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (5, 'Montajes permanentes en laminillas de Cobb', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO storage_type (storage_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (3, 'Lámina Fija', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO substrate (substrate_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (2, 'Suelo', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO substrate (substrate_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (1, 'Troncos en descomposición', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO system_module (module_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version, subsystem_id) VALUES (2, 'menuModuleSpecimens', NULL, 'ara', '2008-01-01', 'ara', '2008-01-01', 0, 1);
INSERT INTO system_module (module_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version, subsystem_id) VALUES (5, 'menuModuleLocations', NULL, 'ara', '2008-01-01', 'ara', '2008-01-01', 0, 2);
INSERT INTO system_module (module_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version, subsystem_id) VALUES (8, 'menuModuleSpecies', NULL, 'ara', '2008-01-01', 'ara', '2008-01-01', 0, 3);
INSERT INTO system_module (module_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version, subsystem_id) VALUES (9, 'menuModuleUsers', NULL, 'ara', '2008-01-01', 'ara', '2008-01-01', 0, 7);
INSERT INTO system_module (module_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version, subsystem_id) VALUES (10, 'menuModuleGroups', NULL, 'ara', '2008-01-01', 'ara', '2008-01-01', 0, 7);
INSERT INTO system_module (module_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version, subsystem_id) VALUES (13, 'menuModulePeople', NULL, 'ara', '2008-01-01', 'ara', '2008-01-01', 0, 5);
INSERT INTO system_module (module_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version, subsystem_id) VALUES (14, 'menuModuleInstitutions', NULL, 'ara', '2008-01-01', 'ara', '2008-01-01', 0, 5);
INSERT INTO system_module (module_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version, subsystem_id) VALUES (15, 'menuModuleStages', NULL, 'ara', '2008-01-01', 'ara', '2008-01-01', 0, 5);
INSERT INTO system_module (module_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version, subsystem_id) VALUES (16, 'menuModuleProfiles', NULL, 'ara', '2008-01-01', 'ara', '2008-01-01', 0, 5);
INSERT INTO system_module (module_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version, subsystem_id) VALUES (17, 'menuModuleChangePassword', NULL, 'ara', '2008-01-01', 'ara', '2008-01-01', 0, 5);
INSERT INTO system_module (module_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version, subsystem_id) VALUES (18, 'menuModuleReferences', NULL, 'ara', '2008-01-01', 'ara', '2008-01-01', 0, 5);
INSERT INTO system_module (module_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version, subsystem_id) VALUES (19, 'menuModuleAudiences', NULL, 'ara', '2008-01-01', 'ara', '2008-01-01', 0, 5);
INSERT INTO system_module (module_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version, subsystem_id) VALUES (7, 'menuModuleNomenclaturalGroups', NULL, 'ara', '2008-01-01', 'ara', '2008-01-01', 0, 3);
INSERT INTO system_module (module_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version, subsystem_id) VALUES (3, 'menuModuleInstitutions', NULL, 'ara', '2008-01-01', 'ara', '2008-01-01', 0, 1);
INSERT INTO system_module (module_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version, subsystem_id) VALUES (1, 'menuModuleGatheringsObservations', NULL, 'ara', '2008-01-01', 'ara', '2008-01-01', 0, 1);
INSERT INTO system_module (module_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version, subsystem_id) VALUES (6, 'menuModuleTaxa', NULL, 'ara', '2008-01-01', 'ara', '2008-01-01', 0, 3);
INSERT INTO system_module (module_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version, subsystem_id) VALUES (21, 'menuModuleAdminCollections', NULL, 'ara', '2008-01-01', 'ara', '2008-01-01', 0, 3);
INSERT INTO system_module (module_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version, subsystem_id) VALUES (20, 'menuModuleSelectionLists', NULL, 'ara', '2008-01-01', 'ara', '2008-01-01', 0, 3);
insert into system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) values (94,21,'adminCollections','admin',1,0,'adminCollections','ara','2008-01-01 00:00:00','ara','2008-01-01 00:00:00');


INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (3, 1, 'modifyGatherings', 'update', 3, 0, 'editGathering', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (4, 1, 'deleteGatherings', 'delete', 4, 0, 'null', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (6, 2, 'listSpecimens', 'list', 1, 0, 'listSpecimen', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (7, 2, 'addSpecimes', 'add', 2, 0, 'addSpecimen', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (8, 2, 'modifySpecimens', 'update', 3, 0, 'modifySpecimen', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (9, 2, 'deleteSpecimens', 'delete', 4, 0, 'null', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (10, 2, 'searchSpecimens', 'search', 5, 0, 'searchSpecimen', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (11, 3, 'listIdentifications', 'list', 1, 0, 'listIdentification', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (12, 3, 'addIdentification', 'add', 2, 0, 'reIdentify', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (13, 3, 'modifyIdentification', 'update', 3, 0, 'editIdentification', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (14, 3, 'deleteIdentification', 'delete', 4, 0, 'null', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (15, 3, 'searchIdentifiers', 'search', 5, 0, 'searchIdentification', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (21, 5, 'listLocations', 'list', 1, 0, 'listSite', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (22, 5, 'addLocation', 'add', 2, 0, 'newSite', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (23, 5, 'modifyLocation', 'update', 3, 0, 'editSite', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (24, 5, 'deleteLocation', 'delete', 4, 0, 'null', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (25, 5, 'searchLocation', 'search', 5, 0, 'searchSite', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (26, 6, 'listTaxons', 'list', 1, 0, 'listTaxon', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (27, 6, 'addTaxons', 'add', 2, 0, 'addTaxon', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (28, 6, 'modifyTaxons', 'update', 3, 0, 'modifyTaxon', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (29, 6, 'deleteTaxons', 'delete', 4, 0, 'null', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (30, 6, 'searchTaxons', 'search', 5, 0, 'searchTaxon', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (31, 7, 'listNomenclaturalGroups', 'list', 1, 0, 'listNomenclaturalGroup', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (32, 7, 'addNomenclaturalGroups', 'add', 2, 0, 'newNomenclaturalGroup', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (33, 7, 'modifyNomenclaturalGroups', 'update', 3, 0, 'editNomenclaturalGroup', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (34, 7, 'deleteNomenclaturalGroups', 'delete', 4, 0, 'null', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (35, 7, 'searchNomenclaturalGroups', 'search', 5, 0, 'searchNomenclaturalGroup', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (36, 8, 'listSpeciesRecords', 'list', 1, 0, 'listSpecies', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (37, 8, 'addSpeciesRecords', 'add', 2, 0, 'newSpecies', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (38, 8, 'modifySpeciesRecords', 'update', 3, 0, 'case2', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (39, 8, 'deleteSpeciesRecords', 'delete', 4, 0, 'null', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (40, 8, 'searchSpeciesRecords', 'search', 5, 0, 'search', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (41, 9, 'listUsers', 'list', 1, 0, 'listUser', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (42, 9, 'addUsers', 'add', 2, 0, 'newUser', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (43, 9, 'modifyUser', 'update', 3, 0, 'editUser', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (44, 9, 'deleteUsers', 'delete', 4, 0, 'null', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (45, 9, 'blockUser', 'update', 4, 0, 'null', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (46, 9, 'searchUsers', 'search', 5, 0, 'searchUser', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (47, 10, 'listGroups', 'list', 1, 0, 'listGroup', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (48, 10, 'addGroup', 'add', 2, 0, 'newGroup', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (49, 10, 'modifyGroup', 'modify', 3, 0, 'editGroup', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (50, 10, 'deleteGroup', 'delete', 4, 0, 'deleteGroup', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (51, 10, 'searchGroup', 'search', 5, 0, 'searchGroup', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (68, 13, 'listPeople', 'list', 1, 0, 'listPerson', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (69, 13, 'addPerson', 'add', 2, 0, 'newPerson', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (70, 13, 'modifyPerson', 'update', 3, 0, 'case3', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (71, 13, 'deletePerson', 'delete', 4, 0, 'null', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (73, 14, 'addInstitution', 'add', 2, 0, 'case3', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (74, 14, 'modifyInstitution', 'update', 3, 0, 'doEditInstitution', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (75, 14, 'deleteInstitution', 'delete', 4, 0, 'null', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (76, 15, 'listStages', 'list', 1, 0, 'listStage', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (77, 15, 'addStages', 'add', 2, 0, 'new', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (78, 15, 'modifyStages', 'update', 3, 0, 'edit', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (79, 15, 'deleteStages', 'delete', 4, 0, 'null', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (80, 16, 'listProfiles', 'list', 1, 0, 'listProfile', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (81, 16, 'addProfiles', 'add', 2, 0, 'doNewProfile', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (82, 16, 'modifyProfiles', 'update', 3, 0, 'doEditProfile', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (83, 16, 'deleteProfiles', 'delete', 4, 0, 'null', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (85, 18, 'listReferences', 'list', 1, 0, 'listReference', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (86, 18, 'addReferences', 'add', 2, 0, 'newReference', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (87, 18, 'editReferences', 'update', 3, 0, 'doEditReference', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (88, 18, 'deleteReferences', 'delete', 4, 0, 'null', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (89, 18, 'searchReferences', 'search', 5, 0, 'case2', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (91, 19, 'addAudiences', 'add', 2, 0, 'doNewAudience', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (90, 19, 'listAudiences', 'list', 1, 0, 'listAudience', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (92, 19, 'editAudiences', 'edit', 3, 0, 'doEditAudience', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (1, 1, 'listGatherings', 'list', 1, 0, 'listGathering', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (2, 1, 'addGatherings', 'add', 2, 0, 'newGathering', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (5, 1, 'searchGatherings', 'search', 5, 0, 'searchGathering', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (72, 14, 'listInstitutions', 'list', 1, 0, 'listInstitution', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');

INSERT INTO system_option (option_id, module_id, name, description, type_id, obj_version, navigation_rule, created_by, creation_date, last_modification_by, last_modification_date) VALUES (84, 17, 'changePassword', 'update', 1, 0, 'changePassword', 'ara', '2008-01-01 00:00:00', 'ara', '2008-01-01 00:00:00');




INSERT INTO system_option_type (system_option_type_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (6, 'report', 'report', 'postgres', '2006-09-29 16:41:58.969138', 'postgres', '2006-09-29 16:41:58.969138', NULL);
INSERT INTO system_option_type (system_option_type_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (1, 'list', 'used for list items from table or query', 'postgres', '2006-07-29 15:39:44.953', 'postgres', '2006-07-29 15:39:44.953', 0);
INSERT INTO system_option_type (system_option_type_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (2, 'add', 'used for add data into a table', 'postgres', '2006-07-29 15:39:58.906', 'postgres', '2006-07-29 15:39:58.906', 0);
INSERT INTO system_option_type (system_option_type_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (3, 'update', 'used for update data on a table', 'postgres', '2006-07-29 15:40:17.562', 'postgres', '2006-07-29 15:40:17.562', 0);
INSERT INTO system_option_type (system_option_type_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (4, 'delete', 'used for delete data from a table', 'postgres', '2006-07-29 15:40:32.781', 'postgres', '2006-07-29 15:40:32.781', 0);
INSERT INTO system_option_type (system_option_type_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (5, 'search', 'used for perform search on tables or queries', 'postgres', '2006-07-29 15:46:48.812', 'postgres', '2006-07-29 15:46:48.812', 0);
INSERT INTO system_subsystem (subsystem_id, name, description, "sequence", obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (2, 'Geographical Information', NULL, 3, 0, 'ara', '2007-01-01', 'ara', '2007-01-01');
INSERT INTO system_subsystem (subsystem_id, name, description, "sequence", obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (3, 'Taxonomy', NULL, 1, 0, 'ara', '2007-01-01', 'ara', '2007-01-01');
INSERT INTO system_subsystem (subsystem_id, name, description, "sequence", obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (4, 'Reports', NULL, 5, 0, 'ara', '2007-01-01', 'ara', '2007-01-01');
INSERT INTO system_subsystem (subsystem_id, name, description, "sequence", obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (6, 'User', NULL, 6, 0, 'ara', '2007-01-01', 'ara', '2007-01-01');
INSERT INTO system_subsystem (subsystem_id, name, description, "sequence", obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (7, 'Security', NULL, 7, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO system_subsystem (subsystem_id, name, description, "sequence", obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (1, 'Inventory', NULL, 2, 0, 'ara', '2007-01-01', 'ara', '2007-01-01');
INSERT INTO system_subsystem (subsystem_id, name, description, "sequence", obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (5, 'Administration', NULL, 4, 0, 'ara', '2007-01-01', 'ara', '2007-01-01');
INSERT INTO system_user_type(user_type_id,name,description,creation_date,created_by,last_modification_date,last_modification_by,obj_version) VALUES (1,'Group','descripcion','2008-05-13','ara','2008-05-28','ara',0);
INSERT INTO system_user_type(user_type_id,name,description,creation_date,created_by,last_modification_date,last_modification_by,obj_version) VALUES (2,'User','descripcion','2008-05-13','ara','2008-05-28','ara',0);
INSERT INTO system_user (user_id, username, fullname, passwd, created_by, creation_date, last_modification_by, last_modification_date, enabled, obj_version, user_type_id, user_group_id) VALUES (71, 'ara', 'Administrador del sistema', '21232f297a57a5a743894a0e4a801fc3', 'ara', '2008-05-13', 'ara', '2008-05-13', 1, 0, 2, 70);
INSERT INTO system_user (user_id, username, fullname, passwd, created_by, creation_date, last_modification_by, last_modification_date, enabled, obj_version, user_type_id, user_group_id) VALUES (25, 'admin', 'Administradores del sistema', '21232f297a57a5a743894a0e4a801fc3', 'ara', '2008-08-05', 'ara', '2008-08-05', 1, 14, 2, 70);
INSERT INTO system_user (user_id, username, fullname, passwd, created_by, creation_date, last_modification_by, last_modification_date, enabled, obj_version, user_type_id, user_group_id) VALUES (70, 'Administradores', 'Administradores del sistema', '636bfa0fb2716ff876f5e33854cc9648', 'ara', '2008-05-13', 'ara', '2008-05-28', 0, 8, 1, NULL);
insert into system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) values (71,94,'ara','2008-05-28','ara','2008-05-28',0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 1, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 2, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 3, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 4, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 5, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 6, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 7, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 8, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 9, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 10, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 11, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 12, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 13, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 14, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 15, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 21, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 22, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 23, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 24, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 25, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 26, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 27, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 28, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 29, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 30, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 31, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 32, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 33, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 34, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 35, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 36, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 37, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 38, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 39, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 40, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 41, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 42, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 43, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 44, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 45, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 46, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 47, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 48, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 49, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 50, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 51, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 68, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 72, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 73, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 74, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 75, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 76, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 77, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 78, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 79, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 80, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 81, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 82, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 83, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 84, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 85, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 86, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 87, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 88, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 89, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 90, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 91, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 92, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 69, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 71, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (71, 70, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

insert into system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) values (25,94, 'ara','2008-05-28','ara','2008-05-28',0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 1, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 2, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 3, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 4, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 5, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 6, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 7, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 8, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 9, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 10, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 11, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 12, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 13, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 14, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 15, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 21, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 22, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 23, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 24, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 25, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 26, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 27, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 28, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 29, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 30, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 31, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 32, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 33, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 34, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 35, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 36, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 37, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 38, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 39, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 40, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 41, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 42, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 43, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 44, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 45, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 46, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 47, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 48, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 49, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 50, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 51, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 68, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 72, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 73, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 74, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 75, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 76, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 77, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 78, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 79, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 80, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 81, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 82, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 83, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 84, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 85, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 86, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 87, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 88, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 89, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 90, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 91, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 92, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 69, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 71, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (25, 70, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);

INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 1, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 2, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 3, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 4, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 5, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 6, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 7, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 8, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 9, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 10, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 11, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 12, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 13, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 14, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 15, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 21, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 22, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 23, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 24, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 25, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 26, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 27, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 28, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 29, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 30, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 31, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 32, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 33, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 34, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 35, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 36, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 37, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 38, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 39, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 40, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 41, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 42, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 43, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 44, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 45, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 46, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 47, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 48, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 49, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 50, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 51, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 68, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 72, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 73, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 74, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 75, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 76, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 77, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 78, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 79, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 80, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 81, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 82, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 83, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 84, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 85, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 86, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 87, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 88, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 89, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 90, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 91, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 92, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 69, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 71, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO system_user_option (user_id, option_id, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (70, 70, 'ara', '2008-05-28', 'ara', '2008-05-28', 0);
INSERT INTO taxon (taxon_id, taxonomical_range_id, current_name, current_name_timestamp, default_name, current_predecessor_timestamp, taxon_category_id, dominium_taxon_id, kingdom_taxon_id, phylum_division_taxon_id, subphylum_subdivision_taxon_id, class_taxon_id, subclass_taxon_id, order_taxon_id, suborder_taxon_id, superfamily_taxon_id, family_taxon_id, subfamily_taxon_id, tribe_taxon_id, subtribe_taxon_id, genus_taxon_id, subgenus_taxon_id, section_taxon_id, subsection_taxon_id, stirps_taxon_id, species_taxon_id, subspecies_taxon_id, variety_taxon_id, description_month, description_year, synonym_taxon_id, author_format_parenthesis, creation_date, created_by, last_modification_date, last_modification_by, collection_id, ancestor_id, basionym, country_id, obj_version, subkingdom_taxon_id, infrakingdom_taxon_id, superphylum_taxon_id, infraphylum_infradivision_taxon_id, superclass_taxon_id, superorder_taxon_id) VALUES (1, 23, 'Eukaryotes', '2000-07-29', 'Eukaryotes', NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 9, NULL, '', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO taxon (taxon_id, taxonomical_range_id, current_name, current_name_timestamp, default_name, current_predecessor_timestamp, taxon_category_id, dominium_taxon_id, kingdom_taxon_id, phylum_division_taxon_id, subphylum_subdivision_taxon_id, class_taxon_id, subclass_taxon_id, order_taxon_id, suborder_taxon_id, superfamily_taxon_id, family_taxon_id, subfamily_taxon_id, tribe_taxon_id, subtribe_taxon_id, genus_taxon_id, subgenus_taxon_id, section_taxon_id, subsection_taxon_id, stirps_taxon_id, species_taxon_id, subspecies_taxon_id, variety_taxon_id, description_month, description_year, synonym_taxon_id, author_format_parenthesis, creation_date, created_by, last_modification_date, last_modification_by, collection_id, ancestor_id, basionym, country_id, obj_version, subkingdom_taxon_id, infrakingdom_taxon_id, superphylum_taxon_id, infraphylum_infradivision_taxon_id, superclass_taxon_id, superorder_taxon_id) VALUES (2, 1, 'Animalia', '1995-05-02', 'Animalia', '1995-05-02', 1, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 9, 1, '', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO taxon (taxon_id, taxonomical_range_id, current_name, current_name_timestamp, default_name, current_predecessor_timestamp, taxon_category_id, dominium_taxon_id, kingdom_taxon_id, phylum_division_taxon_id, subphylum_subdivision_taxon_id, class_taxon_id, subclass_taxon_id, order_taxon_id, suborder_taxon_id, superfamily_taxon_id, family_taxon_id, subfamily_taxon_id, tribe_taxon_id, subtribe_taxon_id, genus_taxon_id, subgenus_taxon_id, section_taxon_id, subsection_taxon_id, stirps_taxon_id, species_taxon_id, subspecies_taxon_id, variety_taxon_id, description_month, description_year, synonym_taxon_id, author_format_parenthesis, creation_date, created_by, last_modification_date, last_modification_by, collection_id, ancestor_id, basionym, country_id, obj_version, subkingdom_taxon_id, infrakingdom_taxon_id, superphylum_taxon_id, infraphylum_infradivision_taxon_id, superclass_taxon_id, superorder_taxon_id) VALUES (3, 2, 'Chordata', '2002-08-09', 'Chordata', '2002-08-09', 1, 1, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 9, 2, '', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO taxon (taxon_id, taxonomical_range_id, current_name, current_name_timestamp, default_name, current_predecessor_timestamp, taxon_category_id, dominium_taxon_id, kingdom_taxon_id, phylum_division_taxon_id, subphylum_subdivision_taxon_id, class_taxon_id, subclass_taxon_id, order_taxon_id, suborder_taxon_id, superfamily_taxon_id, family_taxon_id, subfamily_taxon_id, tribe_taxon_id, subtribe_taxon_id, genus_taxon_id, subgenus_taxon_id, section_taxon_id, subsection_taxon_id, stirps_taxon_id, species_taxon_id, subspecies_taxon_id, variety_taxon_id, description_month, description_year, synonym_taxon_id, author_format_parenthesis, creation_date, created_by, last_modification_date, last_modification_by, collection_id, ancestor_id, basionym, country_id, obj_version, subkingdom_taxon_id, infrakingdom_taxon_id, superphylum_taxon_id, infraphylum_infradivision_taxon_id, superclass_taxon_id, superorder_taxon_id) VALUES (4, 1, 'Plantae', '2008-04-02', 'Plantae', NULL, 1, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '2008-04-02', 'ara', '2008-04-02', 'ara', 9, 1, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO ara.taxon (taxon_id, taxonomical_range_id, current_name, current_name_timestamp, default_name, current_predecessor_timestamp, taxon_category_id, dominium_taxon_id, kingdom_taxon_id, phylum_division_taxon_id, subphylum_subdivision_taxon_id, class_taxon_id, subclass_taxon_id, order_taxon_id, suborder_taxon_id, superfamily_taxon_id, family_taxon_id, subfamily_taxon_id, tribe_taxon_id, subtribe_taxon_id, genus_taxon_id, subgenus_taxon_id, section_taxon_id, subsection_taxon_id, stirps_taxon_id, species_taxon_id, subspecies_taxon_id, variety_taxon_id, description_month, description_year, synonym_taxon_id, author_format_parenthesis, creation_date, created_by, last_modification_date, last_modification_by, collection_id, ancestor_id, basionym, country_id, obj_version, subkingdom_taxon_id, infrakingdom_taxon_id, superphylum_taxon_id, infraphylum_infradivision_taxon_id, superclass_taxon_id, superorder_taxon_id) VALUES (5, 4, 'Reptilia', '2002-08-09', 'Reptilia', '2002-08-09', 1, 1, 2, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 9, 3, '', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO taxon_nomenclatural_group (nomenclatural_group_id, taxon_id, taxonomical_timestamp, "sequence", obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (7, 5, '2008-08-05', 1, 0, 'ara', '2008-08-05', 'ara', '2008-08-05');
INSERT INTO taxon_author_connector (taxon_author_connector_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (2, '&', 'bla', '2007-07-18', 'ara', '2007-07-18', 'ara', 0);
INSERT INTO taxon_author_connector (taxon_author_connector_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (4, 'et', NULL, '2007-09-02', 'ara', '2007-09-02', 'ara', 1);
INSERT INTO taxon_author_connector (taxon_author_connector_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (1, 'emend.', NULL, '2007-09-02', 'ara', '2007-09-02', 'ara', 1);
INSERT INTO taxon_author_connector (taxon_author_connector_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (3, 'ex', NULL, '2007-09-02', 'ara', '2007-09-02', 'ara', 1);
INSERT INTO taxon_author_connector (taxon_author_connector_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (5, 'in', NULL, '2007-09-02', 'ara', '2007-09-02', 'ara', 1);
INSERT INTO taxon_author_connector (taxon_author_connector_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (6, 'nec', NULL, '2007-09-02', 'ara', '2007-09-02', 'ara', 1);
INSERT INTO taxon_author_connector (taxon_author_connector_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (7, '.:', NULL, '2007-09-02', 'ara', '2007-09-02', 'ara', 1);
INSERT INTO taxon_author_connector (taxon_author_connector_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (8, 'non', NULL, '2007-09-02', 'ara', '2007-09-02', 'ara', 1);
INSERT INTO taxon_author_connector (taxon_author_connector_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (9, ':', NULL, '2007-09-02', 'ara', '2007-09-02', 'ara', 1);
INSERT INTO taxon_category (taxon_category_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (2, 'Temporal', 'Taxon temporal definido usualmente para el trabajo cotidiano de los taxonomos.', '2000-07-29', 'ATTA', '2000-07-29', 'ATTA', 0);
INSERT INTO taxon_category (taxon_category_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (1, 'Aceptado', 'Taxon valido, araado y vigente del taxon.', '2000-07-29', 'ATTA', '2000-07-29', 'ATTA', 0);
INSERT INTO taxon_category (taxon_category_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (3, 'Sinonimo', 'Nombre que pertenece a la sinonimia de otro taxon.', '2000-07-29', 'ATTA', '2000-07-29', 'ATTA', 0);
INSERT INTO taxon_category (taxon_category_id, name, description, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (4, 'En desuso', 'Taxon que se ha dejado de utilizar por diversas razones.', '2000-07-29', 'ATTA', '2000-07-29', 'ATTA', 0);
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (1, 'Description', '', 1, 0, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, NULL);
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (6, 'Identification Keys', '', 3, 1, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, NULL);
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (9, 'Natural History', '', 2, 0, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, NULL);
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (16, 'Interactions', '', 7, 9, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, NULL);
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (24, 'Detail', '', 1, 23, 1, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, NULL);
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (25, 'Details Text', '', 2, 23, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, NULL);
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (26, 'Habitat and Distribution', '', 3, 0, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, NULL);
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (29, 'Atomized Distribution', '', 1, 28, 1, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, NULL);
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (30, 'Distribution Area', '', 2, 28, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, NULL);
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (32, 'Atomized Endemism', '', 1, 31, 1, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, NULL);
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (33, 'Endemism Text', '', 2, 31, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, NULL);
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (34, 'Demography and Conservation', '', 4, 0, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, NULL);
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (39, 'Atomized Distribution', '', 1, 38, 1, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, NULL);
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (40, 'Distribution Area', '', 2, 38, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, NULL);
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (43, 'Legistation Text', '', 1, 42, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, NULL);
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (44, 'Legislation', '', 2, 42, 1, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, NULL);
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (45, 'Uses and Management', '', 5, 0, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, NULL);
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (66, 'Base elements', ' ', 0, 0, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, NULL);
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (48, 'Documentation', NULL, 1, 47, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, NULL);
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (17, 'Text Interactions', '', 1, 16, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, NULL);
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (67, 'Abstract', NULL, 1, 66, 0, 0, '2008-01-01', 'ara', '2008-01-01', 'ara', 0, NULL);
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (2, 'Brief Description', '', 1, 1, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, 'BriefDescription');
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (3, 'Full Description', '', 2, 1, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, 'ScientificDescription');
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (7, 'Keys', '', 1, 6, 1, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, 'IdentificationKeys');
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (10, 'Habit', '', 1, 9, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, 'Habit');
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (11, 'Life Cycle', '', 2, 9, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, 'LifeCycle');
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (12, 'Reproduction', '', 3, 9, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, 'Reproduction');
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (13, 'Annual Cyle', '', 4, 9, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, 'AnnualCycle');
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (14, 'Feeding', '', 5, 9, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, 'Feeding');
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (15, 'Behavior', '', 6, 9, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, 'Behavior');
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (18, 'Interaction', '', 2, 16, 1, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, 'Interactions');
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (19, 'Chromosomic Number', '', 8, 9, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, 'ChromosomicNumberN');
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (20, 'Molecular data', '', 9, 9, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, 'MolecularData');
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (21, 'Migratory data', '', 10, 9, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, 'MigratoryData');
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (22, 'Ecological Significance', '', 11, 9, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, 'EcologicalSignificance');
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (27, 'Habitat', '', 1, 26, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, 'Habitat');
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (28, 'Distribution', '', 2, 26, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, 'Distribution');
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (31, 'Endemicity', '', 3, 26, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, 'Endemicity');
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (35, 'Territory', '', 1, 34, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, 'Territory');
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (36, 'Population Biology', '', 2, 34, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, 'PopulationBiology');
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (37, 'Threat Status', '', 3, 34, 1, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, 'ThreatStatus');
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (42, 'Legislation', '', 4, 34, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, 'Legislation');
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (46, 'Uses', '', 1, 45, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, 'Uses');
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (63, 'Folkclore', '', 3, 45, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, 'Folkclore');
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (64, 'Management', '', 4, 45, 0, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, 'Management');
INSERT INTO taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, creation_date, created_by, last_modification_date, last_modification_by, obj_version, standard_concept) VALUES (65, 'References', '', 6, 0, 1, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0, 'References');
INSERT INTO taxon_description_datatype (taxon_description_datatype_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (3, 'Predefined ListBox', 'campo de opciones predefinidas', 'ara', '2007-01-01', 'ara', '2007-01-01', 0);
INSERT INTO taxon_description_datatype (taxon_description_datatype_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (2, 'TextArea', 'campo de texto de multiples lineas', 'ara', '2007-01-01', 'ara', '2007-01-01', 0);
INSERT INTO taxon_description_datatype (taxon_description_datatype_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (4, 'Label', 'campo de texto No editable', 'ara', '2007-01-01', 'ara', '2007-01-01', 0);
INSERT INTO taxon_description_datatype (taxon_description_datatype_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (5, 'TaxonNameWidget', 'campo de texto para insertar nombre de un taxon o buscarlo.', 'ara', '2007-01-01', 'ara', '2007-01-01', 0);
INSERT INTO taxon_description_datatype (taxon_description_datatype_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (6, 'Textbox No Editable', 'campo de una linea de texto, que no es editable', 'ara', '2007-01-01', 'ara', '2007-01-01', 0);
INSERT INTO taxon_description_datatype (taxon_description_datatype_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (7, 'TextAndRefWidget', 'TextArea + Widget de Referencias', 'ara', '2007-01-01', 'ara', '2007-01-01', 0);
INSERT INTO taxon_description_datatype (taxon_description_datatype_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (1, 'TextBox', 'campo de texto de 1 linea', 'ara', '2007-01-01', 'ara', '2007-01-01', 0);
INSERT INTO taxon_description_datatype (taxon_description_datatype_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (8, 'Contents_Number', 'Contents_Number', 'ara', '2007-01-01', 'ara', '2007-01-01', 0);
INSERT INTO taxon_description_datatype (taxon_description_datatype_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (9, 'Contents_Text', 'Contents_Text', 'ara', '2007-01-01', 'ara', '2007-01-01', 0);
INSERT INTO taxon_description_datatype (taxon_description_datatype_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (11, 'Vacio', 'Vacio', 'ara', '2007-01-01', 'ara', '2007-01-01', 0);
INSERT INTO taxon_description_datatype (taxon_description_datatype_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (10, 'autocomplete', 'autcomplete', 'ara', '2007-01-01', 'ara', '2007-01-01', 0);
INSERT INTO taxon_description_datatype (taxon_description_datatype_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (12, 'Calendar', 'calendar', 'ara', '2007-01-01', 'ara', '2007-01-01', 0);
INSERT INTO taxon_description_datatype (taxon_description_datatype_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (15, 'AddRemove', 'AddRemove', 'ara', '2008-01-01', 'ara', '2008-01-01', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (18, 78, 'Interaction Species', 0, NULL, 2, 0, NULL, NULL, NULL, 0, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (11, 13, 'Unstructured description', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (12, 15, 'Unstructured description', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (13, 17, 'Unstructured description', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (14, 19, 'Unstructured description', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (15, 21, 'Unstructured description', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (17, 23, 'Unstructured description', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (18, 26, 'Interaction Comments', 0, NULL, 6, 0, NULL, NULL, NULL, 2, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (19, 28, 'Unstructured description', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (20, 29, 'Unstructured description', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (21, 30, 'Unstructured description', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (22, 31, 'Unstructured description', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (24, 32, 'Item Attribute', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (24, 33, 'Item Value', 0, NULL, 6, 0, NULL, NULL, NULL, 2, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (25, 35, 'Unstructured description', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (27, 37, 'Unstructured description', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (30, 41, 'Unstructured description', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (32, 43, 'Endemic for', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (33, 46, 'Unstructured description', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (35, 48, 'Unstructured description', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (36, 50, 'Unstructured description', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (37, 52, 'Threat status', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (37, 53, 'According to', 0, NULL, 6, 0, NULL, NULL, NULL, 2, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (39, 54, 'Catalogue', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (40, 57, 'Unstructured description', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (43, 60, 'Unstructured description', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (44, 62, 'Legislation name', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (44, 63, 'Protection legal status', 0, NULL, 6, 0, NULL, NULL, NULL, 2, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (46, 65, 'Unstructured description', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (48, 67, 'Source of information text', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (63, 68, 'Unstructured description', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (64, 70, 'Unstructured description', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (2, 82, 'Unstructured description', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (3, 83, 'Unstructured description', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (10, 84, 'Unstructured description', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (37, 85, 'Applies to', 0, NULL, 6, 0, NULL, NULL, NULL, 3, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (67, 76, 'Unstructured description', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (7, 86, 'Unstructured description', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (18, 25, 'Interaction Type', 0, NULL, 3, 0, 'InteractionType', 'id', 'name', 1, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (29, 38, 'Catalogue', 0, NULL, 3, 0, 'GeographicCatalogue', 'id', 'name', 1, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (29, 39, 'Geographic Entity', 0, NULL, 3, 0, 'GeographicEntity', 'id', 'name', 2, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (39, 55, 'Geographic Entity', 0, NULL, 3, 0, 'GeographicEntity', 'id', 'name', 2, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (32, 44, 'Endemic in', 0, NULL, 3, 0, 'Country', 'id', 'name', 2, '2007-01-01', 'ara', '2007-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (65, 88, 'Title', 0, NULL, 6, 0, NULL, NULL, NULL, 1, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (65, 89, 'Description', 0, NULL, 6, 0, NULL, NULL, NULL, 2, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (65, 91, 'Identifier', 0, NULL, 6, 0, NULL, NULL, NULL, 4, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (65, 92, 'Type', 0, NULL, 3, 0, 'ReferenceType', 'id', 'name', 5, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (65, 94, 'Coverage', 0, NULL, 6, 0, NULL, NULL, NULL, 7, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (65, 95, 'Contributor', 0, NULL, 6, 0, NULL, NULL, NULL, 8, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (65, 96, 'Creator', 0, NULL, 6, 0, NULL, NULL, NULL, 9, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (65, 97, 'Publisher', 0, NULL, 6, 0, NULL, NULL, NULL, 10, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (65, 98, 'Relation', 0, NULL, 6, 0, NULL, NULL, NULL, 11, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (65, 99, 'Rights', 0, NULL, 6, 0, NULL, NULL, NULL, 12, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (65, 100, 'Source', 0, NULL, 6, 0, NULL, NULL, NULL, 13, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (65, 101, 'Subject', 0, NULL, 6, 0, NULL, NULL, NULL, 14, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (65, 93, 'Language', 0, NULL, 6, 0, NULL, NULL, NULL, 6, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO taxon_description_element (taxon_description_category_id, taxon_description_element_id, name, mandatory, description, taxon_description_datatype_id, "repeatable", table_name, key_field, main_field_name, "sequence", creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (65, 90, 'Publication date', 0, NULL, 6, 0, NULL, NULL, NULL, 3, '2008-01-01', 'ara', '2008-01-01', 'ara', 0);
INSERT INTO taxon_description_stage (taxon_description_stage_id, name, description, created_by, creation_date, last_modification_by, last_modification_date, obj_version) VALUES (1, 'No publicado', 'Registro de especie no publicado', 'ara', '2007-07-22', 'ara', '2007-07-22', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (22, 20, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (22, 19, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (22, 18, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (20, 19, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (20, 18, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (19, 18, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (18, 17, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (18, 16, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (18, 15, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (18, 14, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (18, 13, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (17, 16, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (17, 15, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (17, 14, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (17, 13, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (16, 15, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (15, 14, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (15, 13, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (13, 11, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (13, 12, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (13, 10, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (13, 9, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (12, 11, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (11, 10, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (11, 9, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (10, 9, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (9, 8, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (9, 7, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (9, 6, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (8, 6, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (7, 6, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (6, 5, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (6, 4, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (5, 4, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (4, 3, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (4, 2, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (3, 2, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (2, 1, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (1, 23, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_hierarchy (taxonomical_range_id, ancestor_taxonomical_id, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (23, 0, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_range (taxonomical_range_id, name, prefix, parenthesis, taxonomical_range_category, field_name, taxonomical_hierarchy_level, mandatory_level, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (0, 'Raíz', NULL, 0, 'r', NULL, 0, 1, '2000-01-01', 'ara', '2000-01-01', 'ara', 0);
INSERT INTO taxonomical_range (taxonomical_range_id, name, prefix, parenthesis, taxonomical_range_category, field_name, taxonomical_hierarchy_level, mandatory_level, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (1, 'Reino', NULL, 0, 'k', 'kingdom', 2, 1, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_range (taxonomical_range_id, name, prefix, parenthesis, taxonomical_range_category, field_name, taxonomical_hierarchy_level, mandatory_level, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (2, 'Filo/División', NULL, 0, 'n', 'phylum_division', 3, 1, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_range (taxonomical_range_id, name, prefix, parenthesis, taxonomical_range_category, field_name, taxonomical_hierarchy_level, mandatory_level, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (3, 'Subfilo/Division', NULL, 0, 'n', 'subphylum_subdivision', 4, 0, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_range (taxonomical_range_id, name, prefix, parenthesis, taxonomical_range_category, field_name, taxonomical_hierarchy_level, mandatory_level, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (4, 'Clase', NULL, 0, 'n', 'class', 5, 1, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_range (taxonomical_range_id, name, prefix, parenthesis, taxonomical_range_category, field_name, taxonomical_hierarchy_level, mandatory_level, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (5, 'Subclase', NULL, 0, 'n', 'subclass', 6, 0, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_range (taxonomical_range_id, name, prefix, parenthesis, taxonomical_range_category, field_name, taxonomical_hierarchy_level, mandatory_level, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (6, 'Orden', NULL, 0, 'n', 'order', 7, 1, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_range (taxonomical_range_id, name, prefix, parenthesis, taxonomical_range_category, field_name, taxonomical_hierarchy_level, mandatory_level, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (7, 'Suborden', NULL, 0, 'n', 'suborder', 8, 0, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_range (taxonomical_range_id, name, prefix, parenthesis, taxonomical_range_category, field_name, taxonomical_hierarchy_level, mandatory_level, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (8, 'Superfamilia', NULL, 0, 'n', 'superfamily', 9, 0, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_range (taxonomical_range_id, name, prefix, parenthesis, taxonomical_range_category, field_name, taxonomical_hierarchy_level, mandatory_level, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (9, 'Familia', NULL, 0, 'f', 'family', 10, 1, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_range (taxonomical_range_id, name, prefix, parenthesis, taxonomical_range_category, field_name, taxonomical_hierarchy_level, mandatory_level, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (10, 'Subfamilia', NULL, 0, 'n', 'subfamily', 11, 0, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_range (taxonomical_range_id, name, prefix, parenthesis, taxonomical_range_category, field_name, taxonomical_hierarchy_level, mandatory_level, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (11, 'Tribu', NULL, 0, 'n', 'tribe', 12, 0, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_range (taxonomical_range_id, name, prefix, parenthesis, taxonomical_range_category, field_name, taxonomical_hierarchy_level, mandatory_level, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (12, 'Subtribu', NULL, 0, 'n', 'subtribe', 13, 0, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_range (taxonomical_range_id, name, prefix, parenthesis, taxonomical_range_category, field_name, taxonomical_hierarchy_level, mandatory_level, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (13, 'Género', NULL, 0, 'g', 'genus', 14, 1, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_range (taxonomical_range_id, name, prefix, parenthesis, taxonomical_range_category, field_name, taxonomical_hierarchy_level, mandatory_level, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (14, 'Subgénero', 'subg.', 1, 'n', 'subgenus', 15, 0, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_range (taxonomical_range_id, name, prefix, parenthesis, taxonomical_range_category, field_name, taxonomical_hierarchy_level, mandatory_level, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (15, 'Sección', 'sect.', 0, 'n', 'section', 16, 0, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_range (taxonomical_range_id, name, prefix, parenthesis, taxonomical_range_category, field_name, taxonomical_hierarchy_level, mandatory_level, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (16, 'Subsección', 'subsect.', 0, 'n', 'subsection', 17, 0, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_range (taxonomical_range_id, name, prefix, parenthesis, taxonomical_range_category, field_name, taxonomical_hierarchy_level, mandatory_level, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (17, 'Estirpe', 'stirps.', 0, 'n', 'stirps', 18, 0, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_range (taxonomical_range_id, name, prefix, parenthesis, taxonomical_range_category, field_name, taxonomical_hierarchy_level, mandatory_level, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (18, 'Especie', NULL, 0, 'e', 'species', 19, 1, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_range (taxonomical_range_id, name, prefix, parenthesis, taxonomical_range_category, field_name, taxonomical_hierarchy_level, mandatory_level, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (19, 'Subespecie', 'subsp.', 0, 'n', 'subspecies', 20, 0, '2007-07-15', 'ara', '2007-07-15', 'ara', 1);
INSERT INTO taxonomical_range (taxonomical_range_id, name, prefix, parenthesis, taxonomical_range_category, field_name, taxonomical_hierarchy_level, mandatory_level, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (20, 'Variedad', 'var.', 0, 'n', 'variety', 21, 0, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_range (taxonomical_range_id, name, prefix, parenthesis, taxonomical_range_category, field_name, taxonomical_hierarchy_level, mandatory_level, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (22, 'Forma', 'forma.', 0, 'n', 'form', 22, 0, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO taxonomical_range (taxonomical_range_id, name, prefix, parenthesis, taxonomical_range_category, field_name, taxonomical_hierarchy_level, mandatory_level, creation_date, created_by, last_modification_date, last_modification_by, obj_version) VALUES (23, 'Dominio', NULL, 0, 'n', 'dominium', 1, 1, '2007-07-15', 'ara', '2007-07-15', 'ara', 0);
INSERT INTO type_specimen_type (type_specimen_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (1, 'Holotipo', 'holotipo', 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO type_specimen_type (type_specimen_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (2, 'Paratipo', 'Paratipo', 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO type_specimen_type (type_specimen_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (3, 'Neotipo', 'Neotipo', 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO type_specimen_type (type_specimen_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (4, 'Sintipo', 'Sintipo', 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO type_specimen_type (type_specimen_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (5, 'Lectotipo', 'Lectotipo', 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO type_specimen_type (type_specimen_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (6, 'Paralectotipo', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO type_specimen_type (type_specimen_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (7, 'Hepantotipo', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO type_specimen_type (type_specimen_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (8, 'Isotipo', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO type_specimen_type (type_specimen_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (9, 'Hepantotipo', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO type_specimen_type (type_specimen_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (10, 'Isolectotipo', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO type_specimen_type (type_specimen_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (11, 'Isosintipo', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO type_specimen_type (type_specimen_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (12, 'Isoneotipo', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO type_specimen_type (type_specimen_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (13, 'Isoparatipo', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO type_specimen_type (type_specimen_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (14, 'Isoparalectotipo', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO type_specimen_type (type_specimen_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (15, 'Kleptotipo', NULL, 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO type_specimen_type (type_specimen_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (16, 'Allotipo', 'Clonotipo', 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO type_specimen_type (type_specimen_type_id, name, description, obj_version, created_by, creation_date, last_modification_by, last_modification_date) VALUES (17, 'Clonotipo', 'Clonotipo', 0, 'ara', '2008-01-01', 'ara', '2008-01-01');
INSERT INTO user_nomenclatural_group (nomenclatural_group_id, user_id, "sequence", obj_version, creation_date, created_by, last_modification_date, last_modification_by) VALUES (7, 25, 1, 0, '2008-01-01', 'ara', '2008-01-01', 'ara');
INSERT INTO user_taxon (taxon_id, user_id, "sequence", obj_version, creation_date, created_by, last_modification_date, last_modification_by) VALUES (3, 25, 1, 0, '2008-01-01', 'ara', '2008-01-01', 'ara');
ALTER TABLE ONLY system_option ADD CONSTRAINT "SYSTEM_OPTION_PK" PRIMARY KEY (option_id);
ALTER TABLE ONLY system_user_option ADD CONSTRAINT "SYSTEM_USER_OPTION_PK" PRIMARY KEY (user_id, option_id);
ALTER TABLE ONLY altitude_floor ADD CONSTRAINT altitude_floor_pk PRIMARY KEY (altitude_floor_id);
ALTER TABLE ONLY annotation ADD CONSTRAINT annotation_pk PRIMARY KEY (annotation_id);
ALTER TABLE ONLY base_projection ADD CONSTRAINT base_projection_pk PRIMARY KEY (base_projection_id);
ALTER TABLE ONLY biotic_unit ADD CONSTRAINT biotic_unit_pk PRIMARY KEY (biotic_unit_id);
ALTER TABLE ONLY canton_ifam ADD CONSTRAINT canton_ifam_pk PRIMARY KEY (canton_ifam_id);
ALTER TABLE ONLY canton ADD CONSTRAINT canton_pk PRIMARY KEY (canton_id);
ALTER TABLE ONLY collecting_area ADD CONSTRAINT collecting_area_pk PRIMARY KEY (collecting_area_id);
ALTER TABLE ONLY collection_protocol ADD CONSTRAINT collection_protocol_pk PRIMARY KEY (collection_id, protocol_attribute_id);
ALTER TABLE ONLY collector_observer ADD CONSTRAINT collector_observer_pk PRIMARY KEY (gathering_observation_id, collector_person_id);
ALTER TABLE ONLY component_part ADD CONSTRAINT component_part_pk PRIMARY KEY (component_part_id);
ALTER TABLE ONLY component ADD CONSTRAINT component_pk PRIMARY KEY (component_id);
ALTER TABLE ONLY conservation_area ADD CONSTRAINT conservation_area_pk PRIMARY KEY (conservation_area_id);
ALTER TABLE ONLY culture_medium ADD CONSTRAINT culture_medium_pk PRIMARY KEY (culture_medium_id);
ALTER TABLE ONLY culture ADD CONSTRAINT culture_pk PRIMARY KEY (specimen_id, replica_number);
ALTER TABLE ONLY culture_storage_medium ADD CONSTRAINT culture_storage_medium_pk PRIMARY KEY (culture_storage_medium_id);
ALTER TABLE ONLY determination_type ADD CONSTRAINT determination_type_pk PRIMARY KEY (determination_type_id);
ALTER TABLE ONLY district ADD CONSTRAINT district_pk PRIMARY KEY (district_id);
ALTER TABLE ONLY ecological_region ADD CONSTRAINT ecological_region_pk PRIMARY KEY (ecological_region_id);
ALTER TABLE ONLY ecological_variable ADD CONSTRAINT ecological_variable_pk PRIMARY KEY (ecological_variable_id);
ALTER TABLE ONLY ecological_variable_value ADD CONSTRAINT ecological_variable_value_pk PRIMARY KEY (ecological_variable_value_id);
ALTER TABLE ONLY ecosystem ADD CONSTRAINT ecosystem_pk PRIMARY KEY (ecosystem_id);
ALTER TABLE ONLY elevation_band ADD CONSTRAINT elevation_band_pk PRIMARY KEY (elevation_band_id);
ALTER TABLE ONLY exposition ADD CONSTRAINT exposition_pk PRIMARY KEY (exposition_id);
ALTER TABLE ONLY extraction_type ADD CONSTRAINT extraction_type_pk PRIMARY KEY (extraction_type_id);
ALTER TABLE ONLY feature_type ADD CONSTRAINT feature_type_pk PRIMARY KEY (feature_type_id);
ALTER TABLE ONLY gathering_observation_method ADD CONSTRAINT gathering_method_pk PRIMARY KEY (gathering_observation_method_id);
ALTER TABLE ONLY gathering_observation_collection ADD CONSTRAINT gathering_observation_collection_pk PRIMARY KEY (gathering_observation_id, collection_id);
ALTER TABLE ONLY gathering_observation_detail ADD CONSTRAINT gathering_observation_detail_pk PRIMARY KEY (gathering_observation_detail_id);
ALTER TABLE ONLY gathering_observation_project ADD CONSTRAINT gathering_observation_project_pk PRIMARY KEY (gathering_observation_id, project_id);
ALTER TABLE ONLY gathering_observation ADD CONSTRAINT gathering_pk PRIMARY KEY (gathering_observation_id);
ALTER TABLE ONLY geographic_layer ADD CONSTRAINT geographic_layer_pk PRIMARY KEY (geographic_layer_id);
ALTER TABLE ONLY georeferenced_site ADD CONSTRAINT georeferenced_site_pk PRIMARY KEY (site_id, geographic_layer_id, geographic_site_id);
ALTER TABLE ONLY id_gen ADD CONSTRAINT id_gen_pk PRIMARY KEY (gen_key);
ALTER TABLE ONLY identification_history ADD CONSTRAINT identification_history_pk PRIMARY KEY (identification_history_id);
ALTER TABLE ONLY identification ADD CONSTRAINT identification_pk PRIMARY KEY (specimen_id, identification_sequence, initial_timestamp);
ALTER TABLE ONLY identification_status ADD CONSTRAINT identification_status_pk PRIMARY KEY (identification_status_id);
ALTER TABLE ONLY identification_type ADD CONSTRAINT identification_type_pk PRIMARY KEY (identification_type_id);
ALTER TABLE ONLY identifier_history ADD CONSTRAINT identifier_history_pk PRIMARY KEY (identifier_history_id);
ALTER TABLE ONLY identifier ADD CONSTRAINT identifier_pk PRIMARY KEY (specimen_id, identification_sequence, initial_timestamp, identifier_person_id);
ALTER TABLE ONLY inmediate_predecessor_history ADD CONSTRAINT inmediate_precedecessor_history PRIMARY KEY (taxon_id, initial_timestamp, final_timestamp, predecessor_taxon_id);
ALTER TABLE ONLY label ADD CONSTRAINT label_pk PRIMARY KEY (label_id);
ALTER TABLE ONLY land_cover ADD CONSTRAINT land_cover_pk PRIMARY KEY (land_cover_id);
ALTER TABLE ONLY life_form ADD CONSTRAINT life_form_pk PRIMARY KEY (life_form_id);
ALTER TABLE ONLY life_stage ADD CONSTRAINT life_stage_pk PRIMARY KEY (life_stage_id);
ALTER TABLE ONLY life_zone ADD CONSTRAINT life_zone_pk PRIMARY KEY (life_zone_id);
ALTER TABLE ONLY list_table_collection ADD CONSTRAINT list_table_collection_pk PRIMARY KEY (list_table_id, collection_id, value_id);
ALTER TABLE ONLY list_table ADD CONSTRAINT list_table_pk PRIMARY KEY (list_table_id);
ALTER TABLE ONLY morphological_description ADD CONSTRAINT morphological_description_pk PRIMARY KEY (morphological_description_id);
ALTER TABLE ONLY natural_region ADD CONSTRAINT natural_region_pk PRIMARY KEY (natural_region_id);
ALTER TABLE ONLY nomenclatural_group ADD CONSTRAINT nomenclatural_group_pk PRIMARY KEY (nomenclatural_group_id);
ALTER TABLE ONLY nomenclatural_group_region ADD CONSTRAINT nomenclatural_group_region_pk PRIMARY KEY (region_id, nomenclatural_group_id);
ALTER TABLE ONLY ocean ADD CONSTRAINT ocean_pk PRIMARY KEY (ocean_id);
ALTER TABLE ONLY origin ADD CONSTRAINT origin_pk PRIMARY KEY (origin_id);
ALTER TABLE ONLY original_label ADD CONSTRAINT origincal_label_pk PRIMARY KEY (original_label_id);
ALTER TABLE ONLY pg_ts_cfg ADD CONSTRAINT pg_ts_cfg_pkey PRIMARY KEY (ts_name);
ALTER TABLE ONLY pg_ts_cfgmap ADD CONSTRAINT pg_ts_cfgmap_pkey PRIMARY KEY (ts_name, tok_alias);
ALTER TABLE ONLY pg_ts_dict ADD CONSTRAINT pg_ts_dict_pkey PRIMARY KEY (dict_name);
ALTER TABLE ONLY pg_ts_parser ADD CONSTRAINT pg_ts_parser_pkey PRIMARY KEY (prs_name);
ALTER TABLE ONLY audience ADD CONSTRAINT pk_arao_meta_id PRIMARY KEY (audience_id);
ALTER TABLE ONLY collection ADD CONSTRAINT pk_collection_id PRIMARY KEY (collection_id);
ALTER TABLE ONLY concept ADD CONSTRAINT pk_concept PRIMARY KEY (concept_id);
ALTER TABLE ONLY country ADD CONSTRAINT pk_country_id PRIMARY KEY (country_id);
ALTER TABLE ONLY geographic_catalogue ADD CONSTRAINT pk_geographic_catalogue PRIMARY KEY (geographic_catalogue_id);
ALTER TABLE ONLY geographic_entity ADD CONSTRAINT pk_geographic_entity PRIMARY KEY (geographic_entity_id);
ALTER TABLE ONLY institution ADD CONSTRAINT pk_institution_id PRIMARY KEY (institution_id);
ALTER TABLE ONLY interaction_type ADD CONSTRAINT pk_interaction_type PRIMARY KEY (interaction_type_id);
ALTER TABLE ONLY "language" ADD CONSTRAINT pk_language_id PRIMARY KEY (language_id);
ALTER TABLE ONLY person ADD CONSTRAINT pk_person_id PRIMARY KEY (person_id);
ALTER TABLE ONLY person_institution ADD CONSTRAINT pk_person_id_institution_id PRIMARY KEY (person_id, institution_id);
ALTER TABLE ONLY person_profile ADD CONSTRAINT pk_person_id_profile_id PRIMARY KEY (person_id, profile_id);
ALTER TABLE ONLY person_profile_taxon ADD CONSTRAINT pk_person_profile_taxon PRIMARY KEY (person_id, profile_id, taxon_id);
ALTER TABLE ONLY profile ADD CONSTRAINT pk_profile_id PRIMARY KEY (profile_id);
ALTER TABLE ONLY reference_element ADD CONSTRAINT pk_reference_element PRIMARY KEY (reference_element_id);
ALTER TABLE ONLY region ADD CONSTRAINT pk_region_id PRIMARY KEY (region_id);
ALTER TABLE ONLY taxon_description_stage ADD CONSTRAINT pk_species_record_stage PRIMARY KEY (taxon_description_stage_id);
ALTER TABLE ONLY species_record_stage_profile ADD CONSTRAINT pk_species_record_stage_prof PRIMARY KEY (species_record_stage_id, profile_id);
ALTER TABLE ONLY stage_transition_digraph ADD CONSTRAINT pk_stage_transition_digraph PRIMARY KEY (species_record_stage_from_id, species_record_stage_to_id);
ALTER TABLE ONLY taxon_author_connector ADD CONSTRAINT pk_taxon_author_connector PRIMARY KEY (taxon_author_connector_id);
ALTER TABLE ONLY taxon_author ADD CONSTRAINT pk_taxon_cate_author_sequence PRIMARY KEY (taxon_id, category, taxon_author_sequence);
ALTER TABLE ONLY taxon_category ADD CONSTRAINT pk_taxon_category_id PRIMARY KEY (taxon_category_id);
ALTER TABLE ONLY taxon_description_category ADD CONSTRAINT pk_taxon_description_category PRIMARY KEY (taxon_description_category_id);
ALTER TABLE ONLY taxon_description_datatype ADD CONSTRAINT pk_taxon_description_datatype PRIMARY KEY (taxon_description_datatype_id);
ALTER TABLE ONLY taxon_description_element ADD CONSTRAINT pk_taxon_description_type_id PRIMARY KEY (taxon_description_element_id);
ALTER TABLE ONLY taxon ADD CONSTRAINT pk_taxon_id PRIMARY KEY (taxon_id);
ALTER TABLE ONLY taxonomical_range ADD CONSTRAINT pk_taxonomical_node_id PRIMARY KEY (taxonomical_range_id);
ALTER TABLE ONLY taxonomical_hierarchy ADD CONSTRAINT pk_taxorangnod_pretaxorangnod PRIMARY KEY (taxonomical_range_id, ancestor_taxonomical_id);
ALTER TABLE ONLY preparation_method ADD CONSTRAINT preparation_method_pk PRIMARY KEY (preparation_method_id);
ALTER TABLE ONLY preservation_medium ADD CONSTRAINT preservation_medium_pk PRIMARY KEY (preservation_medium_id);
ALTER TABLE ONLY project ADD CONSTRAINT project_pk PRIMARY KEY (project_id);
ALTER TABLE ONLY projection ADD CONSTRAINT projection_pk PRIMARY KEY (projection_id);
ALTER TABLE ONLY protected_area ADD CONSTRAINT protected_area_pk PRIMARY KEY (protected_area_id);
ALTER TABLE ONLY protected_area_type ADD CONSTRAINT protected_area_type_pk PRIMARY KEY (protected_area_type_id);
ALTER TABLE ONLY protocol_attribute ADD CONSTRAINT protocol_attribute_pk PRIMARY KEY (protocol_attribute_id);
ALTER TABLE ONLY province ADD CONSTRAINT province_pk PRIMARY KEY (province_id);
ALTER TABLE ONLY reference_element_value ADD CONSTRAINT reference_element_value_pk PRIMARY KEY (reference_id, reference_element_id);
ALTER TABLE ONLY reference ADD CONSTRAINT reference_pk PRIMARY KEY (reference_id);
ALTER TABLE ONLY reference_type ADD CONSTRAINT reference_type_pk PRIMARY KEY (reference_type_id);
ALTER TABLE ONLY sampling_type ADD CONSTRAINT sampling_type_pk PRIMARY KEY (sampling_type_id);
ALTER TABLE ONLY sex ADD CONSTRAINT sex_pk PRIMARY KEY (sex_id);
ALTER TABLE ONLY site_calculation_method ADD CONSTRAINT site_calculation_method_pk PRIMARY KEY (site_calculation_method_id);
ALTER TABLE ONLY site_coordinate ADD CONSTRAINT site_coordinates_pk PRIMARY KEY (site_coordinate_id);
ALTER TABLE ONLY site ADD CONSTRAINT site_pk PRIMARY KEY (site_id);
ALTER TABLE ONLY taxon_description_institution ADD CONSTRAINT species_record_institution_pk PRIMARY KEY (taxon_id, taxon_description_sequence, institution_id);
ALTER TABLE ONLY taxon_description_person_profile ADD CONSTRAINT species_record_person_profile_pk PRIMARY KEY (taxon_id, taxon_description_sequence, person_id, profile_id);
ALTER TABLE ONLY specimen_annotation ADD CONSTRAINT specimen_annotation_pk PRIMARY KEY (specimen_id, annotation_id);
ALTER TABLE ONLY specimen_category ADD CONSTRAINT specimen_category_pk PRIMARY KEY (specimen_category_id);
ALTER TABLE ONLY specimen_life_form ADD CONSTRAINT specimen_life_form_pk PRIMARY KEY (specimen_id, life_form_id);
ALTER TABLE ONLY specimen_life_stage_sex ADD CONSTRAINT specimen_life_stage_sex_pk PRIMARY KEY (specimen_id, life_stage_id, sex_id);
ALTER TABLE ONLY specimen ADD CONSTRAINT specimen_pk2 PRIMARY KEY (specimen_id);
ALTER TABLE ONLY specimen_type ADD CONSTRAINT specimen_type_pk PRIMARY KEY (specimen_type_id);
ALTER TABLE ONLY specimen_variable ADD CONSTRAINT specimen_variable_pk PRIMARY KEY (specimen_variable_id);
ALTER TABLE ONLY specimen_variable_value ADD CONSTRAINT specimen_variable_value_id PRIMARY KEY (specimen_variable_value_id);
ALTER TABLE ONLY stage_transition_date ADD CONSTRAINT stage_transition_date_pk PRIMARY KEY (taxon_id, taxon_description_sequence, taxon_description_stage_id, transition_date);
ALTER TABLE ONLY storage_type ADD CONSTRAINT storage_type_pk PRIMARY KEY (storage_type_id);
ALTER TABLE ONLY substrate ADD CONSTRAINT substrate_pk PRIMARY KEY (substrate_id);
ALTER TABLE ONLY system_module ADD CONSTRAINT system_module_pk PRIMARY KEY (module_id);
ALTER TABLE ONLY system_option_type ADD CONSTRAINT system_option_type_pk PRIMARY KEY (system_option_type_id);
ALTER TABLE ONLY system_subsystem ADD CONSTRAINT system_subsystem_pk PRIMARY KEY (subsystem_id);
ALTER TABLE ONLY system_user ADD CONSTRAINT system_user_pk PRIMARY KEY (user_id);
ALTER TABLE ONLY system_user_type ADD CONSTRAINT system_user_type_pk PRIMARY KEY (user_type_id);
ALTER TABLE ONLY taxon_description_audience ADD CONSTRAINT taxon_description_audience_pk PRIMARY KEY (taxon_id, taxon_description_sequence, audience_id);
ALTER TABLE ONLY taxon_description ADD CONSTRAINT taxon_description_pk PRIMARY KEY (taxon_description_sequence, taxon_id);
ALTER TABLE ONLY taxon_description_record ADD CONSTRAINT taxon_description_record_id_pk PRIMARY KEY (taxon_description_record_id);
ALTER TABLE ONLY taxon_description_record_reference ADD CONSTRAINT taxon_description_record_reference_pk PRIMARY KEY (taxon_description_record_id, reference_id);
ALTER TABLE ONLY taxon_name_history ADD CONSTRAINT taxon_name_history_pk PRIMARY KEY (taxon_id, initial_timestamp, final_timestamp);
ALTER TABLE ONLY taxon_nomenclatural_group ADD CONSTRAINT taxon_nomenclatural_group_pk PRIMARY KEY (taxon_id, nomenclatural_group_id);
ALTER TABLE ONLY taxon_reference ADD CONSTRAINT taxon_reference_pk PRIMARY KEY (taxon_id, reference_id);
ALTER TABLE ONLY topographic_sheet ADD CONSTRAINT topographic_sheet_pk PRIMARY KEY (topographic_sheet_id);
ALTER TABLE ONLY transacted_specimen ADD CONSTRAINT transacted_specimen_pk PRIMARY KEY (transaction_id, specimen_id);
ALTER TABLE ONLY transacted_specimen_status ADD CONSTRAINT transacted_specimen_status_pk PRIMARY KEY (transacted_specimen_status_id);
ALTER TABLE ONLY "transaction" ADD CONSTRAINT transaction_pk PRIMARY KEY (transaction_id);
ALTER TABLE ONLY transaction_type ADD CONSTRAINT transaction_type_pk PRIMARY KEY (transaction_type_id);
ALTER TABLE ONLY type_specimen ADD CONSTRAINT type_specimen_pk PRIMARY KEY (type_specimen_id);
ALTER TABLE ONLY type_specimen_type ADD CONSTRAINT type_specimen_type_pk PRIMARY KEY (type_specimen_type_id);
ALTER TABLE ONLY user_nomenclatural_group ADD CONSTRAINT user_nomenclatural_group_pk PRIMARY KEY (nomenclatural_group_id, user_id, "sequence");
ALTER TABLE ONLY user_taxon ADD CONSTRAINT user_taxon_pk PRIMARY KEY (taxon_id, user_id, "sequence");
ALTER TABLE ONLY versant ADD CONSTRAINT versant_pk PRIMARY KEY (versant_id);
ALTER TABLE ONLY system_option ADD CONSTRAINT "SYSTEM_MODULE_OPTION_FK" FOREIGN KEY (module_id) REFERENCES system_module(module_id);
ALTER TABLE ONLY annotation ADD CONSTRAINT annotation_person_profile FOREIGN KEY (annotator_person_id, annotator_profile_id) REFERENCES person_profile(person_id, profile_id);
ALTER TABLE ONLY site ADD CONSTRAINT base_projection_fk FOREIGN KEY (base_projection_id) REFERENCES projection(projection_id);
ALTER TABLE ONLY canton_ifam ADD CONSTRAINT canton_ifam_province FOREIGN KEY (province_id) REFERENCES province(province_id);
ALTER TABLE ONLY canton ADD CONSTRAINT canton_province FOREIGN KEY (province_id) REFERENCES province(province_id);
ALTER TABLE ONLY list_table_collection ADD CONSTRAINT collection_fk FOREIGN KEY (collection_id) REFERENCES collection(collection_id);
ALTER TABLE ONLY collection_protocol ADD CONSTRAINT collection_protocol_collection_pk FOREIGN KEY (collection_id) REFERENCES collection(collection_id);
ALTER TABLE ONLY collection_protocol ADD CONSTRAINT collection_protocol_protocol_attribute_fk FOREIGN KEY (protocol_attribute_id) REFERENCES protocol_attribute(protocol_attribute_id);
ALTER TABLE ONLY collector_observer ADD CONSTRAINT collector_observer_person_fk FOREIGN KEY (collector_person_id) REFERENCES person(person_id);
ALTER TABLE ONLY component ADD CONSTRAINT component_part_fk FOREIGN KEY (component_part_id) REFERENCES component_part(component_part_id);
ALTER TABLE ONLY component ADD CONSTRAINT component_preparation_method_fk FOREIGN KEY (preparation_method_id) REFERENCES preparation_method(preparation_method_id);
ALTER TABLE ONLY component ADD CONSTRAINT component_specimen_fk FOREIGN KEY (specimen_id) REFERENCES specimen(specimen_id);
ALTER TABLE ONLY culture ADD CONSTRAINT culture_medium_fk FOREIGN KEY (culture_medium_id) REFERENCES culture_medium(culture_medium_id);
ALTER TABLE ONLY culture ADD CONSTRAINT culture_responsible_person_profile FOREIGN KEY (responsible_person_id, responsible_profile_id) REFERENCES person_profile(person_id, profile_id);
ALTER TABLE ONLY culture ADD CONSTRAINT culture_storage_medium_fk FOREIGN KEY (culture_storage_medium_id) REFERENCES culture_storage_medium(culture_storage_medium_id);
ALTER TABLE ONLY district ADD CONSTRAINT district_canton_fk FOREIGN KEY (canton_id) REFERENCES canton(canton_id);
ALTER TABLE ONLY ecological_variable_value ADD CONSTRAINT ecological_variable_fk FOREIGN KEY (ecological_variable_id) REFERENCES ecological_variable(ecological_variable_id);
ALTER TABLE ONLY gathering_observation_ecological_var ADD CONSTRAINT ecological_variable_value_fk FOREIGN KEY (ecological_variable_value_id) REFERENCES ecological_variable_value(ecological_variable_value_id);
ALTER TABLE ONLY gathering_observation ADD CONSTRAINT exposition_fk FOREIGN KEY (exposition_id) REFERENCES exposition(exposition_id);
ALTER TABLE ONLY site ADD CONSTRAINT feature_type_fk FOREIGN KEY (feature_type_id) REFERENCES feature_type(feature_type_id);
ALTER TABLE ONLY taxon_author ADD CONSTRAINT fk132_taxon_author_connector FOREIGN KEY (taxon_author_connector_id) REFERENCES taxon_author_connector(taxon_author_connector_id);
ALTER TABLE ONLY taxon ADD CONSTRAINT fk67_ancestor_id FOREIGN KEY (ancestor_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY taxon ADD CONSTRAINT fk67_class_taxon_id FOREIGN KEY (class_taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY taxon ADD CONSTRAINT fk67_collection_id FOREIGN KEY (collection_id) REFERENCES collection(collection_id);
ALTER TABLE ONLY taxon ADD CONSTRAINT fk67_dominium_taxon_id FOREIGN KEY (dominium_taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY taxon ADD CONSTRAINT fk67_family_taxon_id FOREIGN KEY (family_taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY taxon ADD CONSTRAINT fk67_genus_taxon_id FOREIGN KEY (genus_taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY taxon ADD CONSTRAINT fk67_kingdom_taxon_id FOREIGN KEY (kingdom_taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY taxon ADD CONSTRAINT fk67_order_taxon_id FOREIGN KEY (order_taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY taxon ADD CONSTRAINT fk67_phylum_division_taxon_id FOREIGN KEY (phylum_division_taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY taxon ADD CONSTRAINT fk67_section_taxon_id FOREIGN KEY (section_taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY taxon ADD CONSTRAINT fk67_species_taxon_id FOREIGN KEY (species_taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY taxon ADD CONSTRAINT fk67_stirps_taxon_id FOREIGN KEY (stirps_taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY taxon ADD CONSTRAINT fk67_subclass_taxon_id FOREIGN KEY (subclass_taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY taxon ADD CONSTRAINT fk67_subfamily_taxon_id FOREIGN KEY (subfamily_taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY taxon ADD CONSTRAINT fk67_subgenus_taxon_id FOREIGN KEY (subgenus_taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY taxon ADD CONSTRAINT fk67_suborder_taxon_id FOREIGN KEY (suborder_taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY taxon ADD CONSTRAINT fk67_subphylum_subdiv_taxon_id FOREIGN KEY (subphylum_subdivision_taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY taxon ADD CONSTRAINT fk67_subsection_taxon_id FOREIGN KEY (subsection_taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY taxon ADD CONSTRAINT fk67_subspecies_taxon_id FOREIGN KEY (subspecies_taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY taxon ADD CONSTRAINT fk67_subtribe_taxon_id FOREIGN KEY (subtribe_taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY taxon ADD CONSTRAINT fk67_superfamily_taxon_id FOREIGN KEY (superfamily_taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY taxon ADD CONSTRAINT fk67_synonym_taxon_id FOREIGN KEY (synonym_taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY taxon ADD CONSTRAINT fk67_taxon_category_id FOREIGN KEY (taxon_category_id) REFERENCES taxon_category(taxon_category_id);
ALTER TABLE ONLY taxon ADD CONSTRAINT fk67_taxonomical_range_id FOREIGN KEY (taxonomical_range_id) REFERENCES taxonomical_range(taxonomical_range_id);
ALTER TABLE ONLY taxon ADD CONSTRAINT fk67_tribe_taxon_id FOREIGN KEY (tribe_taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY taxon ADD CONSTRAINT fk67_variety_taxon_id FOREIGN KEY (variety_taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY taxonomical_hierarchy ADD CONSTRAINT fk70_prede_range_id FOREIGN KEY (ancestor_taxonomical_id) REFERENCES taxonomical_range(taxonomical_range_id);
ALTER TABLE ONLY taxonomical_hierarchy ADD CONSTRAINT fk70_taxonomical_range_id FOREIGN KEY (taxonomical_range_id) REFERENCES taxonomical_range(taxonomical_range_id);
ALTER TABLE ONLY taxon_author ADD CONSTRAINT fk74_taxon_id FOREIGN KEY (taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY taxon_description_element ADD CONSTRAINT fk76_taxon_desc_category FOREIGN KEY (taxon_description_category_id) REFERENCES taxon_description_category(taxon_description_category_id);
ALTER TABLE ONLY person_institution ADD CONSTRAINT fk7_institution_id FOREIGN KEY (institution_id) REFERENCES institution(institution_id);ALTER TABLE ONLY person_profile ADD CONSTRAINT fk7_person_id FOREIGN KEY (person_id) REFERENCES person(person_id);
ALTER TABLE ONLY person_institution ADD CONSTRAINT fk7_person_id FOREIGN KEY (person_id) REFERENCES person(person_id);
ALTER TABLE ONLY person_profile ADD CONSTRAINT fk7_profile_id FOREIGN KEY (profile_id) REFERENCES profile(profile_id);
ALTER TABLE ONLY person_profile_taxon ADD CONSTRAINT fk8_person_id FOREIGN KEY (person_id) REFERENCES person(person_id);
ALTER TABLE ONLY person_profile_taxon ADD CONSTRAINT fk8_person_profile FOREIGN KEY (person_id, profile_id) REFERENCES person_profile(person_id, profile_id);
ALTER TABLE ONLY person_profile_taxon ADD CONSTRAINT fk8_profile_id FOREIGN KEY (profile_id) REFERENCES profile(profile_id);
ALTER TABLE ONLY "language" ADD CONSTRAINT fk_language_reference_concept FOREIGN KEY (concept_id) REFERENCES concept(concept_id);
ALTER TABLE ONLY person_profile_taxon ADD CONSTRAINT fk_person_p_fk8_taxon_taxon FOREIGN KEY (taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY taxon_author ADD CONSTRAINT fk_person_profile_id FOREIGN KEY (taxon_author_person_id, taxon_author_person_profile_id) REFERENCES person_profile(person_id, profile_id);
ALTER TABLE ONLY species_record_stage_profile ADD CONSTRAINT fk_species__ref_72892_species_ FOREIGN KEY (species_record_stage_id) REFERENCES taxon_description_stage(taxon_description_stage_id);
ALTER TABLE ONLY species_record_stage_profile ADD CONSTRAINT fk_species__ref_72896_profile FOREIGN KEY (profile_id) REFERENCES profile(profile_id);
ALTER TABLE ONLY stage_transition_digraph ADD CONSTRAINT fk_stage_tr_ref_65607_species_ FOREIGN KEY (species_record_stage_from_id) REFERENCES taxon_description_stage(taxon_description_stage_id);
ALTER TABLE ONLY stage_transition_digraph ADD CONSTRAINT fk_stage_tr_ref_65613_species_ FOREIGN KEY (species_record_stage_to_id) REFERENCES taxon_description_stage(taxon_description_stage_id);
ALTER TABLE ONLY taxon_description_element ADD CONSTRAINT fk_taxon_de_reference_taxon_aa FOREIGN KEY (taxon_description_datatype_id) REFERENCES taxon_description_datatype(taxon_description_datatype_id);
ALTER TABLE ONLY taxon ADD CONSTRAINT fk_taxon_fk76_taxo_country FOREIGN KEY (country_id) REFERENCES country(country_id);
ALTER TABLE ONLY gathering_observation_collection ADD CONSTRAINT gathering_collection_collection_fk FOREIGN KEY (collection_id) REFERENCES collection(collection_id);
ALTER TABLE ONLY gathering_observation ADD CONSTRAINT gathering_collection_fk FOREIGN KEY (collection_id) REFERENCES collection(collection_id);
ALTER TABLE ONLY gathering_observation_collection ADD CONSTRAINT gathering_collection_gathering_fk FOREIGN KEY (gathering_observation_id) REFERENCES gathering_observation(gathering_observation_id);
ALTER TABLE ONLY collector_observer ADD CONSTRAINT gathering_collector_fk FOREIGN KEY (gathering_observation_id) REFERENCES gathering_observation(gathering_observation_id);
ALTER TABLE ONLY gathering_observation_detail ADD CONSTRAINT gathering_detail_collection_fk FOREIGN KEY (collection_id) REFERENCES collection(collection_id);
ALTER TABLE ONLY gathering_observation_detail ADD CONSTRAINT gathering_detail_gathering_fk FOREIGN KEY (gathering_observation_id) REFERENCES gathering_observation(gathering_observation_id);
ALTER TABLE ONLY gathering_observation_detail ADD CONSTRAINT gathering_detail_label FOREIGN KEY (label_id) REFERENCES label(label_id);
ALTER TABLE ONLY gathering_observation_detail ADD CONSTRAINT gathering_detail_morphological_description FOREIGN KEY (morphological_description_id) REFERENCES morphological_description(morphological_description_id);
ALTER TABLE ONLY gathering_observation_detail ADD CONSTRAINT gathering_detail_original_label_fk FOREIGN KEY (original_label_id) REFERENCES original_label(original_label_id);
ALTER TABLE ONLY gathering_observation ADD CONSTRAINT gathering_label_fk FOREIGN KEY (label_id) REFERENCES label(label_id);
ALTER TABLE ONLY gathering_observation_project ADD CONSTRAINT gathering_observation_fk FOREIGN KEY (gathering_observation_id) REFERENCES gathering_observation(gathering_observation_id);
ALTER TABLE ONLY gathering_observation_ecological_var ADD CONSTRAINT gathering_observation_fk FOREIGN KEY (gathering_observation_id) REFERENCES gathering_observation(gathering_observation_id);
ALTER TABLE ONLY specimen ADD CONSTRAINT gathering_observation_method_fk2 FOREIGN KEY (gathering_observation_method_id) REFERENCES gathering_observation_method(gathering_observation_method_id);
ALTER TABLE ONLY specimen ADD CONSTRAINT fk2_institution_id FOREIGN KEY (institution_id) REFERENCES institution(institution_id);
ALTER TABLE ONLY gathering_observation ADD CONSTRAINT gathering_original_label_fk FOREIGN KEY (original_label_id) REFERENCES original_label(original_label_id);
ALTER TABLE ONLY gathering_observation ADD CONSTRAINT gathering_responsible_person_fk FOREIGN KEY (responsible_person_id) REFERENCES person(person_id);
ALTER TABLE ONLY gathering_observation ADD CONSTRAINT gathering_sampling_type_fk FOREIGN KEY (sampling_type_id) REFERENCES sampling_type(sampling_type_id);
ALTER TABLE ONLY gathering_observation ADD CONSTRAINT gathering_site_fk FOREIGN KEY (site_id) REFERENCES site(site_id);
ALTER TABLE ONLY georeferenced_site ADD CONSTRAINT geographic_layer_fk FOREIGN KEY (geographic_layer_id) REFERENCES geographic_layer(geographic_layer_id);
ALTER TABLE ONLY identification ADD CONSTRAINT identification_person_fk FOREIGN KEY (valuer_person_id) REFERENCES person(person_id);
ALTER TABLE ONLY identification ADD CONSTRAINT identification_specimen_fk FOREIGN KEY (specimen_id) REFERENCES specimen(specimen_id);
ALTER TABLE ONLY identification ADD CONSTRAINT identification_status_fk FOREIGN KEY (identification_status_id) REFERENCES identification_status(identification_status_id);
ALTER TABLE ONLY identification ADD CONSTRAINT identification_taxon_fk FOREIGN KEY (taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY identification ADD CONSTRAINT identification_type_fk FOREIGN KEY (identification_type_id) REFERENCES identification_type(identification_type_id);
ALTER TABLE ONLY identifier ADD CONSTRAINT identifier_identification_fk FOREIGN KEY (specimen_id, identification_sequence, initial_timestamp) REFERENCES identification(specimen_id, identification_sequence, initial_timestamp);
ALTER TABLE ONLY identifier ADD CONSTRAINT identifier_person_fk FOREIGN KEY (identifier_person_id) REFERENCES person(person_id);
ALTER TABLE ONLY inmediate_predecessor_history ADD CONSTRAINT inmediate_predecessor_history_predecessor_taxon_fk FOREIGN KEY (predecessor_taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY inmediate_predecessor_history ADD CONSTRAINT inmediate_predecessor_history_taxon_fk FOREIGN KEY (taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY inmediate_predecessor_history ADD CONSTRAINT inmediate_predecessor_history_taxonomical_range_fk FOREIGN KEY (taxon_taxonomical_range_id) REFERENCES taxonomical_range(taxonomical_range_id);
ALTER TABLE ONLY specimen_life_form ADD CONSTRAINT life_form_fk FOREIGN KEY (life_form_id) REFERENCES life_form(life_form_id);
ALTER TABLE ONLY specimen_life_stage_sex ADD CONSTRAINT life_stage_fk FOREIGN KEY (life_stage_id) REFERENCES life_stage(life_stage_id);
ALTER TABLE ONLY list_table_collection ADD CONSTRAINT list_table_fk FOREIGN KEY (list_table_id) REFERENCES list_table(list_table_id);
ALTER TABLE ONLY morphological_description ADD CONSTRAINT morphological_description_person_fk FOREIGN KEY (description_person_id) REFERENCES person(person_id);
ALTER TABLE ONLY collecting_area ADD CONSTRAINT natural_region_fk FOREIGN KEY (natural_region_id) REFERENCES natural_region(natural_region_id);
ALTER TABLE ONLY nomenclatural_group ADD CONSTRAINT nomenclatural_group_person_fk FOREIGN KEY (certificator_person_id) REFERENCES person(person_id);
ALTER TABLE ONLY nomenclatural_group_region ADD CONSTRAINT nomenclatural_group_region_nomenclatural_group_fk FOREIGN KEY (nomenclatural_group_id) REFERENCES nomenclatural_group(nomenclatural_group_id);
ALTER TABLE ONLY nomenclatural_group_region ADD CONSTRAINT nomenclatural_group_region_taxon_fk FOREIGN KEY (region_id) REFERENCES region(region_id);
ALTER TABLE ONLY system_option ADD CONSTRAINT option_option_type_fk FOREIGN KEY (type_id) REFERENCES system_option_type(system_option_type_id);
ALTER TABLE ONLY site ADD CONSTRAINT original_projection_fk FOREIGN KEY (original_projection_id) REFERENCES projection(projection_id);
ALTER TABLE ONLY gathering_observation_project ADD CONSTRAINT project_fk FOREIGN KEY (project_id) REFERENCES project(project_id);
ALTER TABLE ONLY protected_area ADD CONSTRAINT protected_area_type_fk FOREIGN KEY (protected_area_type_id) REFERENCES protected_area_type(protected_area_type_id);
ALTER TABLE ONLY province ADD CONSTRAINT province_country FOREIGN KEY (country_id) REFERENCES country(country_id);
ALTER TABLE ONLY reference_element_value ADD CONSTRAINT reference_element_value_reference_element_fk FOREIGN KEY (reference_element_id) REFERENCES reference_element(reference_element_id);
ALTER TABLE ONLY reference_element_value ADD CONSTRAINT reference_element_value_reference_fk FOREIGN KEY (reference_id) REFERENCES reference(reference_id);
ALTER TABLE ONLY reference ADD CONSTRAINT reference_language FOREIGN KEY (language_id) REFERENCES "language"(language_id);
ALTER TABLE ONLY reference ADD CONSTRAINT reference_type_fk FOREIGN KEY (reference_type_id) REFERENCES reference_type(reference_type_id);
ALTER TABLE ONLY specimen_life_stage_sex ADD CONSTRAINT sex_fk FOREIGN KEY (sex_id) REFERENCES sex(sex_id);
ALTER TABLE ONLY site ADD CONSTRAINT site_calculation_method_fk FOREIGN KEY (site_calculation_method_id) REFERENCES site_calculation_method(site_calculation_method_id);
ALTER TABLE ONLY site_coordinate ADD CONSTRAINT site_coordinate_site FOREIGN KEY (site_id) REFERENCES site(site_id);
ALTER TABLE ONLY georeferenced_site ADD CONSTRAINT site_fk FOREIGN KEY (site_id) REFERENCES site(site_id);
ALTER TABLE ONLY specimen_annotation ADD CONSTRAINT specimen_annotation_annotation_fk FOREIGN KEY (annotation_id) REFERENCES annotation(annotation_id);
ALTER TABLE ONLY specimen_annotation ADD CONSTRAINT specimen_annotation_specimen_fk FOREIGN KEY (specimen_id) REFERENCES specimen(specimen_id);
ALTER TABLE ONLY specimen ADD CONSTRAINT specimen_category_fk2 FOREIGN KEY (specimen_category_id) REFERENCES specimen_category(specimen_category_id);
ALTER TABLE ONLY specimen ADD CONSTRAINT specimen_collection_fk3 FOREIGN KEY (collection_id) REFERENCES collection(collection_id);
ALTER TABLE ONLY specimen ADD CONSTRAINT specimen_extraction_type_fk2 FOREIGN KEY (extraction_type_id) REFERENCES extraction_type(extraction_type_id);
ALTER TABLE ONLY specimen_description ADD CONSTRAINT specimen_fk FOREIGN KEY (specimen_id) REFERENCES specimen(specimen_id);
ALTER TABLE ONLY specimen ADD CONSTRAINT specimen_gathering_fk2 FOREIGN KEY (gathering_observation_id) REFERENCES gathering_observation(gathering_observation_id);
ALTER TABLE ONLY specimen ADD CONSTRAINT specimen_gathering_observation_detail_fk2 FOREIGN KEY (gathering_observation_detail_id) REFERENCES gathering_observation_detail(gathering_observation_detail_id);
ALTER TABLE ONLY specimen_life_form ADD CONSTRAINT specimen_life_form_fk FOREIGN KEY (specimen_id) REFERENCES specimen(specimen_id);
ALTER TABLE ONLY specimen ADD CONSTRAINT specimen_life_stage_fk2 FOREIGN KEY (life_stage_id) REFERENCES life_stage(life_stage_id);
ALTER TABLE ONLY specimen_life_stage_sex ADD CONSTRAINT specimen_life_stage_sex_fk FOREIGN KEY (specimen_id) REFERENCES specimen(specimen_id);
ALTER TABLE ONLY specimen ADD CONSTRAINT specimen_morphological_description_fk2 FOREIGN KEY (morphological_description_id) REFERENCES morphological_description(morphological_description_id);
ALTER TABLE ONLY specimen ADD CONSTRAINT specimen_origin_fk2 FOREIGN KEY (origin_id) REFERENCES origin(origin_id);
ALTER TABLE ONLY specimen ADD CONSTRAINT specimen_preservation_medium_fk2 FOREIGN KEY (preservation_medium_id) REFERENCES preservation_medium(preservation_medium_id);
ALTER TABLE ONLY specimen ADD CONSTRAINT specimen_sex_fk2 FOREIGN KEY (sex_id) REFERENCES sex(sex_id);
ALTER TABLE ONLY specimen ADD CONSTRAINT specimen_storage_type_fk2 FOREIGN KEY (storage_type_id) REFERENCES storage_type(storage_type_id);
ALTER TABLE ONLY specimen ADD CONSTRAINT specimen_substrate_fk2 FOREIGN KEY (substrate_id) REFERENCES substrate(substrate_id);
ALTER TABLE ONLY specimen ADD CONSTRAINT specimen_type_fk2 FOREIGN KEY (specimen_type_id) REFERENCES specimen_type(specimen_type_id);
ALTER TABLE ONLY specimen_variable_value ADD CONSTRAINT specimen_variable_fk FOREIGN KEY (specimen_variable_id) REFERENCES specimen_variable(specimen_variable_id);
ALTER TABLE ONLY specimen_description ADD CONSTRAINT specimen_variable_fk FOREIGN KEY (specimen_variable_value_id) REFERENCES specimen_variable_value(specimen_variable_value_id);
ALTER TABLE ONLY stage_transition_date ADD CONSTRAINT stage_transition_date_taxon_description_stage_fk FOREIGN KEY (taxon_description_stage_id) REFERENCES taxon_description_stage(taxon_description_stage_id);
ALTER TABLE ONLY system_module ADD CONSTRAINT subsystem_module_fk FOREIGN KEY (subsystem_id) REFERENCES system_subsystem(subsystem_id) ON DELETE RESTRICT;
ALTER TABLE ONLY system_user_option ADD CONSTRAINT system_option_fk FOREIGN KEY (option_id) REFERENCES system_option(option_id);
ALTER TABLE ONLY system_user_option ADD CONSTRAINT system_user_fr FOREIGN KEY (user_id) REFERENCES system_user(user_id) ON DELETE CASCADE;
ALTER TABLE ONLY taxon_description_person_profile ADD CONSTRAINT taxon_description_person_profile_fk FOREIGN KEY (taxon_id, taxon_description_sequence) REFERENCES taxon_description(taxon_id, taxon_description_sequence);
ALTER TABLE ONLY taxon_description_record_reference ADD CONSTRAINT taxon_description_record_reference_reference_fk FOREIGN KEY (reference_id) REFERENCES reference(reference_id);
ALTER TABLE ONLY taxon_description_record_reference ADD CONSTRAINT taxon_description_record_reference_taxon_description_record_fk FOREIGN KEY (taxon_description_record_id) REFERENCES taxon_description_record(taxon_description_record_id);
ALTER TABLE ONLY taxon_description_record ADD CONSTRAINT taxon_description_record_taxon_description_element_fk FOREIGN KEY (taxon_description_element_id) REFERENCES taxon_description_element(taxon_description_element_id);
ALTER TABLE ONLY taxon_description_record ADD CONSTRAINT taxon_description_record_taxon_description_fk FOREIGN KEY (taxon_id, taxon_description_sequence) REFERENCES taxon_description(taxon_id, taxon_description_sequence);
ALTER TABLE ONLY taxon_description_institution ADD CONSTRAINT taxon_description_species_record_institution FOREIGN KEY (taxon_id, taxon_description_sequence) REFERENCES taxon_description(taxon_id, taxon_description_sequence);
ALTER TABLE ONLY taxon_description ADD CONSTRAINT taxon_description_stage_fk FOREIGN KEY (taxon_description_stage_id) REFERENCES taxon_description_stage(taxon_description_stage_id);
ALTER TABLE ONLY stage_transition_date ADD CONSTRAINT taxon_description_stage_transition_date_fk FOREIGN KEY (taxon_id, taxon_description_sequence) REFERENCES taxon_description(taxon_id, taxon_description_sequence);
ALTER TABLE ONLY taxon_description ADD CONSTRAINT taxon_description_taxon_fk FOREIGN KEY (taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY taxon_nomenclatural_group ADD CONSTRAINT taxon_nomenclatural_group_nomenclatural_group_fk FOREIGN KEY (nomenclatural_group_id) REFERENCES nomenclatural_group(nomenclatural_group_id);
ALTER TABLE ONLY taxon_nomenclatural_group ADD CONSTRAINT taxon_nomenclatural_group_taxon_fk FOREIGN KEY (taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY taxon_reference ADD CONSTRAINT taxon_reference_reference_fk FOREIGN KEY (reference_id) REFERENCES reference(reference_id);
ALTER TABLE ONLY taxon_reference ADD CONSTRAINT taxon_reference_taxon_fk FOREIGN KEY (taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY transacted_specimen ADD CONSTRAINT transacted_specimen_specimen_fk FOREIGN KEY (specimen_id) REFERENCES specimen(specimen_id);
ALTER TABLE ONLY transacted_specimen ADD CONSTRAINT transacted_specimen_status_fk FOREIGN KEY (transacted_specimen_status_id) REFERENCES transacted_specimen_status(transacted_specimen_status_id);
ALTER TABLE ONLY transacted_specimen ADD CONSTRAINT transacted_specimen_transaction_fk FOREIGN KEY (transaction_id) REFERENCES "transaction"(transaction_id);
ALTER TABLE ONLY transacted_specimen ADD CONSTRAINT transacted_specimen_type_fk FOREIGN KEY (transaction_type_id) REFERENCES transaction_type(transaction_type_id);
ALTER TABLE ONLY "transaction" ADD CONSTRAINT transaction_collection_fk FOREIGN KEY (collection_id) REFERENCES collection(collection_id);
ALTER TABLE ONLY "transaction" ADD CONSTRAINT transaction_receiver_institution_fk FOREIGN KEY (receiver_institution_id) REFERENCES institution(institution_id);
ALTER TABLE ONLY "transaction" ADD CONSTRAINT transaction_receiver_person_id FOREIGN KEY (receiver_person_id) REFERENCES person(person_id);
ALTER TABLE ONLY "transaction" ADD CONSTRAINT transaction_sender_institution_id FOREIGN KEY (sender_institution_id) REFERENCES institution(institution_id);
ALTER TABLE ONLY "transaction" ADD CONSTRAINT transaction_sender_person_fk FOREIGN KEY (sender_person_id) REFERENCES person(person_id);
ALTER TABLE ONLY "transaction" ADD CONSTRAINT transaction_type_fk FOREIGN KEY (transaction_type_id) REFERENCES transaction_type(transaction_type_id);
ALTER TABLE ONLY type_specimen ADD CONSTRAINT type_specimen_institution_fk FOREIGN KEY (institution_id) REFERENCES institution(institution_id);
ALTER TABLE ONLY type_specimen ADD CONSTRAINT type_specimen_specimen_fk FOREIGN KEY (specimen_id) REFERENCES specimen(specimen_id);
ALTER TABLE ONLY type_specimen ADD CONSTRAINT type_specimen_taxon_fk FOREIGN KEY (taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY type_specimen ADD CONSTRAINT type_specimen_type_fk FOREIGN KEY (type_specimen_type_id) REFERENCES type_specimen_type(type_specimen_type_id);
ALTER TABLE ONLY system_user ADD CONSTRAINT user_group_fk FOREIGN KEY (user_group_id) REFERENCES system_user(user_id);
ALTER TABLE ONLY user_nomenclatural_group ADD CONSTRAINT user_nomenclatural_group_fk FOREIGN KEY (nomenclatural_group_id) REFERENCES nomenclatural_group(nomenclatural_group_id);
ALTER TABLE ONLY user_nomenclatural_group ADD CONSTRAINT user_nomenclatural_group_user_fk FOREIGN KEY (user_id) REFERENCES system_user(user_id);
ALTER TABLE ONLY user_taxon ADD CONSTRAINT user_taxon_fk FOREIGN KEY (taxon_id) REFERENCES taxon(taxon_id);
ALTER TABLE ONLY user_taxon ADD CONSTRAINT user_taxon_user_fk FOREIGN KEY (user_id) REFERENCES system_user(user_id);
ALTER TABLE ONLY system_user ADD CONSTRAINT user_type_fk FOREIGN KEY (user_type_id) REFERENCES system_user_type(user_type_id);
ALTER TABLE ONLY natural_region ADD CONSTRAINT versant_fk FOREIGN KEY (versant_id) REFERENCES versant(versant_id);
ALTER TABLE ONLY taxon_description_person_profile ADD CONSTRAINT species_record_person_profile_fk FOREIGN KEY (person_id, profile_id) REFERENCES person_profile(person_id, profile_id);
CREATE INDEX fki_taxon_description_stage_transition_date_fk ON stage_transition_date (taxon_id, taxon_description_sequence);
CREATE INDEX idx_collector_gatobsidcolleidseq ON collector_observer (gathering_observation_id, collector_person_id, "sequence");
CREATE INDEX idx_collector_gatobsidseq ON collector_observer (gathering_observation_id, "sequence");
CREATE INDEX idx_gatheringobservation_resperid ON gathering_observation (responsible_person_id);
CREATE INDEX idx_gatheringobservation_origlabid ON gathering_observation (original_label_id);
CREATE INDEX idx_gatheringobservation_finaldate ON gathering_observation (final_date);
CREATE INDEX idx_gatheringobservation_gatidcolid ON gathering_observation (gathering_observation_id, collection_id);
CREATE UNIQUE INDEX idx_gatheringobservation_colidgatid ON gathering_observation (collection_id, gathering_observation_id);
CREATE INDEX idx_gatheringobservation_labid ON gathering_observation (label_id);
CREATE INDEX idx_gatheringobservation_sampltypeid ON gathering_observation (sampling_type_id );
CREATE INDEX idx_gatheringobservation_initdate ON gathering_observation (initial_date );
CREATE INDEX idx_gatheringobservation_colid ON gathering_observation (collection_id );
CREATE INDEX idx_gatheringobscoll_colid ON gathering_observation_collection (collection_id );
CREATE INDEX idx_gatheringobsdet_gatdetpersid ON gathering_observation_detail (gathering_observation_detail_person_id );
CREATE INDEX idx_gatheringobsdet_gatidcolid ON gathering_observation_detail (gathering_observation_id, collection_id);
CREATE INDEX idx_gatheringobsdet_orilabeid ON gathering_observation_detail (original_label_id);
CREATE INDEX idx_gatheringobsdet_labeid ON gathering_observation_detail (label_id );
CREATE INDEX idx_gatheringobsdet_gatobsid ON gathering_observation_detail (gathering_observation_id);
CREATE INDEX idx_gatheringobsdet_morphid ON gathering_observation_detail (morphological_description_id);
CREATE INDEX idx_gatheringobsdet_colidgatid ON gathering_observation_detail (collection_id, gathering_observation_id);
CREATE INDEX idx_identification_taxonid ON identification (taxon_id );
CREATE INDEX idx_identification_statusid ON identification (identification_status_id);
CREATE INDEX idx_identification_specid ON identification (specimen_id);
CREATE INDEX idx_protected_area_protareaypeid ON protected_area (protected_area_type_id );
CREATE INDEX idx_site_coordinate_longlat ON site_coordinate (longitude, latitude);
CREATE INDEX idx_specimen_gatobsid ON specimen (gathering_observation_id);
CREATE INDEX idx_specimen_colidgatobsid ON specimen (collection_id, gathering_observation_id);
CREATE INDEX idx_specimen_colidspecid ON specimen (collection_id, specimen_id);
CREATE INDEX idx_specimen_colid ON specimen (collection_id);
CREATE INDEX idx_specimen_disc ON specimen (discarded );
CREATE INDEX idx_specimen_speidcoliddisc ON specimen (specimen_id, collection_id, discarded );
CREATE INDEX idx_specimen_gathidcolid ON specimen (gathering_observation_id, collection_id );
CREATE INDEX idx_specimen_gathdetperidgathnum ON specimen (gathering_observation_id, collection_id );
CREATE INDEX idx_taxon_domtxid ON taxon(dominium_taxon_id);
CREATE INDEX idx_taxon_kimtxid ON taxon(kingdom_taxon_id);
CREATE INDEX idx_taxon_phydivtxid ON taxon(phylum_division_taxon_id );
CREATE INDEX idx_taxon_subphysubdivtxid ON taxon(subphylum_subdivision_taxon_id);
CREATE INDEX idx_taxon_clatxid ON taxon(class_taxon_id);
CREATE INDEX idx_taxon_subcltxid ON taxon(subclass_taxon_id);
CREATE INDEX idx_taxon_ordtxid ON taxon(order_taxon_id);
CREATE INDEX idx_taxon_subortaxid ON taxon(suborder_taxon_id );
CREATE INDEX idx_taxon_supfamtaxid ON taxon(superfamily_taxon_id);
CREATE INDEX idx_taxon_famtxid ON taxon(family_taxon_id);
CREATE INDEX idx_taxon_subfatxid ON taxon(subfamily_taxon_id );
CREATE INDEX idx_taxon_tritxid ON taxon(tribe_taxon_id);
CREATE INDEX idx_taxon_subtritxid ON taxon(subtribe_taxon_id);
CREATE INDEX idx_taxon_gentxid ON taxon(genus_taxon_id );
CREATE INDEX idx_taxon_subgetxid ON taxon(subgenus_taxon_id);
CREATE INDEX idx_taxon_sectxid ON taxon(section_taxon_id);
CREATE INDEX idx_taxon_subsectxid ON taxon(subsection_taxon_id );
CREATE INDEX idx_taxon_stirtxid ON taxon(stirps_taxon_id);
CREATE INDEX idx_taxon_spectxid ON taxon(species_taxon_id );
CREATE INDEX idx_taxon_subsptxid ON taxon(subspecies_taxon_id);
CREATE INDEX idx_taxon_ancestxid ON taxon(ancestor_id );
CREATE INDEX idx_taxon_defnam ON taxon(default_name);
CREATE INDEX idx_taxon_curnam ON taxon(current_name );
CREATE INDEX idx_taxon_taxrangid ON taxon(taxonomical_range_id);
CREATE INDEX idx_taxon_taxcatid ON taxon(taxon_category_id);
CREATE INDEX idx_taxon_syntxid ON taxon(synonym_taxon_id);
CREATE INDEX idx_taxonnomegroup_nomgrpseq ON taxon_nomenclatural_group (nomenclatural_group_id,"sequence");
REVOKE ALL ON SCHEMA ara FROM PUBLIC;
REVOKE ALL ON SCHEMA ara FROM ara;
GRANT ALL ON SCHEMA ara TO ara;
GRANT ALL ON SCHEMA ara TO postgres;
REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
REVOKE ALL ON TABLE altitude_floor FROM PUBLIC;
REVOKE ALL ON TABLE altitude_floor FROM ara;
GRANT ALL ON TABLE altitude_floor TO ara;
GRANT ALL ON TABLE altitude_floor TO postgres;
REVOKE ALL ON TABLE DARWIN_CORE_1_4 FROM PUBLIC;
REVOKE ALL ON TABLE DARWIN_CORE_1_4 FROM ara;
GRANT ALL ON TABLE DARWIN_CORE_1_4 TO ara;
GRANT ALL ON TABLE DARWIN_CORE_1_4 TO postgres;
REVOKE ALL ON TABLE annotation FROM PUBLIC;
REVOKE ALL ON TABLE annotation FROM ara;
GRANT ALL ON TABLE annotation TO ara;
GRANT ALL ON TABLE annotation TO postgres;
REVOKE ALL ON TABLE audience FROM PUBLIC;
REVOKE ALL ON TABLE audience FROM ara;
GRANT ALL ON TABLE audience TO ara;
GRANT ALL ON TABLE audience TO postgres;
REVOKE ALL ON TABLE base_projection FROM PUBLIC;
REVOKE ALL ON TABLE base_projection FROM ara;
GRANT ALL ON TABLE base_projection TO ara;
GRANT ALL ON TABLE base_projection TO postgres;
REVOKE ALL ON TABLE biotic_unit FROM PUBLIC;
REVOKE ALL ON TABLE biotic_unit FROM ara;
GRANT ALL ON TABLE biotic_unit TO ara;
GRANT ALL ON TABLE biotic_unit TO PUBLIC;
REVOKE ALL ON TABLE canton FROM PUBLIC;
REVOKE ALL ON TABLE canton FROM ara;
GRANT ALL ON TABLE canton TO ara;
GRANT ALL ON TABLE canton TO PUBLIC;
REVOKE ALL ON TABLE canton_ifam FROM PUBLIC;
REVOKE ALL ON TABLE canton_ifam FROM ara;
GRANT ALL ON TABLE canton_ifam TO ara;
GRANT ALL ON TABLE canton_ifam TO PUBLIC;
REVOKE ALL ON TABLE collecting_area FROM PUBLIC;
REVOKE ALL ON TABLE collecting_area FROM ara;
GRANT ALL ON TABLE collecting_area TO ara;
GRANT ALL ON TABLE collecting_area TO PUBLIC;
REVOKE ALL ON TABLE collection FROM PUBLIC;
REVOKE ALL ON TABLE collection FROM ara;
GRANT ALL ON TABLE collection TO ara;
GRANT ALL ON TABLE collection TO postgres;
REVOKE ALL ON TABLE collection_protocol FROM PUBLIC;
REVOKE ALL ON TABLE collection_protocol FROM ara;
GRANT ALL ON TABLE collection_protocol TO ara;
GRANT ALL ON TABLE collection_protocol TO postgres;
REVOKE ALL ON TABLE collector_observer FROM PUBLIC;
REVOKE ALL ON TABLE collector_observer FROM ara;
GRANT ALL ON TABLE collector_observer TO ara;
GRANT ALL ON TABLE collector_observer TO PUBLIC;
REVOKE ALL ON TABLE component FROM PUBLIC;
REVOKE ALL ON TABLE component FROM ara;
GRANT ALL ON TABLE component TO ara;
GRANT ALL ON TABLE component TO postgres;
REVOKE ALL ON TABLE component_part FROM PUBLIC;
REVOKE ALL ON TABLE component_part FROM ara;
GRANT ALL ON TABLE component_part TO ara;
GRANT ALL ON TABLE component_part TO postgres;
REVOKE ALL ON TABLE concept FROM PUBLIC;
REVOKE ALL ON TABLE concept FROM ara;
GRANT ALL ON TABLE concept TO ara;
GRANT ALL ON TABLE concept TO postgres;
REVOKE ALL ON TABLE conservation_area FROM PUBLIC;
REVOKE ALL ON TABLE conservation_area FROM ara;
GRANT ALL ON TABLE conservation_area TO ara;
GRANT ALL ON TABLE conservation_area TO PUBLIC;
REVOKE ALL ON TABLE country FROM PUBLIC;
REVOKE ALL ON TABLE country FROM ara;
GRANT ALL ON TABLE country TO ara;
GRANT ALL ON TABLE country TO postgres;
REVOKE ALL ON TABLE culture FROM PUBLIC;
REVOKE ALL ON TABLE culture FROM ara;
GRANT ALL ON TABLE culture TO ara;
GRANT ALL ON TABLE culture TO postgres;
REVOKE ALL ON TABLE culture_medium FROM PUBLIC;
REVOKE ALL ON TABLE culture_medium FROM ara;
GRANT ALL ON TABLE culture_medium TO ara;
GRANT ALL ON TABLE culture_medium TO postgres;
REVOKE ALL ON TABLE culture_storage_medium FROM PUBLIC;
REVOKE ALL ON TABLE culture_storage_medium FROM ara;
GRANT ALL ON TABLE culture_storage_medium TO ara;
GRANT ALL ON TABLE culture_storage_medium TO postgres;
REVOKE ALL ON TABLE determination_type FROM PUBLIC;
REVOKE ALL ON TABLE determination_type FROM ara;
GRANT ALL ON TABLE determination_type TO ara;
GRANT ALL ON TABLE determination_type TO postgres;
REVOKE ALL ON TABLE district FROM PUBLIC;
REVOKE ALL ON TABLE district FROM ara;
GRANT ALL ON TABLE district TO ara;
GRANT ALL ON TABLE district TO PUBLIC;
REVOKE ALL ON TABLE ecological_region FROM PUBLIC;
REVOKE ALL ON TABLE ecological_region FROM ara;
GRANT ALL ON TABLE ecological_region TO ara;
GRANT ALL ON TABLE ecological_region TO PUBLIC;
REVOKE ALL ON TABLE ecological_variable FROM PUBLIC;
REVOKE ALL ON TABLE ecological_variable FROM ara;
GRANT ALL ON TABLE ecological_variable TO ara;
GRANT ALL ON TABLE ecological_variable TO postgres;
REVOKE ALL ON TABLE ecological_variable_value FROM PUBLIC;
REVOKE ALL ON TABLE ecological_variable_value FROM ara;
GRANT ALL ON TABLE ecological_variable_value TO ara;
GRANT ALL ON TABLE ecological_variable_value TO postgres;
REVOKE ALL ON TABLE ecosystem FROM PUBLIC;
REVOKE ALL ON TABLE ecosystem FROM ara;
GRANT ALL ON TABLE ecosystem TO ara;
GRANT ALL ON TABLE ecosystem TO PUBLIC;
REVOKE ALL ON TABLE elevation_band FROM PUBLIC;
REVOKE ALL ON TABLE elevation_band FROM ara;
GRANT ALL ON TABLE elevation_band TO ara;
GRANT ALL ON TABLE elevation_band TO PUBLIC;
REVOKE ALL ON TABLE exposition FROM PUBLIC;
REVOKE ALL ON TABLE exposition FROM ara;
GRANT ALL ON TABLE exposition TO ara;
GRANT ALL ON TABLE exposition TO postgres;
REVOKE ALL ON TABLE extraction_type FROM PUBLIC;
REVOKE ALL ON TABLE extraction_type FROM ara;
GRANT ALL ON TABLE extraction_type TO ara;
GRANT ALL ON TABLE extraction_type TO postgres;
REVOKE ALL ON TABLE feature_type FROM PUBLIC;
REVOKE ALL ON TABLE feature_type FROM ara;
GRANT ALL ON TABLE feature_type TO ara;
GRANT ALL ON TABLE feature_type TO postgres;
REVOKE ALL ON TABLE gathering_observation FROM PUBLIC;
REVOKE ALL ON TABLE gathering_observation FROM ara;
GRANT ALL ON TABLE gathering_observation TO ara;
REVOKE ALL ON TABLE gathering_observation_collection FROM PUBLIC;
REVOKE ALL ON TABLE gathering_observation_collection FROM ara;
GRANT ALL ON TABLE gathering_observation_collection TO ara;
REVOKE ALL ON TABLE gathering_observation_detail FROM PUBLIC;
REVOKE ALL ON TABLE gathering_observation_detail FROM ara;
GRANT ALL ON TABLE gathering_observation_detail TO ara;
REVOKE ALL ON TABLE gathering_observation_ecological_var FROM PUBLIC;
REVOKE ALL ON TABLE gathering_observation_ecological_var FROM ara;
GRANT ALL ON TABLE gathering_observation_ecological_var TO ara;
GRANT ALL ON TABLE gathering_observation_ecological_var TO postgres;
REVOKE ALL ON TABLE gathering_observation_method FROM PUBLIC;
REVOKE ALL ON TABLE gathering_observation_method FROM ara;
GRANT ALL ON TABLE gathering_observation_method TO ara;
REVOKE ALL ON TABLE gathering_observation_project FROM PUBLIC;
REVOKE ALL ON TABLE gathering_observation_project FROM ara;
GRANT ALL ON TABLE gathering_observation_project TO ara;
GRANT ALL ON TABLE gathering_observation_project TO postgres;
REVOKE ALL ON TABLE geographic_catalogue FROM PUBLIC;
REVOKE ALL ON TABLE geographic_catalogue FROM ara;
GRANT ALL ON TABLE geographic_catalogue TO ara;
GRANT ALL ON TABLE geographic_catalogue TO postgres;
REVOKE ALL ON TABLE geographic_entity FROM PUBLIC;
REVOKE ALL ON TABLE geographic_entity FROM ara;
GRANT ALL ON TABLE geographic_entity TO ara;
GRANT ALL ON TABLE geographic_entity TO postgres;
REVOKE ALL ON TABLE geographic_layer FROM PUBLIC;
REVOKE ALL ON TABLE geographic_layer FROM ara;
GRANT ALL ON TABLE geographic_layer TO ara;
GRANT ALL ON TABLE geographic_layer TO PUBLIC;
REVOKE ALL ON TABLE georeferenced_site FROM PUBLIC;
REVOKE ALL ON TABLE georeferenced_site FROM ara;
GRANT ALL ON TABLE georeferenced_site TO ara;
GRANT ALL ON TABLE georeferenced_site TO PUBLIC;
REVOKE ALL ON TABLE id_gen FROM PUBLIC;
REVOKE ALL ON TABLE id_gen FROM ara;
GRANT ALL ON TABLE id_gen TO ara;
REVOKE ALL ON TABLE identification FROM PUBLIC;
REVOKE ALL ON TABLE identification FROM ara;
GRANT ALL ON TABLE identification TO ara;
GRANT ALL ON TABLE identification TO postgres;
REVOKE ALL ON TABLE identification_history FROM PUBLIC;
REVOKE ALL ON TABLE identification_history FROM ara;
GRANT ALL ON TABLE identification_history TO ara;
GRANT ALL ON TABLE identification_history TO postgres;
REVOKE ALL ON TABLE identification_status FROM PUBLIC;
REVOKE ALL ON TABLE identification_status FROM ara;
GRANT ALL ON TABLE identification_status TO ara;
GRANT ALL ON TABLE identification_status TO postgres;
REVOKE ALL ON TABLE identification_type FROM PUBLIC;
REVOKE ALL ON TABLE identification_type FROM ara;
GRANT ALL ON TABLE identification_type TO ara;
GRANT ALL ON TABLE identification_type TO postgres;
REVOKE ALL ON TABLE identifier FROM PUBLIC;
REVOKE ALL ON TABLE identifier FROM ara;
GRANT ALL ON TABLE identifier TO ara;
GRANT ALL ON TABLE identifier TO postgres;
REVOKE ALL ON TABLE identifier_history FROM PUBLIC;
REVOKE ALL ON TABLE identifier_history FROM ara;
GRANT ALL ON TABLE identifier_history TO ara;
GRANT ALL ON TABLE identifier_history TO postgres;
REVOKE ALL ON TABLE inmediate_predecessor_history FROM PUBLIC;
REVOKE ALL ON TABLE inmediate_predecessor_history FROM ara;
GRANT ALL ON TABLE inmediate_predecessor_history TO ara;
GRANT ALL ON TABLE inmediate_predecessor_history TO postgres;
REVOKE ALL ON TABLE institution FROM PUBLIC;
REVOKE ALL ON TABLE institution FROM ara;
GRANT ALL ON TABLE institution TO ara;
GRANT ALL ON TABLE institution TO postgres;
REVOKE ALL ON TABLE interaction_type FROM PUBLIC;
REVOKE ALL ON TABLE interaction_type FROM ara;
GRANT ALL ON TABLE interaction_type TO ara;
GRANT ALL ON TABLE interaction_type TO postgres;
REVOKE ALL ON TABLE label FROM PUBLIC;
REVOKE ALL ON TABLE label FROM ara;
GRANT ALL ON TABLE label TO ara;
GRANT ALL ON TABLE label TO postgres;
REVOKE ALL ON TABLE label_history FROM PUBLIC;
REVOKE ALL ON TABLE label_history FROM ara;
GRANT ALL ON TABLE label_history TO ara;
GRANT ALL ON TABLE label_history TO postgres;
REVOKE ALL ON TABLE land_cover FROM PUBLIC;
REVOKE ALL ON TABLE land_cover FROM ara;
GRANT ALL ON TABLE land_cover TO ara;
GRANT ALL ON TABLE land_cover TO PUBLIC;
REVOKE ALL ON TABLE "language" FROM PUBLIC;
REVOKE ALL ON TABLE "language" FROM ara;
GRANT ALL ON TABLE "language" TO ara;
GRANT ALL ON TABLE "language" TO postgres;
REVOKE ALL ON TABLE life_form FROM PUBLIC;
REVOKE ALL ON TABLE life_form FROM ara;
GRANT ALL ON TABLE life_form TO ara;
GRANT ALL ON TABLE life_form TO postgres;
REVOKE ALL ON TABLE life_stage FROM PUBLIC;
REVOKE ALL ON TABLE life_stage FROM ara;
GRANT ALL ON TABLE life_stage TO ara;
GRANT ALL ON TABLE life_stage TO postgres;
REVOKE ALL ON TABLE life_zone FROM PUBLIC;
REVOKE ALL ON TABLE life_zone FROM ara;
GRANT ALL ON TABLE life_zone TO ara;
GRANT ALL ON TABLE life_zone TO PUBLIC;
REVOKE ALL ON TABLE morphological_description FROM PUBLIC;
REVOKE ALL ON TABLE morphological_description FROM ara;
GRANT ALL ON TABLE morphological_description TO ara;
GRANT ALL ON TABLE morphological_description TO postgres;
REVOKE ALL ON TABLE natural_region FROM PUBLIC;
REVOKE ALL ON TABLE natural_region FROM ara;
GRANT ALL ON TABLE natural_region TO ara;
GRANT ALL ON TABLE natural_region TO PUBLIC;
REVOKE ALL ON TABLE nomenclatural_group FROM PUBLIC;
REVOKE ALL ON TABLE nomenclatural_group FROM ara;
GRANT ALL ON TABLE nomenclatural_group TO ara;
GRANT ALL ON TABLE nomenclatural_group TO postgres;
REVOKE ALL ON TABLE nomenclatural_group_region FROM PUBLIC;
REVOKE ALL ON TABLE nomenclatural_group_region FROM ara;
GRANT ALL ON TABLE nomenclatural_group_region TO ara;
GRANT ALL ON TABLE nomenclatural_group_region TO postgres;
REVOKE ALL ON TABLE ocean FROM PUBLIC;
REVOKE ALL ON TABLE ocean FROM ara;
GRANT ALL ON TABLE ocean TO ara;
GRANT ALL ON TABLE ocean TO PUBLIC;
REVOKE ALL ON TABLE origin FROM PUBLIC;
REVOKE ALL ON TABLE origin FROM ara;
GRANT ALL ON TABLE origin TO ara;
GRANT ALL ON TABLE origin TO postgres;
REVOKE ALL ON TABLE original_label FROM PUBLIC;
REVOKE ALL ON TABLE original_label FROM ara;
GRANT ALL ON TABLE original_label TO ara;
GRANT ALL ON TABLE original_label TO postgres;
REVOKE ALL ON TABLE person FROM PUBLIC;
REVOKE ALL ON TABLE person FROM ara;
GRANT ALL ON TABLE person TO ara;
GRANT ALL ON TABLE person TO postgres;
REVOKE ALL ON TABLE person_institution FROM PUBLIC;
REVOKE ALL ON TABLE person_institution FROM ara;
GRANT ALL ON TABLE person_institution TO ara;
GRANT ALL ON TABLE person_institution TO postgres;
REVOKE ALL ON TABLE person_profile FROM PUBLIC;
REVOKE ALL ON TABLE person_profile FROM ara;
GRANT ALL ON TABLE person_profile TO ara;
GRANT ALL ON TABLE person_profile TO postgres;
REVOKE ALL ON TABLE person_profile_taxon FROM PUBLIC;
REVOKE ALL ON TABLE person_profile_taxon FROM ara;
GRANT ALL ON TABLE person_profile_taxon TO ara;
GRANT ALL ON TABLE person_profile_taxon TO postgres;
REVOKE ALL ON TABLE pg_ts_cfg FROM PUBLIC;
REVOKE ALL ON TABLE pg_ts_cfg FROM ara;
GRANT ALL ON TABLE pg_ts_cfg TO ara;
GRANT ALL ON TABLE pg_ts_cfg TO postgres;
REVOKE ALL ON TABLE pg_ts_cfgmap FROM PUBLIC;
REVOKE ALL ON TABLE pg_ts_cfgmap FROM ara;
GRANT ALL ON TABLE pg_ts_cfgmap TO ara;
GRANT ALL ON TABLE pg_ts_cfgmap TO postgres;
REVOKE ALL ON TABLE pg_ts_dict FROM PUBLIC;
REVOKE ALL ON TABLE pg_ts_dict FROM ara;
GRANT ALL ON TABLE pg_ts_dict TO ara;
GRANT ALL ON TABLE pg_ts_dict TO postgres;
REVOKE ALL ON TABLE pg_ts_parser FROM PUBLIC;
REVOKE ALL ON TABLE pg_ts_parser FROM ara;
GRANT ALL ON TABLE pg_ts_parser TO ara;
GRANT ALL ON TABLE pg_ts_parser TO postgres;
REVOKE ALL ON TABLE preparation_method FROM PUBLIC;
REVOKE ALL ON TABLE preparation_method FROM ara;
GRANT ALL ON TABLE preparation_method TO ara;
GRANT ALL ON TABLE preparation_method TO postgres;
REVOKE ALL ON TABLE preservation_medium FROM PUBLIC;
REVOKE ALL ON TABLE preservation_medium FROM ara;
GRANT ALL ON TABLE preservation_medium TO ara;
GRANT ALL ON TABLE preservation_medium TO postgres;
REVOKE ALL ON TABLE profile FROM PUBLIC;
REVOKE ALL ON TABLE profile FROM ara;
GRANT ALL ON TABLE profile TO ara;
GRANT ALL ON TABLE profile TO postgres;
REVOKE ALL ON TABLE project FROM PUBLIC;
REVOKE ALL ON TABLE project FROM ara;
GRANT ALL ON TABLE project TO ara;
GRANT ALL ON TABLE project TO postgres;
REVOKE ALL ON TABLE projection FROM PUBLIC;
REVOKE ALL ON TABLE projection FROM ara;
GRANT ALL ON TABLE projection TO ara;
GRANT ALL ON TABLE projection TO postgres;
REVOKE ALL ON TABLE protected_area FROM PUBLIC;
REVOKE ALL ON TABLE protected_area FROM ara;
GRANT ALL ON TABLE protected_area TO ara;
GRANT ALL ON TABLE protected_area TO PUBLIC;
REVOKE ALL ON TABLE protected_area_type FROM PUBLIC;
REVOKE ALL ON TABLE protected_area_type FROM ara;
GRANT ALL ON TABLE protected_area_type TO ara;
GRANT ALL ON TABLE protected_area_type TO postgres;
REVOKE ALL ON TABLE protocol_attribute FROM PUBLIC;
REVOKE ALL ON TABLE protocol_attribute FROM ara;
GRANT ALL ON TABLE protocol_attribute TO ara;
GRANT ALL ON TABLE protocol_attribute TO postgres;
REVOKE ALL ON TABLE province FROM PUBLIC;
REVOKE ALL ON TABLE province FROM ara;
GRANT ALL ON TABLE province TO ara;
GRANT ALL ON TABLE province TO PUBLIC;
REVOKE ALL ON TABLE reference FROM PUBLIC;
REVOKE ALL ON TABLE reference FROM ara;
GRANT ALL ON TABLE reference TO ara;
GRANT ALL ON TABLE reference TO postgres;
REVOKE ALL ON TABLE reference_element FROM PUBLIC;
REVOKE ALL ON TABLE reference_element FROM ara;
GRANT ALL ON TABLE reference_element TO ara;
GRANT ALL ON TABLE reference_element TO postgres;
REVOKE ALL ON TABLE reference_element_value FROM PUBLIC;
REVOKE ALL ON TABLE reference_element_value FROM ara;
GRANT ALL ON TABLE reference_element_value TO ara;
GRANT ALL ON TABLE reference_element_value TO postgres;
REVOKE ALL ON TABLE reference_type FROM PUBLIC;
REVOKE ALL ON TABLE reference_type FROM ara;
GRANT ALL ON TABLE reference_type TO ara;
GRANT ALL ON TABLE reference_type TO postgres;
REVOKE ALL ON TABLE region FROM PUBLIC;
REVOKE ALL ON TABLE region FROM ara;
GRANT ALL ON TABLE region TO ara;
GRANT ALL ON TABLE region TO postgres;
REVOKE ALL ON TABLE sampling_type FROM PUBLIC;
REVOKE ALL ON TABLE sampling_type FROM ara;
GRANT ALL ON TABLE sampling_type TO ara;
GRANT ALL ON TABLE sampling_type TO postgres;
REVOKE ALL ON TABLE sex FROM PUBLIC;
REVOKE ALL ON TABLE sex FROM ara;
GRANT ALL ON TABLE sex TO ara;
GRANT ALL ON TABLE sex TO postgres;
REVOKE ALL ON TABLE site FROM PUBLIC;
REVOKE ALL ON TABLE site FROM ara;
GRANT ALL ON TABLE site TO ara;
GRANT ALL ON TABLE site TO postgres;
REVOKE ALL ON TABLE site_calculation_method FROM PUBLIC;
REVOKE ALL ON TABLE site_calculation_method FROM ara;
GRANT ALL ON TABLE site_calculation_method TO ara;
GRANT ALL ON TABLE site_calculation_method TO postgres;
REVOKE ALL ON TABLE site_coordinate FROM PUBLIC;
REVOKE ALL ON TABLE site_coordinate FROM ara;
GRANT ALL ON TABLE site_coordinate TO ara;
GRANT ALL ON TABLE site_coordinate TO PUBLIC;
REVOKE ALL ON TABLE species_record_stage_profile FROM PUBLIC;
REVOKE ALL ON TABLE species_record_stage_profile FROM ara;
GRANT ALL ON TABLE species_record_stage_profile TO ara;
GRANT ALL ON TABLE species_record_stage_profile TO postgres;
REVOKE ALL ON TABLE specimen FROM PUBLIC;
REVOKE ALL ON TABLE specimen FROM ara;
GRANT ALL ON TABLE specimen TO ara;
GRANT ALL ON TABLE specimen TO postgres;
REVOKE ALL ON TABLE specimen_annotation FROM PUBLIC;
REVOKE ALL ON TABLE specimen_annotation FROM ara;
GRANT ALL ON TABLE specimen_annotation TO ara;
GRANT ALL ON TABLE specimen_annotation TO postgres;
REVOKE ALL ON TABLE specimen_category FROM PUBLIC;
REVOKE ALL ON TABLE specimen_category FROM ara;
GRANT ALL ON TABLE specimen_category TO ara;
GRANT ALL ON TABLE specimen_category TO postgres;
REVOKE ALL ON TABLE specimen_description FROM PUBLIC;
REVOKE ALL ON TABLE specimen_description FROM ara;
GRANT ALL ON TABLE specimen_description TO ara;
GRANT ALL ON TABLE specimen_description TO postgres;
REVOKE ALL ON TABLE specimen_type FROM PUBLIC;
REVOKE ALL ON TABLE specimen_type FROM ara;
GRANT ALL ON TABLE specimen_type TO ara;
GRANT ALL ON TABLE specimen_type TO postgres;
REVOKE ALL ON TABLE specimen_variable FROM PUBLIC;
REVOKE ALL ON TABLE specimen_variable FROM ara;
GRANT ALL ON TABLE specimen_variable TO ara;
GRANT ALL ON TABLE specimen_variable TO postgres;
REVOKE ALL ON TABLE specimen_variable_value FROM PUBLIC;
REVOKE ALL ON TABLE specimen_variable_value FROM ara;
GRANT ALL ON TABLE specimen_variable_value TO ara;
GRANT ALL ON TABLE specimen_variable_value TO postgres;
REVOKE ALL ON TABLE stage_transition_date FROM PUBLIC;
REVOKE ALL ON TABLE stage_transition_date FROM ara;
GRANT ALL ON TABLE stage_transition_date TO ara;
GRANT ALL ON TABLE stage_transition_date TO postgres;
REVOKE ALL ON TABLE stage_transition_digraph FROM PUBLIC;
REVOKE ALL ON TABLE stage_transition_digraph FROM ara;
GRANT ALL ON TABLE stage_transition_digraph TO ara;
GRANT ALL ON TABLE stage_transition_digraph TO postgres;
REVOKE ALL ON TABLE storage_type FROM PUBLIC;
REVOKE ALL ON TABLE storage_type FROM ara;
GRANT ALL ON TABLE storage_type TO ara;
GRANT ALL ON TABLE storage_type TO postgres;
REVOKE ALL ON TABLE substrate FROM PUBLIC;
REVOKE ALL ON TABLE substrate FROM ara;
GRANT ALL ON TABLE substrate TO ara;
GRANT ALL ON TABLE substrate TO postgres;
REVOKE ALL ON TABLE system_module FROM PUBLIC;
REVOKE ALL ON TABLE system_module FROM ara;
GRANT ALL ON TABLE system_module TO ara;
GRANT ALL ON TABLE system_module TO postgres;
REVOKE ALL ON TABLE system_option FROM PUBLIC;
REVOKE ALL ON TABLE system_option FROM ara;
GRANT ALL ON TABLE system_option TO ara;
GRANT ALL ON TABLE system_option TO postgres;
REVOKE ALL ON TABLE system_option_type FROM PUBLIC;
REVOKE ALL ON TABLE system_option_type FROM ara;
GRANT ALL ON TABLE system_option_type TO ara;
GRANT ALL ON TABLE system_option_type TO postgres;
REVOKE ALL ON TABLE system_subsystem FROM PUBLIC;
REVOKE ALL ON TABLE system_subsystem FROM ara;
GRANT ALL ON TABLE system_subsystem TO ara;
GRANT ALL ON TABLE system_subsystem TO postgres;
REVOKE ALL ON TABLE system_user FROM PUBLIC;
REVOKE ALL ON TABLE system_user FROM ara;
GRANT ALL ON TABLE system_user TO ara;
GRANT ALL ON TABLE system_user TO postgres;
REVOKE ALL ON TABLE system_user_option FROM PUBLIC;
REVOKE ALL ON TABLE system_user_option FROM ara;
GRANT ALL ON TABLE system_user_option TO ara;
GRANT ALL ON TABLE system_user_option TO postgres;
REVOKE ALL ON TABLE system_user_type FROM PUBLIC;
REVOKE ALL ON TABLE system_user_type FROM ara;
GRANT ALL ON TABLE system_user_type TO ara;
GRANT ALL ON TABLE system_user_type TO postgres;
REVOKE ALL ON TABLE taxon FROM PUBLIC;
REVOKE ALL ON TABLE taxon FROM ara;
GRANT ALL ON TABLE taxon TO ara;
GRANT ALL ON TABLE taxon TO postgres;
REVOKE ALL ON TABLE taxon_author FROM PUBLIC;
REVOKE ALL ON TABLE taxon_author FROM ara;
GRANT ALL ON TABLE taxon_author TO ara;
GRANT ALL ON TABLE taxon_author TO postgres;
REVOKE ALL ON TABLE taxon_author_connector FROM PUBLIC;
REVOKE ALL ON TABLE taxon_author_connector FROM ara;
GRANT ALL ON TABLE taxon_author_connector TO ara;
GRANT ALL ON TABLE taxon_author_connector TO postgres;
REVOKE ALL ON TABLE taxon_category FROM PUBLIC;
REVOKE ALL ON TABLE taxon_category FROM ara;
GRANT ALL ON TABLE taxon_category TO ara;
GRANT ALL ON TABLE taxon_category TO postgres;
REVOKE ALL ON TABLE taxon_description FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description FROM ara;
GRANT ALL ON TABLE taxon_description TO ara;
GRANT ALL ON TABLE taxon_description TO postgres;
REVOKE ALL ON TABLE taxon_description_audience FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_audience FROM ara;
GRANT ALL ON TABLE taxon_description_audience TO ara;
GRANT ALL ON TABLE taxon_description_audience TO postgres;
REVOKE ALL ON TABLE taxon_description_category FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_category FROM ara;
GRANT ALL ON TABLE taxon_description_category TO ara;
GRANT ALL ON TABLE taxon_description_category TO postgres;
REVOKE ALL ON TABLE taxon_description_datatype FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_datatype FROM ara;
GRANT ALL ON TABLE taxon_description_datatype TO ara;
GRANT ALL ON TABLE taxon_description_datatype TO postgres;
REVOKE ALL ON TABLE taxon_description_element FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_element FROM ara;
GRANT ALL ON TABLE taxon_description_element TO ara;
GRANT ALL ON TABLE taxon_description_element TO postgres;
REVOKE ALL ON TABLE taxon_description_institution FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_institution FROM ara;
GRANT ALL ON TABLE taxon_description_institution TO ara;
GRANT ALL ON TABLE taxon_description_institution TO postgres;
REVOKE ALL ON TABLE taxon_description_record FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_record FROM ara;
GRANT ALL ON TABLE taxon_description_record TO ara;
GRANT ALL ON TABLE taxon_description_record TO postgres;
REVOKE ALL ON TABLE taxon_description_record_reference FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_record_reference FROM ara;
GRANT ALL ON TABLE taxon_description_record_reference TO ara;
GRANT ALL ON TABLE taxon_description_record_reference TO postgres;
REVOKE ALL ON TABLE taxon_description_stage FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_stage FROM ara;
GRANT ALL ON TABLE taxon_description_stage TO ara;
GRANT ALL ON TABLE taxon_description_stage TO postgres;
REVOKE ALL ON TABLE taxon_name_history FROM PUBLIC;
REVOKE ALL ON TABLE taxon_name_history FROM ara;
GRANT ALL ON TABLE taxon_name_history TO ara;
GRANT ALL ON TABLE taxon_name_history TO postgres;
REVOKE ALL ON TABLE taxon_nomenclatural_group FROM PUBLIC;
REVOKE ALL ON TABLE taxon_nomenclatural_group FROM ara;
GRANT ALL ON TABLE taxon_nomenclatural_group TO ara;
GRANT ALL ON TABLE taxon_nomenclatural_group TO postgres;
REVOKE ALL ON TABLE taxon_reference FROM PUBLIC;
REVOKE ALL ON TABLE taxon_reference FROM ara;
GRANT ALL ON TABLE taxon_reference TO ara;
GRANT ALL ON TABLE taxon_reference TO postgres;
REVOKE ALL ON TABLE taxonomical_hierarchy FROM PUBLIC;
REVOKE ALL ON TABLE taxonomical_hierarchy FROM ara;
GRANT ALL ON TABLE taxonomical_hierarchy TO ara;
GRANT ALL ON TABLE taxonomical_hierarchy TO postgres;
REVOKE ALL ON TABLE taxonomical_range FROM PUBLIC;
REVOKE ALL ON TABLE taxonomical_range FROM ara;
GRANT ALL ON TABLE taxonomical_range TO ara;
GRANT ALL ON TABLE taxonomical_range TO postgres;
REVOKE ALL ON TABLE topographic_sheet FROM PUBLIC;
REVOKE ALL ON TABLE topographic_sheet FROM ara;
GRANT ALL ON TABLE topographic_sheet TO ara;
GRANT ALL ON TABLE topographic_sheet TO PUBLIC;
REVOKE ALL ON TABLE transacted_specimen FROM PUBLIC;
REVOKE ALL ON TABLE transacted_specimen FROM ara;
GRANT ALL ON TABLE transacted_specimen TO ara;
GRANT ALL ON TABLE transacted_specimen TO postgres;
REVOKE ALL ON TABLE transacted_specimen_status FROM PUBLIC;
REVOKE ALL ON TABLE transacted_specimen_status FROM ara;
GRANT ALL ON TABLE transacted_specimen_status TO ara;
GRANT ALL ON TABLE transacted_specimen_status TO postgres;
REVOKE ALL ON TABLE "transaction" FROM PUBLIC;
REVOKE ALL ON TABLE "transaction" FROM ara;
GRANT ALL ON TABLE "transaction" TO ara;
GRANT ALL ON TABLE "transaction" TO postgres;
REVOKE ALL ON TABLE transaction_type FROM PUBLIC;
REVOKE ALL ON TABLE transaction_type FROM ara;
GRANT ALL ON TABLE transaction_type TO ara;
GRANT ALL ON TABLE transaction_type TO postgres;
REVOKE ALL ON TABLE type_specimen FROM PUBLIC;
REVOKE ALL ON TABLE type_specimen FROM ara;
GRANT ALL ON TABLE type_specimen TO ara;
GRANT ALL ON TABLE type_specimen TO postgres;
REVOKE ALL ON TABLE type_specimen_type FROM PUBLIC;
REVOKE ALL ON TABLE type_specimen_type FROM ara;
GRANT ALL ON TABLE type_specimen_type TO ara;
GRANT ALL ON TABLE type_specimen_type TO postgres;
REVOKE ALL ON TABLE versant FROM PUBLIC;
REVOKE ALL ON TABLE versant FROM ara;
GRANT ALL ON TABLE versant TO ara;
GRANT ALL ON TABLE versant TO PUBLIC;
SET check_function_bodies = false;




CREATE TABLE ara.dwc_category (
    category_id numeric NOT NULL,
    category_name character varying(150) NOT NULL,
    category_keyword character varying(150) NOT NULL
);



ALTER TABLE ara.dwc_category OWNER TO postgres;


INSERT INTO ara.dwc_category (category_id, category_name, category_keyword) VALUES (1, 'Record-level', 'record-level');

INSERT INTO ara.dwc_category (category_id, category_name, category_keyword) VALUES (2, 'Taxonomic', 'taxonomic');
INSERT INTO ara.dwc_category (category_id, category_name, category_keyword) VALUES (3, 'Identification', 'identification');

INSERT INTO ara.dwc_category (category_id, category_name, category_keyword) VALUES (4, 'Locality', 'locality');

INSERT INTO ara.dwc_category (category_id, category_name, category_keyword) VALUES (5, 'Collecting Event', 'collecting-event');

INSERT INTO ara.dwc_category (category_id, category_name, category_keyword) VALUES (6, 'Biological', 'biological');

INSERT INTO ara.dwc_category (category_id, category_name, category_keyword) VALUES (7, 'References', 'references');


ALTER TABLE ONLY ara.dwc_category
    ADD CONSTRAINT dwc_categories_pk PRIMARY KEY (category_id);



REVOKE ALL ON TABLE ara.dwc_category FROM PUBLIC;

REVOKE ALL ON TABLE ara.dwc_category FROM postgres;

GRANT ALL ON TABLE ara.dwc_category TO postgres;

GRANT ALL ON TABLE ara.dwc_category TO ara;


-- begin share module

-------------------------------------------------------
-- Creation of darwin core elements table --
-------------------------------------------------------
SET search_path = ara, pg_catalog;
CREATE TABLE dwc_element (
    element_id numeric NOT NULL,
    element_name character varying(150) NOT NULL,
    element_keyword character varying NOT NULL,
    element_category_id numeric NOT NULL,
    element_required character varying(1) NOT NULL
); -- '1' = true and '0' = false
ALTER TABLE ara.dwc_element OWNER TO postgres;

-- Populating the table
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (1, 'GlobalUniqueIdentifier', 'globaluniqueidentifier', 1, '1');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (2, 'DateLastModified', 'datelastmodified', 1, '1');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (3, 'BasisOfRecord', 'basisofrecord', 1, '1');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (4, 'InstitutionCode', 'institutioncode', 1, '1');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (5, 'CollectionCode', 'collectioncode', 1, '1');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (6, 'CatalogNumber', 'catalognumber', 1, '1');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (7, 'InformationWithheld', 'informationwithheld', 1, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (8, 'Remarks', 'remarks', 1, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (9, 'ScientificName', 'scientificname', 2, '1');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (10, 'HigherTaxon', 'highertaxon', 2, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (11, 'Kingdom', 'kingdom', 2, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (12, 'Phylum', 'phylum', 2, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (13, 'Class', 'class1', 2, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (14, 'Order', 'orders', 2, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (15, 'Family', 'family', 2, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (16, 'Genus', 'genus', 2, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (17, 'SpecificEpithet', 'specificepithet', 2, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (18, 'InfraspecificRank', 'infraspecificrank', 2, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (19, 'InfraspecificEpithet', 'infraspecificepithet', 2, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (20, 'AuthorYearOfScientificName', 'authoryearofscientificname', 2, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (21, 'NomenclaturalCode', 'nomenclaturalcode', 2, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (22, 'IdentificationQualifier', 'identificationqualifier', 3, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (23, 'HigherGeography', 'highergeography', 4, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (24, 'Continent', 'continent', 4, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (25, 'WaterBody', 'waterbody', 4, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (26, 'IslandGroup', 'islandgroup', 4, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (27, 'Island', 'island', 4, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (28, 'Country', 'country', 4, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (29, 'StateProvince', 'stateprovince', 4, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (30, 'County', 'county', 4, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (31, 'Locality', 'locality', 4, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (32, 'MinimumElevationInMeters', 'minimumelevationinmeters', 4, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (33, 'MaximumElevationInMeters', 'maximumelevationinmeters', 4, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (34, 'MinimumDepthInMeters', 'minimumdepthinmeters', 4, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (35, 'MaximumDepthInMeters', 'maximumdepthinmeters', 4, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (36, 'CollectingMethod', 'collectingmethod', 5, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (37, 'ValidDistributionFlag', 'validdistributionflag', 5, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (38, 'EarliestDateCollected', 'earliestdatecollected', 5, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (39, 'LatestDateCollected', 'latestdatecollected', 5, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (40, 'DayOfYear', 'dayofyear', 5, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (41, 'Collector', 'collector', 5, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (42, 'Sex', 'sex', 6, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (43, 'LifeStage', 'lifestage', 6, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (44, 'Attributes', 'attributes', 6, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (45, 'ImageURL', 'imageurl', 7, '0');
INSERT INTO dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (46, 'RelatedInformation', 'relatedinformation', 7, '0');
-- Seting the primary key
ALTER TABLE ONLY dwc_element
    ADD CONSTRAINT dwc_elements_pk PRIMARY KEY (element_id);
-- Seting the foreing key
ALTER TABLE ONLY dwc_element
    ADD CONSTRAINT dwc_elements_fk FOREIGN KEY (element_category_id) REFERENCES dwc_category(category_id);
-- Generated by postgres
REVOKE ALL ON TABLE dwc_element FROM PUBLIC;
REVOKE ALL ON TABLE dwc_element FROM postgres;
GRANT ALL ON TABLE dwc_element TO postgres;
GRANT ALL ON TABLE dwc_element TO ara;

-------------------------------------------------------
-- Creation of Darwin Core Snapshot Table --
-------------------------------------------------------
CREATE TABLE ara.dwc_snapshot
(
  globaluniqueidentifier character varying,
  datelastmodified timestamp without time zone,
  institutioncode character varying,
  collectioncode character varying,
  catalognumber character varying NOT NULL,
  scientificname character varying,
  basisofrecord character varying,
  informationwithheld character varying,
  phylum character varying,
  highertaxon character varying,
  kingdom character varying,
  "class" character varying,
  orders character varying,
  "family" character varying,
  genus character varying,
  specificepithet character varying,
  infraspecificepithet character varying,
  infraspecificrank character varying,
  authoryearofscientificname character varying,
  nomenclaturalcode character varying,
  identificationqualifier character varying,
  collectingmethod character varying,
  validdistributionflag character varying,
  collector character varying,
  earliestdatecollected timestamp without time zone,
  latestdatecollected timestamp without time zone,
  dayofyear numeric,
  highergeography character varying,
  continent character varying,
  waterbody character varying,
  islandgroup character varying,
  island character varying,
  country character varying,
  stateprovince character varying,
  county character varying,
  locality character varying,
  minimumelevationinmeters double precision,
  maximumelevationinmeters double precision,
  minimumdepthinmeters double precision,
  maximumdepthinmeters double precision,
  sex character varying,
  lifestage character varying,
  remarks character varying,
  attributes character varying,
  imageurl character varying,
  relatedinformation character varying,
  CONSTRAINT dwc_snapshot_pkey PRIMARY KEY (globaluniqueidentifier)
);
ALTER TABLE ara.dwc_snapshot OWNER TO ara;

-------------------------------------------------------
-- Creation of Plinian Core elements Table --
-------------------------------------------------------
-- Creation
CREATE TABLE pli_element (
    element_id numeric NOT NULL,
    element_name character varying(150) NOT NULL,
    element_keyword character varying NOT NULL,
    element_required character varying(1) NOT NULL
);
ALTER TABLE ara.pli_element OWNER TO postgres;
-- Populating the table
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (1, 'ScientificName', 'scientificname', '1');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (2, 'InstitutionCode', 'institutioncode', '1');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (3, 'DateLastModified', 'datelastmodified', '1');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (4, 'TaxonRecordId', 'taxonrecordid', '1');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (5, 'Language', 'language', '1');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (6, 'Creators', 'creators', '1');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (7, 'Distribution', 'distribution', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (8, 'Abstract', 'abstract', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (9, 'Kingdom', 'kingdom', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (10, 'Phylum', 'phylum', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (11, 'Class', 'class1', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (12, 'OrderRank', 'orderrank', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (13, 'Family', 'family', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (14, 'Genus', 'genus', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (15, 'Synonyms', 'synonyms', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (16, 'AuthorYearOfScientificName', 'authoryearofscientificname', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (17, 'SpeciesPublicationReference', 'speciespublicationreference', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (18, 'CommoNnames', 'commonnames', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (19, 'Typification', 'typification', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (20, 'GlobalUniqueIdentifier', 'globaluniqueidentifier', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (21, 'Contributors', 'contributors', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (22, 'DateCreated', 'datecreated', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (23, 'Habit', 'habit', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (24, 'LifeCycle', 'lifecycle', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (25, 'Reproduction', 'reproduction', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (26, 'AnnualCycle', 'annualcycle', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (27, 'ScientificDescription', 'scientificdescription', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (28, 'BriefDescription', 'briefdescription', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (29, 'Feeding', 'feeding', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (30, 'Behavior', 'behavior', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (31, 'Interactions', 'interactions', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (32, 'ChromosomicNumberN', 'chromosomicnumbern', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (33, 'MolecularData', 'moleculardata', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (34, 'PopulationBiology', 'populationbiology', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (35, 'ThreatStatus', 'threatstatus', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (36, 'Legislation', 'legislation', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (37, 'Habitat', 'habitat', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (38, 'Territory', 'territory', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (39, 'Endemicity', 'endemicity', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (40, 'TheUses', 'theuses', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (41, 'TheManagement', 'themanagement', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (42, 'Folklore', 'folklore', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (43, 'TheReferences', 'thereferences', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (44, 'UnstructedDocumentation', 'unstructeddocumentation', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (45, 'OtherInformationSources', 'otherinformationsources', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (46, 'Papers', 'papers', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (47, 'IdentificationKeys', 'identificationkeys', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (48, 'MigratoryData', 'migratorydata', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (49, 'EcologicalSignificance', 'ecologicalsignificance', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (50, 'UnstructuredNaturalHistory', 'unstructurednaturalhistory', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (51, 'InvasivenessData', 'invasivenessdata', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (52, 'TargetAudiences', 'targetaudiences', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (53, 'Version', 'version', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (54, 'UrlImage1', 'urlimage1', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (55, 'CaptionImage1', 'captionimage1', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (56, 'UrlImage2', 'urlimage2', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (57, 'CaptionImage2', 'captionimage2', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (58, 'UrlImage3', 'urlimage3', '0');
INSERT INTO pli_element (element_id, element_name, element_keyword, element_required) VALUES (59, 'CaptionImage3', 'captionimage3', '0');
-- Seting the primary key
ALTER TABLE ONLY pli_element
    ADD CONSTRAINT pli_elements_pk PRIMARY KEY (element_id);
-- Generated by postgres
REVOKE ALL ON TABLE pli_element FROM PUBLIC;
REVOKE ALL ON TABLE pli_element FROM postgres;
GRANT ALL ON TABLE pli_element TO postgres;
GRANT ALL ON TABLE pli_element TO ara;

-- end share module














SET check_function_bodies = false;

SET client_min_messages = warning;

SET default_tablespace = '';


SET default_with_oids = false;








