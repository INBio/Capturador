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

package org.inbio.ara.security;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.convert.CharacterConverter;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.dto.security.NomenclaturalGroupDTO;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version EditUser.java
 * @version Created on 23/09/2009, 05:24:10 PM
 * @author esmata
 */

public class EditUser extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>

    //Contexto utilizado para obtener el current locale
    private FacesContext context;
    private Locale myLocale;

    //Binding de los componentes graficos
    private TextField txFullname = new TextField();
    private TextField txUsename = new TextField();
    private CharacterConverter characterConverter1 = new CharacterConverter();

    public CharacterConverter getCharacterConverter1() {
        return characterConverter1;
    }

    public void setCharacterConverter1(CharacterConverter cc) {
        this.characterConverter1 = cc;
    }
    private CharacterConverter characterConverter2 = new CharacterConverter();

    public CharacterConverter getCharacterConverter2() {
        return characterConverter2;
    }

    public void setCharacterConverter2(CharacterConverter cc) {
        this.characterConverter2 = cc;
    }

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EditUser() {
    }

    /**
     * <p>Callback method that is called whenever a page is navigated to,
     * either directly via a URL, or indirectly via page navigation.
     * Customize this method to acquire resources that will be needed
     * for event handlers and lifecycle methods, whether or not this
     * page is performing post back processing.</p>
     * 
     * <p>Note that, if the current request is a postback, the property
     * values of the components do <strong>not</strong> represent any
     * values submitted with this request.  Instead, they represent the
     * property values that were saved for this view when it was rendered.</p>
     */
    @Override
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
            log("EditUser Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    @Override
    public void preprocess() {
    }

    /**
     * <p>Callback method that is called just before rendering takes place.
     * This method will <strong>only</strong> be called for the page that
     * will actually be rendered (and not, for example, on a page that
     * handled a postback and then navigated to a different page).  Customize
     * this method to allocate resources that will be required for rendering
     * this page.</p>
     */
    @Override
    public void prerender() {
        SystemUserSessionBean usb = this.getUserSessionBean();
        //Cargar datos de los add remove
        loadAddRemoveData();

        if(this.getUserSessionBean().isFirstTime()){
            //Cargar datos de los campos de texto
            this.txFullname.setText(usb.getCurrentUser().getFullname());
            this.txUsename.setText(usb.getCurrentUser().getUsername());
            //Cargar datos seleccionados de los add remove
            loadAddRemoveSelectedData();
            this.getUserSessionBean().setFirstTime(false);
        }
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
     */
    @Override
    public void destroy() {
    }

    protected SystemUserSessionBean getUserSessionBean() {
        return (SystemUserSessionBean) getBean("security$SystemUserSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AraSessionBean getAraSessionBean() {
        return (AraSessionBean) getBean("AraSessionBean");
    }

    /**
     * Metodo encargado de cargar los datos de los distintos add remove de la
     * ventana de editar usuario, carga las opciones dispinibles disponibles
     */
    private void loadAddRemoveData(){
        SystemUserSessionBean usb = this.getUserSessionBean();
        
        //Cargar datos del add remove de taxones (Disponibles)
        if (usb.getArTaxonsEdit().getAvailableOptions() == null ||
                usb.getArTaxonsEdit().getAvailableOptions().length == 0) {

            List<TaxonDTO> taxonList = usb.getTaxonsData();
            List<Option> list = new ArrayList<Option>();
            for (TaxonDTO myDTO : taxonList) {
                list.add(new Option(myDTO.getTaxonKey(), myDTO.getCurrentName()));
            }
            usb.getArTaxonsEdit().setAvailableOptions(list.toArray(new Option[list.size()]));
        }

        //Cargar los datos del add remove de grupos nomenclaturales (Disponibles)
        if (usb.getArNomenclaturalsEdit().getAvailableOptions() == null ||
                usb.getArNomenclaturalsEdit().getAvailableOptions().length == 0) {

            List<NomenclaturalGroupDTO> nomenclaturalList = usb.getAllNomenclaturalGroup();
            List<Option> list = new ArrayList<Option>();
            for (NomenclaturalGroupDTO myDTO : nomenclaturalList) {
                list.add(new Option(myDTO.getNomenclaturalGroupId(), myDTO.getName()));
            }
            usb.getArNomenclaturalsEdit().setAvailableOptions(list.toArray
                    (new Option[list.size()]));
        }

        //Setea los labels del componente add remove
        usb.getArTaxonsEdit().setLbTitle(BundleHelper.getDefaultBundleValue
                ("taxons", this.getMyLocale()));
        usb.getArTaxonsEdit().setLbAvailable(BundleHelper.getDefaultBundleValue
                ("available", this.getMyLocale()));
        usb.getArTaxonsEdit().setLbSelected(BundleHelper.getDefaultBundleValue
                ("selected", this.getMyLocale()));

        usb.getArNomenclaturalsEdit().setLbTitle(BundleHelper.getDefaultBundleValue
                ("nomenclatural_groups", this.getMyLocale()));
        usb.getArNomenclaturalsEdit().setLbAvailable(BundleHelper.getDefaultBundleValue
                ("available", this.getMyLocale()));
        usb.getArNomenclaturalsEdit().setLbSelected(BundleHelper.getDefaultBundleValue
                ("selected", this.getMyLocale()));
    }

    /**
     * Metodo encargado de cargar los datos de los distintos add remove de la
     * ventana de editar usuario, carga los seleccionados segun el
     * currenUserDTO para edicion
     */
    private void loadAddRemoveSelectedData(){
        SystemUserSessionBean usb = this.getUserSessionBean();
        Long user = usb.getCurrentUser().getUserId();

        //Cargar datos del add remove de taxones (Seleccionados)
        List<TaxonDTO> taxonList = usb.getTaxonListByUser(user);
        List<Long> list = new ArrayList<Long>();
        for (TaxonDTO myDTO : taxonList) {
            list.add(myDTO.getTaxonKey());
        }
        usb.getArTaxonsEdit().setSelectedOptions(list.toArray(new Long[list.size()]));

        //Cargar los datos del add remove de grupos nomenclaturales (Seleccionados)
        List<NomenclaturalGroupDTO> nomenclaturalList =
                usb.getNomenclaturalGroupListByUser(user);
        List<Long> listN = new ArrayList<Long>();
        for (NomenclaturalGroupDTO myDTO : nomenclaturalList) {
            listN.add(myDTO.getNomenclaturalGroupId());
        }
        usb.getArNomenclaturalsEdit().setSelectedOptions
                (listN.toArray(new Long[listN.size()]));

    }

    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
		return this.getAraSessionBean().getCurrentLocale();
    }

    /**
     * @return the txFullname
     */
    public TextField getTxFullname() {
        return txFullname;
    }

    /**
     * @param txFullname the txFullname to set
     */
    public void setTxFullname(TextField txFullname) {
        this.txFullname = txFullname;
    }

    /**
     * @return the txUsename
     */
    public TextField getTxUsename() {
        return txUsename;
    }

    /**
     * @param txUsename the txUsename to set
     */
    public void setTxUsename(TextField txUsename) {
        this.txUsename = txUsename;
    }

    /**
     * Metodo ejecutado por el boton de editar usuario
     * @return
     */
    public String btnSaveUser_action() {

        SystemUserSessionBean usb = this.getUserSessionBean();

        //Obtener nuevos valores
        String fullName=null,userName=null;
        fullName = (String)this.getTxFullname().getText();
        userName = (String)this.getTxUsename().getText();

        //Setear el DTO con los nuevos valores
        usb.getCurrentUser().setFullname(fullName);
        usb.getCurrentUser().setUsername(userName);

        try{
            //Persistir el DTO
            usb.updateSystemUser();
            //Obtener las listas de taxones y grupos
            Long[] taxonList = usb.getArTaxonsEdit().getSelectedOptions();
            Long[] nomenclaturalList = usb.getArNomenclaturalsEdit().
                    getSelectedOptions();

            //Borrar de la bd dichas listas
            usb.deleteNomenclaturalGroupsByUser(usb.getCurrentUser().getUserId());
            usb.deleteUserTaxonsByUser(usb.getCurrentUser().getUserId());

            //Actualizar en la bd dichas listas
            Long user = usb.getCurrentUser().getUserId();
            Long secuence = new Long(1);

            int arrayLength = 0;

            if(taxonList != null){
                arrayLength = taxonList.length;
                for(int i = 0; i < arrayLength; i++){
                    usb.saveUserTaxon(taxonList[i],user, secuence);
                    secuence++;
                }
            }

            if(nomenclaturalList != null){
                arrayLength = nomenclaturalList.length;
                for(int i = 0; i < arrayLength; i++){
                    usb.saveUserNomenclaturalGroup
                            (nomenclaturalList[i],user, secuence);
                    secuence++;
                }
            }
        }
        catch(Exception e){
            MessageBean.setErrorMessageFromBundle("error", this.getMyLocale());
            return null;
        }

        //Refrescar el data provider del paginador
        this.getUserSessionBean().getPagination().refreshList();

        //Notificar al usuario
        MessageBean.setSuccessMessageFromBundle("updated_succes",
                this.getMyLocale());

        return null;
    }
    
}

