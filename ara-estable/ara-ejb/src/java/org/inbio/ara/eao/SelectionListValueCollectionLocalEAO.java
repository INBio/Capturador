/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao;

import javax.ejb.Local;

/**
 *
 * @author jgutierrez
 */
@Local
public interface SelectionListValueCollectionLocalEAO {

    /**
     *
     * @param selectionListId
     * @param selectionListValueId
     * @param collectionId
     */
    public void createSelectionListValueCollection(Long selectionListId, Long selectionListValueId, Long collectionId);

    /**
     * 
     * @param selectionListId
     * @param selectionListValueId
     * @param CollectionId
     */
    public void deleteSelectionListValueCollection(Long selectionListId, Long selectionListValueId, Long CollectionId);

}
