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
package org.inbio.ara.manager.impl;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.inbio.ara.dto.GeographicLayerDTO;
import org.inbio.ara.dto.GeographicLayerValueDTO;
import org.inbio.ara.eao.CountryLocalEAO;
import org.inbio.ara.eao.GeographicLayerLocalEAO;
import org.inbio.ara.eao.GeoreferencedSiteLocalEAO;
import org.inbio.ara.eao.ProvinceLocalEAO;
import org.inbio.ara.facade.gis.SiteRemote;
import org.inbio.ara.manager.SiteManagerRemote;
import org.inbio.ara.persistence.gis.GeographicLayer;
import org.inbio.ara.persistence.gis.GeoreferencedSite;
import org.inbio.ara.persistence.gis.GeoreferencedSitePK;
import org.inbio.ara.persistence.util.Country;
import org.inbio.ara.persistence.util.Province;


/**
 *
 * @author jgutierrez
 */
@Stateless
public class SiteManagerImpl implements SiteManagerRemote {

    @EJB
    CountryLocalEAO countryEAOImpl;

    @EJB
    ProvinceLocalEAO provinceEAOImpl;

    @EJB
    GeoreferencedSiteLocalEAO georeferencedSiteEAOImpl;

    @EJB
    GeographicLayerLocalEAO geographicLayerEAOImpl;

    @Override
    public List<Country> getAllCountries() {

		return countryEAOImpl.listAll();
    }

    @Override
    public List<Province> getAllProvinces() {
        return provinceEAOImpl.listAll();
    }


    public List<Province> getAllProvincesForContry(Long countryId) {
        return provinceEAOImpl.listAllByContryId(countryId);
    }

    @Override
    public List<GeographicLayerDTO> getAllGeographicalLayers() {

        List<GeographicLayer> glList = geographicLayerEAOImpl.findAll();
        GeographicLayer ancestorGL;
        List<GeographicLayerDTO> glDTOList = new ArrayList<GeographicLayerDTO>();
        GeographicLayerDTO glDTO;

        for(GeographicLayer gl: glList){
            glDTO = new GeographicLayerDTO(gl.getId(), gl.getName(), gl.getDescription(), null, null);

            if(gl.getId().equals(SiteManagerRemote.PROVINCE_LAYER)){
                ancestorGL = (GeographicLayer) geographicLayerEAOImpl.findById(GeographicLayer.class, SiteManagerRemote.COUNTRY_LAYER);
                glDTO.setAncestorKey(ancestorGL.getId());
                glDTO.setAncestorName(ancestorGL.getName());
            }

            glDTOList.add(glDTO);
        }

        return glDTOList;
        
    }

    @Override
    public GeographicLayerDTO getAllGeographicalLayer(Long geographicLayerId) {
        GeographicLayer gl = (GeographicLayer) geographicLayerEAOImpl.findById(GeographicLayer.class, geographicLayerId);
        GeographicLayerDTO glDTO = new GeographicLayerDTO(gl.getId(), gl.getName(), gl.getDescription(), null, null);

            if(geographicLayerId.equals(SiteManagerRemote.PROVINCE_LAYER)){
                GeographicLayer ancestorGL = (GeographicLayer) geographicLayerEAOImpl.findById(GeographicLayer.class, SiteManagerRemote.COUNTRY_LAYER);
                glDTO.setAncestorKey(ancestorGL.getId());
                glDTO.setAncestorName(ancestorGL.getName());
            }


        return glDTO;
    }

    @Override
    public GeographicLayerValueDTO getAllGeographicalLayerValueForGeographicLayerAndId(Long geographicLayerId, Long geographicLayerValueId) {

        GeographicLayerValueDTO glvDTO = null;
        Country c;

        if(geographicLayerId.equals(SiteManagerRemote.COUNTRY_LAYER)){
            c =  (Country) provinceEAOImpl.findById(Country.class, geographicLayerValueId);
            glvDTO = new GeographicLayerValueDTO(SiteManagerRemote.COUNTRY_LAYER, c.getId(), c.getName(), null, null);
        
        } else if(geographicLayerId.equals(SiteManagerRemote.PROVINCE_LAYER)){
            Province p = (Province) provinceEAOImpl.findById(Province.class, geographicLayerValueId);
            c = (Country) countryEAOImpl.findById(Country.class, p.getCountry().getId());
            glvDTO = new GeographicLayerValueDTO(SiteManagerRemote.PROVINCE_LAYER,p.getId(), p.getName(), c.getId(),c.getName());
        }

        return glvDTO;
    }

