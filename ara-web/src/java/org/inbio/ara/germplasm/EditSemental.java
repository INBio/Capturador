/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.germplasm;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.faces.FacesException;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.admin.SelectionListSessionBean;
import org.inbio.ara.admin.PersonSessionBean;
import org.inbio.ara.dto.germplasm.BreedDTO;
import org.inbio.ara.dto.germplasm.SementalDTO;
import org.inbio.ara.dto.gis.SiteDTO;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.inventory.GatheringSessionBean;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version EditSemental.java
 * @version Created on 08/04/2010, 09:48:39 AM
 * @author dasolano
 */

public class EditSemental extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>

    private Calendar birthDate = new Calendar();


    private SingleSelectOptionsList breeds = new SingleSelectOptionsList();
    private SingleSelectOptionsList localities = new SingleSelectOptionsList();
    private SingleSelectOptionsList condition = new SingleSelectOptionsList();
    
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EditSemental() {
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
            log("EditSemental Initialization Failure", e);
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

        breeds.setOptions(SetBreedDropDownData());
        localities.setOptions(SetSitesDropDownData());
        condition.setOptions(getSelectionListDropDownData(SelectionListEntity.CONDITION.getId()));

        if(getgermplasm$SementalSessionBean().isFirstTime())
        {
            birthDate.setSelectedDate(getgermplasm$SementalSessionBean().
                    getSementalDTO().getBirthDate().getTime());
            getgermplasm$SementalSessionBean().setFirstTime(false);
        }
    }

    /**
     * Performed the update action.
     * @return
     */
    public String updateSemental()
    {
        try
        {
            SementalDTO sementalDTO = getgermplasm$SementalSessionBean().getSementalDTO();
            sementalDTO.setUserName(getAraSessionBean().getGlobalUserName());

            //birth date
            GregorianCalendar birth = new GregorianCalendar();

            Date birthDateD = this.getBirthDate().getSelectedDate();


            if (birthDateD != null)
            {
                birth.setTime(birthDateD);
                sementalDTO.setBirthDate(birth);
            }

            getgermplasm$SementalSessionBean().getGermplasmFacadeRemote().updateSemental(sementalDTO);
            getgermplasm$SementalSessionBean().getPagination().refreshList();
            MessageBean.setSuccessMessageFromBundle("update_semental_success", this.getMyLocale());

        }
        catch (Exception e)
        {
            MessageBean.setErrorMessageFromBundle("error", this.getMyLocale());
        }
        return null;
    }

    /**
     * Put the sementalId in the SemenGatheringSessionBean  and
     * redirect to the semen gathering.
     * @return
     */
    public String goSemenGathering()
    {
        getgermplasm$SemenGatheringSessionBean().resetValues();
        getgermplasm$SemenGatheringSessionBean().setSementalId(
                getgermplasm$SementalSessionBean().getSementalDTO().getSementalId());

        return "semen_gathering";
    }
    
    /**
     * Obtener los datos del drop down de sitios
     */
    public Option[] SetSitesDropDownData(){
        List<SiteDTO> instDTOList = this.getinventory$GatheringSessionBean().SetSitesDropDownData();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(SiteDTO sDTO : instDTOList){
            option = new Option(sDTO.getSiteId(), sDTO.getDescription().trim());
            allOptions.add(option);
        }
        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

    /**
     * Metodo para obtener los datos a mostrar en los drop downs de la
     * ventana de generacion que pertenecen a listas de seleccion
     * @param selectionListEntityId que es el id del enum de listas de seleccion
     * @return
     */
    public Option[] getSelectionListDropDownData(Long selectionListEntityId) {

        //getAllSelectionListElementsByCollection
        List<SelectionListDTO> DTOList = this.getgermplasm$AccessionSessionBean().
                getInventoryFacadeRemote().
                getAllSelectionListElementsByCollection(selectionListEntityId, getAraSessionBean().getGlobalCollectionId());
        /*List<SelectionListDTO> DTOList = this.getPassportSessionBean().
        getGermplasmFacadeRemote().getElementsForSelectionList(selectionListEntityId);*/

        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null, " -- " + BundleHelper.getDefaultBundleValue("drop_down_default", getMyLocale()) + " --");
        allOptions.add(option);

        //Crear todas las opciones del drop down
        for (SelectionListDTO slDTO : DTOList) {
            option = new Option(slDTO.getValueId(), slDTO.getValueName());
            allOptions.add(option);
        }
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SementalSessionBean getgermplasm$SementalSessionBean() {
        return (SementalSessionBean) getBean("germplasm$SementalSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SemenGatheringSessionBean getgermplasm$SemenGatheringSessionBean() {
        return (SemenGatheringSessionBean) getBean("germplasm$SemenGatheringSessionBean");
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
    protected AccessionSessionBean getgermplasm$AccessionSessionBean() {
        return (AccessionSessionBean) getBean("germplasm$AccessionSessionBean");
    }

    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
        return this.getAraSessionBean().getCurrentLocale();
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
     * Obtener los datos del drop down de Instituciones
     */
    public Option[] SetBreedDropDownData(){
        List<BreedDTO> instDTOList = this.getgermplasm$SementalSessionBean().getGermplasmFacadeRemote().getAllBreeds();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(BreedDTO instDTO : instDTOList){
            option = new Option(instDTO.getBreedId(), instDTO.getName().trim());
            allOptions.add(option);
        }
        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
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
    protected PersonSessionBean getadmin$PersonSessionBean() {
        return (PersonSessionBean) getBean("admin$PersonSessionBean");
    }

    /**
     * @return the birthDate
     */
    public Calendar getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return the breeds
     */
    public SingleSelectOptionsList getBreeds() {
        return breeds;
    }

    /**
     * @param breeds the breeds to set
     */
    public void setBreeds(SingleSelectOptionsList breeds) {
        this.breeds = breeds;
    }

    /**
     * @return the localities
     */
    public SingleSelectOptionsList getLocalities() {
        return localities;
    }

    /**
     * @param localities the localities to set
     */
    public void setLocalities(SingleSelectOptionsList localities) {
        this.localities = localities;
    }

    /**
     * @return the condition
     */
    public SingleSelectOptionsList getCondition() {
        return condition;
    }

    /**
     * @param condition the condition to set
     */
    public void setCondition(SingleSelectOptionsList condition) {
        this.condition = condition;
    }
    
}

