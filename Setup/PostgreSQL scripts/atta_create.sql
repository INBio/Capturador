-- Atta - capture species and specimen data
--
-- Copyright (C) 2011  INBio (Instituto Nacional de Biodiversidad)
--
-- This program is free software: you can redistribute it and/or modify
-- it under the terms of the GNU General Public License as published by
-- the Free Software Foundation, either version 3 of the License, or
-- (at your option) any later version.
--
-- This program is distributed in the hope that it will be useful,
-- but WITHOUT ANY WARRANTY; without even the implied warranty of
-- MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
-- GNU General Public License for more details.
--
-- You should have received a copy of the GNU General Public License
-- along with this program.  If not, see <http://www.gnu.org/licenses/>.
--

SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;
CREATE SCHEMA atta;
ALTER SCHEMA atta OWNER TO atta;
COMMENT ON SCHEMA atta IS 'Standard atta schema';
COMMENT ON SCHEMA public IS 'Standard public schema';
SET search_path = atta, pg_catalog;
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
ALTER TABLE atta.altitude_floor OWNER TO atta;
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
ALTER TABLE atta.annotation OWNER TO atta;
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
ALTER TABLE atta.audience OWNER TO atta;
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
ALTER TABLE atta.base_projection OWNER TO atta;
CREATE TABLE biotic_unit (
biotic_unit_id numeric NOT NULL,
value character varying(80) NOT NULL,
obj_version numeric NOT NULL,
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL
);
ALTER TABLE atta.biotic_unit OWNER TO atta;
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
ALTER TABLE atta.canton OWNER TO atta;
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
ALTER TABLE atta.canton_ifam OWNER TO atta;
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
ALTER TABLE atta.collecting_area OWNER TO atta;
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
ALTER TABLE atta.collection OWNER TO atta;
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
ALTER TABLE atta.collection_protocol OWNER TO atta;
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
ALTER TABLE atta.collector_observer OWNER TO atta;
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
ALTER TABLE atta.component OWNER TO atta;
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
ALTER TABLE atta.component_part OWNER TO atta;
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
ALTER TABLE atta.concept OWNER TO atta;
CREATE TABLE conservation_area (
conservation_area_id numeric NOT NULL,
value character varying(80) NOT NULL,
obj_version numeric NOT NULL,
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL
);
ALTER TABLE atta.conservation_area OWNER TO atta;
CREATE TABLE country (
country_id numeric NOT NULL,
value character varying(80) NOT NULL,
creation_date date,
created_by character varying(100),
last_modification_date date,
last_modification_by character varying(100),
obj_version numeric NOT NULL
);
ALTER TABLE atta.country OWNER TO atta;
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
ALTER TABLE atta.culture OWNER TO atta;
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
ALTER TABLE atta.culture_medium OWNER TO atta;
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
ALTER TABLE atta.culture_storage_medium OWNER TO atta;
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
ALTER TABLE atta.determination_type OWNER TO atta;
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
ALTER TABLE atta.district OWNER TO atta;
CREATE TABLE ecological_region (
ecological_region_id numeric NOT NULL,
value character varying(80) NOT NULL,
obj_version numeric NOT NULL,
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL
);
ALTER TABLE atta.ecological_region OWNER TO atta;
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
ALTER TABLE atta.ecological_variable OWNER TO atta;
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
ALTER TABLE atta.ecological_variable_value OWNER TO atta;
CREATE TABLE ecosystem (
ecosystem_id numeric NOT NULL,
value character varying(80) NOT NULL,
obj_version numeric NOT NULL,
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL
);
ALTER TABLE atta.ecosystem OWNER TO atta;
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
ALTER TABLE atta.elevation_band OWNER TO atta;
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
ALTER TABLE atta.exposition OWNER TO atta;
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
ALTER TABLE atta.extraction_type OWNER TO atta;
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
ALTER TABLE atta.feature_type OWNER TO atta;
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
ALTER TABLE atta.gathering_observation OWNER TO atta;
CREATE TABLE gathering_observation_collection (
gathering_observation_id numeric NOT NULL,
collection_id numeric NOT NULL,
obj_version numeric NOT NULL,
created_by character varying(100) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying NOT NULL,
last_modification_date date NOT NULL
);
ALTER TABLE atta.gathering_observation_collection OWNER TO atta;
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
ALTER TABLE atta.gathering_observation_detail OWNER TO atta;
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
ALTER TABLE atta.gathering_observation_ecological_var OWNER TO atta;
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
ALTER TABLE atta.gathering_observation_method OWNER TO atta;
CREATE TABLE gathering_observation_project (
gathering_observation_id numeric NOT NULL,
project_id numeric NOT NULL,
obj_version numeric NOT NULL,
created_by character varying(100) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(100) NOT NULL,
last_modification_date date NOT NULL
);
ALTER TABLE atta.gathering_observation_project OWNER TO atta;
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
ALTER TABLE atta.geographic_catalogue OWNER TO atta;
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
ALTER TABLE atta.geographic_entity OWNER TO atta;
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
ALTER TABLE atta.geographic_layer OWNER TO atta;
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
ALTER TABLE atta.georeferenced_site OWNER TO atta;
CREATE TABLE id_gen (
gen_key character varying NOT NULL,
gen_value numeric NOT NULL
);
ALTER TABLE atta.id_gen OWNER TO atta;
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
ALTER TABLE atta.identification OWNER TO atta;
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
ALTER TABLE atta.identification_history OWNER TO atta;
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
ALTER TABLE atta.identification_status OWNER TO atta;
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
ALTER TABLE atta.identification_type OWNER TO atta;
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
ALTER TABLE atta.identifier OWNER TO atta;
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
ALTER TABLE atta.identifier_history OWNER TO atta;
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
ALTER TABLE atta.inmediate_predecessor_history OWNER TO atta;
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
ALTER TABLE atta.institution OWNER TO atta;
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
ALTER TABLE atta.interaction_type OWNER TO atta;
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
ALTER TABLE atta.label OWNER TO atta;
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
ALTER TABLE atta.label_history OWNER TO atta;
CREATE TABLE land_cover (
land_cover_id numeric NOT NULL,
value character varying(80) NOT NULL,
obj_version numeric NOT NULL,
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL
);
ALTER TABLE atta.land_cover OWNER TO atta;
CREATE TABLE "language" (
language_id numeric NOT NULL,
concept_id numeric,
obj_version numeric NOT NULL,
creation_date date NOT NULL,
last_modification_date date NOT NULL,
created_by character varying(100) NOT NULL,
last_modification_by character varying(100) NOT NULL
);
ALTER TABLE atta."language" OWNER TO atta;
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
ALTER TABLE atta.life_form OWNER TO atta;
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
ALTER TABLE atta.life_stage OWNER TO atta;
CREATE TABLE life_zone (
life_zone_id numeric NOT NULL,
value character varying(80) NOT NULL,
obj_version numeric NOT NULL,
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL
);
ALTER TABLE atta.life_zone OWNER TO atta;
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
ALTER TABLE atta.list_table OWNER TO atta;
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
ALTER TABLE atta.list_table_collection OWNER TO atta;
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
ALTER TABLE atta.morphological_description OWNER TO atta;
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
ALTER TABLE atta.natural_region OWNER TO atta;
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
ALTER TABLE atta.nomenclatural_group OWNER TO atta;
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
ALTER TABLE atta.nomenclatural_group_region OWNER TO atta;
CREATE TABLE ocean (
ocean_id numeric NOT NULL,
value character varying(80) NOT NULL,
obj_version numeric NOT NULL,
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL
);
ALTER TABLE atta.ocean OWNER TO atta;
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
ALTER TABLE atta.origin OWNER TO atta;
CREATE TABLE original_label (
original_label_id numeric NOT NULL,
contents character varying(4000),
obj_version numeric NOT NULL,
created_by character varying(100) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(100) NOT NULL,
last_modification_date date NOT NULL
);
ALTER TABLE atta.original_label OWNER TO atta;
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
ALTER TABLE atta.person OWNER TO atta;
CREATE TABLE person_institution (
person_id numeric NOT NULL,
institution_id numeric NOT NULL,
creation_date date,
created_by character varying(100),
last_modification_date date,
last_modification_by character varying(100),
obj_version numeric NOT NULL
);
ALTER TABLE atta.person_institution OWNER TO atta;
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
ALTER TABLE atta.person_profile OWNER TO atta;
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
ALTER TABLE atta.person_profile_taxon OWNER TO atta;
SET default_with_oids = true;
CREATE TABLE pg_ts_cfg (
ts_name text NOT NULL,
prs_name text NOT NULL,
locale text
);
ALTER TABLE atta.pg_ts_cfg OWNER TO atta;
CREATE TABLE pg_ts_cfgmap (
ts_name text NOT NULL,
tok_alias text NOT NULL,
dict_name text[]
);
ALTER TABLE atta.pg_ts_cfgmap OWNER TO atta;
CREATE TABLE pg_ts_dict (
dict_name text NOT NULL,
dict_init regprocedure,
dict_initoption text,
dict_lexize regprocedure NOT NULL,
dict_comment text
);
ALTER TABLE atta.pg_ts_dict OWNER TO atta;
CREATE TABLE pg_ts_parser (
prs_name text NOT NULL,
prs_start regprocedure NOT NULL,
prs_nexttoken regprocedure NOT NULL,
prs_end regprocedure NOT NULL,
prs_headline regprocedure NOT NULL,
prs_lextype regprocedure NOT NULL,
prs_comment text
);
ALTER TABLE atta.pg_ts_parser OWNER TO atta;
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
ALTER TABLE atta.preparation_method OWNER TO atta;
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
ALTER TABLE atta.preservation_medium OWNER TO atta;
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
ALTER TABLE atta.profile OWNER TO atta;
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
ALTER TABLE atta.project OWNER TO atta;
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
ALTER TABLE atta.projection OWNER TO atta;
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
ALTER TABLE atta.protected_area OWNER TO atta;
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
ALTER TABLE atta.protected_area_type OWNER TO atta;
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
ALTER TABLE atta.protocol_attribute OWNER TO atta;
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
ALTER TABLE atta.province OWNER TO atta;
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
ALTER TABLE atta.reference OWNER TO atta;
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
ALTER TABLE atta.reference_element OWNER TO atta;
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
ALTER TABLE atta.reference_element_value OWNER TO atta;
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
ALTER TABLE atta.reference_type OWNER TO atta;
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
ALTER TABLE atta.region OWNER TO atta;
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
ALTER TABLE atta.sampling_type OWNER TO atta;
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
ALTER TABLE atta.sex OWNER TO atta;
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
ALTER TABLE atta.site OWNER TO atta;
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
ALTER TABLE atta.site_calculation_method OWNER TO atta;
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
ALTER TABLE atta.site_coordinate OWNER TO atta;
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
ALTER TABLE atta.species_record_stage_profile OWNER TO atta;
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
ALTER TABLE atta.specimen OWNER TO atta;
CREATE TABLE specimen_annotation (
specimen_id numeric NOT NULL,
annotation_id numeric NOT NULL,
obj_version numeric NOT NULL,
created_by character varying(100) NOT NULL,
creation_date date NOT NULL,
last_modification_date date NOT NULL,
last_modification_by character varying(100) NOT NULL
);
ALTER TABLE atta.specimen_annotation OWNER TO atta;
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
ALTER TABLE atta.specimen_category OWNER TO atta;
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
ALTER TABLE atta.specimen_description OWNER TO atta;
CREATE TABLE specimen_life_form (
specimen_id numeric NOT NULL,
life_form_id numeric NOT NULL,
obj_version numeric NOT NULL,
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL
);
ALTER TABLE atta.specimen_life_form OWNER TO atta;
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
ALTER TABLE atta.specimen_life_stage_sex OWNER TO atta;
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
ALTER TABLE atta.specimen_type OWNER TO atta;
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
ALTER TABLE atta.specimen_variable OWNER TO atta;
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
ALTER TABLE atta.specimen_variable_value OWNER TO atta;
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
ALTER TABLE atta.stage_transition_date OWNER TO atta;
CREATE TABLE stage_transition_digraph (
species_record_stage_from_id numeric NOT NULL,
species_record_stage_to_id numeric NOT NULL,
obj_version numeric NOT NULL,
created_by character varying(100) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(100) NOT NULL,
last_modification_date date NOT NULL
);
ALTER TABLE atta.stage_transition_digraph OWNER TO atta;
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
ALTER TABLE atta.storage_type OWNER TO atta;
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
ALTER TABLE atta.substrate OWNER TO atta;
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
ALTER TABLE atta.system_module OWNER TO atta;
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
ALTER TABLE atta.system_option OWNER TO atta;
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
ALTER TABLE atta.system_option_bak OWNER TO postgres;
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
ALTER TABLE atta.system_option_type OWNER TO atta;
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
ALTER TABLE atta.system_subsystem OWNER TO atta;
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
ALTER TABLE atta.system_user OWNER TO atta;
CREATE TABLE system_user_option (
user_id numeric NOT NULL,
option_id numeric NOT NULL,
created_by character varying(100) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(100) NOT NULL,
last_modification_date date NOT NULL,
obj_version numeric NOT NULL
);
ALTER TABLE atta.system_user_option OWNER TO atta;
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
ALTER TABLE atta.system_user_type OWNER TO atta;
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
ALTER TABLE atta.taxon OWNER TO atta;
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
ALTER TABLE atta.taxon_author OWNER TO atta;
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
ALTER TABLE atta.taxon_author_connector OWNER TO atta;
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
ALTER TABLE atta.taxon_category OWNER TO atta;
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
ALTER TABLE atta.taxon_description OWNER TO atta;
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
ALTER TABLE atta.taxon_description_audience OWNER TO atta;
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
ALTER TABLE atta.taxon_description_category OWNER TO atta;
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
ALTER TABLE atta.taxon_description_datatype OWNER TO atta;
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
ALTER TABLE atta.taxon_description_element OWNER TO atta;
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
ALTER TABLE atta.taxon_description_institution OWNER TO atta;
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
ALTER TABLE atta.taxon_description_person_profile OWNER TO atta;
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
ALTER TABLE atta.taxon_description_record OWNER TO atta;
CREATE TABLE taxon_description_record_reference (
taxon_description_record_id numeric NOT NULL,
reference_id numeric NOT NULL,
obj_version numeric NOT NULL,
created_by character varying(100) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(100) NOT NULL,
last_modification_date date NOT NULL
);
ALTER TABLE atta.taxon_description_record_reference OWNER TO atta;
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
ALTER TABLE atta.taxon_description_stage OWNER TO atta;
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
ALTER TABLE atta.taxon_name_history OWNER TO atta;
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
ALTER TABLE atta.taxon_nomenclatural_group OWNER TO atta;
CREATE TABLE taxon_reference (
taxon_id numeric NOT NULL,
reference_id numeric NOT NULL,
obj_version numeric NOT NULL,
created_by character varying(100) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(100) NOT NULL,
last_modification_date date NOT NULL
);
ALTER TABLE atta.taxon_reference OWNER TO atta;
CREATE TABLE taxonomical_hierarchy (
taxonomical_range_id numeric NOT NULL,
ancestor_taxonomical_id numeric NOT NULL,
creation_date date,
created_by character varying(100),
last_modification_date date,
last_modification_by character varying(100),
obj_version numeric NOT NULL
);
ALTER TABLE atta.taxonomical_hierarchy OWNER TO atta;
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
ALTER TABLE atta.taxonomical_range OWNER TO atta;
CREATE TABLE topographic_sheet (
topographic_sheet_id numeric NOT NULL,
value character varying(80) NOT NULL,
obj_version numeric NOT NULL,
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL
);
ALTER TABLE atta.topographic_sheet OWNER TO atta;
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
ALTER TABLE atta.transacted_specimen OWNER TO atta;
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
ALTER TABLE atta.transacted_specimen_status OWNER TO atta;
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
ALTER TABLE atta."transaction" OWNER TO atta;
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
ALTER TABLE atta.transaction_type OWNER TO atta;
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
ALTER TABLE atta.type_specimen OWNER TO atta;
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
ALTER TABLE atta.type_specimen_type OWNER TO atta;
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
ALTER TABLE atta.user_nomenclatural_group OWNER TO atta;
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
ALTER TABLE atta.user_taxon OWNER TO atta;
CREATE TABLE versant (
versant_id numeric NOT NULL,
value character varying(80) NOT NULL,
obj_version numeric NOT NULL,
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL
);
ALTER TABLE atta.versant OWNER TO atta;
create table atta.DARWIN_CORE_1_4
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
ALTER TABLE atta.DARWIN_CORE_1_4 OWNER TO atta;
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;
SET search_path = atta, pg_catalog;

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
REVOKE ALL ON SCHEMA atta FROM PUBLIC;
REVOKE ALL ON SCHEMA atta FROM atta;
GRANT ALL ON SCHEMA atta TO atta;
GRANT ALL ON SCHEMA atta TO postgres;
REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
REVOKE ALL ON TABLE altitude_floor FROM PUBLIC;
REVOKE ALL ON TABLE altitude_floor FROM atta;
GRANT ALL ON TABLE altitude_floor TO atta;
GRANT ALL ON TABLE altitude_floor TO postgres;
REVOKE ALL ON TABLE DARWIN_CORE_1_4 FROM PUBLIC;
REVOKE ALL ON TABLE DARWIN_CORE_1_4 FROM atta;
GRANT ALL ON TABLE DARWIN_CORE_1_4 TO atta;
GRANT ALL ON TABLE DARWIN_CORE_1_4 TO postgres;
REVOKE ALL ON TABLE annotation FROM PUBLIC;
REVOKE ALL ON TABLE annotation FROM atta;
GRANT ALL ON TABLE annotation TO atta;
GRANT ALL ON TABLE annotation TO postgres;
REVOKE ALL ON TABLE audience FROM PUBLIC;
REVOKE ALL ON TABLE audience FROM atta;
GRANT ALL ON TABLE audience TO atta;
GRANT ALL ON TABLE audience TO postgres;
REVOKE ALL ON TABLE base_projection FROM PUBLIC;
REVOKE ALL ON TABLE base_projection FROM atta;
GRANT ALL ON TABLE base_projection TO atta;
GRANT ALL ON TABLE base_projection TO postgres;
REVOKE ALL ON TABLE biotic_unit FROM PUBLIC;
REVOKE ALL ON TABLE biotic_unit FROM atta;
GRANT ALL ON TABLE biotic_unit TO atta;
GRANT ALL ON TABLE biotic_unit TO PUBLIC;
REVOKE ALL ON TABLE canton FROM PUBLIC;
REVOKE ALL ON TABLE canton FROM atta;
GRANT ALL ON TABLE canton TO atta;
GRANT ALL ON TABLE canton TO PUBLIC;
REVOKE ALL ON TABLE canton_ifam FROM PUBLIC;
REVOKE ALL ON TABLE canton_ifam FROM atta;
GRANT ALL ON TABLE canton_ifam TO atta;
GRANT ALL ON TABLE canton_ifam TO PUBLIC;
REVOKE ALL ON TABLE collecting_area FROM PUBLIC;
REVOKE ALL ON TABLE collecting_area FROM atta;
GRANT ALL ON TABLE collecting_area TO atta;
GRANT ALL ON TABLE collecting_area TO PUBLIC;
REVOKE ALL ON TABLE collection FROM PUBLIC;
REVOKE ALL ON TABLE collection FROM atta;
GRANT ALL ON TABLE collection TO atta;
GRANT ALL ON TABLE collection TO postgres;
REVOKE ALL ON TABLE collection_protocol FROM PUBLIC;
REVOKE ALL ON TABLE collection_protocol FROM atta;
GRANT ALL ON TABLE collection_protocol TO atta;
GRANT ALL ON TABLE collection_protocol TO postgres;
REVOKE ALL ON TABLE collector_observer FROM PUBLIC;
REVOKE ALL ON TABLE collector_observer FROM atta;
GRANT ALL ON TABLE collector_observer TO atta;
GRANT ALL ON TABLE collector_observer TO PUBLIC;
REVOKE ALL ON TABLE component FROM PUBLIC;
REVOKE ALL ON TABLE component FROM atta;
GRANT ALL ON TABLE component TO atta;
GRANT ALL ON TABLE component TO postgres;
REVOKE ALL ON TABLE component_part FROM PUBLIC;
REVOKE ALL ON TABLE component_part FROM atta;
GRANT ALL ON TABLE component_part TO atta;
GRANT ALL ON TABLE component_part TO postgres;
REVOKE ALL ON TABLE concept FROM PUBLIC;
REVOKE ALL ON TABLE concept FROM atta;
GRANT ALL ON TABLE concept TO atta;
GRANT ALL ON TABLE concept TO postgres;
REVOKE ALL ON TABLE conservation_area FROM PUBLIC;
REVOKE ALL ON TABLE conservation_area FROM atta;
GRANT ALL ON TABLE conservation_area TO atta;
GRANT ALL ON TABLE conservation_area TO PUBLIC;
REVOKE ALL ON TABLE country FROM PUBLIC;
REVOKE ALL ON TABLE country FROM atta;
GRANT ALL ON TABLE country TO atta;
GRANT ALL ON TABLE country TO postgres;
REVOKE ALL ON TABLE culture FROM PUBLIC;
REVOKE ALL ON TABLE culture FROM atta;
GRANT ALL ON TABLE culture TO atta;
GRANT ALL ON TABLE culture TO postgres;
REVOKE ALL ON TABLE culture_medium FROM PUBLIC;
REVOKE ALL ON TABLE culture_medium FROM atta;
GRANT ALL ON TABLE culture_medium TO atta;
GRANT ALL ON TABLE culture_medium TO postgres;
REVOKE ALL ON TABLE culture_storage_medium FROM PUBLIC;
REVOKE ALL ON TABLE culture_storage_medium FROM atta;
GRANT ALL ON TABLE culture_storage_medium TO atta;
GRANT ALL ON TABLE culture_storage_medium TO postgres;
REVOKE ALL ON TABLE determination_type FROM PUBLIC;
REVOKE ALL ON TABLE determination_type FROM atta;
GRANT ALL ON TABLE determination_type TO atta;
GRANT ALL ON TABLE determination_type TO postgres;
REVOKE ALL ON TABLE district FROM PUBLIC;
REVOKE ALL ON TABLE district FROM atta;
GRANT ALL ON TABLE district TO atta;
GRANT ALL ON TABLE district TO PUBLIC;
REVOKE ALL ON TABLE ecological_region FROM PUBLIC;
REVOKE ALL ON TABLE ecological_region FROM atta;
GRANT ALL ON TABLE ecological_region TO atta;
GRANT ALL ON TABLE ecological_region TO PUBLIC;
REVOKE ALL ON TABLE ecological_variable FROM PUBLIC;
REVOKE ALL ON TABLE ecological_variable FROM atta;
GRANT ALL ON TABLE ecological_variable TO atta;
GRANT ALL ON TABLE ecological_variable TO postgres;
REVOKE ALL ON TABLE ecological_variable_value FROM PUBLIC;
REVOKE ALL ON TABLE ecological_variable_value FROM atta;
GRANT ALL ON TABLE ecological_variable_value TO atta;
GRANT ALL ON TABLE ecological_variable_value TO postgres;
REVOKE ALL ON TABLE ecosystem FROM PUBLIC;
REVOKE ALL ON TABLE ecosystem FROM atta;
GRANT ALL ON TABLE ecosystem TO atta;
GRANT ALL ON TABLE ecosystem TO PUBLIC;
REVOKE ALL ON TABLE elevation_band FROM PUBLIC;
REVOKE ALL ON TABLE elevation_band FROM atta;
GRANT ALL ON TABLE elevation_band TO atta;
GRANT ALL ON TABLE elevation_band TO PUBLIC;
REVOKE ALL ON TABLE exposition FROM PUBLIC;
REVOKE ALL ON TABLE exposition FROM atta;
GRANT ALL ON TABLE exposition TO atta;
GRANT ALL ON TABLE exposition TO postgres;
REVOKE ALL ON TABLE extraction_type FROM PUBLIC;
REVOKE ALL ON TABLE extraction_type FROM atta;
GRANT ALL ON TABLE extraction_type TO atta;
GRANT ALL ON TABLE extraction_type TO postgres;
REVOKE ALL ON TABLE feature_type FROM PUBLIC;
REVOKE ALL ON TABLE feature_type FROM atta;
GRANT ALL ON TABLE feature_type TO atta;
GRANT ALL ON TABLE feature_type TO postgres;
REVOKE ALL ON TABLE gathering_observation FROM PUBLIC;
REVOKE ALL ON TABLE gathering_observation FROM atta;
GRANT ALL ON TABLE gathering_observation TO atta;
REVOKE ALL ON TABLE gathering_observation_collection FROM PUBLIC;
REVOKE ALL ON TABLE gathering_observation_collection FROM atta;
GRANT ALL ON TABLE gathering_observation_collection TO atta;
REVOKE ALL ON TABLE gathering_observation_detail FROM PUBLIC;
REVOKE ALL ON TABLE gathering_observation_detail FROM atta;
GRANT ALL ON TABLE gathering_observation_detail TO atta;
REVOKE ALL ON TABLE gathering_observation_ecological_var FROM PUBLIC;
REVOKE ALL ON TABLE gathering_observation_ecological_var FROM atta;
GRANT ALL ON TABLE gathering_observation_ecological_var TO atta;
GRANT ALL ON TABLE gathering_observation_ecological_var TO postgres;
REVOKE ALL ON TABLE gathering_observation_method FROM PUBLIC;
REVOKE ALL ON TABLE gathering_observation_method FROM atta;
GRANT ALL ON TABLE gathering_observation_method TO atta;
REVOKE ALL ON TABLE gathering_observation_project FROM PUBLIC;
REVOKE ALL ON TABLE gathering_observation_project FROM atta;
GRANT ALL ON TABLE gathering_observation_project TO atta;
GRANT ALL ON TABLE gathering_observation_project TO postgres;
REVOKE ALL ON TABLE geographic_catalogue FROM PUBLIC;
REVOKE ALL ON TABLE geographic_catalogue FROM atta;
GRANT ALL ON TABLE geographic_catalogue TO atta;
GRANT ALL ON TABLE geographic_catalogue TO postgres;
REVOKE ALL ON TABLE geographic_entity FROM PUBLIC;
REVOKE ALL ON TABLE geographic_entity FROM atta;
GRANT ALL ON TABLE geographic_entity TO atta;
GRANT ALL ON TABLE geographic_entity TO postgres;
REVOKE ALL ON TABLE geographic_layer FROM PUBLIC;
REVOKE ALL ON TABLE geographic_layer FROM atta;
GRANT ALL ON TABLE geographic_layer TO atta;
GRANT ALL ON TABLE geographic_layer TO PUBLIC;
REVOKE ALL ON TABLE georeferenced_site FROM PUBLIC;
REVOKE ALL ON TABLE georeferenced_site FROM atta;
GRANT ALL ON TABLE georeferenced_site TO atta;
GRANT ALL ON TABLE georeferenced_site TO PUBLIC;
REVOKE ALL ON TABLE id_gen FROM PUBLIC;
REVOKE ALL ON TABLE id_gen FROM atta;
GRANT ALL ON TABLE id_gen TO atta;
REVOKE ALL ON TABLE identification FROM PUBLIC;
REVOKE ALL ON TABLE identification FROM atta;
GRANT ALL ON TABLE identification TO atta;
GRANT ALL ON TABLE identification TO postgres;
REVOKE ALL ON TABLE identification_history FROM PUBLIC;
REVOKE ALL ON TABLE identification_history FROM atta;
GRANT ALL ON TABLE identification_history TO atta;
GRANT ALL ON TABLE identification_history TO postgres;
REVOKE ALL ON TABLE identification_status FROM PUBLIC;
REVOKE ALL ON TABLE identification_status FROM atta;
GRANT ALL ON TABLE identification_status TO atta;
GRANT ALL ON TABLE identification_status TO postgres;
REVOKE ALL ON TABLE identification_type FROM PUBLIC;
REVOKE ALL ON TABLE identification_type FROM atta;
GRANT ALL ON TABLE identification_type TO atta;
GRANT ALL ON TABLE identification_type TO postgres;
REVOKE ALL ON TABLE identifier FROM PUBLIC;
REVOKE ALL ON TABLE identifier FROM atta;
GRANT ALL ON TABLE identifier TO atta;
GRANT ALL ON TABLE identifier TO postgres;
REVOKE ALL ON TABLE identifier_history FROM PUBLIC;
REVOKE ALL ON TABLE identifier_history FROM atta;
GRANT ALL ON TABLE identifier_history TO atta;
GRANT ALL ON TABLE identifier_history TO postgres;
REVOKE ALL ON TABLE inmediate_predecessor_history FROM PUBLIC;
REVOKE ALL ON TABLE inmediate_predecessor_history FROM atta;
GRANT ALL ON TABLE inmediate_predecessor_history TO atta;
GRANT ALL ON TABLE inmediate_predecessor_history TO postgres;
REVOKE ALL ON TABLE institution FROM PUBLIC;
REVOKE ALL ON TABLE institution FROM atta;
GRANT ALL ON TABLE institution TO atta;
GRANT ALL ON TABLE institution TO postgres;
REVOKE ALL ON TABLE interaction_type FROM PUBLIC;
REVOKE ALL ON TABLE interaction_type FROM atta;
GRANT ALL ON TABLE interaction_type TO atta;
GRANT ALL ON TABLE interaction_type TO postgres;
REVOKE ALL ON TABLE label FROM PUBLIC;
REVOKE ALL ON TABLE label FROM atta;
GRANT ALL ON TABLE label TO atta;
GRANT ALL ON TABLE label TO postgres;
REVOKE ALL ON TABLE label_history FROM PUBLIC;
REVOKE ALL ON TABLE label_history FROM atta;
GRANT ALL ON TABLE label_history TO atta;
GRANT ALL ON TABLE label_history TO postgres;
REVOKE ALL ON TABLE land_cover FROM PUBLIC;
REVOKE ALL ON TABLE land_cover FROM atta;
GRANT ALL ON TABLE land_cover TO atta;
GRANT ALL ON TABLE land_cover TO PUBLIC;
REVOKE ALL ON TABLE "language" FROM PUBLIC;
REVOKE ALL ON TABLE "language" FROM atta;
GRANT ALL ON TABLE "language" TO atta;
GRANT ALL ON TABLE "language" TO postgres;
REVOKE ALL ON TABLE life_form FROM PUBLIC;
REVOKE ALL ON TABLE life_form FROM atta;
GRANT ALL ON TABLE life_form TO atta;
GRANT ALL ON TABLE life_form TO postgres;
REVOKE ALL ON TABLE life_stage FROM PUBLIC;
REVOKE ALL ON TABLE life_stage FROM atta;
GRANT ALL ON TABLE life_stage TO atta;
GRANT ALL ON TABLE life_stage TO postgres;
REVOKE ALL ON TABLE life_zone FROM PUBLIC;
REVOKE ALL ON TABLE life_zone FROM atta;
GRANT ALL ON TABLE life_zone TO atta;
GRANT ALL ON TABLE life_zone TO PUBLIC;
REVOKE ALL ON TABLE morphological_description FROM PUBLIC;
REVOKE ALL ON TABLE morphological_description FROM atta;
GRANT ALL ON TABLE morphological_description TO atta;
GRANT ALL ON TABLE morphological_description TO postgres;
REVOKE ALL ON TABLE natural_region FROM PUBLIC;
REVOKE ALL ON TABLE natural_region FROM atta;
GRANT ALL ON TABLE natural_region TO atta;
GRANT ALL ON TABLE natural_region TO PUBLIC;
REVOKE ALL ON TABLE nomenclatural_group FROM PUBLIC;
REVOKE ALL ON TABLE nomenclatural_group FROM atta;
GRANT ALL ON TABLE nomenclatural_group TO atta;
GRANT ALL ON TABLE nomenclatural_group TO postgres;
REVOKE ALL ON TABLE nomenclatural_group_region FROM PUBLIC;
REVOKE ALL ON TABLE nomenclatural_group_region FROM atta;
GRANT ALL ON TABLE nomenclatural_group_region TO atta;
GRANT ALL ON TABLE nomenclatural_group_region TO postgres;
REVOKE ALL ON TABLE ocean FROM PUBLIC;
REVOKE ALL ON TABLE ocean FROM atta;
GRANT ALL ON TABLE ocean TO atta;
GRANT ALL ON TABLE ocean TO PUBLIC;
REVOKE ALL ON TABLE origin FROM PUBLIC;
REVOKE ALL ON TABLE origin FROM atta;
GRANT ALL ON TABLE origin TO atta;
GRANT ALL ON TABLE origin TO postgres;
REVOKE ALL ON TABLE original_label FROM PUBLIC;
REVOKE ALL ON TABLE original_label FROM atta;
GRANT ALL ON TABLE original_label TO atta;
GRANT ALL ON TABLE original_label TO postgres;
REVOKE ALL ON TABLE person FROM PUBLIC;
REVOKE ALL ON TABLE person FROM atta;
GRANT ALL ON TABLE person TO atta;
GRANT ALL ON TABLE person TO postgres;
REVOKE ALL ON TABLE person_institution FROM PUBLIC;
REVOKE ALL ON TABLE person_institution FROM atta;
GRANT ALL ON TABLE person_institution TO atta;
GRANT ALL ON TABLE person_institution TO postgres;
REVOKE ALL ON TABLE person_profile FROM PUBLIC;
REVOKE ALL ON TABLE person_profile FROM atta;
GRANT ALL ON TABLE person_profile TO atta;
GRANT ALL ON TABLE person_profile TO postgres;
REVOKE ALL ON TABLE person_profile_taxon FROM PUBLIC;
REVOKE ALL ON TABLE person_profile_taxon FROM atta;
GRANT ALL ON TABLE person_profile_taxon TO atta;
GRANT ALL ON TABLE person_profile_taxon TO postgres;
REVOKE ALL ON TABLE pg_ts_cfg FROM PUBLIC;
REVOKE ALL ON TABLE pg_ts_cfg FROM atta;
GRANT ALL ON TABLE pg_ts_cfg TO atta;
GRANT ALL ON TABLE pg_ts_cfg TO postgres;
REVOKE ALL ON TABLE pg_ts_cfgmap FROM PUBLIC;
REVOKE ALL ON TABLE pg_ts_cfgmap FROM atta;
GRANT ALL ON TABLE pg_ts_cfgmap TO atta;
GRANT ALL ON TABLE pg_ts_cfgmap TO postgres;
REVOKE ALL ON TABLE pg_ts_dict FROM PUBLIC;
REVOKE ALL ON TABLE pg_ts_dict FROM atta;
GRANT ALL ON TABLE pg_ts_dict TO atta;
GRANT ALL ON TABLE pg_ts_dict TO postgres;
REVOKE ALL ON TABLE pg_ts_parser FROM PUBLIC;
REVOKE ALL ON TABLE pg_ts_parser FROM atta;
GRANT ALL ON TABLE pg_ts_parser TO atta;
GRANT ALL ON TABLE pg_ts_parser TO postgres;
REVOKE ALL ON TABLE preparation_method FROM PUBLIC;
REVOKE ALL ON TABLE preparation_method FROM atta;
GRANT ALL ON TABLE preparation_method TO atta;
GRANT ALL ON TABLE preparation_method TO postgres;
REVOKE ALL ON TABLE preservation_medium FROM PUBLIC;
REVOKE ALL ON TABLE preservation_medium FROM atta;
GRANT ALL ON TABLE preservation_medium TO atta;
GRANT ALL ON TABLE preservation_medium TO postgres;
REVOKE ALL ON TABLE profile FROM PUBLIC;
REVOKE ALL ON TABLE profile FROM atta;
GRANT ALL ON TABLE profile TO atta;
GRANT ALL ON TABLE profile TO postgres;
REVOKE ALL ON TABLE project FROM PUBLIC;
REVOKE ALL ON TABLE project FROM atta;
GRANT ALL ON TABLE project TO atta;
GRANT ALL ON TABLE project TO postgres;
REVOKE ALL ON TABLE projection FROM PUBLIC;
REVOKE ALL ON TABLE projection FROM atta;
GRANT ALL ON TABLE projection TO atta;
GRANT ALL ON TABLE projection TO postgres;
REVOKE ALL ON TABLE protected_area FROM PUBLIC;
REVOKE ALL ON TABLE protected_area FROM atta;
GRANT ALL ON TABLE protected_area TO atta;
GRANT ALL ON TABLE protected_area TO PUBLIC;
REVOKE ALL ON TABLE protected_area_type FROM PUBLIC;
REVOKE ALL ON TABLE protected_area_type FROM atta;
GRANT ALL ON TABLE protected_area_type TO atta;
GRANT ALL ON TABLE protected_area_type TO postgres;
REVOKE ALL ON TABLE protocol_attribute FROM PUBLIC;
REVOKE ALL ON TABLE protocol_attribute FROM atta;
GRANT ALL ON TABLE protocol_attribute TO atta;
GRANT ALL ON TABLE protocol_attribute TO postgres;
REVOKE ALL ON TABLE province FROM PUBLIC;
REVOKE ALL ON TABLE province FROM atta;
GRANT ALL ON TABLE province TO atta;
GRANT ALL ON TABLE province TO PUBLIC;
REVOKE ALL ON TABLE reference FROM PUBLIC;
REVOKE ALL ON TABLE reference FROM atta;
GRANT ALL ON TABLE reference TO atta;
GRANT ALL ON TABLE reference TO postgres;
REVOKE ALL ON TABLE reference_element FROM PUBLIC;
REVOKE ALL ON TABLE reference_element FROM atta;
GRANT ALL ON TABLE reference_element TO atta;
GRANT ALL ON TABLE reference_element TO postgres;
REVOKE ALL ON TABLE reference_element_value FROM PUBLIC;
REVOKE ALL ON TABLE reference_element_value FROM atta;
GRANT ALL ON TABLE reference_element_value TO atta;
GRANT ALL ON TABLE reference_element_value TO postgres;
REVOKE ALL ON TABLE reference_type FROM PUBLIC;
REVOKE ALL ON TABLE reference_type FROM atta;
GRANT ALL ON TABLE reference_type TO atta;
GRANT ALL ON TABLE reference_type TO postgres;
REVOKE ALL ON TABLE region FROM PUBLIC;
REVOKE ALL ON TABLE region FROM atta;
GRANT ALL ON TABLE region TO atta;
GRANT ALL ON TABLE region TO postgres;
REVOKE ALL ON TABLE sampling_type FROM PUBLIC;
REVOKE ALL ON TABLE sampling_type FROM atta;
GRANT ALL ON TABLE sampling_type TO atta;
GRANT ALL ON TABLE sampling_type TO postgres;
REVOKE ALL ON TABLE sex FROM PUBLIC;
REVOKE ALL ON TABLE sex FROM atta;
GRANT ALL ON TABLE sex TO atta;
GRANT ALL ON TABLE sex TO postgres;
REVOKE ALL ON TABLE site FROM PUBLIC;
REVOKE ALL ON TABLE site FROM atta;
GRANT ALL ON TABLE site TO atta;
GRANT ALL ON TABLE site TO postgres;
REVOKE ALL ON TABLE site_calculation_method FROM PUBLIC;
REVOKE ALL ON TABLE site_calculation_method FROM atta;
GRANT ALL ON TABLE site_calculation_method TO atta;
GRANT ALL ON TABLE site_calculation_method TO postgres;
REVOKE ALL ON TABLE site_coordinate FROM PUBLIC;
REVOKE ALL ON TABLE site_coordinate FROM atta;
GRANT ALL ON TABLE site_coordinate TO atta;
GRANT ALL ON TABLE site_coordinate TO PUBLIC;
REVOKE ALL ON TABLE species_record_stage_profile FROM PUBLIC;
REVOKE ALL ON TABLE species_record_stage_profile FROM atta;
GRANT ALL ON TABLE species_record_stage_profile TO atta;
GRANT ALL ON TABLE species_record_stage_profile TO postgres;
REVOKE ALL ON TABLE specimen FROM PUBLIC;
REVOKE ALL ON TABLE specimen FROM atta;
GRANT ALL ON TABLE specimen TO atta;
GRANT ALL ON TABLE specimen TO postgres;
REVOKE ALL ON TABLE specimen_annotation FROM PUBLIC;
REVOKE ALL ON TABLE specimen_annotation FROM atta;
GRANT ALL ON TABLE specimen_annotation TO atta;
GRANT ALL ON TABLE specimen_annotation TO postgres;
REVOKE ALL ON TABLE specimen_category FROM PUBLIC;
REVOKE ALL ON TABLE specimen_category FROM atta;
GRANT ALL ON TABLE specimen_category TO atta;
GRANT ALL ON TABLE specimen_category TO postgres;
REVOKE ALL ON TABLE specimen_description FROM PUBLIC;
REVOKE ALL ON TABLE specimen_description FROM atta;
GRANT ALL ON TABLE specimen_description TO atta;
GRANT ALL ON TABLE specimen_description TO postgres;
REVOKE ALL ON TABLE specimen_type FROM PUBLIC;
REVOKE ALL ON TABLE specimen_type FROM atta;
GRANT ALL ON TABLE specimen_type TO atta;
GRANT ALL ON TABLE specimen_type TO postgres;
REVOKE ALL ON TABLE specimen_variable FROM PUBLIC;
REVOKE ALL ON TABLE specimen_variable FROM atta;
GRANT ALL ON TABLE specimen_variable TO atta;
GRANT ALL ON TABLE specimen_variable TO postgres;
REVOKE ALL ON TABLE specimen_variable_value FROM PUBLIC;
REVOKE ALL ON TABLE specimen_variable_value FROM atta;
GRANT ALL ON TABLE specimen_variable_value TO atta;
GRANT ALL ON TABLE specimen_variable_value TO postgres;
REVOKE ALL ON TABLE stage_transition_date FROM PUBLIC;
REVOKE ALL ON TABLE stage_transition_date FROM atta;
GRANT ALL ON TABLE stage_transition_date TO atta;
GRANT ALL ON TABLE stage_transition_date TO postgres;
REVOKE ALL ON TABLE stage_transition_digraph FROM PUBLIC;
REVOKE ALL ON TABLE stage_transition_digraph FROM atta;
GRANT ALL ON TABLE stage_transition_digraph TO atta;
GRANT ALL ON TABLE stage_transition_digraph TO postgres;
REVOKE ALL ON TABLE storage_type FROM PUBLIC;
REVOKE ALL ON TABLE storage_type FROM atta;
GRANT ALL ON TABLE storage_type TO atta;
GRANT ALL ON TABLE storage_type TO postgres;
REVOKE ALL ON TABLE substrate FROM PUBLIC;
REVOKE ALL ON TABLE substrate FROM atta;
GRANT ALL ON TABLE substrate TO atta;
GRANT ALL ON TABLE substrate TO postgres;
REVOKE ALL ON TABLE system_module FROM PUBLIC;
REVOKE ALL ON TABLE system_module FROM atta;
GRANT ALL ON TABLE system_module TO atta;
GRANT ALL ON TABLE system_module TO postgres;
REVOKE ALL ON TABLE system_option FROM PUBLIC;
REVOKE ALL ON TABLE system_option FROM atta;
GRANT ALL ON TABLE system_option TO atta;
GRANT ALL ON TABLE system_option TO postgres;
REVOKE ALL ON TABLE system_option_type FROM PUBLIC;
REVOKE ALL ON TABLE system_option_type FROM atta;
GRANT ALL ON TABLE system_option_type TO atta;
GRANT ALL ON TABLE system_option_type TO postgres;
REVOKE ALL ON TABLE system_subsystem FROM PUBLIC;
REVOKE ALL ON TABLE system_subsystem FROM atta;
GRANT ALL ON TABLE system_subsystem TO atta;
GRANT ALL ON TABLE system_subsystem TO postgres;
REVOKE ALL ON TABLE system_user FROM PUBLIC;
REVOKE ALL ON TABLE system_user FROM atta;
GRANT ALL ON TABLE system_user TO atta;
GRANT ALL ON TABLE system_user TO postgres;
REVOKE ALL ON TABLE system_user_option FROM PUBLIC;
REVOKE ALL ON TABLE system_user_option FROM atta;
GRANT ALL ON TABLE system_user_option TO atta;
GRANT ALL ON TABLE system_user_option TO postgres;
REVOKE ALL ON TABLE system_user_type FROM PUBLIC;
REVOKE ALL ON TABLE system_user_type FROM atta;
GRANT ALL ON TABLE system_user_type TO atta;
GRANT ALL ON TABLE system_user_type TO postgres;
REVOKE ALL ON TABLE taxon FROM PUBLIC;
REVOKE ALL ON TABLE taxon FROM atta;
GRANT ALL ON TABLE taxon TO atta;
GRANT ALL ON TABLE taxon TO postgres;
REVOKE ALL ON TABLE taxon_author FROM PUBLIC;
REVOKE ALL ON TABLE taxon_author FROM atta;
GRANT ALL ON TABLE taxon_author TO atta;
GRANT ALL ON TABLE taxon_author TO postgres;
REVOKE ALL ON TABLE taxon_author_connector FROM PUBLIC;
REVOKE ALL ON TABLE taxon_author_connector FROM atta;
GRANT ALL ON TABLE taxon_author_connector TO atta;
GRANT ALL ON TABLE taxon_author_connector TO postgres;
REVOKE ALL ON TABLE taxon_category FROM PUBLIC;
REVOKE ALL ON TABLE taxon_category FROM atta;
GRANT ALL ON TABLE taxon_category TO atta;
GRANT ALL ON TABLE taxon_category TO postgres;
REVOKE ALL ON TABLE taxon_description FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description FROM atta;
GRANT ALL ON TABLE taxon_description TO atta;
GRANT ALL ON TABLE taxon_description TO postgres;
REVOKE ALL ON TABLE taxon_description_audience FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_audience FROM atta;
GRANT ALL ON TABLE taxon_description_audience TO atta;
GRANT ALL ON TABLE taxon_description_audience TO postgres;
REVOKE ALL ON TABLE taxon_description_category FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_category FROM atta;
GRANT ALL ON TABLE taxon_description_category TO atta;
GRANT ALL ON TABLE taxon_description_category TO postgres;
REVOKE ALL ON TABLE taxon_description_datatype FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_datatype FROM atta;
GRANT ALL ON TABLE taxon_description_datatype TO atta;
GRANT ALL ON TABLE taxon_description_datatype TO postgres;
REVOKE ALL ON TABLE taxon_description_element FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_element FROM atta;
GRANT ALL ON TABLE taxon_description_element TO atta;
GRANT ALL ON TABLE taxon_description_element TO postgres;
REVOKE ALL ON TABLE taxon_description_institution FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_institution FROM atta;
GRANT ALL ON TABLE taxon_description_institution TO atta;
GRANT ALL ON TABLE taxon_description_institution TO postgres;
REVOKE ALL ON TABLE taxon_description_record FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_record FROM atta;
GRANT ALL ON TABLE taxon_description_record TO atta;
GRANT ALL ON TABLE taxon_description_record TO postgres;
REVOKE ALL ON TABLE taxon_description_record_reference FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_record_reference FROM atta;
GRANT ALL ON TABLE taxon_description_record_reference TO atta;
GRANT ALL ON TABLE taxon_description_record_reference TO postgres;
REVOKE ALL ON TABLE taxon_description_stage FROM PUBLIC;
REVOKE ALL ON TABLE taxon_description_stage FROM atta;
GRANT ALL ON TABLE taxon_description_stage TO atta;
GRANT ALL ON TABLE taxon_description_stage TO postgres;
REVOKE ALL ON TABLE taxon_name_history FROM PUBLIC;
REVOKE ALL ON TABLE taxon_name_history FROM atta;
GRANT ALL ON TABLE taxon_name_history TO atta;
GRANT ALL ON TABLE taxon_name_history TO postgres;
REVOKE ALL ON TABLE taxon_nomenclatural_group FROM PUBLIC;
REVOKE ALL ON TABLE taxon_nomenclatural_group FROM atta;
GRANT ALL ON TABLE taxon_nomenclatural_group TO atta;
GRANT ALL ON TABLE taxon_nomenclatural_group TO postgres;
REVOKE ALL ON TABLE taxon_reference FROM PUBLIC;
REVOKE ALL ON TABLE taxon_reference FROM atta;
GRANT ALL ON TABLE taxon_reference TO atta;
GRANT ALL ON TABLE taxon_reference TO postgres;
REVOKE ALL ON TABLE taxonomical_hierarchy FROM PUBLIC;
REVOKE ALL ON TABLE taxonomical_hierarchy FROM atta;
GRANT ALL ON TABLE taxonomical_hierarchy TO atta;
GRANT ALL ON TABLE taxonomical_hierarchy TO postgres;
REVOKE ALL ON TABLE taxonomical_range FROM PUBLIC;
REVOKE ALL ON TABLE taxonomical_range FROM atta;
GRANT ALL ON TABLE taxonomical_range TO atta;
GRANT ALL ON TABLE taxonomical_range TO postgres;
REVOKE ALL ON TABLE topographic_sheet FROM PUBLIC;
REVOKE ALL ON TABLE topographic_sheet FROM atta;
GRANT ALL ON TABLE topographic_sheet TO atta;
GRANT ALL ON TABLE topographic_sheet TO PUBLIC;
REVOKE ALL ON TABLE transacted_specimen FROM PUBLIC;
REVOKE ALL ON TABLE transacted_specimen FROM atta;
GRANT ALL ON TABLE transacted_specimen TO atta;
GRANT ALL ON TABLE transacted_specimen TO postgres;
REVOKE ALL ON TABLE transacted_specimen_status FROM PUBLIC;
REVOKE ALL ON TABLE transacted_specimen_status FROM atta;
GRANT ALL ON TABLE transacted_specimen_status TO atta;
GRANT ALL ON TABLE transacted_specimen_status TO postgres;
REVOKE ALL ON TABLE "transaction" FROM PUBLIC;
REVOKE ALL ON TABLE "transaction" FROM atta;
GRANT ALL ON TABLE "transaction" TO atta;
GRANT ALL ON TABLE "transaction" TO postgres;
REVOKE ALL ON TABLE transaction_type FROM PUBLIC;
REVOKE ALL ON TABLE transaction_type FROM atta;
GRANT ALL ON TABLE transaction_type TO atta;
GRANT ALL ON TABLE transaction_type TO postgres;
REVOKE ALL ON TABLE type_specimen FROM PUBLIC;
REVOKE ALL ON TABLE type_specimen FROM atta;
GRANT ALL ON TABLE type_specimen TO atta;
GRANT ALL ON TABLE type_specimen TO postgres;
REVOKE ALL ON TABLE type_specimen_type FROM PUBLIC;
REVOKE ALL ON TABLE type_specimen_type FROM atta;
GRANT ALL ON TABLE type_specimen_type TO atta;
GRANT ALL ON TABLE type_specimen_type TO postgres;
REVOKE ALL ON TABLE versant FROM PUBLIC;
REVOKE ALL ON TABLE versant FROM atta;
GRANT ALL ON TABLE versant TO atta;
GRANT ALL ON TABLE versant TO PUBLIC;
SET check_function_bodies = false;
CREATE TABLE atta.dwc_category (
    category_id numeric NOT NULL,
    category_name character varying(150) NOT NULL,
    category_keyword character varying(150) NOT NULL
);
ALTER TABLE atta.dwc_category OWNER TO postgres;
ALTER TABLE ONLY atta.dwc_category ADD CONSTRAINT dwc_categories_pk PRIMARY KEY (category_id);
REVOKE ALL ON TABLE atta.dwc_category FROM PUBLIC;
REVOKE ALL ON TABLE atta.dwc_category FROM postgres;
GRANT ALL ON TABLE atta.dwc_category TO postgres;
GRANT ALL ON TABLE atta.dwc_category TO atta;
SET search_path = atta, pg_catalog;
CREATE TABLE dwc_element (
    element_id numeric NOT NULL,
    element_name character varying(150) NOT NULL,
    element_keyword character varying NOT NULL,
    element_category_id numeric NOT NULL,
    element_required character varying(1) NOT NULL
);
ALTER TABLE atta.dwc_element OWNER TO postgres;

