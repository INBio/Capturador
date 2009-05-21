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
 * GatheringDetailDataProvider.java
 *
 * Created on June 7, 2008, 11:26 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.web.gathering;

import com.sun.data.provider.impl.ObjectListDataProvider;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.inbio.ara.facade.gathering.GatheringDetailRemote;
import org.inbio.ara.persistence.gathering.GatheringObservationDetail;

/**
 *
 * @author roaguilar
 */
public class GatheringDetailDataProvider extends ObjectListDataProvider {
    
    private Long gatheringId;
    private Long collectionId;
    
    /** Creates a new instance of GatheringDetailDataProvider */
    public GatheringDetailDataProvider() {
        this.setObjectType(GatheringObservationDetail.class);
    }
    
    public GatheringDetailDataProvider(Long gatheringId, Long collectionId) {
        this.setObjectType(GatheringObservationDetail.class);
        this.refreshDataList(gatheringId,collectionId);
    }

    public void refreshDataList(Long gatheringId, Long collectionId) {
        this.collectionId = collectionId;
        this.gatheringId = gatheringId;
        this.setList(lookupGatheringBean().getGatheringObservationDetail(gatheringId,collectionId));
    }
    
    public void refreshDataList() {
        this.setList(lookupGatheringBean().getGatheringObservationDetail(gatheringId,collectionId));
    }
    
    private GatheringDetailRemote lookupGatheringBean() {
        try {
            Context c = new InitialContext();
            return (GatheringDetailRemote) c.lookup("GatheringDetailBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
}
