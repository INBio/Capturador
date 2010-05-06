/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.germplasm;

import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.germplasm.Breed;

/**
 *
 * @author dasolano
 */
@Local
public interface BreedEAOLocal extends BaseLocalEAO<Breed ,Long> {

    public List<Long> findByBreedName(String breedName);

    public List<Long> findByScientificName(String scientificName);
}
