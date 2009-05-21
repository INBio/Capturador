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
 * ReferenceFacade.java
 *
 * Created on July 16, 2007, 11:37 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import org.inbio.ara.persistence.entity.Reference;
import org.inbio.ara.persistence.reference.Reference;

/**
 *
 * @author jgutierrez
 */
@Stateless
public class ReferenceFacade implements ReferenceFacadeLocal {

    @PersistenceContext
    private EntityManager em;
    
    /** Creates a new instance of ReferenceFacade */
    public ReferenceFacade() {
    }

    public void create(Reference reference) {
        em.persist(reference);
    }

    public void edit(Reference reference) {
        em.merge(reference);
    }

    public void destroy(Reference reference) {
        em.merge(reference);
        em.remove(reference);
    }

    public Reference find(Object pk) {
        return (Reference) em.find(Reference.class, pk);
    }

    public List findAll() {
        return em.createQuery("select object(o) from Reference as o").getResultList();
    }
    
}
