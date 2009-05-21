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
 * GatheringBean.java
 *
 * Created on November 4, 2007, 4:03 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.gathering;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;
import org.inbio.ara.persistence.collection.Collection;
import org.inbio.ara.persistence.gathering.CollectorObserver;
import org.inbio.ara.persistence.gathering.CollectorObserverPK;
import org.inbio.ara.persistence.gathering.Exposition;
import org.inbio.ara.persistence.gathering.GatheringObservation;
import org.inbio.ara.persistence.gathering.GatheringObservationCollection;
import org.inbio.ara.persistence.gathering.GatheringObservationCollectionPK;
import org.inbio.ara.persistence.gathering.GatheringObservationProject;
import org.inbio.ara.persistence.gathering.GatheringObservationProjectPK;
import org.inbio.ara.persistence.gathering.Label;
import org.inbio.ara.persistence.gathering.OriginalLabel;
import org.inbio.ara.persistence.gathering.Project;
import org.inbio.ara.persistence.gis.Site;
import org.inbio.ara.persistence.person.Person;

/**
 *
 * @author roaguilar
 */
@Stateless
public class GatheringBean implements GatheringRemote, GatheringLocal {

    @EJB
    private CollectorRemote collectorBean;
    
    @PersistenceContext
    private EntityManager em;
    private String message;
    private GatheringObservation gathering;
    
    /** Creates a new instance of GatheringBean */
    public GatheringBean() {
        setMessage("");
    }
    
    private boolean persist() {
        boolean persisted = false;
        if (!isGatheringNull(gathering)){
            if (this.isGatheringUnique(gathering)) {
                try {
                    // Incorporar las entidades auxiliares al contexto de la transaccion
                    // Primero las obligatorias
                    this.gathering.setSite(em.find(Site.class,this.gathering.getSite().getId()));
                    this.gathering.setResponsiblePerson(em.find(Person.class,this.gathering.getResponsiblePerson().getId()));
                    this.gathering.setCollection(em.find(Collection.class,this.gathering.getCollection().getId()));
                    // Luego las opcionales
                    if (this.gathering.getLabel()!=null) {
                        this.gathering.setLabel(em.find(Label.class,this.gathering.getLabel().getId()));
                    }
                    if (this.gathering.getOriginalLabel()!=null) {
                        this.gathering.setOriginalLabel(em.find(OriginalLabel.class,this.gathering.getOriginalLabel().getId()));
                    }
                    if (this.gathering.getExposition()!= null) {
                        this.gathering.setExposition(em.find(Exposition.class,this.gathering.getExposition().getId()));
                    }
                    em.persist(this.gathering);
                    this.gathering = em.merge(this.gathering);
                    persisted = true;
                } catch(EntityExistsException ex0) {
                    this.setMessage(ex0.getMessage());
                    return false;
                } catch(IllegalStateException ex1) {
                    this.setMessage(ex1.getMessage());
                    return false;
                } catch (IllegalArgumentException ex2) {
                    this.setMessage(ex2.getMessage());
                    return false;
                } catch (TransactionRequiredException ex3) {
                    this.setMessage(ex3.getMessage());
                    return false;
                }
            } else {
                setMessage("La recoleccion ya existe en el sistema.");
                persisted = false;
            }
        } else {
            this.setMessage(this.getMessage() + " El registro no fue creado.");
            persisted = false;
        }
        return persisted;
    }
    
    public boolean create(GatheringObservation gathering, Long[] collectorArray, Long[] projectArray, Long[] collectionArray) {
        this.setGathering(gathering);
        boolean persist = persist();
        if (persist) {
            this.updateCollectorList(collectorArray);
            this.updateCollectionList(collectionArray);
            this.updateProjectList(projectArray);
        }
        return persist;
    }
    
   
    public boolean createCollectors(Long[] collectorArray) {
        Query q;
        if (collectorArray.length > 0) {
            for (int i= 0; i < collectorArray.length; i++){

                try {
                    CollectorObserverPK pk = new CollectorObserverPK();
                    pk.setgatheringObservationId(gathering.getId());
                    pk.setPersonId(collectorArray[i]);
                    
                    CollectorObserver tmp = new CollectorObserver();
                    tmp.setCollectorPK(pk);
                    tmp.setSequence(1l + i);
                    tmp.setCreatedBy(gathering.getLastModificationBy());
                    tmp.setLastModificationBy(gathering.getLastModificationBy());

                    this.collectorBean.create(tmp);
                } catch (EntityExistsException ex1) {
                    this.setMessage("El colector ya est� asignado a la recolecci�n");
                    return false;
                } catch (IllegalStateException ex2) {
                    this.setMessage(ex2.getMessage());
                    return false;
                } catch (IllegalArgumentException ex3) {
                    this.setMessage(ex3.getMessage());
                    return false;
                }
            }
            return true;
        } else {
            this.setMessage("No hay colectores que agregar.");
            return true;
        }
    }
    
