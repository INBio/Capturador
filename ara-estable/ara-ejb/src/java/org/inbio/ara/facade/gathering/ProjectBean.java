/* Ara - capture species and specimen data
 * 
 * Copyright (C) 2009  INBio ( Instituto Naciona de Biodiversidad )
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
/*
 * ProjectBean.java
 *
 * Created on November 4, 2007, 10:41 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.gathering;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.inbio.ara.persistence.gathering.Project;

/**
 *
 * @author roaguilar
 */
@Stateless
public class ProjectBean implements ProjectRemote, ProjectLocal {

    @PersistenceContext
    private EntityManager em;
    private Project project;
    private List projectList;
    private String message;
    
    
    /** Creates a new instance of ProjectBean */
    public ProjectBean() {
    }
    
    public boolean create(Project project) {
        return false;
    }
    
    public boolean update(Project porject) {
        return false;
    }
    
    public boolean remove(Long id) {
        return false;
    }
    
    public Project getProject() {
        return this.project;
    }
    
    public List getProjectList() {
        return this.projectList;
    }
    
    public Project getProject(Long id) {
        return this.project;
    }
    
    private boolean isProjectNull(Project project){
        return false;
    }
    
    private boolean isProjectUnique(Project project) {
        return false;
    }
    
    private boolean canDeleteProject() {
        return false;
    }
    
    public void persist() {
        // TODO:
        // em.persist(object);
    }
    
}
