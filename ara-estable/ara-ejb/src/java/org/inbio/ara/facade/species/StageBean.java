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
 * StageBean.java
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
//import org.inbio.ara.persistence.species.SpeciesRecordStage;
import org.inbio.ara.persistence.species.TaxonDescriptionStage;
import javax.persistence.Query;
import com.sun.data.provider.SortCriteria;


/**
 *
 * @author roaguilar
 */
@Stateless
public class StageBean implements StageRemote, StageLocal {

    @PersistenceContext
    private EntityManager em;
    //private SpeciesRecordStage stage;
    private TaxonDescriptionStage stage;
    private List speciesRecordStageList;
    
    private String message;
    
    /** Creates a new instance of StageBean */
    public StageBean() {
        message = "";
    }

    //public boolean create(SpeciesRecordStage stage) {
    public boolean create(TaxonDescriptionStage stage) {
        this.stage = stage;
        return persist();
    }

    //public SpeciesRecordStage getStage() {
    public TaxonDescriptionStage getStage() {
        return this.stage;
    }

    //public boolean update(SpeciesRecordStage stage) {
    public boolean update(TaxonDescriptionStage stage) {
        boolean updated = false;
        if (!isStageNull(stage)){
            if (this.isStageUnique(stage)) {
                try {
                    this.stage = stage;
                    em.merge(this.stage);
                    updated = true;                
                } catch (Exception ex) {
                    this.setMessage("El registro No. " + this.stage.getId() + " ha sido modificado o borrado por otro usuario. No se realizó la modificación.");
                }
            } else {
                setMessage("Ya existe otra etapa almacenada en el sistema con el mismo nombre. El registro no fue modificado.");
            }            
        } else {
            this.setMessage(this.getMessage() + " El registro no se modificó.");
        }
        return updated;     
    }

    public List findAll() {
        Query q = em.createQuery("Select object(o) from SpeciesRecordStage as o");
        this.speciesRecordStageList = (List)q.getResultList();
        return this.speciesRecordStageList;
    }
    
    public List findAll(int firstResult, int maxResults, SortCriteria[] sortCriteria) {
        String hql;
        int index;
        Query q;
        
        //hql = "Select object(o) from SpeciesRecordStage as o";
        hql = "Select object(o) from TaxonRecordStage as o";
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
            //this.stage = em.find(org.inbio.ara.persistence.species.SpeciesRecordStage.class,id);
            this.stage = em.find(org.inbio.ara.persistence.species.TaxonDescriptionStage.class,id);
            if (this.canDeleteStage(this.stage)) {
                this.stage = em.merge(this.stage);
                em.remove(this.stage);
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
    
    private void setMessage (String message) {
        this.message = message;
    }
            
    //private boolean canDeleteStage(SpeciesRecordStage stage) {
    private boolean canDeleteStage(TaxonDescriptionStage stage) {
        boolean canDelete = true;        
        String  errorMessage = "";
        
        /*
        if (!stage.getSpeciesRecordSet().isEmpty()) {
            canDelete = false;
            errorMessage = "El registro No. " + stage.getId() +  " está asociado al menos a un registro de especie.";
        }
        
        if (!stage.getSpeciesRecordSet().isEmpty()) {
            canDelete = false;
            errorMessage = "El registro No. " + stage.getId() +  " está asociado al menos a un perfil.";
        }        
        
        if (!canDelete) errorMessage += " No es posible borrarlo.";
        this.setMessage(errorMessage);
         */
        return canDelete;
    }
    
    //private boolean isStageNull(SpeciesRecordStage stage) {
    private boolean isStageNull(TaxonDescriptionStage stage) {
        boolean isNull = false;
        String msg = "";
        if ((stage.getName() == null) || (stage.getName().equals(""))){
            isNull = true;
            msg = "El siguiente campo es obligatorio: Nombre";
            setMessage(msg);
        }
        return isNull;
    }
    
    //private boolean isStageUnique(SpeciesRecordStage stage) {
    private boolean isStageUnique(TaxonDescriptionStage stage) {
        boolean isUnique = true;
        String tmpName, sql;
        Long tmpId;
        
        tmpName = stage.getName();
        sql = "SELECT o FROM SpeciesRecordStage o ";
        sql = sql + "where trim(lower(name)) = trim(lower('" + tmpName +"')) ";
        if (stage.getId()!=null) {
            sql = sql + " and id <> " + stage.getId();
        }
        if (em.createQuery(sql).getResultList().size() > 0) {
            isUnique = false;
        }
        return isUnique;
    }

    private boolean persist() {
        if (!isStageNull(this.stage)) {
           if (isStageUnique(this.stage)) {
                try {
                    em.persist(this.stage);
                    return true;                
                } catch (Exception e) {
                    setMessage(e.getLocalizedMessage());
                    return false;
                }
            } else {
                setMessage("Ya existe otra etapa almacenada en el sistema con el mismo nombre. El registro no fue creado.");
                return false;
            }
        } else {
            setMessage(getMessage() + " El registro no se creó.");
            return false;
        }
    }
}
