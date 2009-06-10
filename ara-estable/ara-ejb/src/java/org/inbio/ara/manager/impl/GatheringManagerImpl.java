/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inbio.ara.manager.impl;

import java.util.LinkedList;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.FlushModeType;
import javax.persistence.Query;
import org.inbio.ara.eao.ShareEAOLocal;
import org.inbio.ara.manager.GatheringManagerRemote;
import org.inbio.ara.util.QueryNode;

/**
 *
 * @author asanabria
 */
@Stateless
public class GatheringManagerImpl implements GatheringManagerRemote {

    @EJB
    ShareEAOLocal shareBean;

    @Override
    public Long countQueryElements(LinkedList<QueryNode> sll) {


        String jpqlQuery = "select count(o) from DarwinCore14 as o where ";

        //Mandatory
        QueryNode qn = sll.getFirst();
        jpqlQuery += "lower(o." + qn.getDwcElement() + ")";
        jpqlQuery += " " + qn.getComparator() + " ";
        if (qn.getComparator().equals("like")) {
            jpqlQuery += "'%" + qn.getUserEntry().toLowerCase() + "%'";
        } else {
            jpqlQuery += "'" + qn.getUserEntry().toLowerCase() + "'";
        }

        //Optional
        for (int i = 1; i < sll.size(); i++) {
            qn = sll.get(i);
            jpqlQuery += " " + qn.getLogicalOperator() + " ";
            jpqlQuery += "lower(o." + qn.getDwcElement() + ")";
            jpqlQuery += " " + qn.getComparator() + " ";
            if (qn.getComparator().equals("like")) {
                jpqlQuery += "'%" + qn.getUserEntry().toLowerCase() + "%'";
            } else {
                jpqlQuery += "'" + qn.getUserEntry().toLowerCase() + "'";
            }
        }
        
        return shareBean.countQueryElements(jpqlQuery);

    }

    @Override
    public Long countAllDwC() {
        return shareBean.findTotalDwc();
    }
}
