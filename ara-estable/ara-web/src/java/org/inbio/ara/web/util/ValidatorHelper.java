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

package org.inbio.ara.web.util;

import com.sun.rave.web.ui.appbase.AbstractApplicationBean;
import com.sun.webui.jsf.component.TextField;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.faces.FacesException;

/**
 *
 * @author jgutierrez
 */
public class ValidatorHelper extends AbstractApplicationBean {


    public void integerNumberFormatValidator(FacesContext context, UIComponent component, Object value) {

        try{
            Integer i = Integer.valueOf((String)value);
		}catch(NumberFormatException nbe){
			throw new ValidatorException(new FacesMessage(BundleHelper.getDefaultBundleValue("errWrongIntegerNumber")));
		}
	}

    public void longNumberFormatValidator(FacesContext context, UIComponent component, Object value) {
        
        try{
            Long l = Long.valueOf((String)value);
		}catch(NumberFormatException nbe){
			throw new ValidatorException(new FacesMessage(BundleHelper.getDefaultBundleValue("errWrongLongNumber")));
		}
	}

   public void txt_email_validate(FacesContext context, UIComponent component, Object value) {

		Pattern pattern = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
		Matcher matcher = pattern.matcher((String)value);

		if (!matcher.matches()){
			throw new ValidatorException(new FacesMessage(BundleHelper.getDefaultBundleValue("errWrongEmail")));
		}
	}

	public void year_validate(FacesContext context, UIComponent component, Object value) {

		Pattern pattern = Pattern.compile("[1-9][0-9][0-9][0-9]");
		Matcher matcher = pattern.matcher((String)value);

		int intValue = Integer.parseInt((String)value);

		if (!matcher.matches()){
			throw new ValidatorException(new FacesMessage(BundleHelper.getDefaultBundleValue("errWrongYear")));
		}else if(intValue < 1900){
			throw new ValidatorException(new FacesMessage(BundleHelper.getDefaultBundleValue("errWrongYear")));
		}
	}

	public void url_validate(FacesContext context, UIComponent component, Object value) {

		try{
			URL url = new URL((String)value);
		}catch(MalformedURLException e){
			throw new ValidatorException(new FacesMessage(BundleHelper.getDefaultBundleValue("errWrongURL")));
		}
	}

	public void telephone_validate(FacesContext context, UIComponent component, Object value) {

		Pattern pattern = Pattern.compile("[0-9)(\\- ]*");
		Matcher matcher = pattern.matcher((String)value);

		if (!matcher.matches()){
			throw new ValidatorException(new FacesMessage(BundleHelper.getDefaultBundleValue("errWrongTelephone")));
		}
	}

/*******************************************************************************
 * Number input validation. This method is private because it is called by other
 * speciallized methods below for each type of input.
 * @param context
 * @param txtField
 * @param value
 ******************************************************************************/
    private void validateTextFieldInputNumber(FacesContext context,
                        UIComponent txtField, Object value) throws Exception {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher matcher = pattern.matcher((String)value);
        if(!matcher.matches()) {
            throw new Exception();
        }
    }

    public void validateTextFieldInputId(FacesContext context,
                                        UIComponent txtField, Object value) {
        try{
            validateTextFieldInputNumber(context, txtField, value);
        } catch (Exception e) {
            throw new ValidatorException(new FacesMessage(BundleHelper.
                                            getDefaultBundleValue("id_error")));
        }
    }

    public void validateTextFieldInputSequence(FacesContext context,
                                        UIComponent txtField, Object value) {
        try{
            validateTextFieldInputNumber(context, txtField, value);
        } catch (Exception e) {
            throw new ValidatorException(new FacesMessage(BundleHelper.
                                    getDefaultBundleValue("sequence_error")));
        }
    }

    public void validateTextFieldInputType(FacesContext context,
                                        UIComponent txtField, Object value) {
        try{
            validateTextFieldInputNumber(context, txtField, value);
        } catch (Exception e) {
            throw new ValidatorException(new FacesMessage(BundleHelper.
                                getDefaultBundleValue("type_language_error")));
        }
    }
/*******************************************************************************
 *******************************************************************************
 ******************************************************************************/

/*******************************************************************************
 * String input validation. This method is private because it is called by other
 * speciallized methods below for each type of input.
 * @param context
 * @param txtField
 * @param value
 ******************************************************************************/
    private void validateTextFieldInputString(FacesContext context,
                        UIComponent txtField, Object value) throws Exception {
        Pattern pattern = Pattern.compile("[0-9a-zA-ZáéíóúÁÉÍÓÚñÑ. -]*");
        Matcher matcher = pattern.matcher((String)value);
        if(!matcher.matches()) {
            throw new Exception();
        }
    }

    public void validateTextFieldInputTaxon(FacesContext context,
                                        UIComponent txtField, Object value) {
        try{
            validateTextFieldInputString(context, txtField, value);
        } catch (Exception e) {
            throw new ValidatorException(new FacesMessage(BundleHelper.
                                getDefaultBundleValue("error_taxon_field")));
        }
    }

    public void validateTextFieldInputIdentifier(FacesContext context,
                                        UIComponent txtField, Object value) {
        try{
            validateTextFieldInputString(context, txtField, value);
        } catch (Exception e) {
            throw new ValidatorException(new FacesMessage(BundleHelper.
                            getDefaultBundleValue("error_identifier_field")));
        }
    }

/*******************************************************************************
 *******************************************************************************
 ******************************************************************************/

    /**
     * <p>This method is called when this bean is initially added to
     * application scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * application scope.</p>
     *
     * <p>You may customize this method to initialize and cache application wide
     * data values (such as the lists of valid options for dropdown list
     * components), or to allocate resources that are required for the
     * lifetime of the application.</p>
     */
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
// Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
// <editor-fold defaultstate="collapsed" desc="Visual-Web-managed Component Initialization">
// Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("Page1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }
    }

    /**
     * <p>This method is called when this bean is removed from
     * application scope.  Typically, this occurs as a result of
     * the application being shut down by its owning container.</p>
     *
     * <p>You may customize this method to clean up resources allocated
     * during the execution of the <code>init()</code> method, or
     * at any later time during the lifetime of the application.</p>
     */
    public void destroy() {
    }

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() {
    }

}
