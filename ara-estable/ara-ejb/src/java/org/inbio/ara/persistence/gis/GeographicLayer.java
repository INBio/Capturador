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
/*
 * GeographicLayer.java
 *
 * Created on April 22, 2008, 10:32 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.gis;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import org.inbio.ara.persistence.selectionListEntity;

/**
 * Entity class GeographicLayer
 * 
 * @author roaguilar
 */
@Entity
@Table(name ="geographic_layer")
@TableGenerator(name="geographic_layer_id_gen",table="ID_GEN",pkColumnName="GEN_KEY",valueColumnName="GEN_VALUE",pkColumnValue="geographic_layer_id",allocationSize=1)
public class GeographicLayer extends selectionListEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="geographic_layer_id_gen")
    @Column(name = "geographic_layer_id", nullable = false)
    private Long id;
    
    @Column(name="file_name")
    private String fileName;
    
    @Column(name="key_field")
    private String keyField;
    
    @Column(name="main_value_field")
    private String mainValueField;
    
    @Column(name="required")
    private String required;
    
    @Column(name="table_name")
    private String tableName;
    
    @Column(name="color")
    private String color;
    
    @Column(name="fill")
    private String fill;
    
    @Column(name="default_sequence")
    private String defaultSequence;
    
    @Column(name="visible")
    private String visible;
    
    
    /** Creates a new instance of GeographicLayer */
    public GeographicLayer() {
    }

    /**
     * Gets the id of this GeographicLayer.
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id of this GeographicLayer to the specified value.
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this GeographicLayer.  The result is 
     * <code>true</code> if and only if the argument is not null and is a GeographicLayer object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeographicLayer)) {
            return false;
        }
        GeographicLayer other = (GeographicLayer)object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.gis.GeographicLayer[id=" + id + "]";
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
    
}
