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


/**
 * This class creates the xml document and parse it to create the list elementXML
 */

package org.inbio.ara.util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileWriter;



public class ParserXML {

    private List myElements;
    private Document dom;
    private File currentFile;

    public ParserXML() {

        //create a list to hold the elementFormat  objects
        myElements = new ArrayList();
    }

    /**
     * create a xml file
     * @param contents
     */
    public void createXLMFile(String text) {
        PrintWriter escribir = null;
        String contents = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" + text;

        /**create a temporal file and parser the document*/
        try {
            setCurrentFile(File.createTempFile("default", ".xml"));
            escribir = new PrintWriter(new BufferedWriter(new FileWriter(getCurrentFile().getAbsolutePath())));
            escribir.println(contents);
            escribir.close();
        } catch (IOException ex) {
            Logger.getLogger(ParserXML.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            escribir.close();
        }
    }

    public List parserFormat() {

        //parse the xml file and get the dom object
        parseXmlFile(this.currentFile);

        //get each employee element and create a ElementLabelXml object
        parseDocument();

        //Iterate through the list and print the data
        this.printData();

        return this.getMyEmpls();

    }

    /**
     *  build the doc if the xml file is well formed and parser a doc
     * @param f
     */
    public void parseXmlFile(File f) {
        
        //get the factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

            //Using factory get an instance of document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse(f);


        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (SAXException se) {
            se.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


   /**
    * generates the list of elemenXML
    */
    public void parseDocument() {

        //get the root elememt
        Element docEle = dom.getDocumentElement();


        //get a nodelist of <p> element
        NodeList nl = docEle.getElementsByTagName("p");
        

        if (nl != null && nl.getLength() > 0) {
            for (int i = 0; i < nl.getLength(); i++) {

                //get the element
                Element el = (Element) nl.item(i);

                //get the ElementLabelXml object  and  convert a element
                ElementLabelXml e = getElement(el);
             
                //add it to list
                getMyEmpls().add(e);
            }
        }
    }

    /**
     * take an  element and read the values in, create
     * an ElementLabelXml object and return it
     * @param empEl
     * @return
     */
    private ElementLabelXml getElement(Element empEl) {

        //for each <employee> element get text or int values of
        //name ,id, age and name

        //String name, String id,String type
        String strong = this.getTextValue(empEl, "strong");
        String em = this.getTextValue(empEl, "em");
        String size = this.getTextValueOfAtributte(empEl, "span");

        String style = empEl.getAttribute("style");
        String name = empEl.getTextContent(); //value of node


        //Create a new ElementLabelXml with the value read from the xml nodes
        ElementLabelXml e = new ElementLabelXml("",name, em, size, style, strong);

        e.toString();

        return e;
    }

    /**
     * take a xml element and the tag name, look for the tag and get
     * the text content
     * @param ele
     * @param tagName
     * @return
     */
    private String getTextValue(Element ele, String tagName) {
        String textVal = null;
        NodeList nl = ele.getElementsByTagName(tagName);
        if (nl != null && nl.getLength() > 0) {
            Element el = (Element) nl.item(0);
            textVal = el.getFirstChild().getNodeValue();
        }

        return textVal;
    }

    /**
     * get the value of the node, when the node  contains the atribbute style
     * @param ele
     * @param tagName
     * @return
     */
    private String getTextValueOfAtributte(Element ele, String tagName) {
        String textVal = null;
        NodeList nl = ele.getElementsByTagName(tagName);
        if (nl != null && nl.getLength() > 0) {
            Element el = (Element) nl.item(0);
            //textVal = el.getFirstChild().getNodeValue();
            textVal = el.getAttribute("style");
        }

        return textVal;
    }

    /**
     * Iterate through the list and print the
     * content to console
     */
    private void printData() {

        System.out.println("No of elements '" + getMyEmpls().size() + "'.");

        Iterator it = getMyEmpls().iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    /**
     * @return the currentFile
     */
    public File getCurrentFile() {
        return currentFile;
    }

    /**
     * @param currentFile the currentFile to set
     */
    public void setCurrentFile(File currentFile) {
        this.currentFile = currentFile;
    }

    /**
     * @return the myElements
     */
    public List getMyEmpls() {
        return myElements;
    }

    /**
     * @param myElements the myElements to set
     */
    public void setMyEmpls(List myEmpls) {
        this.myElements = myEmpls;
    }
}




