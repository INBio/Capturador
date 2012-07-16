/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.germplasm;

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
 * @author dasolano
 */
@Entity
@Table(name = "accession")
public class Accession extends LogGenericEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="accession")
    @SequenceGenerator(name="accession", sequenceName="accession_seq")
    @Basic(optional = false)
    @Column(name = "accession_id")
    private Long accessionId;

    @Basic(optional = false)
    @Column(name = "accession_number")
    private String accessionNumber;

    @Column(name = "packages")
    private Long packages;

    @Column(name = "original_weigth")
    private Long originalWeigth;

    @Column(name = "multiplication_regeneration")
    private Long multiplicationRegeneration;

    @Column(name = "current_weigth")
    private Long currentWeigth;

    @Column(name = "location")
    private String location;

    @Column(name = "germination_date")
    @Temporal(TemporalType.DATE)
    private Calendar germinationDate;

    @Column(name = "germination_rate")
    private Long germinationRate;

    @Column(name = "germination_viability")
    private Long germinationViability;

    @Column(name = "moisture")
    private Long moisture;

    @Column(name = "storage_date")
    @Temporal(TemporalType.DATE)
    private Calendar storageDate;

    @Column(name = "notes")
    private String notes;

    @Column(name = "accession_parent_id")
    private Long accessionParentId;

    @Column(name = "collection_type_id")
    private Long collectionTypeId;

    @Column(name = "germination_method_type_id")
    private Long germinationMethodTypeId;

    @Column(name = "moisture_method_type_id")
    private Long moistureMethodTypeId;

    @Column(name = "passport_id")
    private Long passportId;
    
    @Column(name = "responsable_person_id")
    private Long responsablePersonId;

    public Accession() {
    }

    public Accession(Long accessionId) {
        this.accessionId = accessionId;
    }

    public Accession(Long accessionId, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.accessionId = accessionId;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getAccessionId() {
        return accessionId;
    }

    public void setAccessionId(Long accessionId) {
        this.accessionId = accessionId;
    }

    public String getAccessionNumber() {
        return accessionNumber;
    }

    public void setAccessionNumber(String accessionNumber) {
        this.accessionNumber = accessionNumber;
    }

    public Long getPackages() {
        return packages;
    }

    public void setPackages(Long packages) {
        this.packages = packages;
    }


    public Long getMultiplicationRegeneration() {
        return multiplicationRegeneration;
    }

    public void setMultiplicationRegeneration(Long multiplicationRegeneration) {
        this.multiplicationRegeneration = multiplicationRegeneration;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Calendar getGerminationDate() {
        return germinationDate;
    }

    public void setGerminationDate(Calendar germinationDate) {
        this.germinationDate = germinationDate;
    }

    public Long getGerminationRate() {
        return germinationRate;
    }

    public void setGerminationRate(Long germinationRate) {
        this.germinationRate = germinationRate;
    }

    public Long getGerminationViability() {
        return germinationViability;
    }

    public void setGerminationViability(Long germinationViability) {
        this.germinationViability = germinationViability;
    }

    public Long getMoisture() {
        return moisture;
    }

    public void setMoisture(Long moisture) {
        this.moisture = moisture;
    }

    public Calendar getStorageDate() {
        return storageDate;
    }

    public void setStorageDate(Calendar storageDate) {
        this.storageDate = storageDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


    public Long getAccessionParentId() {
        return accessionParentId;
    }

    public void setAccessionParentId(Long accessionParentId) {
        this.accessionParentId = accessionParentId;
    }

    public Long getCollectionTypeId() {
        return collectionTypeId;
    }

    public void setCollectionTypeId(Long collectionTypeId) {
        this.collectionTypeId = collectionTypeId;
    }

    public Long getGerminationMethodTypeId() {
        return germinationMethodTypeId;
    }

    public void setGerminationMethodTypeId(Long germinationMethodTypeId) {
        this.germinationMethodTypeId = germinationMethodTypeId;
    }

    public Long getMoistureMethodTypeId() {
        return moistureMethodTypeId;
    }

    public void setMoistureMethodTypeId(Long moistureMethodTypeId) {
        this.moistureMethodTypeId = moistureMethodTypeId;
    }

    public Long getPassportId() {
        return passportId;
    }

    public void setPassportId(Long passportId) {
        this.passportId = passportId;
    }

    public Long getResponsablePersonId() {
        return responsablePersonId;
    }

    public void setResponsablePersonId(Long responsablePersonId) {
        this.responsablePersonId = responsablePersonId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accessionId != null ? accessionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accession)) {
            return false;
        }
        Accession other = (Accession) object;
        if ((this.accessionId == null && other.accessionId != null) || (this.accessionId != null && !this.accessionId.equals(other.accessionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.germoplasma.Accession[accessionId=" + accessionId + "]";
    }

    /**
     * @return the originalWeigth
     */
    public Long getOriginalWeigth() {
        return originalWeigth;
    }

    /**
     * @param originalWeigth the originalWeigth to set
     */
    public void setOriginalWeigth(Long originalWeigth) {
        this.originalWeigth = originalWeigth;
    }

    /**
     * @return the currentWeigth
     */
    public Long getCurrentWeigth() {
        return currentWeigth;
    }

    /**
     * @param currentWeigth the currentWeigth to set
     */
    public void setCurrentWeigth(Long currentWeigth) {
        this.currentWeigth = currentWeigth;
    }

}
