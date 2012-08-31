 /*
 *  Ara - Capture Species and Specimen Data
 *
 * Copyright © 2009  INBio (Instituto Nacional de Biodiversidad).
 * Heredia, Costa Rica.
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

package org.inbio.ara.facade.gis.impl;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.EJB;
import org.inbio.ara.facade.gis.*;
import javax.ejb.Stateless;
import org.inbio.ara.dto.gis.*;
import org.inbio.ara.dto.taxonomy.CountryDTO;
import org.inbio.ara.dto.taxonomy.CountryDTOFactory;
import org.inbio.ara.eao.gis.CountryEAOLocal;
import org.inbio.ara.eao.gis.FeatureTypeEAOLocal;
import org.inbio.ara.eao.gis.GeographicLayerEAOLocal;
import org.inbio.ara.eao.gis.GeoreferencedSiteEAOLocal;
import org.inbio.ara.eao.gis.ProjectionEAOLocal;
import org.inbio.ara.eao.gis.ProvinceEAOLocal;
import org.inbio.ara.eao.gis.SiteCalculationMethodEAOLocal;
import org.inbio.ara.eao.gis.SiteCoordinateEAOLocal;
import org.inbio.ara.eao.gis.SiteEAOLocal;
import org.inbio.ara.persistence.gis.Country;
import org.inbio.ara.persistence.gis.FeatureType;
import org.inbio.ara.persistence.gis.GeographicLayer;
import org.inbio.ara.persistence.gis.GeoreferencedSite;
import org.inbio.ara.persistence.gis.GeoreferencedSitePK;
import org.inbio.ara.persistence.gis.Projection;
import org.inbio.ara.persistence.gis.Province;
import org.inbio.ara.persistence.gis.Site;
import org.inbio.ara.persistence.gis.SiteCalculationMethod;
import org.inbio.ara.persistence.gis.SiteCoordinate;

/**
 *
 * @author esmata
 */
@Stateless
public class GisFacadeImpl implements GisFacadeRemote {

    //Injections
    @EJB
    private CountryEAOLocal countryEAOImpl;
    @EJB
    private ProvinceEAOLocal provinceEAOImpl;
    @EJB
    private SiteEAOLocal siteEAOImpl;
    @EJB
    private GeographicLayerEAOLocal geographicLayerEAOImpl;
    @EJB
    private FeatureTypeEAOLocal featureTypeEAOImpl;
    @EJB
    private SiteCalculationMethodEAOLocal siteCalculationMethodEAOImpl;
    @EJB
    private ProjectionEAOLocal projectionEAOImpl;
    @EJB
    private GeoreferencedSiteEAOLocal georeferencedSiteEAOImpl;
    @EJB
    private SiteCoordinateEAOLocal siteCoordinateEAOImpl;
    
    

    //DTO factories
    private SiteDTOFactory siteDTOFactory = new SiteDTOFactory();
    private SiteCoordinateDTOFactory siteCoordinateDTOFactory = new SiteCoordinateDTOFactory();
    private FeatureTypeDTOFactory featureTypeDTOFactory =
            new FeatureTypeDTOFactory();
    private SiteCalculationMethodDTOFactory siteCalculationMethodDTOFactory =
            new SiteCalculationMethodDTOFactory();
    private ProjectionDTOFactory projectionDTOFactory = new
            ProjectionDTOFactory();
    private CountryDTOFactory countryDTOFactory = new CountryDTOFactory();
    private ProvinceDTOFactory provinceDTOFactory = new ProvinceDTOFactory();

    /**
     * Listado de todos los feature type
     */
    public List<FeatureTypeDTO> getAllFeatureType(){
        return featureTypeDTOFactory.createDTOList
                (featureTypeEAOImpl.findAll(FeatureType.class));
    }

    /**
     * Listado de todos los site calculation methods
     */
    public List<SiteCalculationMethodDTO> getAllSiteCalculationMethods(){
        String[] orderByFields = {"name"};
        return siteCalculationMethodDTOFactory.createDTOList
                (siteCalculationMethodEAOImpl.findAllAndOrderBy(
                SiteCalculationMethod.class, orderByFields));
    }

