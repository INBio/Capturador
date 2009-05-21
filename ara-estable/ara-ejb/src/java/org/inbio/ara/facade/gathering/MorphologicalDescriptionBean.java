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
 * MorphologicalDescriptionBean.java
 *
 * Created on December 27, 2007, 4:05 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.gathering;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;
import org.inbio.ara.persistence.gathering.MorphologicalDescription;
import org.inbio.ara.persistence.person.Person;
import org.inbio.ara.persistence.person.PersonProfile;

/**
 *
 * @author roaguilar
 */
@Stateless
public class MorphologicalDescriptionBean implements org.inbio.ara.facade.gathering.MorphologicalDescriptionRemote, org.inbio.ara.facade.gathering.MorphologicalDescriptionLocal {

    @PersistenceContext
    private EntityManager em;
    private MorphologicalDescription morphologicalDescription;
    private String message;
    
    /** Creates a new instance of MorphologicalDescriptionBean */
    public MorphologicalDescriptionBean() {
    }

    public boolean persist() {
        boolean persisted = false;
        if (!isMorphologicalDescriptionNull(morphologicalDescription)){
            if (this.isMorphologicalDescriptionUnique(morphologicalDescription)) {
                try {
                    morphologicalDescription.setPerson(em.find(Person.class,morphologicalDescription.getPerson().getId()));
                    em.persist(morphologicalDescription);
                    persisted = true;
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
                setMessage("La descripción morfológica ya existe en el sistema.");
                persisted = false;
            }
        } else {
            this.setMessage(this.getMessage() + " El registro no fue creado. Entidad Nula");
        }
        return persisted;
    }
    
    public boolean create(MorphologicalDescription morphologicalDescription) {
        this.setMorphologicalDescription(morphologicalDescription);
        return persist();
    }
    
    public boolean update(MorphologicalDescription morphologicalDescription) {
        boolean updated = false;
        if (!isMorphologicalDescriptionNull(morphologicalDescription)){
            if (this.isMorphologicalDescriptionUnique(morphologicalDescription)) {
                try {
                    // Incorporar las entidades auxiliares al contexto de la transacción
                    morphologicalDescription.setPerson(em.find(Person.class,morphologicalDescription.getPerson().getId()));
                    this.morphologicalDescription = em.merge(morphologicalDescription);
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
                setMessage("La descripción morfológica ya existe en el sistema.");
                updated = false;
            }
        } else {
            this.setMessage(this.getMessage() + " El registro no fue creado.");
        }
        return updated;
    }
    
    public boolean delete(Long id) {
        try {
            // Buscar la entidad a borrar
            MorphologicalDescription md = (MorphologicalDescription)em.find(MorphologicalDescription.class,id);
            // Verificar si la entidad realmente existe
            if (md == null) {
                setMessage("No existe una descripción morfológica asociada al Id " + id);
                return false;
            }
            // Incorporar la entidad al contexto de la transacción
            this.morphologicalDescription = em.merge(md);
            if (canDeleteMorphologicalDescription(md)) {
                // Eliminar la entidad
                em.remove(this.morphologicalDescription);
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
    
    public MorphologicalDescription getMorphologicalDescription(Long gatheringObservationDetailId) {
        return this.getMorphologicalDescription();
    }
    
    private boolean isMorphologicalDescriptionNull(MorphologicalDescription morphologicalDescription) {
        if (morphologicalDescription.getContents() == null) {
            setMessage("Falta el texto de la descripción.");
            return true;
        }
        if(morphologicalDescription.getDescriptionDate() == null) {
            setMessage("Falta la fecha de la descripción");
            return true;
        }
        if (morphologicalDescription.getPerson() == null) {
            setMessage("Falta el descriptor.");
            return true;
        }
        return false;
    }
    
    private boolean isMorphologicalDescriptionUnique (MorphologicalDescription morphologicalDescription) {
        return true;
    }
    
    public boolean canDeleteMorphologicalDescription(MorphologicalDescription morphologicalDescription) {
        return true;
    }

    public MorphologicalDescription getMorphologicalDescription() {
        return morphologicalDescription;
    }

    public void setMorphologicalDescription(MorphologicalDescription morphologicalDescription) {
        this.morphologicalDescription = morphologicalDescription;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
