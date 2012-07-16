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

package org.inbio.ara.dto.agent;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.collection.Collection;

/**
 *
 * @author jgutierrez
 */
public class CollectionDTOFactory extends BaseEntityOrDTOFactory<Collection,CollectionDTO> {

    public CollectionDTO createDTO(Collection c) {
        if(c == null)
            return null;

         CollectionDTO cDTO = new CollectionDTO();
         //seleted is used in the Graphical Interface, should be set in false
         cDTO.setSelected(false);
         cDTO.setCollectionId(c.getCollectionId());
         cDTO.setCollectionName(c.getName());
         cDTO.setCollectionDescription(c.getDescription());
         return cDTO;

    }


    /**
     *
     * @param dto
     * @return
     */
    public Collection getEntityWithPlainValues(CollectionDTO dto) {
        Collection c = new Collection();
        c.setCollectionId(dto.getCollectionId());
        c.setName(dto.getCollectionName());
        c.setDescription(dto.getCollectionDescription());
        return c;
    }

    /**
     * 
     * @param dto
     * @param e
     * @return
     */
    public Collection updateEntityWithPlainValues(CollectionDTO dto, Collection c) {
        c.setName(dto.getCollectionName());
        c.setDescription(dto.getCollectionDescription());
        return c;
    }

}
