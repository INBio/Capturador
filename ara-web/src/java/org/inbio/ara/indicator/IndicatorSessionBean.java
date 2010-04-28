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

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import javax.ejb.EJB;
import javax.faces.FacesException;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.indicator.IndicatorDTO;
import org.inbio.ara.facade.indicator.IndicatorFacadeRemote;

/**
 * <p>Session scope data bean for your application.  Create properties
 *  here to represent cached data that should be made available across
 *  multiple HTTP requests for an individual user.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 *
 * @version IndicatorSessionBean.java
 * @version Created on 26/03/2010, 10:06:48 AM
 * @author gsulca
 */

public class IndicatorSessionBean extends AbstractSessionBean {

     //Injections
    @EJB
    private IndicatorFacadeRemote indicatorFacade;


    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>


    private String nodeId = null; //
    private String pathNode = null; //

    //Seleccion del estandar a utilizar
    private Long resultRadioGroup = 1L;

    private IndicatorDTO currentIndicatorDTO = new IndicatorDTO();
    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public IndicatorSessionBean() {
    }

    /**
     * <p>This method is called when this bean is initially added to
     * session scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * session scope.</p>
     * 
     * <p>You may customize this method to initialize and cache data values
     * or resources that are required for the lifetime of a particular
     * user session.</p>
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
            log("IndicatorSessionBean Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }

    /**
     * <p>This method is called when the session containing it is about to be
     * passivated.  Typically, this occurs in a distributed servlet container
     * when the session is about to be transferred to a different
     * container instance, after which the <code>activate()</code> method
     * will be called to indicate that the transfer is complete.</p>
     * 
     * <p>You may customize this method to release references to session data
     * or resources that can not be serialized with the session itself.</p>
     */
    @Override
    public void passivate() {
    }

    /**
     * <p>This method is called when the session containing it was
     * reactivated.</p>
     * 
     * <p>You may customize this method to reacquire references to session
     * data or resources that could not be serialized with the
     * session itself.</p>
     */
    @Override
    public void activate() {
    }

    /**
     * <p>This method is called when this bean is removed from
     * session scope.  Typically, this occurs as a result of
     * the session timing out or being terminated by the application.</p>
     * 
     * <p>You may customize this method to clean up resources allocated
     * during the execution of the <code>init()</code> method, or
     * at any later time during the lifetime of the application.</p>
     */
    @Override
    public void destroy() {
    }




    /**
     * @return the nodeId
     */
    public String getNodeId() {
        return nodeId;
    }

    /**
     * @param nodeId the nodeId to set
     */
    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * @return the pathNode
     */
    public String getPathNode() {
        return pathNode;
    }

    /**
     * @param pathNode the pathNode to set
     */
    public void setPathNode(String pathNode) {
        this.pathNode = pathNode;
    }

    /**
     * @return the resultRadioGroup
     */
    public Long getResultRadioGroup() {
        return resultRadioGroup;
    }

    /**
     * @param resultRadioGroup the resultRadioGroup to set
     */
    public void setResultRadioGroup(Long resultRadioGroup) {
        this.resultRadioGroup = resultRadioGroup;
    }

    /**
     * @return the currentSiteDTO
     */
    public IndicatorDTO getCurrentIndicatorDTO() {
        return currentIndicatorDTO;
    }

    /**
     * @param currentSiteDTO the currentSiteDTO to set
     */
    public void setCurrentIndicatorDTO(IndicatorDTO currentIndicatorDTO) {
        this.currentIndicatorDTO = currentIndicatorDTO;
    }

    public Long countChildrenByIndicatorId(Long indicatorId) {
       return this.indicatorFacade.countChildrenByIndicatorId(indicatorId);
    }
        /**
     * Guardar el nuevo sitio, sus coordenadas y division politica
     */
    public void saveNewIndicator(){
      //  System.out.println("ancestor id (IndicatorSessionBean) "+ this.getCurrentIndicatorDTO().getIndicatorAncestorId());
        IndicatorDTO newDTO = this.getIndicatorFacade().saveNewIndicator(this.getCurrentIndicatorDTO());
        this.setCurrentIndicatorDTO(newDTO);
    }


     public void updateIndicator(){
      /*   System.out.println("node id (IndicatorSessionBean) "+ this.getCurrentIndicatorDTO().getIndicatorId());
         System.out.println("name (IndicatorSessionBean) "+ this.getCurrentIndicatorDTO().getName());
         System.out.println("description (IndicatorSessionBean) "+ this.getCurrentIndicatorDTO().getDescription());
         System.out.println("appliy to parts (IndicatorSessionBean) "+ this.getCurrentIndicatorDTO().getAppliesToParts());
         System.out.println("ancestor id (IndicatorSessionBean) "+ this.getCurrentIndicatorDTO().getIndicatorAncestorId());
*/
        this.getIndicatorFacade().updateIndicator(this.getCurrentIndicatorDTO());
        //this.setCurrentIndicatorDTO(newDTO);
    }

     public void deleteIndicator(Long indicatorId)
     {
         this.indicatorFacade.deletePassport(indicatorId);
     }


    public IndicatorDTO getIndicatorDTOByIndicatorId(Long indicatorId)
    {
       return indicatorFacade.getIndicatorByIndicatorId(indicatorId);
    }

    
    /**
     * @return the indicatorFacade
     */
    public IndicatorFacadeRemote getIndicatorFacade() {
        return indicatorFacade;
    }
    
}
