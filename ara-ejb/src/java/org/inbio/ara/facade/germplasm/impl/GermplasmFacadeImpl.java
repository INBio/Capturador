/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.facade.germplasm.impl;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import org.inbio.ara.dto.germplasm.AccessionMovementDTO;
import org.inbio.ara.dto.germplasm.BreedDTO;
import org.inbio.ara.dto.germplasm.PassportDTO;
import org.inbio.ara.dto.germplasm.SemenGatheringDTO;
import org.inbio.ara.dto.germplasm.SementalDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.dto.security.NomenclaturalGroupDTO;
import org.inbio.ara.facade.germplasm.*;
import javax.ejb.Stateless;
import org.inbio.ara.dto.germplasm.AccessionDTO;
import org.inbio.ara.dto.germplasm.AccessionDTOFactory;
import org.inbio.ara.dto.germplasm.AccessionMovementDTOFactory;
import org.inbio.ara.dto.germplasm.BreedDTOFactory;
import org.inbio.ara.dto.germplasm.PassportDTOFactory;
import org.inbio.ara.dto.germplasm.PassportNomenclaturalGroupDTO;
import org.inbio.ara.dto.germplasm.PassportNomenclaturalGroupDTOFactory;
import org.inbio.ara.dto.germplasm.SemenGatheringDTOFactory;
import org.inbio.ara.dto.germplasm.SementalDTOFactory;
import org.inbio.ara.dto.inventory.PersonDTOFactory;
import org.inbio.ara.dto.inventory.SelectionListDTOFactory;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.dto.inventory.TaxonDTOFactory;
import org.inbio.ara.dto.security.NomenclaturalGroupDTOFactory;
import org.inbio.ara.eao.agent.InstitutionEAOLocal;
import org.inbio.ara.eao.agent.PersonEAOLocal;
import org.inbio.ara.eao.germplasm.AccessionEAOLocal;
import org.inbio.ara.eao.germplasm.AccessionMovementEAOLocal;
import org.inbio.ara.eao.germplasm.BreedEAOLocal;
import org.inbio.ara.eao.germplasm.PassportEAOLocal;
import org.inbio.ara.eao.germplasm.PassportNomenclaturalGroupEAOLocal;
import org.inbio.ara.eao.germplasm.SemenGatheringEAOLocal;
import org.inbio.ara.eao.germplasm.SementalEAOLocal;
import org.inbio.ara.eao.gis.SiteEAOLocal;
import org.inbio.ara.eao.security.NomenclaturalGroupEAOLocal;
import org.inbio.ara.eao.selectionlist.SelectionListValueLocalEAO;
import org.inbio.ara.eao.taxonomy.TaxonEAOLocal;
import org.inbio.ara.eao.taxonomy.TaxonomicalRangeEAOLocal;
import org.inbio.ara.persistence.SelectionListGenericEntity;
import org.inbio.ara.persistence.germplasm.Accession;
import org.inbio.ara.persistence.germplasm.AccessionMovement;
import org.inbio.ara.persistence.germplasm.Breed;
import org.inbio.ara.persistence.germplasm.Passport;
import org.inbio.ara.persistence.germplasm.SemenGathering;
import org.inbio.ara.persistence.germplasm.Semental;
import org.inbio.ara.persistence.institution.Institution;
import org.inbio.ara.persistence.person.Person;
import org.inbio.ara.persistence.person.ProfileEntity;
import org.inbio.ara.persistence.taxonomy.NomenclaturalGroup;
import org.inbio.ara.persistence.taxonomy.Taxon;

/**
 *
 * @author dasolano
 */
@Stateless
public class GermplasmFacadeImpl implements GermplasmFacadeRemote {


    /**
     * EAO
     */
    @EJB
    private SelectionListValueLocalEAO selectionListValueLocalEAO;

    @EJB
    private PersonEAOLocal personEAOLocal;

    @EJB
    private NomenclaturalGroupEAOLocal nomenclaturalGroupEAOLocal;

    @EJB
    private PassportEAOLocal passportEAOLocal;

    @EJB
    private TaxonEAOLocal taxonEAOLocal;

    @EJB
    private InstitutionEAOLocal institutionEAOLocal;

    @EJB
    private PassportNomenclaturalGroupEAOLocal passportNomenclaturalGroupEAOLocal;

    @EJB
    private TaxonomicalRangeEAOLocal taxonomicalRangeEAOLocal;

    @EJB
    private AccessionEAOLocal accessionEAOLocal;

    @EJB
    private AccessionMovementEAOLocal accessionMovementEAOLocal;

    @EJB
    private BreedEAOLocal breedEAOLocal;

    @EJB
    private SementalEAOLocal sementalEAOLocal;

    @EJB
    private SemenGatheringEAOLocal semenGatheringEAOLocal;

    @EJB
    private SiteEAOLocal siteEAOLocal;

    /**
     * Factory
     */
    private SelectionListDTOFactory selecionListDTOFactory = new SelectionListDTOFactory();
    private PersonDTOFactory personDTOFactory = new PersonDTOFactory();
    private NomenclaturalGroupDTOFactory nomenclaturalGroupDTOFactory = new NomenclaturalGroupDTOFactory();
    private TaxonDTOFactory taxonDTOFactory = new TaxonDTOFactory();

    private PassportDTOFactory passportDTOFactory = new PassportDTOFactory();
    private PassportNomenclaturalGroupDTOFactory passportNomenclaturalGroupDTOFactory =
            new PassportNomenclaturalGroupDTOFactory();

    private AccessionDTOFactory accessionDTOFactory = new AccessionDTOFactory();
    private AccessionMovementDTOFactory accessionMovementDTOFactory = new AccessionMovementDTOFactory();


    private BreedDTOFactory breedDTOFactory = new BreedDTOFactory();
    private SemenGatheringDTOFactory semenGatheringDTOFactory = new SemenGatheringDTOFactory();
    private SementalDTOFactory sementalDTOFactory = new SementalDTOFactory();

    /**
     * Return all the SelectionList values for a Selection List id
     * @param selectionListId
     * @return List<SelectionListDTO>
     */
    public List<SelectionListDTO> getElementsForSelectionList(long selectionListId) {
        return selecionListDTOFactory.createDTOList(selectionListValueLocalEAO.findAll(selectionListId));
    }


    /**
     * @return the personEAOLocal
     */
    public PersonEAOLocal getPersonEAOLocal() {
        return personEAOLocal;
    }

    /**
     * Return a list of nomenclatural groups for a taxon id
     * @param taxonId
     * @return
     */
    public List<NomenclaturalGroupDTO> getNomenclaturalGroupsByTaxon(Long taxonId) {
        return nomenclaturalGroupDTOFactory.createDTOList(
                nomenclaturalGroupEAOLocal.getNomenclaturalGroupListByTaxon(taxonId));
    }

    public void savePassport(PassportDTO passportDTO,
            Long[] selectedNomenclaturalGroups)
    {
        Passport passport = passportDTOFactory.createPlainEntity(passportDTO);
        passportEAOLocal.create(passport);
        savePassportNomenclaturalGroups(passport.getPassportId(),
                passportDTO.getUserName(),
                selectedNomenclaturalGroups);
    }

    /**
     * Create the nomenclatural groups selected for a passport
     * @param passportId
     * @param userName
     * @param passportNomenclaturalGroupDTOs
     */
    private void savePassportNomenclaturalGroups(Long passportId, String userName,
            Long[] passportNomenclaturalGroupDTOs)
    {
        if(passportNomenclaturalGroupDTOs != null &&
                passportNomenclaturalGroupDTOs.length > 0)
        {
            PassportNomenclaturalGroupDTO passportNomenclaturalGroupDTO;
            for (int i = 0; i < passportNomenclaturalGroupDTOs.length; i++)
            {
                passportNomenclaturalGroupDTO =
                    new PassportNomenclaturalGroupDTO();

                passportNomenclaturalGroupDTO.setNomenclaturalGroupId(
                        passportNomenclaturalGroupDTOs[i]);
                passportNomenclaturalGroupDTO.setPassportId(passportId);
                passportNomenclaturalGroupDTO.setUserName(userName);

                passportNomenclaturalGroupEAOLocal.
                        create(
                        passportNomenclaturalGroupDTOFactory.
                        createPlainEntity(passportNomenclaturalGroupDTO));
            }
        }
    }

