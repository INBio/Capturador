/*
 *  Ara - Capture Species and Specimen Data
 *
 * Copyright © 2009  INBio (Instituto Nacional de Biodiversidad).
 * Heredia, Costa Rica.
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

package org.inbio.ara.facade.label.impl;

import javax.ejb.EJB;
import org.inbio.ara.dto.label.LabelDTO;
import org.inbio.ara.dto.label.OriginalLabelDTO;
import org.inbio.ara.facade.label.*;
import javax.ejb.Stateless;
import java.util.Calendar;
import java.util.List;
import org.inbio.ara.dto.inventory.SpecimenDTOFactory;
import org.inbio.ara.dto.label.HistoryLabelDTO;
import org.inbio.ara.dto.label.HistoryLabelDTOFactory;
import org.inbio.ara.dto.label.LabelDTOFactory;
import org.inbio.ara.dto.label.OriginalLabelDTOFactory;
import org.inbio.ara.eao.label.HistoryLabelEAOLocal;
import org.inbio.ara.eao.label.LabelEAOLocal;
import org.inbio.ara.eao.label.OriginalLabelEAOLocal;
import org.inbio.ara.eao.specimen.SpecimenEAOLocal;
import org.inbio.ara.persistence.label.Label;
import org.inbio.ara.persistence.label.OriginalLabel;
import org.inbio.ara.persistence.label.LabelHistory;



/**
 * Jueves 21-01-10 16:00
 * @author pcorrales
 */

@Stateless
public class LabelFacadeImpl implements LabelFacadeRemote {

    @EJB  //inyectar interfaces local -remote
    private SpecimenEAOLocal specimenEAO;


    @EJB  //
    private LabelEAOLocal labelEAO;

    @EJB  //
    private OriginalLabelEAOLocal originalLabelEAO;

    @EJB  //
    private HistoryLabelEAOLocal historylLabelEAO;
   

    /*factory of  DTO */
    private SpecimenDTOFactory specimenDTOFactory = new SpecimenDTOFactory();

    private LabelDTOFactory labelDTOFactory = new LabelDTOFactory();

    private OriginalLabelDTOFactory originalLabelDTOFactory = new OriginalLabelDTOFactory ();

    private HistoryLabelDTOFactory historylLabelDTOFactory = new HistoryLabelDTOFactory();
   
    
  
    /**
     * @return the specimenEAO
     */
    public SpecimenEAOLocal getSpecimenEAO() {
        return specimenEAO;
    }

    /**
     * @param specimenEAO the specimenEAO to set
     */
    public void setSpecimenEAO(SpecimenEAOLocal specimenEAO) {
        this.specimenEAO = specimenEAO;
    }

    /**
     * @return the labelEAO
     */
    public LabelEAOLocal getLabelEAO() {
        return labelEAO;
    }

    /**
     * @param labelEAO the labelEAO to set
     */
    public void setLabelEAO(LabelEAOLocal labelEAO) {
        this.labelEAO = labelEAO;
    }

    /**
     * @return the originalLabelEAO
     */
    public OriginalLabelEAOLocal getOriginalLabelEAO() {
        return originalLabelEAO;
    }

    /**
     * @param originalLabelEAO the originalLabelEAO to set
     */
    public void setOriginalLabelEAO(OriginalLabelEAOLocal originalLabelEAO) {
        this.originalLabelEAO = originalLabelEAO;
    }

    /**
     * @return the specimenDTOFactory
     */
    public SpecimenDTOFactory getSpecimenDTOFactory() {
        return specimenDTOFactory;
    }

    /**
     * @param specimenDTOFactory the specimenDTOFactory to set
     */
    public void setSpecimenDTOFactory(SpecimenDTOFactory specimenDTOFactory) {
        this.specimenDTOFactory = specimenDTOFactory;
    }

    /**
     * @return the labelDTOFactory
     */
    public LabelDTOFactory getLabelDTOFactory() {
        return labelDTOFactory;
    }

    /**
     * @param labelDTOFactory the labelDTOFactory to set
     */
    public void setLabelDTOFactory(LabelDTOFactory labelDTOFactory) {
        this.labelDTOFactory = labelDTOFactory;
    }

    /**
     * @return the originalLabelDTOFactory
     */
    public OriginalLabelDTOFactory getOriginalLabelDTOFactory() {
        return originalLabelDTOFactory;
    }

    /**
     * @param originalLabelDTOFactory the originalLabelDTOFactory to set
     */
    public void setOriginalLabelDTOFactory(OriginalLabelDTOFactory originalLabelDTOFactory) {
        this.originalLabelDTOFactory = originalLabelDTOFactory;
    }
    
     /**
     * @param selectionListEntityId
     * @param collectionId
     * @return
     */

    /**
     * @return the historylLabelDTOFactory
     */
    public HistoryLabelDTOFactory getHistorylLabelDTOFactory() {
        return historylLabelDTOFactory;
    }

