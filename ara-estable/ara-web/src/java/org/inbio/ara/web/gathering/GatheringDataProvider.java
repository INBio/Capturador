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
 * GatheringDataProvider.java
 *
 * Created on May 11, 2008, 2:23 PM
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
import org.inbio.ara.facade.gathering.GatheringRemote;
import org.inbio.ara.persistence.gathering.GatheringObservation;

/**
 *
 * @author roaguilar
 */
public class GatheringDataProvider extends ObjectListDataProvider{
    
    /** Creates a new instance of GatheringDataProvider */
    public GatheringDataProvider(Long collectionId) {
        this.setObjectType(GatheringObservation.class);
        this.refreshDataList(collectionId);
    }

    public void refreshDataList(Long collectionId) {
        this.setList(lookupGatheringBean().getGathering(collectionId));
    }
    
    private GatheringRemote lookupGatheringBean() {
        try {
            Context c = new InitialContext();
            return (GatheringRemote) c.lookup("GatheringBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
    
}
