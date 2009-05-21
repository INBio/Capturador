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
 * LabelBean.java
 *
 * Created on December 29, 2007, 4:47 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.gathering;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;
import org.inbio.ara.persistence.gathering.Label;

/**
 *
 * @author roaguilar
 */
@Stateless
public class LabelBean implements org.inbio.ara.facade.gathering.LabelRemote, org.inbio.ara.facade.gathering.LabelLocal {

    @PersistenceContext
    private EntityManager em;
    private Label label;
    private String message;
    
    /** Creates a new instance of LabelBean */
    public LabelBean() {
    }
    
    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean persist() {
        boolean persisted = false;
        if (!isLabelNull(this.label)){
            try {
                em.persist(this.label);
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
            this.setMessage(this.getMessage() + " El registro no fué creado.");
        }
        return persisted;
    }
    
    public boolean create(Label label) {
        setLabel(label);
        return persist();
    }
    
    public boolean update(Label label) {
        boolean updated = false;
        if (!isLabelNull(label)){
            try {
                this.label = em.merge(label);
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
            this.setMessage(this.getMessage() + " El registro no fue creado.");
        }
        return updated;
    }
    
    public boolean delete(Long id) {
        try {
            // Buscar la entidad a borrar
            Label label = (Label)em.find(Label.class,id);
            // Verificar si la entidad realmente existe
            if (label == null) {
                setMessage("No existe una etiqueta asociada al Id " + id);
                return false;
            }
            // Incorporar la entidad al contexto de la transacción
            this.label = em.merge(label);
            // Eliminar la entidad
            em.remove(this.label);
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
    }
    
    private boolean isLabelNull(Label label) {
        if (label.getContents()==null) {
            setMessage("Falta el texto de la etiqueta");
            return true;
        }
        if (label.getInitialDate()==null) {
            setMessage("Falta la fecha de la etiqueta");
            return true;
        }

        return false;
    }
}
