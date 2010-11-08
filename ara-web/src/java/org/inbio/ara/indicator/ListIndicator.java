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
import java.util.HashMap;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.statistics.StatisticsSessionBean;
import org.inbio.ara.util.ValidatorBean;
import org.inbio.ara.admin.CollectionSessionBean;
import org.inbio.ara.SessionManager;
import org.inbio.ara.dto.indicator.IndicatorDTO;
import org.inbio.ara.util.MessageBean;
import org.inbio.commons.dublincore.dto.ara.ReferenceDTO;


/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version ListIndicator.java
 * @version Created on 26/03/2010, 09:44:48 AM
 * @author gsulca
 */

public class ListIndicator extends AbstractPageBean {
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
    
    private HtmlPanelGrid gridIndicator = new HtmlPanelGrid();
    private HtmlPanelGrid indicator = new HtmlPanelGrid();
    private HtmlInputHidden hiddenNodeId = new HtmlInputHidden();
    private HtmlInputHidden hiddenPathNode = new HtmlInputHidden();


    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ListIndicator() {
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
            log("ListIndicator Initialization Failure", e);
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

        hiddenNodeId.setValue(this.getIndicatorSessionBean().getNodeId());
        hiddenPathNode.setValue(this.getIndicatorSessionBean().getPathNode());
        
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
    protected AraSessionBean getAraSessionBean() {
        return (AraSessionBean) getBean("AraSessionBean");
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
    protected StatisticsSessionBean getstatistics$StatisticsSessionBean() {
        return (StatisticsSessionBean) getBean("statistics$StatisticsSessionBean");
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
    protected CollectionSessionBean getadmin$CollectionSessionBean() {
        return (CollectionSessionBean) getBean("admin$CollectionSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionManager getSessionManager() {
        return (SessionManager) getBean("SessionManager");
    }

    

    


    protected IndicatorSessionBean getIndicatorSessionBean() {
        return (IndicatorSessionBean) getBean("indicator$IndicatorSessionBean");
    }

    public String btnNewIndicator_action() {
        
       // this.getIndicatorSessionBean().setCurrentIndicatorDTO(null);
        this.getIndicatorSessionBean().setCurrentIndicatorDTO(new IndicatorDTO());
        this.getIndicatorSessionBean().setNodeId(this.hiddenNodeId.getValue().toString());
        this.getIndicatorSessionBean().setPathNode(this.hiddenPathNode.getValue().toString());
        this.getIndicatorSessionBean().setSelectedResourcesId(new HashMap<String, ReferenceDTO>());
        if(this.getIndicatorSessionBean().getPagination() != null)
        {
            this.getIndicatorSessionBean().getPagination().refreshList();
            this.getIndicatorSessionBean().getPagination().firstResults();
        }
        
        return "new";
    }

    public String btnEditIndicator_action() {
        this.getIndicatorSessionBean().setCurrentIndicatorDTO(new IndicatorDTO());
        this.getIndicatorSessionBean().setNodeId(this.hiddenNodeId.getValue().toString());
        this.getIndicatorSessionBean().setPathNode(this.hiddenPathNode.getValue().toString());
        //IndicatorDTO indicatorEdit = this.getIndicatorSessionBean().getIndicatorDTOByIndicatorId(new Long(this.getIndicatorSessionBean().getNodeId()));
        this.getIndicatorSessionBean().setCurrentIndicatorDTO(this.getIndicatorSessionBean().getIndicatorDTOByIndicatorId(new Long(this.getIndicatorSessionBean().getNodeId())));

        if(this.getIndicatorSessionBean().getPagination() != null)
        {
            this.getIndicatorSessionBean().setPagination(null);
        }
        this.getIndicatorSessionBean().setQueryMode(false);
        this.getIndicatorSessionBean().setQueryModeSimple(false);
        this.getIndicatorSessionBean().setSimpleConsult(new String(""));

        return "edit";
        
    }

    public String btnDeleteIndicator_action() {
        Long indicatorId = new Long(this.hiddenNodeId.getValue().toString());
       if(this.getIndicatorSessionBean().countChildrenByIndicatorId(indicatorId) <= 0)
       {
           this.getIndicatorSessionBean().deleteIndicator(indicatorId);
       }
       else
       {
               MessageBean.setErrorMessageFromBundle("has_indicator_children", this.getMyLocale());
        

       }
        return null;
    }

    public HtmlPanelGrid getGridIndicator() {
        return gridIndicator;
    }

    public void setGridIndicator(HtmlPanelGrid hpg) {
        this.gridIndicator = hpg;
    }


    public HtmlPanelGrid getIndicator() {
        return indicator;
    }

    public void setIndicator(HtmlPanelGrid hpg) {
        this.indicator = hpg;
    }



    public HtmlInputHidden getHiddenNodeId() {
        return hiddenNodeId;
    }

    public void setHiddenNodeId(HtmlInputHidden hdn) {
        this.hiddenNodeId = hdn;
    }




    public HtmlInputHidden getHiddenPathNode() {
        return hiddenPathNode;
    }

    public void setHiddenPathNode(HtmlInputHidden hdn) {
        this.hiddenPathNode = hdn;
    }
    
}

