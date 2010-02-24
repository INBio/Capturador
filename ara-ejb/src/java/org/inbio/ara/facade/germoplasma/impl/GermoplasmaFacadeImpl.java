/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.facade.germoplasma.impl;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import org.inbio.ara.dto.germoplasma.PassportDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.dto.security.NomenclaturalGroupDTO;
import org.inbio.ara.facade.germoplasma.*;
import javax.ejb.Stateless;
import org.inbio.ara.dto.germoplasma.PassportDTOFactory;
import org.inbio.ara.dto.germoplasma.PassportNomenclaturalGroupDTO;
import org.inbio.ara.dto.germoplasma.PassportNomenclaturalGroupDTOFactory;
import org.inbio.ara.dto.inventory.PersonDTOFactory;
import org.inbio.ara.dto.inventory.SelectionListDTOFactory;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.dto.inventory.TaxonDTOFactory;
import org.inbio.ara.dto.security.NomenclaturalGroupDTOFactory;
import org.inbio.ara.eao.agent.InstitutionEAOLocal;
import org.inbio.ara.eao.agent.PersonEAOLocal;
import org.inbio.ara.eao.germoplasma.PassportEAOLocal;
import org.inbio.ara.eao.germoplasma.PassportNomenclaturalGroupEAOLocal;
import org.inbio.ara.eao.security.NomenclaturalGroupEAOLocal;
import org.inbio.ara.eao.selectionlist.SelectionListValueLocalEAO;
import org.inbio.ara.eao.taxonomy.TaxonEAOLocal;
import org.inbio.ara.eao.taxonomy.TaxonomicalRangeEAOLocal;
import org.inbio.ara.facade.search.SearchFacadeRemote;
import org.inbio.ara.persistence.SelectionListGenericEntity;
import org.inbio.ara.persistence.germoplasma.Passport;
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
public class GermoplasmaFacadeImpl implements GermoplasmaFacadeRemote {


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
        List<PassportDTO> listPassport =  passportDTOFactory.createDTOList(
                passportEAOLocal.findAllPaginated(Passport.class, firstResult, maxResults));
        
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

        passport.setCropSystemId(passportDTO.getCropSystemId());
        passport.setCropTypeId(passportDTO.getCropTypeId());
        passport.setCultivationPracticeId(passportDTO.getCultivationPracticeId());
        passport.setDonorInstitutionId(passportDTO.getDonorInstitutionId());
        passport.setDonorPersonId(passportDTO.getDonorPersonId());
        passport.setGatheringId(passportDTO.getGatheringId());
        passport.setGatheringSourceId(passportDTO.getGatheringSourceId());
        passport.setHarvestingSeasonDate(passportDTO.getHarvestingSeasonDate());

        passport.setLastModificationBy(passportDTO.getUserName());
        passport.setLastModificationDate(new GregorianCalendar());

        passport.setMaterialTypeId(passportDTO.getMaterialTypeId());
        passport.setMissionNumber(passportDTO.getMissionNumber());
        passport.setPlantNurseryDate(passportDTO.getPlantNurseryDate());
        passport.setPlantingSeasonDate(passportDTO.getPlantingSeasonDate());
        passport.setRemarks(passportDTO.getRemarks());
        passport.setResistant(passportDTO.getResistant());
        passport.setSampleStatusId(passportDTO.getSampleStatusId());
        passport.setSoilColorId(passportDTO.getSoilColorId());
        passport.setSoilTextureId(passportDTO.getSoilTextureId());


        //passportEAOLocal.update(
        //        passportDTOFactory.createPlainEntity(passportDTO));
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
}