    /**
     * Retrieve all donor persons
     * @return
     */
    public List<PersonDTO> getDonorPersons() {
        return personDTOFactory.createDTOList(personEAOLocal.
                findByProfile(ProfileEntity.DONOR_PERSON_PROFILE.getId()));
    }

    /**
     * Get all taxons for a collection Id
     * @param collectionId
     * @return
     */
    public List<TaxonDTO> getAllTaxonsByCollectionIdAndTaxonomicalRangeId(Long collectionId, Long taxonomicalRangeId) {
        return taxonDTOFactory.createDTOList(taxonEAOLocal.getTaxonsByCollectionIdAndTaxonomicalRangeId(collectionId,taxonomicalRangeId));
    }

    /**
     * Get Passport list paginated
     * @param firstResult
     * @param maxResults
     * @return
     */
    public List<PassportDTO> getPassportListPaginated(int firstResult, int maxResults) {
        String[] parts = {"passportId"};
        List<PassportDTO> listPassport =  passportDTOFactory.createDTOList(
                //passportEAOLocal.findAllPaginated(Passport.class, firstResult, maxResults));
                passportEAOLocal.findAllPaginatedFilterAndOrderBy(
                Passport.class, firstResult, maxResults, parts, null));
        
        updatePassportDTOListValues(listPassport);
        /*for (PassportDTO passportDTO : listPassport) {
            updatePassportDTOValues(passportDTO);
        }*/
        return listPassport;
    }

    /**
     * Update the content of each passport in a list
     * @param passportDTOList
     * @return
     */
    private List<PassportDTO> updatePassportDTOListValues(List<PassportDTO> passportDTOList)
    {
        for (PassportDTO passportDTO : passportDTOList) {
            updatePassportDTOValues(passportDTO);
        }
        return passportDTOList;
    }

    /**
     * Update the content of a passportDTO
     * @param passportDTO
     * @return
     */
    private PassportDTO updatePassportDTOValues(PassportDTO passportDTO)
    {
        if(passportDTO.getDonorPersonId() != null)
        {
            passportDTO.setPerson(personEAOLocal.
                    findById(
                    Person.class, passportDTO.getDonorPersonId()).
                    getNaturalFullName());
        }
        if(passportDTO.getDonorInstitutionId() != null)
        {
            passportDTO.setInstitution(institutionEAOLocal.
                findById(
                Institution.class, passportDTO.getDonorInstitutionId()).
                getName());
        }
        if(passportDTO.getMaterialTypeId() != null)
        {
            passportDTO.setMaterialType(selectionListValueLocalEAO.
                findById(
                SelectionListEntity.MATERIAL_TYPE.getId(),
                passportDTO.getMaterialTypeId()).getName());
        }
        if(passportDTO.getSampleStatusId() != null)
        {
            passportDTO.setSampleStatus(selectionListValueLocalEAO.
                findById(
                SelectionListEntity.SAMPLE_STATUS.getId(),
                passportDTO.getSampleStatusId()).getName());
        }
        if(passportDTO.getGatheringSourceId() != null)
        {
            passportDTO.setGatheringSource(selectionListValueLocalEAO.
                findById(
                SelectionListEntity.GATHERING_SOURCE.getId(),
                passportDTO.getGatheringSourceId()).getName());
        }
        if(passportDTO.getSoilColorId() != null)
        {
            passportDTO.setSoilColor(selectionListValueLocalEAO.
                findById(
                SelectionListEntity.SOIL_COLOR.getId(),
                passportDTO.getSoilColorId()).getName());
        }
        if(passportDTO.getSoilTextureId() != null)
        {
            passportDTO.setSoilTexture(selectionListValueLocalEAO.
                findById(
                SelectionListEntity.SOIL_TEXTURE.getId(),
                passportDTO.getSoilTextureId()).getName());
        }
        if(passportDTO.getCultivationPracticeId() != null)
        {
            passportDTO.setCultivationPractice(selectionListValueLocalEAO.
                findById(
                SelectionListEntity.CULTIVATION_PRACTICE.getId(),
                passportDTO.getCultivationPracticeId()).getName());
        }
        if(passportDTO.getCropSystemId() != null)
        {
            passportDTO.setCropSystem(selectionListValueLocalEAO.
                findById(
                SelectionListEntity.CROP_SYSTEM.getId(),
                passportDTO.getCropSystemId()).getName());
        }
        if(passportDTO.getCropTypeId() != null)
        {
            passportDTO.setCropType(selectionListValueLocalEAO.
                findById(
                SelectionListEntity.CROP_TYPE.getId(),
                passportDTO.getCropTypeId()).getName());
        }

        //load the nomenclatural groups associated
        passportDTO.setPassportNomenclaturalGroupList(
                getPassportNomenclaturalGroups(passportDTO.getPassportId()));

        return passportDTO;
    }

    /**
     *
     * @param passportId
     * @return
     */
    private List<PassportNomenclaturalGroupDTO> getPassportNomenclaturalGroups
            (Long passportId)
    {
        List<PassportNomenclaturalGroupDTO> listPNGDTO =
                passportNomenclaturalGroupDTOFactory.createDTOList(
                passportNomenclaturalGroupEAOLocal.getAllByPassportId(passportId));
        return updateNomenclaturalGroupsforPassport(listPNGDTO);
    }

    /**
     * Set the name to each PassportNomenclaturalGroupDTO of the list
     * @param listPNGDTO
     * @return
     */
    private List<PassportNomenclaturalGroupDTO> updateNomenclaturalGroupsforPassport(
            List<PassportNomenclaturalGroupDTO> listPNGDTO)
    {
        if(listPNGDTO != null && !listPNGDTO.isEmpty())
        {
            NomenclaturalGroup ng;
            for (PassportNomenclaturalGroupDTO passportNomenclaturalGroupDTO : listPNGDTO)
            {
                ng = nomenclaturalGroupEAOLocal.findById(
                        NomenclaturalGroup.class,
                        passportNomenclaturalGroupDTO.getNomenclaturalGroupId());

                //set the name to the PNG
                passportNomenclaturalGroupDTO.setNomenclaturalGroupName(
                        ng.getName());

            }
            return listPNGDTO;
        }
        else
            return new ArrayList<PassportNomenclaturalGroupDTO>();

    }

    /**
     * Return the quantity of passports
     * @return
     */
    public Long countPassport() {
        return passportEAOLocal.count(Passport.class);
    }

    /**
     * Update a passport
     * @param passportDTO
     */
    public void updatePassport(PassportDTO passportDTO, Long[] selectedNomenclaturalGroups) {
        Passport passport = passportEAOLocal.findById(Passport.class, passportDTO.getPassportId());

        passport = passportDTOFactory.updatePlainEntity(passportDTO, passport);

        passportEAOLocal.update(passport);

        updatenomenclaturalGroupsForPassport(passport.getPassportId(),
                passportDTO.getUserName(),
                selectedNomenclaturalGroups);
    }

