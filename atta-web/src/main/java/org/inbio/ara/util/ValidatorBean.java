/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Nacional de Biodiversidad)
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

package org.inbio.ara.util;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import javax.faces.FacesException;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.inbio.ara.AraSessionBean;

/**
 * <p>Session scope data bean for your application.  Create properties
 *  here to represent cached data that should be made available across
 *  multiple HTTP requests for an individual user.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 *
 * @version ValidatorBean.java
 * @version Created on 14/08/2009, 11:52:03 AM
 * @author esmata
 */

public class ValidatorBean extends AbstractSessionBean implements Serializable{

    //Contexto utilizado para obtener el current locale
    private FacesContext context;
    private Locale myLocale;
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>

    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public ValidatorBean() {
    }

    /**
     * To validate Double formats
     * @param context
     * @param component
     * @param value
     */
    public void doubleNumberFormatValidator(FacesContext context, UIComponent component, Object value) {
        if(value!=null){
            try{
                Double.valueOf((String)value);
            }catch(NumberFormatException nfe){
                throw new ValidatorException(new FacesMessage(BundleHelper.getDefaultBundleValue("errWrongNumber",this.getMyLocale())));
            }
        }
	}

    /**
     * To validate Long formats
     * @param context
     * @param component
     * @param value
     */
    public void longNumberFormatValidator(FacesContext context, UIComponent component, Object value) {
        if(value!=null){
            try{
                Long.valueOf((String)value);
            }catch(NumberFormatException nfe){
                throw new ValidatorException(new FacesMessage(BundleHelper.getDefaultBundleValue("errWrongNumber",this.getMyLocale())));
            }
        }
	}

    /**
     * To validate emails
     * @param context
     * @param component
     * @param value
     */
    public void txt_email_validate(FacesContext context, UIComponent component, Object value) {
		Pattern pattern = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
		Matcher matcher = pattern.matcher((String)value);

		if (!matcher.matches()){
			throw new ValidatorException(new FacesMessage(BundleHelper.getDefaultBundleValue("errWrongEmail",this.getMyLocale())));
		}
	}

   /**
    * To validate year format
    * @param context
    * @param component
    * @param value
    */
	public void year_validate(FacesContext context, UIComponent component, Object value) {
		Pattern pattern = Pattern.compile("[1-9][0-9][0-9][0-9]");
		Matcher matcher = pattern.matcher((String)value);
		int intValue = Integer.parseInt((String)value);
		if (!matcher.matches()){
			throw new ValidatorException(new FacesMessage(BundleHelper.getDefaultBundleValue("errWrongYear",this.getMyLocale())));
		}else if(intValue < 1900){
			throw new ValidatorException(new FacesMessage(BundleHelper.getDefaultBundleValue("errWrongYear",this.getMyLocale())));
		}
	}

    /**
     * To validate correct url formats
     * @param context
     * @param component
     * @param value
     */
	public void url_validate(FacesContext context, UIComponent component, Object value) {
		try{
			URL url = new URL((String)value);
		}catch(MalformedURLException e){
			throw new ValidatorException(new FacesMessage(BundleHelper.getDefaultBundleValue("errWrongURL",this.getMyLocale())));
		}
	}

    /**
     * To validate the phone number format
     * @param context
     * @param component
     * @param value
     */
	public void telephone_validate(FacesContext context, UIComponent component, Object value) {
		Pattern pattern = Pattern.compile("[0-9)(\\- ]*");
		Matcher matcher = pattern.matcher((String)value);
		if (!matcher.matches()){
			throw new ValidatorException(new FacesMessage(BundleHelper.getDefaultBundleValue("errWrongTelephone",this.getMyLocale())));
		}
	}

    /**
     * To validate the catalog number
     * @param context
     * @param txtField
     * @param value
     */
    public void validateInputCatalog(FacesContext context,UIComponent txtField, Object value) {
        try{
            validateInputString(context, txtField, value);
        } catch (Exception e) {
            throw new ValidatorException(new FacesMessage(BundleHelper.getDefaultBundleValue("error_catalog_field",this.getMyLocale())));
        }
    }

    /**
     * To validate the taxon name
     * @param context
     * @param txtField
     * @param value
     */
    public void validateInputTaxon(FacesContext context,UIComponent txtField, Object value) {
        try{
            validateInputString(context, txtField, value);
        } catch (Exception e) {
            throw new ValidatorException(new FacesMessage(BundleHelper.getDefaultBundleValue("error_taxon_field",this.getMyLocale())));
        }
    }

    /**
     * To validate generic strings
     * @param context
     * @param txtField
     * @param value
     */
    public void validateInputStringGeneric(FacesContext context,UIComponent txtField, Object value) {
        try{
            validateInputString(context, txtField, value);
        } catch (Exception e) {
            throw new ValidatorException(new FacesMessage(BundleHelper.getDefaultBundleValue("error_generic_field",this.getMyLocale())));
        }
    }

/*******************************************************************************
 * String input validation. This method is private because it is called by other
 * speciallized methods below for each type of input.
 * @param context
 * @param txtField
 * @param value
 ******************************************************************************/
    private void validateInputString(FacesContext context,UIComponent component, Object value) throws Exception {
        Pattern pattern = Pattern.compile("[0-9a-zA-ZáéíóúÁÉÍÓÚñÑ,.\\-\\s]*");
        Matcher matcher = pattern.matcher((String)value);
        if(!matcher.matches()) {
            throw new Exception();
        }
    }

    /**
     * <p>This method is called when this bean is initially added to
     * session scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * session scope.</p>
     * 
     * <p>You may customize this method to initialize and cache data values
     * or resources that are required for the lifetime of a particular
     * user session.</p>
     */
    @Override
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
        
        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("ValidatorBean Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }

    /**
     * <p>This method is called when the session containing it is about to be
     * passivated.  Typically, this occurs in a distributed servlet container
     * when the session is about to be transferred to a different
     * container instance, after which the <code>activate()</code> method
     * will be called to indicate that the transfer is complete.</p>
     * 
     * <p>You may customize this method to release references to session data
     * or resources that can not be serialized with the session itself.</p>
     */
    @Override
    public void passivate() {
    }

    /**
     * <p>This method is called when the session containing it was
     * reactivated.</p>
     * 
     * <p>You may customize this method to reacquire references to session
     * data or resources that could not be serialized with the
     * session itself.</p>
     */
    @Override
    public void activate() {
    }

    /**
     * <p>This method is called when this bean is removed from
     * session scope.  Typically, this occurs as a result of
     * the session timing out or being terminated by the application.</p>
     * 
     * <p>You may customize this method to clean up resources allocated
     * during the execution of the <code>init()</code> method, or
     * at any later time during the lifetime of the application.</p>
     */
    @Override
    public void destroy() {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AraSessionBean getAraSessionBean() {
        return (AraSessionBean) getBean("AraSessionBean");
    }

    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
		return this.getAraSessionBean().getCurrentLocale();
    }
    
}
