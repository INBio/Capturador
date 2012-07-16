/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.taxonomy;

import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionInstitution;

/**
 *
 * @author esmata
 */
@Local
public interface TaxonDescriptionInstitutionEAOLocal 
        extends BaseLocalEAO<TaxonDescriptionInstitution,Long>{

    public void deleteByTaxonDesciptionPK(java.lang.Long taxonId, java.lang.Long taxonDescriptionSequenceId);

    public java.util.List<org.inbio.ara.persistence.taxonomy.TaxonDescriptionInstitution> getTDInstitutionsByTaxonDescription(java.lang.Long taxonId, java.lang.Long taxonDescriptionSequence);
    
}
