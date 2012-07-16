/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Nacional de Biodiversidad)
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

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "concept")

public class Concept extends LogGenericEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "concept_id")
    private Long conceptId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
    
        @OneToMany(mappedBy = "concept")
    private List<Language> languageCollection;

    public Concept() {
    }

    public Concept(Long conceptId) {
        this.conceptId = conceptId;
    }

    public Long getConceptId() {
        return conceptId;
    }

    public void setConceptId(Long conceptId) {
        this.conceptId = conceptId;
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

    public List<Language> getLanguageCollection() {
        return languageCollection;
    }

    public void setLanguageCollection(List<Language> languageCollection) {
        this.languageCollection = languageCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conceptId != null ? conceptId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Concept)) {
            return false;
        }
        Concept other = (Concept) object;
        if ((this.conceptId == null && other.conceptId != null) || (this.conceptId != null && !this.conceptId.equals(other.conceptId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.Concept[conceptId=" + conceptId + "]";
    }

}
