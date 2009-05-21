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
 * SpecimenLifeForm.java
 *
 * Created on October 30, 2007, 2:20 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.specimen;

import javax.persistence.Entity;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.inbio.ara.persistence.genericEntity;

/**
 * Entity class SpecimenLifeForm
 * 
 * @author roaguilar
 */
@Entity()
@Table(name="specimen_life_form")
public class SpecimenLifeForm extends genericEntity {

    @EmbeddedId
    private SpecimenLifeFormPK specimenLifeFormPK;
    
    @JoinColumn(name="specimen_id", referencedColumnName="specimen_id", insertable = false, updatable=false)
    @ManyToOne()
    private Specimen specimen;
    
    @JoinColumn(name="life_form_id", referencedColumnName="life_form_id", insertable = false, updatable=false)
    @ManyToOne()
    private LifeForm lifeForm;
    
    /** Creates a new instance of SpecimenLifeForm */
    public SpecimenLifeForm() {
    }
    
    public SpecimenLifeForm(SpecimenLifeFormPK specimenLifeFormPK) {
        this.setSpecimenLifeFormPK(specimenLifeFormPK);
    }
    
    public SpecimenLifeForm(Long specimenId, Long lifeFormId) {
        this.setSpecimenLifeFormPK(new SpecimenLifeFormPK(specimenId, lifeFormId));
    }

    public SpecimenLifeFormPK getSpecimenLifeFormPK() {
        return specimenLifeFormPK;
    }

    public void setSpecimenLifeFormPK(SpecimenLifeFormPK specimenLifeFormPK) {
        this.specimenLifeFormPK = specimenLifeFormPK;
    }

    public Specimen getSpecimen() {
        return specimen;
    }

    public void setSpecimen(Specimen specimen) {
        this.specimen = specimen;
    }

    public LifeForm getLifeForm() {
        return lifeForm;
    }

    public void setLifeForm(LifeForm lifeForm) {
        this.lifeForm = lifeForm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.specimenLifeFormPK != null ? this.specimenLifeFormPK.hashCode() : 0);
        return hash;
    }
    
    /**
     * Determines whether another object is equal to this PersonProfile.  The result is 
     * <code>true</code> if and only if the argument is not null and is a PersonProfile object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpecimenLifeForm)) {
            return false;
        }
        SpecimenLifeForm other = (SpecimenLifeForm)object;
        if (this.specimenLifeFormPK != other.specimenLifeFormPK && (this.specimenLifeFormPK == null || !this.specimenLifeFormPK.equals(other.specimenLifeFormPK))) return false;
        return true;
    }
    
    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.specimen.SpecimenLifeForm[specimenLifeFormPK=" + specimenLifeFormPK + "]";
    } 
}
