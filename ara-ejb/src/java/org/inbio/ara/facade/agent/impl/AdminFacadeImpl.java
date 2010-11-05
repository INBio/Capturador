/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio ( Instituto Nacional de Biodiversidad )
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

package org.inbio.ara.facade.agent.impl;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.dto.inventory.SelectionListEntityDTO;
import org.inbio.ara.facade.agent.*;
import javax.ejb.Stateless;
import org.inbio.ara.dto.agent.AudienceDTO;
import org.inbio.ara.dto.agent.AudienceDTOFactory;
import org.inbio.ara.dto.agent.CollectionDTO;
import org.inbio.ara.dto.agent.CollectionDTOFactory;
import org.inbio.ara.dto.agent.InstitutionDTO;
import org.inbio.ara.dto.agent.InstitutionDTOFactory;
import org.inbio.ara.dto.agent.ProfileDTO;
import org.inbio.ara.dto.agent.ProfileDTOFactory;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.dto.inventory.PersonDTOFactory;
import org.inbio.ara.dto.inventory.SelectionListDTOFactory;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.dto.inventory.TaxonDTOFactory;
import org.inbio.ara.eao.agent.AudienceEAOLocal;
import org.inbio.ara.eao.agent.InstitutionEAOLocal;
import org.inbio.ara.eao.agent.PersonEAOLocal;
import org.inbio.ara.eao.agent.PersonInstitutionEAOLocal;
import org.inbio.ara.eao.agent.PersonProfileEAOLocal;
import org.inbio.ara.eao.agent.ProfileEAOLocal;
import org.inbio.ara.eao.collection.CollectionEAOLocal;
import org.inbio.ara.eao.selectionlist.SelectionListValueCollectionEAOLocal;
import org.inbio.ara.eao.selectionlist.SelectionListValueLocalEAO;
import org.inbio.ara.eao.specimen.SpecimenEAOLocal;
import org.inbio.ara.eao.taxonomy.TaxonEAOLocal;
import org.inbio.ara.persistence.SelectionListGenericEntity;
import org.inbio.ara.persistence.audiences.Audience;
import org.inbio.ara.persistence.collection.Collection;
import org.inbio.ara.persistence.institution.Institution;
import org.inbio.ara.persistence.person.Person;
import org.inbio.ara.persistence.person.PersonInstitution;
import org.inbio.ara.persistence.person.PersonInstitutionPK;
import org.inbio.ara.persistence.person.PersonProfile;
import org.inbio.ara.persistence.person.PersonProfilePK;
import org.inbio.ara.persistence.person.Profile;
import org.inbio.ara.persistence.selectionlist.ListTableCollection;
import org.inbio.ara.persistence.selectionlist.ListTableCollectionPK;

/**
 *
 * @author esmata
 */
@Stateless
public class AdminFacadeImpl implements AdminFacadeRemote {
    
    @EJB
    private InstitutionEAOLocal institutionEAOImpl;
    @EJB
    private CollectionEAOLocal collectionEAOImpl;
    @EJB
    private TaxonEAOLocal taxonEAOImpl;
    @EJB
    private SelectionListValueLocalEAO selectionListValueEAOImpl;
    @EJB
    private SelectionListValueCollectionEAOLocal selectionListValueCollectionEAOImpl;
    @EJB
    private SpecimenEAOLocal specimenEAOImpl;
    @EJB
    private AudienceEAOLocal audienceEAOImpl;
    @EJB
    private ProfileEAOLocal profileEAOImpl;
    @EJB
    private PersonEAOLocal personEAOImpl;
    @EJB
    private PersonInstitutionEAOLocal personInstitutionEAOImpl;
    @EJB
    private PersonProfileEAOLocal personProfileEAOImpl;
    
    CollectionDTOFactory collectionDTOFactory = new CollectionDTOFactory();
    TaxonDTOFactory taxonDTPFactory = new TaxonDTOFactory();
    private SelectionListDTOFactory selecionListDTOFactory = new SelectionListDTOFactory();
    private InstitutionDTOFactory institutionDTOFactory = new InstitutionDTOFactory();
    private AudienceDTOFactory audienceDTOFactory = new AudienceDTOFactory();
    private ProfileDTOFactory profileDTOFactory = new ProfileDTOFactory();
    
