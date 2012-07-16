/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.germplasm;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.persistence.LogGenericEntity;
import org.inbio.ara.persistence.SelectionListGenericEntity;

/**
 *
 * @author dasolano
 */
@Entity
@Table(name = "condition")
public class Condition  extends SelectionListGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="condition")
    @SequenceGenerator(name="condition", sequenceName="condition_seq")
    @Basic(optional = false)
    @Column(name = "condition_id")
    private Long conditionId;


    public Condition() {
    }

    public Condition(Long conditionId) {
        this.conditionId = conditionId;
    }

    public Condition(Long conditionId, String name, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.conditionId = conditionId;
        this.setName(name);
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getConditionId() {
        return conditionId;
    }

    public void setConditionId(Long conditionId) {
        this.conditionId = conditionId;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conditionId != null ? conditionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Condition)) {
            return false;
        }
        Condition other = (Condition) object;
        if ((this.conditionId == null && other.conditionId != null) || (this.conditionId != null && !this.conditionId.equals(other.conditionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.germplasm.Condition[conditionId=" + conditionId + "]";
    }

    @Override
    public Long getId() {
        return conditionId;
    }

    @Override
    public void setId(Long id) {
        this.conditionId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.CONDITION;
    }

}
