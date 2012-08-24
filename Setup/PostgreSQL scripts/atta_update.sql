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

--2011.03.23 gsulca

--Set start profile_seq
-- usar: select setval('atta.identification_history_seq',cast(max(identification_history_id) as bigint)+1) from atta.identification_history;
ALTER SEQUENCE ATTA.PROFILE_SEQ RESTART WITH 22;

-- Adding profiles
INSERT INTO ATTA.PROFILE (name, description, creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('Autor de registros de especies', null, '2011-03-24', 'admin', '2011-03-24', 'admin');

INSERT INTO ATTA.PROFILE (name, description, creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('Autor de descripciones morfologicas',  null, '2011-03-24', 'admin', '2011-03-24', 'admin');

INSERT INTO ATTA.PROFILE (name, description, creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('Donor person',  null, '2011-03-24', 'admin', '2011-03-24', 'admin');

INSERT INTO ATTA.PROFILE (name, description, creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('Responsible person',  null, '2011-03-24', 'admin', '2011-03-24', 'admin');

--2011.03.28 gsulca

--Set start profile_seq
ALTER SEQUENCE ATTA.TAXON_SEQ RESTART WITH 74762;

INSERT INTO ATTA.TAXON (taxonomical_range_id, current_name, current_name_timestamp, default_name, current_predecessor_timestamp, taxon_category_id, author_format_parenthesis, creation_date, created_by, last_modification_date, last_modification_by)
	VALUES('0', 'Base taxonómica', '2011-03-28', 'Base taxonómica', '2011-03-28', 1, 0, '2011-03-28', 'admin', '2011-03-28', 'admin');

UPDATE ATTA.TAXON SET ancestor_id = 74762 WHERE taxonomical_range_id = 23;

--2011.03.30 gsulca

INSERT INTO atta.list_table (list_table_id,description,obj_version,created_by,creation_date,last_modification_by,last_modification_date,name,key_field_name)
values (154,'Exposition',0,'atta','2011-03-30','atta','2011-03-30','exposition','exposition_id');

INSERT INTO atta.list_table (list_table_id,description,obj_version,created_by,creation_date,last_modification_by,last_modification_date,name,key_field_name)
values (155,'Tipo de Material',0,'atta','2010-01-21','atta','2010-01-21','material_type','material_type_id');
INSERT INTO atta.list_table (list_table_id,description,obj_version,created_by,creation_date,last_modification_by,last_modification_date,name,key_field_name)
values (156,'Sistema de Cultivo',0,'atta','2010-01-21','atta','2010-01-21','crop_system','crop_system_id');
INSERT INTO atta.list_table (list_table_id,description,obj_version,created_by,creation_date,last_modification_by,last_modification_date,name,key_field_name)
values (157,'Tipo de Cultivo',0,'atta','2010-01-21','atta','2010-01-21','crop_type','crop_type_id');
INSERT INTO atta.list_table (list_table_id,description,obj_version,created_by,creation_date,last_modification_by,last_modification_date,name,key_field_name)
values (158,'Practica de Cultivo',0,'atta','2010-01-21','atta','2010-01-21','cultivation_practice','cultivation_practice_id');
INSERT INTO atta.list_table (list_table_id,description,obj_version,created_by,creation_date,last_modification_by,last_modification_date,name,key_field_name)
values (159,'Fuente de Recoleccion',0,'atta','2010-01-21','atta','2010-01-21','gathering_source','gathering_source_id');
INSERT INTO atta.list_table (list_table_id,description,obj_version,created_by,creation_date,last_modification_by,last_modification_date,name,key_field_name)
values (160,'Estado de la muestra',0,'atta','2010-01-21','atta','2010-01-21','sample_status','sample_status_id');
INSERT INTO atta.list_table (list_table_id,description,obj_version,created_by,creation_date,last_modification_by,last_modification_date,name,key_field_name)
values (161,'Color de Suelo',0,'atta','2010-01-21','atta','2010-01-21','soil_color','soil_color_id');
INSERT INTO atta.list_table (list_table_id,description,obj_version,created_by,creation_date,last_modification_by,last_modification_date,name,key_field_name)
values (162,'Textura del Suelo',0,'atta','2010-01-21','atta','2010-01-21','soil_texture','soil_texture_id');

INSERT INTO atta.list_table (list_table_id,description,obj_version,created_by,creation_date,last_modification_by,last_modification_date,name,key_field_name)
values (163,'Método de Germinación',0,'atta','2010-03-03','atta','2010-03-03','germination_method_type','germination_method_type_id');

INSERT INTO atta.list_table (list_table_id,description,obj_version,created_by,creation_date,last_modification_by,last_modification_date,name,key_field_name)
values (164,'Tipo de Colección',0,'atta','2010-03-03','atta','2010-03-03','collection_type','collection_type_id');

INSERT INTO atta.list_table (list_table_id,description,obj_version,created_by,creation_date,last_modification_by,last_modification_date,name,key_field_name)
values (165,'Método de Humedad',0,'atta','2010-03-03','atta','2010-03-03','moisture_method_type','moisture_method_type_id');

INSERT INTO atta.list_table (list_table_id,description,obj_version,created_by,creation_date,last_modification_by,last_modification_date,name,key_field_name)
values (166,'Movimiento de Accesión',0,'atta','2010-03-03','atta','2010-03-03','accession_movement_type','accession_movement_type_id');

INSERT INTO atta.list_table(
            list_table_id, description, obj_version, created_by, creation_date,
            last_modification_by, last_modification_date, "name", key_field_name)
    VALUES (167, '', 0, 'Ara', '2010-04-13',
            'Ara', '2010-04-13', 'condition', 'condition_id');

INSERT INTO atta.list_table(
            list_table_id, description, obj_version, created_by, creation_date,
            last_modification_by, last_modification_date, "name", key_field_name)
    VALUES (168, '', 0, 'Ara', '2010-04-13',
            'Ara', '2010-04-13', 'semen_gathering_method', 'semen_gathering_method_id');

INSERT INTO atta.list_table(
            list_table_id, description, obj_version, created_by, creation_date,
            last_modification_by, last_modification_date, "name", key_field_name)
    VALUES (169, '', 0, 'Ara', '2010-04-13',
            'Ara', '2010-04-13', 'solvent', 'solvent_id');

INSERT INTO atta.list_table(
            list_table_id, description, obj_version, created_by, creation_date,
            last_modification_by, last_modification_date, "name", key_field_name)
    VALUES (170, 'Tipo de Transacción', 0, 'atta', '2010-03-01',
            'atta', '2010-03-01', 'transaction_type', 'transaction_type_id');

INSERT INTO atta.list_table(
            list_table_id, description, obj_version, created_by, creation_date,
            last_modification_by, last_modification_date, "name", key_field_name)
    VALUES (171, 'Estado de Espécimen Transado', 0, 'atta', '2010-03-01',
            'atta', '2010-03-01', 'transacted_specimen_status', 'transacted_specimen_status_id');

INSERT INTO atta.list_table(
            list_table_id, description, obj_version, created_by, creation_date,
            last_modification_by, last_modification_date, "name", key_field_name)
    VALUES (172, '', 0, 'Ara', '2010-8-12',
            'Ara', '2010-8-12', 'semen_consistency', 'semen_consistency_id');

--2011.04.08 gsulca

--Set start gathering_observation_seq
select setval('atta.gathering_observation_seq',cast(max(gathering_observation_id) as bigint)+1) from atta.gathering_observation;

-- 2011.04.12 gsulca

--Set start accession_movement_type_seq
select setval('atta.accession_movement_type_seq',cast(max(accession_movement_type_id) as bigint)+1) from atta.accession_movement_type;

--Set start accession_seq
select setval('atta.accession_seq',cast(max(accession_id) as bigint)+1) from atta.accession;

--Set start audience_seq
select setval('atta.audience_seq',cast(max(audience_id) as bigint)+1) from atta.audience;

--Set start breed_seq
select setval('atta.breed_seq',cast(max(breed_id) as bigint)+1) from atta.breed;

--Set start collection_seq
select setval('atta.collection_seq',cast(max(collection_id) as bigint)+1) from atta.collection;

--Set start collection_type_seq
select setval('atta.collection_type_seq',cast(max(collection_type_id) as bigint)+1) from atta.collection_type;

--Set start component_part_seq
select setval('atta.component_part_seq',cast(max(component_part_id) as bigint)+1) from atta.component_part;

--Set start condition_seq
select setval('atta.condition_seq',cast(max(condition_id) as bigint)+1) from atta.condition;

--Set start country_seq
select setval('atta.country_seq',cast(max(country_id) as bigint)+1) from atta.country;

--Set start crop_system_seq
select setval('atta.crop_system_seq',cast(max(crop_system_id) as bigint)+1) from atta.crop_system;

--Set start crop_type_seq
select setval('atta.crop_type_seq',cast(max(crop_type_id) as bigint)+1) from atta.crop_type;

--Set start cultivation_practice_seq
select setval('atta.cultivation_practice_seq',cast(max(cultivation_practice_id) as bigint)+1) from atta.cultivation_practice;

--Set start dublin_core_description_seq
select setval('atta.dublin_core_description_seq',cast(max(resource_id) as bigint)+1) from atta.dublin_core_description;

--Set start dublin_core_element_seq
select setval('atta.dublin_core_element_seq',cast(max(dublin_core_element_id) as bigint)+1) from atta.dublin_core_element;

--Set start dublin_core_element_seq
select setval('atta.dublin_core_element_seq',cast(max(dublin_core_element_id) as bigint)+1) from atta.dublin_core_element;

--Set start exposition_seq
select setval('atta.exposition_seq',cast(max(exposition_id) as bigint)+1) from atta.exposition;

--Set start extraction_type_seq
select setval('atta.extraction_type_seq',cast(max(extraction_type_id) as bigint)+1) from atta.extraction_type;

--Set start gathering_observation_detail_seq
select setval('atta.gathering_observation_detail_seq',cast(max(gathering_observation_detail_id) as bigint)+1) from atta.gathering_observation_detail;

--Set start gathering_observation_method_seq
select setval('atta.gathering_observation_method_seq',cast(max(gathering_observation_method_id) as bigint)+1) from atta.gathering_observation_method;

--Set start gathering_observation_seq
select setval('atta.gathering_observation_seq',cast(max(gathering_observation_id) as bigint)+1) from atta.gathering_observation;

--Set start gathering_source_seq
select setval('atta.gathering_source_seq',cast(max(gathering_source_id) as bigint)+1) from atta.gathering_source;

--Set start germination_method_type_seq
select setval('atta.germination_method_type_seq',cast(max(germination_method_type_id) as bigint)+1) from atta.germination_method_type;

--Set start identification_history_seq
select setval('atta.identification_history_seq',cast(max(identification_history_id) as bigint)+1) from atta.identification_history;

--Set start indicator_seq
select setval('atta.indicator_seq',cast(max(indicator_id) as bigint)+1) from atta."indicator";

--Set start institution_seq
select setval('atta.institution_seq',cast(max(institution_id) as bigint)+1) from atta.institution;

--Set start life_form_seq
select setval('atta.life_form_seq',cast(max(life_form_id) as bigint)+1) from atta.life_form;

--Set start life_stage_seq
select setval('atta.life_stage_seq',cast(max(life_stage_id) as bigint)+1) from atta.life_stage;

--Set start material_type_seq
select setval('atta.material_type_seq',cast(max(material_type_id) as bigint)+1) from atta.material_type;

--Set start moisture_method_type_seq
select setval('atta.moisture_method_type_seq',cast(max(moisture_method_type_id) as bigint)+1) from atta.moisture_method_type;

--Set start morphological_description_seq
select setval('atta.morphological_description_seq',cast(max(morphological_description_id) as bigint)+1) from atta.morphological_description;

--Set start nomenclatural_group_seq
select setval('atta.nomenclatural_group_seq',cast(max(nomenclatural_group_id) as bigint)+1) from atta.nomenclatural_group;

--Set start origin_seq
select setval('atta.origin_seq',cast(max(origin_id) as bigint)+1) from atta.origin;

--Set start passport_seq
select setval('atta.passport_seq',cast(max(passport_id) as bigint)+1) from atta.passport;

--Set start person_seq
select setval('atta.person_seq',cast(max(person_id) as bigint)+1) from atta.person;

--Set start preservation_medium_seq
select setval('atta.preservation_medium_seq',cast(max(preservation_medium_id) as bigint)+1) from atta.preservation_medium;

--Set start profile_seq
select setval('atta.profile_seq',cast(max(profile_id) as bigint)+1) from atta.profile;

--Set start province_seq
select setval('atta.province_seq',cast(max(province_id) as bigint)+1) from atta.province;

--Set start sample_status_seq
select setval('atta.sample_status_seq',cast(max(sample_status_id) as bigint)+1) from atta.sample_status;

--Set start semen_gathering_method_seq
select setval('atta.semen_gathering_method_seq',cast(max(semen_gathering_method_id) as bigint)+1) from atta.semen_gathering_method;

--Set start semen_gathering_seq
select setval('atta.semen_gathering_seq',cast(max(semen_gathering_id) as bigint)+1) from atta.semen_gathering;

--Set start semental_seq
select setval('atta.semental_seq',cast(max(semental_id) as bigint)+1) from atta.semental;

--Set start sex_seq
select setval('atta.sex_seq',cast(max(sex_id) as bigint)+1) from atta.sex;

--Set start site_coordinate_seq
select setval('atta.site_coordinate_seq',cast(max(site_coordinate_id) as bigint)+1) from atta.site_coordinate;

--Set start site_seq
select setval('atta.site_seq',cast(max(site_id) as bigint)+1) from atta.site;

--Set start soil_color_seq
select setval('atta.soil_color_seq',cast(max(soil_color_id) as bigint)+1) from atta.soil_color;

--Set start soil_texture_seq
select setval('atta.soil_texture_seq',cast(max(soil_texture_id) as bigint)+1) from atta.soil_texture;

--Set start solvent_seq
select setval('atta.solvent_seq',cast(max(solvent_id) as bigint)+1) from atta.solvent;

--Set start specimen_category_seq
select setval('atta.specimen_category_seq',cast(max(specimen_category_id) as bigint)+1) from atta.specimen_category;

--Set start specimen_seq
select setval('atta.specimen_seq',cast(max(specimen_id) as bigint)+1) from atta.specimen;

--Set start specimen_type_seq
select setval('atta.specimen_type_seq',cast(max(specimen_type_id) as bigint)+1) from atta.specimen_type;

--Set start storage_type_seq
select setval('atta.storage_type_seq',cast(max(storage_type_id) as bigint)+1) from atta.storage_type;

--Set start substrate_seq
select setval('atta.substrate_seq',cast(max(substrate_id) as bigint)+1) from atta.substrate;

--Set start system_user_seq
select setval('atta.system_user_seq',cast(max(user_id) as bigint)+1) from atta."system_user";

--Set start taxon_author_connector_seq
select setval('atta.taxon_author_connector_seq',cast(max(taxon_author_connector_id) as bigint)+1) from atta.taxon_author_connector;

--Set start taxon_description_element_seq
select setval('atta.taxon_description_element_seq',cast(max(taxon_description_element_id) as bigint)+1) from atta.taxon_description_element;

--Set start taxon_description_record_seq
select setval('atta.taxon_description_record_seq',cast(max(taxon_description_record_id) as bigint)+1) from atta.taxon_description_record;

--Set start taxon_description_stage_seq
select setval('atta.taxon_description_stage_seq',cast(max(taxon_description_stage_id) as bigint)+1) from atta.taxon_description_stage;

--Set start taxon_seq
select setval('atta.taxon_seq',cast(max(taxon_id) as bigint)+1) from atta.taxon;

--Set start transacted_specimen_status_seq
select setval('atta.transacted_specimen_status_seq',cast(max(transacted_specimen_status_id) as bigint)+1) from atta.transacted_specimen_status;

--Set start transaction_seq
select setval('atta.transaction_seq',cast(max(transaction_id) as bigint)+1) from atta."transaction";

--Set start transaction_type_seq
select setval('atta.transaction_type_seq',cast(max(transaction_type_id) as bigint)+1) from atta.transaction_type;



--  2011.04.13 TABLAS Y SEQUECE PARA EL MODULO DE MANEJO DE MUESTRAS

CREATE SEQUENCE atta.bioprospecting_project_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE atta.bioprospecting_project_seq OWNER TO atta;

CREATE SEQUENCE atta.sample_class_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE atta.sample_class_seq OWNER TO atta;

CREATE SEQUENCE atta.permission_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE atta.permission_seq OWNER TO atta;

CREATE SEQUENCE atta.micro_source_type_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE atta.micro_source_type_seq OWNER TO atta;

CREATE SEQUENCE atta.micro_method_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE atta.micro_method_seq OWNER TO atta;

CREATE SEQUENCE atta.micro_fome_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE atta.micro_fome_seq OWNER TO atta;

CREATE SEQUENCE atta.micro_quality_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE atta.micro_quality_seq OWNER TO atta;

CREATE SEQUENCE atta.sample_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE atta.sample_seq OWNER TO atta;

CREATE SEQUENCE atta.enviromental_data_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE atta.enviromental_data_seq OWNER TO atta;


CREATE SEQUENCE atta.vertical_strata_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE atta.vertical_strata_seq OWNER TO atta;

CREATE SEQUENCE atta.vegetation_type_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE atta.vegetation_type_seq OWNER TO atta;

CREATE SEQUENCE atta.sample_state_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE atta.sample_state_seq OWNER TO atta;

CREATE SEQUENCE atta.sample_quantity_measurement_unit_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE atta.sample_quantity_measurement_unit_seq OWNER TO atta;

CREATE TABLE atta.sample_class
(
  sample_class_id numeric NOT NULL DEFAULT nextval('atta.sample_class_seq'::regclass),
  "name" character varying(100) NOT NULL,
  description character varying(500),
  created_by character varying(20) NOT NULL,
  creation_date date NOT NULL,
  last_modification_by character varying(20) NOT NULL,
  last_modification_date date NOT NULL,
  CONSTRAINT "SAMPLE_CLASS_ID_PK" PRIMARY KEY (sample_class_id)
);
ALTER TABLE atta.sample_class OWNER TO atta;

CREATE TABLE atta.permission
(
  permission_id numeric NOT NULL DEFAULT nextval('atta.permission_seq'::regclass),
  "name" character varying(100) NOT NULL,
  description character varying(500),
  created_by character varying(20) NOT NULL,
  creation_date date NOT NULL,
  last_modification_by character varying(20) NOT NULL,
  last_modification_date date NOT NULL,
  CONSTRAINT "PERMISSION_ID_PK" PRIMARY KEY (permission_id)
);
ALTER TABLE atta.permission OWNER TO atta;

CREATE TABLE atta.micro_source_type
(
  micro_source_type_id numeric NOT NULL DEFAULT nextval('atta.micro_source_type_seq'::regclass),
  "name" character varying(100) NOT NULL,
  description character varying(500),
  created_by character varying(20) NOT NULL,
  creation_date date NOT NULL,
  last_modification_by character varying(20) NOT NULL,
  last_modification_date date NOT NULL,
  CONSTRAINT "MICRO_SOURCE_TYPE_ID_PK" PRIMARY KEY (micro_source_type_id)
);
ALTER TABLE atta.micro_source_type OWNER TO atta;

CREATE TABLE atta.micro_method
(
  micro_method_id numeric NOT NULL DEFAULT nextval('atta.micro_method_seq'::regclass),
  "name" character varying(100) NOT NULL,
  description character varying(500),
  created_by character varying(20) NOT NULL,
  creation_date date NOT NULL,
  last_modification_by character varying(20) NOT NULL,
  last_modification_date date NOT NULL,
  CONSTRAINT "MICRO_METHOD_ID_PK" PRIMARY KEY (micro_method_id)
);
ALTER TABLE atta.micro_method OWNER TO atta;

CREATE TABLE atta.micro_fome
(
  micro_fome_id numeric NOT NULL DEFAULT nextval('atta.micro_fome_seq'::regclass),
  "name" character varying(100) NOT NULL,
  description character varying(500),
  created_by character varying(20) NOT NULL,
  creation_date date NOT NULL,
  last_modification_by character varying(20) NOT NULL,
  last_modification_date date NOT NULL,
  CONSTRAINT "MICRO_FOME_ID_PK" PRIMARY KEY (micro_fome_id)
);
ALTER TABLE atta.micro_fome OWNER TO atta;

CREATE TABLE atta.micro_quality
(
  micro_quality_id numeric NOT NULL DEFAULT nextval('atta.micro_quality_seq'::regclass),
  "name" character varying(100) NOT NULL,
  description character varying(500),
  created_by character varying(20) NOT NULL,
  creation_date date NOT NULL,
  last_modification_by character varying(20) NOT NULL,
  last_modification_date date NOT NULL,
  CONSTRAINT "MICRO_QUALITY_ID_PK" PRIMARY KEY (micro_quality_id)
);
ALTER TABLE atta.micro_quality OWNER TO atta;


CREATE TABLE atta.vertical_strata
(
  vertical_strata_id numeric NOT NULL DEFAULT nextval('atta.vertical_strata_seq'::regclass),
  "name" character varying(100) NOT NULL,
  description character varying(500),
  created_by character varying(20) NOT NULL,
  creation_date date NOT NULL,
  last_modification_by character varying(20) NOT NULL,
  last_modification_date date NOT NULL,
  CONSTRAINT "VERTICAL_STRATA_ID_PK" PRIMARY KEY (vertical_strata_id)
);
ALTER TABLE atta.vertical_strata OWNER TO atta;

CREATE TABLE atta.vegetation_type
(
  vegetation_type_id numeric NOT NULL DEFAULT nextval('atta.vegetation_type_seq'::regclass),
  "name" character varying(100) NOT NULL,
  description character varying(500),
  created_by character varying(20) NOT NULL,
  creation_date date NOT NULL,
  last_modification_by character varying(20) NOT NULL,
  last_modification_date date NOT NULL,
  CONSTRAINT "VEGETATION_TYPE_ID_PK" PRIMARY KEY (vegetation_type_id)
);
ALTER TABLE atta.vegetation_type OWNER TO atta;

CREATE TABLE atta.sample_state
(
  sample_state_id numeric NOT NULL DEFAULT nextval('atta.sample_state_seq'::regclass),
  "name" character varying(100) NOT NULL,
  description character varying(500),
  created_by character varying(20) NOT NULL,
  creation_date date NOT NULL,
  last_modification_by character varying(20) NOT NULL,
  last_modification_date date NOT NULL,
  CONSTRAINT "SAMPLE_STATE_ID_PK" PRIMARY KEY (sample_state_id)
);
ALTER TABLE atta.vegetation_type OWNER TO atta;

CREATE TABLE atta.sample_quantity_measurement_unit
(
  sample_quantity_measurement_unit_id numeric NOT NULL DEFAULT nextval('atta.sample_quantity_measurement_unit_seq'::regclass),
  "name" character varying(100) NOT NULL,
  description character varying(500),
  created_by character varying(20) NOT NULL,
  creation_date date NOT NULL,
  last_modification_by character varying(20) NOT NULL,
  last_modification_date date NOT NULL,
  CONSTRAINT "SAMPLE_QUANTITY_MEASUREMENT_UNIT_ID_PK" PRIMARY KEY (sample_quantity_measurement_unit_id)
);
ALTER TABLE atta.vegetation_type OWNER TO atta;

CREATE TABLE atta.bioprospecting_project
(
  bioprospecting_project_id numeric NOT NULL DEFAULT nextval('atta.bioprospecting_project_seq'::regclass),
  "name" character varying(100) NOT NULL,
  description character varying(500),
  created_by character varying(20) NOT NULL,
  creation_date date NOT NULL,
  last_modification_by character varying(20) NOT NULL,
  last_modification_date date NOT NULL,
  CONSTRAINT "BIOPROSPECTING_PROJECT_ID_PK" PRIMARY KEY (bioprospecting_project_id)
);
ALTER TABLE atta.bioprospecting_project OWNER TO atta;



CREATE TABLE atta.sample
(
  sample_id numeric NOT NULL DEFAULT nextval('atta.sample_seq'::regclass),
  witness character varying(100) NOT NULL,
  description character varying(5000),
  sample_class_id numeric,
  taxon_id numeric,
  gathering_date date,
  reception_date date,
  permission_id numeric,
  micro_source_type_id numeric,
  micro_method_id numeric,
  micro_fome_id numeric,
  micro_quality_id numeric,
  sample_altitude numeric,
  ph numeric,
  tempeture numeric,
  salinity numeric,
  sample_quantity numeric,
  sample_quantity_measurement_unit_id numeric,
  sample_status_id numeric,
  site_id numeric,
  gathering_observation_id numeric,
  created_by character varying(20) NOT NULL,
  creation_date date NOT NULL,
  last_modification_by character varying(20) NOT NULL,
  last_modification_date date NOT NULL,
  CONSTRAINT "SAMPLE_ID_PK" PRIMARY KEY (sample_id),

  CONSTRAINT sample_class_id_fk FOREIGN KEY (sample_class_id)
      REFERENCES atta.sample_class (sample_class_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,

  CONSTRAINT taxon_id_fk FOREIGN KEY (taxon_id)
      REFERENCES atta.taxon (taxon_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,

  CONSTRAINT sample_quantity_measurement_unit_id_fk FOREIGN KEY (sample_quantity_measurement_unit_id)
      REFERENCES atta.sample_quantity_measurement_unit (sample_quantity_measurement_unit_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,

  CONSTRAINT permission_id_fk FOREIGN KEY (permission_id)
      REFERENCES atta.permission (permission_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,

  CONSTRAINT micro_source_type_id_fk FOREIGN KEY (micro_source_type_id)
      REFERENCES atta.micro_source_type (micro_source_type_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,

  CONSTRAINT micro_method_id_fk FOREIGN KEY (micro_method_id)
      REFERENCES atta.micro_method (micro_method_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,

  CONSTRAINT micro_fome_id_fk FOREIGN KEY (micro_fome_id)
      REFERENCES atta.micro_fome (micro_fome_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,

  CONSTRAINT micro_quality_id_fk FOREIGN KEY (micro_quality_id)
      REFERENCES atta.micro_quality (micro_quality_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,

  CONSTRAINT sample_status_id_fk FOREIGN KEY (sample_status_id)
      REFERENCES atta.sample_status (sample_status_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,

  CONSTRAINT site_id_fk FOREIGN KEY (site_id)
      REFERENCES atta.site (site_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,

  CONSTRAINT gathering_observation_id_fk FOREIGN KEY (gathering_observation_id)
      REFERENCES atta.gathering_observation (gathering_observation_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,

  CONSTRAINT witness_key UNIQUE (witness)
);
ALTER TABLE atta.sample OWNER TO atta;


CREATE TABLE atta.bioprospecting_project_sample
(
  bioprospecting_project_id numeric NOT NULL,
  sample_id numeric NOT NULL,
  created_by character varying(20) NOT NULL,
  creation_date date NOT NULL,
  last_modification_by character varying(20) NOT NULL,
  last_modification_date date NOT NULL,
  CONSTRAINT "BIOPROSPECTING_PROJECT_SAMPLE_ID_PK" PRIMARY KEY (bioprospecting_project_id,sample_id),
  CONSTRAINT sample_id_fk FOREIGN KEY (sample_id)
      REFERENCES atta.sample (sample_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT bioprospecting_project_id_fk FOREIGN KEY (bioprospecting_project_id)
      REFERENCES atta.bioprospecting_project (bioprospecting_project_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
ALTER TABLE atta.bioprospecting_project_sample OWNER TO atta;

CREATE TABLE atta.enviromental_data
(
  enviromental_data_id numeric NOT NULL DEFAULT nextval('atta.enviromental_data_seq'::regclass),
  sample_id numeric,
  elevation numeric,
  ph numeric,
  luminosity numeric,
  tempeture numeric,
  moisture numeric,
  habitat character varying(5000),
  vertical_strata_id numeric,
  vegetation_type_id numeric,
  salinity numeric,
  created_by character varying(20) NOT NULL,
  creation_date date NOT NULL,
  last_modification_by character varying(20) NOT NULL,
  last_modification_date date NOT NULL,
  CONSTRAINT "ENVIROMENTAL_DATA_ID_PK" PRIMARY KEY (enviromental_data_id),

  CONSTRAINT sample_id_fk FOREIGN KEY (sample_id)
      REFERENCES atta.sample (sample_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,

  CONSTRAINT vertical_strata_id_fk FOREIGN KEY (vertical_strata_id)
      REFERENCES atta.vertical_strata (vertical_strata_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,

  CONSTRAINT vegetation_type_id_fk FOREIGN KEY (vegetation_type_id)
      REFERENCES atta.vegetation_type (vegetation_type_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION

);
ALTER TABLE atta.enviromental_data OWNER TO atta;

--2011.04.15 Insert para los seleccion list de manejo de muestras


INSERT INTO atta.list_table(
            list_table_id, description, obj_version, created_by, creation_date,
            last_modification_by, last_modification_date, "name", key_field_name)
    VALUES (173, '', 0, 'Ara', '2010-4-15',
            'Ara', '2010-4-15', 'sample_class', 'sample_class_id');

INSERT INTO atta.list_table(
            list_table_id, description, obj_version, created_by, creation_date,
            last_modification_by, last_modification_date, "name", key_field_name)
    VALUES (174, '', 0, 'Ara', '2010-4-15',
            'Ara', '2010-4-15', 'permission', 'permission_id');

INSERT INTO atta.list_table(
            list_table_id, description, obj_version, created_by, creation_date,
            last_modification_by, last_modification_date, "name", key_field_name)
    VALUES (175, '', 0, 'Ara', '2010-4-15',
            'Ara', '2010-4-15', 'micro_source_type', 'micro_source_type_id');

INSERT INTO atta.list_table(
            list_table_id, description, obj_version, created_by, creation_date,
            last_modification_by, last_modification_date, "name", key_field_name)
    VALUES (176, '', 0, 'Ara', '2010-4-15',
            'Ara', '2010-4-15', 'micro_method', 'micro_method_id');

INSERT INTO atta.list_table(
            list_table_id, description, obj_version, created_by, creation_date,
            last_modification_by, last_modification_date, "name", key_field_name)
    VALUES (177, '', 0, 'Ara', '2010-4-15',
            'Ara', '2010-4-15', 'micro_fome', 'micro_fome_id');

INSERT INTO atta.list_table(
            list_table_id, description, obj_version, created_by, creation_date,
            last_modification_by, last_modification_date, "name", key_field_name)
    VALUES (178, '', 0, 'Ara', '2010-4-15',
            'Ara', '2010-4-15', 'micro_quality', 'micro_quality_id');

INSERT INTO atta.list_table(
            list_table_id, description, obj_version, created_by, creation_date,
            last_modification_by, last_modification_date, "name", key_field_name)
    VALUES (179, '', 0, 'Ara', '2010-4-15',
            'Ara', '2010-4-15', 'sample_quantity_measurement_unit', 'sample_quantity_measurement_unit_id');

INSERT INTO atta.list_table(
            list_table_id, description, obj_version, created_by, creation_date,
            last_modification_by, last_modification_date, "name", key_field_name)
    VALUES (180, '', 0, 'Ara', '2010-4-15',
            'Ara', '2010-4-15', 'vertical_strata', 'vertical_strata_id');

INSERT INTO atta.list_table(
            list_table_id, description, obj_version, created_by, creation_date,
            last_modification_by, last_modification_date, "name", key_field_name)
    VALUES (181, '', 0, 'Ara', '2010-4-15',
            'Ara', '2010-4-15', 'vegetation_type', 'vegetation_type_id');

--2011.04.29 Se agrego la tabla de huesped

CREATE SEQUENCE atta.host_information_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE atta.host_information_seq OWNER TO atta;

CREATE TABLE atta.host_information
(
  host_information_id numeric NOT NULL DEFAULT nextval('atta.host_information_seq'::regclass),
  sample_id numeric,
  health_comment character varying(5000),
  diameter numeric,
  taxon_id numeric,
  created_by character varying(20) NOT NULL,
  creation_date date NOT NULL,
  last_modification_by character varying(20) NOT NULL,
  last_modification_date date NOT NULL,
  CONSTRAINT "HOST_INFORMATION_ID_PK" PRIMARY KEY (host_information_id),

  CONSTRAINT sample_id_fk FOREIGN KEY (sample_id)
      REFERENCES atta.sample (sample_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,

  CONSTRAINT taxon_id_fk FOREIGN KEY (taxon_id)
      REFERENCES atta.taxon (taxon_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION

);
ALTER TABLE atta.host_information OWNER TO atta;

--2011.05.10 gsulca
-- Adding taxon description stage
INSERT INTO ATTA.TAXON_DESCRIPTION_STAGE (name, description, creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('No pubblicado', 'Registro de especie no publicado', '2011-05-11', 'admin', '2011-05-11', 'admin');

INSERT INTO ATTA.TAXON_DESCRIPTION_STAGE (name, description, creation_date, created_by, last_modification_date, last_modification_by)
    VALUES ('Pubblicado', 'Registro de especie publicado', '2011-05-11', 'admin', '2011-05-11', 'admin');

--2011.05.19 gsulca

CREATE SEQUENCE atta.taxon_description_category_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE atta.taxon_description_category_seq OWNER TO atta;

ALTER TABLE atta.taxon_description_category ALTER COLUMN taxon_description_category_id
SET DEFAULT nextval('atta.taxon_description_category_seq'::regclass);


-- Addind taxon description category
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (1, 'Description', '', 1, 0, 0, 0, NULL, '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (6, 'Identification Keys', '', 3, 1, 0, 0, NULL, '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (9, 'Natural History', '', 2, 0, 0, 0, NULL, '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (16, 'Interactions', '', 7, 9, 0, 0, NULL, '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (24, 'Detail', '', 1, 23, 1, 0, NULL, '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (25, 'Details Text', '', 2, 23, 0, 0, NULL, '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (26, 'Habitat and Distribution', '', 3, 0, 0, 0, NULL, '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (34, 'Demography and Conservation', '', 4, 0, 0, 0, NULL, '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (39, 'Atomized Distribution', '', 1, 38, 1, 0, NULL, '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (40, 'Distribution Area', '', 2, 38, 0, 0, NULL, '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (45, 'Uses and Management', '', 5, 0, 0, 0, NULL, '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (66, 'Base elements', ' ', 0, 0, 0, 0, NULL, '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (48, 'Documentation', NULL, 1, 47, 0, 0, NULL, '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (2, 'Brief Description', '', 1, 1, 0, 0, 'BriefDescription', '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (3, 'Full Description', '', 2, 1, 0, 0, 'ScientificDescription', '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (7, 'Keys', '', 1, 6, 1, 0, 'IdentificationKeys', '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (10, 'Habit', '', 1, 9, 0, 0, 'Habit', '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (11, 'Life Cycle', '', 2, 9, 0, 0, 'LifeCycle', '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (12, 'Reproduction', '', 3, 9, 0, 0, 'Reproduction', '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (13, 'Annual Cyle', '', 4, 9, 0, 0, 'AnnualCycle', '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (14, 'Feeding', '', 5, 9, 0, 0, 'Feeding', '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (15, 'Behavior', '', 6, 9, 0, 0, 'Behavior', '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (18, 'Interaction', '', 2, 16, 1, 0, 'Interactions', '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (19, 'Chromosomic Number', '', 8, 9, 0, 0, 'ChromosomicNumberN', '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (20, 'Molecular data', '', 9, 9, 0, 0, 'MolecularData', '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (21, 'Migratory data', '', 10, 9, 0, 0, 'MigratoryData', '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (22, 'Ecological Significance', '', 11, 9, 0, 0, 'EcologicalSignificance', '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (27, 'Habitat', '', 1, 26, 0, 0, 'Habitat', '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (28, 'Distribution', '', 2, 26, 0, 0, 'Distribution', '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (31, 'Endemicity', '', 3, 26, 0, 0, 'Endemicity', '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (35, 'Territory', '', 1, 34, 0, 0, 'Territory', '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (36, 'Population Biology', '', 2, 34, 0, 0, 'PopulationBiology', '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (37, 'Threat Status', '', 3, 34, 1, 0, 'ThreatStatus', '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (42, 'Legislation', '', 4, 34, 0, 0, 'Legislation', '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (46, 'Uses', '', 1, 45, 0, 0, 'Uses', '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (63, 'Folkclore', '', 3, 45, 0, 0, 'Folkclore', '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (64, 'Management', '', 4, 45, 0, 0, 'Management', '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (65, 'References', '', 6, 0, 1, 0, 'References', '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (17, 'Text Interactions', '', 1, 16, 0, 0, 'Interactions', '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (29, 'Atomized Distribution', '', 1, 28, 1, 0, 'Distribution', '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (30, 'Distribution Area', '', 2, 28, 0, 0, 'Distribution', '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (67, 'Abstract', NULL, 1, 66, 0, 0, 'Abstract', '2008-01-01', 'ara', '2008-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (43, 'Legistation Text', '', 1, 42, 0, 0, 'Legislation', '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (44, 'Legislation', '', 2, 42, 1, 0, 'Legislation', '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (33, 'Endemism Text', '', 2, 31, 0, 0, 'Endemicity', '2007-01-01', 'ara', '2007-01-01', 'ara');
INSERT INTO atta.taxon_description_category (taxon_description_category_id, name, description, sequence, ancestor_id, repeatable, mandatory, standard_concept, creation_date, created_by, last_modification_date, last_modification_by) VALUES (32, 'Atomized Endemism', '', 1, 31, 1, 0, 'Endemicity', '2007-01-01', 'ara', '2007-01-01', 'ara');

create sequence atta.taxon_description_category_seq;
alter table atta.taxon_description_category_seq OWNER TO atta;
alter table atta.taxon_description_category alter column taxon_description_category_id set default nextval('atta.taxon_description_category_seq'::regclass);
SELECT setval('atta.taxon_description_category_seq', cast(max(taxon_description_category_id) as bigint)+1) from atta.taxon_description_category ;


--2011.05.30 gsulca

CREATE TABLE atta.taxon_country
(
  taxon_id numeric NOT NULL,
  country_id numeric NOT NULL,
  description character varying(500),
  creation_date date NOT NULL,
  created_by character varying(100) NOT NULL,
  last_modification_date date NOT NULL,
  last_modification_by character varying(100) NOT NULL
);

--add foreing key
ALTER TABLE atta.taxon_country ADD CONSTRAINT pk_taxon_country_id PRIMARY KEY (taxon_id, country_id );

--2011.05.31 gsulca
INSERT INTO atta.indicator ( name, description, indicator_ancestor_id, applies_to_parts, creation_date, created_by, last_modification_date, last_modification_by) VALUES ('Atributos taxonómicos', 'Raíz del árbol', null, 0 ,'2011-05-19', 'admin', '2011-05-19', 'admin');


--2012.08.21

--Procedimiento para actualizar la mayoria de las proyecciones originales
-- Realizarlo antes de ejecutar los constraints

drop function isProjection( longitude numeric, latitude numeric, x numeric, y numeric, srid numeric, error numeric);
CREATE OR REPLACE FUNCTION isProjection( longitude numeric, latitude numeric, x numeric, y numeric, srid integer,error numeric)
RETURNS boolean AS
$BODY$
DECLARE
xCalculado numeric;
yCalculado numeric;
parameters text := 'SRID=4326;POINT('||longitude||' '||latitude||')';
reprojection CURSOR IS
   SELECT text(ST_AsEWKT(ST_Transform(ST_GeomFromEWKT(parameters), srid)));
--Result string
reprojResult text;
result boolean := false;

BEGIN
	OPEN reprojection;
	FETCH reprojection INTO reprojResult;	
		reprojResult = split_part(reprojResult, '(',2);
		reprojResult = split_part(reprojResult, ')',1);
		xCalculado = split_part(reprojResult, ' ',1);
		yCalculado = split_part(reprojResult, ' ',2);
		RAISE NOTICE 'Absoluto: abs(xCalculado - x) = %', abs(xCalculado - x);
		RAISE NOTICE 'Absoluto: abs(yCalculado - y) = %', abs(yCalculado - y);
		IF abs(xCalculado - x) <= error AND abs(yCalculado - y) <= error
		THEN
			result = true;
		END IF;
	CLOSE reprojection;  
	return result;
END
$BODY$
LANGUAGE plpgsql VOLATILE
COST 100;


drop function realProjection( longitude numeric, latitude numeric, x numeric, y numeric);
CREATE OR REPLACE FUNCTION realProjection( longitude numeric, latitude numeric, x numeric, y numeric)
RETURNS integer AS
$BODY$
DECLARE
listProjections integer[] := '{97134, 97135, 97136}';
errorEstimado numeric := 200;
--Result string

result integer := -1;

BEGIN
	for pos in 1..3 LOOP
		IF isProjection( longitude, latitude, x, y, listProjections[pos] , errorEstimado) THEN
			result = listProjections[pos];
		END IF; 
	END LOOP;
	return result;
END
$BODY$
LANGUAGE plpgsql VOLATILE
COST 100;



drop function updatelProjection();
CREATE OR REPLACE FUNCTION updateProjection()
RETURNS integer AS
$BODY$
DECLARE
coordinates CURSOR IS
	SELECT site_id, site_coordinate_id,longitude, latitude, original_x, original_y from atta.site_coordinate;
siteCordId numeric;
siteId numeric;
longi numeric;
lat numeric;
original_x numeric;
original_y numeric;

--Result string

result integer := -1;

BEGIN
	OPEN coordinates;
	FETCH coordinates INTO siteId, siteCordId,longi, lat, original_x, original_y;
	WHILE FOUND LOOP
		IF original_x <> 0.0 AND original_Y <> 0.0 THEN
			result = realProjection( longi, lat, original_x, original_y);
		ELSE
			UPDATE atta.site SET original_projection_id = 4326 WHERE site_id = siteid;
		END IF;
		IF result <> -1 THEN
			UPDATE atta.site SET original_projection_id = result WHERE site_id = siteid;
		ELSE
			RAISE NOTICE 'ERROR: Site_Coordinate_ID = %', siteCordId;
		END IF;
		FETCH coordinates INTO siteId, siteCordId,longi, lat, original_x, original_y;
	END LOOP;		
	CLOSE coordinates;  
	return result;
END
$BODY$
LANGUAGE plpgsql VOLATILE
COST 100;

--Actualiza el código de las proyecciones originales
SELECT updateProjection();

-- Actualiza las proyecciones base a WGS84
UPDATE atta.site SET base_projection_id = 4326;


ALTER TABLE atta.site DROP CONSTRAINT base_projection_fk;

ALTER TABLE atta.site ALTER COLUMN base_projection_id TYPE integer;

ALTER TABLE atta.site ADD CONSTRAINT base_projection_fk FOREIGN KEY (base_projection_id)
      REFERENCES spatial_ref_sys (srid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE atta.site DROP CONSTRAINT original_projection_fk;

ALTER TABLE atta.site ALTER COLUMN original_projection_id TYPE integer;

ALTER TABLE atta.site ADD CONSTRAINT original_projection_fk FOREIGN KEY (original_projection_id)
      REFERENCES spatial_ref_sys (srid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;


ALTER TABLE atta.site_coordinate ADD COLUMN verbatim_longitude varchar(150);
ALTER TABLE atta.site_coordinate ADD COLUMN verbatim_latitude varchar(150);




