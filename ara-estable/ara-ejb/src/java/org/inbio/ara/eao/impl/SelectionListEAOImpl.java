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

package org.inbio.ara.eao.impl;

import java.util.List;
import javax.ejb.Stateless;
import org.inbio.ara.eao.SelectionListLocalEAO;
import org.inbio.ara.persistence.collection.ListTable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jgutierrez
 */
@Stateless
public class SelectionListEAOImpl implements SelectionListLocalEAO{

    @PersistenceContext
    private EntityManager em;
    

    /**
     * Deberían llamarse getAllSelectionLists pero... asi estaban los nombres
     * 
     * @return
     */
    public List<ListTable> getAllSelectionLists(){

        Query q = em .createQuery("select lt from ListTable as lt");
        return q.getResultList();
        //fin
    }

    /**
     * Deberia llamarse getSelectionList, pero... asi estaban los nombres
     *
     * @param listTableId
     * @return
     */
    public ListTable getSelectionList(Long selectionListId){
        Query q = em .createQuery("select lt from ListTable as lt where lt.id = :selectionListId");
        q.setParameter("selectionListId", (Long) selectionListId);
        return (ListTable) q.getSingleResult();
    }

    /**
     *
     *
     * @param selectionListId
     * @return
     */
    public ListTable getSelectionListById(Long selectionListId){
        Query q = em.createQuery("select lt " +
                "from ListTable as lt " +
                "where lt.id = :selectionListId");
        q.setParameter("selectionListId", selectionListId);
        return (ListTable) q.getSingleResult();
    }
}
