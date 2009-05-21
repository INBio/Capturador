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
 * ReferenceElementFacade.java
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
//import org.inbio.ara.persistence.entity.ReferenceElement;
import org.inbio.ara.persistence.reference.ReferenceElement;

/**
 *
 * @author jgutierrez
 */
@Stateless
public class ReferenceElementFacade implements ReferenceElementFacadeLocal {

    @PersistenceContext
    private EntityManager em;
    
    /** Creates a new instance of ReferenceElementFacade */
    public ReferenceElementFacade() {
    }

    public void create(ReferenceElement referenceElement) {
        em.persist(referenceElement);
    }

    public void edit(ReferenceElement referenceElement) {
        em.merge(referenceElement);
    }

    public void destroy(ReferenceElement referenceElement) {
        em.merge(referenceElement);
        em.remove(referenceElement);
    }

    public ReferenceElement find(Object pk) {
        return (ReferenceElement) em.find(ReferenceElement.class, pk);
    }

    public List findAll() {
        return em.createQuery("select object(o) from ReferenceElement as o").getResultList();
    }
    
}
