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
 * TaxonomicalRangeBean.java
 *
 * Created on August 26, 2007, 5:45 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.taxonomy;

import com.sun.mail.util.QDecoderStream;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.inbio.ara.persistence.taxonomy.TaxonomicalRange;
import javax.persistence.Query;
import com.sun.data.provider.SortCriteria;

/**
 *
 * @author roaguilar
 */
@Stateless
public class TaxonomicalRangeBean implements org.inbio.ara.facade.taxonomy.TaxonomicalRangeRemote, org.inbio.ara.facade.taxonomy.TaxonomicalRangeLocal {
    
    @PersistenceContext
    private EntityManager em;
    private TaxonomicalRange taxonomicalRange;
    private List taxonomicalRangeList;    
    private String message;
    
    /** Creates a new instance of TaxonomicalRangeBean */
    public TaxonomicalRangeBean() {
        this.message = "";
    }
    
    public boolean create(TaxonomicalRange taxonomicalRange) {
        this.taxonomicalRange = taxonomicalRange;
        return persist();
    }

    public TaxonomicalRange getTaxonomicalRange() {
        return this.taxonomicalRange;
    }

    public boolean update(TaxonomicalRange taxonomicalRange) {
        boolean updated = false;
        if (!isTaxonomicalRangeNull(taxonomicalRange)){
            if (this.isTaxonomicalRangeUnique(taxonomicalRange)) {
                try {
                    this.taxonomicalRange = taxonomicalRange;
                    em.merge(this.taxonomicalRange);
                    updated = true;                
                } catch (Exception ex) {
                    this.setMessage("El registro No. " + this.taxonomicalRange.getId() + " ha sido modificado o borrado por otro usuario. No se realizó la modificación.");
                }
            } else {
                setMessage("Ya existe otro nivel taxonómico almacenado en el sistema con la misma información. El registro no fué modificado.");
            }            
        } else {
            this.setMessage(this.getMessage() + " El registro no se modificó.");
        }
        return updated;     
    }

    public List findAll() {
        Query q = em.createQuery("Select object(o) from TaxonomicalRange as o");
        this.taxonomicalRangeList = (List)q.getResultList();
        return this.taxonomicalRangeList;
    }
    
    public List findAll(int firstResult, int maxResults, SortCriteria[] sortCriteria) {
        String hql;
        int index;
        Query q;
        
        hql = "Select object(o) from TaxonomicalRange as o";
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
        this.taxonomicalRangeList = q.getResultList();
        return this.taxonomicalRangeList;
    }

    public boolean remove(Long id) {
        boolean removed = false;
        try {
            this.taxonomicalRange = em.find(org.inbio.ara.persistence.taxonomy.TaxonomicalRange.class,id);
            if (this.canDeleteTaxonomicalRange(this.taxonomicalRange)) {
                this.taxonomicalRange = em.merge(this.taxonomicalRange);
                em.remove(this.taxonomicalRange);
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
            
    private boolean canDeleteTaxonomicalRange(TaxonomicalRange taxonomicalRange) {
        boolean canDelete = true;        
        String  errorMessage = "";
        
        if (!taxonomicalRange.getTaxonSet().isEmpty() ) {
            canDelete = false;
            errorMessage = "El registro No. " + taxonomicalRange.getId() +  " está siendo usado al menos en un registro de taxón.";
        }
        
        if (!canDelete) errorMessage += " No es posible borrarlo.";
        this.setMessage(errorMessage);
        return canDelete;
    }
    
    private boolean isTaxonomicalRangeNull(TaxonomicalRange taxonomicalRange) {
        boolean isNull = false;
        String msg = "";
        if ((taxonomicalRange.getName() == null) || (taxonomicalRange.getName().equals(""))){
            isNull = true;
            msg = "Conector";
            setMessage(msg);
        }
        if (taxonomicalRange.getParenthesis () == null){
            isNull = true;
            msg += " Usa paréntesis";
            setMessage(msg);
        }        
        if ((taxonomicalRange.getTaxonomicalRangeCategory () == null) || (taxonomicalRange.getTaxonomicalRangeCategory().equals(""))){
            isNull = true;
            msg += " Categoría de Nivel Taxonómico";
            setMessage(msg);
        }
        if (taxonomicalRange.getMandatoryLevel() == null){
            isNull = true;
            msg += " Nivel Obligatorio";
            setMessage(msg);
        }
        msg = "Los siguientes datos son obligatorios : " + msg;  
        return isNull;
    }
    
    private boolean isTaxonomicalRangeUnique(TaxonomicalRange taxonomicalRange) {
        boolean isUnique = true;
        String tmpName, sql;
        Long tmpId;
        
        tmpName = taxonomicalRange.getName();
        sql = "SELECT o FROM TaxonomicalRange o ";
        sql = sql + "where trim(lower(name)) = trim(lower('" + tmpName +"')) ";
        if (taxonomicalRange.getId()!=null) {
            sql = sql + " and id <> " + taxonomicalRange.getId();
        }
        if (em.createQuery(sql).getResultList().size() > 0) {
            isUnique = false;
        }
        return isUnique;
    }

    private boolean persist() {
        if (!isTaxonomicalRangeNull(this.taxonomicalRange)) {
           if (isTaxonomicalRangeUnique(this.taxonomicalRange)) {
                try {
                    em.persist(this.taxonomicalRange);
                    return true;                
                } catch (Exception e) {
                    setMessage(e.getLocalizedMessage());
                    return false;
                }
            } else {
                setMessage("Ya existe otro nivel taxonómico almacenado en el sistema con el mismo nombre. El registro no fué creado.");
                return false;
            }
        } else {
            setMessage(getMessage() + " El registró no se creó.");
            return false;
        }
    }        
    
    public TaxonomicalRange findTaxonomicalRangeById(Object id) {
        return (TaxonomicalRange) em.createNamedQuery("TaxonomicalRange.findByTaxonomicalRangeId").setParameter("taxonRangeId", id).getSingleResult();
    }    
}
