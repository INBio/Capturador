/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio ( Instituto Nacional de Biodiversidad )
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

package org.inbio.ara.facade.statistics.impl;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import org.inbio.ara.facade.statistics.StatisticsFacadeRemote;
import javax.ejb.Stateless;
import org.inbio.ara.dto.statistics.SystemStatisticsDTO;
import org.inbio.ara.eao.collection.CollectionEAOLocal;
import org.inbio.ara.persistence.collection.Collection;
import org.inbio.ara.persistence.statistics.SystemStatisticsEntinty;

/**
 *
 * @author esmata
 */
@Stateless
public class StatisticsFacadeImpl implements StatisticsFacadeRemote {

	@EJB
    private CollectionEAOLocal collectionEAO;

    public List<SystemStatisticsDTO> getSpecimenCountByCollection() {

        SystemStatisticsDTO statisticsDTO = null;

        List<Collection> colectionList = collectionEAO.findAll(Collection.class);
        List<SystemStatisticsDTO> statisticList = new ArrayList<SystemStatisticsDTO>();

        for (Collection col : colectionList) {

            statisticsDTO = new SystemStatisticsDTO();

            statisticsDTO.setStatistic(SystemStatisticsEntinty.SPECIMENS_BY_COLLECTION_COUNT);
            statisticsDTO.setName(col.getName());
            statisticsDTO.setValue(collectionEAO.getSpecimensCountByCollectionId(col.getCollectionId()));
            statisticList.add(statisticsDTO);
        }

        return statisticList;
    }

    public List<SystemStatisticsDTO> getSpeciesCountByCollection() {

        SystemStatisticsDTO statisticsDTO = null;
        Long taxonId = null;
        Long speciesCount = null;

        List<Collection> colectionList = collectionEAO.findAll(Collection.class);
        List<SystemStatisticsDTO> statisticList = new ArrayList<SystemStatisticsDTO>();

        for (Collection col : colectionList) {

            statisticsDTO = new SystemStatisticsDTO();

            statisticsDTO.setStatistic(SystemStatisticsEntinty.SPECIES_BY_COLLECTION_COUNT);
            statisticsDTO.setName(col.getName());
            
            // determinal cual es el taxón que esta asociado a la jerarquía
            taxonId = collectionEAO.getTaxonFatherOfCollection(col.getCollectionId());

            // retorna el conteo de especies que esta bajo un taxon.
            speciesCount = collectionEAO.getSpeciesCountUnderTaxonId(taxonId);

            statisticsDTO.setValue(speciesCount);
            statisticList.add(statisticsDTO);
        }

        return statisticList;
    }
 
}
