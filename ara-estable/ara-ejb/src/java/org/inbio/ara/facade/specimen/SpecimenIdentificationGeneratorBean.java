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
 * SpecimenIdentificationGeneratorBean.java
 *
 * Created on June 21, 2008, 5:51 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.specimen;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;
import org.inbio.ara.persistence.gathering.GatheringObservationDetail;
import org.inbio.ara.persistence.gathering.MorphologicalDescription;
import org.inbio.ara.persistence.specimen.LifeStage;
import org.inbio.ara.persistence.specimen.Origin;
import org.inbio.ara.persistence.specimen.PreservationMedium;
import org.inbio.ara.persistence.specimen.Sex;
import org.inbio.ara.persistence.specimen.Specimen;
import org.inbio.ara.persistence.specimen.SpecimenCategory;
import org.inbio.ara.persistence.specimen.SpecimenType;
import org.inbio.ara.persistence.specimen.StorageType;
import org.inbio.ara.persistence.specimen.Substrate;
import org.inbio.ara.persistence.collection.Collection;
import org.inbio.ara.persistence.gathering.GatheringObservation;
import org.inbio.ara.persistence.gathering.GatheringObservationMethod;
import org.inbio.ara.persistence.person.Person;
import org.inbio.ara.persistence.specimen.ExtractionType;
import org.inbio.ara.persistence.specimen.Identification;
import org.inbio.ara.persistence.specimen.IdentificationPK;
import org.inbio.ara.persistence.specimen.IdentificationStatus;
import org.inbio.ara.persistence.specimen.IdentificationType;
import org.inbio.ara.persistence.specimen.Identifier;
import org.inbio.ara.persistence.specimen.IdentifierPK;
import org.inbio.ara.persistence.specimen.SpecimenLifeForm;
import org.inbio.ara.persistence.specimen.SpecimenLifeFormPK;
import org.inbio.ara.persistence.specimen.SpecimenLifeStageSex;
import org.inbio.ara.persistence.specimen.SpecimenLifeStageSexPK;
import org.inbio.ara.persistence.taxonomy.Taxon;

/**
 *
 * @author roaguilar
 */
@Stateless
public class SpecimenIdentificationGeneratorBean implements SpecimenIdentificationGeneratorRemote, SpecimenIdentificationGeneratorLocal {

    @PersistenceContext
    private EntityManager em;
    private String message;
    private SpecimenGenParms specimenGenParms;
    private List<Specimen> specimenList = new ArrayList();
    
    /** Creates a new instance of SpecimenIdentificationGeneratorBean */
    public SpecimenIdentificationGeneratorBean() {
    }

