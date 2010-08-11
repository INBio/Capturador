/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.germplasm;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import javax.faces.FacesException;
import org.inbio.ara.admin.SelectionListSessionBean;
import org.inbio.ara.admin.PersonSessionBean;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.MessageBean;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.germplasm.SemenGatheringDTO;
import org.inbio.ara.dto.inventory.SelectionListEntity;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version NewSemenGathering.java
 * @version Created on 08/04/2010, 09:51:47 AM
 * @author dasolano
 */

public class NewSemenGathering extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>

    private SingleSelectOptionsList semenGatheringMethod = new SingleSelectOptionsList();
    private SingleSelectOptionsList solvent = new SingleSelectOptionsList();
    private SingleSelectOptionsList hourDropDown = new SingleSelectOptionsList();
    private SingleSelectOptionsList minutesDropDown = new SingleSelectOptionsList();




    private Calendar gatheringDate = new Calendar();
    private TextField textTime = new TextField();
    
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public NewSemenGathering() {
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
            log("NewSemenGathering Initialization Failure", e);
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
        semenGatheringMethod.setOptions(getSelectionListDropDownData(SelectionListEntity.SEMEN_GATHERING_METHOD.getId()));
        solvent.setOptions(getSelectionListDropDownData(SelectionListEntity.SOLVENT.getId()));

        hourDropDown.setOptions(getHourDropDownData());
        minutesDropDown.setOptions(getMinutesDropDownData());
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
     * fill the options for the hour drop down
     * @return
     */
    public Option[] getHourDropDownData()
    {
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null, " -- ");
        allOptions.add(option);

        option = new Option(0L, "00");
        allOptions.add(option);
        option = new Option(1L, "01");
        allOptions.add(option);
        option = new Option(2L, "02");
        allOptions.add(option);
        option = new Option(3L, "03");
        allOptions.add(option);
        option = new Option(4L, "04");
        allOptions.add(option);
        option = new Option(5L, "05");
        allOptions.add(option);
        option = new Option(6L, "06");
        allOptions.add(option);
        option = new Option(7L, "07");
        allOptions.add(option);
        option = new Option(8L, "08");
        allOptions.add(option);
        option = new Option(9L, "09");
        allOptions.add(option);

        for(int i = 10; i <= 23; i ++)
        {
            option = new Option(new Long(i), Integer.toString(i));
            allOptions.add(option);
        }


        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

    /**
     * fill the options for the minutes drop down
     * @return
     */
    public Option[] getMinutesDropDownData()
    {
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null, " -- ");
        allOptions.add(option);


        option = new Option(0L, "00");
        allOptions.add(option);
        option = new Option(1L, "01");
        allOptions.add(option);
        option = new Option(2L, "02");
        allOptions.add(option);
        option = new Option(3L, "03");
        allOptions.add(option);
        option = new Option(4L, "04");
        allOptions.add(option);
        option = new Option(5L, "05");
        allOptions.add(option);
        option = new Option(6L, "06");
        allOptions.add(option);
        option = new Option(7L, "07");
        allOptions.add(option);
        option = new Option(8L, "08");
        allOptions.add(option);
        option = new Option(9L, "09");
        allOptions.add(option);

        for(int i = 10; i <=59; i ++)
        {
            option = new Option(new Long(i), Integer.toString(i));
            allOptions.add(option);
        }

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
     * Performed the create semen gathering for a semental id
     * @return
     */
    public String saveSemenGathering()
    {
        try
        {
            getgermplasm$SemenGatheringSessionBean().getSemenGatheringDTO().setUserName(getAraSessionBean().getGlobalUserName());

            GregorianCalendar semenGatheringDateGC = new GregorianCalendar();


            Date semenGatheringDate = this.getGatheringDate().getSelectedDate();


            if (semenGatheringDate != null)
            {
                semenGatheringDateGC.setTime(semenGatheringDate);
                getgermplasm$SemenGatheringSessionBean().getSemenGatheringDTO().
                        setSemenGatheringDate(semenGatheringDateGC);
            }
            String hhmm = null;
            if(getgermplasm$SemenGatheringSessionBean().getSelectedMinutes() != null &&
                    getgermplasm$SemenGatheringSessionBean().getSelectedHour() != null)
            {
                String mm = getgermplasm$SemenGatheringSessionBean().getSelectedMinutes().toString();
                if(mm.length() == 1)
                    mm = "0"+mm;
                hhmm = getgermplasm$SemenGatheringSessionBean().getSelectedHour() +
                        ":"+ mm;
            }

            getgermplasm$SemenGatheringSessionBean().getSemenGatheringDTO().
                    setSemenGatheringTime(hhmm);

            
            getgermplasm$SemenGatheringSessionBean().getSemenGatheringDTO().
                    setSementalId(getgermplasm$SemenGatheringSessionBean().getSementalId());

            SemenGatheringDTO semenGatheringDTO = getgermplasm$SemenGatheringSessionBean().getSemenGatheringDTO();
            if(semenGatheringDTO.getCurrentStrawQuantity() != null)
            {
                if(semenGatheringDTO.getCurrentStrawQuantity() <= semenGatheringDTO.getStrawQuantity() &&
                        semenGatheringDTO.getCurrentStrawQuantity() >= 0)
                {
                    getgermplasm$SemenGatheringSessionBean().getGermplasmFacadeRemote().saveSemenGathering(
                        getgermplasm$SemenGatheringSessionBean().getSemenGatheringDTO());
                    getgermplasm$SemenGatheringSessionBean().getPagination().addItem();
                    getgermplasm$SemenGatheringSessionBean().getPagination().refreshList();
                    getgermplasm$SemenGatheringSessionBean().setSemenGatheringDTO(new SemenGatheringDTO());
                    getgermplasm$SemenGatheringSessionBean().setSelectedHour(null);
                    getgermplasm$SemenGatheringSessionBean().setSelectedMinutes(null);
                    getGatheringDate().setSelectedDate(null);
                    MessageBean.setSuccessMessageFromBundle("create_semen_gathering_success", this.getMyLocale());
                }
                else
                    MessageBean.setErrorMessageFromBundle("error_current_straw_quantity", this.getMyLocale());
            }
            else
            {
                
                getgermplasm$SemenGatheringSessionBean().getSemenGatheringDTO().imprimir();
                getgermplasm$SemenGatheringSessionBean().getGermplasmFacadeRemote().saveSemenGathering(
                        getgermplasm$SemenGatheringSessionBean().getSemenGatheringDTO());
                getgermplasm$SemenGatheringSessionBean().getPagination().addItem();
                getgermplasm$SemenGatheringSessionBean().getPagination().refreshList();
                getgermplasm$SemenGatheringSessionBean().setSemenGatheringDTO(new SemenGatheringDTO());
                getgermplasm$SemenGatheringSessionBean().setSelectedHour(null);
                getgermplasm$SemenGatheringSessionBean().setSelectedMinutes(null);
                getGatheringDate().setSelectedDate(null);
                MessageBean.setSuccessMessageFromBundle("create_semen_gathering_success", this.getMyLocale());
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            MessageBean.setErrorMessageFromBundle("error", this.getMyLocale());
        }
        return null;
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
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AccessionSessionBean getgermplasm$AccessionSessionBean() {
        return (AccessionSessionBean) getBean("germplasm$AccessionSessionBean");
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
     * @return the semenGatheringMethod
     */
    public SingleSelectOptionsList getSemenGatheringMethod() {
        return semenGatheringMethod;
    }

    /**
     * @param semenGatheringMethod the semenGatheringMethod to set
     */
    public void setSemenGatheringMethod(SingleSelectOptionsList semenGatheringMethod) {
        this.semenGatheringMethod = semenGatheringMethod;
    }

    /**
     * @return the solvent
     */
    public SingleSelectOptionsList getSolvent() {
        return solvent;
    }

    /**
     * @param solvent the solvent to set
     */
    public void setSolvent(SingleSelectOptionsList solvent) {
        this.solvent = solvent;
    }

    /**
     * @return the gatheringDate
     */
    public Calendar getGatheringDate() {
        return gatheringDate;
    }

    /**
     * @param gatheringDate the gatheringDate to set
     */
    public void setGatheringDate(Calendar gatheringDate) {
        this.gatheringDate = gatheringDate;
    }

    /**
     * @return the textTime
     */
    public TextField getTextTime() {
        return textTime;
    }

    /**
     * @param textTime the textTime to set
     */
    public void setTextTime(TextField textTime) {
        this.textTime = textTime;
    }

    /**
     * @return the hourDropDown
     */
    public SingleSelectOptionsList getHourDropDown() {
        return hourDropDown;
    }

    /**
     * @param hourDropDown the hourDropDown to set
     */
    public void setHourDropDown(SingleSelectOptionsList hourDropDown) {
        this.hourDropDown = hourDropDown;
    }

    /**
     * @return the minutesDropDown
     */
    public SingleSelectOptionsList getMinutesDropDown() {
        return minutesDropDown;
    }

    /**
     * @param minutesDropDown the minutesDropDown to set
     */
    public void setMinutesDropDown(SingleSelectOptionsList minutesDropDown) {
        this.minutesDropDown = minutesDropDown;
    }
    
}

