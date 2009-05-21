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
 * PredefinedValuesRemote.java
 *
 * Created on July 26, 2007, 11:00 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade;

import java.util.List;
import javax.ejb.Remote;
import java.util.HashMap;

/**
 *
 * @author jgutierrez
 */
@Remote
public interface PredefinedValuesRemote {
    
    public List getListBoxValues(String className, String idValue, String showName);
    public List getListBoxValuesSQL(String className, String idValue, String showName);
    public List getMainFields(String key, String tableName, String showName);
    public List getElements(int categoryId);
    public String getFieldContent(Long taxonId, String tableName, String keyField, String tableField);

    public int getContentNumber(Long taxonId, Long taxonDescriptionElementId);

    public String getContentText(Long taxonId, Long taxonDescriptionElementId);
    
    public HashMap hashMapListBox(String tableName, String idValue, String showName);

    //java.util.HashMap getHashMapListBox(String listBox);
}
