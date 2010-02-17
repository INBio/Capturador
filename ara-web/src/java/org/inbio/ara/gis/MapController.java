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

package org.inbio.ara.gis;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.util.List;
import java.util.Locale;
import javax.faces.context.FacesContext;
import org.inbio.ara.dto.gis.SiteDTO;
import org.inbio.ara.persistence.gis.SiteCoordinate;
import org.inbio.ara.util.BundleHelper;
import javax.faces.FacesException;
import org.inbio.ara.AraSessionBean;


/**
 *
 * @author mvargas
 */
public class MapController extends AbstractPageBean {

    //Contexto utilizado para obtener el current locale
    private FacesContext context;
    private Locale myLocale;

    /*private List<SiteDTO> localities =
            this.getsite$SiteSessionBean().getPagination().getResults(0, 1000000);*/
    private List<SiteDTO> localities = this.getsite$SiteSessionBean().
            getPagination().getDataProvider().getList();


    public MapController () {
    }

    public String getMapScript() {

        if(this.getsite$SiteSessionBean().getPagination() == null){
            this.getsite$SiteSessionBean().initDataProvider();
        }

        //Define variables to internationalize popups
        String country = BundleHelper.getDefaultBundleValue
                ("country", this.getMyLocale());
        String state = BundleHelper.getDefaultBundleValue
                ("state", this.getMyLocale());
        String coordinate = BundleHelper.getDefaultBundleValue
                ("coordinates", this.getMyLocale());
        String locality = BundleHelper.getDefaultBundleValue
                ("locality", this.getMyLocale());
        String gatheringObs = BundleHelper.getDefaultBundleValue
                ("gathering_observation_id", this.getMyLocale());
        String responsable = BundleHelper.getDefaultBundleValue
                ("person_in_charge", this.getMyLocale());
        String scientificNames = BundleHelper.getDefaultBundleValue
                ("taxon_name", this.getMyLocale());
        String initialDate = BundleHelper.getDefaultBundleValue
                ("initial_date", this.getMyLocale());
        String finalDate = BundleHelper.getDefaultBundleValue
                ("final_date", this.getMyLocale());


        String scriptString = "";
        //scriptString += "<script src='http://maps.google.com/maps?file=api&amp;v=2&amp;key=ABQIAAAAjpkAC9ePGem0lIq5XcMiuhT2yXp_ZAY8_ufC3CFXhHIE1NvwkxTS6gjckBmeABOGXIUiOiZObZESPg'></script>\n";
        scriptString += "<script src='http://api.maps.yahoo.com/ajaxymap?v=3.0&appid=euzuro-openlayers'></script>\n";
        scriptString += "<script src='http://dev.virtualearth.net/mapcontrol/mapcontrol.ashx?v=6.1'></script>\n";
        //Script to Java Script SOAPClient
        scriptString += "<script id=\"script2\" type=\"text/JavaScript\" src=\"../../SOAPClient.js\"></script>";
        scriptString += "<script defer='defer' type='text/javascript'>\n";

        //Define global variables
        scriptString += "var map\n";
        scriptString += "var selectControl\n";
        scriptString += "var selectedFeature\n";

        scriptString += "function init() {\n";
        scriptString += "var attributes;\n";

        // Define map
        scriptString += "map = new OpenLayers.Map('map', {controls: [], numZoomLevels: 10});\n";

        // Define map's layers
        //scriptString += "googleMapsLayer    = new OpenLayers.Layer.Google('Google Hybrid', {type: G_HYBRID_MAP });\n";
        scriptString += "openLayersWMSLayer = new OpenLayers.Layer.WMS('OpenLayers WMS', 'http://labs.metacarta.com/wms/vmap0', {layers:'basic'} );\n";
        scriptString += "yahooLayer         = new OpenLayers.Layer.Yahoo('Yahoo');\n";
        scriptString += "vectorLayer        = new OpenLayers.Layer.Vector('Gatherings/Observations');\n";
        scriptString += "virtualEarthLayer  = new OpenLayers.Layer.VirtualEarth('Virtual Earth');\n";

        // Add coordinates of collecting points
        for (SiteDTO tObject : getLocalities()) {
            Long siteId = tObject.getSiteId();                     
            
            List coordinateList = tObject.getCoordinatesList();

            if (coordinateList.size() > 0) {
                Double lon = ((SiteCoordinate) coordinateList.get(0)).getLongitude();
                Double lat = ((SiteCoordinate) coordinateList.get(0)).getLatitude();
                String countryName = tObject.getCountryName();
                String coordinates = tObject.getCoordinates();
                String province = tObject.getProvinceName();
                String localityName = tObject.getDescription();

				// clean the string...
				localityName = localityName.replace("\n", " ");
				localityName = localityName.replace("\r", " ");
              
                if(province==null)
                {
                    province="";
                }

                scriptString += "attributes = createAttrib(\""+siteId+"\" , \""+countryName+"\" , \""+coordinates+"\" , \""+province+"\" , \""+localityName+"\" , \""+gatheringObs+"\" , \""+responsable+"\" , \""+initialDate+"\" , \""+finalDate+"\" , \""+scientificNames+"\");\n";
                scriptString += "addPoint(" + Double.toString(lon) + ", " + Double.toString(lat) + ",attributes);\n";
            }
        }

        // Add map's layers
        scriptString += "map.addLayer(openLayersWMSLayer);\n";
        //scriptString += "map.addLayer(googleMapsLayer);\n";
        scriptString += "map.addLayer(yahooLayer);\n";
        scriptString += "map.addLayer(vectorLayer);\n";
        scriptString += "map.addLayer(virtualEarthLayer);\n";

        // Get map's bounds
        Double minX = getMinX(getLocalities());
        Double minY = getMinY(getLocalities());
        Double maxX = getMaxX(getLocalities());
        Double maxY = getMaxY(getLocalities());

        scriptString += "bounds = new OpenLayers.Bounds(" + minX + ", " + minY + ", " + maxX + ", " + maxY + ");\n";
        scriptString += "map.zoomToExtent(bounds);\n";

        //Create selected control
        scriptString += "selectControl = new OpenLayers.Control.SelectFeature(vectorLayer,\n";
        scriptString += "{onSelect: onFeatureSelect, onUnselect: onFeatureUnselect});\n";


        // Add map's controls
        scriptString += "map.addControl(new OpenLayers.Control.LayerSwitcher());\n";
        scriptString += "map.addControl(new OpenLayers.Control.MousePosition());\n";
        scriptString += "map.addControl(new OpenLayers.Control.OverviewMap());\n";
        scriptString += "map.addControl(new OpenLayers.Control.Navigation());\n";
        scriptString += "map.addControl(new OpenLayers.Control.MouseToolbar());\n";
        scriptString += "map.addControl(new OpenLayers.Control.PanZoomBar());\n";
        scriptString += "map.addControl(selectControl);\n";
        scriptString += "selectControl.activate();\n";

        scriptString += "}\n";

        // Create Attributes
        scriptString += "function createAttrib(site, countryName, coordinates, state, locality, gathObs, responsible, initialDate,finalDate, scientificName) {\n";
        scriptString += "attrib = {\n";
        scriptString += "siteId: site,\n";
        scriptString += "country: countryName,\n";
        scriptString += "coordinate: coordinates,\n";
        scriptString += "state: state,\n";
        scriptString += "locality: locality,\n";
        scriptString += "sGathObs: gathObs,\n";
        scriptString += "sResponsible: responsible,\n";
        scriptString += "sInitialDate: initialDate,\n";
        scriptString += "sFinalDate: finalDate,\n";
        scriptString += "sScientificName: scientificName\n";
        scriptString += "};\n";
        scriptString += "return attrib;\n";
        scriptString += "};\n";

        // Add Point
        scriptString += "function addPoint(x, y, attribute) {\n";
        scriptString += "var attrib = attribute;\n";
        scriptString += "var feature = new OpenLayers.Feature.Vector(\n";
        scriptString += "new OpenLayers.Geometry.Point(x, y), attrib);\n";
        scriptString += "vectorLayer.addFeatures(feature);\n";
        scriptString += "}\n";

        // Event onPopupClose
        scriptString += "function onPopupClose(evt) {\n";
        scriptString += "selectControl.unselect(selectedFeature);\n";
        scriptString += "}\n";


        // Event onFeatureSelect
        scriptString += "function onFeatureSelect(feature) {\n";
        scriptString += "selectedFeature = feature;\n";
        scriptString += "var gatheringObservation = getScientificNames(feature.attributes.siteId, feature);\n";
        scriptString += "popup = new OpenLayers.Popup.FramedCloud(\"point\",  \n";
        scriptString += "feature.geometry.getBounds().getCenterLonLat(),\n";
        scriptString += " null,\n";
        scriptString += "\"<div style='font-size:.8em; font-family:";
        scriptString += "Arial Unicode MS'><b>";
        scriptString +=  country+":</b> \" + feature.attributes.country +";
        scriptString += "\"<br><b>"+state +":</b> \" + feature.attributes.state +";
        scriptString += "\"<br><b>"+locality +":</b> \" + feature.attributes.locality +";
        scriptString += "\"<br><b>"+coordinate+":</b> \" + feature.attributes.coordinate+\"<br>\"+";
        scriptString += "gatheringObservation";        
        scriptString += "+\"</div>\",";
        scriptString += " null, true, onPopupClose);\n";
        scriptString += " feature.popup = popup;\n";
        scriptString += " map.addPopup(popup);\n";
        scriptString += " }\n";


        //Get Gathering Observation and Scientific Names
        scriptString += "function getScientificNames(siteId, feature)\n";
        scriptString += "{\n";
        scriptString += "var parameter = new Array();\n";
        scriptString += "var url = \"../../../InventoryWebServiceService/InventoryWebService\";\n";
        scriptString += "parameter[\"siteId\"]=siteId;\n";
        scriptString += "var gathObs = SOAPClient.request(url, \"getGathObsBySiteId\", parameter);\n";
        scriptString += "var gathObsXML=stringToXML(gathObs);\n";
        scriptString += "var gatheringObservations =gathObsXML.getElementsByTagName(\"gathering\");\n";
        scriptString += "var url = \"../../../TaxonomyWebServiceService/TaxonomyWebService\";\n";
        scriptString += "var information = \"\";\n";
        scriptString += "for(var gath = 0; gath < gatheringObservations.length; gath++)\n";
        scriptString += "{\n";
        scriptString += "var parameters = new Array();\n";
        scriptString += "var id = gatheringObservations[gath].getElementsByTagName(\"id\")[0].childNodes[0].nodeValue;\n";
        scriptString += "var responsible = gatheringObservations[gath].getElementsByTagName(\"responsible\")[0].childNodes[0].nodeValue;\n";
        scriptString += "var initialDate = gatheringObservations[gath].getElementsByTagName(\"initialDate\")[0].childNodes[0].nodeValue;\n";
        scriptString += "var finalDate = gatheringObservations[gath].getElementsByTagName(\"finalDate\")[0].childNodes[0].nodeValue;\n";
        scriptString += "parameters[\"gathObsId\"]=id;\n";
        scriptString += "var scientificNames = SOAPClient.request(url, \"getTaxonByGatheringObservation\", parameters);\n";
        scriptString += "information += \"<br><b>\"+feature.attributes.sGathObs +\": </b>\"+id +\"<br>\";\n";
        scriptString += "information += \"<b>\"+feature.attributes.sResponsible +\": </b>\"+responsible +\"<br>\";\n";
        scriptString += "information += \"<b>\"+feature.attributes.sInitialDate +\": </b>\"+initialDate +\"<br>\";\n";
        scriptString += "information += \"<b>\"+feature.attributes.sFinalDate +\": </b>\"+finalDate +\"<br>\";\n";
        scriptString += "information += \"<b>\"+feature.attributes.sScientificName +\": </b>\"+scientificNames +\"<br>\";\n";
        scriptString += "}\n";
        scriptString += "return information;\n";
        scriptString += "}\n";


        //Convert String to XML
        scriptString += "function stringToXML(xmlData)\n";
        scriptString += "{\n";
        scriptString += "if (window.ActiveXObject) {\n";
        scriptString += "xmlDoc=new ActiveXObject(\"Microsoft.XMLDOM\");\n";
        scriptString += "xmlDoc.async=\"false\";\n";
        scriptString += "xmlDoc.loadXML(xmlData);\n";
        scriptString += "return xmlDoc;\n";
        scriptString += "} else if (document.implementation && document.implementation.createDocument) {\n";
        scriptString += "parser=new DOMParser();\n";
        scriptString += "xmlDoc=parser.parseFromString(xmlData,\"text/xml\");\n";
        scriptString += "return xmlDoc;\n";
        scriptString += "}\n";
        scriptString += "}\n";



        //Event onFeatureUnselect
        scriptString += "function onFeatureUnselect(feature) { \n";
        scriptString += "map.removePopup(feature.popup); \n";
        scriptString += "feature.popup.destroy(); \n";
        scriptString += "feature.popup = null; \n";
        scriptString += " }\n";


        scriptString += "</script>\n";      
        return scriptString;
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SiteSessionBean getsite$SiteSessionBean() {
        return (SiteSessionBean) getBean("gis$SiteSessionBean");
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
     * @return the localities
     */
    private List<SiteDTO> getLocalities() {
        return localities;
    }

    /**
     * @param localities the localities to set
     */
    private void setLocalities(List<SiteDTO> localities) {
        this.localities = localities;
    }

    private Double getMaxX(List<SiteDTO> localities) {
        // Lets assume we are working with validated geographical coordinates, so -180 <= longitude <= l80
        Double maxX = new Double(-180);

        for (SiteDTO tObject : localities) {
            List coordinateList = tObject.getCoordinatesList();

            if (coordinateList.size() > 0) {
                Double x = ((SiteCoordinate) coordinateList.get(0)).getLongitude();
                if (x > maxX) {
                    maxX = x;
                }
            }
        }

        return maxX;
    }

    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
		return this.getAraSessionBean().getCurrentLocale();
    }

    private Double getMaxY(List<SiteDTO> localities) {
        // Lets assume we are working with validated geographical coordinates, so -90 <= latitude <= 90
        Double maxY = new Double(-90);

        for (SiteDTO tObject : localities) {
            List coordinateList = tObject.getCoordinatesList();

            if (coordinateList.size() > 0) {
                Double y = ((SiteCoordinate) coordinateList.get(0)).getLatitude();
                if (y > maxY) {
                    maxY = y;
                }
            }
        }

        return maxY;
    }

    private Double getMinX(List<SiteDTO> localities) {
        // Lets assume we are working with validated geographical coordinates, so -180 <= longitude <= l80
        Double minX = new Double(180);

        for (SiteDTO tObject : localities) {
            List coordinateList = tObject.getCoordinatesList();

            if (coordinateList.size() > 0) {
                Double x = ((SiteCoordinate) coordinateList.get(0)).getLongitude();
                if (x < minX) {
                    minX = x;
                }
            }
        }

        return minX;
    }

    private Double getMinY(List<SiteDTO> localities) {
        // Lets assume we are working with validated geographical coordinates, so -90 <= latitude <= 90
        Double minY = new Double(90);

        for (SiteDTO tObject : localities) {
            List coordinateList = tObject.getCoordinatesList();

            if (coordinateList.size() > 0) {
                Double y = ((SiteCoordinate) coordinateList.get(0)).getLatitude();
                if (y < minY) {
                    minY = y;
                }
            }
        }

        return minY;
    }

    /**
     * <p>Callback method that is called whenever a page is navigated to,
     * either directly via a URL, or indirectly via page navigation.
     * Customize this method to acquire resources that will be needed
     * for event handlers and lifecycle methods, whether or not this
     * page is performing post back processing.</p>
     *
     * <p>Note that, if the current request is a postback, the property
     * values of the components do <strong>not</strong> represent any
     * values submitted with this request.  Instead, they represent the
     * property values that were saved for this view when it was rendered.</p>
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
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    public void preprocess() {
    }

    /**
     * <p>Callback method that is called just before rendering takes place.
     * This method will <strong>only</strong> be called for the page that
     * will actually be rendered (and not, for example, on a page that
     * handled a postback and then navigated to a different page).  Customize
     * this method to allocate resources that will be required for rendering
     * this page.</p>
     */
    public void prerender() {
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
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
