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
package org.inbio.ara.eao.reports;

import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.reports.DarwinCore14;

/**
 *
 * @author esmata
 */
@Local
public interface DarwinCore14EAOLocal extends BaseLocalEAO<DarwinCore14,String>{

    public boolean reloadDarwinCoreTable(String dbSchema);

    public java.lang.Long countQueryElements(java.lang.String jpqlQuery);

    public java.util.List findAllDwCPaginated(int first, int amount);

    public java.util.List makePaginatedQuery(java.util.LinkedList<org.inbio.ara.util.QueryNode> sll, int first, int amount);

    public java.lang.Long findTotalDwc();
    
}
