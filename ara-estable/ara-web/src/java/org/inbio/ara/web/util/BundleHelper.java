/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.web.util;

import java.util.ResourceBundle;

/**
 *
 * @author asanabria
 */
public class BundleHelper {

	
	private String bundle = null;

	private static String DEFAULT_BUNDLE = "org/inbio/ara/web/resources/global";
	
	public BundleHelper(){
		bundle = DEFAULT_BUNDLE;
	}

	public BundleHelper(String bundleURI){
		bundle = bundleURI;
	}

	public static String getDefaultBundle() {
		return DEFAULT_BUNDLE;
	}

	public String getBundle() {
		return bundle;
	}

	public void setBundle(String bundle) {
		this.bundle = bundle;
	}


	public String getValue(String bundleKey){
		return ResourceBundle.getBundle(this.getBundle()).getString(bundleKey);
	}

	public static String getDefaultBundleValue(String key){
		return ResourceBundle.getBundle(DEFAULT_BUNDLE).getString(key);
	}
}
