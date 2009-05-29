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
 * IdentificationBean.java
 *
 * Created on June 24, 2008, 11:03 PM
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
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;
import org.inbio.ara.persistence.institution.Institution;
import org.inbio.ara.persistence.person.Person;
import org.inbio.ara.persistence.specimen.Identification;
import org.inbio.ara.persistence.specimen.IdentificationHistory;
import org.inbio.ara.persistence.specimen.IdentificationPK;
import org.inbio.ara.persistence.specimen.IdentificationStatus;
import org.inbio.ara.persistence.specimen.IdentificationType;
import org.inbio.ara.persistence.specimen.Identifier;
import org.inbio.ara.persistence.specimen.IdentifierHistory;
import org.inbio.ara.persistence.specimen.IdentifierPK;
import org.inbio.ara.persistence.specimen.Specimen;
import org.inbio.ara.persistence.specimen.SpecimenLifeStageSex;
import org.inbio.ara.persistence.specimen.SpecimenLifeStageSexPK;
import org.inbio.ara.persistence.specimen.TypeSpecimen;
import org.inbio.ara.persistence.specimen.TypeSpecimenType;
import org.inbio.ara.persistence.taxonomy.Taxon;

/**
 *
 * @author roaguilar
 */
@Stateless
public class IdentificationBean implements org.inbio.ara.facade.specimen.IdentificationRemote, org.inbio.ara.facade.specimen.IdentificationLocal {
    
    @PersistenceContext
    private EntityManager em;
    private String message;
    
    /** Creates a new instance of IdentificationBean */
    public IdentificationBean() {
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        System.out.println(message);
        this.message = message;
    }
    
    public List getIdentification() {
        Query q;
        try {
            q = em.createQuery("Select object(o) from Identification as o order by o.identificationPK.identificationSequence desc");
            //em.createNativeQuery()
            return q.getResultList();
        } catch(IllegalStateException ex1) {
            this.setMessage(ex1.getMessage());
            return null;
        } catch (IllegalArgumentException ex2) {
            this.setMessage(ex2.getMessage());
            return null;
        }
    }
    
    public List getIdentificationByCollection(Long CollectionId) {
        Query q;
        try {
            em.setFlushMode(FlushModeType.COMMIT);
            q = em.createQuery("Select object(o) from Identification as o where o.specimen.collection.id = " + CollectionId + " order by o.identificationPK.identificationSequence desc");
            List result = (List)q.getResultList();
            em.setFlushMode(FlushModeType.AUTO);
            return result;
        } catch(IllegalStateException ex1) {
            this.setMessage(ex1.getMessage());
            return null;
        } catch (IllegalArgumentException ex2) {
            this.setMessage(ex2.getMessage());
            return null;
        }
    }
    
    public List getIdentification(Long specimenId) {
        Query q;
        try {
            q = em.createQuery("Select object(o) from Identification as o where o.specimen.id = " + specimenId + " order by o.identificationDate desc");
            return q.getResultList();
        } catch(IllegalStateException ex1) {
            this.setMessage(ex1.getMessage());
            return null;
        } catch (IllegalArgumentException ex2) {
            this.setMessage(ex2.getMessage());
            return null;
        }
    }
    
    public boolean reIdentify(Identification identification, Long[] specimenList, Long[] taxonList, Long[] identifierArray, List lifeStageSexList, Long typeSpecimenTypeId, Long institutionId) {
        int reIdentifiedCount = 0;
        int notIdentifiedCount = 0;
        String historyErrorCount= "";
        for (int i =0;i<specimenList.length;i++) {
            if (createIdentificationHistory(specimenList[i], identification.getDataEntryError())) {
                if (this.createIdentification(identification, specimenList[i], taxonList, identifierArray, typeSpecimenTypeId, institutionId)) {
                    updateSpecimenLifeStageSex(specimenList[i],lifeStageSexList, identification.getCreatedBy());
                    reIdentifiedCount++;
                } else {
                    notIdentifiedCount++;
                }
            } else {
                historyErrorCount+= ", " + specimenList[i];
            }
        }
        this.setMessage("Espec�menes identificados: " + reIdentifiedCount + ". Errores de identificaci�n: " + notIdentifiedCount + ". Especimenes no procesados: " + historyErrorCount);
        return true;
    }
    
