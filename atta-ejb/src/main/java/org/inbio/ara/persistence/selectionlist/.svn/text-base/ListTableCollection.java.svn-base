/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.selectionlist;

import java.util.Calendar;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.inbio.ara.persistence.GenericEntity;
import org.inbio.ara.persistence.collection.Collection;

/**
 *
 * @author jgutierrez
 */
@Entity
@Table(name = "list_table_collection")
public class ListTableCollection extends GenericEntity {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private ListTableCollectionPK selectionListCollectionPK;

    @JoinColumn(name = "collection_id", referencedColumnName = "collection_id", insertable=false, updatable=false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Collection collection;

    public ListTableCollection() {
    }

    public ListTableCollection(ListTableCollectionPK listTableCollectionPK) {
        this.selectionListCollectionPK = listTableCollectionPK;
    }

    public ListTableCollection(ListTableCollectionPK listTableCollectionPK, 
            String createdBy, Calendar creationDate, String lastModificationBy,
            Calendar lastModificationDate) {
        this.selectionListCollectionPK = listTableCollectionPK;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public ListTableCollection(Long selectionListEntityId, Long collectionId, Long selectionListValueId) {
        this.selectionListCollectionPK = new ListTableCollectionPK(selectionListEntityId, collectionId, selectionListValueId);
    }


 
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getSelectionListCollectionPK() != null ? getSelectionListCollectionPK().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListTableCollection)) {
            return false;
        }
        ListTableCollection other = (ListTableCollection) object;
        if ((this.getSelectionListCollectionPK() == null && other.getSelectionListCollectionPK() != null) || (this.getSelectionListCollectionPK() != null && !this.selectionListCollectionPK.equals(other.selectionListCollectionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.selectionlist.ListTableCollection[listTableCollectionPK=" + getSelectionListCollectionPK() + "]";
    }

    /**
     * @return the selectionListCollectionPK
     */
    public ListTableCollectionPK getSelectionListCollectionPK() {
        return selectionListCollectionPK;
    }

    /**
     * @param selectionListCollectionPK the selectionListCollectionPK to set
     */
    public void setSelectionListCollectionPK(ListTableCollectionPK selectionListCollectionPK) {
        this.selectionListCollectionPK = selectionListCollectionPK;
    }

    /**
     * @return the collection
     */
    public Collection getCollection() {
        return collection;
    }

    /**
     * @param collection the collection to set
     */
    public void setCollection(Collection collection) {
        this.collection = collection;
    }

}
