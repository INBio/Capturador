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
 * TaxonServiceBean.java
 *
 * Created on September 28, 2007, 10:26 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.taxon.service;

import com.sun.data.provider.SortCriteria;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.inbio.ara.persistence.taxonomy.Taxon;



/**
 *
 * @author mvargas
 */
@Stateless
public class TaxonServiceBean implements org.inbio.ara.taxon.service.TaxonServiceLocal, org.inbio.ara.taxon.service.TaxonServiceRemote {
    
    @PersistenceContext
    private EntityManager em;    
    private String message;    
    private Taxon taxon;    
    private List taxonList;    
    
    /** Creates a new instance of TaxonServiceBean */
    public TaxonServiceBean() {
        this.taxon = null;
        this.message = "";        
    }
    
    public boolean persist() {
        if (!isTaxonNull(this.taxon)){
            if (isTaxonUnique(this.taxon)) {
                try {
                    em.persist(this.taxon);
                    System.out.println("Taxon creado en la base de datos");
                    return true;                
                } catch (Exception e) {
                    setMessage(e.getLocalizedMessage());
                    System.out.println("Taxon no creado " + e.getLocalizedMessage());
                    return false;
                }
            } else {
                setMessage("Ya existe este taxon. El registro no fué creado.");
                System.out.println("Taxon no creado.  Ya existe este taxon.");
                return false;
            }
        } else {
            this.setMessage(this.getMessage() + " El registro no fué creado.");
            System.out.println("Taxon no creado.  Taxon nulo.");
            return false;
        }
    }

    public boolean create(Taxon taxon) {
        this.taxon = taxon;
        return persist();
    }

    public boolean remove(Long id) {
        boolean removed = false;
        try {
            this.taxon = em.find(Taxon.class,id);
            if (this.canDeleteTaxon(this.taxon)) {
                this.taxon = em.merge(this.taxon);
                em.remove(this.taxon);
                System.out.println("Se borro el taxon: " + id);
                removed = true;
            }
        } catch (Exception e) {
            this.setMessage(e.getMessage());
            removed = false;
        }
        return removed;     
    }    
    
    public Taxon getTaxon() {
        return this.taxon;
    }    

    public List getTaxa(int startPosition, int maxResult, SortCriteria[] sc) {
        String query = "select object(o) from Taxon as o where o.taxonomicalRange.id = 18";
        // String query = "select o.id, o.defaultName from Taxon as o where o.taxonomicalRange.id = 18";
        if(sc != null){
            query = query + " " + "order by " + " " + "o."+sc[0].getCriteriaKey();
            if(!sc[0].isAscending()){
                query = query + " desc";
            }
        }
        
        Query q = em.createQuery(query);
        q.setMaxResults(maxResult);
        q.setFirstResult(startPosition);
        return q.getResultList();
    }
    
    
    public List getAllSpecies() {
        String query = "select object(o) from Taxon as o where o.taxonomicalRange.id = 18";
        
        Query q = em.createQuery(query);
        return q.getResultList();
    }    

    
    public List getSpeciesData() {
        String query;
        
        // query = "select o.taxonomicalRange.id, o.id, o.defaultName from Taxon as o";
        query = "select o.id, o.defaultName from Taxon as o";
        query = query + " " + "where o.taxonomicalRange.id = 18";
        query = query + " " + "order by o.defaultName";         
        
        query = "select o.id, o.defaultName from Taxon as o";
        query = query + " " + "where o.taxonomicalRange.id = 18";
        query = query + " " + "order by o.defaultName";         
        
        Query q = em.createQuery(query);

        return q.getResultList();
    }    
    
    
    public List getSpecies(int startPosition, int maxResult) {
        String query = "select object(o) from Taxon as o where o.taxonomicalRange.id = 18";
        // String query = "select o.id, o.defaultName from Taxon as o where o.taxonomicalRange.id = 18";
        query = query + " " + "order by o.dominiumTaxon.defaultName, o.phylumDivisionTaxon.defaultName, o.classTaxon.defaultName, o.orderTaxon.defaultName, o.familyTaxon.defaultName, o.genusTaxon.defaultName, o.defaultName";
        
        Query q = em.createQuery(query);
        q.setMaxResults(maxResult);
        q.setFirstResult(startPosition);
        return q.getResultList();
    }    
    
