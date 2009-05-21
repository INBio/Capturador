/* Ara - capture species and specimen data
 * 
 * Copyright (C) 2009  INBio ( Instituto Naciona de Biodiversidad )
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

package org.inbio.ara.facade.gathering;

import javax.ejb.Remote;
import org.inbio.ara.persistence.gathering.MorphologicalDescription;


/**
 * This is the business interface for MorphologicalDescription enterprise bean.
 */
@Remote
public interface MorphologicalDescriptionRemote {
    boolean persist();

    boolean create(MorphologicalDescription morphologicalDescription);

    boolean update(MorphologicalDescription morphologicalDescription);

    boolean delete(Long id);

    org.inbio.ara.persistence.gathering.MorphologicalDescription getMorphologicalDescription(Long gatheringObservationDetailId);

    org.inbio.ara.persistence.gathering.MorphologicalDescription getMorphologicalDescription();

    java.lang.String getMessage();
    
}
