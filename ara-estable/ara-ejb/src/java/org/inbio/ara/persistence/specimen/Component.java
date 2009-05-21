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
 * Component.java
 *
 * Created on October 30, 2007, 2:13 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.specimen;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.persistence.genericEntity;

/**
 * Entity class Component
 * 
 * @author roaguilar
 */
@Entity()
@Table(name="component")
@TableGenerator(name="component_gen",table="ID_GEN",pkColumnName="GEN_KEY",valueColumnName="GEN_VALUE",pkColumnValue="component_id",allocationSize=1)
public class Component extends genericEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="component_gen")
    @Column(name = "component_id", nullable = false)
    private Long id;
    
    @Column(name="component_sequence")
    private Long sequence;
    
    @Temporal(TemporalType.DATE)
    @Column(name="component_date", nullable = false)
    private Date componentDate;
    
    @Column(name="component_type",length=1)
    private String componentType;
    
    @JoinColumn(name="specimen_id", referencedColumnName="specimen_id")
    @ManyToOne()
    private Specimen specimen;
    
    @JoinColumn(name="component_part_id", referencedColumnName="component_part_id")
    @ManyToOne()
    private ComponentPart componentPartId;
    
    @JoinColumn(name="preparation_method_id", referencedColumnName="preparation_method_id")
    @ManyToOne()
    private PreparationMethod preparationMethod;    
    
    /** Creates a new instance of Component */
    public Component() {
    }

    /**
     * Gets the id of this Component.
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id of this Component to the specified value.
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
     * Determines whether another object is equal to this Component.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Component object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Component)) {
            return false;
        }
        Component other = (Component)object;
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
        return "org.inbio.ara.persistence.specimen.Component[id=" + id + "]";
    }

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    public Date getComponentDate() {
        return componentDate;
    }

    public void setComponentDate(Date componentDate) {
        this.componentDate = componentDate;
    }

    public String getComponentType() {
        return componentType;
    }

    public void setComponentType(String componentType) {
        this.componentType = componentType;
    }

    public Specimen getSpecimen() {
        return specimen;
    }

    public void setSpecimen(Specimen specimen) {
        this.specimen = specimen;
    }

    public ComponentPart getComponentPartId() {
        return componentPartId;
    }

    public void setComponentPartId(ComponentPart componentPartId) {
        this.componentPartId = componentPartId;
    }

    public PreparationMethod getPreparationMethod() {
        return preparationMethod;
    }

    public void setPreparationMethod(PreparationMethod preparationMethod) {
        this.preparationMethod = preparationMethod;
    }
    
}
