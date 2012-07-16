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


package org.inbio.ara.taxonomy;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.agent.InstitutionDTO;
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.dto.taxonomy.LanguageDTO;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionStageDTO;
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
 * @version NewSpecies.java
 * @version Created on 13/10/2009, 03:07:49 PM
 * @author esmata
 */

public class NewSpecies extends AbstractPageBean {
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
    private DropDown ddScientificName = new DropDown();
    private DropDown ddLanguage = new DropDown();
    private DropDown ddStatus = new DropDown();
    private DropDown ddInstitutions = new DropDown();
    private TextField txSequence = new TextField();
    private TextField txTitle = new TextField();

    //En esta variable se setearan los datos del drop down de nombres cientificos
    private SingleSelectOptionsList scientificNameData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de idioma
    private SingleSelectOptionsList languageData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de estado
    private SingleSelectOptionsList statusData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de instituciones
    private SingleSelectOptionsList institutionsData = new SingleSelectOptionsList();

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public NewSpecies() {
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
            log("NewSpecies Initialization Failure", e);
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
        this.scientificNameData.setOptions(getScientificNamesDropDownData());
        this.languageData.setOptions(getLanguagesDropDownData());
        this.statusData.setOptions(getTaxonDescriptionStatusDropDownData());
        this.institutionsData.setOptions(getInstitutionDropDownData());
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
     * Obtener los datos del drop down de nombres cientificos
     */
    public Option[] getScientificNamesDropDownData(){
        List<TaxonDTO> DTOList = this.gettaxonomy$SpeciesSessionBean().
                getAllSpecies();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue
                ("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(TaxonDTO myDTO : DTOList){
            option = new Option(myDTO.getTaxonKey(), myDTO.getDefaultName().trim());
            allOptions.add(option);
        }
        //return the elements
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

   /**
     * Obtener los datos del drop down de idiomas
     */
    public Option[] getLanguagesDropDownData(){
        List<LanguageDTO> DTOList = this.gettaxonomy$SpeciesSessionBean().
                getAllLanguages();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue
                ("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(LanguageDTO myDTO : DTOList){
            option = new Option(myDTO.getLanguageId(), myDTO.getConcepName().trim());
            allOptions.add(option);
        }
        //return the elements
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }
    
   /**
     * Obtener los datos del drop down de estados
     */
    public Option[] getTaxonDescriptionStatusDropDownData(){
        List<TaxonDescriptionStageDTO> DTOList = this.gettaxonomy$SpeciesSessionBean().
                getAllTaxonDescriptionStages();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue
                ("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(TaxonDescriptionStageDTO myDTO : DTOList){
            option = new Option(myDTO.getTaxonDescriptionStageId(), 
                    myDTO.getName().trim());
            allOptions.add(option);
        }
        //return the elements
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

   /**
     * Obtener los datos del drop down de instituciones
     */
    public Option[] getInstitutionDropDownData(){
        List<InstitutionDTO> instDTOList = this.gettaxonomy$SpeciesSessionBean()
                .SetInstitutionDropDownData();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue
                ("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(InstitutionDTO instDTO : instDTOList){
            option = new Option(instDTO.getInstitutionId(), instDTO.getInstitutionName());
            allOptions.add(option);
        }
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

    /**
     * Metodo ejecutado por el boton para crear un nuevo taxon description
     * @return
     */
    public String btnNewTaxonDescription_action() {
        SpeciesSessionBean ssb = this.gettaxonomy$SpeciesSessionBean();

        //Capturar datos de la pantalla
        String title = (String)this.getTxTitle().getText();
        Long sequence = null;
        String sequenceAux = (String)this.getTxSequence().getText();
        if(sequenceAux!=null){
            sequence = Long.parseLong(sequenceAux);
        }

        //Setear el current DTO
        ssb.getCurrentTaxDescripDTO().setTaxonId(ssb.getSelectedScientificName());
        ssb.getCurrentTaxDescripDTO().setTaxonDescriptionSequence
                (sequence);
        ssb.getCurrentTaxDescripDTO().setTitle(title);
        ssb.getCurrentTaxDescripDTO().setLanguageId
                (ssb.getSelectedLanguage());
        ssb.getCurrentTaxDescripDTO().setTaxonDescriptionStageId
                (ssb.getSelectedStatus());
        ssb.getCurrentTaxDescripDTO().setInstitutionId
                (ssb.getSelectedInstitution());

        String scientificName = ssb.getTaxonomyFacadeImpl().
                getSpeciesNameById(ssb.getSelectedScientificName());
        ssb.getCurrentTaxDescripDTO().setTaxonDefaultName(scientificName);

        //Asegurarnos de que el registro no exista previamente en la BD
        boolean existDescription = this.exist();
        if(existDescription){
            MessageBean.setErrorMessageFromBundle("alredy_exist", this.getMyLocale());
            return null;
        }

        //Persistir el nuevo registro de especie
        try {
            ssb.saveTaxonDescription();
        } catch (Exception e) {
            MessageBean.setErrorMessageFromBundle("error", this.getMyLocale());
            return null;
        }

        //Limpiar la pantalla
        this.getTxSequence().setText(null);
        this.getTxTitle().setText(null);
        ssb.setSelectedLanguage(null);
        ssb.setSelectedScientificName(null);
        ssb.setSelectedStatus(null);
        ssb.setArAudiences(new AddRemoveList());
        ssb.setArAuthors(new AddRemoveList());
        ssb.setArInstitutions(new AddRemoveList());

        //Refrescar el paginador
        ssb.getPagination().refreshList();

        /*//Notificar al usuario
        MessageBean.setSuccessMessageFromBundle
        ("create_species_record_succces", this.getMyLocale());*/

        /*Indicar a la pantalla de edit que cargue 1 sola ves los datos
        seleccionados de los AddRemove*/
        this.gettaxonomy$SpeciesSessionBean().setFirstTime(true);

        return "edit";
    }

    /**
     * True si existe el registro, False en caso contrario
     * @return
     */
    private boolean exist(){
        SpeciesSessionBean ssb = this.gettaxonomy$SpeciesSessionBean();
        Long taxonId = ssb.getCurrentTaxDescripDTO().getTaxonId();
        Long sequenceId = ssb.getCurrentTaxDescripDTO().getTaxonDescriptionSequence();
        return ssb.getTaxonomyFacadeImpl().existTaxonDescription
                (taxonId, sequenceId);
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SpeciesSessionBean gettaxonomy$SpeciesSessionBean() {
        return (SpeciesSessionBean) getBean("taxonomy$SpeciesSessionBean");
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
     * @return the scientificNameData
     */
    public SingleSelectOptionsList getScientificNameData() {
        return scientificNameData;
    }

    /**
     * @param scientificNameData the scientificNameData to set
     */
    public void setScientificNameData(SingleSelectOptionsList scientificNameData) {
        this.scientificNameData = scientificNameData;
    }

    /**
     * @return the languageData
     */
    public SingleSelectOptionsList getLanguageData() {
        return languageData;
    }

    /**
     * @param languageData the languageData to set
     */
    public void setLanguageData(SingleSelectOptionsList languageData) {
        this.languageData = languageData;
    }

    /**
     * @return the statusData
     */
    public SingleSelectOptionsList getStatusData() {
        return statusData;
    }

    /**
     * @param statusData the statusData to set
     */
    public void setStatusData(SingleSelectOptionsList statusData) {
        this.statusData = statusData;
    }

    /**
     * @return the ddScientificName
     */
    public DropDown getDdScientificName() {
        return ddScientificName;
    }

    /**
     * @param ddScientificName the ddScientificName to set
     */
    public void setDdScientificName(DropDown ddScientificName) {
        this.ddScientificName = ddScientificName;
    }

    /**
     * @return the ddLanguage
     */
    public DropDown getDdLanguage() {
        return ddLanguage;
    }

    /**
     * @param ddLanguage the ddLanguage to set
     */
    public void setDdLanguage(DropDown ddLanguage) {
        this.ddLanguage = ddLanguage;
    }

    /**
     * @return the ddStatus
     */
    public DropDown getDdStatus() {
        return ddStatus;
    }

    /**
     * @param ddStatus the ddStatus to set
     */
    public void setDdStatus(DropDown ddStatus) {
        this.ddStatus = ddStatus;
    }

    /**
     * @return the txSequence
     */
    public TextField getTxSequence() {
        return txSequence;
    }

    /**
     * @param txSequence the txSequence to set
     */
    public void setTxSequence(TextField txSequence) {
        this.txSequence = txSequence;
    }

    /**
     * @return the txTitle
     */
    public TextField getTxTitle() {
        return txTitle;
    }

    /**
     * @param txTitle the txTitle to set
     */
    public void setTxTitle(TextField txTitle) {
        this.txTitle = txTitle;
    }

    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
		return this.getAraSessionBean().getCurrentLocale();
    }

    /**
     * @return the ddInstitutions
     */
    public DropDown getDdInstitutions() {
        return ddInstitutions;
    }

    /**
     * @param ddInstitutions the ddInstitutions to set
     */
    public void setDdInstitutions(DropDown ddInstitutions) {
        this.ddInstitutions = ddInstitutions;
    }

    /**
     * @return the institutionsData
     */
    public SingleSelectOptionsList getInstitutionsData() {
        return institutionsData;
    }

    /**
     * @param institutionsData the institutionsData to set
     */
    public void setInstitutionsData(SingleSelectOptionsList institutionsData) {
        this.institutionsData = institutionsData;
    }
    
}

