/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.taxonomy;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;


/**
 *
 * @author gsulca
 */
@Entity
@Table(name = "taxon_indicator")

public class TaxonIndicator extends LogGenericEntity {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TaxonIndicatorPK taxonIndicatorPK;

    @Column(name = "certainty_level")
    private Long certaintyLevel;
    @Column(name = "evaluation_criteria")
    private String evaluationCriteria;
    @Column(name = "regionality")
    private String regionality;
    @Column(name = "temporality")
    private String temporality;
    @Column(name = "notes")
    private String notes;
    @Column(name = "valuer_person_id")
    private Long valuerPersonId;
    
    public TaxonIndicator() {
    }

    public TaxonIndicator(TaxonIndicatorPK taxonIndicatorPK) {
        this.taxonIndicatorPK = taxonIndicatorPK;
    }

    public TaxonIndicator(TaxonIndicatorPK taxonIndicatorPK,String createdBy, Calendar creationDate,
            String lastModificationBy, Calendar lastModificationDate) {
        this.taxonIndicatorPK = taxonIndicatorPK;
        
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);

    }

    public TaxonIndicator(Long taxonId, Long indicatorId) {
        this.taxonIndicatorPK = new TaxonIndicatorPK(indicatorId, taxonId);
    }

    public TaxonIndicatorPK getTaxonIndicatorPK() {
        return taxonIndicatorPK;
    }

    public void setTaxonIndicatorPK(TaxonIndicatorPK taxonIndicatorPK) {
        this.taxonIndicatorPK = taxonIndicatorPK;
    }

    public Long getCertaintyLevel() {
        return certaintyLevel;
    }

    public void setCertaintyLevel(Long certaintyLevel) {
        this.certaintyLevel = certaintyLevel;
    }

    public String getEvaluationCriteria() {
        return evaluationCriteria;
    }

    public void setEvaluationCriteria(String evaluationCriteria) {
        this.evaluationCriteria = evaluationCriteria;
    }

    public String getRegionality() {
        return regionality;
    }

    public void setRegionality(String regionality) {
        this.regionality = regionality;
    }

    public String getTemporality() {
        return temporality;
    }

    public void setTemporality(String temporality) {
        this.temporality = temporality;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    
    public Long getValuerPersonId() {
        return valuerPersonId;
    }

    public void setValuerPersonId(Long valuerPersonId) {
        this.valuerPersonId = valuerPersonId;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxonIndicatorPK != null ? taxonIndicatorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonIndicator)) {
            return false;
        }
        TaxonIndicator other = (TaxonIndicator) object;
        if ((this.taxonIndicatorPK == null && other.taxonIndicatorPK != null) || (this.taxonIndicatorPK != null && !this.taxonIndicatorPK.equals(other.taxonIndicatorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonIndicator[taxonIndicatorPK=" + taxonIndicatorPK + "]";
    }

}
