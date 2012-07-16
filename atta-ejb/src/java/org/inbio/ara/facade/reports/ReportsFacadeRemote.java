/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Nacional de Biodiversidad)
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

package org.inbio.ara.facade.reports;

import javax.ejb.Remote;

/**
 *
 * @author esmata
 */
@Remote
public interface ReportsFacadeRemote {

    public java.util.List<org.inbio.ara.dto.reports.DwcElementDTO> findDwCElements();

    public org.inbio.ara.dto.reports.DwcCategoryDTO findDwcCategoryById(java.lang.Long id);

    public org.inbio.ara.dto.reports.DwcElementDTO findDwcElementById(java.lang.Long id);

    public boolean reloadDarwinCoreTable();

    public boolean makeDcwSnapshotNative(java.util.LinkedList<org.inbio.ara.util.QueryNode> qnlist, java.util.LinkedList<java.lang.String> elist);

    public java.util.LinkedList<java.lang.String> getAllElementsDwc();

    public boolean export(java.io.File f);

    public java.util.LinkedList<java.lang.String> getAllElementsPlic();

    public java.util.List<org.inbio.ara.dto.reports.PlicElementDTO> findPlicElements();

    public boolean exportToPlic(java.io.File f);

    public boolean makePlicSnapshotNative(java.util.LinkedList<org.inbio.ara.util.QueryNode> qnlist, java.util.LinkedList<java.lang.String> elist);

    public boolean reloadPlinianCoreTable();
}
