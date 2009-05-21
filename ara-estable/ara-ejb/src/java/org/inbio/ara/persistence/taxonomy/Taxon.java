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
 * Taxon.java
 *
 * Created on June 17, 2007, 6:50 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.taxonomy;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;
import org.inbio.ara.persistence.genericEntity;
import javax.persistence.OneToMany;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.CascadeType;
import org.inbio.ara.persistence.person.PersonProfileTaxon;
import java.util.Set;
import javax.persistence.FetchType;
import org.inbio.ara.persistence.collection.Collection;

/**
 * Entity class Taxon
 * 
 * 
 * @author roaguilar
 */
@Entity
@Table(name = "taxon")
@NamedQueries ({
    @NamedQuery(name ="Taxon.findByTaxonId", query = "SELECT t FROM Taxon t WHERE t.id = :taxonId")
    //@NamedQuery(name="getSpeciesByName", query = "Select id, defaultName from Taxon where defaultName like :speciesName and taxonomicalRange.name = 'Especie'"),
    //@NamedQuery(name ="getAllSpecies", query = "Select id, defaultName from Taxon where taxonomicalRange.name = 'Especie'")
})


@TableGenerator(name="taxon_id_gen",table="ID_GEN",pkColumnName="GEN_KEY",valueColumnName="GEN_VALUE",pkColumnValue="taxon_id",allocationSize=1)
public class Taxon extends genericEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="taxon_id_gen")
    @Column(name = "taxon_id", nullable = false)
    private Long id;

    @Column(name = "current_name", nullable = false)
    private String currentName;

    @Column(name = "current_name_timestamp", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date currentNameTimestamp;

    @Column(name = "default_name", nullable = false)
    private String defaultName;

    @Column(name = "current_predecessor_timestamp")
    @Temporal(TemporalType.DATE)
    private Date currentPredecessorTimestamp;

    @Column(name = "description_month")
    private Long descriptionMonth;

    @Column(name = "description_year")
    private Long descriptionYear;

    @Column(name = "author_format_parenthesis", nullable = false)
    private Long authorFormatParenthesis;

    @Column(name = "basionym")
    private String basionym;

    @JoinColumn(name="subkingdom_taxon_id", referencedColumnName= "taxon_id")
    @ManyToOne()
    private Taxon subkingdomTaxon;
    
    @JoinColumn(name="infrakingdom_taxon_id", referencedColumnName = "taxon_id")
    @ManyToOne()
    private Taxon infrakingdomTaxon;
    
    @JoinColumn(name="superphylum_taxon_id", referencedColumnName="taxon_id")
    @ManyToOne()
    private Taxon superphylumTaxon;
    
    @JoinColumn(name="infraphylum_infradivision_taxon_id", referencedColumnName="taxon_id")
    @ManyToOne()
    private Taxon infraphylumInfradivisionTaxon;
    
    @JoinColumn(name="superclass_taxon_id", referencedColumnName="taxon_id")
    @ManyToOne()
    private Taxon superclassTaxon;
    
    @JoinColumn(name = "class_taxon_id", referencedColumnName = "taxon_id")
    @ManyToOne()
    private Taxon classTaxon;

    @JoinColumn(name = "subclass_taxon_id", referencedColumnName = "taxon_id")
    @ManyToOne()
    private Taxon subclassTaxon;

    @JoinColumn(name = "order_taxon_id", referencedColumnName = "taxon_id")
    @ManyToOne()
    private Taxon orderTaxon;

    @JoinColumn(name = "suborder_taxon_id", referencedColumnName = "taxon_id")
    @ManyToOne()
    private Taxon suborderTaxon;

    @JoinColumn(name = "superfamily_taxon_id", referencedColumnName = "taxon_id")
    @ManyToOne()
    private Taxon superfamilyTaxon;

    @JoinColumn(name = "family_taxon_id", referencedColumnName = "taxon_id")
    @ManyToOne()
    private Taxon familyTaxon;

    @JoinColumn(name = "subfamily_taxon_id", referencedColumnName = "taxon_id")
    @ManyToOne()
    private Taxon subfamilyTaxon;

    @JoinColumn(name = "tribe_taxon_id", referencedColumnName = "taxon_id")
    @ManyToOne()
    private Taxon tribeTaxon;

    @JoinColumn(name = "subtribe_taxon_id", referencedColumnName = "taxon_id")
    @ManyToOne()
    private Taxon subtribeTaxon;

    @JoinColumn(name = "subphylum_subdivision_taxon_id", referencedColumnName = "taxon_id")
    @ManyToOne()
    private Taxon subphylumSubdivisionTaxon;

    @JoinColumn(name = "subgenus_taxon_id", referencedColumnName = "taxon_id")
    @ManyToOne()
    private Taxon subgenusTaxon;

    @JoinColumn(name = "section_taxon_id", referencedColumnName = "taxon_id")
    @ManyToOne()
    private Taxon sectionTaxon;

    @JoinColumn(name = "subsection_taxon_id", referencedColumnName = "taxon_id")
    @ManyToOne()
    private Taxon subsectionTaxon;

    @JoinColumn(name = "stirps_taxon_id", referencedColumnName = "taxon_id")
    @ManyToOne()
    private Taxon stirpsTaxon;

    @JoinColumn(name = "species_taxon_id", referencedColumnName = "taxon_id")
    @ManyToOne()
    private Taxon speciesTaxon;

    @JoinColumn(name = "subspecies_taxon_id", referencedColumnName = "taxon_id")
    @ManyToOne()
    private Taxon subspeciesTaxon;

    @JoinColumn(name = "variety_taxon_id", referencedColumnName = "taxon_id")
    @ManyToOne()
    private Taxon varietyTaxon;

    @JoinColumn(name = "synonym_taxon_id", referencedColumnName = "taxon_id")
    @ManyToOne()
    private Taxon synonymTaxon;

    @JoinColumn(name = "ancestor_id", referencedColumnName = "taxon_id")
    @ManyToOne()
    private Taxon ancestor;

    @JoinColumn(name = "genus_taxon_id", referencedColumnName = "taxon_id")
    @ManyToOne()
    private Taxon genusTaxon;

    @JoinColumn(name = "dominium_taxon_id", referencedColumnName = "taxon_id")
    @ManyToOne()
    private Taxon dominiumTaxon;

    @JoinColumn(name = "kingdom_taxon_id", referencedColumnName = "taxon_id")
    @ManyToOne()
    private Taxon kingdomTaxon;

    @JoinColumn(name = "phylum_division_taxon_id", referencedColumnName = "taxon_id")
    @ManyToOne()
    private Taxon phylumDivisionTaxon;
   
    @JoinColumn(name = "taxonomical_range_id", referencedColumnName = "taxonomical_range_id")
    @ManyToOne()
    private TaxonomicalRange taxonomicalRange;
    
    @JoinColumn(name="taxon_category_id", referencedColumnName="taxon_category_id")
    @ManyToOne()
    private TaxonCategory taxonCategory;
    
    @JoinColumn(name="collection_id", referencedColumnName="collection_id")
    @ManyToOne()
    private Collection collection;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "taxon")
    private Set<PersonProfileTaxon> personProfileTaxonSet;
    
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "taxon", fetch = FetchType.EAGER)
    private Set<TaxonDescription> taxonDescriptionSet;
    
    
    @Transient
    private String familyName;
    /**
     * Creates a new instance of Taxon
     */
    public Taxon() {
    }

    /**
     * Creates a new instance of Taxon with the specified values.
     * 
     * @param taxonId the taxonId of the Taxon
     */
    public Taxon(Long taxonId) {
        this.id = taxonId;
    }

    /**
     * Creates a new instance of Taxon with the specified values.
     * 
     * @param taxonId the taxonId of the Taxon
     * @param currentName the currentName of the Taxon
     * @param currentNameTimestamp the currentNameTimestamp of the Taxon
     * @param defaultName the defaultName of the Taxon
     * @param authorFormatParenthesis the authorFormatParenthesis of the Taxon
     */
    public Taxon(String currentName, Date currentNameTimestamp, String defaultName, Long authorFormatParenthesis) {
        this.currentName = currentName;
        this.currentNameTimestamp = currentNameTimestamp;
        this.defaultName = defaultName;
        this.authorFormatParenthesis = authorFormatParenthesis;
    }

    /**
     * Gets the taxonId of this Taxon.
     * 
     * @return the taxonId
     */
    public Long getTaxonId() {
        return this.id;
    }

    /**
     * Sets the taxonId of this Taxon to the specified value.
     * 
     * @param taxonId the new taxonId
     */
    public void setTaxonId(Long taxonId) {
        this.id = taxonId;
    }

    /**
     * Gets the currentName of this Taxon.
     * 
     * @return the currentName
     */
    public String getCurrentName() {
        return this.currentName;
    }

    /**
     * Sets the currentName of this Taxon to the specified value.
     * 
     * @param currentName the new currentName
     */
    public void setCurrentName(String currentName) {
        this.currentName = currentName;
    }

    /**
     * Gets the currentNameTimestamp of this Taxon.
     * 
     * @return the currentNameTimestamp
     */
    public Date getCurrentNameTimestamp() {
        return this.currentNameTimestamp;
    }

    /**
     * Sets the currentNameTimestamp of this Taxon to the specified value.
     * 
     * @param currentNameTimestamp the new currentNameTimestamp
     */
    public void setCurrentNameTimestamp(Date currentNameTimestamp) {
        this.currentNameTimestamp = currentNameTimestamp;
    }

    /**
     * Gets the defaultName of this Taxon.
     * 
     * @return the defaultName
     */
    public String getDefaultName() {
        return this.defaultName;
    }

    /**
     * Sets the defaultName of this Taxon to the specified value.
     * 
     * @param defaultName the new defaultName
     */
    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

    /**
     * Gets the currentPredecessorTimestamp of this Taxon.
     * 
     * @return the currentPredecessorTimestamp
     */
    public Date getCurrentPredecessorTimestamp() {
        return this.currentPredecessorTimestamp;
    }

    /**
     * Sets the currentPredecessorTimestamp of this Taxon to the specified value.
     * 
     * @param currentPredecessorTimestamp the new currentPredecessorTimestamp
     */
    public void setCurrentPredecessorTimestamp(Date currentPredecessorTimestamp) {
        this.currentPredecessorTimestamp = currentPredecessorTimestamp;
    }

    /**
     * Gets the descriptionMonth of this Taxon.
     * 
     * @return the descriptionMonth
     */
    public Long getDescriptionMonth() {
        return this.descriptionMonth;
    }

    /**
     * Sets the descriptionMonth of this Taxon to the specified value.
     * 
     * @param descriptionMonth the new descriptionMonth
     */
    public void setDescriptionMonth(Long descriptionMonth) {
        this.descriptionMonth = descriptionMonth;
    }

    /**
     * Gets the descriptionYear of this Taxon.
     * 
     * @return the descriptionYear
     */
    public Long getDescriptionYear() {
        return this.descriptionYear;
    }

    /**
     * Sets the descriptionYear of this Taxon to the specified value.
     * 
     * @param descriptionYear the new descriptionYear
     */
    public void setDescriptionYear(Long descriptionYear) {
        this.descriptionYear = descriptionYear;
    }

    /**
     * Gets the authorFormatParenthesis of this Taxon.
     * 
     * @return the authorFormatParenthesis
     */
    public Long getAuthorFormatParenthesis() {
        return this.authorFormatParenthesis;
    }

    /**
     * Sets the authorFormatParenthesis of this Taxon to the specified value.
     * 
     * @param authorFormatParenthesis the new authorFormatParenthesis
     */
    public void setAuthorFormatParenthesis(Long authorFormatParenthesis) {
        this.authorFormatParenthesis = authorFormatParenthesis;
    }

    /**
     * Gets the basionym of this Taxon.
     * 
     * @return the basionym
     */
    public String getBasionym() {
        return this.basionym;
    }

    /**
     * Sets the basionym of this Taxon to the specified value.
     * 
     * @param basionym the new basionym
     */
    public void setBasionym(String basionym) {
        this.basionym = basionym;
    }

    /**
     * Gets the classTaxonId of this Taxon.
     * 
     * @return the classTaxonId
     */
    public Taxon getClassTaxon() {
        return this.classTaxon;
    }

    /**
     * Sets the classTaxonId of this Taxon to the specified value.
     * 
     * @param classTaxonId the new classTaxonId
     */
    public void setClassTaxon(Taxon classTaxon) {
        this.classTaxon = classTaxon;
    }


    /**
     * Gets the subclassTaxonId of this Taxon.
     * 
     * @return the subclassTaxonId
     */
    public Taxon getSubclassTaxon() {
        return this.subclassTaxon;
    }

    /**
     * Sets the subclassTaxonId of this Taxon to the specified value.
     * 
     * @param subclassTaxonId the new subclassTaxonId
     */
    public void setSubclassTaxon(Taxon subclassTaxon) {
        this.subclassTaxon = subclassTaxon;
    }

    /**
     * Gets the orderTaxonId of this Taxon.
     * 
     * @return the orderTaxonId
     */
    public Taxon getOrderTaxon() {
        return this.orderTaxon;
    }

    /**
     * Sets the orderTaxonId of this Taxon to the specified value.
     * 
     * @param orderTaxonId the new orderTaxonId
     */
    public void setOrderTaxon(Taxon orderTaxon) {
        this.orderTaxon = orderTaxon;
    }

    /**
     * Gets the suborderTaxonId of this Taxon.
     * 
     * @return the suborderTaxonId
     */
    public Taxon getSuborderTaxon() {
        return this.suborderTaxon;
    }

    /**
     * Sets the suborderTaxonId of this Taxon to the specified value.
     * 
     * @param suborderTaxonId the new suborderTaxonId
     */
    public void setSuborderTaxon(Taxon suborderTaxon) {
        this.suborderTaxon = suborderTaxon;
    }

    /**
     * Gets the superfamilyTaxonId of this Taxon.
     * 
     * @return the superfamilyTaxonId
     */
    public Taxon getSuperfamilyTaxon() {
        return this.superfamilyTaxon;
    }

    /**
     * Sets the superfamilyTaxonId of this Taxon to the specified value.
     * 
     * @param superfamilyTaxonId the new superfamilyTaxonId
     */
    public void setSuperfamilyTaxon(Taxon superfamilyTaxon) {
        this.superfamilyTaxon = superfamilyTaxon;
    }

    /**
     * Gets the familyTaxonId of this Taxon.
     * 
     * @return the familyTaxonId
     */
    public Taxon getFamilyTaxon() {
        return this.familyTaxon;
    }

    /**
     * Sets the familyTaxonId of this Taxon to the specified value.
     * 
     * @param familyTaxonId the new familyTaxonId
     */
    public void setFamilyTaxon(Taxon familyTaxon) {
        this.familyTaxon = familyTaxon;
    }

    /**
     * Gets the subfamilyTaxonId of this Taxon.
     * 
     * @return the subfamilyTaxonId
     */
    public Taxon getSubfamilyTaxon() {
        return this.subfamilyTaxon;
    }

    /**
     * Sets the subfamilyTaxonId of this Taxon to the specified value.
     * 
     * @param subfamilyTaxonId the new subfamilyTaxonId
     */
    public void setSubfamilyTaxon(Taxon subfamilyTaxon) {
        this.subfamilyTaxon = subfamilyTaxon;
    }

    /**
     * Gets the tribeTaxonId of this Taxon.
     * 
     * @return the tribeTaxonId
     */
    public Taxon getTribeTaxon() {
        return this.tribeTaxon;
    }

    /**
     * Sets the tribeTaxonId of this Taxon to the specified value.
     * 
     * @param tribeTaxonId the new tribeTaxonId
     */
    public void setTribeTaxon(Taxon tribeTaxon) {
        this.tribeTaxon = tribeTaxon;
    }

    /**
     * Gets the subtribeTaxonId of this Taxon.
     * 
     * @return the subtribeTaxonId
     */
    public Taxon getSubtribeTaxon() {
        return this.subtribeTaxon;
    }

    /**
     * Sets the subtribeTaxonId of this Taxon to the specified value.
     * 
     * @param subtribeTaxonId the new subtribeTaxonId
     */
    public void setSubtribeTaxon(Taxon subtribeTaxon) {
        this.subtribeTaxon = subtribeTaxon;
    }

    /**
     * Gets the subphylumSubdivisionTaxonId of this Taxon.
     * 
     * @return the subphylumSubdivisionTaxonId
     */
    public Taxon getSubphylumSubdivisionTaxon() {
        return this.subphylumSubdivisionTaxon;
    }

    /**
     * Sets the subphylumSubdivisionTaxonId of this Taxon to the specified value.
     * 
     * @param subphylumSubdivisionTaxonId the new subphylumSubdivisionTaxonId
     */
    public void setSubphylumSubdivisionTaxon(Taxon subphylumSubdivisionTaxon) {
        this.subphylumSubdivisionTaxon = subphylumSubdivisionTaxon;
    }

    /**
     * Gets the subgenusTaxonId of this Taxon.
     * 
     * @return the subgenusTaxonId
     */
    public Taxon getSubgenusTaxon() {
        return this.subgenusTaxon;
    }

    /**
     * Sets the subgenusTaxonId of this Taxon to the specified value.
     * 
     * @param subgenusTaxonId the new subgenusTaxonId
     */
    public void setSubgenusTaxon(Taxon subgenusTaxon) {
        this.subgenusTaxon = subgenusTaxon;
    }

    /**
     * Gets the sectionTaxonId of this Taxon.
     * 
     * @return the sectionTaxonId
     */
    public Taxon getSectionTaxon() {
        return this.sectionTaxon;
    }

    /**
     * Sets the sectionTaxonId of this Taxon to the specified value.
     * 
     * @param sectionTaxonId the new sectionTaxonId
     */
    public void setSectionTaxon(Taxon sectionTaxon) {
        this.sectionTaxon = sectionTaxon;
    }

    /**
     * Gets the subsectionTaxonId of this Taxon.
     * 
     * @return the subsectionTaxonId
     */
    public Taxon getSubsectionTaxon() {
        return this.subsectionTaxon;
    }

    /**
     * Sets the subsectionTaxonId of this Taxon to the specified value.
     * 
     * @param subsectionTaxonId the new subsectionTaxonId
     */
    public void setSubsectionTaxon(Taxon subsectionTaxon) {
        this.subsectionTaxon = subsectionTaxon;
    }

    /**
     * Gets the stirpsTaxonId of this Taxon.
     * 
     * @return the stirpsTaxonId
     */
    public Taxon getStirpsTaxon() {
        return this.stirpsTaxon;
    }

    /**
     * Sets the stirpsTaxonId of this Taxon to the specified value.
     * 
     * @param stirpsTaxonId the new stirpsTaxonId
     */
    public void setStirpsTaxon(Taxon stirpsTaxon) {
        this.stirpsTaxon = stirpsTaxon;
    }

    /**
     * Gets the speciesTaxonId of this Taxon.
     * 
     * @return the speciesTaxonId
     */
    public Taxon getSpeciesTaxon() {
        return this.speciesTaxon;
    }

    /**
     * Sets the speciesTaxonId of this Taxon to the specified value.
     * 
     * @param speciesTaxonId the new speciesTaxonId
     */
    public void setSpeciesTaxon(Taxon speciesTaxon) {
        this.speciesTaxon = speciesTaxon;
    }

    /**
     * Gets the subspeciesTaxonId of this Taxon.
     * 
     * @return the subspeciesTaxonId
     */
    public Taxon getSubspeciesTaxon() {
        return this.subspeciesTaxon;
    }

    /**
     * Sets the subspeciesTaxonId of this Taxon to the specified value.
     * 
     * @param subspeciesTaxonId the new subspeciesTaxonId
     */
    public void setSubspeciesTaxon(Taxon subspeciesTaxon) {
        this.subspeciesTaxon = subspeciesTaxon;
    }

    /**
     * Gets the varietyTaxonId of this Taxon.
     * 
     * @return the varietyTaxonId
     */
    public Taxon getVarietyTaxon() {
        return this.varietyTaxon;
    }

    /**
     * Sets the varietyTaxonId of this Taxon to the specified value.
     * 
     * @param varietyTaxonId the new varietyTaxonId
     */
    public void setVarietyTaxon(Taxon varietyTaxon) {
        this.varietyTaxon = varietyTaxon;
    }

    /**
     * Gets the synonymTaxonId of this Taxon.
     * 
     * @return the synonymTaxonId
     */
    public Taxon getSynonymTaxon() {
        return this.synonymTaxon;
    }

    /**
     * Sets the synonymTaxonId of this Taxon to the specified value.
     * 
     * @param synonymTaxonId the new synonymTaxonId
     */
    public void setSynonymTaxon(Taxon synonymTaxon) {
        this.synonymTaxon = synonymTaxon;
    }

    /**
     * Gets the ancestorId of this Taxon.
     * 
     * @return the ancestorId
     */
    public Taxon getAncestor() {
        return this.ancestor;
    }

    /**
     * Sets the ancestorId of this Taxon to the specified value.
     * 
     * @param ancestorId the new ancestorId
     */
    public void setAncestor(Taxon ancestor) {
        this.ancestor = ancestor;

        if (this.ancestor.getTaxonomicalRange().getFieldName().equals("dominium")) {
            this.dominiumTaxon = this.ancestor;
        } else {
            this.dominiumTaxon = this.ancestor.getDominiumTaxon();    
        }
        
        if (this.ancestor.getTaxonomicalRange().getFieldName().equals("kingdom")) {
            this.kingdomTaxon = this.ancestor;
        } else {
            this.kingdomTaxon = this.ancestor.getKingdomTaxon();
        }
        
        if (this.ancestor.getTaxonomicalRange().getFieldName().equals("phylum_division")) {
            this.phylumDivisionTaxon = this.ancestor;
        } else {
            this.phylumDivisionTaxon = this.ancestor.getPhylumDivisionTaxon();
        }
        
        if (this.ancestor.getTaxonomicalRange().getFieldName().equals("subphylum_subdivision")) {
            this.subphylumSubdivisionTaxon = this.ancestor;
        } else {
            this.subphylumSubdivisionTaxon = this.ancestor.getSubphylumSubdivisionTaxon();
        }
        
        if (this.ancestor.getTaxonomicalRange().getFieldName().equals("class")) {
            this.classTaxon = this.ancestor;
        } else {
            this.classTaxon = this.ancestor.getClassTaxon();
        }
        
        if (this.ancestor.getTaxonomicalRange().getFieldName().equals("subclass")) {
            this.subclassTaxon = this.ancestor;
        } else {
            this.subclassTaxon = this.ancestor.getSubclassTaxon();
        }
        
        if (this.ancestor.getTaxonomicalRange().getFieldName().equals("order")) {
            this.orderTaxon = this.ancestor;
        } else {
            this.orderTaxon = this.ancestor.getOrderTaxon();
        }
        
        if (this.ancestor.getTaxonomicalRange().getFieldName().equals("suborder")) {
            this.setSuborderTaxon(this.ancestor);
        } else {
            this.setSuborderTaxon(this.ancestor.getSuborderTaxon());
        }
        
        if (this.ancestor.getTaxonomicalRange().getFieldName().equals("superfamily")) {
            this.superfamilyTaxon= this.ancestor;
        } else {
            this.superfamilyTaxon = this.ancestor.getSuperfamilyTaxon();
        }
        
        if (this.ancestor.getTaxonomicalRange().getFieldName().equals("family")) {
            this.familyTaxon = this.ancestor;
        } else {
            this.familyTaxon = this.ancestor.getFamilyTaxon();
        }
        
        if (this.ancestor.getTaxonomicalRange().getFieldName().equals("subfamily")) {
            this.subfamilyTaxon = this.ancestor;
        } else {
            this.subfamilyTaxon = this.ancestor.getSubfamilyTaxon();
        }
        
        if (this.ancestor.getTaxonomicalRange().getFieldName().equals("tribe")) {
            this.tribeTaxon = this.ancestor;
        } else {
            this.tribeTaxon = this.ancestor.getTribeTaxon();
        }
        
        if (this.ancestor.getTaxonomicalRange().getFieldName().equals("subtribe")) {
            this.subtribeTaxon = this.ancestor;
        } else {
            this.subtribeTaxon = this.ancestor.getSubtribeTaxon();
        }
        
        if (this.ancestor.getTaxonomicalRange().getFieldName().equals("genus")) {
            this.genusTaxon = this.ancestor;
        } else {
            this.genusTaxon = this.ancestor.getGenusTaxon();
        }
        
        if (this.ancestor.getTaxonomicalRange().getFieldName().equals("subgenus")) {
            this.subgenusTaxon = this.ancestor;
        } else {
            this.subgenusTaxon = this.ancestor.getSubgenusTaxon();
        }
        
        if (this.ancestor.getTaxonomicalRange().getFieldName().equals("section")) {
            this.sectionTaxon = this.ancestor;
        } else {
            this.sectionTaxon = this.ancestor.getSectionTaxon();
        }
        
        if (this.ancestor.getTaxonomicalRange().getFieldName().equals("subsection")) {
            this.subsectionTaxon = this.ancestor;
        } else {
            this.subsectionTaxon = this.ancestor.getSubsectionTaxon();
        }
        
        if (this.ancestor.getTaxonomicalRange().getFieldName().equals("stirps")) {
            this.stirpsTaxon = this.ancestor;
        } else {
            this.stirpsTaxon = this.ancestor.getStirpsTaxon();
        }
        
        if (this.ancestor.getTaxonomicalRange().getFieldName().equals("species")) {
            this.speciesTaxon = this.ancestor;
        } else {
            this.speciesTaxon = this.ancestor.getSpeciesTaxon();
        }
        
        if (this.ancestor.getTaxonomicalRange().getFieldName().equals("subspecies")) {
            this.subspeciesTaxon = this.ancestor;
        } else {
            this.subspeciesTaxon = this.ancestor.getSpeciesTaxon();
        }
        
        if (this.ancestor.getTaxonomicalRange().getFieldName().equals("variety")) {
            this.varietyTaxon = this.ancestor;
        } else {
            this.varietyTaxon = this.ancestor.getVarietyTaxon();
        }
        
        
    }

    /**
     * Gets the genusTaxonId of this Taxon.
     * 
     * @return the genusTaxonId
     */
    public Taxon getGenusTaxon() {
        return this.genusTaxon;
    }

    /**
     * Sets the genusTaxonId of this Taxon to the specified value.
     * 
     * @param genusTaxonId the new genusTaxonId
     */
    public void setGenusTaxon(Taxon genusTaxon) {
        this.genusTaxon = genusTaxon;
    }

    /**
     * Gets the dominiumTaxonId of this Taxon.
     * 
     * @return the dominiumTaxonId
     */
    public Taxon getDominiumTaxon() {
        return this.dominiumTaxon;
    }

    /**
     * Sets the dominiumTaxonId of this Taxon to the specified value.
     * 
     * @param dominiumTaxonId the new dominiumTaxonId
     */
    public void setDominiumTaxon(Taxon dominiumTaxon) {
        this.dominiumTaxon = dominiumTaxon;
    }

    
    public void setTaxonomicalRange(TaxonomicalRange taxonomicalRange) {
        this.taxonomicalRange = taxonomicalRange;
    }
    
    public TaxonomicalRange getTaxonomicalRange(){
        return this.taxonomicalRange;
    }

    public void setTaxonCategory(TaxonCategory taxonCategory) {
        this.taxonCategory = taxonCategory;
    }
    
    public TaxonCategory getTaxonCategory(){
        return this.taxonCategory;
    }
    
    /**
     * Gets the kingdomTaxonId of this Taxon.
     * 
     * @return the kingdomTaxonId
     */
    public Taxon getKingdomTaxon() {
        return this.kingdomTaxon;
    }

    /**
     * Sets the kingdomTaxonId of this Taxon to the specified value.
     * 
     * @param kingdomTaxonId the new kingdomTaxonId
     */
    public void setKingdomTaxon(Taxon kingdomTaxon) {
        this.kingdomTaxon = kingdomTaxon;
    }

    /**
     * Gets the phylumDivisionTaxonId of this Taxon.
     * 
     * @return the phylumDivisionTaxonId
     */
    public Taxon getPhylumDivisionTaxon() {
        return this.phylumDivisionTaxon;
    }

    /**
     * Sets the phylumDivisionTaxonId of this Taxon to the specified value.
     * 
     * @param phylumDivisionTaxonId the new phylumDivisionTaxonId
     */
    public void setPhylumDivisionTaxon(Taxon phylumDivisionTaxon) {
        this.phylumDivisionTaxon = phylumDivisionTaxon;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this Taxon.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Taxon object that 
     * has the same id field values as this object.
     * 
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Taxon)) {
            return false;
        }
        Taxon other = (Taxon)object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.Taxon[taxonId=" + this.id + "]";
    }

    public Set<PersonProfileTaxon> getPersonProfileTaxonSet() {
        return personProfileTaxonSet;
    }

    public void setPersonProfileTaxonSet(Set<PersonProfileTaxon> personProfileTaxonSet) {
        this.personProfileTaxonSet = personProfileTaxonSet;
    }

    
    public Set<TaxonDescription> getTaxonDescriptionSet() {
        return taxonDescriptionSet;
    }

    public void setTaxonDescriptionSet(Set<TaxonDescription> taxonDescriptionSet) {
        this.taxonDescriptionSet = taxonDescriptionSet;
    }
    
    /*
    @PostLoad
    public void postLoad() {
        this.familyName = this.familyTaxon.getDefaultName();
    }
     */

    public Taxon getSubkingdomTaxon() {
        return subkingdomTaxon;
    }

    public void setSubkingdomTaxon(Taxon subkingdomTaxon) {
        this.subkingdomTaxon = subkingdomTaxon;
    }

    public Taxon getInfrakingdomTaxon() {
        return infrakingdomTaxon;
    }

    public void setInfrakingdomTaxon(Taxon infrakingdomTaxon) {
        this.infrakingdomTaxon = infrakingdomTaxon;
    }

    public Taxon getSuperphylumTaxon() {
        return superphylumTaxon;
    }

    public void setSuperphylumTaxon(Taxon superphylumTaxon) {
        this.superphylumTaxon = superphylumTaxon;
    }

    public Taxon getInfraphylumInfradivisionTaxon() {
        return infraphylumInfradivisionTaxon;
    }

    public void setInfraphylumInfradivisionTaxon(Taxon infraphylumInfradivisionTaxon) {
        this.infraphylumInfradivisionTaxon = infraphylumInfradivisionTaxon;
    }

    public Taxon getSuperclassTaxon() {
        return superclassTaxon;
    }

    public void setSuperclassTaxon(Taxon superclassTaxon) {
        this.superclassTaxon = superclassTaxon;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }
}
