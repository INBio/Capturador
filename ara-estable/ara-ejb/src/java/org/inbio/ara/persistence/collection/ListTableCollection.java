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
 * ListTableCollection.java
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
 * Entity class ListTableCollection
 * 
 * @author roaguilar
 */
@Entity()
@Table(name = "list_table_collection")
public class ListTableCollection extends genericEntity {

    @EmbeddedId
    private ListTableCollectionPK listTableCollectionPK;
    
    @JoinColumn(name="list_table_id", referencedColumnName="list_table_id", insertable = false, updatable=false)
    @ManyToOne()
    private ListTable listTable;
    
    @JoinColumn(name="collection_id", referencedColumnName="collection_id", insertable = false, updatable=false)
    @ManyToOne()
    private Collection collection;
    
    /** Creates a new instance of ListTableCollection */
    public ListTableCollection() {
    }
    
    public ListTableCollection(ListTableCollectionPK listTableCollectionPK) {
        this.setListTableCollectionPK(listTableCollectionPK);
    }
    
    public ListTableCollection(Long collectionId, Long protocolAttributeId, Long valueId) {
        this.setListTableCollectionPK(new ListTableCollectionPK(collectionId, protocolAttributeId, valueId));
    }

    public ListTableCollectionPK getListTableCollectionPK() {
        return listTableCollectionPK;
    }

    public void setListTableCollectionPK(ListTableCollectionPK listTableCollectionPK) {
        this.listTableCollectionPK = listTableCollectionPK;
    }

    public ListTable getListTable() {
        return listTable;
    }

    public void setLisTable(ListTable listTable) {
        this.listTable = listTable;
    }

    public Collection getProtocolAttribute() {
        return getCollection();
    }

    public void setProtocolAttribute(Collection collection) {
        this.setCollection(collection);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.listTableCollectionPK != null ? this.listTableCollectionPK.hashCode() : 0);
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
        if (!(object instanceof ListTableCollection)) {
            return false;
        }
        ListTableCollection other = (ListTableCollection)object;
        if (this.listTableCollectionPK != other.listTableCollectionPK && (this.listTableCollectionPK == null || !this.listTableCollectionPK.equals(other.listTableCollectionPK))) return false;
        return true;
    }
    
    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.collection.ListTableCollection[listTableCollectionPK=" + listTableCollectionPK + "]";
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
