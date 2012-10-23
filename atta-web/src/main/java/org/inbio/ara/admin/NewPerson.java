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

package org.inbio.ara.admin;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.TextArea;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.agent.InstitutionDTO;
import org.inbio.ara.dto.agent.ProfileDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.util.AddRemoveList;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version NewPerson.java
 * @version Created on 07/10/2009, 03:05:03 PM
 * @author esmata
 */

public class NewPerson extends AbstractPageBean {
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

    //Bindings de los componentes graficos
    private TextField txName = new TextField();
    private TextField tx1lastName = new TextField();
    private TextField tx2lastName = new TextField();
    private TextField txInitials = new TextField();
    private TextField txBirthDate = new TextField();
    private TextField txDeathDate = new TextField();
    private TextField txOcupation = new TextField();

    private TextField txEmail = new TextField();
    private TextField txWebSite = new TextField();
    private TextField txPhoneNumber = new TextField();
    private TextField txFax = new TextField();
    private TextField txCity = new TextField();
    private TextField txProvience = new TextField();
    private TextField txCountry = new TextField();
    private TextArea txaAddress = new TextArea();

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public NewPerson() {
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
            log("NewPerson Initialization Failure", e);
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
        //Cargar los valores de los AddRemove
        this.loadAddRemoveData();
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

    /**
     * Metodo ejecutado por el boton de crear nueva persona
     * @return
     */
    public String btnSavePerson_action() {

        //Capturar datos de la pantalla
        Long deathDate = null,birthDate = null;
        String deathAux = (String)this.getTxDeathDate().getText();
        if(deathAux!=null){
            deathDate = Long.parseLong(deathAux);
        }
        String birthAux = (String)this.getTxBirthDate().getText();
        if(birthAux!=null){
            birthDate = Long.parseLong(birthAux);
        }
        String name=null,lastName1=null,lastName2=null,initials=null,
                ocupation=null;
        name = (String)this.getTxName().getText();
        lastName1 = (String)this.getTx1lastName().getText();
        lastName2 = (String)this.getTx2lastName().getText();
        initials = (String)this.getTxInitials().getText();
        ocupation = (String)this.getTxOcupation().getText();
        String email=null,webSite=null,phone=null,fax=null,city=null,
                province=null,country=null,address=null;
        email = (String)this.getTxEmail().getText();
        webSite = (String)this.getTxWebSite().getText();
        phone = (String)this.getTxPhoneNumber().getText();
        fax = (String)this.getTxFax().getText();
        city = (String)this.getTxCity().getText();
        province = (String)this.getTxProvience().getText();
        country = (String)this.getTxCountry().getText();
        address = (String)this.getTxaAddress().getText();

        //Crear el DTO para persistir
        PersonDTO myDTO = new PersonDTO();
        myDTO.setDeathYear(deathDate);
        myDTO.setBirthYear(birthDate);
        myDTO.setFirstName(name);
        myDTO.setLastName(lastName1);
        myDTO.setSecondLastName(lastName2);
        myDTO.setInitials(initials);
        myDTO.setOccupation(ocupation);
        myDTO.setEmail(email);
        myDTO.setUrl(webSite);
        myDTO.setTelephone(phone);
        myDTO.setFax(fax);
        myDTO.setCity(city);
        myDTO.setStateProvince(province);
        myDTO.setCountry(country);
        myDTO.setStreetAddress(address);

        //Persistir el DTO
        try{
            //Mandar a persistir
            this.getPersonSessionBean().setCurrentPerson(myDTO);
            PersonDTO aux = this.getPersonSessionBean().savePerson();
            //Setear el currentDTO con el DTO recien persistido
            this.getPersonSessionBean().getCurrentPerson().setPersonKey
                    (aux.getPersonKey());
            //Persistir las listas asociadas
            this.getPersonSessionBean().savePersonInstitutionsAndProfiles();
        }
        catch(Exception e){
            MessageBean.setErrorMessageFromBundle("error", this.getMyLocale());
            return null;
        }

        //Refrescar la lista de perosnas
        PersonSessionBean psb = this.getPersonSessionBean();
        psb.getPagination().refreshList();

        //Limpiar los datos de la pantalla
        this.getPersonSessionBean().setArInstitutionesNew(new AddRemoveList());
        this.getPersonSessionBean().setArProfilesNew(new AddRemoveList());
        this.getTx1lastName().setText(null);
        this.getTx2lastName().setText(null);
        this.getTxBirthDate().setText(null);
        this.getTxCity().setText(null);
        this.getTxCountry().setText(null);
        this.getTxDeathDate().setText(null);
        this.getTxEmail().setText(null);
        this.getTxFax().setText(null);
        this.getTxInitials().setText(null);
        this.getTxName().setText(null);
        this.getTxOcupation().setText(null);
        this.getTxPhoneNumber().setText(null);
        this.getTxProvience().setText(null);
        this.getTxWebSite().setText(null);
        this.getTxaAddress().setText(null);

        //Notificar al usuario
        MessageBean.setSuccessMessageFromBundle("create_project_success", this.getMyLocale());

        return null;
    }

    /**
     * Metodo encargado de cargar los datos de los distintos add remove de la
     * ventana de nueva perosna
     */
    private void loadAddRemoveData() {
        PersonSessionBean psb = this.getPersonSessionBean();
        //Cargar datos del add remove de perfiles
        if (psb.getArProfilesNew().getAvailableOptions() == null ||
                psb.getArProfilesNew().getAvailableOptions().length == 0) {

            List<ProfileDTO> profilesList = psb.getprofilesData();
            List<Option> list = new ArrayList<Option>();

            for (ProfileDTO dto : profilesList) {
                list.add(new Option(dto.getProfileId(), dto.getName()));
            }
            psb.getArProfilesNew().setAvailableOptions(list.toArray(new Option[list.size()]));
        }
        //Cargar los datos del add remove de instituciones
        if (psb.getArInstitutionesNew().getAvailableOptions() == null ||
                psb.getArInstitutionesNew().getAvailableOptions().length == 0) {

            List<InstitutionDTO> institutionsList = psb.getinstitutionsData();
            List<Option> list = new ArrayList<Option>();

            for (InstitutionDTO ins : institutionsList) {
                list.add(new Option(ins.getInstitutionId(), ins.getInstitutionName()));
            }
            psb.getArInstitutionesNew().setAvailableOptions(list.toArray(new Option[list.size()]));
        }
        //Setea los labels del componente add remove
        psb.getArProfilesNew().setLbTitle(BundleHelper.getDefaultBundleValue
                ("menuModuleProfiles", this.getMyLocale()));
        psb.getArProfilesNew().setLbAvailable(BundleHelper.getDefaultBundleValue
                ("available", this.getMyLocale()));
        psb.getArProfilesNew().setLbSelected(BundleHelper.getDefaultBundleValue
                ("selected", this.getMyLocale()));

        psb.getArInstitutionesNew().setLbTitle(BundleHelper.getDefaultBundleValue
                ("menuModuleInstitutions", this.getMyLocale()));
        psb.getArInstitutionesNew().setLbAvailable(BundleHelper.getDefaultBundleValue
                ("available", this.getMyLocale()));
        psb.getArInstitutionesNew().setLbSelected(BundleHelper.getDefaultBundleValue
                ("selected", this.getMyLocale()));
    }
    
    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected PersonSessionBean getPersonSessionBean() {
        return (PersonSessionBean) getBean("admin$PersonSessionBean");
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
     * @return the txName
     */
    public TextField getTxName() {
        return txName;
    }

    /**
     * @param txName the txName to set
     */
    public void setTxName(TextField txName) {
        this.txName = txName;
    }

    /**
     * @return the tx1lastName
     */
    public TextField getTx1lastName() {
        return tx1lastName;
    }

    /**
     * @param tx1lastName the tx1lastName to set
     */
    public void setTx1lastName(TextField tx1lastName) {
        this.tx1lastName = tx1lastName;
    }

    /**
     * @return the tx2lastName
     */
    public TextField getTx2lastName() {
        return tx2lastName;
    }

    /**
     * @param tx2lastName the tx2lastName to set
     */
    public void setTx2lastName(TextField tx2lastName) {
        this.tx2lastName = tx2lastName;
    }

    /**
     * @return the txInitials
     */
    public TextField getTxInitials() {
        return txInitials;
    }

    /**
     * @param txInitials the txInitials to set
     */
    public void setTxInitials(TextField txInitials) {
        this.txInitials = txInitials;
    }

    /**
     * @return the txBirthDate
     */
    public TextField getTxBirthDate() {
        return txBirthDate;
    }

    /**
     * @param txBirthDate the txBirthDate to set
     */
    public void setTxBirthDate(TextField txBirthDate) {
        this.txBirthDate = txBirthDate;
    }

    /**
     * @return the txDeathDate
     */
    public TextField getTxDeathDate() {
        return txDeathDate;
    }

    /**
     * @param txDeathDate the txDeathDate to set
     */
    public void setTxDeathDate(TextField txDeathDate) {
        this.txDeathDate = txDeathDate;
    }

    /**
     * @return the txOcupation
     */
    public TextField getTxOcupation() {
        return txOcupation;
    }

    /**
     * @param txOcupation the txOcupation to set
     */
    public void setTxOcupation(TextField txOcupation) {
        this.txOcupation = txOcupation;
    }

    /**
     * @return the txEmail
     */
    public TextField getTxEmail() {
        return txEmail;
    }

    /**
     * @param txEmail the txEmail to set
     */
    public void setTxEmail(TextField txEmail) {
        this.txEmail = txEmail;
    }

    /**
     * @return the txWebSite
     */
    public TextField getTxWebSite() {
        return txWebSite;
    }

    /**
     * @param txWebSite the txWebSite to set
     */
    public void setTxWebSite(TextField txWebSite) {
        this.txWebSite = txWebSite;
    }

    /**
     * @return the txPhoneNumber
     */
    public TextField getTxPhoneNumber() {
        return txPhoneNumber;
    }

    /**
     * @param txPhoneNumber the txPhoneNumber to set
     */
    public void setTxPhoneNumber(TextField txPhoneNumber) {
        this.txPhoneNumber = txPhoneNumber;
    }

    /**
     * @return the txFax
     */
    public TextField getTxFax() {
        return txFax;
    }

    /**
     * @param txFax the txFax to set
     */
    public void setTxFax(TextField txFax) {
        this.txFax = txFax;
    }

    /**
     * @return the txCity
     */
    public TextField getTxCity() {
        return txCity;
    }

    /**
     * @param txCity the txCity to set
     */
    public void setTxCity(TextField txCity) {
        this.txCity = txCity;
    }

    /**
     * @return the txProvience
     */
    public TextField getTxProvience() {
        return txProvience;
    }

    /**
     * @param txProvience the txProvience to set
     */
    public void setTxProvience(TextField txProvience) {
        this.txProvience = txProvience;
    }

    /**
     * @return the txCountry
     */
    public TextField getTxCountry() {
        return txCountry;
    }

    /**
     * @param txCountry the txCountry to set
     */
    public void setTxCountry(TextField txCountry) {
        this.txCountry = txCountry;
    }

    /**
     * @return the txaAddress
     */
    public TextArea getTxaAddress() {
        return txaAddress;
    }

    /**
     * @param txaAddress the txaAddress to set
     */
    public void setTxaAddress(TextArea txaAddress) {
        this.txaAddress = txaAddress;
    }

    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
		return this.getAraSessionBean().getCurrentLocale();
    }    
}

