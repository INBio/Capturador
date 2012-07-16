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

package org.inbio.ara.facade.format;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;
import org.inbio.ara.dto.format.ReportLayoutDTO;
import org.inbio.ara.dto.inventory.SpecimenDTO;

/**
 *
 * @author pcorrales
 */
@Remote
public interface FormatFacadeRemote {
    
  public List<ReportLayoutDTO> getAllReportLayout(Long FuncionalityTypeId);

  /**
   * obtener el DTO que corresponde al Id seleccionado por el usurio
   * @param reportLayoutId
   * @return*/

    /*proccess a report and  get the contents of label in this format**/
    public String  processReportLayout(Long reportLayoutId, SpecimenDTO specimenDTO);

    /*proccess a report and  get the  the list of the label  with this contents in format  html**/
    public List processReportLayout(Long reportLayoutId,ArrayList<SpecimenDTO> list);

    /*get the contents od report layout*/
    public String  getReportLayoutContents(Long  reportLayoutId);
}