    public boolean updateSpecimenLifeStageSex(Long specimenId, List<LifeStageSexSimple> lifeStageSexList, String userName) {
        if (deleteCurrentSpecimenLifeStageSex(specimenId)) {
            List<LifeStageSexSimple> list = lifeStageSexList;
            for (LifeStageSexSimple obj: list) {
                SpecimenLifeStageSexPK pk = new SpecimenLifeStageSexPK();
                pk.setSpecimenId(specimenId);
                pk.setLifeStageId(obj.getLifeStage().getId());
                pk.setSexId(obj.getSex().getId());

                SpecimenLifeStageSex specimenLifeStageSex = new SpecimenLifeStageSex(pk);
                specimenLifeStageSex.setQuantity(obj.getQuantity());
                specimenLifeStageSex.setCreatedBy(userName);
                specimenLifeStageSex.setLastModificationBy(userName);

                em.persist(specimenLifeStageSex);
            }
        }
        return true;
    }
    
    public boolean deleteCurrentSpecimenLifeStageSex(Long specimenId) {
        try {
            Query q = em.createNativeQuery("delete from ara.specimen_life_stage_sex where specimen_id = " + specimenId);
            q.executeUpdate();
            return true;
        } catch (IllegalStateException ex) {
            this.setMessage(ex.getMessage());
            return false;
        } catch (TransactionRequiredException ex2) {
            this.setMessage(ex2.getMessage());
            return false;            
        }
    }
    
