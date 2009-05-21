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
 * LanguageBean.java
 *
 * Created on 16 de noviembre de 2007, 09:50 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.util;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.inbio.ara.persistence.util.Language;

/**
 *
 * @author herson
 */
@Stateless
public class LanguageBean implements LanguageRemote, LanguageLocal {
    
    @PersistenceContext
    private EntityManager em;
    
    private Language language;    
    private String message;
    
    /** Creates a new instance of TaxonDescriptionElementBean */
    public LanguageBean() {
        this.language = null;
        message = "";
    }
    
    public Language find(Long id){
        Query q = em.createQuery("Select object(o) from Language as o where o.languageId = " + id);                
        try {
            this.language = 
                    (Language) q.getSingleResult();
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
        return this.language;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }    
}
