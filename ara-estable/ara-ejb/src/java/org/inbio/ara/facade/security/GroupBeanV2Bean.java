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
 * GroupBeanV2Bean.java
 *
 * Created on 7 de julio de 2008, 08:55 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.facade.security;

import com.sun.data.provider.SortCriteria;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;
import org.inbio.ara.persistence.security.User;
import org.inbio.ara.persistence.security.UserOption;
import org.inbio.ara.persistence.security.UserOptionPK;
import org.inbio.ara.persistence.security.UserType;

/**
 *
 * @author roaguilar
 */
@Stateless
public class GroupBeanV2Bean implements org.inbio.ara.facade.security.GroupBeanV2Remote, org.inbio.ara.facade.security.GroupBeanV2Local {

    @PersistenceContext
    private EntityManager em;
    private User group;
    private List groupList;
    private List userOption;
    private String message;
    
    /** Creates a new instance of GroupBeanV2Bean */
    public GroupBeanV2Bean() {
    }
    
    public boolean persist() {
        if (!isGroupValid(this.group)){
            if (isGroupUnique(this.group)) {
                try {
                    UserType userType = this.getUserType();
                    try {
                        userType = (UserType)em.find(UserType.class,1L);
                    } catch (IllegalStateException illegalStateException) {
                        this.setMessage("Se perdi� la conexi�n con la base de datos");
                        return false;
                    } catch (IllegalArgumentException illegalArgumentException) {
                        this.setMessage("Argumentos err�neos." + illegalArgumentException.getMessage());
                        return false;
                    }
                    this.group.setUserType(userType);
                    em.persist(this.group);
                    return true;                
                } catch (EntityExistsException entityExistEx) {
                    setMessage("El registro ya existe en la base de datos.");
                    return false;
                } catch (IllegalStateException illegalStateEx) {
                    setMessage("La conexi�n con la base de datos fu� cerrada.");
                    return false;
                } catch (IllegalArgumentException illegalArgumentEx) {
                    setMessage("El objeto a persistir no es una entidad v�lida.");
                    return false;
                } catch (TransactionRequiredException transactionRequiredEx) {
                    setMessage("No se puede ejecutar la acci�n debido a que no hay una transacci�n activa");
                    return false;
                }
            } else {
                setMessage("Ya existe otro usuario almacenado en el sistema con el mismo usuario. El registro no fu� creado.");
                return false;
            }
        } else {
            this.setMessage(this.getMessage() + " El registro no fu� creado.");
            return false;
        }
    }

    public boolean create(User group, Long[] systemOptionArray) {
        //UserType userType;
        boolean created = false;
        this.group = group;
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
        return created;
    }
    
    public boolean remove(Long id) {
        boolean removed = false;
        try {
            this.group = em.find(User.class,id);
            if (this.canDeleteGroup(this.group.getId())) {
                this.group = em.merge(this.group);
                em.remove(this.group);
                removed = true;
            }
        } catch (Exception e) {
            this.setMessage(this.toString() + ":remove. Error:  " + e.getMessage());
            removed = false;
        }
        return removed;   
    }
    
    private boolean canDeleteGroup(Long id) {
        Query q;
        try {
            q = em.createQuery("Select object(o) from User as o where o.userGroup.id =" + id);
            if (q.getResultList().size() > 0) {
                setMessage("No se puede borrar el grupo puede tiene usuarios asociados.");
                return false;
            } else {
                return true;
            }
        } catch (IllegalStateException e) {
            setMessage("Se perdi� la conexi�n con la base de datos");
            return false;
        } catch (IllegalArgumentException ex) {
            setMessage("Consulta inv�lida");
            return false;
        }
    }
    
    public boolean update(User group, Long[] systemOptionArray) {
        boolean updated = false;
        if (updateGroup(group)) {            
            updated = true;
            this.group.setUserOptionCollection(this.getPrivilegiesFromIds(group.getId(), systemOptionArray));
            updateGroup(this.group);
            if ((systemOptionArray.length > 0) | (systemOptionArray != null)) {
                if (getGroup().getUserCollection().size() > 0) {
                    if (!updateUsersPrivilegies(systemOptionArray)){
                        this.setMessage("Error al actualizar los privilegios de los usuarios asociados: " + this.getMessage());
                    }                    
                }
            }
        }
        System.out.println(getMessage());
        return updated;
    }
    
