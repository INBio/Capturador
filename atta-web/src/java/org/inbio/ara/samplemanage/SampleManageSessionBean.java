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

package org.inbio.ara.samplemanage;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.FacesException;
import org.inbio.ara.dto.samplemanage.EnviromentalDataDTO;
import org.inbio.ara.dto.samplemanage.HostInformationDTO;
import org.inbio.ara.dto.samplemanage.SampleDTO;
import org.inbio.ara.facade.inventory.InventoryFacadeRemote;
import org.inbio.ara.facade.samplemanage.SampleManageFacadeRemote;
import org.inbio.ara.util.PaginationControllerRemix;
import org.inbio.ara.util.PaginationCoreInterface;

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
 * @version SampleManageSessionBean.java
 * @version Created on 18/04/2011, 07:23:08 PM
 * @author dasolano
 */

public class SampleManageSessionBean extends AbstractSessionBean implements PaginationCoreInterface{
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>

    //Injections
    @EJB
    private SampleManageFacadeRemote sampleManageFacadeRemote;

    @EJB
    private InventoryFacadeRemote inventoryFacadeRemote;

    private SampleDTO sampleDTO = new SampleDTO();
    private HostInformationDTO hostInformationDTO = new HostInformationDTO();
    private EnviromentalDataDTO enviromentalDataDTO = new EnviromentalDataDTO();


    private List<EnviromentalDataDTO> enviromentalDataList = new ArrayList<EnviromentalDataDTO>();

    private List<HostInformationDTO> hostInformationList = new ArrayList<HostInformationDTO>();

    //Objeto que controla la paginacion de la informacion de samples
    private PaginationControllerRemix pagination = null;

    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public SampleManageSessionBean() {
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
            log("SampleManageSessionBean Initialization Failure", e);
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

    public List getResults(int firstResult, int maxResults) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getEnviromentalDataListSize()
    {
        return enviromentalDataList.size();
    }

    public int getHostInformationListSize()
    {
        return hostInformationList.size();
    }

    /**
     * @return the sampleManageFacadeRemote
     */
    public SampleManageFacadeRemote getSampleManageFacadeRemote() {
        return sampleManageFacadeRemote;
    }

    /**
     * @param sampleManageFacadeRemote the sampleManageFacadeRemote to set
     */
    public void setSampleManageFacadeRemote(SampleManageFacadeRemote sampleManageFacadeRemote) {
        this.sampleManageFacadeRemote = sampleManageFacadeRemote;
    }

    /**
     * @return the inventoryFacadeRemote
     */
    public InventoryFacadeRemote getInventoryFacadeRemote() {
        return inventoryFacadeRemote;
    }

    /**
     * @param inventoryFacadeRemote the inventoryFacadeRemote to set
     */
    public void setInventoryFacadeRemote(InventoryFacadeRemote inventoryFacadeRemote) {
        this.inventoryFacadeRemote = inventoryFacadeRemote;
    }

    /**
     * @return the sampleDTO
     */
    public SampleDTO getSampleDTO() {
        return sampleDTO;
    }

    /**
     * @param sampleDTO the sampleDTO to set
     */
    public void setSampleDTO(SampleDTO sampleDTO) {
        this.sampleDTO = sampleDTO;
    }

    /**
     * @return the enviromentalDataList
     */
    public List<EnviromentalDataDTO> getEnviromentalDataList() {
        return enviromentalDataList;
    }

    /**
     * @param enviromentalDataList the enviromentalDataList to set
     */
    public void setEnviromentalDataList(List<EnviromentalDataDTO> enviromentalDataList) {
        this.setEnviromentalDataList(enviromentalDataList);
    }

    /**
     * @return the hostInformationList
     */
    public List<HostInformationDTO> getHostInformationList() {
        return hostInformationList;
    }

    /**
     * @param hostInformationList the hostInformationList to set
     */
    public void setHostInformationList(List<HostInformationDTO> hostInformationList) {
        this.setHostInformationList(hostInformationList);
    }

    /**
     * @return the pagination
     */
    public PaginationControllerRemix getPagination() {
        return pagination;
    }

    /**
     * @param pagination the pagination to set
     */
    public void setPagination(PaginationControllerRemix pagination) {
        this.pagination = pagination;
    }

    /**
     * @return the hostInformationDTO
     */
    public HostInformationDTO getHostInformationDTO() {
        return hostInformationDTO;
    }

    /**
     * @param hostInformationDTO the hostInformationDTO to set
     */
    public void setHostInformationDTO(HostInformationDTO hostInformationDTO) {
        this.hostInformationDTO = hostInformationDTO;
    }

    /**
     * @return the enviromentalDataDTO
     */
    public EnviromentalDataDTO getEnviromentalDataDTO() {
        return enviromentalDataDTO;
    }

    /**
     * @param enviromentalDataDTO the enviromentalDataDTO to set
     */
    public void setEnviromentalDataDTO(EnviromentalDataDTO enviromentalDataDTO) {
        this.enviromentalDataDTO = enviromentalDataDTO;
    }

   

    
}
