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
 * CollectionBean.java
 *
 * Created on December 29, 2007, 7:31 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.collection;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;
import org.inbio.ara.eao.CollectionLocalEAO;
import org.inbio.ara.persistence.collection.Collection;

/**
 *
 * @author roaguilar
 */
@Stateless
public class CollectionBean implements CollectionRemote, CollectionLocal {


    @EJB
    private CollectionLocalEAO collectionEAO;

    @PersistenceContext
    private EntityManager em;
    private Collection collection;
    private List collectionList;
    private List collectionProtocolList;
    private String message;
    
    /** Creates a new instance of CollectionBean */
    public CollectionBean() {
    }

    public Collection getCollection() {
        return collection;
    }

    private void setCollection(Collection collection) {
        this.collection = collection;
    }

    public List getCollectionList() {
        return collectionList;
    }

    private void setCollectionList(List collectionList) {
        this.collectionList = collectionList;
    }

    public String getMessage() {
        return message;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    private List getCollectionProtocolList() {
        return collectionProtocolList;
    }

    private void setCollectionProtocolList(List collectionProtocolList) {
        this.collectionProtocolList = collectionProtocolList;
    }
    
    private boolean persist() {
        boolean persisted = false;
        if (!isCollectionNull(collection)){
            if (this.isCollectionUnique(collection)) {
                try {
                    em.persist(this.collection);
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
                setMessage("La colección ya existe en el sistema.");
                persisted = false;
            }
        } else {
            this.setMessage(this.getMessage() + " El registro no fue creado.");
        }
        return persisted;
    }

    /**
     * Listo - reparado
     *
     * @param collection
     * @return
     */
    public void create(Collection collection) {
        collectionEAO.create(collection);
    }
    
    public boolean update(Collection collection) {
        boolean updated = false;
        if (!isCollectionNull(collection)){
            if (this.isCollectionUnique(collection)) {
                try {
                    // Incorporar la entidad al contexto de la transacción y realizar la actualización
                    this.collection = em.merge(collection);
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
                setMessage("La colección ya existe en el sistema.");
                updated = false;
            }
        } else {
            this.setMessage(this.getMessage() + " El registro no fué creado.");
        }
        return updated;
    }

    /**
     * listo y pura vida!
     *
     * @param collectionId
     * @throws java.lang.IllegalArgumentException
     */
    public void deleteCollection(Long collectionId) throws IllegalArgumentException {
        try {
            if (canDeleteCollection(collectionId)) {
                this.collectionEAO.delete(Collection.class, collectionId);
            } else {
               throw new IllegalArgumentException("El usuario no tiene privilegios para modificar el registro");
            }
        } catch(IllegalStateException ex1) {
            throw new IllegalArgumentException(ex1.getMessage());
        } catch (IllegalArgumentException ex2) {
            throw new IllegalArgumentException(ex2.getMessage());
        } catch (TransactionRequiredException ex3) {
            throw new IllegalArgumentException(ex3.getMessage());
        }
    }

    
    public List getCollections() {
        Query q;
        String hql;
        
        hql = "Select object(o) from Collection as o order by o.name";        
        try {
            q = em.createQuery(hql);
            this.setCollectionList(q.getResultList());
        } catch(IllegalStateException ex1) {
            this.setMessage(ex1.getMessage());
            return null;
        } catch (IllegalArgumentException ex2) {
            this.setMessage(ex2.getMessage());
            return null;
        }
        
        return getCollectionList();
    }

    /**
     * Listo y pura vida!
     *
     * @return
     */
    public List<Collection> listAllCollections(){
        return this.collectionEAO.listAll();
    }
    
    public Collection getCollection(Long collectionId) {
        Query q;
        String hql;
        
        hql = "Select object(o) from Collection as o ";
        hql += "where o.id = " + collectionId;
        
        try {
            q = em.createQuery(hql);
            this.setCollection((Collection)q.getSingleResult());
            this.collectionProtocolList = this.getCollectionProtocols(this.collection.getId());
        } catch(NonUniqueResultException ex4) {
            this.setMessage(ex4.getMessage());
            return null;
        } catch(NoResultException ex3) {
            this.setMessage(ex3.getMessage());
            return null;        
        } catch(IllegalStateException ex1) {
            this.setMessage(ex1.getMessage());
            return null;
        } catch (IllegalArgumentException ex2) {
            this.setMessage(ex2.getMessage());
            return null;
        }
        
        return getCollection();
    }
    
    public List getCollectionProtocols() {
        return this.getCollectionProtocols(this.collection.getId());
    }
    
    public List getCollectionProtocols(Long collectionId) {
        Query q;
        String hql;
        
        hql = "Select object(o) from CollectionProtocol as o ";
        hql += "where o.collectionProtocolPK.collectionId = " + collectionId;
        
        try {
            q = em.createQuery(hql);
            this.setCollectionProtocolList(q.getResultList());
            System.out.println("cantidad de elementos encontrados: " + this.getCollectionProtocolList().size());
        } catch(IllegalStateException ex1) {
            this.setMessage(ex1.getMessage());
            return null;
        } catch (IllegalArgumentException ex2) {
            this.setMessage(ex2.getMessage());
            return null;
        }
        return this.getCollectionProtocolList();
    }
    
    private boolean isCollectionNull(Collection collection) {
        if(collection.getName()== null) {
            setMessage("Falta el nombre de la colección.");
            return true;
        }
        return false;
    }
    
    private boolean isCollectionUnique(Collection collection) {
        boolean isUnique = true;
        String hql;
        Long tmpId;
        
        hql = "Select object(o) from Collection as o ";
        hql += "where o.name = '" + collection.getName() + "'";
        if (collection.getId()!=null) {
            hql += " and o.id <> " + collection.getId();
        }
        
        if (em.createQuery(hql).getResultList().size() > 0) {
            isUnique = false;
        }
        return isUnique;
    }
    
    private boolean canDeleteCollection(Long collectionId) {
        String tmpMessage = "La colección no puede ser borrada pues está siendo referenciada por al menos un registro de: ";

        //este funcionamiento debería ser modificado pero por ahora se quedará así.
        //podria ser con llamadas a un manager a ver si hay colecciones asociadas
        //a cada una de las tablas aca citadas.
        //Por ahora para que funke que se modificaron desde el nombre de los entities(actualizaron)
        //hasta agregar valores en los entities (valor collection) para que funcione
        //esto como esta hecho.

        if (findCollectionUsageByEntity("GatheringObservation", collectionId)) {
            setMessage(tmpMessage + "Recolecciones.");
            return false;
        }
        if (findCollectionUsageByEntity("GatheringObservationCollection", collectionId)) {
            setMessage(tmpMessage + "Recolecciones (colecciones asociadas).");
            return false;
        }
        if (findCollectionUsageByEntity("GatheringObservationDetail", collectionId)) {
            setMessage(tmpMessage + "Recolecciones (detalles de recolección).");
            return false;
        }
        if (findCollectionUsageByEntity("Specimen", collectionId)) {
            setMessage(tmpMessage + "Especímenes");
            return false;
        }
        //Falta chequear que no tenga lista asociadas.
        if (findCollectionUsageByEntity("ListTableCollection", collectionId)){
            setMessage(tmpMessage + "Listas de Selección");
            return false;
        }

        //se ignora la tabla transaction
        /*
        if (findCollectionUsageByEntity("Transaction", collectionId)) {
            setMessage(tmpMessage + "Transacciones");
            return false;
        }
        */
        return true;
    }
    
    private boolean findCollectionUsageByEntity(String entityName, Long collectionId) {
        
        
        Query q = em.createQuery("Select object(o)" +
                " from " + entityName + " as o"
               +" where o.collection.id =" + collectionId);
        List resultList = q.getResultList();
        
        if (resultList == null)
            return false;
        else if (resultList.size() > 0)
            return true;
        else 
            return false;
    }
    
    public Collection find(Long id) {
        return em.find(Collection.class, id);
    }

    /**
     * @return the collectionEAO
     */
    public CollectionLocalEAO getCollectionEAO() {
        return collectionEAO;
    }

    /**
     * @param collectionEAO the collectionEAO to set
     */
    public void setCollectionEAO(CollectionLocalEAO collectionEAO) {
        this.collectionEAO = collectionEAO;
    }
}
