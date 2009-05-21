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
 * DataTypeBean.java
 *
 * Created on August 26, 2007, 2:50 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.taxonomy;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionDataType;
import javax.persistence.Query;
import com.sun.data.provider.SortCriteria;
/**
 *
 * @author roaguilar
 */
@Stateless
public class DataTypeBean implements org.inbio.ara.facade.taxonomy.DataTypeRemote, org.inbio.ara.facade.taxonomy.DataTypeLocal {
    
    @PersistenceContext
    private EntityManager em;
    private TaxonDescriptionDataType dataType;
    private List dataTypeList;    
    private String message;
    
    /** Creates a new instance of StageBean */
    public DataTypeBean() {
        message = "";
    }

    public boolean create(TaxonDescriptionDataType dataType) {
        this.dataType = dataType;
        return persist();
    }

    public TaxonDescriptionDataType getDataType() {
        return this.dataType;
    }

    public boolean update(TaxonDescriptionDataType dataType) {
        boolean updated = false;
        if (!isDataTypeNull(dataType)){
            if (this.isDataTypeUnique(dataType)) {
                try {
                    this.dataType = dataType;
                    em.merge(this.dataType);
                    updated = true;                
                } catch (Exception ex) {
                    this.setMessage("El registro No. " + this.dataType.getId() + " ha sido modificado o borrado por otro usuario. No se realizo la modificación.");
                }
            } else {
                setMessage("Ya existe otro tipo de dato almacenado en el sistema con el mismo nombre. El registro no fue modificado.");
            }            
        } else {
            this.setMessage(this.getMessage() + " El registro no se modifico.");
        }
        return updated;     
    }

    public List findAll() {
        Query q = em.createQuery("Select object(o) from TaxonDescriptionDataType as o");
        this.dataTypeList = (List)q.getResultList();
        return this.dataTypeList;
    }
    
    public List findAll(int firstResult, int  maxResults, SortCriteria[] sortCriteria) {
        String hql;
        int index;
        Query q;
        
        hql = "Select object(o) from TaxonDescriptionDataType as o";
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
            this.dataType = em.find(org.inbio.ara.persistence.taxonomy.TaxonDescriptionDataType.class,id);
            if (this.canDeleteDataType(this.dataType)) {
                this.dataType = em.merge(this.dataType);
                em.remove(this.dataType);
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
            
    private boolean canDeleteDataType(TaxonDescriptionDataType dataType) {
        boolean canDelete = true;        
        String  errorMessage = "";
        
        if (!dataType.getTaxonDescriptionElementSet().isEmpty() ) {
            canDelete = false;
            errorMessage = "El registro No. " + dataType.getId() +  " está asociado al menos a un taxon description element.";
        }
        
        if (!canDelete) errorMessage += " No es posible borrarlo.";
        this.setMessage(errorMessage);
        return canDelete;
    }
    
    private boolean isDataTypeNull(TaxonDescriptionDataType dataType) {
        boolean isNull = false;
        String msg = "";
        if ((dataType.getName() == null) || (dataType.getName().equals(""))){
            isNull = true;
            msg = "El siguiente campo es obligatorio: Nombre";
            setMessage(msg);
        }
        return isNull;
    }
    
    private boolean isDataTypeUnique(TaxonDescriptionDataType dataType) {
        boolean isUnique = true;
        String tmpName, sql;
        Long tmpId;
        
        tmpName = dataType.getName();
        sql = "SELECT o FROM TaxonDescriptionDataType o ";
        sql = sql + "where trim(lower(name)) = trim(lower('" + tmpName +"')) ";
        if (dataType.getId()!=null) {
            sql = sql + " and id <> " + dataType.getId();
        }
        if (em.createQuery(sql).getResultList().size() > 0) {
            isUnique = false;
        }
        return isUnique;
    }

    private boolean persist() {
        if (!isDataTypeNull(this.dataType)) {
           if (isDataTypeUnique(this.dataType)) {
                try {
                    em.persist(this.dataType);
                    return true;                
                } catch (Exception e) {
                    setMessage(e.getLocalizedMessage());
                    return false;
                }
            } else {
                setMessage("Ya existe otro tipo de dato almacenado en el sistema con el mismo nombre. El registro no fue creado.");
                return false;
            }
        } else {
            setMessage(getMessage() + " El registro no se creó.");
            return false;
        }
    }
}
