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
 * StageTransitionDigraphRemote.java
 *
 * Created on 2 de abril de 2008, 09:14 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.species;

import java.util.List;
import javax.ejb.Remote;
import org.inbio.ara.persistence.species.StageTransitionDigraph;


/**
 *
 * @author herson
 */
@Remote
public interface StageTransitionDigraphRemote {
    String getMessage();

    void save(List<StageTransitionDigraph> list, long selected);

    /**
     * 
     * 
     * @param id Estado
     * @return List Estados a los que puedo ir (to) desde "Estado"
     */
    java.util.List getToList(Long id);

    /**
     * 
     * 
     * @param id Estado
     * @return List Estados desde (from) los que puedo ir a "Estado"
     */
    java.util.List getFromList(Long id);

}
