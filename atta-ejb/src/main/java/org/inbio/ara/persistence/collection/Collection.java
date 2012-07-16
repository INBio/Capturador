/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author herson
 */
@Entity
@Table(name = "collection")
public class Collection extends LogGenericEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="Collection")
	@SequenceGenerator(name="Collection", sequenceName="collection_seq")
    @Basic(optional = false)
    @Column(name = "collection_id")
    private Long collectionId;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
    

    public Collection() {
    }

    public Collection(Long collectionId) {
        this.collectionId = collectionId;
    }

    public Collection(String name) {
      this.name = name;
    }

    public Collection(Long collectionId, String name) {
        this.collectionId = collectionId;
        this.name = name;
    }

    public Long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (collectionId != null ? collectionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Collection)) {
            return false;
        }
        Collection other = (Collection) object;
        if ((this.collectionId == null && other.collectionId != null) || (this.collectionId != null && !this.collectionId.equals(other.collectionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.collection.Collection[collectionId=" + collectionId + "]" +
                "\n\tname= "+name +
                "\n\tdescription= "+description;
    }

}
