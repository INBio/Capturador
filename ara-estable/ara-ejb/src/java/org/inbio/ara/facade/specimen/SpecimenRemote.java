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
import javax.ejb.Remote;
import org.inbio.ara.dto.LifeStageSexDTO;
import org.inbio.ara.persistence.specimen.DwcCategory;
import org.inbio.ara.persistence.specimen.DwcElement;
import org.inbio.ara.persistence.specimen.LifeStage;
import org.inbio.ara.persistence.specimen.Specimen;
import org.inbio.ara.util.QueryNode;


/**
 * This is the business interface for Specimen enterprise bean.
 */
@Remote
public interface SpecimenRemote {

    org.inbio.ara.persistence.specimen.Specimen getSpecimen();

  //  java.util.List getSpecimenList();

    java.lang.String getMessage();

    boolean update(Specimen specimen);

    boolean delete(Long specimenId);

    boolean discard(Long specimenId);

    /**
     * @deprecated este metdo debe estar en un EAO [jgutierrez]
     * @param specimenId
     * @return
     */
    org.inbio.ara.persistence.specimen.Specimen find(Long specimenId);

    org.inbio.ara.persistence.gathering.GatheringObservationDetail findGOD(Long id);

    org.inbio.ara.persistence.gathering.GatheringObservationMethod findGOMethod(Long id);

    org.inbio.ara.persistence.specimen.StorageType findStorageType(Long id);

    org.inbio.ara.persistence.specimen.Substrate findSubstrate(Long id);

    org.inbio.ara.persistence.specimen.PreservationMedium findPreservationMedium(Long id);

    org.inbio.ara.persistence.specimen.Origin findOrigin(Long id);

    org.inbio.ara.persistence.specimen.SpecimenType findSpecimenType(Long id);

    org.inbio.ara.persistence.specimen.ExtractionType findExtractionType(Long id);

    org.inbio.ara.persistence.specimen.SpecimenCategory findSpecimenCategory(Long id);

    java.util.List findAll();

    LifeStage findLifeStage(Long aLong);

    org.inbio.ara.persistence.specimen.Sex findSex(Long id);

    /**
     * @deprecated se recomienda utilizar el metodo getLifeStageSexDTOList(Long specimenId)
     * @use getLifeStageSexDTOList(Long specimenId)
     * @param specimenId
     * @return
     */
    java.util.List getSpecimenLifeStageSex(Long specimenId);
    List getDwCRecords();
    List findAllDwC();
    List<DwcElement> getDwCElements();
    List<DwcElement> categoryElements(BigDecimal catId);
    List<DwcCategory> getDwCCategories();
    List makeQuery(LinkedList<QueryNode> sll);
    List makePaginatedQuery(LinkedList<QueryNode> sll, int first, int amount);
    
	DwcElement getDwCElementById(BigDecimal id);

    /**
     * @deprecated se recomienda usar el método saveSpecimenLifeStageSex(List<LifeStageSexDTO> specimenLifeStageSexList)
     * @use saveSpecimenLifeStageSex(List<LifeStageSexDTO> specimenLifeStageSexList)
     * [jgutierrez]
     * @param specimenId
     * @return
     */
	boolean saveSpecimenLifeStageSexList(List<LifeStageSexSimple> stageSexList);
    void reloadDarwinCoreTable();

    /**
     * 
     * @param specimenId
     * @return
     */
    public List<LifeStageSexDTO> getLifeStageSexDTOList(Long specimenId);


    /**
     * 
     * @param specimenId
     * @param specimenLifeStageSexList
     */
    public void updateSpecimenLifeStageSexList(Long specimenId, List<LifeStageSexDTO> specimenLifeStageSexList);


    /**
     * 
     * @param specimenId
     * @param lifeStageId
     * @param sexId
     */
    public void deleteSpecimenLifeStageSex(Long specimenId, Long lifeStageId, Long sexId);

    /**
     *
     * @param specimenId
     * @param lifeStageSexDTO de este objecto solo necesita el lifeStageId, sexId y el quantity para crear el objeto
     */
    public void saveSpecimenLifeStageSex(Long specimenId, LifeStageSexDTO lifeStageSexDTO);

    public org.inbio.ara.persistence.specimen.Specimen getSpecimenByCatalogNumber(java.lang.Long cn);

    public List findAllDwCPaginated(int first, int amount);

    public List findByGatheringObservationId(Long gatheringObservationId);
}
