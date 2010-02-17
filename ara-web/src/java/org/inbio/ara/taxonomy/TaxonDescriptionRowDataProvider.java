/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Naciona de Biodiversidad)
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
 * TaxonDescriptionRowDataProvider.java
 *
 * Created on February 5, 2008, 11:55 AM
 * Modified on October 22, 2009 12.24
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.taxonomy;

import com.sun.data.provider.impl.ObjectListDataProvider;

/**
 *
 * @author roaguilar
 */
public class TaxonDescriptionRowDataProvider extends ObjectListDataProvider{

    /** Creates a new instance of TaxonDescriptionRowDataProvider */
    public TaxonDescriptionRowDataProvider() {
        this.setObjectType(TaxonDescriptionRow.class);
        refreshDataList(0L, 0L, 0L);
    }

    public TaxonDescriptionRowDataProvider(Long categoryId, Long taxonId,
            Long taxonDescriptionSequence) {
        this.setObjectType(TaxonDescriptionRow.class);
        refreshDataList(categoryId, taxonId, taxonDescriptionSequence);
    }

    /**
     * Metodo bebe ser sobreescrito por la clase privada que extienda this
     * @param categoryId
     * @param taxonId
     * @param taxonDescriptionSequenceId
     */
    public void refreshDataList
            (Long categoryId, Long taxonId, Long taxonDescriptionSequenceId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
