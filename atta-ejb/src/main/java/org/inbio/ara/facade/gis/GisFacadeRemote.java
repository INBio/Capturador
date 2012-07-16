/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.facade.gis;

import java.util.List;
import javax.ejb.Remote;
import org.inbio.ara.dto.gis.GeographicLayerDTO;
import org.inbio.ara.dto.gis.GeographicLayerValueDTO;
import org.inbio.ara.dto.gis.GeoreferencedSitePKDTO;
import org.inbio.ara.dto.gis.SiteCoordinateDTO;
import org.inbio.ara.dto.gis.SiteDTO;
import org.inbio.ara.dto.taxonomy.CountryDTO;

/**
 *
 * @author esmata
 */
@Remote
public interface GisFacadeRemote {

    public static Long COUNTRY_LAYER = new Long(1);
    public static Long PROVINCE_LAYER = new Long(2);

    /**
     *
     * @param first
     * @param totalResults
     * @return
     */
    public java.util.List<org.inbio.ara.dto.gis.SiteDTO> getAllSitePaginated(int first, int totalResults);

    public Long countSites();

    public java.util.List<org.inbio.ara.dto.gis.GeographicLayerDTO> getAllCountries();

    public java.util.List<org.inbio.ara.dto.gis.GeographicLayerDTO> getProvincesByCountry(java.lang.Long country);

    public java.util.List<org.inbio.ara.dto.gis.SiteDTO> getAllSites();

    public java.util.List<org.inbio.ara.dto.gis.SiteDTO> updateCountryAndProvinceName(java.util.List<org.inbio.ara.dto.gis.SiteDTO> sDTOList);

    public org.inbio.ara.dto.gis.SiteDTO updateCountryAndProvinceName(org.inbio.ara.dto.gis.SiteDTO sDTO);

    public GeographicLayerDTO getAllGeographicalLayer(Long geographicLayerId);

    public List<GeographicLayerValueDTO> getAllGeographicalLayerValuesForGeographicLayerAndAncestor
            (Long geographicLayerId, Long ancestorGeographicValueId);

    public List<GeographicLayerValueDTO> getAllGeographicalLayerValuesForGeographicLayer
            (Long geographicLayerId);

    public List<GeographicLayerDTO> getAllGeographicalLayers();

    public GeographicLayerValueDTO getAllGeographicalLayerValueForGeographicLayerAndId
            (Long geographicLayerId, Long geographicLayerValueId);

    public boolean saveOrUpdateGeographicLayerValue
            (GeographicLayerValueDTO geographicLayerValueDTO);

    public java.util.List<org.inbio.ara.dto.gis.FeatureTypeDTO> getAllFeatureType();

    public java.util.List<org.inbio.ara.dto.gis.SiteCalculationMethodDTO> getAllSiteCalculationMethods();

    public java.util.List<org.inbio.ara.dto.gis.ProjectionDTO> getAllProjection();

    public CountryDTO getCountryForSite(Long siteId);

    public org.inbio.ara.dto.gis.ProvinceDTO getProvinceForSite(java.lang.Long siteId);

    public java.util.List<org.inbio.ara.dto.taxonomy.CountryDTO> findAllCountries();

    public java.util.List<org.inbio.ara.dto.gis.ProvinceDTO> getAllProvincesForContry(java.lang.Long cId);

    public SiteDTO saveNewSite(SiteDTO sDTO,List<SiteCoordinateDTO> coorList,
            List<GeoreferencedSitePKDTO> georefSiteList);

    public void saveOrUpdateGeoreferenceForSite(Long siteId,
            Long layerId, Long value);

    public SiteDTO updateSite(SiteDTO sDTO, List<SiteCoordinateDTO> coorList,
            List<GeoreferencedSitePKDTO> georefSiteList);

    public void deleteSite(Long Id);

    public CountryDTO getCountryByCountryId(Long countryId);

    /**
     * Get all sites for a fragment of a site description. The results are obtain in a given range
     * @param siteDescription String
     * @param base int
     * @param offset int
     * @return List<SiteDTO>
     */
    public List<SiteDTO> getSiteByDescription(String siteDescription, int base, int offset);

    public String getSiteDescriptionById(Long siteId);
    
}
