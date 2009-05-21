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
import org.inbio.ara.persistence.gathering.GatheringObservationDetail;
//import org.inbio.ara.persistence.gathering.GatheringDetailPK;


/**
 * This is the business interface for GatheringDetailSession enterprise bean.
 */
@Remote
public interface GatheringDetailRemote {
    boolean create(GatheringObservationDetail gatherinDetail);

    boolean update(GatheringObservationDetail gatheringDetail);

    boolean delete(Long gatheringObservationDetailID);

    java.util.List getGatheringDetail(Long gatheringId);

    org.inbio.ara.persistence.gathering.GatheringObservationDetail getGatheringDetail();

    void setGatheringDetail(GatheringObservationDetail gatheringDetail);

    java.lang.String getMessage();

    java.util.List getGatheringObservationDetail(Long gatheringId, Long collectionId);
    
}
