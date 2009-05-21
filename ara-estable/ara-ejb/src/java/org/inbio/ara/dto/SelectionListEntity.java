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

package org.inbio.ara.dto;

import org.inbio.ara.persistence.selectionListEntity;
import org.inbio.ara.persistence.specimen.ComponentPart;
import org.inbio.ara.persistence.gathering.GatheringObservationMethod;
import org.inbio.ara.persistence.gathering.Exposition;
import org.inbio.ara.persistence.gathering.SamplingType;
import org.inbio.ara.persistence.specimen.ExtractionType;
import org.inbio.ara.persistence.specimen.IdentificationType;
import org.inbio.ara.persistence.specimen.LifeForm;
import org.inbio.ara.persistence.specimen.LifeStage;
import org.inbio.ara.persistence.specimen.Origin;
import org.inbio.ara.persistence.specimen.PreservationMedium;
import org.inbio.ara.persistence.specimen.PreparationMethod;
import org.inbio.ara.persistence.specimen.Sex;

import org.inbio.ara.persistence.specimen.SpecimenType;
import org.inbio.ara.persistence.specimen.StorageType;
import org.inbio.ara.persistence.specimen.Substrate;
import org.inbio.ara.persistence.taxonomy.TaxonAuthorConnector;
import org.inbio.ara.persistence.specimen.TypeSpecimenType;
import org.inbio.ara.persistence.species.InteractionType;
import org.inbio.ara.persistence.species.GeographicCatalogue;
import org.inbio.ara.persistence.reference.ReferenceType;
import org.inbio.ara.persistence.gis.SiteCalculationMethod;
import org.inbio.ara.persistence.specimen.SpecimenCategory;


/**
 *
 * Esta clase esta hecha para poder llegarle desde el Objeto ListTable a las
 * distintas listas de selección pues por ahora es bastante complejo ya que el
 * Objeto ListTable responde uno a uno a la tabla de la base de datos y con esa
 * no basta, pues no hay manera de saber cual es la clase(Entity) que tiene los
 * values de cada una de las listas de seleccion
 *
 * @author jgutierrez
 */
public enum SelectionListEntity {
    /*
    GATHERING_METHOD_OBSERVATION(1, new GatheringObservationMethod().getClass().getName()),
    SPECIMEN_TYPE(3, new SpecimenType().getClass().getName()),
    SPECIMEN_ORIGIN(4, new Origin().getClass().getName()),
    PRESERVATION_METHOD(5, new PreservationMedium().getClass().getName()),
    STORAGE_TYPE(6, new StorageType().getClass().getName()),
    STAGE(7, new LifeStage().getClass().getName()),
    SEX(8, new Sex().getClass().getName()),
    SUBSTRATE(9, new Substrate().getClass().getName()),
    IDENTIFICATION_TYPE(10, new IdentificationType().getClass().getName()),
    LIFE_FORM(11,new LifeForm().getClass().getName()),
    EXTRACTION_TYPE(13, new ExtractionType().getClass().getName()),
    COMPONENT_PART(14, new ComponentPart().getClass().getName()),
    PREPARATION_METHOD(17, new PreparationMethod().getClass().getName()),
    SAMPLING_TYPE(18, new SamplingType().getClass().getName()),
    TAXON_AUTHOR_CONNECTOR(19, new TaxonAuthorConnector().getClass().getName()),
    TYPE_SPECIMEN_TYPE(20, new TypeSpecimenType().getClass().getName()),
    REFERENCE_TYPE(21, new ReferenceType().getClass().getName()),
    SITE_CALCULATION_METHOD(22, new SiteCalculationMethod().getClass().getName()),
    EXPOSITION(23, new Exposition().getClass().getName()),
    INTERACTION_TYPE(24, new InteractionType().getClass().getName()),
    GEOGRAPHIC_CATALOGUE(25, new GeographicCatalogue().getClass().getName());
     */
    GATHERING_METHOD_OBSERVATION(1, new GatheringObservationMethod(), true),
    SPECIMEN_CATEGORY(2, new SpecimenCategory(), false),
    SPECIMEN_TYPE(3, new SpecimenType(), true),
    SPECIMEN_ORIGIN(4, new Origin(), true),
    PRESERVATION_METHOD(5, new PreservationMedium(), true),
    STORAGE_TYPE(6, new StorageType(), true),
    STAGE(7, new LifeStage(), true),
    SEX(8, new Sex(), true),
    SUBSTRATE(9, new Substrate(), true),
    IDENTIFICATION_TYPE(10, new IdentificationType(), true),
    LIFE_FORM(11,new LifeForm(), true),
    EXTRACTION_TYPE(13, new ExtractionType(), true),
    COMPONENT_PART(14, new ComponentPart(), true),
    PREPARATION_METHOD(17, new PreparationMethod(), true),
    SAMPLING_TYPE(18, new SamplingType(), true),
    TAXON_AUTHOR_CONNECTOR(19, new TaxonAuthorConnector(), true),
    TYPE_SPECIMEN_TYPE(20, new TypeSpecimenType(), true),
    REFERENCE_TYPE(21, new ReferenceType(), true),
    SITE_CALCULATION_METHOD(22, new SiteCalculationMethod(), true),
    EXPOSITION(23, new Exposition(), true),
    INTERACTION_TYPE(24, new InteractionType(), true),
    GEOGRAPHIC_CATALOGUE(25, new GeographicCatalogue(), true);

    /* Class name of the entity maped with the selection list table */
    private int id;
    private selectionListEntity implementation;
    private boolean editable;
    //public String selectionlistClassName;

    /**
	 * @param id
	 * @param implementation
	 */
	private SelectionListEntity(int id, selectionListEntity implementation, boolean editable) {
		this.id = id;
		this.implementation = implementation;
        this.editable = editable;
	}

    /**
	 *
	 * @param selectionlistClassName
	 * @return
	 */
	public static SelectionListEntity getByName(String selectionlistClassName){
		SelectionListEntity[] all = SelectionListEntity.values();
		for(SelectionListEntity sle: all){
			if (sle.getSelectionlistClassName().compareTo(selectionlistClassName) == 0)
				return sle;
		}
		return null;
	}

	/**
	 *
	 * @param id
	 * @return
	 */
	public static SelectionListEntity getById(int id){

        SelectionListEntity[] all = SelectionListEntity.values();
		for(SelectionListEntity sle: all){
			if (sle.getId() == id)
				return sle;
		}
		return null;
        
	}


    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the selectionlistClassName
     */
    public String getSelectionlistClassName() {
        return implementation.getClass().getName();
        //return selectionlistClassName;
    }

    /**
     * @return the implementation
     */
    public selectionListEntity getImplementation() {
        return implementation;
    }

    /**
     * @param implementation the implementation to set
     */
    public void setImplementation(selectionListEntity implementation) {
        this.implementation = implementation;
    }

    /**
     * @return the editable
     */
    public boolean isEditable() {
        return editable;
    }

    /**
     * @param editable the editable to set
     */
    public void setEditable(boolean editable) {
        this.editable = editable;
    }

}