    /**
     * @param historylLabelDTOFactory the historylLabelDTOFactory to set
     */
    public void setHistorylLabelDTOFactory(HistoryLabelDTOFactory historylLabelDTOFactory) {
        this.historylLabelDTOFactory = historylLabelDTOFactory;
    }

    /**
     * @return the historylLabelEAO
     */
    public HistoryLabelEAOLocal getHistorylLabelEAO() {
        return historylLabelEAO;
    }

    /**
     * @param historylLabelEAO the historylLabelEAO to set
     */
    public void setHistorylLabelEAO(HistoryLabelEAOLocal historylLabelEAO) {
        this.historylLabelEAO = historylLabelEAO;
    }

     /**
    * created tha label of specimen information
    * @param labelDTO
    */
    public Long  saveLabel(LabelDTO labelDTO) {

        Label label = this.getLabelDTOFactory().createPlainEntity(labelDTO);
        this.getLabelEAO().create(label);

        return label.getLabelId();
    }

    /**
     * created tha OriginalLabel of specimen information, this label is not modificable
     * @param OriginalLabelDTO
     */
    public Long saveOriginalLabel(OriginalLabelDTO originalLabelDTO) {

          OriginalLabel  originalLabel = this.getOriginalLabelDTOFactory().createPlainEntity(originalLabelDTO);
          this.getOriginalLabelEAO().create(originalLabel);

          return originalLabel.getOriginalLabelId();
    }


    /**
     * created tha OriginalLabel of specimen information, this label is not modificable
     * @param OriginalLabelDTO
     */
    public void updateLabel(LabelDTO labelDTO) {

        Label  label = this.labelEAO.findById(Label.class, labelDTO.getLabelId());
        Label newLabel =  this.labelDTOFactory.updateEntityWithPlainValues(labelDTO, label);
        this.getLabelEAO().update(newLabel);
    }

    /**
     * created tha OriginalLabel of specimen information, this label is not modificable
     * @param OriginalLabelDTO
     */
    public void updateOriginalLabel(OriginalLabelDTO labelDTO) {

        OriginalLabel label = this.originalLabelEAO.findById(OriginalLabel.class, labelDTO.getOriginalLabelID());
        OriginalLabel newLabel = this.originalLabelDTOFactory.updateEntityWithPlainValues(labelDTO, label);
        this.originalLabelEAO.update(newLabel);

    }


    /**
     * created tha OriginalLabel of specimen information, this label is not modificable
     * this labels is the result of label and  label type  corrector
     * @param HistoryLabelDTO
     */
    public void saveHistoryLabel(HistoryLabelDTO historyLabelDTO){

        //buscar los correctores
        LabelHistory  history  =  this.getHistorylLabelDTOFactory().createPlainEntity(historyLabelDTO);
        this.getHistorylLabelEAO().create(history);
    }


  

    /**
     * counts the labels
     * @return
     */
    public Long countLabels() {
        return this.getLabelEAO().count(Label.class);
    }

    /**
     * find the label 
     * @param id
     * @param initialDate
     * @param finalDate
     * @return
     */
    public List<Long> findByLabelTypeId(Long id, Calendar initialDate, Calendar finalDate) {
        
        return this.getLabelEAO().findByLabelTypeId(id, initialDate, finalDate);
    }


   /**
    * find the label match with the id
    * @param labelDTO
    */
    public LabelDTO findByLabelId(Long labelId) {

        return this.getLabelDTOFactory().createDTO(this.getLabelEAO().findById(Label.class, labelId));
    }

     /**
    * find tje label  match with the id
    * @param labelDTO
    */
    public OriginalLabelDTO findByOriginalLabelId(Long labelId) {
        
        return this.getOriginalLabelDTOFactory().createDTO(this.getOriginalLabelEAO().findById(OriginalLabel.class, labelId));
        
    }

    
   public List<HistoryLabelDTO> getAllLabelHistoryPaginated(int first,
            int totalResults, Long labelId, Long collectionId) {

        List<LabelHistory> sList = this.getHistorylLabelEAO().findLabelHistoryPaginatedFilterAndOrderByAncestorId(labelId, first, totalResults, null, collectionId);
        
        if (sList == null)
            return null;
        List<HistoryLabelDTO> updated =  this.getHistorylLabelDTOFactory().createDTOList(sList);
        return updated;
    }
    

   /**
    * get  the list of labels  associated with a current label
    * @param first
    * @param totalResults
    * @param labelId
    * @param collection
    * @param labelTypeId
    * @return
    */
    public List<LabelDTO> getAllLabelPaginated(int first,int totalResults,Long labelId, Long collection,Long labelTypeId) {

        //paginated the label by id of the labels
        String[]  campos = {"labelId"};
        List<Label> sList = this.getLabelEAO().findAllPaginatedFilterAndOrderByAncestorId(labelId, first, totalResults,campos,collection,labelTypeId);

        if (sList == null)
            return null;
        List<LabelDTO> updated =   this.getLabelDTOFactory().createDTOList(sList);
        return updated;
    }
}