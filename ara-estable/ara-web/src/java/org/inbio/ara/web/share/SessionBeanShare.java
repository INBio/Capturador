/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.web.share;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.FacesException;
import org.inbio.ara.facade.share.ShareRemote;
import org.inbio.ara.persistence.share.PliElement;
import org.inbio.ara.persistence.specimen.DwcCategory;
import org.inbio.ara.persistence.specimen.DwcElement;
import org.inbio.ara.util.QueryNode;
import org.inbio.ara.util.StandardNode;
import org.inbio.ara.web.util.MessageBean;
import org.inbio.ara.web.ApplicationBean1;
import org.inbio.ara.web.AraApplicationBean;

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
 * @version SessionBeanShare.java
 * @version Created on 23/03/2009, 09:02:50 AM
 * @author esmata
 */

public class SessionBeanShare extends AbstractSessionBean {

    //Injection
    @EJB private ShareRemote ShareBR;

    //Variables for binding
    private int result_radio_group = 2;
    private LinkedList<QueryNode> queryList = new LinkedList();
    private LinkedList<QueryNode> queryListPli = new LinkedList();
    private LinkedList<String> elementList = new LinkedList();

    private void _init() throws Exception {
    }

    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public SessionBeanShare() {
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
            log("SessionBeanShare Initialization Failure", e);
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
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected MessageBean getutil$MessageBean() {
        return (MessageBean) getBean("util$MessageBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AraApplicationBean getAraApplicationBean() {
        return (AraApplicationBean) getBean("AraApplicationBean");
    }

    /**
     * @return the result_radio_group
     */
    public int getResult_radio_group() {
        return result_radio_group;
    }

    /**
     * @param result_radio_group the result_radio_group to set
     */
    public void setResult_radio_group(int result_radio_group) {
        this.result_radio_group = result_radio_group;
    }

    /**
     * @return the ShareBR
     */
    public ShareRemote getShareBR() {
        return ShareBR;
    }

    /**
     * @param ShareBR the ShareBR to set
     */
    public void setShareBR(ShareRemote ShareBR) {
        this.ShareBR = ShareBR;
    }

    /*----------------------------------------------------------------------*/
    //Method to retrive the elements of darwin core
    public LinkedList<StandardNode> findDwCElements() {
        List<DwcElement> dwcElements = this.getShareBR().getDwCElementsB();
        LinkedList<StandardNode> tempList = new LinkedList();
        int i = 0;
        for (DwcElement element : dwcElements){
            BigDecimal comboId = element.getElementId();
            String keyword = element.getElementKeyword();
            String selected = element.getElementRequired();
            DwcCategory cat = element.getElementCategoryId();
            String name = element.getElementName();
            StandardNode aux = new StandardNode(comboId,keyword,selected,cat,name);
            tempList.add(aux);
            i++;
        }
        return tempList;
    }

    //Method to retrive the elements of plinian core
    public LinkedList<StandardNode> findPliElements() {
        List<PliElement> pliElements = this.getShareBR().getPliElementsB();
        LinkedList<StandardNode> tempList = new LinkedList();
        int i = 0;
        for (PliElement element : pliElements){
            BigDecimal checkId = element.getElementId();
            String keyword = element.getElementKeyword();
            String selected = element.getElementRequired();
            String name = element.getElementName();
            StandardNode aux = new StandardNode(checkId,keyword,selected,null,name);
            tempList.add(aux);
            i++;
        }
        return tempList;
    }

    //Method to create the darwin core snapshot
    public String createDwcSnapshot(int validate){
        return getShareBR().makeDcwSnapshot(queryList, elementList,validate);
    }

    //Method to create the darwin core snapshot with all information
    public String createDwcSnapshotAll(){
        return getShareBR().makeDcwSnapshotAll();
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
     * @return the queryListPli
     */
    public LinkedList<QueryNode> getQueryListPli() {
        return queryListPli;
    }

    /**
     * @param queryListPli the queryListPli to set
     */
    public void setQueryListPli(LinkedList<QueryNode> queryListPli) {
        this.queryListPli = queryListPli;
    }

    /*----------------------------------------------------------------------*/

}
