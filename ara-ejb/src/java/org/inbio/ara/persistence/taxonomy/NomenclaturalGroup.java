/* Ara - capture species and specimen data
 *
 * Copyright © 2010 INBio (Instituto Nacional de Biodiversidad)
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

package org.inbio.ara.persistence.taxonomy;

import java.util.Calendar;
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
 * @author esmata
 */
@Entity
@Table(name = "nomenclatural_group")
public class NomenclaturalGroup extends LogGenericEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,
        generator="NomenclaturalGroup")
    @SequenceGenerator(name="NomenclaturalGroup",
        sequenceName="nomenclatural_group_seq")
    @Basic(optional = false)
    @Column(name = "nomenclatural_group_id")
    private Long nomenclaturalGroupId;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "temporality")
    private String temporality;

    @Basic(optional = false)
    @Column(name = "common_name")
    private Character commonName;

    @Column(name = "collection_id")
    private Long collectionId;

    @Column(name = "notes")
    private String notes;

//    @JoinColumn(name = "certificator_person_id", referencedColumnName = "person_id")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Person certificatorPersonId;
    @Column(name = "certificator_person_id")
    private Long certificatorPersonId;

    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "nomenclaturalGroup", fetch = FetchType.LAZY)
    private List<UserNomenclaturalGroup> userNomenclaturalGroupCollection;*/

    public NomenclaturalGroup() {
    }

    public NomenclaturalGroup(Long nomenclaturalGroupId) {
        this.nomenclaturalGroupId = nomenclaturalGroupId;
    }

    public NomenclaturalGroup(Long nomenclaturalGroupId, String name, 
            Character commonName, String createdBy, Calendar creationDate,
            String lastModificationBy, Calendar lastModificationDate) {
        this.nomenclaturalGroupId = nomenclaturalGroupId;
        this.name = name;
        this.commonName = commonName;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getNomenclaturalGroupId() {
        return nomenclaturalGroupId;
    }

    public void setNomenclaturalGroupId(Long nomenclaturalGroupId) {
        this.nomenclaturalGroupId = nomenclaturalGroupId;
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

    public String getTemporality() {
        return temporality;
    }

    public void setTemporality(String temporality) {
        this.temporality = temporality;
    }

    public Character getCommonName() {
        return commonName;
    }

    public void setCommonName(Character commonName) {
        this.commonName = commonName;
    }

    public Long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    /*public List<UserNomenclaturalGroup> getUserNomenclaturalGroupCollection() {
        return userNomenclaturalGroupCollection;
    }

    public void setUserNomenclaturalGroupCollection(List<UserNomenclaturalGroup> userNomenclaturalGroupCollection) {
        this.userNomenclaturalGroupCollection = userNomenclaturalGroupCollection;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomenclaturalGroupId != null ? nomenclaturalGroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NomenclaturalGroup)) {
            return false;
        }
        NomenclaturalGroup other = (NomenclaturalGroup) object;
        if ((this.nomenclaturalGroupId == null && other.nomenclaturalGroupId != null) || (this.nomenclaturalGroupId != null && !this.nomenclaturalGroupId.equals(other.nomenclaturalGroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.NomenclaturalGroup[nomenclaturalGroupId=" + nomenclaturalGroupId + "]";
    }

    /**
     * @return the certificatorPersonId
     */
    public Long getCertificatorPersonId() {
        return certificatorPersonId;
    }

    /**
     * @param certificatorPersonId the certificatorPersonId to set
     */
    public void setCertificatorPersonId(Long certificatorPersonId) {
        this.certificatorPersonId = certificatorPersonId;
    }

}