    /**
     * Update the nomenclatural groups for a passport
     * @param passportId
     * @param userName
     * @param selectedNomenclaturalGroups
     */
    private void updatenomenclaturalGroupsForPassport(Long passportId,
            String userName,
            Long[] selectedNomenclaturalGroups)
    {
        passportNomenclaturalGroupEAOLocal.deleteByPassportId(passportId);

        if(selectedNomenclaturalGroups != null &&
                selectedNomenclaturalGroups.length > 0)
        {
            PassportNomenclaturalGroupDTO passportNomenclaturalGroupDTO;
            for (int i = 0; i < selectedNomenclaturalGroups.length; i++)
            {
                passportNomenclaturalGroupDTO =
                    new PassportNomenclaturalGroupDTO();

                passportNomenclaturalGroupDTO.setNomenclaturalGroupId(
                        selectedNomenclaturalGroups[i]);
                passportNomenclaturalGroupDTO.setPassportId(passportId);
                passportNomenclaturalGroupDTO.setUserName(userName);

                passportNomenclaturalGroupEAOLocal.
                        create(
                        passportNomenclaturalGroupDTOFactory.
                        createPlainEntity(passportNomenclaturalGroupDTO));
            }
        }

    }

    /**
     * Get the taxnomomical range where a taxon id belong
     * @param taxonId
     * @return Long
     */
    public Long getTaxonomicalLevelForTaxon(Long taxonId) {
        if(taxonId != null)
        {
            Taxon taxon = taxonEAOLocal.findById(Taxon.class, taxonId);
            return taxon.getTaxonomicalRangeId();
        }
        else
            return null;
    }

    /**
     * Coun the quantity of passports for a simple search
     * @param query
     * @param collectionId
     * @param firstResult
     * @param maxResult
     * @return
     */
    public Long countPassportSimpleSearch(String query, Long collectionId)
    {
        Integer quantity = new Integer(unstructeredPassportQuery(splitQuery(query)).size());
        return quantity.longValue();
    }

    /**
     * Get a passport list for a simple search. Search by passportId, material type,
     * gatheringId and mission number
     * @param query
     * @param collectionId
     * @param firstResult
     * @param maxResult
     * @return
     */
    public List<PassportDTO> getPassportSimpleSearch(String query, Long collectionId, int firstResult, int maxResult)
    {
        Set<Long> passportIds = unstructeredPassportQuery(splitQuery(query));

        //Retrieve entities
        List<Passport> passportList = getEntities(passportIds,
                Passport.class, firstResult, maxResult);

        return updatePassportDTOListValues(passportDTOFactory.createDTOList(passportList));
    }

    /**
     * Search passports id for each part if the query string. It search for
     * passport Id, material type, mission number, and gathering id
     * @param parts
     * @return
     */
    private Set<Long> unstructeredPassportQuery(String[] parts)
    {
        Set<Long> passportList = new HashSet();
        Long id = null;
        List<Long> passportsId = null;
        Passport entity = null;

        //get All material types
        List<SelectionListGenericEntity> slge =
                selectionListValueLocalEAO.findAll(
                SelectionListEntity.MATERIAL_TYPE.getId());
        Long slId = null;

        for (int i = 0; i < parts.length; i++)
        {
            id = getSeleccionListByName(slge, parts[i]);


            if(id != null)
            {
                passportsId = passportEAOLocal.findByMaterialTypeId(id);
                if(passportsId != null && !passportsId.isEmpty())
                    passportList.addAll(passportsId);
            }

            //try to cast it
            try
            {
                id = Long.parseLong(parts[i]);

                //find by passport Id
                entity = passportEAOLocal.findById(Passport.class, id);
                if(entity != null)
                    passportList.add(entity.getPassportId());

                //find by gathering id
                passportsId = passportEAOLocal.findByGatheringId(id);
                if(passportsId != null && !passportsId.isEmpty())
                    passportList.addAll(passportsId);

                //find by mission number
                passportsId = passportEAOLocal.findByMissionNumber(id);
                if(passportsId != null && !passportsId.isEmpty())
                    passportList.addAll(passportsId);

                
            }
            catch(Exception e){}            
        }
        return passportList;
    }

    /**
     * ESTE METODO FUE CREADO CON EL FIN DE NO MODIFICAR LA EAO DE LAS
     * LISTAS DE SELECCION
     * Metodo que se encarga de buscar el id de una lista de seleccion
     * dado un nombre dado y un listado de listas de seleccion
     * @param slge
     * @param name
     * @return
     */
    private Long getSeleccionListByName(List<SelectionListGenericEntity> slge, String name)
    {
        Long id = null;
        for (SelectionListGenericEntity selectionListGenericEntity : slge)
        {
            if(selectionListGenericEntity.getName().equalsIgnoreCase(name))
            {
                id = selectionListGenericEntity.getId();
            }
        }
        return id;
    }


  

    /**
     * Split the query
     * @param query
     * @return
     */
    private String[] splitQuery(String query)
    {
            if(query == null || query.length() == 0)
                return null;
            return query.split(" ");
    }

    /**
     * Get the entities for a list of Longs
     * @param ids
     * @param t
     * @param base
     * @param offset
     * @return
     */
    private List getEntities(Set<Long> ids, Class t, int base, int offset)
    {
        List entitiesList = new ArrayList();
        Object[] sortedIdentificationIds = ids.toArray();
        java.util.Arrays.sort(sortedIdentificationIds);
        int entitiesCounter = 0;
        int baseCounter = 0;
        if(sortedIdentificationIds.length > base)
        {
            for (Object id : sortedIdentificationIds)
            {
                if (baseCounter < base)
                {
                    baseCounter++;
                } 
                else if(entitiesCounter < offset)
                {
                    if(t == Passport.class)
                    {
                        entitiesList.add(passportEAOLocal.
                            findById(Passport.class, (Long)id));
                    }
                    else 
                    {
                        if(t == Accession.class)
                        {
                            entitiesList.add(accessionEAOLocal.
                                findById(Accession.class, (Long)id));
                        }
                        else
                        {
                            if(t == Breed.class)
                            {
                                entitiesList.add(breedEAOLocal.
                                    findById(Breed.class, (Long)id));
                            }
                            else
                            {
                                if(t == Semental.class)
                                {
                                    entitiesList.add(sementalEAOLocal.
                                        findById(Semental.class, (Long)id));
                                }
                                else
                                {
                                    if(t == SemenGathering.class)
                                    {
                                        entitiesList.add(semenGatheringEAOLocal.
                                            findById(SemenGathering.class, (Long)id));
                                    }
                                }
                            }
                        }
                    }
                    
                    entitiesCounter++;
                }

            }
        }
        return entitiesList;
    }

    /**
     * Count the quantity of passports for the advanced search
     * @param passportDTO
     * @param collectionId
     * @param firstResult
     * @param maxResult
     * @return
     */
    public Long countPassportAdvancedSearch(PassportDTO passportDTO, Long collectionId)
    {
        Integer quantity = new Integer(getPassportsByCriteria(passportDTO).size());
        return quantity.longValue();
    }

    /**
     * Get a list of passport for the advanced search
     * @param passportDTO
     * @param collectionId
     * @param firstResult
     * @param maxResult
     * @return
     */
    public List<PassportDTO> getPassportAdvancedSearch(PassportDTO passportDTO, Long collectionId, int firstResult, int maxResult) {
        Set<Long> passportIds = getPassportsByCriteria(passportDTO);

        //Retrieve entities
        List<Passport> passportList = getEntities(passportIds,
                Passport.class, firstResult, maxResult);

        return updatePassportDTOListValues(passportDTOFactory.createDTOList(passportList));
    }


