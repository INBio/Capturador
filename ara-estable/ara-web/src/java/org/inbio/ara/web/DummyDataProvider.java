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
 * DummyDataProvider.java
 *
 * Created on March 29, 2008, 2:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.web;

import com.sun.data.provider.impl.ObjectListDataProvider;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mvargas
 */
public class DummyDataProvider extends ObjectListDataProvider {
    private List smallSpeciesList = new ArrayList();
    
    /** Creates a new instance of DummyDataProvider */
    public DummyDataProvider() {
        setObjectType(SmallSpecies.class);
        
//        smallSpeciesList.add(new SmallSpecies(new Long(1), "Uno"));
//        smallSpeciesList.add(new SmallSpecies(new Long(2), "Dos"));
//        smallSpeciesList.add(new SmallSpecies(new Long(3), "Tres"));
        
        this.setList(smallSpeciesList);        
    }
    
}
