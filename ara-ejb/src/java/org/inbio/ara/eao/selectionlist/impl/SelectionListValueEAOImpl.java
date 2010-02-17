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


package org.inbio.ara.eao.selectionlist.impl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.eao.selectionlist.SelectionListValueLocalEAO;
import org.inbio.ara.persistence.SelectionListGenericEntity;

/**
 *
 * @author jgutierrez
 */
@Stateless
public class SelectionListValueEAOImpl implements SelectionListValueLocalEAO {

    @PersistenceContext
    private EntityManager em;


        /**
     *
     * @param actualSelectionListValue
     */
    public void create(SelectionListGenericEntity selectionListGenericEntity){
        //SelectionListEntity sle = SelectionListEntity.getById(selectionListId.intValue());
        //String selectionListEntityClassName = sle.getSelectionlistClassName();
        em.persist(selectionListGenericEntity);
        em.flush();

    }

    /**
     *
     * @param selectionListValue
     */
    public void update(SelectionListGenericEntity selectionListGenericEntity) {
        em.merge(selectionListGenericEntity);
        em.flush();
    }

    /**
     *
     * @param selectionListId
     * @param selectionListValueId
     * @return
     */
    public SelectionListGenericEntity findById(Long selectionListEntityId, Long selectionListValueId){

        SelectionListEntity selectionListEntity = SelectionListEntity.getById(selectionListEntityId.intValue());
        String selectionListEntityClassName = selectionListEntity.getSelectionlistClassName();

        Query q = em .createQuery("select slv " +
                "from "+ selectionListEntityClassName+" as  slv " +
                "where slv.id = :selectionListValueId");
        q.setParameter("selectionListValueId", selectionListValueId);

        return (SelectionListGenericEntity) q.getSingleResult();
    }

   /**
     * Get all the values associated with the given selection list Id. The Id
     * corresponds to an entity of the ListTable class.
     *
     * @param selectionListId the id of an ListTable entity
     * @return
     */
    public List<SelectionListGenericEntity> findAll(Long selectionListEntityId){

        //System.out.println("findAll ["+selectionListEntityId+"]");
        SelectionListEntity selectionListEntity = SelectionListEntity.getById(selectionListEntityId.intValue());

        String entityClassName = selectionListEntity.getSelectionlistClassName();
        Query q = em .createQuery("select slv from "+ entityClassName+" as  slv");

        return q.getResultList();
    }
    
    /**
     * 
     * @param selectionListEntityId
     * @param first
     * @param maxResults
     * @return
     */
    public List<SelectionListGenericEntity> findAllPaginated(Long selectionListEntityId, int first, int maxResults) {
       //System.out.println("findAll ["+selectionListEntityId+"]");
        SelectionListEntity selectionListEntity = SelectionListEntity.getById(selectionListEntityId.intValue());

        String entityClassName = selectionListEntity.getSelectionlistClassName();
        Query q = em .createQuery("select slv from "+ entityClassName+" as  slv");
        q.setFirstResult(first);
        q.setMaxResults(maxResults);
        return q.getResultList();
    }

    /**
     * TODO: james
     *
     * @param selectionListEntityId
     * @param CollectionId
     * @return
     */
    public List<SelectionListGenericEntity> findAllByCollectionId(Long selectionListEntityId, Long collectionId) {
        SelectionListEntity selectionListEntity = SelectionListEntity.getById(selectionListEntityId.intValue());

        String entityClassName = selectionListEntity.getSelectionlistClassName();
        Query q = em .createQuery("select slv" +
                " from "+ entityClassName+" as  slv, ListTableCollection as slc" +
                " where slc.selectionListCollectionPK.collectionId = :colletionId" +
                " and slc.selectionListCollectionPK.selectionListEntityId = :selectionListEntityId" +
                " and slc.selectionListCollectionPK.selectionListValueId = slv.id");
        q.setParameter("colletionId", collectionId);
        q.setParameter("selectionListEntityId", selectionListEntityId);

        return q.getResultList();
    }

    /**
     * Eso debería estar en el SelectionListValueDAO o EAO
     *
     * @param selectionListId
     * @param selectionListValueId
     */
    public void delete(Long selectionListEntityId, Long selectionListValueId){
        SelectionListGenericEntity sle = this.findById(selectionListEntityId, selectionListValueId);

        em.remove(sle);
        em.flush();
    }

    /**
     * 
     * @param selectionListEntityId
     * @return
     */
    public Long count(Long selectionListEntityId) {
        SelectionListEntity selectionListEntity = SelectionListEntity.getById(selectionListEntityId.intValue());
        String entityClassName = selectionListEntity.getSelectionlistClassName();
        Query q = em.createQuery("select count (slv.id) from "+ entityClassName+" as  slv");
        Long result = (Long)q.getSingleResult();
        return result;


    }

}