    /**
     * get a Set of passport by criteria
     * @param passportDTO
     * @return
     */
    private Set<Long> getPassportsByCriteria(PassportDTO passportDTO)
    {
        Set<Long> ids = new HashSet();
        boolean firstTime = true;

        List<Long> query = new ArrayList<Long>();
        Passport queryPassport = null;

        //find by passport id
        if(passportDTO.getPassportId() != null)
        {
            queryPassport = passportEAOLocal.
                    findById(Passport.class, passportDTO.getPassportId());
            if(queryPassport != null)
            {
                ids.add(queryPassport.getPassportId());
                firstTime = false;
            }
        }

        //find by donor person
        if(passportDTO.getDonorPersonId() != null)
        {
            query = passportEAOLocal.
                    findByDonorPersonId(passportDTO.getDonorPersonId());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        //find by donor institution
        if(passportDTO.getDonorInstitutionId() != null)
        {
            query = passportEAOLocal.
                    findByDonorInstitutionId(passportDTO.getDonorInstitutionId());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        //find by gathering id
        if(passportDTO.getGatheringId() != null)
        {
            query = passportEAOLocal.
                    findByGatheringId(passportDTO.getGatheringId());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }
        
        //find by material type
        if(passportDTO.getMaterialTypeId() != null)
        {
            query = passportEAOLocal.
                    findByMaterialTypeId(passportDTO.getMaterialTypeId());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }
        
        //find by mission number
        if(passportDTO.getMissionNumber() != null)
        {
            query = passportEAOLocal.
                    findByMissionNumber(passportDTO.getMissionNumber());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }
        
        //find by plant nursery date
        if(passportDTO.getPlantNurseryDate() != null)
        {
            query = passportEAOLocal.
                    findByPlantNurseryDate(passportDTO.getPlantNurseryDate());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }
        
        //find by planting season date
        if(passportDTO.getPlantingSeasonDate() != null)
        {
            query = passportEAOLocal.
                    findByPlantingSeasonDate(passportDTO.getPlantingSeasonDate());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }
        
        //find by harvesting season date
        if(passportDTO.getHarvestingSeasonDate() != null)
        {
            query = passportEAOLocal.
                    findByHarvestingSeasonDate(passportDTO.getHarvestingSeasonDate());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        //find by sample status
        if(passportDTO.getSampleStatusId() != null)
        {
            query = passportEAOLocal.
                    findBySampleStatusId(passportDTO.getSampleStatusId());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        return ids;
    }



    public Long countAccessionAdvancedSearch(AccessionDTO accessionDTO, Long collectionId)
    {
        Integer quantity = new Integer(getAccessionByCriteria(accessionDTO).size());
        return quantity.longValue();
    }

    public Long countAccessionSimpleSearch(String query, Long collectionId)
    {
        Integer quantity = new Integer(unstructeredAccessionQuery(splitQuery(query)).size());
        return quantity.longValue();
    }

    public List<AccessionDTO> getAccessionListPaginated(int firstResult, int maxResults)
    {
        String[] parts = {"accessionId"};
        return updateAccessionDTOListValues(accessionDTOFactory.createDTOList(
                accessionEAOLocal.findAllPaginatedFilterAndOrderBy(
                Accession.class, firstResult, maxResults, parts, null)));
    }

    public Long countAccessions()
    {
        return accessionEAOLocal.count(Accession.class);
    }

    public List<AccessionDTO> getAccessionAdvancedSearch(AccessionDTO accessionDTO, Long collectionId, int firstResult, int maxResult) {
        Set<Long> accessionIds = getAccessionByCriteria(accessionDTO);

        //Retrieve entities
        List<Accession> accessionList = getEntities(accessionIds,
                Accession.class, firstResult, maxResult);

        return updateAccessionDTOListValues(accessionDTOFactory.createDTOList(accessionList));
    }

    /**
     * Use this method for accession advance search. Searh by:
     * accession id, accession number, packagesoriginal weight, current weight,
     * responsable person, passport id,parent id, germination rate, germination
     * method type
     * @param accessionDTO
     * @return
     */
    public Set<Long> getAccessionByCriteria(AccessionDTO accessionDTO)
    {
        Set<Long> ids = new HashSet<Long>();
        boolean firstTime = true;

        List<Long> query = new ArrayList<Long>();
        Accession queryAccession = null;

        //find by accession id
        if(accessionDTO.getAccessionId() != null)
        {
            queryAccession = accessionEAOLocal.
                    findById(Accession.class, accessionDTO.getAccessionId());
            if(queryAccession != null)
            {
                ids.add(queryAccession.getAccessionId());
                firstTime = false;
            }
        }

        //find by
        if(accessionDTO.getAccessionNumber() != null)
        {
            query = accessionEAOLocal.findByAccessionNumber
                    (accessionDTO.getAccessionNumber());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        //find by
        if(accessionDTO.getPackages() != null)
        {
            query = accessionEAOLocal.
                    findByPackages(accessionDTO.getPackages());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        //find by
        if(accessionDTO.getOriginalWeigth() != null)
        {
            query = accessionEAOLocal.
                    findByOriginalWeigth(accessionDTO.getOriginalWeigth());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        //find by
        if(accessionDTO.getCurrentWeigth() != null)
        {
            query = accessionEAOLocal.
                    findByCurrentWeigth(accessionDTO.getCurrentWeigth());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        //find by
        if(accessionDTO.getResponsablePersonId() != null)
        {
            query = accessionEAOLocal.
                    findByResponsablePersonId(accessionDTO.getResponsablePersonId());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        //find by
        if(accessionDTO.getPassportId() != null)
        {
            query = accessionEAOLocal.
                    findByPassportId(accessionDTO.getPassportId());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        //find by
        if(accessionDTO.getAccessionParentId() != null)
        {
            query = accessionEAOLocal.
                    findByAccessionParentId(accessionDTO.getAccessionParentId());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        //find by
        if(accessionDTO.getGerminationMethodTypeId() != null)
        {
            query = accessionEAOLocal.
                    findByGerminationMethodId(accessionDTO.getGerminationMethodTypeId());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        //find by
        if(accessionDTO.getGerminationRate() != null)
        {
            query = accessionEAOLocal.
                    findByGerminationRate(accessionDTO.getGerminationRate());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }
        return ids;

    }

    public List<AccessionDTO> getAccessionSimpleSearch(String query, Long collectionId, int firstResult, int maxResult) {
        Set<Long> accessionIds = unstructeredAccessionQuery(splitQuery(query));

        //Retrieve entities
        List<Accession> accessionList = getEntities(accessionIds,
                Accession.class, firstResult, maxResult);

        return updateAccessionDTOListValues(accessionDTOFactory.createDTOList(accessionList));
    }

    /**
     * Update values for an Accession List
     * @param accessionDTOList
     * @return List<AccessionDTO>
     */
    public List<AccessionDTO> updateAccessionDTOListValues(List<AccessionDTO> accessionDTOList)
    {
        for (AccessionDTO accessionDTO : accessionDTOList)
            updateAccessionDTOValues(accessionDTO);

        return accessionDTOList;
    }

    /**
     * Update values for an AccessionDTO. Put: accession parent name, responsable person,
     * germinationMethodType name
     * @param accessionDTO
     * @return AccessionDTO
     */
    public AccessionDTO updateAccessionDTOValues(AccessionDTO accessionDTO)
    {
        if(accessionDTO.getAccessionParentId() != null)
        {
            accessionDTO.setAccessionParent((accessionEAOLocal.
                    findById(
                    Accession.class, accessionDTO.getAccessionParentId())).
                    getAccessionNumber());
        }
        if(accessionDTO.getResponsablePersonId() != null)
        {
            accessionDTO.setResponsablePerson(personEAOLocal.
                    findById(
                    Person.class, accessionDTO.getResponsablePersonId()).
                    getNaturalLongName());
        }
        if(accessionDTO.getGerminationMethodTypeId() != null)
        {
            accessionDTO.setGerminationMethodType(
                    selectionListValueLocalEAO.
                    findById(
                    SelectionListEntity.GERMINATION_METHOD_TYPE.getId(),
                    accessionDTO.getGerminationMethodTypeId()).getName());

        }
        return accessionDTO;
    }

    /**
     * Search passports id for each part if the query string. It search for
     * passport Id, material type, mission number, and gathering id
     * @param parts
     * @return
     */
    private Set<Long> unstructeredAccessionQuery(String[] parts)
    {
        Set<Long> accessionList = new HashSet();
        Long id = null;
        List<Long> accessionId = null;
        Accession entity = null;



        for (int i = 0; i < parts.length; i++)
        {
            accessionId = accessionEAOLocal.findByAccessionNumber(parts[i]);
            if(accessionId != null && !accessionId.isEmpty())
                accessionList.addAll(accessionId);

            //try to cast it
            try
            {
                id = Long.parseLong(parts[i]);
                

                //find by accession parent id
                accessionId = accessionEAOLocal.findByAccessionParentId(id);
                if(accessionId != null && !accessionId.isEmpty())
                    accessionList.addAll(accessionId);

                //find by current weigth
                accessionId = accessionEAOLocal.findByCurrentWeigth(id);
                if(accessionId != null && !accessionId.isEmpty())
                    accessionList.addAll(accessionId);

                //find by original weigth
                accessionId = accessionEAOLocal.findByOriginalWeigth(id);
                if(accessionId != null && !accessionId.isEmpty())
                    accessionList.addAll(accessionId);

                //find by packages number
                accessionId = accessionEAOLocal.findByPackages(id);
                if(accessionId != null && !accessionId.isEmpty())
                    accessionList.addAll(accessionId);

                //find by passport Id
                accessionId = accessionEAOLocal.findByPassportId(id);
                if(accessionId != null && !accessionId.isEmpty())
                    accessionList.addAll(accessionId);
            }
            catch(Exception e){}
        }
        return accessionList;
    }

    public Long saveAccession(AccessionDTO accessionDTO) {
        Accession accession = accessionDTOFactory.createPlainEntity(accessionDTO);
        accessionEAOLocal.create(accession);
        return accession.getAccessionId();
    }

    public AccessionDTO updateAccession(AccessionDTO accessionDTO) {

        Accession accession = accessionEAOLocal.findById(
                Accession.class, accessionDTO.getAccessionId());

        Long weightRemoved = new Long(0);
        
        if(accession.getOriginalWeigth() != null)
        {
            weightRemoved = accession.getOriginalWeigth() - accession.getCurrentWeigth();

            if(accessionDTO.getOriginalWeigth() < weightRemoved)
                throw new IllegalArgumentException("error_low_weight");
        }

        accessionDTOFactory.updatePlainEntity(accessionDTO, accession);

        if(accessionDTO.getOriginalWeigth() != null)
            accession.setCurrentWeigth(accessionDTO.getOriginalWeigth() - weightRemoved);

        accessionEAOLocal.update(accession);

        accessionDTO.setCurrentWeigth(accession.getCurrentWeigth());
        
        return accessionDTO;
    }





    
    public void saveAccessionMovement(AccessionMovementDTO accessionMovementDTO)throws IllegalArgumentException  {
        AccessionMovement accessionMovement = accessionMovementDTOFactory.createPlainEntity(accessionMovementDTO);
        accessionMovement.getAccessionMovementPK().setAccessionMovementDate(new GregorianCalendar().getTime());

        Accession accession = accessionEAOLocal.findById(Accession.class, accessionMovementDTO.getAccessionId());
        if(accession.getOriginalWeigth() != null && accession.getCurrentWeigth() != null)
        {
            if(accession.getCurrentWeigth() == 0)
                throw new IllegalArgumentException("error_current_weight_zero");

            if((accession.getCurrentWeigth() < accessionMovementDTO.getWeight()))
                throw new IllegalArgumentException("error_not_enough_weight");

            accession.setCurrentWeigth(accession.getCurrentWeigth() - accessionMovementDTO.getWeight());
            accessionEAOLocal.update(accession);
            
            accessionMovementEAOLocal.create(accessionMovement);

        }
        else
            throw new IllegalArgumentException("error_current_weight_null");
        
    }

    public void updateAccessionMovement(AccessionMovementDTO accessionMovementDTO) {
        AccessionMovement accessionMovement =
                accessionMovementEAOLocal.findByAccessionIdAndDateTime(
                accessionMovementDTO.getAccessionId(), accessionMovementDTO.getAccessionMovementDate());

        Accession accession = accessionEAOLocal.findById(Accession.class, accessionMovementDTO.getAccessionId());

        accession.setCurrentWeigth(
                accession.getCurrentWeigth() +
                accessionMovement.getWeight());

        if(accession.getOriginalWeigth() != null && accession.getCurrentWeigth() != null)
        {
            if(accession.getCurrentWeigth() == 0)
                throw new IllegalArgumentException("error_current_weight_zero");

            if((accession.getCurrentWeigth() < accessionMovementDTO.getWeight()))
                throw new IllegalArgumentException("error_not_enough_weight");

            accession.setCurrentWeigth(accession.getCurrentWeigth() - accessionMovementDTO.getWeight());
            accessionEAOLocal.update(accession);

        }

        accessionMovement.setWeight(accessionMovementDTO.getWeight());

        accessionMovementEAOLocal.update(accessionMovement);
    }

    public AccessionDTO deleteAccessionMovement(AccessionMovementDTO accessionMovementDTO) {
        AccessionMovement accessionMovement =
                accessionMovementEAOLocal.findByAccessionIdAndDateTime(
                accessionMovementDTO.getAccessionId(), accessionMovementDTO.getAccessionMovementDate());

        //delete the accession movement
        accessionMovementEAOLocal.delete(accessionMovement);

        //get the accession and update the current weight
        Accession accession = accessionEAOLocal.findById(Accession.class, accessionMovementDTO.getAccessionId());
        accession.setCurrentWeigth(accession.getCurrentWeigth() + accessionMovementDTO.getWeight());
        accessionEAOLocal.update(accession);

        //return the accessionDTO with the new weight value
        return accessionDTOFactory.createDTO(accession);
    }

    public List<AccessionMovementDTO> getAllAccessionMovementByAccesionIdPaginated(Long accessionId, int firstResult, int maxResult) {
        List<AccessionMovementDTO> accessionMovementDTOList =
                accessionMovementDTOFactory.createDTOList(
                accessionMovementEAOLocal.findAllPaginatedByAccessionId(accessionId));
        return updateAccessionMovementDTOListValues(accessionMovementDTOList);
    }

    /**
     * Update values for an Accession movement list
     * @param accessionMovementDTOList
     * @return List<AccessionMovementDTO>
     */
    public List<AccessionMovementDTO> updateAccessionMovementDTOListValues(List<AccessionMovementDTO> accessionMovementDTOList)
    {
        for (AccessionMovementDTO accessionMovementDTO : accessionMovementDTOList)
        {
            updateAccessionMovementDTOValue(accessionMovementDTO);
        }
        return accessionMovementDTOList;
    }

    /**
     * Update values for  accession movements. put: responsable person, and
     * movement type id.
     * @param accessionMovementDTO
     * @return AccessionMovementDTO
     */
    public AccessionMovementDTO updateAccessionMovementDTOValue(AccessionMovementDTO accessionMovementDTO)
    {
        accessionMovementDTO.setAccessionNumber(
                accessionEAOLocal.findById(
                Accession.class, accessionMovementDTO.getAccessionId()).getAccessionNumber());
        
        if(accessionMovementDTO.getResponsablePersonId() != null)
        {
            accessionMovementDTO.setResponsablePerson(personEAOLocal.
                    findById(
                    Person.class, accessionMovementDTO.getResponsablePersonId()).
                    getNaturalLongName());
        }
        if(accessionMovementDTO.getAccessionMovementTypeId() != null)
        {
            accessionMovementDTO.setAccessionMovementType(
            selectionListValueLocalEAO.
                    findById(
                    SelectionListEntity.ACCESSION_MOVEMENT_TYPE.getId(),
                    accessionMovementDTO.getAccessionMovementTypeId()).getName());
        }
        return accessionMovementDTO;
    }

    public Long countAccessionMovements(Long accessionId) {
        return accessionMovementEAOLocal.countAllByAccessionId(accessionId);
    }

    public List<AccessionMovementDTO> getAccessionMovementsSimpleSearch(String query, Long collectionId, int firstResult, int maxResult) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<AccessionMovementDTO> getAccessionMovementsAdvancedSearch(AccessionMovementDTO accessionMovement, Long collectionId, int firstResult, int maxResult) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Long countAccessionMovementsSimpleSearch(String query, Long collectionId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Long countAccessionMovementsAdvancedSearch(AccessionMovementDTO accessionMovement, Long collectionId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<PersonDTO> getResponsablePersons() {
        return personDTOFactory.createDTOList(personEAOLocal.
                findByProfile(ProfileEntity.RESPONSABLE_PERSON_GERMPLASM_PROFILE.getId()));
    }


    public boolean haveMovementsAndAccessions(Long accessionId)
    {
        List<AccessionMovement> accessionMovementList = accessionMovementEAOLocal.findAllPaginatedByAccessionId(accessionId);
        if(accessionMovementList != null && !accessionMovementList.isEmpty())
            return true;

        List<Long> accessionsList = accessionEAOLocal.findByAccessionParentId(accessionId);
        if(accessionsList != null && !accessionsList.isEmpty())
            return true;

        else
            return false;
    }

    public void deleteAccession(Long accessionId)
    {
        Accession accession = accessionEAOLocal.findById(Accession.class, accessionId);
        accessionEAOLocal.delete(accession);
    }

    public AccessionDTO addToAccessionCurrentWeight(AccessionDTO accessionDTO, Long weigth) {
        Accession accession = accessionEAOLocal.findById(Accession.class, accessionDTO.getAccessionId());

        accession.setCurrentWeigth(accession.getCurrentWeigth() + weigth);

        accessionEAOLocal.update(accession);
        return accessionDTOFactory.createDTO(accession);
    }

    public void deletePassport(Long passportId) {
        Passport passport = passportEAOLocal.findById(Passport.class, passportId);
        passportEAOLocal.delete(passport);
    }

    public boolean haveAccessions(Long passportId) {
        List<Long> accessionList = accessionEAOLocal.findByPassportId(passportId);
        if(accessionList != null && !accessionList.isEmpty())
            return true;
        else
            return false;
    }

    public void saveBreed(BreedDTO breedDTO) {
        Breed breed = breedDTOFactory.createPlainEntity(breedDTO);
        breedEAOLocal.create(breed);
    }

    public void updateBreed(BreedDTO breedDTO) {
        Breed breed = breedEAOLocal.findById(Breed.class, breedDTO.getBreedId());
        breedDTOFactory.updatePlainEntity(breedDTO, breed);
        breedEAOLocal.update(breed);
    }

    public List<BreedDTO> getAllBreedPaginated(int firstResult, int maxResult) {
        String[] parts = {"name"};
        return updateBreedDTOListValues(breedDTOFactory.createDTOList(breedEAOLocal.findAllPaginatedFilterAndOrderBy(
                Breed.class, firstResult, maxResult,parts, null)));
    }

    public Long countAllBreed() {
        return breedEAOLocal.count(Breed.class);
    }

    public List<BreedDTO> getBreedSimpleSearch(String query, int firstResult, int maxResult) {
        Set<Long> breedIds = unstructeredBreedQuery(splitQuery(query));
        List<Breed> breedList = getEntities(breedIds, Breed.class, firstResult, maxResult);
        return updateBreedDTOListValues(breedDTOFactory.createDTOList(breedList));
    }

    public Long countBreedSimpleSearch(String query) {
        Integer quantity = new Integer(unstructeredBreedQuery(splitQuery(query)).size());
        return quantity.longValue();
    }

    /**
     * Use this method for breed simple search
     * Search by: name and scientific name
     * @param parts
     * @return Set<Long>
     */
    private Set<Long> unstructeredBreedQuery(String[] parts)
    {
        Set<Long> list = new HashSet();
        List<Long> ids = null;



        for (int i = 0; i < parts.length; i++)
        {
            //try to cast it
            try
            {
                //find by breed
                ids = breedEAOLocal.findByBreedName(parts[i]);
                if(ids != null && !ids.isEmpty())
                    list.addAll(ids);
                //find by scientific name
                ids = breedEAOLocal.findByScientificName(parts[i]);
                if(ids != null && !ids.isEmpty())
                    list.addAll(ids);

            }
            catch(Exception e){}
        }
        return list;
    }

    public SementalDTO saveSemental(SementalDTO sementalDTO) {
        Semental semental = sementalDTOFactory.createPlainEntity(sementalDTO);
        sementalEAOLocal.create(semental);
        return sementalDTOFactory.createDTO(semental);
    }

    public void updateSemental(SementalDTO sementalDTO) {
        Semental semental = sementalEAOLocal.findById(Semental.class, sementalDTO.getSementalId());
        sementalDTOFactory.updatePlainEntity(sementalDTO, semental);
        sementalEAOLocal.update(semental);
    }

    public List<SementalDTO> getAllSementalPaginated(int firstResult, int maxResult) {
        String[] parts = {"breedId","name","animalCode"};
        return updateSementalDTOListValues(sementalDTOFactory.createDTOList(
                sementalEAOLocal.findAllPaginatedFilterAndOrderBy(
                Semental.class, firstResult, maxResult, parts, null)));
    }

    public Long countAllSemental() {
        return sementalEAOLocal.count(Semental.class);
    }

    public List<SementalDTO> getSementalSimpleSearch(String query, int firstResult, int maxResult) {

        Set<Long> sementalIds = unstructeredSementalQuery(splitQuery(query));
        List<Semental> sementalList = getEntities(sementalIds, Semental.class, firstResult, maxResult);
        return updateSementalDTOListValues(sementalDTOFactory.createDTOList(sementalList));
    }

    public Long countSementalSimpleSearch(String query) {
        Integer quantity = new Integer(unstructeredSementalQuery(splitQuery(query)).size());
        return quantity.longValue();
    }

    /**
     * Use this method for semental simple search:
     * unstructuredSementalQuery: search by breed name, animal name, animal code,
     * veterinarian status,condition and animal description
     * @param parts
     * @return Set<Long>
     */
    private Set<Long> unstructeredSementalQuery(String[] parts)
    {
        Set<Long> list = new HashSet();
        List<Long> ids = null;



        for (int i = 0; i < parts.length; i++)
        {
            //try to cast it
            try
            {
                //find by breed
                ids = sementalEAOLocal.findByBreedName(parts[i]);
                if(ids != null && !ids.isEmpty())
                    list.addAll(ids);

                //find by name
                ids = sementalEAOLocal.findByAnimalName(parts[i]);
                if(ids != null && !ids.isEmpty())
                    list.addAll(ids);

                //find by animal code
                ids = sementalEAOLocal.findByAnimalCode(parts[i]);
                if(ids != null && !ids.isEmpty())
                    list.addAll(ids);

                //find by veterinarian status
                ids = sementalEAOLocal.findByVeterinarianStatus(parts[i]);
                if(ids != null && !ids.isEmpty())
                    list.addAll(ids);

                //find by condition
                ids = sementalEAOLocal.findByCondition(parts[i]);
                if(ids != null && !ids.isEmpty())
                    list.addAll(ids);

                //find by animal description
                ids = sementalEAOLocal.findByAnimalDescription(parts[i]);
                if(ids != null && !ids.isEmpty())
                    list.addAll(ids);
            }
            catch(Exception e){}
        }
        return list;
    }

    public List<SementalDTO> getSementalAdvancedSearch(SementalDTO sementalDTO, int firstResult, int maxResult) {
        Set<Long> ids = getSementalsByCriteria(sementalDTO);

        //Retrieve entities
        List<Semental> list = getEntities(ids,
                Semental.class, firstResult, maxResult);

        return updateSementalDTOListValues(sementalDTOFactory.createDTOList(list));

    }

    public Long countSementalAdvancedSearch(SementalDTO sementalDTO) {
        Integer quantity = new Integer(getSementalsByCriteria(sementalDTO).size());
        return quantity.longValue();
    }

    /**
     * Use this method for sementals advance search:
     * getElementsByCriteria: searh by, name, animal code, color,
     * veterinarian status, father, mother, bith date, breed, site, condition
     * @param sementalDTO
     * @return  Set<Long>
     */
    public Set<Long> getSementalsByCriteria(SementalDTO sementalDTO)
    {
         Set<Long> ids = new HashSet();
        boolean firstTime = true;

        List<Long> query = new ArrayList<Long>();

        //find by name
        if(sementalDTO.getName() != null)
        {
            query = sementalEAOLocal.findByAnimalName(sementalDTO.getName());
            if(query != null && !query.isEmpty())
            {
                ids.addAll(query);
                firstTime = false;
            }
        }

        //find by animal code
        if(sementalDTO.getAnimalCode() != null)
        {
            query = sementalEAOLocal.findByAnimalCode(sementalDTO.getAnimalCode());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        //find by Color
        if(sementalDTO.getColor() != null)
        {
            query = sementalEAOLocal.findByColor(sementalDTO.getColor());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        //find by veterinarian status
        if(sementalDTO.getVeterinarianStatus() != null)
        {
            query = sementalEAOLocal.findByVeterinarianStatus(sementalDTO.getVeterinarianStatus());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        //find by father
        if(sementalDTO.getFather() != null)
        {
            query = sementalEAOLocal.findByFather(sementalDTO.getFather());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        //find by Mother
        if(sementalDTO.getMother() != null)
        {
            query = sementalEAOLocal.findByMother(sementalDTO.getMother());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        //find by birth date
        if(sementalDTO.getBirthDate() != null)
        {
            query = sementalEAOLocal.findByBirthDate(sementalDTO.getBirthDate());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        //find by breed
        if(sementalDTO.getBreedId() != null)
        {
            query = sementalEAOLocal.findByBreedId(sementalDTO.getBreedId());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        //find by Site
        if(sementalDTO.getSiteId() != null)
        {
            query = sementalEAOLocal.findByLocalityId(sementalDTO.getSiteId());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        //find by condition
        if(sementalDTO.getConditionId() != null)
        {
            query = sementalEAOLocal.findByConditionId(sementalDTO.getConditionId());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }


       
        return ids;
    }

    

    public void saveSemenGathering(SemenGatheringDTO semenGatheringDTO) {
        SemenGathering semenGathering = semenGatheringDTOFactory.createPlainEntity(semenGatheringDTO);
        semenGatheringEAOLocal.create(semenGathering);
    }

    public void updateSemenGathering(SemenGatheringDTO semenGatheringDTO) {
        SemenGathering semenGathering = semenGatheringEAOLocal.findById(SemenGathering.class, semenGatheringDTO.getSemenGatheringId());
        semenGatheringDTOFactory.updatePlainEntity(semenGatheringDTO, semenGathering);
        semenGatheringEAOLocal.update(semenGathering);
    }

    public List<SemenGatheringDTO> getAllSemenGatheringPaginated(Long sementalId, int firstResult, int maxResult) {
        return updateSemenGatheringDTOListValues(semenGatheringDTOFactory.createDTOList(
                semenGatheringEAOLocal.findAllBySementalId(sementalId, firstResult, maxResult)));
    }

    public Long countAllSemenGathering(Long sementalId) {
        return semenGatheringEAOLocal.countAllBySementalId(sementalId);
    }

    public List<SemenGatheringDTO> getSemenGatheringlSimpleSearch(String query, int firstResult, int maxResult) {
        
        Set<Long> semengatheringIds = unstructeredSemenGatheringQuery(splitQuery(query));
        List<SemenGathering> semenGatheringList = getEntities(semengatheringIds, SemenGathering.class, firstResult, maxResult);
        return updateSemenGatheringDTOListValues(semenGatheringDTOFactory.createDTOList(semenGatheringList));
    }

    public Long countSemenGatheringSimpleSearch(String query) {

        Integer quantity = new Integer(unstructeredSemenGatheringQuery(splitQuery(query)).size());
        return quantity.longValue();
    }

    /**
     * Use this method for simples simple seach. seach by, dilution name,
     * volume, motility, concentration, straw quantity, straw size, quantity,
     * tank number, canister number, goblet number,ptm, active doses
     * @param parts
     * @return
     */
    private Set<Long> unstructeredSemenGatheringQuery(String[] parts)
    {
        Set<Long> list = new HashSet();
        List<Long> ids = null;

        Long id;

        for (int i = 0; i < parts.length; i++)
        {
            //find by Dilution
            ids = semenGatheringEAOLocal.findByDilution(parts[i]);
            if(ids != null && !ids.isEmpty())
                list.addAll(ids);
            //try to cast it
            try
            {
                id = Long.parseLong(parts[i]);

                //find by volume
                ids = semenGatheringEAOLocal.findByVolume(id);
                if(ids != null && !ids.isEmpty())
                    list.addAll(ids);

                //find by motility
                ids = semenGatheringEAOLocal.findByMotility(id);
                if(ids != null && !ids.isEmpty())
                    list.addAll(ids);

                //find by Concentration
                ids = semenGatheringEAOLocal.findByConcentration(id);
                if(ids != null && !ids.isEmpty())
                    list.addAll(ids);

                //find by StrawQuantity
                ids = semenGatheringEAOLocal.findByStrawQuantity(id);
                if(ids != null && !ids.isEmpty())
                    list.addAll(ids);

                //find by StrawSize
                ids = semenGatheringEAOLocal.findByStrawSize(id);
                if(ids != null && !ids.isEmpty())
                    list.addAll(ids);

                

                //find by TankNumber
                ids = semenGatheringEAOLocal.findByTankNumber(id);
                if(ids != null && !ids.isEmpty())
                    list.addAll(ids);

                //find by CanisterNumber
                ids = semenGatheringEAOLocal.findByCanisterNumber(id);
                if(ids != null && !ids.isEmpty())
                    list.addAll(ids);

                //find by GobletNumber
                ids = semenGatheringEAOLocal.findByGobletNumber(id);
                if(ids != null && !ids.isEmpty())
                    list.addAll(ids);

                //find by PostThawMotility
                ids = semenGatheringEAOLocal.findByPostThawMotility(id);
                if(ids != null && !ids.isEmpty())
                    list.addAll(ids);

                //find by ActiveDoses
                ids = semenGatheringEAOLocal.findByActiveDoses(id);
                if(ids != null && !ids.isEmpty())
                    list.addAll(ids);
            }
            catch(Exception e){}
        }
        return list;
    }

    public List<SemenGatheringDTO> getSemenGatheringAdvancedSearch(SemenGatheringDTO semenGatheringDTO, int firstResult, int maxResult) {
        Set<Long> ids = getSemenGatheringsByCriteria(semenGatheringDTO);

        //Retrieve entities
        List<SemenGathering> list = getEntities(ids,
                SemenGathering.class, firstResult, maxResult);

        return updateSemenGatheringDTOListValues(semenGatheringDTOFactory.createDTOList(list));
    }

    public Long countSemenGatheringAdvancedSearch(SemenGatheringDTO semenGatheringDTO) {
        Integer quantity = new Integer(getSemenGatheringsByCriteria(semenGatheringDTO).size());
        return quantity.longValue();
    }

    /**
     * Use this method for advance search for semen gathering
     * Search semenGathering By criteria: search by: semen gathering date,
     * semenGatheringTime, volume,motility,concentration, strawSize,straw quantity,
     * straw color,dilution, tank number, canister number, goblet number, gathering method,
     * solvent, active doses, ptm, ph mass motility.
     * @param semenGatheringDTO
     * @return
     */
    public Set<Long> getSemenGatheringsByCriteria(SemenGatheringDTO semenGatheringDTO)
    {
         Set<Long> ids = new HashSet();
        boolean firstTime = true;

        List<Long> query = new ArrayList<Long>();

        //find by gathering date
        if(semenGatheringDTO.getSemenGatheringDate() != null && semenGatheringDTO.getFinalSemenGatheringDate() != null)
        {
            query = semenGatheringEAOLocal.findBySemenGatheringDate(semenGatheringDTO.getSemenGatheringDate(), semenGatheringDTO.getFinalSemenGatheringDate());
            if(query != null && !query.isEmpty())
            {
                ids.addAll(query);
                firstTime = false;
            }
        }

        

        //find by volume
        if(semenGatheringDTO.getVolume() != null)
        {
            query = semenGatheringEAOLocal.findByVolume(semenGatheringDTO.getVolume());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        //find by Motility
        if(semenGatheringDTO.getMotility() != null)
        {
            query = semenGatheringEAOLocal.findByMotility(semenGatheringDTO.getMotility());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        //find by concentration
        if(semenGatheringDTO.getConcentration() != null)
        {
            query = semenGatheringEAOLocal.findByConcentration(semenGatheringDTO.getConcentration());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        //find by straw size
        if(semenGatheringDTO.getStrawSize() != null)
        {
            query = semenGatheringEAOLocal.findByStrawSize(semenGatheringDTO.getStrawSize());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        //find by dilution
        if(semenGatheringDTO.getDilution() != null)
        {
            query = semenGatheringEAOLocal.findByDilution(semenGatheringDTO.getDilution());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        //find by tank number
        if(semenGatheringDTO.getTankNumber() != null)
        {
            query = semenGatheringEAOLocal.findByTankNumber(semenGatheringDTO.getTankNumber());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        //find by canister number
        if(semenGatheringDTO.getCanisterNumber() != null)
        {
            query = semenGatheringEAOLocal.findByCanisterNumber(semenGatheringDTO.getCanisterNumber());
            if(query != null && !query.isEmpty())
            {System.out.println("entro canister = " + semenGatheringDTO.getCanisterNumber());
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        //find by goblet number
        if(semenGatheringDTO.getGobletNumber() != null)
        {
            query = semenGatheringEAOLocal.findByGobletNumber(semenGatheringDTO.getGobletNumber());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        //find by straw color
        if(semenGatheringDTO.getStrawColor() != null)
        {
            query = semenGatheringEAOLocal.findByStrawColor(semenGatheringDTO.getStrawColor());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        //find by ptm
        if(semenGatheringDTO.getPostThawMotility() != null)
        {
            query = semenGatheringEAOLocal.findByPostThawMotility(semenGatheringDTO.getPostThawMotility());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        //find by active doses
        if(semenGatheringDTO.getActiveDoses() != null)
        {
            query = semenGatheringEAOLocal.findByActiveDoses(semenGatheringDTO.getActiveDoses());
            if(query != null && !query.isEmpty())
            {
                if(firstTime)
                {
                    ids.addAll(query);
                    firstTime = false;
                }
                else
                    ids.retainAll(query);
            }
        }

        return ids;
    }

    /**
     * Update the values of a BreedDTO list
     * @param listBreedDTO
     * @return List<BreedDTO>
     */
    private List<BreedDTO> updateBreedDTOListValues(List<BreedDTO> listBreedDTO)
    {
        for (BreedDTO breedDTO : listBreedDTO)
        {
            updateBreedDTOValue(breedDTO);
        }
        return listBreedDTO;
    }

    /**
     * Update the values of a BreedDTO: search the taxon name
     * @param breedDTO
     * @return BreedDTO
     */
    private BreedDTO updateBreedDTOValue(BreedDTO breedDTO)
    {
        if(breedDTO.getTaxonId() != null)
        {
            breedDTO.setTaxonName(taxonEAOLocal.findById(
                    Taxon.class, breedDTO.getTaxonId()).getDefaultName());
        }
        return breedDTO;
    }

    /**
     * Upate the values of  SementalDTO list
     * @param listSementalDTO
     * @return  List<SementalDTO>
     */
    private List<SementalDTO> updateSementalDTOListValues(List<SementalDTO> listSementalDTO)
    {
        for (SementalDTO sementalDTO : listSementalDTO)
        {
            updateSementalDTOValues(sementalDTO);
        }
        return listSementalDTO;
    }

    /**
     * Update the values of a SementalDTO: search the condition name and the breed name
     * @param sementalDTO
     * @return SementalDTO
     */
    private SementalDTO updateSementalDTOValues(SementalDTO sementalDTO)
    {
        if(sementalDTO.getConditionId() != null)
        {
            sementalDTO.setCondition(
                    selectionListValueLocalEAO.
                    findById(
                    SelectionListEntity.CONDITION.getId(),
                    sementalDTO.getConditionId()).getName());
        }
        if(sementalDTO.getBreedId() != null)
        {
            sementalDTO.setBreed(
                    breedEAOLocal.findById(
                    Breed.class, sementalDTO.getBreedId()).getName());
        }
        return sementalDTO;
    }

    /**
     * Update the values of a SemenGatheringDTO list
     * @param listSGDTO
     * @return List<SemenGatheringDTO>
     */
    private List<SemenGatheringDTO> updateSemenGatheringDTOListValues(List<SemenGatheringDTO> listSGDTO)
    {
        for (SemenGatheringDTO semenGatheringDTO : listSGDTO)
        {
            updateSemenGatheringDTOValues(semenGatheringDTO);
        }
        return listSGDTO;
    }

    /**
     * Update the values of a SemenGatheringDTO: put the gathering method name,
     * and solvent id.
     * @param sgDTO
     * @return SemenGatheringDTO
     */
    private SemenGatheringDTO updateSemenGatheringDTOValues(SemenGatheringDTO sgDTO)
    {
        if(sgDTO.getSemenGatheringMethodId() != null)
        {
            sgDTO.setSemenGatheringMethod(
                    selectionListValueLocalEAO.
                    findById(
                    SelectionListEntity.SEMEN_GATHERING_METHOD.getId(),
                    sgDTO.getSemenGatheringMethodId()).getName());
        }
        if(sgDTO.getSolventId() != null)
        {
            sgDTO.setSolvent(
            selectionListValueLocalEAO.
                    findById(
                    SelectionListEntity.SOLVENT.getId(),
                    sgDTO.getSolventId()).getName());
        }
        return sgDTO;
    }

    public List<BreedDTO> getAllBreeds() {
        return breedDTOFactory.createDTOList(breedEAOLocal.findAll(Breed.class));
    }

    public boolean haveSementals(Long breedId) {
        List<Long> sementalList = sementalEAOLocal.findByBreedId(breedId);
        if(sementalList != null && !sementalList.isEmpty())
            return true;
        else
            return false;

    }

    public boolean haveSemenGathering(Long sementalId) {
        List<SemenGathering> semenGatheringList = semenGatheringEAOLocal.findAllBySementalId(sementalId, 0, 10);
        if(semenGatheringList != null && !semenGatheringList.isEmpty())
            return true;
        else
            return false;
    }

    public void deleteBreed(Long breedId) {
        Breed breed = breedEAOLocal.findById(Breed.class, breedId);
        breedEAOLocal.delete(breed);
    }

    public void deleteSemental(Long sementalId) {
        Semental semental = sementalEAOLocal.findById(Semental.class, sementalId);
        sementalEAOLocal.delete(semental);
    }

    public void deleteSemenGathering(Long semenGatheringId) {
        SemenGathering semenGathering = semenGatheringEAOLocal.findById(SemenGathering.class, semenGatheringId);
        semenGatheringEAOLocal.delete(semenGathering);
    }

    public List<TaxonDTO> getAllTaxonsByPlantaeKingdomAndTaxonomicalRangeId(Long taxonomicalRangeId) {
        return taxonDTOFactory.createDTOList(taxonEAOLocal.
                getTaxonsByKingdomNameAndTaxonomicalRangeId("Plantae", taxonomicalRangeId));
    }

    public List<TaxonDTO> getAllTaxonsByAnimaliaKingdomAndTaxonomicalRangeId(Long taxonomicalRangeId) {
        return taxonDTOFactory.createDTOList(taxonEAOLocal.
                getTaxonsByKingdomNameAndTaxonomicalRangeId("Animalia", taxonomicalRangeId));
    }
}