    private ProfileDTOFactory profileDTOFactoty = new ProfileDTOFactory();
    private PersonDTOFactory personDTOFactory = new PersonDTOFactory();
    /**
     * Metodo para obtener la lista de taxones con la que puede trabajar un
     * determinado usuario
     */
    public List<TaxonDTO> getUserTaxonList(Long userId){
        return taxonDTPFactory.createDTOList(taxonEAOImpl.getTaxonListByUser(userId));
    }

    /**
     * Metodo que retorna la lista completa de instituciones
     */
    public List<InstitutionDTO> getAllInstitutions(){
        String[] fields = {"institutionCode"};
        return institutionDTOFactory.
                createDTOList(institutionEAOImpl.findAllAndOrderBy(Institution.class, fields));
        
        //return institutionEAOImpl.getAllInstitutions();
    }

    /**
     * Metodo que retorna la lista completa de perfiles
     */
    public List<ProfileDTO> getAllProfiles(){
        //return profileDTOFactory.createDTOList(profileEAOImpl.findAll(Profile.class));
        String[] fields  = {"name"};
        return profileDTOFactory.createDTOList(profileEAOImpl.
                findAllAndOrderBy(Profile.class, fields));

    }

    /**
     * Metodo que retorna la lista completa de instituciones paginada
     */
    public List<InstitutionDTO> getAllInstitutionsPaginated(int firstResult,int maxResults){
        String[] orderByFields = {"institutionCode", "name"};
        List<Institution> entityList =  institutionEAOImpl.
                findAllPaginatedFilterAndOrderBy(Institution.class,
                firstResult, maxResults,orderByFields,null);
        return institutionDTOFactory.createDTOList(entityList);
    }

    /**
     * Retorn el numero de instituciones almacenadas en la bd
     */
    public Long countInstitutions(){
        return this.institutionEAOImpl.count(Institution.class);
    }

    /**
     * Metodo que retorna la lista completa de audiencias paginada
     */
    public List<AudienceDTO> getAllAudiencesPaginated(int firstResult,int maxResults){
        String[] orderByFields = {"name"};
        List<Audience> entityList =  audienceEAOImpl.
                findAllPaginatedFilterAndOrderBy(
                Audience.class,
                firstResult, maxResults,orderByFields,null);
        return audienceDTOFactory.createDTOList(entityList);
    }

    /**
     * Metodo que retorna la lista completa de audiencias sin paginar
     */
    public List<AudienceDTO> getAllAudiences(){
        //List<Audience> entityList =  audienceEAOImpl.findAll(Audience.class);
        String[] fields = {"name"};
        List<Audience> entityList =  audienceEAOImpl.findAllAndOrderBy(Audience.class, fields);
        return audienceDTOFactory.createDTOList(entityList);
    }

    /**
     * Retorn el numero de audiencias almacenadas en la bd
     */
    public Long countAudiences(){
        return this.audienceEAOImpl.count(Audience.class);
    }

    /**
     * Metodo que retorna la lista completa de perfiles paginada
     */
    public List<ProfileDTO> getAllProfilesPaginated(int firstResult,int maxResults){
        String[] orderByFields = {"name"};
        List<Profile> entityList =  profileEAOImpl.
                findAllPaginatedFilterAndOrderBy(Profile.class,
                firstResult, maxResults,orderByFields,null);
        return profileDTOFactory.createDTOList(entityList);
    }

    /**
     * Retorna el numero de perfiles almacenados en la bd
     */
    public Long countProfiles(){
        return this.profileEAOImpl.count(Profile.class);
    }

    /**
     * Metodo que retorna las colecciones de una institucion especifica
     */
    public List<CollectionDTO> getAllCollections(){
        List<Collection> collectioList = collectionEAOImpl.findAll(Collection.class);
        return collectionDTOFactory.createDTOList(collectioList);
    }

