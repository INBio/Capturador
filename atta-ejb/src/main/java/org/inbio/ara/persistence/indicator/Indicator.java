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


package org.inbio.ara.persistence.indicator;


import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author gsulca
 */
@Entity
@Table(name = "indicator")

public class Indicator extends LogGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="indicator")
    @SequenceGenerator(name="indicator", sequenceName="indicator_seq")
    @Basic(optional = false)
    @Column(name = "indicator_id")
    private Long indicatorId;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "applies_to_parts")
    private Long appliesToParts;
/*
    @OneToMany(mappedBy = "indicatorAncestorId", fetch = FetchType.LAZY)
    private List<Indicator> indicatorCollection;
*/
    /*@JoinColumn(name = "indicator_ancestor_id", referencedColumnName = "indicator_id")
    @ManyToOne*/
    @Column(name = "indicator_ancestor_id")
    private Long indicatorAncestorId;

    public Indicator() {
    }

    public Indicator(Long indicatorId) {
        this.indicatorId = indicatorId;
    }

    public Indicator(Long indicatorId, String name, String createdBy,
            Calendar creationDate, String lastModificationBy, Calendar lastModificationDate,
            String description, Long appliesToParts) {
        this.indicatorId = indicatorId;
        this.name = name;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
        this.description = description;
        this.appliesToParts = appliesToParts;
    }

    public Long getIndicatorId() {
        return indicatorId;
    }

    public void setIndicatorId(Long indicatorId) {
        this.indicatorId = indicatorId;
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

    public Long getAppliesToParts() {
        return appliesToParts;
    }

    public void setAppliesToParts(Long appliesToParts) {
        this.appliesToParts = appliesToParts;
    }
/*
    public List<Indicator> getIndicatorCollection() {
        return indicatorCollection;
    }

    public void setIndicatorCollection(List<Indicator> indicatorCollection) {
        this.indicatorCollection = indicatorCollection;
    }
*/
    public Long getIndicatorAncestorId() {
        return indicatorAncestorId;
    }

    public void setIndicatorAncestorId(Long indicatorAncestorId) {
        this.indicatorAncestorId = indicatorAncestorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (indicatorId != null ? indicatorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Indicator)) {
            return false;
        }
        Indicator other = (Indicator) object;
        if ((this.indicatorId == null && other.indicatorId != null) || (this.indicatorId != null && !this.indicatorId.equals(other.indicatorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.indicator.Indicator[indicatorId=" + indicatorId + "]";
    }

}
