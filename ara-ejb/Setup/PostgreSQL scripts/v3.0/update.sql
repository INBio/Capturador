-- Ara - capture species and specimen data
--
-- Copyright (C) 2009  INBio (Instituto Nacional de Biodiversidad)
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

--
-- Actualiza la base de datos para que corra con la version 3.0 del código
--  No crea la base de datos, sino que asumen que existe alguna previamente,
--  si no se cuenta con ninguna base de datos se debe ejecutar el script
--  araCreate2009-06-30.sql
--
--  created: 2009.08.12
--

-- 2009.08.12
--Cambia el tipo de la columna catalog_number a varhcar(100) pues antes era numeric
-- y este dato pordria contenter caracteres alfanumericos
alter table ara.specimen alter column catalog_number type varchar(100);

-- 2009.08.12
-- Borrar el sex_id de la tabla especimen pues se manejan en una tabla separada
-- por el tema de los "especimenenes" con varios individuos
alter table ara.specimen drop column sex_id;

-- 2009.08.12
-- Borrar el life_stage_id de la tabla especimen pues se manejan en una tabla separada
-- por el tema de los "especimenenes" con varios individuos
alter table ara.specimen drop column life_stage_id;

-- 2009.08.13
-- Cambia el tipo de la columna discarded a numeric pues antes era un varchar(1)
-- y este dato en realidad es un boolean (donde 1 es true y 0 es false)
alter table ara.specimen add column discarded_tmp numeric not null default 0;
update ara.specimen set discarded_tmp =1 where discarded='1';
alter table ara.specimen drop column discarded;
alter table ara.specimen rename discarded_tmp  to discarded;

-- 2009.08.14
-- En elfoque actual de mapeos no se utiliza la columna obj_version en la tablas:
-- specimen_life_stage_sex, specimen
alter table ara.specimen_life_stage_sex drop column obj_version;
alter table ara.specimen drop column obj_version;

alter table ara.identifier drop column obj_version;
alter table ara.identification drop column obj_version;
alter table ara.identifier_history drop column obj_version;
alter table ara.identification_history drop column obj_version;

-- Secuence para el historico de identificaciones
CREATE SEQUENCE ara.identification_history_seq;
ALTER TABLE ara.identification_history_seq OWNER TO ara;

-- Secuence para el historico de identificadores
CREATE SEQUENCE ara.identifier_history_seq;
ALTER TABLE ara.identifier_history_seq OWNER TO ara;

ALTER TABLE ara.identification_history  ALTER COLUMN identification_history_id SET DEFAULT nextval('ara.identification_history_seq'::regclass);
ALTER TABLE ara.identifier_history  ALTER COLUMN identifier_history_id SET DEFAULT nextval('ara.identifier_history_seq'::regclass);

--2009.09.01 esmata
-- Eliminando la columna obj_version de la tabla ara.gathering_observation
alter table ara.gathering_observation drop column obj_version;
--2009.09.01 esmata
-- Eliminando la columna obj_version de la tabla ara.protocol_attribute
alter table ara.protocol_attribute drop column obj_version;

--2009.09.01 esmata
-- Nuevo secuence para la tabla de gathering_observation
CREATE SEQUENCE ara.gathering_observation_seq;
ALTER TABLE ara.gathering_observation_seq OWNER TO ara;
-- Asignar dicho secuence al atributo correspondiente de la tabla
ALTER TABLE ara.gathering_observation ALTER COLUMN gathering_observation_id SET DEFAULT nextval('ara.gathering_observation_seq'::regclass);

--2009.09.02 esmata
-- Eliminando la columna obj_version de la tabla ara.collection_protocol
alter table ara.collection_protocol drop column obj_version;
-- Eliminando la columna obj_version de la tabla ara.collector_observer
alter table ara.collector_observer drop column obj_version;
-- Eliminando la columna obj_version de la tabla ara.gathering_observation_project
alter table ara.gathering_observation_project drop column obj_version;
-- Eliminando la columna obj_version de la tabla ara.gathering_observation_collection
alter table ara.gathering_observation_collection drop column obj_version;

--2009.09.07 esmata
-- Eliminando la columna obj_version de la tabla ara.morphological_description
alter table ara.morphological_description drop column obj_version;
-- Eliminando la columna obj_version de la tabla ara.gathering_observation_detail
alter table ara.gathering_observation_detail drop column obj_version;
-- Nuevo secuence para la tabla ara.morphological_description
CREATE SEQUENCE ara.morphological_description_seq;
ALTER TABLE ara.morphological_description_seq OWNER TO ara;
ALTER TABLE ara.morphological_description  ALTER COLUMN morphological_description_id SET DEFAULT nextval('ara.morphological_description_seq'::regclass);
-- Nuevo secuence para la tabla ara.gathering_observation_detail
CREATE SEQUENCE ara.gathering_observation_detail_seq;
ALTER TABLE ara.gathering_observation_detail_seq OWNER TO ara;
ALTER TABLE ara.gathering_observation_detail  ALTER COLUMN gathering_observation_detail_id SET DEFAULT nextval('ara.gathering_observation_detail_seq'::regclass);

--2009.09.21 esmata
-- Eliminando la columna obj_version de la tabla ara.taxon_category
alter table ara.taxon_category drop column obj_version;

--2009.09.22 esmata
-- Eliminando la columna obj_version de la tabla ara.system_user
alter table ara.system_user drop column obj_version;
-- Eliminando la columna obj_version de la tabla ara.system_user_type
alter table ara.system_user_type drop column obj_version;

--2009.09.22 jgutierrez
-- Nuevo secuence para la tabla ara.gathering_observation_detail
create sequence ara.collection_seq;
alter table ara.collection_seq owner to ara;
alter table ara.collection  alter column collection_id set default nextval('ara.collection_seq'::regclass);
alter table ara.collection drop column obj_version;

--2009.09.23 esmata
-- Eliminando la columna obj_version de la tabla ara.nomenclatural_group
alter table ara.nomenclatural_group drop column obj_version;
-- Eliminando la columna obj_version de la tabla ara.user_nomenclatural_group
alter table ara.user_nomenclatural_group drop column obj_version;
-- Eliminando la columna obj_version de la tabla ara.user_taxon
alter table ara.user_taxon drop column obj_version;

--2009.09.24 esmata
-- Nuevo secuence para la tabla ara.system_user
CREATE SEQUENCE ara.system_user_seq   INCREMENT 1  MINVALUE 1  MAXVALUE 9223372036854775807  START 72  CACHE 1;
ALTER TABLE ara.system_user_seq OWNER TO ara;
ALTER TABLE ara.system_user ALTER COLUMN user_id SET DEFAULT nextval('ara.system_user_seq '::regclass);

--2009.09.24 jgutierrez
-- Nuevo secuence para la tabla ara.gathering_observation_method
create sequence ara.gathering_observation_method_seq;
alter table ara.gathering_observation_method_seq owner to ara;
alter table ara.gathering_observation_method alter column gathering_observation_method_id set default nextval('ara.gathering_observation_method_seq'::regclass);
alter table ara.gathering_observation_method drop column obj_version;
--2009.09.24 jgutierrez
-- Nuevo secuence para la tabla ara.specimen_category
create sequence ara.specimen_category_seq;
alter table ara.specimen_category_seq owner to ara;
alter table ara.specimen_category alter column specimen_category_id set default nextval('ara.specimen_category_seq'::regclass);
alter table ara.specimen_category drop column obj_version;
--2009.09.24 jgutierrez
-- Nuevo secuence para la tabla ara.specimen_type
create sequence ara.specimen_type_seq;
alter table ara.specimen_type_seq owner to ara;
alter table ara.specimen_type alter column specimen_type_id set default nextval('ara.specimen_type_seq'::regclass);
alter table ara.specimen_type drop column obj_version;
--2009.09.24 jgutierrez
-- Nuevo secuence para la tabla ara.origin
create sequence ara.origin_seq;
alter table ara.origin_seq owner to ara;
alter table ara.origin alter column origin_id set default nextval('ara.origin_seq'::regclass);
alter table ara.origin drop column obj_version;
--2009.09.24 jgutierrez
-- Nuevo secuence para la tabla ara.preservation_medium
create sequence ara.preservation_medium_seq;
alter table ara.preservation_medium_seq owner to ara;
alter table ara.preservation_medium alter column preservation_medium_id set default nextval('ara.preservation_medium_seq'::regclass);
alter table ara.preservation_medium drop column obj_version;
--2009.09.24 jgutierrez
-- Nuevo secuence para la tabla ara.storage_type
create sequence ara.storage_type_seq;
alter table ara.storage_type_seq owner to ara;
alter table ara.storage_type alter column storage_type_id set default nextval('ara.storage_type_seq'::regclass);
alter table ara.storage_type drop column obj_version;
--2009.09.24 jgutierrez
-- Nuevo secuence para la tabla ara.life_stage
create sequence ara.life_stage_seq;
alter table ara.life_stage_seq owner to ara;
alter table ara.life_stage alter column life_stage_id set default nextval('ara.life_stage_seq'::regclass);
alter table ara.life_stage drop column obj_version;
--2009.09.24 jgutierrez
-- Nuevo secuence para la tabla ara.sex
create sequence ara.sex_seq;
alter table ara.sex_seq owner to ara;
alter table ara.sex alter column sex_id set default nextval('ara.sex_seq'::regclass);
alter table ara.sex drop column obj_version;
--2009.09.24 jgutierrez
-- Nuevo secuence para la tabla ara.substrate
create sequence ara.substrate_seq;
alter table ara.substrate_seq owner to ara;
alter table ara.substrate alter column substrate_id set default nextval('ara.substrate_seq'::regclass);
alter table ara.substrate drop column obj_version;
--2009.09.24 jgutierrez
-- Nuevo secuence para la tabla ara.life_form
create sequence ara.life_form_seq;
alter table ara.life_form_seq owner to ara;
alter table ara.life_form alter column life_form_id set default nextval('ara.life_form_seq'::regclass);
alter table ara.life_form drop column obj_version;
--2009.09.24 jgutierrez
-- Nuevo secuence para la tabla ara.extraction_type
create sequence ara.extraction_type_seq;
alter table ara.extraction_type_seq owner to ara;
alter table ara.extraction_type alter column extraction_type_id set default nextval('ara.extraction_type_seq'::regclass);
alter table ara.extraction_type drop column obj_version;
--2009.09.24 jgutierrez
-- Nuevo secuence para la tabla ara.exposition
create sequence ara.exposition_seq;
alter table ara.exposition_seq owner to ara;
alter table ara.exposition alter column exposition_id set default nextval('ara.exposition_seq'::regclass);
alter table ara.exposition drop column obj_version;

