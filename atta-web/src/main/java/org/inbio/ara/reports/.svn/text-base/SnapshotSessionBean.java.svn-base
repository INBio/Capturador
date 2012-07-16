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

package org.inbio.ara.reports;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.FacesException;
import org.inbio.ara.dto.reports.DwcCategoryDTO;
import org.inbio.ara.dto.reports.DwcElementDTO;
import org.inbio.ara.facade.reports.ReportsFacadeRemote;
import org.inbio.ara.util.QueryNode;
import org.inbio.ara.util.StandardNode;

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
 * @version SnapshotSessionBean.java
 * @version Created on 05/11/2009, 10:46:26 AM
 * @author esmata
 */

public class SnapshotSessionBean extends AbstractSessionBean {
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
    private ReportsFacadeRemote reportsFacade;

    //Seleccion del estandar a utilizar
    private int resultRadioGroup = 2;

    private LinkedList<QueryNode> queryList = new LinkedList();
    private LinkedList<String> elementList = new LinkedList();

    private File currentFile;

    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public SnapshotSessionBean() {
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
            log("SnapshotSessionBean Initialization Failure", e);
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

    //Method to retrive the elements of darwin core
    public LinkedList<StandardNode> findDwCElements() {
        List<DwcElementDTO> dwcElements = this.getReportsFacade().findDwCElements();
        LinkedList<StandardNode> tempList = new LinkedList();
        int i = 0;
        for (DwcElementDTO element : dwcElements){
            Long comboId = element.getElementId();
            String keyword = element.getElementKeyword();
            String selected = element.getElementRequired();

            Long catId = element.getElementCategoryId();
            DwcCategoryDTO cat = this.getReportsFacade().findDwcCategoryById(catId);

            String name = element.getElementName();
            StandardNode aux = new StandardNode(comboId,keyword,selected,cat,name);
            tempList.add(aux);
            i++;
        }
        return tempList;
    }

    //Method to create the darwin core snapshot with all information
    public boolean createDwcSnapshot(){
        return reportsFacade.makeDcwSnapshotNative(queryList, elementList);
    }

    //Method to create the plinian core snapshot with all information
    public boolean createPlicSnapshot(){
        return reportsFacade.makePlicSnapshotNative(queryList, elementList);
    }

    /**
     * @return the resultRadioGroup
     */
    public int getResultRadioGroup() {
        return resultRadioGroup;
    }

    /**
     * @param resultRadioGroup the resultRadioGroup to set
     */
    public void setResultRadioGroup(int resultRadioGroup) {
        this.resultRadioGroup = resultRadioGroup;
    }

    /**
     * @return the queryList
     */
    public LinkedList<QueryNode> getQueryList() {
        return queryList;
    }

    /**
     * @param queryList the queryList to set
     */
    public void setQueryList(LinkedList<QueryNode> queryList) {
        this.queryList = queryList;
    }

    /**
     * @return the reportsFacade
     */
    public ReportsFacadeRemote getReportsFacade() {
        return reportsFacade;
    }

    /**
     * @param reportsFacade the reportsFacade to set
     */
    public void setReportsFacade(ReportsFacadeRemote reportsFacade) {
        this.reportsFacade = reportsFacade;
    }

    /**
     * @return the elementList
     */
    public LinkedList<String> getElementList() {
        return elementList;
    }

    /**
     * @param elementList the elementList to set
     */
    public void setElementList(LinkedList<String> elementList) {
        this.elementList = elementList;
    }

    /**
     * @return the currentFile
     */
    public File getCurrentFile() {
        return currentFile;
    }

    /**
     * @param currentFile the currentFile to set
     */
    public void setCurrentFile(File currentFile) {
        this.currentFile = currentFile;
    }
    
}
