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
 * NomenclaturalGroupSessionBean.java
 *
 * Created on June 28, 2008, 1:57 PM
 * Copyright roaguilar
 */
package org.inbio.ara.web.nomenclaturalgroup;

import com.sun.data.provider.RowKey;
import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import com.sun.webui.jsf.model.Option;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FacesException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.inbio.ara.facade.taxonomy.NomenclaturalGroupRemote;
import org.inbio.ara.persistence.taxonomy.NomenclaturalGroup;
import org.inbio.ara.web.ApplicationBean1;
import org.inbio.ara.web.AraApplicationBean;
import org.inbio.ara.web.SessionManager;
import org.inbio.ara.web.util.MessageBean;
import org.inbio.ara.web.util.SelectionListBean;

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
public class NomenclaturalGroupSessionBean extends AbstractSessionBean {
	// <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
	private int __placeholder;
	private NomenclaturalGroupDataProvider nomenclaturalGroupDataProvider = new NomenclaturalGroupDataProvider();
	private Option[] certificatorPersonOption;
	private Option[] collectionOption;
	private Option[] taxonOption;
	private Option[] regionOption;
	private Long selectedCertificator = -1L;
	private Long selectedCollection = -1L;
	private Long[] selectedTaxon;
	private Long[] selectedRegion;
	private boolean editMode;
	private NomenclaturalGroup nomenclaturalGroup;

	/**
	 * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
	 * This method is automatically generated, so any user-specified code inserted
	 * here is subject to being replaced.</p>
	 */
	private void _init() throws Exception {
	}
	// </editor-fold>

