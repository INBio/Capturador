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
package org.inbio.ara.persistence.label;

import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;
//import org.inbio.ara.persistence.gathering.GatheringObservation;
//import org.inbio.ara.persistence.gathering.GatheringObservationDetail;

/**
 *
 * @author pcorrales
 */
@Entity
@Table(name = "original_label")
public class OriginalLabel extends  LogGenericEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="Label")
    @SequenceGenerator(name="Label", sequenceName="original_label_seq")
    @Basic(optional = false)
    @Column(name = "original_label_id")
    private Long originalLabelId;

    @Column(name = "contents")
    private String contents;



    /*@OneToMany(mappedBy = "original_label_id", fetch = FetchType.LAZY)
    private List<GatheringObservationDetail> gatheringObservationDetailList;

    @OneToMany(mappedBy = "original_label_id", fetch = FetchType.LAZY)
    private List<GatheringObservation> gatheringObservationList;*/

    public OriginalLabel() {
    }

    public OriginalLabel( Long originalLabelId) {
        this.originalLabelId = originalLabelId;
    }

    public OriginalLabel( Long originalLabelId,  Long objVersion, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.originalLabelId = originalLabelId;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getOriginalLabelId() {
        return originalLabelId;
    }

    public void setOriginalLabelId(Long originalLabelId) {
        this.originalLabelId = originalLabelId;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

   /* public List<GatheringObservationDetail> getGatheringObservationDetailList() {
        return gatheringObservationDetailList;
    }

    public void setGatheringObservationDetailList(List<GatheringObservationDetail> gatheringObservationDetailList) {
        this.gatheringObservationDetailList = gatheringObservationDetailList;
    }

    public List<GatheringObservation> getGatheringObservationList() {
        return gatheringObservationList;
    }

    public void setGatheringObservationList(List<GatheringObservation> gatheringObservationList) {
        this.gatheringObservationList = gatheringObservationList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (originalLabelId != null ? originalLabelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OriginalLabel)) {
            return false;
        }
        OriginalLabel other = (OriginalLabel) object;
        if ((this.originalLabelId == null && other.originalLabelId != null) || (this.originalLabelId != null && !this.originalLabelId.equals(other.originalLabelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.label.OriginalLabel[originalLabelId=" + originalLabelId + "]";
    }

}