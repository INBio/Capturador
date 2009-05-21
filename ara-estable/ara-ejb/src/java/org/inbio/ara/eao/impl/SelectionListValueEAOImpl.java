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
import org.inbio.ara.eao.SelectionListValueLocalEAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.inbio.ara.dto.SelectionListEntity;
import org.inbio.ara.persistence.selectionListEntity;

/**
 *
 * @author jgutierrez
 */
@Stateless
public class SelectionListValueEAOImpl implements SelectionListValueLocalEAO{

    @PersistenceContext
    private EntityManager em;


        /**
     *
     * @param actualSelectionListValue
     */
    public void createSelectionListValue(selectionListEntity selectionListValue){
        //SelectionListEntity sle = SelectionListEntity.getById(selectionListId.intValue());
        //String selectionListEntityClassName = sle.getSelectionlistClassName();
        em.persist(selectionListValue);
        em.flush();

    }

    /**
     *
     * @param selectionListValue
     */
    public void updateSelectionListValue(selectionListEntity selectionListValue) {
        em.merge(selectionListValue);
        em.flush();
    }

    /**
     *
     * @param selectionListId
     * @param selectionListValueId
     * @return
     */
    public selectionListEntity getSelectionlistValueById(Long selectionListId, Long selectionListValueId){

        SelectionListEntity selectionListEntity = SelectionListEntity.getById(selectionListId.intValue());
        String selectionListEntityClassName = selectionListEntity.getSelectionlistClassName();

        Query q = em .createQuery("select slv " +
                "from "+ selectionListEntityClassName+" as  slv " +
                "where slv.id = :selectionListValueId");
        q.setParameter("selectionListValueId", selectionListValueId);

        return (selectionListEntity) q.getSingleResult();
    }

   /**
     * Get all the values associated with the given selection list Id. The Id
     * corresponds to an entity of the ListTable class.
     *
     * @param selectionListId the id of an ListTable entity
     * @return
     */
    public List<selectionListEntity> getAllSelectionListValues(Long selectionListId){


        SelectionListEntity selectionListEntity = SelectionListEntity.getById(selectionListId.intValue());

        String entityClassName = selectionListEntity.getSelectionlistClassName();
        Query q = em .createQuery("select slv from "+ entityClassName+" as  slv");

        return q.getResultList();


    }

        /**
     * Eso debería estar en el SelectionListValueDAO o EAO
     *
     * @param selectionListId
     * @param selectionListValueId
     */
    public void deleteSelectionListValue(Long selectionListId, Long selectionListValueId){
        selectionListEntity sle = this.getSelectionlistValueById(selectionListId, selectionListValueId);

        em.remove(sle);
        em.flush();
    }



}
