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
 * ProfileBean.java
 *
 * Created on August 20, 2007, 10:57 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.profile;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.inbio.ara.persistence.person.Profile;
import javax.persistence.Query;
import com.sun.data.provider.SortCriteria;
import javax.persistence.EntityExistsException;
/**
 *
 * @author roaguilar
 */
@Stateless
public class ProfileBean implements ProfileRemote, ProfileLocal {
  
    
    @PersistenceContext
    private EntityManager em;
    private String message;    
    private Profile profile;    
    private List profileList;
    
    /** Creates a new instance of ProfileBean */
    public ProfileBean() {
    }

    public boolean create(Profile profile) {
        this.profile = profile;
        return persist();
    }
    
    private boolean persist() {
        if (!isProfileNull(this.profile)) {
           if (isProfileUnique(this.profile)) {
                try {
                    em.persist(this.profile);
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
            } else {
                setMessage("Ya existe otro perfil almacenado en el sistema con el mismo nombre. El registro no fue creado.");
                return false;
            }
        } else {
            setMessage(getMessage() + " El registro no se creó.");
            return false;
        }
    }
    
    public boolean remove(Long id) {
        boolean removed = false;
        try {
            this.profile = em.find(Profile.class,id);
            if (this.canDeleteProfile(this.profile)) {
                this.profile = em.merge(this.profile);
                em.remove(this.profile);
                removed = true;
            }
        } catch (Exception e) {
            this.setMessage(e.getMessage());
            removed = false;
        }
        return removed;     
    }

    public boolean update(Profile profile) {
        boolean updated = false;
        if (!isProfileNull(profile)){
            if (this.isProfileUnique(profile)) {
                try {
                    this.profile = profile;
                    //this.profile.setCreatedBy(userBean.getUserName());
                    //this.profile.setLastModificationBy(userBean.getUserName());
                    em.merge(this.profile);
                    updated = true;                
                } catch (Exception ex) {
                    this.setMessage("El registro No. " + this.profile.getId() + " ha sido modificado o borrado por otro usuario. No se realizo la modificación.");
                }
            } else {
                setMessage("Ya existe otro perfil almacenado en el sistema con el mismo nombre. El registro no fue modificado.");
            }            
        } else {
            this.setMessage(this.getMessage() + " El registro no se modificó.");
        }
        return updated;     
    }


    public List findAll() {
        Query q = em.createQuery("Select object(o) from Profile as o");
        this.profileList = (List)q.getResultList();
        return this.profileList;
    }
    
    public List findAll(int firstResult, int maxResults, SortCriteria[] sortCriteria) {
        String hql;
        int index;
        Query q;
        
        hql = "Select object(o) from Profile as o";
        if (sortCriteria!=null) {
            hql += " order by ";
            for (index =0; index < sortCriteria.length; index++) {
                if (index > 0) {
                    hql += ", ";
                }
                hql += "o." + sortCriteria[index];
            }
            if(!sortCriteria[0].isAscending()){
                hql += " desc";
            }
        }
        q = em.createQuery(hql);
        q.setFirstResult(firstResult);
        q.setMaxResults(maxResults);
        this.profileList = (List)q.getResultList();
        return this.profileList;
    }
    
    private boolean canDeleteProfile(Profile profile) {
        boolean canDelete = true;        
        String  errorMessage = "";
        
        if (!profile.getPersonProfileSet().isEmpty()) {
            canDelete = false;
            //errorMessage = "El registro No. " + this.profile.getId() +  " tiene personas asociadas.";
            if (errorMessage.equals("")) {
                errorMessage = "personas";
            } else {
                errorMessage += ", personas";
            }
        }
        
        if (this.profileHasTaxonDescription(profile) == true) {
            canDelete = false;
            if (errorMessage.equals("")) {
                errorMessage = "registros de especies";
            } else {
                errorMessage += ", registros de especies";
            }
        }
        
        if (!canDelete) errorMessage = "El registro no fue borrado pues está asociado a las siguientes entidades: " + errorMessage + ".";
        this.setMessage(errorMessage);
        return canDelete;
    }
    
    
    private boolean profileHasTaxonDescription(Profile tProfile) {
        try {
            System.out.println("Select object(o) from TaxonDescriptionPersonProfile as o where o.taxonDescriptionPersonProfilePK.profileId  = " + tProfile.getId());
            Query q = em.createQuery("Select object(o) from TaxonDescriptionPersonProfile as o where o.taxonDescriptionPersonProfilePK.authorProfileId  = " + tProfile.getId());
            if (q.getResultList().size() > 0) {
                System.out.println(q.getResultList().size());
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            this.setMessage(e.getMessage());
            System.out.println(this.message);
            return true;
        } catch (Throwable ex) {
            this.setMessage(ex.getLocalizedMessage());
            System.out.println(this.message);
            return true;
        }
    }
    
    private boolean isProfileUnique(Profile profile) {
        boolean isUnique = true;
        String tmpName, sql;
        Long tmpId;
        
        tmpName = profile.getName();
        sql = "SELECT o FROM Profile o ";
        sql = sql + "where trim(lower(name)) = trim(lower('" + tmpName +"')) ";
        if (profile.getId()!=null) {
            sql = sql + " and id <> " + profile.getId();
        }
        if (em.createQuery(sql).getResultList().size() > 0) {
            isUnique = false;
        }
        return isUnique;
    }
    
    private boolean isProfileNull(Profile profile) {
        boolean isNull = false;
        String msg = "";
        if ((profile.getName() == null) || (profile.getName().equals(""))){
            isNull = true;
            msg = "El siguiente campo es obligatorio: Nombre";
            setMessage(msg);
        }
        return isNull;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void businessMethod() {
        //TODO implement businessMethod
    }
}
