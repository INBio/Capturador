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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author esmata
 */
@Embeddable
public class SpecimenLifeStageSexPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "specimen_id")
    private Long specimenId;
    @Basic(optional = false)
    @Column(name = "life_stage_id")
    private Long lifeStageId;
    @Basic(optional = false)
    @Column(name = "sex_id")
    private Long sexId;

    public SpecimenLifeStageSexPK() {
    }

    public SpecimenLifeStageSexPK(Long specimenId, Long lifeStageId, Long sexId) {
        this.specimenId = specimenId;
        this.lifeStageId = lifeStageId;
        this.sexId = sexId;
    }

    public Long getSpecimenId() {
        return specimenId;
    }

    public void setSpecimenId(Long specimenId) {
        this.specimenId = specimenId;
    }

    public Long getLifeStageId() {
        return lifeStageId;
    }

    public void setLifeStageId(Long lifeStageId) {
        this.lifeStageId = lifeStageId;
    }

    public Long getSexId() {
        return sexId;
    }

    public void setSexId(Long sexId) {
        this.sexId = sexId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (specimenId != null ? specimenId.hashCode() : 0);
        hash += (lifeStageId != null ? lifeStageId.hashCode() : 0);
        hash += (sexId != null ? sexId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof SpecimenLifeStageSexPK)) {
            return false;
        }

        SpecimenLifeStageSexPK other = (SpecimenLifeStageSexPK) obj;
        
        if(this.specimenId.longValue() != other.specimenId.longValue())
            return false;
        else if(this.lifeStageId.longValue() != other.lifeStageId.longValue())
            return false;
        else if(this.sexId.longValue() != other.sexId.longValue())
            return false;
        else
            return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.specimen.SpecimenLifeStageSexPK[specimenId=" + specimenId + ", lifeStageId=" + lifeStageId + ", sexId=" + sexId + "]";
    }

}