    private Object getEntity(Class clase, Object id) {
        try {
            Object obj = em.find(clase,id);
            if (obj == null) {
                System.out.println ("Objeto no encontrado: " + clase.getName() + ", " + id);
            }
            return obj;
        } catch (IllegalArgumentException ex1) {
            System.out.println (ex1.getMessage());
            return null;
        } catch(IllegalStateException ex2) {
            System.out.println (ex2.getMessage());
            return null;
        }
    }

    
    private boolean persist(Specimen specimen) {
        try {
            // Incorporar las entidades auxiliares al contexto de la transacción
            // Primero las obligatorias
            specimen.setSpecimenCategory(em.find(SpecimenCategory.class,specimen.getSpecimenCategory().getId()));
            specimen.setGatheringObservation(em.find(GatheringObservation.class,specimen.getGatheringObservation().getId()));
            specimen.setCollection(em.find(Collection.class,specimen.getCollection().getId()));
            specimen.setGatheringObservationMethod(em.find(GatheringObservationMethod.class,specimen.getGatheringObservationMethod().getId()));
            // Luego las opcionales
            if (specimen.getSpecimenType() != null) {
                specimen.setSpecimenType(em.find(SpecimenType.class,specimen.getSpecimenType().getId()));
            }
            if (specimen.getStorageType()!=null) {
                specimen.setStorageType(em.find(StorageType.class,specimen.getStorageType().getId()));
            }
            if(specimen.getSubstrate()!=null) {
                specimen.setSubstrate(em.find(Substrate.class,specimen.getSubstrate().getId()));
            }
            if(specimen.getOrigin()!=null){
                specimen.setOrigin(em.find(Origin.class,specimen.getOrigin().getId()));
            }
            if(specimen.getPreservationMedium()!=null){
                specimen.setPreservationMedium(em.find(PreservationMedium.class,specimen.getPreservationMedium().getId()));
            }
            if(specimen.getGatheringObservationDetail()!=null) {
                specimen.setGatheringObservationDetail(em.find(GatheringObservationDetail.class,specimen.getGatheringObservationDetail().getId()));
            }
            if(specimen.getMorphologicalDescription()!=null) {
                specimen.setMorphologicalDescription(em.find(MorphologicalDescription.class,specimen.getMorphologicalDescription().getId()));
            }
            if(specimen.getLifeStage()!=null) {
                specimen.setLifeStage(em.find(LifeStage.class,specimen.getLifeStage().getId()));
            } 
            if(specimen.getSex()!=null){
                specimen.setSex(em.find(Sex.class,specimen.getSex().getId()));
            }
            
            if(specimen.getExtractionType()!=null){
                specimen.setExtractionType(em.find(ExtractionType.class,specimen.getExtractionType().getId()));
            }
            em.persist(specimen);
            specimen.postLoad();
            this.getSpecimenList().add(specimen);
            // Asociar SpecimenLifeForm
            if (specimenGenParms.useLifeForm()) {
                if (specimenGenParms.getLifeForm()!= null) {
                    if (specimenGenParms.getLifeForm().length > 0) {
                        for (int i=0; i<specimenGenParms.getLifeForm().length; i++) {
                            SpecimenLifeFormPK pk = new SpecimenLifeFormPK();
                            pk.setLifeForm(specimenGenParms.getLifeForm()[i].getId());
                            pk.setSpecimenId(specimen.getId());                        
                            //SpecimenLifeForm specimenLifeForm = new SpecimenLifeForm();
                            //specimenLifeForm.setSpecimenLifeFormPK(pk);
                            SpecimenLifeForm specimenLifeForm = new SpecimenLifeForm(pk);
                            specimenLifeForm.setCreatedBy(specimen.getCreatedBy());
                            specimenLifeForm.setLastModificationBy(specimen.getCreatedBy());

                            System.out.println(specimenLifeForm.getSpecimenLifeFormPK().getLifeForm());
                            System.out.println(specimenLifeForm.getSpecimenLifeFormPK().getSpecimenId());
                            System.out.println(specimenLifeForm.getCreatedBy());
                            System.out.println(specimenLifeForm.getLastModificationBy());
                            persistLifeForm(specimenLifeForm);
                        }
                    }
                }
            }
            
            // Asociar estad�os y sexos
            if (specimenGenParms.useMultipleLifeStageSex()) {
                if (specimenGenParms.getLifeStageSexSimple()!=null) {
                    if (specimenGenParms.getLifeStageSexSimple().size() > 0) {
                        List<LifeStageSexSimple> list = specimenGenParms.getLifeStageSexSimple();
                        for (LifeStageSexSimple obj: list) {
                            SpecimenLifeStageSexPK pk = new SpecimenLifeStageSexPK();
                            pk.setSpecimenId(specimen.getId());
                            pk.setLifeStageId(obj.getLifeStage().getId());
                            pk.setSexId(obj.getSex().getId());

                            SpecimenLifeStageSex specimenLifeStageSex = new SpecimenLifeStageSex(pk);
                            specimenLifeStageSex.setQuantity(obj.getQuantity());
                            specimenLifeStageSex.setCreatedBy(specimen.getCreatedBy());
                            specimenLifeStageSex.setLastModificationBy(specimen.getCreatedBy());

                            System.out.println(specimenLifeStageSex.getSpecimenLifeStageSexPK().getSpecimenId());
                            System.out.println(specimenLifeStageSex.getSpecimenLifeStageSexPK().getLifeStageId());
                            System.out.println(specimenLifeStageSex.getSpecimenLifeStageSexPK().getSexId());
                            System.out.println(specimenLifeStageSex.getQuantity());
                            System.out.println(specimenLifeStageSex.getCreatedBy());
                            System.out.println(specimenLifeStageSex.getLastModificationBy());
                            em.persist(specimenLifeStageSex);
							em.flush();
                        }
                    }
                }
            } else {
                if (specimenGenParms.getLifeStageSexSimple()!=null) {
                    if (specimenGenParms.getLifeStageSexSimple().size() > 0) {
                        LifeStageSexSimple obj = (LifeStageSexSimple)specimenGenParms.getLifeStageSexSimple().get(0);
                        specimen.setLifeStage(em.find(LifeStage.class,obj.getLifeStage().getId()));
                        specimen.setSex(em.find(Sex.class,obj.getSex().getId()));
                        specimen = em.merge(specimen);
                    }                
                }
            } 
            
            // Asociar identificaciones
            // Proceder solamente si hay taxones seleccionados
            if (specimenGenParms.getTaxonArray().length > 0) {
                // Recorrer el arreglo con los ID de taxones
                Long idSeq = 1L;
                for (int i = 0; i < specimenGenParms.getTaxonArray().length; i++) {
                    // Construir la llave primera de la identificaci�n
                    IdentificationPK pk = new IdentificationPK();
                    pk.setIdentificationSequence(idSeq); // Secuencia de identificaci�n
                    pk.setSpecimenId(specimen.getId());   // ID del especimen a identificar
                    pk.setInitialTimeStamp(new Date());   // Fecha del d�a de la identificaci�n
                    
                    // Construir el objeto Identification
                    //IdentificationTest identification = new IdentificationTest();
                    Identification identification = new Identification(pk);
                    //identification.setIdentificationPK(pk);

                    // Fecha de la identificaci�n
                    identification.setIdentificationDate(specimenGenParms.getIdentificationDate());
                    // Tipo de identificaci�n
                    if (specimenGenParms.getIdentificationTypeId()!=null) {
                        identification.setIdentificationType(em.find(IdentificationType.class,specimenGenParms.getIdentificationTypeId()));
                    }
                    
                    // Estado de la identificaci�n
                    identification.setIdentificationStatus(em.find(IdentificationStatus.class,specimenGenParms.getIdentificationStatusId()));

                    // Taxon
                    identification.setTaxon(em.find(Taxon.class,specimenGenParms.getTaxonArray()[i]));
                    
                    // Validador de la identificaci�n
                    if (specimenGenParms.getValuerPersonId()!=null) {
                        identification.setValuerPerson(em.find(Person.class,specimenGenParms.getValuerPersonId()));
                    }
                    // No es error de entrada de datos
                    identification.setDataEntryError("n");                    
                    // Info de bitacoria                    
                    identification.setCreatedBy(specimen.getCreatedBy());
                    identification.setLastModificationBy(specimen.getCreatedBy());
                    // Grabar la informaci�n
                    em.persist(identification);
                    idSeq++;
                    
                    // Identificadores
                    if (specimenGenParms.getIdentifierArray()!= null) {
                        if (specimenGenParms.getIdentifierArray().length > 0) {
                            Long idSeqId = 1L;
                            for (int z=0; z<specimenGenParms.getIdentifierArray().length; z++ ) {
                                IdentifierPK pkI = new IdentifierPK();
                                // ID del identificador
                                pkI.setIdentifierPersonId(specimenGenParms.getIdentifierArray()[z]);
                                // Llave primaria del objeto Identification
                                pkI.setIdentificationSequence(identification.getIdentificationPK().getIdentificationSequence());
                                pkI.setInitialTimeStamp(identification.getIdentificationPK().getInitialTimeStamp());
                                pkI.setSpecimenId(identification.getIdentificationPK().getSpecimenId());
                                
                                // Crear el objeto Identifier
                                Identifier identifier = new Identifier();
                                identifier.setIdentifierPK(pkI);
                                identifier.setIdentifierSequence(idSeqId);
                                identifier.setCreatedBy(identification.getCreatedBy());
                                identifier.setLastModificationBy(identification.getCreatedBy());
                                em.persist(identifier);
                                idSeqId++;
                            }                            
                            
                        }
                    }
                }
            }
            return true;
        } catch(EntityExistsException ex0) {
            this.setMessage(ex0.getMessage());
            return false;
        } catch(IllegalStateException ex1) {
            this.setMessage(ex1.getMessage());
            return false;
        } catch (IllegalArgumentException ex2) {
            this.setMessage(ex2.getMessage());
            return false;
        }
    }
    