    @Override
    public List<GeographicLayerValueDTO> getAllGeographicalLayerValuesForGeographicLayer(Long geographicLayerId) {

        List<GeographicLayerValueDTO> glvDTOList= new ArrayList<GeographicLayerValueDTO>();
        GeographicLayerValueDTO glvDTO;
        
        if(geographicLayerId.equals(SiteManagerRemote.COUNTRY_LAYER)){

            for(Country c : countryEAOImpl.listAll()){
                glvDTO = new GeographicLayerValueDTO(SiteManagerRemote.COUNTRY_LAYER,c.getId(), c.getName(), null, null);
                glvDTOList.add(glvDTO);
            }

        } else if(geographicLayerId.equals(SiteManagerRemote.PROVINCE_LAYER)){

            Country c;
            for(Province p : provinceEAOImpl.listAll()){
                c = (Country) countryEAOImpl.findById(Country.class, p.getCountry().getId());
                glvDTO = new GeographicLayerValueDTO(SiteManagerRemote.PROVINCE_LAYER,p.getId(), p.getName(), c.getId(),c.getName());
                glvDTOList.add(glvDTO);
            }

        } 

        return glvDTOList;
    }

    @Override
    public List<GeographicLayerValueDTO> getAllGeographicalLayerValuesForGeographicLayerAndAncestor(Long geographicLayerId, Long ancestorGeographicValueId) {
        List<GeographicLayerValueDTO> glvDTOList= new ArrayList<GeographicLayerValueDTO>();
        GeographicLayerValueDTO glvDTO;

        if(geographicLayerId.equals(SiteManagerRemote.PROVINCE_LAYER)){

            Country c;
            for(Province p : provinceEAOImpl.listAllByContryId(ancestorGeographicValueId)){
                c = (Country) countryEAOImpl.findById(Country.class, p.getCountry().getId());
                glvDTO = new GeographicLayerValueDTO(SiteManagerRemote.PROVINCE_LAYER,p.getId(), p.getName(), c.getId(),c.getName());
                glvDTOList.add(glvDTO);
            }

        }

        return glvDTOList;
    }


    @Override
    public Province getProvinceForSite(Long siteId) {
        
        List<GeoreferencedSite> geoRefSites = georeferencedSiteEAOImpl.findAllBySiteAndLayer(siteId, SiteManagerRemote.PROVINCE_LAYER);
        GeoreferencedSite gs;       

        if(geoRefSites!=null && geoRefSites.size() !=0){
            System.out.println("[getProvinceForSite] encontro sitios>"+geoRefSites.size());
            gs = geoRefSites.get(0);
            return (Province) provinceEAOImpl.findById(Province.class, gs.getGeoreferencedSitePK().getGeographicSiteId());
        }
        else
            return null;
    }

    @Override
    public Country getCountryForSite(Long siteId) {

        List<GeoreferencedSite> geoRefSites = georeferencedSiteEAOImpl.findAllBySiteAndLayer(siteId, SiteManagerRemote.COUNTRY_LAYER);
        GeoreferencedSite gs;

        if(geoRefSites!=null && geoRefSites.size() !=0){
            System.out.println("[getCountryForSite] encontro sitios>"+geoRefSites.size());
            gs = geoRefSites.get(0);
            return (Country) countryEAOImpl.findById(Country.class, gs.getGeoreferencedSitePK().getGeographicSiteId());
        }
        else
            return null;
    }


