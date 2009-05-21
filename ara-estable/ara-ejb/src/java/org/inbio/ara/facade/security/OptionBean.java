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
 * OptionBean.java
 *
 * Created on September 24, 2007, 9:43 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.security;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import org.inbio.ara.persistence.security.SystemOption;

/**
 *
 * @author roaguilar
 */
@Stateless
public class OptionBean implements OptionRemote, OptionLocal {

    @PersistenceContext
    private EntityManager em;
    
    /** Creates a new instance of OptionBean */
    public OptionBean() {
    }

    public void persist(Object object) {
        // TODO:
        // em.persist(object);
    }
    
    public List findAll() {
        //Query q = em.createQuery("Select Object(o) from SystemOption as o order by o.name");
        Query q = em.createQuery("Select Object(o) from SystemOption as o order by o.module.name, o.name");
        return q.getResultList();
    }
    
    public SystemOption getSystemOption(Long id) {
        return em.find(SystemOption.class, id);
    }
}
