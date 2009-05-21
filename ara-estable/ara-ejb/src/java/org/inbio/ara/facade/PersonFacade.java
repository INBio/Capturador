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
 * PersonFacade.java
 *
 * Created on June 7, 2007, 10:12 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
//import org.inbio.ara.persistence.entity.Person;
import org.inbio.ara.persistence.person.Person;

/**
 *
 * @author jgutierrez
 */
@Stateless
public class PersonFacade implements PersonFacadeLocal {
    
    @PersistenceContext
    //@PersistenceContext(unitName="Capturador-ejbPU" )
    private EntityManager em;
    
    /** Creates a new instance of PersonFacade */
    public PersonFacade() {
    }
    
    public void create(Person person) {   
            em.persist(person);
    }
    
    public void edit(Person person) {
        em.merge(person);
    }
    
    public void destroy(Person person) {
        em.merge(person);
        em.remove(person);
    }
    
    public Person find(Object pk) {
        return (Person) em.find(Person.class, pk);
    }
    
    public List findAll() {
        return em.createQuery("select object(o) from Person as o").getResultList();
    }
    
    public void createPerson(String name, String lastName) {
        Person thePerson = new Person();
        
        thePerson.setFirstName(name);
        thePerson.setLastName(lastName);
        
        em.persist(thePerson);
    }
    
}