    @Override
    public void saveOrUpdateGeoreferenceForSite(Long siteId, Long layerId, Long value) {
        //System.out.println("[saveOrUpdateGeoreferenceForSite] params> siteId["+siteId+"] layerId["+layerId+"] value["+value+"]");
        List<GeoreferencedSite> gsList = georeferencedSiteEAOImpl.findAllBySiteAndLayer(siteId,layerId);
        GeoreferencedSite gs = null;
        GeoreferencedSitePK gsPK;
        //System.out.println("[saveOrUpdateGeoreferenceForSite] encontro sitios>"+gsList.size());

        if(gsList == null || gsList.size() == 0){
            //System.out.println("nuevo");
            gsPK = new GeoreferencedSitePK(siteId, layerId, value);
            gs = new GeoreferencedSite(gsPK);
            gs.setCreatedBy("ara-alambrado");
            gs.setLastModificationBy("ara-alambrado");

        } else if (gsList.size() == 1){
            //System.out.println("pura vida - tamaño ==1");
            gs = gsList.get(0);
            //System.out.println("antes> "+gs.getGeoreferencedSitePK().toString());
            georeferencedSiteEAOImpl.delete(GeoreferencedSite.class, gs.getGeoreferencedSitePK());
            gs.getGeoreferencedSitePK().setGeographicSiteId(value);
            //System.out.println("luego> "+gs.getGeoreferencedSitePK().toString());

        } 
         //falta un caso en que haya mas de un georeferecedSite, pero por ahora no se implementara

        georeferencedSiteEAOImpl.create(gs);
        //System.out.println("al terminar> "+gs.getGeoreferencedSitePK().toString());
    }


    @Override
    public void saveOrUpdateGeographicLayerValue(GeographicLayerValueDTO geographicLayerValueDTO) {

        Country c;

        if(geographicLayerValueDTO.getGeographicLayerKey().equals(SiteManagerRemote.COUNTRY_LAYER)){

            if(geographicLayerValueDTO.getGeographicLayerValueKey() == null){
                System.out.println("new country");
                c = new Country(geographicLayerValueDTO.getName());
                c.setCreatedBy("ara-alambrado");
                c.setLastModificationBy("ara-alambrado");
                countryEAOImpl.create(c);

            } else {
                System.out.println("edit country");
                c = (Country) countryEAOImpl.findById(Country.class, geographicLayerValueDTO.getGeographicLayerValueKey());
                System.out.println(" country con Id>"+c.getId());
                System.out.println(" country con Name>"+geographicLayerValueDTO.getName());
                c.setName(geographicLayerValueDTO.getName());
                c.setLastModificationBy("ara-alambrado");
                countryEAOImpl.update(c);
            }

        } else if(geographicLayerValueDTO.getGeographicLayerKey().equals(SiteManagerRemote.PROVINCE_LAYER)){
            Province p;
            c = (Country) countryEAOImpl.findById(Country.class, geographicLayerValueDTO.getAncestorGeographicLayerValueKey());

            if(geographicLayerValueDTO.getGeographicLayerValueKey() == null){
                System.out.println("new province");
                p = new Province();
                p.setCountry(c);
                p.setName(geographicLayerValueDTO.getName());
                p.setCreatedBy("ara-alambrado");
                p.setLastModificationBy("ara-alambrado");
                provinceEAOImpl.create(p);

            } else {
                System.out.println("edit province");
                p = (Province) provinceEAOImpl.findById(Province.class, geographicLayerValueDTO.getGeographicLayerValueKey());
                p.setCountry(c);
                p.setName(geographicLayerValueDTO.getName());
                p.setLastModificationBy("ara-alambrado");
                provinceEAOImpl.update(p);
            }

        }
    }


    @Override
    public void deleteGeoreferenceForSite(Long siteId, Long layerId) {
        //System.out.println("[saveOrUpdateGeoreferenceForSite] params> siteId["+siteId+"] layerId["+layerId+"] value["+value+"]");
        List<GeoreferencedSite> gsList = georeferencedSiteEAOImpl.findAllBySiteAndLayer(siteId,layerId);

        if(gsList!=null){
            for(GeoreferencedSite gs : gsList)
                georeferencedSiteEAOImpl.delete(GeoreferencedSite.class, gs.getGeoreferencedSitePK());
        }
    }

    @Override
    public void deleteForSite(Long siteId) {
        List<GeoreferencedSite> gsList = georeferencedSiteEAOImpl.findAllBySiteId(siteId);

        if(gsList!=null){
            for(GeoreferencedSite gs : gsList)
                georeferencedSiteEAOImpl.delete(GeoreferencedSite.class, gs.getGeoreferencedSitePK());
        }
    }



    @Override
    public Province getProvince(Long provinceId) {
        return (Province) provinceEAOImpl.findById(Province.class, provinceId);
    }

    @Override
    public Country getCountry(Long countryId) {
        return (Country) provinceEAOImpl.findById(Country.class, countryId);
    }




    
}
