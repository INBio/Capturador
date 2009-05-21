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
 * ListTableCollectionPK.java
 *
 * Created on April 22, 2008, 10:49 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.collection;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
/**
 *
 * @author roaguilar
 */
@Embeddable
public class ListTableCollectionPK implements Serializable {
    
    @Column(name = "list_table_id", nullable = false)
    private Long listTableId;

    @Column(name = "collection_id", nullable = false)
    private Long collectionId;
    
    @Column(name = "value_id", nullable = false)
    private Long valueId;    
    
    /** Creates a new instance of ListTableCollectionPK */
    public ListTableCollectionPK() {
    }
    
    public ListTableCollectionPK(Long listTableId, Long collectionId, Long valueId) {
        this.setlistTableId(listTableId);
        this.setcollectionId(collectionId);
        this.setvalueId(valueId);
    }
    
    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.listTableId != null ? this.listTableId.hashCode() : 0);
        hash += (this.getcollectionId() != null ? this.getcollectionId().hashCode() : 0);
        hash += (this.getvalueId() != null ? this.getvalueId().hashCode() : 0);
        return hash;
    }
    
    /**
     * Determines whether another object is equal to this CollectorPK.  The result is 
     * <code>true</code> if and only if the argument is not null and is a CollectorPK object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListTableCollectionPK)) {
            return false;
        }
        ListTableCollectionPK other = (ListTableCollectionPK)object;
        if (this.getlistTableId() != other.getlistTableId() && (this.getlistTableId() == null || !this.getlistTableId().equals(other.getlistTableId()))) return false;
        if (this.getcollectionId() != other.getcollectionId()&& (this.getcollectionId()== null || !this.getcollectionId().equals(other.getcollectionId()))) return false;
        if (this.getvalueId() != other.getvalueId()&& (this.getvalueId()== null || !this.getvalueId().equals(other.getvalueId()))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.collection.ListTableCollectionPK[listTableId=" + getlistTableId() + ", collectionId=" + getcollectionId() + ", valueId=" + getvalueId() + "]";
    }

    public Long getlistTableId() {
        return listTableId;
    }

    public void setlistTableId(Long listTableId) {
        this.listTableId = listTableId;
    }

    public Long getcollectionId() {
        return collectionId;
    }

    public void setcollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    public Long getvalueId() {
        return valueId;
    }

    public void setvalueId(Long valueId) {
        this.valueId = valueId;
    }
}
