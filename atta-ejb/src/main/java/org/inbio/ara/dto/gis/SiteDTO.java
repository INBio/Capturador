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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.inbio.ara.dto.GenericDTO;
import org.inbio.ara.persistence.gis.SiteCoordinate;

/**
 *
 * @author esmata
 */
public class SiteDTO extends GenericDTO implements Serializable{

    
    
    private Long siteId;
    private String description;
    private Long precision;
    private Long geodeticDatum;
    private Long featureTypeId;
    private Long baseProjectionId;
    private Long originalProjectionId;
    private Long siteCalculationMethodId;
    private String name;

    private Integer radio;
    private Double longitude;
    private Double latitude;
    private String coordinates;
    @Deprecated
    private List<SiteCoordinate> coordinatesList;
    
    private List<SiteCoordinateDTO> coordinatesListDTO;

    private Long countryId;
    private String countryName;
    private Long provinceId;
    private String provinceName;
    private String specimenName;

    // only for queries
    private String taxonName;

    //Para propositos de GUI (Listado)
    private boolean selected;

    public SiteDTO(){
    }

    public SiteDTO(Long id,String des){
        this.siteId = id;
        this.description = des;
    }

    /**
     * @return the siteId
     */
    public Long getSiteId() {
        return siteId;
    }

    /**
     * @param siteId the siteId to set
     */
    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the coordinates
     */
    public String getCoordinates() {
        return coordinates;
    }

    /**
     * @param coordinates the coordinates to set
     */
    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * @return the longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the radio
     */
    public Integer getRadio() {
        return radio;
    }

    /**
     * @param radio the radio to set
     */
    public void setRadio(Integer radio) {
        this.radio = radio;
    }

    /**
     * @return the countryId
     */
    public Long getCountryId() {
        return countryId;
    }

    /**
     * @param countryId the countryId to set
     */
    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    /**
     * @return the countryName
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * @param countryName the countryName to set
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * @return the provinceId
     */
    public Long getProvinceId() {
        return provinceId;
    }

    /**
     * @param provinceId the provinceId to set
     */
    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * @return the provinceName
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * @param provinceName the provinceName to set
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

     /**
     * @return the specimenName
     */
    public String getSpecimenName() {
        return specimenName;
    }

    /**
     * @param specimenName the provinceName to set
     */
    public void setSpecimenName(String specimenName) {
        this.specimenName = specimenName;
    }

    /**
     * @return the coordinatesList
     */
    public List<SiteCoordinate> getCoordinatesList() {
        return coordinatesList;
    }

    public List<SiteCoordinateDTO> getCoordinateDTOList() {
        /*
        List<SiteCoordinateDTO> result = new ArrayList<SiteCoordinateDTO>();
        
        for(SiteCoordinate sc : coordinatesList){
            SiteCoordinateDTO aux = new SiteCoordinateDTO();
            aux.setLatitude(sc.getLatitude());
            aux.setLongitude(sc.getLongitude());
            aux.setOriginalX(sc.getOriginalX());
            aux.setOriginalY(sc.getOriginalY());
            aux.setSequence(sc.getSequence());
            aux.setSiteCoordinateId(sc.getSiteCoordinateId());
            aux.setSiteId(sc.getSiteId().getSiteId());
            result.add(aux);
        }
        
        
        return result;        
        */
        return coordinatesListDTO;
    }

    /**
     * @param coordinatesList the coordinatesList to set
     */
    public void setCoordinatesList(List<SiteCoordinate> coordinatesList) {
        this.coordinatesList = coordinatesList;
    }

    @Override
    public String toString() {
        return "SpecimenDTO" +
                "\n\tCoords = " + this.coordinates +
                "\n\tDescription = " + this.description +
                "\n\tSite Id = " + this.siteId +
                "\n\tSite countryName = " + this.countryName +
                "\n\tSite countryId = " + this.countryId +
                "\n\tSite provinceName = " + this.provinceName +
                "\n\tSite provinceId = " + this.provinceId +
                "\n\tSite radio = " + this.radio;

    }

    /**
     * @return the selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * @return the taxonName
     */
    public String getTaxonName() {
        return taxonName;
    }

    /**
     * @param taxonName the taxonName to set
     */
    public void setTaxonName(String taxonName) {
        this.taxonName = taxonName;
    }

    /**
     * @return the precision
     */
    public Long getPrecision() {
        return precision;
    }

    /**
     * @param precision the precision to set
     */
    public void setPrecision(Long precision) {
        this.precision = precision;
    }

    /**
     * @return the geodeticDatum
     */
    public Long getGeodeticDatum() {
        return geodeticDatum;
    }

    /**
     * @param geodeticDatum the geodeticDatum to set
     */
    public void setGeodeticDatum(Long geodeticDatum) {
        this.geodeticDatum = geodeticDatum;
    }

    /**
     * @return the featureTypeId
     */
    public Long getFeatureTypeId() {
        return featureTypeId;
    }

    /**
     * @param featureTypeId the featureTypeId to set
     */
    public void setFeatureTypeId(Long featureTypeId) {
        this.featureTypeId = featureTypeId;
    }

    /**
     * @return the baseProjectionId
     */
    public Long getBaseProjectionId() {
        return baseProjectionId;
    }

    /**
     * @param baseProjectionId the baseProjectionId to set
     */
    public void setBaseProjectionId(Long baseProjectionId) {
        this.baseProjectionId = baseProjectionId;
    }

    /**
     * @return the originalProjectionId
     */
    public Long getOriginalProjectionId() {
        return originalProjectionId;
    }

    /**
     * @param originalProjectionId the originalProjectionId to set
     */
    public void setOriginalProjectionId(Long originalProjectionId) {
        this.originalProjectionId = originalProjectionId;
    }

    /**
     * @return the siteCalculationMethodId
     */
    public Long getSiteCalculationMethodId() {
        return siteCalculationMethodId;
    }

    /**
     * @param siteCalculationMethodId the siteCalculationMethodId to set
     */
    public void setSiteCalculationMethodId(Long siteCalculationMethodId) {
        this.siteCalculationMethodId = siteCalculationMethodId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the coordinatesListDTO
     */
    public List<SiteCoordinateDTO> getCoordinatesListDTO() {
        return coordinatesListDTO;
    }

    /**
     * @param coordinatesListDTO the coordinatesListDTO to set
     */
    public void setCoordinatesListDTO(List<SiteCoordinateDTO> coordinatesListDTO) {
        this.coordinatesListDTO = coordinatesListDTO;
    }
}