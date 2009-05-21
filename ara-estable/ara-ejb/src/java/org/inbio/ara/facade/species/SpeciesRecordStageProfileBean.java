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
 * SpeciesRecordStageProfileBean.java
 *
 * Created on 4 de abril de 2008, 03:22 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.species;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import org.inbio.ara.persistence.species.SpeciesRecordStageProfile;

/**
 *
 * @author herson
 */
@Stateless
public class SpeciesRecordStageProfileBean implements 
            SpeciesRecordStageProfileRemote, SpeciesRecordStageProfileLocal {
    @PersistenceContext
    private EntityManager em;
    private String message;
    private SpeciesRecordStageProfile speciesRecordStageProfile;
    private List speciesRecordStageProfileList;
    
    /** Creates a new instance of SpeciesRecordStageProfileBean */
    public SpeciesRecordStageProfileBean() {
        message = "";
    }
    
    public boolean create(SpeciesRecordStageProfile speciesRecordStageProfile) {        
        this.speciesRecordStageProfile = speciesRecordStageProfile;
        return persist();
    }
    
    public boolean remove(SpeciesRecordStageProfile speciesRecordStageProfile) {
        try {     
            this.speciesRecordStageProfile = em.merge(this.speciesRecordStageProfile);
            em.remove(this.speciesRecordStageProfile);
            return true;
        } catch (Exception e) {
            this.setMessage(e.getMessage());
            return false;
        } 
    }
    
    public boolean update(SpeciesRecordStageProfile speciesRecordStageProfile){
        try {
            this.speciesRecordStageProfile = speciesRecordStageProfile;
            em.merge(this.speciesRecordStageProfile);
            return true;                
        } catch (Exception ex) {
            this.setMessage("Error modificando el registro en SpeciesRecordStageProfile");
            return false;
        }
    }

    private boolean persist() {
        try {
            em.persist(this.speciesRecordStageProfile);
            return true;                
        } catch (EntityExistsException e1) {
            this.setMessage(e1.getMessage());
            return false;
        } catch (IllegalStateException e2) {
            this.setMessage(e2.getMessage());
            return false;
        } catch (IllegalArgumentException e3) {
            this.setMessage(e3.getMessage());
            return false;
        } catch (NullPointerException e5) {
            this.setMessage(e5.getMessage());
            return false;
        }
    }
    
    public SpeciesRecordStageProfile find(long stageId, long profileId) {
        String jpql = "from SpeciesRecordStageProfile as o where " +
                      "o.speciesRecordStageProfilePK.speciesRecordStageId = " +
                      stageId + " and o.speciesRecordStageProfilePK.profileId = " +
                      profileId;
        try{
            speciesRecordStageProfile = (SpeciesRecordStageProfile) 
                                        em.createQuery(jpql).getSingleResult();
        } catch(NoResultException e){
            return null;
        }
        return speciesRecordStageProfile;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
