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

package org.inbio.ara.web.site;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.PageAlert;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.Hashtable;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.event.ValueChangeEvent;
import org.inbio.ara.facade.util.SearchManagerRemote;
import org.inbio.ara.persistence.gis.Site;
import org.inbio.ara.web.StringUtils;
import org.inbio.ara.web.util.BundleHelper;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version SearchSite.java
 * @version Created on 04/06/2009, 09:08:37 AM
 * @author herson
 */

public class SearchSite extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    
    private TextField txt_identification = new TextField();

    public TextField getTxt_identification() {
        return txt_identification;
    }

    public void setTxt_identification(TextField tf) {
        this.txt_identification = tf;
    }
    private TextField txt_description = new TextField();

    public TextField getTxt_description() {
        return txt_description;
    }

    public void setTxt_description(TextField tf) {
        this.txt_description = tf;
    }
    private DropDown dd_type = new DropDown();

    public DropDown getDd_type() {
        return dd_type;
    }

    public void setDd_type(DropDown dd) {
        this.dd_type = dd;
    }
    private DropDown dd_baseProjection = new DropDown();

    public DropDown getDd_baseProjection() {
        return dd_baseProjection;
    }

    public void setDd_baseProjection(DropDown dd) {
        this.dd_baseProjection = dd;
    }
    private DropDown dd_determinationMethod = new DropDown();

    public DropDown getDd_determinationMethod() {
        return dd_determinationMethod;
    }

    public void setDd_determinationMethod(DropDown dd) {
        this.dd_determinationMethod = dd;
    }
    private PageAlert searchAlert = new PageAlert();

    public PageAlert getSearchAlert() {
        return searchAlert;
    }

    public void setSearchAlert(PageAlert pa) {
        this.searchAlert = pa;
    }
    private Option[] dd_typeOptions;
    private Option[] dd_baseProjectionOptions;
    private Option[] dd_determinationMethodOptions;

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public SearchSite() {
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
            log("SearchSite Initialization Failure", e);
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
        this.getsite$SiteSessionBean().populateList();
//        Option o = new Option(-1,"seleccione un valor");
//        //Base Projection
//        dd_baseProjectionOptions = new Option[getsite$SiteSessionBean().getProjectionOption().length];
//        dd_baseProjectionOptions[0] = o;
//        for (Option option : getsite$SiteSessionBean().getProjectionOption()) {
//            int i = 1;
//            System.out.println("**" + dd_baseProjectionOptions.length);
//            dd_baseProjectionOptions[i] = option;
//            i++;
//        }
//        //Type
//        dd_typeOptions = new Option[getsite$SiteSessionBean().getFeatureTypeOption().length];
//        dd_typeOptions[0] = o;
//        for (Option option : getsite$SiteSessionBean().getFeatureTypeOption()) {
//            int i = 1;
//            dd_typeOptions[i] = option;
//            i++;
//        }
//        //Determination method
//        dd_determinationMethodOptions = new Option[getsite$SiteSessionBean().getSiteCalculationMethod().length];
//        dd_determinationMethodOptions[0] = o;
//        for (Option option : getsite$SiteSessionBean().getSiteCalculationMethod()) {
//            int i = 1;
//            dd_determinationMethodOptions[i] = option;
//            i++;
//        }
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

    public String searchButton_action() {
        if (!isValidInput())
            return null;
        Hashtable searchCriteria = new Hashtable();

        if (txt_identification.getText() != null) {
            searchCriteria.put("table.id = ",
                        txt_identification.getText().toString());
        }
        if (txt_description.getText() != null) {
            searchCriteria.put("lower(table.description) like ",
                "'%" + txt_description.getText().toString().toLowerCase() + "%'");
        }
        if(dd_type.getValue() != null && !dd_type.getValue().equals(-1)) {
            searchCriteria.put("table.featureType.id = ", dd_type.getValue());
        }
        if(dd_baseProjection.getValue() != null && !dd_baseProjection.getValue().equals(-1)) {
            searchCriteria.put("table.baseProjection.id = ", dd_baseProjection.getValue());
        }
        if(dd_determinationMethod.getValue() != null && !dd_determinationMethod.getValue().equals(-1)) {
            searchCriteria.put("table.siteCalculationMethod.id = ", dd_determinationMethod.getValue());
        }

        SearchManagerRemote smr = getsite$SiteSessionBean().getSearchManager();
        getsite$SiteSessionBean().setPagination(null);
        List resultSet = smr.makeQuery(Site.class, searchCriteria);
        if (resultSet != null) {
            getsite$SiteSessionBean().setFiltered(true);
            getsite$SiteSessionBean().getSiteDataProvider().clearObjectList();
            getsite$SiteSessionBean().getSiteDataProvider().setList(resultSet);
            return "site_list"; //back to the list
        }

        return null;
    }

        /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SiteSessionBean getsite$SiteSessionBean() {
        return (SiteSessionBean)getBean("site$SiteSessionBean");
    }

    private boolean isValidInput() {
        boolean isValid = true;
        String message = "";
        if (txt_identification.getText() != null) {
            String id = txt_identification.getText().toString();
            if (!StringUtils.isNumeric(id)) {
                message += BundleHelper.getDefaultBundleValue("id_error");
                isValid = false;
            }
        }
        if (txt_description.getText() != null) {
            String responsible = txt_description.getText().toString();
            if (!responsible.matches("[0-9a-zA-ZáéíóúÁÉÍÓÚñÑ. -]*")) {
                message += BundleHelper.getDefaultBundleValue("description_error");
                isValid = false;
            }
        }

        if (!isValid) {
            searchAlert.setRendered(true);
            searchAlert.setType("error");
            searchAlert.setSummary(BundleHelper.getDefaultBundleValue("validation_error"));
            searchAlert.setDetail(message);
        }
        return isValid;
    }

    public void dd_type_processValueChange(ValueChangeEvent vce) {
    }

    /**
     * @return the dd_typeOptions
     */
    public Option[] getDd_typeOptions() {
        return dd_typeOptions;
    }

    /**
     * @param dd_typeOptions the dd_typeOptions to set
     */
    public void setDd_typeOptions(Option[] dd_typeOptions) {
        this.dd_typeOptions = dd_typeOptions;
    }

    /**
     * @return the dd_baseProjectionOptions
     */
    public Option[] getDd_baseProjectionOptions() {
        return dd_baseProjectionOptions;
    }

    /**
     * @param dd_baseProjectionOptions the dd_baseProjectionOptions to set
     */
    public void setDd_baseProjectionOptions(Option[] dd_baseProjectionOptions) {
        this.dd_baseProjectionOptions = dd_baseProjectionOptions;
    }

    /**
     * @return the dd_determinationMethodOptions
     */
    public Option[] getDd_determinationMethodOptions() {
        return dd_determinationMethodOptions;
    }

    /**
     * @param dd_determinationMethodOptions the dd_determinationMethodOptions to set
     */
    public void setDd_determinationMethodOptions(Option[] dd_determinationMethodOptions) {
        this.dd_determinationMethodOptions = dd_determinationMethodOptions;
    }
    
}

