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

DROP LANGUAGE IF EXISTS 'plpgsql';
CREATE LANGUAGE 'plpgsql';

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

                --------------------------------------------------------------------------------
                -- Hata aquí quedó la versión para Panamá  --
                --------------------------------------------------------------------------------

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

                --------------------------------------------------------------------------------
                -- Hata aquí quedó la versión de Bután (Primer taller del 4 de febrero)  --
                --------------------------------------------------------------------------------

-----------------------------------
-- TABLES FOR GERMOPLASMA MODULE --
-----------------------------------
--2010.03.01
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

                --------------------------------------------------------------------------------
                -- Hata aquí quedó la versión de Jamaica y Perú  --
                --------------------------------------------------------------------------------

---------------------------------------------
    -- TABLES FOR INDICATOR MODULE --
---------------------------------------------
--2010.04.27 gsulca

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

--2010.05.11 dasolano --update the constraint of the passport_nomenclatural table
ALTER TABLE ONLY ara.passport_nomenclatural_group
   DROP CONSTRAINT nomenclatural_group_id_fk;

ALTER TABLE ONLY ara.passport_nomenclatural_group
   DROP CONSTRAINT passport_id_fk;

ALTER TABLE ONLY ara.passport_nomenclatural_group ADD CONSTRAINT nomenclatural_group_id_fk FOREIGN KEY (nomenclatural_group_id) REFERENCES ara.nomenclatural_group(nomenclatural_group_id) ON DELETE CASCADE;
ALTER TABLE ONLY ara.passport_nomenclatural_group ADD CONSTRAINT passport_id_fk FOREIGN KEY (passport_id) REFERENCES ara.passport(passport_id) ON DELETE CASCADE;

--2010.06.15 esmata
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
ALTER TABLE ARA.TAXON_INDICATOR_REFERENCE RENAME TO TAXON_INDICATOR_DUBLIN_CORE;
-- Rename column reference_id from taxon_indicator_dublin_core to dublin_core_id
ALTER TABLE ARA.TAXON_INDICATOR_DUBLIN_CORE RENAME COLUMN REFERENCE_ID TO DUBLIN_CORE_ID;
-- Remove constraint TAXON_INDICATOR_REFERENCE_PK
ALTER TABLE ARA.TAXON_INDICATOR_DUBLIN_CORE DROP CONSTRAINT TAXON_INDICATOR_REFERENCE_PK;
-- Add constraint
ALTER TABLE ONLY ARA.TAXON_INDICATOR_DUBLIN_CORE ADD CONSTRAINT TAXON_INDICATOR_DUBLIN_CORE_PK primary key (DUBLIN_CORE_ID, INDICATOR_ID, TAXON_ID);

--
-- Actualizaciones sobre indicator_reference
--
-- Rename table indicator_reference to indicator_dublin_core
ALTER TABLE ARA.INDICATOR_REFERENCE RENAME TO INDICATOR_DUBLIN_CORE;
-- Rename column reference_id from indicator_dublin_core to dublin_core_id
ALTER TABLE ARA.INDICATOR_DUBLIN_CORE RENAME COLUMN REFERENCE_ID TO DUBLIN_CORE_ID;
-- Remove constraint INDICATOR_REFERENCE_PK
ALTER TABLE ARA.INDICATOR_DUBLIN_CORE DROP CONSTRAINT INDICATOR_REFERENCE_PK;
-- Add constraint INDICATOR_DUBLIN_CORE_pk
ALTER TABLE ONLY ARA.INDICATOR_DUBLIN_CORE add constraint INDICATOR_DUBLIN_CORE_pk primary key (DUBLIN_CORE_ID, INDICATOR_ID);
-- Remove constraint INDICATOR_REFERENCE_ID_FK
ALTER TABLE ARA.INDICATOR_DUBLIN_CORE DROP CONSTRAINT INDICATOR_REFERENCE_ID_FK;
-- Add constraint INDICATOR_DUBLIN_CORE_ID_FK
ALTER TABLE ONLY ARA.INDICATOR_DUBLIN_CORE  ADD CONSTRAINT INDICATOR_DUBLIN_CORE_ID_FK FOREIGN KEY (INDICATOR_ID ) REFERENCES ARA.INDICATOR(INDICATOR_ID);