    /**
     * Listado de todos las projections
     */
    public List<ProjectionDTO> getAllProjection(){
        String[] orderByFields = {"name"};
        return projectionDTOFactory.createDTOList
                (projectionEAOImpl.findAllAndOrderBy(Projection.class, orderByFields));
    }

    public List<ProvinceDTO> getAllProvincesForContry(Long cId){
        return provinceDTOFactory.createDTOList
                (provinceEAOImpl.listAllByContryId(cId));
    }

    /**
     * Retorna un listado de la sitios
     */
    public List<SiteDTO> getAllSitePaginated(int first, int totalResults) {
        String[] orderByFields = {"description"};
        List<Site> sList = siteEAOImpl.findAllPaginatedFilterAndOrderBy(Site.class, first, totalResults,orderByFields,null);
        if (sList == null) {
            return null;
        } else {
            return updateCountryAndProvinceName(siteDTOFactory.createDTOList(sList));
        }
    }

    public Long countSites() {
        return siteEAOImpl.count(Site.class);
    }

    /**
     * Metodo que retorna la lista completa de paises
     */
    @Deprecated
    public List<GeographicLayerDTO> getAllCountries(){
        return countryEAOImpl.getAllCountries();
    }

    public List<CountryDTO> findAllCountries(){
        String[] orderByFields = {"value"};
        return countryDTOFactory.createDTOList
                (countryEAOImpl.findAllAndOrderBy(Country.class, orderByFields));
    }

    public CountryDTO getCountryForSite(Long siteId) {

        List<GeoreferencedSite> geoRefSites = georeferencedSiteEAOImpl.findAllBySiteAndLayer
                (siteId, COUNTRY_LAYER);
        GeoreferencedSite gs;
        if(geoRefSites!=null && geoRefSites.size() !=0){
            //System.out.println("[getCountryForSite] encontro sitios>"+geoRefSites.size());
            gs = geoRefSites.get(0);
            Country aux =  (Country) countryEAOImpl.findById
                    (Country.class, gs.getGeoreferencedSitePK().getGeographicSiteId());
            return countryDTOFactory.createDTO(aux);
        }
        else
            return null;
    }

    public ProvinceDTO getProvinceForSite(Long siteId) {

        List<GeoreferencedSite> geoRefSites = georeferencedSiteEAOImpl.
                findAllBySiteAndLayer(siteId, PROVINCE_LAYER);
        GeoreferencedSite gs;

        if(geoRefSites!=null && geoRefSites.size() !=0){
            //System.out.println("[getProvinceForSite] encontro sitios>"+geoRefSites.size());
            gs = geoRefSites.get(0);
            Province aux =  (Province) provinceEAOImpl.findById
                    (Province.class, gs.getGeoreferencedSitePK().getGeographicSiteId());
            return provinceDTOFactory.createDTO(aux);
        }
        else
            return null;
    }

    /**
     * Metodo que retorna las provincias pertenecientes a un pais
     */
    public List<GeographicLayerDTO> getProvincesByCountry(Long country){
        return provinceEAOImpl.getProvincesByCountry(country);
    }

    /**
     * Metodo que retorna todos los sitios de la base de datos
     * @return
     */
    public List<SiteDTO> getAllSites(){
        List<Site> sitios = siteEAOImpl.findAllOrdered();
        List<SiteDTO> result = new ArrayList<SiteDTO>();
        for(Site s: sitios){
            result.add(siteDTOFactory.createDTO(s));
        }
        return result;
    }

    public SiteDTO updateCountryAndProvinceName(SiteDTO sDTO) {
            Country c;
            Province p;

            if (sDTO.getProvinceId() != null) {
                    p = provinceEAOImpl.findById(Province.class, sDTO.getProvinceId());
                    sDTO.setProvinceName(p.getValue());
                    c = countryEAOImpl.findById(Country.class, p.getCountryId());
                    sDTO.setCountryName(c.getValue());
                    sDTO.setCountryId(c.getCountryId());
            } else if (sDTO.getCountryId() != null) {
                    c = countryEAOImpl.findById(Country.class, sDTO.getCountryId());
                    sDTO.setCountryName(c.getValue());
            }

            return sDTO;
    }