    private Collection getPrivilegiesFromIds(Long id, Long[] systemOptionArray) {
        //Collection<SystemOption> tCollection = new HashSet();
        Collection<UserOption> tCollection = new ArrayList();
        UserOption currentOption;
        for (Long tId: systemOptionArray) {
            try {
                currentOption = new UserOption(id, tId);
                currentOption.setCreatedBy(this.group.getCreatedBy());
                currentOption.setLastModificationBy(this.group.getCreatedBy());
                tCollection.add(currentOption);
            } catch (Exception e) {
                // do nothing;
            }            
        }
        return tCollection;
    }
    
    private boolean updateUsersPrivilegies(Long[] systemOptionArray) {
        boolean updated = false;
        Collection<User> userList;
        //userList = this.getGroup().getUserCollection();
        userList = em.createQuery("Select object(o) from User as o where o.userGroup.id=" + this.getGroup().getId()).getResultList();
        for (User tUser: userList) {
            try {
                //userBean.deleteAllPrivilegies(tUser.getId());
                this.deleteAllPrivilegies(tUser.getId());
                //tUser.setUserOptionCollection(this.getGroup().getUserOptionCollection());
                //if (!userBean.update(tUser,systemOptionArray)) {
                if (!this.update(tUser,systemOptionArray)) {
                    //this.setMessage(userBean.getMessage());
                    updated = false;
                } else {
                    updated = true;
                }
                //em.merge(tUser);
            } catch(IllegalStateException e) {
                setMessage("Se perdi� la conexi�n con la base de datos.");
            } catch (IllegalArgumentException ex) {
                setMessage("Not an entity or removed entity");
            } catch (TransactionRequiredException exc) {
                setMessage("No hay transacci�n");
            }
        }
        return updated;
    }
    
    private boolean updateGroup(User group) {
        boolean updated = false;
        if (!isGroupValid(group)){
            if (this.isGroupUnique(group)) {
                try {
                    //this.group = group;
                    //em.merge(this.group);
                    this.group = em.merge(group);
                    updated = true;
                } catch (Exception ex) {
                    //this.setMessage("El registro No. " + this.group.getId() + " ha sido modificado o borrado por otro usuario. No se realiz� la modificaci�n.");
                    this.setMessage(ex.getCause().getLocalizedMessage());
                    updated = false;
                } catch (Throwable e) {
                    this.setMessage(this.toString() + ":updateGroup. Error: " + e.getLocalizedMessage());
                    System.out.println(this.getMessage());
                    updated = false;                    
                }
            } else {
                setMessage("Ya existe otro grupo almacenado en el sistema con el mismo grupo. El registro no fu� modificado.");
                updated = false;
            }            
        } else {
            this.setMessage(this.getMessage() + " El registro no fu� creado.");
        }
        return updated;  
    }
    
    /*
    public boolean update(User user, Long[] systemOptionArray) {
        boolean updated = false;
        if (!isUserValid(user)){
            if (this.isUserUnique(user)) {
                try {
                    this.user = user;
                    em.merge(this.user);
                    updated = true;
                    if (systemOptionArray != null) {
                        this.updatePrivilegies(systemOptionArray);
                    }
                } catch (Exception ex) {
                    this.setMessage("El registro No. " + this.user.getId() + " ha sido modificado o borrado por otro usuario. No se realiz� la modificaci�n.");
                    updated = false;
                }
            } else {
                setMessage("Ya existe otro usuario almacenado en el sistema con el mismo usuario. El registro no fu� modificado.");
                updated = false;
            }            
        } else {
            this.setMessage(this.getMessage() + " El registro no fu� creado.");
        }
        return updated;  
    }
    */
    public boolean updatePrivilegies(Long[] systemOptionArray){
        boolean updated = false;
        int i = 0;
        UserOptionPK uoPk;
        UserOption option;
        System.out.println("Cantidad de opciones: " + systemOptionArray.length);
        if (systemOptionArray != null) {
            for (Long optionId: systemOptionArray) {
                optionId = systemOptionArray[i];
                option = new UserOption(this.group.getId(),optionId);
                option.setCreatedBy("roaguilar");
                option.setLastModificationBy("roaguilar");
                try {
                    em.persist(option);
                    updated = true;                
                } catch (Exception ex) {
                    updated = false;
                    this.setMessage(this.toString() + ": updatePrivilegies. Error: " +ex.getLocalizedMessage());
                }
                i++;
            }
        } else {
            updated = true;
        }
        return updated;
    }

