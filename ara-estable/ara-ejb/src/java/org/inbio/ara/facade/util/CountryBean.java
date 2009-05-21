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
 * CountryBean.java
 *
 * Created on August 26, 2007, 4:47 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.util;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.inbio.ara.persistence.util.Country;
import javax.persistence.Query;
import com.sun.data.provider.SortCriteria;

/**
 * Support Session-bean used to manage Country entities.
 * @author Róger Aguilar P.
 */
@Stateless
public class CountryBean implements org.inbio.ara.facade.util.CountryRemote, org.inbio.ara.facade.util.CountryLocal {
    
    /**
     * Persistence context object
     */
    @PersistenceContext
    private EntityManager em;
    /**
     * Last error message produced by action methods such as update, create, remove or 
     * findAll.
     */
    private String message;    
    /**
     * Persistence entity
     */
    private Country country;    
    /**
     * List of entities produced after calling the findAll method.
     */
    private List countryList;
    
    /** Creates a new instance of PersonBean */
    public CountryBean() {
        this.country = null;
        this.message = "";
    }

    /**
     * This method is used to save the new dataset corresponding to the Country
     * entity. First verifies that the name of the new Country is not duplicated.
     * @return <B>True</B> if the entity manager successfully performs the persist action.<BR>
     * <B>False</B> in case that the information could not be saved. After this use the
     * <B>getMessage()<B> method to see a fully description of the error.
     */
    public boolean persist() {
        if (!isCountryNull(this.country)){
            if (isCountryUnique(this.country)) {
                try {
                    em.persist(this.country);
                    return true;                
                } catch (Exception e) {
                    setMessage(e.getLocalizedMessage());
                    return false;
                }
            } else {
                setMessage("Ya existe otro país almacenado en el sistema con el mismo nombre. El registro no fue creado.");
                return false;
            }
        } else {
            this.setMessage(this.getMessage() + " El registro no fue creado.");
            return false;
        }
    }

    /**
     * This method must be used when creating a new Country. Calls the local 
     * <b>persist()</b> method to validate and save the information.
     * @param country A Country entity containing the new data to be saved.
     * @return <B>True</B> if the entity manager successfully performs the persist action.<BR>
     * <B>False</B> in case that the information could not be saved. After this use the
     * <B>getMessage()<B> method to see a fully description of the error.
     */
    public boolean create(Country country) {
        this.country = country;
        return persist();
    }

    /**
     * Use this to get the last persisted/merged Country entity.
     * @return The last used Country entity.
     */
    public Country getCountry() {
        return this.country;
    }

    /**
     * Use this method to eliminate a Country from the database.
     * @param id Unique identificator of the Country to be deleted.
     * @return True if the Country was deleted. False if the Country could not be deleted. Use
     * getMessage() after this to know the cause.
     */
    public boolean remove(Long id) {
        boolean removed = false;
        try {
            this.country = em.find(org.inbio.ara.persistence.util.Country.class,id);
            if (this.canDeleteCountry(this.country)) {
                this.country = em.merge(this.country);
                em.remove(this.country);
                removed = true;
            }
        } catch (Exception e) {
            this.setMessage(e.getMessage());
            removed = false;
        }
        return removed;     
    }

    /**
     * Use this method to update the information of a given Country.
     * @param country Country entity to be updated.
     * @return True if the information was updated or False in case of error, use getMessage()
     * after this to know the cause.
     */
    public boolean update(Country country) {
        boolean updated = false;
        if (!isCountryNull(country)){
            if (this.isCountryUnique(country)) {
                try {
                    this.country = country;
                    em.merge(this.country);
                    updated = true;                
                } catch (Exception ex) {
                    this.setMessage("El registro No. " + this.country.getId() + " ha sido modificado o borrado por otro usuario. No se realizó la modificación.");
                    updated = false;
                }
            } else {
                setMessage("Ya existe otrp país almacenado en el sistema con el mismo nombre. El registro no fue modificado.");
                updated = false;
            }            
        } else {
            this.setMessage(this.getMessage() + " El registro no fue creado.");
        }
        return updated;     
    }


    /**
     * Use this method to get all the Countries existing in the database.
     * @return A List of Country entities.
     */
    public List findAll() {
        Query q = em.createQuery("Select object(o) from Country as o");
        this.countryList = (List)q.getResultList();
        return this.countryList;
    }
    
    /**
     * 
     * @param firstResult 
     * @param maxResults 
     * @param sortCriteria 
     * @return 
     */
    public List findAll(int firstResult, int maxResults, SortCriteria[] sortCriteria) {
        String hql;
        int index;
        Query q;
        
        hql = "Select object(o) from Country as o";
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
        this.countryList = q.getResultList();
        return this.countryList;
    }
    
    /**
     * 
     * @param country 
     * @return 
     */
    private boolean isCountryUnique(Country country) {
        boolean isUnique = true;
        String tmpName, sql;
        Long tmpId;
        
        tmpName = country.getName();
        sql = "SELECT o FROM Country o ";
        sql = sql + "where trim(lower(name)) = trim(lower('" + tmpName +"')) ";
        if (country.getId()!=null) {
            sql = sql + " and id <> " + country.getId();
        }
        if (em.createQuery(sql).getResultList().size() > 0) {
            isUnique = false;
        }
        return isUnique;
    }
    
    /**
     * 
     * @param country 
     * @return 
     */
    private boolean canDeleteCountry(Country country) {
        boolean canDelete = true;        
        String  errorMessage = "";
        
        /*if (!tPerson.getPersonProfileCollection().isEmpty()) {
            canDelete = false;
             errorMessage = "El registro No. " + this.country.getId() +  " tiene perfiles asociados.";
        }
        
        if (!tPerson.getPersonInstitutionCollection().isEmpty()) {
            canDelete = false;
            errorMessage += "El registro No. " + this.country.getId() +  " está asociado al menos a una institución.";                            
        }
        if (!canDelete) errorMessage += " No es posible borrarlo.";
        this.setMessage(errorMessage);*/
        return canDelete;
    }
    
    /**
     * 
     * @param country 
     * @return 
     */
    private boolean isCountryNull(Country country){
        boolean isNull = false;
        String msg = "";
        if ((country.getName() == null) || (country.getName().equals(""))){
            isNull = true;
            msg = "Nombre";
        }

        if (isNull) {
            msg = "Los siguientes campos son obligatorios: " + msg + ".";
            this.setMessage(msg);
        }
        return isNull;
    }
    
    /**
     * 
     * @return 
     */
    public String getMessage() {
        return message;
    }

    /**
     * 
     * @param message 
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
