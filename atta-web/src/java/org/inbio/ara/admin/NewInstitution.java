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
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import org.inbio.ara.SessionManager;
import org.inbio.ara.util.ValidatorBean;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.agent.InstitutionDTO;
import org.inbio.ara.inventory.IdentificationSessionBean;
import org.inbio.ara.security.SystemUserSessionBean;
import org.inbio.ara.inventory.SpecimenSessionBean;
import org.inbio.ara.inventory.SpecimenGenerationSessionBean;
import org.inbio.ara.statistics.StatisticsSessionBean;
import org.inbio.ara.inventory.GatheringSessionBean;
import org.inbio.ara.inventory.GatheringDetailSessionBean;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version NewInstitution.java
 * @version Created on 28/09/2009, 10:08:43 AM
 * @author esmata
 */

public class NewInstitution extends AbstractPageBean {
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
    private TextField txName = new TextField();
    private TextField txPhone = new TextField();
    private TextField txFax = new TextField();
    private TextField txCountry = new TextField();
    private TextField txProvince = new TextField();
    private TextField txCity = new TextField();
    private TextField txAdreess = new TextField();
    private TextField txInstitutionCode = new TextField();
    private TextField txAcronym = new TextField();
    private TextArea taURL = new TextArea();

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public NewInstitution() {
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
            log("NewInstitution Initialization Failure", e);
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
     * Metodo ejecutado por el boton de crear nueva institucion
     */
    public String btnSaveInstitution_action(){

        //Tomar datos de la pantalla
        String name=null,phone=null,fax=null,country=null,province=null,city=null,
                adreess=null,institutionCode=null,acronym=null,url=null;
        name = (String)this.getTxName().getText();
        phone = (String)this.getTxPhone().getText();
        fax = (String)this.getTxFax().getText();
        country = (String)this.getTxCountry().getText();
        province = (String)this.getTxProvince().getText();
        city = (String)this.getTxCity().getText();
        adreess = (String)this.getTxAdreess().getText();
        institutionCode = (String)this.getTxInstitutionCode().getText();
        acronym = (String)this.getTxAcronym().getText();
        url = (String)this.getTaURL().getText();

        //Construir institutionDTO
        InstitutionDTO myDTO = new InstitutionDTO();
        myDTO.setInstitutionName(name);
        myDTO.setTelephone(phone);
        myDTO.setFax(fax);
        myDTO.setCountry(country);
        myDTO.setStateProvince(province);
        myDTO.setCity(city);
        myDTO.setStreetAddress(adreess);
        myDTO.setInstitutionCode(institutionCode);
        myDTO.setAcronym(acronym);
        myDTO.setUrl(url);

        //Persistir
        try{
            this.getInstitutionSessionBean().saveInstitution(myDTO);
        }
        catch(Exception e){
            MessageBean.setErrorMessageFromBundle("error", this.getMyLocale());
            return null;
        }

        //Limpiar la pantalla
        txName.setText(null);
        txPhone.setText(null);
        txFax.setText(null);
        txCountry.setText(null);
        txProvince.setText(null);
        txCity.setText(null);
        txAdreess.setText(null);
        txInstitutionCode.setText(null);
        txAcronym.setText(null);
        taURL.setText(null);

        //Refrescar el pagination
        this.getInstitutionSessionBean().getPagination().addItem();
        this.getInstitutionSessionBean().getPagination().refreshList();

        //Notificar al usuario
        MessageBean.setSuccessMessageFromBundle("create_institution_succces", this.getMyLocale());

        return null;
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
     protected InstitutionSessionBean getInstitutionSessionBean() {
        return (InstitutionSessionBean) getBean("admin$InstitutionSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionManager getSessionManager() {
        return (SessionManager) getBean("SessionManager");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ValidatorBean getutil$ValidatorBean() {
        return (ValidatorBean) getBean("util$ValidatorBean");
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
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected IdentificationSessionBean getinventory$IdentificationSessionBean() {
        return (IdentificationSessionBean) getBean("inventory$IdentificationSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SystemUserSessionBean getsecurity$SystemUserSessionBean() {
        return (SystemUserSessionBean) getBean("security$SystemUserSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SelectionListSessionBean getadmin$SelectionListSessionBean() {
        return (SelectionListSessionBean) getBean("admin$SelectionListSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SpecimenSessionBean getinventory$SpecimenSessionBean() {
        return (SpecimenSessionBean) getBean("inventory$SpecimenSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SpecimenGenerationSessionBean getinventory$SpecimenGenerationSessionBean() {
        return (SpecimenGenerationSessionBean) getBean("inventory$SpecimenGenerationSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected StatisticsSessionBean getstatistics$StatisticsSessionBean() {
        return (StatisticsSessionBean) getBean("statistics$StatisticsSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected GatheringSessionBean getinventory$GatheringSessionBean() {
        return (GatheringSessionBean) getBean("inventory$GatheringSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected GatheringDetailSessionBean getinventory$GatheringDetailSessionBean() {
        return (GatheringDetailSessionBean) getBean("inventory$GatheringDetailSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected CollectionSessionBean getadmin$CollectionSessionBean() {
        return (CollectionSessionBean) getBean("admin$CollectionSessionBean");
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
     * @return the txPhone
     */
    public TextField getTxPhone() {
        return txPhone;
    }

    /**
     * @param txPhone the txPhone to set
     */
    public void setTxPhone(TextField txPhone) {
        this.txPhone = txPhone;
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
     * @return the txProvince
     */
    public TextField getTxProvince() {
        return txProvince;
    }

    /**
     * @param txProvince the txProvince to set
     */
    public void setTxProvince(TextField txProvince) {
        this.txProvince = txProvince;
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
     * @return the txAdreess
     */
    public TextField getTxAdreess() {
        return txAdreess;
    }

    /**
     * @param txAdreess the txAdreess to set
     */
    public void setTxAdreess(TextField txAdreess) {
        this.txAdreess = txAdreess;
    }

    /**
     * @return the txInstitutionCode
     */
    public TextField getTxInstitutionCode() {
        return txInstitutionCode;
    }

    /**
     * @param txInstitutionCode the txInstitutionCode to set
     */
    public void setTxInstitutionCode(TextField txInstitutionCode) {
        this.txInstitutionCode = txInstitutionCode;
    }

    /**
     * @return the txAcronym
     */
    public TextField getTxAcronym() {
        return txAcronym;
    }

    /**
     * @param txAcronym the txAcronym to set
     */
    public void setTxAcronym(TextField txAcronym) {
        this.txAcronym = txAcronym;
    }

    /**
     * @return the taURL
     */
    public TextArea getTaURL() {
        return taURL;
    }

    /**
     * @param taURL the taURL to set
     */
    public void setTaURL(TextArea taURL) {
        this.taURL = taURL;
    }

    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
		return this.getAraSessionBean().getCurrentLocale();
    }
    
}

