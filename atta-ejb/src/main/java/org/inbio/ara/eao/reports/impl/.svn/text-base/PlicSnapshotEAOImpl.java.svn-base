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

import org.inbio.ara.eao.reports.*;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.reports.PlicSnapshot;

/**
 *
 * @author esmata
 */
@Stateless
public class PlicSnapshotEAOImpl extends BaseEAOImpl<PlicSnapshot,String>
        implements PlicSnapshotEAOLocal {
    
    /**
     * Delete all elements from snapshot table
     */
    public void truncatePlicSnapshot(){
        Query q = em.createNativeQuery("truncate ara.plic_snapshot;");
        q.executeUpdate();
    }

    /**
     * Execute native query to populate the snapshot table
     * @param query
     * @return
     */
    public boolean PlicSnapshotAllPostgresql(String query){
        try{
            Query nq = em.createNativeQuery(query);
            nq.executeUpdate();
            return true;
        }
        catch(Exception e){return false;}
    }
 
}
