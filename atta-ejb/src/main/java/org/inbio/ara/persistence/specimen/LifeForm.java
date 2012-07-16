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
@Table(name = "life_form")

public class LifeForm  extends SelectionListGenericEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="life_form")
	@SequenceGenerator(name="life_form", sequenceName="life_form_seq")
    @Basic(optional = false)
    @Column(name = "life_form_id")
    private Long lifeFormId;

    public LifeForm() {
    }

    public LifeForm(Long lifeFormId) {
        this.lifeFormId = lifeFormId;
    }

    public LifeForm(Long lifeFormId, String name, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.setId(lifeFormId);
        this.setName(name);
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lifeFormId != null ? lifeFormId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LifeForm)) {
            return false;
        }
        LifeForm other = (LifeForm) object;
        if ((this.lifeFormId == null && other.lifeFormId != null) || (this.lifeFormId != null && !this.lifeFormId.equals(other.lifeFormId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.specimen.LifeForm[lifeFormId=" + lifeFormId + "]";
    }

    @Override
    public Long getId() {
        return lifeFormId;
    }

    @Override
    public void setId(Long id) {
        this.lifeFormId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
       return SelectionListEntity.LIFE_FORM;
    }

}