    private void printSpecimen(Specimen specimen) {
        System.out.println("id: " + specimen.getId());
        System.out.println(specimen.getCollection().getId() + " -> Coleccion");
        System.out.println(specimen.getCreatedBy() + " -> Creado por");
        System.out.println(specimen.getCreationDate() + " -> fecha creacion");
        System.out.println(specimen.getDiscarded() + " -> descartado");
        System.out.println(specimen.getGatheringObservation().getId() + " -> recoleccion");
        //System.out.println(specimen.getGatheringObservationDetail().getId() + " -> detalle de colecta");
        System.out.println(specimen.getLastModificationBy() + " -> modificado por");
        System.out.println(specimen.getLastModificationDate() + " -> fecha de modificacion");
        //System.out.println(specimen.getLifeStage().getId() + " -> stadio");
        System.out.println(specimen.getOrigin().getId() + " -> origen");
        System.out.println(specimen.getPreservationMedium().getId() + " -> preservacion");
        System.out.println(specimen.getSpecimenCategory().getId() + " -> categoria");
        System.out.println(specimen.getSpecimenType().getId() + " -> tipo");
        System.out.println(specimen.getStorageType().getId() + " -> almacenamiento");
        System.out.println(specimen.getSubstrate().getId() + " -> sustrato");
    }

