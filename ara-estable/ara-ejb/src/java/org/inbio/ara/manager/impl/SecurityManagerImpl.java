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
package org.inbio.ara.manager.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.inbio.ara.dto.GroupLiteDTO;
import org.inbio.ara.dto.UserFullDTO;
import org.inbio.ara.dto.UserLiteDTO;
import org.inbio.ara.dto.UserTypeEntity;
import org.inbio.ara.dto.factory.GroupLiteDTOFactory;
import org.inbio.ara.dto.factory.UserLiteDTOFactory;
import org.inbio.ara.eao.GroupLocalEAO;
import org.inbio.ara.eao.UserLocalEAO;
import org.inbio.ara.eao.UserOptionLocalEAO;
import org.inbio.ara.manager.SecurityManagerRemote;
import org.inbio.ara.persistence.security.User;
import org.inbio.ara.persistence.security.UserOption;
import org.inbio.ara.util.MD5Encrypter;

/**
 *
 * @author jgutierrez
 */
@Stateless
public class SecurityManagerImpl implements SecurityManagerRemote {

	@EJB
	UserLocalEAO userEAOImpl;

	@EJB
	GroupLocalEAO groupEAOImpl;

	@EJB
	UserOptionLocalEAO userOptionEAOImpl;
    
	private MD5Encrypter encrypter = new MD5Encrypter();

	/**
	 *
	 * @return
	 */
	@Override
	public List<UserLiteDTO> listAllUserLite() {

		UserLiteDTOFactory userLiteDTOFactory = new UserLiteDTOFactory();

		List<User> usersList = userEAOImpl.listAllUser();

		return userLiteDTOFactory.createDTOList(usersList);

	}

	/**
	 *
	 * @return
	 */
	@Override
	public List<GroupLiteDTO> listAllGroupsList() {

		GroupLiteDTOFactory groupLiteDTOFactory = new GroupLiteDTOFactory();

		List<User> groupsList = groupEAOImpl.listAllGroups();

		return groupLiteDTOFactory.createDTOList(groupsList);
	}

	/**
	 *
	 * @deprecated
	 * @param userDTO
	 */
	@Override
	public void addUser(UserFullDTO userDTO) {

		User tUser = new User();

		tUser.setUserName(userDTO.getUserName());
		tUser.setFullName(userDTO.getFullName());
		tUser.setPasswd(userDTO.getPassword());

		tUser.setUserGroup(
				(User) groupEAOImpl.findById(
				User.class,
				userDTO.getGroupKey()));

		tUser.setEnabled(1L);
		tUser.setUserType(userEAOImpl.getUserTypeById(UserTypeEntity.USER_TYPE.getId()));

		tUser.setCreatedBy(userDTO.getCreatedBy());
		tUser.setLastModificationBy(userDTO.getLastModificationBy());

		tUser.setUserCollection(null);
		tUser.setUserOptionCollection(null);

		userEAOImpl.create(tUser);

		
		userDTO.setUserKey(tUser.getId());
		copyPrivileges(userDTO);

	}

	/**
	 * @deprecated
	 * @param userGrupId
	 * @return
	 * TODO: quitar esta !"#$"#$& de aquí
	 */
	private void copyPrivileges(UserFullDTO userData) {

		UserOption option = null;

		//toma las opciones de los grupos
		List<UserOption> groupOptions = userOptionEAOImpl.findAllByGroupId(userData.getGroupKey());

		if (groupOptions != null) {
			for (UserOption uo : groupOptions) {
				option = new UserOption(userData.getUserKey(), uo.getOption().getId());
				option.setCreatedBy(userData.getCreatedBy());
				option.setLastModificationBy(userData.getLastModificationBy());
				userOptionEAOImpl.create(option);
			}
		}
	}

	/**
	 * //TODO: deberia TIRAR UNA EXCEPCION
	 * @param userKey
	 */
	@Override
	public void deleteUser(Long userKey) {
		//borrar nomenclatural group list asociada
		userOptionEAOImpl.deleteAllByUserId(userKey);
		userEAOImpl.delete(User.class, userKey);

	}

	@Override
	public UserFullDTO findById(Long id) {

		UserFullDTO userDTO = new UserFullDTO();
		User user = (User) userEAOImpl.findById(User.class, id);

		userDTO.setFullName(user.getFullName());
		userDTO.setUserKey(user.getId());
		userDTO.setUserName(user.getUserName());
		userDTO.setGroupKey(user.getUserGroup().getId());

		return userDTO;
	}

	/**
	 * @deprecated
	 * @param userDTO
	 */
	@Override
	public void updateUser(UserFullDTO userDTO) {
		
		User tUser = (User)userEAOImpl.findById(User.class, userDTO.getUserKey());
		
	
		tUser.setUserName(userDTO.getUserName());
		tUser.setFullName(userDTO.getFullName());

        
		tUser.setUserGroup(
				(User) groupEAOImpl.findById(
				User.class,
				userDTO.getGroupKey()));
		
		tUser.setLastModificationBy(userDTO.getLastModificationBy());

		userEAOImpl.update(tUser);

		userEAOImpl.deleteNomenclaturalGroupList(userDTO.getUserKey());


		userEAOImpl.updateNomenclaturalGroupList(
				userDTO.getSelectedNomenclaturalGroupKeys().toArray(
					new Long[userDTO.getSelectedNomenclaturalGroupKeys().size()])
				, tUser);

		userEAOImpl.deleteTaxonList(userDTO.getUserKey());
		userEAOImpl.updateTaxonList(
				userDTO.getSelectedTaxonKeys().toArray(
					new Long[userDTO.getSelectedTaxonKeys().size()])
				, tUser);
		
		userOptionEAOImpl.deleteAllByUserId(userDTO.getUserKey());

		userDTO.setCreatedBy(tUser.getCreatedBy());
		copyPrivileges(userDTO);

	}

	@Override
	public boolean verifyPassword(Long userId, String password){

		boolean result = false;
		String currentPassword = null;

		User user = (User)userEAOImpl.findById(User.class, userId);
		currentPassword = encrypter.Encrypt(password);
		result = user.getPasswd().equals(currentPassword);

		return result;
	}

	@Override
	public void updatePassword(Long userId, String password){
		User user = (User)userEAOImpl.findById(User.class, userId);
		String encriptedPassword = encrypter.Encrypt(password);
		user.setPasswd(encriptedPassword);
		userEAOImpl.update(user);
	}
}
