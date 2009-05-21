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
 * TaxonAuthorConnectorBean.java
 *
 * Created on August 26, 2007, 5:13 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.taxonomy;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.inbio.ara.persistence.taxonomy.TaxonAuthorConnector;
import javax.persistence.Query;
import com.sun.data.provider.SortCriteria;

/**
 *
 * @author roaguilar
 */
@Stateless
public class TaxonAuthorConnectorBean implements org.inbio.ara.facade.taxonomy.TaxonAuthorConnectorRemote, org.inbio.ara.facade.taxonomy.TaxonAuthorConnectorLocal {
    
    @PersistenceContext
    private EntityManager em;
    private TaxonAuthorConnector taxonAuthorConnector;
    private List taxonAuthorConnectorList;    
    private String message;
    
    /** Creates a new instance of TaxonAuthorConnectorBean */
    public TaxonAuthorConnectorBean() {
        this.message = "";
    }
    
    public boolean create(TaxonAuthorConnector taxonAuthorConnector) {
        this.taxonAuthorConnector = taxonAuthorConnector;
        return persist();
    }

    public TaxonAuthorConnector getTaxonAuthorConnector() {
        return this.taxonAuthorConnector;
    }

    public boolean update(TaxonAuthorConnector taxonAuthorConnector) {
        boolean updated = false;
        if (!isTaxonAuthorConnectorNull(taxonAuthorConnector)){
            if (this.isTaxonAuthorConnectorUnique(taxonAuthorConnector)) {
                try {
                    this.taxonAuthorConnector = taxonAuthorConnector;
                    em.merge(this.taxonAuthorConnector);
                    updated = true;                
                } catch (Exception ex) {
                    this.setMessage("El registro No. " + this.taxonAuthorConnector.getId() + " ha sido modificado o borrado por otro usuario. No se realizó la modificación.");
                }
            } else {
                setMessage("Ya existe otro conector almacenado en el sistema con la misma información. El registro no fue modificado.");
            }            
        } else {
            this.setMessage(this.getMessage() + " El registro no se modificó.");
        }
        return updated;     
    }

    public List findAll() {
        Query q = em.createQuery("Select object(o) from TaxonAuthorConnector as o");
        this.taxonAuthorConnectorList = (List)q.getResultList();
        return this.taxonAuthorConnectorList;
    }
    
    public List findAll(int firstResult, int maxResults, SortCriteria[] sortCriteria) {
        String hql;
        int index;
        Query q;
        
        hql = "Select object(o) from TaxonAuthorConnector as o";
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
        this.taxonAuthorConnectorList = q.getResultList();
        return this.taxonAuthorConnectorList;
    }

    public boolean remove(Long id) {
        boolean removed = false;
        try {
            this.taxonAuthorConnector = em.find(org.inbio.ara.persistence.taxonomy.TaxonAuthorConnector.class,id);
            if (this.canDeleteTaxonAuthorConnector(this.taxonAuthorConnector)) {
                this.taxonAuthorConnector = em.merge(this.taxonAuthorConnector);
                em.remove(this.taxonAuthorConnector);
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
            
    private boolean canDeleteTaxonAuthorConnector(TaxonAuthorConnector taxonAuthorConnector) {
        boolean canDelete = true;        
        String  errorMessage = "";
        
        if (!taxonAuthorConnector.getTaxonAuthorSet() .isEmpty() ) {
            canDelete = false;
            errorMessage = "El registro No. " + taxonAuthorConnector.getId() +  " está siendo usado al menos en un registro de autores taxonómicos.";
        }
        
        if (!canDelete) errorMessage += " No es posible borrarlo.";
        this.setMessage(errorMessage);
        return canDelete;
    }
    
    private boolean isTaxonAuthorConnectorNull(TaxonAuthorConnector taxonAuthorConnector) {
        boolean isNull = false;
        String msg = "";
        if ((taxonAuthorConnector.getName() == null) || (taxonAuthorConnector.getName().equals(""))){
            isNull = true;
            msg = "El siguiente campo es obligatorio: Conector";
            setMessage(msg);
        }
        return isNull;
    }
    
    private boolean isTaxonAuthorConnectorUnique(TaxonAuthorConnector taxonAuthorConnector) {
        boolean isUnique = true;
        String tmpName, sql;
        Long tmpId;
        
        tmpName = taxonAuthorConnector.getName();
        sql = "SELECT o FROM TaxonAuthorConnector o ";
        sql = sql + "where trim(lower(name)) = trim(lower('" + tmpName +"')) ";
        if (taxonAuthorConnector.getId()!=null) {
            sql = sql + " and id <> " + taxonAuthorConnector.getId();
        }
        if (em.createQuery(sql).getResultList().size() > 0) {
            isUnique = false;
        }
        return isUnique;
    }

    private boolean persist() {
        if (!isTaxonAuthorConnectorNull(this.taxonAuthorConnector)) {
           if (isTaxonAuthorConnectorUnique(this.taxonAuthorConnector)) {
                try {
                    em.persist(this.taxonAuthorConnector);
                    return true;                
                } catch (Exception e) {
                    setMessage(e.getLocalizedMessage());
                    return false;
                }
            } else {
                setMessage("Ya existe otro conector almacenado en el sistema con el mismo nombre. El registro no fue creado.");
                return false;
            }
        } else {
            setMessage(getMessage() + " El registro no se creó.");
            return false;
        }
    }    
}
