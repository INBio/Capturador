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
/*
 * SpecimenSessionBean.java
 *
 * Created on 29 de mayo de 2008, 05:22 PM
 * Copyright herson
 */
package org.inbio.ara.web.specimen;

import com.sun.data.provider.RowKey;
import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import com.sun.webui.jsf.model.Option;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.inbio.ara.facade.collection.CollectionRemote;
import org.inbio.ara.facade.gathering.GatheringRemote;
import org.inbio.ara.facade.specimen.SpecimenRemote;
import org.inbio.ara.facade.util.SearchManagerRemote;
import org.inbio.ara.manager.GatheringManagerRemote;
import org.inbio.ara.persistence.specimen.DwcCategory;
import org.inbio.ara.persistence.specimen.DwcElement;
import org.inbio.ara.persistence.specimen.Specimen;
import org.inbio.ara.util.QueryNode;
import org.inbio.ara.web.ApplicationBean1;
import org.inbio.ara.web.AraApplicationBean;
import org.inbio.ara.web.util.BundleHelper;
import org.inbio.ara.web.util.MessageBean;
import org.inbio.ara.web.util.PaginationController;

/**
 * <p>Session scope data bean for your application.  Create properties
 *  here to represent cached data that should be made available across
 *  multiple HTTP requests for an individual user.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 */