    /**
     * Dice cuantos especimenes hay asociados a una institucion
     * @param insId
     * @return
     */
    public int findSpecimensByInstitutionId(Long insId){
        List<Long> list = this.specimenEAOImpl.findByInstitutionId(insId);
        if(list==null)
            return 0;
        else
            return list.size();
    }

    /**
     * Metodo para eliminar institucion por su id
     * @param insId
     */
    public void deleteInstitution(Long insId){
        Institution aux = this.institutionEAOImpl.findById(Institution.class, insId);
        if(aux!=null){
            this.institutionEAOImpl.delete(aux);
        }
    }

    /**
     * Metodo para persistir una nueva institucion
     */
    public void saveInstitution(InstitutionDTO idto){
        Institution entity = this.institutionDTOFactory.createEntity(idto);
        this.institutionEAOImpl.create(entity);
    }

    /**
     * Metodo para eliminar Audiencias por su id
     * @param Id
     */
    public void deleteAudience(Long Id){
        Audience aux = this.audienceEAOImpl.findById(Audience.class, Id);
        if(aux!=null){
            this.audienceEAOImpl.delete(aux);
        }
    }

    /**
     * Metodo para persistir una nueva Audiencia
     */
    public void saveAudience(AudienceDTO adto){
        Audience entity = this.audienceDTOFactory.createPlainEntity(adto);
        this.audienceEAOImpl.create(entity);
    }

    /**
     * Metodo para hacer update de una Audiencia
     */
    public void updateAudience(AudienceDTO dto){
        Audience a = audienceEAOImpl.findById(Audience.class, dto.getAudienceId());
        a = audienceDTOFactory.updatePlainEntity(dto, a);
        audienceEAOImpl.update(a);
    }

    /**
     * Metodo para hacer update de un Profile
     */
    public void updateProfile(ProfileDTO dto){
        Profile p = profileEAOImpl.findById(Profile.class, dto.getProfileId());
        p = profileDTOFactory.updatePlainEntity(dto, p);
        profileEAOImpl.update(p);
    }

    /**
     * Metodo para hacer update de una entidad
     */
    public void updateInstitution(InstitutionDTO idto){
        Institution entity = this.institutionDTOFactory.createEntity(idto);
        this.institutionEAOImpl.update(entity);
    }

    /**
     * @param collectionDTO
     * @return 0 = create, 1 = update
     */
    public int saveOrUpdateCollection(CollectionDTO collectionDTO) {

        Collection c = collectionDTOFactory.createPlainEntity(collectionDTO);


        if(collectionDTO.getCollectionId() == null){
            //collection = new Collection();
            //collection.setName(collectionDTO.getCollectionName());
            //collection.setDescription(collectionDTO.getCollectionDescription());
            //collectionEAOImpl.create(collection);
            collectionEAOImpl.create(c);
            return 0;
        } else {
            //collection = collectionEAOImpl.findById(Collection.class, collectionDTO.getCollectionId());
            //collection.setName(collectionDTO.getCollectionName());
            //collection.setDescription(collectionDTO.getCollectionDescription());
            //collectionEAOImpl.update(collection);
            c = collectionEAOImpl.findById(Collection.class, collectionDTO.getCollectionId());
            c = collectionDTOFactory.updatePlainEntity(collectionDTO, c);
            collectionEAOImpl.update(c);
            return 1;
        }

    }

    public void deleteCollection(CollectionDTO collectionDTO) throws IllegalArgumentException {

        if(collectionDTO.getCollectionId() == null)
            throw new IllegalArgumentException("Not supported yet.");
        else{
            try{
                Collection collection = collectionEAOImpl.findById(Collection.class, collectionDTO.getCollectionId());
                collectionEAOImpl.delete(collection);
            } catch (Exception e){
                throw new IllegalArgumentException("Collection in use");
            }
        }
    }

