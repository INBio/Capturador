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
 * SpeciesRecordStageFacadeLocal.java
 *
 * Created on July 24, 2007, 4:12 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade;

import java.util.List;
import javax.ejb.Local;
//import org.inbio.ara.persistence.entity.SpeciesRecordStage;
//import org.inbio.ara.persistence.species.SpeciesRecordStage;
import org.inbio.ara.persistence.species.TaxonDescriptionStage;

/**
 *
 * @author jgutierrez
 */
@Local
public interface SpeciesRecordStageFacadeLocal{
    //void create(SpeciesRecordStage speciesRecordStage);
    void create(TaxonDescriptionStage speciesRecordStage);
    
    //void edit(SpeciesRecordStage speciesRecordStage);
    void edit(TaxonDescriptionStage speciesRecordStage);
    
    //void destroy(SpeciesRecordStage speciesRecordStage);
    void destroy(TaxonDescriptionStage speciesRecordStage);
    
    //SpeciesRecordStage find(Object pk);
    TaxonDescriptionStage find(Object pk);
    
    List findAll();
    
    java.util.List getSpeciesRecordStages();
    
}
