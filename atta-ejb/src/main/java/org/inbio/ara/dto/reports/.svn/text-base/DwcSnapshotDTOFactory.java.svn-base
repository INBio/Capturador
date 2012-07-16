/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Nacional de Biodiversidad)
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

package org.inbio.ara.dto.reports;

import java.util.ArrayList;
import java.util.List;
import org.inbio.ara.persistence.reports.DwcSnapshot;

/**
 *
 * @author esmata
 */
public class DwcSnapshotDTOFactory {
    public DwcSnapshotDTO createDTO(DwcSnapshot e) {
        if(e==null){
            return null;
        }
        DwcSnapshotDTO r = new DwcSnapshotDTO();
        r.setAttributes(e.getAttributes());
        r.setAuthoryearofscientificname(e.getAuthoryearofscientificname());
        r.setBasisofrecord(e.getBasisofrecord());
        r.setCatalognumber(e.getCatalognumber());
        r.setClass1(e.getClass1());
        r.setCollectingmethod(e.getCollectingmethod());
        r.setCollectioncode(e.getCollectioncode());
        r.setCollector(e.getCollector());
        r.setContinent(e.getContinent());
        r.setCountry(e.getCountry());
        r.setCounty(e.getCounty());
        r.setDatelastmodified(e.getDatelastmodified());
        r.setDayofyear(e.getDayofyear());
        r.setEarliestdatecollected(e.getEarliestdatecollected());
        r.setFamily(e.getFamily());
        r.setGenus(e.getGenus());
        r.setGlobaluniqueidentifier(e.getGlobaluniqueidentifier());
        r.setHighergeography(e.getHighergeography());
        r.setHighertaxon(e.getHighertaxon());
        r.setIdentificationqualifier(e.getIdentificationqualifier());
        r.setImageurl(e.getImageurl());
        r.setInformationwithheld(e.getInformationwithheld());
        r.setInfraspecificepithet(e.getInfraspecificepithet());
        r.setInfraspecificrank(e.getInfraspecificrank());
        r.setInstitutioncode(e.getInstitutioncode());
        r.setIsland(e.getIsland());
        r.setIslandgroup(e.getIslandgroup());
        r.setKingdom(e.getKingdom());
        r.setLatestdatecollected(e.getLatestdatecollected());
        r.setLifestage(e.getLifestage());
        r.setLocality(e.getLocality());
        r.setMaximumdepthinmeters(e.getMaximumdepthinmeters());
        r.setMaximumelevationinmeters(e.getMaximumelevationinmeters());
        r.setMinimumdepthinmeters(e.getMinimumdepthinmeters());
        r.setMinimumelevationinmeters(e.getMinimumelevationinmeters());
        r.setNomenclaturalcode(e.getNomenclaturalcode());
        r.setOrders(e.getOrders());
        r.setPhylum(e.getPhylum());
        r.setRelatedinformation(e.getRelatedinformation());
        r.setRemarks(e.getRemarks());
        r.setScientificname(e.getScientificname());
        r.setSex(e.getSex());
        r.setSpecificepithet(e.getSpecificepithet());
        r.setStateprovince(e.getStateprovince());
        r.setValiddistributionflag(e.getValiddistributionflag());
        r.setWaterbody(e.getWaterbody());
        return r;
    }


	public List<DwcSnapshotDTO> createDTOList(List<DwcSnapshot> entitiesList) {
		if(entitiesList==null)
			return null;
		List<DwcSnapshotDTO> dtoList = new ArrayList<DwcSnapshotDTO>();
		for (DwcSnapshot entity: entitiesList)
			dtoList.add((DwcSnapshotDTO) createDTO(entity));
		return dtoList;
	}
}
