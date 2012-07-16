/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio ( Instituto Nacional de Biodiversidad )
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

package org.inbio.ara.persistence.specimen;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.inbio.ara.persistence.GenericEntity;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "specimen_life_stage_sex")
public class SpecimenLifeStageSex extends GenericEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected SpecimenLifeStageSexPK specimenLifeStageSexPK;

    @Basic(optional = false)
    @Column(name = "quantity")
    private Long quantity;

    @JoinColumn(name = "specimen_id", referencedColumnName = "specimen_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Specimen specimen;

    @JoinColumn(name="life_stage_id", referencedColumnName="life_stage_id", insertable = false, updatable=false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LifeStage lifeStage;

    @JoinColumn(name="sex_id", referencedColumnName="sex_id", insertable = false, updatable=false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sex sex;

    public SpecimenLifeStageSex() {
    }

    public SpecimenLifeStageSex(SpecimenLifeStageSexPK specimenLifeStageSexPK, Long quantity) {
        this.specimenLifeStageSexPK = specimenLifeStageSexPK;
        this.quantity = quantity;
    }

    public SpecimenLifeStageSex(SpecimenLifeStageSexPK specimenLifeStageSexPK, 
            Long quantity, String createdBy, Calendar creationDate,
            String lastModificationBy, Calendar lastModificationDate) {
        this.specimenLifeStageSexPK = specimenLifeStageSexPK;
        this.quantity = quantity;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public SpecimenLifeStageSex(Long specimenId, Long lifeStageId, Long sexId) {
        this.specimenLifeStageSexPK = new SpecimenLifeStageSexPK(specimenId, lifeStageId, sexId);
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (specimenLifeStageSexPK != null ? specimenLifeStageSexPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpecimenLifeStageSex)) {
            return false;
        }
        SpecimenLifeStageSex other = (SpecimenLifeStageSex) object;
        if ((this.specimenLifeStageSexPK == null && other.specimenLifeStageSexPK != null) 
                || (this.specimenLifeStageSexPK != null && !this.specimenLifeStageSexPK.equals(other.getSpecimenLifeStageSexPK())) ) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.specimen.SpecimenLifeStageSex[specimenLifeStageSexPK=" + specimenLifeStageSexPK + "]";
    }

    /**
     * @return the lifeStage
     */
    public LifeStage getLifeStage() {
        return lifeStage;
    }

    /**
     * @param lifeStage the lifeStage to set
     */
    public void setLifeStage(LifeStage lifeStage) {
        this.lifeStage = lifeStage;
    }

    /**
     * @return the sex
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(Sex sex) {
        this.sex = sex;
    }

}
