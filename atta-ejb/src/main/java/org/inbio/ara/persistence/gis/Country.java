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

package org.inbio.ara.persistence.gis;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.inbio.ara.persistence.GenericEntity;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "country")
public class Country extends GenericEntity {
    private static final long serialVersionUID = 1L;

    private static final GeographicLayerEntity geographicLayerEntity = 
            GeographicLayerEntity.COUNTRY;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="Country")
	@SequenceGenerator(name="Country", sequenceName="country_seq")
    @Basic(optional = false)
    @Column(name = "country_id")
    private Long countryId;
    
    @Basic(optional = false)
    @Column(name = "value")
    private String value;

    public Country() {
    }

    public Country(Long countryId) {
        this.countryId = countryId;
    }

    public Country(Long countryId, String value) {
        this.countryId = countryId;
        this.value = value;
    }

     public Country(String name){
        this.setValue(name);
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryId != null ? countryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Country)) {
            return false;
        }
        Country other = (Country) object;
        if ((this.countryId == null && other.countryId != null) || (this.countryId != null && !this.countryId.equals(other.countryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.gis.Country[countryId=" + countryId + "]";
    }

}
