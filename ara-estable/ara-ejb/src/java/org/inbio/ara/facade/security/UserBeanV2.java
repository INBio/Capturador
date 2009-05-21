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
/*
 * UserBeanV2Bean.java
 *
 * Created on May 14, 2008, 11:10 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package org.inbio.ara.facade.security;

import com.sun.data.provider.SortCriteria;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;
import org.inbio.ara.persistence.security.SimpleModule;
import org.inbio.ara.persistence.security.SimpleSubsystem;
import org.inbio.ara.persistence.security.SystemOption;
import org.inbio.ara.persistence.security.User;
import org.inbio.ara.persistence.security.UserNomenclaturalGroup;
import org.inbio.ara.persistence.security.UserNomenclaturalGroupPK;
import org.inbio.ara.persistence.security.UserOption;
import org.inbio.ara.persistence.security.UserOptionPK;
import org.inbio.ara.persistence.security.UserTaxon;
import org.inbio.ara.persistence.security.UserTaxonPK;
import org.inbio.ara.persistence.security.UserType;
import org.inbio.ara.persistence.taxonomy.NomenclaturalGroup;
import org.inbio.ara.persistence.taxonomy.Taxon;
import org.inbio.ara.util.MD5Encrypter;

/**
 *
 * @deprecated 
 * @author roaguilar
 */
@Stateless
public class UserBeanV2 implements UserBeanV2Remote, UserBeanV2Local {

	@EJB
	private GroupBeanV2Remote groupBean;
	/*
	@EJB
	private GroupRemote groupBean;
	 */
	@PersistenceContext
	private EntityManager em;
	private User user;
	private List userList;
	private List userOption;
	private String message;
	private MD5Encrypter encrypter = new MD5Encrypter();

	/** Creates a new instance of UserBean */
	public UserBeanV2() {
	}

	public String getUserName() {
		return this.user.getUserName();
	}

	public boolean persist() {
		if (!isUserValid(this.user)) {
			if (isUserUnique(this.user)) {
				try {
					UserType userType = this.getUserType();
					try {
						userType = (UserType) em.find(UserType.class, 2L);
					} catch (IllegalStateException illegalStateException) {
						this.setMessage("Se perdió la conexión con la base de datos");
						return false;
					} catch (IllegalArgumentException illegalArgumentException) {
						this.setMessage("Argumentos erróneos." + illegalArgumentException.getMessage());
						return false;
					}
					this.user.setUserType(userType);
					em.persist(this.user);
					return true;
				} catch (EntityExistsException entityExistEx) {
					setMessage("El registro ya existe en la base de datos.");
					return false;
				} catch (IllegalStateException illegalStateEx) {
					setMessage("La conexión con la base de datos fué cerrada.");
					return false;
				} catch (IllegalArgumentException illegalArgumentEx) {
					setMessage("El objeto a persistir no es una entidad válida.");
					return false;
				} catch (TransactionRequiredException transactionRequiredEx) {
					setMessage("No se puede ejecutar la acción debido a que no hay una transacción activa");
					return false;
				}
			} else {
				setMessage("Ya existe otro usuario almacenado en el sistema con el mismo usuario. El registro no fué creado.");
				return false;
			}
		} else {
			this.setMessage(this.getMessage() + " El registro no fué creado.");
			return false;
		}
	}

	public boolean create(User user, Long groupId) {
		Long[] systemOptionArray;
		int i;
		List<SystemOption> optionList = groupBean.getGroupOptions(groupId);
		systemOptionArray = new Long[optionList.size()];
		i = 0;
		for (SystemOption systemOption : optionList) {
			systemOptionArray[i] = systemOption.getId();
			i++;
		}
		return this.create(user, systemOptionArray);
	}

	public boolean create(User user, Long[] systemOptionArray) {
		//UserType userType;
		boolean created = false;
		this.user = user;
		/*userType = this.getUserType();
		if (userType ==null) {
		this.setMessage(getMessage() + " Error al obtener tipo usuario");
		return false;
		}
		this.user.setUserType(userType);*/
		created = persist();
		if (created) {
			updatePrivilegies(systemOptionArray);
		}
		System.out.println(this.getMessage());
		return created;
	}

