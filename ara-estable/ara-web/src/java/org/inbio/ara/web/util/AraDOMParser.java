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
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inbio.ara.web.util;

/**
 *
 * @author herson
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author herson
 */
/*
enum CLASSIMAGE = 1;
public static final AUDIO = 2;
public static final VIDEO = 3;
*/


public class AraDOMParser extends DefaultHandler {
    private String url;
    

    /**
     * Creates a new instance of AraSAXParser
     */
    public AraDOMParser(String url) {
        this.url = url;
    }

    // Given a city string, an element name, and
    // a list of attributes, print the values of
    // the attributes found in the XML document.
    public int[][] processDocument(String ScName, String kingdom) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();

            if (ScName != null) {
                Document document = getDocument(db, this.url);
                if (document != null) {
                    int[][] mediaIds = getMediaIds(document);
                    return mediaIds;
                } else {
                    System.out.println("No XML created from URL=" + this.url);
                }
            } // if
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    } // processDocument

    // Using the given document builder object,
    // construct and return an XML DOM
    // from the given URL.
    private static Document getDocument(DocumentBuilder db, String urlString) {
        try {
            URL url = new URL(urlString);

            try {
                URLConnection URLconnection = url.openConnection();
                HttpURLConnection httpConnection = (HttpURLConnection) URLconnection;

                int responseCode = httpConnection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    InputStream in = httpConnection.getInputStream();
                    try {
                        Document doc = db.parse(in);
                        return doc;
                    } catch (org.xml.sax.SAXException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("HTTP connection response != HTTP_OK");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } // Catch
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } // Catch
        return null;
    } // getDocument

    private static int[][] getMediaIds(Document document) {
        NodeList listOfMedia = document.getElementsByTagName("media");
        int totalMedia = listOfMedia.getLength();
        int[][] ids = new int[totalMedia][2];
        System.out.println("Total no of MM : " + totalMedia);
        for (int i = 0; i < totalMedia; i++) {
            NamedNodeMap attrList = listOfMedia.item(i).getAttributes();
            Node id = attrList.getNamedItem("id");
            ids[i][0] = Integer.parseInt(id.getNodeValue());
            Node category = attrList.getNamedItem("category");
            ids[i][1] = Integer.parseInt(category.getNodeValue());
        }
        return ids;
    }

}
