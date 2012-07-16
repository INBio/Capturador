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

package org.inbio.ara.eao.reports.impl;

import java.io.File;
import org.inbio.ara.eao.reports.*;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.reports.DwcSnapshot;

/**
 *
 * @author esmata
 */
@Stateless
public class DwcSnapshotEAOImpl extends BaseEAOImpl<DwcSnapshot,String>
        implements DwcSnapshotEAOLocal {

    /**
     * Delete all elements from snapshot table
     */
    public void truncateDwcSnapshot(){
        Query q = em.createNativeQuery("truncate ara.dwc_snapshot;");
        q.executeUpdate();
    }

    /**
     * Execute native query to populate the snapshot table
     * @param query
     * @return
     */
    public boolean DcwSnapshotAllPostgresql(String query){
        try{
            Query nq = em.createNativeQuery(query);
            nq.executeUpdate();
            return true;
        }
        catch(Exception e){return false;}
    }

    public boolean writeDwcSnapshotToFile(File f) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
