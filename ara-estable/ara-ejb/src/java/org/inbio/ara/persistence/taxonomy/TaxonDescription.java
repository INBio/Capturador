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
 * TaxonDescription.java
 *
 * Created on October 21, 2007, 10:14 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.taxonomy;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.inbio.ara.persistence.genericEntity;
import org.inbio.ara.persistence.species.StageTransitionDate;
import org.inbio.ara.persistence.species.TaxonDescriptionAudience;
import org.inbio.ara.persistence.species.TaxonDescriptionInstitution;
import org.inbio.ara.persistence.species.TaxonDescriptionPersonProfile;
import org.inbio.ara.persistence.species.TaxonDescriptionRecord;
import org.inbio.ara.persistence.species.TaxonDescriptionStage;
import org.inbio.ara.persistence.util.Language;

/**
 * Entity class TaxonDescription
 * 
 * @author roaguilar
 */
@Entity
@Table(name="taxon_description")
public class TaxonDescription extends genericEntity {

    @EmbeddedId
    private TaxonDescriptionPK taxonDescriptionPK;
    
    @Column(name="url")
    private String url;
    
    @Column(name="title")
    private String title;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "taxonDescription")
    private Set<TaxonDescriptionRecord> taxonDescriptionRecordSet;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "taxonDescription")
    private Set<StageTransitionDate> stageTransitionDateSet;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "taxonDescription")
    private Set<TaxonDescriptionAudience> taxonDescriptionAudienceSet;    
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "taxonDescription")
    private Set<TaxonDescriptionInstitution> taxonDescriptionInstitutionSet;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "taxonDescription")
    private Set<TaxonDescriptionPersonProfile> taxonDescriptionPersonProfileSet;    
    
    @JoinColumn(name="taxon_id", referencedColumnName="taxon_id", insertable = false, updatable=false)
    @ManyToOne()
    private Taxon taxon;
    
    @JoinColumn(name="language_id", referencedColumnName="language_id")
    @ManyToOne()
    private Language language;
    
    @JoinColumn(name="taxon_description_stage_id", referencedColumnName="taxon_description_stage_id")
    @ManyToOne()
    private TaxonDescriptionStage taxonDescriptionStage;
    
    /** Creates a new instance of TaxonDescription */
    public TaxonDescription() {
    }
    
    public TaxonDescription(TaxonDescriptionPK taxonDescriptionPK) {
        this.setTaxonDescriptionPK(taxonDescriptionPK);
    }
    
    public TaxonDescription(Long taxonId, Long taxonDescriptionSequence, String url) {
        this.setTaxonDescriptionPK(new TaxonDescriptionPK());
        this.getTaxonDescriptionPK().setTaxonDescriptionSequence(taxonDescriptionSequence);
        this.getTaxonDescriptionPK().setTaxonId(taxonId);
        this.setUrl(url);
    }

    public TaxonDescriptionPK getTaxonDescriptionPK() {
        return taxonDescriptionPK;
    }

    public void setTaxonDescriptionPK(TaxonDescriptionPK TaxonDescriptionPK) {
        this.taxonDescriptionPK = TaxonDescriptionPK;
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<TaxonDescriptionRecord> getTaxonDescriptionRecordSet() {
        return taxonDescriptionRecordSet;
    }

    public void setTaxonDescriptionRecordSet(Set<TaxonDescriptionRecord> taxonDescriptionRecordSet) {
        this.taxonDescriptionRecordSet = taxonDescriptionRecordSet;
    }

    public Taxon getTaxon() {
        return taxon;
    }

    public void setTaxon(Taxon taxon) {
        this.taxon = taxon;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public TaxonDescriptionStage getTaxonDescriptionStage() {
        return taxonDescriptionStage;
    }

    public void setTaxonDescriptionStage(TaxonDescriptionStage taxonDescriptionStage) {
        this.taxonDescriptionStage = taxonDescriptionStage;
    }
    
}
