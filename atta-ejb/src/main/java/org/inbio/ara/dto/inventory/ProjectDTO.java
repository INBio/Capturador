/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.inventory;

import java.io.Serializable;

/**
 *
 * @author esmata
 */
public class ProjectDTO implements Serializable {

    //Atributos
    private Long projectId;
    private String description;
    private String projectManagerName;

    //Constructor
    public ProjectDTO(){
    }

    /**
     * @return the projectId
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * @param projectId the projectId to set
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
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
     * @return the projectManagerName
     */
    public String getProjectManagerName() {
        return projectManagerName;
    }

    /**
     * @param projectManagerName the projectManagerName to set
     */
    public void setProjectManagerName(String projectManagerName) {
        this.projectManagerName = projectManagerName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProjectDTO other = (ProjectDTO) obj;
        if (this.projectId != other.projectId && (this.projectId == null || !this.projectId.equals(other.projectId))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (this.projectId != null ? this.projectId.hashCode() : 0);
        hash = 37 * hash + (this.description != null ? this.description.hashCode() : 0);
        hash = 37 * hash + (this.projectManagerName != null ? this.projectManagerName.hashCode() : 0);
        return hash;
    }

}