public class SpecimenSessionBean extends AbstractSessionBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    private int __placeholder;
    //public SpecimenDataProvider specimenDataProvider = new SpecimenDataProvider();
    //private DwCDataProvider dwcDataProvider = new DwCDataProvider();
    //paginacion de la tabla
    private PaginationController pagination = null;
    private PaginationController paginationInventory = null;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>
    private Specimen currentSpecimen;
    private ArrayList<Specimen> specimenList;
    private boolean inMultipleEdition;
    private boolean isFiltered = false; //usada para la consulta normal
    private boolean isSpecimenInventory = false; //indica si la consulta es para inventario
    private List<QueryNode> query;
    private Hashtable searchCriteria = null;

    //Binding values for PreviewSpecimen.jsp
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private boolean dwcFiltered = false; //usada para el reporte de especimenes
    //private Option[] dwcArray;
    private Object[] dwcSelectedElements;
    private LinkedList<QueryNode> queryList = new LinkedList();
    // </editor-fold>
    @EJB
    private SpecimenRemote specimenBean;

    @EJB
    private GatheringManagerRemote gatheringManager;

    @EJB
    SearchManagerRemote searchManager;

    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public SpecimenSessionBean() {
        //this.currentSpecimen = this.getSpecimenBean().find(1L);
        this.setSpecimenList(new ArrayList<Specimen>());
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
            log("SpecimenSessionBean Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
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
    public void destroy() {
    }

    public Specimen getCurrentSpecimen() {
        return currentSpecimen;
    }

    public void setCurrentSpecimen(Specimen currentSpecimen) {
        this.currentSpecimen = currentSpecimen;
    }

    public void setCurrentSpecimen(RowKey rowKey) {
        this.currentSpecimen = (Specimen) paginationInventory.getDataProvider().getObject(rowKey);
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected AraApplicationBean getAraApplicationBean() {
        return (AraApplicationBean) getBean("AraApplicationBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected MessageBean getutil$MessageBean() {
        return (MessageBean) getBean("util$MessageBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    private SpecimenRemote lookupSpecimenBean() {
        try {
            Context c = new InitialContext();
            return (SpecimenRemote) c.lookup("SpecimenBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public SpecimenRemote getSpecimenBean() {
        return lookupSpecimenBean();
    }

    public void setSpecimenBean(SpecimenRemote specimenBean) {
        this.specimenBean = specimenBean;
    }

    private CollectionRemote lookupCollectionBean() {
        try {
            Context c = new InitialContext();
            return (CollectionRemote) c.lookup("CollectionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public CollectionRemote getCollectionBean() {
        return lookupCollectionBean();
    }

    /*public SpecimenDataProvider getSpecimenDataProvider() {
        return specimenDataProvider;
    }

    public void setSpecimenDataProvider(SpecimenDataProvider specimenDataProvider) {
        this.specimenDataProvider = specimenDataProvider;
    }*/

    public void setSelectedSpecimens(RowKey[] rowKeySet) {
        for (int i = 0; i < rowKeySet.length; i++) {
            specimenList.add((Specimen) paginationInventory.getDataProvider().getObject(rowKeySet[i]));
        }
    }

    public boolean isInMultipleEdition() {
        return inMultipleEdition;
    }

    public void setInMultipleEdition(boolean inMultipleEdition) {
        this.inMultipleEdition = inMultipleEdition;
    }

    public ArrayList<Specimen> getSpecimenList() {
        return specimenList;
    }

    public void setSpecimenList(ArrayList<Specimen> specimenList) {
        this.specimenList = specimenList;
    }

    public GatheringRemote getGatheringBean() {
        return lookupGatheringBean();
    }

    private GatheringRemote lookupGatheringBean() {
        try {
            Context c = new InitialContext();
            return (GatheringRemote) c.lookup("GatheringBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private SearchManagerRemote lookupSearchManagerBean() {
        try {
            Context c = new InitialContext();
            return (SearchManagerRemote) c.lookup("SearchManagerBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public SearchManagerRemote getSearchManager() {
        return this.lookupSearchManagerBean();
    }

    public boolean isIsFiltered() {
        return isFiltered;
    }

    public void setIsFiltered(boolean isFiltered) {
        this.isFiltered = isFiltered;
    }

    public void initDataProvider() {
        //if (!isFiltered) {
            paginationInventory = new PaginationControllerImpl(searchManager.countResult(Specimen.class,getSearchCriteria()).intValue(), 20);
        //}
    }

    public Option[] findDwCElements() {
        /*if (dwcElementsList.size() > 0) {
        Option[] optionArray = new Option[dwcElementsList.size()];
        int i=0;
        for (DwcElement tmp : dwcElementsList) {
        //TODO: internacionalizar el string q viene en el objeto
        //q es el nombre de la columna en la tabla dwc1.4
        optionArray[i] = new Option(tmp.getElementId(), tmp.getElementKeyword());
        i++;
        }
        dwcArray = optionArray;
        return optionArray;
        }
        return null;*/
        List<DwcElement> dwcElements = getSpecimenBean().getDwCElements();
        Option[] dwcElementOptions = new Option[dwcElements.size()];
        int i = 0;
        for (DwcElement dwcElement : dwcElements) {
            dwcElementOptions[i] = new Option(dwcElement.getElementId(),
                                              BundleHelper.getDefaultBundleValue(dwcElement.getElementKeyword()));
            i++;
        }
        return dwcElementOptions;
    }

    public Option[] findDwCCategories() {
        List<DwcCategory> dwcCategoriesList;
        dwcCategoriesList = getSpecimenBean().getDwCCategories();
        if (dwcCategoriesList.size() > 0) {
            Option[] optionArray = new Option[dwcCategoriesList.size()];
            int i = 0;
            for (DwcCategory tmp : dwcCategoriesList) {
                optionArray[i] = new Option(tmp.getCategoryId(), tmp.toString());
                i++;
            }
            return optionArray;
        }
        return null;
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
     * @return the dwcDataProvider
     */
    /*public DwCDataProvider getDwcDataProvider() {
        return dwcDataProvider;
    }*/

    /**
     * @param dwcDataProvider the dwcDataProvider to set
     */
    /*public void setDwcDataProvider(DwCDataProvider dwcDataProvider) {
        this.dwcDataProvider = dwcDataProvider;
    }*/

    /**
     * @return the filtered
     */
    public boolean isFiltered() {
        return dwcFiltered;
    }

    /**
     * @param filtered the filtered to set
     */
    public void setFiltered(boolean dwcFiltered) {
        this.dwcFiltered = dwcFiltered;
    }

    public void initDwCDataProvider() {

        if (!isFiltered()) {
            pagination = new PaginationControllerImpl(gatheringManager.countAllDwC().intValue(), 10);

        } else {
            pagination = new PaginationControllerImpl(gatheringManager.countQueryElements(this.queryList).intValue(), 10);
        }
    }

    /**
     * @return the dwcSelectedElements
     */
    public Object[] getDwcSelectedElements() {
        return dwcSelectedElements;
    }

    /**
     * @param dwcSelectedElements the dwcSelectedElements to set
     */
    public void setDwcSelectedElements(Object[] dwcSelectedElements) {
        this.dwcSelectedElements = dwcSelectedElements;
    }

    public PaginationController getPagination() {
        return pagination;
    }

    public void setPagination(PaginationController pagination) {
        this.pagination = pagination;
    }

    /**
     * @return the searchCriteria
     */
    public Hashtable getSearchCriteria() {
        return searchCriteria;
    }

    /**
     * @param searchCriteria the searchCriteria to set
     */
    public void setSearchCriteria(Hashtable searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    /**
     * @return the isSpecimenInventory
     */
    public boolean isIsSpecimenInventory() {
        return isSpecimenInventory;
    }

    /**
     * @param isSpecimenInventory the isSpecimenInventory to set
     */
    public void setIsSpecimenInventory(boolean isSpecimenInventory) {
        this.isSpecimenInventory = isSpecimenInventory;
    }

    /**
     * @return the paginationInventory
     */
    public PaginationController getPaginationInventory() {
        return paginationInventory;
    }

    /**
     * @param paginationInventory the paginationInventory to set
     */
    public void setPaginationInventory(PaginationController paginationInventory) {
        this.paginationInventory = paginationInventory;
    }

    private class PaginationControllerImpl extends PaginationController {

        public PaginationControllerImpl(int totalResults, int resultsPerPage) {
            super(totalResults, resultsPerPage);
        }

        @Override
        public List getResults(int firstResult, int maxResults) {
            if(isIsSpecimenInventory()){
                System.out.println("Primer Resultado: "+firstResult + " resutlados por página: "+maxResults);
                System.out.println("hola***********////////////---------------");
                return searchManager.makePaginatedQuery(firstResult, maxResults, Specimen.class,getSearchCriteria());
            }
            else if(!isFiltered()) {
                System.out.println("ConteoA: -------> " + this.totalResults);
                return specimenBean.findAllDwCPaginated(firstResult, maxResults);
            }
            else {
                System.out.println("ConteoB: -------> " + this.totalResults);
                return specimenBean.makePaginatedQuery(queryList, firstResult, maxResults);
            }
        }
    }
}