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

import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.persistence.SelectionListGenericEntity;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "life_stage")
public class LifeStage extends SelectionListGenericEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="life_stage")
	@SequenceGenerator(name="life_stage", sequenceName="life_stage_seq")
    @Basic(optional = false)
    @Column(name = "life_stage_id")
    private Long lifeStageId;


    public LifeStage() {
    }

    public LifeStage(Long lifeStageId) {
        this.lifeStageId = lifeStageId;
    }

    public LifeStage(Long lifeStageId, String name, String createdBy,
            Calendar creationDate, String lastModificationBy,
            Calendar lastModificationDate) {
        this.setId(lifeStageId);
        this.setName(name);
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getLifeStageId() {
        return lifeStageId;
    }

    public void setLifeStageId(Long lifeStageId) {
        this.lifeStageId = lifeStageId;
    }

   @Override
    public Long getId() {
       return lifeStageId;
    }

    @Override
    public void setId(Long id) {
        this.lifeStageId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.LIFE_STAGE;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lifeStageId != null ? lifeStageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LifeStage)) {
            return false;
        }
        LifeStage other = (LifeStage) object;
        if ((this.lifeStageId == null && other.lifeStageId != null) || (this.lifeStageId != null && !this.lifeStageId.equals(other.lifeStageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.specimen.LifeStage[lifeStageId=" + lifeStageId + "]";
    }

}
