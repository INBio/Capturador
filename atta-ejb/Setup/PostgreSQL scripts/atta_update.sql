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




