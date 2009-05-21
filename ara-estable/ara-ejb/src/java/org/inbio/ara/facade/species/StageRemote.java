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
import javax.ejb.Remote;
//import org.inbio.ara.persistence.species.SpeciesRecordStage;
import org.inbio.ara.persistence.species.TaxonDescriptionStage;
import com.sun.data.provider.SortCriteria;


/**
 * This is the business interface for Stage enterprise bean.
 */
@Remote
public interface StageRemote {
    //boolean create(SpeciesRecordStage speciesRecordStage);
    boolean create(TaxonDescriptionStage speciesRecordStage);

    //SpeciesRecordStage getStage();
    TaxonDescriptionStage getStage();

    //boolean update(SpeciesRecordStage stage);
    boolean update(TaxonDescriptionStage stage);

    List findAll();

    boolean remove(Long id);

    String getMessage();

    java.util.List findAll(int firstResult, int maxResults, SortCriteria[] sortCriteria);
    
}
