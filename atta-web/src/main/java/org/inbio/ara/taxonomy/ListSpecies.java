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
import java.util.ArrayList;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import org.inbio.ara.statistics.StatisticsSessionBean;
import org.inbio.ara.security.SystemUserSessionBean;
import org.inbio.ara.admin.AudienceSessionBean;
import org.inbio.ara.admin.CollectionSessionBean;
import org.inbio.ara.inventory.SpecimenSessionBean;
import org.inbio.ara.inventory.GatheringDetailSessionBean;
import org.inbio.ara.admin.ProfileSessionBean;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionDTO;
import org.inbio.ara.util.AddRemoveList;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version ListSpecies.java
 * @version Created on 13/10/2009, 03:06:45 PM
 * @author esmata
 */

public class ListSpecies extends AbstractPageBean {
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

    //Binding de la tabla
    private HtmlDataTable TaxonDescriptionTable = new HtmlDataTable();

    //Variable que contiene los datos de la paginacion para ser mostrados en la tabla
    private String quantityTotal = new String();

    /*Componentes de busquedas*/
    private HtmlCommandButton btnSearchSpecies = new HtmlCommandButton(); //Boton busqueda simple
    private HtmlInputText txSearchSpecies = new HtmlInputText(); //Input text de busqueda simple

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ListSpecies() {
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
            log("ListSpecies Initialization Failure", e);
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
        SpeciesSessionBean ssb = this.gettaxonomy$SpeciesSessionBean();
        //Inicializar el dataprovider la primera vez (si la paginación es nula)
        if (ssb.getPagination()==null) {
            ssb.initDataProvider();
        }
        //Actualizar los datos del paginador
        else
            ssb.getPagination().refreshList();
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

    public String newButton_action() {
        //Limpiar el currentDTO
        this.gettaxonomy$SpeciesSessionBean().setCurrentTaxDescripDTO
                (new TaxonDescriptionDTO());
        this.gettaxonomy$SpeciesSessionBean().setSelectedLanguage(null);
        this.gettaxonomy$SpeciesSessionBean().setSelectedScientificName(null);
        this.gettaxonomy$SpeciesSessionBean().setSelectedStatus(null);
        return "new";
    }

    /**
     * Metodo ejecutado por el boton para editar un registro de especie
     * @return
     */
    public String editButton_action() {
        int n = this.getTaxonDescriptionTable().getRowCount();
        ArrayList<TaxonDescriptionDTO> selectedDescriptions = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getTaxonDescriptionTable().setRowIndex(i);
            TaxonDescriptionDTO aux = (TaxonDescriptionDTO)
                    this.getTaxonDescriptionTable().getRowData();
            if (aux.isSelected()) {
                selectedDescriptions.add(aux);
            }
        }
        if(selectedDescriptions == null || selectedDescriptions.size() == 0){
            //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        else if(selectedDescriptions.size() == 1){ //En caso de que solo se seleccione un elemento
            //Reestablecer el valor default del DTO y de los add remove components
            this.gettaxonomy$SpeciesSessionBean().
                    setCurrentTaxDescripDTO(selectedDescriptions.get(0));
            this.gettaxonomy$SpeciesSessionBean().setArAudiences(new AddRemoveList());
            this.gettaxonomy$SpeciesSessionBean().setArAuthors(new AddRemoveList());
            this.gettaxonomy$SpeciesSessionBean().setArInstitutions(new AddRemoveList());
            /*Indicar a la pantalla de edit que cargue 1 sola ves los datos
            seleccionados de los AddRemove*/
            this.gettaxonomy$SpeciesSessionBean().setFirstTime(true);
            return "edit";
        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            return null;
        }
    }

    /**
     * Metodo ejecutado por el boton para eliminar un registro de especie
     * @return
     */
    public String deleteButton_action() {
        int n = this.getTaxonDescriptionTable().getRowCount();
        ArrayList<TaxonDescriptionDTO> selectedItems = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getTaxonDescriptionTable().setRowIndex(i);
            TaxonDescriptionDTO aux = (TaxonDescriptionDTO)
                    this.getTaxonDescriptionTable().getRowData();
            if (aux.isSelected()) {
                selectedItems.add(aux);
            }
        }
        if(selectedItems == null || selectedItems.size() == 0){
            //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        //En caso de que solo se seleccione un elemento
        else if(selectedItems.size() == 1){
            TaxonDescriptionDTO selected = selectedItems.get(0);
            //Mandar a borrar la audiencia
            try{
                this.gettaxonomy$SpeciesSessionBean().
                        deleteTaxonDescription(selected.getTaxonId(),
                        selected.getTaxonDescriptionSequence());
            }
            catch(Exception e){
                MessageBean.setErrorMessageFromBundle("imposible_to_delete", this.getMyLocale());
                return null;
            }
            //Refrescar la lista de audiencias
            this.gettaxonomy$SpeciesSessionBean().getPagination().refreshList();

            //Notificar al usuario
            MessageBean.setSuccessMessageFromBundle("delete_success", this.getMyLocale());
            return null;
        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            return null;
        }
    }