    public List<SiteDTO> updateCountryAndProvinceName(List<SiteDTO> sDTOList) {

            List<SiteDTO> resultSiteDTOList = new ArrayList<SiteDTO>();

            for (SiteDTO sDTO : sDTOList) {
                    resultSiteDTOList.add(updateCountryAndProvinceName(sDTO));
            }

            return resultSiteDTOList;
    }

    public GeographicLayerDTO getAllGeographicalLayer(Long geographicLayerId) {
        GeographicLayer gl = (GeographicLayer) geographicLayerEAOImpl.
                findById(GeographicLayer.class, geographicLayerId);
        GeographicLayerDTO glDTO = new GeographicLayerDTO
                (gl.getGeographicLayerId(), gl.getName(), gl.getDescription(), null, null);

            if(geographicLayerId.equals(PROVINCE_LAYER)){
                GeographicLayer ancestorGL =
                        (GeographicLayer) geographicLayerEAOImpl.findById(GeographicLayer.class, COUNTRY_LAYER);
                glDTO.setAncestorKey(ancestorGL.getGeographicLayerId());
                glDTO.setAncestorName(ancestorGL.getName());
            }

        return glDTO;
    }

    public List<GeographicLayerValueDTO> getAllGeographicalLayerValuesForGeographicLayerAndAncestor
            (Long geographicLayerId, Long ancestorGeographicValueId) {

        List<GeographicLayerValueDTO> glvDTOList= new ArrayList<GeographicLayerValueDTO>();
        GeographicLayerValueDTO glvDTO;

        if(geographicLayerId.equals(PROVINCE_LAYER)){

            Country c;
            for(Province p : provinceEAOImpl.listAllByContryId(ancestorGeographicValueId)){
                c = (Country) countryEAOImpl.findById(Country.class, p.getCountryId());
                glvDTO = new GeographicLayerValueDTO
                        (PROVINCE_LAYER,p.getProvinceId(), p.getValue(), c.getCountryId(),c.getValue());
                glvDTOList.add(glvDTO);
            }

        }

        return glvDTOList;
    }

    public List<GeographicLayerValueDTO> getAllGeographicalLayerValuesForGeographicLayer
            (Long geographicLayerId) {

        List<GeographicLayerValueDTO> glvDTOList= new ArrayList<GeographicLayerValueDTO>();
        GeographicLayerValueDTO glvDTO;

        if(geographicLayerId.equals(COUNTRY_LAYER)){

            for(Country c : countryEAOImpl.listAll()){
                glvDTO = new GeographicLayerValueDTO
                        (COUNTRY_LAYER,c.getCountryId(), c.getValue(), null, null);
                glvDTOList.add(glvDTO);
            }

        } else if(geographicLayerId.equals(PROVINCE_LAYER)){

            Country c;
            for(Province p : provinceEAOImpl.listAll()){
                c = (Country) countryEAOImpl.findById(Country.class, p.getCountryId());
                glvDTO = new GeographicLayerValueDTO
                        (PROVINCE_LAYER,p.getProvinceId(), p.getValue(), c.getCountryId(),c.getValue());
                glvDTOList.add(glvDTO);
            }

        }

        return glvDTOList;
    }

    public List<GeographicLayerDTO> getAllGeographicalLayers() {

        List<GeographicLayer> glList = geographicLayerEAOImpl.findAll(GeographicLayer.class);
        GeographicLayer ancestorGL;
        List<GeographicLayerDTO> glDTOList = new ArrayList<GeographicLayerDTO>();
        GeographicLayerDTO glDTO;

        for(GeographicLayer gl: glList){
            glDTO = new GeographicLayerDTO
                    (gl.getGeographicLayerId(), gl.getName(), gl.getDescription(), null, null);

            if(gl.getGeographicLayerId().equals(PROVINCE_LAYER)){
                ancestorGL = (GeographicLayer) geographicLayerEAOImpl.
                        findById(GeographicLayer.class, COUNTRY_LAYER);
                glDTO.setAncestorKey(ancestorGL.getGeographicLayerId());
                glDTO.setAncestorName(ancestorGL.getName());
            }

            glDTOList.add(glDTO);
        }

        return glDTOList;

    }

