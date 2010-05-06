/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.germplasm.impl;

import java.util.List;
import org.inbio.ara.eao.germplasm.*;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.germplasm.Breed;

/**
 *
 * @author dasolano
 */
@Stateless
public class BreedEAOImpl extends BaseEAOImpl<Breed, Long> implements BreedEAOLocal  {

    public List<Long> findByBreedName(String breedName) {
        Query q = em.createQuery(
                " Select b.breedId " +
                " from Breed b " +
                " where lower(b.name) like '%"+breedName.toLowerCase() +"%'"
               );
        return  q.getResultList();
    }

    public List<Long> findByScientificName(String scientificName) {
        Query q = em.createQuery(
                " Select b.breedId " +
                " from Breed b, Taxon t " +
                " where b.taxonId = t.taxonId and " +
                " lower(t.defaultName) like '%"+ scientificName.toLowerCase() +"%'"
               );
        return  q.getResultList();
    }
    
 
}
