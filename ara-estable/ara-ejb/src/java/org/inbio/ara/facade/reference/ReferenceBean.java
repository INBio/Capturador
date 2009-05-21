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
 * ReferenceBean.java
 *
 * Created on 20 de noviembre de 2007, 10:32 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.reference;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;
import org.inbio.ara.persistence.reference.Reference;
import org.inbio.ara.persistence.reference.ReferenceElementValue;
import org.inbio.ara.persistence.reference.ReferenceElementValuePK;
import org.inbio.ara.persistence.reference.ReferenceType;
import org.inbio.ara.persistence.util.Language;

/**
 *
 * @author herson
 */
@Stateless
public class ReferenceBean implements ReferenceLocal, ReferenceRemote {
    /**
     * Persistence context object
     */
    @PersistenceContext
    private EntityManager em;
    private Reference reference;
    private List referenceElementValues;
    private List<Reference> referenceList;
    
    /**
     * Last error message produced by action methods such as update, create, remove or 
     * findAll.
     */
    private String message;    
    /**
     * Persistence entity
     */

    
    /** Creates a new instance of ReferenceBean */
    public ReferenceBean() {
        setReference(null);
        setMessage("");
    }
    
    /**
     * Use this method to get all the References existing in the database.
     * @return A List of Reference entities.
     */
    public List findAll() {
        Query q = em.createQuery("Select object(o) from Reference as o");
        try {
            this.referenceList = (List)q.getResultList();
        } catch (NoResultException noResultEx) {
            this.setMessage("No se encontraron registros para el Id dado");
            return null;
        } catch (IllegalStateException stateException) {
            this.setMessage("Se produjo un llamado a INSERT o UPDATE");
            return null;
        }
        return this.getReferenceList();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Reference getReference() {
        return reference;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }

    public List getReferenceElementValues() {
        return referenceElementValues;
    }

    public void setReferenceElementValues(List referenceElementValues) {
        this.referenceElementValues = referenceElementValues;
    }

    public List<Reference> getReferenceList() {
        return referenceList;
    }
    
    private boolean canDeleteReference(Reference reference) {
        boolean canDelete = true;        
        String  errorMessage = "";
        /*
        if (!userType.getSpeciesRecordAudienceSet().isEmpty()) {
            canDelete = false;
             errorMessage = "El registro No. " + this.audience.getId() +  " est� asociado al menos a un registro de especies. No es posible borrarlo.";
        }
        this.setMessage(errorMessage);
         */
        return canDelete;
    }
    
    private boolean isReferenceNull(Reference reference) {
        boolean isNull = false;
        String msg = "";
        /*
        if ((audience.getName() == null) || (audience.getName().equals(""))){
            isNull = true;
            msg = "El siguiente campo es obligatorio: Nombre";
            setMessage(msg);
        }
         */
        return isNull;
    }
    
    private boolean isReferenceUnique(Reference reference) {
        boolean isUnique = true;
        
        String tmpIdentifier, sql;
        Long tmpId;
        tmpIdentifier = reference.getIdentifier();
        sql = "SELECT o FROM Reference o ";
        sql = sql + "where trim(lower(identifier)) = trim(lower('" + tmpIdentifier +"')) ";
        if (reference.getId()!=null) {
            sql = sql + " and id <> " + reference.getId();
        }
        if (em.createQuery(sql).getResultList().size() > 0) {
            isUnique = false;
        }
        return isUnique;
    }
    
    private boolean persist() {
        if (!isReferenceNull(reference)) {
           if (isReferenceUnique(reference)) {
                try {
                    this.reference.setLanguage(em.find(Language.class,this.reference.getLanguage().getLanguageId()));
                    this.reference.setReferenceType(em.find(ReferenceType.class,this.reference.getReferenceType().getId()));
                    em.persist(this.reference);
                    return true;
                } catch (Exception e) {
                    setMessage(e.getLocalizedMessage());
                    return false;
                }
            } else {
                setMessage("Ya existe otra referencia almacenada en el sistema con el mismo número de serie. El registro no fue creado.");
                return false;
            }
        } else {
            setMessage(getMessage() + " El registr� no se cre�.");
            return false;
        }
    }

    public boolean create(Reference reference) {
        setReference(reference);
        return persist();
    }
    
    public boolean update(Reference reference) {
        boolean updated = false;
        if (!isReferenceNull(reference)){
            if (this.isReferenceUnique(reference)) {
                try {
                    reference.setLanguage(em.find(Language.class,reference.getLanguage().getLanguageId()));
                    reference.setReferenceType(em.find(ReferenceType.class,reference.getReferenceType().getId()));
                    this.setReference(em.merge(reference));
                    updated = true;                
                } catch (IllegalStateException ex) {
                    this.setMessage(ex.getMessage());
                } catch (IllegalArgumentException ex2) {
                    this.setMessage(ex2.getMessage());
                } catch (TransactionRequiredException ex3) {
                    this.setMessage(ex3.getMessage());
                }
            } else {
                setMessage("Ya existe otra referencia almacenada en el sistema con el mismo n�mero de serie. El registro no fu� creado.");
            }            
        } else {
            this.setMessage(this.getMessage() + " El registro no se modific�.");
        }
        return updated;     
    }
    
    public boolean remove(Long id) {
        boolean removed = false;
        try {
            this.reference = em.find(org.inbio.ara.persistence.reference.Reference.class,id);
            if (this.canDeleteReference(this.reference)) {
                this.reference = em.merge(this.reference);
                em.remove(this.reference);
                removed = true;
            }
        } catch (Exception e) {
            this.setMessage(e.getMessage());
            removed = false;
        }
        return removed;     
    }
    
    public List getReferenceElementList() {
        Query q = em.createQuery("Select o.id, o.name, o.sequence from ReferenceElement as o order by o.sequence");
        try {
            return q.getResultList();
        } catch (NoResultException noResultEx) {
            this.setMessage("No hay elementos que mostrar");
            return null;
        } catch (IllegalStateException stateException) {
            this.setMessage("Se produjo un llamado a INSERT o UPDATE");
            return null;
        }
    }
    
    public String getReferenceElementValue(Long ReferenceId, Long ElementId) {
        Query q = em.createQuery("Select object(o) from ReferenceElementValue as o where o.referenceElementValuePK.referenceId = " + ReferenceId + " and o.referenceElementValuePK.referenceElementId = " + ElementId);
        try {
            ReferenceElementValue value = (ReferenceElementValue)q.getSingleResult();
            return value.getContents();
        } catch (NoResultException noResultEx) {
            this.setMessage("No hay elementos que mostrar");
            return null;
        } catch (IllegalStateException stateException) {
            this.setMessage("Se produjo un llamado a INSERT o UPDATE");
            return null;
        } catch(NonUniqueResultException nonUniqueEx) {
            this.setMessage(nonUniqueEx.getMessage());
            return null;
        }
    }
    
    public ReferenceElementValue getReferenceElementValueEntity(Long ReferenceId, Long ElementId) {
        Query q = em.createQuery("Select object(o) from ReferenceElementValue as o where o.referenceElementValuePK.referenceId = " + ReferenceId + " and o.referenceElementValuePK.referenceElementId = " + ElementId);
        try {
            return (ReferenceElementValue)q.getSingleResult();
        } catch (NoResultException noResultEx) {
            return new ReferenceElementValue();
        } catch (IllegalStateException stateException) {
            this.setMessage("Se produjo un llamado a INSERT o UPDATE");
            return null;
        } catch(NonUniqueResultException nonUniqueEx) {
            this.setMessage(nonUniqueEx.getMessage());
            return null;
        }
    }    
    
    public boolean updateReferenceElementValue (Long referenceId, Long elementId, String contents, String createdBy, String modifiedBy) {
        Boolean updated = false;
        
        ReferenceElementValue tmp = getReferenceElementValueEntity(referenceId, elementId);
        if (tmp.getReferenceElementValuePK() == null) {
            // Nueva entidad.
            ReferenceElementValuePK pk = new ReferenceElementValuePK();
            pk.setReferenceId(referenceId);
            pk.setReferenceElementId(elementId);
            
            tmp.setReferenceElementValuePK(pk);
            tmp.setContents(contents);
            tmp.setCreatedBy(createdBy);
            tmp.setLastModificationBy(modifiedBy);
            tmp.setSequence(0L);
            try {
                em.persist(tmp);
                updated=true;
            } catch (Exception e) {
                setMessage(e.getLocalizedMessage());
            }            
        } else {
            // Entidad existente
            tmp.setContents(contents);
            tmp.setLastModificationBy(modifiedBy);
            try {
                em.merge(tmp);
                updated = true;                
            } catch (IllegalStateException ex) {
                this.setMessage(ex.getMessage());
            } catch (IllegalArgumentException ex2) {
                this.setMessage(ex2.getMessage());
            } catch (TransactionRequiredException ex3) {
                this.setMessage(ex3.getMessage());
            }
        }
        return updated;
    }
}
