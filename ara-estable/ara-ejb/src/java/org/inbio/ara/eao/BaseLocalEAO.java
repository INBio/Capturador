/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao;

import javax.ejb.Local;

/**
 *
 * @author jgutierrez
 */
@Local
public interface BaseLocalEAO {


    /**
     * 
     * @param entityClass
     * @param entityId
     * @return
     */
    public Object findById(Class entityClass, Object entityId);

    /**
     *
     * @param entity
     */
    public void create(Object entity);

    
    /**
     * 
     * @param entityClass
     * @param entityId
     */
    public void delete(Class entityClass, Object entityId);

	/**
     *
     * @param entity
     */
	public void update(Object entity);

}
