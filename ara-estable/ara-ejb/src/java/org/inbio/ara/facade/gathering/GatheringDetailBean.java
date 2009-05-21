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
 * GatheringDetailSessionBean.java
 *
 * Created on December 26, 2007, 2:07 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.gathering;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;
import org.inbio.ara.persistence.collection.Collection;
import org.inbio.ara.persistence.gathering.GatheringObservation;
import org.inbio.ara.persistence.gathering.GatheringObservationDetail;
import org.inbio.ara.persistence.gathering.Label;
import org.inbio.ara.persistence.gathering.MorphologicalDescription;
import org.inbio.ara.persistence.gathering.OriginalLabel;
import org.inbio.ara.persistence.person.Person;

/**
 *
 * @author roaguilar
 */
@Stateless
public class GatheringDetailBean implements GatheringDetailRemote, GatheringDetailLocal {

    @PersistenceContext
    private EntityManager em;
    private GatheringObservationDetail gatheringDetail;
    private String message;
    
    /** Creates a new instance of GatheringDetailSessionBean */
    public GatheringDetailBean() {
        setMessage("");
    }
    
    private boolean persist() {
        boolean persisted = false;
        if (!isGatheringDetailNull(this.gatheringDetail)){
            if (this.isGatheringDetailUnique(this.gatheringDetail,"insert")) {
                try {
                    // Incorporar las entidades auxiliares al contexto de la transacción
                    this.gatheringDetail.setGatheringObservation(em.find(GatheringObservation.class,this.gatheringDetail.getGatheringObservation().getId()));
                    this.gatheringDetail.setCollection(em.find(Collection.class,gatheringDetail.getCollection().getId()));
                    this.gatheringDetail.setPerson(em.find(Person.class,gatheringDetail.getPerson().getId()));
                    if (this.gatheringDetail.getLabel()!=null) {
                        this.gatheringDetail.setLabel(em.find(Label.class,this.gatheringDetail.getLabel().getId()));
                    }
                    if (this.gatheringDetail.getOriginalLabel()!=null) {
                        this.gatheringDetail.setOriginalLabel(em.find(OriginalLabel.class,this.gatheringDetail.getOriginalLabel().getId()));
                    }
                    if (this.gatheringDetail.getMorphologicalDescription()!=null) {
                        this.gatheringDetail.setMorphologicalDescription(em.find(MorphologicalDescription.class,this.gatheringDetail.getMorphologicalDescription().getId()));
                    }
                    em.persist(this.gatheringDetail);
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
                setMessage("El detalle de recolección ya existe en el sistema.");
                persisted = false;
            }
        } else {
            this.setMessage(this.getMessage() + " El registro no fue creado.");
        }
        return persisted;
    }
    
    public boolean create(GatheringObservationDetail gatheringDetail) {
        this.setGatheringDetail(gatheringDetail);
        return persist();
    }
    
    public boolean update(GatheringObservationDetail gatheringDetail) {
        boolean updated = false;
        if (!isGatheringDetailNull(gatheringDetail)){
            if (this.isGatheringDetailUnique(gatheringDetail,"update")) {
                try {
                    // Incorporar las entidades auxiliares al contexto de la transacción
                    gatheringDetail.setGatheringObservation(em.find(GatheringObservation.class,gatheringDetail.getGatheringObservation().getId()));
                    gatheringDetail.setCollection(em.find(Collection.class,gatheringDetail.getCollection().getId()));
                    gatheringDetail.setPerson(em.find(Person.class,gatheringDetail.getPerson().getId()));
                    if (gatheringDetail.getLabel()!=null) {
                        gatheringDetail.setLabel(em.find(Label.class,gatheringDetail.getLabel().getId()));
                    }
                    if (gatheringDetail.getOriginalLabel()!=null) {
                        gatheringDetail.setOriginalLabel(em.find(OriginalLabel.class,gatheringDetail.getOriginalLabel().getId()));
                    }
                    if (gatheringDetail.getMorphologicalDescription()!=null) {
                        gatheringDetail.setMorphologicalDescription(em.find(MorphologicalDescription.class,gatheringDetail.getMorphologicalDescription().getId()));
                    }

                    this.gatheringDetail = em.merge(gatheringDetail);
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
                setMessage("El detalle de recolección ya existe en el sistema.");
                updated = false;
            }
        } else {
            this.setMessage(this.getMessage() + " El registro no fue creado.");
        }
        return updated;
    }
    
    //public boolean delete(GatheringDetailPK pk) {
    public boolean delete(Long gatheringObservationDetailId) {
        if (this.canDeleteGatheringDetail(gatheringObservationDetailId)) {
            try {
                /*
                // Buscar la entidad a borrar
                GatheringObservationDetail gatheringDetail = (GatheringObservationDetail)em.find(GatheringObservationDetail.class,gatheringObservationDetailId);
                // Verificar si la entidad realmente existe
                if (gatheringDetail == null) {
                    setMessage("No existe un detalle de recolección asociado al Id " + gatheringDetail.toString());
                    return false;
                }
                // Incorporar la entidad al contexto de la transacción
                this.gatheringDetail = em.merge(gatheringDetail);
                if (canDeleteGatheringDetail()) {
                    // Eliminar la entidad
                    em.remove(this.gatheringDetail);
                    return true;
                } else {
                    return false;
                }*/
                String sql = "delete from ara.gathering_observation_detail where gathering_observation_detail_id = " +gatheringObservationDetailId;
                Query q = em.createNativeQuery(sql);
                q.executeUpdate();
                return true;
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
            return false;
        }
    }
    
    public List getGatheringDetail(Long gatheringId) {
        Query q;
        String hql;
        
        hql = "Select object(o) from GatheringDetail as o ";
        hql += "where o.gathering.id = " + gatheringId;
        
        q = em.createQuery(hql);
        return q.getResultList();
    }
    
    public List getGatheringObservationDetail(Long gatheringId, Long collectionId) {
        Query q;
        String hql;
        List tList;
        
        hql = "Select object(o) from GatheringObservationDetail as o ";
        hql += "where o.gatheringObservation.id = " + gatheringId + " and ";
        hql += "o.collection.id = " + collectionId;
        System.out.println(hql);
        try {
            q = em.createQuery(hql);
            tList = q.getResultList();
            System.out.println("Elementos encontrados: " + tList.size());
        } catch (IllegalArgumentException ex1) {
            this.setMessage(ex1.getMessage());
            return null;
        } catch (IllegalStateException ex2) {
            this.setMessage(ex2.getMessage());
            return null;
        }        
        return tList;
    }
    
    private boolean isGatheringDetailNull(GatheringObservationDetail gatheringDetail) {
        if (gatheringDetail == null) {
            setMessage("La entidad es nula!");
            return true;
        }        
        if (gatheringDetail.getCollection() == null) {
            setMessage("Falta la colección.");
            return true;
        }
        if (gatheringDetail.getPerson() == null) {
            setMessage("Falta el colector.");
            return true;
        }
        if (gatheringDetail.getGatheringObservationDetailNumber() == null) {
            setMessage("Falta el número de colecta.");
            return true;
        }
        if (gatheringDetail.getGatheringObservation() == null) {
            setMessage("Falta la recolección.");
            return true;
        }
        return false;
    }
    
    private boolean isGatheringDetailUnique(GatheringObservationDetail gatheringDetail, String action) {
        Query q;
        String hql;
        boolean isUnique = false;
        
        /*hql = "Select object(o) from GatheringDetail as o ";
        hql += "where o.gatheringDetailPK.gatheringDetailPersonId = " + gatheringDetail.getGatheringDetailPK().getGatheringDetailPersonId() + " and ";
        hql += "o.gatheringDetailPK.gatheringNumber = '" + gatheringDetail.getGatheringDetailPK().getGatheringNumber() + " and ";
        hql += "o.gatheringDetailPK.collectionId = " + gatheringDetail.getGatheringDetailPK().getCollectionId() + " and ";
        hql += "o.gathering.id = " + gatheringDetail.getGathering().getId();*/
        
        hql = "Select object(o) from GatheringObservationDetail as o ";
        hql += "where o.person.id = " + gatheringDetail.getPerson().getId() + " and ";
        hql += "o.gatheringObservationDetailNumber = '" + gatheringDetail.getGatheringObservationDetailNumber() + "' and ";
        hql += "o.collection.id = " + gatheringDetail.getCollection().getId() + " and ";
        hql += "o.gatheringObservation.id = " + gatheringDetail.getGatheringObservation().getId();
        
        System.out.println(hql);
        
        q = em.createQuery(hql);
        if (action.equals("insert")) {
            if (q.getResultList().size() > 0) {
                isUnique = false;
            } else {
                isUnique = true;
            }
        }
        
        if (action.equals("update")) {
            if (q.getResultList().size() > 0) {
                GatheringObservationDetail tmp = (GatheringObservationDetail)q.getSingleResult();
                if (gatheringDetail.getId().equals(tmp.getId())) {
                    isUnique = true;
                } else {
                    isUnique = false;
                }                
            } else {
                isUnique = true;
            }
        }
        
        System.out.println(q.getResultList().size());
        return isUnique;
    }
    
    private boolean canDeleteGatheringDetail(Long gatheringObservationDetailId) {
        int specimenCount = this.getSpecimenCount(gatheringObservationDetailId);
        if (specimenCount > 0) {
            this.setMessage("El registro no puede ser borrado pues tiene asociado(s) " + specimenCount + " especimen(es)");
            return false;
        } else {
            return true;
        }
    }
    
    private int getSpecimenCount(Long gatheringObservationDetailId) {
        Query q;
        String sql;
        
        sql = "select count(specimen_id) from ara.specimen where gathering_observation_detail_id = " + gatheringObservationDetailId;
        q = em.createNativeQuery(sql);
        
        Object obj = q.getSingleResult();        
        int count = Integer.parseInt(obj.toString());
        return count;
    }

    public GatheringObservationDetail getGatheringDetail() {
        return gatheringDetail;
    }

    public void setGatheringDetail(GatheringObservationDetail gatheringDetail) {
        this.gatheringDetail = gatheringDetail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
