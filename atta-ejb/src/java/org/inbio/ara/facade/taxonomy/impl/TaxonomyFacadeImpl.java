/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Nacional de Biodiversidad)
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
package org.inbio.ara.facade.taxonomy.impl;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import org.inbio.ara.facade.taxonomy.TaxonomyFacadeRemote;
import javax.ejb.Stateless;
import org.inbio.ara.dto.agent.AudienceDTO;
import org.inbio.ara.dto.agent.AudienceDTOFactory;
import org.inbio.ara.dto.agent.CollectionDTO;
import org.inbio.ara.dto.agent.CollectionDTOFactory;
import org.inbio.ara.dto.agent.InstitutionDTO;
import org.inbio.ara.dto.agent.InstitutionDTOFactory;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.dto.inventory.PersonDTOFactory;
import org.inbio.ara.dto.inventory.TaxonCategoryDTO;
import org.inbio.ara.dto.inventory.TaxonCategoryDTOFactory;
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.dto.inventory.TaxonDTOFactory;
import org.inbio.ara.dto.inventory.TaxonomicalRangeDTO;
import org.inbio.ara.dto.inventory.TaxonomicalRangeDTOFactory;
import org.inbio.ara.dto.security.NomenclaturalGroupDTO;
import org.inbio.ara.dto.security.NomenclaturalGroupDTOFactory;
import org.inbio.ara.dto.taxonomy.LanguageDTO;
import org.inbio.ara.dto.taxonomy.LanguageDTOFactory;
import org.inbio.ara.dto.taxonomy.PersonAuthorDTO;
import org.inbio.ara.dto.taxonomy.RegionDTO;
import org.inbio.ara.dto.taxonomy.RegionDTOFactory;
import org.inbio.ara.dto.taxonomy.TaxonAuthorDTO;
import org.inbio.ara.dto.taxonomy.TaxonAuthorDTOFactory;
import org.inbio.ara.dto.taxonomy.TaxonAuthorProfileDTO;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionAudienceDTO;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionAudienceDTOFactory;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionCategoryDTO;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionCategoryDTOFactory;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionDTO;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionDTOFactory;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionElementDTO;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionElementDTOFactory;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionInstitutionDTO;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionInstitutionDTOFactory;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionPersonProfileDTO;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionPersonProfileDTOFactory;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionRecordDTO;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionRecordDTOFactory;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionStageDTO;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionStageDTOFactory;
import org.inbio.ara.dto.taxonomy.TaxonIndicatorComponentPartDTO;
import org.inbio.ara.dto.taxonomy.TaxonIndicatorComponentPartDTOFactory;
import org.inbio.ara.dto.taxonomy.TaxonIndicatorCountryDTO;
import org.inbio.ara.dto.taxonomy.TaxonIndicatorCountryDTOFactory;
import org.inbio.ara.dto.taxonomy.TaxonIndicatorDTO;
import org.inbio.ara.dto.taxonomy.TaxonIndicatorDTOFactory;
import org.inbio.ara.dto.taxonomy.TaxonIndicatorDublinCoreDTO;
import org.inbio.ara.dto.taxonomy.TaxonIndicatorDublinCoreDTOFactory;
import org.inbio.ara.eao.agent.AudienceEAOLocal;
import org.inbio.ara.eao.agent.InstitutionEAOLocal;
import org.inbio.ara.eao.agent.PersonEAOLocal;
import org.inbio.ara.eao.agent.PersonProfileEAOLocal;
import org.inbio.ara.eao.collection.CollectionEAOLocal;
import org.inbio.ara.eao.gis.CountryEAOLocal;
import org.inbio.ara.eao.identification.IdentificationEAOLocal;
import org.inbio.ara.eao.security.NomenclaturalGroupEAOLocal;
import org.inbio.ara.eao.specimen.SpecimenEAOLocal;
import org.inbio.ara.eao.taxonomy.GeographicCatalogueEAOLocal;
import org.inbio.ara.eao.taxonomy.GeographicEntityEAOLocal;
import org.inbio.ara.eao.taxonomy.InteractionTypeEAOLocal;
import org.inbio.ara.eao.taxonomy.LanguageEAOLocal;
import org.inbio.ara.eao.taxonomy.NomenclaturalGroupRegionEAOLocal;
import org.inbio.ara.eao.taxonomy.ReferenceEAOLocal;
import org.inbio.ara.eao.taxonomy.ReferenceTypeEAOLocal;
import org.inbio.ara.eao.taxonomy.RegionEAOLocal;
import org.inbio.ara.eao.taxonomy.TaxonAuthorEAOLocal;
import org.inbio.ara.eao.taxonomy.TaxonCategoryEAOLocal;
import org.inbio.ara.eao.taxonomy.TaxonDescriptionAudienceEAOLocal;
import org.inbio.ara.eao.taxonomy.TaxonDescriptionCategoryEAOLocal;
import org.inbio.ara.eao.taxonomy.TaxonDescriptionEAOLocal;
import org.inbio.ara.eao.taxonomy.TaxonDescriptionElementEAOLocal;
import org.inbio.ara.eao.taxonomy.TaxonDescriptionInstitutionEAOLocal;
import org.inbio.ara.eao.taxonomy.TaxonDescriptionPersonProfileEAOLocal;
import org.inbio.ara.eao.taxonomy.TaxonDescriptionRecordEAOLocal;
import org.inbio.ara.eao.taxonomy.TaxonDescriptionRecordReferenceEAOLocal;
import org.inbio.ara.eao.taxonomy.TaxonDescriptionStageEAOLocal;
import org.inbio.ara.eao.taxonomy.TaxonEAOLocal;
import org.inbio.ara.eao.taxonomy.TaxonIndicatorComponentPartEAOLocal;
import org.inbio.ara.eao.taxonomy.TaxonIndicatorCountryEAOLocal;
import org.inbio.ara.eao.taxonomy.TaxonIndicatorDublinCoreEAOLocal;
import org.inbio.ara.eao.taxonomy.TaxonIndicatorEAOLocal;
import org.inbio.ara.eao.taxonomy.TaxonNomenclaturalGroupEAOLocal;
import org.inbio.ara.eao.taxonomy.TaxonomicalHierarchyEAOLocal;
import org.inbio.ara.eao.taxonomy.TaxonomicalRangeEAOLocal;
import org.inbio.ara.persistence.audiences.Audience;
import org.inbio.ara.persistence.collection.Collection;
import org.inbio.ara.persistence.gis.Country;
import org.inbio.ara.persistence.institution.Institution;
import org.inbio.ara.persistence.person.Person;
import org.inbio.ara.persistence.person.PersonProfile;
import org.inbio.ara.persistence.person.ProfileEntity;
import org.inbio.ara.persistence.taxonomy.GeographicCatalogue;
import org.inbio.ara.persistence.taxonomy.GeographicEntity;
import org.inbio.ara.persistence.taxonomy.InteractionType;
import org.inbio.ara.persistence.taxonomy.Language;
import org.inbio.ara.persistence.taxonomy.NomenclaturalGroup;
import org.inbio.ara.persistence.taxonomy.NomenclaturalGroupRegion;
import org.inbio.ara.persistence.taxonomy.NomenclaturalGroupRegionPK;
import org.inbio.ara.persistence.taxonomy.Reference;
import org.inbio.ara.persistence.taxonomy.ReferenceType;
import org.inbio.ara.persistence.taxonomy.Region;
import org.inbio.ara.persistence.taxonomy.Taxon;
import org.inbio.ara.persistence.taxonomy.TaxonAuthor;
import org.inbio.ara.persistence.taxonomy.TaxonAuthorProfile;
import org.inbio.ara.persistence.taxonomy.TaxonCategory;
import org.inbio.ara.persistence.taxonomy.TaxonDescription;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionAudience;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionAudiencePK;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionCategory;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionElement;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionInstitution;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionInstitutionPK;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionPK;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionPersonProfile;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionPersonProfilePK;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionRecord;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionRecordReference;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionStage;
import org.inbio.ara.persistence.taxonomy.TaxonIndicator;
import org.inbio.ara.persistence.taxonomy.TaxonIndicatorComponentPart;
import org.inbio.ara.persistence.taxonomy.TaxonIndicatorCountry;
import org.inbio.ara.persistence.taxonomy.TaxonIndicatorDublinCore;
import org.inbio.ara.persistence.taxonomy.TaxonNomenclaturalGroup;
import org.inbio.ara.persistence.taxonomy.TaxonNomenclaturalGroupPK;
import org.inbio.ara.persistence.taxonomy.TaxonomicalRange;

/**
 *
 * @author esmata
 */
@Stateless
public class TaxonomyFacadeImpl implements TaxonomyFacadeRemote {

