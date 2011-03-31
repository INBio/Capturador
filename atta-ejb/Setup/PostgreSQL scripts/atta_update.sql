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



