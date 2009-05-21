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

package org.inbio.ara.facade.species;

import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.persistence.taxonomy.TaxonDescription;


/**
 * This is the business interface for TaxonDescription1 enterprise bean.
 */
@Local
public interface TaxonDescriptionLocal {
    boolean create(TaxonDescription taxonDescription);

    boolean update(TaxonDescription taxonDescription);

    List findAll();

    String getMessage();

    TaxonDescription getTaxonDescription(Long taxonId, Long taxonDescriptionSequence);

    List getTaxonDescriptions(Long taxonId);

    org.inbio.ara.persistence.taxonomy.TaxonDescription find(Long taxonId, Long taxonDescriptionSequence);

    org.inbio.ara.persistence.taxonomy.TaxonDescription getTaxonDescription();

    boolean update(TaxonDescription taxonDescription, Long[] audienceArray, Long[] authorArray, Long[] institutionArray);

    boolean remove(Long taxonId, Long sequence);
    
}
