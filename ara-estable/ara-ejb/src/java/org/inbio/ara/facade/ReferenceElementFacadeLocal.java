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
 * ReferenceElementFacadeLocal.java
 *
 * Created on July 16, 2007, 11:37 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade;

import java.util.List;
import javax.ejb.Local;
//import org.inbio.ara.persistence.entity.ReferenceElement;
import org.inbio.ara.persistence.reference.ReferenceElement;

/**
 *
 * @author jgutierrez
 */
@Local
public interface ReferenceElementFacadeLocal {
    void create(ReferenceElement referenceElement);

    void edit(ReferenceElement referenceElement);

    void destroy(ReferenceElement referenceElement);

    ReferenceElement find(Object pk);

    List findAll();
    
}
