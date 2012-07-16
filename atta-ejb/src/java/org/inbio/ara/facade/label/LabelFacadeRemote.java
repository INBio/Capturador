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

package org.inbio.ara.facade.label;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Calendar;
import java.util.List;
import javax.ejb.Remote;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.dto.inventory.SpecimenDTO;
import org.inbio.ara.dto.label.HistoryLabelDTO;
import org.inbio.ara.dto.label.LabelDTO;
import org.inbio.ara.dto.label.OriginalLabelDTO;
import org.inbio.ara.persistence.label.Label;
import org.inbio.ara.persistence.label.LabelHistory;


/**
 * Jueves 21-01-10 16:00
 * @author pcorrales
 */

@Remote
public interface LabelFacadeRemote {


   public Long saveLabel(LabelDTO labelDTO);

   public Long saveOriginalLabel(OriginalLabelDTO labelDTO);

   public void saveHistoryLabel(HistoryLabelDTO labelDTO);

   public void updateLabel(LabelDTO labelDTO);

   public void updateOriginalLabel(OriginalLabelDTO labelDTO);

   public List<Long> findByLabelTypeId(Long label, Calendar initialDate, Calendar finalDate);

   public LabelDTO findByLabelId(Long labelId);

   public OriginalLabelDTO findByOriginalLabelId(Long labelId);

  
   public Long countLabels();

   public List<HistoryLabelDTO> getAllLabelHistoryPaginated(int first,
            int totalResults, Long labelId,Long collectionId);

   public List<LabelDTO> getAllLabelPaginated(int first,
            int totalResults,Long labelId,Long collectionId,Long labelTypeId);
 

}