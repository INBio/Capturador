/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.samplemanage;

import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.persistence.SelectionListGenericEntity;

/**
 *
 * @author dasolano
 */
@Entity
@Table(name = "micro_fome")
public class MicroFome extends SelectionListGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="micro_fome")
    @SequenceGenerator(name="micro_fome", sequenceName="micro_fome_seq")
    @Basic(optional = false)
    @Column(name = "micro_fome_id")
    private Long microFomeId;
    
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;


    public MicroFome() {
    }

    public MicroFome(Long microFomeId) {
        this.microFomeId = microFomeId;
    }

    public MicroFome(Long microFomeId, String name, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.microFomeId = microFomeId;
        this.name = name;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getMicroFomeId() {
        return microFomeId;
    }

    public void setMicroFomeId(Long microFomeId) {
        this.microFomeId = microFomeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (microFomeId != null ? microFomeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MicroFome)) {
            return false;
        }
        MicroFome other = (MicroFome) object;
        if ((this.microFomeId == null && other.microFomeId != null) || (this.microFomeId != null && !this.microFomeId.equals(other.microFomeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.samplemanage.MicroFome[microFomeId=" + microFomeId + "]";
    }

    @Override
    public Long getId() {
        return this.microFomeId;
    }

    @Override
    public void setId(Long id) {
        this.microFomeId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.MICRO_FOME;
    }

}
