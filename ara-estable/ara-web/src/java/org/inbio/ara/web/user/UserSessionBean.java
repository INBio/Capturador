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
 * UserSessionBean.java
 *
 * Created on September 15, 2007, 7:42 PM
 * Copyright roaguilar
 */
package org.inbio.ara.web.user;

import com.sun.data.provider.impl.ObjectListDataProvider;
import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.Option;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.FacesException;
import org.inbio.ara.dto.GroupLiteDTO;
import org.inbio.ara.dto.UserFullDTO;
import org.inbio.ara.dto.UserLiteDTO;
import org.inbio.ara.manager.SecurityManagerRemote;
import org.inbio.ara.web.group.GroupSessionBean;
import org.inbio.ara.web.util.SelectionListBean;

/**
 * <p>Session scope data bean for your application.  Create properties
 *  here to represent cached data that should be made available across
 *  multiple HTTP requests for an individual user.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 */
public class UserSessionBean extends AbstractSessionBean {

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>
    @EJB
    private SecurityManagerRemote securityManager;

    // Data Bindings
    private ObjectListDataProvider userListDataProvider = new ObjectListDataProvider(UserLiteDTO.class);
    private TextField userNameTextField = new TextField();
    private TextField fullNameTextField = new TextField();
    //-----------

    // Usuario que fue seleccionado para el Editar.
    private Long userId;

    // grupos nomenclaturales
    private Option[] availableGroups;
    private Long[] selectedGroups;
    // taxa
    private Option[] availableTaxa;
    private Long[] selectedTaxa;

    // Grupos de Usuarios
    private Long selectedGroup;
    private Option[] groupList;
    // Opciones de seguridad
    private Option[] groupOptions;

    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public UserSessionBean() {
    }

    /**
     * <p>This method is called when this bean is initially added to
     * session scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * session scope.</p>
     *
     * <p>You may customize this method to initialize and cache data values
     * or resources that are required for the lifetime of a particular
     * user session.</p>
     */
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("UserSessionBean Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

    // </editor-fold>
    // Perform application initialization that must complete
    // *after* managed components are initialized
    // TODO - add your own initialization code here
    }

    /**
     * <p>This method is called when the session containing it is about to be
     * passivated.  Typically, this occurs in a distributed servlet container
     * when the session is about to be transferred to a different
     * container instance, after which the <code>activate()</code> method
     * will be called to indicate that the transfer is complete.</p>
     *
     * <p>You may customize this method to release references to session data
     * or resources that can not be serialized with the session itself.</p>
     */
    public void passivate() {
    }

    /**
     * <p>This method is called when the session containing it was
     * reactivated.</p>
     *
     * <p>You may customize this method to reacquire references to session
     * data or resources that could not be serialized with the
     * session itself.</p>
     */
    public void activate() {
    }

    /**
     * <p>This method is called when this bean is removed from
     * session scope.  Typically, this occurs as a result of
     * the session timing out or being terminated by the application.</p>
     *
     * <p>You may customize this method to clean up resources allocated
     * during the execution of the <code>init()</code> method, or
     * at any later time during the lifetime of the application.</p>
     */
    public void destroy() {
    }

    /**
     * Carga la información al dataProvider
     *
     */
    public void setUserListDataProviderInfo() {
        userListDataProvider.setList(securityManager.listAllUserLite());
    }

    /**
     * Carga la lista de Grupos de Usuario
     */
    public void loadGroupList() {

        // Carga los Grupos en el a travez de la variable en el UserSessionBean
        List<GroupLiteDTO> dtoGroupList = this.getSecurityManager().listAllGroupsList();

        Option[] tempOptions = new Option[dtoGroupList.size()];

        int i = 0;
        for (GroupLiteDTO aGroup : dtoGroupList) {

            tempOptions[i++] =
                    new Option(aGroup.getGroupKey(),
                    aGroup.getGroupName());
        }

        this.setGroupList(tempOptions);
    }

    public void loadNomenclaturalGroups(Long userId) {

        SelectionListBean slb = getSelectionListBean();

        this.setAvailableGroups(slb.getNomenclaturalGroups());
        this.setSelectedGroups(slb.getSelectedUserNomenclaturalGroup(userId));

    }

    public void loadTaxa(Long userId) {

        SelectionListBean slb = getSelectionListBean();

        this.setAvailableTaxa(slb.getTaxons());
        this.setSelectedTaxa(slb.getSelectedUserTaxon(userId));

    }

    public void loadData() {

        UserFullDTO userDTO = securityManager.findById(this.userId);

        userNameTextField.setText(userDTO.getUserName());
        fullNameTextField.setText(userDTO.getFullName());

        loadTaxa(userDTO.getUserKey());
        loadNomenclaturalGroups(userDTO.getUserKey());
        this.setSelectedGroup(userDTO.getGroupKey());

    }

    public void updatePassword(Long userId, String password) {
    }

    public boolean verifyPassword(String password) {
        return securityManager.verifyPassword(this.userId, password);
    }

    public void updatePassword(String password) {
        securityManager.updatePassword(this.userId, password);
    }


    // Getters de Beans ----------------------------------------------
    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected GroupSessionBean getGroupSessionBean() {
        return (GroupSessionBean) getBean("group$GroupSessionBean");
    }

    protected SelectionListBean getSelectionListBean() {
        return (SelectionListBean) getBean("util$SelectionListBean");
    }

// Getters y setters de variables ------------------------------------------
    public ObjectListDataProvider getUserListDataProvider() {
        return userListDataProvider;
    }

    public void setUserListDataProvider(ObjectListDataProvider userListDataProvider) {
        this.userListDataProvider = userListDataProvider;
    }

    public SecurityManagerRemote getSecurityManager() {
        return securityManager;
    }

    public void setSecurityManager(SecurityManagerRemote securityManager) {
        this.securityManager = securityManager;
    }

    public Option[] getAvailableGroups() {
        return availableGroups;
    }

    public void setAvailableGroups(Option[] availableGroups) {
        this.availableGroups = availableGroups;
    }

    public Option[] getAvailableTaxa() {
        return availableTaxa;
    }

    public void setAvailableTaxa(Option[] availableTaxa) {
        this.availableTaxa = availableTaxa;
    }

    public Long getSelectedGroup() {
        return selectedGroup;
    }

    public void setSelectedGroup(Long selectedGroup) {
        this.selectedGroup = selectedGroup;
    }

    public Long[] getSelectedGroups() {
        return selectedGroups;
    }

    public void setSelectedGroups(Long[] selectedGroups) {
        this.selectedGroups = selectedGroups;
    }

    public Long[] getSelectedTaxa() {
        return selectedTaxa;
    }

    public void setSelectedTaxa(Long[] selectedTaxons) {
        this.selectedTaxa = selectedTaxons;
    }

    public Option[] getGroupOptions() {
        return groupOptions;
    }

    public void setGroupOptions(Option[] groupOptions) {
        this.groupOptions = groupOptions;
    }

    public Option[] getGroupList() {
        return groupList;
    }

    public void setGroupList(Option[] groupList) {
        this.groupList = groupList;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long UserId) {
        this.userId = UserId;
    }

    public TextField getFullNameTextField() {
        return fullNameTextField;
    }

    public void setFullNameTextField(TextField fullNameTextField) {
        this.fullNameTextField = fullNameTextField;
    }

    public TextField getUserNameTextField() {
        return userNameTextField;
    }

    public void setUserNameTextField(TextField userNameTextField) {
        this.userNameTextField = userNameTextField;
    }
}
