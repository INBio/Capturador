/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.inventory;

import org.inbio.ara.persistence.SelectionListGenericEntity;
import org.inbio.ara.persistence.gathering.Exposition;
import org.inbio.ara.persistence.gathering.GatheringObservationMethod;
import org.inbio.ara.persistence.specimen.SpecimenCategory;
import org.inbio.ara.persistence.specimen.SpecimenType;
import org.inbio.ara.persistence.specimen.Origin;
import org.inbio.ara.persistence.specimen.PreservationMedium;
import org.inbio.ara.persistence.specimen.StorageType;
import org.inbio.ara.persistence.specimen.LifeStage;
import org.inbio.ara.persistence.specimen.Sex;
import org.inbio.ara.persistence.specimen.Substrate;
import org.inbio.ara.persistence.gathering.ExtractionType;
import org.inbio.ara.persistence.germoplasma.CropSystem;
import org.inbio.ara.persistence.germoplasma.CropType;
import org.inbio.ara.persistence.germoplasma.CultivationPractice;
import org.inbio.ara.persistence.germoplasma.GatheringSource;
import org.inbio.ara.persistence.germoplasma.MaterialType;
import org.inbio.ara.persistence.germoplasma.SampleStatus;
import org.inbio.ara.persistence.germoplasma.SoilColor;
import org.inbio.ara.persistence.germoplasma.SoilTexture;
import org.inbio.ara.persistence.specimen.LifeForm;

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
    //EXIFMetadataExtractorDAOImpl.class.getName()
    GATHERING_METHOD_OBSERVATION(new Long(1), new GatheringObservationMethod(), true,"sle_gathering_method_observation", GatheringObservationMethod.class.getName()),
    SPECIMEN_CATEGORY(new Long(2), new SpecimenCategory(), false,"sle_specimen_category", SpecimenCategory.class.getName()),
    SPECIMEN_TYPE(new Long(3), new SpecimenType(), true,"sle_specimen_type",SpecimenType.class.getName()),
    ORIGIN(new Long(4), new Origin(), true,"sle_origin",Origin.class.getName()),
    PRESERVATION_MEDIUM(new Long(5), new PreservationMedium(), true,"sle_preservation_medium",PreservationMedium.class.getName()),
    STORAGE_TYPE(new Long(6), new StorageType(), true,"sle_storage_type",StorageType.class.getName()),
    LIFE_STAGE(new Long(7), new LifeStage(), true,"sle_life_stage",LifeStage.class.getName()),
    SEX(new Long(8), new Sex(), true,"sle_sex",Sex.class.getName()),
    SUBSTRATE(new Long(9), new Substrate(), true,"sle_substrate",Substrate.class.getName()),
    /*
    IDENTIFICATION_TYPE(10, new IdentificationType(), true),
     */
    LIFE_FORM(new Long(11),new LifeForm(), true,"sle_life_form",LifeForm.class.getName()),
    EXTRACTION_TYPE(new Long(13), new ExtractionType(), true,"sle_extraction_type",ExtractionType.class.getName()),
    /*
    COMPONENT_PART(14, new ComponentPart(), true),
    PREPARATION_METHOD(17, new PreparationMethod(), true),
    SAMPLING_TYPE(18, new SamplingType(), true),
    TAXON_AUTHOR_CONNECTOR(19, new TaxonAuthorConnector(), true),
    TYPE_SPECIMEN_TYPE(20, new TypeSpecimenType(), true),
    REFERENCE_TYPE(21, new ReferenceType(), true),
    SITE_CALCULATION_METHOD(22, new SiteCalculationMethod(), true),*/
    EXPOSITION(new Long(23), new Exposition(), true,"sle_exposition",Exposition.class.getName()),
    /*INTERACTION_TYPE(24, new InteractionType(), true),
    GEOGRAPHIC_CATALOGUE(25, new GeographicCatalogue(), true)
     */
    MATERIAL_TYPE(new Long(27), new MaterialType(), true,"sle_material_type",MaterialType.class.getName()),
    CROP_SYSTEM(new Long(28), new CropSystem(), true,"sle_crop_system",CropSystem.class.getName()),
    CROP_TYPE(new Long(29), new CropType(), true,"sle_crop_type",CropType.class.getName()),
    CULTIVATION_PRACTICE(new Long(30), new CultivationPractice(), true,"sle_cultivation_practice",CultivationPractice.class.getName()),
    GATHERING_SOURCE(new Long(31), new GatheringSource(), true,"sle_gathering_source",GatheringSource.class.getName()),
    SAMPLE_STATUS(new Long(32), new SampleStatus(), true,"sle_sample_status",SampleStatus.class.getName()),
    SOIL_COLOR(new Long(33), new SoilColor(), true,"sle_soil_color",SoilColor.class.getName()),
    SOIL_TEXTURE(new Long(34), new SoilTexture(), true,"sle_soil_texture",SoilTexture.class.getName())
    ;

    /* Class name of the entity maped with the selection list table */
    private Long id;
    private SelectionListGenericEntity implementation;
    private boolean editable;
    private String nameAsProperty; //this property should be resolved in the properties file for web display
    private String selectionListGenericEntityClass;


    /**
	 * @param id
	 * @param implementation
	 */
	private SelectionListEntity(Long id, SelectionListGenericEntity implementation, boolean editable, String nameAsProperty,String selectionListGenericEntityClass) {
		this.id = id;
		this.implementation = implementation;
        this.editable = editable;
        this.nameAsProperty = nameAsProperty;
        this.selectionListGenericEntityClass =selectionListGenericEntityClass;
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

    public SelectionListGenericEntity getImplementationEntity() throws IllegalArgumentException{
		try {
			return (SelectionListGenericEntity) Class.forName(this.selectionListGenericEntityClass).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new IllegalArgumentException(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new IllegalArgumentException(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new IllegalArgumentException(e.getMessage());
		}
	}


    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the selectionlistClassName
     * @deprecated
     * @use getSelectionListGenericEntityClass()
     */
    public String getSelectionlistClassName() {
        return implementation.getClass().getName();
        //return selectionlistClassName;
    }

    /**
     * @return the implementation
     * @deprecated
     * @use getImplementationEntity()
     */
    public SelectionListGenericEntity getImplementation() {
        return implementation;
    }

    /**
     * @param implementation the implementation to set
     */
    public void setImplementation(SelectionListGenericEntity implementation) {
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

    /**
     * @return the nameAsProperty
     */
    public String getNameAsProperty() {
        return nameAsProperty;
    }

    /**
     * @param nameAsProperty the nameAsProperty to set
     */
    public void setNameAsProperty(String nameAsProperty) {
        this.nameAsProperty = nameAsProperty;
    }

    /**
     * @return the selectionListGenericEntityClass
     */
    public String getSelectionListGenericEntityClass() {
        return selectionListGenericEntityClass;
    }

    /**
     * @param selectionListGenericEntityClass the selectionListGenericEntityClass to set
     */
    public void setSelectionListGenericEntityClass(String selectionListGenericEntityClass) {
        this.selectionListGenericEntityClass = selectionListGenericEntityClass;
    }

}