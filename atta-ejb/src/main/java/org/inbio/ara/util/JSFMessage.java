/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.util;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author mvargas
 */
public class JSFMessage {
    private static String bundle = "org/inbio/ara/resources/global";

    public static void addErrorMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage("errorMessage", facesMsg);
    }

    public static void setErrorMessageFromBundle(String key,Locale locale){
        String errorMsj = ResourceBundle.getBundle(bundle,locale).getString(key);
        addErrorMessage(errorMsj);
    }

}
