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
import java.util.Calendar;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.persistence.GenericEntity;
import org.inbio.ara.persistence.gis.Site;
import org.inbio.ara.persistence.person.Person;

/**
 *
 * @author herson
 */
@Entity
@Table(name = "gathering_observation")
public class GatheringObservation extends GenericEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="GatheringObservation")
	@SequenceGenerator(name="GatheringObservation", sequenceName="gathering_observation_seq")
    @Basic(optional = false)
    @Column(name = "gathering_observation_id")
    private Long gatheringObservationId;

    @Column(name = "initial_date")
    @Temporal(TemporalType.DATE)
    private Calendar initialDate;

    @Column(name = "final_date")
    @Temporal(TemporalType.DATE)
    private Calendar finalDate;

    @Column(name = "surroundings_description")
    private String surroundingsDescription;

    @Column(name = "minimum_elevation")
    private Double minimumElevation;

    @Column(name = "maximum_elevation")
    private Double maximumElevation;

    @Column(name = "site_description")
    private String siteDescription;

    @Column(name = "gradient_percentage")
    private Long gradientPercentage;

    @Column(name = "minimum_depth")
    private Double minimumDepth;

    @Column(name = "maximum_depth")
    private Double maximumDepth;

    @Column(name = "collection_id")
    private Long collectionId;

    @Column(name = "exposition_id")
    private Long expositionId;

    @Column(name = "label_id")
    private Long labelId;

    @Column(name = "original_label_id")
    private Long originalLabelId;

    @JoinColumn(name = "responsible_person_id", referencedColumnName = "person_id", insertable=false, updatable=false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Person responsiblePerson;

    @Column(name = "responsible_person_id")
    private Long responsiblePersonId;

    @Column(name = "sampling_type_id")
    private Long samplingTypeId;

    @JoinColumn(name = "site_id", referencedColumnName = "site_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Site site;

    //@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "gatheringObservation")
    //private List<CollectorObserver> collectorObserverList;

    //@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "gatheringObservation")
    //private List<GatheringObservationProject> gatheringProjectList;

    //@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "gatheringObservation")
    //private List<GatheringObservationCollection> gatheringCollectionList;

	@JoinColumn(name = "gathering_observation_id", referencedColumnName = "gathering_observation_id", insertable=false, updatable=false)
	@OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
	private List<CollectorObserver> collectorObserverList;

	@JoinColumn(name = "gathering_observation_id", referencedColumnName = "gathering_observation_id", insertable=false,updatable=false)
	@OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
	private List<GatheringObservationCollection> gatheringCollectionList;

	@JoinColumn(name = "gathering_observation_id", referencedColumnName = "gathering_observation_id", insertable=false,updatable=false)
	@OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
	private List<GatheringObservationProject> gatheringProjectList;

    public GatheringObservation() {
    }

    public GatheringObservation(Long gatheringObservationId) {
        this.gatheringObservationId = gatheringObservationId;
    }

    public GatheringObservation(Long gatheringObservationId, String createdBy, 
            Calendar creationDate, String lastModificationBy,
            Calendar lastModificationDate) {
        this.gatheringObservationId = gatheringObservationId;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getGatheringObservationId() {
        return gatheringObservationId;
    }

    public void setGatheringObservationId(Long gatheringObservationId) {
        this.gatheringObservationId = gatheringObservationId;
    }

    public Calendar getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Calendar initialDate) {
        this.initialDate = initialDate;
    }

    public Calendar getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Calendar finalDate) {
        this.finalDate = finalDate;
    }

    public String getSurroundingsDescription() {
        return surroundingsDescription;
    }

    public void setSurroundingsDescription(String surroundingsDescription) {
        this.surroundingsDescription = surroundingsDescription;
    }

    public Double getMinimumElevation() {
        return minimumElevation;
    }

    public void setMinimumElevation(Double minimumElevation) {
        this.minimumElevation = minimumElevation;
    }

    public Double getMaximumElevation() {
        return maximumElevation;
    }

    public void setMaximumElevation(Double maximumElevation) {
        this.maximumElevation = maximumElevation;
    }

    public String getSiteDescription() {
        return siteDescription;
    }

    public void setSiteDescription(String siteDescription) {
        this.siteDescription = siteDescription;
    }

    public Long getGradientPercentage() {
        return gradientPercentage;
    }

    public void setGradientPercentage(Long gradientPercentage) {
        this.gradientPercentage = gradientPercentage;
    }

    public Double getMinimumDepth() {
        return minimumDepth;
    }

    public void setMinimumDepth(Double minimumDepth) {
        this.minimumDepth = minimumDepth;
    }

    public Double getMaximumDepth() {
        return maximumDepth;
    }

    public void setMaximumDepth(Double maximumDepth) {
        this.maximumDepth = maximumDepth;
    }

    public Long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    public Long getExpositionId() {
        return expositionId;
    }

    public void setExpositionId(Long expositionId) {
        this.expositionId = expositionId;
    }

    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    public Long getOriginalLabelId() {
        return originalLabelId;
    }

    public void setOriginalLabelId(Long originalLabelId) {
        this.originalLabelId = originalLabelId;
    }

    public Long getResponsiblePersonId() {
        return responsiblePersonId;
    }

    public void setResponsiblePersonId(Long responsiblePersonId) {
        this.responsiblePersonId = responsiblePersonId;
    }

    public Long getSamplingTypeId() {
        return samplingTypeId;
    }

    public void setSamplingTypeId(Long samplingTypeId) {
        this.samplingTypeId = samplingTypeId;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gatheringObservationId != null ? gatheringObservationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GatheringObservation)) {
            return false;
        }
        GatheringObservation other = (GatheringObservation) object;
        if ((this.gatheringObservationId == null && other.gatheringObservationId != null) || (this.gatheringObservationId != null && !this.gatheringObservationId.equals(other.gatheringObservationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.gathering.GatheringObservation[gatheringObservationId=" + gatheringObservationId + "]";
    }

    /**
     * @return the responsiblePerson
     */
    public Person getResponsiblePerson() {
        return responsiblePerson;
    }

    /**
     * @param responsiblePerson the responsiblePerson to set
     */
    public void setResponsiblePerson(Person responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    /**
     * @return the collectorObserverList
     */
    public List<CollectorObserver> getCollectorObserverList() {
        return collectorObserverList;
    }

    /**
     * @param collectorObserverList the collectorObserverList to set
     */
    public void setCollectorObserverList(List<CollectorObserver> collectorObserverList) {
        this.collectorObserverList = collectorObserverList;
    }

    /**
     * @return the gatheringProjectList
     */
    public List<GatheringObservationProject> getGatheringProjectList() {
        return gatheringProjectList;
    }

    /**
     * @param gatheringProjectList the gatheringProjectList to set
     */
    public void setGatheringProjectlist(List<GatheringObservationProject> gatheringProjectSet) {
        this.gatheringProjectList = gatheringProjectSet;
    }

    /**
     * @return the gatheringCollectionList
     */
    public List<GatheringObservationCollection> getGatheringCollectionList() {
        return gatheringCollectionList;
    }

    /**
     * @param gatheringCollectionList the gatheringCollectionList to set
     */
    public void setGatheringCollectionList(List<GatheringObservationCollection> gatheringCollectionList) {
        this.gatheringCollectionList = gatheringCollectionList;
    }

}
