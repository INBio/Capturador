/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.collection;

import java.util.List;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.collection.Collection;

/**
 *
 * @author jgutierrez
 */

public interface CollectionEAOLocal extends BaseLocalEAO<Collection,Long>{

    public List<Collection> finAllBySelectionListValue(Long selectedSelectionListEntityId, Long selectedSelectionListValueId);

    public java.lang.Long getSpecimensCountByCollectionId(java.lang.Long collectionId);

    public java.lang.Long getSpeciesCountByCollectionId(java.lang.Long collectionId);

    public java.util.List<org.inbio.ara.persistence.collection.Collection> findByCollectionName(java.lang.String collectionName);
    
}
