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

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author asanabria
 * @author esmata Se agrego la propiedad de "locale" necesaria para la
 * correcta internacionalizacion desde el backing bean de los jsp's
 */
public class BundleHelper {


	private String bundle = null;

	private static String DEFAULT_BUNDLE = "org/inbio/ara/resources/global";

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

	public static String getDefaultBundleValue(String key,Locale locale){
        return ResourceBundle.getBundle(DEFAULT_BUNDLE,locale).getString(key);
	}
}
