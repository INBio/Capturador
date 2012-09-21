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
package org.inbio.ara.facade.inventory.impl;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.inbio.ara.dto.agent.CollectionDTO;
import org.inbio.ara.dto.agent.CollectionDTOFactory;
import org.inbio.ara.dto.agent.InstitutionDTOFactory;
import org.inbio.ara.dto.agent.ProfileDTOFactory;
import org.inbio.ara.dto.inventory.GatheringObservationDTO;
import org.inbio.ara.dto.inventory.GatheringObservationDTOFactory;
import org.inbio.ara.dto.inventory.GatheringObservationDetailDTO;
import org.inbio.ara.dto.inventory.GatheringObservationDetailDTOFactory;
import org.inbio.ara.dto.inventory.IdentificationDTO;
import org.inbio.ara.dto.inventory.IdentificationDTOFactory;
import org.inbio.ara.dto.inventory.IdentificationHistoryDTOFactory;
import org.inbio.ara.dto.inventory.IdentificationStatusDTO;
import org.inbio.ara.dto.inventory.IdentificationStatusDTOFactory;
import org.inbio.ara.dto.inventory.IdentificationTypeDTO;
import org.inbio.ara.dto.inventory.IdentificationTypeDTOFactory;
import org.inbio.ara.dto.inventory.IdentifierDTO;
import org.inbio.ara.dto.inventory.IdentifierHistoryDTOFactory;
import org.inbio.ara.dto.inventory.LifeStageSexDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.dto.inventory.PersonDTOFactory;
import org.inbio.ara.dto.inventory.ProjectDTO;
import org.inbio.ara.dto.inventory.ProjectDTOFactory;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.dto.inventory.SelectionListDTOFactory;
import org.inbio.ara.dto.inventory.SpecimenDTO;
import org.inbio.ara.dto.inventory.SpecimenDTOFactory;
import org.inbio.ara.dto.inventory.TaxonCategoryDTO;
import org.inbio.ara.dto.inventory.TaxonCategoryDTOFactory;
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.dto.inventory.TaxonDTOFactory;
import org.inbio.ara.dto.inventory.TaxonomicalRangeDTO;
import org.inbio.ara.dto.inventory.TaxonomicalRangeDTOFactory;
import org.inbio.ara.eao.agent.InstitutionEAOLocal;
import org.inbio.ara.eao.agent.PersonEAOLocal;
import org.inbio.ara.eao.agent.PersonInstitutionEAOLocal;
import org.inbio.ara.eao.agent.PersonProfileEAOLocal;
import org.inbio.ara.eao.agent.ProfileEAOLocal;
import org.inbio.ara.eao.collection.CollectionEAOLocal;
import org.inbio.ara.eao.gathering.CollectionProtocolEAOLocal;
import org.inbio.ara.eao.gathering.CollectorObserverEAOLocal;
import org.inbio.ara.eao.gathering.GatheringObservationCollectionEAOLocal;
import org.inbio.ara.eao.gathering.GatheringObservationDetailEAOLocal;
import org.inbio.ara.eao.gathering.GatheringObservationEAOLocal;
import org.inbio.ara.eao.gathering.GatheringObservationProjectEAOLocal;
import org.inbio.ara.eao.gathering.MorphologicalDescriptionEAOLocal;
import org.inbio.ara.eao.gathering.ProjectEAOLocal;
import org.inbio.ara.eao.gis.CountryEAOLocal;
import org.inbio.ara.eao.gis.ProvinceEAOLocal;
import org.inbio.ara.eao.identification.IdentifierEAOLocal;
import org.inbio.ara.eao.identification.IdentificationEAOLocal;
import org.inbio.ara.eao.identification.IdentificationHistoryEAOLocal;
import org.inbio.ara.eao.identification.IdentificationStatusEAOLocal;
import org.inbio.ara.eao.identification.IdentificationTypeEAOLocal;
import org.inbio.ara.eao.identification.IdentifierHistoryEAOLocal;
import org.inbio.ara.eao.specimen.SpecimenEAOLocal;
import org.inbio.ara.eao.specimen.SpecimenLifeStageSexEAOLocal;
import org.inbio.ara.eao.taxonomy.TaxonomicalRangeEAOLocal;
import org.inbio.ara.eao.selectionlist.SelectionListValueLocalEAO;
import org.inbio.ara.eao.specimen.SpecimenLifeFormEAOLocal;
import org.inbio.ara.eao.taxonomy.TaxonCategoryEAOLocal;
import org.inbio.ara.eao.taxonomy.TaxonEAOLocal;
import org.inbio.ara.facade.inventory.InventoryFacadeRemote;
import org.inbio.ara.persistence.SelectionListGenericEntity;
import org.inbio.ara.persistence.collection.Collection;
import org.inbio.ara.persistence.gathering.CollectionProtocol;
import org.inbio.ara.persistence.gathering.CollectionProtocolValuesEntity;
import org.inbio.ara.persistence.gathering.CollectorObserver;
import org.inbio.ara.persistence.gathering.CollectorObserverPK;
import org.inbio.ara.persistence.gathering.GatheringObservation;
import org.inbio.ara.persistence.gathering.GatheringObservationCollection;
import org.inbio.ara.persistence.gathering.GatheringObservationCollectionPK;
import org.inbio.ara.persistence.gathering.GatheringObservationDetail;
import org.inbio.ara.persistence.gathering.GatheringObservationProject;
import org.inbio.ara.persistence.gathering.GatheringObservationProjectPK;
import org.inbio.ara.persistence.gathering.MorphologicalDescription;
import org.inbio.ara.persistence.gathering.ProtocolAtributeEntity;
import org.inbio.ara.persistence.gis.Country;
import org.inbio.ara.persistence.gis.Province;
import org.inbio.ara.persistence.gis.Site;
import org.inbio.ara.persistence.person.Person;
import org.inbio.ara.persistence.person.ProfileEntity;
import org.inbio.ara.persistence.specimen.Specimen;
import org.inbio.ara.persistence.specimen.SpecimenLifeStageSex;
import org.inbio.ara.persistence.specimen.SpecimenLifeStageSexPK;
import org.inbio.ara.persistence.identification.Identification;
import org.inbio.ara.persistence.identification.IdentificationHistory;
import org.inbio.ara.persistence.identification.IdentificationPK;
import org.inbio.ara.persistence.identification.IdentificationStatus;
import org.inbio.ara.persistence.identification.IdentificationType;
import org.inbio.ara.persistence.identification.Identifier;
import org.inbio.ara.persistence.identification.IdentifierHistory;
import org.inbio.ara.persistence.identification.IdentifierPK;
import org.inbio.ara.persistence.specimen.SpecimenCategoryEntity;
import org.inbio.ara.persistence.specimen.SpecimenLifeForm;
import org.inbio.ara.persistence.taxonomy.Taxon;
import org.inbio.ara.persistence.taxonomy.TaxonCategory;
import org.inbio.ara.persistence.taxonomy.TaxonomicalRange;