--2009.09.29 esmata
-- Nuevo secuence para la tabla ara.institution
create sequence ara.institution_seq;
alter table ara.institution_seq owner to ara;
alter table ara.institution alter column institution_id set default nextval('ara.institution_seq'::regclass);
alter table ara.institution drop column obj_version;

-- *******************************************   Actualizar los secuences con el valor maximo + 1   ************************************************
select setval('ara.identification_history_seq',cast(max(identification_history_id) as bigint)+1) from ara.identification_history;
select setval('ara.identifier_history_seq',cast(max(identifier_history_id) as bigint)+1) from ara.identifier_history;
select setval('ara.gathering_observation_seq',cast(max(gathering_observation_id) as bigint)+1) from ara.gathering_observation;
select setval('ara.morphological_description_seq',cast(max(morphological_description_id) as bigint)+1) from ara.morphological_description;
select setval('ara.gathering_observation_detail_seq',cast(max(gathering_observation_detail_id) as bigint)+1) from ara.gathering_observation_detail;
select setval('ara.system_user_seq',cast(max(user_id) as bigint)+1) from ara.system_user;
select setval('ara.collection_seq',cast(max(collection_id) as bigint)+1) from ara.collection;
select setval('ara.gathering_observation_method_seq',cast(max(gathering_observation_method_id) as bigint)+1) from ara.gathering_observation_method;
select setval('ara.specimen_category_seq',cast(max(specimen_category_id) as bigint)+1) from ara.specimen_category;
select setval('ara.specimen_type_seq',cast(max(specimen_type_id) as bigint)+1) from ara.specimen_type;
select setval('ara.origin_seq',cast(max(origin_id) as bigint)+1) from ara.origin;
select setval('ara.storage_type_seq',cast(max(storage_type_id) as bigint)+1) from ara.storage_type;
select setval('ara.life_stage_seq',cast(max(life_stage_id) as bigint)+1) from ara.life_stage;
select setval('ara.sex_seq',cast(max(sex_id) as bigint)+1) from ara.sex;
select setval('ara.substrate_seq',cast(max(substrate_id) as bigint)+1) from ara.substrate;
select setval('ara.life_form_seq',cast(max(life_form_id) as bigint)+1) from ara.life_form;
select setval('ara.extraction_type_seq',cast(max(extraction_type_id) as bigint)+1) from ara.extraction_type;
select setval('ara.exposition_seq',cast(max(exposition_id) as bigint)+1) from ara.exposition;
select setval('ara.preservation_medium_seq',cast(max(preservation_medium_id) as bigint)+1) from ara.preservation_medium;
select setval('ara.institution_seq',cast(max(institution_id) as bigint)+1) from ara.institution;
-- *************************************************************************************************************************************************

--2009.09.29 herson
-- Nuevo sequence para la tabla ara.especimen
create sequence ara.specimen_seq;
alter table ara.specimen_seq owner to ara;
alter table ara.specimen alter column specimen_id set default nextval('ara.specimen_seq'::regclass);
SELECT setval('ara.specimen_seq', cast(max(specimen_id) as bigint)+1) from ara.specimen;

--2009.09.29 james
-- Eliminando el obj_version de la tabla list_table_collection
alter table ara.list_table_collection drop column obj_version;

--2009.10.02 herson
-- Eliminando el obj_version de la tabla specimen_life_form
ALTER TABLE ara.specimen_life_form DROP COLUMN obj_version;

--2009.10.05 esmata
-- Eliminando el obj_version de la tabla ara.audience
ALTER TABLE ara.audience DROP COLUMN obj_version;
-- Eliminando el obj_version de la tabla ara.profile
ALTER TABLE ara.profile DROP COLUMN obj_version;
-- Eliminando el obj_version de la tabla ara.person_profile
ALTER TABLE ara.person_profile DROP COLUMN obj_version;
-- Nuevo sequence para la tabla ara.audience
create sequence ara.audience_seq;
alter table ara.audience_seq owner to ara;
alter table ara.audience alter column audience_id set default nextval('ara.audience_seq'::regclass);
SELECT setval('ara.audience_seq', cast(max(audience_id) as bigint)+1) from ara.audience;
-- Nuevo sequence para la tabla ara.profile
create sequence ara.profile_seq;
alter table ara.profile_seq owner to ara;
alter table ara.profile alter column profile_id set default nextval('ara.profile_seq'::regclass);
SELECT setval('ara.profile_seq', cast(max(profile_id) as bigint)+1) from ara.profile;

--2009.10.06 herson
ALTER TABLE ara.specimen
ALTER COLUMN collection_id SET NOT NULL;

--2009.10.07 esmata
-- Eliminando el obj_version de la tabla ara.person
ALTER TABLE ara.person DROP COLUMN obj_version;
-- Nuevo sequence para la tabla ara.person
create sequence ara.person_seq;
alter table ara.person_seq owner to ara;
alter table ara.person alter column person_id set default nextval('ara.person_seq'::regclass);
SELECT setval('ara.person_seq', cast(max(person_id) as bigint)+1) from ara.person ;

--2009.10.08
-- Eliminando el obj_version de la tabla ara.person_institution
ALTER TABLE ara.person_institution DROP COLUMN obj_version;

--2009.10.13
-- Eliminando el obj_version de la tabla ara.taxon_description
ALTER TABLE ara.taxon_description DROP COLUMN obj_version;
-- Eliminando el obj_version de la tabla ara.taxon_description_stage
ALTER TABLE ara.taxon_description_stage DROP COLUMN obj_version;

--2009.10.14
-- Nuevo sequence para la tabla ara.taxon_description_stage
create sequence ara.taxon_description_stage_seq;
alter table ara.taxon_description_stage_seq owner to ara;
alter table ara.taxon_description_stage alter column taxon_description_stage_id set default nextval('ara.taxon_description_stage_seq'::regclass);
SELECT setval('ara.taxon_description_stage_seq', cast(max(taxon_description_stage_id) as bigint)+1) from ara.taxon_description_stage ;
-- Insertando nuevo valor requerido
INSERT INTO ara.taxon_description_stage (name, description, created_by, creation_date, last_modification_by, last_modification_date) VALUES ('Publicado', 'Registro de especie publicado', 'admin', '2009-10-14', 'admin', '2009-10-14');

--2009.10.15
-- Eliminando el obj_version de la tabla ara."language"
ALTER TABLE ara."language" DROP COLUMN obj_version;
-- Eliminando el obj_version de la tabla ara.person_institution
ALTER TABLE ara.concept DROP COLUMN obj_version;

--2009.10.19
-- Eliminando el obj_version de la tabla ara.taxon_description_audience
ALTER TABLE ara.taxon_description_audience DROP COLUMN obj_version;
-- Eliminando el obj_version de la ara.taxon_description_institution
ALTER TABLE ara.taxon_description_institution DROP COLUMN obj_version;
-- Eliminando el obj_version de la ara.taxon_description_person_profile
ALTER TABLE ara.taxon_description_person_profile DROP COLUMN obj_version;

--2009.10.21 herson
-- Obj_version
ALTER TABLE ara.taxon_description_element DROP COLUMN obj_version;
ALTER TABLE ara.taxon_description_category DROP COLUMN obj_version;
ALTER TABLE ara.taxon_description_datatype DROP COLUMN obj_version;

--2009.10.21 esmata
ALTER TABLE ara.taxon_description_record_reference DROP COLUMN obj_version;
ALTER TABLE ara.taxon_description_record DROP COLUMN obj_version;
ALTER TABLE ara.reference DROP COLUMN obj_version;
ALTER TABLE ara.reference_type DROP COLUMN obj_version;
ALTER TABLE ara.interaction_type DROP COLUMN obj_version;
ALTER TABLE ara.geographic_catalogue DROP COLUMN obj_version;
ALTER TABLE ara.geographic_entity DROP COLUMN obj_version;

--2009.10.28 esmata
-- Nuevo sequence para la tabla ara.taxon_description_record
create sequence ara.taxon_description_record_seq;
alter table ara.taxon_description_record_seq owner to ara;
alter table ara.taxon_description_record alter column taxon_description_record_id set default nextval('ara.taxon_description_record_seq'::regclass);
SELECT setval('ara.taxon_description_record_seq', cast(max(taxon_description_record_id) as bigint)+1) from ara.taxon_description_record ;
-- Nuevo sequence para la tabla ara.taxon_description_record
create sequence ara.taxon_description_element_seq;
alter table ara.taxon_description_element_seq owner to ara;
alter table ara.taxon_description_element alter column taxon_description_element_id set default nextval('ara.taxon_description_element_seq'::regclass);
SELECT setval('ara.taxon_description_element_seq', cast(max(taxon_description_element_id) as bigint)+1) from ara.taxon_description_element ;

--2009.11.04 esmata
-- Cambiando valor "name" por "value", esto para el correcto funcionamiento del modulo de especies
UPDATE ara.taxon_description_element SET main_field_name ='value' WHERE taxon_description_element_id=44;

--2009.11.06 esmata
-- Agregando valor default a la tabla ara.geographic_catalogue
delete from ara.geographic_catalogue;
INSERT INTO ara.geographic_catalogue(
            geographic_catalogue_id, "name", description, creation_date,
            created_by, last_modification_date, last_modification_by)
    VALUES (1,'Gazetteer', 'Gazetteer', '2009-11-01',
            'admin', '2009-11-01', 'admin');

--2009.11.16 esmata
-- Obj_version
ALTER TABLE ara.geographic_layer DROP COLUMN obj_version;

--2009.11.17 esmata
-- Nuevo sequence para la tabla ara.country
create sequence ara.country_seq;
alter table ara.country_seq owner to ara;
alter table ara.country alter column country_id set default nextval('ara.country_seq'::regclass);
SELECT setval('ara.country_seq', cast(max(country_id) as bigint)+1) from ara.country ;
-- Obj_version
ALTER TABLE ara.country DROP COLUMN obj_version;

-- Nuevo sequence para la tabla ara.province
create sequence ara.province_seq;
alter table ara.province_seq owner to ara;
alter table ara.province alter column province_id set default nextval('ara.province_seq'::regclass);
SELECT setval('ara.province_seq', cast(max(province_id) as bigint)+1) from ara.province;
-- Obj_version
ALTER TABLE ara.province  DROP COLUMN obj_version;

--2009.11.18 esmata
-- Obj_version
ALTER TABLE ara.site  DROP COLUMN obj_version;
-- Obj_version
ALTER TABLE ara.site_calculation_method  DROP COLUMN obj_version;
-- Obj_version
ALTER TABLE ara.site_coordinate  DROP COLUMN obj_version;
-- Nuevo sequence para la tabla ara.site
create sequence ara.site_seq;
alter table ara.site_seq owner to ara;
alter table ara.site alter column site_id set default nextval('ara.site_seq'::regclass);
SELECT setval('ara.site_seq', cast(max(site_id) as bigint)+1) from ara.site;
-- Nuevo sequence para la tabla ara.site_coordinate
create sequence ara.site_coordinate_seq;
alter table ara.site_coordinate_seq owner to ara;
alter table ara.site_coordinate alter column site_coordinate_id set default nextval('ara.site_coordinate_seq'::regclass);
SELECT setval('ara.site_coordinate_seq', cast(max(site_coordinate_id) as bigint)+1) from ara.site_coordinate;

