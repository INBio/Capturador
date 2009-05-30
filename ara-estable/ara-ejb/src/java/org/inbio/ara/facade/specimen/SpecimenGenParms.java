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

package org.inbio.ara.facade.specimen;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.inbio.ara.facade.util.SelectionListManagerRemote;
import org.inbio.ara.persistence.collection.Collection;
import org.inbio.ara.persistence.gathering.GatheringObservation;
import org.inbio.ara.persistence.gathering.GatheringObservationDetail;
import org.inbio.ara.persistence.gathering.GatheringObservationMethod;
import org.inbio.ara.persistence.institution.Institution;
import org.inbio.ara.persistence.specimen.ExtractionType;
import org.inbio.ara.persistence.specimen.LifeForm;
import org.inbio.ara.persistence.specimen.LifeStage;
import org.inbio.ara.persistence.specimen.Origin;
import org.inbio.ara.persistence.specimen.PreservationMedium;
import org.inbio.ara.persistence.specimen.Sex;
import org.inbio.ara.persistence.specimen.Specimen;
import org.inbio.ara.persistence.specimen.SpecimenCategory;
import org.inbio.ara.persistence.specimen.SpecimenType;
import org.inbio.ara.persistence.specimen.StorageType;
import org.inbio.ara.persistence.specimen.Substrate;


public class SpecimenGenParms implements java.io.Serializable {
    
    private int quantity;
    private GatheringObservation gatheringObservation;
    private GatheringObservationDetail gatheringObservationDetail;
    private SpecimenCategory specimenCategory;
    private Collection collection;
    private SpecimenType specimenType;
    private StorageType storageType;
    private Substrate substrate;
    private Origin origin;
    private PreservationMedium preservationMedium;
    private LifeStage lifeStage;
    private Sex sex;
    private List lifeStageSexSimple;
    private LifeForm[] lifeForm;
    private boolean useGatheringDetail;
    private boolean useLifeForm;
    private boolean useMultipleLifeStageSex;
    private Long numberWhole;
    private Long numberFragment;
    private GatheringObservationMethod gatheringObservationMethod;
    private String createdBy;
    private Long[] taxonArray = new Long[]{};
    private Long[] identifierArray = new Long[]{};
    private Date identificationDate;
    private Long identificationTypeId;
    private Long valuerPersonId;
    private Long identificationStatusId;
    private ExtractionType extractionType;
    private Date dateTime;
    private Long initialCatalogNumber;
    private Institution institution;
    
    
            
    /** Creates a new instance of SpecimenGenParms */
    public SpecimenGenParms() {
    }

    /* Getter section */
    
    public int getQuantity() {
        return quantity;
    }

    public GatheringObservation getGatheringObservation() {
        return gatheringObservation;
    }

    public GatheringObservationDetail getGatheringObservationDetail() {
        return gatheringObservationDetail;
    }

    public SpecimenCategory getSpecimenCategory() {
        return specimenCategory;
    }

    public Collection getCollection() {
        return collection;
    }

    public SpecimenType getSpecimenType() {
        return specimenType;
    }

    public StorageType getStorageType() {
        return storageType;
    }

    public Substrate getSubstrate() {
        return substrate;
    }

    public Origin getOrigin() {
        return origin;
    }

    public PreservationMedium getPreservationMedium() {
        return preservationMedium;
    }

    public LifeStage getLifeStage() {
        return lifeStage;
    }

    public Sex getSex() {
        return sex;
    }

    public List getLifeStageSexSimple() {
        return lifeStageSexSimple;
    }

    public LifeForm[] getLifeForm() {
        return lifeForm;
    }

    public boolean useGatheringDetail() {
        return useGatheringDetail;
    }

    public boolean useLifeForm() {
        return useLifeForm;
    }
    
    public boolean useMultipleLifeStageSex() {
        return useMultipleLifeStageSex;
    }
    
    public GatheringObservationMethod getGatheringObservationMethod() {
        return this.gatheringObservationMethod;
    }
    
    public String getCreatedBy() {
        return this.createdBy;
    }

    /* Setter section */

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setGatheringObservation(GatheringObservation gatheringObservation) {
        this.gatheringObservation = gatheringObservation;
        if (gatheringObservation == null) { 
            System.out.println("SpecimenGenParms: objeto recoleccion nulo");
        }        
    }

    public void setGatheringObservationDetail(GatheringObservationDetail gatheringObservationDetail) {
        this.gatheringObservationDetail = gatheringObservationDetail;
    }