	public boolean remove(Long id) {
		boolean removed = false;
		try {
			this.user = em.find(User.class, id);
			//if (this.canDeletePerson(this.person)) {
			this.deleteTaxonList();
			this.deleteNomenclaturalGroupList();
			
			this.user = em.merge(this.user);
			em.remove(this.user);
			removed = true;
		//}
		} catch (Exception e) {
			this.setMessage(this.toString() + ":remove. Error:  " + e.getMessage());
			removed = false;
		}
		return removed;
	}

	@Override
	public boolean update(User user, Long[] systemOptionArray) {
		
		boolean updated = false;
		
		if (updateUser(user)) {

			deleteAllPrivilegies(user.getId());
			if ((systemOptionArray.length > 0) | (systemOptionArray != null)) {
				if (updatePrivilegies(systemOptionArray)) {
					updated = true;
				}
			}
		}
 		return updated;
	}

	@Override
	public boolean update(User user, Long[] systemOptionArray, Long[] taxonArray, Long[] groupArray) {

		if (update(user, systemOptionArray)) {
			if (this.clearLists()) {
				this.updateTaxonList(taxonArray);
				this.updateNomenclaturalGroupList(groupArray);
			}
			return true;
		} else {
			return false;
		}
	}

	public boolean updatePassword(User user) {
		user.encryptPassword();
		return this.updateUser(user);
	}

	private boolean updateUser(User user) {
		boolean updated = false;
		if (!isUserValid(user)) {
			if (this.isUserUnique(user)) {
				try {
					this.user = em.merge(user);
					em.persist(this.user);
					updated = true;
				} catch (Exception ex) {
					this.setMessage("El registro No. " + this.user.getId() + " ha sido modificado o borrado por otro usuario. No se realizó la modificación.");
					updated = false;
				} catch (Throwable e) {
					this.setMessage(this.toString() + ":updateUser. Error: " + e.getLocalizedMessage());
					System.out.println(this.getMessage());
					updated = false;
				}
			} else {
				setMessage("Ya existe otro usuario almacenado en el sistema con el mismo usuario. El registro no fué modificado.");
				updated = false;
			}
		} else {
			this.setMessage(this.getMessage() + " El registro no fué creado.");
		}
		return updated;
	}





	public boolean updatePrivilegies(Long[] systemOptionArray) {
		boolean updated = false;
		int i = 0;
		UserOptionPK uoPk;
		UserOption option;
		System.out.println("Cantidad de opciones: " + systemOptionArray.length);
		if (systemOptionArray != null) {
			for (Long optionId : systemOptionArray) {
				optionId = systemOptionArray[i];
				option = new UserOption(this.user.getId(), optionId);
				option.setCreatedBy("roaguilar");
				option.setLastModificationBy("roaguilar");
				try {
					em.persist(option);
					updated = true;
				} catch (Exception ex) {
					updated = false;
					this.setMessage(this.toString() + ": updatePrivilegies. Error: " + ex.getLocalizedMessage());
				}
				i++;
			}
		} else {
			updated = true;
		}
		return updated;
	}

	@Override
	public void deleteAllPrivilegies(Long userId) {
		UserOption option;
		Query q;
		List<UserOption> list;
		q = em.createQuery("Select Object(o) from UserOption as o where o.userOptionPK.userId = " + userId);
		list = q.getResultList();

		for (UserOption uOption : list) {
			try {
				option = em.find(UserOption.class, uOption.getUserOptionPK());
				option = em.merge(uOption);
				em.remove(option);
			} catch (Exception e) {
				this.setMessage(e.getLocalizedMessage());
				System.out.println(this.toString() + ":deleteAllPrivilegies. Error: " + this.getMessage());
			} catch (Throwable ex) {
				this.setMessage(this.toString() + ":deleteAllPrivilegies. Error: " + ex.getLocalizedMessage());
				System.out.println(this.getMessage());
			}
		}
	}