    public List getSpeciesIds(int startPosition, int maxResult) {
        String query = "select o.id from Taxon as o where o.taxonomicalRange.id = 18";
        // String query = "select o.id, o.defaultName from Taxon as o where o.taxonomicalRange.id = 18";
        query = query + " " + "order by o.dominiumTaxon.defaultName, o.phylumDivisionTaxon.defaultName, o.classTaxon.defaultName, o.orderTaxon.defaultName, o.familyTaxon.defaultName, o.genusTaxon.defaultName, o.defaultName";
        
        Query q = em.createQuery(query);
        q.setMaxResults(maxResult);
        q.setFirstResult(startPosition);
        return q.getResultList();
    }      
    
    public List getTaxaNames(int startPosition, int maxResult) {
        // String query = "select o.dominiumTaxon.id, o.dominiumTaxon.defaultName, o.kingdomTaxon.id, o.kingdomTaxon.defaultName, o.phylumDivisionTaxon.id, o.phylumDivisionTaxon.defaultName, o.classTaxon.id, o.classTaxon.defaultName, o.orderTaxon.id, o.orderTaxon.defaultName, o.familyTaxon.id, o.familyTaxon.defaultName, o.genusTaxon.id, o.genusTaxon.defaultName, o.id, o.defaultName from Taxon as o where o.taxonomicalRange.id = 18";
        // String query = "select o.id, o.defaultName from Taxon as o where o.taxonomicalRange.id = 18";
        // String query = "select o.dominiumTaxon.id, o.dominiumTaxon.defaultName, o.kingdomTaxon.id, o.kingdomTaxon.defaultName, o.phylumDivisionTaxon.id, o.phylumDivisionTaxon.defaultName, o.classTaxon.id, o.classTaxon.defaultName, o.orderTaxon.id, o.orderTaxon.defaultName, o.familyTaxon.id, o.familyTaxon.defaultName, o.id, o.defaultName from Taxon as o where o.taxonomicalRange.id = 13";
        // query = query + " " + "order by o.dominiumTaxon.defaultName, o.phylumDivisionTaxon.defaultName, o.classTaxon.defaultName, o.orderTaxon.defaultName, o.familyTaxon.defaultName, o.genusTaxon.defaultName, o.defaultName";

        // String query = "select o.id, o.defaultName, o.dominiumTaxon.id from Taxon as o where o.dominiumTaxon is null";
        // query = query + " " + "order by o.dominiumTaxon.defaultName, o.kingdomTaxon.defaultName";

        // String query = "select o.dominiumTaxon.id, o.dominiumTaxon.defaultName, o.kingdomTaxon.id, o.kingdomTaxon.defaultName, o.phylumDivisionTaxon.id, o.phylumDivisionTaxon.defaultName, o.classTaxon.id, o.classTaxon.defaultName, o.orderTaxon.id, o.orderTaxon.defaultName, o.familyTaxon.id, o.familyTaxon.defaultName, o.genusTaxon.id, o.genusTaxon.defaultName, o.id, o.defaultName from Taxon as o";
        // query = query + " " + "order by o.dominiumTaxon.defaultName, o.phylumDivisionTaxon.defaultName, o.classTaxon.defaultName, o.orderTaxon.defaultName, o.familyTaxon.defaultName, o.genusTaxon.defaultName, o.defaultName";

        ArrayList finalResults = new ArrayList();        

        
        String query = "select o.taxonomicalRange.id, o.id, o.defaultName from Taxon as o";
        query = query + " " + "where o.taxonomicalRange.id IN (1, 2, 4, 6)";
        query = query + " " + "order by o.taxonomicalRange.id, o.defaultName";
        
        
        Query q = em.createQuery(query);
        q.setMaxResults(maxResult);
        q.setFirstResult(startPosition);
        
        finalResults.addAll(q.getResultList());

        // return q.getResultList();
        return finalResults;
    }    

    
    public List getTheTopTaxon(long taxonId) {
        Query q;
        String query;
            
        query = "select o.taxonomicalRange.id, o.id, o.defaultName from Taxon as o";
        query = query + " " + "where o.id = :ptaxonid";
        query = query + " " + "order by o.taxonomicalRange.id, o.defaultName";            
            
        q = em.createQuery(query);
        q.setParameter("ptaxonid", taxonId);

        return q.getResultList();        
        
    }
    
    
    public int getChildCount(long taxonId) {
        String query = "select o.id from Taxon as o where o.ancestor.id = " + taxonId;
        Query q = em.createQuery(query);
        
        return q.getResultList().size();
    }
    
    
    public List getTheSons(long taxonId) {
        ArrayList sons    = new ArrayList();
        ArrayList results = new ArrayList();
        ArrayList ids     = new ArrayList();
        long rangeId;
        Query q;
        String query;
        long id;
        long rangeId2 = 0;
        String rangeName = "";
        
        
//        try {
            this.taxon = em.find(org.inbio.ara.persistence.taxonomy.Taxon.class, taxonId);
            rangeId = this.taxon.getTaxonomicalRange().getId();
            
            
            query = "select o.taxonomicalRange.id, o.id, o.defaultName from Taxon as o";
            query = query + " " + "where o.id = :ptaxonid";
            query = query + " " + "order by o.taxonomicalRange.id, o.defaultName";            
            
            q = em.createQuery(query);
            q.setParameter("ptaxonid", taxonId);
            // sons.addAll(q.getResultList());
            // System.out.println("Tamano de sons 1: " + sons.size());
            

            if (q.getResultList().isEmpty()) {
                return sons;
            } else {
                switch ((int) rangeId) {
                    case 23 : 
                        rangeId2  = 1;
                        rangeName = "o.dominiumTaxon.id";
                        break;
                    case 1 : 
                        rangeId2  = 2;
                        rangeName = "o.kingdomTaxon.id";
                        break;
                    case 2 :
                        rangeId2 = 4;
                        rangeName = "o.phylumDivisionTaxon.id";
                        break;
                    case 4 :
                        rangeId2 = 6;
                        rangeName = "o.classTaxon.id";
                        break;
                    case 6 :
                        rangeId2 = 9;
                        rangeName = "o.orderTaxon.id";
                        break;
                    case 9 :
                        rangeId2 = 13;
                        rangeName = "o.familyTaxon.id";
                        break;
                    case 13 :
                        rangeId2 = 18;
                        rangeName = "o.genusTaxon.id";
                        break;                        
                    default :
                        return sons;
                }
                
                query = "select o.id from Taxon as o ";
                query = query + " " + "where o.taxonomicalRange.id = " + rangeId2;
                query = query + " and " + rangeName + " = " + taxonId;
                query = query + " " + "order by o.defaultName"; 
                
                q = em.createQuery(query);
                ids.addAll(q.getResultList());
                
                if (ids.isEmpty()) {
                    return sons;
                } else {
                    for (int i = 0; i < ids.size(); i++) {
                        id = ((Long) ids.get(i)).longValue();
                        
                        query = "select o.taxonomicalRange.id, o.id, o.defaultName from Taxon as o";
                        query = query + " " + "where o.id = " + id;
                        query = query + " " + "order by o.taxonomicalRange.id, o.defaultName";    
                        // System.out.println(query);
                        
                        q = em.createQuery(query);
                        sons.addAll(q.getResultList());
                        // sons.addAll(getSons(id));
                    }
                }
                
            }            
            
            
//        } catch (Exception e) {
//            this.setMessage(e.getMessage());
//        }
        


        return sons;        
        
    }
    
    
    