    /**
     * Metodo ejecutado por el boton de mostrar el preview del registro seleccionado
     * @return
     */
    public String previewButton_action() {
        int n = this.getTaxonDescriptionTable().getRowCount();
        ArrayList<TaxonDescriptionDTO> selectedItems = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getTaxonDescriptionTable().setRowIndex(i);
            TaxonDescriptionDTO aux = (TaxonDescriptionDTO)
                    this.getTaxonDescriptionTable().getRowData();
            if (aux.isSelected()) {
                selectedItems.add(aux);
            }
        }
        if(selectedItems == null || selectedItems.size() == 0){
            //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        //En caso de que solo se seleccione un elemento
        else if(selectedItems.size() == 1){
            TaxonDescriptionDTO selected = selectedItems.get(0);
            this.gettaxonomy$SpeciesSessionBean().setCurrentTaxDescripDTO(selected);
            return "preview";
        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            return null;
        }
    }

    /**
     * Metodo ejecutado por el boton de busqueda simple
     * @return
     */
    public String btnSpeciesSearch_action() {
        String userInput = "";
        if(this.getTxSearchSpecies().getValue()!= null)
            userInput = this.getTxSearchSpecies().getValue().toString();
        userInput = userInput.trim();
        System.out.println(1);
        if(userInput.length()==0){
            //Se desabilitan las banderas de busqueda simple y avanzada
            this.gettaxonomy$SpeciesSessionBean().setQueryModeSimple(false);
        }
        else{
            //Setear el string para consulta simple del SessionBean
            this.gettaxonomy$SpeciesSessionBean().setConsultaSimple(userInput);
            //Indicarle al SessionBean que el paginador debe "trabajar" en modo busqueda simple
            this.gettaxonomy$SpeciesSessionBean().setQueryModeSimple(true);
        }
        //set the first result of the query
        this.gettaxonomy$SpeciesSessionBean().getPagination().firstResults();
        return null;
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
    protected SystemUserSessionBean getsecurity$SystemUserSessionBean() {
        return (SystemUserSessionBean) getBean("security$SystemUserSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AudienceSessionBean getadmin$AudienceSessionBean() {
        return (AudienceSessionBean) getBean("admin$AudienceSessionBean");
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
    protected CollectionSessionBean getadmin$CollectionSessionBean() {
        return (CollectionSessionBean) getBean("admin$CollectionSessionBean");
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
    protected GatheringDetailSessionBean getinventory$GatheringDetailSessionBean() {
        return (GatheringDetailSessionBean) getBean("inventory$GatheringDetailSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ProfileSessionBean getadmin$ProfileSessionBean() {
        return (ProfileSessionBean) getBean("admin$ProfileSessionBean");
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
     * @return the TaxonDescriptionTable
     */
    public HtmlDataTable getTaxonDescriptionTable() {
        return TaxonDescriptionTable;
    }

    /**
     * @param TaxonDescriptionTable the TaxonDescriptionTable to set
     */
    public void setTaxonDescriptionTable(HtmlDataTable TaxonDescriptionTable) {
        this.TaxonDescriptionTable = TaxonDescriptionTable;
    }

    /**
     * @return the quantityTotal
     */
    public String getQuantityTotal() {
        quantityTotal = this.gettaxonomy$SpeciesSessionBean().getQuantityTotal();
        return quantityTotal;
    }

    /**
     * @param quantityTotal the quantityTotal to set
     */
    public void setQuantityTotal(String quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
		return this.getAraSessionBean().getCurrentLocale();
    }

    /**
     * Metodo ejecutado por el boton para crear un nuevo registro de especie
     * @return
     */

    /**
     * @return the btnSearchSpecies
     */
    public HtmlCommandButton getBtnSearchSpecies() {
        return btnSearchSpecies;
    }

    /**
     * @param btnSearchSpecies the btnSearchSpecies to set
     */
    public void setBtnSearchSpecies(HtmlCommandButton btnSearchSpecies) {
        this.btnSearchSpecies = btnSearchSpecies;
    }

    /**
     * @return the txSearchSpecies
     */
    public HtmlInputText getTxSearchSpecies() {
        return txSearchSpecies;
    }

    /**
     * @param txSearchSpecies the txSearchSpecies to set
     */
    public void setTxSearchSpecies(HtmlInputText txSearchSpecies) {
        this.txSearchSpecies = txSearchSpecies;
    }

    
}

