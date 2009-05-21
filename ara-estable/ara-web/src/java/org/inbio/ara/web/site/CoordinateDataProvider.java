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
 * CoordinateDataProvider.java
 *
 * Created on June 26, 2008, 10:37 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.web.site;

import com.sun.data.provider.RowKey;
import com.sun.data.provider.impl.ObjectListDataProvider;
import java.util.List;
import org.inbio.ara.persistence.gis.SiteCoordinate;

/**
 *
 * @author roaguilar
 */
public class CoordinateDataProvider extends ObjectListDataProvider{
    
    /** Creates a new instance of CoordinateDataProvider */
    public CoordinateDataProvider() {
        this.setObjectType(SiteCoordinate.class);
    }
    
    private void refreshDataList(List list) {
        this.setList(list);
    }
    
    public boolean addElement(SiteCoordinate object) {
        List tList;
        tList = this.getList();
        if (objectExists(object)==false) {
            tList.add(object);
            this.refreshDataList(tList);
            return true;
        } else {
            return false;
        }
    }
    
    public void removeElement(RowKey rowkey) {
        SiteCoordinate object = (SiteCoordinate)this.getObject(rowkey);
        List tList = this.getList();
        tList.remove(object);
        this.setList(tList);
    }
    
    public boolean objectExists(SiteCoordinate object) {
        //List<LifeStageSexSimple> tList = this.getList();
        List<SiteCoordinate> tList = this.getList();
        //Long newLifeStageId = object.getLifeStage().getId();
        Float longitude = object.getLongitude();
        //Long newSexId = object.getSex().getId();
        Float latitude = object.getLatitude();
        for (SiteCoordinate tObject : tList) {
            if (tObject.getLongitude().compareTo(longitude)== 0) {
                if (tObject.getLatitude().compareTo(latitude)==0) {
                    return true;
                }
            }
        }
        return false;
    }
}
