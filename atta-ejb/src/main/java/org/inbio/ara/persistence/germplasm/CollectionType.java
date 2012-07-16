/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.germplasm;

import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.persistence.SelectionListGenericEntity;

/**
 *
 * @author dasolano
 */
@Entity
@Table(name = "collection_type")
public class CollectionType extends SelectionListGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="collection_type")
    @SequenceGenerator(name="collection_type", sequenceName="collection_type_seq")
    @Basic(optional = false)
    @Column(name = "collection_type_id")
    private Long collectionTypeId;

    public CollectionType() {
    }

    public CollectionType(Long collectionTypeId) {
        this.collectionTypeId = collectionTypeId;
    }

    public CollectionType(Long collectionTypeId, String name, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.collectionTypeId = collectionTypeId;
        this.setName(name);
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getCollectionTypeId() {
        return collectionTypeId;
    }

    public void setCollectionTypeId(Long collectionTypeId) {
        this.collectionTypeId = collectionTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (collectionTypeId != null ? collectionTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CollectionType)) {
            return false;
        }
        CollectionType other = (CollectionType) object;
        if ((this.collectionTypeId == null && other.collectionTypeId != null) || (this.collectionTypeId != null && !this.collectionTypeId.equals(other.collectionTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.germoplasma.CollectionType[collectionTypeId=" + collectionTypeId + "]";
    }

    @Override
    public Long getId() {
        return this.collectionTypeId;
    }

    @Override
    public void setId(Long id) {
        this.collectionTypeId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.COLLECTION_TYPE;
    }

}
