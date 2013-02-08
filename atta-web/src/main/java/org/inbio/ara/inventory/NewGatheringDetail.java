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

package org.inbio.ara.inventory;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.TextArea;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.util.ValidatorBean;
import org.inbio.ara.SessionManager;
import org.inbio.ara.dto.inventory.GatheringObservationDetailDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version NewGatheringDetail.java
 * @version Created on 07/09/2009, 09:44:07 AM
 * @author esmata
 */

public class NewGatheringDetail extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>

    //Binding de los componenetes graficos
    private com.sun.webui.jsf.component.Calendar descDate = new com.sun.webui.jsf.component.Calendar();
    private TextField txGathNumber = new TextField();
    private TextArea txaMorphoDesc = new TextArea();

    //En esta variable se setearan los datos del drop down de colectores
    private SingleSelectOptionsList collectorsData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de descriptores
    private SingleSelectOptionsList descriptorsData = new SingleSelectOptionsList();

	//Contexto utilizado para obtener el current locale
	private FacesContext context;
	private Locale myLocale;

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public NewGatheringDetail() {
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
            log("NewGatheringDetail Initialization Failure", e);
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
        /* Obtener los datos de los diferentes drop downs */
        this.getCollectorsData().setOptions(SetColectorsDropDownData());
        this.getDescriptorsData().setOptions(SetDescriptosDropDownData());
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
     * Obtener los datos del drop down de colectores responsables
     */
    public Option[] SetColectorsDropDownData(){
        List<PersonDTO> instDTOList = this.getinventory$GatheringDetailSessionBean().getCollectors();
        System.out.println("NEW GATHERING DETAIL ");
        System.out.println("colectores = "+instDTOList.size());
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(PersonDTO perDTO : instDTOList){
            option = new Option(perDTO.getPersonKey(), perDTO.getNaturalLongName().trim());
            allOptions.add(option);
        }
        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

    /**
     * Obtener los datos del drop down de colectores responsables
     */
    public Option[] SetDescriptosDropDownData(){
        List<PersonDTO> instDTOList = this.getinventory$GatheringDetailSessionBean().getDescriptors();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(PersonDTO perDTO : instDTOList){
            option = new Option(perDTO.getPersonKey(), perDTO.getNaturalLongName().trim());
            allOptions.add(option);
        }
        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
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
    protected AraSessionBean getAraSessionBean() {
        return (AraSessionBean) getBean("AraSessionBean");
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
    protected SessionManager getSessionManager() {
        return (SessionManager) getBean("SessionManager");
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
    protected SpecimenSessionBean getinventory$SpecimenSessionBean() {
        return (SpecimenSessionBean) getBean("inventory$SpecimenSessionBean");
    }

    /**
     * @return the collectorsData
     */
    public SingleSelectOptionsList getCollectorsData() {
        return collectorsData;
    }

    /**
     * @param collectorsData the collectorsData to set
     */
    public void setCollectorsData(SingleSelectOptionsList collectorsData) {
        this.collectorsData = collectorsData;
    }

    /**
     * @return the descriptorsData
     */
    public SingleSelectOptionsList getDescriptorsData() {
        return descriptorsData;
    }

    /**
     * @param descriptorsData the descriptorsData to set
     */
    public void setDescriptorsData(SingleSelectOptionsList descriptorsData) {
        this.descriptorsData = descriptorsData;
    }

    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
		return this.getAraSessionBean().getCurrentLocale();
    }

    /**
     * @param myLocale the myLocale to set
     */
    public void setMyLocale(Locale myLocale) {
        this.myLocale = myLocale;
    }

    /**
     * Metodo ejecutado por el boton de salvar el nuevo detalle de recoleccion
     * @return
     */
    public String btnSaveDetail_action() {
        GatheringDetailSessionBean gdsb = this.getinventory$GatheringDetailSessionBean();

        //Cargar el dto a persistir
        String gatheringNumber = (String)this.getTxGathNumber().getText();
        Long collector = gdsb.getSelectedCollector();
        Long descriptor = gdsb.getSelectedDescriptor();
        GregorianCalendar descriptionDate = new GregorianCalendar();
        Date myDate = this.getDescDate().getSelectedDate();
        if (myDate != null) {
            descriptionDate.setTime(myDate);
            gdsb.getCurrentDetail().setDescriptionDate(descriptionDate);
        }
        String morphoDescription = (String)this.getTxaMorphoDesc().getText();
        gdsb.getCurrentDetail().setGatheringObservationDetailNumber(gatheringNumber);
        gdsb.getCurrentDetail().setGatheringObservationDetailPersonId(collector);
        gdsb.getCurrentDetail().setDescriptorId(descriptor);        
        gdsb.getCurrentDetail().setMorphologicalContents(morphoDescription);
        gdsb.getCurrentDetail().setGatheringObservationId(gdsb.getCurrentGathering().getGatheringObservationId());

        Long currentCollection = this.getAraSessionBean().getGlobalCollectionId();
        gdsb.getCurrentDetail().setCollectionId(currentCollection);

        //Limpiar la pantalla de new detail
        gdsb.setSelectedCollector(null);
        gdsb.setSelectedDescriptor(null);
        this.getTxGathNumber().setText(null);
        this.getTxaMorphoDesc().setText(null);

        try{
            //Persistir las entidades, primero morpho description y luego el detalle
            GatheringObservationDetailDTO nuevo = gdsb.getInventoryFacade().
                    saveGatheringDetail(gdsb.getCurrentDetail());
            gdsb.setCurrentDetail(nuevo);
        }
        catch(Exception e){
            MessageBean.setErrorMessageFromBundle("error", this.getMyLocale());
            return null;
        }

        //Refrescar la lista de detalles de recolecion
        this.getinventory$GatheringDetailSessionBean().getPagination().addItem();
        this.getinventory$GatheringDetailSessionBean().getPagination().refreshList();
        
        return "edit";
    }

    /**
     * @return the descDate
     */
    public com.sun.webui.jsf.component.Calendar getDescDate() {
        return descDate;
    }

    /**
     * @param descDate the descDate to set
     */
    public void setDescDate(com.sun.webui.jsf.component.Calendar descDate) {
        this.descDate = descDate;
    }

    /**
     * @return the txGathNumber
     */
    public TextField getTxGathNumber() {
        return txGathNumber;
    }

    /**
     * @param txGathNumber the txGathNumber to set
     */
    public void setTxGathNumber(TextField txGathNumber) {
        this.txGathNumber = txGathNumber;
    }

    /**
     * @return the txaMorphoDesc
     */
    public TextArea getTxaMorphoDesc() {
        return txaMorphoDesc;
    }

    /**
     * @param txaMorphoDesc the txaMorphoDesc to set
     */
    public void setTxaMorphoDesc(TextArea txaMorphoDesc) {
        this.txaMorphoDesc = txaMorphoDesc;
    }
    
}