    //Bean injections
    // <editor-fold defaultstate="collapsed" desc="comment">
    @EJB
    private TaxonDescriptionEAOLocal taxonDescriptionEAOImpl;
    @EJB
    private TaxonEAOLocal taxonEAOImpl;
    @EJB
    private LanguageEAOLocal languageEAOImpl;
    @EJB
    private TaxonDescriptionStageEAOLocal taxonDescriptionStageEAOImpl;
    @EJB
    private PersonEAOLocal personEAOImpl;
    @EJB
    private InstitutionEAOLocal institutionEAOImpl;
    @EJB
    private AudienceEAOLocal audienceEAOImpl;
    @EJB
    private TaxonDescriptionCategoryEAOLocal taxonDescriptionCategoryEAOImpl;
    @EJB
    private TaxonDescriptionElementEAOLocal taxonDescriptionElementEAOImpl;
    @EJB
    private TaxonDescriptionRecordEAOLocal taxonDescriptionRecordEAOImpl;
    @EJB
    private TaxonDescriptionRecordReferenceEAOLocal taxonDescriptionRecordReferenceEAOImpl;
    @EJB
    private ReferenceTypeEAOLocal referenceTypeEAOImpl;
    @EJB
    private ReferenceEAOLocal referenceEAOImpl;
    @EJB
    private InteractionTypeEAOLocal interactionTypeEAOImpl;
    @EJB
    private GeographicCatalogueEAOLocal geographicCatalogueEAOImpl;
    @EJB
    private GeographicEntityEAOLocal geographicEntityEAOImpl;
    @EJB
    private CountryEAOLocal countryEAOImpl;
    @EJB
    private SpecimenEAOLocal specimenEAOImpl;
    @EJB
    private TaxonDescriptionAudienceEAOLocal taxonDescriptionAudienceEAOImpl;
    @EJB
    private TaxonDescriptionInstitutionEAOLocal taxonDescriptionInstitutionEAOImpl;
    @EJB
    private TaxonDescriptionPersonProfileEAOLocal taxonDescriptionPersonProfileEAOImpl;
    @EJB
    private CollectionEAOLocal collectionEAOImpl;
    @EJB
    private TaxonomicalRangeEAOLocal taxonomicalRangeEAOImpl;
    @EJB
    private NomenclaturalGroupEAOLocal nomenclaturalGroupEAOImpl;
    @EJB
    private TaxonNomenclaturalGroupEAOLocal taxonNomenclaturalGroupEAOImpl;
    @EJB
    private NomenclaturalGroupRegionEAOLocal nomenclaturalGroupRegionEAOImpl;
    @EJB
    private IdentificationEAOLocal identificationEAOImpl;
    @EJB
    private TaxonomicalHierarchyEAOLocal taxonomicalHierarchyEAOImpl;
    @EJB
    private RegionEAOLocal regionEAOImpl;
    @EJB
    private TaxonCategoryEAOLocal taxonCategoryEAOImpl;
    @EJB
    private TaxonIndicatorEAOLocal taxonIndicatorEAOImpl;
    @EJB
    private TaxonIndicatorCountryEAOLocal taxonIndicatorCountryEAOImpl;
    @EJB
    private TaxonIndicatorDublinCoreEAOLocal taxonIndicatorDublinCoreEAOImpl;
    @EJB
    private TaxonIndicatorComponentPartEAOLocal taxonIndicatorComponentPartEAOImpl;
    @EJB
    private PersonProfileEAOLocal personProfileEAOImpl;
    @EJB
    private TaxonAuthorEAOLocal taxonAuthorEAOImpl;


    //DTO factories
    private TaxonDescriptionDTOFactory taxonDescriptionDTOFactory =
            new TaxonDescriptionDTOFactory();
    private TaxonDTOFactory taxonDTOFactory = new TaxonDTOFactory();
    private LanguageDTOFactory languageDTOFactory = new LanguageDTOFactory();
    private TaxonDescriptionStageDTOFactory taxonDescriptionStageDTOFactoty =
            new TaxonDescriptionStageDTOFactory();
    private PersonDTOFactory personDTOFactory = new PersonDTOFactory();
    private InstitutionDTOFactory institutionDTOFactory = new InstitutionDTOFactory();
    private AudienceDTOFactory audienceDTOFactoty = new AudienceDTOFactory();
    private TaxonDescriptionCategoryDTOFactory taxonDescriptionCategoryDTOFactory =
            new TaxonDescriptionCategoryDTOFactory();
    private TaxonDescriptionElementDTOFactory taxonDescriptionElementDTOFactory =
            new TaxonDescriptionElementDTOFactory();
    private TaxonDescriptionRecordDTOFactory taxonDescriptionRecordDTOFactory =
            new TaxonDescriptionRecordDTOFactory();
    private TaxonDescriptionAudienceDTOFactory taxonDescriptionAudienceDTOFactory =
            new TaxonDescriptionAudienceDTOFactory();
    private TaxonDescriptionPersonProfileDTOFactory taxonDescriptionPersonProfileDTOFactory =
            new TaxonDescriptionPersonProfileDTOFactory();
    private TaxonDescriptionInstitutionDTOFactory taxonDescriptionInstitutionDTOFactory =
            new TaxonDescriptionInstitutionDTOFactory();
    private CollectionDTOFactory collectionDTOFactory = new CollectionDTOFactory();
    private TaxonomicalRangeDTOFactory taxonomicalRangeDTOFactory =
            new TaxonomicalRangeDTOFactory();
    private NomenclaturalGroupDTOFactory nomenclaturalGroupDTOFatory =
            new NomenclaturalGroupDTOFactory();
    private RegionDTOFactory regionDTOFactory = new RegionDTOFactory();
    private TaxonCategoryDTOFactory taxonCategoryDTOFactory = new TaxonCategoryDTOFactory();
    private TaxonIndicatorDTOFactory taxonIndicatorDTOFactory = new TaxonIndicatorDTOFactory();
    private TaxonIndicatorCountryDTOFactory taxonIndicatorCountryDTOFactory = new TaxonIndicatorCountryDTOFactory();
    private TaxonIndicatorDublinCoreDTOFactory taxonIndicatorDublinCoreDTOFactory = new TaxonIndicatorDublinCoreDTOFactory();
    private TaxonIndicatorComponentPartDTOFactory taxonIndicatorComponentPartDTOFactory = new TaxonIndicatorComponentPartDTOFactory();
    private TaxonAuthorDTOFactory taxonAuthorDTOFactory = new TaxonAuthorDTOFactory();

    /**
     * Retorna un listado paginado de TaxonDescriptionDTO
     */
    public List<TaxonDescriptionDTO> getAllTaxonDescriptionPaginated(int first, int totalResults) {

        String[] order = {"taxon.defaultName"};
        List<TaxonDescription> tdList = taxonDescriptionEAOImpl.
                findAllPaginatedFilterAndOrderBy(
                TaxonDescription.class, first, totalResults,order,null);
        if (tdList == null) {
            return null;
        } else {
            List<TaxonDescriptionDTO> dtoList =
                    taxonDescriptionDTOFactory.createDTOList(tdList);
            return updateFamilyAndKingdom(dtoList);
        }
    }

    /**
     * Get the entities for a list of Longs
     * @param ids
     * @param t
     * @param base
     * @param offset
     * @return
     */
    private List getEntities(Set<TaxonDescriptionPK> ids, Class t, int base, int offset)
    {
        List entitiesList = new ArrayList();
        Object[] tdids = ids.toArray();
        TaxonDescriptionPK tdpk;
        int baseCounter = 0;
        int entitiesCounter = 0;
        for (int i = 0; i < ids.size(); i++)
        {

            if (baseCounter < base)
            {
                baseCounter++;
            }
            else if(entitiesCounter < offset)
            {
                if(t == TaxonDescription.class)
                {
                    tdpk = (TaxonDescriptionPK)tdids[i];
                    entitiesList.add(taxonDescriptionEAOImpl.
                        findByPK(tdpk.getTaxonId(),tdpk.getTaxonDescriptionSequence()));
                }
                entitiesCounter++;
            }
        }
        return entitiesList;
    }

    public Long countTaxonDescriptionSimpleSearch(String query)
    {
        Integer quantity = new Integer(unstructeredTaxonDescriptionQuery(splitQuery(query)).size());
        return quantity.longValue();
    }

    public List<TaxonDescriptionDTO> getTaxonDescriptionSimpleSearch(String query, int firstResult, int maxResult)
    {

        Set<TaxonDescriptionPK> taxonDescriptionIds = unstructeredTaxonDescriptionQuery(splitQuery(query));
        List<TaxonDescription> taxonDescriptionList =
                getEntities(taxonDescriptionIds, TaxonDescription.class, firstResult, maxResult);
        return updateFamilyAndKingdom(taxonDescriptionDTOFactory.createDTOList(taxonDescriptionList));
    }

