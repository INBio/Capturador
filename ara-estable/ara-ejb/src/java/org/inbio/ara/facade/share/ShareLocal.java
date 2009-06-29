/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.facade.share;

import javax.ejb.Local;

/**
 *
 * @author esmata
 */
@Local
public interface ShareLocal {

    public java.lang.String makeQueryString(java.util.LinkedList<org.inbio.ara.util.QueryNode> llqn, java.util.LinkedList<java.lang.String> lls, int validate);

    public java.lang.String taxonAuthorList(java.lang.Long tId, int form, java.lang.Long year, java.lang.Long parentesis);

    public java.lang.String makeQueryStringPostgres(java.util.LinkedList<org.inbio.ara.util.QueryNode> llqn, java.util.LinkedList<java.lang.String> lls);
    
}
