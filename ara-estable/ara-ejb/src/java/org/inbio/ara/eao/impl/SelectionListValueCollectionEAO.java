/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.inbio.ara.eao.SelectionListValueCollectionLocalEAO;
import org.inbio.ara.persistence.collection.ListTableCollection;
import org.inbio.ara.persistence.collection.ListTableCollectionPK;

/**
 *
 * @author jgutierrez
 */
@Stateless
public class SelectionListValueCollectionEAO implements SelectionListValueCollectionLocalEAO {

    @PersistenceContext
    private EntityManager em;

    /**
     *
     * @param selectionListId
     * @param selectionListValueId
     * @param CollectionId
     */
    public void createSelectionListValueCollection(Long selectionListId, Long selectionListValueId, Long collectionId) {
        
        ListTableCollectionPK listTableCollectionPK = new ListTableCollectionPK(selectionListId, collectionId, selectionListValueId);
        ListTableCollection listTableCollection = new ListTableCollection(listTableCollectionPK);


        listTableCollection.setCreatedBy("jgutierrez");
        listTableCollection.setLastModificationBy("jgutierrez");
        try{
        em.persist(listTableCollection);
        em.flush();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

     /**
     *
     * @param selectionListId
     * @param selectionListValueId
     * @param CollectionId
     */
    public void deleteSelectionListValueCollection(Long selectionListId, Long selectionListValueId, Long CollectionId) {

        ListTableCollectionPK listTableCollectionPK = new ListTableCollectionPK(selectionListId, CollectionId,selectionListValueId);
        ListTableCollection listTableCollection = em.find(ListTableCollection.class, listTableCollectionPK);

        em.remove(listTableCollection);
        em.flush();

    }
}
