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
 * StringUtils.java
 *
 * Created on 24 de agosto de 2007, 10:32 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.web;

/**
 * Esta clase tiene metodos estaticos utiles para el manejo de strings.
 * Se usan para determinar las propiedades de los componentes JSF que se guardan
 * en base de datos como strings (varchar), ya que en la tabla de Hash de las
 * propiedades no se puede insertar strings en todos los casos.
 * Si el valor es numerico debe insertarse como un numero.
 * Si el valor es booleano debe insertarse como un boolean.
 * ej. true en lugar de "true" / 6 en lugar de "6"
 * @author herson
 */
public class StringUtils {
    
    /** Creates a new instance of StringUtils */
    public StringUtils() {
    }
    
    /**
     * Esta funcion sirve para determinar si una cadena representa un valor
     * entero.
     * @param attribute Contiene el valor de un atributo
     * @return boolean
     */
    public static boolean isNumeric(String attribute){
	try {
		Integer.parseInt(attribute);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    
    /**
     * Esta funcion sirve para determinar si una cadena representa un valor
     * booleano.
     * @param attribute Contiene el valor de un atributo
     * @return boolean
     */
    public static boolean isBoolean(String attribute){
        /*Si el attribute dice "true" o "false" la cadena es un valor booleano*/
        return (attribute.equalsIgnoreCase("true") ||
                attribute.equalsIgnoreCase("false")) ? true : false;
    }
}
