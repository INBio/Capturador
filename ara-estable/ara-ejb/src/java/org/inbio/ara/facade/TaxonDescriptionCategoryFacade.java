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
 * TaxonDescriptionCategoryFacade.java
 *
 * Created on June 4, 2007, 2:08 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package org.inbio.ara.facade;


import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionCategory;

/**
 *
 * @author jgutierrez
 */
@Stateless
public class TaxonDescriptionCategoryFacade implements TaxonDescriptionCategoryFacadeRemote, TaxonDescriptionCategoryFacadeLocal {
    
    @PersistenceContext
    private EntityManager em;
    private String message;
    
    /** Creates a new instance of TaxonDescriptionCategoryFacade */
    public TaxonDescriptionCategoryFacade() {
    }
    
    public void create(TaxonDescriptionCategory taxonDescriptionCategory) {
        em.persist(taxonDescriptionCategory);
    }
    
    public void edit(TaxonDescriptionCategory taxonDescriptionCategory) {
        em.merge(taxonDescriptionCategory);
    }
    
    public void destroy(TaxonDescriptionCategory taxonDescriptionCategory) {
        em.merge(taxonDescriptionCategory);
        em.remove(taxonDescriptionCategory);
    }
    
    public TaxonDescriptionCategory find(Object pk) {
        return (TaxonDescriptionCategory) em.find(TaxonDescriptionCategory.class, pk);
    }
    
    public List findAll() {
        System.out.println("findAll");
        //return em.createQuery("select object(o) from TaxonDescriptionCategory as o").getResultList();
        return em.createQuery("select object(o) from TaxonDescriptionCategory as o where o.ancestor = 0").getResultList();
    }
    
    public List getCategories(){
        System.out.println("getCategories");
        
        List categories =
                em.createQuery("select m from TaxonDescriptionCategory m order by m.sequence, m.ancestor").getResultList();
        
        System.out.println( categories.size() + " categories found:" );
        
        List result = new ArrayList();
        
        for(Object m : categories) {;
        TaxonDescriptionCategory loadedMsg = (TaxonDescriptionCategory) m;
        System.out.println(loadedMsg.getName());
        result.add((String) loadedMsg.getName());
        }
        
        
        //return categories;
        return result;
    }
    //* @return list toBeInsertItems a list of objects with [0]=id, [1]=name and [2]=sequence
    public List getChilds(Long i) {
        //List result = new ArrayList();
        
        return em.createQuery("select tdc.id, tdc.name, tdc.sequence from TaxonDescriptionCategory as tdc where tdc.ancestor = "+i+" order by tdc.sequence").getResultList();
        
        //return result;
    }
    
    public TaxonDescriptionCategory getTaxonDescriptionCategory(Long id) {
        Query q;
        try {
            q = em.createQuery("Select object(o) from TaxonDescriptionCategory as o where o.id= " + id);
            return (TaxonDescriptionCategory)q.getSingleResult();
        } catch(IllegalStateException ex1) {
            this.setMessage(ex1.getMessage());
            return null;
        } catch (IllegalArgumentException ex2) {
            this.setMessage(ex2.getMessage());
            return null;
        }
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
}