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
 * SpecimenGenParms.java
 *
 * Created on January 1, 2008, 10:09 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.specimen;

import java.util.ArrayList;
import java.util.List;
import org.inbio.ara.persistence.collection.Collection;
import org.inbio.ara.persistence.gathering.GatheringObservation;
import org.inbio.ara.persistence.gathering.GatheringObservationDetail;
import org.inbio.ara.persistence.gathering.MorphologicalDescription;
import org.inbio.ara.persistence.gathering.Project;
import org.inbio.ara.persistence.specimen.ExtractionType;
import org.inbio.ara.persistence.specimen.LifeStage;
import org.inbio.ara.persistence.specimen.Origin;
import org.inbio.ara.persistence.specimen.PreservationMedium;
import org.inbio.ara.persistence.specimen.Sex;
import org.inbio.ara.persistence.specimen.Specimen;
import org.inbio.ara.persistence.specimen.SpecimenCategory;
import org.inbio.ara.persistence.specimen.SpecimenType;
import org.inbio.ara.persistence.specimen.StorageType;
import org.inbio.ara.persistence.specimen.Substrate;

/**
 *
 * @author roaguilar
 */
public class SpecimenGenerator {
    
    private int quantity;
    private List specimenList;
    private String message;
    private SpecimenGenParms specimenGenParms;
    
    /** Creates a new instance of SpecimenGen */
    public SpecimenGenerator() {
    }
    
    /*
    private boolean checkParms() {
        
        if (project == null) {
            setMessage("Falta el proyecto.");
            return false;
        }
        if (gathering == null) {
            setMessage("Falta la recolección.");
            return false;
        }
        if (specimenCategory == null) {
            setMessage("Falta la categoría.");
            return false;
        }
        if (collection == null) {
            setMessage("Falta la colección.");
            return false;
        }
        if (quantity <= 0) {
            setMessage("La cantidad de especímenes debe ser igual o mayor a 1.");
            return false;
        }
        return true;
    }
    
     */
    public List getGeneratedSpecimens() {
        Specimen tmpSpecimen;
        setMessage("");
        //if (checkParms()) {
            specimenList = new ArrayList(quantity);
            for (int i = 1; i <= quantity; i++) {
                tmpSpecimen = new Specimen();
                specimenList.add(tmpSpecimen);
            }
            /*
        } else {
            String tmp = "No es posible generar los especímenes: " + getMessage();
            specimenList = new ArrayList(0);
            setMessage(tmp);
        }*/
        return specimenList;
    }
    

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



    public List getSpecimenList() {
        return specimenList;
    }

    public void setSpecimenList(List specimenList) {
        this.specimenList = specimenList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
