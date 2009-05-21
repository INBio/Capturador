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
 * AudienceBean.java
 *
 * Created on August 23, 2007, 1:03 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.species;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
//import org.inbio.ara.persistence.species.Audience;
import org.inbio.ara.persistence.species.Audience;
import com.sun.data.provider.SortCriteria;


/**
 *
 * @author roaguilar
 */
@Stateless
public class AudienceBean implements AudienceRemote, AudienceLocal {

    @PersistenceContext
    private EntityManager em;
    private String message;    
    //private Audience audience;    
    private Audience audience;    
    private List userTypeList;
    
    
    /**
     * Creates a new instance of AudienceBean
     */
    public AudienceBean() {
    }

    //public boolean create(Audience userType) {
    public boolean create(Audience audience) {
        this.audience = audience;
        return persist();
    }

    //public Audience getAudience() {
    public Audience getAudience() {
        return this.audience;
    }

    //public boolean update(Audience userType) {
    public boolean update(Audience userType) {
        boolean updated = false;
        if (!isAudienceNull(userType)){
            if (this.isAudienceUnique(userType)) {
                try {
                    this.audience = userType;
                    em.merge(this.audience);
                    updated = true;                
                } catch (Exception ex) {
                    this.setMessage("El registro No. " + this.audience.getId() + " ha sido modificado o borrado por otro usuario. No se realiz� la modificaci�n.");
                }
            } else {
                setMessage("Ya existe otro p�blico meta almacenado en el sistema con el mismo nombre. El registro no fu� modificado.");
            }            
        } else {
            this.setMessage(this.getMessage() + " El registro no se modific�.");
        }
        return updated;     
    }

    public List findAll() {
        Query q = em.createQuery("Select object(o) from Audience as o order by o.name");
        this.userTypeList = (List)q.getResultList();
        return this.userTypeList;
    }
    
    public List findAll(int firstResult, int maxResults, SortCriteria[] sortCriteria) {
        String hql;
        int index;
        Query q;
        
        hql = "Select object(o) from Audience as o";
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
        return q.getResultList();
    }

    public boolean remove(Long id) {
        boolean removed = false;
        try {
            //this.audience = em.find(org.inbio.ara.persistence.species.Audience.class,id);
            this.audience = em.find(org.inbio.ara.persistence.species.Audience.class,id);
            if (this.canDeleteAudience(this.audience)) {
                this.audience = em.merge(this.audience);
                em.remove(this.audience);
                removed = true;
            }
        } catch (Exception e) {
            this.setMessage(e.getMessage());
            removed = false;
        }
        return removed;     
    }

    public String getMessage() {
        return this.message;
    }

    private boolean persist() {
        if (!isAudienceNull(this.audience)) {
           if (isAudienceUnique(this.audience)) {
                try {
                    em.persist(this.audience);
                    return true;                
                } catch (Exception e) {
                    setMessage(e.getLocalizedMessage());
                    return false;
                }
            } else {
                setMessage("Ya existe otro p�blico meta almacenado en el sistema con el mismo nombre. El registro no fu� creado.");
                return false;
            }
        } else {
            setMessage(getMessage() + " El registr� no se cre�.");
            return false;
        }
    }
    
    //private boolean canDeleteAudience(Audience userType) {
    private boolean canDeleteAudience(Audience userType) {
        boolean canDelete = true;        
        String  errorMessage = "";
               
        //if (em.createQuery().createNamedQuery("select * from taxon_description_audience where audience_id = " + userType.getId()).getResultList().size() > 0) {
        if (em.createQuery("select object(o) from TaxonDescriptionAudience as o where o.taxonDescriptionAudiencePK.audienceId = " + userType.getId()).getResultList().size() >0) {
            canDelete = false;
            errorMessage = "El registro No. " + this.audience.getId() +  " está asociado al menos a un registro de especies. No es posible borrarlo.";
        }
        /*
        if (!userType.getSpeciesRecordAudienceSet().isEmpty()) {
            canDelete = false;
             errorMessage = "El registro No. " + this.audience.getId() +  " est� asociado al menos a un registro de especies. No es posible borrarlo.";
        }
        this.setMessage(errorMessage);
         */
        this.setMessage(errorMessage);
        return canDelete;
    }
    
    //private boolean isAudienceNull(Audience userType) {
    private boolean isAudienceNull(Audience audience) {
        boolean isNull = false;
        String msg = "";
        //if ((userType.getName() == null) || (userType.getName().equals(""))){
        if ((audience.getName() == null) || (audience.getName().equals(""))){
            isNull = true;
            msg = "El siguiente campo es obligatorio: Nombre";
            setMessage(msg);
        }
        return isNull;
    }
    
    //private boolean isAudienceUnique(Audience userType) {
    private boolean isAudienceUnique(Audience audience) {
        boolean isUnique = true;
        String tmpName, sql;
        Long tmpId;
        
        tmpName = audience.getName();
        sql = "SELECT o FROM Audience o ";
        sql = sql + "where trim(lower(name)) = trim(lower('" + tmpName +"')) ";
        if (audience.getId()!=null) {
            sql = sql + " and id <> " + audience.getId();
        }
        if (em.createQuery(sql).getResultList().size() > 0) {
            isUnique = false;
        }
        return isUnique;
    }
    
    private void setMessage(String message) {
        this.message = message;
    }
}