    /**
     * 
     * @return
     */
    public List<SelectionListEntityDTO> getAllSelectionListEntities() {
        
        List<SelectionListEntityDTO> sleDTOList = new ArrayList<SelectionListEntityDTO>();
        SelectionListEntityDTO sleDTO;
        SelectionListEntity[] all = SelectionListEntity.values();

        for(SelectionListEntity sle: all){
			sleDTO = new SelectionListEntityDTO(sle.getId(),sle.getNameAsProperty());
            sleDTOList.add(sleDTO);
		}
        return sleDTOList;
    }

    public List<SelectionListDTO> getAllSelectionListElementsPaginated(Long selectionListEntityId, int first, int totalResults) {
            List<SelectionListGenericEntity> slgeList = this.selectionListValueEAOImpl.findAllPaginated(selectionListEntityId, first, totalResults);
            return this.selecionListDTOFactory.createDTOList(slgeList);
    }

    public Long countAllSelectionListElements(Long selectionListEntityId) {
        return selectionListValueEAOImpl.count(selectionListEntityId);
    }

    /**
     * @param sleDTO
     * @return 0 = create, 1 = update
     */
    public int saveOrUpdateSelectionListElement(SelectionListDTO sleDTO) {
        SelectionListGenericEntity slge;
        SelectionListEntity sle;

        if(sleDTO.getValueId() == null){
            sle = SelectionListEntity.getById(sleDTO.getSelectionListEntityId().intValue());
            //slge = sle.getImplementation();
            slge = sle.getImplementationEntity();
            slge.setName(sleDTO.getValueName());
            slge.setDescription(sleDTO.getValueDescription());
            selectionListValueEAOImpl.create(slge);
            return 0;
        } else {
            slge = selectionListValueEAOImpl.findById(sleDTO.getSelectionListEntityId(), sleDTO.getValueId());
            slge.setName(sleDTO.getValueName());
            slge.setDescription(sleDTO.getValueDescription());
            selectionListValueEAOImpl.update(slge);
            return 1;
        }

    }

    public void deleteSelectionListElement(SelectionListDTO sleDTO) throws IllegalArgumentException  {

        if(sleDTO.getValueId() == null || sleDTO.getSelectionListEntityId() == null)
            throw new IllegalArgumentException("Not supported yet.");
        else{
            try{
                selectionListValueEAOImpl.delete(sleDTO.getSelectionListEntityId(), sleDTO.getValueId());
            } catch (Exception e){
                throw new IllegalArgumentException("selection list value in use");
            }
        }

    }

    public List<CollectionDTO> getAllCollectionsAssociatedToSelectionListValue(Long selectedSelectionListEntityId, Long selectedSelectionListValueId) {
        List<Collection> cList = collectionEAOImpl.finAllBySelectionListValue(selectedSelectionListEntityId, selectedSelectionListValueId);
        return collectionDTOFactory.createDTOList(cList);
    }

    public void saveOrUpdateCollectionsBySelectionListValue(Long selectionListEntityId, Long selectionListValueId, List<Long> newCollectionsIdList) {
        /*Toma la lista de de las colecciones que *actualmente* estan asociadas (oldAssociatedCollections) y la lista de las que
         * deben estar asociadas (collectionsId). Primero elimina de ambas listas las que esten incluidas en ambas. Luego
         * elimina de la BD las que esten en 'oldAssociatedCollections' porque ya no son asociaciones y por último inserta las
         * nuevas asociaciones (collectionsId)
         */
        List<Collection> oldAssociatedCollections = collectionEAOImpl.finAllBySelectionListValue(selectionListEntityId, selectionListValueId);
        List<Collection> tobeDeleted = new ArrayList<Collection>();
        ListTableCollection ltc;  //selectionListCollection
        ListTableCollectionPK ltcPk;  //lave para el selectionListCollection

        //elimina de la lista los que ya estan asociados
        for(Collection old : oldAssociatedCollections){
            if(newCollectionsIdList.contains(old.getCollectionId())){
                newCollectionsIdList.remove(old.getCollectionId());
            } else {
                tobeDeleted.add(old);
            }
        }
        
        
         //borrar las antiguas colecciones asociadas.
        for(Collection c : tobeDeleted){
            ltcPk = new ListTableCollectionPK(selectionListEntityId, c.getCollectionId(), selectionListValueId);
            ltc = selectionListValueCollectionEAOImpl.findById(ListTableCollection.class, ltcPk);
            this.selectionListValueCollectionEAOImpl.delete(ltc);

        }
        
        //volver a insertar las colecciones que se acaban de seleccionar.
        for(Long collectionId : newCollectionsIdList){
            ltc = new ListTableCollection(selectionListEntityId, collectionId, selectionListValueId);
            this.selectionListValueCollectionEAOImpl.create(ltc);
        }

    }

