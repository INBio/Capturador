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
/*
 * CollectionProtocol.java
 *
 * Created on October 30, 2007, 2:20 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.collection;

import javax.persistence.Entity;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.Table;
import org.inbio.ara.persistence.genericEntity;

/**
 * Entity class CollectionProtocol
 * 
 * @author roaguilar
 */
@Entity()
@Table(name = "collection_protocol")
public class CollectionProtocol extends genericEntity {

    @EmbeddedId
    private CollectionProtocolPK collectionProtocolPK;
    
    @JoinColumn(name="collection_id", referencedColumnName="collection_id", insertable = false, updatable=false)
    @ManyToOne()
    private Collection collection;
    
    @JoinColumn(name="protocol_attribute_id", referencedColumnName="protocol_attribute_id", insertable = false, updatable=false)
    @ManyToOne()
    private ProtocolAttribute protocolAttribute;
    
    @Column(name="value", nullable = false)
    private String value;
    
    /** Creates a new instance of CollectionProtocol */
    public CollectionProtocol() {
    }
    
    public CollectionProtocol(CollectionProtocolPK collectionProtocolPK) {
        this.setCollectionProtocolPK(collectionProtocolPK);
    }
    
    public CollectionProtocol(Long collectionId, Long protocolAttributeId) {
        this.setCollectionProtocolPK(new CollectionProtocolPK(collectionId, protocolAttributeId));
    }

    public CollectionProtocolPK getCollectionProtocolPK() {
        return collectionProtocolPK;
    }

    public void setCollectionProtocolPK(CollectionProtocolPK collectionProtocolPK) {
        this.collectionProtocolPK = collectionProtocolPK;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public ProtocolAttribute getProtocolAttribute() {
        return protocolAttribute;
    }

    public void setProtocolAttribute(ProtocolAttribute protocolAttribute) {
        this.protocolAttribute = protocolAttribute;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.collectionProtocolPK != null ? this.collectionProtocolPK.hashCode() : 0);
        return hash;
    }
    
    /**
     * Determines whether another object is equal to this PersonProfile.  The result is 
     * <code>true</code> if and only if the argument is not null and is a PersonProfile object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CollectionProtocol)) {
            return false;
        }
        CollectionProtocol other = (CollectionProtocol)object;
        if (this.collectionProtocolPK != other.collectionProtocolPK && (this.collectionProtocolPK == null || !this.collectionProtocolPK.equals(other.collectionProtocolPK))) return false;
        return true;
    }
    
    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.collection.CollectionProtocol[collectionProtocolPK=" + collectionProtocolPK + "]";
    } 

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
