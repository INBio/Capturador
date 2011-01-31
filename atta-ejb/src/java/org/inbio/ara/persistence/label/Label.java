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

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
/*import org.inbio.ara.persistence.gathering.GatheringObservation;
import org.inbio.ara.persistence.gathering.GatheringObservationDetail;*/

/**
 *
 * @author pcorrales
 */
@Entity
@Table(name = "label")


public class Label extends LogGenericEntity  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="Label")
    @SequenceGenerator(name="Label", sequenceName="label_seq")
    @Basic(optional = false)
    @Column(name = "label_id")
    private Long labelId;

    @Column(name = "initial_date")
    @Temporal(TemporalType.DATE)
    private Calendar initialDate;

    @Column(name = "contents")
    private String contents;

    @Column(name = "label_type_id")
    private Long labelTypeId;

    @Column(name = "ancestor_label_id")
    private Long ancestorLabelId;




  /*  @OneToMany ( cascade = {CascadeType.ALL},mappedBy = "labelId", fetch = FetchType.LAZY)
    private List<GatheringObservationDetail> gatheringObservationDetailList;

    @OneToMany(cascade = {CascadeType.ALL},mappedBy = "labelId", fetch = FetchType.LAZY)
    private List<GatheringObservation> gatheringObservationList;*/


    public Label() {
    }

    public Label(Long labelId) {
        this.labelId = labelId;
    }

    public Label(Long labelId, Long objVersion, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate,Long ancestorLabelId) {
        this.setLabelId(labelId);
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
        this.setAncestorLabelId(ancestorLabelId);
    }

    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    public Calendar getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Calendar initialDate) {
        this.initialDate = initialDate;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

  /*  @Override
    public void setLastModificationDate(Calendar lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public List<GatheringObservationDetail> getGatheringObservationDetailList() {
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
        hash += (labelId != null ? labelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Label)) {
            return false;
        }
        Label other = (Label) object;
        if ((this.labelId == null && other.labelId != null) || (this.labelId != null && !this.labelId.equals(other.labelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.label.Label[labelId=" + labelId + "]";
    }

    
    /**
     * @return the labelTypeID
     */
    public Long getLabelTypeId() {
        return labelTypeId;
    }

    /**
     * @param labelTypeID the labelTypeID to set
     */
    public void setLabelTypeId(Long labelTypeId) {
        this.labelTypeId = labelTypeId;
    }

    /**
     * @return the ancestorLabelId
     */
    public Long getAncestorLabelId() {
        return ancestorLabelId;
    }

    /**
     * @param ancestorLabelId the ancestorLabelId to set
     */
    public void setAncestorLabelId(Long ancestorLabelId) {
        this.ancestorLabelId = ancestorLabelId;
    }

}