    public boolean createIdentification(Identification identification, Long specimenId, Long[] taxonList, Long[] identifierList, Long typeSpecimenTypeId, Long institutionId) {
        try {
            // RA TEST
            //System.out.println("# de identificaciones actuales para el especimen " + specimenId + " : " + this.getIdentification(specimenId).size());
            for (int i=0; i<taxonList.length;i++) {
                // Construir la llave primera de la identificaci�n
                IdentificationPK pk = new IdentificationPK();
                pk.setIdentificationSequence(1L+i); // Secuencia de identificaci�n
                pk.setSpecimenId(specimenId);   // ID del especimen a identificar
                pk.setInitialTimeStamp(new Date());   // Fecha del d�a de la identificaci�n

                // Construir el objeto Identification
                //IdentificationTest identification = new IdentificationTest();
                Identification obj = new Identification(pk);

                // Fecha de la identificaci�n
                obj.setIdentificationDate(identification.getIdentificationDate());
                // Tipo de identificaci�n
                if (identification.getIdentificationType()!=null) {
                    obj.setIdentificationType(em.find(IdentificationType.class,identification.getIdentificationType().getId()));
                }

                // Estado de la identificaci�n
                obj.setIdentificationStatus(em.find(IdentificationStatus.class,identification.getIdentificationStatus().getId()));

                // Taxon
                obj.setTaxon(em.find(Taxon.class,taxonList[i]));

                // Validador de la identificaci�n
                if (identification.getValuerPerson()!=null) {
                    obj.setValuerPerson(em.find(Person.class,identification.getValuerPerson().getId()));
                }
                // No es error de entrada de datos
                obj.setDataEntryError("n");                    
                // Info de bitacoria                    
                obj.setCreatedBy(identification.getCreatedBy());
                obj.setLastModificationBy(identification.getCreatedBy());
                
                // Asignar los identificadores
                if (identifierList != null) {
                    if(identifierList.length>0) {
                        List<Identifier> tList = new ArrayList();
                        for (int x=0; x< identifierList.length;x++) {
                            IdentifierPK pkI = new IdentifierPK();
                            pkI.setIdentifierPersonId(identifierList[i]);
                            pkI.setIdentificationSequence(obj.getIdentificationPK().getIdentificationSequence());
                            pkI.setInitialTimeStamp(obj.getIdentificationPK().getInitialTimeStamp());
                            pkI.setSpecimenId(obj.getIdentificationPK().getSpecimenId());

                            // Crear el objeto Identifier
                            Identifier identifier = new Identifier();
                            identifier.setIdentifierPK(pkI);
                            identifier.setIdentifierSequence(1L+x);
                            identifier.setCreatedBy(obj.getCreatedBy());
                            identifier.setLastModificationBy(obj.getCreatedBy());
                            tList.add(identifier);
                        }
                        obj.setIdentifierList(tList);
                    }
                }
                
                // Grabar la informaci�n
                //System.out.println("Identification a persistir: " + obj.getIdentificationPK().toString());
                em.persist(obj);
                
                // Grabar la informaci�n del tipo en caso necesario
                if (typeSpecimenTypeId != null) {
                    TypeSpecimen typeSpecimen = new TypeSpecimen();
                    typeSpecimen.setIdentificationSequence(obj.getIdentificationPK().getIdentificationSequence());
                    typeSpecimen.setInitialTimeStamp(new Date());
                    typeSpecimen.setInstitution(em.find(Institution.class,institutionId));
                    typeSpecimen.setSpecimen(em.find(Specimen.class,obj.getIdentificationPK().getSpecimenId()));
                    typeSpecimen.setTaxon(em.find(Taxon.class,obj.getTaxon().getTaxonId()));
                    typeSpecimen.setTaxonomicalTimeStamp(new Date());
                    typeSpecimen.setTypeSpecimenType(em.find(TypeSpecimenType.class,typeSpecimenTypeId));
                    typeSpecimen.setCreatedBy(obj.getCreatedBy());
                    typeSpecimen.setLastModificationBy(obj.getLastModificationBy());
                    em.persist(typeSpecimen);
                }
            }
            return true;
        } catch (EntityExistsException ex) {
            this.setMessage(ex.getMessage());
            return false;
        } catch (IllegalStateException ex2) {
            this.setMessage(ex2.getMessage());
            return false;
        } catch (IllegalArgumentException ex3) {
            this.setMessage(ex3.getMessage());
            return false;
        } catch (TransactionRequiredException ex4) {
            this.setMessage(ex4.getMessage());
            return false;
        }
    }
    
