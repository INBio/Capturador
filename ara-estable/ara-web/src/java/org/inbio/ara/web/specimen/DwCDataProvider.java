/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.web.specimen;

import com.sun.data.provider.impl.ObjectListDataProvider;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.inbio.ara.facade.specimen.SpecimenRemote;
import org.inbio.ara.persistence.specimen.DarwinCore14;

/**
 *
 * @author herson
 */
public class DwCDataProvider extends ObjectListDataProvider {
    /** Creates a new instance of InstitutionDataProvider */
    public DwCDataProvider() {
        this.setObjectType(DarwinCore14.class);
        refreshDataList();
    }

    public void refreshDataList() {
        this.setList(lookupSpecimenBean().findAllDwC());
    }

    private SpecimenRemote lookupSpecimenBean() {
        try {
            Context c = new InitialContext();
            return (SpecimenRemote) c.lookup("SpecimenBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
}