    public GeographicLayerValueDTO getAllGeographicalLayerValueForGeographicLayerAndId
            (Long geographicLayerId, Long geographicLayerValueId) {

        GeographicLayerValueDTO glvDTO = null;
        Country c;

        if(geographicLayerId.equals(COUNTRY_LAYER)){
            c =  (Country) countryEAOImpl.findById(Country.class, geographicLayerValueId);
            glvDTO = new GeographicLayerValueDTO
                    (COUNTRY_LAYER, c.getCountryId(), c.getValue(), null, null);

        } else if(geographicLayerId.equals(PROVINCE_LAYER)){
            Province p = (Province) provinceEAOImpl.findById
                    (Province.class, geographicLayerValueId);
            c = (Country) countryEAOImpl.findById(Country.class, p.getCountryId());
            glvDTO = new GeographicLayerValueDTO
                    (PROVINCE_LAYER,p.getProvinceId(), p.getValue(), c.getCountryId(),c.getValue());
        }

        return glvDTO;
    }

    /**
     * Metodo encargado de guardar en la base de datos un nuevo sitio con sus
     * respectivas coordenas y capas geograficas relacionadas
     */
    public SiteDTO saveNewSite(SiteDTO sDTO, List<SiteCoordinateDTO> coorList,
            List<GeoreferencedSitePKDTO> georefSiteList) {
        //System.out.println("Entro a Save New Site");
        //Nueva entidad a persistir
        //Site site = new Site();
        //Asignar las propiedades de nuevo sition
        /*site.setBaseProjectionId(sDTO.getBaseProjectionId());
        site.setDescription(sDTO.getDescription());
        site.setFeatureTypeId(sDTO.getFeatureTypeId());
        site.setGeodeticDatum(sDTO.getGeodeticDatum());
        site.setName(sDTO.getName());
        site.setOriginalProjectionId(sDTO.getOriginalProjectionId());
        site.setPrecision(sDTO.getPrecision());
        site.setSiteCalculationMethodId(sDTO.getSiteCalculationMethodId());
        site.setSiteCoordinates(new ArrayList<SiteCoordinate>());
        site.setGeoreferencedSites(new ArrayList<GeoreferencedSite>());*/
        
        //System.out.println("Antes del Factory = " + sDTO.getUserName());
        Site site = siteDTOFactory.createPlainEntity(sDTO);
        //System.out.println("Despues del Factory = " +site.getCreatedBy());
        //Persistir la nueva entidad
        siteEAOImpl.create(site);
        //Actualizar el CurrentDTO con el id asignado
        SiteDTO result = siteDTOFactory.createDTO(site);

        //Persistir las coordenadas asociadas
        if (coorList != null) {
            if (coorList.size() > 0) {
                for (int i = 0; i < coorList.size(); i++) {
                    SiteCoordinateDTO dto = coorList.get(i);
                    //dto.setSiteId(result.getSiteId());
                    SiteCoordinate newCoor = new SiteCoordinate();
                    /*
                    newCoor.setSiteId(site);
                    newCoor.setSequence(new Long(i + 1));
                    newCoor.setLatitude(dto.getLatitude());
                    newCoor.setLongitude(dto.getLongitude());
                    newCoor.setOriginalX(dto.getOriginalX());
                    newCoor.setOriginalY(dto.getOriginalY());
                    newCoor.setVerbatimLongitude(dto.getVerbatimLongitude());
                    newCoor.setVerbatimLatitude(dto.getVerbatimLatitude());                    
                    */
                    newCoor = siteCoordinateDTOFactory.createPlainEntity(dto);
                    newCoor.setSiteId(site);
                    newCoor.setSequence(new Long(i + 1));
                    siteCoordinateEAOImpl.create(newCoor);
                }
            }
        }

        //Persistir la division politica del sitio
        if (georefSiteList != null) {
            for (GeoreferencedSitePKDTO gsPK : georefSiteList) {
                saveOrUpdateGeoreferenceForSite(site.getSiteId(),
                        gsPK.getGeographicLayerId(),
                        gsPK.getGeographicSiteId(), gsPK.getUserName());
            }
        }

        //Retornar el nuevo dto
        return result;
    }

