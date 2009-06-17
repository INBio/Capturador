/* Ara - capture species and specimen data
 * 
 * Copyright (C) 2009  INBio ( Instituto Nacional de Biodiversidad )
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
 * SearchManagerBean.java
 *
 * Created on 1 de febrero de 2008, 03:35 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package org.inbio.ara.facade.util;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.inbio.ara.persistence.genericEntity;

/**
 *
 * @author herson
 */
@Stateless
public class SearchManagerBean implements SearchManagerLocal, SearchManagerRemote {

    /**
     * Persistence context object
     */
    @PersistenceContext
    private EntityManager em;
    private List objectsList;
    private String message;

    public SearchManagerBean() {
        setMessage("");
    }

    @Override
    public <T extends genericEntity> List makeQuery(Class<T> clazz, Hashtable parameters) {
        StringBuffer query = new StringBuffer("FROM " + clazz.getName() + "  as table ");
        boolean firstClause = true;

        Iterator iter = parameters.keySet().iterator();
        while (iter.hasNext()) {
            query.append(firstClause ? "WHERE " : " AND ");
            String name = (String) iter.next();
            query.append(name);
            String value = (String) parameters.get(name);
            query.append(value);
            firstClause = false;
        }

        try {
            Query q = em.createQuery(query.toString());
            this.objectsList = (List) q.getResultList();
        } catch (IllegalStateException ex1) {

            this.setMessage(ex1.getMessage());
            return null;
        } catch (IllegalArgumentException ex2) {
            this.setMessage(ex2.getMessage());
            return null;
        }
        return this.objectsList;
    }

    @Override
    public <T> List makePaginatedQuery(int firstResult, int maxResults, Class<T> clazz, Hashtable parameters) {
        StringBuffer query = new StringBuffer("FROM " + clazz.getName() + "  as table ");
        boolean firstClause = true;

        Iterator iter = parameters.keySet().iterator();
        while (iter.hasNext()) {
            query.append(firstClause ? "WHERE " : " AND ");
            String name = (String) iter.next();
            query.append(name);
            String value = (String) parameters.get(name);
            query.append(value);
            firstClause = false;
        }
        
        if(clazz.getSimpleName().equals("Identification")){
            System.out.println("Identification******************");
            query.append(" order by table.identificationPK.specimenId) ");
            System.out.println(query);
        } else
            query.append(" order by table.id ");

        try {
            Query q = em.createQuery(query.toString());
            q.setFirstResult(firstResult);
            q.setMaxResults(maxResults);
            this.objectsList = (List) q.getResultList();
            System.out.println("------->"+this.objectsList.size());
        } catch (IllegalStateException ex1) {
            ex1.printStackTrace();
            this.setMessage(ex1.getMessage());
            return null;
        } catch (IllegalArgumentException ex2) {
            ex2.printStackTrace();
            this.setMessage(ex2.getMessage());
            return null;
        }
        return this.objectsList;
    }
    
    @Override
    public <T> Long countResult(Class<T> clazz, Hashtable parameters) {
        StringBuffer query = new StringBuffer("FROM " + clazz.getName() + "  as table ");
        Long countResult = null;
        boolean firstClause = true;

        Iterator iter = parameters.keySet().iterator();
        while (iter.hasNext()) {
            query.append(firstClause ? "WHERE " : " AND ");
            String name = (String) iter.next();
            query.append(name);
            String value = (String) parameters.get(name);
            query.append(value);
            firstClause = false;
        }
        if(clazz.getSimpleName().equals("Identification")){
            System.out.println("Identification******************");
            query.insert(0, "SELECT COUNT(table.identificationPK.specimenId) ");
            System.out.println(query);
        }
        else
            query.insert(0, "SELECT COUNT(table.id) ");
              
        try {
            System.out.println(query.toString() + "QQQQQQQQQQQQ");
            Query q = em.createQuery(query.toString());
            countResult = (Long)q.getSingleResult();
        } catch (IllegalStateException ex1) {
            ex1.printStackTrace();
            this.setMessage(ex1.getMessage());
            return null;
        } catch (IllegalArgumentException ex2) {
            ex2.printStackTrace();
            this.setMessage(ex2.getMessage());
            return null;
        }
        return countResult;
    }

    @Override
    public <T> Long countResult4Reports (Class<T> clazz, Hashtable parameters) {
        StringBuffer query = new StringBuffer("FROM " + clazz.getName() + "  as table WHERE");
        Long countResult = null;
        boolean firstClause = true;

        Iterator iter = parameters.keySet().iterator();
        while (iter.hasNext()) {

            String name = (String) iter.next();
            query.append(name);
            String value = (String) parameters.get(name);
            query.append(value);
            firstClause = false;
        }

        if(clazz.getSimpleName().equals("Identification")){
            System.out.println("Identification******************");
            query.insert(0, "SELECT COUNT(table.identificationPK.specimenId) ");
            System.out.println(query);
        }
        else
            query.insert(0, "SELECT COUNT(table.id)  ");
        System.out.println("##################################################################" + query.toString());

        try {
            System.out.println(query.toString() + "QQQQQQQQQQQQ");
            Query q = em.createQuery(query.toString());
            countResult = (Long)q.getSingleResult();
        } catch (IllegalStateException ex1) {
            ex1.printStackTrace();
            this.setMessage(ex1.getMessage());
            return null;
        } catch (IllegalArgumentException ex2) {
            ex2.printStackTrace();
            this.setMessage(ex2.getMessage());
            return null;
        }
        return countResult;
    }

     @Override
    public <T> List makePaginatedQuery4Reports(int firstResult, int maxResults, Class<T> clazz, Hashtable parameters) {
        StringBuffer query = new StringBuffer("FROM " + clazz.getName() + "  as table WHERE ");
        boolean firstClause = true;

        Iterator iter = parameters.keySet().iterator();
        while (iter.hasNext()) {
            String name = (String) iter.next();
            query.append(name);
            String value = (String) parameters.get(name);
            query.append(value);
            firstClause = false;
        }

        if(clazz.getSimpleName().equals("Identification")){
            System.out.println("Identification******************");
            query.append(" order by table.identificationPK.specimenId) ");
            System.out.println(query);
        } else
            query.append(" order by table.id ");

        try {
            System.out.println(query.toString() + "QQQQQQQQQQQQ");
            Query q = em.createQuery(query.toString());
            q.setFirstResult(firstResult);
            q.setMaxResults(maxResults);
            this.objectsList = (List) q.getResultList();
        } catch (IllegalStateException ex1) {
            ex1.printStackTrace();
            this.setMessage(ex1.getMessage());
            return null;
        } catch (IllegalArgumentException ex2) {
            ex2.printStackTrace();
            this.setMessage(ex2.getMessage());
            return null;
        }
        return this.objectsList;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
