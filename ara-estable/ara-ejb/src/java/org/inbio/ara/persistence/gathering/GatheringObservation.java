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
 * Gathering.java
 *
 * Created on October 28, 2007, 3:33 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.gathering;

import java.util.Date;
import java.util.List;
import java.util.Set;
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
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.inbio.ara.persistence.collection.Collection;
import org.inbio.ara.persistence.genericEntity;
import org.inbio.ara.persistence.gis.Site;
import org.inbio.ara.persistence.person.Person;

/**
 * Entity class Gathering
 *
 * @author roaguilar
 */
@Entity()
@Table(name = "gathering_observation")
@TableGenerator(name="gathering_observation_id_gen",table="ID_GEN",pkColumnName="GEN_KEY",valueColumnName="GEN_VALUE",pkColumnValue="gathering_observation_id",allocationSize=1)
public class GatheringObservation extends genericEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="gathering_observation_id_gen")
    @Column(name = "gathering_observation_id", nullable = false)
    private Long id;
    
    @Temporal(TemporalType.DATE)
    @Column(name="initial_date", nullable = false)
    private Date initialDate;
    
    @Temporal(TemporalType.DATE)
    @Column(name="final_date", nullable = false)
    private Date finalDate;
    
    @Column(name="surroundings_description", length=4000)
    private String surroundingsDescription;
    
    @Column(name="site_description", length=4000)
    private String siteDescription;
    
    @Column(name="minimum_elevation")
    private Long minimumElevation;
    
    @Column(name="maximum_elevation")
    private Long maximum_elevation;
    
    @Column(name="minimum_depth")
    private Long minimumDepth;
    
    @Column(name="maximum_depth")
    private Long maximumDepth;
    
    @Column(name="gradient_percentage")
    private Long gradientPercentage;

    //@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "gathering")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "gathering")
    private Set<GatheringObservationProject> gatheringProjectSet;
    
    //@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "gathering")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "gathering")
    private Set<GatheringObservationCollection> gatheringCollectionSet;
    
    //@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "gatheringObservation")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "gatheringObservation")
    private Set<GatheringObservationDetail> gatheringDetailSet;
    
    @OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "gatheringObservation")
    private List<CollectorObserver> collectorObserverList;
    
    @JoinColumn(name="site_id", referencedColumnName="site_id")
    @ManyToOne()
    private Site site;
    
    @JoinColumn(name="exposition_id", referencedColumnName="exposition_id")
    @ManyToOne()
    private Exposition exposition;
    
    @JoinColumn(name="responsible_person_id", referencedColumnName="person_id")
    @ManyToOne()
    private Person responsiblePerson;
    
    @JoinColumn(name="collection_id", referencedColumnName="collection_id")
    @ManyToOne()
    private Collection collection;
    
    @JoinColumn(name="label_id", referencedColumnName="label_id")
    @ManyToOne()
    private Label label;

    @JoinColumn(name="original_label_id", referencedColumnName="original_label_id")
    @ManyToOne()
    private OriginalLabel originalLabel;
    
    @Transient
    private String siteName;
    
    @Transient
    private String responsibleName;
    
    @Transient
    private String projectName;
    
    @Transient
    private String collectionName;
    
    @Transient
    private String summary;
    
    @Transient
    private String firstCollectorObserverName = "";
    
    /** Creates a new instance of Gathering */
    public GatheringObservation() {
    }
    
    /**
     * Gets the id of this Gathering.
     * @return the id
     */
    public Long getId() {
        return this.id;
    }
    
    /**
     * Returns a hash code value for the object.  This implementation computes
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }
    
    /**
     * Determines whether another object is equal to this Gathering.  The result is
     * <code>true</code> if and only if the argument is not null and is a Gathering object that
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GatheringObservation)) {
            return false;
        }
        GatheringObservation other = (GatheringObservation)object;
        if (this.getId() != other.getId() && (this.getId() == null || !this.getId().equals(other.getId()))) return false;
        return true;
    }
    
    /**
     * Returns a string representation of the object.  This implementation constructs
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.gathering.Gathering[id=" + getId() + "]";
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public String getSurroundingsDescription() {
        return surroundingsDescription;
    }

    public void setSurroundingsDescription(String surroundingsDescription) {
        this.surroundingsDescription = surroundingsDescription;
    }

    public String getGatheringSiteDescription() {
        return siteDescription;
    }

    public void setGatheringSiteDescription(String gatheringSiteDescription) {
        this.siteDescription = gatheringSiteDescription;
    }

    public Long getMinimumElevation() {
        return minimumElevation;
    }

    public void setMinimumElevation(Long minimumElevation) {
        this.minimumElevation = minimumElevation;
    }

    public Long getMaximumElevation() {
        return maximum_elevation;
    }

    public void setMaximumElevation(Long maximumElevation) {
        this.maximum_elevation = maximumElevation;
    }

    public Long getMinimumDepth() {
        return minimumDepth;
    }

    public void setMinimumDepth(Long minimumDepth) {
        this.minimumDepth = minimumDepth;
    }

    public Long getMaximumDepth() {
        return maximumDepth;
    }

    public void setMaximumDepth(Long minimumDepth) {
        this.maximumDepth = minimumDepth;
    }

    public Long getGradientPercentage() {
        return gradientPercentage;
    }

    public void setGradientPercentage(Long gradientPercentage) {
        this.gradientPercentage = gradientPercentage;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Person getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(Person responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public OriginalLabel getOriginalLabel() {
        return originalLabel;
    }

    public void setOriginalLabel(OriginalLabel originalLabel) {
        this.originalLabel = originalLabel;
    }

    public Set<GatheringObservationDetail> getGatheringDetailSet() {
        return gatheringDetailSet;
    }

    public void setGatheringDetailSet(Set<GatheringObservationDetail> gatheringDetailSet) {
        this.gatheringDetailSet = gatheringDetailSet;
    }

    public void setExposition(Exposition exposition) {
        this.exposition = exposition;
    }
    
    public Exposition getExposition() {
        return this.exposition;
    }

    public String getSiteName() {
        return siteName;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    @PostLoad
    public void postLoad(){
        this.siteName = this.site.getDescription();
        this.responsibleName = this.responsiblePerson.getFormalFullName();
        this.collectionName = this.collection.getName();
        
        String tmpSummary = "";
        tmpSummary = "Id." + this.getId() + ", ";
        tmpSummary += this.getSite().getFirstCoordinate() + " - " + this.getSite().getDescription() + ", ";
        if (this.initialDate.equals(this.finalDate)) {
            tmpSummary += this.initialDate.toString() + ", ";
        } else {
            tmpSummary += this.initialDate.toString() + " - " + this.finalDate.toString() + ", ";
        }
        if (this.minimumElevation!= null) {
            if(this.minimumElevation.equals(this.maximum_elevation)) {
                tmpSummary += this.minimumElevation + " - " + this.maximum_elevation + " mts, ";
            }
        }
        this.setSummary(tmpSummary);
        
        if (this.collectorObserverList!= null) {
            if (this.collectorObserverList.size() > 0) {
                CollectorObserver obj = (CollectorObserver)this.collectorObserverList.get(0);
                String tmpName;
                if (obj!= null) {
                    tmpName = obj.getCollectorObserverName();
                } else {
                    tmpName = "";
                }
                this.firstCollectorObserverName = tmpName;
            }
        }
    }

    public Set<GatheringObservationProject> getGatheringProjectSet() {
        return gatheringProjectSet;
    }

    public void setGatheringProjectSet(Set<GatheringObservationProject> gatheringProjectSet) {
        this.gatheringProjectSet = gatheringProjectSet;
    }

    public Set<GatheringObservationCollection> getGatheringCollectionSet() {
        return gatheringCollectionSet;
    }

    public void setGatheringCollectionSet(Set<GatheringObservationCollection> gatheringCollectionSet) {
        this.gatheringCollectionSet = gatheringCollectionSet;
    }

    public List<CollectorObserver> getCollectorObserverList() {
        return collectorObserverList;
    }

    public void setCollectorObserverList(List<CollectorObserver> collectorObserverList) {
        this.collectorObserverList = collectorObserverList;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getFirstCollectorObserverName() {
        return firstCollectorObserverName;
    }

    public void setFirstCollectorObserverName(String firstCollectorObserverName) {
        this.firstCollectorObserverName = firstCollectorObserverName;
    }
    
}
