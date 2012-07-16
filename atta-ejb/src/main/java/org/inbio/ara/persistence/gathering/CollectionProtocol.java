/*
 *  Ara - Capture Species and Specimen Data
 *
 * Copyright © 2009  INBio (Instituto Nacional de Biodiversidad).
 * Heredia, Costa Rica.
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

package org.inbio.ara.persistence.gathering;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.inbio.ara.persistence.GenericEntity;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "collection_protocol")

public class CollectionProtocol extends GenericEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected CollectionProtocolPK collectionProtocolPK;

    @Basic(optional = false)
    @Column(name = "value")
    private String value;

    public CollectionProtocol() {
    }

    public CollectionProtocol(CollectionProtocolPK collectionProtocolPK) {
        this.collectionProtocolPK = collectionProtocolPK;
    }

    public CollectionProtocol(CollectionProtocolPK collectionProtocolPK, String value) {
        this.collectionProtocolPK = collectionProtocolPK;
        this.value = value;
    }

    public CollectionProtocol(Long collectionId, Long protocolAttributeId) {
        this.collectionProtocolPK = new CollectionProtocolPK(collectionId, protocolAttributeId);
    }

    public CollectionProtocolPK getCollectionProtocolPK() {
        return collectionProtocolPK;
    }

    public void setCollectionProtocolPK(CollectionProtocolPK collectionProtocolPK) {
        this.collectionProtocolPK = collectionProtocolPK;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (collectionProtocolPK != null ? collectionProtocolPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CollectionProtocol)) {
            return false;
        }
        CollectionProtocol other = (CollectionProtocol) object;
        if ((this.collectionProtocolPK == null && other.collectionProtocolPK != null) || (this.collectionProtocolPK != null && !this.collectionProtocolPK.equals(other.collectionProtocolPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.gathering.CollectionProtocol[collectionProtocolPK=" + collectionProtocolPK + "]";
    }

}
