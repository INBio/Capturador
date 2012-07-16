/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.germplasm;

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
 * @author dasolano
 */
@Entity
@Table(name = "cultivation_practice")
public class CultivationPractice extends SelectionListGenericEntity{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="cultivation_practice")
    @SequenceGenerator(name="cultivation_practice", sequenceName="cultivation_practice_seq")
    @Basic(optional = false)
    @Column(name = "cultivation_practice_id")
    private Long cultivationPracticeId;

    public CultivationPractice() {
    }

    public CultivationPractice(Long cultivationPracticeId) {
        this.cultivationPracticeId = cultivationPracticeId;
    }

    public CultivationPractice(Long cultivationPracticeId, String name, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.cultivationPracticeId = cultivationPracticeId;
        this.setName(name);
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getCultivationPracticeId() {
        return cultivationPracticeId;
    }

    public void setCultivationPracticeId(Long cultivationPracticeId) {
        this.cultivationPracticeId = cultivationPracticeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cultivationPracticeId != null ? cultivationPracticeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CultivationPractice)) {
            return false;
        }
        CultivationPractice other = (CultivationPractice) object;
        if ((this.cultivationPracticeId == null && other.cultivationPracticeId != null) || (this.cultivationPracticeId != null && !this.cultivationPracticeId.equals(other.cultivationPracticeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.germoplasma.CultivationPractice[cultivationPracticeId=" + cultivationPracticeId + "]";
    }

    @Override
    public Long getId() {
        return cultivationPracticeId;
    }

    @Override
    public void setId(Long id) {
        this.cultivationPracticeId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.CULTIVATION_PRACTICE;
    }

}