/**
 *
 * @author jgutierrez
 */
@Stateless
public class InventoryFacadeImpl implements InventoryFacadeRemote {

    // <editor-fold defaultstate="collapsed" desc="EAO's">
    @EJB
    private SpecimenEAOLocal specimenEAOImpl;
    @EJB
    private CountryEAOLocal countryEAOImpl;
    @EJB
    private ProvinceEAOLocal provinceEAOImpl;
    @EJB
    private SelectionListValueLocalEAO selectionListValueEAOImpl;
    @EJB
    private GatheringObservationEAOLocal gatheringObservationEAOImpl;
    @EJB
    private PersonEAOLocal personEAOImpl;
    @EJB
    private IdentificationEAOLocal identificationEAOImpl;
    @EJB
    private SpecimenLifeStageSexEAOLocal specimenLifeStageSexEAOImpl;
    @EJB
    private IdentificationTypeEAOLocal identificationTypeEAOImpl;
    @EJB
    private IdentificationStatusEAOLocal identificationStatusEAOImpl;
    @EJB
    private TaxonomicalRangeEAOLocal taxonomicalRangeEAOImpl;
    @EJB
    private TaxonEAOLocal taxonEAOImpl;
    @EJB
    private IdentifierEAOLocal identifierEAOImpl;
    @EJB
    private ProjectEAOLocal projectEAOImpl;
    @EJB
    private IdentificationHistoryEAOLocal identificationHistoryEAOImpl;
    @EJB
    private IdentifierHistoryEAOLocal identifierHistoryEAOImpl;
    @EJB
    private CollectionProtocolEAOLocal collectionProtocolImpl;
    @EJB
    private GatheringObservationDetailEAOLocal gatheringDetailEAOImpl;
    @EJB
    private CollectorObserverEAOLocal collectorObserverEAOImpl;
    @EJB
    private GatheringObservationCollectionEAOLocal gatheringCollectionEAOImpl;
    @EJB
    private GatheringObservationProjectEAOLocal gatheringProjectEAOImpl;
    @EJB
    private MorphologicalDescriptionEAOLocal morphologicalDescriptionEAOImpl;
    @EJB
    private CollectionEAOLocal collectionEAOImpl;
    @EJB
    private TaxonCategoryEAOLocal taxonCategoryEAOImpl;
    @EJB
    private SpecimenLifeFormEAOLocal specimenLifeFormEAOImpl;
    @EJB
    private PersonInstitutionEAOLocal personInstitutionEAOImpl;
    @EJB
    private PersonProfileEAOLocal personProfileEAOImpl;
    @EJB
    private InstitutionEAOLocal institutionEAOImpl;
    @EJB
    private ProfileEAOLocal profileEAOImpl;
    // </editor-fold>
    //DTO factories
    private SpecimenDTOFactory specimenDTOFactory = new SpecimenDTOFactory();
    private GatheringObservationDTOFactory gatheringObservationDTOFactory =
            new GatheringObservationDTOFactory();
    private SelectionListDTOFactory selecionListDTOFactory =
            new SelectionListDTOFactory();
    private IdentificationDTOFactory identificationDTOFactory =
            new IdentificationDTOFactory();
    private IdentificationTypeDTOFactory identificationTypeDTOFactory =
            new IdentificationTypeDTOFactory();
    private IdentificationStatusDTOFactory identificationStatusDTOFactory =
            new IdentificationStatusDTOFactory();
    private TaxonomicalRangeDTOFactory taxonomicalRangeDTOFactory =
            new TaxonomicalRangeDTOFactory();
    private PersonDTOFactory personDTOFactory = new PersonDTOFactory();
    private TaxonDTOFactory taxonDTOFactory = new TaxonDTOFactory();
    private ProjectDTOFactory projectDTOFactory = new ProjectDTOFactory();
    private GatheringObservationDetailDTOFactory 
            gatheringObservationDetailDTOFactory =
            new GatheringObservationDetailDTOFactory();
    private CollectionDTOFactory collectionDTOFactory =
            new CollectionDTOFactory();
    private TaxonCategoryDTOFactory taxonCategoryFactory =
            new TaxonCategoryDTOFactory();
    private InstitutionDTOFactory institutionDTOFactory =
            new InstitutionDTOFactory();
    private ProfileDTOFactory profileDTOFactoty = new ProfileDTOFactory();

    /**
     * Retorna un listado de especimenes
     * @deprecated use instead:
     * public List<SpecimenDTO> getAllSpecimenPaginated(int first,
     *      int totalResults, int collectionId)
     */
    public List<SpecimenDTO> getAllSpecimenPaginated(int first,
            int totalResults) {
        List<Specimen> sList = specimenEAOImpl.findAllPaginatedFilterAndOrderBy(Specimen.class,
                first, totalResults, null, null);
        if (sList == null)
            return null;
        List<SpecimenDTO> updated = updateCountryAndProvinceName(
                specimenDTOFactory.createDTOList(sList));
        return updateScientificName(updated);
    }

    /**
     * 
     * @param first
     * @param totalResults
     * @param collectionId
     * @return
     */
    public List<SpecimenDTO> getAllSpecimenPaginated(int first,
            int totalResults, Long collectionId) {
        String[] orderByFields = {"specimenId"};
        List<Specimen> sList = specimenEAOImpl.findAllPaginatedFilterAndOrderBy(Specimen.class,
                first, totalResults, orderByFields, collectionId);
        if (sList == null)
            return null;
        List<SpecimenDTO> updated = updateCountryAndProvinceName(
                specimenDTOFactory.createDTOList(sList));
        return updateScientificName(updated);
    }

    /**
     * To update the scientificName
     * @param list
     * @return
     */
    public List<SpecimenDTO> updateScientificName(List<SpecimenDTO> list) {
        List<SpecimenDTO> result = new ArrayList<SpecimenDTO>();
        for (SpecimenDTO dto : list) {
            String taxones = "";

            List<Identification> identificaciones = this.identificationEAOImpl.
                    findBySpecimenId(dto.getSpecimenKey());
            for (int i = 1; i <= identificaciones.size(); i++) {
                Identification aux = identificaciones.get(i - 1);
                if (i == identificaciones.size()) {
                    taxones += aux.getTaxon().getDefaultName();
                } else {
                    taxones += aux.getTaxon().getDefaultName() + " , ";
                }
            }

            dto.setTaxonName(taxones);
            result.add(dto);
        }

        return result;
    }

