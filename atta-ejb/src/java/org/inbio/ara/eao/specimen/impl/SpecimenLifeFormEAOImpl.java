/*
 *  Ara - Capture Species and Specimen Data
 *
 * Copyright © 2009  INBio (Instituto Nacional de Biodiversidad).
 * Heredia, Costa Rica.
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

package org.inbio.ara.eao.specimen.impl;

import javax.ejb.Stateless;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.eao.identification.IdentificationEAOLocal;
import org.inbio.ara.eao.specimen.SpecimenLifeFormEAOLocal;
import org.inbio.ara.persistence.specimen.SpecimenLifeForm;
import org.inbio.ara.persistence.specimen.SpecimenLifeFormPK;

/**
 *
 * @author herson
 */
@Stateless
public class SpecimenLifeFormEAOImpl 
        extends BaseEAOImpl<SpecimenLifeForm, SpecimenLifeFormPK>
        implements SpecimenLifeFormEAOLocal {

 
}