    /**
     * Metodo para eliminar Localidades por su id
     * Además elimina las dependencias en las tablas:
     *          - site_coordinate
     *          -
     * @param Id
     */
    public void deleteSite(Long Id){
        Site aux = this.siteEAOImpl.findById(Site.class, Id);
        if(aux!=null){
            //Delete asociated coordinates
            this.siteCoordinateEAOImpl.deleteBySiteId(Id);
            //Delete asociated countries and provinces
            this.georeferencedSiteEAOImpl.deleteBySiteId(Id);
            //Finally delete the site
            this.siteEAOImpl.delete(aux);
        }
    }

    /**
     * Metodo encargado de guardar en la base de datos el sitio editado
     * respectivas coordenas y capas geograficas relacionadas
     */
    public SiteDTO updateSite(SiteDTO sDTO, List<SiteCoordinateDTO> coorList,
            List<GeoreferencedSitePKDTO> georefSiteList) {

        //Nueva entidad a persistir
        Site site = siteEAOImpl.findById(Site.class, sDTO.getSiteId());
        
        //Asignar las propiedades de nuevo sition
        /*
        site.setBaseProjectionId(sDTO.getBaseProjectionId());
        site.setDescription(sDTO.getDescription());
        site.setFeatureTypeId(sDTO.getFeatureTypeId());
        site.setGeodeticDatum(sDTO.getGeodeticDatum());
        site.setName(sDTO.getName());
        site.setOriginalProjectionId(sDTO.getOriginalProjectionId());
        site.setPrecision(sDTO.getPrecision());
        site.setSiteCalculationMethodId(sDTO.getSiteCalculationMethodId());
        site.setSiteCoordinates(new ArrayList<SiteCoordinate>());
        site.setGeoreferencedSites(new ArrayList<GeoreferencedSite>());         
        */
        site = siteDTOFactory.updatePlainEntity(sDTO, site);
        //Persistir la entidad
        siteEAOImpl.update(site);
        //Actualizar el CurrentDTO con el id asignado
        SiteDTO result = siteDTOFactory.createDTO(site);

        //Eliminar las coordenadas acuales
        siteCoordinateEAOImpl.deleteBySiteId(site.getSiteId());

        //Persistir las coordenadas asociadas
        if (coorList != null) {
            if (coorList.size() > 0) {
                for (int i = 0; i < coorList.size(); i++) {
                    SiteCoordinateDTO dto = coorList.get(i);
                    SiteCoordinate newCoor = new SiteCoordinate();
                    newCoor = siteCoordinateDTOFactory.createPlainEntity(dto);
                    newCoor.setSiteId(site);
                    newCoor.setSequence(new Long(i + 1));
                    //para eliminar el id que fue asignado anteriormente
                    newCoor.setSiteCoordinateId(null);
                    /*
                    newCoor.setLatitude(dto.getLatitude());
                    newCoor.setLongitude(dto.getLongitude());
                    newCoor.setOriginalX(dto.getOriginalX());
                    newCoor.setOriginalY(dto.getOriginalY());
                    newCoor.setVerbatimLongitude(dto.getVerbatimLongitude());
                    newCoor.setVerbatimLatitude(dto.getVerbatimLatitude());
                    */
                    
                    
                    siteCoordinateEAOImpl.create(newCoor);
                }
            }
        }

        //Persistir la division politica del sitio
        if (georefSiteList != null) {
            for (GeoreferencedSitePKDTO gsPK : georefSiteList) {                
                saveOrUpdateGeoreferenceForSite(site.getSiteId(),
                        gsPK.getGeographicLayerId(),
                        gsPK.getGeographicSiteId(), gsPK.getUserName());
            }
        }

        //Retornar el nuevo dto
        return result;
    }

