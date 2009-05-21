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
 * TaxonDescriptionElementBean.java
 *
 * Created on 19 de octubre de 2007, 06:10 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.taxonomy;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionElement;

/**
 *
 * @author herson
 */
@Stateless
public class TaxonDescriptionElementBean implements
        TaxonDescriptionElementLocal, TaxonDescriptionElementRemote{
    
    @PersistenceContext
    private EntityManager em;
    private TaxonDescriptionElement taxonDescriptionElement;
    
    private String message;
    
    /** Creates a new instance of TaxonDescriptionElementBean */
    public TaxonDescriptionElementBean() {
        message = "";
    }
    
    public TaxonDescriptionElement find(Long id){
        Query q = em.createQuery("Select object(o) from TaxonDescriptionElement as o where o.id = " + id);                
        try {
            this.taxonDescriptionElement = 
                    (TaxonDescriptionElement) q.getSingleResult();
        } catch (NoResultException noResultEx) {
            this.setMessage("No se encontraron registros para el Id dado");
            return null;
        } catch (NonUniqueResultException noUniqueResultEx) {
            this.setMessage("La consulta produjo más de un resultado");
            return null;
        } catch (IllegalStateException stateException) {
            this.setMessage("Se produjo un llamado a INSERT o UPDATE");
            return null;
        }
        return this.taxonDescriptionElement;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