ALTER TABLE ONLY dwc_element
    ADD CONSTRAINT dwc_elements_pk PRIMARY KEY (element_id);
ALTER TABLE ONLY dwc_element
    ADD CONSTRAINT dwc_elements_fk FOREIGN KEY (element_category_id) REFERENCES dwc_category(category_id);
REVOKE ALL ON TABLE dwc_element FROM PUBLIC;
REVOKE ALL ON TABLE dwc_element FROM postgres;
GRANT ALL ON TABLE dwc_element TO postgres;
GRANT ALL ON TABLE dwc_element TO atta;
CREATE TABLE atta.dwc_snapshot
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
ALTER TABLE atta.dwc_snapshot OWNER TO atta;
CREATE TABLE pli_element (
    element_id numeric NOT NULL,
    element_name character varying(150) NOT NULL,
    element_keyword character varying NOT NULL,
    element_required character varying(1) NOT NULL
);
ALTER TABLE atta.pli_element OWNER TO postgres;

ALTER TABLE ONLY pli_element ADD CONSTRAINT pli_elements_pk PRIMARY KEY (element_id);
REVOKE ALL ON TABLE pli_element FROM PUBLIC;
REVOKE ALL ON TABLE pli_element FROM postgres;
GRANT ALL ON TABLE pli_element TO postgres;
GRANT ALL ON TABLE pli_element TO atta;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET default_tablespace = '';
SET default_with_oids = false;

