/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio ( Instituto Nacional de Biodiversidad )
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

import java.util.StringTokenizer;



public class ElementLabelXml {

    
    private String strongLabel;
    private String emLabel;
    private String labelSize;
    private String labelStyle;
    private String elementName;
    private String value;

    public ElementLabelXml(String value, String name, String em, String size, String style, String strong) {


        this.value = value;
        this.elementName = name;
        this.emLabel = em;
        this.labelSize = this.getValueOfElement(size);
        this.labelStyle = this.getValueOfElement(style);
        this.strongLabel = strong;

    }

    /**
     * get the element of the cadena who contains the style or size
     * @param cadena
     * @return
     */
    public String getValueOfElement(String cadena) {

       String resp = null;    
       
        if (cadena != null  && cadena.length() > 0 ) {
            StringTokenizer token = new StringTokenizer(cadena, ":");

            while (token.hasMoreTokens()) {
                resp = token.nextToken();
            }
        }

        return resp;
    }


   /**
    * This method takes the object and transforms the object into a string with html format
    * @return the element in html format
    */
    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();



        if (this.getEmLabel() != null && this.getStrongLabel() != null && this.getLabelSize()  != null    && this.getLabelStyle() != null)
        {
            sb.append("<p style='text-align:" + this.getLabelStyle() + " ;'> <span style = 'font-size:' " + this.getLabelSize() + "> <em> <strong> " + this.getValue() + "  </strong> </em> </spam> </p>");
        }
     
        else if (this.getEmLabel() != null  && this.getLabelSize()  != null    && this.getLabelStyle() != null)
        {
            sb.append("<p style='text-align:" + this.getLabelStyle() + " ;'> <span style = 'font-size:' " + this.getLabelSize() + "> <em>  " + this.getValue() + "  </em> </spam> </p>");
        }

        else if (this.getStrongLabel()!= null  && this.getLabelSize()  != null    && this.getLabelStyle() != null)
        {
            sb.append("<p style='text-align:" + this.getLabelStyle() + " ;'> <span style = 'font-size:' " + this.getLabelSize() + ">  <strong> " + this.getValue() + "  </strong> </spam> </p>");
        }

        else if (this.getEmLabel() != null && this.getStrongLabel() != null && this.getLabelStyle()  != null)
        {
            sb.append("<p  style = 'text-align:" + this.getLabelStyle() + "'>  <em> <strong> " + this.getValue() + "  </strong> </em> </p>");
        }

        else if (this.getEmLabel() != null && this.getStrongLabel() != null && this.getLabelSize()  != null)
        {
            sb.append("<p> <span style = 'font-size:" + this.getLabelSize() + "'> <em> <strong> " + this.getValue() + "  </strong> </em> </spam> </p>");
        }
       
        else if (this.getEmLabel() != null  && this.getLabelSize()  != null    && this.getLabelStyle() != null)
        {
            sb.append("<p style='text-align:" + this.getLabelStyle() + " ;'> <span style = 'font-size:" + this.getLabelSize() + "'> <em>  " + this.getValue() + "  </em> </spam> </p>");
        }

        else if (this.getStrongLabel()!= null  && this.getLabelSize()  != null    && this.getLabelStyle() != null)
        {
            sb.append("<p style='text-align:" + this.getLabelStyle() + " ;'> <span style = 'font-size: " + this.getLabelSize() + "'>  <strong> " + this.getValue() + "  </strong> </spam> </p>");
        }
        
        else if (this.getEmLabel() != null && this.getLabelStyle()  != null)
        {
            sb.append("<p  style = 'text-align:" + this.getLabelStyle() + "'>  <em> " + this.getValue() + "  </em> </spam> </p>");
        }
        else if (this.getStrongLabel() != null && this.getLabelStyle()  != null)
        {
            sb.append("<p  style = 'text-align: " + this.getLabelStyle() + "'> <strong> " + this.getValue() + "  </strong> </p>");
        }

        else if (this.getEmLabel() != null && this.getLabelSize()  != null)
        {
            sb.append("<p> <span style = 'font-size:" + this.getLabelSize() + "'> <em>  " + this.getValue() + "  </em> </spam> </p>");
        }
        else if (this.getStrongLabel() != null && this.getLabelSize()  != null)
        {
           sb.append("<p> <span style = 'font-size: " + this.getLabelSize() + "'> <strong>  " + this.getValue() + "  </strong> </spam> </p>");
        }
        else if (this.getEmLabel() != null && this.getStrongLabel() != null)
        {
            sb.append("<p > <em> <strong> " + this.getValue() + "  </strong> </em>  </p>");
        }
        else if (this.getLabelStyle()  != null)
        {
            sb.append("<p  style = 'text-align:" + this.getLabelStyle() + " '>" + this.getValue() + " </p>");
        }
         else if (this.getLabelSize()  != null)
        {
            sb.append("<p>  <span style = 'font-size: " + this.getLabelSize() + "'>  " + this.getValue() + " </spam> </p>");
        }

        else if (this.getEmLabel() != null)
        {
            sb.append("<p > <em> " + this.getValue() + " </em>  </p>");
        }
        else if (this.getStrongLabel() != null)
        {
            sb.append("<p > <strong> " + this.getValue() + " </strong>  </p>");
        }

        else if(this.getElementName().equals("Barcode"))
        {
            System.out.println("<p > " + this.getElementName() + " </p>");
        }
        else
        {
            System.out.println("<p > " + this.getValue() + " </p>");
        }


        return sb.toString();
    }

    /**
     * @return the strongLabel
     */
    public String getStrongLabel() {
        return strongLabel;
    }

    /**
     * @param strongLabel the strongLabel to set
     */
    public void setStrongLabel(String strongLabel) {
        this.strongLabel = strongLabel;
    }

    /**
     * @return the emLabel
     */
    public String getEmLabel() {
        return emLabel;
    }

    /**
     * @param emLabel the emLabel to set
     */
    public void setEmLabel(String emLabel) {
        this.emLabel = emLabel;
    }

    /**
     * @return the labelSize
     */
    public String getLabelSize() {
        return labelSize;
    }

    /**
     * @param labelSize the labelSize to set
     */
    public void setLabelSize(String labelSize) {
        this.labelSize = labelSize;
    }

    /**
     * @return the labelStyle
     */
    public String getLabelStyle() {
        return labelStyle;
    }

    /**
     * @param labelStyle the labelStyle to set
     */
    public void setLabelStyle(String labelStyle) {
        this.labelStyle = labelStyle;
    }

    /**
     * @return the elementName
     */
    public String getElementName() {
        return elementName;
    }

    /**
     * @param elementName the elementName to set
     */
    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }
}

