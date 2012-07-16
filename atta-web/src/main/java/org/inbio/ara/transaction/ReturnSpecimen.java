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

package org.inbio.ara.transaction;

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
import javax.faces.component.html.HtmlInputText;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.dto.transaction.TransactedSpecimenDTO;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version ReturnSpecimen.java
 * @version Created on Apr 15, 2010, 2:14:42 PM
 * @author echinchilla
 */

public class ReturnSpecimen extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>


    private HtmlInputText txReturnTransactedSpecimen = new HtmlInputText();
    private Calendar clReceivingDate = new Calendar();
    private SingleSelectOptionsList transactedSpecimenStatusData = new SingleSelectOptionsList();

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ReturnSpecimen() {
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
            log("TransactedSpecimens Initialization Failure", e);
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

        this.getTransactedSpecimenStatusData().setOptions(getSelectionListDropDownData
                (SelectionListEntity.TRANSACTED_SPECIMEN_STATUS.getId()));

        java.util.Calendar currentDate = java.util.Calendar.getInstance();
        this.clReceivingDate.setSelectedDate(currentDate.getTime());
        System.out.println(currentDate);
        System.out.println(this.clReceivingDate);
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
     * @return reference to the scoped data bean
     */
    protected TransactionSessionBean getTransactionSessionBean() {
        return (TransactionSessionBean) getBean("transaction$TransactionSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     * @return reference to the scoped data bean
     */
    protected AraSessionBean getAraSessionBean() {
        return (AraSessionBean) getBean("AraSessionBean");
    }

    public String btnReturnTransactedSpecimen_action() {
        if(this.txReturnTransactedSpecimen.getValue() != null) {
            String catalogNumber = txReturnTransactedSpecimen.getValue().toString().trim();

            GregorianCalendar receivingDateGC = new GregorianCalendar();
            Date recievingDateD = null;

            recievingDateD = this.getClReceivingDate().getSelectedDate();

            TransactedSpecimenDTO transactedSpecimenDTO = this.getTransactionSessionBean().getCurrentTransactedSpecimen();
            if (recievingDateD != null) {
                receivingDateGC.setTime(recievingDateD);
                transactedSpecimenDTO.setReceivingDate(receivingDateGC);
            }
            else {
                transactedSpecimenDTO.setReceivingDate(null);
            }

            transactedSpecimenDTO.setCatalogNumber(catalogNumber);
            try {
                if (transactedSpecimenDTO.getCatalogNumber() == null) {
                    MessageBean.setErrorMessageFromBundle("error_catalog_number", this.getMyLocale());
                    return null;
                }

                else if (this.getTransactionSessionBean().getTransactedSpecimenStatusId() == null) {
                    MessageBean.setErrorMessageFromBundle("error_transacted_specimen_status", this.getMyLocale());
                    return null;
                }

                this.getTransactionSessionBean().returnTransactedSpecimen(catalogNumber);

            }
            catch (Exception e){
                MessageBean.setErrorMessageFromBundle("error", this.getMyLocale());
                return null;
            }

            MessageBean.setSuccessMessageFromBundle("return_transacted_specimen_succces", this.getMyLocale());

            //Refrescar la lista de transacciones
            this.getTransactionSessionBean().getPagination().refreshList();
            this.txReturnTransactedSpecimen.setValue(null);
        }
        else {
            MessageBean.setErrorMessageFromBundle("missing_catalog_number", this.getMyLocale());
        }
        return null;
    }

    /**
     * Metodo para obtener los datos a mostrar en los drop downs de la
     * ventana de generacion que pertenecen a listas de seleccion
     * @param selectionListEntityId que es el id del enum de listas de seleccion
     * @return
     */
    public Option[] getSelectionListDropDownData(Long selectionListEntityId) {

        List<SelectionListDTO> DTOList = this.getTransactionSessionBean().
                getInventoryFacade().
                getAllSelectionListElementsByCollection
                (selectionListEntityId, getAraSessionBean().getGlobalCollectionId());
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null, " -- " + BundleHelper.getDefaultBundleValue
                ("drop_down_default", getMyLocale()) + " --");
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
     * @return the myLocale
     */
    public Locale getMyLocale() {
        return this.getAraSessionBean().getCurrentLocale();
    }

    /**
     * @return the txReturnTransactedSpecimen
     */
    public HtmlInputText getTxReturnTransactedSpecimen() {
        return txReturnTransactedSpecimen;
    }

    /**
     * @param txReturnTransactedSpecimen the txReturnTransactedSpecimen to set
     */
    public void setTxReturnTransactedSpecimen(HtmlInputText txReturnTransactedSpecimen) {
        this.txReturnTransactedSpecimen = txReturnTransactedSpecimen;
    }

    /**
     * @return the clReceivingDate
     */
    public Calendar getClReceivingDate() {
        return clReceivingDate;
    }

    /**
     * @param clReceivingDate the clReceivingDate to set
     */
    public void setClReceivingDate(Calendar clReceivingDate) {
        this.clReceivingDate = clReceivingDate;
    }

    /**
     * @return the transactedSpecimenStatusData
     */
    public SingleSelectOptionsList getTransactedSpecimenStatusData() {
        return transactedSpecimenStatusData;
    }

    /**
     * @param transactedSpecimenStatusData the transactedSpecimenStatusData to set
     */
    public void setTransactedSpecimenStatusData(SingleSelectOptionsList transactedSpecimenStatusData) {
        this.transactedSpecimenStatusData = transactedSpecimenStatusData;
    }
    
}