    /**
     * Retorna un listado de todos los detalles de recollecion para una
     * recoleccion dada
     */
    public List<GatheringObservationDetailDTO> getDetailPaginatedByGathering(
            int first, int totalResults, Long gathId) {
        List<GatheringObservationDetail> entities = gatheringDetailEAOImpl.
                getDetailPaginatedByGathering(first, totalResults, gathId);
        List<GatheringObservationDetailDTO> result = new ArrayList();
        for (GatheringObservationDetail god : entities) {
            GatheringObservationDetailDTO aux =
                    gatheringObservationDetailDTOFactory.createDTO(god);
            result.add(aux);
        }
        return result;
    }

    /**
     * Retorna un listado de la recolecciones
     * @deprecated use instead:
     * public List<GatheringObservationDTO>
     *       getAllGatheringObservationPaginated(int first, int totalResults,
     *       int collectionId)
     */
    public List<GatheringObservationDTO>
            getAllGatheringObservationPaginated(int first, int totalResults) {
        List<GatheringObservation> gList = gatheringObservationEAOImpl.findAllPaginatedFilterAndOrderBy(GatheringObservation.class,
                first, totalResults, null, null);
        if (gList == null)
            return null;
        return updateGathObsCountryAndProvinceName(
                gatheringObservationDTOFactory.createDTOList(gList));
    }

    public List<GatheringObservationDTO>
            getAllGatheringObservationPaginated(int first, int totalResults,
            Long collectionId) {
        String[] orderByFields = {"gatheringObservationId"};
        List<GatheringObservation> gList = gatheringObservationEAOImpl.
                findAllPaginatedFilterAndOrderBy(GatheringObservation.class,
                first, totalResults, orderByFields, collectionId);
        if (gList == null)
            return null;
        return updateGathObsCountryAndProvinceName(
                gatheringObservationDTOFactory.createDTOList(gList));
    }

    private SpecimenDTO updateCountryAndProvinceName(SpecimenDTO sDTO) {
        Country c;
        Province p;

        if (sDTO.getProvinceId() != null) {
            p = provinceEAOImpl.findById(Province.class, sDTO.getProvinceId());
            sDTO.setProvinceName(p.getValue());
            c = countryEAOImpl.findById(Country.class, p.getCountryId());
            sDTO.setCountryName(c.getValue());
            sDTO.setCountryId(c.getCountryId());
        } else if (sDTO.getCountryId() != null) {
            c = countryEAOImpl.findById(Country.class, sDTO.getCountryId());
            sDTO.setCountryName(c.getValue());
        }

        return sDTO;
    }

    private GatheringObservationDTO
            updateCountryAndProvinceName(GatheringObservationDTO gDTO) {
        Country c;
        Province p;

        if (gDTO.getProvinceId() != null) {
            p = provinceEAOImpl.findById(Province.class, gDTO.getProvinceId());
            gDTO.setProvinceName(p.getValue());
            c = countryEAOImpl.findById(Country.class, p.getCountryId());
            gDTO.setCountryName(c.getValue());
            gDTO.setCountryId(c.getCountryId());
        } else if (gDTO.getCountryId() != null) {
            c = countryEAOImpl.findById(Country.class, gDTO.getCountryId());
            gDTO.setCountryName(c.getValue());
        }

        return gDTO;
    }

    public List<SpecimenDTO>
            updateCountryAndProvinceName(List<SpecimenDTO> sDTOList) {

        List<SpecimenDTO> resultSpecimenDTOList = new ArrayList<SpecimenDTO>();

        for (SpecimenDTO sDTO : sDTOList) {
            resultSpecimenDTOList.add(updateCountryAndProvinceName(sDTO));
        }
        return resultSpecimenDTOList;
    }

    public List<GatheringObservationDTO> updateGathObsCountryAndProvinceName(
            List<GatheringObservationDTO> gDTOList) {
        List<GatheringObservationDTO> resultGatheringObservationDTOList =
                new ArrayList<GatheringObservationDTO>();

        for (GatheringObservationDTO gDTO : gDTOList) {
            resultGatheringObservationDTOList.
                    add(updateCountryAndProvinceName(gDTO));
        }
        return resultGatheringObservationDTOList;
    }

    public Long countSpecimens() {
        return specimenEAOImpl.count(Specimen.class);
    }

    public Long countGatheringDetail() {
        return gatheringDetailEAOImpl.count(GatheringObservationDetail.class);
    }

    /**
     * @deprecated Because this method ingnors the collectionId
     */
    public Long countGatheringObservations() {
        return gatheringObservationEAOImpl.count(GatheringObservation.class);
    }

    public Long countGatheringObservations(Long collectionId){
        return gatheringObservationEAOImpl.countByCollection(GatheringObservation.class,collectionId);
    }

    /**
     * Dice cuantos especimenes hay para una recoleccion dada
     * @param gId
     * @return
     */
    public int findSpecimensByGathObsId(Long gId) {
        List<Long> list = this.specimenEAOImpl.findByGathObsId(gId);
        if (list == null)
            return 0;
        return list.size();
    }

    /**
     * Dice cuantos detalles hay para una recoleccion dada
     * @param gId
     * @return
     */
    public int findDetailsByGathObsId(Long gId) {
        List<Long> list = this.specimenEAOImpl.findByGathObsId(gId);
        if (list == null)
            return 0;
        return list.size();
    }

    /**
     * Dice cuantos especimenes hay para un detalle de recoleccion dado
     * @param gId
     * @return
     */
    public int findSpecimensByGathObsDetailId(Long gId) {
        List<Long> list = this.gatheringDetailEAOImpl.findByGathObsDetailId(gId);
        if (list == null)
            return 0;
        return list.size();
    }

    /**
     * @param selectionListEntityId
     * @return
     */
    public List<SelectionListDTO>
            getAllSelectionListElements(Long selectionListEntityId) {
        List<SelectionListGenericEntity> slgeList = selectionListValueEAOImpl.
                findAll(selectionListEntityId);
        return this.selecionListDTOFactory.createDTOList(slgeList);
    }


/**
     * @param selectionListEntityId
     * @return
     */
    public SelectionListDTO
            getSelectionListElementById(Long selectionListEntityId, Long selectionListValueId) {
        SelectionListGenericEntity slge = selectionListValueEAOImpl.
                findById(selectionListEntityId, selectionListValueId);
        return this.selecionListDTOFactory.createDTO(slge);
    }


    /**
     * @param selectionListEntityId
     * @param collectionId
     * @return
     */
    public List<SelectionListDTO> 
            getAllSelectionListElementsByCollection(Long selectionListEntityId,
            Long collectionId) {
        List<SelectionListGenericEntity> slgeList = selectionListValueEAOImpl.
                findAllByCollectionId(selectionListEntityId, collectionId);
        return this.selecionListDTOFactory.createDTOList(slgeList);
    }

