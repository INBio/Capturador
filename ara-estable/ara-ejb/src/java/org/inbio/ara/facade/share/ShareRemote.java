/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.facade.share;

import javax.ejb.Remote;

/**
 *
 * @author esmata
 */
@Remote
public interface ShareRemote {
    
    public org.inbio.ara.persistence.specimen.DwcElement getDwCElementByIdB(java.math.BigDecimal id);

    public java.util.List<org.inbio.ara.persistence.specimen.DwcElement> getDwCElementsB();

    public java.util.List<org.inbio.ara.persistence.specimen.DwcCategory> getDwCCategoriesB();

    public java.lang.String makeDcwSnapshotAll();

    public java.lang.String makeDcwSnapshot(java.util.LinkedList<org.inbio.ara.util.QueryNode> qnlist, java.util.LinkedList<java.lang.String> elist, int validate);

    public java.util.List<org.inbio.ara.persistence.share.PliElement> getPliElementsB();

    public org.inbio.ara.persistence.share.PliElement getPliElementByIdB(java.math.BigDecimal id);

    public java.lang.String createDwCTable();
    
}
