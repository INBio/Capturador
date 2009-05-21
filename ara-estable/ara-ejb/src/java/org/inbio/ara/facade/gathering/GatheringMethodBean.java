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
 * GatheringMethodBean.java
 *
 * Created on November 4, 2007, 8:10 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.gathering;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.inbio.ara.persistence.gathering.GatheringObservationMethod;

/**
 *
 * @author roaguilar
 */
@Stateless
public class GatheringMethodBean implements GatheringMethodRemote, GatheringMethodLocal {

    @PersistenceContext
    private EntityManager em;
    private String message;
    private GatheringObservationMethod gatheringMethod;
    private List gatheringMethodList;
    
    /** Creates a new instance of GatheringMethodBean */
    public GatheringMethodBean() {
    }

    public boolean persist() {
            try {
                em.persist(this.gatheringMethod);
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
    
    public boolean create(GatheringObservationMethod gatheringMethod, Long[] collection) {
        this.setGatheringMethod(gatheringMethod);
        return this.persist();
    }
    
    public boolean remove(Long id) {
        boolean removed = false;
        try {
            this.gatheringMethod = em.find(GatheringObservationMethod.class,id);
            if (this.canDeleteGatheringMethod(this.gatheringMethod)) {
                this.gatheringMethod = em.merge(this.gatheringMethod);
                em.remove(this.gatheringMethod);
                removed = true;
            }
        } catch (Exception e) {
            this.setMessage(e.getMessage());
            removed = false;
        }
        return removed;     
    }
    
    public boolean update(GatheringObservationMethod gatheringMethod, Long[] collection) {
        boolean updated = false;
        if (!isGatheringMethodNull(this.gatheringMethod)){
            if (this.isGatheringMethodUnique(this.gatheringMethod)) {
                try {
                    this.setGatheringMethod(gatheringMethod);
                    em.merge(this.gatheringMethod);
                    updated = true;                
                } catch (Exception ex) {
                    this.setMessage("El registro No. " + this.gatheringMethod.getId() + " ha sido modificado o borrado por otro usuario. No se realizó la modificación.");
                }
            } else {
                setMessage("Ya existe otra etapa almacenada en el sistema con el mismo nombre. El registro no fue modificado.");
            }            
        } else {
            this.setMessage(this.getMessage() + " El registro no se modificó.");
        }
        return updated;     
    }

    public GatheringObservationMethod getGatheringMethod(Long id) {
        this.setGatheringMethod(em.find(GatheringObservationMethod.class,id));
        return this.gatheringMethod;
    }
    
    public List getGatheringMethodList () {
        String hql = "";
        int index;
        Query q;
        
        try {
            hql = "Select object(o) from GatheringMethod as o order by o.name";
            q = em.createQuery(hql);
            this.setGatheringMethodList(q.getResultList());
        } catch (IllegalStateException illegalStateException) {
            setMessage("Conexión a la base de datos cerrada");
        } catch (IllegalArgumentException illegalArgumentException) {
            setMessage("Consulta inválida:" + hql);
        }
        return this.gatheringMethodList;
    }
    
    public List getGatheringMethodList(Long collectionId) {
        String hql = "";
        int index;
        Query q;
        
        try {
            hql = "Select object(o) from GatheringMethod as o, gatheringMethodCollection as p ";
            hql+= "where o.id = p.gatheringMethodCollectionPK.gatheringMethodId and ";
            hql+= "pgatheringMethodCollectionPK.collectionId = " + collectionId + " .order by o.name";
            q = em.createQuery(hql);
            this.setGatheringMethodList(q.getResultList());
        } catch (IllegalStateException illegalStateException) {
            setMessage("Conexión a la base de datos cerrada");
        } catch (IllegalArgumentException illegalArgumentException) {
            setMessage("Consulta inválida:" + hql);
        }
        return this.gatheringMethodList;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public GatheringObservationMethod getGatheringMethod() {
        return gatheringMethod;
    }

    public void setGatheringMethod(GatheringObservationMethod gatheringMethod) {
        this.gatheringMethod = gatheringMethod;
    }

    public void setGatheringMethodList(List gatheringMethodList) {
        this.gatheringMethodList = gatheringMethodList;
    }
    
    private boolean canDeleteGatheringMethod(GatheringObservationMethod gatheringMethod) {
        boolean canDelete = true;        
        String  errorMessage = "";
        int count = 0;
        String hql = "";
        Query q;
        
        try {
            hql = "Select object(o) from Gathering as o where o.gatheringMethod.id = " + this.gatheringMethod.getId();
            q = em.createQuery(hql);
            count = q.getResultList().size();
        } catch (IllegalStateException illegalStateException) {
            setMessage("Conexión a la base de datos cerrada");
        } catch (IllegalArgumentException illegalArgumentException) {
            setMessage("Consulta inválida:" + hql);
        }
       
        if (count > 0 ) {
            canDelete = false;
            errorMessage = "El registro No. " + this.gatheringMethod.getId() +  " está asociado al menos a un registro de recolección.";
        }
        return canDelete;
    }
    
    private boolean isGatheringMethodNull(GatheringObservationMethod gatheringMethod) {
        boolean isNull = false;
        String msg = "";
        if ((gatheringMethod.getName() == null) || (gatheringMethod.getName().equals(""))){
            isNull = true;
            msg = "El siguiente campo es obligatorio: Nombre";
            setMessage(msg);
        }
        return isNull;
    }
    
    private boolean isGatheringMethodUnique(GatheringObservationMethod gatheringMethod) {
        boolean isUnique = true;
        String tmpName, sql;
        Long tmpId;
        
        tmpName = gatheringMethod.getName();
        sql = "SELECT o FROM GatheringMethod o ";
        sql = sql + "where trim(lower(name)) = trim(lower('" + tmpName +"')) ";
        if (gatheringMethod.getId()!=null) {
            sql = sql + " and id <> " + gatheringMethod.getId();
        }
        if (em.createQuery(sql).getResultList().size() > 0) {
            isUnique = false;
        }
        return isUnique;
    }
}
