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
 * SearchManagerRemote.java
 *
 * Created on 4 de febrero de 2008, 03:30 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.util;

import java.util.Hashtable;
import java.util.List;
import javax.ejb.Remote;
import org.inbio.ara.persistence.genericEntity;

/**
 *
 * @author herson
 */
@Remote
public interface SearchManagerRemote {
    /**
     */
    <T extends genericEntity> java.util.List makeQuery(Class<T> clazz, Hashtable parameters);

    public <T extends genericEntity> List makePaginatedQuery(int firstResult, int maxResults, Class<T> clazz, Hashtable parameters);
    public <T extends genericEntity> Long countResult(Class<T> clazz, Hashtable parameters);
    
}
