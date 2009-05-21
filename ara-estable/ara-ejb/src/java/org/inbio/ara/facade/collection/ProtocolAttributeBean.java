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
 * ProtocolAttributeBean.java
 *
 * Created on December 29, 2007, 7:34 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.collection;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;
import org.inbio.ara.persistence.collection.ProtocolAttribute;

/**
 *
 * @author roaguilar
 */
@Stateless
public class ProtocolAttributeBean implements ProtocolAttributeRemote, ProtocolAttributeLocal {

    @PersistenceContext
    private EntityManager em;
    private ProtocolAttribute protocolAttribute;
    private String message;
    private List collectionProtocolList;
    
    /** Creates a new instance of ProtocolAttributeBean */
    public ProtocolAttributeBean() {
    }

    private boolean persist() {
        boolean persisted = false;
        if (!isProtocolNull(protocolAttribute)){
            if (this.isProtocolUnique(protocolAttribute)) {
                try {
                    em.persist(this.protocolAttribute);
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
                setMessage("El protocolo ya existe en el sistema.");
                persisted = false;
            }
        } else {
            this.setMessage(this.getMessage() + " El registro no fue creado.");
        }
        return persisted;
    }
    
    public boolean create(ProtocolAttribute protocol) {
        setProtocolAttribute(protocol);
        return persist();
    }
    
    public boolean update(ProtocolAttribute protocol) {
        boolean updated = false;
        if (!isProtocolNull(protocol)){
            if (this.isProtocolUnique(protocol)) {
                try {
                    // Incorporar la entidad al contexto de la transacción y realizar la actualización
                    this.protocolAttribute = em.merge(protocol);
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
                setMessage("El protocolo ya existe en el sistema.");
                updated = false;
            }
        } else {
            this.setMessage(this.getMessage() + " El registro no fue creado.");
        }
        return updated;
    }
    
    public boolean delete(Long protocolId) {
        try {
            // Buscar la entidad a borrar
            ProtocolAttribute protocol = (ProtocolAttribute)em.find(ProtocolAttribute.class,protocolId);
            // Verificar si la entidad realmente existe
            if (protocol == null) {
                setMessage("No existe un protocol asociado al Id " + protocolId);
                return false;
            }
            // Incorporar la entidad al contexto de la transacción
            this.protocolAttribute = em.merge(protocol);
            if (canDeleteProtocol()) {
                // Eliminar la entidad
                em.remove(this.protocolAttribute);
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
    
    public List getCollectionProtocols(Long collectionId, Long protocolAttributeId) {
        Query q;
        String hql;
        
        hql = "Select object(o) from CollectionProtocol as o ";
        hql += "where o.collectionProtocolPK.collectionId = " + collectionId + " and ";
        hql += "o.collectionProtocolPK.protocolAttributeId = " + protocolAttributeId;
        try {
            q = em.createQuery(hql);
            return q.getResultList();
        } catch(IllegalStateException ex1) {
            this.setMessage(ex1.getMessage());
            return null;
        } catch (IllegalArgumentException ex2) {
            this.setMessage(ex2.getMessage());
            return null;
        }
    }
    
    private boolean isProtocolNull(ProtocolAttribute protocol) {
        if(protocol.getName()== null) {
            setMessage("Falta el nombre del protocolo.");
            return true;
        }
        return false;
    }
    
    private boolean isProtocolUnique(ProtocolAttribute protocol) {
        boolean isUnique = true;
        String hql;
        Long tmpId;
        
        hql = "Select object(o) from ProtocolAttribute as o ";
        hql += "where o.name = '" + protocol.getName() + "'";
        if (protocol.getId()!=null) {
            hql += " and o.id <> " + protocol.getId();
        }
        
        if (em.createQuery(hql).getResultList().size() > 0) {
            isUnique = false;
        }
        return isUnique;
    }
    
    private boolean canDeleteProtocol() {
        return false;
    }

    public ProtocolAttribute getProtocolAttribute() {
        return protocolAttribute;
    }

    public void setProtocolAttribute(ProtocolAttribute protocolAttribute) {
        this.protocolAttribute = protocolAttribute;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List getCollectionProtocolList() {
        return collectionProtocolList;
    }

    public void setCollectionProtocolList(List collectionProtocolList) {
        this.collectionProtocolList = collectionProtocolList;
    }
}