---------------------------------------------
    -- TABLES FOR DUBLIN_CORE MODULE --
---------------------------------------------

--
-- Dublin Core Elements table
--
create table ara.dublin_core_element (
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

alter table ara.dublin_core_element add constraint dce_pkey primary key (id);
alter table ara.dublin_core_element add constraint dce_ukey1 unique (resource_id,dublin_core_element_id,value);

--
-- Dublin Core Descriptions table
--
create table ara.dublin_core_description (
    resource_id integer not null
  , resource_type_id integer not null
  , description character varying(255) default null
  --log fields
  , creation_date date not null
  , created_by character varying(255) not null
  , last_modification_date date not null
  , last_modification_by character varying(255) not null
);
alter table ara.dublin_core_description add constraint dcd_pkey primary key (resource_id);

-- Hacer OWNER a ara de las nuevas tablas
ALTER TABLE ara.dublin_core_description OWNER TO ara;
ALTER TABLE ara.dublin_core_element OWNER TO ara;

--Create sequence dublin_core_description
CREATE SEQUENCE ARA.DUBLIN_CORE_DESCRIPTION_SEQ;
ALTER TABLE ARA.DUBLIN_CORE_DESCRIPTION ALTER COLUMN RESOURCE_ID SET DEFAULT nextval('ARA.DUBLIN_CORE_DESCRIPTION_SEQ'::regclass);
ALTER TABLE ARA.DUBLIN_CORE_DESCRIPTION_SEQ OWNER TO ara;

--Create sequence dublin_core_element
CREATE SEQUENCE ARA.DUBLIN_CORE_ELEMENT_SEQ;
ALTER TABLE ARA.DUBLIN_CORE_ELEMENT ALTER COLUMN ID SET DEFAULT nextval('ARA.DUBLIN_CORE_ELEMENT_SEQ'::regclass);
ALTER TABLE ARA.DUBLIN_CORE_ELEMENT_SEQ OWNER TO ara;

--
-- Agregar columnas log files a las tablas del modulo indicadores
--
-- Add columns log fields to INDICATOR_DUBLIN_CORE
ALTER TABLE ARA.INDICATOR_DUBLIN_CORE ADD COLUMN creation_date date not null;
ALTER TABLE ARA.INDICATOR_DUBLIN_CORE ADD COLUMN created_by character varying(255) not null;
ALTER TABLE ARA.INDICATOR_DUBLIN_CORE ADD COLUMN last_modification_date date not null;
ALTER TABLE ARA.INDICATOR_DUBLIN_CORE ADD COLUMN last_modification_by character varying(255) not null;

-- Add columns log fields to TAXON_INDICATOR_DUBLIN_CORE
ALTER TABLE ARA.TAXON_INDICATOR_DUBLIN_CORE ADD COLUMN creation_date date not null;
ALTER TABLE ARA.TAXON_INDICATOR_DUBLIN_CORE ADD COLUMN created_by character varying(255) not null;
ALTER TABLE ARA.TAXON_INDICATOR_DUBLIN_CORE ADD COLUMN last_modification_date date not null;
ALTER TABLE ARA.TAXON_INDICATOR_DUBLIN_CORE ADD COLUMN last_modification_by character varying(255) not null;

-- Add columns log fields to TAXON_INDICATOR_COMPONENT_PART
ALTER TABLE ARA.TAXON_INDICATOR_COMPONENT_PART ADD COLUMN creation_date date not null;
ALTER TABLE ARA.TAXON_INDICATOR_COMPONENT_PART ADD COLUMN created_by character varying(255) not null;
ALTER TABLE ARA.TAXON_INDICATOR_COMPONENT_PART ADD COLUMN last_modification_date date not null;
ALTER TABLE ARA.TAXON_INDICATOR_COMPONENT_PART ADD COLUMN last_modification_by character varying(255) not null;



---------------------------------------------------
------------  MÓDULO DE TRANSACCIONES  ------------
---------------------------------------------------

--2010.06.28 echinchilla
-- Eliminando la columna obj_version de la tabla ara.transaction
alter table ara.transaction drop column obj_version;

--2010.06.28 echinchilla
-- Eliminando la columna obj_version de la tabla ara.transaction_type
alter table ara.transaction_type drop column obj_version;

--2010.06.28 echinchilla
-- Eliminando la columna obj_version de la tabla ara.transacted_specimen_status
alter table ara.transacted_specimen_status drop column obj_version;

--2010.06.28 echinchilla
-- Eliminando la columna obj_version de la tabla ara.transacted_specimen
alter table ara.transacted_specimen drop column obj_version;


--2010.06.28 echinchilla
-- Nuevo sequence para la tabla de transaction
CREATE SEQUENCE ara.transaction_seq;
ALTER TABLE ara.transaction_seq OWNER TO ara;
-- Asignar dicho sequence al atributo correspondiente de la tabla
ALTER TABLE ara.transaction  ALTER COLUMN transaction_id SET DEFAULT nextval('ara.transaction_seq'::regclass);

--2010.06.28 echinchilla
-- Nuevo sequence para la tabla de transaction_type
CREATE SEQUENCE ara.transaction_type_seq;
ALTER TABLE ara.transaction_type_seq OWNER TO ara;
-- Asignar dicho sequence al atributo correspondiente de la tabla
ALTER TABLE ara.transaction_type  ALTER COLUMN transaction_type_id SET DEFAULT nextval('ara.transaction_type_seq'::regclass);

--2010.06.28 echinchilla
-- Nuevo sequence para la tabla de transacted_specimen_status
CREATE SEQUENCE ara.transacted_specimen_status_seq;
ALTER TABLE ara.transacted_specimen_status_seq OWNER TO ara;
-- Asignar dicho sequence al atributo correspondiente de la tabla
ALTER TABLE ara.transacted_specimen_status  ALTER COLUMN transacted_specimen_status_id SET DEFAULT nextval('ara.transacted_specimen_status_seq'::regclass);

--2010.06.28 echinchilla
-- Agregar columna faltante a tabla de transacciones
ALTER TABLE ara.transaction ADD COLUMN creation_date date;
ALTER TABLE ara.transaction ALTER COLUMN creation_date SET STORAGE PLAIN;
ALTER TABLE ara.transaction ALTER COLUMN creation_date SET NOT NULL;

--2010.06.28 echinchilla
-- Agregar información de tabla de lista de selección en list_table
INSERT INTO ara.list_table(
            list_table_id, description, obj_version, created_by, creation_date,
            last_modification_by, last_modification_date, "name", key_field_name)
    VALUES (42, 'Tipo de Transacción', 0, 'ara', '2010-03-01',
            'ara', '2010-03-01', 'transaction_type', 'transaction_type_id');

--2010.06.28 echinchilla
-- Agregar información de tabla de lista de selección en list_table
INSERT INTO ara.list_table(
            list_table_id, description, obj_version, created_by, creation_date,
            last_modification_by, last_modification_date, "name", key_field_name)
    VALUES (43, 'Estado de Espécimen Transado', 0, 'ara', '2010-03-01',
            'ara', '2010-03-01', 'transacted_specimen_status', 'transacted_specimen_status_id');

--2010.06.28 echinchilla
-- Cambiar el tipo de la columna CREATION_DATE de DATE a TIMESTAMP
-- en la tabla TRANSACTED_SPECIMEN, para ordenar los especímenes transados.
ALTER TABLE ara.transacted_specimen
	ALTER COLUMN creation_date TYPE timestamp;

--2010.06.29 echinchilla
-- Agregar columna de descripción para transacted_specimen, necesario para botánica.
ALTER TABLE ara.transacted_specimen
    ADD COLUMN description character varying(500);

--2010.07.30 echinchilla
-- Agregar columna de En Espera de Devolución para transacted_specimen.
ALTER TABLE ara.transacted_specimen
   ADD COLUMN waiting_for_return boolean NOT NULL;

--2010.08.05 echinchilla
-- Cambiar el tipo de la columna CREATION_DATE de TIMESTAMP a DATE
-- en la tabla TRANSACTED_SPECIMEN.
ALTER TABLE ara.transacted_specimen
	ALTER COLUMN creation_date TYPE date;

--2010.08.05 echinchilla
-- Agregar columna de fecha y hora de creación a la tabla
-- TRANSACTED_SPECIMEN, para ordenar los especímenes.
ALTER TABLE ara.transacted_specimen
	ADD COLUMN creation_date_and_time timestamp NOT NULL;

---------------------------------------------------
----------  FIN MÓDULO DE TRANSACCIONES  ----------
---------------------------------------------------


--
-- CAMBIOS PARA EL MODULO DE SEMEN
--

--2010.08.20 dasolano. quita los not null no requeriros de la tabla semental
ALTER TABLE ara.semental ALTER COLUMN color DROP NOT NULL;
ALTER TABLE ara.semental ALTER COLUMN condition_id DROP NOT NULL;

--2010.08.20 dasolano. quita los not null no requeridos de la tabla semen_gathering
ALTER TABLE ara.semen_gathering ALTER COLUMN semen_gathering_time DROP NOT NULL;
ALTER TABLE ara.semen_gathering ALTER COLUMN concentration DROP NOT NULL;
ALTER TABLE ara.semen_gathering ALTER COLUMN straw_quantity DROP NOT NULL;
ALTER TABLE ara.semen_gathering ALTER COLUMN dilution DROP NOT NULL;
ALTER TABLE ara.semen_gathering ALTER COLUMN tank_number DROP NOT NULL;
ALTER TABLE ara.semen_gathering ALTER COLUMN canister_number DROP NOT NULL;
ALTER TABLE ara.semen_gathering ALTER COLUMN goblet_number DROP NOT NULL;
ALTER TABLE ara.semen_gathering ALTER COLUMN straw_color DROP NOT NULL;
ALTER TABLE ara.semen_gathering ALTER COLUMN active_doses DROP NOT NULL;
ALTER TABLE ara.semen_gathering ALTER COLUMN straw_size DROP NOT NULL;
ALTER TABLE ara.semen_gathering ALTER COLUMN semen_gathering_method_id DROP NOT NULL;
ALTER TABLE ara.semen_gathering ALTER COLUMN consistency DROP NOT NULL;
ALTER TABLE ara.semen_gathering ALTER COLUMN semen_color DROP NOT NULL;
ALTER TABLE ara.semen_gathering ALTER COLUMN ph DROP NOT NULL;
ALTER TABLE ara.semen_gathering ALTER COLUMN mass_motility DROP NOT NULL;
ALTER TABLE ara.semen_gathering ALTER COLUMN solvent_id DROP NOT NULL;
ALTER TABLE ara.semen_gathering ALTER COLUMN current_straw_quantity DROP NOT NULL;
ALTER TABLE ara.semen_gathering ALTER COLUMN post_thaw_motility DROP NOT NULL;


CREATE TABLE ara.semen_consistency(
semen_consistency_id numeric not null,
name character varying(100) NOT NULL,
description character varying(500),
created_by character varying(20) NOT NULL,
creation_date date NOT NULL,
last_modification_by character varying(20) NOT NULL,
last_modification_date date NOT NULL);

ALTER TABLE ara.semen_consistency OWNER TO ara;

ALTER TABLE ONLY ara.semen_consistency ADD CONSTRAINT "SEMEN_COSISTENCY_ID_PK" PRIMARY KEY (semen_consistency_id);


--2010.08.20 dasolano. Elmina la columna consistencia y agrega la de semen_cosistency_id
ALTER TABLE ara.semen_gathering DROP COLUMN consistency;
ALTER TABLE ara.semen_gathering ADD COLUMN semen_consistency_id numeric;
ALTER TABLE ONLY ara.semen_gathering ADD CONSTRAINT semen_consistency_id_fk FOREIGN KEY (semen_consistency_id) REFERENCES ara.semen_consistency(semen_consistency_id);

INSERT INTO ara.list_table(
            list_table_id, description, obj_version, created_by, creation_date,
            last_modification_by, last_modification_date, "name", key_field_name)
    VALUES (44, '', 0, 'Ara', '2010-8-12',
            'Ara', '2010-8-12', 'semen_consistency', 'semen_consistency_id');

--2010.08.20 dasolano. Secuence para el historico de identificadores
CREATE SEQUENCE ara.semen_consistency_seq;
ALTER TABLE ara.semen_consistency_seq OWNER TO ara;

ALTER TABLE ara.semen_consistency ALTER COLUMN semen_consistency_id
SET DEFAULT nextval('ara.semen_consistency_seq'::regclass);

INSERT INTO ara.semen_consistency(name,description,created_by,creation_date,last_modification_by,last_modification_date)values('Creamy',NULL,'ara','2010-8-12','ara','2010-8-12');
INSERT INTO ara.semen_consistency(name,description,created_by,creation_date,last_modification_by,last_modification_date)values('Thick creamy',NULL,'ara','2010-8-12','ara','2010-8-12');
INSERT INTO ara.semen_consistency(name,description,created_by,creation_date,last_modification_by,last_modification_date)values('Thin creamy',NULL,'ara','2010-8-12','ara','2010-8-12');
--
-- FIN DE LOS CAMBIOS PARA EL MODULO DE SEMEN
--

--Insert del padre de los atributos taxonomicos (indicadores)
--2010.08.27
INSERT INTO ara.indicator(indicator_id, "name", description, creation_date, created_by, last_modification_date, last_modification_by, indicator_ancestor_id, applies_to_parts) VALUES (0, 'Atributos Taxonómicos', null, '2010-08-27', 'ara', '2010-08-27', 'ara', null,null);


--
-- Cambios modulo de semen
--
--2010.09.09
--Se agregaron nuevos campos a las recolecciones de semen
ALTER TABLE ara.semen_gathering ADD COLUMN total_sperm_concentration numeric;
ALTER TABLE ara.semen_gathering ADD COLUMN sperm_concentration_per_straw numeric;
--final de los cambios


--2010.09.16 gsulca
/* A */
INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('AF','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('AX','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('AL','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('DZ','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('AS','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('AD','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('AO','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('AI','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('AQ','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('AG','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('AR','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('AM','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('AW','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('AU','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('AT','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('AZ','2010-09-13' , 'admin', '2010-09-13', 'admin');

/* B */

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('BS','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('BH','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('BD','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('BB','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('BY','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('BE','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('BZ','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('BJ','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('BM','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('BT','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('BO','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('BA','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('BW','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('BV','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('BR','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('IO','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('BN','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('BG','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('BF','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('BI','2010-09-13' , 'admin', '2010-09-13', 'admin');

/* C */

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('KH','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('CM','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('CA','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('CV','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('KY','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('CF','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('TD','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('CL','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('CN','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('CX','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('CC','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('CO','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('KM','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('CG','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('CD','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('CK','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('CR','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('CI','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('HR','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('CU','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('CY','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('CZ','2010-09-13' , 'admin', '2010-09-13', 'admin');

/* D */

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('DK','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('DJ','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('DM','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('DO','2010-09-13' , 'admin', '2010-09-13', 'admin');

/* E */

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('EC','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('EG','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('SV','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('GQ','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('ER','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('EE','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('ET','2010-09-13' , 'admin', '2010-09-13', 'admin');

/* F */

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('FK','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('FO','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('FJ','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('FI','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('FR','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('GF','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('PF','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('TF','2010-09-13' , 'admin', '2010-09-13', 'admin');

/* G */

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('GA','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('GM','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('GE','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('DE','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('GH','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('GI','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('GR','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('GL','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('GD','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('GP','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('GU','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('GT','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('GT','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('GG','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('GN','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('GW','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('GY','2010-09-13' , 'admin', '2010-09-13', 'admin');

/* H */

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('HT','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('HM','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('VA','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('HN','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('HK','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('HU','2010-09-13' , 'admin', '2010-09-13', 'admin');

/* I */

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('IS','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('IN','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('ID','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('IR','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('IQ','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('IE','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('IM','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('IL','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('IT','2010-09-13' , 'admin', '2010-09-13', 'admin');

/* J */

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('JM','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('JP','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('JE','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('JO','2010-09-13' , 'admin', '2010-09-13', 'admin');

/* K */

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('KZ','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('KE','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('KI','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('KP','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('KR','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('KW','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('KG','2010-09-13' , 'admin', '2010-09-13', 'admin');

/* L */

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('LA','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('LV','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('LB','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('LS','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('LR','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('LY','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('LI','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('LT','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('LU','2010-09-13' , 'admin', '2010-09-13', 'admin');

/* M */

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('MO','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('MK','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('MG','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('MW','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('MY','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('MV','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('ML','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('MT','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('MH','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('MQ','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('MR','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('MU','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('YT','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('MX','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('FM','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('MD','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('MC','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('MN','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('ME','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('MS','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('MA','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('MZ','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('MM','2010-09-13' , 'admin', '2010-09-13', 'admin');

/* N */

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('NA','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('NR','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('NP','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('NL','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('AN','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('NC','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('NZ','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('NI','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('NE','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('NG','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('NU','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('NF','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('MP','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('NO','2010-09-13' , 'admin', '2010-09-13', 'admin');

/* O */

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('OM','2010-09-13' , 'admin', '2010-09-13', 'admin');

/* P */

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('PK','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('PW','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('PS','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('PA','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('PG','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('PY','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('PE','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('PH','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('PN','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('PL','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('PT','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('PR','2010-09-13' , 'admin', '2010-09-13', 'admin');

/* Q */

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('QA','2010-09-13' , 'admin', '2010-09-13', 'admin');

/* R */

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('RE','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('RO','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('RU','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('RW','2010-09-13' , 'admin', '2010-09-13', 'admin');


/* S */

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('BL','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('SH','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('KN','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('LC','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('MF','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('PM','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('VC','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('WS','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('SM','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('ST','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('SA','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('SN','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('RS','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('SC','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('SL','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('SG','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('SK','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('SI','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('SB','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('SO','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('ZA','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('GS','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('ES','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('LK','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('SD','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('SR','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('SJ','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('SZ','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('SE','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('CH','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('SY','2010-09-13' , 'admin', '2010-09-13', 'admin');

/* T */

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('TW','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('TJ','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('TZ','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('TH','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('TL','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('TG','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('TK','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('TO','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('TT','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('TN','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('TR','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('TM','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('TC','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('TV','2010-09-13' , 'admin', '2010-09-13', 'admin');

/* U */

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('UG','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('UA','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('AE','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('GB','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('US','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('UM','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('UY','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('UZ','2010-09-13' , 'admin', '2010-09-13', 'admin');

/* V */

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('VU','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('VE','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('VN','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('VG','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('VI','2010-09-13' , 'admin', '2010-09-13', 'admin');

/* W */

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('WF','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('EH','2010-09-13' , 'admin', '2010-09-13', 'admin');

/* Y */

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('YE','2010-09-13' , 'admin', '2010-09-13', 'admin');

/* Z */

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('ZM','2010-09-13' , 'admin', '2010-09-13', 'admin');

INSERT INTO ara.country("value", creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('ZW','2010-09-13' , 'admin', '2010-09-13', 'admin');



create table ARA.TAXON_INDICATOR_COUNTRY  (
   COUNTRY_ID    	numeric NOT NULL,
   INDICATOR_ID         numeric NOT NULL,
   TAXON_ID             numeric NOT NULL,
   created_by character varying(20) NOT NULL,
   creation_date date NOT NULL,
   last_modification_by character varying(20) NOT NULL,
   last_modification_date date NOT NULL);

ALTER TABLE ONLY ARA.TAXON_INDICATOR_COUNTRY ADD CONSTRAINT TAXON_INDICATOR_COUNTRY_ID_PK PRIMARY KEY (COUNTRY_ID,INDICATOR_ID, TAXON_ID);
ALTER TABLE ONLY ARA.TAXON_INDICATOR_COUNTRY ADD CONSTRAINT TAXON_INDICATOR_COUNTRY_fk FOREIGN KEY (INDICATOR_ID, TAXON_ID) REFERENCES ARA.TAXON_INDICATOR(INDICATOR_ID, TAXON_ID);
ALTER TABLE ONLY ARA.TAXON_INDICATOR_COUNTRY OWNER TO ara;


ALTER TABLE ARA.TAXON_INDICATOR ALTER COLUMN VALUER_PERSON_ID DROP NOT NULL;

--2010.11.08 gsulca
UPDATE ara.indicator SET applies_to_parts=0 WHERE name='Atributos Taxonómicos';

--2010.11.18 gsulca
ALTER TABLE ara.taxon_author_connector DROP COLUMN obj_version;
-- Secuence para taxon_author_connector
CREATE SEQUENCE ara.taxon_author_connector_seq;
ALTER TABLE ara.taxon_author_connector_seq OWNER TO ara;
ALTER TABLE ara.taxon_author_connector ALTER COLUMN taxon_author_connector_id
SET DEFAULT nextval('ara.taxon_author_connector_seq'::regclass);


---------------------------------------------
    -- TABLES FOR LABELS MODULE --
---------------------------------------------
--2010.11.29 pcorrales

-- Addition of columns to support new features.
ALTER TABLE ara.label ALTER COLUMN initial_date TYPE timestamp without time zone;
ALTER TABLE ara.label ALTER COLUMN initial_date SET NOT NULL;
ALTER TABLE ara.label DROP COLUMN obj_version;
ALTER TABLE ara.label ADD COLUMN final_date timestamp without time zone;
ALTER TABLE ara.label ADD COLUMN label_type_id numeric;
ALTER TABLE ara.label ADD COLUMN ancestor_label_id numeric;

--create sequence
CREATE SEQUENCE ara.label_seq;
ALTER TABLE ara.label_seq OWNER TO ara;

--add sequence
ALTER TABLE ara.label  ALTER COLUMN label_id  SET DEFAULT nextval('ara.label_seq'::regclass);

------------------------------------------------------------------------------------------------

-- drop unnecesary column
ALTER TABLE ara.label_history DROP COLUMN obj_version;

-- Add new columns to support new features.
ALTER TABLE ara.label_history ALTER COLUMN initial_date TYPE timestamp without time zone;
ALTER TABLE ara.label_history ALTER COLUMN initial_date SET NOT NULL;
ALTER TABLE ara.label_history ALTER COLUMN final_date TYPE timestamp without time zone;
ALTER TABLE ara.label_history ADD COLUMN ancestor_label_id numeric;


--add primary key
ALTER TABLE  ara.label_history ADD CONSTRAINT label_history_pk PRIMARY KEY (label_id,initial_date);

--add foreing key
ALTER TABLE  ara.label_history  ADD CONSTRAINT label_fk FOREIGN KEY (label_id)
      REFERENCES ara.label (label_id);


------------------------------------------------------------------------------------------------

-- drop unnecesary column
ALTER TABLE ara.original_label DROP COLUMN obj_version;


-- Secuence for original label
CREATE SEQUENCE ara.original_label_seq;
ALTER TABLE ara.original_label_seq OWNER TO ara;

ALTER TABLE ara.original_label  ALTER COLUMN original_label_id  SET DEFAULT nextval('ara.original_label_seq'::regclass);

---- modificar  la tabla de specimen para que posee el campo de label

ALTER TABLE ara.specimen  ADD COLUMN label_id numeric;
ALTER TABLE ara.specimen  ADD COLUMN  original_label_id numeric;

---------------------------------------------
    -- TABLES FOR FORMAT LABEL MODULE --
---------------------------------------------
--2010.11.29 pcorrales

-------------------------------------------------------------
-- Table: ara.funcionality_type

CREATE TABLE ara.funcionality_type
(
  funcionality_type_id numeric NOT NULL,
  funcionality_type_keyword character varying(100) NOT NULL,
  description character varying(100) NOT NULL,
  creation_date date NOT NULL,
  created_by character varying(100) NOT NULL,
  last_modification_date date NOT NULL,
  last_modification_by character varying(100) NOT NULL
);

ALTER TABLE ara.funcionality_type ADD CONSTRAINT pk_funcionality_id PRIMARY KEY (funcionality_type_id);

-------------------------------------------------------------
--create tabel report layout

CREATE TABLE ara.report_layout
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
ALTER TABLE ara.report_layout ADD CONSTRAINT pk_report_id PRIMARY KEY (report_layout_id);

--add foreing key
ALTER TABLE ara.report_layout ADD CONSTRAINT funcionality_type_fk FOREIGN KEY (funcionality_type_id)
      REFERENCES ara.funcionality_type (funcionality_type_id);

------------------------------------------------------------------------------------------

-- create Table: ara.report_layout_category


CREATE TABLE ara.report_layout_category
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
ALTER TABLE ara.report_layout_category ADD  CONSTRAINT pk_category_id PRIMARY KEY (report_layout_category_id );

--------------------------------------------------------------------------------------------------
CREATE TABLE ara.report_layout_element
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
ALTER TABLE ara.report_layout_element ADD CONSTRAINT pk_element_id PRIMARY KEY (report_layout_element_id);

--add foreing key
ALTER TABLE ara.report_layout_element ADD CONSTRAINT category_fk FOREIGN KEY (report_layout_category_id )
      REFERENCES ara.report_layout_category (report_layout_category_id);


---------------------------------------------------------------------------------------
--Table: ara.element_format;

CREATE TABLE ara.element_format
(
  element_format_id numeric NOT NULL,
  element_format_keyword character varying(100) NOT NULL,
  creation_date date NOT NULL,
  created_by character varying(100) NOT NULL,
  last_modification_date date NOT NULL,
  last_modification_by character varying(100) NOT NULL
);

--add primary key
ALTER TABLE ara.element_format ADD  CONSTRAINT pk_element_format_id PRIMARY KEY (element_format_id);


-------------------------------------------------------------------------------------

--Table: ara.report_layout_element_format

CREATE TABLE ara.report_layout_element_format
(
  element_format_id numeric NOT NULL,
  report_layout_element_id numeric NOT NULL,
  creation_date date NOT NULL,
  created_by character varying(100) NOT NULL,
  last_modification_date date NOT NULL,
  last_modification_by character varying(100) NOT NULL
);

--add primary key
ALTER TABLE  ara.report_layout_element_format ADD  CONSTRAINT pk_report_layout_element_format_id PRIMARY KEY (report_layout_element_id,element_format_id);

--add foreing key
ALTER TABLE  ara.report_layout_element_format ADD  CONSTRAINT report_layout_element_fk FOREIGN KEY (report_layout_element_id)
  REFERENCES ara.report_layout_element (report_layout_element_id);

---------------------------------------------------------------------------------

--Table: ara.element_format

CREATE TABLE ara.report_layout_selected_element
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

ALTER TABLE ara.report_layout_selected_element ADD CONSTRAINT pk_report_layout_selected_element_id PRIMARY KEY (report_layout_selected_element_id );

--add foreing key
ALTER TABLE ara.report_layout_selected_element ADD  CONSTRAINT element_format_fk FOREIGN KEY (element_format_id)
      REFERENCES ara.element_format (element_format_id);

ALTER TABLE ara.report_layout_selected_element ADD CONSTRAINT report_layout_element_fk FOREIGN KEY (report_layout_element_id)
      REFERENCES ara.report_layout_element (report_layout_element_id);

ALTER TABLE ara.report_layout_selected_element ADD CONSTRAINT report_layout_fk FOREIGN KEY (report_layout_id)
      REFERENCES ara.report_layout (report_layout_id);

alter table ara.report_layout owner to ara;
alter table ara.report_layout_category owner to ara;
alter table ara.report_layout_element owner to ara;
alter table ara.report_layout_element_format owner to ara;
alter table ara.report_layout_selected_element owner to ara;
alter table ara.funcionality_type owner to ara;
--2010.11.29 pcorrales End
---------------------------------------------


--2010.12.15 esmata and mvargas
-- Function: ara.taxon_nomenclatural_group_list(numeric, text)
-- DROP FUNCTION ara.taxon_nomenclatural_group_list(numeric, text);
CREATE OR REPLACE FUNCTION ara.taxon_nomenclatural_group_list(arg_taxon_id numeric, arg_separator text)
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
      from ara.taxon_nomenclatural_group tng, ara.nomenclatural_group ng
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
ALTER FUNCTION ara.taxon_nomenclatural_group_list(numeric, text) OWNER TO ara;

--------------------------------------------------------------------------------
--2011.01.19 esmata
-- Adding a foreing key constrint to audience_id on table taxon_description_audience
ALTER TABLE ara.taxon_description_audience ADD CONSTRAINT audience_fk FOREIGN KEY (audience_id)
      REFERENCES ara.audience (audience_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;