------------------- update ---------------------

DROP LANGUAGE IF EXISTS 'plpgsql';
CREATE LANGUAGE 'plpgsql';

-- 2009.08.12
--Cambia el tipo de la columna catalog_number a varhcar(100) pues antes era numeric
-- y este dato pordria contenter caracteres alfanumericos
alter table atta.specimen alter column catalog_number type varchar(100);

-- 2009.08.12
-- Borrar el sex_id de la tabla especimen pues se manejan en una tabla separada
-- por el tema de los "especimenenes" con varios individuos
alter table atta.specimen drop column sex_id;

-- 2009.08.12
-- Borrar el life_stage_id de la tabla especimen pues se manejan en una tabla separada
-- por el tema de los "especimenenes" con varios individuos
alter table atta.specimen drop column life_stage_id;

-- 2009.08.13
-- Cambia el tipo de la columna discarded a numeric pues antes era un varchar(1)
-- y este dato en realidad es un boolean (donde 1 es true y 0 es false)
alter table atta.specimen add column discarded_tmp numeric not null default 0;
update atta.specimen set discarded_tmp =1 where discarded='1';
alter table atta.specimen drop column discarded;
alter table atta.specimen rename discarded_tmp  to discarded;

-- 2009.08.14
-- En elfoque actual de mapeos no se utiliza la columna obj_version en la tablas:
-- specimen_life_stage_sex, specimen
alter table atta.specimen_life_stage_sex drop column obj_version;
alter table atta.specimen drop column obj_version;

alter table atta.identifier drop column obj_version;
alter table atta.identification drop column obj_version;
alter table atta.identifier_history drop column obj_version;
alter table atta.identification_history drop column obj_version;

-- Secuence para el historico de identificaciones
CREATE SEQUENCE atta.identification_history_seq;
ALTER TABLE atta.identification_history_seq OWNER TO atta;

-- Secuence para el historico de identificadores
CREATE SEQUENCE atta.identifier_history_seq;
ALTER TABLE atta.identifier_history_seq OWNER TO atta;

ALTER TABLE atta.identification_history  ALTER COLUMN identification_history_id SET DEFAULT nextval('atta.identification_history_seq'::regclass);
ALTER TABLE atta.identifier_history  ALTER COLUMN identifier_history_id SET DEFAULT nextval('atta.identifier_history_seq'::regclass);

--2009.09.01 esmata
-- Eliminando la columna obj_version de la tabla atta.gathering_observation
alter table atta.gathering_observation drop column obj_version;
--2009.09.01 esmata
-- Eliminando la columna obj_version de la tabla atta.protocol_attribute
alter table atta.protocol_attribute drop column obj_version;

--2009.09.01 esmata
-- Nuevo secuence para la tabla de gathering_observation
CREATE SEQUENCE atta.gathering_observation_seq;
ALTER TABLE atta.gathering_observation_seq OWNER TO atta;
-- Asignar dicho secuence al atributo correspondiente de la tabla
ALTER TABLE atta.gathering_observation ALTER COLUMN gathering_observation_id SET DEFAULT nextval('atta.gathering_observation_seq'::regclass);

--2009.09.02 esmata
-- Eliminando la columna obj_version de la tabla atta.collection_protocol
alter table atta.collection_protocol drop column obj_version;
-- Eliminando la columna obj_version de la tabla atta.collector_observer
alter table atta.collector_observer drop column obj_version;
-- Eliminando la columna obj_version de la tabla atta.gathering_observation_project
alter table atta.gathering_observation_project drop column obj_version;
-- Eliminando la columna obj_version de la tabla atta.gathering_observation_collection
alter table atta.gathering_observation_collection drop column obj_version;

--2009.09.07 esmata
-- Eliminando la columna obj_version de la tabla atta.morphological_description
alter table atta.morphological_description drop column obj_version;
-- Eliminando la columna obj_version de la tabla atta.gathering_observation_detail
alter table atta.gathering_observation_detail drop column obj_version;
-- Nuevo secuence para la tabla atta.morphological_description
CREATE SEQUENCE atta.morphological_description_seq;
ALTER TABLE atta.morphological_description_seq OWNER TO atta;
ALTER TABLE atta.morphological_description  ALTER COLUMN morphological_description_id SET DEFAULT nextval('atta.morphological_description_seq'::regclass);
-- Nuevo secuence para la tabla atta.gathering_observation_detail
CREATE SEQUENCE atta.gathering_observation_detail_seq;
ALTER TABLE atta.gathering_observation_detail_seq OWNER TO atta;
ALTER TABLE atta.gathering_observation_detail  ALTER COLUMN gathering_observation_detail_id SET DEFAULT nextval('atta.gathering_observation_detail_seq'::regclass);

--2009.09.21 esmata
-- Eliminando la columna obj_version de la tabla atta.taxon_category
alter table atta.taxon_category drop column obj_version;

--2009.09.22 esmata
-- Eliminando la columna obj_version de la tabla atta.system_user
alter table atta.system_user drop column obj_version;
-- Eliminando la columna obj_version de la tabla atta.system_user_type
alter table atta.system_user_type drop column obj_version;

--2009.09.22 jgutierrez
-- Nuevo secuence para la tabla atta.gathering_observation_detail
create sequence atta.collection_seq;
alter table atta.collection_seq owner to atta;
alter table atta.collection  alter column collection_id set default nextval('atta.collection_seq'::regclass);
alter table atta.collection drop column obj_version;

