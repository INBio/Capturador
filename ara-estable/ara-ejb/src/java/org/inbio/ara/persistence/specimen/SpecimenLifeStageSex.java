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
 * SpecimenLifeStageSex.java
 *
 * Created on October 29, 2007, 10:37 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.specimen;

import javax.persistence.Entity;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.inbio.ara.persistence.genericEntity;

/**
 * Entity class SpecimenLifeStageSex
 * 
 * @author roaguilar
 */
@Entity()
@Table(name="specimen_life_stage_sex")
public class SpecimenLifeStageSex extends genericEntity {

    @EmbeddedId
    private SpecimenLifeStageSexPK specimenLifeStageSexPK;
    
    @Column(name="quantity")
    private Long quantity;
    
    @JoinColumn(name="specimen_id", referencedColumnName="specimen_id", insertable = false, updatable=false)
    @ManyToOne()
    private Specimen specimen;
    
    @JoinColumn(name="life_stage_id", referencedColumnName="life_stage_id", insertable = false, updatable=false)
    @ManyToOne()
    private LifeStage lifeStage;
    
    @JoinColumn(name="sex_id", referencedColumnName="sex_id", insertable = false, updatable=false)
    @ManyToOne()
    private Sex sex;
    
    @Transient
    private String lifeStageName;
    
    @Transient
    private String sexName;
    
    /** Creates a new instance of SpecimenLifeStageSex */
    public SpecimenLifeStageSex() {
    }

    public SpecimenLifeStageSex(SpecimenLifeStageSexPK specimenLifeStageSexPK) {
        this.setSpecimenLifeStageSexPK(specimenLifeStageSexPK);
    }
    
    public SpecimenLifeStageSex(Long specimenId, Long lifeStageId, Long sexId) {
        this.setSpecimenLifeStageSexPK(new SpecimenLifeStageSexPK(specimenId, lifeStageId, sexId));
    }

    public SpecimenLifeStageSexPK getSpecimenLifeStageSexPK() {
        return specimenLifeStageSexPK;
    }

    public void setSpecimenLifeStageSexPK(SpecimenLifeStageSexPK specimenLifeStageSexPK) {
        this.specimenLifeStageSexPK = specimenLifeStageSexPK;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
    
    public Specimen getSpecimen() {
        return specimen;
    }

    public void setSpecimen(Specimen specimen) {
        this.specimen = specimen;
    }

    public LifeStage getLifeStage() {
        return lifeStage;
    }

    public void setLifeStage(LifeStage lifeStage) {
        this.lifeStage = lifeStage;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.specimenLifeStageSexPK != null ? this.specimenLifeStageSexPK.hashCode() : 0);
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
        if (!(object instanceof SpecimenLifeStageSex)) {
            return false;
        }
        SpecimenLifeStageSex other = (SpecimenLifeStageSex)object;
        if (this.specimenLifeStageSexPK != other.specimenLifeStageSexPK && (this.specimenLifeStageSexPK == null || !this.specimenLifeStageSexPK.equals(other.specimenLifeStageSexPK))) return false;
        return true;
    }
    
    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.gathering.SpecimenLifeStageSex[specimenLifeStageSexPK=" + specimenLifeStageSexPK + "]";
    } 

    @PostLoad
    public void postLoad(){
        if (this.lifeStage != null) {
            this.setLifeStageName(lifeStage.getName());
        }
        
        if (this.sex != null) {
            this.setSexName(sex.getName());
        }
    }

    public String getLifeStageName() {
        return lifeStageName;
    }

    public void setLifeStageName(String lifeStageName) {
        this.lifeStageName = lifeStageName;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }
}
