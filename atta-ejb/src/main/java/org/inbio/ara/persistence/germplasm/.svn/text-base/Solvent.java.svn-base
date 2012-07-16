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
import org.inbio.ara.persistence.SelectionListGenericEntity;

/**
 *
 * @author dasolano
 */
@Entity
@Table(name = "solvent")
public class Solvent extends SelectionListGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="solvent")
    @SequenceGenerator(name="solvent", sequenceName="solvent_seq")
    @Basic(optional = false)
    @Column(name = "solvent_id")
    private Long solventId;
    

    public Solvent() {
    }

    public Solvent(Long solventId) {
        this.solventId = solventId;
    }

    public Solvent(Long solventId, String name, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.solventId = solventId;
        this.setName(name);
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getSolventId() {
        return solventId;
    }

    public void setSolventId(Long solventId) {
        this.solventId = solventId;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (solventId != null ? solventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solvent)) {
            return false;
        }
        Solvent other = (Solvent) object;
        if ((this.solventId == null && other.solventId != null) || (this.solventId != null && !this.solventId.equals(other.solventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.germplasm.Solvent[solventId=" + solventId + "]";
    }

    @Override
    public Long getId() {
        return solventId;
    }

    @Override
    public void setId(Long id) {
        this.solventId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.SOLVENT;
    }

}
