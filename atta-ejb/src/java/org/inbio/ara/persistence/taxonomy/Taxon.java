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

package org.inbio.ara.persistence.taxonomy;

import java.util.Calendar;
import java.util.List;
import javax.persistence.Basic;
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
import org.inbio.ara.persistence.LogGenericEntity;
import org.inbio.ara.persistence.collection.Collection;

/**
 *
 * @author herson
 */
@Entity
@Table(name = "taxon")
public class Taxon extends LogGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="Taxon")
	@SequenceGenerator(name="Taxon", sequenceName="taxon_seq")
    @Basic(optional = false)
    @Column(name = "taxon_id")
    private Long taxonId;

    @Basic(optional = false)
    @Column(name = "current_name")
    private String currentName;

    @Basic(optional = false)
    @Column(name = "current_name_timestamp")
    @Temporal(TemporalType.DATE)
    private Calendar currentNameTimestamp;

    @Basic(optional = false)
    @Column(name = "default_name")
    private String defaultName;

    @Column(name = "current_predecessor_timestamp")
    @Temporal(TemporalType.DATE)
    private Calendar currentPredecessorTimestamp;

    @Column(name = "description_month")
    private Long descriptionMonth;

    @Column(name = "description_year")
    private Long descriptionYear;

    @Basic(optional = false)
    @Column(name = "author_format_parenthesis")
    private short authorFormatParenthesis;

    @Column(name = "basionym")
    private String basionym;

    @Column(name = "subkingdom_taxon_id")
    private Long subkingdomTaxonId;

    @Column(name = "infrakingdom_taxon_id")
    private Long infrakingdomTaxonId;

    @Column(name = "superphylum_taxon_id")
    private Long superphylumTaxonId;

    @Column(name = "infraphylum_infradivision_taxon_id")
    private Long infraphylumInfradivisionTaxonId;

    @Column(name = "superclass_taxon_id")
    private Long superclassTaxonId;

    @Column(name = "superorder_taxon_id")
    private Long superorderTaxonId;

    @JoinColumn(name = "collection_id", referencedColumnName = "collection_id", insertable=false, updatable=false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Collection collection;

    @Column(name = "collection_id")
    private Long collectionId;

    @Column(name = "country_id")
    private Long countryId;

    @OneToMany(mappedBy = "dominiumTaxonId", fetch = FetchType.LAZY)
    private List<Taxon> taxonCollection;

    @Column(name = "dominium_taxon_id")
    private Long dominiumTaxonId;

    @OneToMany(mappedBy = "familyTaxonId", fetch = FetchType.LAZY)
    private List<Taxon> taxonCollection1;

    @Column(name = "family_taxon_id")
    private Long familyTaxonId;

    @OneToMany(mappedBy = "genusTaxonId", fetch = FetchType.LAZY)
    private List<Taxon> taxonCollection2;

    @Column(name = "genus_taxon_id")
    private Long genusTaxonId;

    @OneToMany(mappedBy = "kingdomTaxonId", fetch = FetchType.LAZY)
    private List<Taxon> taxonCollection3;

    @Column(name = "kingdom_taxon_id")
    private Long kingdomTaxonId;

    @OneToMany(mappedBy = "orderTaxonId", fetch = FetchType.LAZY)
    private List<Taxon> taxonCollection4;

    @Column(name = "order_taxon_id")
    private Long orderTaxonId;

    @OneToMany(mappedBy = "phylumDivisionTaxonId", fetch = FetchType.LAZY)
    private List<Taxon> taxonCollection5;

    @Column(name = "phylum_division_taxon_id")
    private Long phylumDivisionTaxonId;

    @OneToMany(mappedBy = "sectionTaxonId", fetch = FetchType.LAZY)
    private List<Taxon> taxonCollection6;

    @Column(name = "section_taxon_id")
    private Long sectionTaxonId;

    @OneToMany(mappedBy = "speciesTaxonId", fetch = FetchType.LAZY)
    private List<Taxon> taxonCollection7;

    @Column(name = "species_taxon_id")
    private Long speciesTaxonId;

    @OneToMany(mappedBy = "stirpsTaxonId", fetch = FetchType.LAZY)
    private List<Taxon> taxonCollection8;

    @Column(name = "stirps_taxon_id")
    private Long stirpsTaxonId;

    @OneToMany(mappedBy = "subclassTaxonId", fetch = FetchType.LAZY)
    private List<Taxon> taxonCollection9;

    @Column(name = "subclass_taxon_id")
    private Long subclassTaxonId;

    @OneToMany(mappedBy = "ancestorId", fetch = FetchType.LAZY)
    private List<Taxon> taxonCollection10;

    @Column(name = "ancestor_id")
    private Long ancestorId;

    @OneToMany(mappedBy = "subgenusTaxonId", fetch = FetchType.LAZY)
    private List<Taxon> taxonCollection11;

    @Column(name = "subgenus_taxon_id")
    private Long subgenusTaxonId;

    @OneToMany(mappedBy = "suborderTaxonId", fetch = FetchType.LAZY)
    private List<Taxon> taxonCollection12;

    @Column(name = "suborder_taxon_id")
    private Long suborderTaxonId;

    @OneToMany(mappedBy = "subphylumSubdivisionTaxonId", fetch = FetchType.LAZY)
    private List<Taxon> taxonCollection13;

    @Column(name = "subphylum_subdivision_taxon_id")
    private Long subphylumSubdivisionTaxonId;

    @OneToMany(mappedBy = "subsectionTaxonId", fetch = FetchType.LAZY)
    private List<Taxon> taxonCollection14;

    @Column(name = "subsection_taxon_id")
    private Long subsectionTaxonId;

    @OneToMany(mappedBy = "subspeciesTaxonId", fetch = FetchType.LAZY)
    private List<Taxon> taxonCollection15;

    @Column(name = "subspecies_taxon_id")
    private Long subspeciesTaxonId;

    @OneToMany(mappedBy = "subtribeTaxonId", fetch = FetchType.LAZY)
    private List<Taxon> taxonCollection16;

    @Column(name = "subtribe_taxon_id")
    private Long subtribeTaxonId;

    @OneToMany(mappedBy = "superfamilyTaxonId", fetch = FetchType.LAZY)
    private List<Taxon> taxonCollection17;

    @Column(name = "superfamily_taxon_id")
    private Long superfamilyTaxonId;

    @OneToMany(mappedBy = "synonymTaxonId", fetch = FetchType.LAZY)
    private List<Taxon> taxonCollection18;

    @Column(name = "synonym_taxon_id")
    private Long synonymTaxonId;

    @OneToMany(mappedBy = "subfamilyTaxonId", fetch = FetchType.LAZY)
    private List<Taxon> taxonCollection19;

    @Column(name = "subfamily_taxon_id")
    private Long subfamilyTaxonId;

    @OneToMany(mappedBy = "classTaxonId", fetch = FetchType.LAZY)
    private List<Taxon> taxonCollection20;

    @Column(name = "class_taxon_id")
    private Long classTaxonId;

    @OneToMany(mappedBy = "tribeTaxonId", fetch = FetchType.LAZY)
    private List<Taxon> taxonCollection21;

    @Column(name = "tribe_taxon_id")
    private Long tribeTaxonId;

    @OneToMany(mappedBy = "varietyTaxonId", fetch = FetchType.LAZY)
    private List<Taxon> taxonCollection22;

    @Column(name = "variety_taxon_id")
    private Long varietyTaxonId;

    @Column(name = "taxon_category_id")
    private Long taxonCategoryId;

    @Column(name = "taxonomical_range_id")
    private Long taxonomicalRangeId;

    public Taxon() {
    }

    public Taxon(Long taxonId) {
        this.taxonId = taxonId;
    }

    public Taxon(Long taxonId, String currentName, Calendar currentNameTimestamp, String defaultName, short authorFormatParenthesis) {
        this.taxonId = taxonId;
        this.currentName = currentName;
        this.currentNameTimestamp = currentNameTimestamp;
        this.defaultName = defaultName;
        this.authorFormatParenthesis = authorFormatParenthesis;
        //this.objVersion = objVersion;
    }

    public Long getTaxonId() {
        return taxonId;
    }

    public void setTaxonId(Long taxonId) {
        this.taxonId = taxonId;
    }

    public String getCurrentName() {
        return currentName;
    }

    public void setCurrentName(String currentName) {
        this.currentName = currentName;
    }

    public Calendar getCurrentNameTimestamp() {
        return currentNameTimestamp;
    }

    public void setCurrentNameTimestamp(Calendar currentNameTimestamp) {
        this.currentNameTimestamp = currentNameTimestamp;
    }

    public String getDefaultName() {
        return defaultName;
    }

    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

    public Calendar getCurrentPredecessorTimestamp() {
        return currentPredecessorTimestamp;
    }

    public void setCurrentPredecessorTimestamp(Calendar currentPredecessorTimestamp) {
        this.currentPredecessorTimestamp = currentPredecessorTimestamp;
    }

    public Long getDescriptionMonth() {
        return descriptionMonth;
    }

    public void setDescriptionMonth(Long descriptionMonth) {
        this.descriptionMonth = descriptionMonth;
    }

    public Long getDescriptionYear() {
        return descriptionYear;
    }

    public void setDescriptionYear(Long descriptionYear) {
        this.descriptionYear = descriptionYear;
    }

    public short getAuthorFormatParenthesis() {
        return authorFormatParenthesis;
    }

    public void setAuthorFormatParenthesis(short authorFormatParenthesis) {
        this.authorFormatParenthesis = authorFormatParenthesis;
    }

    public String getBasionym() {
        return basionym;
    }

    public void setBasionym(String basionym) {
        this.basionym = basionym;
    }

//    public Long getObjVersion() {
//        return objVersion;
//    }
//
//    public void setObjVersion(Long objVersion) {
//        this.objVersion = objVersion;
//    }

    public Long getSubkingdomTaxonId() {
        return subkingdomTaxonId;
    }

    public void setSubkingdomTaxonId(Long subkingdomTaxonId) {
        this.subkingdomTaxonId = subkingdomTaxonId;
    }

    public Long getInfrakingdomTaxonId() {
        return infrakingdomTaxonId;
    }

    public void setInfrakingdomTaxonId(Long infrakingdomTaxonId) {
        this.infrakingdomTaxonId = infrakingdomTaxonId;
    }

    public Long getSuperphylumTaxonId() {
        return superphylumTaxonId;
    }

    public void setSuperphylumTaxonId(Long superphylumTaxonId) {
        this.superphylumTaxonId = superphylumTaxonId;
    }

    public Long getInfraphylumInfradivisionTaxonId() {
        return infraphylumInfradivisionTaxonId;
    }

    public void setInfraphylumInfradivisionTaxonId(Long infraphylumInfradivisionTaxonId) {
        this.infraphylumInfradivisionTaxonId = infraphylumInfradivisionTaxonId;
    }

    public Long getSuperclassTaxonId() {
        return superclassTaxonId;
    }

    public void setSuperclassTaxonId(Long superclassTaxonId) {
        this.superclassTaxonId = superclassTaxonId;
    }

    public Long getSuperorderTaxonId() {
        return superorderTaxonId;
    }

    public void setSuperorderTaxonId(Long superorderTaxonId) {
        this.superorderTaxonId = superorderTaxonId;
    }

    public Long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public List<Taxon> getTaxonCollection() {
        return taxonCollection;
    }

    public void setTaxonCollection(List<Taxon> taxonCollection) {
        this.taxonCollection = taxonCollection;
    }

    public Long getDominiumTaxonId() {
        return dominiumTaxonId;
    }

    public void setDominiumTaxonId(Long dominiumTaxonId) {
        this.dominiumTaxonId = dominiumTaxonId;
    }

    public List<Taxon> getTaxonCollection1() {
        return taxonCollection1;
    }

    public void setTaxonCollection1(List<Taxon> taxonCollection1) {
        this.taxonCollection1 = taxonCollection1;
    }

    public Long getFamilyTaxonId() {
        return familyTaxonId;
    }

    public void setFamilyTaxonId(Long familyTaxonId) {
        this.familyTaxonId = familyTaxonId;
    }

    public List<Taxon> getTaxonCollection2() {
        return taxonCollection2;
    }

    public void setTaxonCollection2(List<Taxon> taxonCollection2) {
        this.taxonCollection2 = taxonCollection2;
    }

    public Long getGenusTaxonId() {
        return genusTaxonId;
    }

    public void setGenusTaxonId(Long genusTaxonId) {
        this.genusTaxonId = genusTaxonId;
    }

    public List<Taxon> getTaxonCollection3() {
        return taxonCollection3;
    }

    public void setTaxonCollection3(List<Taxon> taxonCollection3) {
        this.taxonCollection3 = taxonCollection3;
    }

    public Long getKingdomTaxonId() {
        return kingdomTaxonId;
    }

    public void setKingdomTaxonId(Long kingdomTaxonId) {
        this.kingdomTaxonId = kingdomTaxonId;
    }

    public List<Taxon> getTaxonCollection4() {
        return taxonCollection4;
    }

    public void setTaxonCollection4(List<Taxon> taxonCollection4) {
        this.taxonCollection4 = taxonCollection4;
    }

    public Long getOrderTaxonId() {
        return orderTaxonId;
    }

    public void setOrderTaxonId(Long orderTaxonId) {
        this.orderTaxonId = orderTaxonId;
    }

    public List<Taxon> getTaxonCollection5() {
        return taxonCollection5;
    }

    public void setTaxonCollection5(List<Taxon> taxonCollection5) {
        this.taxonCollection5 = taxonCollection5;
    }

    public Long getPhylumDivisionTaxonId() {
        return phylumDivisionTaxonId;
    }

    public void setPhylumDivisionTaxonId(Long phylumDivisionTaxonId) {
        this.phylumDivisionTaxonId = phylumDivisionTaxonId;
    }

    public List<Taxon> getTaxonCollection6() {
        return taxonCollection6;
    }

    public void setTaxonCollection6(List<Taxon> taxonCollection6) {
        this.taxonCollection6 = taxonCollection6;
    }

    public Long getSectionTaxonId() {
        return sectionTaxonId;
    }

    public void setSectionTaxonId(Long sectionTaxonId) {
        this.sectionTaxonId = sectionTaxonId;
    }

    public List<Taxon> getTaxonCollection7() {
        return taxonCollection7;
    }

    public void setTaxonCollection7(List<Taxon> taxonCollection7) {
        this.taxonCollection7 = taxonCollection7;
    }

    public Long getSpeciesTaxonId() {
        return speciesTaxonId;
    }

    public void setSpeciesTaxonId(Long speciesTaxonId) {
        this.speciesTaxonId = speciesTaxonId;
    }

    public List<Taxon> getTaxonCollection8() {
        return taxonCollection8;
    }

    public void setTaxonCollection8(List<Taxon> taxonCollection8) {
        this.taxonCollection8 = taxonCollection8;
    }

    public Long getStirpsTaxonId() {
        return stirpsTaxonId;
    }

    public void setStirpsTaxonId(Long stirpsTaxonId) {
        this.stirpsTaxonId = stirpsTaxonId;
    }

    public List<Taxon> getTaxonCollection9() {
        return taxonCollection9;
    }

    public void setTaxonCollection9(List<Taxon> taxonCollection9) {
        this.taxonCollection9 = taxonCollection9;
    }

    public Long getSubclassTaxonId() {
        return subclassTaxonId;
    }

    public void setSubclassTaxonId(Long subclassTaxonId) {
        this.subclassTaxonId = subclassTaxonId;
    }

    public List<Taxon> getTaxonCollection10() {
        return taxonCollection10;
    }

    public void setTaxonCollection10(List<Taxon> taxonCollection10) {
        this.taxonCollection10 = taxonCollection10;
    }

    public Long getAncestorId() {
        return ancestorId;
    }

    public void setAncestorId(Long ancestorId) {
        this.ancestorId = ancestorId;
    }

    public List<Taxon> getTaxonCollection11() {
        return taxonCollection11;
    }

    public void setTaxonCollection11(List<Taxon> taxonCollection11) {
        this.taxonCollection11 = taxonCollection11;
    }

    public Long getSubgenusTaxonId() {
        return subgenusTaxonId;
    }

    public void setSubgenusTaxonId(Long subgenusTaxonId) {
        this.subgenusTaxonId = subgenusTaxonId;
    }

    public List<Taxon> getTaxonCollection12() {
        return taxonCollection12;
    }

    public void setTaxonCollection12(List<Taxon> taxonCollection12) {
        this.taxonCollection12 = taxonCollection12;
    }

    public Long getSuborderTaxonId() {
        return suborderTaxonId;
    }

    public void setSuborderTaxonId(Long suborderTaxonId) {
        this.suborderTaxonId = suborderTaxonId;
    }

    public List<Taxon> getTaxonCollection13() {
        return taxonCollection13;
    }

    public void setTaxonCollection13(List<Taxon> taxonCollection13) {
        this.taxonCollection13 = taxonCollection13;
    }

    public Long getSubphylumSubdivisionTaxonId() {
        return subphylumSubdivisionTaxonId;
    }

    public void setSubphylumSubdivisionTaxonId(Long subphylumSubdivisionTaxonId) {
        this.subphylumSubdivisionTaxonId = subphylumSubdivisionTaxonId;
    }

    public List<Taxon> getTaxonCollection14() {
        return taxonCollection14;
    }

    public void setTaxonCollection14(List<Taxon> taxonCollection14) {
        this.taxonCollection14 = taxonCollection14;
    }

    public Long getSubsectionTaxonId() {
        return subsectionTaxonId;
    }

    public void setSubsectionTaxonId(Long subsectionTaxonId) {
        this.subsectionTaxonId = subsectionTaxonId;
    }

    public List<Taxon> getTaxonCollection15() {
        return taxonCollection15;
    }

    public void setTaxonCollection15(List<Taxon> taxonCollection15) {
        this.taxonCollection15 = taxonCollection15;
    }

    public Long getSubspeciesTaxonId() {
        return subspeciesTaxonId;
    }

    public void setSubspeciesTaxonId(Long subspeciesTaxonId) {
        this.subspeciesTaxonId = subspeciesTaxonId;
    }

    public List<Taxon> getTaxonCollection16() {
        return taxonCollection16;
    }

    public void setTaxonCollection16(List<Taxon> taxonCollection16) {
        this.taxonCollection16 = taxonCollection16;
    }

    public Long getSubtribeTaxonId() {
        return subtribeTaxonId;
    }

    public void setSubtribeTaxonId(Long subtribeTaxonId) {
        this.subtribeTaxonId = subtribeTaxonId;
    }

    public List<Taxon> getTaxonCollection17() {
        return taxonCollection17;
    }

    public void setTaxonCollection17(List<Taxon> taxonCollection17) {
        this.taxonCollection17 = taxonCollection17;
    }

    public Long getSuperfamilyTaxonId() {
        return superfamilyTaxonId;
    }

    public void setSuperfamilyTaxonId(Long superfamilyTaxonId) {
        this.superfamilyTaxonId = superfamilyTaxonId;
    }

    public List<Taxon> getTaxonCollection18() {
        return taxonCollection18;
    }

    public void setTaxonCollection18(List<Taxon> taxonCollection18) {
        this.taxonCollection18 = taxonCollection18;
    }

    public Long getSynonymTaxonId() {
        return synonymTaxonId;
    }

    public void setSynonymTaxonId(Long synonymTaxonId) {
        this.synonymTaxonId = synonymTaxonId;
    }

    public List<Taxon> getTaxonCollection19() {
        return taxonCollection19;
    }

    public void setTaxonCollection19(List<Taxon> taxonCollection19) {
        this.taxonCollection19 = taxonCollection19;
    }

    public Long getSubfamilyTaxonId() {
        return subfamilyTaxonId;
    }

    public void setSubfamilyTaxonId(Long subfamilyTaxonId) {
        this.subfamilyTaxonId = subfamilyTaxonId;
    }

    public List<Taxon> getTaxonCollection20() {
        return taxonCollection20;
    }

    public void setTaxonCollection20(List<Taxon> taxonCollection20) {
        this.taxonCollection20 = taxonCollection20;
    }

    public Long getClassTaxonId() {
        return classTaxonId;
    }

    public void setClassTaxonId(Long classTaxonId) {
        this.classTaxonId = classTaxonId;
    }

    public List<Taxon> getTaxonCollection21() {
        return taxonCollection21;
    }

    public void setTaxonCollection21(List<Taxon> taxonCollection21) {
        this.taxonCollection21 = taxonCollection21;
    }

    public Long getTribeTaxonId() {
        return tribeTaxonId;
    }

    public void setTribeTaxonId(Long tribeTaxonId) {
        this.tribeTaxonId = tribeTaxonId;
    }

    public List<Taxon> getTaxonCollection22() {
        return taxonCollection22;
    }

    public void setTaxonCollection22(List<Taxon> taxonCollection22) {
        this.taxonCollection22 = taxonCollection22;
    }

    public Long getVarietyTaxonId() {
        return varietyTaxonId;
    }

    public void setVarietyTaxonId(Long varietyTaxonId) {
        this.varietyTaxonId = varietyTaxonId;
    }

    public Long getTaxonCategoryId() {
        return taxonCategoryId;
    }

    public void setTaxonCategoryId(Long taxonCategoryId) {
        this.taxonCategoryId = taxonCategoryId;
    }

    public Long getTaxonomicalRangeId() {
        return taxonomicalRangeId;
    }

    public void setTaxonomicalRangeId(Long taxonomicalRangeId) {
        this.taxonomicalRangeId = taxonomicalRangeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxonId != null ? taxonId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Taxon)) {
            return false;
        }
        Taxon other = (Taxon) object;
        if ((this.taxonId == null && other.taxonId != null) || (this.taxonId != null && !this.taxonId.equals(other.taxonId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.Taxon[taxonId=" + taxonId + "]";
    }

    /**
     * @return the collection
     */
    public Collection getCollection() {
        return collection;
    }

    /**
     * @param collection the collection to set
     */
    public void setCollection(Collection collection) {
        this.collection = collection;
    }

}