    /**
     * Method to persist a gathering detail from a specific DTO
     * @param gdDTO
     */
    public GatheringObservationDetailDTO
            saveGatheringDetail(GatheringObservationDetailDTO gdDTO) {
        //Crear descripcion  morfologica asociada
        MorphologicalDescription md = gatheringObservationDetailDTOFactory.
                createMorphologicalDescription(gdDTO);
        morphologicalDescriptionEAOImpl.create(md);

        /* Una vez que creamos la desc morpho y por ende tenemos su id, vamos a
           proceder a persistir
           el nuevo detalle de recoleccion */
        GatheringObservationDetail god = gatheringObservationDetailDTOFactory.
                createEntity(gdDTO);
        god.setMorphologicalDescription(md);
        //Actualizando el DTO
        gdDTO.setMorphologicalDescriptionId(md.getMorphologicalDescriptionId());
        //Persist
        gatheringDetailEAOImpl.create(god);
        //Actualizando el DTO
        gdDTO.setGatheringObservationDetailId(god.
                getGatheringObservationDetailId());

        return gdDTO;
    }

    /**
     * Method to get a gathering observation by a specific siteId
     * @param gdDTO
     */
    public List<GatheringObservationDTO> getGathObsBySiteId(Long siteId) {
        List<GatheringObservationDTO> gathObsDTO =
                new ArrayList<GatheringObservationDTO>();
        List<GatheringObservation> gathObsIds = gatheringObservationEAOImpl.
                findGathObsBySiteId(siteId);
        gathObsDTO = gatheringObservationDTOFactory.createDTOList(gathObsIds);
        return gathObsDTO;
    }

    /**
     * Method to update a gathering detail by a specific DTO
     * @param gdDTO
     */
    public GatheringObservationDetailDTO
            updateGatheringDetail(GatheringObservationDetailDTO gdDTO) {

        //Costruir la entidad de descripcion morfologica a partir del DTO
        MorphologicalDescription md = gatheringObservationDetailDTOFactory.
                createMorphologicalDescription(gdDTO);
        //Costruir la entidad de detalle de recolecciom a partir del DTO
        GatheringObservationDetail god = gatheringObservationDetailDTOFactory.
                createEntity(gdDTO);
        //Mantener la "liga" de las dos entidades
        god.setMorphologicalDescription(md);
        //Merge
        gatheringDetailEAOImpl.update(god);
        //Retornar el dto actualizado
        return gatheringObservationDetailDTOFactory.createDTO(god);
    }

    /**
     * Method to persist a gathering from a specific DTO
     * @param gDTO
     */
    public GatheringObservationDTO saveGathering(GatheringObservationDTO gDTO) {
        //Entidad sin listas asociadas y sin gathering id
        /*
        GatheringObservation entity = this.gatheringObservationDTOFactory.
                createSimpleEntity(gDTO);
         */
        //System.out.println("User name = "+gDTO.getUserName());
        GatheringObservation entity = this.gatheringObservationDTOFactory.
                createPlainEntity(gDTO);
        //Persisto dicha entidad y por ende se actualiza el ID asignado por el
        //secuence en BD
        this.gatheringObservationEAOImpl.create(entity);
        //Ahora seteo el DTO con el id asignado en la bd para dicha recollecion
        gDTO.setGatheringObservationId(entity.getGatheringObservationId());
        gDTO.setCollectionId(entity.getCollectionId());
        //Seteo la entidad con todos los datos (id gathering, id collection y
        //listas)
        /*
        entity = this.gatheringObservationDTOFactory.createEntity(gDTO);
        */
        entity = this.gatheringObservationDTOFactory.updatePlainEntity(gDTO, entity);
        //Persisto las listas asociadas al gathering
        this.gatheringObservationEAOImpl.update(entity);

        return gDTO; //Lo retorno pero con gathering Id
    }

    

    /**
     * Eliminar recolecciones por id
     * @param gId
     */
    public void deleteGatheringById(Long gId) {
        this.gatheringObservationEAOImpl.deleteById(gId);
    }

    /**
     * Eliminar detalles de recoleccion por id
     * @param gId
     */
    public void deleteGatheringDetailById(Long gId) {
        this.gatheringDetailEAOImpl.deleteById(gId);
    }

    /**
     * Metodo para eliminar los proyectos, colecciones y colectores
     * asociados a una recoleccion en especifico
     * @param gId identificador de la recoleccion
     */
    public void deleteAsociatedListByGatheringId(Long gId) {
        //Lista de proyectos
        gatheringProjectEAOImpl.deleteByGathering(gId);

        //Lista de colecciones asociadas
        gatheringCollectionEAOImpl.deleteByGathering(gId);

        //Lista de colectores
        collectorObserverEAOImpl.deleteByGathering(gId);
    }

    /**
     * Method to update a gathering from a specific DTO
     * @param gDTO
     */
    public void updateGathering(GatheringObservationDTO gDTO) {

        //Borrar lista de collectores, colecciones y proyectos
        deleteAsociatedListByGatheringId(gDTO.getGatheringObservationId());

        //Obtener la entidad a partir del gathering Id
        GatheringObservation entity = gatheringObservationEAOImpl.
                findById(GatheringObservation.class,
                        gDTO.getGatheringObservationId());

        //Seteo la entidad con los nuevos datos
        entity.setGatheringObservationId(gDTO.getGatheringObservationId());
        Site site = new Site();
        site.setSiteId(gDTO.getLocalityId());
        entity.setSite(site);
        entity.setInitialDate(gDTO.getInitialDateTime());
        entity.setFinalDate(gDTO.getFinalDateTime());
        entity.setResponsiblePersonId(gDTO.getResponsibleId());
        entity.setExpositionId(gDTO.getExpositionId());
        entity.setGradientPercentage(gDTO.getGradient());
        entity.setMaximumElevation(gDTO.getMaximumElevation());
        entity.setMinimumElevation(gDTO.getMinimumElevation());
        entity.setMaximumDepth(gDTO.getMaximumDepth());
        entity.setMinimumDepth(gDTO.getMinimumDepth());
        entity.setSurroundingsDescription(gDTO.getSurroundingDescription());
        entity.setSiteDescription(gDTO.getSiteDescription());
        entity.setCollectionId(gDTO.getCollectionId());

        //Nuevos valores para la lista de colectores
        List<PersonDTO> colectorDTOList = gDTO.getColectorsList();
        Long secuence = new Long(1);
        for (PersonDTO pDTO : colectorDTOList) {
            CollectorObserverPK pk = new CollectorObserverPK(gDTO.
                    getGatheringObservationId(), pDTO.getPersonKey());
            CollectorObserver newEntry = new CollectorObserver(pk);
            newEntry.setSequence(secuence);
            entity.getCollectorObserverList().add(newEntry);
            secuence++;
        }
        //Nuevos valores para la lista de colecciones asociadas
        List<CollectionDTO> collDTOList = gDTO.getCollectionsList();
        for (CollectionDTO colDTO : collDTOList) {
            GatheringObservationCollectionPK pk =
                    new GatheringObservationCollectionPK(gDTO.
                    getGatheringObservationId(), colDTO.getCollectionId());
            GatheringObservationCollection newEntry =
                    new GatheringObservationCollection(pk);
            entity.getGatheringCollectionList().add(newEntry);
        }
        //Nuevos valores para la lista de proyectos
        List<ProjectDTO> projectDTOList = gDTO.getProjectsList();
        for (ProjectDTO proDTO : projectDTOList) {
            GatheringObservationProjectPK pk =
                    new GatheringObservationProjectPK(gDTO.
                    getGatheringObservationId(), proDTO.getProjectId());
            GatheringObservationProject newEntry =
                    new GatheringObservationProject(pk);
            entity.getGatheringProjectList().add(newEntry);
        }
        //Persisto la entidad modificada
        this.gatheringObservationEAOImpl.update(entity);
    }