--2009.09.23 esmata
-- Eliminando la columna obj_version de la tabla atta.nomenclatural_group
alter table atta.nomenclatural_group drop column obj_version;
-- Eliminando la columna obj_version de la tabla atta.user_nomenclatural_group
alter table atta.user_nomenclatural_group drop column obj_version;
-- Eliminando la columna obj_version de la tabla atta.user_taxon
alter table atta.user_taxon drop column obj_version;

--2009.09.24 esmata
-- Nuevo secuence para la tabla atta.system_user
CREATE SEQUENCE atta.system_user_seq   INCREMENT 1  MINVALUE 1  MAXVALUE 9223372036854775807  START 72  CACHE 1;
ALTER TABLE atta.system_user_seq OWNER TO atta;
ALTER TABLE atta.system_user ALTER COLUMN user_id SET DEFAULT nextval('atta.system_user_seq '::regclass);

--2009.09.24 jgutierrez
-- Nuevo secuence para la tabla atta.gathering_observation_method
create sequence atta.gathering_observation_method_seq;
alter table atta.gathering_observation_method_seq OWNER TO atta;
alter table atta.gathering_observation_method alter column gathering_observation_method_id set default nextval('atta.gathering_observation_method_seq'::regclass);
alter table atta.gathering_observation_method drop column obj_version;
--2009.09.24 jgutierrez
-- Nuevo secuence para la tabla atta.specimen_category
create sequence atta.specimen_category_seq;
alter table atta.specimen_category_seq OWNER TO atta;
alter table atta.specimen_category alter column specimen_category_id set default nextval('atta.specimen_category_seq'::regclass);
alter table atta.specimen_category drop column obj_version;
--2009.09.24 jgutierrez
-- Nuevo secuence para la tabla atta.specimen_type
create sequence atta.specimen_type_seq;
alter table atta.specimen_type_seq OWNER TO atta;
alter table atta.specimen_type alter column specimen_type_id set default nextval('atta.specimen_type_seq'::regclass);
alter table atta.specimen_type drop column obj_version;
--2009.09.24 jgutierrez
-- Nuevo secuence para la tabla atta.origin
create sequence atta.origin_seq;
alter table atta.origin_seq OWNER TO atta;
alter table atta.origin alter column origin_id set default nextval('atta.origin_seq'::regclass);
alter table atta.origin drop column obj_version;
--2009.09.24 jgutierrez
-- Nuevo secuence para la tabla atta.preservation_medium
create sequence atta.preservation_medium_seq;
alter table atta.preservation_medium_seq OWNER TO atta;
alter table atta.preservation_medium alter column preservation_medium_id set default nextval('atta.preservation_medium_seq'::regclass);
alter table atta.preservation_medium drop column obj_version;
--2009.09.24 jgutierrez
-- Nuevo secuence para la tabla atta.storage_type
create sequence atta.storage_type_seq;
alter table atta.storage_type_seq OWNER TO atta;
alter table atta.storage_type alter column storage_type_id set default nextval('atta.storage_type_seq'::regclass);
alter table atta.storage_type drop column obj_version;
--2009.09.24 jgutierrez
-- Nuevo secuence para la tabla atta.life_stage
create sequence atta.life_stage_seq;
alter table atta.life_stage_seq OWNER TO atta;
alter table atta.life_stage alter column life_stage_id set default nextval('atta.life_stage_seq'::regclass);
alter table atta.life_stage drop column obj_version;
--2009.09.24 jgutierrez
-- Nuevo secuence para la tabla atta.sex
create sequence atta.sex_seq;
alter table atta.sex_seq OWNER TO atta;
alter table atta.sex alter column sex_id set default nextval('atta.sex_seq'::regclass);
alter table atta.sex drop column obj_version;
--2009.09.24 jgutierrez
-- Nuevo secuence para la tabla atta.substrate
create sequence atta.substrate_seq;
alter table atta.substrate_seq OWNER TO atta;
alter table atta.substrate alter column substrate_id set default nextval('atta.substrate_seq'::regclass);
alter table atta.substrate drop column obj_version;
--2009.09.24 jgutierrez
-- Nuevo secuence para la tabla atta.life_form
create sequence atta.life_form_seq;
alter table atta.life_form_seq OWNER TO atta;
alter table atta.life_form alter column life_form_id set default nextval('atta.life_form_seq'::regclass);
alter table atta.life_form drop column obj_version;
--2009.09.24 jgutierrez
-- Nuevo secuence para la tabla atta.extraction_type
create sequence atta.extraction_type_seq;
alter table atta.extraction_type_seq OWNER TO atta;
alter table atta.extraction_type alter column extraction_type_id set default nextval('atta.extraction_type_seq'::regclass);
alter table atta.extraction_type drop column obj_version;
--2009.09.24 jgutierrez
-- Nuevo secuence para la tabla atta.exposition
create sequence atta.exposition_seq;
alter table atta.exposition_seq OWNER TO atta;
alter table atta.exposition alter column exposition_id set default nextval('atta.exposition_seq'::regclass);
alter table atta.exposition drop column obj_version;

--2009.09.29 esmata
-- Nuevo secuence para la tabla atta.institution
create sequence atta.institution_seq;
alter table atta.institution_seq OWNER TO atta;
alter table atta.institution alter column institution_id set default nextval('atta.institution_seq'::regclass);
alter table atta.institution drop column obj_version;

-- *******************************************   Actualizar los secuences con el valor maximo + 1   ************************************************
select setval('atta.identification_history_seq',cast(max(identification_history_id) as bigint)+1) from atta.identification_history;
select setval('atta.identifier_history_seq',cast(max(identifier_history_id) as bigint)+1) from atta.identifier_history;
select setval('atta.gathering_observation_seq',cast(max(gathering_observation_id) as bigint)+1) from atta.gathering_observation;
select setval('atta.morphological_description_seq',cast(max(morphological_description_id) as bigint)+1) from atta.morphological_description;
select setval('atta.gathering_observation_detail_seq',cast(max(gathering_observation_detail_id) as bigint)+1) from atta.gathering_observation_detail;
select setval('atta.system_user_seq',cast(max(user_id) as bigint)+1) from atta.system_user;
select setval('atta.collection_seq',cast(max(collection_id) as bigint)+1) from atta.collection;
select setval('atta.gathering_observation_method_seq',cast(max(gathering_observation_method_id) as bigint)+1) from atta.gathering_observation_method;
select setval('atta.specimen_category_seq',cast(max(specimen_category_id) as bigint)+1) from atta.specimen_category;
select setval('atta.specimen_type_seq',cast(max(specimen_type_id) as bigint)+1) from atta.specimen_type;
select setval('atta.origin_seq',cast(max(origin_id) as bigint)+1) from atta.origin;
select setval('atta.storage_type_seq',cast(max(storage_type_id) as bigint)+1) from atta.storage_type;
select setval('atta.life_stage_seq',cast(max(life_stage_id) as bigint)+1) from atta.life_stage;
select setval('atta.sex_seq',cast(max(sex_id) as bigint)+1) from atta.sex;
select setval('atta.substrate_seq',cast(max(substrate_id) as bigint)+1) from atta.substrate;
select setval('atta.life_form_seq',cast(max(life_form_id) as bigint)+1) from atta.life_form;
select setval('atta.extraction_type_seq',cast(max(extraction_type_id) as bigint)+1) from atta.extraction_type;
select setval('atta.exposition_seq',cast(max(exposition_id) as bigint)+1) from atta.exposition;
select setval('atta.preservation_medium_seq',cast(max(preservation_medium_id) as bigint)+1) from atta.preservation_medium;
select setval('atta.institution_seq',cast(max(institution_id) as bigint)+1) from atta.institution;
-- *************************************************************************************************************************************************

--2009.09.29 herson
-- Nuevo sequence para la tabla atta.especimen
create sequence atta.specimen_seq;
alter table atta.specimen_seq OWNER TO atta;
alter table atta.specimen alter column specimen_id set default nextval('atta.specimen_seq'::regclass);
SELECT setval('atta.specimen_seq', cast(max(specimen_id) as bigint)+1) from atta.specimen;

--2009.09.29 james
-- Eliminando el obj_version de la tabla list_table_collection
alter table atta.list_table_collection drop column obj_version;

--2009.10.02 herson
-- Eliminando el obj_version de la tabla specimen_life_form
ALTER TABLE atta.specimen_life_form DROP COLUMN obj_version;

--2009.10.05 esmata
-- Eliminando el obj_version de la tabla atta.audience
ALTER TABLE atta.audience DROP COLUMN obj_version;
-- Eliminando el obj_version de la tabla atta.profile
ALTER TABLE atta.profile DROP COLUMN obj_version;
-- Eliminando el obj_version de la tabla atta.person_profile
ALTER TABLE atta.person_profile DROP COLUMN obj_version;
-- Nuevo sequence para la tabla atta.audience
create sequence atta.audience_seq;
alter table atta.audience_seq OWNER TO atta;
alter table atta.audience alter column audience_id set default nextval('atta.audience_seq'::regclass);
SELECT setval('atta.audience_seq', cast(max(audience_id) as bigint)+1) from atta.audience;
-- Nuevo sequence para la tabla atta.profile
create sequence atta.profile_seq;
alter table atta.profile_seq OWNER TO atta;
alter table atta.profile alter column profile_id set default nextval('atta.profile_seq'::regclass);
SELECT setval('atta.profile_seq', cast(max(profile_id) as bigint)+1) from atta.profile;

--2009.10.06 herson
ALTER TABLE atta.specimen
ALTER COLUMN collection_id SET NOT NULL;

--2009.10.07 esmata
-- Eliminando el obj_version de la tabla atta.person
ALTER TABLE atta.person DROP COLUMN obj_version;
-- Nuevo sequence para la tabla atta.person
create sequence atta.person_seq;
alter table atta.person_seq OWNER TO atta;
alter table atta.person alter column person_id set default nextval('atta.person_seq'::regclass);
SELECT setval('atta.person_seq', cast(max(person_id) as bigint)+1) from atta.person ;

--2009.10.08
-- Eliminando el obj_version de la tabla atta.person_institution
ALTER TABLE atta.person_institution DROP COLUMN obj_version;

--2009.10.13
-- Eliminando el obj_version de la tabla atta.taxon_description
ALTER TABLE atta.taxon_description DROP COLUMN obj_version;
-- Eliminando el obj_version de la tabla atta.taxon_description_stage
ALTER TABLE atta.taxon_description_stage DROP COLUMN obj_version;

--2009.10.14
-- Nuevo sequence para la tabla atta.taxon_description_stage
create sequence atta.taxon_description_stage_seq;
alter table atta.taxon_description_stage_seq OWNER TO atta;
alter table atta.taxon_description_stage alter column taxon_description_stage_id set default nextval('atta.taxon_description_stage_seq'::regclass);
SELECT setval('atta.taxon_description_stage_seq', cast(max(taxon_description_stage_id) as bigint)+1) from atta.taxon_description_stage ;

--2009.10.15
-- Eliminando el obj_version de la tabla atta."language"
ALTER TABLE atta."language" DROP COLUMN obj_version;
-- Eliminando el obj_version de la tabla atta.person_institution
ALTER TABLE atta.concept DROP COLUMN obj_version;

--2009.10.19
-- Eliminando el obj_version de la tabla atta.taxon_description_audience
ALTER TABLE atta.taxon_description_audience DROP COLUMN obj_version;
-- Eliminando el obj_version de la atta.taxon_description_institution
ALTER TABLE atta.taxon_description_institution DROP COLUMN obj_version;
-- Eliminando el obj_version de la atta.taxon_description_person_profile
ALTER TABLE atta.taxon_description_person_profile DROP COLUMN obj_version;

--2009.10.21 herson
-- Obj_version
ALTER TABLE atta.taxon_description_element DROP COLUMN obj_version;
ALTER TABLE atta.taxon_description_category DROP COLUMN obj_version;
ALTER TABLE atta.taxon_description_datatype DROP COLUMN obj_version;

--2009.10.21 esmata
ALTER TABLE atta.taxon_description_record_reference DROP COLUMN obj_version;
ALTER TABLE atta.taxon_description_record DROP COLUMN obj_version;
ALTER TABLE atta.reference DROP COLUMN obj_version;
ALTER TABLE atta.reference_type DROP COLUMN obj_version;
ALTER TABLE atta.interaction_type DROP COLUMN obj_version;
ALTER TABLE atta.geographic_catalogue DROP COLUMN obj_version;
ALTER TABLE atta.geographic_entity DROP COLUMN obj_version;

--2009.10.28 esmata
-- Nuevo sequence para la tabla atta.taxon_description_record
create sequence atta.taxon_description_record_seq;
alter table atta.taxon_description_record_seq OWNER TO atta;
alter table atta.taxon_description_record alter column taxon_description_record_id set default nextval('atta.taxon_description_record_seq'::regclass);
SELECT setval('atta.taxon_description_record_seq', cast(max(taxon_description_record_id) as bigint)+1) from atta.taxon_description_record ;
-- Nuevo sequence para la tabla atta.taxon_description_record
create sequence atta.taxon_description_element_seq;
alter table atta.taxon_description_element_seq OWNER TO atta;
alter table atta.taxon_description_element alter column taxon_description_element_id set default nextval('atta.taxon_description_element_seq'::regclass);
SELECT setval('atta.taxon_description_element_seq', cast(max(taxon_description_element_id) as bigint)+1) from atta.taxon_description_element ;

--2009.11.04 esmata
-- Cambiando valor "name" por "value", esto para el correcto funcionamiento del modulo de especies
UPDATE atta.taxon_description_element SET main_field_name ='value' WHERE taxon_description_element_id=44;

--2009.11.06 esmata
-- Agregando valor default a la tabla atta.geographic_catalogue
delete from atta.geographic_catalogue;

--2009.11.16 esmata
-- Obj_version
ALTER TABLE atta.geographic_layer DROP COLUMN obj_version;

--2009.11.17 esmata
-- Nuevo sequence para la tabla atta.country
create sequence atta.country_seq;
alter table atta.country_seq OWNER TO atta;
alter table atta.country alter column country_id set default nextval('atta.country_seq'::regclass);
SELECT setval('atta.country_seq', cast(max(country_id) as bigint)+1) from atta.country ;
-- Obj_version
ALTER TABLE atta.country DROP COLUMN obj_version;

-- Nuevo sequence para la tabla atta.province
create sequence atta.province_seq;
alter table atta.province_seq OWNER TO atta;
alter table atta.province alter column province_id set default nextval('atta.province_seq'::regclass);
SELECT setval('atta.province_seq', cast(max(province_id) as bigint)+1) from atta.province;
-- Obj_version
ALTER TABLE atta.province  DROP COLUMN obj_version;

--2009.11.18 esmata
-- Obj_version
ALTER TABLE atta.site  DROP COLUMN obj_version;
-- Obj_version
ALTER TABLE atta.site_calculation_method  DROP COLUMN obj_version;
-- Obj_version
ALTER TABLE atta.site_coordinate  DROP COLUMN obj_version;
-- Nuevo sequence para la tabla atta.site
create sequence atta.site_seq;
alter table atta.site_seq OWNER TO atta;
alter table atta.site alter column site_id set default nextval('atta.site_seq'::regclass);
SELECT setval('atta.site_seq', cast(max(site_id) as bigint)+1) from atta.site;
-- Nuevo sequence para la tabla atta.site_coordinate
create sequence atta.site_coordinate_seq;
alter table atta.site_coordinate_seq OWNER TO atta;
alter table atta.site_coordinate alter column site_coordinate_id set default nextval('atta.site_coordinate_seq'::regclass);
SELECT setval('atta.site_coordinate_seq', cast(max(site_coordinate_id) as bigint)+1) from atta.site_coordinate;

-- 2009.11.19 herson
ALTER TABLE atta.nomenclatural_group_region DROP COLUMN obj_version;
ALTER TABLE atta.taxon_nomenclatural_group DROP COLUMN obj_version;

--2009.11.19 esmata
ALTER TABLE atta.feature_type DROP COLUMN obj_version;
ALTER TABLE atta.projection DROP COLUMN obj_version;

-- 2009.11.19 herson
ALTER TABLE atta.region DROP COLUMN obj_version;

--2009.11.20 esmata
ALTER TABLE atta.georeferenced_site DROP COLUMN obj_version;

-- 2009.11.21
ALTER TABLE atta.taxon DROP COLUMN obj_version;

-- Nuevo sequence para la tabla atta.site
create sequence atta.taxon_seq;
alter table atta.taxon_seq OWNER TO atta;
alter table atta.taxon alter column taxon_id set default nextval('atta.taxon_seq'::regclass);
SELECT setval('atta.taxon_seq', cast(max(taxon_id) as bigint)+1) from atta.taxon;

-- 2009-11-24 herson
create sequence atta.nomenclatural_group_seq;
alter table atta.nomenclatural_group_seq OWNER TO atta;
alter table atta.nomenclatural_group alter column nomenclatural_group_id set default nextval('atta.nomenclatural_group_seq'::regclass);
SELECT setval('atta.nomenclatural_group_seq', cast(max(nomenclatural_group_id) as bigint)+1) from atta.nomenclatural_group;


update atta.taxon
	set ancestor_id = (select cast(max(taxon_id) as bigint) from atta.taxon)
	where taxonomical_range_id = 23;

alter table atta.dwc_snapshot add column catalognumbernumeric  numeric;
alter table atta.dwc_snapshot add column identifiedby varchar;
alter table atta.dwc_snapshot add column dateidentified timestamp;
alter table atta.dwc_snapshot add column collectornumber varchar;
alter table atta.dwc_snapshot add column fieldnumber  varchar;
alter table atta.dwc_snapshot add column fieldnotes varchar;
alter table atta.dwc_snapshot add column verbatimcollectingdate varchar;
alter table atta.dwc_snapshot add column verbatimelevation double precision;
alter table atta.dwc_snapshot add column preparations varchar;
alter table atta.dwc_snapshot add column typestatus varchar;
alter table atta.dwc_snapshot add column othercatalognumbers varchar;
alter table atta.dwc_snapshot add column disposition varchar;
alter table atta.dwc_snapshot add column individualcount numeric;
alter table atta.dwc_snapshot add column decimallatitude varchar;
alter table atta.dwc_snapshot add column decimallongitude varchar;
alter table atta.dwc_snapshot add column geodeticdatum varchar;
alter table atta.dwc_snapshot add column coordinateuncertaintyinmeters varchar;
alter table atta.dwc_snapshot add column pointradiusspatialfit decimal;
alter table atta.dwc_snapshot add column verbatimcoordinates varchar;
alter table atta.dwc_snapshot add column verbatimlatitude varchar;
alter table atta.dwc_snapshot add column verbatimlongitude varchar;
alter table atta.dwc_snapshot add column verbatimcoordinatesystem varchar;
alter table atta.dwc_snapshot add column georeferenceprotocol varchar;
alter table atta.dwc_snapshot add column georeferencesources varchar;
alter table atta.dwc_snapshot add column georeferenceverificationstatus varchar;
alter table atta.dwc_snapshot add column georeferenceremarks varchar;
alter table atta.dwc_snapshot add column footprintwkt varchar;
alter table atta.dwc_snapshot add column footprintspatialfit  decimal;

                --------------------------------------------------------------------------------
                -- Hata aquí quedó la versión para Panamá  --
                --------------------------------------------------------------------------------

--2010.01.18 esmata
-- Eliminar la tabla atta.pli_element
drop table atta.pli_element;

