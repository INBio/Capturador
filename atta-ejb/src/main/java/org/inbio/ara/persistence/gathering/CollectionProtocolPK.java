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
import javax.persistence.Embeddable;

/**
 *
 * @author esmata
 */
@Embeddable
public class CollectionProtocolPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "collection_id")
    private Long collectionId;

    @Basic(optional = false)
    @Column(name = "protocol_attribute_id")
    private Long protocolAttributeId;

    public CollectionProtocolPK() {
    }

    public CollectionProtocolPK(Long collectionId, Long protocolAttributeId) {
        this.collectionId = collectionId;
        this.protocolAttributeId = protocolAttributeId;
    }

    public Long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    public Long getProtocolAttributeId() {
        return protocolAttributeId;
    }

    public void setProtocolAttributeId(Long protocolAttributeId) {
        this.protocolAttributeId = protocolAttributeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (collectionId != null ? collectionId.hashCode() : 0);
        hash += (protocolAttributeId != null ? protocolAttributeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CollectionProtocolPK)) {
            return false;
        }
        CollectionProtocolPK other = (CollectionProtocolPK) object;
        if ((this.collectionId == null && other.collectionId != null) || (this.collectionId != null && !this.collectionId.equals(other.collectionId))) {
            return false;
        }
        if ((this.protocolAttributeId == null && other.protocolAttributeId != null) || (this.protocolAttributeId != null && !this.protocolAttributeId.equals(other.protocolAttributeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.gathering.CollectionProtocolPK[collectionId=" + collectionId + ", protocolAttributeId=" + protocolAttributeId + "]";
    }

}
