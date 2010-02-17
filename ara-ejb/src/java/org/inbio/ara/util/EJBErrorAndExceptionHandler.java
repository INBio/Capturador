/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.util;

import java.lang.reflect.Method;
import java.util.Locale;
import java.util.logging.FileHandler;
import javax.faces.context.FacesContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.TransactionRolledbackLocalException;
import javax.persistence.PersistenceException;
import javax.transaction.TransactionRolledbackException;
import org.hibernate.exception.SQLGrammarException;


/**
 *
 * @author mvargas
 */
public class EJBErrorAndExceptionHandler {

    @AroundInvoke
    public Object handleErrorOrException(InvocationContext invocationContext) throws Exception {
        Class  clas = invocationContext.getTarget().getClass();
        Method method = invocationContext.getMethod();

        // following lines belong to the logger class
        Logger theLogger = Logger.getLogger(EJBErrorAndExceptionHandler.class.getName());
        theLogger.addHandler(new FileHandler("aralog.xml"));
        
        Handler[] handlers = Logger.getLogger("").getHandlers();

        for (int index = 0; index < handlers.length; index++) {
            handlers[index].setLevel(Level.FINE);
        }
        theLogger.setLevel(Level.FINE);

        try {
            // following lines belong to the logger class
            
            return invocationContext.proceed();
        } catch (SQLGrammarException ex) {
            // theLogger.fine("SQLGrammarException exception");
            // System.err.println("SQLGrammarException exception");

            JSFMessage.addErrorMessage("not_yet");

            if ("searchByCriteria".equals(method.getName())) {
                return null;
            } else if ("countSpecimensByCriteria".equals(method.getName())) {
                return new Long(0);
            } else {
                return null;
            }
        } catch (TransactionRolledbackException ex) {
            // theLogger.fine("TransactionRolledbackLocalException exception");
            // System.err.println("TransactionRolledbackLocalException exception");

            JSFMessage.addErrorMessage("not_yet");

            if ("searchByCriteria".equals(method.getName())) {
                return null;
            } else if ("countSpecimensByCriteria".equals(method.getName())) {
                return new Long(0);
            } else {
                return null;
            }
        } catch (PersistenceException ex) {
            // theLogger.fine("Persistence exception");
            // System.err.println("Persistence exception");

            JSFMessage.addErrorMessage("not_yet");

            if ("searchByCriteria".equals(method.getName())) {
                return null;
            } else if ("countSpecimensByCriteria".equals(method.getName())) {
                return new Long(0);
            } else {
                return null;
            }
        } catch (Exception ex) {
            String s = ex.getLocalizedMessage();
            String cl = ex.getClass().getName();

            theLogger.fine(clas.getName());
            theLogger.fine(method.getName());
            // theLogger.fine(ex.toString());
            
            JSFMessage.addErrorMessage("not_yet");

            if ("searchByCriteria".equals(method.getName())) {
                return null;
            } else if ("countSpecimensByCriteria".equals(method.getName())) {
                return new Long(0);
            } else {
                return null;
            }
        }
    }

    public Locale getMyLocale() {
        FacesContext context = FacesContext.getCurrentInstance();
        Locale myLocale = context.getViewRoot().getLocale();
        return myLocale;
    }

}
