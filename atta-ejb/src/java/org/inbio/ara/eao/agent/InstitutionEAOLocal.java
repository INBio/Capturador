/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.agent;

import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.institution.Institution;

/**
 *
 * @author jgutierrez
 */
@Local
public interface InstitutionEAOLocal extends BaseLocalEAO<Institution,Long>{

    public java.util.List<org.inbio.ara.dto.agent.InstitutionDTO> getAllInstitutions();

    public java.util.List<org.inbio.ara.persistence.institution.Institution> getInstitutionsByPerson(java.lang.Long personId);

    public java.util.List<org.inbio.ara.persistence.institution.Institution> getInstitutionsByTaxonDescription(java.lang.Long taxonId, java.lang.Long taxonDescriptionSequence);

    public java.util.List<org.inbio.ara.persistence.institution.Institution> getInstitutionsByInstitutionCode(String institutionCode);
    
}