    public boolean update(GatheringObservation gathering) {
        boolean updated = false;
        if (!isGatheringNull(gathering)){
            if (this.isGatheringUnique(gathering)) {
                try {
                    this.setGathering(gathering);
                    GatheringObservation tmp = em.find(GatheringObservation.class,gathering.getId());
                    // Incorporar las entidades auxiliares al contexto de la transacción
                    tmp.setSite(em.find(Site.class,gathering.getSite().getId()));
                    //gathering.setGatheringMethod(em.find(GatheringObservationMethod.class,gathering.getGatheringMethod()));
                    tmp.setResponsiblePerson(em.find(Person.class,gathering.getResponsiblePerson().getId()));
                    tmp.setCollection(em.find(Collection.class,gathering.getCollection().getId()));
                    if (gathering.getLabel()!=null) {
                        tmp.setLabel(em.find(Label.class,gathering.getLabel().getId()));
                    }
                    if (gathering.getOriginalLabel()!=null) {
                        tmp.setOriginalLabel(em.find(OriginalLabel.class,gathering.getOriginalLabel().getId()));
                    }
                    
                    tmp.setCreatedBy(gathering.getCreatedBy());
                    tmp.setFinalDate(gathering.getFinalDate());
                    tmp.setGatheringSiteDescription(gathering.getGatheringSiteDescription());
                    tmp.setGradientPercentage(gathering.getGradientPercentage());
                    tmp.setInitialDate(gathering.getInitialDate());
                    tmp.setLastModificationBy(gathering.getLastModificationBy());
                    tmp.setMaximumDepth(gathering.getMaximumDepth());
                    tmp.setMaximumElevation(gathering.getMaximumElevation());
                    tmp.setMinimumDepth(gathering.getMinimumDepth());
                    tmp.setMinimumElevation(gathering.getMinimumElevation());
                    tmp.setSurroundingsDescription(gathering.getSurroundingsDescription());
                    
                    this.gathering = em.merge(tmp);
                    updated = true;
                    
                    /*
                    // Incorporar las entidades auxiliares al contexto de la transacción
                    this.gathering.setSite(em.find(Site.class,gathering.getSite().getId()));
                    //gathering.setGatheringMethod(em.find(GatheringObservationMethod.class,gathering.getGatheringMethod()));
                    this.gathering.setResponsiblePerson(em.find(Person.class,gathering.getResponsiblePerson().getId()));
                    this.gathering.setCollection(em.find(Collection.class,gathering.getCollection().getId()));
                    if (gathering.getLabel()!=null) {
                        this.gathering.setLabel(em.find(Label.class,gathering.getLabel().getId()));
                    }
                    if (gathering.getOriginalLabel()!=null) {
                        this.gathering.setOriginalLabel(em.find(OriginalLabel.class,gathering.getOriginalLabel().getId()));
                    }
                    this.gathering = em.merge(this.gathering);
                    updated = true;
                     */
                } catch(IllegalStateException ex1) {
                    this.setMessage(ex1.getMessage());
                    return false;
                } catch (IllegalArgumentException ex2) {
                    this.setMessage(ex2.getMessage());
                    return false;
                } catch (TransactionRequiredException ex3) {
                    this.setMessage(ex3.getMessage());
                    return false;
                }
            } else {
                setMessage("La recolección ya existe en el sistema.");
                updated = false;
            }
        } else {
            this.setMessage(this.getMessage() + " El registro no fue creado.");
        }
        return updated;
    }
    