	/**
	 * <p>Construct a new session data bean instance.</p>
	 */
	public NomenclaturalGroupSessionBean() {
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
			log("NomenclaturalGroupSessionBean Initialization Failure", e);
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

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 */
	protected AraApplicationBean getAraApplicationBean() {
        return (AraApplicationBean)getBean("AraApplicationBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 */
	protected MessageBean getutil$MessageBean() {
        return (MessageBean)getBean("util$MessageBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 */
	protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1)getBean("ApplicationBean1");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 */
	protected SelectionListBean getutil$SelectionListBean() {
        return (SelectionListBean)getBean("util$SelectionListBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 */
	protected SessionManager getSessionManager() {
        return (SessionManager)getBean("SessionManager");
	}

	public NomenclaturalGroupDataProvider getNomenclaturalGroupDataProvider() {
		return nomenclaturalGroupDataProvider;
	}

	public void setNomenclaturalGroupDataProvider(NomenclaturalGroupDataProvider nomenclaturalGroupDataProvider) {
		this.nomenclaturalGroupDataProvider = nomenclaturalGroupDataProvider;
	}

	public Option[] getCertificatorPersonOption() {
		return certificatorPersonOption;
	}

	public void setCertificatorPersonOption(Option[] certificatorPersonOption) {
		this.certificatorPersonOption = certificatorPersonOption;
	}

	public Option[] getCollectionOption() {
		return collectionOption;
	}

	public void setCollectionOption(Option[] collectionOption) {
		this.collectionOption = collectionOption;
	}

	public Option[] getTaxonOption() {
		return taxonOption;
	}
    
	public void setTaxonOption(Option[] taxonOption) {
		this.taxonOption = taxonOption;
	}

	public Option[] getRegionOption() {
		return regionOption;
	}

	public void setRegionOption(Option[] regionOption) {
		this.regionOption = regionOption;
	}

	public Long getSelectedCertificator() {
		return selectedCertificator;
	}

	public void setSelectedCertificator(Long selectedCertificator) {
		this.selectedCertificator = selectedCertificator;
	}

	public Long getSelectedCollection() {
		return selectedCollection;
	}

	public void setSelectedCollection(Long selectedCollection) {
		this.selectedCollection = selectedCollection;
	}

	public Long[] getSelectedTaxon() {
		return selectedTaxon;
	}

	public void setSelectedTaxon(Long[] selectedTaxon) {
		this.selectedTaxon = selectedTaxon;
	}

	public Long[] getSelectedRegion() {
		return selectedRegion;
	}

	public void setSelectedRegion(Long[] selectedRegion) {
		this.selectedRegion = selectedRegion;
	}

    public void populateList() {
        this.collectionOption = this.getutil$SelectionListBean().getCollection();
        this.certificatorPersonOption = this.getutil$SelectionListBean().getNomenclaturalGroupCertificator();
        if (this.getSelectedCollection()!=null) {
            if (this.getSelectedCollection() > 0L) {
                this.setTaxonOption(this.getutil$SelectionListBean().getTaxonByCollection(this.getSelectedCollection()));
            }
        }
        this.regionOption = this.getutil$SelectionListBean().getRegion();
    }

    public boolean create(NomenclaturalGroup nomenclaturalGroup) {
        nomenclaturalGroup.setCollection(this.getutil$SelectionListBean().getCollectionById(this.getSelectedCollection()));
		if (this.getSelectedCertificator() == -1l) {
			nomenclaturalGroup.setPerson(null);
		} else {
			nomenclaturalGroup.setPerson(this.getutil$SelectionListBean().getPerson(this.getSelectedCertificator()));
		}
		nomenclaturalGroup.setCreatedBy(this.getSessionManager().getUser().getUserName());
        nomenclaturalGroup.setLastModificationBy(this.getSessionManager().getUser().getUserName());
        if (this.lookupNomenclaturalGroupBean().create(nomenclaturalGroup, this.getSelectedTaxon(), this.getSelectedRegion())) {
            initValues();
            return true;
        } else {
            MessageBean.addErrorMessage(this.lookupNomenclaturalGroupBean().getMessage());
            return false;
        }
    }

	public boolean update(NomenclaturalGroup nomenclaturalGroup) {
		nomenclaturalGroup.setCollection(this.getutil$SelectionListBean().getCollectionById(this.getSelectedCollection()));
		if (this.getSelectedCertificator() == -1l) {
			nomenclaturalGroup.setPerson(null);
		} else {
			nomenclaturalGroup.setPerson(this.getutil$SelectionListBean().getPerson(this.getSelectedCertificator()));
		}

		nomenclaturalGroup.setLastModificationBy(this.getSessionManager().getUser().getUserName());
		if (this.lookupNomenclaturalGroupBean().update(nomenclaturalGroup, this.getSelectedTaxon(), this.getSelectedRegion())) {
			initValues();
			return true;
		} else {
            MessageBean.addErrorMessage(this.lookupNomenclaturalGroupBean().getMessage());
			return false;
		}
	}

	private NomenclaturalGroupRemote lookupNomenclaturalGroupBean() {
		try {
			Context c = new InitialContext();
			return (NomenclaturalGroupRemote) c.lookup("NomenclaturalGroupBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
			throw new RuntimeException(ne);
		}
	}

	private void initValues() {
		this.certificatorPersonOption = null;
		this.collectionOption = null;
		this.regionOption = null;
		this.selectedCertificator = -1l;
		this.selectedCollection = -1l;
		this.selectedRegion = null;
		this.selectedTaxon = null;
	}

	public void setNomenclaturalGroup(RowKey rowKey) {
		this.nomenclaturalGroup = (NomenclaturalGroup) this.getNomenclaturalGroupDataProvider().getObject(rowKey);
		if (this.getNomenclaturalGroup().getPerson() != null) {
			this.selectedCertificator = this.getNomenclaturalGroup().getPerson().getId();
		}
		this.selectedCollection = this.getNomenclaturalGroup().getCollection().getId();
		this.selectedTaxon = this.lookupNomenclaturalGroupBean().getTaxonArray(this.getNomenclaturalGroup().getId());
		this.selectedRegion = this.lookupNomenclaturalGroupBean().getRegionArray(this.getNomenclaturalGroup().getId());
	}

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	public NomenclaturalGroup getNomenclaturalGroup() {
		return nomenclaturalGroup;
	}

	public void delete(RowKey rowKey) {
		if (rowKey != null) {
            NomenclaturalGroup nomenclaturalGroup = (NomenclaturalGroup)this.getNomenclaturalGroupDataProvider().getObject(rowKey);
			if (this.lookupNomenclaturalGroupBean().delete(nomenclaturalGroup.getId())) {
                MessageBean.setSuccessMessageFromBundle("deletion_success");
			} else {
                MessageBean.addSuccessMessage("Error al borrar el registro: " + lookupNomenclaturalGroupBean().getMessage());
			}
		} else {
			System.out.println("rowKey es nulo.");
		}
	}
}
