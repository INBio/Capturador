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

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.*;
import org.inbio.ara.persistence.GenericEntity;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "project")

public class Project extends LogGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
        @GeneratedValue(strategy=GenerationType.AUTO, generator="Project")
	@SequenceGenerator(name="Project", sequenceName="project_seq")
    @Basic(optional = false)
    @Column(name = "project_id")
    private Long projectId;

    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    
    @Basic(optional = false)
    @Column(name = "project_manager_name")
    private String projectManagerName;

    @Column(name = "initial_date")
    @Temporal(TemporalType.DATE)
    private Calendar initialDate;

    @Column(name = "final_date")
    @Temporal(TemporalType.DATE)
    private Calendar finalDate;

    
    
    public Project() {
    }

    public Project(Long projectId) {
        this.projectId = projectId;
    }

    public Project(Long projectId, String description, String projectManagerName, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.projectId = projectId;
        this.description = description;
        this.projectManagerName = projectManagerName;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
        

    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectManagerName() {
        return projectManagerName;
    }

    public void setProjectManagerName(String projectManagerName) {
        this.projectManagerName = projectManagerName;
    }

    public Calendar getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Calendar initialDate) {
        this.initialDate = initialDate;
        
    }

    public Calendar getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Calendar finalDate) {
        this.finalDate = finalDate;
        
    }
    
    public String getStringInitialDate()
    {
        return initialDate.toString();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectId != null ? projectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.projectId == null && other.projectId != null) || (this.projectId != null && !this.projectId.equals(other.projectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.gathering.Project[projectId=" + projectId + "]";
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param stringInitialDate the stringInitialDate to set
     */
    public String getDateToString(Calendar date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        String result = null;
        if (date != null) {
         result = sdf.format(date.getTime());
        }
        return result;
    }

  
}