    public List getSons(long taxonId) {
        ArrayList sons    = new ArrayList();
        ArrayList results = new ArrayList();
        ArrayList ids     = new ArrayList();
        long rangeId;
        Query q;
        String query;
        long id;
        long rangeId2 = 0;
        String rangeName = "";
        
        
//        try {
            this.taxon = em.find(org.inbio.ara.persistence.taxonomy.Taxon.class, taxonId);
            rangeId = this.taxon.getTaxonomicalRange().getId();
            
            
            query = "select o.taxonomicalRange.id, o.id, o.defaultName from Taxon as o";
            query = query + " " + "where o.id = :ptaxonid";
            query = query + " " + "order by o.taxonomicalRange.id, o.defaultName";            
            
            q = em.createQuery(query);
            q.setParameter("ptaxonid", taxonId);
            sons.addAll(q.getResultList());
            // System.out.println("Tamano de sons 1: " + sons.size());
            

            if (sons.isEmpty()) {
                return sons;
            } else {
                switch ((int) rangeId) {
                    case 23 : 
                        rangeId2  = 1;
                        rangeName = "o.dominiumTaxon.id";
                        break;
                    case 1 : 
                        rangeId2  = 2;
                        rangeName = "o.kingdomTaxon.id";
                        break;
                    case 2 :
                        rangeId2 = 4;
                        rangeName = "o.phylumDivisionTaxon.id";
                        break;
                    case 4 :
                        rangeId2 = 6;
                        rangeName = "o.classTaxon.id";
                        break;
                    case 6 :
                        rangeId2 = 9;
                        rangeName = "o.orderTaxon.id";
                        break;
                    case 9 :
                        rangeId2 = 13;
                        rangeName = "o.familyTaxon.id";
                        break;
                    case 13 :
                        rangeId2 = 18;
                        rangeName = "o.genusTaxon.id";
                        break;                        
                    default :
                        return sons;
                }
                
                query = "select o.id from Taxon as o where o.taxonomicalRange.id = " + rangeId2 + " and " + rangeName + " = " + taxonId;
                // System.out.println(query);
                
                q = em.createQuery(query);
                ids.addAll(q.getResultList());
                
                if (sons.isEmpty()) {
                    return sons;
                } else {
                    for (int i = 0; i < ids.size(); i++) {
                        id = ((Long) ids.get(i)).longValue();
                        
                        query = "select o.taxonomicalRange.id, o.id, o.defaultName from Taxon as o";
                        query = query + " " + "where o.id = " + id;
                        query = query + " " + "order by o.taxonomicalRange.id, o.defaultName";    
                        // System.out.println(query);
                        
                        q = em.createQuery(query);
                        sons.addAll(q.getResultList());
                        sons.addAll(getSons(id));
                    }
                }
                
            }            
            
            
//        } catch (Exception e) {
//            this.setMessage(e.getMessage());
//        }
        


        return sons;        
        
    }
    
    
    public List getAllTaxa() {
        String query = "select object(o) from Taxon as o";
        
        Query q = em.createQuery(query);
        return q.getResultList();
    }    
    
