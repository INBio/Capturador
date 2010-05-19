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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.persistence.LogGenericEntity;


/**
 *
 * @author gsulca
 */
@Entity
@Table(name = "dublin_core")

public class DublinCore extends LogGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="dublin_core")
    @SequenceGenerator(name="dublin_core", sequenceName="dublin_core_seq")
    @Basic(optional = false)
    @Column(name = "dublin_core_id")
    private Long dublinCoreId;

    @Basic(optional = false)
    @Column(name = "title")
    private String title;

    @Column(name = "subject")
    private String subject;

    @Column(name = "description")
    private String description;

    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Calendar date;

    @Basic(optional = false)
    @Column(name = "identifier")
    private String identifier;

    @Column(name = "source")
    private String source;

    @Column(name = "relation")
    private String relation;

    @Column(name = "coverage")
    private String coverage;

    @Column(name = "rights_management")
    private String rightsManagement;

    /*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dublinCoreId")
    private Collection<DublinCoreEntity> dublinCoreEntityCollection;*/

    @Column(name = "dublin_core_format_id")
    private Long dublinCoreFormatId;

    @Column(name = "dublin_core_type_id")
    private Long dublinCoreTypeId;

    @Column(name = "language_id")
    private Long languageId;

    public DublinCore() {
    }

    public DublinCore(Long dublinCoreId) {
        this.dublinCoreId = dublinCoreId;
    }

    public DublinCore(Long dublinCoreId, String title, Calendar date, String identifier, String createdBy,
            Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.dublinCoreId = dublinCoreId;
        this.title = title;
        this.date = date;
        this.identifier = identifier;

        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getDublinCoreId() {
        return dublinCoreId;
    }

    public void setDublinCoreId(Long dublinCoreId) {
        this.dublinCoreId = dublinCoreId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getCoverage() {
        return coverage;
    }

    public void setCoverage(String coverage) {
        this.coverage = coverage;
    }

    public String getRightsManagement() {
        return rightsManagement;
    }

    public void setRightsManagement(String rightsManagement) {
        this.rightsManagement = rightsManagement;
    }

    
    public Long getDublinCoreFormatId() {
        return dublinCoreFormatId;
    }

    public void setDublinCoreFormatId(Long dublinCoreFormatId) {
        this.dublinCoreFormatId = dublinCoreFormatId;
    }

    public Long getDublinCoreTypeId() {
        return dublinCoreTypeId;
    }

    public void setDublinCoreTypeId(Long dublinCoreTypeId) {
        this.dublinCoreTypeId = dublinCoreTypeId;
    }

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dublinCoreId != null ? dublinCoreId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DublinCore)) {
            return false;
        }
        DublinCore other = (DublinCore) object;
        if ((this.dublinCoreId == null && other.dublinCoreId != null) || (this.dublinCoreId != null && !this.dublinCoreId.equals(other.dublinCoreId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.indicator.DublinCore[dublinCoreId=" + dublinCoreId + "]";
    }

}
