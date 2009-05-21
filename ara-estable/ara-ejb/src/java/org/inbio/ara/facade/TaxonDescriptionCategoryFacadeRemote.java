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
 * TaxonDescriptionCategoryFacadeRemote.java
 *
 * Created on January 31, 2008, 2:51 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade;

import java.util.List;
import javax.ejb.Remote;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionCategory;

/**
 *
 * @author roaguilar
 */
@Remote
public interface TaxonDescriptionCategoryFacadeRemote {
    void create(TaxonDescriptionCategory taxonDescriptionCategory);
    
    void edit(TaxonDescriptionCategory taxonDescriptionCategory);
    
    void destroy(TaxonDescriptionCategory taxonDescriptionCategory);
    
    TaxonDescriptionCategory find(Object pk);
    
    List findAll();
    
    java.util.List getCategories();

    List getChilds(Long i);

    org.inbio.ara.persistence.taxonomy.TaxonDescriptionCategory getTaxonDescriptionCategory(Long id);

    java.lang.String getMessage();
    
}