    /* Count */
    public int getCount() {
        Query q = em.createQuery("select count(o) from Taxon as o ");
        Long count = (Long)q.getSingleResult();
        if(count != null){
            return count.intValue();
        }
        return 0;
    }
    
    /* getTaxonomicalRangeId */
    public int getTaxonomicalRangeId() {
        Query q = em.createQuery("select o.taxonomicalRange.id from Taxon as o ");
        Long count = (Long)q.getSingleResult();
        if(count != null){
            return count.intValue();
        }
        return 0;
    }    
    
    public Taxon findTaxonById(Object id) {
        return (Taxon) em.createNamedQuery("Taxon.findByTaxonId").setParameter("taxonId", id).getSingleResult();
    }
    
    private boolean isTaxonNull(Taxon taxon){
        boolean isNull = false;

        return isNull;
    }    
    
    private boolean isTaxonUnique(Taxon taxon) {
        boolean isUnique = true;

        return isUnique;
    }    
    
    private boolean canDeleteTaxon(Taxon tTaxon) {
        boolean canDelete = true;        
        String  errorMessage = "";
        
//        if (!tPerson.getPersonProfileSet().isEmpty()) {
//            canDelete = false;
//             errorMessage = "El registro No. " + this.person.getId() +  " tiene perfiles asociados.";
//        }
//        
//        if (!tPerson.getPersonInstitutionSet().isEmpty()) {
//            canDelete = false;
//            errorMessage += "El registro No. " + this.person.getId() +  " está asociado al menos a una institución.";                            
//        }
        
        if (!canDelete) errorMessage += " No es posible borrarlo.";
        this.setMessage(errorMessage);
        return canDelete;
    }    
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }    
    
    public Taxon getTaxon(Long taxonId) {
        Query q;
        try {
            q = em.createQuery("Select object(o) from Taxon as o where o.id = " + taxonId);
            return (Taxon)q.getSingleResult();
        } catch(IllegalStateException ex1) {
            this.setMessage(ex1.getMessage());
            return null;
        } catch (IllegalArgumentException ex2) {
            this.setMessage(ex2.getMessage());
            return null;
        }
    }
    
    public List getTaxonHierarchy(Long taxonId) {
        Taxon currentTaxon;
        List hierarchy = new ArrayList();
        
        currentTaxon = this.getTaxon(taxonId);
        if (currentTaxon != null) {
            hierarchy.add(currentTaxon);
            currentTaxon = currentTaxon.getAncestor();
            while (currentTaxon != null) {
                hierarchy.add(currentTaxon);
                currentTaxon = currentTaxon.getAncestor();
            }
        }
        return hierarchy;
    }
    
}
