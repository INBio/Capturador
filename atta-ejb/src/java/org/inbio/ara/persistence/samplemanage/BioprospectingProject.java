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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author dasolano
 */
@Entity
@Table(name = "bioprospecting_project")
public class BioprospectingProject extends LogGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="bioprospecting_project")
    @SequenceGenerator(name="bioprospecting_project", sequenceName="bioprospecting_project_seq")
    @Basic(optional = false)
    @Column(name = "bioprospecting_project_id")
    private Long bioprospectingProjectId;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;



    public BioprospectingProject() {
    }

    public BioprospectingProject(Long bioprospectingProjectId) {
        this.bioprospectingProjectId = bioprospectingProjectId;
    }

    public BioprospectingProject(Long bioprospectingProjectId, String name, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.bioprospectingProjectId = bioprospectingProjectId;
        this.name = name;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getBioprospectingProjectId() {
        return bioprospectingProjectId;
    }

    public void setBioprospectingProjectId(Long bioprospectingProjectId) {
        this.bioprospectingProjectId = bioprospectingProjectId;
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
        hash += (bioprospectingProjectId != null ? bioprospectingProjectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BioprospectingProject)) {
            return false;
        }
        BioprospectingProject other = (BioprospectingProject) object;
        if ((this.bioprospectingProjectId == null && other.bioprospectingProjectId != null) || (this.bioprospectingProjectId != null && !this.bioprospectingProjectId.equals(other.bioprospectingProjectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.samplemanage.BioprospectingProject[bioprospectingProjectId=" + bioprospectingProjectId + "]";
    }

}
