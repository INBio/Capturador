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

package org.inbio.ara.persistence.reports;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "plic_snapshot")

public class PlicSnapshot implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "globaluniqueidentifier")
    private String globaluniqueidentifier;
    @Column(name = "scientificname")
    private String scientificname;
    @Column(name = "institutioncode")
    private String institutioncode;
    @Column(name = "datelastmodified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datelastmodified;
    @Column(name = "taxonrecordid")
    private String taxonrecordid;
    @Column(name = "language")
    private String language;
    @Column(name = "creators")
    private String creators;
    @Column(name = "distribution")
    private String distribution;
    @Column(name = "abstract")
    private String abstract1;
    @Column(name = "kingdomtaxon")
    private String kingdomtaxon;
    @Column(name = "phylumtaxon")
    private String phylumtaxon;
    @Column(name = "classtaxon")
    private String classtaxon;
    @Column(name = "ordertaxon")
    private String ordertaxon;
    @Column(name = "familytaxon")
    private String familytaxon;
    @Column(name = "genustaxon")
    private String genustaxon;
    @Column(name = "synonyms")
    private String synonyms;
    @Column(name = "authoryearofscientificname")
    private String authoryearofscientificname;
    @Column(name = "speciespublicationreference")
    private String speciespublicationreference;
    @Column(name = "commonnames")
    private String commonnames;
    @Column(name = "typification")
    private String typification;
    @Column(name = "contributors")
    private String contributors;
    @Column(name = "datecreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreated;
    @Column(name = "habit")
    private String habit;
    @Column(name = "lifecycle")
    private String lifecycle;
    @Column(name = "reproduction")
    private String reproduction;
    @Column(name = "annualcycle")
    private String annualcycle;
    @Column(name = "scientificdescription")
    private String scientificdescription;
    @Column(name = "briefdescription")
    private String briefdescription;
    @Column(name = "feeding")
    private String feeding;
    @Column(name = "behavior")
    private String behavior;
    @Column(name = "interactions")
    private String interactions;
    @Column(name = "chromosomicnumbern")
    private String chromosomicnumbern;
    @Column(name = "moleculardata")
    private String moleculardata;
    @Column(name = "populationbiology")
    private String populationbiology;
    @Column(name = "threatstatus")
    private String threatstatus;
    @Column(name = "legislation")
    private String legislation;
    @Column(name = "habitat")
    private String habitat;
    @Column(name = "territory")
    private String territory;
    @Column(name = "endemicity")
    private String endemicity;
    @Column(name = "theuses")
    private String theuses;
    @Column(name = "themanagement")
    private String themanagement;
    @Column(name = "folklore")
    private String folklore;
    @Column(name = "thereferences")
    private String thereferences;
    @Column(name = "unstructureddocumentation")
    private String unstructureddocumentation;
    @Column(name = "otherinformationsources")
    private String otherinformationsources;
    @Column(name = "papers")
    private String papers;
    @Column(name = "identificationkeys")
    private String identificationkeys;
    @Column(name = "migratorydata")
    private String migratorydata;
    @Column(name = "ecologicalsignificance")
    private String ecologicalsignificance;
    @Column(name = "unstructurednaturalhistory")
    private String unstructurednaturalhistory;
    @Column(name = "invasivenessdata")
    private String invasivenessdata;
    @Column(name = "targetaudiences")
    private String targetaudiences;
    @Column(name = "version")
    private String version;
    @Column(name = "urlimage1")
    private String urlimage1;
    @Column(name = "captionimage1")
    private String captionimage1;
    @Column(name = "urlimage2")
    private String urlimage2;
    @Column(name = "captionimage2")
    private String captionimage2;
    @Column(name = "urlimage3")
    private String urlimage3;
    @Column(name = "captionimage3")
    private String captionimage3;

    public PlicSnapshot() {
    }

    public PlicSnapshot(String globaluniqueidentifier) {
        this.globaluniqueidentifier = globaluniqueidentifier;
    }

    public String getGlobaluniqueidentifier() {
        return globaluniqueidentifier;
    }

    public void setGlobaluniqueidentifier(String globaluniqueidentifier) {
        this.globaluniqueidentifier = globaluniqueidentifier;
    }

    public String getScientificname() {
        return scientificname;
    }

    public void setScientificname(String scientificname) {
        this.scientificname = scientificname;
    }

    public String getInstitutioncode() {
        return institutioncode;
    }

    public void setInstitutioncode(String institutioncode) {
        this.institutioncode = institutioncode;
    }

    public Date getDatelastmodified() {
        return datelastmodified;
    }

    public void setDatelastmodified(Date datelastmodified) {
        this.datelastmodified = datelastmodified;
    }

    public String getTaxonrecordid() {
        return taxonrecordid;
    }

    public void setTaxonrecordid(String taxonrecordid) {
        this.taxonrecordid = taxonrecordid;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCreators() {
        return creators;
    }

    public void setCreators(String creators) {
        this.creators = creators;
    }

    public String getDistribution() {
        return distribution;
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution;
    }

    public String getAbstract1() {
        return abstract1;
    }

    public void setAbstract1(String abstract1) {
        this.abstract1 = abstract1;
    }

    public String getKingdomtaxon() {
        return kingdomtaxon;
    }

    public void setKingdomtaxon(String kingdomtaxon) {
        this.kingdomtaxon = kingdomtaxon;
    }

    public String getPhylumtaxon() {
        return phylumtaxon;
    }

    public void setPhylumtaxon(String phylumtaxon) {
        this.phylumtaxon = phylumtaxon;
    }

    public String getClasstaxon() {
        return classtaxon;
    }

    public void setClasstaxon(String classtaxon) {
        this.classtaxon = classtaxon;
    }

    public String getOrdertaxon() {
        return ordertaxon;
    }

    public void setOrdertaxon(String ordertaxon) {
        this.ordertaxon = ordertaxon;
    }

    public String getFamilytaxon() {
        return familytaxon;
    }

    public void setFamilytaxon(String familytaxon) {
        this.familytaxon = familytaxon;
    }

    public String getGenustaxon() {
        return genustaxon;
    }

    public void setGenustaxon(String genustaxon) {
        this.genustaxon = genustaxon;
    }

    public String getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(String synonyms) {
        this.synonyms = synonyms;
    }

    public String getAuthoryearofscientificname() {
        return authoryearofscientificname;
    }

    public void setAuthoryearofscientificname(String authoryearofscientificname) {
        this.authoryearofscientificname = authoryearofscientificname;
    }

    public String getSpeciespublicationreference() {
        return speciespublicationreference;
    }

    public void setSpeciespublicationreference(String speciespublicationreference) {
        this.speciespublicationreference = speciespublicationreference;
    }

    public String getCommonnames() {
        return commonnames;
    }

    public void setCommonnames(String commonnames) {
        this.commonnames = commonnames;
    }

    public String getTypification() {
        return typification;
    }

    public void setTypification(String typification) {
        this.typification = typification;
    }

    public String getContributors() {
        return contributors;
    }

    public void setContributors(String contributors) {
        this.contributors = contributors;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public String getHabit() {
        return habit;
    }

    public void setHabit(String habit) {
        this.habit = habit;
    }

    public String getLifecycle() {
        return lifecycle;
    }

    public void setLifecycle(String lifecycle) {
        this.lifecycle = lifecycle;
    }

    public String getReproduction() {
        return reproduction;
    }

    public void setReproduction(String reproduction) {
        this.reproduction = reproduction;
    }

    public String getAnnualcycle() {
        return annualcycle;
    }

    public void setAnnualcycle(String annualcycle) {
        this.annualcycle = annualcycle;
    }

    public String getScientificdescription() {
        return scientificdescription;
    }

    public void setScientificdescription(String scientificdescription) {
        this.scientificdescription = scientificdescription;
    }

    public String getBriefdescription() {
        return briefdescription;
    }

    public void setBriefdescription(String briefdescription) {
        this.briefdescription = briefdescription;
    }

    public String getFeeding() {
        return feeding;
    }

    public void setFeeding(String feeding) {
        this.feeding = feeding;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public String getInteractions() {
        return interactions;
    }

    public void setInteractions(String interactions) {
        this.interactions = interactions;
    }

    public String getChromosomicnumbern() {
        return chromosomicnumbern;
    }

    public void setChromosomicnumbern(String chromosomicnumbern) {
        this.chromosomicnumbern = chromosomicnumbern;
    }

    public String getMoleculardata() {
        return moleculardata;
    }

    public void setMoleculardata(String moleculardata) {
        this.moleculardata = moleculardata;
    }

    public String getPopulationbiology() {
        return populationbiology;
    }

    public void setPopulationbiology(String populationbiology) {
        this.populationbiology = populationbiology;
    }

    public String getThreatstatus() {
        return threatstatus;
    }

    public void setThreatstatus(String threatstatus) {
        this.threatstatus = threatstatus;
    }

    public String getLegislation() {
        return legislation;
    }

    public void setLegislation(String legislation) {
        this.legislation = legislation;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    public String getEndemicity() {
        return endemicity;
    }

    public void setEndemicity(String endemicity) {
        this.endemicity = endemicity;
    }

    public String getTheuses() {
        return theuses;
    }

    public void setTheuses(String theuses) {
        this.theuses = theuses;
    }

    public String getThemanagement() {
        return themanagement;
    }

    public void setThemanagement(String themanagement) {
        this.themanagement = themanagement;
    }

    public String getFolklore() {
        return folklore;
    }

    public void setFolklore(String folklore) {
        this.folklore = folklore;
    }

    public String getThereferences() {
        return thereferences;
    }

    public void setThereferences(String thereferences) {
        this.thereferences = thereferences;
    }

    public String getUnstructureddocumentation() {
        return unstructureddocumentation;
    }

    public void setUnstructureddocumentation(String unstructureddocumentation) {
        this.unstructureddocumentation = unstructureddocumentation;
    }

    public String getOtherinformationsources() {
        return otherinformationsources;
    }

    public void setOtherinformationsources(String otherinformationsources) {
        this.otherinformationsources = otherinformationsources;
    }

    public String getPapers() {
        return papers;
    }

    public void setPapers(String papers) {
        this.papers = papers;
    }

    public String getIdentificationkeys() {
        return identificationkeys;
    }

    public void setIdentificationkeys(String identificationkeys) {
        this.identificationkeys = identificationkeys;
    }

    public String getMigratorydata() {
        return migratorydata;
    }

    public void setMigratorydata(String migratorydata) {
        this.migratorydata = migratorydata;
    }

    public String getEcologicalsignificance() {
        return ecologicalsignificance;
    }

    public void setEcologicalsignificance(String ecologicalsignificance) {
        this.ecologicalsignificance = ecologicalsignificance;
    }

    public String getUnstructurednaturalhistory() {
        return unstructurednaturalhistory;
    }

    public void setUnstructurednaturalhistory(String unstructurednaturalhistory) {
        this.unstructurednaturalhistory = unstructurednaturalhistory;
    }

    public String getInvasivenessdata() {
        return invasivenessdata;
    }

    public void setInvasivenessdata(String invasivenessdata) {
        this.invasivenessdata = invasivenessdata;
    }

    public String getTargetaudiences() {
        return targetaudiences;
    }

    public void setTargetaudiences(String targetaudiences) {
        this.targetaudiences = targetaudiences;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUrlimage1() {
        return urlimage1;
    }

    public void setUrlimage1(String urlimage1) {
        this.urlimage1 = urlimage1;
    }

    public String getCaptionimage1() {
        return captionimage1;
    }

    public void setCaptionimage1(String captionimage1) {
        this.captionimage1 = captionimage1;
    }

    public String getUrlimage2() {
        return urlimage2;
    }

    public void setUrlimage2(String urlimage2) {
        this.urlimage2 = urlimage2;
    }

    public String getCaptionimage2() {
        return captionimage2;
    }

    public void setCaptionimage2(String captionimage2) {
        this.captionimage2 = captionimage2;
    }

    public String getUrlimage3() {
        return urlimage3;
    }

    public void setUrlimage3(String urlimage3) {
        this.urlimage3 = urlimage3;
    }

    public String getCaptionimage3() {
        return captionimage3;
    }

    public void setCaptionimage3(String captionimage3) {
        this.captionimage3 = captionimage3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (globaluniqueidentifier != null ? globaluniqueidentifier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlicSnapshot)) {
            return false;
        }
        PlicSnapshot other = (PlicSnapshot) object;
        if ((this.globaluniqueidentifier == null && other.globaluniqueidentifier != null) || (this.globaluniqueidentifier != null && !this.globaluniqueidentifier.equals(other.globaluniqueidentifier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.reports.PlicSnapshot[globaluniqueidentifier=" + globaluniqueidentifier + "]";
    }

}
