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


package org.inbio.ara.persistence.gathering;

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
 * @author jgutierrez
 */
@Entity
@Table(name = "gathering_observation_method")
public class GatheringObservationMethod extends SelectionListGenericEntity {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="gathering_observation_method")
	@SequenceGenerator(name="gathering_observation_method", sequenceName="gathering_observation_method_seq")
    @Basic(optional = false)
    @Column(name = "gathering_observation_method_id")
    private Long gatheringObservationMethodId;


    public GatheringObservationMethod() {
    }

    public GatheringObservationMethod(Long gatheringObservationMethodId) {
        this.gatheringObservationMethodId = gatheringObservationMethodId;
    }

    public GatheringObservationMethod(Long gatheringObservationMethodId, 
            String name, String createdBy, Calendar creationDate,
            String lastModificationBy, Calendar lastModificationDate) {
        this.gatheringObservationMethodId = gatheringObservationMethodId;
        this.setName(name);
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getGatheringObservationMethodId() {
        return gatheringObservationMethodId;
    }

    public void setGatheringObservationMethodId(Long gatheringObservationMethodId) {
        this.gatheringObservationMethodId = gatheringObservationMethodId;
    }


    @Override
    public Long getId() {
       return gatheringObservationMethodId;
    }

    @Override
    public void setId(Long id) {
        this.gatheringObservationMethodId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.GATHERING_METHOD_OBSERVATION;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gatheringObservationMethodId != null ? gatheringObservationMethodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GatheringObservationMethod)) {
            return false;
        }
        GatheringObservationMethod other = (GatheringObservationMethod) object;
        if ((this.gatheringObservationMethodId == null && other.gatheringObservationMethodId != null) || (this.gatheringObservationMethodId != null && !this.gatheringObservationMethodId.equals(other.gatheringObservationMethodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.gathering.GatheringObservationMethod[gatheringObservationMethodId=" + gatheringObservationMethodId + "]";
    }

}