    /**
     * Method to persist a specimen from a specific DTO
     * @param sDTO
     * @throws java.lang.IllegalArgumentException
     */
    public void saveSpecimen(SpecimenDTO sDTO) throws IllegalArgumentException {
        Specimen s = null;
        if (sDTO.getSpecimenKey() == null) {
            s = saveSpecimenMandatoryFields();
        } else {
            s = specimenEAOImpl.findById(Specimen.class, sDTO.getSpecimenKey());
        }

        if (s == null) {
            throw new IllegalArgumentException("Invalid SpecimenId");
        }

        //set Values
        s.setLabelId( sDTO.getLabelId());
        s.setOriginalLabelId( sDTO.getOriginalLabelId());
        
        s.setSpecimenCategoryId(sDTO.getCategoryId());
        s.setSpecimenTypeId(sDTO.getTypeId());
        s.setGatheringObservationMethodId(sDTO.getGatheringMethodId());
        s.setSubstrateId(sDTO.getSubstrateId());
        s.setNumberWhole(sDTO.getNumberWhole());
        s.setExtractionTypeId(sDTO.getExtractionTypeId());
        s.setOriginId(sDTO.getOriginId());
        s.setPreservationMediumId(sDTO.getPreservationMediumId());
        s.setStorageTypeId(sDTO.getStorageTypeId());
        s.setNumberFragments(sDTO.getNumberFragments());

        Set<SpecimenLifeStageSex> slssSet = new HashSet<SpecimenLifeStageSex>();
        SpecimenLifeStageSexPK slssPK;
        Set<SpecimenLifeStageSex> actualSlsSet =s.getSpecimenLifeStageSexList();
        SpecimenLifeStageSex sls;

        for (LifeStageSexDTO lssDTO : safetyCast(sDTO.getLifeStageSexList())) {
            slssPK = new SpecimenLifeStageSexPK(sDTO.getSpecimenKey(), lssDTO.
                    getLifeStageDTO().getValueId(), lssDTO.getSexDTO().
                    getValueId());
            sls = new SpecimenLifeStageSex(slssPK, null);

            if (actualSlsSet.contains(sls) == false) {
                sls.setQuantity(lssDTO.getQuantity());
                specimenLifeStageSexEAOImpl.create(sls);
                sls = specimenLifeStageSexEAOImpl.
                        findById(SpecimenLifeStageSex.class, slssPK);
            } else {
                sls = specimenLifeStageSexEAOImpl.
                        findById(SpecimenLifeStageSex.class, slssPK);
                sls.setQuantity(lssDTO.getQuantity());
                actualSlsSet.remove(sls);
            }


            slssSet.add(sls);
        }
        s.setSpecimenLifeStageSexList(slssSet);
        for (SpecimenLifeStageSex slss : actualSlsSet) {
            specimenLifeStageSexEAOImpl.delete(slss);
        }

        //if discarded == true sifnifica que discarded debe ser 1
        if (sDTO.isDiscarded()) {
            s.setDiscarded(1);
        } else {
            s.setDiscarded(0);
        }

        specimenEAOImpl.update(s);
    }

    /**
     * In a safety way cast the List to a Set
     * If two or more elements has the same sexId, lifeStageId then
     * the quantities are goint to be added.
     *
     * @param lifeStageSexDTOList
     */
    private Set<LifeStageSexDTO>
            safetyCast(List<LifeStageSexDTO> lifeStageSexDTOList) {
        //System.out.println("safetyCast con una lista de [" +
        //lifeStageSexDTOList.size() + "] elementos");
        Set<LifeStageSexDTO> lssDTOSet = new HashSet<LifeStageSexDTO>();

        LifeStageSexDTO pivote, duplicated;
        int duplicatedIndex;
        while (lifeStageSexDTOList.size() != 0) {
            //System.out.println("en el while de [" + lifeStageSexDTOList.size()
            //+ "] elementos");
            pivote = lifeStageSexDTOList.get(0);
            lifeStageSexDTOList.remove(0);

            while (pivote.isPartOf(lifeStageSexDTOList)) {
                duplicatedIndex = pivote.getIndexInList(lifeStageSexDTOList);
                duplicated = lifeStageSexDTOList.get(duplicatedIndex);
                pivote.setQuantity(pivote.getQuantity() + duplicated.
                        getQuantity());
                lifeStageSexDTOList.remove(duplicatedIndex);
            }
            //System.out.println("Se agrega: \n" + pivote.toString());
            lssDTOSet.add(pivote);
        }

        return lssDTOSet;
    }

    private Specimen saveSpecimenMandatoryFields()
            throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");

