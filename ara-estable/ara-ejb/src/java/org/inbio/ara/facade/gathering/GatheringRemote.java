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
import org.inbio.ara.persistence.gathering.GatheringObservation;


/**
 * This is the business interface for Gathering enterprise bean.
 */
@Remote
public interface GatheringRemote {

    boolean delete(Long id);

    java.lang.String getMessage();

    java.util.List getGathering(Long collectionId);

    org.inbio.ara.persistence.gathering.GatheringObservation getGathering();

    void setGathering(GatheringObservation gathering);

    boolean update(GatheringObservation gathering);

    boolean createCollectors(Long[] collectorArray);

    boolean create(GatheringObservation gathering, Long[] collectorArray, Long[] projectArray, Long[] collectionArray);

    boolean update(GatheringObservation gathering, Long[] collectorArray, Long[] projectArray, Long[] collectionArray);

    boolean updateAssociatedInformation(Long[] collectorArray, Long[] projectArray, Long[] collectionArray);

    org.inbio.ara.persistence.gathering.GatheringObservation find(Long id);
    
}
