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

package org.inbio.ara.dto.gis;

import javax.ejb.EJB;
import org.inbio.ara.dto.BaseDTOFactory;
import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.eao.gis.SiteEAOLocal;
import org.inbio.ara.persistence.gis.Site;
import org.inbio.ara.persistence.gis.SiteCoordinate;

/**
 *
 * @author esmata
 */
public class SiteCoordinateDTOFactory 
        extends BaseEntityOrDTOFactory<SiteCoordinate, SiteCoordinateDTO>{
    
    @EJB
    private SiteEAOLocal siteEAOImpl;

    public SiteCoordinateDTO createDTO(SiteCoordinate entity) {
        if(entity==null){
            return null;
        }
        else{
            SiteCoordinateDTO result = new SiteCoordinateDTO();
            result.setLatitude(entity.getLatitude());
            result.setLongitude(entity.getLongitude());
            result.setOriginalX(entity.getOriginalX());
            result.setOriginalY(entity.getOriginalY());
            result.setVerbatimLongitude(entity.getVerbatimLongitude());
            result.setVerbatimLatitude(entity.getVerbatimLatitude());
            result.setSequence(entity.getSequence());
            result.setSiteCoordinateId(entity.getSiteCoordinateId());
            result.setSiteId(entity.getSiteId().getSiteId());
            result.setUserName(entity.getCreatedBy());
            return result;
        }
    }

    @Override
    public SiteCoordinate getEntityWithPlainValues(SiteCoordinateDTO dto) {
        if(dto == null) return null;
        SiteCoordinate newSiteCord = new SiteCoordinate();
        newSiteCord.setLatitude(dto.getLatitude());
        newSiteCord.setLongitude(dto.getLongitude());
        newSiteCord.setOriginalX(dto.getOriginalX());
        newSiteCord.setOriginalY(dto.getOriginalY());
        newSiteCord.setSequence(dto.getSequence());
        newSiteCord.setSiteCoordinateId(dto.getSiteCoordinateId());
        //No estoy segura si es correcta la inyección del EJB
        //newSiteCord.setSiteId(siteEAOImpl.findById(Site.class,dto.getSiteId()));
        newSiteCord.setVerbatimLatitude(dto.getVerbatimLatitude());
        newSiteCord.setVerbatimLongitude(dto.getVerbatimLongitude());
        
        return newSiteCord;
    }

    @Override
    public SiteCoordinate updateEntityWithPlainValues(SiteCoordinateDTO dto, SiteCoordinate e) {
        if(dto == null) return null;
        
        e.setLatitude(dto.getLatitude());
        e.setLongitude(dto.getLongitude());
        e.setOriginalX(dto.getOriginalX());
        e.setOriginalY(dto.getOriginalY());
        e.setSequence(dto.getSequence());
        e.setSiteCoordinateId(dto.getSiteCoordinateId());
        //No estoy segura si es correcta la inyección del EJB
        e.setSiteId(siteEAOImpl.findById(Site.class,dto.getSiteId()));
        e.setVerbatimLatitude(dto.getVerbatimLatitude());
        e.setVerbatimLongitude(dto.getVerbatimLongitude());
        
        return e;
        
    }

}