    public void saveOrUpdateGeoreferenceForSite(Long siteId,
            Long layerId, Long value, String user) {
        //Busca las capas: PROVINCIA o COUNTRY para el site Id
        
        List<GeoreferencedSite> gsList = georeferencedSiteEAOImpl.
                findAllBySiteAndLayer(siteId,layerId);
        GeoreferencedSite gs = null;
        GeoreferencedSitePK gsPK;

        if(gsList == null || gsList.isEmpty()){        
            //Nuevo GeoreferencedSite
            gsPK = new GeoreferencedSitePK(siteId, layerId, value);
            gs = new GeoreferencedSite(gsPK);
            //aqui porque no usa DTOFacade
            gs.setCreatedBy(user);
            gs.setCreationDate(new GregorianCalendar());
            gs.setLastModificationBy(user);
            gs.setLastModificationDate(new GregorianCalendar());

        } else if (gsList.size() == 1){
            //Edit GeoreferencedSite
        
            gs = gsList.get(0);
            georeferencedSiteEAOImpl.delete(gs);                
            gsPK = new GeoreferencedSitePK(siteId, layerId, value);
            gs = new GeoreferencedSite(gsPK);
            gs.setCreatedBy(user);
            gs.setCreationDate(new GregorianCalendar());
            gs.setLastModificationBy(user);
            gs.setLastModificationDate(new GregorianCalendar());
            
        }
         //Falta un caso en que haya mas de un georeferecedSite, pero por ahora no se implementara
        
        
        georeferencedSiteEAOImpl.create(gs);
    }

    /**
     * Metodo encargado de guardar nuevas capas geograficas o editar existentes
     * @param geographicLayerValueDTO
     */
    public boolean saveOrUpdateGeographicLayerValue
            (GeographicLayerValueDTO geographicLayerValueDTO) {

        Country c;
        Province p;

        //En caso de que la capa geografica sea un pais
        if(geographicLayerValueDTO.getGeographicLayerKey().equals(COUNTRY_LAYER)){

            //Validar si los datos no son vacios
            String aux = geographicLayerValueDTO.getName();
            if(aux==null||aux.equals(""))
                return false;

            if(geographicLayerValueDTO.getGeographicLayerValueKey() == null){
                System.out.println("new country");
                c = new Country(geographicLayerValueDTO.getName());
                countryEAOImpl.create(c);

            } else {
                System.out.println("edit country");
                c = (Country) countryEAOImpl.findById(Country.class,
                        geographicLayerValueDTO.getGeographicLayerValueKey());
                System.out.println(" country con Id>"+c.getCountryId());
                System.out.println(" country con Name>"+geographicLayerValueDTO.getName());
                c.setValue(geographicLayerValueDTO.getName());
                countryEAOImpl.update(c);
            }

        //En caso de que la capa geografica sea una provincia
        } else if(geographicLayerValueDTO.getGeographicLayerKey().equals(PROVINCE_LAYER)){

            //Validar si los datos no son vacios
            String aux = geographicLayerValueDTO.getName();
            Long aux2 = geographicLayerValueDTO.getAncestorGeographicLayerValueKey();
            if(aux==null||aux2==null||aux.equals("")||aux2.equals(new Long(-1)))
                return false;
            
            c = (Country) countryEAOImpl.findById(Country.class,
                    geographicLayerValueDTO.getAncestorGeographicLayerValueKey());

            if(geographicLayerValueDTO.getGeographicLayerValueKey() == null){
                System.out.println("new province");
                p = new Province();
                p.setCountryId(c.getCountryId());
                p.setValue(geographicLayerValueDTO.getName());
                provinceEAOImpl.create(p);

            } else {
                System.out.println("edit province");
                p = (Province) provinceEAOImpl.findById(Province.class,
                        geographicLayerValueDTO.getGeographicLayerValueKey());
                p.setCountryId(c.getCountryId());
                p.setValue(geographicLayerValueDTO.getName());
                provinceEAOImpl.update(p);
            }

        }

        return true;
    }

    public CountryDTO getCountryByCountryId(Long countryId)
    {
        CountryDTO result;
        Country country =  (Country) countryEAOImpl.findById (Country.class, countryId);
        if(country !=null)
        {
         result = countryDTOFactory.createDTO(country);
        }
        else
        {
            result = null;
        }
        
        return result;
    }

    public List<SiteDTO> getSiteByDescription(String siteDescription, int base, int offset)
    {
        if(siteDescription != null)
            return siteDTOFactory.createDTOList(siteEAOImpl.getSiteByDescription(siteDescription, base, offset));
        else
            return null;
    }


    public String getSiteDescriptionById(Long siteId)
    {
        return siteEAOImpl.getSiteDescriptionById(siteId);
    }
    
    public String getReprojection(float valueX, float valueY, Long projectionSRID, Long reprojectioSRID)
    {
        return projectionEAOImpl.reprojection(valueX, valueY, projectionSRID, reprojectioSRID);
    }
}