        //list of mandatory fields:
        //catalogueNumber
    }

    /**
     * Retrive all people who have identifier profile
     * @return
     */
    public List<PersonDTO> getAllIdentifiers() {
        return personDTOFactory.createDTOList(personEAOImpl.
                findByProfile(ProfileEntity.IDENTIFIER_PROFILE.getId()));
    }

    

    /**
     * Retrive all people who have validator profile
     * @return
     */
    public List<PersonDTO> getAllValidators() {
        return personDTOFactory.createDTOList(personEAOImpl.
                findByProfile(ProfileEntity.IDENTIFICATION_VALIDATOR.getId()));
    }

    /**
     * Retrive all people who have descriptor profile
     * @return
     */
    public List<PersonDTO> getAllDescriptors() {
        return personDTOFactory.createDTOList(personEAOImpl.
                findByProfile(ProfileEntity.MORPHOLOGICAL_DESCRIPTOR.getId()));
    }

    public List<PersonDTO> getCollectorsByGathering(Long gathid) {
        return personDTOFactory.createDTOList(collectorObserverEAOImpl.
                getCollectorsByGathering(gathid));
    }

    /**
     * Retrive all people who have responsible profile
     * @return
     */
    public List<PersonDTO> getAllResponsibles() {
        return personDTOFactory.createDTOList(personEAOImpl.
                findByProfile(ProfileEntity.GATHERING_RESPONSIBLE_PROFILE.
                getId()));
    }

    /**
     * Retrive all people who have colector profile
     * @return
     */
    public List<PersonDTO> getAllColectors() {
        return personDTOFactory.createDTOList(personEAOImpl.
                findByProfile(ProfileEntity.RECOLECTOR.getId()));
    }

    /**
     * Method to get all projects from project table
     * @return
     */
    public List<ProjectDTO> getAllProjects() {
        return projectDTOFactory.createDTOList(projectEAOImpl.
                findAllProjects());
    }

    /**
     * Listado de taxon categories en forma de DTO's
     */
    public List<TaxonCategoryDTO> getAllTaxonCategories() {
        List<TaxonCategory> aux = taxonCategoryEAOImpl.
                findAll(TaxonCategory.class);
        if (aux == null)
            return null;
        return taxonCategoryFactory.createDTOList(aux);
    }

    /**
     * La idea de este metodo es poder preguntar si determinado protocolo esta
     * activado o no para una determinada colleccion
     * @param collectionId
     * @param protocolAtributeId
     * @param value corresponde a alguno de los valores posibles para saber si 
     * el protocolo esta "activado" o "desactivado"
     * @return
     */
    public boolean matchCollectionProtocol(Long collectionId,
            Long protocolAtributeId, String value) {
        CollectionProtocol protocol = collectionProtocolImpl.
                findCollectionProtocolByPK(collectionId, protocolAtributeId);
        if (protocol == null) {
            return false;
        }
        String val = protocol.getValue();
        if (val != null && value != null) {
            if (val.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public List<TaxonDTO> getAllTaxon() {
        return taxonDTOFactory.createDTOList(taxonEAOImpl.findAll(Taxon.class));
    }

    public SpecimenDTO getSpecimenById(Long specimenId) {
        Specimen s = specimenEAOImpl.findById(Specimen.class, specimenId);
        if (s == null)
            return null;
        return updateCountryAndProvinceName(specimenDTOFactory.createDTO(s));
    }

    public List<IdentificationStatusDTO> getAllIdentificationStatus() {
        return identificationStatusDTOFactory.
                createDTOList(identificationStatusEAOImpl.
                findAll(IdentificationStatus.class));
    }

    public List<IdentificationTypeDTO> getAllIdentificationTypes() {
        String[] fields = {"name"};
        return identificationTypeDTOFactory.
                createDTOList(identificationTypeEAOImpl.
                findAllAndOrderBy(IdentificationType.class, fields));
    }

    public List<TaxonomicalRangeDTO> getAllTaxonomicalRage() {
        return taxonomicalRangeDTOFactory.createDTOList(taxonomicalRangeEAOImpl.
                findAll(TaxonomicalRange.class));
    }

    public List<TaxonDTO>
            getAllTaxonByTaxononimcalRange(Long taxonomicalRangeId) {
        return taxonDTOFactory.createDTOList(taxonEAOImpl.
                findByTaxononimcalRange(taxonomicalRangeId));
    }

    public Long countIdentifications(Long collectionId) {
        return identificationEAOImpl.count(collectionId);
    }

    public void reIdentify(List<IdentificationDTO> selectedIdentifications) {
        // si no se seleccionaron identificaciones
        if (selectedIdentifications == null ||
                selectedIdentifications.isEmpty()) {
            return;
        }

        /* ejecuta la reidentificación y dentro de ese proceso se archiva la
         * idenficicacion en las tablas de historial
         */
        for (IdentificationDTO current : selectedIdentifications) {
            /* Archiva en el identification_history la Identificación junto con
             * los identificadores a identifier_history (dentro de estos tambien
             * se guardan implicitamente los taxones)
             */
            this.archiveIdentification(current);

            // Crea la nueva Identificacion
            this.createIdentification(current);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Funciones de apoyo para la función reIdentify">
    private void archiveIdentification(IdentificationDTO anIdentificationDTO) {
        Long specimenId = null;
        Long identificationSequence = null;
        List<Identification> multiTaxaIdentification = null;
        IdentificationHistoryDTOFactory identificationHistoryDTOFactory =
                new IdentificationHistoryDTOFactory();

        IdentifierHistoryDTOFactory identifierHistoryDTOFactory =
                new IdentifierHistoryDTOFactory();

        IdentificationHistory anIdentificationHistory = null;
        IdentifierHistory anIdentifierHistory = null;

        if (anIdentificationDTO == null) {
            return;
        }

        specimenId = anIdentificationDTO.getSpecimenKey();

        multiTaxaIdentification = identificationEAOImpl.findBySpecimenId(specimenId);

        for (Identification anIdentification : multiTaxaIdentification) {

            anIdentificationHistory =
                    identificationHistoryDTOFactory.createEntity(anIdentification);

            identificationHistoryEAOImpl.create(anIdentificationHistory);

            if (anIdentification.getIdentifiers() != null) {
                for (Identifier ident : anIdentification.getIdentifiers()) {

                    anIdentifierHistory = identifierHistoryDTOFactory.createEntity(ident);

                    identifierHistoryEAOImpl.create(anIdentifierHistory);
                    identifierEAOImpl.delete(ident);
                }
            }
            identificationEAOImpl.delete(anIdentification);
        }
    }

    //</editor-fold>

    /**
     * Used in ListIdentification.jsp
     * @param first
     * @param totalResults
     * @return IdentificationDTOs listed
     * @deprecated Use instead the method below:
     * public List<IdentificationDTO> getAllIdentificationPaginated(int first,
     *       int totalResults, <b>int collectionId</b>)
     */
    public List<IdentificationDTO> getAllIdentificationPaginated(int first,
            int totalResults) {
        Set<Identification> identificationSet = null;
        IdentificationDTO identDTO = null;

        List<Specimen> specimenList = specimenEAOImpl.
                getAllSpecimenIdentificatedPaginated(first, totalResults);
        List<IdentificationDTO> identificationDTOList =
                new ArrayList<IdentificationDTO>();

        for (Specimen sp : specimenList) {
            identificationSet = sp.getIdentificationList();
            if (identificationSet.size() > 0) {
                //Lo convierte a DTO.
                identDTO = identificationDTOFactory.createDTO(
                        new ArrayList<Identification>(identificationSet));
                identificationDTOList.add(identDTO);
            }
        }
        return identificationDTOList;
    }

    /**
     * 
     * @param first
     * @param totalResults
     * @param collectionId
     * @return
     */
    public List<IdentificationDTO> getAllIdentificationPaginated(int first,
            int totalResults, Long collectionId) {

/*
        long inicioT = System.currentTimeMillis();
        long finalT;

        Set<Identification> identificationSet;
        IdentificationDTO identDTO;

        List<Specimen> specimenList = specimenEAOImpl.
                getAllSpecimenIdentificatedPaginated(first, totalResults,
                collectionId);

        finalT = System.currentTimeMillis();
        System.out.println("Despues de traer la lista de especimenes = "+(finalT-inicioT));
        inicioT = finalT;

        List<IdentificationDTO> identificationDTOList =
                new ArrayList<IdentificationDTO>();

        for (Specimen sp : specimenList) {
            identificationSet = sp.getIdentificationList();
            if (identificationSet.size() > 0) {
                //Lo convierte a DTO.
                identDTO = identificationDTOFactory.createDTO(
                        new ArrayList<Identification>(identificationSet));
                identificationDTOList.add(identDTO);
            }
        }
        
        
        finalT = System.currentTimeMillis();
        System.out.println("Tiempo al finalizar el getAllIdentificationPaginated = "+(finalT-inicioT));
        return identificationDTOList;
         */

       List<IdentificationDTO> identificationDTOList =
                new ArrayList<IdentificationDTO>();

        List<Identification> identificationEntities = identificationEAOImpl.getAllIdentificatedPaginated(first, totalResults, collectionId);

        //identificationDTOList = identificationDTOFactory.createDTOList(identificationEntities);
        for(Identification identification: identificationEntities)
        {
            identificationDTOList.add(identificationDTOFactory.createDTO(identification));
        }

        return identificationDTOList;
        
    }


    /**
     * This method generates specimens by specific specimen,identification,
     * life forms and life stages information
     * @param sDTO specimen
     * @param iDTO identification
     * @param lssDTO life forms
     * @param quantity
     * @return int Operation code
     */
    public int specimenGenerator(SpecimenDTO sDTO, IdentificationDTO iDTO,
            List<Long> lifeForms, int quantity) {
        String[] catalogNumbersAvailable;
        List<LifeStageSexDTO> lssDTOList;

        if (sDTO == null) {
            //Null specimenDTO
            return 1;
        } else {
            validateSpecimenDTO(sDTO);
        }
        if (quantity == 0) {
            //Not quantity specified
            return 2;
        }
        lssDTOList = sDTO.getLifeStageSexList();

        //Do I have an initial Catalog Number?
        //No. Then set one.
        if (sDTO.getCatalogNumber() == null ||
                sDTO.getCatalogNumber().isEmpty()) {
            Specimen lastSpecimen = specimenEAOImpl.getLastSpecimen();
            if (lastSpecimen != null) {
                sDTO.setCatalogNumber(increment(lastSpecimen.getSpecimenId().toString().
                        toCharArray()));
            } else {
                sDTO.setCatalogNumber("0");
            }
        }
        //Yes, I have or you assigned one to me
        //Are all of them available?
        catalogNumbersAvailable = catalogNumberChecker(sDTO.getCatalogNumber(),
                quantity);
        //No
        if (catalogNumbersAvailable == null) {
            //Catalog Number not available
            return 3;
        }
        //Yes
        for (String cn : catalogNumbersAvailable) {
            Specimen specimen = createSpecimen(sDTO);
            specimen.setCatalogNumber(cn);
            //Do I have Gath Obs Detail?
            if (matchCollectionProtocol(sDTO.getCollectionId(),
                    ProtocolAtributeEntity.USE_GATHERING_DETAIL.getId(),
                    CollectionProtocolValuesEntity.TRUE_VALUE.getValue())) {
                //Yes
                specimen.setGatheringObservationDetailId(sDTO.
                        getGatheringObservationDetailId());
            }
            specimenEAOImpl.create(specimen);
            //Identification?
            //Yes
            if (iDTO != null) {
                iDTO.setSpecimenKey(specimen.getSpecimenId());
                createIdentification(iDTO);
                if(sDTO.getCategoryId() != SpecimenCategoryEntity.
                        AGRUPADO_MULTITAXON.getId() &&
                        iDTO.getTaxa().size() > 1) {
                    //Multiple taxa selected
                    return 4;
                }
            }
            //Do I have a life stage sex?
            //Yes
            if (lssDTOList != null) {
                createLifeStageSex(lssDTOList, specimen.getSpecimenId());
            }
            //Do I have a life form?
            //Yes
            if (lifeForms != null) {
                createLifeForm(lifeForms, specimen.getSpecimenId());
            }
        }
        return 0; //0 means everything is ok
    }

    private void createLifeForm(List<Long> lifeFormIds, Long specimenId) {
        for (Long formId : lifeFormIds) {
            SpecimenLifeForm slf = new SpecimenLifeForm(specimenId, formId);
            specimenLifeFormEAOImpl.create(slf);
        }
    }

    private void createLifeStageSex(List<LifeStageSexDTO> lssDTOList,
            Long specimenId) {
        for (LifeStageSexDTO lssDTO : lssDTOList) {
            SpecimenLifeStageSex slss = new SpecimenLifeStageSex();
            SpecimenLifeStageSexPK slssPK = new SpecimenLifeStageSexPK();

            slssPK.setLifeStageId(lssDTO.getLifeStageDTO().getValueId());
            slssPK.setSexId(lssDTO.getSexDTO().getValueId());
            slssPK.setSpecimenId(specimenId);

            slss.setQuantity(lssDTO.getQuantity());
            slss.setSpecimenLifeStageSexPK(slssPK);

            specimenLifeStageSexEAOImpl.create(slss);
        }
    }

    private void createIdentification(IdentificationDTO iDTO) {
        List<TaxonDTO> taxonList = iDTO.getTaxa();
        Long sequence = 1L;
        Long personKey = 0L;
        Person aPerson = null;
        IdentificationStatus aStatus = null;
        IdentificationType aType = null;

        for (TaxonDTO taxonDTO : taxonList) {
            Identification identification = new Identification();
            IdentificationPK identificationPK =
                    new IdentificationPK(iDTO.getSpecimenKey(), sequence,
                    new GregorianCalendar());

            //DataEntryError
            identification.setDataEntryError(iDTO.getDataEntryError());
            //Specimen
            identification.setSpecimen(specimenEAOImpl.findById(Specimen.class,
                    iDTO.getSpecimenKey()));

            //Taxon
            identification.setTaxon(
                    taxonEAOImpl.findById(Taxon.class, taxonDTO.getTaxonKey()));

            if (iDTO.getValuerPerson() != null) {
                personKey = iDTO.getValuerPerson().getPersonKey();
                if (personKey != null) {
                    aPerson = personEAOImpl.findById(Person.class, personKey);
                    identification.setValuerPerson(aPerson);
                }

            }
            if (iDTO.getTypeId() != null) {
                aType = identificationTypeEAOImpl.
                        findById(IdentificationType.class, iDTO.getTypeId());

                identification.setIdentificationType(aType);

            }

            //IdentificationStatusId
            aStatus = identificationStatusEAOImpl.findById(
                    IdentificationStatus.class, iDTO.getStatusId());

            identification.setIdentificationStatus(aStatus);

            //IdentificationPK
            identification.setIdentificationPK(identificationPK);

            //IdentificationDate
            identification.setIdentificationDate(iDTO.getIdentificationDate());

            identificationEAOImpl.create(identification);

            //Set identifiers
            List<IdentifierDTO> identifiers = iDTO.getIdentifiers();
            if (identifiers != null) {
                Long identifierSequence = 1L;
                for (IdentifierDTO identifierDTO : identifiers) {
                    IdentifierPK pk = new IdentifierPK();
                    pk.setSpecimenId(iDTO.getSpecimenKey());
                    pk.setIdentificationSequence(sequence);
                    pk.setInitialTimestamp(new GregorianCalendar());
                    pk.setIdentifierPerson(personEAOImpl.findById(Person.class,
                            identifierDTO.getIdentifierKey()));

                    Identifier identifier = new Identifier(pk);
                    identifier.setIdentifierSequence(identifierSequence);

                    identifierEAOImpl.create(identifier);
                    identifierSequence++;
                }
            }
            sequence++;
        }
    }

    private Specimen createSpecimen(SpecimenDTO sDTO) {
        Specimen specimen = new Specimen();

        specimen.setSpecimenCategoryId(sDTO.getCategoryId());
        specimen.setSpecimenTypeId(sDTO.getTypeId());
        specimen.setGatheringObservationMethodId(sDTO.getGatheringMethodId());
        specimen.setSubstrateId(sDTO.getSubstrateId());
        specimen.setNumberWhole(sDTO.getNumberWhole());
        specimen.setExtractionTypeId(sDTO.getExtractionTypeId());
        specimen.setOriginId(sDTO.getOriginId());
        specimen.setPreservationMediumId(sDTO.getPreservationMediumId());
        specimen.setStorageTypeId(sDTO.getStorageTypeId());
        specimen.setNumberFragments(sDTO.getNumberFragments());
        specimen.setCollectionId(sDTO.getCollectionId());

        if (sDTO.getGatheringObsevationId() != null) {
            specimen.setGatheringObservation(gatheringObservationEAOImpl.
                    findById(GatheringObservation.class,
                            sDTO.getGatheringObsevationId()));
        }
        specimen.setInstitutionId(sDTO.getInstitutionId());
        return specimen;
    }

    /**
     * Verifies that all the requested catalog numbers are unassigned
     * @param catalogNumber Initial catalog number
     * @param quantity How many catalog numbers do I want from the initial CN
     * @return String Array with the requested catalog numbers or null if any of
     * them is not available
     */
    private String[] catalogNumberChecker(String catalogNumber, int quantity) {
        String[] catalogNumbers = new String[quantity];
        int i = 0;

        String catalogNumberAux = catalogNumber;
        do {
            Long specimenId = specimenEAOImpl.
                    findByCatalogNumber(catalogNumberAux);
            if (specimenId == null) {
                catalogNumbers[i] = catalogNumberAux;
            } else {
                return null;
            }
            catalogNumberAux = increment(catalogNumberAux.toCharArray());
            i++;
        } while (i < quantity);

        return catalogNumbers;
    }

    /**
     * Ej. "24100" -> "24101", "INB-24100" -> "INB-24101", "9" -> "10"
     * @param catalogNumber
     * @return increment of the catalog number or null if catalogNumber format
     * is not correct
     */
    private String increment(char[] catalogNumber) {
        StringBuilder catalogNumberText = new StringBuilder();
        StringBuilder catalogNumberNumeric = new StringBuilder();
        int i = 0;
        for (; i < catalogNumber.length; i++) {
            char c = catalogNumber[i];
            if (Character.isDigit(c)) {
                break;
            }
            catalogNumberText.append(c);
        }
        for (; i < catalogNumber.length; i++) {
            char c = catalogNumber[i];
            if (Character.isDigit(c)) {
                catalogNumberNumeric.append(c);
            } else {
                return null;
            }
        }
        if(catalogNumberNumeric.toString().equals("")){
            return catalogNumberText.toString();
        }
        else{
            Long numberPart = Long.parseLong(catalogNumberNumeric.toString());
            numberPart++;
            return catalogNumberText.toString() + numberPart;
        }
    }

    /**
     * 
     * @return
     */
    public Long countCollections() {
        return collectionEAOImpl.count(Collection.class);
    }

    /**
     * @param firstResult
     * @param maxResults
     * @return
     */
    public List<CollectionDTO> getAllCollectionPaginated(int firstResult,
            int maxResults) {
        String[] orderByFields = {"name"};
        List<Collection> cList = collectionEAOImpl.
                findAllPaginatedFilterAndOrderBy(
                Collection.class, firstResult, maxResults,orderByFields,null);
        if (cList == null)
            return null;
        return collectionDTOFactory.createDTOList(cList);
    }

    private void validateSpecimenDTO(SpecimenDTO sDTO)
    throws IllegalArgumentException {
        if(sDTO.getInstitutionId() == null) {
            throw new IllegalArgumentException("Null institution");
        }
    }

    public IdentificationDTO getIdentificationByCatalogNumber(String catalogNumber){

        // get the identifications
        List<Identification> identList =
                identificationEAOImpl.findByCatalogNumber(catalogNumber);

        IdentificationDTOFactory idtof = new IdentificationDTOFactory();

        IdentificationDTO result = idtof.createDTO(identList);

        return result;
    }

    public List<PersonDTO> getPersonByFilterProfile(Long profileId, String filter)
    {
        List<PersonDTO> personDTOs = new ArrayList<PersonDTO>();
        if(filter != null && !(filter.trim().equals("")))
            personDTOs = personDTOFactory.createDTOList(personEAOImpl.findPersonByProfile(profileId, filter));
        return personDTOs;
    }

    public String getPersonById(Long personId)
    {
        String result = null;
        Person person = personEAOImpl.findById(Person.class, personId);
        if(person!=null)
        {
            PersonDTO personDto = personDTOFactory.createDTO(person);
            result = personDto.getNaturalLongName();
        }
        return result;

    }

}