    /**
     * Use this method for TaxonDescription simple search:
     * unstructuredSementalQuery: search by default name,kingdom,family,sequence,createdBy,
     * veterinarian status,condition and animal description
     * @param parts
     * @return Set<Long>
     */
    private Set<TaxonDescriptionPK> unstructeredTaxonDescriptionQuery(String[] parts)
    {
        Set<TaxonDescriptionPK> list = new HashSet();
        List<TaxonDescriptionPK> ids = null;



        List<Long> taxonIds;
        for (int i = 0; i < parts.length; i++)
        {
            //try to cast it
            try
            {
                //find by taxon name
                ids = taxonDescriptionEAOImpl.findByTaxonName(parts[i]);
                if(ids != null && !ids.isEmpty())
                    list.addAll(ids);

                //find by kingdom
                taxonIds = taxonEAOImpl.findByTaxonName(parts[i]);
                if(taxonIds != null & !taxonIds.isEmpty())
                {
                    for (int j = 0; j < taxonIds.size(); j++)
                    {
                        ids = taxonDescriptionEAOImpl.findByKingdomId(taxonIds.get(j));
                        if(ids != null && !ids.isEmpty())
                            list.addAll(ids);
                    }
                    taxonIds = null;
                }

                //find by animal family
                taxonIds = taxonEAOImpl.findByTaxonName(parts[i]);
                if(taxonIds != null & !taxonIds.isEmpty())
                {
                    for (int j = 0; j < taxonIds.size(); j++)
                    {
                        ids = taxonDescriptionEAOImpl.findByFamilyId(taxonIds.get(j));
                        if(ids != null && !ids.isEmpty())
                            list.addAll(ids);
                    }
                    taxonIds = null;
                }

                //find by created by
                ids = taxonDescriptionEAOImpl.findByCreatedBy(parts[i]);
                if(ids != null && !ids.isEmpty())
                    list.addAll(ids);

                //find by sequence
                ids = taxonDescriptionEAOImpl.findBySequence(Long.parseLong(parts[i]));
                if(ids != null && !ids.isEmpty())
                    list.addAll(ids);
            }
            catch(Exception e){}
        }
        return list;
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

    private List<TaxonDescriptionDTO> updateFamilyAndKingdom(List<TaxonDescriptionDTO> dtoList) {

        for (TaxonDescriptionDTO myDTO : dtoList) {
            //Get the asociated family taxon
            Taxon TFamily = taxonEAOImpl.findById(Taxon.class, myDTO.getFamilyId());
            //Get the asociated kingdom taxon
            Taxon TKingdom = taxonEAOImpl.findById(Taxon.class, myDTO.getKingdomId());
            //Update DTO's family and kingdom names
            myDTO.setFamilyName(TFamily.getDefaultName());
            myDTO.setKingdomName(TKingdom.getDefaultName());
        }

        return dtoList;
    }

    /**
     * Retorn el numero de taxon description almacenadas en la bd
     */
    public Long countTaxonDescriptions() {
        return this.taxonDescriptionEAOImpl.countByPK();
    }

    /**
     * Check if a specific taxon has associated nomenclatural groups
     * @param taxonId
     * @return
     */
    public Long getAssociatedNumenclaturalG(Long taxonId){
        return this.taxonNomenclaturalGroupEAOImpl.countByTaxonId(taxonId);
    }

    /**
     * Obtener taxones de especies, subespecies, variedad y forma
     * @return
     */
    public List<TaxonDTO> getAllSpecies() {
        return taxonDTOFactory.createDTOList(taxonEAOImpl.getAllSpecies());
    }

    public List<TaxonDTO> getAllTaxon() {
        String[] orderByFields = {"defaultName"};
        return taxonDTOFactory.createDTOList(taxonEAOImpl.findAllAndOrderBy(Taxon.class,orderByFields));
    }

    public List<TaxonDTO> getTaxonsByNomenclaturalGroup(Long ngId){
        return taxonDTOFactory.createDTOList(taxonEAOImpl.
                getTaxonListByNomenclaturalGroup(ngId));
    }

    public List<RegionDTO> getRegionsByNomenclaturalGroup(Long ngId){
        return regionDTOFactory.createDTOList
                (regionEAOImpl.getRegionsByNomenclaturalGroup(ngId));
    }

    /**
     * Obtener nombre de una especie especifica
     * @return
     */
    public String getSpeciesNameById(Long entityId) {
        Taxon aux = taxonEAOImpl.findById(Taxon.class, entityId);
        return aux.getDefaultName();
    }

    /**
     * Obtener los distintos idiomas disponibles
     * @return
     */
    public List<LanguageDTO> getAllLanguages() {
        return this.languageDTOFactory.createDTOList(this.languageEAOImpl.findAll(Language.class));
    }

    /**
     * Obtener todos los estados posibles para la creacion de
     * nuevos registros de especies
     * @return
     */
    public List<TaxonDescriptionStageDTO> getAllTaxonDescriptionStages() {
        return this.taxonDescriptionStageDTOFactoty.createDTOList(this.taxonDescriptionStageEAOImpl.findAll(TaxonDescriptionStage.class));
    }

    /**
     * Metodo para persistir un nuevo registro de especie
     */
    public void saveTaxonDescription(TaxonDescriptionDTO dto) {
        TaxonDescription entity = this.taxonDescriptionDTOFactory.createPlainEntity(dto);
        this.taxonDescriptionEAOImpl.create(entity);
    }

    /**
     * Metodo para persistir los cambios realizados a un taxon description
     */
    public TaxonDescriptionDTO updateTaxonDescription(TaxonDescriptionDTO dto, Long[] audiences,
            Long[] authors, Long[] institutions) {

        //Actualizar datos propios del la descripcion taxonomica
        TaxonDescription entity = this.taxonDescriptionEAOImpl.findByPK(dto.getTaxonId(), dto.getTaxonDescriptionSequence());
        entity = this.taxonDescriptionDTOFactory.updateEntityWithPlainValues(dto, entity);
        this.taxonDescriptionEAOImpl.update(entity);

        //Borrar datos existentes de audiencias, autores e instituciones relacionadas
        this.deleteTDAsociatedData(dto.getTaxonId(), dto.getTaxonDescriptionSequence());

        //Actualizar datos de Audiencias
        for (int i = 0; i < audiences.length; i++) {
            TaxonDescriptionAudiencePK pk = new TaxonDescriptionAudiencePK(dto.getTaxonId(), dto.getTaxonDescriptionSequence(), audiences[i]);
            TaxonDescriptionAudience newEntry = new TaxonDescriptionAudience(pk);
            newEntry.setCreatedBy(dto.getUserName());
            newEntry.setLastModificationBy(dto.getUserName());
            newEntry.setCreationDate(new GregorianCalendar());
            newEntry.setLastModificationDate(new GregorianCalendar());
            taxonDescriptionAudienceEAOImpl.create(newEntry);
        }

        //Actualizar datos de Autores
        for (int i = 0; i < authors.length; i++) {
            TaxonDescriptionPersonProfilePK pk = new TaxonDescriptionPersonProfilePK(dto.getTaxonId(), dto.getTaxonDescriptionSequence(),
                    authors[i], ProfileEntity.SPECIES_RECORD_AUTHOR.getId());
            TaxonDescriptionPersonProfile newEntry = new TaxonDescriptionPersonProfile(pk);
            newEntry.setCreatedBy(dto.getUserName());
            newEntry.setLastModificationBy(dto.getUserName());
            newEntry.setCreationDate(new GregorianCalendar());
            newEntry.setLastModificationDate(new GregorianCalendar());
            newEntry.setSequence(new Long(1)); //FIXME
            taxonDescriptionPersonProfileEAOImpl.create(newEntry);
        }

        //Actualizar datos de instituciones
        for (int i = 0; i < institutions.length; i++) {
            TaxonDescriptionInstitutionPK pk = new TaxonDescriptionInstitutionPK(dto.getTaxonId(), dto.getTaxonDescriptionSequence(), institutions[i]);
            TaxonDescriptionInstitution newEntry = new TaxonDescriptionInstitution(pk);
            newEntry.setCreatedBy(dto.getUserName());
            newEntry.setLastModificationBy(dto.getUserName());
            newEntry.setCreationDate(new GregorianCalendar());
            newEntry.setLastModificationDate(new GregorianCalendar());
            newEntry.setSequence(new Long(1)); //FIXME
            taxonDescriptionInstitutionEAOImpl.create(newEntry);
        }

        return taxonDescriptionDTOFactory.createDTO(entity);
    }

    /**
     * Metodo encargado de eliminar momentaneamente las audiencias, autores
     * e instituciones relacionadas a un taxon description
     */
    private void deleteTDAsociatedData(Long taxonId, Long tasonDescriptionSequenceId) {

        //Eliminar audiencias asociadas
        taxonDescriptionAudienceEAOImpl.deleteByTaxonDesciptionPK(taxonId, tasonDescriptionSequenceId);

        //Eliminar autores asociados
        taxonDescriptionPersonProfileEAOImpl.deleteByTaxonDesciptionPK(taxonId, tasonDescriptionSequenceId);

        //Eliminar instituciones asociados
        taxonDescriptionInstitutionEAOImpl.deleteByTaxonDesciptionPK(taxonId, tasonDescriptionSequenceId);
    }

    /**
     * Metodo para eliminar registros de especies por su id
     * @param Id
     */
    public void deleteTaxonDescription(Long taxonId, Long sequenceId) {
        TaxonDescription aux = this.taxonDescriptionEAOImpl.findByPK(taxonId, sequenceId);
        if (aux != null) {
            this.taxonDescriptionEAOImpl.delete(aux);
        }
    }

    /**
     * Retrive all people who have species record author profile
     * @return
     */
    public List<PersonDTO> getAllSpeciesRecordAuthors() {
        return personDTOFactory.createDTOList(personEAOImpl.findByProfile(ProfileEntity.SPECIES_RECORD_AUTHOR.getId()));
    }

    public List<InstitutionDTO> getInstitutionsByTaxonDescription(Long taxonId, Long taxonDescriptionSequence) {
        return institutionDTOFactory.createDTOList(institutionEAOImpl.getInstitutionsByTaxonDescription(taxonId, taxonDescriptionSequence));
    }

    public List<AudienceDTO> getAudiencesByTaxonDescription(Long taxonId, Long taxonDescriptionSequence) {
        return audienceDTOFactoty.createDTOList(audienceEAOImpl.getAudiencesByTaxonDescription(taxonId, taxonDescriptionSequence));
    }

    public AudienceDTO getAudienceById(Long aId) {
        return audienceDTOFactoty.createDTO(audienceEAOImpl.findById(Audience.class, aId));
    }

    public List<TaxonDescriptionAudienceDTO> getTDAudiencesByTaxonDescription(Long taxonId,
            Long taxonDescriptionSequence) {
        return taxonDescriptionAudienceDTOFactory.createDTOList(taxonDescriptionAudienceEAOImpl.getTDAudiencesByTaxonDescription(taxonId, taxonDescriptionSequence));
    }

    public List<PersonDTO> getPersonsByTaxonDescription(Long taxonId, Long taxonDescriptionSequence) {
        return personDTOFactory.createDTOList(personEAOImpl.getPersonsByTaxonDescription(taxonId, taxonDescriptionSequence));
    }

    public List<TaxonDescriptionPersonProfileDTO> getAuthorsByTaxonDescription(Long taxonId, Long taxonDescriptionSequence) {
        return taxonDescriptionPersonProfileDTOFactory.createDTOList(taxonDescriptionPersonProfileEAOImpl.getPersonsByTaxonDescription(taxonId, taxonDescriptionSequence));
    }

    public PersonDTO getPersonById(Long pId) {
        return personDTOFactory.createDTO(personEAOImpl.findById(Person.class, pId));
    }

    public List<TaxonDescriptionInstitutionDTO> getTDInstitutionsByTaxonDescription(Long taxonId, Long taxonDescriptionSequence) {
        return taxonDescriptionInstitutionDTOFactory.createDTOList(taxonDescriptionInstitutionEAOImpl.getTDInstitutionsByTaxonDescription(taxonId, taxonDescriptionSequence));
    }

    public InstitutionDTO getInstitutionById(Long iId) {
        return institutionDTOFactory.createDTO(institutionEAOImpl.findById(Institution.class, iId));
    }

    /**
     * Metodo que retorna las categorias correspondientes para un ancestro dato
     * @return
     */
    public List<TaxonDescriptionCategoryDTO> getTaxonDescriptionsByAncestorId(Long ancestor) {
        return this.taxonDescriptionCategoryDTOFactory.createDTOList(this.taxonDescriptionCategoryEAOImpl.findByAncestorId(ancestor));
    }

    /**
     * Metodo que retorna los elementos correspondientes para uan categoria dada
     * @return
     */
    public List<TaxonDescriptionElementDTO> getTDElementsByCategoryId(Long categoryId) {
        return this.taxonDescriptionElementDTOFactory.createDTOList(this.taxonDescriptionElementEAOImpl.findByCategoryId(categoryId));
    }

    public TaxonDescriptionCategoryDTO getTaxonDescriptionCategoryByid(Long id) {
        return taxonDescriptionCategoryDTOFactory.createDTO(taxonDescriptionCategoryEAOImpl.findById(TaxonDescriptionCategory.class, id));
    }

    public TaxonDescriptionRecordDTO getTaxonDescriptionRecord(Long taxonId, Long taxonDescriptionSequence, Long elementId, Long sequence) {
        return taxonDescriptionRecordDTOFactory.createDTO(taxonDescriptionRecordEAOImpl.getTaxonDescriptionRecord(taxonId, taxonDescriptionSequence, elementId, sequence));
    }

    public TaxonDescriptionRecordDTO getTaxonDescriptionRecordById(Long tdrId) {
        return taxonDescriptionRecordDTOFactory.createDTO(taxonDescriptionRecordEAOImpl.findById(TaxonDescriptionRecord.class, tdrId));
    }

    public TaxonDescriptionRecordDTO getTaxonDescriptionRecord(Long elementId, Long sequence) {
        return taxonDescriptionRecordDTOFactory.createDTO(taxonDescriptionRecordEAOImpl.getTaxonDescriptionRecord(elementId, sequence));
    }

    public List<Long> getTaxonDescriptionRows(Long categoryId, Long taxonId, Long taxonDescriptionSequence) {
        return taxonDescriptionRecordEAOImpl.getTaxonDescriptionRows(categoryId, taxonId, taxonDescriptionSequence);
    }

    public TaxonDescriptionElementDTO getElementById(Long elementId) {
        if (elementId == null) {
            return null;
        }
        return taxonDescriptionElementDTOFactory.createDTO(taxonDescriptionElementEAOImpl.findById(TaxonDescriptionElement.class, elementId));
    }

    public TaxonDescriptionCategoryDTO getCategoryById(Long categoryId) {
        if (categoryId == null) {
            return null;
        }
        return taxonDescriptionCategoryDTOFactory.createDTO(taxonDescriptionCategoryEAOImpl.findById(TaxonDescriptionCategory.class, categoryId));
    }

    public String getTaxonDescriptionRecordValue(String mainFieldName, String tableName, String keyField, String contentsNumeric) {
        return taxonDescriptionRecordEAOImpl.getTaxonDescriptionRecordValue(mainFieldName, tableName, keyField, contentsNumeric);
    }

    public TaxonDescriptionRecordDTO getTaxonDescriptionRecordByRowId(Long taxonId, Long taxonDescriptionSequence, Long taxonDescriptionElementId, Long rowId) {
        return taxonDescriptionRecordDTOFactory.createDTO(taxonDescriptionRecordEAOImpl.getTaxonDescriptionRecordByRowId(taxonId, taxonDescriptionSequence, taxonDescriptionElementId, rowId));
    }

    public TaxonDescriptionRecordDTO getTaxonDescriptionRecordByTaxonDescription(Long taxonId, Long taxonDescriptionSequence, Long taxonDescriptionElementId) {
        return taxonDescriptionRecordDTOFactory.createDTO(taxonDescriptionRecordEAOImpl.getTaxonDescriptionRecordByTaxonDescription(taxonId, taxonDescriptionSequence, taxonDescriptionElementId));
    }

    public Long[] getTaxonDescriptionRecordReference(Long taxonDescriptionRecordId) {
        Long[] selectedArray = new Long[]{};
        String hql;

        List<TaxonDescriptionRecordReference> tList =
                taxonDescriptionRecordReferenceEAOImpl.getTaxonDescriptionRecordReference(taxonDescriptionRecordId);
        if (tList.size() > 0) {
            selectedArray = new Long[tList.size()];
            int i = 0;
            for (TaxonDescriptionRecordReference tmp : tList) {
                selectedArray[i] = tmp.getTaxonDescriptionRecordReferencePK().getReferenceId();
                i++;
            }
        }
        return selectedArray;
    }

    public HashMap hashMapListBox(String className, String idValue, String showName) {
        HashMap options = new HashMap();

        if (className.equals("ReferenceType")) {
            List<ReferenceType> lista = referenceTypeEAOImpl.allReferenceTypeOrderByName();
            if (lista != null) {
                for (ReferenceType o : lista) {
                    String value = o.getReferenceTypeId().toString();
                    String label = o.getName();
                    options.put(label, value);
                }
            } else {
                System.out.println("Lista nula");
            }
        }

        if (className.equals("Reference")) {
            List<Reference> lista = referenceEAOImpl.allReferenceOrderByTitle();
            if (lista != null) {
                for (Reference o : lista) {
                    String value = o.getReferenceId().toString();
                    String label = o.getTitle();
                    options.put(label, value);
                }
            } else {
                System.out.println("Lista nula");
            }
        }

        if (className.equals("InteractionType")) {
            List<InteractionType> lista = interactionTypeEAOImpl.allInteractionTypeOrderByName();
            if (lista != null) {
                for (InteractionType o : lista) {
                    String value = o.getInteractionTypeId().toString();
                    String label = o.getName();
                    options.put(label, value);
                }
            } else {
                System.out.println("Lista nula");
            }
        }

        if (className.equals("GeographicCatalogue")) {
            List<GeographicCatalogue> lista = geographicCatalogueEAOImpl.allGeographicCatalogueOrderByName();
            if (lista != null) {
                for (GeographicCatalogue o : lista) {
                    String value = o.getGeographicCatalogueId().toString();
                    String label = o.getName();
                    options.put(label, value);
                }
            } else {
                System.out.println("Lista nula");
            }
        }

        if (className.equals("GeographicEntity")) {
            List<GeographicEntity> lista = geographicEntityEAOImpl.allGeographicEntityOrderByName();
            if (lista != null) {
                for (GeographicEntity o : lista) {
                    String value = o.getGeographicEntityId().toString();
                    String label = o.getName();
                    options.put(label, value);
                }
            } else {
                System.out.println("Lista nula");
            }
        }

        if (className.equals("Country")) {
            List<Country> lista = countryEAOImpl.allCountryOrderByValue();
            if (lista != null) {
                for (Country o : lista) {
                    String value = o.getCountryId().toString();
                    String label = o.getValue();
                    options.put(label, value);
                }
            } else {
                System.out.println("Lista nula");
            }
        }

        return options;
    }

    /**
     * To obtain the defaultName acording to gatheringObsId
     * @param gathObsId
     * @return
     */
    public List<String> getDefaultNameByGathObsId(Long gathObsId) {
        Set<String> dtoList = new HashSet<String>();

        List<Long> specimen = specimenEAOImpl.findByGathObsId(gathObsId);

        if (specimen != null) {
            for (Long specimenId : specimen) {
                Taxon taxon = taxonEAOImpl.findBySpecimenId(specimenId);
                if (taxon != null) {
                    TaxonDTO scientificName = taxonDTOFactory.createDTO(taxon);
                    dtoList.add(scientificName.getDefaultName().trim());
                }
            }
        }
        return new ArrayList(dtoList);
    }

    public boolean deleteTaxonDescriptionRecordRow(Long taxonDescriptionSequence, Long taxonId, Long sequence) {
        try {
            taxonDescriptionRecordEAOImpl.deleteTaxonDescriptionRecordRow(taxonDescriptionSequence, taxonId, sequence);
            return true;
        } catch (IllegalStateException ex1) {
            return false;
        } catch (IllegalArgumentException ex2) {
            return false;
        }
    }

    /**
     * Metodo en cargado de persistir una nueva entrada en la tabla de
     * taxon_description_record
     */
    public void saveTaxonDescriptionRecord(TaxonDescriptionRecordDTO tdrDTO,
            TaxonDescriptionDTO tdDTO) {
        TaxonDescriptionRecord entityToPersist =
                taxonDescriptionRecordDTOFactory.createPlainEntity(tdrDTO);
        TaxonDescription aux = taxonDescriptionDTOFactory.createPlainEntity(
                tdDTO);
        entityToPersist.setTaxonDescription(aux);
        taxonDescriptionRecordEAOImpl.create(entityToPersist);
    }

    /**
     * Metodo en cargado de realizar un update de cierta entrada de la tabla
     * taxon_description_record
     */
    public void updateTaxonDescriptionRecord(TaxonDescriptionRecordDTO tdrDTO) {
        TaxonDescriptionRecord entity = taxonDescriptionRecordEAOImpl.findById(TaxonDescriptionRecord.class, tdrDTO.getTaxonDescriptionRecordId());
        entity = taxonDescriptionRecordDTOFactory.updateEntityWithPlainValues(tdrDTO, entity);
        taxonDescriptionRecordEAOImpl.update(entity);
    }

    public Long getNextTaxonDescriptionRecordSequence(Long taxonDescriptionSequence, Long taxonId) {
        Long nextSequence = 0L;

        try {
            nextSequence = this.taxonDescriptionRecordEAOImpl.getNextTaxonDescriptionRecordSequence(
                    taxonDescriptionSequence, taxonId);
        } catch (Exception e) {
        }

        if (nextSequence == null) {
            nextSequence = 1L;
        } else {
            nextSequence = nextSequence + 1;
        }
        return nextSequence;
    }

    public List<TaxonDescriptionRecordDTO> getTaxonDescriptionRecordsByTaxonDescription(
            Long taxonId, Long taxonDescriptionSequence) {
        List<TaxonDescriptionRecord> aux = taxonDescriptionRecordEAOImpl.getTaxonDescriptionRecordsByTaxonDescription(taxonId,
                taxonDescriptionSequence);
        return taxonDescriptionRecordDTOFactory.createDTOList(aux);
    }

    public String getFieldContent(Long Id, String tableName, String keyField,
            String tableField) {
        List tmp = taxonDescriptionRecordEAOImpl.getFieldContent(Id, tableName,
                keyField, tableField);
        return (String) tmp.get(0);
    }

    /**
     * True si el taxon desccription existe, false en cualquier otro caso
     * @param taxonId
     * @param sequenceId
     * @return
     */
    public boolean existTaxonDescription(Long taxonId, Long sequenceId) {
        TaxonDescription aux = this.taxonDescriptionEAOImpl.findByPK(taxonId,
                sequenceId);
        if (aux != null) {
            return true;
        }
        return false;
    }

    public List<CollectionDTO> getAllCollections() {
        List<Collection> collectioList = collectionEAOImpl.findAll(Collection.class);
        return collectionDTOFactory.createDTOList(collectioList);
    }

    public List<PersonDTO> getAllCertifiers() {
        return personDTOFactory.createDTOList(personEAOImpl.
                findByProfile(ProfileEntity.CERTIFIER.getId()));
    }

    public List<RegionDTO> getAllRegions(){
        return regionDTOFactory.createDTOList
                (regionEAOImpl.findAll(Region.class));
    }

    /**
     * Return all the taxon in the specified taxonomical hierarchy level.
     * @return List<TaxonDTO>
     */
    public List<TaxonDTO> getAllTaxonByRange(Long rangeId) {
        List<Taxon> taxonList = null;
        List<TaxonDTO> taxonDTOList = null;

        taxonList = this.taxonEAOImpl.findByTaxononimcalRange(rangeId);
        taxonDTOList = taxonDTOFactory.createDTOList(taxonList);

        return taxonDTOList;
    }

    /**
     * returns a list with the taxa in the next hierarchy level under the
     * taxon specified by the parameter
     * @param taxonId
     * @return List<TaxonDTO>
     */
    public List<TaxonDTO> getTaxonChildren(Long taxonId) {
        List<Taxon> taxonList = null;
        List<TaxonDTO> taxonDTOList = null;

        taxonList = this.taxonEAOImpl.findByAncestor(taxonId);
        taxonDTOList = taxonDTOFactory.createDTOList(taxonList);

        return taxonDTOList;
    }

    /**
     * return the taxa number in the next hierarchy level under the taxon
     * specified by taxonId
     * @param taxonId
     * @return
     */
    public Long getTaxonChildrenCount(Long taxonId) {
        Long taxonCount = null;
        taxonCount = this.taxonEAOImpl.findByAncestorCount(taxonId);

        return taxonCount;
    }

    /**
     * Return the number of specimens associated to the selected taxa
     * @return
     */
    public Long getAssociatedSpecimenCount() {
        return 0L;
    }

    /**
     * Returns the taxon information corresponding to the specified taxon.
     * @param taxonId
     * @return TaxonDTO
     */
    public TaxonDTO getTaxon(Long taxonId) {
        Taxon taxon = null;
        TaxonDTO taxonDTO = null;

        taxon = this.taxonEAOImpl.findById(Taxon.class, taxonId);
        taxonDTO = taxonDTOFactory.createDTO(taxon);

        return taxonDTO;
    }

    /**
     * find a TaxonomicalRange by its id.
     * @param taxonId
     * @return
     */
    public TaxonomicalRangeDTO getTaxonRangeName(Long taxonRangeId) {
        TaxonomicalRange aTR = taxonomicalRangeEAOImpl.findById(
                TaxonomicalRange.class, taxonRangeId);

        return taxonomicalRangeDTOFactory.createDTO(aTR);
    }

    /**
     * Creates a new NomenclaturalGroup with all the information related.
     * @param dto
     * @param regionIds
     * @param taxonIds
     */
    public void createNomenclaturalGroup(NomenclaturalGroupDTO dto,
            Long[] regionIds, Long[] taxonIds) {
        NomenclaturalGroup entity = this.nomenclaturalGroupDTOFatory.
                createPlainEntity(dto);
        this.nomenclaturalGroupEAOImpl.create(entity);

        //Save TaxonNomenclaturalGroup entities
        for (int i = 0; i < taxonIds.length; i++) {
            TaxonNomenclaturalGroup taxonNG = new TaxonNomenclaturalGroup(
                    entity.getNomenclaturalGroupId(), taxonIds[i]);
            taxonNG.setSequence(i + 1); //Sequence number starts with 1
            taxonNG.setTaxonomicalTimestamp(new GregorianCalendar());
            taxonNG.setCreatedBy(entity.getCreatedBy());
            taxonNG.setLastModificationBy(entity.getLastModificationBy());
            taxonNG.setLastModificationDate(new GregorianCalendar());
            taxonNG.setCreationDate(new GregorianCalendar());
            this.taxonNomenclaturalGroupEAOImpl.create(taxonNG);
        }
        //Save NomenclaturalGroupRegion entities
        for (int i = 0; i < regionIds.length; i++) {
            NomenclaturalGroupRegion NGRegion = new NomenclaturalGroupRegion(
                    entity.getNomenclaturalGroupId(), regionIds[i]);
            NGRegion.setSequence(i + 1);
            NGRegion.setCreatedBy(entity.getCreatedBy());
            NGRegion.setLastModificationBy(entity.getLastModificationBy());
            NGRegion.setLastModificationDate(new GregorianCalendar());
            NGRegion.setCreationDate(new GregorianCalendar());
            this.nomenclaturalGroupRegionEAOImpl.create(NGRegion);
        }
    }

    /**
     * Used by updateNomenclaturalGroup
     * @param dto
     * @param taxonIds
     */
    private void updateTaxonNomenclaturalGroup(NomenclaturalGroupDTO dto,
            Long[] taxonIds) {
        //currentTaxa will hold the current taxon Ids
        Set<Long> currentTaxa = new HashSet<Long>();
        Set<Long> currentTaxaAux = new HashSet<Long>();
        List<Long> currentTaxonIds = this.taxonNomenclaturalGroupEAOImpl.
                findTaxaByNomenclaturalGroupId(dto.getNomenclaturalGroupId());
        System.out.println("Current:");
        for (Long taxonId : currentTaxonIds) {
            currentTaxa.add(taxonId);
            currentTaxaAux.add(taxonId);
            System.out.println(taxonId);
        }
        //newTaxa will hold the new taxon Ids
        System.out.println("New:");
        Set<Long> newTaxa = new HashSet<Long>();
        for (Long taxonId : taxonIds) {
            newTaxa.add(taxonId);
            System.out.println(taxonId);
        }
        //Remove TaxonNomenclaturalGroup entities (deselected taxon ids)
        //Set difference: current - new = taxa to remove
        currentTaxaAux.removeAll(newTaxa);
        for (Long id : currentTaxaAux) {
            TaxonNomenclaturalGroupPK pk = new TaxonNomenclaturalGroupPK(
                    dto.getNomenclaturalGroupId(), id);
            TaxonNomenclaturalGroup toDelete = taxonNomenclaturalGroupEAOImpl.
                    findById(TaxonNomenclaturalGroup.class, pk);
            this.taxonNomenclaturalGroupEAOImpl.delete(toDelete);
        }
        //Create new TaxonNomenclaturalGroup entities (selected taxon ids)
        //Set difference: new - current = taxa to include
        int sequence = currentTaxaAux.size();
        newTaxa.removeAll(currentTaxa);
        for (Long id : newTaxa) {
            TaxonNomenclaturalGroup taxonNG = new TaxonNomenclaturalGroup(dto.
                    getNomenclaturalGroupId(), id);
            taxonNG.setSequence(++sequence);
            taxonNG.setTaxonomicalTimestamp(new GregorianCalendar());
            taxonNG.setCreatedBy("alambred");
            taxonNG.setLastModificationBy("alambred");
            taxonNG.setCreationDate(new GregorianCalendar());
            taxonNG.setLastModificationDate(new GregorianCalendar());
            this.taxonNomenclaturalGroupEAOImpl.create(taxonNG);
        }

    }

    /**
     * Used by updateNomenclaturalGroup
     * @param dto
     * @param regionIds
     */
    private void updateNomenclaturalGroupRegion(NomenclaturalGroupDTO dto,
            Long[] regionIds) {
        Set<Long> currentRegions = new HashSet<Long>();
        Set<Long> currentRegionsAux = new HashSet<Long>();
        List<Long> currentRegionIds = this.nomenclaturalGroupRegionEAOImpl.findRegionByNomenclaturalGroupId(dto.getNomenclaturalGroupId());
        for (Long regionId : currentRegionIds) {
            currentRegions.add(regionId);
            currentRegionsAux.add(regionId);
        }
        Set<Long> newRegions = new HashSet<Long>();
        for (Long regionId : regionIds) {
            newRegions.add(regionId);
        }
        //Remove NomenclaturalGroupRegion entities (deselected region ids)
        //Set difference: current - new = regions to remove
        currentRegionsAux.removeAll(newRegions);
        for (Long id : currentRegionsAux) {
            NomenclaturalGroupRegionPK pk = new NomenclaturalGroupRegionPK(dto.
                    getNomenclaturalGroupId(), id);
            NomenclaturalGroupRegion toDelete = nomenclaturalGroupRegionEAOImpl.
                    findById(NomenclaturalGroupRegion.class, pk);
            this.nomenclaturalGroupRegionEAOImpl.delete(toDelete);
        }
        //Create new NomenclaturalGroupRegion entities (selected region ids)
        //Set difference: new - current = regions to include
        int sequence = currentRegionsAux.size();
        newRegions.removeAll(currentRegions);
        for (Long id : newRegions) {
            NomenclaturalGroupRegion NGRegion =new NomenclaturalGroupRegion(dto.
                    getNomenclaturalGroupId(), id);
            NGRegion.setSequence(++sequence);
            NGRegion.setCreatedBy("alambred");
            NGRegion.setLastModificationBy("alambred");
            NGRegion.setCreationDate(new GregorianCalendar());
            NGRegion.setLastModificationDate(new GregorianCalendar());
            this.nomenclaturalGroupRegionEAOImpl.create(NGRegion);
        }
    }

    /**
     * Updates general information about de NomenclaturalGroup as well as the
     * information related in taxonomy and regions.
     * @param dto
     * @param regionIds
     * @param taxonIds
     */
    public void updateNomenclaturalGroup(NomenclaturalGroupDTO dto,
            Long[] regionIds, Long[] taxonIds) {
        NomenclaturalGroup entity = this.nomenclaturalGroupEAOImpl.findById(
                NomenclaturalGroup.class, dto.getNomenclaturalGroupId());
        entity = this.nomenclaturalGroupDTOFatory.updateEntityWithPlainValues(dto, entity);
        this.nomenclaturalGroupEAOImpl.update(entity);
        /**
         *Update TaxonNomenclaturalGroup entities
         */
        updateTaxonNomenclaturalGroup(dto, taxonIds);
        /**
         *Update NomenclaturalGroupRegion entities
         */
        updateNomenclaturalGroupRegion(dto, regionIds);
    }

    /**
     * Deletes a NomenclaturalGroup if it is not used.
     * @param id
     */
    public void deleteNomenclaturalGroup(Long id) {
        NomenclaturalGroup aux = this.nomenclaturalGroupEAOImpl.findById(
                NomenclaturalGroup.class, id);
        if (aux != null) {
            //If there are references in nomenclatural_group_region or
            //taxon_nomenclatural_group, this method will throw a database
            //exception
            this.nomenclaturalGroupEAOImpl.delete(aux);
        }
    }

    /**
     * return the next Mandatory Taxonomomical level (top-down direction)
     *
     * top = first
     *
     * @param taxonomicalLevel
     * @return
     */
    public Long getNextMandatoryTaxonomicalLevel(Long ancestorTaxonomicalLevel) {
        return taxonomicalHierarchyEAOImpl.findMandatoryIdByAncestor(ancestorTaxonomicalLevel);
    }

    /**
     * convert the taxon DTO into an Taxon Entity and persist it
     * @param taxonDTO
     */
    public TaxonDTO saveTaxon(TaxonDTO taxonDTO) {
        Taxon taxon = this.taxonDTOFactory.createPlainEntity(taxonDTO);
        this.taxonEAOImpl.create(taxon);

        TaxonDTO result = taxonDTOFactory.createDTO(taxon);
        return result;
    }

    /**
     * convert the taxon DTO into an Taxon Entity and persist it
     * @param taxonDTO
     */
    public void updateTaxon(TaxonDTO taxonDTO) {

        Taxon t = taxonEAOImpl.findById(Taxon.class, taxonDTO.getTaxonKey());
        t = this.taxonDTOFactory.updatePlainEntity(taxonDTO, t);
        this.taxonEAOImpl.update(t);
    }


    /**
     * Delete the Taxon specified by TaxonId
     * @param taxonId
     */
    public void deleteTaxon(Long taxonId) {
        Taxon taxon = this.taxonEAOImpl.findById(Taxon.class, taxonId);
        this.taxonEAOImpl.delete(taxon);
    }

    /**
     * Return the number of specimens associated to the selected taxa
     * @return
     */
    public Long getAssociatedSpecimenCount(Long taxonId) {
        return this.identificationEAOImpl.countSpecimenByTaxonId(taxonId);
	}

    /**
     * Return the number of nomenclatural groups indicated by maxResults
     * starting from firstResults filtrated by collection
     *
     * @param firstResult
     * @param maxResults
     * @param collectionId
     * @return
     */
    public List<NomenclaturalGroupDTO> getAllNomenclaturalGroupsPaginated(
                                            int firstResult
                                            , int maxResults
                                            , Long collectionId){
        String[] orderByFields = {"name"};
        List<NomenclaturalGroup> entityList =
            nomenclaturalGroupEAOImpl.findAllPaginatedFilterAndOrderBy(
                NomenclaturalGroup.class
                , firstResult
                , maxResults
                , orderByFields
                , collectionId);

        return nomenclaturalGroupDTOFatory.createDTOList(entityList);
    }

    /**
     * Return the total count of Nomenclatural Groups
     * @return
     */
    public Long countAllNomenclaturalGroups() {
        return nomenclaturalGroupEAOImpl.count(NomenclaturalGroup.class);
    }

    public TaxonDTO getTaxonRootByCollectionId(Long collectionId)
    {
        return taxonDTOFactory.createDTO(taxonEAOImpl.getTaxonRootByCollectionId(collectionId));
    }

    public List<TaxonCategoryDTO> getAllTaxonCategory()
    {
        return taxonCategoryDTOFactory.createDTOList(taxonCategoryEAOImpl.findAll(TaxonCategory.class));
    }

    public List<TaxonomicalRangeDTO> getNextLevelsByTaxonId(Long taxonId)
    {
        return taxonomicalRangeDTOFactory.createDTOList(taxonomicalRangeEAOImpl.findNextLevelsByTaxonId(taxonId));
    }

    public Long getTaxonomicalRangeIdByTaxonId(Long taxonId)
    {
        return taxonEAOImpl.findTaxonomicalRangeIdByTaxonId(taxonId);
    }


    public void saveTaxonIndicators(Long taxonId, List<String> indicatorIds, String userName)
    {
        
        
        for(String indicatorId: indicatorIds)
        {
        
            TaxonIndicatorDTO newDTO = new TaxonIndicatorDTO();
            newDTO.setTaxonId(taxonId);
            newDTO.setIndicatorId(new Long(indicatorId));
            newDTO.setUserName(userName);
            //newDTO.setValuerPersonId(1L);
            TaxonIndicator taxonIndicator = taxonIndicatorDTOFactory.createPlainEntity(newDTO);                   
            taxonIndicatorEAOImpl.create(taxonIndicator);
        }

    }

    public void saveTaxonIndicator(Long taxonId, String indicatorId, String userName)
    {

            TaxonIndicatorDTO newDTO = new TaxonIndicatorDTO();
            newDTO.setTaxonId(taxonId);
            newDTO.setIndicatorId(new Long(indicatorId));
            newDTO.setUserName(userName);
            //newDTO.setValuerPersonId(4L);//ALAMBRADO CAMBIAR LA PROPIEDAD EN LA BD PARA QUE DEJE DE SER NOT NULL
            TaxonIndicator taxonIndicator = taxonIndicatorDTOFactory.createPlainEntity(newDTO);
            taxonIndicatorEAOImpl.create(taxonIndicator);

    }


    public void saveTaxonIndicatorCountries(Long taxonId, Long indicatorId ,List<Long> countryIds, String userName)
    {


        for(Long countryId: countryIds)
        {

            TaxonIndicatorCountryDTO newDTO = new TaxonIndicatorCountryDTO();
            newDTO.setTaxonId(taxonId);
            newDTO.setIndicatorId(new Long(indicatorId));
            newDTO.setCountryId(countryId);
            newDTO.setUserName(userName);
            TaxonIndicatorCountry taxonIndicatorCountry = taxonIndicatorCountryDTOFactory.createPlainEntity(newDTO);
            taxonIndicatorCountryEAOImpl.create(taxonIndicatorCountry);
        }

    }


    public void saveTaxonIndicatorCountry(Long taxonId, Long indicatorId ,Long countryId, String userName)
    {
            TaxonIndicatorCountryDTO newDTO = new TaxonIndicatorCountryDTO();
            newDTO.setTaxonId(taxonId);
            newDTO.setIndicatorId(new Long(indicatorId));
            newDTO.setCountryId(countryId);
            newDTO.setUserName(userName);
            TaxonIndicatorCountry taxonIndicatorCountry = taxonIndicatorCountryDTOFactory.createPlainEntity(newDTO);
            taxonIndicatorCountryEAOImpl.create(taxonIndicatorCountry);
    }

    public void deleteTaxonIndicatorByIds(Long taxonId, List<String> indicatorIds)
    {
        for(String indicatorId: indicatorIds)
        {
            taxonIndicatorEAOImpl.deleteTaxonIndicatorById(taxonId, new Long(indicatorId));
        }
    }

    public void deleteTaxonIndicatorById(Long taxonId, String indicatorId)
    {

        taxonIndicatorEAOImpl.deleteTaxonIndicatorById(taxonId, new Long(indicatorId));

    }


    public void deleteTaxonIndicatorByTaxonId(Long taxonId)
    {
        taxonIndicatorEAOImpl.deleteTaxonIndicatorByTaxonId(taxonId);
    }


    public void deleteTaxonIndicatorCountryByTaxonId(Long taxonId)
    {
        taxonIndicatorCountryEAOImpl.deleteTaxonIndicatorCountryByTaxonId(taxonId);
    }



    public List<Long> getIndicatorIdsByTaxon(Long taxonId)
    {

        return taxonIndicatorEAOImpl.getIndicatorsByTaxonId(taxonId);

    }

    public void deleteTaxonIndicatorById(Long taxonId, Long indicatorId)
    {
        taxonIndicatorEAOImpl.deleteTaxonIndicatorById(taxonId, indicatorId);
    }


    public List<Long> getCountriesByTaxonIndicatorIds(Long taxon, Long indicator)
    {
        return taxonIndicatorCountryEAOImpl.findCountriesByTaxonIndicatorIds(taxon, indicator);
    }


    public void deleteTaxonIndicatorCountryByIds(Long taxonId, Long indicatorId, List<Long> countryIds)
    {
        for(Long countryId: countryIds)
        {
            taxonIndicatorCountryEAOImpl.deleteTaxonIndicatorCountryById(taxonId, indicatorId, countryId);
        }
    }


    public void saveTaxonIndicatorDublinCoreIds(Long taxonId, Long indicatorId ,List<String> dublinCoreIds, String userName)
    {


        for(String dublinCoreId: dublinCoreIds )
        {

            TaxonIndicatorDublinCoreDTO newDTO = new TaxonIndicatorDublinCoreDTO();
            newDTO.setTaxonId(taxonId);
            newDTO.setIndicatorId(indicatorId);
            newDTO.setDublinCoreId(new Long(dublinCoreId));
            newDTO.setUserName(userName);
            TaxonIndicatorDublinCore taxonIndicatorDublinCore = taxonIndicatorDublinCoreDTOFactory.createPlainEntity(newDTO);
            taxonIndicatorDublinCoreEAOImpl.create(taxonIndicatorDublinCore);
        }
        
    }

    public List<Long> getDublinCoreByTaxonIndicatorIds(Long taxonId, Long indicatorId)
    {
        return taxonIndicatorDublinCoreEAOImpl.findDublinCoreByTaxonIndicatorIds(taxonId, indicatorId);
    }


    public void deleteTaxonIndicatorDublinCoreIds(Long taxonId, Long indicatorId, List<String> dublinCoreIds)
    {
        for(String dublinCoreId: dublinCoreIds)
        {
            taxonIndicatorDublinCoreEAOImpl.deleteTaxonIndicatorDublinCoreById(taxonId, indicatorId, new Long(dublinCoreId));
        }
    }


    public void deleteTaxonIndicatorDublinCoreByTaxonId(Long taxonId)
    {
        taxonIndicatorDublinCoreEAOImpl.deleteTaxonIndicatorDublinCoreByTaxonId(taxonId);
    }

    public void deleteTaxonIndicatorCountryByTaxonIndicator(Long taxonId, Long indicatorId)
    {
        taxonIndicatorCountryEAOImpl.deleteTaxonIndicatorCountryByTaxonIndicator(taxonId, indicatorId);
    }

    public void deleteTaxonIndicatorDublinCoreByTaxonIndicator(Long taxonId, Long indicatorId)
    {
        taxonIndicatorDublinCoreEAOImpl.deleteTaxonIndicatorDublinCoreByTaxonIndicator(taxonId, indicatorId);
    }


    public List<Long> getComponentPartByTaxonIndicatorIds(Long taxon, Long indicator)
    {
        return taxonIndicatorComponentPartEAOImpl.findComponentPartByTaxonIndicatorIds(taxon, indicator);
    }

    public void saveTaxonIndicatorComponentPartIds(Long taxonId, Long indicatorId ,List<Long> componentPartIds, String userName)
    {


        for(Long componentPartId: componentPartIds )
        {

            TaxonIndicatorComponentPartDTO newDTO = new TaxonIndicatorComponentPartDTO();
            newDTO.setTaxonId(taxonId);
            newDTO.setIndicatorId(indicatorId);
            newDTO.setComponentPartId(new Long(componentPartId));
            newDTO.setUserName(userName);
            TaxonIndicatorComponentPart taxonIndicatorComponentPart = taxonIndicatorComponentPartDTOFactory.createPlainEntity(newDTO);
            taxonIndicatorComponentPartEAOImpl.create(taxonIndicatorComponentPart);
        }

    }

    public void deleteTaxonIndicatorComponentPartIds(Long taxonId, Long indicatorId, List<Long> componentPartIds)
    {
        for(Long componentPartId: componentPartIds)
        {
            taxonIndicatorComponentPartEAOImpl.deleteTaxonIndicatorComponentPartById(taxonId, indicatorId, new Long(componentPartId));
        }
    }


    public void deleteTaxonIndicatorComponentPartByTaxonId(Long taxonId)
    {
        taxonIndicatorComponentPartEAOImpl.deleteTaxonIndicatorComponentPartByTaxonId(taxonId);
    }

    public void deleteTaxonIndicatorComponentPartByTaxonIndicator(Long taxonId, Long indicatorId)
    {
        taxonIndicatorComponentPartEAOImpl.deleteTaxonIndicatorComponentPartByTaxonIndicator(taxonId, indicatorId);
    }

    public List<TaxonAuthorProfileDTO> getAllTaxonAuthorProfile() {

        List<TaxonAuthorProfileDTO> tapDTOList = new ArrayList<TaxonAuthorProfileDTO>();
        //SelectionListEntityDTO sleDTO;
        TaxonAuthorProfile[] all = TaxonAuthorProfile.values();

        for(TaxonAuthorProfile tap: all){
			//tapDTO = new TaxonAuthorProfileDTO(tap.getId(),sle.getNameAsProperty());
            tapDTOList.add(new TaxonAuthorProfileDTO(tap.getId(), tap.getNameAsProperty(), tap.getNameAsProperty()));
		}
        return tapDTOList;
    }


    public String getAuthorName(Long personId, Long profileId,short formatId, boolean orientation)
    {
        String result;
        switch(formatId)
        {
            case 0: result = perfilFormat(personId, profileId);
                    if(result == null)
                    {
                        result = shortFormat(personId, orientation);
                    }
                    break;
            case 1: result = shortFormat(personId, orientation);
                    break;
            case 2: result = LongFormat(personId, orientation);
                    break;
            case 3: result = completeFormat(personId, orientation);
                    break;
            default: result = shortFormat(personId, orientation);
        }
        return result;
    }


    public String getAuthorName(PersonProfile personProfile,short formatId, boolean orientation)
    {
        String result;
        switch(formatId)
        {
            case 0: result = perfilFormat(personProfile);
                    if(result == null)
                    {
                        result = shortFormat(personProfile, orientation);
                    }
                    break;
            case 1: result = shortFormat(personProfile, orientation);
                    break;
            case 2: result = LongFormat(personProfile, orientation);
                    break;
            case 3: result = completeFormat(personProfile, orientation);
                    break;
            default: result = shortFormat(personProfile, orientation);
        }
        return result;
    }




    private String perfilFormat(Long personId, Long profileId)
    {
        //System.out.println("entro a perfilFormat");
        return personProfileEAOImpl.findPersonByPersonProfileId(personId, profileId);
    }

    private String perfilFormat(PersonProfile personProfile)
    {
        //System.out.println("entro a perfilFormat");
        //return personProfileEAOImpl.findPersonByPersonProfileId(personId, profileId);
        return personProfile.getShortName();
    }



    private String shortFormat(Long personId,boolean orientation)
    {
        //System.out.println("entro a shortFormat");
        String result = "";
        Person person = personEAOImpl.findById(Person.class, personId);
        String initials =person.getInitials();
        String lastName =person.getLastName();

        if(initials == null)
        {
            result =lastName;
        }
        else
        {
            if(lastName == null)
            {
                result = initials;
            }
            else
            {
                if(orientation)
                {
                    result = person.getInitials() +" "+person.getLastName();
                }
                else
                {
                    result = person.getLastName()+", "+person.getInitials();
                }
            }
        }

        return result;

    }

     private String shortFormat(PersonProfile personProfile,boolean orientation)
    {
         String result = "";
         if(orientation)
         {
             result = personProfile.getPerson().getNaturalShortName();
         }
         else
         {
             result = personProfile.getPerson().getFormalShortName();
         }      
         return result;

    }

    private String LongFormat(Long personId, boolean orientation)
    {
     //   System.out.println("entro a longFormat");
        String result = "";
        Person person = personEAOImpl.findById(Person.class, personId);
        String firstName =person.getFirstName();
        String lastName =person.getLastName();

        if(firstName == null)
        {
            result = lastName;
        }
        else
        {
            if(lastName == null)
            {
                result = firstName;
            }
            else
            {
                if(orientation)
                {
                    result = firstName +" "+lastName;
                }
                else
                {
                    result = lastName+", "+firstName;
                }
            }
        }

        return result;
    }

     private String LongFormat(PersonProfile personProfile, boolean orientation)
     {

         String result = "";
         if(orientation)
         {
             result= personProfile.getPerson().getNaturalLongName();
         }
         else
         {
             result= personProfile.getPerson().getFormalLongName();
         }
         return result;
     }

    private String completeFormat(Long personId, boolean orientation)
    {
        //System.out.println("entro a completeFormat");
        String result = "";
        Person person = personEAOImpl.findById(Person.class, personId);
        String firstName =person.getFirstName();
        String lastName =person.getLastName();
        String secondLastName =person.getSecondLastName();
        if(firstName == null)
        {
            firstName = "";
        }
        if(lastName == null)
        {
            lastName = "";
        }
        if(secondLastName != null)
        {
            secondLastName=" "+secondLastName;
            
        }
        else
        {
            secondLastName = "";
        }
        if(orientation)
        {
            result = firstName +" "+lastName+secondLastName;
        }
        else
        {

            if(firstName != null)
            {
                firstName = ", "+firstName;
            }
           
            result = lastName+secondLastName+firstName;
        }
        result = result.trim();
        return result;
    }


    private String completeFormat(PersonProfile personProfile, boolean orientation)
    {
         String result = "";
         if(orientation)
         {
             result= personProfile.getPerson().getNaturalFullName();
         }
         else
         {
             result= personProfile.getPerson().getFormalFullName();
         }
         return result;
        
    }

    public List<PersonAuthorDTO> getAllPersonsByProfileId(Long profileId, Short formatId, boolean orientation)
    {
              
        List<PersonProfile> personProfiles = personProfileEAOImpl.findPersonsByProfileId(profileId);

        
        List<PersonAuthorDTO> personAuthors = new ArrayList<PersonAuthorDTO>();
        for(PersonProfile personProfile: personProfiles)
        {
            /*System.out.print("\t- "+personProfile.getPersonProfilePK().getPersonId()+", "+personProfile.getShortName()+
                    ", "+personProfile.getPerson().getFirstName()+", "+personProfile.getPerson().getLastName()+" => "+getAuthorName(personProfile, formatId, orientation));*/
            Long personId = personProfile.getPersonProfilePK().getPersonId();
            personAuthors.add(new PersonAuthorDTO(personId,
                    /*getAuthorName(personId, profileId, formatId, orientation)*/
                    getAuthorName(personProfile, formatId, orientation)));
       
        }

        return personAuthors;

    }


    public void saveTaxonAuthors(Long taxonId, List<TaxonAuthorDTO> taxonAuthors, String userName)
    {


        for(TaxonAuthorDTO taxonAuthorDTO: taxonAuthors)
        {

            taxonAuthorDTO.setTaxonId(taxonId);
            taxonAuthorDTO.setUserName(userName);
            //newDTO.setValuerPersonId(1L);
            TaxonAuthor taxonAuthor = taxonAuthorDTOFactory.createPlainEntity(taxonAuthorDTO);
            taxonAuthorEAOImpl.create(taxonAuthor);
        }

    }

    public void deleteTaxonAuthorByTaxonId(Long taxonId)
    {
        taxonAuthorEAOImpl.deleteTaxonAuthorByTaxonId(taxonId);
    }

    public void deleteTaxonAuthorByTaxonAuthorIds(Long taxonId, Long taxonAuthorPersonId, String category)
    {
        taxonAuthorEAOImpl.deleteTaxonAuthorByTaxonAuthorIds(taxonId, taxonAuthorPersonId, category);
    }

    public void deleteTaxonAuthorByTaxonAuthorIds(List<TaxonAuthorDTO> elements)
    {
        for(TaxonAuthorDTO taxonAuthorDTO: elements)
        {
            deleteTaxonAuthorByTaxonAuthorIds(taxonAuthorDTO.getTaxonId(),
                    taxonAuthorDTO.getTaxonAuthorPersonId(),
                    taxonAuthorDTO.getCategory());
        }
    }

    public List<TaxonAuthorDTO> getTaxonAuthorsByTaxonCategory(Long taxonId, String category)
    {
        List<TaxonAuthor> taxonAuthors = taxonAuthorEAOImpl.findTaxonAuthorsByTaxonCategory(taxonId, category);
        return taxonAuthorDTOFactory.createDTOList(taxonAuthors);
    }


    public void updateTaxonAuthor(TaxonAuthorDTO taxonAuthorDTO) {

       
        TaxonAuthor ta = taxonAuthorEAOImpl.findTaxonAuthorByTaxonAuthorIds(taxonAuthorDTO.getTaxonId(), taxonAuthorDTO.getTaxonAuthorSequence(), taxonAuthorDTO.getCategory());
        ta = this.taxonAuthorDTOFactory.updatePlainEntity(taxonAuthorDTO, ta);       
        this.taxonAuthorEAOImpl.update(ta);
    }


    public List<TaxonDTO> getTaxonByName(String taxonName, Long kingdomId, Long categoryId , int base, int offset)
    {
        //System.out.println("taxonName = "+taxonName+" , kingdomId = "+kingdomId+ " , categoryId = "+categoryId+ " , base = "+ base + " , offset = "+offset);
        List<Taxon> taxonEntities = taxonEAOImpl.findTaxonByName(taxonName, kingdomId, categoryId, base, offset);
        return taxonDTOFactory.createDTOList(taxonEntities);
    }

    public String getTaxonNameByTaxonId(Long taxonId)
    {
        return taxonEAOImpl.findById(Taxon.class, taxonId).getDefaultName();
    }

}
