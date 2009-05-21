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
 * TaxonCategoryBean.java
 *
 * Created on August 26, 2007, 7:34 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.taxonomy;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.inbio.ara.persistence.taxonomy.TaxonCategory;
import javax.persistence.Query;
import com.sun.data.provider.SortCriteria;

/**
 *
 * @author roaguilar
 */
@Stateless
public class TaxonCategoryBean implements org.inbio.ara.facade.taxonomy.TaxonCategoryRemote, org.inbio.ara.facade.taxonomy.TaxonCategoryLocal {
    
    @PersistenceContext
    private EntityManager em;
    private TaxonCategory taxonCategory;
    private List taxonCategoryList;    
    private String message;
    
    /** Creates a new instance of TaxonCategoryBean */
    public TaxonCategoryBean() {
        this.message = "";
    }
    
    public boolean create(TaxonCategory taxonCategory) {
        this.taxonCategory = taxonCategory;
        return persist();
    }

    public TaxonCategory getTaxonCategory() {
        return this.taxonCategory;
    }

    public boolean update(TaxonCategory taxonCategory) {
        boolean updated = false;
        if (!isTaxonCategoryNull(taxonCategory)){
            if (this.isTaxonCategoryUnique(taxonCategory)) {
                try {
                    this.taxonCategory = taxonCategory;
                    em.merge(this.taxonCategory);
                    updated = true;                
                } catch (Exception ex) {
                    this.setMessage("El registro No. " + this.taxonCategory.getId() + " ha sido modificado o borrado por otro usuario. No se realizó la modificación.");
                }
            } else {
                setMessage("Ya existe otra categoría almacenada en el sistema con la misma información. El registro no fué modificado.");
            }            
        } else {
            this.setMessage(this.getMessage() + " El registro no se modificó.");
        }
        return updated;     
    }

    public List findAll() {
        Query q = em.createQuery("Select object(o) from TaxonCategory as o");
        this.taxonCategoryList = (List)q.getResultList();
        return this.taxonCategoryList;
    }
    
    public List findAll(int firstResult, int maxResults, SortCriteria[] sortCriteria) {
        String hql;
        int index;
        Query q;
        
        hql = "Select object(o) from TaxonCategory as o";
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
        this.taxonCategoryList = q.getResultList();
        return this.taxonCategoryList;
    }

    public boolean remove(Long id) {
        boolean removed = false;
        try {
            this.taxonCategory = em.find(org.inbio.ara.persistence.taxonomy.TaxonCategory.class,id);
            if (this.canDeleteTaxonCategory(this.taxonCategory)) {
                this.taxonCategory = em.merge(this.taxonCategory);
                em.remove(this.taxonCategory);
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
            
    private boolean canDeleteTaxonCategory(TaxonCategory taxonCategory) {
        boolean canDelete = true;        
        String  errorMessage = "";
        
        if (!taxonCategory.getTaxonSet().isEmpty() ) {
            canDelete = false;
            errorMessage = "El registro No. " + taxonCategory.getId() +  " está siendo usado al menos en un registro de Taxón.";
        }
        
        if (!canDelete) errorMessage += " No es posible borrarlo.";
        this.setMessage(errorMessage);
        return canDelete;
    }
    
    private boolean isTaxonCategoryNull(TaxonCategory taxonCategory) {
        boolean isNull = false;
        String msg = "";
        if ((taxonCategory.getName() == null) || (taxonCategory.getName().equals(""))){
            isNull = true;
            msg = "El siguiente campo es obligatorio: Nombre";
            setMessage(msg);
        }
        return isNull;
    }
    
    private boolean isTaxonCategoryUnique(TaxonCategory taxonCategory) {
        boolean isUnique = true;
        String tmpName, sql;
        Long tmpId;
        
        tmpName = taxonCategory.getName();
        sql = "SELECT o FROM TaxonCategory o ";
        sql = sql + "where trim(lower(name)) = trim(lower('" + tmpName +"')) ";
        if (taxonCategory.getId()!=null) {
            sql = sql + " and id <> " + taxonCategory.getId();
        }
        if (em.createQuery(sql).getResultList().size() > 0) {
            isUnique = false;
        }
        return isUnique;
    }

    private boolean persist() {
        if (!isTaxonCategoryNull(this.taxonCategory)) {
           if (isTaxonCategoryUnique(this.taxonCategory)) {
                try {
                    em.persist(this.taxonCategory);
                    return true;                
                } catch (Exception e) {
                    setMessage(e.getLocalizedMessage());
                    return false;
                }
            } else {
                setMessage("Ya existe otra categoría almacenada en el sistema con el mismo nombre. El registro no fué creado.");
                return false;
            }
        } else {
            setMessage(getMessage() + " El registró no se creó.");
            return false;
        }
    }
    
    public TaxonCategory findTaxonCategoryById(Object id) {
        return (TaxonCategory) em.createNamedQuery("TaxonCategory.findByTaxonCategoryId").setParameter("taxonCategoryId", id).getSingleResult();
    }     
}