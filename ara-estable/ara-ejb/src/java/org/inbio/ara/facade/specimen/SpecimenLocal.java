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

package org.inbio.ara.facade.specimen;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.persistence.specimen.DwcCategory;
import org.inbio.ara.persistence.specimen.DwcElement;
import org.inbio.ara.persistence.specimen.LifeStage;
import org.inbio.ara.persistence.specimen.Specimen;
import org.inbio.ara.util.QueryNode;


/**
 * This is the business interface for Specimen enterprise bean.
 */
@Local
public interface SpecimenLocal {
    org.inbio.ara.persistence.specimen.Specimen getSpecimen();

   // java.util.List getSpecimenList();

    java.lang.String getMessage();

    boolean update(Specimen specimen);

    boolean delete(Long specimenId);

    boolean discard(Long specimenId);

    org.inbio.ara.persistence.specimen.Specimen find(Long specimenId);

    org.inbio.ara.persistence.gathering.GatheringObservationDetail findGOD(Long id);

    org.inbio.ara.persistence.gathering.GatheringObservationMethod findGOMethod(Long id);

    org.inbio.ara.persistence.specimen.Substrate findSubstrate(Long id);

    org.inbio.ara.persistence.specimen.PreservationMedium findPreservationMedium(Long id);

    org.inbio.ara.persistence.specimen.Origin findOrigin(Long id);

    org.inbio.ara.persistence.specimen.SpecimenType findSpecimenType(Long id);

    org.inbio.ara.persistence.specimen.ExtractionType findExtractionType(Long id);

    org.inbio.ara.persistence.specimen.SpecimenCategory findSpecimenCategory(Long id);

    java.util.List findAll();
    
    LifeStage findLifeStage(Long aLong);

    org.inbio.ara.persistence.specimen.Sex findSex(Long id);
    List getDwCRecords();
    List findAllDwC();
    List<DwcElement> getDwCElements();
    List<DwcElement> categoryElements(BigDecimal catId);
    List<DwcCategory> getDwCCategories();
    List makeQuery(LinkedList<QueryNode> sll);
    DwcElement getDwCElementById(BigDecimal id);
	boolean saveSpecimenLifeStageSexList(List<LifeStageSexSimple> stageSexList);
    void reloadDarwinCoreTable();
}
