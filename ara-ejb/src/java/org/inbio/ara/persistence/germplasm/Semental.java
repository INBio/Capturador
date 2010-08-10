/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.germplasm;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.persistence.LogGenericEntity;
import org.inbio.ara.persistence.gis.Site;

/**
 *
 * @author dasolano
 */
@Entity
@Table(name = "semental")
public class Semental extends LogGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="semental")
    @SequenceGenerator(name="semental", sequenceName="semental_seq")
    @Basic(optional = false)
    @Column(name = "semental_id")
    private Long sementalId;

    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Column(name = "animal_code")
    private String animalCode;

    @Column(name = "color")
    private String color;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Calendar birthDate;

    @Column(name = "veterinarian_status")
    private String veterinarianStatus;

    @Column(name = "animal_description")
    private String animalDescription;

    @Column(name = "father")
    private String father;

    @Column(name = "mother")
    private String mother;

    @Basic(optional = false)
    @Column(name = "breed_id")
    private Long breedId;

    @Column(name = "condition_id")
    private Long conditionId;

    @Column(name = "site_id")
    private Long siteId;

    public Semental() {
    }

    public Semental(Long sementalId) {
        this.sementalId = sementalId;
    }

    public Semental(Long sementalId, String animalCode, String color, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.sementalId = sementalId;
        this.animalCode = animalCode;
        this.color = color;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getSementalId() {
        return sementalId;
    }

    public void setSementalId(Long sementalId) {
        this.sementalId = sementalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnimalCode() {
        return animalCode;
    }

    public void setAnimalCode(String animalCode) {
        this.animalCode = animalCode;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public String getVeterinarianStatus() {
        return veterinarianStatus;
    }

    public void setVeterinarianStatus(String veterinarianStatus) {
        this.veterinarianStatus = veterinarianStatus;
    }

    public String getAnimalDescription() {
        return animalDescription;
    }

    public void setAnimalDescription(String animalDescription) {
        this.animalDescription = animalDescription;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sementalId != null ? sementalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Semental)) {
            return false;
        }
        Semental other = (Semental) object;
        if ((this.sementalId == null && other.sementalId != null) || (this.sementalId != null && !this.sementalId.equals(other.sementalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.germplasm.Semental[sementalId=" + sementalId + "]";
    }

    /**
     * @return the breedId
     */
    public Long getBreedId() {
        return breedId;
    }

    /**
     * @param breedId the breedId to set
     */
    public void setBreedId(Long breedId) {
        this.breedId = breedId;
    }

    /**
     * @return the conditionId
     */
    public Long getConditionId() {
        return conditionId;
    }

    /**
     * @param conditionId the conditionId to set
     */
    public void setConditionId(Long conditionId) {
        this.conditionId = conditionId;
    }

    /**
     * @return the siteId
     */
    public Long getSiteId() {
        return siteId;
    }

    /**
     * @param siteId the siteId to set
     */
    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

}