    private boolean updateV2(GatheringObservation gathering, Long[] collectorArray, Long[] projectArray, Long[] collectionArray) {
        boolean updated = false;
        if (!isGatheringNull(gathering)){
            if (this.isGatheringUnique(gathering)) {
                try {
                    // Finalmente actualizar la entidad GatheringObservation
                    this.setGathering(gathering);
                    GatheringObservation currentEntity = em.find(GatheringObservation.class,gathering.getId());
                    
                    // Incorporar las entidades auxiliares al contexto de la transacción
                    currentEntity.setSite(em.find(Site.class,gathering.getSite().getId()));
                    
                    //gathering.setGatheringMethod(em.find(GatheringObservationMethod.class,gathering.getGatheringMethod()));
                    currentEntity.setResponsiblePerson(em.find(Person.class,gathering.getResponsiblePerson().getId()));
                    currentEntity.setCollection(em.find(Collection.class,gathering.getCollection().getId()));
                    if (gathering.getLabel()!=null) {
                        currentEntity.setLabel(em.find(Label.class,gathering.getLabel().getId()));
                    }
                    if (gathering.getOriginalLabel()!=null) {
                        currentEntity.setOriginalLabel(em.find(OriginalLabel.class,gathering.getOriginalLabel().getId()));
                    }
                    
                    currentEntity.setCreatedBy(gathering.getCreatedBy());
                    currentEntity.setFinalDate(gathering.getFinalDate());
                    currentEntity.setGatheringSiteDescription(gathering.getGatheringSiteDescription());
                    currentEntity.setGradientPercentage(gathering.getGradientPercentage());
                    currentEntity.setInitialDate(gathering.getInitialDate());
                    currentEntity.setLastModificationBy(gathering.getLastModificationBy());
                    currentEntity.setMaximumDepth(gathering.getMaximumDepth());
                    currentEntity.setMaximumElevation(gathering.getMaximumElevation());
                    currentEntity.setMinimumDepth(gathering.getMinimumDepth());
                    currentEntity.setMinimumElevation(gathering.getMinimumElevation());
                    currentEntity.setSurroundingsDescription(gathering.getSurroundingsDescription());                    
                    this.gathering = em.merge(currentEntity);
                    
                    
                    // Actualizar los colectores
                    // 1. Eliminar los colectores actuales
                    String hql = "Select object(o) from CollectorObserver as o where o.collectorPK.gatheringObservationId = " + gathering.getId();
                    String msg = "";
                    Query q = em.createQuery(hql);
                    List<CollectorObserver> lst = q.getResultList();
                    if (lst.size() > 0) {
                        for (CollectorObserver tmp: lst) {
                            if (canDeleteCollector(tmp.getCollectorPK().getPersonId(), tmp.getCollectorPK().getgatheringObservationId())) {
                                em.merge(tmp);
                                em.remove(tmp);
                            } else {
                                if (msg.equals("")) {
                                    msg = tmp.getPerson().getFormalLongName();
                                } else {
                                    msg = msg + " ," + tmp.getPerson().getFormalLongName();
                                }
                            }                
                        }
                    }

                    if (!msg.equals("")) {
                        this.setMessage("Los siguientes colectores no fueron eliminados pues tienes detalles de recolecci�n asociados: " + msg);
                    }
                    
                    // 2. Crear los nuevos colectores
                    CollectorObserver collector;
                    Person person;
                    Long sequence = 1L;
                    System.out.println("Procediendo a crear colectores");
                    if (collectorArray != null) {
                        if (collectorArray.length > 0) {
                            for (Long personId: collectorArray) {
                                person = (Person)em.find(Person.class,personId);
                                CollectorObserverPK pk = new CollectorObserverPK();                
                                pk.setPersonId(person.getId());
                                pk.setgatheringObservationId(gathering.getId());
                                if (em.find(CollectorObserver.class,pk)== null) {
                                    collector = new CollectorObserver();
                                    collector.setCollectorPK(pk);
                                    collector.setSequence(sequence);
                                    collector.setCreatedBy(gathering.getLastModificationBy());
                                    collector.setLastModificationBy(gathering.getLastModificationBy());
                                    em.persist(collector);
                                    sequence++;
                                }
                            }
                        }
                    }
                    
                    // Actualizar las colecciones asociadas
                    // 1. Borrar las colecciones asociadas actuales
                    hql = "Select object(o) from GatheringObservationCollection as o where o.gatheringObservationCollectionPK.gatheringObservationId = " + gathering.getId();
                    q = em.createQuery(hql);
                    List<GatheringObservationCollection> lst2 = q.getResultList();
                    if (lst.size() > 0) {
                        for (GatheringObservationCollection tmp: lst2) {
                            em.merge(tmp);
                            em.remove(tmp);
                        }
                    }
                    
                    // 2. Creas las nuevas colecciones asociadas
                    GatheringObservationCollection gatheringObservationCollection;
                    Collection collection;
                    System.out.println("Procediendo a crear colecciones");
                    if (collectionArray != null) {
                        if (collectionArray.length > 0) {
                            for (Long collectionId: collectionArray) {
                                collection = (Collection)em.find(Collection.class,collectionId);
                                GatheringObservationCollectionPK pk = new GatheringObservationCollectionPK();

                                pk.setCollectionId(collection.getId());
                                pk.setGatheringId(gathering.getId());

                                gatheringObservationCollection = new GatheringObservationCollection();

                                gatheringObservationCollection.setGatheringObservationCollectionPK(pk);
                                gatheringObservationCollection.setCreatedBy(gathering.getLastModificationBy());
                                gatheringObservationCollection.setLastModificationBy(gathering.getLastModificationBy());
                                em.persist(gatheringObservationCollection);
                            }
                        }
                    }
                    
                    // Actualizar los proyectos
                    // 1. Eliminar los proyectos actuales
                    hql = "Select object(o) from GatheringObservationProject as o where o.gatheringObservationProjectPK.gatheringObservationId = " + gathering.getId();
                    q = em.createQuery(hql);
                    List<GatheringObservationProject> lst3 = q.getResultList();
                    if (lst.size() > 0) {
                        for (GatheringObservationProject tmp: lst3) {
                            em.merge(tmp);
                            em.remove(tmp);
                        }
                    }
                    
                    // 2. Crear las nuevas asociaciones con proyectos
                    GatheringObservationProject gatheringObservationProject;
                    Project project;
                    System.out.println("Procediendo a crear proyectos");
                    if (projectArray!= null) {
                        if (projectArray.length > 0) {
                            for (Long projectId: projectArray) {
                                project = (Project)em.find(Project.class,projectId);
                                GatheringObservationProjectPK pk = new GatheringObservationProjectPK();

                                pk.setProjectId(projectId);
                                pk.setGatheringObservationId(gathering.getId());

                                gatheringObservationProject = new GatheringObservationProject();

                                gatheringObservationProject.setGatheringObservationProjectPK(pk);
                                gatheringObservationProject.setCreatedBy(gathering.getLastModificationBy());
                                gatheringObservationProject.setLastModificationBy(gathering.getLastModificationBy());
                                em.persist(gatheringObservationProject);
                            }
                        }
                    }
                    this.gathering = em.find(GatheringObservation.class, this.gathering.getId());
                    updated = true;
                    
                } catch(IllegalStateException ex1) {
                    this.setMessage(ex1.getMessage());
                    return false;
                } catch (IllegalArgumentException ex2) {
                    this.setMessage(ex2.getMessage());
                    return false;
                } catch (TransactionRequiredException ex3) {
                    this.setMessage(ex3.getMessage());
                    return false;
                }
            } else {
                setMessage("La recolección ya existe en el sistema.");
                updated = false;
            }
        } else {
            this.setMessage(this.getMessage() + " El registro no fue creado.");
        }
        return updated;
    }
    