--2010.01.18 esmata
-- Crear tabla plinian_core_flat (Tabla principal para generar el snapshot plinian)
Create table atta.plinian_core_flat
   (GlobalUniqueIdentifier varchar,
    ScientificName varchar,
    InstitutionCode varchar,
    DateLastModified timestamp,
    TaxonRecordID varchar,
    Language varchar,
    Creators  varchar,
    Distribution varchar,
    Abstract varchar,
    KingdomTaxon varchar,
    PhylumTaxon varchar,
    ClassTaxon varchar,
    OrderTaxon varchar,
    FamilyTaxon varchar,
    GenusTaxon varchar,
    Synonyms varchar,
    AuthorYearOfScientificName varchar,
    SpeciesPublicationReference varchar,
    CommonNames varchar,
    Typification varchar,
    Contributors varchar,
    DateCreated timestamp,
    Habit varchar,
    LifeCycle varchar,
    Reproduction varchar,
    AnnualCycle varchar,
    ScientificDescription varchar,
    BriefDescription varchar,
    Feeding varchar,
    Behavior varchar,
    Interactions varchar,
    ChromosomicNumberN varchar,
    MolecularData varchar,
    PopulationBiology varchar,
    ThreatStatus varchar,
    Legislation varchar,
    Habitat varchar,
    Territory varchar,
    Endemicity varchar,
    TheUses varchar,
    TheManagement varchar,
    Folklore varchar,
    TheReferences varchar,
    UnstructuredDocumentation varchar,
    OtherInformationSources varchar,
    Papers varchar,
    IdentificationKeys varchar,
    MigratoryData varchar,
    EcologicalSignificance varchar,
    UnstructuredNaturalHistory varchar,
    InvasivenessData  varchar,
    TargetAudiences  varchar,
    Version  varchar,
    URLImage1  varchar,
    CaptionImage1  varchar,
    URLImage2  varchar,
    CaptionImage2  varchar,
    URLImage3  varchar,
    CaptionImage3  varchar,
    PRIMARY KEY ( GlobalUniqueIdentifier));
ALTER TABLE atta.plinian_core_flat OWNER TO atta;

--2010.01.18 esmata
-- Tabla para definir los elementos del standard plinian core
CREATE TABLE atta.plic_element (
    element_id numeric NOT NULL,
    element_name character varying(150) NOT NULL,
    element_keyword character varying NOT NULL,
    element_required character varying(1) NOT NULL
);
ALTER TABLE atta.plic_element OWNER TO atta;
ALTER TABLE ONLY atta.plic_element ADD CONSTRAINT plic_elements_pk PRIMARY KEY (element_id);

--2010.01.18 esmata
-- Crear tabla para generar el snapshot de plinian core
Create table atta.plic_snapshot
   (GlobalUniqueIdentifier varchar,
    ScientificName varchar,
    InstitutionCode varchar,
    DateLastModified timestamp,
    TaxonRecordID varchar,
    Language varchar,
    Creators  varchar,
    Distribution varchar,
    Abstract varchar,
    KingdomTaxon varchar,
    PhylumTaxon varchar,
    ClassTaxon varchar,
    OrderTaxon varchar,
    FamilyTaxon varchar,
    GenusTaxon varchar,
    Synonyms varchar,
    AuthorYearOfScientificName varchar,
    SpeciesPublicationReference varchar,
    CommonNames varchar,
    Typification varchar,
    Contributors varchar,
    DateCreated timestamp,
    Habit varchar,
    LifeCycle varchar,
    Reproduction varchar,
    AnnualCycle varchar,
    ScientificDescription varchar,
    BriefDescription varchar,
    Feeding varchar,
    Behavior varchar,
    Interactions varchar,
    ChromosomicNumberN varchar,
    MolecularData varchar,
    PopulationBiology varchar,
    ThreatStatus varchar,
    Legislation varchar,
    Habitat varchar,
    Territory varchar,
    Endemicity varchar,
    TheUses varchar,
    TheManagement varchar,
    Folklore varchar,
    TheReferences varchar,
    UnstructuredDocumentation varchar,
    OtherInformationSources varchar,
    Papers varchar,
    IdentificationKeys varchar,
    MigratoryData varchar,
    EcologicalSignificance varchar,
    UnstructuredNaturalHistory varchar,
    InvasivenessData  varchar,
    TargetAudiences  varchar,
    Version  varchar,
    URLImage1  varchar,
    CaptionImage1  varchar,
    URLImage2  varchar,
    CaptionImage2  varchar,
    URLImage3  varchar,
    CaptionImage3  varchar,
    PRIMARY KEY ( GlobalUniqueIdentifier));
ALTER TABLE atta.plic_snapshot OWNER TO atta;


--2010.01.18 esmata
-- Update para que funcione correctamente la generacion del snapshot de plinian core
update atta.taxon_description_category set standard_concept = 'Interactions' where taxon_description_category_id = 17;
update atta.taxon_description_category set standard_concept = 'Distribution' where taxon_description_category_id = 29;
update atta.taxon_description_category set standard_concept = 'Distribution' where taxon_description_category_id = 30;
update atta.taxon_description_category set standard_concept = 'Abstract' where taxon_description_category_id = 67;
update atta.taxon_description_category set standard_concept = 'Legislation' where taxon_description_category_id = 43;
update atta.taxon_description_category set standard_concept = 'Legislation' where taxon_description_category_id = 44;
update atta.taxon_description_category set standard_concept = 'Endemicity' where taxon_description_category_id = 33;
update atta.taxon_description_category set standard_concept = 'Endemicity' where taxon_description_category_id = 32;

                    -------------------------------------------------------------
                    -- Required functions to create the plinian core snapshot ---
                    -------------------------------------------------------------
--2010.03.18 esmata
create or replace function atta.taxon_description_audience_list (arg_taxon_id NUMERIC, arg_taxon_description_sequence NUMERIC,
                                       arg_separator TEXT) returns text as '
DECLARE

--Fetch var
aAudienceID numeric;
aName text;

-- Result string
aAudienceList text;

taxonDescAudience CURSOR IS
   select  a.audience_id, a.name
      from atta.taxon_description_audience tda, atta.audience a
      where tda.audience_id = a.audience_id and
            tda.taxon_id = arg_taxon_id
 and
            tda.taxon_description_sequence = arg_taxon_description_sequence

      order by  a.name;