-- 2009.11.19 herson
ALTER TABLE ara.nomenclatural_group_region DROP COLUMN obj_version;
ALTER TABLE ara.taxon_nomenclatural_group DROP COLUMN obj_version;

--2009.11.19 esmata
ALTER TABLE ara.feature_type DROP COLUMN obj_version;
ALTER TABLE ara.projection DROP COLUMN obj_version;

-- 2009.11.19 herson
ALTER TABLE ara.region DROP COLUMN obj_version;

--2009.11.20 esmata
ALTER TABLE ara.georeferenced_site DROP COLUMN obj_version;

-- 2009.11.21
ALTER TABLE ara.taxon DROP COLUMN obj_version;

-- Nuevo sequence para la tabla ara.site
create sequence ara.taxon_seq;
alter table ara.taxon_seq owner to ara;
alter table ara.taxon alter column taxon_id set default nextval('ara.taxon_seq'::regclass);
SELECT setval('ara.taxon_seq', cast(max(taxon_id) as bigint)+1) from ara.taxon;

-- 2009-11-24 herson
create sequence ara.nomenclatural_group_seq;
alter table ara.nomenclatural_group_seq owner to ara;
alter table ara.nomenclatural_group alter column nomenclatural_group_id set default nextval('ara.nomenclatural_group_seq'::regclass);
SELECT setval('ara.nomenclatural_group_seq', cast(max(nomenclatural_group_id) as bigint)+1) from ara.nomenclatural_group;

-- 2009-11-25 asanabria
-- Add root element for the taxonomy.
insert INTO ara.taxon( taxonomical_range_id
            , current_name
            , current_name_timestamp
            , default_name
            , taxon_category_id
            , creation_date
            , created_by
            , last_modification_date
            , last_modification_by
            ,author_format_parenthesis)
		VALUES ( 0
            , 'Base de la taxonomía'
            , now()
            , 'Base de la taxonomía'
            , 1
            , now()
            , 'admin'
            , now()
            , 'admin'
            , 0);

update ara.taxon
	set ancestor_id = (select cast(max(taxon_id) as bigint) from ara.taxon)
	where taxonomical_range_id = 23;

--2009.11.27 esmata
--Agregando elementos de la extencion curatorial y geospatial al snapshot darwin core
INSERT INTO ara.dwc_category(
            category_id, category_name, category_keyword)
    VALUES (8, 'Curatorial', 'curatorial');
INSERT INTO ara.dwc_category(
            category_id, category_name, category_keyword)
    VALUES (9, 'Geospatial', 'geospatial');

INSERT INTO ara.dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (47, 'CatalogNumberNumeric', 'catalognumbernumeric', 8, '0');
INSERT INTO ara.dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (48, 'IdentifiedBy', 'identifiedby', 8, '0');
INSERT INTO ara.dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (49, 'DateIdentified', 'dateidentified', 8, '0');
INSERT INTO ara.dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (50, 'CollectorNumber', 'collectornumber', 8, '0');
INSERT INTO ara.dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (51, 'FieldNumber', 'fieldnumber', 8, '0');
INSERT INTO ara.dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (52, 'FieldNotes', 'fieldnotes', 8, '0');
INSERT INTO ara.dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (53, 'VerbatimCollectingDate', 'verbatimcollectingdate', 8, '0');
INSERT INTO ara.dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (54, 'VerbatimElevation', 'verbatimelevation', 8, '0');
INSERT INTO ara.dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (55, 'Preparations', 'preparations', 8, '0');
INSERT INTO ara.dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (56, 'TypeStatus', 'typestatus', 8, '0');
INSERT INTO ara.dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (57, 'OtherCatalogNumbers', 'othercatalognumbers', 8, '0');
INSERT INTO ara.dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (58, 'Disposition', 'disposition', 8, '0');
INSERT INTO ara.dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (59, 'IndividualCount', 'individualcount', 8, '0');
INSERT INTO ara.dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (60, 'DecimalLatitude', 'decimallatitude', 9, '0');
INSERT INTO ara.dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (61, 'DecimalLongitude', 'decimallongitude', 9, '0');
INSERT INTO ara.dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (62, 'GeodeticDatum', 'geodeticdatum', 9, '0');
INSERT INTO ara.dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (63, 'CoordinateUncertaintyInMeters', 'coordinateuncertaintyinmeters', 9, '0');
INSERT INTO ara.dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (64, 'PointRadiusSpatialFit', 'pointradiusspatialfit', 9, '0');
INSERT INTO ara.dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (65, 'VerbatimCoordinates', 'verbatimcoordinates', 9, '0');
INSERT INTO ara.dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (66, 'VerbatimLatitude', 'verbatimlatitude', 9, '0');
INSERT INTO ara.dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (67, 'VerbatimLongitude', 'verbatimlongitude', 9, '0');
INSERT INTO ara.dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (68, 'VerbatimCoordinateSystem', 'verbatimcoordinatesystem', 9, '0');
INSERT INTO ara.dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (69, 'GeoreferenceProtocol', 'georeferenceprotocol', 9, '0');
INSERT INTO ara.dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (70, 'GeoreferenceSources', 'georeferencesources', 9, '0');
INSERT INTO ara.dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (71, 'GeoreferenceVerificationStatus', 'georeferenceverificationstatus', 9, '0');
INSERT INTO ara.dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (72, 'GeoreferenceRemarks', 'georeferenceremarks', 9, '0');
INSERT INTO ara.dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (73, 'FootprintWKT', 'footprintwkt', 9, '0');
INSERT INTO ara.dwc_element (element_id, element_name, element_keyword, element_category_id, element_required) VALUES (74, 'FootprintSpatialFit', 'footprintspatialfit', 9, '0');

alter table ara.dwc_snapshot add column catalognumbernumeric  numeric;
alter table ara.dwc_snapshot add column identifiedby varchar;
alter table ara.dwc_snapshot add column dateidentified timestamp;
alter table ara.dwc_snapshot add column collectornumber varchar;
alter table ara.dwc_snapshot add column fieldnumber  varchar;
alter table ara.dwc_snapshot add column fieldnotes varchar;
alter table ara.dwc_snapshot add column verbatimcollectingdate varchar;
alter table ara.dwc_snapshot add column verbatimelevation double precision;
alter table ara.dwc_snapshot add column preparations varchar;
alter table ara.dwc_snapshot add column typestatus varchar;
alter table ara.dwc_snapshot add column othercatalognumbers varchar;
alter table ara.dwc_snapshot add column disposition varchar;
alter table ara.dwc_snapshot add column individualcount numeric;
alter table ara.dwc_snapshot add column decimallatitude varchar;
alter table ara.dwc_snapshot add column decimallongitude varchar;
alter table ara.dwc_snapshot add column geodeticdatum varchar;
alter table ara.dwc_snapshot add column coordinateuncertaintyinmeters varchar;
alter table ara.dwc_snapshot add column pointradiusspatialfit decimal;
alter table ara.dwc_snapshot add column verbatimcoordinates varchar;
alter table ara.dwc_snapshot add column verbatimlatitude varchar;
alter table ara.dwc_snapshot add column verbatimlongitude varchar;
alter table ara.dwc_snapshot add column verbatimcoordinatesystem varchar;
alter table ara.dwc_snapshot add column georeferenceprotocol varchar;
alter table ara.dwc_snapshot add column georeferencesources varchar;
alter table ara.dwc_snapshot add column georeferenceverificationstatus varchar;
alter table ara.dwc_snapshot add column georeferenceremarks varchar;
alter table ara.dwc_snapshot add column footprintwkt varchar;
alter table ara.dwc_snapshot add column footprintspatialfit  decimal;

-- Hata aquí quedó la versión para Panamá  --

--2010.01.18 esmata
-- Eliminar la tabla ara.pli_element
drop table ara.pli_element;

--2010.01.18 esmata
-- Crear tabla plinian_core_flat (Tabla principal para generar el snapshot plinian)
Create table ara.plinian_core_flat
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
ALTER TABLE ara.plinian_core_flat OWNER TO ara;

--2010.01.18 esmata
-- Tabla para definir los elementos del standard plinian core
CREATE TABLE ara.plic_element (
    element_id numeric NOT NULL,
    element_name character varying(150) NOT NULL,
    element_keyword character varying NOT NULL,
    element_required character varying(1) NOT NULL
);
ALTER TABLE ara.plic_element OWNER TO ara;
ALTER TABLE ONLY ara.plic_element ADD CONSTRAINT plic_elements_pk PRIMARY KEY (element_id);

