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
package org.inbio.ara.taxonomy;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import com.sun.webui.jsf.model.Option;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.FacesException;
import org.inbio.ara.dto.agent.CollectionDTO;
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.dto.inventory.TaxonomicalRangeDTO;
import org.inbio.ara.facade.taxonomy.TaxonomyFacadeRemote;

/**
 * <p>Session scope data bean for the taxonomy module </p>
 *
 * @version Created on 19/11/2009, 10:10:48 AM
 * @author asanabria
 */

public class TaxonomySessionBean extends AbstractSessionBean {
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
	private TaxonomyFacadeRemote taxonomyFacade;

	private Long	 selectedCollection   = null;
	private Long	 taxonId			  = null;
	private String	 taxonName			  = null;
	private Option[] availableCollections = new Option[0];
	private String	 taxonomicalLevel	  = null;

    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public TaxonomySessionBean() {
    }

    /**
     * <p>This method is called when this bean is initially added to
     * session scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * session scope.</p>
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
            log("TaxonomySessionBean Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }

    /**
     * <p>This method is called when the session containing it is about to be
     * passivated.
	 */
    @Override
    public void passivate() {
    }

    /**
     * <p>This method is called when the session containing it was
     * reactivated.</p>
     */
    @Override
    public void activate() {
    }

    /**
     * <p>This method is called when this bean is removed from
     * session scope.  Typically, this occurs as a result of
     */
    @Override
    public void destroy() {
    }

	/**
	 * return a List with all the biological collections available in the 
	 * database
	 * @return List<CollectionDTO>
	 */
	public List<CollectionDTO> getAllCollections(){
		return taxonomyFacade.getAllCollections();
	}

	/**
	 * Return all the taxon in the specified taxonomical hierarchy level.
	 * @return List<TaxonDTO>
	 */
	public List<TaxonDTO> getAllTaxonByRange(Long taxonId){
		return taxonomyFacade.getAllTaxonByRange(taxonId);
	}

	/**
	 * returns a list with the taxa in the next hierarchy level under the
	 * taxon specified by the parameter
	 * @param taxonId
	 * @return List<TaxonDTO>
	 */
	public List<TaxonDTO> getTaxonChildren(Long taxonId){
		return taxonomyFacade.getTaxonChildren(taxonId);
	}

	/**
	 * return the taxa number in the next hierarchy level under the taxon 
	 * specified by taxonId
	 * @param taxonId
	 * @return
	 */
	public Long getTaxonChildrenCount(Long taxonId){
		return taxonomyFacade.getTaxonChildrenCount(taxonId);
	}

	/**
	 * Return the number of specimens associated to the selected taxa
	 * @return
	 */
	public Long getAssociatedSpecimenCount(Long taxonId){
		return taxonomyFacade.getAssociatedSpecimenCount(taxonId);
	}

    /**
     * Check if a specific taxon has associated nomenclatural groups
     * @param taxonId
     * @return
     */
    public Long getAssociatedNumenclaturalG(Long taxonId){
        Long aux = taxonomyFacade.getAssociatedNumenclaturalG(taxonId);
        if(aux==null)
            return 0L;
        else
            return aux;
    }

	/**
	 * Returns the taxon information corresponding to the specified taxon.
	 * @param taxonId
	 * @return TaxonDTO
	 */
	public TaxonDTO getTaxon(Long taxonId){
		return taxonomyFacade.getTaxon(taxonId);
	}

	/**
	 * Returns the name of the given taxonomical range.
	 * @param taxonId
	 * @return
	 */
	public String getTaxonRangeName(Long taxonRangeId){
		TaxonomicalRangeDTO aTRDTO = taxonomyFacade.getTaxonRangeName(taxonRangeId);
		return aTRDTO.getName();
	}


	/**
	 * return the next Mandatory Taxonomomical level (top-down direction)
	 *
	 * top = first
	 *
	 * @param taxonomicalLevel
	 * @return
	 */
	public Long getNextMandatoryTaxonomicalLevel(Long ancestorTaxonomicalLevel){
		return taxonomyFacade.getNextMandatoryTaxonomicalLevel(ancestorTaxonomicalLevel);
	}

    /**
     * Send to persis a TaxonDTO to the database
     * @param aDTO
     */
    public void saveTaxon(TaxonDTO aDTO){
        this.taxonomyFacade.saveTaxon(aDTO);
    }

    /**
     * Delete the taxon identified by taxonId
     * @param taxonId
     */
    public void removeTaxon(Long taxonId){
        this.taxonomyFacade.deleteTaxon(taxonId);
    }

	/* Getters and Setters */

	public Option[] getAvailableCollections() {
		return availableCollections;
	}

	public void setAvailableCollections(Option[] availableCollections) {
		this.availableCollections = availableCollections;
	}

	public Long getSelectedCollection() {
		return selectedCollection;
	}

	public void setSelectedCollection(Long selectedCollection) {
		this.selectedCollection = selectedCollection;
	}

	public Long getTaxonId() {
		return taxonId;
	}

	public void setTaxonId(Long taxonId) {
		this.taxonId = taxonId;
	}

	public String getTaxonName() {
		return taxonName;
	}

	public void setTaxonName(String taxonName) {
		this.taxonName = taxonName;
	}

	public String getTaxonomicalLevel() {
		return taxonomicalLevel;
	}

	public void setTaxonomicalLevel(String taxonomicalLevel) {
		this.taxonomicalLevel = taxonomicalLevel;
	}

	public TaxonomyFacadeRemote getTaxonomyFacade() {
		return taxonomyFacade;
	}

	public void setTaxonomyFacade(TaxonomyFacadeRemote taxonomyFacade) {
		this.taxonomyFacade = taxonomyFacade;
	}
}
