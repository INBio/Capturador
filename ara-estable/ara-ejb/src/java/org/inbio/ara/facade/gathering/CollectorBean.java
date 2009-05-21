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
 * CollectorBean.java
 *
 * Created on December 27, 2007, 8:24 PM
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
import javax.persistence.TransactionRequiredException;
import org.inbio.ara.persistence.gathering.CollectorObserver;
import org.inbio.ara.persistence.gathering.CollectorObserverPK;

/**
 *
 * @author roaguilar
 */
@Stateless
public class CollectorBean implements CollectorRemote {

    @PersistenceContext
    private EntityManager em;
    private CollectorObserver collector;
    private List collectorList;
    private String message;
    
    /** Creates a new instance of CollectorBean */
    public CollectorBean() {
    }
    
    public List getCollector(Long gatheringId) {
        return this.collectorList;
    }
    
    public CollectorObserver getCollector() {
        return collector;
    }

    public void setCollector(CollectorObserver collector) {
        this.collector = collector;
    }

    public List getCollectorList() {
        return collectorList;
    }

    public void setCollectorList(List collectorList) {
        this.collectorList = collectorList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean persist() {
        boolean persisted = false;
        if (!isCollectorNull(this.collector)){
            if (this.isCollectorUnique(this.collector,"persist")) {
                try {
                    // Incorporar las entidades auxiliares al contexto de la transacción
                    // Primero las obligatorias
                    em.persist(this.collector);
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
                setMessage("La recolección ya existe en el sistema.");
                persisted = false;
            }
        } else {
            this.setMessage(this.getMessage() + " El registro no fue creado.");
        }
        return persisted;
    }
    
    public boolean create(CollectorObserver collector) {
        setCollector(collector);
        return this.persist();
    }
    
    public void assign(List<CollectorObserver> collectorList) {
        for (CollectorObserver tmpCollector: collectorList) {
            create(tmpCollector);
        }
    }
    
    public void assign(Long[] collectorArrayId) {
        
    }

    public boolean update(CollectorObserver collector) {
        return false;
    }
    
    public boolean delete(CollectorObserverPK pk) {
        try {
            // Buscar la entidad a borrar
            CollectorObserver collector = (CollectorObserver)em.find(CollectorObserver.class,pk);
            // Verificar si la entidad realmente existe
            if (collector == null) {
                setMessage("No existe un collector para el Id dado." + pk.toString());
                return false;
            }
            // Incorporar la entidad al contexto de la transaccion
            this.collector = em.merge(this.collector);
            if (canDeleteCollector()) {
                // Eliminar la entidad
                em.remove(this.collector);
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
    
    public boolean isCollectorUnique(CollectorObserver collector, String action) {
        boolean isUnique = true;
        String hql;
        /*
        hql = "Select o from Collector as o ";
        hql += "where o.collectorPK.gatheringId = " + collector.getGathering().getId() + " and ";
        hql += "o.collectorPK.personId = " + collector.getPersonProfile().getPersonProfilePK().getPersonId() + " and ";
        hql += "o.collectorPK.profileId = " + collector.getPersonProfile().getPersonProfilePK().getProfileId();
        
        if (action.equals("persist")) {
            if (em.createQuery(hql).getResultList().size() == 0) {
                isUnique = true;
            }
        }
        if (action.equals("update")) {
            if (em.createQuery(hql).getResultList().size() == 1) {
                isUnique = true;
            } else {
                isUnique = false;
            }
        }*/
        return isUnique;
    }
    
    public boolean isCollectorNull(CollectorObserver collector) {
        if (collector.getCollectorPK().getgatheringObservationId() == null) {
            setMessage("Falta la recoleccion");
            return true;
        }
        
        if(collector.getCollectorPK().getPersonId() == null) {
            setMessage("Falta el colector");
            return true;
        }
        
        /*
        if(collector.getCollectorPK().getProfileId() == null) {
            setMessage("Falta el colector");
            return true;
        }
        */
        if(collector.getSequence() == null) {
            setMessage("Falta la secuencia");
            return true;
        }
        return false;
    }
    
    public boolean canDeleteCollector() {
        return true;
    }
}
