/* Ara - capture species and specimen data
 * 
 * Copyright (C) 2009  INBio ( Instituto Naciona de Biodiversidad )
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */ 
/*
 * RecordDataFormManager.java
 *
 * Created on July 25, 2007, 2:40 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.web.uimanagers;

import com.sun.webui.jsf.model.Option;
import java.math.BigDecimal;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.inbio.ara.facade.PredefinedValuesBean;
import org.inbio.ara.facade.PredefinedValuesRemote;
import org.inbio.ara.facade.SpeciesRecordStageFacadeRemote;

/**
 *
 * @author jgutierrez
 */
public class RecordDataFormManager{
    
    PredefinedValuesRemote PVR;
    
    //informacion actual en la tabla --init
    String tableName = "SPECIES_RECORD_STAGE";
    String keyField = "SPECIES_RECORD_STAGE_ID";
    String mainFieldName = "NAME";
    //informacion actual en la tabla --end
    
    /**
     * Holds value of property statuslistOptions.
     */
    private Option[] statuslistOptions;
    
    /**
     * Getter for property statuslistOptions.
     * @return Value of property statuslistOptions.
     */
    public Option[] getStatuslistOptions() {
        return this.statuslistOptions;
    }
    
    /**
     * Setter for property statuslistOptions.
     * @param listOptions New value of property statuslistOptions.
     */
    public void setStatuslistOptions(Option[] options) {
        this.statuslistOptions = options;
    }
    
    /** Creates a new instance of RecordDataFormManager */
    public RecordDataFormManager() {
        //PVR = lookupTheReferencesBean();
        initStatusListOptiones();
    }
    
    //set the options of the registry Status list box
    public void initStatusListOptiones(){
        //List recordStages = PVR.getListBoxValues(this.className, this.keyField2, this.showField);
        //Object[] element;
        
        List recordStages = PVR.getListBoxValuesSQL(this.tableName, this.keyField, this.mainFieldName);
        Vector element;
        
        statuslistOptions = new Option[recordStages.size()];
        
        for( int i=0; i< recordStages.size(); i++ ) {
            element = (java.util.Vector) recordStages.get(i);
            //statuslistOptions[i] = new Option( ((BigDecimal) element[0]).toString(), (String) element[1]);
            statuslistOptions[i] = new Option( ((BigDecimal) element.get(0)).toString(), (String) element.get(1));
        }
    }
    
    /* Helper for calling ejb service . Created by netbeans*/
    /*
    private PredefinedValuesRemote lookupTheReferencesBean() {
        try {
            Context c = new InitialContext();
            return (PredefinedValuesRemote) c.lookup("PredefinedValuesBean");
        } catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
    */
}