    public boolean persistLifeForm(SpecimenLifeForm specimenLifeForm) {
        try {
            em.persist(specimenLifeForm);
            return true;
        } catch(EntityExistsException ex0) {
            this.setMessage(ex0.getMessage());
            return false;
        } catch(IllegalStateException ex1) {
            this.setMessage(ex1.getMessage());
            return false;
        } catch (IllegalArgumentException ex2) {
            this.setMessage(ex2.getMessage());
            return false;
        }
    }
    
    public boolean generate(SpecimenGenParms specimenGenParms) {
        setSpecimenGenParms(specimenGenParms);
        if (!(this.getSpecimenGenParms() == null)) {
            //printSpecimen(specimenGenParms.getSpecimen());
            for (int i = 1; i<= this.specimenGenParms.getQuantity();i++) {
                if (persist(specimenGenParms.getSpecimen())) {
                    System.out.println("Especimen creado");
                } else {
                    return false;
                }
                
            }
            return true;
        } else {
            this.setMessage("No se han definido los par�metros para el proceso de generaci�n;");
            return false;
        }
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SpecimenGenParms getSpecimenGenParms() {
        return specimenGenParms;
    }

    public void setSpecimenGenParms(SpecimenGenParms specimenGenParms) {
        this.specimenGenParms = specimenGenParms;
    }    

    public List<Specimen> getSpecimenList() {
        return specimenList;
    }

    public void setSpecimenList(List<Specimen> specimenList) {
        this.specimenList = specimenList;
    }
}