BEGIN
   -- Procedure Name: taxon_description_audience_list


   -- Retruns a taxon description audience list.
   -- Created to be use during the generation of the Plinian Core snapshot.
   -- Revisión History:
   --   December 16,  2009 - Maria  Mora
   -- Arguments (input / output):
   --    arg_taxon_id NUMBER,                    Taxon identifier
   --    arg_taxon_description_sequence NUMBER   Species record version
   --    arg_separator                           Element separator

   aAudienceList = '''';

   OPEN taxonDescAudience ;

   FETCH taxonDescAudience INTO aAudienceID, aName ;

   WHILE FOUND LOOP

     IF aName is not NULL THEN
        aAudienceList  = aAudienceList   || aName || arg_separator;
     END IF;

     FETCH taxonDescAudience INTO aAudienceID, aName ;

   END LOOP;

   CLOSE taxonDescAudience ;

   RETURN aAudienceList;


END;'
language 'plpgsql';

--2010.01.19 esmata
create or replace function atta.species_standard_element_content (arg_taxon_id NUMERIC, arg_taxon_description_sequence NUMERIC,
                                       arg_standard_concept TEXT, arg_with_label NUMERIC, arg_separator TEXT) returns text as '

DECLARE

--Fetch var
aStandardConcept text;
aElementSequence int4;
aElementName text;
aRecordSequence int4;
aContentsText text;
aContentsNum numeric;
aTableName text;
aMainFieldName text;

-- Temp var
aCurrentRecordSequence int4;
aLabelTemp text;

-- Result string
aFullContent text;

speciesDescription CURSOR IS
 select tdc.standard_concept, tde.sequence as element_sequence, tde.name,
        tdr.sequence as record_sequence, tdr.contents_text, tdr.contents_numeric,
        tde.table_name, tde.main_field_name
   from atta.taxon_description_category tdc, atta.taxon_description_element tde, atta.taxon_description_record tdr
   where tdr.taxon_id = arg_taxon_id and
         tdr.taxon_description_sequence = arg_taxon_description_sequence and
         tdc.standard_concept = arg_standard_concept and
         tdc.taxon_description_category_id = tde.taxon_description_category_id and
         tde.taxon_description_element_id = tdr.taxon_description_element_id
   order by tdc.taxon_description_category_id, tdr.taxon_description_record_id,tdr.sequence ;


BEGIN
   -- Procedure Name: species_standard_element_content

   -- Returns the content of a species standard element.  The content could be the result of concatening
   --    a group of records.
   -- Nota:  En la tabla atta.taxon_description_element existe un campo que se llama table_name en el cual por error
   --        se esta almacenando el nombre del la clase (EJB) por lo que temporalmente se alambro en el codigo el nombre
   --        de las tablas que contienen los nombre de las listas de seleccion mientras se agrega un campo con el nombre de la tabla.

   --   Los nombres alambrados corresponden a:
   --       InteractionType
   --       GeographicCatalogue
   --       GeographicEntity
   --       ReferenceType

   -- Created to be use during the generation of the Plinian Core snapshot.

   -- Revisión History:
   --   December 9,  2009 - Maria  Mora

   -- Arguments (input / output):
   --    arg_taxon_id NUMBER,                    Taxon identifier
   --    arg_taxon_description_sequence NUMBER   Species record version
   --    arg_standard_concept text,              The concept name as defined by the used standard (currently Plinian Core)
   --    arg_with_label                          Define if the return text must include the elements name (1=Yes, 0=no)
   --    arg_separator                           Element separator

   -- Return Values: aFullContent

   aFullContent = '''';

   OPEN speciesDescription;

   FETCH speciesDescription INTO aStandardConcept, aElementSequence, aElementName, aRecordSequence,
                                  aContentsText, aContentsNum, aTableName, aMainFieldName ;

   aCurrentRecordSequence = 1;


   WHILE FOUND LOOP

     IF aCurrentRecordSequence != aRecordSequence THEN
        aCurrentRecordSequence = aRecordSequence;
        aFullContent = aFullContent || ''<br>'' ;
     END IF;

     IF aContentsText is not NULL THEN

        IF arg_with_label = 1 THEN
           aFullContent = aFullContent || '' <b>'' ||aElementName  || '':</b> '' || aContentsText || arg_separator ;
        ELSE
           aFullContent = aFullContent  || aContentsText || arg_separator;
        END IF;

     ELSE
         aLabelTemp = '''';

         IF aContentsNum is not null and aTableName is not null THEN

            IF TRIM(aTableName) = ''InteractionType'' THEN
               SELECT name INTO aLabelTemp  FROM atta.Interaction_Type
                 WHERE interaction_type_id = aContentsNum ;
            END IF;

            IF TRIM(aTableName) = ''GeographicCatalogue'' THEN
               SELECT name INTO aLabelTemp  FROM atta.Geographic_Catalogue
                 WHERE geographic_catalogue_id = aContentsNum ;
            END IF;

            IF TRIM(aTableName) = ''GeographicEntity'' THEN
               SELECT name INTO aLabelTemp  FROM atta.Geographic_Entity
                 WHERE geographic_entity_id = aContentsNum ;
            END IF;

            IF TRIM(aTableName) = ''ReferenceType'' THEN
               SELECT name INTO aLabelTemp  FROM atta.Reference_Type
                 WHERE reference_type_id = aContentsNum ;
            END IF;

            IF TRIM(aTableName) = ''Country'' THEN
               SELECT value INTO aLabelTemp  FROM atta.Country
                 WHERE country_id = aContentsNum ;
            END IF;

            IF arg_with_label = 1 THEN
               aFullContent = aFullContent || '' <b>'' ||aElementName  || '':</b> '' || aLabelTemp  || arg_separator;
            ELSE
               aFullContent = aFullContent || aLabelTemp  || arg_separator ;
            END IF;

         END IF;

     END IF;

     FETCH speciesDescription INTO aStandardConcept, aElementSequence, aElementName, aRecordSequence,
                                  aContentsText, aContentsNum, aTableName, aMainFieldName ;

   END LOOP;

   CLOSE speciesDescription ;

   RETURN aFullContent;
END;'
language 'plpgsql';

--2010.01.28 esmata
alter table atta.taxon_description add column institution_id numeric;
update atta.taxon_description set institution_id = (select min(institution_id) from atta.institution);
ALTER TABLE atta.taxon_description ADD CONSTRAINT fk_species_record_institution_id FOREIGN KEY (institution_id) REFERENCES atta.institution (institution_id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION;

--2010.01.28 esmata
create or replace function atta.person_name (atta.person.person_id%TYPE, arg_profile_id NUMERIC,
                                       arg_form NUMERIC) returns text as '
DECLARE

firstNameTemp      text;
lastNameTemp       text;
secondLastNameTemp text;
initialsTemp       text;
profileNameTemp    text;
personNameTemp     text;

BEGIN
   -- Procedure Name: person_name


   --   Retrun the person name using different formats such as short name, full name,
   --     and the long form of the name.   Additionally, it returns the abbreviated name used by a person
   --     according with a profile.  To generate the abbreviated name it use the function
   --     person_profile_short_name.
   --   If arg_profile_id = 0 it returns the person name accoding the arg_form, if not, it returns
   --     person_profile_short_name.

   -- Created to be use during the generation of the Darwin Core snapshot.

   -- Revisión History:
   --   October 6,  2009 - Maria  Mora

   -- Arguments (input / output):
   --    arg_person_id NUMBER,       Person identifier
   --    arg_profile_id NUMBER       Profile identifier (0 if the profile is not important)
   --    arg_form NUMBER,            String format

   -- Format (arg_form):
      --Short name
      --  <Last name><,><blank><Iniciales> (arg_form = 1):
      --  <Iniciales><blank><last name> (arg_form = 2)

      --Long form:
      --  <last name><,><blank><name> (arg_form = 3)
      --  <Name><blank><last name> (arg_form = 4)

      --Full form:
      --  <Last name><blank><second last name><,><blank><name>
      --         (arg_form = 5)
      --  <Name><blank><Last name><blank><Second last name>
      --         (arg_form = 6)

      -- arg_form 7 => <1 name Frist character> <"."> <Last name>


   -- Return Values:
   --   Person name

   -- Precondition:
   --  The arg_person_id must exist in the table Person_name.

   -- Postcondition:

   -- Associated functions: person_profile_short_name

   -- Local Variables:


--   profileNameTemp := person_profile_short_name( arg_person_id,  arg_profile_id);

   personNameTemp = NULL;
   profileNameTemp = NULL;


   IF arg_profile_id = 0  THEN


      -- Search the person information identified by $1
      SELECT RTRIM(first_name), RTRIM(last_name), RTRIM(initials), RTRIM(second_last_name)
         INTO firstNameTemp, lastNameTemp, initialsTemp, secondLastNameTemp
         FROM atta.PERSON
         WHERE person_id = $1;


      -- Null to blank string convertion
      IF lastNameTemp = NULL THEN
         lastNameTemp = '''';
      END IF;

      IF firstNameTemp = NULL THEN
         firstNameTemp = '''';
      END IF;

      IF initialsTemp = NULL THEN
         initialsTemp = '''';
      END IF;

      IF secondLastNameTemp = NULL THEN
         secondLastNameTemp = '''';
      END IF;


      IF arg_form = 1 THEN       -- Short form
         personNameTemp = LTRIM(lastNameTemp) || '', '' || LTRIM(initialsTemp) ;

      ELSIF arg_form = 2 THEN       -- Short form
         personNameTemp = LTRIM(initialsTemp) || '' '' || LTRIM(lastNameTemp );

      ELSIF arg_form = 3 THEN       -- Long form
         personNameTemp = LTRIM(lastNameTemp) || '', '' || LTRIM(firstNameTemp) ;

      ELSIF arg_form = 4 THEN       -- Short form
         personNameTemp = LTRIM(firstNameTemp) || '' '' || LTRIM(lastNameTemp );

      ELSIF arg_form = 5 THEN       -- Complete form
         personNameTemp = LTRIM(lastNameTemp )|| '' '' || LTRIM(secondLastNameTemp) || '', '' || LTRIM(firstNameTemp );

      ELSIF arg_form = 6 THEN       -- Complete form
         personNameTemp = LTRIM(firstNameTemp ) || '' '' || LTRIM(lastNameTemp) || '' '' || LTRIM(secondLastNameTemp);

      ELSIF arg_form = 7 THEN       -- 1 letra del nombre || . || 1 apellido
         personNameTemp = LTRIM(SUBSTR(firstNameTemp, 1, 1) ) || ''. '' || LTRIM(lastNameTemp );

      ELSIF arg_form = 8 THEN       -- 1 letra del nombre || . || 1 apellido
         personNameTemp = LTRIM(SUBSTR(lastNameTemp, 1, 1) ) || ''. '' || LTRIM(firstNameTemp );

      END IF;


      RETURN personNameTemp;
   ELSE
      RETURN firstNameTemp;
   END IF;

END;
' language 'plpgsql';

--2010.01.28 esmata
create or replace function atta.species_record_person (arg_taxon_id NUMERIC, arg_taxon_description_sequence NUMERIC,
                                       arg_separator TEXT) returns text as '
DECLARE

--Fetch var
aCreatorID numeric;
aName text;

-- Result string
aCreatorList text;

taxonDescCreators CURSOR IS
   select atta.person_name (person_id, 0, 4)
      from atta.taxon_description_person_profile tdp
      where tdp.taxon_id = arg_taxon_id and
            tdp.taxon_description_sequence = arg_taxon_description_sequence
      order by  tdp.sequence;


BEGIN
   -- Procedure Name: species_record_person


   -- Retruns a taxon description creators list.

   -- Created to be use during the generation of the Plinian Core snapshot.

   -- Revisión History:
   --   January 28,  2010 - Maria  Mora

   -- Arguments (input / output):
   --    arg_taxon_id NUMBER,                    Taxon identifier
   --    arg_taxon_description_sequence NUMBER   Species record version
   --    arg_separator                           Element separator

   -- Return Values:

   -- Precondition: The function uses atta.person_name (person_id, 0, 4) in order to format each creator name.

   -- Postcondition:

   -- Local Variables:



   OPEN taxonDescCreators;

   FETCH taxonDescCreators INTO aName ;

   aCreatorList = aName;

   aName = NULL;

   WHILE FOUND LOOP

     IF aName is not NULL THEN
        aCreatorList = aCreatorList || arg_separator || aName  ;
     END IF;

     FETCH taxonDescCreators INTO aName ;

   END LOOP;

   CLOSE taxonDescCreators;

   RETURN aCreatorList;


END;
' language 'plpgsql';

                --------------------------------------------------------------------------------
                -- Hata aquí quedó la versión de Bután (Primer taller del 4 de febrero)  --
                --------------------------------------------------------------------------------

-----------------------------------
-- TABLES FOR GERMOPLASMA MODULE --
-----------------------------------
--2010.03.01
CREATE TABLE atta.material_type(
material_type_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE atta.material_type OWNER TO atta;

ALTER TABLE ONLY atta.material_type ADD CONSTRAINT "MATERIAL_TYPE_ID_PK" PRIMARY KEY (material_type_id);

CREATE TABLE atta.sample_status(
sample_status_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE atta.sample_status OWNER TO atta;

ALTER TABLE ONLY atta.sample_status ADD CONSTRAINT "SAMPLE_STATUS_ID_PK" PRIMARY KEY (sample_status_id);

CREATE TABLE atta.gathering_source(
gathering_source_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE atta.gathering_source OWNER TO atta;

ALTER TABLE ONLY atta.gathering_source ADD CONSTRAINT "GATHERING_SOURCE_ID_PK" PRIMARY KEY (gathering_source_id);

CREATE TABLE atta.soil_color(
soil_color_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE atta.soil_color OWNER TO atta;

ALTER TABLE ONLY atta.soil_color ADD CONSTRAINT "SOIL_COLOR_ID_PK" PRIMARY KEY (soil_color_id);

CREATE TABLE atta.soil_texture(
soil_texture_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE atta.soil_texture OWNER TO atta;

ALTER TABLE ONLY atta.soil_texture ADD CONSTRAINT "SOIL_TEXTURE_ID_PK" PRIMARY KEY (soil_texture_id);

CREATE TABLE atta.cultivation_practice(
cultivation_practice_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE atta.cultivation_practice OWNER TO atta;

ALTER TABLE ONLY atta.cultivation_practice ADD CONSTRAINT "CULTURE_PRACTCE_ID_PK" PRIMARY KEY (cultivation_practice_id);

CREATE TABLE atta.crop_system(
crop_system_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE atta.crop_system OWNER TO atta;

ALTER TABLE ONLY atta.crop_system ADD CONSTRAINT "CROP_SYSTEM_ID_PK" PRIMARY KEY (crop_system_id);

CREATE TABLE atta.crop_type(
crop_type_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE atta.crop_type OWNER TO atta;

ALTER TABLE ONLY atta.crop_type ADD CONSTRAINT "CROP_TYPE_ID_PK" PRIMARY KEY (crop_type_id);


CREATE TABLE atta.passport (
passport_id 		numeric not null,
donor_person_id 	numeric,
donor_institution_id 	numeric,
gathering_id 		numeric,
material_type_id 	numeric not null,
sample_status_id 	numeric,
gathering_source_id 	numeric,
mission_number 		numeric,
soil_color_id 		numeric,
soil_texture_id 	numeric,
cultivation_practice_id numeric,
plant_nursery_date 	date,
planting_season_date 	date,
harvesting_season_date 	date,
crop_system_id 		numeric,
resistant 		character varying(500),
remarks 		character varying(1000),
crop_type_id 		numeric,
taxon_id  		numeric,
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE atta.passport OWNER TO atta;

ALTER TABLE ONLY atta.passport ADD CONSTRAINT "PASSPORT_ID_PK" PRIMARY KEY (passport_id);

ALTER TABLE ONLY atta.passport ADD CONSTRAINT donor_person_id_fk FOREIGN KEY (donor_person_id) REFERENCES atta.person(person_id);
ALTER TABLE ONLY atta.passport ADD CONSTRAINT donor_institution_id_fk FOREIGN KEY (donor_institution_id) REFERENCES atta.institution(institution_id);
ALTER TABLE ONLY atta.passport ADD CONSTRAINT gathering_id_fk FOREIGN KEY (gathering_id) REFERENCES atta.gathering_observation(gathering_observation_id);
ALTER TABLE ONLY atta.passport ADD CONSTRAINT material_type_id_fk FOREIGN KEY (material_type_id) REFERENCES atta.material_type(material_type_id);
ALTER TABLE ONLY atta.passport ADD CONSTRAINT sample_status_id_fk FOREIGN KEY (sample_status_id) REFERENCES atta.sample_status(sample_status_id);
ALTER TABLE ONLY atta.passport ADD CONSTRAINT gathering_source_id_fk FOREIGN KEY (gathering_source_id) REFERENCES atta.gathering_source(gathering_source_id);
ALTER TABLE ONLY atta.passport ADD CONSTRAINT soil_color_id_fk FOREIGN KEY (soil_color_id) REFERENCES atta.soil_color(soil_color_id);
ALTER TABLE ONLY atta.passport ADD CONSTRAINT soil_texture_id_fk FOREIGN KEY (soil_texture_id) REFERENCES atta.soil_texture(soil_texture_id);
ALTER TABLE ONLY atta.passport ADD CONSTRAINT culture_practice_id_fk FOREIGN KEY (cultivation_practice_id) REFERENCES atta.cultivation_practice(cultivation_practice_id);
ALTER TABLE ONLY atta.passport ADD CONSTRAINT crop_system_id_fk FOREIGN KEY (crop_system_id) REFERENCES atta.crop_system(crop_system_id);
ALTER TABLE ONLY atta.passport ADD CONSTRAINT crop_type__id_fk FOREIGN KEY (crop_type_id) REFERENCES atta.crop_type(crop_type_id);


--ALTER TABLE ONLY atta.passport ADD taxon_id  numeric;
ALTER TABLE ONLY atta.passport ADD CONSTRAINT taxon_id_fk FOREIGN KEY (taxon_id) REFERENCES atta.taxon(taxon_id);

--CREATE SEQUENCE
CREATE SEQUENCE atta.material_type_seq;
ALTER TABLE atta.material_type ALTER COLUMN material_type_id SET DEFAULT nextval('atta.material_type_seq'::regclass);
ALTER TABLE atta.material_type_seq OWNER TO atta;

CREATE SEQUENCE atta.sample_status_seq;
ALTER TABLE atta.sample_status ALTER COLUMN sample_status_id SET DEFAULT nextval('atta.sample_status_seq'::regclass);
ALTER TABLE atta.sample_status_seq OWNER TO atta;

CREATE SEQUENCE atta.gathering_source_seq;
ALTER TABLE atta.gathering_source ALTER COLUMN gathering_source_id SET DEFAULT nextval('atta.gathering_source_seq'::regclass);
ALTER TABLE atta.gathering_source_seq OWNER TO atta;

CREATE SEQUENCE atta.soil_color_seq;
ALTER TABLE atta.soil_color ALTER COLUMN soil_color_id SET DEFAULT nextval('atta.soil_color_seq'::regclass);
ALTER TABLE atta.soil_color_seq OWNER TO atta;

CREATE SEQUENCE atta.soil_texture_seq;
ALTER TABLE atta.soil_texture ALTER COLUMN soil_texture_id SET DEFAULT nextval('atta.soil_texture_seq'::regclass);
ALTER TABLE atta.soil_texture_seq OWNER TO atta;

CREATE SEQUENCE atta.cultivation_practice_seq;
ALTER TABLE atta.cultivation_practice ALTER COLUMN cultivation_practice_id SET DEFAULT nextval('atta.cultivation_practice_seq'::regclass);
ALTER TABLE atta.cultivation_practice_seq OWNER TO atta;

CREATE SEQUENCE atta.crop_system_seq;
ALTER TABLE atta.crop_system ALTER COLUMN crop_system_id SET DEFAULT nextval('atta.crop_system_seq'::regclass);
ALTER TABLE atta.crop_system_seq OWNER TO atta;

CREATE SEQUENCE atta.crop_type_seq;
ALTER TABLE atta.crop_type ALTER COLUMN crop_type_id SET DEFAULT nextval('atta.crop_type_seq'::regclass);
ALTER TABLE atta.crop_type_seq OWNER TO atta;

CREATE SEQUENCE atta.passport_seq;
ALTER TABLE atta.passport ALTER COLUMN passport_id SET DEFAULT nextval('atta.passport_seq'::regclass);
ALTER TABLE atta.passport_seq OWNER TO atta;

CREATE TABLE atta.passport_nomenclatural_group (
passport_id			numeric NOT NULL,
nomenclatural_group_id		numeric NOT NULL,
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL
);

ALTER TABLE atta.passport_nomenclatural_group OWNER TO atta;

ALTER TABLE ONLY atta.passport_nomenclatural_group ADD CONSTRAINT passport_nomenclatural_group_pk PRIMARY KEY (passport_id, nomenclatural_group_id);
ALTER TABLE ONLY atta.passport_nomenclatural_group ADD CONSTRAINT nomenclatural_group_id_fk FOREIGN KEY (nomenclatural_group_id) REFERENCES atta.nomenclatural_group(nomenclatural_group_id);
ALTER TABLE ONLY atta.passport_nomenclatural_group ADD CONSTRAINT passport_id_fk FOREIGN KEY (passport_id) REFERENCES atta.passport(passport_id);

--2010.03.18 esmata
--Adding unique constraint between catalog number and institution code on specimen table
ALTER TABLE atta.specimen ADD CONSTRAINT unique_specimen UNIQUE (catalog_number,institution_id);

--2010.03.24 dasolano

                                ---------------------------------------------
                                -- TABLES FOR GERMPLASM MODULE: ACCESSIONS --
                                ---------------------------------------------


CREATE TABLE atta.germination_method_type(
germination_method_type_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE atta.germination_method_type OWNER TO atta;

ALTER TABLE ONLY atta.germination_method_type ADD CONSTRAINT "GERMINATION_METHOD_TYPE_ID_PK" PRIMARY KEY (germination_method_type_id);

CREATE TABLE atta.moisture_method_type(
moisture_method_type_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE atta.moisture_method_type OWNER TO atta;

ALTER TABLE ONLY atta.moisture_method_type ADD CONSTRAINT "MOISTURE_METHOD_TYPE_ID_PK" PRIMARY KEY (moisture_method_type_id);

CREATE TABLE atta.collection_type(
collection_type_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE atta.collection_type OWNER TO atta;

ALTER TABLE ONLY atta.collection_type ADD CONSTRAINT "COLLECTION_TYPE_ID_PK" PRIMARY KEY (collection_type_id);


CREATE TABLE atta.accession_movement_type(
accession_movement_type_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE atta.accession_movement_type OWNER TO atta;

ALTER TABLE ONLY atta.accession_movement_type ADD CONSTRAINT "ACCESSION_MOVEMENT_TYPE_ID_PK" PRIMARY KEY (accession_movement_type_id);


CREATE TABLE atta.accession(
accession_id 			numeric not null,
accession_number		character varying(20),
collection_type_id		numeric not null,
responsable_person_id		numeric,
packages			numeric,
original_weigth			numeric,
passport_id			numeric,
multiplication_regeneration	numeric,
current_weigth			numeric,
location			character varying(1000),
germination_date		date,
germination_rate		numeric,
germination_viability		numeric,
germination_method_type_id	numeric,
moisture			numeric,
moisture_method_type_id		numeric,
storage_date			date,
accession_parent_id		numeric,
notes				character varying(1000),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE atta.accession OWNER TO atta;

ALTER TABLE ONLY atta.accession ADD CONSTRAINT "ACCESSION_ID_PK" PRIMARY KEY (accession_id);
ALTER TABLE ONLY atta.accession ADD CONSTRAINT accession_number_unique UNIQUE (accession_number);

CREATE TABLE atta.accession_movement(
accession_id 		numeric not null,
accession_movement_date		timestamp with time zone default now(),
weight				numeric not null,
accession_movement_type_id 	numeric not null,
responsable_person_id 		numeric not null,
notes 				character varying(1000),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE atta.accession_movement OWNER TO atta;

ALTER TABLE ONLY atta.accession_movement ADD CONSTRAINT "ACCESSION_MOVEMENT_ID_PK" PRIMARY KEY (accession_id, accession_movement_date);

ALTER TABLE ONLY atta.accession ADD CONSTRAINT collection_type_id_fk FOREIGN KEY (collection_type_id) REFERENCES atta.collection_type(collection_type_id);
ALTER TABLE ONLY atta.accession ADD CONSTRAINT responsable_person_id_fk FOREIGN KEY (responsable_person_id) REFERENCES atta.person(person_id);
ALTER TABLE ONLY atta.accession ADD CONSTRAINT passport_id_fk FOREIGN KEY (passport_id) REFERENCES atta.passport(passport_id) ON DELETE CASCADE;
ALTER TABLE ONLY atta.accession ADD CONSTRAINT germination_method_type_id_fk FOREIGN KEY (germination_method_type_id) REFERENCES atta.germination_method_type(germination_method_type_id);
ALTER TABLE ONLY atta.accession ADD CONSTRAINT moisture_method_type_id_fk FOREIGN KEY (moisture_method_type_id) REFERENCES atta.moisture_method_type(moisture_method_type_id);
ALTER TABLE ONLY atta.accession ADD CONSTRAINT accession_parent_id_fk FOREIGN KEY (accession_parent_id) REFERENCES atta.accession(accession_id) ON DELETE CASCADE;



ALTER TABLE ONLY atta.accession_movement ADD CONSTRAINT accession_id_fk FOREIGN KEY (accession_id) REFERENCES atta.accession(accession_id)  ON DELETE CASCADE;
ALTER TABLE ONLY atta.accession_movement ADD CONSTRAINT accession_movement_type_id_fk FOREIGN KEY (accession_movement_type_id) REFERENCES atta.accession_movement_type(accession_movement_type_id);

--SEQUENCE

CREATE SEQUENCE atta.germination_method_type_seq;
ALTER TABLE atta.germination_method_type ALTER COLUMN germination_method_type_id SET DEFAULT nextval('atta.germination_method_type_seq'::regclass);
ALTER TABLE atta.germination_method_type_seq OWNER TO atta;


CREATE SEQUENCE atta.moisture_method_type_seq;
ALTER TABLE atta.moisture_method_type ALTER COLUMN moisture_method_type_id SET DEFAULT nextval('atta.moisture_method_type_seq'::regclass);
ALTER TABLE atta.moisture_method_type_seq OWNER TO atta;

CREATE SEQUENCE atta.collection_type_seq;
ALTER TABLE atta.collection_type ALTER COLUMN collection_type_id SET DEFAULT nextval('atta.collection_type_seq'::regclass);
ALTER TABLE atta.collection_type_seq OWNER TO atta;

CREATE SEQUENCE atta.accession_movement_type_seq;
ALTER TABLE atta.accession_movement_type ALTER COLUMN accession_movement_type_id SET DEFAULT nextval('atta.accession_movement_type_seq'::regclass);
ALTER TABLE atta.accession_movement_type_seq OWNER TO atta;

CREATE SEQUENCE atta.accession_seq;
ALTER TABLE atta.accession ALTER COLUMN accession_id SET DEFAULT nextval('atta.accession_seq'::regclass);
ALTER TABLE atta.accession_seq OWNER TO atta;

                --------------------------------------------------------------------------------
                -- Hata aquí quedó la versión de Jamaica y Perú  --
                --------------------------------------------------------------------------------

---------------------------------------------
    -- TABLES FOR INDICATOR MODULE --
---------------------------------------------
--2010.04.27 gsulca

create table atta.INDICATOR  (
   INDICATOR_ID         numeric not null,
   NAME                 character varying(80) not null,
   DESCRIPTION          character varying(200),
   CREATION_DATE        DATE,
   CREATED_BY           character varying(20),
   LAST_MODIFICATION_DATE DATE,
   LAST_MODIFICATION_BY character varying(20),
   INDICATOR_ANCESTOR_ID numeric ,
   APPLIES_TO_PARTS     numeric,
   CONSTRAINT ckc_APPLIES_TO_PARTS CHECK (((APPLIES_TO_PARTS  = (0)::numeric) OR (APPLIES_TO_PARTS  = (1)::numeric)))
);
ALTER TABLE  atta.INDICATOR OWNER TO atta;
ALTER TABLE ONLY atta.INDICATOR add constraint INDICATOR_ID_pk primary key (INDICATOR_ID);

create table atta.TAXON_INDICATOR  (
   INDICATOR_ID         numeric NOT NULL,
   TAXON_ID             numeric NOT NULL,
   CERTAINTY_LEVEL      numeric
         constraint CKC_CERTAINTY_LEVEL_TAXON_IN check (CERTAINTY_LEVEL is null or (CERTAINTY_LEVEL between 0 and 1)),
   EVALUATION_CRITERIA  character varying(200),
   REGIONALITY          character varying(200),
   TEMPORALITY          character varying(200),
   NOTES                character varying(4000),
   VALUER_PERSON_ID     numeric not null,
   CREATION_DATE        DATE,
   CREATED_BY           character varying(20),
   LAST_MODIFICATION_DATE DATE,
   LAST_MODIFICATION_BY character varying(20)
);
ALTER TABLE atta.TAXON_INDICATOR OWNER TO atta;
ALTER TABLE ONLY atta.TAXON_INDICATOR ADD CONSTRAINT TAXON_INDICATOR_ID_TAXON_ID_PK PRIMARY KEY (INDICATOR_ID, TAXON_ID);
ALTER TABLE ONLY atta.TAXON_INDICATOR ADD CONSTRAINT TAXON_INDICATOR_taxon_id_fk FOREIGN KEY (TAXON_ID ) REFERENCES atta.TAXON(TAXON_ID);
ALTER TABLE ONLY atta.TAXON_INDICATOR ADD CONSTRAINT TAXON_INDICATOR_INDICATOR_id_fk FOREIGN KEY (INDICATOR_ID) REFERENCES atta.INDICATOR(INDICATOR_ID);
ALTER TABLE ONLY atta.TAXON_INDICATOR ADD CONSTRAINT valuer_person_id_fk FOREIGN KEY (valuer_person_id) REFERENCES atta.PERSON(person_id);


create table atta.TAXON_INDICATOR_REFERENCE  (
   REFERENCE_ID         numeric not null,
   INDICATOR_ID         numeric not null,
   TAXON_ID             numeric not null
);
ALTER TABLE  atta.TAXON_INDICATOR_REFERENCE OWNER TO atta;
ALTER TABLE ONLY atta.TAXON_INDICATOR_REFERENCE add constraint TAXON_INDICATOR_REFERENCE_PK primary key (REFERENCE_ID, INDICATOR_ID, TAXON_ID);
ALTER TABLE ONLY atta.TAXON_INDICATOR_REFERENCE  ADD CONSTRAINT TAXON_INDIC_INDICATOR_TAXON_id_fk FOREIGN KEY (INDICATOR_ID, TAXON_ID) REFERENCES atta.TAXON_INDICATOR(INDICATOR_ID, TAXON_ID);


create table atta.INDICATOR_REFERENCE  (
   REFERENCE_ID         numeric not null,
   INDICATOR_ID         numeric not null
);
ALTER TABLE atta.INDICATOR_REFERENCE OWNER TO atta;
ALTER TABLE ONLY atta.INDICATOR_REFERENCE add constraint INDICATOR_REFERENCE_pk primary key (REFERENCE_ID, INDICATOR_ID);


create table atta.TAXON_INDICATOR_COMPONENT_PART  (
   COMPONENT_PART_ID    numeric NOT NULL,
   INDICATOR_ID         numeric NOT NULL,
   TAXON_ID             numeric NOT NULL
);
ALTER TABLE ONLY atta.TAXON_INDICATOR_COMPONENT_PART ADD CONSTRAINT TAXON_INDICATOR_CP_ID_TAXON_ID_PK PRIMARY KEY (COMPONENT_PART_ID,INDICATOR_ID, TAXON_ID);
ALTER TABLE ONLY atta.TAXON_INDICATOR_COMPONENT_PART ADD CONSTRAINT TAXON_INDIC_CP_indic_taxon_fk FOREIGN KEY (INDICATOR_ID, TAXON_ID) REFERENCES atta.TAXON_INDICATOR(INDICATOR_ID, TAXON_ID);
ALTER TABLE ONLY atta.TAXON_INDICATOR_COMPONENT_PART OWNER TO atta;

-- Agregué las siguientes llaves foraneas
ALTER TABLE ONLY atta.INDICATOR_REFERENCE  ADD CONSTRAINT INDICATOR_reference_id_fk FOREIGN KEY (INDICATOR_ID ) REFERENCES atta.INDICATOR(INDICATOR_ID);
ALTER TABLE ONLY atta.TAXON_INDICATOR_COMPONENT_PART  ADD CONSTRAINT TAXON_INDICATOR_COMPONENT_PART_fk FOREIGN KEY (COMPONENT_PART_ID ) REFERENCES atta.COMPONENT_PART(COMPONENT_PART_ID);

-- Hacer la tabla indicadores jerárquica
ALTER TABLE ONLY atta.INDICATOR ADD CONSTRAINT TAXON_INDICATOR_ancestor_id_fk FOREIGN KEY (INDICATOR_ANCESTOR_ID ) REFERENCES atta.INDICATOR(INDICATOR_ID);


-- Nuevo secuence para la tabla de component_part
CREATE SEQUENCE atta.component_part_seq;
ALTER TABLE atta.component_part_seq OWNER TO atta;
-- Asignar dicho secuence al atributo correspondiente de la tabla
ALTER TABLE atta.component_part ALTER COLUMN component_part_id SET DEFAULT nextval('atta.component_part_seq'::regclass);
-- Eliminar el obj_version
ALTER TABLE atta.component_part DROP COLUMN obj_version;


-- Nuevo secuence para la tabla de indicator
CREATE SEQUENCE atta.indicator_seq START 0 MINVALUE 0;
ALTER TABLE atta.indicator_seq OWNER TO atta;
-- Asignar dicho secuence al atributo correspondiente de la tabla
ALTER TABLE atta.indicator ALTER COLUMN indicator_id SET DEFAULT nextval('atta.indicator_seq'::regclass);

------------------------------------------------
----GERMPLASM SEMEN MODULE----------------------
------------------------------------------------

CREATE TABLE atta.condition(
condition_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE atta.condition OWNER TO atta;

ALTER TABLE ONLY atta.condition ADD CONSTRAINT "CONDITION_TYPE_ID_PK" PRIMARY KEY (condition_id);

CREATE TABLE atta.solvent(
solvent_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE atta.solvent OWNER TO atta;

ALTER TABLE ONLY atta.solvent ADD CONSTRAINT "SOLVENT_TYPE_ID_PK" PRIMARY KEY (solvent_id);

CREATE TABLE atta.semen_gathering_method(
semen_gathering_method_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE atta.semen_gathering_method OWNER TO atta;

ALTER TABLE ONLY atta.semen_gathering_method ADD CONSTRAINT "SEMEN_GATHERING_METHOD_ID_PK" PRIMARY KEY (semen_gathering_method_id);


CREATE TABLE atta.breed(
breed_id numeric not null,
name character varying(100) UNIQUE NOT NULL,
taxon_id numeric not null,
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE atta.breed OWNER TO atta;

ALTER TABLE ONLY atta.breed ADD CONSTRAINT "BREED_TYPE_ID_PK" PRIMARY KEY (breed_id);

ALTER TABLE ONLY atta.breed ADD CONSTRAINT taxon_id_fk FOREIGN KEY (taxon_id) REFERENCES atta.taxon(taxon_id);


CREATE TABLE atta.semental(
semental_id 	numeric not null,
name 		character varying(200),
animal_code 	character varying(100) NOT NULL UNIQUE,
breed_id 	numeric not null,
color 		character varying(200) NOT NULL,
birth_date 	date,
site_id 	numeric,
veterinarian_status character varying(100),
condition_id 	numeric not null,
animal_description character varying(100),
father 		character varying(100),
mother 		character varying(100),
created_by 	character varying(20) NOT NULL,
creation_date 	date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE atta.semental OWNER TO atta;

ALTER TABLE ONLY atta.semental ADD CONSTRAINT "SEMENTAL_ID_PK" PRIMARY KEY (semental_id);

ALTER TABLE ONLY atta.semental ADD CONSTRAINT breed_id_fk FOREIGN KEY (breed_id) REFERENCES atta.breed(breed_id) ON DELETE CASCADE;
ALTER TABLE ONLY atta.semental ADD CONSTRAINT site_id_fk FOREIGN KEY (site_id) REFERENCES atta.site(site_id);
ALTER TABLE ONLY atta.semental ADD CONSTRAINT condition_id_fk FOREIGN KEY (condition_id) REFERENCES atta.condition(condition_id);

CREATE TABLE atta.semen_gathering(
semen_gathering_id numeric not null,
semental_id numeric not null,
semen_gathering_date date NOT NULL,
semen_gathering_time character varying(5) NOT NULL,
volume numeric not null,
motility numeric not null,
concentration numeric not null,
straw_quantity numeric not null,
dilution character varying(100) NOT NULL,
tank_number numeric not null,
canister_number numeric not null,
goblet_number numeric not null,
straw_color character varying(100) NOT NULL,
post_thaw_motility numeric not null,
active_doses numeric not null,
straw_size numeric not null,
semen_gathering_method_id numeric not null,
consistency character varying(100) NOT NULL,
semen_color character varying(100) NOT NULL,
ph numeric not null,
mass_motility numeric not null,
solvent_id numeric not null,
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE atta.semen_gathering OWNER TO atta;

ALTER TABLE ONLY atta.semen_gathering ADD CONSTRAINT "SEMEN_GATHERING_ID_PK" PRIMARY KEY (semen_gathering_id);

ALTER TABLE ONLY atta.semen_gathering ADD CONSTRAINT solvent_id_fk FOREIGN KEY (solvent_id) REFERENCES atta.solvent(solvent_id);
ALTER TABLE ONLY atta.semen_gathering ADD CONSTRAINT semen_gathering_method_id_fk FOREIGN KEY (semen_gathering_method_id) REFERENCES atta.semen_gathering_method(semen_gathering_method_id);
ALTER TABLE ONLY atta.semen_gathering ADD CONSTRAINT semental_id_fk FOREIGN KEY (semental_id) REFERENCES atta.semental(semental_id) ON DELETE CASCADE;

--CREATE SEQUENCE
CREATE SEQUENCE atta.condition_seq;
ALTER TABLE atta.condition ALTER COLUMN condition_id SET DEFAULT nextval('atta.condition_seq'::regclass);
ALTER TABLE atta.condition_seq OWNER TO atta;

CREATE SEQUENCE atta.solvent_seq;
ALTER TABLE atta.solvent ALTER COLUMN solvent_id SET DEFAULT nextval('atta.solvent_seq'::regclass);
ALTER TABLE atta.solvent_seq OWNER TO atta;

CREATE SEQUENCE atta.semen_gathering_method_seq;
ALTER TABLE atta.semen_gathering_method ALTER COLUMN semen_gathering_method_id SET DEFAULT nextval('atta.semen_gathering_method_seq'::regclass);
ALTER TABLE atta.semen_gathering_method_seq OWNER TO atta;

CREATE SEQUENCE atta.breed_seq;
ALTER TABLE atta.breed ALTER COLUMN breed_id SET DEFAULT nextval('atta.breed_seq'::regclass);
ALTER TABLE atta.breed_seq OWNER TO atta;

CREATE SEQUENCE atta.semental_seq;
ALTER TABLE atta.semental ALTER COLUMN semental_id SET DEFAULT nextval('atta.semental_seq'::regclass);
ALTER TABLE atta.semental_seq OWNER TO atta;

CREATE SEQUENCE atta.semen_gathering_seq;
ALTER TABLE atta.semen_gathering ALTER COLUMN semen_gathering_id SET DEFAULT nextval('atta.semen_gathering_seq'::regclass);
ALTER TABLE atta.semen_gathering_seq OWNER TO atta;

--Add column current straw quantity to semen_gathering tabble
ALTER TABLE atta.semen_gathering ADD COLUMN current_straw_quantity numeric;

--2010.05.11 dasolano --update the constraint of the passport_nomenclatural table
ALTER TABLE ONLY atta.passport_nomenclatural_group
   DROP CONSTRAINT nomenclatural_group_id_fk;

ALTER TABLE ONLY atta.passport_nomenclatural_group
   DROP CONSTRAINT passport_id_fk;

ALTER TABLE ONLY atta.passport_nomenclatural_group ADD CONSTRAINT nomenclatural_group_id_fk FOREIGN KEY (nomenclatural_group_id) REFERENCES atta.nomenclatural_group(nomenclatural_group_id) ON DELETE CASCADE;
ALTER TABLE ONLY atta.passport_nomenclatural_group ADD CONSTRAINT passport_id_fk FOREIGN KEY (passport_id) REFERENCES atta.passport(passport_id) ON DELETE CASCADE;

--2010.06.15 esmata
create or replace function atta.species_standard_element_content (arg_taxon_id NUMERIC, arg_taxon_description_sequence NUMERIC,
                                       arg_standard_concept TEXT, arg_with_label NUMERIC, arg_separator TEXT) returns text as '

DECLARE

--Fetch var
aStandardConcept text;
aElementSequence int4;
aElementName text;
aRecordSequence int4;
aContentsText text;
aContentsNum numeric;
aTableName text;
aMainFieldName text;

-- Temp var
aCurrentRecordSequence int4;
aLabelTemp text;

-- Result string
aFullContent text;

speciesDescription CURSOR IS
 select tdc.standard_concept, tde.sequence as element_sequence, tde.name,
        tdr.sequence as record_sequence, tdr.contents_text, tdr.contents_numeric,
        tde.table_name, tde.main_field_name
   from atta.taxon_description_category tdc, atta.taxon_description_element tde, atta.taxon_description_record tdr
   where tdr.taxon_id = arg_taxon_id and
         tdr.taxon_description_sequence = arg_taxon_description_sequence and
         tdc.standard_concept = arg_standard_concept and
         tdc.taxon_description_category_id = tde.taxon_description_category_id and
         tde.taxon_description_element_id = tdr.taxon_description_element_id
   order by tdc.taxon_description_category_id, tdr.taxon_description_record_id,tdr.sequence ;


BEGIN
   -- Procedure Name: species_standard_element_content

   -- Returns the content of a species standard element.  The content could be the result of concatening
   --    a group of records.
   -- Nota:  En la tabla atta.taxon_description_element existe un campo que se llama table_name en el cual por error
   --        se esta almacenando el nombre del la clase (EJB) por lo que temporalmente se alambro en el codigo el nombre
   --        de las tablas que contienen los nombre de las listas de seleccion mientras se agrega un campo con el nombre de la tabla.

   --   Los nombres alambrados corresponden a:
   --       InteractionType
   --       GeographicCatalogue
   --       GeographicEntity
   --       ReferenceType

   -- Created to be use during the generation of the Plinian Core snapshot.

   -- Revisión History:
   --   December 9,  2009 - Maria  Mora

   -- Arguments (input / output):
   --    arg_taxon_id NUMBER,                    Taxon identifier
   --    arg_taxon_description_sequence NUMBER   Species record version
   --    arg_standard_concept text,              The concept name as defined by the used standard (currently Plinian Core)
   --    arg_with_label                          Define if the return text must include the elements name (1=Yes, 0=no)
   --    arg_separator                           Element separator

   -- Return Values: aFullContent


   aFullContent = '''';

   OPEN speciesDescription;

   FETCH speciesDescription INTO aStandardConcept, aElementSequence, aElementName, aRecordSequence,
                                  aContentsText, aContentsNum, aTableName, aMainFieldName ;

   aCurrentRecordSequence = aRecordSequence;


   WHILE FOUND LOOP

     IF aCurrentRecordSequence != aRecordSequence THEN
        aCurrentRecordSequence = aRecordSequence;
        aFullContent = aFullContent || ''<br>'' ;
     END IF;

     IF aContentsText is not NULL THEN

        IF arg_with_label = 1 THEN
           aFullContent = aFullContent || '' <b>'' ||aElementName  || '':</b> '' || aContentsText || arg_separator ;
        ELSE
           aFullContent = aFullContent  || aContentsText || arg_separator;
        END IF;

     ELSE
         aLabelTemp = '''';

         IF aContentsNum is not null and aTableName is not null THEN

            IF TRIM(aTableName) = ''InteractionType'' THEN
               SELECT name INTO aLabelTemp  FROM atta.Interaction_Type
                 WHERE interaction_type_id = aContentsNum ;
            END IF;

            IF TRIM(aTableName) = ''GeographicCatalogue'' THEN
               SELECT name INTO aLabelTemp  FROM atta.Geographic_Catalogue
                 WHERE geographic_catalogue_id = aContentsNum ;
            END IF;

            IF TRIM(aTableName) = ''GeographicEntity'' THEN
               SELECT name INTO aLabelTemp  FROM atta.Geographic_Entity
                 WHERE geographic_entity_id = aContentsNum ;
            END IF;

            IF TRIM(aTableName) = ''ReferenceType'' THEN
               SELECT name INTO aLabelTemp  FROM atta.Reference_Type
                 WHERE reference_type_id = aContentsNum ;
            END IF;

            IF TRIM(aTableName) = ''Country'' THEN
               SELECT value INTO aLabelTemp  FROM atta.Country
                 WHERE country_id = aContentsNum ;
            END IF;

            IF arg_with_label = 1 THEN
               aFullContent = aFullContent || '' <b>'' ||aElementName  || '':</b> '' || aLabelTemp  || arg_separator;
            ELSE
               aFullContent = aFullContent || aLabelTemp  || arg_separator ;
            END IF;

         END IF;

     END IF;

     FETCH speciesDescription INTO aStandardConcept, aElementSequence, aElementName, aRecordSequence,
                                  aContentsText, aContentsNum, aTableName, aMainFieldName ;

   END LOOP;

   CLOSE speciesDescription ;

   RETURN aFullContent;
END;
' language 'plpgsql';

                --------------------------------------------------------------------------------
                -- Hata aquí quedó la versión para la segunda visita a Bután 11 Junio 2010  --
                --------------------------------------------------------------------------------

--2010.06.15 gsulca
-- Actualizaciones para renombrar REFERENCE por DUBLIN_CORE

--
-- Actualizaciones sobre taxon_indicator_reference
--
-- Rename table taxon_indicator_reference to taxon_indicator_dublin_core
ALTER TABLE atta.TAXON_INDICATOR_REFERENCE RENAME TO TAXON_INDICATOR_DUBLIN_CORE;
-- Rename column reference_id from taxon_indicator_dublin_core to dublin_core_id
ALTER TABLE atta.TAXON_INDICATOR_DUBLIN_CORE RENAME COLUMN REFERENCE_ID TO DUBLIN_CORE_ID;
-- Remove constraint TAXON_INDICATOR_REFERENCE_PK
ALTER TABLE atta.TAXON_INDICATOR_DUBLIN_CORE DROP CONSTRAINT TAXON_INDICATOR_REFERENCE_PK;
-- Add constraint
ALTER TABLE ONLY atta.TAXON_INDICATOR_DUBLIN_CORE ADD CONSTRAINT TAXON_INDICATOR_DUBLIN_CORE_PK primary key (DUBLIN_CORE_ID, INDICATOR_ID, TAXON_ID);

--
-- Actualizaciones sobre indicator_reference
--
-- Rename table indicator_reference to indicator_dublin_core
ALTER TABLE atta.INDICATOR_REFERENCE RENAME TO INDICATOR_DUBLIN_CORE;
-- Rename column reference_id from indicator_dublin_core to dublin_core_id
ALTER TABLE atta.INDICATOR_DUBLIN_CORE RENAME COLUMN REFERENCE_ID TO DUBLIN_CORE_ID;
-- Remove constraint INDICATOR_REFERENCE_PK
ALTER TABLE atta.INDICATOR_DUBLIN_CORE DROP CONSTRAINT INDICATOR_REFERENCE_PK;
-- Add constraint INDICATOR_DUBLIN_CORE_pk
ALTER TABLE ONLY atta.INDICATOR_DUBLIN_CORE add constraint INDICATOR_DUBLIN_CORE_pk primary key (DUBLIN_CORE_ID, INDICATOR_ID);
-- Remove constraint INDICATOR_REFERENCE_ID_FK
ALTER TABLE atta.INDICATOR_DUBLIN_CORE DROP CONSTRAINT INDICATOR_REFERENCE_ID_FK;
-- Add constraint INDICATOR_DUBLIN_CORE_ID_FK
ALTER TABLE ONLY atta.INDICATOR_DUBLIN_CORE  ADD CONSTRAINT INDICATOR_DUBLIN_CORE_ID_FK FOREIGN KEY (INDICATOR_ID ) REFERENCES atta.INDICATOR(INDICATOR_ID);

---------------------------------------------
    -- TABLES FOR DUBLIN_CORE MODULE --
---------------------------------------------

--
-- Dublin Core Elements table
--
create table atta.dublin_core_element (
    id integer not null
  , resource_id integer not null
  , dublin_core_element_id integer not null
  , value character varying(65535) not null
  , language character varying(255) default null
  --log fields
  , creation_date date not null
  , created_by character varying(255) not null
  , last_modification_date date not null
  , last_modification_by character varying(255) not null
);

alter table atta.dublin_core_element add constraint dce_pkey primary key (id);
alter table atta.dublin_core_element add constraint dce_ukey1 unique (resource_id,dublin_core_element_id,value);

--
-- Dublin Core Descriptions table
--
create table atta.dublin_core_description (
    resource_id integer not null
  , resource_type_id integer not null
  , description character varying(255) default null
  --log fields
  , creation_date date not null
  , created_by character varying(255) not null
  , last_modification_date date not null
  , last_modification_by character varying(255) not null
);
alter table atta.dublin_core_description add constraint dcd_pkey primary key (resource_id);

-- Hacer OWNER a ara de las nuevas tablas
ALTER TABLE atta.dublin_core_description OWNER TO atta;
ALTER TABLE atta.dublin_core_element OWNER TO atta;

--Create sequence dublin_core_description
CREATE SEQUENCE atta.DUBLIN_CORE_DESCRIPTION_SEQ;
ALTER TABLE atta.DUBLIN_CORE_DESCRIPTION ALTER COLUMN RESOURCE_ID SET DEFAULT nextval('atta.DUBLIN_CORE_DESCRIPTION_SEQ'::regclass);
ALTER TABLE atta.DUBLIN_CORE_DESCRIPTION_SEQ OWNER TO atta;

--Create sequence dublin_core_element
CREATE SEQUENCE atta.DUBLIN_CORE_ELEMENT_SEQ;
ALTER TABLE atta.DUBLIN_CORE_ELEMENT ALTER COLUMN ID SET DEFAULT nextval('atta.DUBLIN_CORE_ELEMENT_SEQ'::regclass);
ALTER TABLE atta.DUBLIN_CORE_ELEMENT_SEQ OWNER TO atta;

--
-- Agregar columnas log files a las tablas del modulo indicadores
--
-- Add columns log fields to INDICATOR_DUBLIN_CORE
ALTER TABLE atta.INDICATOR_DUBLIN_CORE ADD COLUMN creation_date date not null;
ALTER TABLE atta.INDICATOR_DUBLIN_CORE ADD COLUMN created_by character varying(255) not null;
ALTER TABLE atta.INDICATOR_DUBLIN_CORE ADD COLUMN last_modification_date date not null;
ALTER TABLE atta.INDICATOR_DUBLIN_CORE ADD COLUMN last_modification_by character varying(255) not null;

-- Add columns log fields to TAXON_INDICATOR_DUBLIN_CORE
ALTER TABLE atta.TAXON_INDICATOR_DUBLIN_CORE ADD COLUMN creation_date date not null;
ALTER TABLE atta.TAXON_INDICATOR_DUBLIN_CORE ADD COLUMN created_by character varying(255) not null;
ALTER TABLE atta.TAXON_INDICATOR_DUBLIN_CORE ADD COLUMN last_modification_date date not null;
ALTER TABLE atta.TAXON_INDICATOR_DUBLIN_CORE ADD COLUMN last_modification_by character varying(255) not null;

-- Add columns log fields to TAXON_INDICATOR_COMPONENT_PART
ALTER TABLE atta.TAXON_INDICATOR_COMPONENT_PART ADD COLUMN creation_date date not null;
ALTER TABLE atta.TAXON_INDICATOR_COMPONENT_PART ADD COLUMN created_by character varying(255) not null;
ALTER TABLE atta.TAXON_INDICATOR_COMPONENT_PART ADD COLUMN last_modification_date date not null;
ALTER TABLE atta.TAXON_INDICATOR_COMPONENT_PART ADD COLUMN last_modification_by character varying(255) not null;



---------------------------------------------------
------------  MÓDULO DE TRANSACCIONES  ------------
---------------------------------------------------

--2010.06.28 echinchilla
-- Eliminando la columna obj_version de la tabla atta.transaction
alter table atta.transaction drop column obj_version;

--2010.06.28 echinchilla
-- Eliminando la columna obj_version de la tabla atta.transaction_type
alter table atta.transaction_type drop column obj_version;

--2010.06.28 echinchilla
-- Eliminando la columna obj_version de la tabla atta.transacted_specimen_status
alter table atta.transacted_specimen_status drop column obj_version;

--2010.06.28 echinchilla
-- Eliminando la columna obj_version de la tabla atta.transacted_specimen
alter table atta.transacted_specimen drop column obj_version;


--2010.06.28 echinchilla
-- Nuevo sequence para la tabla de transaction
CREATE SEQUENCE atta.transaction_seq;
ALTER TABLE atta.transaction_seq OWNER TO atta;
-- Asignar dicho sequence al atributo correspondiente de la tabla
ALTER TABLE atta.transaction  ALTER COLUMN transaction_id SET DEFAULT nextval('atta.transaction_seq'::regclass);

--2010.06.28 echinchilla
-- Nuevo sequence para la tabla de transaction_type
CREATE SEQUENCE atta.transaction_type_seq;
ALTER TABLE atta.transaction_type_seq OWNER TO atta;
-- Asignar dicho sequence al atributo correspondiente de la tabla
ALTER TABLE atta.transaction_type  ALTER COLUMN transaction_type_id SET DEFAULT nextval('atta.transaction_type_seq'::regclass);

--2010.06.28 echinchilla
-- Nuevo sequence para la tabla de transacted_specimen_status
CREATE SEQUENCE atta.transacted_specimen_status_seq;
ALTER TABLE atta.transacted_specimen_status_seq OWNER TO atta;
-- Asignar dicho sequence al atributo correspondiente de la tabla
ALTER TABLE atta.transacted_specimen_status  ALTER COLUMN transacted_specimen_status_id SET DEFAULT nextval('atta.transacted_specimen_status_seq'::regclass);

--2010.06.28 echinchilla
-- Agregar columna faltante a tabla de transacciones
ALTER TABLE atta.transaction ADD COLUMN creation_date date;
ALTER TABLE atta.transaction ALTER COLUMN creation_date SET STORAGE PLAIN;
ALTER TABLE atta.transaction ALTER COLUMN creation_date SET NOT NULL;

--2010.06.28 echinchilla
-- Cambiar el tipo de la columna CREATION_DATE de DATE a TIMESTAMP
-- en la tabla TRANSACTED_SPECIMEN, para ordenar los especímenes transados.
ALTER TABLE atta.transacted_specimen
	ALTER COLUMN creation_date TYPE timestamp;

--2010.06.29 echinchilla
-- Agregar columna de descripción para transacted_specimen, necesario para botánica.
ALTER TABLE atta.transacted_specimen
    ADD COLUMN description character varying(500);

--2010.07.30 echinchilla
-- Agregar columna de En Espera de Devolución para transacted_specimen.
ALTER TABLE atta.transacted_specimen
   ADD COLUMN waiting_for_return boolean NOT NULL;

--2010.08.05 echinchilla
-- Cambiar el tipo de la columna CREATION_DATE de TIMESTAMP a DATE
-- en la tabla TRANSACTED_SPECIMEN.
ALTER TABLE atta.transacted_specimen
	ALTER COLUMN creation_date TYPE date;

--2010.08.05 echinchilla
-- Agregar columna de fecha y hora de creación a la tabla
-- TRANSACTED_SPECIMEN, para ordenar los especímenes.
ALTER TABLE atta.transacted_specimen
	ADD COLUMN creation_date_and_time timestamp NOT NULL;

---------------------------------------------------
----------  FIN MÓDULO DE TRANSACCIONES  ----------
---------------------------------------------------


--
-- CAMBIOS PARA EL MODULO DE SEMEN
--

--2010.08.20 dasolano. quita los not null no requeriros de la tabla semental
ALTER TABLE atta.semental ALTER COLUMN color DROP NOT NULL;
ALTER TABLE atta.semental ALTER COLUMN condition_id DROP NOT NULL;

--2010.08.20 dasolano. quita los not null no requeridos de la tabla semen_gathering
ALTER TABLE atta.semen_gathering ALTER COLUMN semen_gathering_time DROP NOT NULL;
ALTER TABLE atta.semen_gathering ALTER COLUMN concentration DROP NOT NULL;
ALTER TABLE atta.semen_gathering ALTER COLUMN straw_quantity DROP NOT NULL;
ALTER TABLE atta.semen_gathering ALTER COLUMN dilution DROP NOT NULL;
ALTER TABLE atta.semen_gathering ALTER COLUMN tank_number DROP NOT NULL;
ALTER TABLE atta.semen_gathering ALTER COLUMN canister_number DROP NOT NULL;
ALTER TABLE atta.semen_gathering ALTER COLUMN goblet_number DROP NOT NULL;
ALTER TABLE atta.semen_gathering ALTER COLUMN straw_color DROP NOT NULL;
ALTER TABLE atta.semen_gathering ALTER COLUMN active_doses DROP NOT NULL;
ALTER TABLE atta.semen_gathering ALTER COLUMN straw_size DROP NOT NULL;
ALTER TABLE atta.semen_gathering ALTER COLUMN semen_gathering_method_id DROP NOT NULL;
ALTER TABLE atta.semen_gathering ALTER COLUMN consistency DROP NOT NULL;
ALTER TABLE atta.semen_gathering ALTER COLUMN semen_color DROP NOT NULL;
ALTER TABLE atta.semen_gathering ALTER COLUMN ph DROP NOT NULL;
ALTER TABLE atta.semen_gathering ALTER COLUMN mass_motility DROP NOT NULL;
ALTER TABLE atta.semen_gathering ALTER COLUMN solvent_id DROP NOT NULL;
ALTER TABLE atta.semen_gathering ALTER COLUMN current_straw_quantity DROP NOT NULL;
ALTER TABLE atta.semen_gathering ALTER COLUMN post_thaw_motility DROP NOT NULL;


CREATE TABLE atta.semen_consistency(
semen_consistency_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE atta.semen_consistency OWNER TO atta;

ALTER TABLE ONLY atta.semen_consistency ADD CONSTRAINT "SEMEN_COSISTENCY_ID_PK" PRIMARY KEY (semen_consistency_id);


--2010.08.20 dasolano. Elmina la columna consistencia y agrega la de semen_cosistency_id
ALTER TABLE atta.semen_gathering DROP COLUMN consistency;
ALTER TABLE atta.semen_gathering ADD COLUMN semen_consistency_id numeric;
ALTER TABLE ONLY atta.semen_gathering ADD CONSTRAINT semen_consistency_id_fk FOREIGN KEY (semen_consistency_id) REFERENCES atta.semen_consistency(semen_consistency_id);

--2010.08.20 dasolano. Secuence para el historico de identificadores
CREATE SEQUENCE atta.semen_consistency_seq;
ALTER TABLE atta.semen_consistency_seq OWNER TO atta;

ALTER TABLE atta.semen_consistency ALTER COLUMN semen_consistency_id
SET DEFAULT nextval('atta.semen_consistency_seq'::regclass);

--
-- Cambios modulo de semen
--
--2010.09.09
--Se agregaron nuevos campos a las recolecciones de semen
ALTER TABLE atta.semen_gathering ADD COLUMN total_sperm_concentration numeric;
ALTER TABLE atta.semen_gathering ADD COLUMN sperm_concentration_per_straw numeric;
--final de los cambios


create table atta.TAXON_INDICATOR_COUNTRY  (
   COUNTRY_ID    	numeric NOT NULL,
   INDICATOR_ID         numeric NOT NULL,
   TAXON_ID             numeric NOT NULL,
   created_by character varying(20) NOT NULL,
   creation_date date NOT NULL,
   last_modification_by character varying(20) NOT NULL,
   last_modification_date date NOT NULL);

ALTER TABLE ONLY atta.TAXON_INDICATOR_COUNTRY ADD CONSTRAINT TAXON_INDICATOR_COUNTRY_ID_PK PRIMARY KEY (COUNTRY_ID,INDICATOR_ID, TAXON_ID);
ALTER TABLE ONLY atta.TAXON_INDICATOR_COUNTRY ADD CONSTRAINT TAXON_INDICATOR_COUNTRY_fk FOREIGN KEY (INDICATOR_ID, TAXON_ID) REFERENCES atta.TAXON_INDICATOR(INDICATOR_ID, TAXON_ID);
ALTER TABLE ONLY atta.TAXON_INDICATOR_COUNTRY OWNER TO atta;


ALTER TABLE atta.TAXON_INDICATOR ALTER COLUMN VALUER_PERSON_ID DROP NOT NULL;

--2010.11.08 gsulca
UPDATE atta.indicator SET applies_to_parts=0 WHERE name='Atributos Taxonómicos';

--2010.11.18 gsulca
ALTER TABLE atta.taxon_author_connector DROP COLUMN obj_version;
-- Secuence para taxon_author_connector
CREATE SEQUENCE atta.taxon_author_connector_seq;
ALTER TABLE atta.taxon_author_connector_seq OWNER TO atta;
ALTER TABLE atta.taxon_author_connector ALTER COLUMN taxon_author_connector_id
SET DEFAULT nextval('atta.taxon_author_connector_seq'::regclass);


---------------------------------------------
    -- TABLES FOR LABELS MODULE --
---------------------------------------------
--2010.11.29 pcorrales

-- Addition of columns to support new features.
ALTER TABLE atta.label ALTER COLUMN initial_date TYPE timestamp without time zone;
ALTER TABLE atta.label ALTER COLUMN initial_date SET NOT NULL;
ALTER TABLE atta.label DROP COLUMN obj_version;
ALTER TABLE atta.label ADD COLUMN final_date timestamp without time zone;
ALTER TABLE atta.label ADD COLUMN label_type_id numeric;
ALTER TABLE atta.label ADD COLUMN ancestor_label_id numeric;

--create sequence
CREATE SEQUENCE atta.label_seq;
ALTER TABLE atta.label_seq OWNER TO atta;

--add sequence
ALTER TABLE atta.label  ALTER COLUMN label_id  SET DEFAULT nextval('atta.label_seq'::regclass);

------------------------------------------------------------------------------------------------

-- drop unnecesary column
ALTER TABLE atta.label_history DROP COLUMN obj_version;

-- Add new columns to support new features.
ALTER TABLE atta.label_history ALTER COLUMN initial_date TYPE timestamp without time zone;
ALTER TABLE atta.label_history ALTER COLUMN initial_date SET NOT NULL;
ALTER TABLE atta.label_history ALTER COLUMN final_date TYPE timestamp without time zone;
ALTER TABLE atta.label_history ADD COLUMN ancestor_label_id numeric;


--add primary key
ALTER TABLE  atta.label_history ADD CONSTRAINT label_history_pk PRIMARY KEY (label_id,initial_date);

--add foreing key
ALTER TABLE  atta.label_history  ADD CONSTRAINT label_fk FOREIGN KEY (label_id)
      REFERENCES atta.label (label_id);


------------------------------------------------------------------------------------------------

-- drop unnecesary column
ALTER TABLE atta.original_label DROP COLUMN obj_version;


-- Secuence for original label
CREATE SEQUENCE atta.original_label_seq;
ALTER TABLE atta.original_label_seq OWNER TO atta;

ALTER TABLE atta.original_label  ALTER COLUMN original_label_id  SET DEFAULT nextval('atta.original_label_seq'::regclass);

---- modificar  la tabla de specimen para que posee el campo de label

ALTER TABLE atta.specimen  ADD COLUMN label_id numeric;
ALTER TABLE atta.specimen  ADD COLUMN  original_label_id numeric;

---------------------------------------------
    -- TABLES FOR FORMAT LABEL MODULE --
---------------------------------------------
--2010.11.29 pcorrales

-------------------------------------------------------------
-- Table: atta.funcionality_type

CREATE TABLE atta.funcionality_type
(
  funcionality_type_id numeric NOT NULL,
  funcionality_type_keyword character varying(100) NOT NULL,
  description character varying(100) NOT NULL,
  creation_date date NOT NULL,
  created_by character varying(100) NOT NULL,
  last_modification_date date NOT NULL,
  last_modification_by character varying(100) NOT NULL
);

ALTER TABLE atta.funcionality_type ADD CONSTRAINT pk_funcionality_id PRIMARY KEY (funcionality_type_id);

-------------------------------------------------------------
--create tabel report layout

CREATE TABLE atta.report_layout
(
  report_layout_id numeric NOT NULL,
  report_layout_keyword character varying(100) NOT NULL,
  description character varying(100) NOT NULL,
  contents character varying(4000) NOT NULL,
  creation_date date NOT NULL,
  created_by character varying(100) NOT NULL,
  last_modification_date date NOT NULL,
  last_modification_by character varying(100) NOT NULL,
  funcionality_type_id numeric
);

--add primary key
ALTER TABLE atta.report_layout ADD CONSTRAINT pk_report_id PRIMARY KEY (report_layout_id);

--add foreing key
ALTER TABLE atta.report_layout ADD CONSTRAINT funcionality_type_fk FOREIGN KEY (funcionality_type_id)
      REFERENCES atta.funcionality_type (funcionality_type_id);

------------------------------------------------------------------------------------------

-- create Table: atta.report_layout_category


CREATE TABLE atta.report_layout_category
(
  report_layout_category_id numeric NOT NULL,
  category_keyword character varying(100) NOT NULL,
  description character varying(100) NOT NULL,
  creation_date date NOT NULL,
  created_by character varying(100) NOT NULL,
  last_modification_date date NOT NULL,
  last_modification_by character varying(100) NOT NULL
);

--add primary key
ALTER TABLE atta.report_layout_category ADD  CONSTRAINT pk_category_id PRIMARY KEY (report_layout_category_id );

--------------------------------------------------------------------------------------------------
CREATE TABLE atta.report_layout_element
(
  report_layout_element_id numeric NOT NULL,
  report_layout_category_id numeric NOT NULL,
  report_layout_element_sequence numeric NOT NULL,
  element_keyword character varying(100) NOT NULL,
  description character varying(100) NOT NULL,
  element_required numeric NOT NULL,
  entity character varying(30),
  entity_key_field character varying(30),
  entity_main_field character varying(30),
  creation_date date NOT NULL,
  created_by character varying(100) NOT NULL,
  last_modification_date date NOT NULL,
  last_modification_by character varying(100) NOT NULL
);

--add primary key
ALTER TABLE atta.report_layout_element ADD CONSTRAINT pk_element_id PRIMARY KEY (report_layout_element_id);

--add foreing key
ALTER TABLE atta.report_layout_element ADD CONSTRAINT category_fk FOREIGN KEY (report_layout_category_id )
      REFERENCES atta.report_layout_category (report_layout_category_id);


---------------------------------------------------------------------------------------
--Table: atta.element_format;

CREATE TABLE atta.element_format
(
  element_format_id numeric NOT NULL,
  element_format_keyword character varying(100) NOT NULL,
  creation_date date NOT NULL,
  created_by character varying(100) NOT NULL,
  last_modification_date date NOT NULL,
  last_modification_by character varying(100) NOT NULL
);

--add primary key
ALTER TABLE atta.element_format ADD  CONSTRAINT pk_element_format_id PRIMARY KEY (element_format_id);


-------------------------------------------------------------------------------------

--Table: atta.report_layout_element_format

CREATE TABLE atta.report_layout_element_format
(
  element_format_id numeric NOT NULL,
  report_layout_element_id numeric NOT NULL,
  creation_date date NOT NULL,
  created_by character varying(100) NOT NULL,
  last_modification_date date NOT NULL,
  last_modification_by character varying(100) NOT NULL
);

--add primary key
ALTER TABLE  atta.report_layout_element_format ADD  CONSTRAINT pk_report_layout_element_format_id PRIMARY KEY (report_layout_element_id,element_format_id);

--add foreing key
ALTER TABLE  atta.report_layout_element_format ADD  CONSTRAINT report_layout_element_fk FOREIGN KEY (report_layout_element_id)
  REFERENCES atta.report_layout_element (report_layout_element_id);

---------------------------------------------------------------------------------

--Table: atta.element_format

CREATE TABLE atta.report_layout_selected_element
(
  report_layout_selected_element_id numeric NOT NULL,
  element_format_id numeric NOT NULL,
  report_layout_id numeric NOT NULL,
  report_layout_element_id numeric NOT NULL,
  creation_date date NOT NULL,
  created_by character varying(100) NOT NULL,
  last_modification_date date NOT NULL,
  last_modification_by character varying(100) NOT NULL

);

--add primary key

ALTER TABLE atta.report_layout_selected_element ADD CONSTRAINT pk_report_layout_selected_element_id PRIMARY KEY (report_layout_selected_element_id );

--add foreing key
ALTER TABLE atta.report_layout_selected_element ADD  CONSTRAINT element_format_fk FOREIGN KEY (element_format_id)
      REFERENCES atta.element_format (element_format_id);

ALTER TABLE atta.report_layout_selected_element ADD CONSTRAINT report_layout_element_fk FOREIGN KEY (report_layout_element_id)
      REFERENCES atta.report_layout_element (report_layout_element_id);

ALTER TABLE atta.report_layout_selected_element ADD CONSTRAINT report_layout_fk FOREIGN KEY (report_layout_id)
      REFERENCES atta.report_layout (report_layout_id);

alter table atta.report_layout OWNER TO atta;
alter table atta.report_layout_category OWNER TO atta;
alter table atta.report_layout_element OWNER TO atta;
alter table atta.report_layout_element_format OWNER TO atta;
alter table atta.report_layout_selected_element OWNER TO atta;
alter table atta.funcionality_type OWNER TO atta;
--2010.11.29 pcorrales End
---------------------------------------------


--2010.12.15 esmata and mvargas
-- Function: atta.taxon_nomenclatural_group_list(numeric, text)
-- DROP FUNCTION atta.taxon_nomenclatural_group_list(numeric, text);
CREATE OR REPLACE FUNCTION atta.taxon_nomenclatural_group_list(arg_taxon_id numeric, arg_separator text)
  RETURNS text AS
$BODY$
DECLARE
--Fetch var
aNomGroupID numeric;
aName text;
-- Result string
aNomGroupsList text;
taxonNomGroups CURSOR IS
   select  ng.nomenclatural_group_id, ng.name
      from atta.taxon_nomenclatural_group tng, atta.nomenclatural_group ng
      where tng.nomenclatural_group_id = ng.nomenclatural_group_id and
            tng.taxon_id = arg_taxon_id;
BEGIN
   -- Procedure Name: taxon_nomenclatural_group_list
   -- Retruns a taxons nomenclatural groups list.
   -- Created to be use during the generation of the Plinian Core snapshot.
   -- Revision History:
   --   June 19,  20010 - Manuel Vargas
   -- Arguments (input / output):
   --    arg_taxon_id NUMBER,                    Taxon identifier
   --    arg_separator                           Element separator

   aNomGroupsList = '';
   OPEN taxonNomGroups;
   FETCH taxonNomGroups INTO aNomGroupID, aName ;
   WHILE FOUND LOOP
     IF aName is not NULL THEN
        aNomGroupsList  = aNomGroupsList || aName || arg_separator;
     END IF;
     FETCH taxonNomGroups INTO aNomGroupID, aName ;
   END LOOP;
   CLOSE taxonNomGroups ;
   RETURN aNomGroupsList;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION atta.taxon_nomenclatural_group_list(numeric, text) OWNER TO atta;

--------------------------------------------------------------------------------
--2011.01.19 esmata
-- Adding a foreing key constrint to audience_id on table taxon_description_audience
ALTER TABLE atta.taxon_description_audience ADD CONSTRAINT audience_fk FOREIGN KEY (audience_id)
      REFERENCES atta.audience (audience_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;

--2011.01.21 gsulca
ALTER TABLE atta.taxon_author DROP COLUMN obj_version;
ALTER TABLE atta.taxon_author DROP COLUMN taxon_author_person_profile_id;