	public User getUser(String userName, String password) {
		String pwdEncrypted = encrypter.Encrypt(password);
		Query q = em.createQuery("Select object(o) from User as o where o.userName = '" + userName + "'");
		if (q.getResultList().size() <= 0) {
			this.setMessage("Usuario no existe");
			return null;
		} else {
			this.user = (User) q.getSingleResult();
			if (this.user.getPasswd().equals(pwdEncrypted)) {
				return this.getUser();
			} else {
				this.setMessage("Contraseña incorrecta");
				return null;
			}
		}
	}

    /**
     * @deprecated
     * @return
     */
	public List findAll() {
		Query q = em.createQuery("Select object(o) from User as o where o.userType.id = 2");
		this.userList = (List) q.getResultList();
		return this.userList;
	}

	public List findAll(int StartPosition, int maxResults, SortCriteria[] sortCriteria) {
		String hql;
		int index;
		Query q;

		hql = "Select object(o) from User as o";
		if (sortCriteria != null) {
			hql += " order by ";
			for (index = 0; index < sortCriteria.length; index++) {
				if (index > 0) {
					hql += ", ";
				}
				hql += "o." + sortCriteria[index];
			}
			if (!sortCriteria[0].isAscending()) {
				hql += " desc";
			}
		}
		q = em.createQuery(hql);
		q.setMaxResults(maxResults);
		q.setFirstResult(StartPosition);
		return q.getResultList();
	}

	public List getUserOptions(Long userId) {
		try {
			Query q = em.createQuery("Select object(o) from SystemOption as o, UserOption u where o.id = u.userOptionPK.optionId and u.userOptionPK.userId = " + userId);
			this.userOption = (List) q.getResultList();
		} catch (Exception e) {
			this.setMessage(e.getMessage());
		} catch (Throwable ex) {
			this.setMessage(ex.getLocalizedMessage());
		}
		return this.userOption;
	}

	public User getUser() {
		return this.user;
	}

	private boolean isUserUnique(User user) {
		boolean isUnique = true;
		String userName, sql;
		Long tmpId;

		userName = user.getUserName();
		sql = "SELECT o FROM User o ";
		sql = sql + "where trim(lower(username)) = trim(lower('" + userName + "')) ";
		if (user.getId() != null) {
			sql = sql + " and id <> " + user.getId();
		}
		if (em.createQuery(sql).getResultList().size() > 0) {
			isUnique = false;
		}
		return isUnique;
	}