    public void deleteAllPrivilegies(Long userId) {
        UserOption option;
        Query q;
        List<UserOption> list;
        
        q = em.createQuery("Select Object(o) from UserOption as o where o.userOptionPK.userId = " + userId);
        list = q.getResultList();
        
        for (UserOption userOption: list) {
            try {
                option = em.find(UserOption.class,userOption.getUserOptionPK());
                option = em.merge(userOption);
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
    
    /*
    public User getGroup(String userName, String password) {
        String pwdEncrypted = encrypter.Encrypt(password);
        Query q = em.createQuery("Select object(o) from User as o where o.userName = '" + userName + "'");
        if (q.getResultList().size() <= 0) {
            this.setMessage("Usuario no existe");
            return null;
        } else {
            this.user = (User)q.getSingleResult();
            if (this.user.getPasswd().equals(pwdEncrypted)) {
                return this.getUser();
            } else {
                this.setMessage("Contrase�a incorrecta");
                return null;
            }            
        }
    }
    */

    /**
     * @deprecated
     * @use SecurityManager
     * @return
     */
    public List findAll() {
        Query q = em.createQuery("Select object(o) from User as o where o.userType.id = 1");
        this.groupList = (List)q.getResultList();
        return this.groupList;
    }
    
    public List findAll(int StartPosition, int maxResults, SortCriteria[] sortCriteria ) {
        String hql;
        int index;
        Query q;
        
        hql = "Select object(o) from User as o where o.userType.id = 1";
        if (sortCriteria!=null) {
            hql += " order by ";
            for (index =0; index < sortCriteria.length; index++) {
                if (index > 0) {
                    hql += ", ";
                }
                hql += "o." + sortCriteria[index];
            }
            if(!sortCriteria[0].isAscending()){
                hql += " desc";
            }
        }
        q = em.createQuery(hql);
        q.setMaxResults(maxResults);
        q.setFirstResult(StartPosition);
        return q.getResultList();
    }
    
    public List getGroupOptions(Long userId) {
        try {
            Query q = em.createQuery("Select object(o) from SystemOption as o, UserOption u where o.id = u.userOptionPK.optionId and u.userOptionPK.userId = " + userId);
            this.userOption = (List)q.getResultList();            
        } catch (Exception e) {
            this.setMessage(e.getMessage());
        } catch (Throwable ex) {
            this.setMessage(ex.getLocalizedMessage());
        }
        return this.userOption;
    }
    
    public User getGroup() {
        return this.group;
    }
    
    private boolean isGroupUnique(User user) {
        boolean isUnique = true;
        String userName, sql;
        Long tmpId;
        
        userName = user.getUserName();
        sql = "SELECT o FROM User o ";
        sql = sql + "where trim(lower(username)) = trim(lower('" + userName +"')) ";
        if (user.getId()!=null) {
            sql = sql + " and id <> " + user.getId();
        }
        if (em.createQuery(sql).getResultList().size() > 0) {
            isUnique = false;
        }
        return isUnique;
    }
    
    private boolean isGroupValid(User user) {
        boolean isNull = false;
        String msg = "";
        if ((user.getUserName() == null) || (user.getUserName().equals(""))){
            isNull = true;
            msg = "Grupo";
        }
        if ((user.getFullName() == null) || (user.getFullName().equals(""))){
            isNull = true;
            if (msg.equals("")) {
                msg = "Descripci�n del Grupo";
            } else {
                msg += ", Descripci�n del Grupo";
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
    
    public UserType getUserType() {
        UserType userType;
        try {
            userType = (UserType)em.find(UserType.class,2L);
            return userType;
        } catch (IllegalStateException illegalStateException) {
            this.setMessage("Se perdi� la conexi�n con la base de datos");
            return null;
        } catch (IllegalArgumentException illegalArgumentException) {
            this.setMessage("Argumentos err�neos." + illegalArgumentException.getMessage());
            return null;
        }
    }
    
    public UserType getGroupType() {
        UserType userType;
        try {
            userType = (UserType)em.find(UserType.class,1);
            return userType;
        } catch (IllegalStateException illegalStateException) {
            this.setMessage("Se perdi� la conexi�n con la base de datos");
            return null;
        } catch (IllegalArgumentException illegalArgumentException) {
            this.setMessage("Argumentos err�neos.");
            return null;
        }        
    }
}