    public void setSpecimenCategory(Long id) {
        if (id != null) {
            this.specimenCategory = this.lookupSelectionListManagerBean().getSpecimenCategoryById(id);
        }
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public void setSpecimenType(Long id) {
        if (id != null) {
            this.specimenType = this.lookupSelectionListManagerBean().getSpecimenTypeById(id);
        }
    }

    public void setStorageType(Long id) {
        if (id != null) {
            this.storageType = this.lookupSelectionListManagerBean().getStorageTypeById(id);
        }
    }

    public void setSubstrate(Long id) {
        if (id != null) {
            this.substrate = this.lookupSelectionListManagerBean().getSubstrateById(id);
        }
    }

    public void setOrigin(Long id) {
        if (id != null) {
            this.origin = this.lookupSelectionListManagerBean().getOriginById(id);
        }
    }

    public void setPreservationMedium(Long id) {
        if (id != null) {
            this.preservationMedium = this.lookupSelectionListManagerBean().getPreservationMediumById(id);
        }
    }

    public void setLifeStage(LifeStage lifeStage) {
        this.lifeStage = lifeStage;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setLifeStageSexSimple(List lifeStageSexSimple) {
        this.lifeStageSexSimple = lifeStageSexSimple;
    }

    public void setLifeForm(Long[] lifeFormArray) {
        if (lifeFormArray != null) {
            if (lifeFormArray.length > 0) {
                this.lifeForm = new LifeForm[lifeFormArray.length];
                for (int i=0; i<lifeFormArray.length;i++) {
                    this.lifeForm[i] = this.lookupSelectionListManagerBean().getLifeFormById(lifeFormArray[i]);
                }
            }
        }
    }

    public void setUseGatheringDetail(boolean useGatheringDetail) {
        this.useGatheringDetail = useGatheringDetail;
    }

    public void setUseLifeForm(boolean useLifeForm) {
        this.useLifeForm = useLifeForm;
    }
    
    public void setUseMultipleLifeStageSex(boolean useMultipleLifeStageSex) {
        this.useMultipleLifeStageSex = useMultipleLifeStageSex;
    }

    private SelectionListManagerRemote lookupSelectionListManagerBean() {
        try {
            Context c = new InitialContext();
            return (SelectionListManagerRemote) c.lookup("SelectionListManagerBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }

    public Long getNumberWhole() {
        return numberWhole;
    }

    public void setNumberWhole(Long numberWhole) {
        this.numberWhole = numberWhole;
    }

    public Long getNumberFragment() {
        return numberFragment;
    }

    public void setNumberFragment(Long numberFragment) {
        this.numberFragment = numberFragment;
    }
    
    public void setGatheringObservationMethod(Long id) {
        //this.gatheringObservationMethod = gatheringObservationMethod;
         if (id != null) {
            this.gatheringObservationMethod = this.lookupSelectionListManagerBean().getGatheringObservationMethodbyId(id);
        }
    }
    
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    
    public Specimen getSpecimen() {
        Specimen specimen = new Specimen();
        
        // Asignar los objetos obligatorios
        specimen.setSpecimenCategory(this.getSpecimenCategory());
        specimen.setSpecimenType(this.getSpecimenType());        
        specimen.setCollection(this.getCollection());
        specimen.setDiscarded("0");
        specimen.setGatheringObservation(this.getGatheringObservation());
        specimen.setInstitution(institution);

        if (useGatheringDetail) {
            specimen.setGatheringObservationDetail(this.getGatheringObservationDetail());
        }
        specimen.setGatheringObservationMethod(this.gatheringObservationMethod);
        specimen.setCreatedBy(this.createdBy);
        specimen.setLastModificationBy(this.createdBy);
        
        // Asignar los objetos opcionales
        if (storageType != null) {
            specimen.setStorageType(storageType);
        }
        
        if (substrate!=null) {
            specimen.setSubstrate(substrate);
        }
        
        if (origin!= null) {
            specimen.setOrigin(origin);
        }

        if (preservationMedium!=null) {
            specimen.setPreservationMedium(preservationMedium);
        }
        
        if (numberWhole!=null) {
            specimen.setNumberWhole(numberWhole);
        }
        
        if (numberFragment != null) {
            specimen.setNumberFragments(numberFragment);
        }
        
        if (dateTime != null) {
            specimen.setDateTime(this.dateTime);
        }
        //specimen.setLifeStage();
        //specimen.setSex();
        return specimen;
    }

    public Long[] getTaxonArray() {
        return taxonArray;
    }

    public void setTaxonArray(Long[] taxonArray) {
        this.taxonArray = taxonArray;
    }

    public Long[] getIdentifierArray() {
        return identifierArray;
    }

    public void setIdentifierArray(Long[] identifierArray) {
        this.identifierArray = identifierArray;
    }

    public Date getIdentificationDate() {
        return identificationDate;
    }

    public void setIdentificationDate(Date identificationDate) {
        this.identificationDate = identificationDate;
    }

    public Long getIdentificationTypeId() {
        return identificationTypeId;
    }

    public void setIdentificationTypeId(Long identificationTypeId) {
        this.identificationTypeId = identificationTypeId;
    }

    public Long getValuerPersonId() {
        return valuerPersonId;
    }

    public void setValuerPersonId(Long valuerPersonId) {
        this.valuerPersonId = valuerPersonId;
    }

    public Long getIdentificationStatusId() {
        return identificationStatusId;
    }

    public void setIdentificationStatusId(Long identificationStatusId) {
        this.identificationStatusId = identificationStatusId;
    }

    public ExtractionType getExtractionType() {
        return extractionType;
    }

    public void setExtractionType(Long id) {
        if (id != null) {
            this.extractionType = this.lookupSelectionListManagerBean().getExtractionById(id);
        }
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * @return the initialCatalogNumber
     */
    public Long getInitialCatalogNumber() {
        return initialCatalogNumber;
    }

    /**
     * @param initialCatalogNumber the initialCatalogNumber to set
     */
    public void setInitialCatalogNumber(Long initialCatalogNumber) {
        this.initialCatalogNumber = initialCatalogNumber;
    }

    /**
     * @return the institution
     */
    public Institution getInstitution() {
        return institution;
    }

    /**
     * @param institution the institution to set
     */
    public void setInstitution(Long id) {
        if (id != null) {
            institution = lookupSelectionListManagerBean().getInstitution(id);
        }
    }
}
