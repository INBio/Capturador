/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inbio.ara.web.identification;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.component.TextField;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import javax.faces.FacesException;
import org.inbio.ara.facade.util.SearchManagerRemote;
import org.inbio.ara.persistence.specimen.Identification;
import org.inbio.ara.web.util.ValidatorHelper;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version SearchIdentification.java
 * @version Created on 15/06/2009, 11:01:44 AM
 * @author herson
 */
public class SearchIdentification extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private TextField txt_specimenId = new TextField();

    public TextField getTxt_specimenId() {
        return txt_specimenId;
    }

    public void setTxt_specimenId(TextField tf) {
        this.txt_specimenId = tf;
    }
    private TextField txt_taxon = new TextField();

    public TextField getTxt_taxon() {
        return txt_taxon;
    }

    public void setTxt_taxon(TextField tf) {
        this.txt_taxon = tf;
    }
    private TextField txt_sequence = new TextField();

    public TextField getTxt_sequence() {
        return txt_sequence;
    }

    public void setTxt_sequence(TextField tf) {
        this.txt_sequence = tf;
    }
    private Calendar cal_identificationDate = new Calendar();

    public Calendar getCal_identificationDate() {
        return cal_identificationDate;
    }

    public void setCal_identificationDate(Calendar c) {
        this.cal_identificationDate = c;
    }
    private TextField txt_identifier = new TextField();

    public TextField getTxt_identifier() {
        return txt_identifier;
    }

    public void setTxt_identifier(TextField tf) {
        this.txt_identifier = tf;
    }
    private TextField txt_type = new TextField();

    public TextField getTxt_type() {
        return txt_type;
    }

    public void setTxt_type(TextField tf) {
        this.txt_type = tf;
    }
    
    private ValidatorHelper validatorHelper;

    public ValidatorHelper getValidatorHelper() {
        return validatorHelper;
    }

    public void setValidatorHelper(ValidatorHelper validatorHelper) {
        this.validatorHelper = validatorHelper;
    }
    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public SearchIdentification() {
        validatorHelper = new ValidatorHelper();
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
            log("SearchIdentification Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
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

    public String searchButton_action() {
        Hashtable searchCriteria = new Hashtable();
        String s;
        if ((s = (String) txt_specimenId.getText()) != null) {
            searchCriteria.put("table.identificationPK.specimenId = ", s);
        }
        if ((s = (String) txt_taxon.getText()) != null) {
            searchCriteria.put("lower(table.taxon.defaultName) like ",
                    "'%" + s.toLowerCase() + "%'");
        }
        if ((s = (String) txt_sequence.getText()) != null) {
            searchCriteria.
                    put("table.identificationPK.identificationSequence = ", s);
        }
        if (cal_identificationDate.getText() != null) {
            searchCriteria.put("table.identificationDate = ",
                    "'" + to_char_date(cal_identificationDate.getSelectedDate(),
                    "yyyy-MM-dd") + "'");
        }
        if ((s = (String) txt_identifier.getText()) != null) {
            String identifier = s.toLowerCase();
            searchCriteria.put("lower(table.valuerPerson.firstName) like ",
                    "'%" + identifier + "%'" +
                    " or lower(table.valuerPerson.lastName) like " +
                    "'%" + identifier + "%'" +
                    " or lower(table.valuerPerson.secondLastName) like " +
                    "'%" + identifier + "%'");
        }
        if ((s = (String) txt_type.getText()) != null) {
            searchCriteria.put("lower(table.identificationType.name) = ",
                                s.toLowerCase());
        }

        IdentificationSessionBean isb =
                getidentification$IdentificationSessionBean();
        SearchManagerRemote smr = isb.getSearchManager();
        isb.setSearchCriteria(searchCriteria);


        if(isb.getPagination() != null){
            isb.setPagination(null); //Deja listo el data provider para la siguiente consulta
        }
        Long resultSet = smr.countResult(Identification.class, searchCriteria);
        if (resultSet != null || resultSet != 0) {
            return "identification_list";
        }

        return null;
    }

    private String to_char_date(Date date, String format) {
        if(date != null){
            SimpleDateFormat df = new SimpleDateFormat(format);
            return df.format(date);
        }
        else return "";
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected IdentificationSessionBean getidentification$IdentificationSessionBean() {
        return (IdentificationSessionBean)getBean("identification$IdentificationSessionBean");
    }
}

