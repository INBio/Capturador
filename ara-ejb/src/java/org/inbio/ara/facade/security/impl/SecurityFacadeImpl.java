/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.facade.security.impl;

import java.util.List;
import javax.ejb.EJB;
import org.inbio.ara.facade.security.SecurityFacadeRemote;
import javax.ejb.Stateless;
import org.inbio.ara.dto.security.NomenclaturalGroupDTO;
import org.inbio.ara.dto.security.NomenclaturalGroupDTOFactory;
import org.inbio.ara.dto.security.SystemUserDTO;
import org.inbio.ara.dto.security.SystemUserDTOFactory;
import org.inbio.ara.eao.security.NomenclaturalGroupEAOLocal;
import org.inbio.ara.eao.security.SystemUserEAOLocal;
import org.inbio.ara.eao.security.UserNomenclaturalGroupEAOLocal;
import org.inbio.ara.eao.security.UserTaxonEAOLocal;
import org.inbio.ara.eao.taxonomy.TaxonEAOLocal;
import org.inbio.ara.persistence.security.SystemUser;
import org.inbio.ara.persistence.taxonomy.NomenclaturalGroup;
import org.inbio.ara.persistence.taxonomy.Taxon;
import org.inbio.ara.persistence.taxonomy.UserNomenclaturalGroup;
import org.inbio.ara.persistence.taxonomy.UserNomenclaturalGroupPK;
import org.inbio.ara.persistence.taxonomy.UserTaxon;
import org.inbio.ara.persistence.taxonomy.UserTaxonPK;

/**
 *
 * @author esmata
 */
@Stateless
public class SecurityFacadeImpl implements SecurityFacadeRemote {

    //Injections
    @EJB
    private SystemUserEAOLocal systemUserEAOImpl;
    @EJB
    private NomenclaturalGroupEAOLocal nomenclaturalEAOImpl;
    @EJB
    private TaxonEAOLocal taxonEAOImpl;
    @EJB
    private UserTaxonEAOLocal userTaxonEAOImpl;
    @EJB
    private UserNomenclaturalGroupEAOLocal userNomenclaturalGroupEAOImpl;

    //DTO's factories
    private SystemUserDTOFactory systemUserDTOFactory = new SystemUserDTOFactory();
    private NomenclaturalGroupDTOFactory nomenclaturalDTOFactory = new NomenclaturalGroupDTOFactory();

    /**
     * Encontrar un usuario de sistema especifico
     * @param name
     * @param pass
     * @return
     */
    public SystemUserDTO getSystemUserByNameAndPass(String name,String pass){
        SystemUser aux = systemUserEAOImpl.getSystemUserByNameAndPass(name, pass);
        return systemUserDTOFactory.createDTO(aux);
    }

    /**
     * Metodo para obtener la lista de grupos con la que puede trabajar un
     * determinado usuario
     */
    public List<NomenclaturalGroupDTO> getNomenclaturalGroupList(Long userId){
        return this.nomenclaturalDTOFactory.createDTOList(this.nomenclaturalEAOImpl.getNomenclaturalGroupList(userId));
    }

    /**
     * Metodo para obtener la lista completa de grupos nomenclaturales
     */
    public List<NomenclaturalGroupDTO> getAllNomenclaturalGroup(){
        return this.nomenclaturalDTOFactory.createDTOList(this.nomenclaturalEAOImpl.findAll(NomenclaturalGroup.class));
    }

    /**
     * Metodo para persistir un nuevo usuario
     * @param uDTO
     * @return
     */
    public SystemUserDTO saveNewSystemUser(SystemUserDTO uDTO){

        //Entidad a persistir
        SystemUser entity = systemUserDTOFactory.createEntity(uDTO);

        //Persistir entidad
        systemUserEAOImpl.create(entity);

        //Refrescar el DTO con los datos de la entidad persistida
        uDTO = systemUserDTOFactory.createDTO(entity);

        return uDTO;
    }

    /**
     * Metodo que se encarga de actualizar la entidad a partir del dto
     */
    public void updateSystemUser(SystemUserDTO dto){
        SystemUser entity = systemUserDTOFactory.createEntity(dto);
        systemUserEAOImpl.update(entity);
    }

    /**
     * Metodo para eliminar una entidad
     */
    public void deleteSystemUser(SystemUserDTO dto){
        SystemUser entity = systemUserEAOImpl.findById(SystemUser.class, dto.getUserId());
        systemUserEAOImpl.delete(entity);
    }

    /**
     * Metodo para eliminar las entidades user_taxon asociadas a un usuario
     */
    public void deleteUserTaxonsByUser(Long userId){
        //Obtener la lista de user_taxon
        List<UserTaxon> list = userTaxonEAOImpl.getUserTaxonList(userId);
        //Borrar cada entrada
        for(UserTaxon t : list){
            userTaxonEAOImpl.delete(t);
        }
    }

    /**
     * Metodo para eliminar las entidades user_nomenclatural_group asociadas a un usuario
     */
    public void deleteNomenclaturalGroupsByUser(Long userId){
        //Obtener la lista de user_nomenclatura_group
        List<UserNomenclaturalGroup> list = userNomenclaturalGroupEAOImpl.getNomenclaturalGroupList(userId);
        //Borrar cada entrada
        for(UserNomenclaturalGroup ng : list){
            userNomenclaturalGroupEAOImpl.delete(ng);
        }
    }

     /**
     * Persistir un nuevo userTaxon
     */
    public void saveUserTaxon(Long taxonId,Long userId,Long secuence){
        UserTaxonPK pk = new UserTaxonPK(taxonId, userId, secuence);
        UserTaxon userTaxon = new UserTaxon(pk);
        this.userTaxonEAOImpl.create(userTaxon);
    }

     /**
     * Persistir un nuevo UserNomenclaturalGroup
     */
    public void saveUserNomenclaturalGroup(Long groupId,Long userId,Long secuence){
        UserNomenclaturalGroupPK pk = new UserNomenclaturalGroupPK(groupId, userId, secuence);
        UserNomenclaturalGroup group = new UserNomenclaturalGroup(pk);
        this.userNomenclaturalGroupEAOImpl.create(group);
    }

    /**
     * Retorna la cantidad total de usuarios registrados
     */
    public Long countUsers() {
            return systemUserEAOImpl.countUserEnabled();
    }

    /**
     * Retorna un listado paginado de los usuarios
     */
    public List<SystemUserDTO> getAllUsersPaginated(int first, int totalResults) {

            List<SystemUser> gList = systemUserEAOImpl.getAllUserEnabledPaginated(first, totalResults);
            if (gList == null) {
                    return null;
            } else {
                    return systemUserDTOFactory.createDTOList(gList);
            }
    }

    public Long getCollecionIdByNomenclaturalGroupId(Long nomenclatural) {
        NomenclaturalGroup ng = nomenclaturalEAOImpl.findById(NomenclaturalGroup.class, nomenclatural);
        return ng.getCollectionId();
    }
    
}