    /**
     * Retrive all people paginated
     * @return
     */
    public List<PersonDTO> getAllPersonPaginated(int firstResult, int maxResults) {
        String[] orderByFields = {"firstName", "lastName"};
        return personDTOFactory.createDTOList(
                personEAOImpl.
                findAllPaginatedFilterAndOrderBy(
                Person.class, firstResult, maxResults, orderByFields,null));
    }

    public Long countPerson() {
        return this.personEAOImpl.count(Person.class);
    }

    /**
     * Metodo para eliminar Personas por su id
     * @param Id
     */
    public void deletePerson(Long Id) {
        /*Person aux = this.personEAOImpl.findById(Person.class, Id);
        if (aux != null) {*/
            this.personEAOImpl.delete(this.personEAOImpl.findById(Person.class, Id));
        //}
    }


    /**
     * Metodo para persistir una nueva persona a partir de un personDTO
     * @param pDTO
     * @return
     */
    public PersonDTO savePerson(PersonDTO pDTO) {
        Person entity = this.personDTOFactory.createPlainEntity(pDTO);
        this.personEAOImpl.create(entity);
        //Lo un DTO ahora con el Id asignado por la BD
        return this.personDTOFactory.createDTO(entity);
    }

    /**
     * Metodo para auctualizar una persona
     * @param pDTO
     * @return
     */
    public void updatePerson(PersonDTO pDTO) {
        Person entity = this.personEAOImpl.findById(Person.class, pDTO.
                getPersonKey());
        entity = this.personDTOFactory.updatePlainEntity(pDTO, entity);
        this.personEAOImpl.update(entity);
    }

    /**
     * Para persistir las istituciones asociadas a una persona
     */
    public void savePersonInstitutions(PersonDTO person,
            List<Long> institutions) {
        Long personId = person.getPersonKey();
        for (Long i : institutions) {
            PersonInstitutionPK pk = new PersonInstitutionPK(personId, i);
            PersonInstitution entity = new PersonInstitution(pk);
            this.personInstitutionEAOImpl.create(entity);
        }
    }

    /**
     * Para persistir los perfiles asociadas a una persona
     */
    public void savePersonProfiles(PersonDTO person, List<Long> profiles) {
        Long personId = person.getPersonKey();
        String personShortName = person.getFirstName()+" "+person.getLastName();
        for (Long p : profiles) {
            PersonProfilePK pk = new PersonProfilePK(personId, p);
            PersonProfile entity = new PersonProfile(pk);
            entity.setShortName(personShortName);
            this.personProfileEAOImpl.create(entity);
        }
    }

    public List<InstitutionDTO> getInstitutionsByPersonId(Long pId) {
        return institutionDTOFactory.createDTOList(institutionEAOImpl.
                getInstitutionsByPerson(pId));
    }

    public List<ProfileDTO> getProfilesByPersonId(Long pId) {
        return profileDTOFactoty.createDTOList(profileEAOImpl.
                getProfilesByPerson(pId));
    }

    public void deleteInstitutionsByPersonId(Long pId) {
        this.personInstitutionEAOImpl.deleteByPerson(pId);
    }

    public void deleteProfilesByPersonId(Long pId) {
        this.personProfileEAOImpl.deleteByPerson(pId);
    }

    

}
