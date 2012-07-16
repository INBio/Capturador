/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.selectionlist;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author jgutierrez
 */
@Embeddable
public class ListTableCollectionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "list_table_id")
    private Long selectionListEntityId;

    @Basic(optional = false)
    @Column(name = "collection_id")
    private Long collectionId;

    @Basic(optional = false)
    @Column(name = "value_id")
    private Long selectionListValueId;

    public ListTableCollectionPK() {
    }

    public ListTableCollectionPK(Long listTableId, Long collectionId, Long valueId) {
        this.selectionListEntityId = listTableId;
        this.collectionId = collectionId;
        this.selectionListValueId = valueId;
    }

    public Long getSelectionListEntityId() {
        return selectionListEntityId;
    }

    public void setSelectionListEntityId(Long selectionListEntityId) {
        this.selectionListEntityId = selectionListEntityId;
    }

    public Long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    public Long getSelectionListValueId() {
        return selectionListValueId;
    }

    public void setSelectionListValueId(Long selectionListValueId) {
        this.selectionListValueId = selectionListValueId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (selectionListEntityId != null ? selectionListEntityId.hashCode() : 0);
        hash += (collectionId != null ? collectionId.hashCode() : 0);
        hash += (selectionListValueId != null ? selectionListValueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListTableCollectionPK)) {
            return false;
        }
        ListTableCollectionPK other = (ListTableCollectionPK) object;
        if ((this.selectionListEntityId == null && other.selectionListEntityId != null) || (this.selectionListEntityId != null && !this.selectionListEntityId.equals(other.selectionListEntityId))) {
            return false;
        }
        if ((this.collectionId == null && other.collectionId != null) || (this.collectionId != null && !this.collectionId.equals(other.collectionId))) {
            return false;
        }
        if ((this.selectionListValueId == null && other.selectionListValueId != null) || (this.selectionListValueId != null && !this.selectionListValueId.equals(other.selectionListValueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.selectionlist.ListTableCollectionPK[listTableId=" + selectionListEntityId + ", collectionId=" + collectionId + ", valueId=" + selectionListValueId + "]";
    }

}
