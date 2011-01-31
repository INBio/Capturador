/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.taxonomy;

import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.taxonomy.TaxonDescription;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionPK;

/**
 *
 * @author esmata
 */
@Local
public interface TaxonDescriptionEAOLocal extends BaseLocalEAO<TaxonDescription,Long>{

    public java.lang.Long countByPK();

    public org.inbio.ara.persistence.taxonomy.TaxonDescription findByPK(java.lang.Long taxonId, java.lang.Long sequence);

    public List<TaxonDescriptionPK> findByTaxonName(String taxonName);

    public List<TaxonDescriptionPK> findByKingdomId(Long kingdomId);

    public List<TaxonDescriptionPK> findByFamilyId(Long familyId);

    public List<TaxonDescriptionPK> findByCreatedBy(String createdBy);

    public List<TaxonDescriptionPK> findBySequence(Long sequence);
    
}
