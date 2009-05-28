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

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.inbio.ara.eao.CountryLocalEAO;
import org.inbio.ara.eao.GeoreferencedSiteLocalEAO;
import org.inbio.ara.eao.ProvinceLocalEAO;
import org.inbio.ara.manager.SiteManagerRemote;
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