    private boolean createIdentificationHistory(Long specimenId, String dataEntryError) {
        if (specimenId != null) {
            if (specimenId > 0L) {
                List<Identification> idList = this.getIdentification(specimenId);
                if (idList != null) {
                    if (idList.size() > 0) {
                        //System.out.println("* - createIdentificationHistory");
                        //System.out.println("Identificaciones actuales del especimen " + specimenId + " : " + idList.size());
                        for (Identification tmp: idList) {
                            try {
                                // Construir el objeto IdentificationHistory
                                IdentificationHistory identificationHistory = new IdentificationHistory();
                                // Fecha de la identificaci�n
                                identificationHistory.setIdentificationHistoryDate(tmp.getIdentificationDate());

                                // Tipo de identificaci�n
                                if (tmp.getIdentificationType()!=null) {
                                    identificationHistory.setIdentificationType(em.find(IdentificationType.class,tmp.getIdentificationType().getId()));
                                }

                                // Estado de la identificaci�n
                                identificationHistory.setIdentificationStatus(em.find(IdentificationStatus.class,tmp.getIdentificationStatus().getId()));

                                // Validador de la identificaci�n
                                if (tmp.getValuerPerson()!=null) {
                                    identificationHistory.setValuerPerson(em.find(Person.class,tmp.getValuerPerson().getId()));
                                }
                                // error de entrada de datos s/n
                                //identificationHistory.setDataEntryError(tmp.getDataEntryError());
                                identificationHistory.setDataEntryError(dataEntryError);
                                // Info de bitacoria                    
                                identificationHistory.setCreatedBy(tmp.getCreatedBy());
                                identificationHistory.setCreationDate(tmp.getCreationDate());
                                identificationHistory.setLastModificationBy(tmp.getLastModificationBy());
                                identificationHistory.setLastModificationDate(tmp.getLastModificationDate());
                                identificationHistory.setInitialTimeStamp(tmp.getIdentificationPK().getInitialTimeStamp());
                                identificationHistory.setFinalTimeStamp(new Date());
                                identificationHistory.setSpecimen(em.find(Specimen.class,tmp.getIdentificationPK().getSpecimenId()));
                                identificationHistory.setTaxon(em.find(Taxon.class,tmp.getTaxon().getTaxonId()));
                                identificationHistory.setIdentificationSequence(tmp.getIdentificationPK().getIdentificationSequence());
                                // Grabar la informaci�n
                                em.persist(identificationHistory);
                                
                                // Hist�rico de Identificadores 
                                if (tmp.getIdentifierList() != null) {
                                    if (tmp.getIdentifierList().size() > 0) {
                                        List<Identifier> identifierList = tmp.getIdentifierList();
                                        for (Identifier tmp2: identifierList) {
                                            IdentifierHistory identifierHistory = new IdentifierHistory();
                                            identifierHistory.setCreatedBy(tmp2.getCreatedBy());
                                            identifierHistory.setCreationDate(tmp2.getCreationDate());
                                            identifierHistory.setIdentificationSequence(identificationHistory.getIdentificationSequence());
                                            identifierHistory.setIdentifier(em.find(Person.class,tmp2.getPerson().getId()));
                                            identifierHistory.setIdentifierSequence(tmp2.getIdentifierSequence());
                                            identifierHistory.setInitialTimeStamp(identificationHistory.getInitialTimeStamp());
                                            identifierHistory.setLastModificationBy(tmp2.getLastModificationBy());
                                            identifierHistory.setLastModificationDate(tmp2.getLastModificationDate());
                                            identifierHistory.setSpecimenId(identificationHistory.getSpecimen().getId());
                                            em.persist(identifierHistory);
                                            em.remove(tmp2);
                                        }
                                    }
                                }
                                //System.out.println("Identification a borrar: " + tmp.getIdentificationPK());
                                em.remove(em.find(Identification.class,tmp.getIdentificationPK()));
                            } catch (EntityExistsException ex) {
                                this.setMessage(ex.getMessage());
                                return false;
                            } catch (IllegalStateException ex2) {
                                this.setMessage(ex2.getMessage());
                                return false;
                            } catch (IllegalArgumentException ex3) {
                                this.setMessage(ex3.getMessage());
                                return false;
                            } catch (TransactionRequiredException ex4) {
                                this.setMessage(ex4.getMessage());
                                return false;
                            }
                        }
                    }
                }
                return true;
            } else {
                this.setMessage("N�mero de espec�men inv�lido: " + specimenId);
                return false;
            }
        } else {
            this.setMessage("N�mero de espec�men inv�lido: par�metro nulo");
            return false;
        }
    }
    
    public boolean delete (IdentificationPK pk) {
        try {
            //Identification identification = em.find(Identification.class, pk);
            Identification identification = this.getIdentification(pk);
            if (identification!= null) {
                em.remove(identification);
                return true;
            } else {
                this.setMessage("No se encontr� el registro indicado. " + this.getMessage());
                return false;
            }
        } catch (IllegalStateException ex1) {
            this.setMessage(ex1.getMessage());
            return false;
        } catch (IllegalArgumentException ex2) {
            this.setMessage(ex2.getMessage());
            return false;
        } catch (TransactionRequiredException ex3) {
            this.setMessage(ex3.getMessage());
            return false;
        }
    }
    