--2010.01.18 esmata
--Insertando los elementos del standard plinian core
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (1, 'GlobalUniqueIdentifier', 'globaluniqueidentifier', '1');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (2, 'ScientificName', 'scientificname', '1');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (3, 'InstitutionCode', 'institutioncode', '1');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (4, 'DateLastModified', 'datelastmodified', '1');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (5, 'TaxonRecordID', 'taxonrecordid', '1');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (6, 'Language', 'language', '1');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (7, 'Creators', 'creators', '1');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (8, 'Distribution', 'distribution', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (9, 'Abstract', 'abstract1', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (10, 'KingdomTaxon', 'kingdomtaxon', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (11, 'PhylumTaxon', 'phylumtaxon', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (12, 'ClassTaxon', 'classtaxon', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (13, 'OrderTaxon', 'ordertaxon', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (14, 'FamilyTaxon', 'familytaxon', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (15, 'GenusTaxon', 'genustaxon', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (16, 'Synonyms', 'synonyms', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (17, 'AuthorYearOfScientificName', 'authoryearofscientificname', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (18, 'SpeciesPublicationReference', 'speciespublicationreference', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (19, 'CommonNames', 'commonnames', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (20, 'Typification', 'typification', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (21, 'Contributors', 'contributors', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (22, 'DateCreated', 'datecreated', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (23, 'Habit', 'habit', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (24, 'LifeCycle', 'lifecycle', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (25, 'Reproduction', 'reproduction', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (26, 'AnnualCycle', 'annualcycle', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (27, 'ScientificDescription', 'scientificdescription', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (28, 'BriefDescription', 'briefdescription', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (29, 'Feeding', 'feeding', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (30, 'Behavior', 'behavior', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (31, 'Interactions', 'interactions', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (32, 'ChromosomicNumberN', 'chromosomicnumbern', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (33, 'MolecularData', 'moleculardata', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (34, 'PopulationBiology', 'populationbiology', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (35, 'ThreatStatus', 'threatstatus', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (36, 'Legislation', 'legislation', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (37, 'Habitat', 'habitat', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (38, 'Territory', 'territory', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (39, 'Endemicity', 'endemicity', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (40, 'TheUses', 'theuses', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (41, 'TheManagement', 'themanagement', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (42, 'Folklore', 'folklore', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (43, 'TheReferences', 'thereferences', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (44, 'UnstructuredDocumentation', 'unstructureddocumentation', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (45, 'OtherInformationSources', 'otherinformationsources', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (46, 'Papers', 'papers', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (47, 'IdentificationKeys', 'identificationkeys', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (48, 'MigratoryData', 'migratorydata', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (49, 'EcologicalSignificance', 'ecologicalsignificance', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (50, 'UnstructuredNaturalHistory', 'unstructurednaturalhistory', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (51, 'InvasivenessData', 'invasivenessdata', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (52, 'TargetAudiences', 'targetaudiences', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (53, 'Version', 'version', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (54, 'URLImage1', 'urlimage1', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (55, 'CaptionImage1', 'captionimage1', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (56, 'URLImage2', 'urlimage2', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (57, 'CaptionImage2', 'captionimage2', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (58, 'UrlImage3', 'urlimage3', '0');
INSERT INTO ara.plic_element (element_id, element_name, element_keyword, element_required) VALUES (59, 'CaptionImage3', 'captionimage3', '0');

--2010.01.18 esmata
-- Crear tabla para generar el snapshot de plinian core
Create table ara.plic_snapshot
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
ALTER TABLE ara.plic_snapshot OWNER TO ara;


--2010.01.18 esmata
-- Update para que funcione correctamente la generacion del snapshot de plinian core
update ara.taxon_description_category set standard_concept = 'Interactions' where taxon_description_category_id = 17;
update ara.taxon_description_category set standard_concept = 'Distribution' where taxon_description_category_id = 29;
update ara.taxon_description_category set standard_concept = 'Distribution' where taxon_description_category_id = 30;
update ara.taxon_description_category set standard_concept = 'Abstract' where taxon_description_category_id = 67;
update ara.taxon_description_category set standard_concept = 'Legislation' where taxon_description_category_id = 43;
update ara.taxon_description_category set standard_concept = 'Legislation' where taxon_description_category_id = 44;
update ara.taxon_description_category set standard_concept = 'Endemicity' where taxon_description_category_id = 33;
update ara.taxon_description_category set standard_concept = 'Endemicity' where taxon_description_category_id = 32;

                    -------------------------------------------------------------
                    -- Required functions to create the plinian core snapshot ---
                    -------------------------------------------------------------
--2010.03.18 esmata
create or replace function ara.taxon_description_audience_list (arg_taxon_id NUMERIC, arg_taxon_description_sequence NUMERIC,
                                       arg_separator TEXT) returns text as '
DECLARE

--Fetch var
aAudienceID numeric;
aName text;

-- Result string
aAudienceList text;

taxonDescAudience CURSOR IS
   select  a.audience_id, a.name
      from ara.taxon_description_audience tda, ara.audience a
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
create or replace function ara.species_standard_element_content (arg_taxon_id NUMERIC, arg_taxon_description_sequence NUMERIC,
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
   from ara.taxon_description_category tdc, ara.taxon_description_element tde, ara.taxon_description_record tdr
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
   -- Nota:  En la tabla ara.taxon_description_element existe un campo que se llama table_name en el cual por error
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
               SELECT name INTO aLabelTemp  FROM ara.Interaction_Type
                 WHERE interaction_type_id = aContentsNum ;
            END IF;

            IF TRIM(aTableName) = ''GeographicCatalogue'' THEN
               SELECT name INTO aLabelTemp  FROM ara.Geographic_Catalogue
                 WHERE geographic_catalogue_id = aContentsNum ;
            END IF;

            IF TRIM(aTableName) = ''GeographicEntity'' THEN
               SELECT name INTO aLabelTemp  FROM ara.Geographic_Entity
                 WHERE geographic_entity_id = aContentsNum ;
            END IF;

            IF TRIM(aTableName) = ''ReferenceType'' THEN
               SELECT name INTO aLabelTemp  FROM ara.Reference_Type
                 WHERE reference_type_id = aContentsNum ;
            END IF;

            IF TRIM(aTableName) = ''Country'' THEN
               SELECT value INTO aLabelTemp  FROM ara.Country
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
alter table ara.taxon_description add column institution_id numeric;
update ara.taxon_description set institution_id = (select min(institution_id) from ara.institution);
ALTER TABLE ara.taxon_description ADD CONSTRAINT fk_species_record_institution_id FOREIGN KEY (institution_id) REFERENCES ara.institution (institution_id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION;

--2010.01.28 esmata
create or replace function ara.person_name (ara.person.person_id%TYPE, arg_profile_id NUMERIC,
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
         FROM ara.PERSON
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
create or replace function ara.species_record_person (arg_taxon_id NUMERIC, arg_taxon_description_sequence NUMERIC,
                                       arg_separator TEXT) returns text as '
DECLARE

--Fetch var
aCreatorID numeric;
aName text;

-- Result string
aCreatorList text;

taxonDescCreators CURSOR IS
   select ara.person_name (person_id, 0, 4)
      from ara.taxon_description_person_profile tdp
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

   -- Precondition: The function uses ara.person_name (person_id, 0, 4) in order to format each creator name.

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

				-----------------------------------
				-- TABLES FOR GERMOPLASMA MODULE --
				-----------------------------------

CREATE TABLE ara.material_type(
material_type_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE ara.material_type OWNER TO ara;

ALTER TABLE ONLY ara.material_type ADD CONSTRAINT "MATERIAL_TYPE_ID_PK" PRIMARY KEY (material_type_id);

CREATE TABLE ara.sample_status(
sample_status_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE ara.sample_status OWNER TO ara;

ALTER TABLE ONLY ara.sample_status ADD CONSTRAINT "SAMPLE_STATUS_ID_PK" PRIMARY KEY (sample_status_id);

CREATE TABLE ara.gathering_source(
gathering_source_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE ara.gathering_source OWNER TO ara;

ALTER TABLE ONLY ara.gathering_source ADD CONSTRAINT "GATHERING_SOURCE_ID_PK" PRIMARY KEY (gathering_source_id);

CREATE TABLE ara.soil_color(
soil_color_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE ara.soil_color OWNER TO ara;

ALTER TABLE ONLY ara.soil_color ADD CONSTRAINT "SOIL_COLOR_ID_PK" PRIMARY KEY (soil_color_id);

CREATE TABLE ara.soil_texture(
soil_texture_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE ara.soil_texture OWNER TO ara;

ALTER TABLE ONLY ara.soil_texture ADD CONSTRAINT "SOIL_TEXTURE_ID_PK" PRIMARY KEY (soil_texture_id);

CREATE TABLE ara.cultivation_practice(
cultivation_practice_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE ara.cultivation_practice OWNER TO ara;

ALTER TABLE ONLY ara.cultivation_practice ADD CONSTRAINT "CULTURE_PRACTCE_ID_PK" PRIMARY KEY (cultivation_practice_id);

CREATE TABLE ara.crop_system(
crop_system_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE ara.crop_system OWNER TO ara;

ALTER TABLE ONLY ara.crop_system ADD CONSTRAINT "CROP_SYSTEM_ID_PK" PRIMARY KEY (crop_system_id);

CREATE TABLE ara.crop_type(
crop_type_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE ara.crop_type OWNER TO ara;

ALTER TABLE ONLY ara.crop_type ADD CONSTRAINT "CROP_TYPE_ID_PK" PRIMARY KEY (crop_type_id);


CREATE TABLE ara.passport (
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

ALTER TABLE ara.passport OWNER TO ara;

ALTER TABLE ONLY ara.passport ADD CONSTRAINT "PASSPORT_ID_PK" PRIMARY KEY (passport_id);

ALTER TABLE ONLY ara.passport ADD CONSTRAINT donor_person_id_fk FOREIGN KEY (donor_person_id) REFERENCES ara.person(person_id);
ALTER TABLE ONLY ara.passport ADD CONSTRAINT donor_institution_id_fk FOREIGN KEY (donor_institution_id) REFERENCES ara.institution(institution_id);
ALTER TABLE ONLY ara.passport ADD CONSTRAINT gathering_id_fk FOREIGN KEY (gathering_id) REFERENCES ara.gathering_observation(gathering_observation_id);
ALTER TABLE ONLY ara.passport ADD CONSTRAINT material_type_id_fk FOREIGN KEY (material_type_id) REFERENCES ara.material_type(material_type_id);
ALTER TABLE ONLY ara.passport ADD CONSTRAINT sample_status_id_fk FOREIGN KEY (sample_status_id) REFERENCES ara.sample_status(sample_status_id);
ALTER TABLE ONLY ara.passport ADD CONSTRAINT gathering_source_id_fk FOREIGN KEY (gathering_source_id) REFERENCES ara.gathering_source(gathering_source_id);
ALTER TABLE ONLY ara.passport ADD CONSTRAINT soil_color_id_fk FOREIGN KEY (soil_color_id) REFERENCES ara.soil_color(soil_color_id);
ALTER TABLE ONLY ara.passport ADD CONSTRAINT soil_texture_id_fk FOREIGN KEY (soil_texture_id) REFERENCES ara.soil_texture(soil_texture_id);
ALTER TABLE ONLY ara.passport ADD CONSTRAINT culture_practice_id_fk FOREIGN KEY (cultivation_practice_id) REFERENCES ara.cultivation_practice(cultivation_practice_id);
ALTER TABLE ONLY ara.passport ADD CONSTRAINT crop_system_id_fk FOREIGN KEY (crop_system_id) REFERENCES ara.crop_system(crop_system_id);
ALTER TABLE ONLY ara.passport ADD CONSTRAINT crop_type__id_fk FOREIGN KEY (crop_type_id) REFERENCES ara.crop_type(crop_type_id);


--ALTER TABLE ONLY ara.passport ADD taxon_id  numeric;
ALTER TABLE ONLY ara.passport ADD CONSTRAINT taxon_id_fk FOREIGN KEY (taxon_id) REFERENCES ara.taxon(taxon_id);

--CREATE SEQUENCE
CREATE SEQUENCE ara.material_type_seq;
ALTER TABLE ara.material_type ALTER COLUMN material_type_id SET DEFAULT nextval('ara.material_type_seq'::regclass);
ALTER TABLE ara.material_type_seq OWNER TO ara;

CREATE SEQUENCE ara.sample_status_seq;
ALTER TABLE ara.sample_status ALTER COLUMN sample_status_id SET DEFAULT nextval('ara.sample_status_seq'::regclass);
ALTER TABLE ara.sample_status_seq OWNER TO ara;

CREATE SEQUENCE ara.gathering_source_seq;
ALTER TABLE ara.gathering_source ALTER COLUMN gathering_source_id SET DEFAULT nextval('ara.gathering_source_seq'::regclass);
ALTER TABLE ara.gathering_source_seq OWNER TO ara;

CREATE SEQUENCE ara.soil_color_seq;
ALTER TABLE ara.soil_color ALTER COLUMN soil_color_id SET DEFAULT nextval('ara.soil_color_seq'::regclass);
ALTER TABLE ara.soil_color_seq OWNER TO ara;

CREATE SEQUENCE ara.soil_texture_seq;
ALTER TABLE ara.soil_texture ALTER COLUMN soil_texture_id SET DEFAULT nextval('ara.soil_texture_seq'::regclass);
ALTER TABLE ara.soil_texture_seq OWNER TO ara;

CREATE SEQUENCE ara.cultivation_practice_seq;
ALTER TABLE ara.cultivation_practice ALTER COLUMN cultivation_practice_id SET DEFAULT nextval('ara.cultivation_practice_seq'::regclass);
ALTER TABLE ara.cultivation_practice_seq OWNER TO ara;

CREATE SEQUENCE ara.crop_system_seq;
ALTER TABLE ara.crop_system ALTER COLUMN crop_system_id SET DEFAULT nextval('ara.crop_system_seq'::regclass);
ALTER TABLE ara.crop_system_seq OWNER TO ara;

CREATE SEQUENCE ara.crop_type_seq;
ALTER TABLE ara.crop_type ALTER COLUMN crop_type_id SET DEFAULT nextval('ara.crop_type_seq'::regclass);
ALTER TABLE ara.crop_type_seq OWNER TO ara;

CREATE SEQUENCE ara.passport_seq;
ALTER TABLE ara.passport ALTER COLUMN passport_id SET DEFAULT nextval('ara.passport_seq'::regclass);
ALTER TABLE ara.passport_seq OWNER TO ara;

-- FILL MATERIAL_TYPE TABLE
INSERT INTO ara.material_type (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Ashom',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.material_type (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Dhan',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.material_type (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Fruit',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.material_type (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Khorsani',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.material_type (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Pods',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.material_type (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Rhizom',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.material_type (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Seeding',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.material_type (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Seeds',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.material_type (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Tuber',NULL,'ara','2010-01-21','ara','2010-01-21');

-- FILL SAMPLE STATUS TABLE
INSERT INTO ara.sample_status (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Improved',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.sample_status (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Landrace',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.sample_status (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Wild relatives',NULL,'ara','2010-01-21','ara','2010-01-21');

-- FILL GATHERING SOURCE
INSERT INTO ara.gathering_source (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Backyard',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.gathering_source (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Farm',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.gathering_source (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Farm store',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.gathering_source (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Farmers Field',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.gathering_source (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Farmers nurse',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.gathering_source (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Forest',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.gathering_source (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Kitchen Garden',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.gathering_source (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Market',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.gathering_source (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Store',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.gathering_source (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Wild',NULL,'ara','2010-01-21','ara','2010-01-21');

-- FILL SOIL COLOR
INSERT INTO ara.soil_color (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Black',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.soil_color (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Brown',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.soil_color (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Red',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.soil_color (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Sandy',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.soil_color (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Sandy Loam',NULL,'ara','2010-01-21','ara','2010-01-21');

-- FILL SOIL TEXTURE
INSERT INTO ara.soil_texture (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Clay',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.soil_texture (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Clay Loam',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.soil_texture (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Clayey',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.soil_texture (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Loam',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.soil_texture (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Loamy',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.soil_texture (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Sandy',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.soil_texture (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Sandy Loam',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.soil_texture (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Stony',NULL,'ara','2010-01-21','ara','2010-01-21');


-- FILL CULTIVATION PRACTICE
INSERT INTO ara.cultivation_practice (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Irrigated',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.cultivation_practice (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Rainfed',NULL,'ara','2010-01-21','ara','2010-01-21');

-- FILL CROP SYSTEM
INSERT INTO ara.crop_system (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Intercroping',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.crop_system (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Intercroping mi',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.crop_system (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Intercroping wi',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.crop_system (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Mixed Cropping',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.crop_system (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Rotation',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.crop_system (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Shifting',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.crop_system (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Sole',NULL,'ara','2010-01-21','ara','2010-01-21');
INSERT INTO ara.crop_system (name,description,created_by,creation_date,last_modification_by,last_modification_date) values ('Tsery cultivati',NULL,'ara','2010-01-21','ara','2010-01-21');

-- FILL SELECTION LIST

INSERT INTO ara.list_table (list_table_id,description,obj_version,created_by,creation_date,last_modification_by,last_modification_date,name,key_field_name)
values (27,'Tipo de Material',0,'ara','2010-01-21','ara','2010-01-21','material_type','material_type_id');
INSERT INTO ara.list_table (list_table_id,description,obj_version,created_by,creation_date,last_modification_by,last_modification_date,name,key_field_name)
values (28,'Sistema de Cultivo',0,'ara','2010-01-21','ara','2010-01-21','crop_system','crop_system_id');
INSERT INTO ara.list_table (list_table_id,description,obj_version,created_by,creation_date,last_modification_by,last_modification_date,name,key_field_name)
values (29,'Tipo de Cultivo',0,'ara','2010-01-21','ara','2010-01-21','crop_type','crop_type_id');
INSERT INTO ara.list_table (list_table_id,description,obj_version,created_by,creation_date,last_modification_by,last_modification_date,name,key_field_name)
values (30,'Practica de Cultivo',0,'ara','2010-01-21','ara','2010-01-21','cultivation_practice','cultivation_practice_id');
INSERT INTO ara.list_table (list_table_id,description,obj_version,created_by,creation_date,last_modification_by,last_modification_date,name,key_field_name)
values (31,'Fuente de Recoleccion',0,'ara','2010-01-21','ara','2010-01-21','gathering_source','gathering_source_id');
INSERT INTO ara.list_table (list_table_id,description,obj_version,created_by,creation_date,last_modification_by,last_modification_date,name,key_field_name)
values (32,'Estado de la muestra',0,'ara','2010-01-21','ara','2010-01-21','sample_status','sample_status_id');
INSERT INTO ara.list_table (list_table_id,description,obj_version,created_by,creation_date,last_modification_by,last_modification_date,name,key_field_name)
values (33,'Color de Suelo',0,'ara','2010-01-21','ara','2010-01-21','soil_color','soil_color_id');
INSERT INTO ara.list_table (list_table_id,description,obj_version,created_by,creation_date,last_modification_by,last_modification_date,name,key_field_name)
values (34,'Textura del Suelo',0,'ara','2010-01-21','ara','2010-01-21','soil_texture','soil_texture_id');

--CREATE DONOR PERSON PROFILE
INSERT INTO ara.profile (profile_id,name,description,creation_date,created_by,last_modification_date,last_modification_by)
VALUES(20,'Donor Person','donor person','2010-01-21','ara','2010-01-21','ara');

CREATE TABLE ara.passport_nomenclatural_group (
passport_id			numeric NOT NULL,
nomenclatural_group_id		numeric NOT NULL,
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL
);

ALTER TABLE ara.passport_nomenclatural_group OWNER TO ara;

ALTER TABLE ONLY ara.passport_nomenclatural_group ADD CONSTRAINT passport_nomenclatural_group_pk PRIMARY KEY (passport_id, nomenclatural_group_id);
ALTER TABLE ONLY ara.passport_nomenclatural_group ADD CONSTRAINT nomenclatural_group_id_fk FOREIGN KEY (nomenclatural_group_id) REFERENCES ara.nomenclatural_group(nomenclatural_group_id);
ALTER TABLE ONLY ara.passport_nomenclatural_group ADD CONSTRAINT passport_id_fk FOREIGN KEY (passport_id) REFERENCES ara.passport(passport_id);

INSERT
INTO
    ara.collection
    (
        collection_id,
        name,
        description,
        creation_date,
        created_by,
        last_modification_date,
        last_modification_by
    )
    VALUES
    (
        15,
        'Germplasm',
        'Germplasm',
        '2010-02-19',
        'ara',
        '2010-02-19',
        'ara'
    );

INSERT
INTO
	ara.nomenclatural_group
	(
		nomenclatural_group_id,
		name,
		description,
		temporality,
		common_name,
		certificator_person_id,
		collection_id,
		notes,
		created_by,
		creation_date,
		last_modification_by,
		last_modification_date
	)
VALUES (
		8,
		'Germplasm',
		'Germplasm',
		NULL,
		'y',
		NULL,
		15,
		NULL,
		'ara',
		'2010-02-19',
		'ara',
		'2010-02-19'
		);



INSERT
INTO
    ara.taxon_nomenclatural_group
    (
        nomenclatural_group_id,
        taxon_id,
        taxonomical_timestamp,
        sequence,
        created_by,
        creation_date,
        last_modification_by,
        last_modification_date
    )
    VALUES
    (
        8,
        4,
        '2010-02-16',
        1,
        'ara',
	'2010-02-19',
	'ara',
	'2010-02-19'
    );


INSERT
INTO
    ara.nomenclatural_group_region
    (
        nomenclatural_group_id,
        region_id,
        sequence,
        created_by,
        creation_date,
        last_modification_by,
        last_modification_date
    )
    VALUES
    (
        8,
        1,
        1,
        'ara',
	'2010-02-19',
	'ara',
	'2010-02-19'
    );

INSERT INTO ara.user_nomenclatural_group(
            nomenclatural_group_id, user_id, "sequence", creation_date, created_by,
            last_modification_date, last_modification_by)
    VALUES (8, 25, 1, '2010-02-19', 'ara',
            '2010-02-19', 'ara');

--2010.03.18 esmata
--Adding unique constraint between catalog number and institution code on specimen table
ALTER TABLE ara.specimen ADD CONSTRAINT unique_specimen UNIQUE (catalog_number,institution_id);

--2010.03.24 dasolano

                                ---------------------------------------------
                                -- TABLES FOR GERMPLASM MODULE: ACCESSIONS --
                                ---------------------------------------------


CREATE TABLE ara.germination_method_type(
germination_method_type_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE ara.germination_method_type OWNER TO ara;

ALTER TABLE ONLY ara.germination_method_type ADD CONSTRAINT "GERMINATION_METHOD_TYPE_ID_PK" PRIMARY KEY (germination_method_type_id);

CREATE TABLE ara.moisture_method_type(
moisture_method_type_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE ara.moisture_method_type OWNER TO ara;

ALTER TABLE ONLY ara.moisture_method_type ADD CONSTRAINT "MOISTURE_METHOD_TYPE_ID_PK" PRIMARY KEY (moisture_method_type_id);

CREATE TABLE ara.collection_type(
collection_type_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE ara.collection_type OWNER TO ara;

ALTER TABLE ONLY ara.collection_type ADD CONSTRAINT "COLLECTION_TYPE_ID_PK" PRIMARY KEY (collection_type_id);


CREATE TABLE ara.accession_movement_type(
accession_movement_type_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE ara.accession_movement_type OWNER TO ara;

ALTER TABLE ONLY ara.accession_movement_type ADD CONSTRAINT "ACCESSION_MOVEMENT_TYPE_ID_PK" PRIMARY KEY (accession_movement_type_id);


CREATE TABLE ara.accession(
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

ALTER TABLE ara.accession OWNER TO ara;

ALTER TABLE ONLY ara.accession ADD CONSTRAINT "ACCESSION_ID_PK" PRIMARY KEY (accession_id);
ALTER TABLE ONLY ara.accession ADD CONSTRAINT accession_number_unique UNIQUE (accession_number);

CREATE TABLE ara.accession_movement(
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

ALTER TABLE ara.accession_movement OWNER TO ara;

ALTER TABLE ONLY ara.accession_movement ADD CONSTRAINT "ACCESSION_MOVEMENT_ID_PK" PRIMARY KEY (accession_id, accession_movement_date);

ALTER TABLE ONLY ara.accession ADD CONSTRAINT collection_type_id_fk FOREIGN KEY (collection_type_id) REFERENCES ara.collection_type(collection_type_id);
ALTER TABLE ONLY ara.accession ADD CONSTRAINT responsable_person_id_fk FOREIGN KEY (responsable_person_id) REFERENCES ara.person(person_id);
ALTER TABLE ONLY ara.accession ADD CONSTRAINT passport_id_fk FOREIGN KEY (passport_id) REFERENCES ara.passport(passport_id) ON DELETE CASCADE;
ALTER TABLE ONLY ara.accession ADD CONSTRAINT germination_method_type_id_fk FOREIGN KEY (germination_method_type_id) REFERENCES ara.germination_method_type(germination_method_type_id);
ALTER TABLE ONLY ara.accession ADD CONSTRAINT moisture_method_type_id_fk FOREIGN KEY (moisture_method_type_id) REFERENCES ara.moisture_method_type(moisture_method_type_id);
ALTER TABLE ONLY ara.accession ADD CONSTRAINT accession_parent_id_fk FOREIGN KEY (accession_parent_id) REFERENCES ara.accession(accession_id) ON DELETE CASCADE;



ALTER TABLE ONLY ara.accession_movement ADD CONSTRAINT accession_id_fk FOREIGN KEY (accession_id) REFERENCES ara.accession(accession_id)  ON DELETE CASCADE;
ALTER TABLE ONLY ara.accession_movement ADD CONSTRAINT accession_movement_type_id_fk FOREIGN KEY (accession_movement_type_id) REFERENCES ara.accession_movement_type(accession_movement_type_id);

--SEQUENCE

CREATE SEQUENCE ara.germination_method_type_seq;
ALTER TABLE ara.germination_method_type ALTER COLUMN germination_method_type_id SET DEFAULT nextval('ara.germination_method_type_seq'::regclass);
ALTER TABLE ara.germination_method_type_seq OWNER TO ara;


CREATE SEQUENCE ara.moisture_method_type_seq;
ALTER TABLE ara.moisture_method_type ALTER COLUMN moisture_method_type_id SET DEFAULT nextval('ara.moisture_method_type_seq'::regclass);
ALTER TABLE ara.moisture_method_type_seq OWNER TO ara;

CREATE SEQUENCE ara.collection_type_seq;
ALTER TABLE ara.collection_type ALTER COLUMN collection_type_id SET DEFAULT nextval('ara.collection_type_seq'::regclass);
ALTER TABLE ara.collection_type_seq OWNER TO ara;

CREATE SEQUENCE ara.accession_movement_type_seq;
ALTER TABLE ara.accession_movement_type ALTER COLUMN accession_movement_type_id SET DEFAULT nextval('ara.accession_movement_type_seq'::regclass);
ALTER TABLE ara.accession_movement_type_seq OWNER TO ara;

CREATE SEQUENCE ara.accession_seq;
ALTER TABLE ara.accession ALTER COLUMN accession_id SET DEFAULT nextval('ara.accession_seq'::regclass);
ALTER TABLE ara.accession_seq OWNER TO ara;


--selection list correspondientes para la seccion de accessiones del modulo de germoplasma

INSERT INTO ara.list_table (list_table_id,description,obj_version,created_by,creation_date,last_modification_by,last_modification_date,name,key_field_name)
values (35,'Método de Germinación',0,'ara','2010-03-03','ara','2010-03-03','germination_method_type','germination_method_type_id');

INSERT INTO ara.list_table (list_table_id,description,obj_version,created_by,creation_date,last_modification_by,last_modification_date,name,key_field_name)
values (36,'Tipo de Colección',0,'ara','2010-03-03','ara','2010-03-03','collection_type','collection_type_id');

INSERT INTO ara.list_table (list_table_id,description,obj_version,created_by,creation_date,last_modification_by,last_modification_date,name,key_field_name)
values (37,'Método de Humedad',0,'ara','2010-03-03','ara','2010-03-03','moisture_method_type','moisture_method_type_id');

INSERT INTO ara.list_table (list_table_id,description,obj_version,created_by,creation_date,last_modification_by,last_modification_date,name,key_field_name)
values (38,'Movimiento de Accesión',0,'ara','2010-03-03','ara','2010-03-03','accession_movement_type','accession_movement_type_id');

-- selection list de ejemplo

INSERT INTO ara.accession_movement_type
(name, description,created_by,creation_date,last_modification_by,last_modification_date )
values
('Donación','','ara','2010-03-03','ara','2010-03-03');


INSERT INTO ara.accession_movement_type
(name, description,created_by,creation_date,last_modification_by,last_modification_date )
values
('Prestamo','','ara','2010-03-03','ara','2010-03-03');



INSERT INTO ara.moisture_method_type
(name, description,created_by,creation_date,last_modification_by,last_modification_date )
values
('Rango 1','','ara','2010-03-03','ara','2010-03-03');

INSERT INTO ara.moisture_method_type
(name, description,created_by,creation_date,last_modification_by,last_modification_date )
values
('Rango 2','','ara','2010-03-03','ara','2010-03-03');

INSERT INTO ara.collection_type
(name, description,created_by,creation_date,last_modification_by,last_modification_date )
values
('Activa','','ara','2010-03-03','ara','2010-03-03');

INSERT INTO ara.collection_type
(name, description,created_by,creation_date,last_modification_by,last_modification_date )
values
('Base','','ara','2010-03-03','ara','2010-03-03');

INSERT INTO ara.germination_method_type
(name, description,created_by,creation_date,last_modification_by,last_modification_date )
values
('Humedo','','ara','2010-03-03','ara','2010-03-03');

INSERT INTO ara.germination_method_type
(name, description,created_by,creation_date,last_modification_by,last_modification_date )
values
('Seco','','ara','2010-03-03','ara','2010-03-03');

INSERT INTO ara.germination_method_type
(name, description,created_by,creation_date,last_modification_by,last_modification_date )
values
('Frio','','ara','2010-03-03','ara','2010-03-03');


--CREATE DONOR PERSON PROFILE
INSERT INTO ara.profile (profile_id,name,description,creation_date,created_by,last_modification_date,last_modification_by)
VALUES(21,'Responsable Person','GermPlams Responsable Person Management','2010-01-21','ara','2010-01-21','ara');

--2010.04.27 gsulca

                                ---------------------------------------------
                                    -- TABLES FOR INDICATOR MODULE --
                                ---------------------------------------------


create table ARA.INDICATOR  (
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
ALTER TABLE  ARA.INDICATOR OWNER TO ara;
ALTER TABLE ONLY ARA.INDICATOR add constraint INDICATOR_ID_pk primary key (INDICATOR_ID);

create table ARA.TAXON_INDICATOR  (
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
ALTER TABLE ARA.TAXON_INDICATOR OWNER TO ara;
ALTER TABLE ONLY ARA.TAXON_INDICATOR ADD CONSTRAINT TAXON_INDICATOR_ID_TAXON_ID_PK PRIMARY KEY (INDICATOR_ID, TAXON_ID);
ALTER TABLE ONLY ARA.TAXON_INDICATOR ADD CONSTRAINT TAXON_INDICATOR_taxon_id_fk FOREIGN KEY (TAXON_ID ) REFERENCES ARA.TAXON(TAXON_ID);
ALTER TABLE ONLY ARA.TAXON_INDICATOR ADD CONSTRAINT TAXON_INDICATOR_INDICATOR_id_fk FOREIGN KEY (INDICATOR_ID) REFERENCES ARA.INDICATOR(INDICATOR_ID);
ALTER TABLE ONLY ARA.TAXON_INDICATOR ADD CONSTRAINT valuer_person_id_fk FOREIGN KEY (valuer_person_id) REFERENCES ARA.PERSON(person_id);


create table ARA.TAXON_INDICATOR_REFERENCE  (
   REFERENCE_ID         numeric not null,
   INDICATOR_ID         numeric not null,
   TAXON_ID             numeric not null
);
ALTER TABLE  ARA.TAXON_INDICATOR_REFERENCE OWNER TO ara;
ALTER TABLE ONLY ARA.TAXON_INDICATOR_REFERENCE add constraint TAXON_INDICATOR_REFERENCE_PK primary key (REFERENCE_ID, INDICATOR_ID, TAXON_ID);
ALTER TABLE ONLY ARA.TAXON_INDICATOR_REFERENCE  ADD CONSTRAINT TAXON_INDIC_INDICATOR_TAXON_id_fk FOREIGN KEY (INDICATOR_ID, TAXON_ID) REFERENCES ARA.TAXON_INDICATOR(INDICATOR_ID, TAXON_ID);


create table ARA.INDICATOR_REFERENCE  (
   REFERENCE_ID         numeric not null,
   INDICATOR_ID         numeric not null
);
ALTER TABLE ARA.INDICATOR_REFERENCE OWNER TO ara;
ALTER TABLE ONLY ARA.INDICATOR_REFERENCE add constraint INDICATOR_REFERENCE_pk primary key (REFERENCE_ID, INDICATOR_ID);


create table ARA.TAXON_INDICATOR_COMPONENT_PART  (
   COMPONENT_PART_ID    numeric NOT NULL,
   INDICATOR_ID         numeric NOT NULL,
   TAXON_ID             numeric NOT NULL
);
ALTER TABLE ONLY ARA.TAXON_INDICATOR_COMPONENT_PART ADD CONSTRAINT TAXON_INDICATOR_CP_ID_TAXON_ID_PK PRIMARY KEY (COMPONENT_PART_ID,INDICATOR_ID, TAXON_ID);
ALTER TABLE ONLY ARA.TAXON_INDICATOR_COMPONENT_PART ADD CONSTRAINT TAXON_INDIC_CP_indic_taxon_fk FOREIGN KEY (INDICATOR_ID, TAXON_ID) REFERENCES ARA.TAXON_INDICATOR(INDICATOR_ID, TAXON_ID);
ALTER TABLE ONLY ARA.TAXON_INDICATOR_COMPONENT_PART OWNER TO ara;

-- Agregué las siguientes llaves foraneas
ALTER TABLE ONLY ARA.INDICATOR_REFERENCE  ADD CONSTRAINT INDICATOR_reference_id_fk FOREIGN KEY (INDICATOR_ID ) REFERENCES ARA.INDICATOR(INDICATOR_ID);
ALTER TABLE ONLY ARA.TAXON_INDICATOR_COMPONENT_PART  ADD CONSTRAINT TAXON_INDICATOR_COMPONENT_PART_fk FOREIGN KEY (COMPONENT_PART_ID ) REFERENCES ARA.COMPONENT_PART(COMPONENT_PART_ID);

-- Hacer la tabla indicadores jerárquica
ALTER TABLE ONLY ARA.INDICATOR ADD CONSTRAINT TAXON_INDICATOR_ancestor_id_fk FOREIGN KEY (INDICATOR_ANCESTOR_ID ) REFERENCES ARA.INDICATOR(INDICATOR_ID);


-- Nuevo secuence para la tabla de component_part
CREATE SEQUENCE ara.component_part_seq;
ALTER TABLE ara.component_part_seq OWNER TO ara;
-- Asignar dicho secuence al atributo correspondiente de la tabla
ALTER TABLE ara.component_part ALTER COLUMN component_part_id SET DEFAULT nextval('ara.component_part_seq'::regclass);
-- Eliminar el obj_version
ALTER TABLE ara.component_part DROP COLUMN obj_version;


-- Nuevo secuence para la tabla de indicator
CREATE SEQUENCE ara.indicator_seq START 0 MINVALUE 0;
ALTER TABLE ara.indicator_seq OWNER TO ara;
-- Asignar dicho secuence al atributo correspondiente de la tabla
ALTER TABLE ara.indicator ALTER COLUMN indicator_id SET DEFAULT nextval('ara.indicator_seq'::regclass);




------------------------------------------------
----GERMPLASM SEMEN MODULE----------------------
------------------------------------------------

CREATE TABLE ara.condition(
condition_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE ara.condition OWNER TO ara;

ALTER TABLE ONLY ara.condition ADD CONSTRAINT "CONDITION_TYPE_ID_PK" PRIMARY KEY (condition_id);


CREATE TABLE ara.solvent(
solvent_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE ara.solvent OWNER TO ara;

ALTER TABLE ONLY ara.solvent ADD CONSTRAINT "SOLVENT_TYPE_ID_PK" PRIMARY KEY (solvent_id);

CREATE TABLE ara.semen_gathering_method(
semen_gathering_method_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE ara.semen_gathering_method OWNER TO ara;

ALTER TABLE ONLY ara.semen_gathering_method ADD CONSTRAINT "SEMEN_GATHERING_METHOD_ID_PK" PRIMARY KEY (semen_gathering_method_id);


CREATE TABLE ara.breed(
breed_id numeric not null,
name character varying(100) UNIQUE NOT NULL,
taxon_id numeric not null,
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE ara.breed OWNER TO ara;

ALTER TABLE ONLY ara.breed ADD CONSTRAINT "BREED_TYPE_ID_PK" PRIMARY KEY (breed_id);

ALTER TABLE ONLY ara.breed ADD CONSTRAINT taxon_id_fk FOREIGN KEY (taxon_id) REFERENCES ara.taxon(taxon_id);


CREATE TABLE ara.semental(
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

ALTER TABLE ara.semental OWNER TO ara;

ALTER TABLE ONLY ara.semental ADD CONSTRAINT "SEMENTAL_ID_PK" PRIMARY KEY (semental_id);


ALTER TABLE ONLY ara.semental ADD CONSTRAINT breed_id_fk FOREIGN KEY (breed_id) REFERENCES ara.breed(breed_id) ON DELETE CASCADE;
ALTER TABLE ONLY ara.semental ADD CONSTRAINT site_id_fk FOREIGN KEY (site_id) REFERENCES ara.site(site_id);
ALTER TABLE ONLY ara.semental ADD CONSTRAINT condition_id_fk FOREIGN KEY (condition_id) REFERENCES ara.condition(condition_id);


CREATE TABLE ara.semen_gathering(
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

ALTER TABLE ara.semen_gathering OWNER TO ara;

ALTER TABLE ONLY ara.semen_gathering ADD CONSTRAINT "SEMEN_GATHERING_ID_PK" PRIMARY KEY (semen_gathering_id);

ALTER TABLE ONLY ara.semen_gathering ADD CONSTRAINT solvent_id_fk FOREIGN KEY (solvent_id) REFERENCES ara.solvent(solvent_id);
ALTER TABLE ONLY ara.semen_gathering ADD CONSTRAINT semen_gathering_method_id_fk FOREIGN KEY (semen_gathering_method_id) REFERENCES ara.semen_gathering_method(semen_gathering_method_id);
ALTER TABLE ONLY ara.semen_gathering ADD CONSTRAINT semental_id_fk FOREIGN KEY (semental_id) REFERENCES ara.semental(semental_id) ON DELETE CASCADE;

--CREATE SEQUENCE
CREATE SEQUENCE ara.condition_seq;
ALTER TABLE ara.condition ALTER COLUMN condition_id SET DEFAULT nextval('ara.condition_seq'::regclass);
ALTER TABLE ara.condition_seq OWNER TO ara;

CREATE SEQUENCE ara.solvent_seq;
ALTER TABLE ara.solvent ALTER COLUMN solvent_id SET DEFAULT nextval('ara.solvent_seq'::regclass);
ALTER TABLE ara.solvent_seq OWNER TO ara;

CREATE SEQUENCE ara.semen_gathering_method_seq;
ALTER TABLE ara.semen_gathering_method ALTER COLUMN semen_gathering_method_id SET DEFAULT nextval('ara.semen_gathering_method_seq'::regclass);
ALTER TABLE ara.semen_gathering_method_seq OWNER TO ara;

CREATE SEQUENCE ara.breed_seq;
ALTER TABLE ara.breed ALTER COLUMN breed_id SET DEFAULT nextval('ara.breed_seq'::regclass);
ALTER TABLE ara.breed_seq OWNER TO ara;

CREATE SEQUENCE ara.semental_seq;
ALTER TABLE ara.semental ALTER COLUMN semental_id SET DEFAULT nextval('ara.semental_seq'::regclass);
ALTER TABLE ara.semental_seq OWNER TO ara;

CREATE SEQUENCE ara.semen_gathering_seq;
ALTER TABLE ara.semen_gathering ALTER COLUMN semen_gathering_id SET DEFAULT nextval('ara.semen_gathering_seq'::regclass);
ALTER TABLE ara.semen_gathering_seq OWNER TO ara;

INSERT INTO ara.list_table(
            list_table_id, description, obj_version, created_by, creation_date,
            last_modification_by, last_modification_date, "name", key_field_name)
    VALUES (39, '', 0, 'Ara', '2010-04-13',
            'Ara', '2010-04-13', 'condition', 'condition_id');

INSERT INTO ara.list_table(
            list_table_id, description, obj_version, created_by, creation_date,
            last_modification_by, last_modification_date, "name", key_field_name)
    VALUES (40, '', 0, 'Ara', '2010-04-13',
            'Ara', '2010-04-13', 'semen_gathering_method', 'semen_gathering_method_id');

INSERT INTO ara.list_table(
            list_table_id, description, obj_version, created_by, creation_date,
            last_modification_by, last_modification_date, "name", key_field_name)
    VALUES (41, '', 0, 'Ara', '2010-04-13',
            'Ara', '2010-04-13', 'solvent', 'solvent_id');

--Add column current straw quantity to semen_gathering tabble
ALTER TABLE ara.semen_gathering ADD COLUMN current_straw_quantity numeric;

--2010.04.27 gsulca


-- Rename table taxon_indicator_reference to taxon_indicator_dublin_core
ALTER TABLE ARA.TAXON_INDICATOR_REFERENCE RENAME TO TAXON_INDICATOR_DUBLIN_CORE;
-- Rename column reference_id from taxon_indicator_dublin_core to dublin_core_id
ALTER TABLE ARA.TAXON_INDICATOR_DUBLIN_CORE RENAME COLUMN REFERENCE_ID TO DUBLIN_CORE_ID;
-- Remove constraint TAXON_INDICATOR_REFERENCE_PK
ALTER TABLE ARA.TAXON_INDICATOR_DUBLIN_CORE DROP CONSTRAINT TAXON_INDICATOR_REFERENCE_PK;
-- Add constraint
ALTER TABLE ONLY ARA.TAXON_INDICATOR_DUBLIN_CORE ADD CONSTRAINT TAXON_INDICATOR_DUBLIN_CORE_PK primary key (DUBLIN_CORE_ID, INDICATOR_ID, TAXON_ID);


-- Rename table indicator_reference to indicator_dublin_core
ALTER TABLE ARA.INDICATOR_REFERENCE RENAME TO INDICATOR_DUBLIN_CORE;
-- Rename column reference_id from indicator_dublin_core to dublin_core_id
ALTER TABLE ARA.INDICATOR_DUBLIN_CORE RENAME COLUMN REFERENCE_ID TO DUBLIN_CORE_ID;
-- Remove constraint TAXON_INDICATOR_REFERENCE_PK
ALTER TABLE ARA.INDICATOR_DUBLIN_CORE DROP CONSTRAINT INDICATOR_REFERENCE_PK;
-- Add constraint INDICATOR_DUBLIN_CORE_pk
ALTER TABLE ONLY ARA.INDICATOR_DUBLIN_CORE add constraint INDICATOR_DUBLIN_CORE_pk primary key (DUBLIN_CORE_ID, INDICATOR_ID);
-- Add constraint INDICATOR_DUBLIN_CORE_ID_FK
ALTER TABLE ONLY ARA.INDICATOR_DUBLIN_CORE  ADD CONSTRAINT INDICATOR_DUBLIN_CORE_ID_FK FOREIGN KEY (INDICATOR_ID ) REFERENCES ARA.INDICATOR(INDICATOR_ID);



--2010.05.11 --update the contraint of the passport_nomenclatural table
ALTER TABLE ONLY ara.passport_nomenclatural_group
   DROP CONSTRAINT nomenclatural_group_id_fk;

ALTER TABLE ONLY ara.passport_nomenclatural_group
   DROP CONSTRAINT passport_id_fk;

ALTER TABLE ONLY ara.passport_nomenclatural_group ADD CONSTRAINT nomenclatural_group_id_fk FOREIGN KEY (nomenclatural_group_id) REFERENCES ara.nomenclatural_group(nomenclatural_group_id) ON DELETE CASCADE;
ALTER TABLE ONLY ara.passport_nomenclatural_group ADD CONSTRAINT passport_id_fk FOREIGN KEY (passport_id) REFERENCES ara.passport(passport_id) ON DELETE CASCADE;

--2010-05-11 gsulca

-- Add table DUBLIN_CORE
create table ARA.DUBLIN_CORE  (
   DUBLIN_CORE_ID       	numeric NOT NULL,
   TITLE             		character varying(1000) NOT NULL,
   SUBJECT             		character varying(2000),
   DESCRIPTION         		character varying(2000),
   DATE		        	DATE NOT NULL,
   DUBLIN_CORE_TYPE_ID  	numeric,
   DUBLIN_CORE_FORMAT_ID  	numeric,
   IDENTIFIER			character varying(500) NOT NULL,
   SOURCE			character varying(1000),
   LANGUAGE_ID  		numeric,
   RELATION			character varying(1000),
   COVERAGE			character varying(1000),
   RIGHTS_MANAGEMENT		character varying(1000),
   CREATION_DATE        DATE,
   CREATED_BY           character varying(20),
   LAST_MODIFICATION_DATE DATE,
   LAST_MODIFICATION_BY character varying(20)
);
ALTER TABLE ARA.DUBLIN_CORE OWNER TO ara;
-- Add primary key DUBLIN_CORE_ID_PK
ALTER TABLE ONLY ARA.DUBLIN_CORE ADD CONSTRAINT DUBLIN_CORE_ID_PK PRIMARY KEY (DUBLIN_CORE_ID);
-- Add foreign key LANGUAGE_ID_FK to DUBLIN_CORE
ALTER TABLE ONLY ARA.DUBLIN_CORE ADD CONSTRAINT LANGUAGE_ID_FK FOREIGN KEY (LANGUAGE_ID ) REFERENCES ARA.LANGUAGE(LANGUAGE_ID);

-- Add table DUBLIN_CORE_FORMAT
create table ARA.DUBLIN_CORE_FORMAT  (
   DUBLIN_CORE_FORMAT_ID       	numeric NOT NULL,
   NAME             		character varying(80) NOT NULL,
   DESCRIPTION         		character varying(200),
   CREATION_DATE        	DATE,
   CREATED_BY           	character varying(20),
   LAST_MODIFICATION_DATE 	DATE,
   LAST_MODIFICATION_BY 	character varying(20)
);
ALTER TABLE ARA.DUBLIN_CORE_FORMAT OWNER TO ara;
-- Add primary key DUBLIN_CORE_ID_PK
ALTER TABLE ONLY ARA.DUBLIN_CORE_FORMAT ADD CONSTRAINT DUBLIN_CORE_FORMAT_ID_PK PRIMARY KEY (DUBLIN_CORE_FORMAT_ID);
-- Add foreign key LANGUAGE_ID_FK to DUBLIN_CORE
ALTER TABLE ONLY ARA.DUBLIN_CORE ADD CONSTRAINT DUBLIN_CORE_FORMAT_ID_FK FOREIGN KEY (DUBLIN_CORE_FORMAT_ID ) REFERENCES ARA.DUBLIN_CORE_FORMAT(DUBLIN_CORE_FORMAT_ID);

-- Add table DUBLIN_CORE_TYPE
create table ARA.DUBLIN_CORE_TYPE  (
   DUBLIN_CORE_TYPE_ID       	numeric NOT NULL,
   NAME             		character varying(80) NOT NULL,
   DESCRIPTION         		character varying(200),
   CREATION_DATE        	DATE,
   CREATED_BY           	character varying(20),
   LAST_MODIFICATION_DATE 	DATE,
   LAST_MODIFICATION_BY 	character varying(20)
);
ALTER TABLE ARA.DUBLIN_CORE_TYPE OWNER TO ara;
-- Add primary key DUBLIN_CORE_TYPE_ID_PK
ALTER TABLE ONLY ARA.DUBLIN_CORE_TYPE ADD CONSTRAINT DUBLIN_CORE_TYPE_ID_PK PRIMARY KEY (DUBLIN_CORE_TYPE_ID);
-- Add foreign key LANGUAGE_ID_FK to DUBLIN_CORE
ALTER TABLE ONLY ARA.DUBLIN_CORE ADD CONSTRAINT DUBLIN_CORE_TYPE_ID_FK FOREIGN KEY (DUBLIN_CORE_TYPE_ID ) REFERENCES ARA.DUBLIN_CORE_TYPE(DUBLIN_CORE_TYPE_ID);

-- Add table DUBLIN_CORE_ENTITY_TYPE
create table ARA.DUBLIN_CORE_ENTITY_TYPE  (
   DUBLIN_CORE_ENTITY_TYPE_ID   numeric NOT NULL,
   NAME             		character varying(80) NOT NULL,
   DESCRIPTION         		character varying(200),
   CREATION_DATE        	DATE,
   CREATED_BY           	character varying(20),
   LAST_MODIFICATION_DATE 	DATE,
   LAST_MODIFICATION_BY 	character varying(20)
);
ALTER TABLE ARA.DUBLIN_CORE_ENTITY_TYPE OWNER TO ara;
-- Add primary key DUBLIN_CORE_ENTITY_TYPE_ID_PK
ALTER TABLE ONLY ARA.DUBLIN_CORE_ENTITY_TYPE ADD CONSTRAINT DUBLIN_CORE_ENTITY_TYPE_ID_PK PRIMARY KEY (DUBLIN_CORE_ENTITY_TYPE_ID);

-- Add table DUBLIN_CORE_ENTITY
create table ARA.DUBLIN_CORE_ENTITY  (
   DUBLIN_CORE_ENTITY_ID       	numeric NOT NULL,
   DUBLIN_CORE_ID      		numeric NOT NULL,
   INSTITUTION_ID         	numeric,
   PERSON_ID         		numeric,
   DUBLIN_CORE_ENTITY_TYPE_ID	numeric NOT NULL,
   CREATION_DATE        	DATE,
   CREATED_BY           	character varying(20),
   LAST_MODIFICATION_DATE 	DATE,
   LAST_MODIFICATION_BY 	character varying(20)
);
ALTER TABLE ARA.DUBLIN_CORE_ENTITY OWNER TO ara;
-- Add primary key DUBLIN_CORE_ENTITY_ID_PK
ALTER TABLE ONLY ARA.DUBLIN_CORE_ENTITY ADD CONSTRAINT DUBLIN_CORE_ENTITY_ID_PK PRIMARY KEY (DUBLIN_CORE_ENTITY_ID);
-- Add foreign key DUBLIN_CORE_TYPE_ID_FK to DUBLIN_CORE
ALTER TABLE ONLY ARA.DUBLIN_CORE_ENTITY ADD CONSTRAINT DUBLIN_CORE_ID_FK FOREIGN KEY (DUBLIN_CORE_ID ) REFERENCES ARA.DUBLIN_CORE(DUBLIN_CORE_ID);


--2010-05-14 gsulca

--Create sequence dublin_core
CREATE SEQUENCE ARA.DUBLIN_CORE_SEQ;
ALTER TABLE ARA.DUBLIN_CORE ALTER COLUMN DUBLIN_CORE_ID SET DEFAULT nextval('ARA.DUBLIN_CORE_SEQ'::regclass);
ALTER TABLE ARA.DUBLIN_CORE_SEQ OWNER TO ara;

--Create sequence dublin_format
CREATE SEQUENCE ARA.DUBLIN_CORE_FORMAT_SEQ;
ALTER TABLE ARA.DUBLIN_CORE_FORMAT ALTER COLUMN DUBLIN_CORE_FORMAT_ID SET DEFAULT nextval('ARA.DUBLIN_CORE_FORMAT_SEQ'::regclass);
ALTER TABLE ARA.DUBLIN_CORE_FORMAT_SEQ OWNER TO ara;

--Create sequence dublin_type
CREATE SEQUENCE ARA.DUBLIN_CORE_TYPE_SEQ;
ALTER TABLE ARA.DUBLIN_CORE_TYPE ALTER COLUMN DUBLIN_CORE_TYPE_ID SET DEFAULT nextval('ARA.DUBLIN_CORE_TYPE_SEQ'::regclass);
ALTER TABLE ARA.DUBLIN_CORE_TYPE_SEQ OWNER TO ara;

--Create sequence dublin_entity
CREATE SEQUENCE ARA.DUBLIN_CORE_ENTITY_SEQ;
ALTER TABLE ARA.DUBLIN_CORE_ENTITY ALTER COLUMN DUBLIN_CORE_ENTITY_ID SET DEFAULT nextval('ARA.DUBLIN_CORE_ENTITY_SEQ'::regclass);
ALTER TABLE ARA.DUBLIN_CORE_ENTITY_SEQ OWNER TO ara;

--Create sequence dublin_entity_type
CREATE SEQUENCE ARA.DUBLIN_CORE_ENTITY_TYPE_SEQ;
ALTER TABLE ARA.DUBLIN_CORE_ENTITY_TYPE ALTER COLUMN DUBLIN_CORE_ENTITY_TYPE_ID SET DEFAULT nextval('ARA.DUBLIN_CORE_ENTITY_TYPE_SEQ'::regclass);
ALTER TABLE ARA.DUBLIN_CORE_ENTITY_TYPE_SEQ OWNER TO ara;

-- Tablas tipo selection list para el módulo dublin core
INSERT INTO ara.list_table (list_table_id,description,obj_version,created_by,creation_date,last_modification_by,last_modification_date,name,key_field_name)
values (42,'Formato Dublin Core',0,'ara','2010-05-14','ara','2010-05-14','dublin_core_format','dublin_core_format_id');

INSERT INTO ara.list_table (list_table_id,description,obj_version,created_by,creation_date,last_modification_by,last_modification_date,name,key_field_name)
values (43,'Tipo',0,'ara','2010-05-14','ara','2010-05-14','dublin_core_type','dublin_core_type_id');

INSERT INTO ara.list_table (list_table_id,description,obj_version,created_by,creation_date,last_modification_by,last_modification_date,name,key_field_name)
values (44,'Tipo de entidad',0,'ara','2010-05-14','ara','2010-05-14','dublin_core_entity_type','dublin_core_entity_type_id');