    public boolean update(GatheringObservation gathering, Long[] collectorArray, Long[] projectArray, Long[] collectionArray){
        /*
        if (update(gathering)) {
            if (this.clearList()) {
                this.updateCollectionList(collectionArray);
                this.updateCollectorList(collectorArray);
                this.updateProjectList(projectArray);
            }
            return true;
        } else {
            return false;
        }        

        
        setGathering(gathering);
        if (this.clearList()) {
            this.updateCollectionList(collectionArray);
            this.updateCollectorList(collectorArray);
            this.updateProjectList(projectArray);
            if (update(gathering)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
        */
        
        return this.updateV2(gathering,collectorArray,projectArray,collectionArray);
    }
    
    public boolean updateAssociatedInformation(Long[] collectorArray, Long[] projectArray, Long[] collectionArray) {
        if (this.clearList()) {
            //this.updateCollectionList(collectionArray);
            this.updateCollectorList(collectorArray);
            this.updateProjectList(projectArray);
        }
        return true;
    }
    
    public boolean delete(Long id) {
        try {
            // Buscar la entidad a borrar
            GatheringObservation gathering = (GatheringObservation)em.find(GatheringObservation.class,id);
            // Verificar si la entidad realmente existe
            if (gathering == null) {
                setMessage("No existe una recolección asociada al Id " + id);
                return false;
            }
            // Incorporar la entidad al contexto de la transacción
            this.gathering = em.merge(gathering);
            if (canDeleteGathering()) {
                // Eliminar la entidad
                em.remove(this.gathering);
                return true;
            } else {
                return false;
            }
        } catch(IllegalStateException ex1) {
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
    
    public List getGathering(Long collectionId) {
        Query q;
        try {
            q = em.createQuery("Select object(o) from GatheringObservation as o where o.collection.id = " + collectionId + " order by o.initialDate desc");
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
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        System.out.println(message);
        this.message = message;
    }
    
    private boolean isGatheringNull(GatheringObservation gathering) {
        if (gathering.getSite() == null) {
            setMessage("Falta el sitio de colecta.");
            return true;
        }
        /*
        if (gathering.getGatheringMethod() == null) {
            setMessage("Falta el método de recolección.");
            return true;
        }*/
        if (gathering.getResponsiblePerson() == null) {
            setMessage("Falta el responsable.");
            return true;
        }
        if(gathering.getCollection() == null) {
            setMessage("Falta la colección.");
            return true;
        }
        if (gathering.getInitialDate() == null) {
            setMessage("Falta la fecha inicial.");
            return true;
        }
        if(gathering.getFinalDate()== null) {
            setMessage("Falta la fecha final.");
            return true;
        }
        return false;
    }
    
    private boolean isGatheringUnique(GatheringObservation gathering) {
        boolean isUnique = true;
        String hql;
        Long tmpId;
        
        hql = "Select o from GatheringObservation as o ";
        hql += "where o.site.id = " + gathering.getSite().getId() + " and ";
        hql += "o.initialDate = '" + gathering.getInitialDate() + "' and ";
        hql += "o.finalDate = '" + gathering.getFinalDate() + "'";
        //hql += "o.gatheringMethod.id = " + gathering.getGatheringMethod().getId();
        if (gathering.getId()!=null) {
            hql += " and o.id <> " + gathering.getId();
        }
        
        if (em.createQuery(hql).getResultList().size() > 0) {
            isUnique = false;
        }
        return isUnique;
    }
    
    private boolean canDeleteGathering() {
        /*
        if (this.gathering.getCollectorSet().size() > 0) {
            this.setMessage("El registro no puede ser borrado, tiene colectores asociados.");
            return false;
        }*/
        if (this.gathering.getGatheringCollectionSet().size() > 0) {
            this.setMessage("El registro no puede ser borrado, está asociado a otras colecciones.");
            return false;
        }
        
        if (this.gathering.getGatheringProjectSet().size() > 0) {
            this.setMessage("El registro no puede ser borrado, tiene proyectos asociados.");
            return false;
        }
        
        if (this.gathering.getGatheringDetailSet().size() > 0) {
            this.setMessage("El registro no puede ser borrado, tiene detalles de colecta asociados.");
            return false;
        }

        if (this.getSpecimenCount(this.gathering.getId()) > 0) {
            return false;
        }
        return true;
    }
    
    private int getSpecimenCount(Long gatheringObservationId) {
        Query q;
        String sql;
        
        sql = "select count(specimen_id) from ara.specimen where gathering_observation_id = " + gatheringObservationId;
        q = em.createNativeQuery(sql);
        
        Object obj = q.getSingleResult();        
        int count = Integer.parseInt(obj.toString());
        return count;
    }
    
    public GatheringObservation getGathering() {
        return this.gathering;
    }
    
    public void setGathering(GatheringObservation gathering) {
        this.gathering = gathering;
        System.out.println(gathering.getMaximumDepth());
        System.out.println(gathering.getMaximumElevation());
        System.out.println(gathering.getMinimumDepth());
        System.out.println(gathering.getMinimumElevation());
        System.out.println(gathering.getGradientPercentage());
    }
    
    private void updateCollectorList(Long[] collectorArray) {
        CollectorObserver collector;
        Person person;
        Long sequence = 1L;
        System.out.println("Procediendo a crear colectores");
        if (collectorArray != null) {
            if (collectorArray.length > 0) {
                for (Long personId: collectorArray) {
                    person = (Person)em.find(Person.class,personId);
                    CollectorObserverPK pk = new CollectorObserverPK();                

                    pk.setPersonId(person.getId());
                    pk.setgatheringObservationId(this.gathering.getId());

                    collector = new CollectorObserver();

                    collector.setCollectorPK(pk);
                    collector.setSequence(sequence);
                    collector.setCreatedBy(this.gathering.getLastModificationBy());
                    collector.setLastModificationBy(this.gathering.getLastModificationBy());
                    try {
                        em.persist(collector);
                    } catch (EntityExistsException entityExistEx) {
                        setMessage("El registro ya existe en la base de datos.");
                    } catch (IllegalStateException illegalStateEx) {
                        setMessage("La conexi�n con la base de datos fue cerrada.");
                    } catch (IllegalArgumentException illegalArgumentEx) {
                        setMessage("El objeto a persistir no es una entidad v�lida.");
                    } catch (TransactionRequiredException transactionRequiredEx) {
                        setMessage("No se puede ejecutar la acci�n debido a que no hay una transacci�n activa");
                    }                        
                    sequence++;
                }
            }
        }
    }
    
    private void updateProjectList(Long[] projectArray) {
        GatheringObservationProject gatheringObservationProject;
        Project project;
        System.out.println("Procediendo a crear proyectos");
        if (projectArray!= null) {
            if (projectArray.length > 0) {
                for (Long projectId: projectArray) {
                    project = (Project)em.find(Project.class,projectId);
                    GatheringObservationProjectPK pk = new GatheringObservationProjectPK();

                    pk.setProjectId(projectId);
                    pk.setGatheringObservationId(this.getGathering().getId());

                    gatheringObservationProject = new GatheringObservationProject();

                    gatheringObservationProject.setGatheringObservationProjectPK(pk);
                    gatheringObservationProject.setCreatedBy(this.gathering.getLastModificationBy());
                    gatheringObservationProject.setLastModificationBy(this.gathering.getLastModificationBy());

                    try {
                        em.persist(gatheringObservationProject);
                    } catch (EntityExistsException entityExistEx) {
                        setMessage("El registro ya existe en la base de datos.");
                    } catch (IllegalStateException illegalStateEx) {
                        setMessage("La conexi�n con la base de datos fue cerrada.");
                    } catch (IllegalArgumentException illegalArgumentEx) {
                        setMessage("El objeto a persistir no es una entidad v�lida.");
                    } catch (TransactionRequiredException transactionRequiredEx) {
                        setMessage("No se puede ejecutar la acci�n debido a que no hay una transacci�n activa");
                    }                        
                }
            }
        }

    }
    
    private void updateCollectionList(Long[] collectionArray) {
        GatheringObservationCollection gatheringObservationCollection;
        Collection collection;
        System.out.println("Procediendo a crear colecciones");
        if (collectionArray != null) {
            if (collectionArray.length > 0) {
                for (Long collectionId: collectionArray) {
                    collection = (Collection)em.find(Collection.class,collectionId);
                    GatheringObservationCollectionPK pk = new GatheringObservationCollectionPK();

                    pk.setCollectionId(collection.getId());
                    pk.setGatheringId(this.getGathering().getId());

                    gatheringObservationCollection = new GatheringObservationCollection();

                    gatheringObservationCollection.setGatheringObservationCollectionPK(pk);
                    gatheringObservationCollection.setCreatedBy(this.gathering.getLastModificationBy());
                    gatheringObservationCollection.setLastModificationBy(this.gathering.getLastModificationBy());

                    try {
                        em.persist(gatheringObservationCollection);
                    } catch (EntityExistsException entityExistEx) {
                        setMessage("El registro ya existe en la base de datos.");
                    } catch (IllegalStateException illegalStateEx) {
                        setMessage("La conexi�n con la base de datos fue cerrada.");
                    } catch (IllegalArgumentException illegalArgumentEx) {
                        setMessage("El objeto a persistir no es una entidad v�lida.");
                    } catch (TransactionRequiredException transactionRequiredEx) {
                        setMessage("No se puede ejecutar la acci�n debido a que no hay una transacci�n activa");
                    }                        
                }
            }
        }
    }
    
    private boolean clearList() {
        this.deleteCollections();
        this.deleteCollectors();
        this.deleteProjects();
        return true;
    }
    
    private void deleteCollectors() {
        /*
        Query q;
        String query = "delete from CollectorObserver where collectorPK.gatheringObservationId = " + this.getGathering().getId();
        System.out.println(query);
        try {
            q = em.createQuery(query);
            q.executeUpdate();
        } catch (IllegalStateException ex1) {
            System.out.println(ex1.getMessage());
        } catch (IllegalArgumentException ex2) {
            System.out.println(ex2.getMessage());
        } catch (TransactionRequiredException ex3) {
            System.out.println(ex3.getMessage());
        }*/
        String hql = "Select object(o) from CollectorObserver as o where o.collectorPK.gatheringObservationId = " + this.getGathering().getId();
        String msg = "";
        Query q = em.createQuery(hql);
        List<CollectorObserver> lst = q.getResultList();
        if (lst.size() > 0) {
            for (CollectorObserver tmp: lst) {
                if (canDeleteCollector(tmp.getCollectorPK().getPersonId(), tmp.getCollectorPK().getgatheringObservationId())) {
                    em.merge(tmp);
                    em.remove(tmp);
                } else {
                    if (msg.equals("")) {
                        msg = tmp.getPerson().getFormalLongName();
                    } else {
                        msg = msg + " ," + tmp.getPerson().getFormalLongName();
                    }
                }                
            }
        }
        
        if (!msg.equals("")) {
            this.setMessage("Los siguientes colectores no fueron eliminados pues tienes detalles de recolecci�n asociados: " + msg);
        }
    }
    
    private boolean canDeleteCollector(Long personId, Long gatheringObservationId) {
        String hql = "Select object(o) from GatheringObservationDetail as o where o.gatheringObservation.id =" + gatheringObservationId + " and o.person.id = " + personId;
        Query q = em.createQuery(hql);
        if (q.getResultList().size() == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    private void deleteCollections() {
        Query q;
        //String query = "delete from GatheringObservationCollection where gatheringObservationCollectionPK.gatheringObservationId = " + this.getGathering().getId();
        String query = "delete from ara.gathering_observation_collection where gathering_observation_id = " + this.getGathering().getId();
        System.out.println(query);
        try {
            //q = em.createQuery(query);
            q = em.createNativeQuery(query);
            q.executeUpdate();
        } catch (IllegalStateException ex1) {
            System.out.println(ex1.getMessage());
        } catch (IllegalArgumentException ex2) {
            System.out.println(ex2.getMessage());
        } catch (TransactionRequiredException ex3) {
            System.out.println(ex3.getMessage());
        }
    }
    
    private void deleteProjects() {
        Query q;
        //String query = "delete from GatheringObservationProject where gatheringObservationProjectPK.gatheringObservationId = " + this.getGathering().getId();
        String query = "delete from ara.gathering_observation_project where gathering_observation_id = " + this.getGathering().getId();
        System.out.println(query);
        try {
            //q = em.createQuery(query);
            q = em.createNativeQuery(query);
            q.executeUpdate();
        } catch (IllegalStateException ex1) {
            System.out.println(ex1.getMessage());
        } catch (IllegalArgumentException ex2) {
            System.out.println(ex2.getMessage());
        } catch (TransactionRequiredException ex3) {
            System.out.println(ex3.getMessage());
        }
    }
    
    public GatheringObservation find(Long id){
        return em.find(GatheringObservation.class, id);
    }
}