    private Identification getIdentification(IdentificationPK pk) {
        try {
            String tmp = "Select object(o) from Identification as o where o.identificationPK.specimenId = " + pk.getSpecimenId() + " and o.identificationPK.identificationSequence = " + pk.getIdentificationSequence() + " and o.identificationPK.initialTimeStamp ='" + pk.getInitialTimeStamp().toString() + "'";
            Query q = em.createQuery(tmp);
            return (Identification)q.getSingleResult();
        } catch (Exception ex) {
            this.setMessage(ex.getMessage());
            return null;
        }
    }
    
    public int getSpecimenCountByTaxon(Long taxonId, java.lang.Long collectionId) {
        String sql = "select count(i.specimen_id) from ara.identification as i, ara.specimen as s where i.taxon_id = " + taxonId + " and i.specimen_id = s.specimen_id and s.collection_id = " + collectionId;
        return this.getSpecimenCount(sql);
    }
    
    public Long[] getSpecimenByTaxon(Long taxonId, java.lang.Long collectionId) {
        String sql = "select i.specimen_id from ara.identification as i, ara.specimen as s where i.taxon_id = " + taxonId + " and i.specimen_id = s.specimen_id and s.collection_id = " + collectionId;
        return this.getSpecimenArray(sql);
    }
    
    public int getSpecimenCountByGathering(Long gatheringId, java.lang.Long collectionId) {
        String sql = "select count(specimen_id) from ara.specimen where gathering_observation_id = " + gatheringId + " and collection_id = " + collectionId;
        return this.getSpecimenCount(sql);
    }
    
    public Long[] getSpecimenByGathering(Long gatheringId, java.lang.Long collectionId) {
        String sql = "select specimen_id from ara.specimen where gathering_observation_id = " + gatheringId + " and collection_id = " + collectionId;
        return this.getSpecimenArray(sql);
    }
    
    public int getSpecimenCountByGatheringDetail(Long personId, String gatheringDetailNumber, Long collectionId) {
        //String sql = "select count(specimen_id) from ara.specimen where gathering_observation_id = " + gatheringId + " and collection_id = " + collectionId;
        String sql = "select count(s.specimen_id) from ara.specimen as s, ara.gathering_observation_detail as g where s.gathering_observation_detail_id = g.gathering_observation_detail_id and g.gathering_observation_detail_person_id = " + personId + " and g.gathering_observation_detail_number = '" + gatheringDetailNumber + "' and s.collection_id = " + collectionId;
        return this.getSpecimenCount(sql);
    }
    
    public Long[] getSpecimenByGatheringDetail(Long personId, String gatheringDetailNumber, Long collectionId) {
        //String sql = "select count(specimen_id) from ara.specimen where gathering_observation_id = " + gatheringId + " and collection_id = " + collectionId;
        String sql = "select distinct s.specimen_id from ara.specimen as s, ara.gathering_observation_detail as g where s.gathering_observation_detail_id = g.gathering_observation_detail_id and g.gathering_observation_detail_person_id = " + personId + " and g.gathering_observation_detail_number = '" + gatheringDetailNumber + "' and s.collection_id = " + collectionId;
        return this.getSpecimenArray(sql);
    }
    
    private int getSpecimenCount(String sql) {
        try {
            Query q = em.createNativeQuery(sql);
            Object obj = q.getSingleResult();
            int count = 0 + Integer.parseInt(obj.toString());
            return count;
        } catch (Exception ex) {
            this.setMessage(ex.getMessage());
            return -1;
        }
    }
    
    private Long[] getSpecimenArray(String sql) {
        try {
            Query q = em.createNativeQuery(sql);
            Long[] specimenArray = new Long[]{};
            List list = q.getResultList();
            int size = list.size();
            int index = 0;
            if (size >0 ) {
              specimenArray = new Long[size];
              for (Object obj: list) {
                  System.out.println(obj.toString());
                  specimenArray[index] = Long.parseLong(obj.toString());
                  index++;
              }
            } 
            return specimenArray;
        } catch (Exception ex) {
            this.setMessage(ex.getMessage());
            return null;
        }
    }
}
