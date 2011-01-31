/*
 *  Ara - Capture Species and Specimen Data
 *
 * Copyright © 2009  INBio (Instituto Nacional de Biodiversidad).
 * Heredia, Costa Rica.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.inbio.ara.dto.taxonomy;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.taxonomy.Concept;
import org.inbio.ara.persistence.taxonomy.Language;

/**
 *
 * @author esmata
 */
public class LanguageDTOFactory extends BaseEntityOrDTOFactory<Language,LanguageDTO>{

    @Override
    public Language getEntityWithPlainValues(LanguageDTO dto) {
        if(dto==null){
            return null;
        }
        Language result = new Language();
        result.setLanguageId(dto.getLanguageId());
        return result;
    }

    @Override
    public Language updateEntityWithPlainValues(LanguageDTO dto, Language e) {
        if(dto==null||e==null){
            return null;
        }
        e.setLanguageId(dto.getLanguageId());
        return e;
    }

    public LanguageDTO createDTO(Language entity) {
        if(entity==null){
            return null;
        }
        LanguageDTO result = new LanguageDTO();
        result.setLanguageId(entity.getLanguageId());
        Concept aux = entity.getConcept();
        result.setConcepId(aux.getConceptId());
        result.setConcepName(aux.getName());
        return result;
    }

}
