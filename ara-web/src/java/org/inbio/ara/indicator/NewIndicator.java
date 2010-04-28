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

package org.inbio.ara.indicator;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.RadioButtonGroup;
import com.sun.webui.jsf.component.TextArea;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import org.inbio.ara.security.SystemUserSessionBean;
import org.inbio.ara.statistics.StatisticsSessionBean;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.indicator.IndicatorDTO;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version NewIndicator.java
 * @version Created on 12/04/2010, 11:24:37 AM
 * @author gsulca
 */

public class NewIndicator extends AbstractPageBean {
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

    private RadioButtonGroup radioButtonGroup = new RadioButtonGroup();
    private SingleSelectOptionsList radioData = new SingleSelectOptionsList();
    /**
     * @return the radioData
     */
    public SingleSelectOptionsList getRadioData() {
        return radioData;
    }

    /**
     * @param radioData the radioData to set
     */
    public void setRadioData(SingleSelectOptionsList radioData) {
        this.radioData = radioData;
    }


    private HtmlPanelGrid gridIndicator = new HtmlPanelGrid();

    public HtmlPanelGrid getGridIndicator() {
        return gridIndicator;
    }

    public void setGridIndicator(HtmlPanelGrid hpg) {
        this.gridIndicator = hpg;
    }


     private HtmlPanelGrid indicator = new HtmlPanelGrid();

    public HtmlPanelGrid getIndicator() {
        return indicator;
    }

    public void setIndicator(HtmlPanelGrid hpg) {
        this.indicator = hpg;
    }


    private TextField txIndicatorName = new TextField();

    public TextField getTxIndicatorName() {
        return txIndicatorName;
    }

    public void setTxIndicatorName(TextField tf) {
        this.txIndicatorName = tf;
    }


    private TextArea txaIndicatorDescription = new TextArea();

    public TextArea getTxaIndicatorDescription() {
        return txaIndicatorDescription;
    }

    public void setTxaIndicatorDescription(TextArea ta) {
        this.txaIndicatorDescription = ta;
    }

    private HtmlInputHidden hiddenNodeId = new HtmlInputHidden();

    public HtmlInputHidden getHiddenNodeId() {
        return hiddenNodeId;
    }

    public void setHiddenNodeId(HtmlInputHidden hdn) {
        this.hiddenNodeId = hdn;
    }


    private HtmlInputHidden hiddenPathNode = new HtmlInputHidden();

    public HtmlInputHidden getHiddenPathNode() {
        return hiddenPathNode;
    }

    public void setHiddenPathNode(HtmlInputHidden hdn) {
        this.hiddenPathNode = hdn;
    }

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public NewIndicator() {
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
            log("NewIndicator Initialization Failure", e);
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
        hiddenNodeId.setValue(this. getindicator$IndicatorSessionBean().getNodeId());
        hiddenPathNode.setValue(this.getindicator$IndicatorSessionBean().getPathNode());
         //Inicialization of radio button group options
        Option op1 = new Option(0L,BundleHelper.getDefaultBundleValue
                ("yes",this.getMyLocale()));
        Option op2 = new Option(1L,BundleHelper.getDefaultBundleValue
                ("no",this.getMyLocale()));
        Option options[] = {op1,op2};
        this.radioData.setOptions(options);
        this.getindicator$IndicatorSessionBean().getCurrentIndicatorDTO().setAppliesToParts(1L);
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
     * @return the myLocale
     */
    public Locale getMyLocale() {
		return this.getAraSessionBean().getCurrentLocale();
    }
   
 
    protected IndicatorSessionBean getindicator$IndicatorSessionBean() {
        return (IndicatorSessionBean) getBean("indicator$IndicatorSessionBean");
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
    protected AraSessionBean getAraSessionBean() {
        return (AraSessionBean) getBean("AraSessionBean");
    }



    public String btnSaveIndicator_action() {

        
         //Create a new indicator
        try{
            Long ancestorId = new Long(this.hiddenNodeId.getValue().toString());
            this.getindicator$IndicatorSessionBean().getCurrentIndicatorDTO().setUserName(getAraSessionBean().getGlobalUserName());
            this.getindicator$IndicatorSessionBean().getCurrentIndicatorDTO().setIndicatorAncestorId(ancestorId);
            this.getindicator$IndicatorSessionBean().saveNewIndicator();
            //System.out.println("****************** -nodeId (Edit) = "+this.getindicator$IndicatorSessionBean().getNodeId());
            //System.out.println("****************** -pathNodeId (Edit) = "+this.getindicator$IndicatorSessionBean().getPathNode());
            Long newNodeId = this.getindicator$IndicatorSessionBean().getCurrentIndicatorDTO().getIndicatorId();
            String newPath = this.getindicator$IndicatorSessionBean().getPathNode()+","+newNodeId;
            this.getindicator$IndicatorSessionBean().setNodeId(newNodeId.toString());
            this.getindicator$IndicatorSessionBean().setPathNode(newPath);
            return "back";
        }
        catch(Exception e){
            MessageBean.setErrorMessageFromBundle("error", this.getMyLocale());
            return null;
        }
        

        
    }

    /**
     * @return the radioButtonGroup
     */
    public RadioButtonGroup getRadioButtonGroup() {
        return radioButtonGroup;
    }

    /**
     * @param radioButtonGroup the radioButtonGroup to set
     */
    public void setRadioButtonGroup(RadioButtonGroup radioButtonGroup) {
        this.radioButtonGroup = radioButtonGroup;
    }

  
}

