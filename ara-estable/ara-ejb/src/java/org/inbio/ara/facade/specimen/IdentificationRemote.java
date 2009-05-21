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

package org.inbio.ara.facade.specimen;

import java.util.List;
import javax.ejb.Remote;
import org.inbio.ara.persistence.specimen.Identification;
import org.inbio.ara.persistence.specimen.IdentificationPK;


/**
 * This is the business interface for Identification enterprise bean.
 */
@Remote
public interface IdentificationRemote {
    java.util.List getIdentification();

    java.util.List getIdentification(Long specimenId);

    java.lang.String getMessage();

    boolean reIdentify(Identification identification, Long[] specimenList, Long[] taxonList, Long[] identifierArray, List lifeStageSexList, Long typeSpecimenTypeId, Long institutionId);

    boolean delete(IdentificationPK pk);

    int getSpecimenCountByTaxon(Long taxonId, java.lang.Long collectionId);

    java.lang.Long[] getSpecimenByTaxon(Long taxonId, java.lang.Long collectionId);

    int getSpecimenCountByGathering(Long gatheringId, java.lang.Long collectionId);

    java.lang.Long[] getSpecimenByGathering(Long gatheringId, java.lang.Long collectionId);

    int getSpecimenCountByGatheringDetail(Long personId, String gatheringDetailNumber, Long collectionId);

    java.lang.Long[] getSpecimenByGatheringDetail(Long personId, String gatheringDetailNumber, Long collectionId);

    java.util.List getIdentificationByCollection(Long CollectionId);
    
}
