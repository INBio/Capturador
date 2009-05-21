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
 * ReferenceLocal.java
 *
 * Created on 20 de noviembre de 2007, 10:47 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.reference;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author herson
 */
@Local
public interface ReferenceLocal {
    /**
     * Use this method to get all the References existing in the database.
     * 
     * @return A List of Reference entities.
     */
    List findAll();

    String getMessage();

    java.util.List getReferenceElementList();

    org.inbio.ara.persistence.reference.Reference getReference();

    java.lang.String getReferenceElementValue(Long ReferenceId, Long ElementId);

    boolean updateReferenceElementValue(Long referenceId, Long elementId, String contents, String createdBy, String modifiedBy);
    
}