	private boolean isUserValid(User user) {
		boolean isNull = false;
		String msg = "";
		if ((user.getUserName() == null) || (user.getUserName().equals(""))) {
			isNull = true;
			msg = "Usuario";
		}
		if ((user.getFullName() == null) || (user.getFullName().equals(""))) {
			isNull = true;
			if (msg.equals("")) {
				msg = "Nombre del usuario";
			} else {
				msg += ", Nombre del usuario";
			}
		}
		if ((user.getPasswd() == null) || (user.getPasswd().equals(""))) {
			isNull = true;
			if (msg.equals("")) {
				msg = "Contraseña";
			} else {
				msg += ", Contraseña";
			}
		}

		if (isNull) {
			msg = "Los siguientes campos son obligatorios: " + msg + ".";
			this.setMessage(msg);
		}
		return isNull;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean changeUserPassword(long userId, String oldPassword, String newPassword) {
		User tUser;
		try {
			tUser = em.find(User.class, userId);
			if (tUser == null) {
				// No se encontró una entidad para el id dado.
				this.setMessage("No se encontró la entidad");
				return false;
			} else {
				// Se encontró la entidad
				// Verificar si la oldPassword coincide con la contraseña actual del usuario
				String tPwd = this.encrypter.Encrypt(oldPassword);
				if (!tUser.getPasswd().equals(tPwd)) {
					System.out.println("Contraseña actual: " + tUser.getPasswd());
					System.out.println("Contraseña digitada por le usuario" + tPwd);
					// La contraseña actual digitada por el usuario no coincide
					this.setMessage("Contraseña actual no coindice con la registrada en el sistema");
					return false;
				} else {
					tUser.setPasswd(newPassword);
					tUser.encryptPassword();
					return this.updateUser(tUser);
				}
			}
		} catch (IllegalStateException illegalStateEx) {
			this.setMessage(this.toString() + ": changeUserPassword" + illegalStateEx.getMessage());
			return false;

		} catch (IllegalArgumentException illegalArgumentEx) {
			this.setMessage(this.toString() + ": changeUserPassword" + illegalArgumentEx.getMessage());
			return false;
		}
	}

	public UserType getUserType() {
		UserType userType;
		try {
			userType = (UserType) em.find(UserType.class, 2L);
			return userType;
		} catch (IllegalStateException illegalStateException) {
			this.setMessage("Se perdió la conexión con la base de datos");
			return null;
		} catch (IllegalArgumentException illegalArgumentException) {
			this.setMessage("Argumentos erróneos." + illegalArgumentException.getMessage());
			return null;
		}
	}

	public UserType getGroupType() {
		UserType userType;
		try {
			userType = (UserType) em.find(UserType.class, 1);
			return userType;
		} catch (IllegalStateException illegalStateException) {
			this.setMessage("Se perdió la conexión con la base de datos");
			return null;
		} catch (IllegalArgumentException illegalArgumentException) {
			this.setMessage("Argumentos erróneos.");
			return null;
		}
	}

	public User getUser(Long userId) {
		User user;
		try {
			user = (User) em.find(User.class, userId);
			return user;
		} catch (IllegalStateException illegalStateException) {
			this.setMessage("Se perdió la conexión con la base de datos");
			return null;
		} catch (IllegalArgumentException illegalArgumentException) {
			this.setMessage("Argumentos erróneos." + illegalArgumentException.getMessage());
			return null;
		}
	}

	public List getGroupSubsystems(Long groupId) {
		String sql;
		Query q;

		sql = "select distinct o.subsystem_id, o.name, o.sequence from ";
		sql += "ara.system_subsystem as o, ara.system_module as p, ara.system_option as q, ara.system_user_option as r ";
		sql += "where o.subsystem_id = p.subsystem_id and ";
		sql += "p.module_id = q.module_id and  ";
		sql += "q.option_id = r.option_id and ";
		sql += "r.user_id = " + groupId + " and ";
		sql += "q.type_id = 1 order by o.sequence";
		q = em.createNativeQuery(sql);
		List subSystemList = q.getResultList();
		List subSystemList2 = new ArrayList();
		;
		if (subSystemList.size() > 0) {
			for (int i = 0; i < subSystemList.size(); i++) {
				SimpleSubsystem temp = new SimpleSubsystem();
				Object[] o = (Object[]) (subSystemList.get(i));

				temp.setId(Long.parseLong(o[0].toString()));
				temp.setName(o[1].toString());
				temp.setSequence(Long.parseLong(o[2].toString()));

				subSystemList2.add(temp);
			}
		}

		return subSystemList2;
	}

	public List getSubsystemModules(Long subSystemId, Long groupId) {
		String sql;
		Query q;

		sql = "select distinct p.module_id, p.name, q.navigation_rule from ";
		sql += "ara.system_module as p, ara.system_option as q, ara.system_user_option as r ";
		sql += "where p.module_id = q.module_id and ";
		sql += "q.option_id = r.option_id and ";
		sql += "p.subsystem_id = " + subSystemId + " and ";
		sql += "r.user_id = " + groupId + " and ";
		sql += "q.type_id = 1 order by p.name";
		System.out.println(sql);
		q = em.createNativeQuery(sql);
		List moduleList = q.getResultList();
		List moduleList2 = new ArrayList();
		;
		if (moduleList.size() > 0) {
			for (int i = 0; i < moduleList.size(); i++) {
				SimpleModule temp = new SimpleModule();
				Object[] o = (Object[]) (moduleList.get(i));

				temp.setId(Long.parseLong(o[0].toString()));
				temp.setName(o[1].toString());
				temp.setNavigationRule(o[2].toString());

				moduleList2.add(temp);
			}
		}
		return moduleList2;
	}

	public String canAdd(Long userId, Long moduleId) {
		return this.getPrivilege(userId, moduleId, 2L);
	}

	public String canModify(Long userId, Long moduleId) {
		return this.getPrivilege(userId, moduleId, 3L);
	}

	public String canDelete(Long userId, Long moduleId) {
		return this.getPrivilege(userId, moduleId, 4L);
	}

	private String getPrivilege(Long userId, Long moduleId, Long optionTypeId) {
		String sql;
		Query q;
		String navigationRule = null;

		sql = "select so.navigation_rule from ";
		sql += "ara.system_option as so, ara.system_user_option as su ";
		sql += "where so.option_id = su.option_id and ";
		sql += "su.user_id = " + userId + " and ";
		sql += "so.type_id = " + optionTypeId + " and ";
		sql += "so.module_id = " + moduleId;
		System.out.println(sql);
		q = em.createNativeQuery(sql);
		List list = q.getResultList();
		if (list.size() > 0) {
			//String[] o = (String[]) (list.get(0));
			navigationRule = (String) list.get(0);
		}
		return navigationRule;
	}

	private boolean clearLists() {
		this.deleteTaxonList();
		this.deleteNomenclaturalGroupList();
		return true;
	}

    //@deprecated
	private void deleteTaxonList() {
		Query q;
		q = em.createNativeQuery("delete from ara.user_taxon where user_id = " + this.user.getId());
		q.executeUpdate();
		}

    //@deprecated
	private void deleteNomenclaturalGroupList() {
		Query q;
		q = em.createNativeQuery("delete from ara.user_nomenclatural_group where user_id = " + this.user.getId());
		q.executeUpdate();
	
	}

	private void updateTaxonList(Long[] taxonArray) {
		UserTaxon userTaxon;
		Taxon taxon;
		Long i = 1L;
		System.out.println("Procediendo a crear taxones");

		if (taxonArray.length > 0) {
			for (Long taxonId : taxonArray) {
				taxon = (Taxon) em.find(Taxon.class, taxonId);
				UserTaxonPK pk = new UserTaxonPK();

				pk.setTaxonId(taxon.getTaxonId());
				pk.setUserId(user.getId());
				pk.setSequence(i);

				userTaxon = new UserTaxon();
				userTaxon.setUserTaxonPK(pk);
				userTaxon.setCreatedBy(user.getLastModificationBy());
				userTaxon.setLastModificationBy(user.getLastModificationBy());

				try {
					em.persist(userTaxon);
				} catch (EntityExistsException entityExistEx) {
					setMessage("El registro ya existe en la base de datos.");
				} catch (IllegalStateException illegalStateEx) {
					setMessage("La conexión con la base de datos fue cerrada.");
				} catch (IllegalArgumentException illegalArgumentEx) {
					setMessage("El objeto a persistir no es una entidad válida.");
				} catch (TransactionRequiredException transactionRequiredEx) {
					setMessage("No se puede ejecutar la acción debido a que no hay una transacción activa");
				}
				i++;
			}
		}
	}

	private void updateNomenclaturalGroupList(Long[] groupArray) {
		UserNomenclaturalGroup userNGroup;
		NomenclaturalGroup group;
		Long i = 1L;
		System.out.println("Procediendo a crear grupos nomenclaturales");

		if (groupArray.length > 0) {
			for (Long groupId : groupArray) {
				group = (NomenclaturalGroup) em.find(NomenclaturalGroup.class, groupId);
				UserNomenclaturalGroupPK pk = new UserNomenclaturalGroupPK();

				pk.setNomenclaturalGroupId(group.getId());
				pk.setUserId(user.getId());
				pk.setSequence(i);

				userNGroup = new UserNomenclaturalGroup();
				userNGroup.setUserNomenclaturalGroupPK(pk);
				userNGroup.setCreatedBy(user.getLastModificationBy());
				userNGroup.setLastModificationBy(user.getLastModificationBy());

				try {
					em.persist(userNGroup);
				} catch (EntityExistsException entityExistEx) {
					setMessage("El registro ya existe en la base de datos.");
				} catch (IllegalStateException illegalStateEx) {
					setMessage("La conexión con la base de datos fue cerrada.");
				} catch (IllegalArgumentException illegalArgumentEx) {
					setMessage("El objeto a persistir no es una entidad válida.");
				} catch (TransactionRequiredException transactionRequiredEx) {
					setMessage("No se puede ejecutar la acción debido a que no hay una transacción activa");
				}
				i++;
			}
		}
	}
}
