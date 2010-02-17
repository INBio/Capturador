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

package org.inbio.ara.persistence.gis;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "geographic_layer")

public class GeographicLayer extends LogGenericEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "geographic_layer_id")
    private Long geographicLayerId;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "key_field")
    private String keyField;

    @Column(name = "main_value_field")
    private String mainValueField;

    @Column(name = "required")
    private String required;

    @Column(name = "table_name")
    private String tableName;

    @Column(name = "color")
    private String color;

    @Column(name = "fill")
    private String fill;

    @Column(name = "default_sequence")
    private String defaultSequence;

    @Column(name = "visible")
    private String visible;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "geographicLayer", fetch = FetchType.LAZY)
    //private List<GeoreferencedSite> georeferencedSiteCollection;

    public GeographicLayer() {
    }

    public GeographicLayer(Long geographicLayerId) {
        this.geographicLayerId = geographicLayerId;
    }

    public GeographicLayer(Long geographicLayerId, String name, String createdBy,
            Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.geographicLayerId = geographicLayerId;
        this.name = name;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getGeographicLayerId() {
        return geographicLayerId;
    }

    public void setGeographicLayerId(Long geographicLayerId) {
        this.geographicLayerId = geographicLayerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getKeyField() {
        return keyField;
    }

    public void setKeyField(String keyField) {
        this.keyField = keyField;
    }

    public String getMainValueField() {
        return mainValueField;
    }

    public void setMainValueField(String mainValueField) {
        this.mainValueField = mainValueField;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFill() {
        return fill;
    }

    public void setFill(String fill) {
        this.fill = fill;
    }

    public String getDefaultSequence() {
        return defaultSequence;
    }

    public void setDefaultSequence(String defaultSequence) {
        this.defaultSequence = defaultSequence;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    /*public List<GeoreferencedSite> getGeoreferencedSiteCollection() {
        return georeferencedSiteCollection;
    }

    public void setGeoreferencedSiteCollection(List<GeoreferencedSite> georeferencedSiteCollection) {
        this.georeferencedSiteCollection = georeferencedSiteCollection;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (geographicLayerId != null ? geographicLayerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeographicLayer)) {
            return false;
        }
        GeographicLayer other = (GeographicLayer) object;
        if ((this.geographicLayerId == null && other.geographicLayerId != null) || (this.geographicLayerId != null && !this.geographicLayerId.equals(other.geographicLayerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.gis.GeographicLayer[geographicLayerId=" + geographicLayerId + "]";
    }

}
