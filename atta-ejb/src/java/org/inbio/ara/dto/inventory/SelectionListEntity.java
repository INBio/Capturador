/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.inventory;

import org.hibernate.type.CollectionType;
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
import org.inbio.ara.persistence.germplasm.AccessionMovementType;
import org.inbio.ara.persistence.germplasm.CropSystem;
import org.inbio.ara.persistence.germplasm.CropType;
import org.inbio.ara.persistence.germplasm.CultivationPractice;
import org.inbio.ara.persistence.germplasm.GatheringSource;
import org.inbio.ara.persistence.germplasm.GerminationMethodType;
import org.inbio.ara.persistence.germplasm.MaterialType;
import org.inbio.ara.persistence.germplasm.MoistureMethodType;
import org.inbio.ara.persistence.germplasm.SampleStatus;
import org.inbio.ara.persistence.germplasm.SoilColor;
import org.inbio.ara.persistence.germplasm.SoilTexture;
import org.inbio.ara.persistence.specimen.LifeForm;
import org.inbio.ara.persistence.germplasm.Solvent;
import org.inbio.ara.persistence.germplasm.SemenGatheringMethod;
import org.inbio.ara.persistence.germplasm.Condition;
import org.inbio.ara.persistence.germplasm.SemenConsistency;
import org.inbio.ara.persistence.indicator.ComponentPart;
import org.inbio.ara.persistence.samplemanage.ForestType;
import org.inbio.ara.persistence.samplemanage.MicroFome;
import org.inbio.ara.persistence.samplemanage.MicroMethod;
import org.inbio.ara.persistence.samplemanage.MicroQuality;
import org.inbio.ara.persistence.samplemanage.MicroSourceType;
import org.inbio.ara.persistence.samplemanage.Permission;
import org.inbio.ara.persistence.samplemanage.SampleClass;
import org.inbio.ara.persistence.samplemanage.VegetationType;
import org.inbio.ara.persistence.samplemanage.VerticalStrata;
import org.inbio.ara.persistence.taxonomy.TaxonAuthorConnector;
import org.inbio.ara.persistence.transaction.TransactedSpecimenStatus;
import org.inbio.ara.persistence.transaction.TransactionType;
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
    GATHERING_METHOD_OBSERVATION(new Long(29), new GatheringObservationMethod(), true,"sle_gathering_method_observation", GatheringObservationMethod.class.getName()),
    SPECIMEN_CATEGORY(new Long(36), new SpecimenCategory(), false,"sle_specimen_category", SpecimenCategory.class.getName()),
    SPECIMEN_TYPE(new Long(37), new SpecimenType(), true,"sle_specimen_type",SpecimenType.class.getName()),
    ORIGIN(new Long(42), new Origin(), true,"sle_origin",Origin.class.getName()),
    PRESERVATION_MEDIUM(new Long(44), new PreservationMedium(), true,"sle_preservation_medium",PreservationMedium.class.getName()),
    STORAGE_TYPE(new Long(40), new StorageType(), true,"sle_storage_type",StorageType.class.getName()),
    LIFE_STAGE(new Long(43), new LifeStage(), true,"sle_life_stage",LifeStage.class.getName()),
    SEX(new Long(41), new Sex(), true,"sle_sex",Sex.class.getName()),
    SUBSTRATE(new Long(134), new Substrate(), true,"sle_substrate",Substrate.class.getName()),
    /*
    IDENTIFICATION_TYPE(10, new IdentificationType(), true),
     */
    LIFE_FORM(new Long(38),new LifeForm(), true,"sle_life_form",LifeForm.class.getName()),
    EXTRACTION_TYPE(new Long(152), new ExtractionType(), true,"sle_extraction_type",ExtractionType.class.getName()),
    
    COMPONENT_PART(new Long(54), new ComponentPart(), true, "sle_component_part", ComponentPart.class.getName()),
    /*
    PREPARATION_METHOD(17, new PreparationMethod(), true),
    SAMPLING_TYPE(18, new SamplingType(), true),
     */
    TAXON_AUTHOR_CONNECTOR(new Long(132), new TaxonAuthorConnector(), true, "sle_taxon_author_connector", TaxonAuthorConnector.class.getName()),
    /*
    TYPE_SPECIMEN_TYPE(20, new TypeSpecimenType(), true),
    REFERENCE_TYPE(21, new ReferenceType(), true),
    SITE_CALCULATION_METHOD(22, new SiteCalculationMethod(), true),*/
    EXPOSITION(new Long(154), new Exposition(), true,"sle_exposition",Exposition.class.getName()),
    /*INTERACTION_TYPE(24, new InteractionType(), true),
    GEOGRAPHIC_CATALOGUE(25, new GeographicCatalogue(), true)
     */
    MATERIAL_TYPE(new Long(155), new MaterialType(), true,"sle_material_type",MaterialType.class.getName()),
    CROP_SYSTEM(new Long(156), new CropSystem(), true,"sle_crop_system",CropSystem.class.getName()),
    CROP_TYPE(new Long(157), new CropType(), true,"sle_crop_type",CropType.class.getName()),
    CULTIVATION_PRACTICE(new Long(158), new CultivationPractice(), true,"sle_cultivation_practice",CultivationPractice.class.getName()),
    GATHERING_SOURCE(new Long(159), new GatheringSource(), true,"sle_gathering_source",GatheringSource.class.getName()),
    SAMPLE_STATUS(new Long(160), new SampleStatus(), true,"sle_sample_status",SampleStatus.class.getName()),
    SOIL_COLOR(new Long(161), new SoilColor(), true,"sle_soil_color",SoilColor.class.getName()),
    SOIL_TEXTURE(new Long(162), new SoilTexture(), true,"sle_soil_texture",SoilTexture.class.getName()),

    GERMINATION_METHOD_TYPE(new Long(163), new GerminationMethodType(), true,"sle_germination_method_type",GerminationMethodType.class.getName()),
    COLLECTION_TYPE(new Long(164), new org.inbio.ara.persistence.germplasm.CollectionType(), true,"sle_collection_type",org.inbio.ara.persistence.germplasm.CollectionType.class.getName()),
    MOISTURE_METHOD_TYPE(new Long(165), new MoistureMethodType(), true,"sle_moisture_method_type",MoistureMethodType.class.getName()),
    ACCESSION_MOVEMENT_TYPE(new Long(166), new AccessionMovementType(), true,"sle_accession_movement_type",MoistureMethodType.class.getName()),

    CONDITION(new Long(167), new Condition(), true,"sle_condition",Condition.class.getName()),
    SEMEN_GATHERING_METHOD(new Long(168), new SemenGatheringMethod(), true,"sle_semen_gathering_method",SemenGatheringMethod.class.getName()),
    SOLVENT(new Long(169), new Solvent(), true,"sle_solvent",Solvent.class.getName()),
    
    /* MODULO DE TRANSACCIONES */
    TRANSACTION_TYPE(new Long(170),new TransactionType(),true,"sle_transaction_type",TransactionType.class.getName()),
    TRANSACTED_SPECIMEN_STATUS(new Long(171),new TransactedSpecimenStatus(),true,"sle_transacted_specimen_status",TransactedSpecimenStatus.class.getName()),
    /* FIN MODULO DE TRANSACCIONES */

    /*Agregados al modulo de semen*/
    SEMEN_CONSISTENCY(new Long(172),new SemenConsistency(),true,"sle_semen_consistency",SemenConsistency.class.getName()),
    /*fin de los agregados*/

    /*MODULO DE MANEJO DE MUESTRAS*/
    SAMPLE_CLASS(new Long(172),new SampleClass(),true,"sle_sample_class",SampleClass.class.getName()),
    PERMISSION(new Long(173),new Permission(),true,"sle_permission",Permission.class.getName()),
    MICRO_SOURCE_TYPE(new Long(174),new MicroSourceType(),true,"sle_micro_source_type",MicroSourceType.class.getName()),
    MICRO_METHOD(new Long(175),new MicroMethod(),true,"sle_micro_method",MicroMethod.class.getName()),
    MICRO_FOME(new Long(176),new MicroFome(),true,"sle_micro_fome",MicroFome.class.getName()),
    MICRO_QUALITY(new Long(177),new MicroQuality(),true,"sle_micro_quality",MicroQuality.class.getName()),
    FOREST_TYPE(new Long(178),new ForestType(),true,"sle_forest_type",ForestType.class.getName()),
    VERTICAL_STRATA(new Long(179),new VerticalStrata(),true,"sle_vertical_strata",VerticalStrata.class.getName()),
    VEGETATION_TYPE(new Long(180),new VegetationType(),true,"sle_vegetation_type",VegetationType.class.getName()),
    /*FIN MODULO DE MANEJO DE MUESTRAS*/
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
    private SelectionListEntity(Long id, SelectionListGenericEntity implementation, boolean editable, String nameAsProperty, String selectionListGenericEntityClass) {
        this.id = id;
        this.implementation = implementation;
        this.editable = editable;
        this.nameAsProperty = nameAsProperty;
        this.selectionListGenericEntityClass = selectionListGenericEntityClass;
    }

    /**
     *
     * @param selectionlistClassName
     * @return
     */
    public static SelectionListEntity getByName(String selectionlistClassName) {
        SelectionListEntity[] all = SelectionListEntity.values();
        for (SelectionListEntity sle : all) {
            if (sle.getSelectionlistClassName().compareTo(selectionlistClassName) == 0) {
                return sle;
            }
        }
        return null;
    }

    /**
     *
     * @param id
     * @return
     */
    public static SelectionListEntity getById(int id) {

        SelectionListEntity[] all = SelectionListEntity.values();
        for (SelectionListEntity sle : all) {
            if (sle.getId() == id) {
                return sle;
            }
        }
        return null;

    }

    public SelectionListGenericEntity getImplementationEntity() throws IllegalArgumentException {
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