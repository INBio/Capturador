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

    public <T extends genericEntity> List makePaginatedQuery(int firstResult, int maxResults, Class<T> clazz, Hashtable parameters) {
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
            q.setFirstResult(firstResult);
            q.setMaxResults(maxResults);
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

    public <T extends genericEntity> Integer countResult(Class<T> clazz, Hashtable parameters) {
        StringBuffer query = new StringBuffer("FROM " + clazz.getName() + "  as table ");
        Integer countResult = null;
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
        query.insert(0, "SELECT COUNT(table.id)  ");

        try {
            Query q = em.createQuery(query.toString());
            countResult = (Integer) q.getSingleResult();
        } catch (IllegalStateException ex1) {

            this.setMessage(ex1.getMessage());
            return null;
        } catch (IllegalArgumentException ex2) {
            this.setMessage(ex2.getMessage());
            return null;
        }
        return countResult;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
