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
package org.inbio.ara.facade.systemstatistics;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.inbio.ara.dto.SystemStatisticsDTO;
import org.inbio.ara.dto.SystemStatisticsEntinty;
import org.inbio.ara.eao.CollectionLocalEAO;
import org.inbio.ara.persistence.collection.Collection;

/**
 *
 * @author asanabria
 */
@Stateless
public class SystemStatisticsManager implements SystemStatisticsManagerRemote, SystemStatisticsManagerLocal {

	// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")

	@EJB
    private CollectionLocalEAO collectionEAO;

	@PersistenceContext
    private EntityManager em;

	
	@Override
	public List<SystemStatisticsDTO> getSpecimenCountByCollection(){

		SystemStatisticsDTO statisticsDTO = null;
		
		List<Collection> colectionList = collectionEAO.listAll();
		List<SystemStatisticsDTO> statisticList = new ArrayList<SystemStatisticsDTO>();
		
		for( Collection col : colectionList){

			statisticsDTO = new SystemStatisticsDTO();

			statisticsDTO.setStatistic(SystemStatisticsEntinty.SPECIMENS_BY_COLLECTION_COUNT);
			statisticsDTO.setName(col.getName());
			statisticsDTO.setValue(collectionEAO.getSpecimensCountByCollectionId(col.getId()));
			statisticList.add(statisticsDTO);
		}
		
		return statisticList;
	}

	@Override
	public List<SystemStatisticsDTO> getSpeciesCountByCollection() {

		SystemStatisticsDTO statisticsDTO = null;

		List<Collection> colectionList = collectionEAO.listAll();
		List<SystemStatisticsDTO> statisticList = new ArrayList<SystemStatisticsDTO>();

		for( Collection col : colectionList){

			statisticsDTO = new SystemStatisticsDTO();

			statisticsDTO.setStatistic(SystemStatisticsEntinty.SPECIMENS_BY_COLLECTION_COUNT);
			statisticsDTO.setName(col.getName());
			statisticsDTO.setValue(collectionEAO.getSpeciesCountByCollectionId(col.getId()));
			statisticList.add(statisticsDTO);
		}

		return statisticList;
	}
}
