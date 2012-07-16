/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.label;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author pcorrales
 */
@Entity
@Table(name = "label_history")

public class LabelHistory extends LogGenericEntity implements Serializable {


    @EmbeddedId
    protected LabelHistoryPK labelHistoryPK;
    
    @Column(name = "contents")
    private String contents;
    
    @Column(name = "final_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar finalDate;

    @JoinColumn(name = "label_id", referencedColumnName = "label_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Label label;

    @Column(name = "ancestor_label_id")
    private Long ancestorLabelId;


    public LabelHistory() {
    }

    public LabelHistory(LabelHistoryPK labelHistoryPK) {
        this.labelHistoryPK = labelHistoryPK;
    }

    public LabelHistory(LabelHistoryPK labelHistoryPK, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate,Long ancestorLabelId) {
        this.setLabelHistoryPK(labelHistoryPK);
        this.setLastModificationDate(lastModificationDate); 
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setAncestorLabelId(ancestorLabelId);
    }

    public LabelHistory(Long labelId, Calendar initialDate) {
        this.labelHistoryPK = new LabelHistoryPK(labelId, initialDate);
    }

    public LabelHistoryPK getLabelHistoryPK() {
        return labelHistoryPK;
    }

    public void setLabelHistoryPK(LabelHistoryPK labelHistoryPK) {
        this.labelHistoryPK = labelHistoryPK;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (labelHistoryPK != null ? labelHistoryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LabelHistory)) {
            return false;
        }
        LabelHistory other = (LabelHistory) object;
        if ((this.labelHistoryPK == null && other.labelHistoryPK != null) || (this.labelHistoryPK != null && !this.labelHistoryPK.equals(other.labelHistoryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.label.LabelHistory[labelHistoryPK=" + labelHistoryPK + "]";
    }

    /**
     * @return the finalDate
     */
    public Calendar getFinalDate() {
        return finalDate;
    }

    /**
     * @param finalDate the finalDate to set
     */
    public void setFinalDate(Calendar finalDate) {
        this.finalDate = finalDate;
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
