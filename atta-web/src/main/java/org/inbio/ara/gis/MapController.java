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


        StringBuilder scriptString = new StringBuilder();
        //scriptString.append("<script src=\"http://maps.google.com/maps?file=api&amp;v=2&amp;sensor=false&amp;key=AIzaSyCR8g_D1ykB4f3y74b-vMf05NxyOiP3c-U\" type=\"text/javascript\"></script>\n");
        scriptString.append("<script src=\"http://maps.google.com/maps/api/js?v=3&amp;sensor=false\" type=\"text/javascript\"></script>\n");
        //scriptString.append("<script src=\"https://maps.googleapis.com/maps/api/js?sensor=false\" type=\"text/javascript\"></script>\n");
        //scriptString.append("<script src='http://api.maps.yahoo.com/ajaxymap?v=3.0&appid=euzuro-openlayers'></script>\n");
        //scriptString.append("<script src='http://dev.virtualearth.net/mapcontrol/mapcontrol.ashx?v=6.1'></script>\n");
        scriptString.append("<script src='http://ecn.dev.virtualearth.net/mapcontrol/mapcontrol.ashx?v=7.0'></script>\n");
        //Script to Java Script SOAPClient
        scriptString.append("<script id=\"script2\" type=\"text/JavaScript\" src=\"../../SOAPClient.js\"></script>");
        scriptString.append("<script defer='defer' type='text/javascript'>\n");

        //Define global variables
        scriptString.append("var map;\n");
        scriptString.append("var bingKey='AoLMy0VeiYxQs__rrYkPAtmuWjMgrnt52xTj_FvCiwDTTihBmPvhwH-I0hL5sCCd';\n");

        scriptString.append("var selectControl;\n");
        scriptString.append("var selectedFeature;\n");
        scriptString.append("var fromProjection = new OpenLayers.Projection('EPSG:4326');\n");
        scriptString.append("var toProjection = new OpenLayers.Projection('EPSG:900913');\n");

        scriptString.append("function init() {\n");
        scriptString.append("var attributes;\n");
        scriptString.append("var lonlat1;\n");
        scriptString.append("var lonlat2;\n");

        // Define map
        scriptString.append("map = new OpenLayers.Map('map', {controls: [], numZoomLevels: 15, projection: 'EPSG:900913'});\n");

        // Define map's layers
        //scriptString.append("openLayersWMSLayer = new OpenLayers.Layer.WMS('OpenLayers WMS', 'http://labs.metacarta.com/wms/vmap0', {layers:'basic'} );\n");
        //scriptString.append("yahooLayer         = new OpenLayers.Layer.Yahoo('Yahoo');\n");
        //scriptString.append("googleLayer        = new OpenLayers.Layer.Google('Google Hybrid', {type: G_HYBRID_MAP, 'sphericalMercator': true, numZoomLevels:15});\n");
        scriptString.append("googleLayer        = new OpenLayers.Layer.Google('Google Hybrid', {type: google.maps.MapTypeId.HYBRID_MAP, 'sphericalMercator': true, numZoomLevels:15});\n");
        scriptString.append("vectorLayer        = new OpenLayers.Layer.Vector('Gatherings/Observations');\n");
        //scriptString.append("virtualEarthLayer  = new OpenLayers.Layer.VirtualEarth('Virtual Earth');\n");
        scriptString.append("virtualEarthLayer  = new OpenLayers.Layer.Bing({name:'Bing Map',key:bingKey,type:'AerialWithLabels','sphericalMercator': true, numZoomLevels:15});\n");
        //scriptString.append("virtualEarthLayer  = new OpenLayers.Layer.Bing({name:'Bing Map',key:bingKey,type:'Road','sphericalMercator': true, numZoomLevels:15});\n");
        
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

                scriptString.append("attributes = createAttrib(\""+siteId+"\" , \""+countryName+"\" , \""+coordinates+"\" , \""+province+"\" , \""+localityName+"\" , \""+gatheringObs+"\" , \""+responsable+"\" , \""+initialDate+"\" , \""+finalDate+"\" , \""+scientificNames+"\");\n");
                scriptString.append("addPoint(" + Double.toString(lon) + ", " + Double.toString(lat) + ",attributes);\n");
            }
        }

        // Add map's layers
        scriptString.append("map.addLayer(googleLayer);\n");
        scriptString.append("map.addLayer(virtualEarthLayer);\n");
        scriptString.append("map.addLayer(vectorLayer);\n");        

        // Get map's bounds
        Double minX = getMinX(getLocalities());
        Double minY = getMinY(getLocalities());
        Double maxX = getMaxX(getLocalities());
        Double maxY = getMaxY(getLocalities());
        scriptString.append("lonlat1 = new OpenLayers.LonLat(" + minX + ", " + minY+ ");\n");
        scriptString.append("lonlat2 = new OpenLayers.LonLat(" + maxX + ", " + maxY+ ");\n");
        //scriptString.append("bounds = new OpenLayers.Bounds(" + minX + ", " + minY + ", " + maxX + ", " + maxY + ");\n");
        scriptString.append("bounds = new OpenLayers.Bounds();\n");
        scriptString.append("bounds.extend(lonlat1.transform(fromProjection,toProjection));\n");
        scriptString.append("bounds.extend(lonlat2.transform(fromProjection,toProjection));\n");
        scriptString.append("bounds.toBBOX();\n");
        scriptString.append("map.zoomToExtent(bounds);\n");
        //scriptString.append("map.setCenter(lonlat2.transform(fromProjection,toProjection));\n");
        scriptString.append("map.zoomTo(6);\n");


        //Create selected control
        scriptString.append("selectControl = new OpenLayers.Control.SelectFeature(vectorLayer,\n");
        scriptString.append("{onSelect: onFeatureSelect, onUnselect: onFeatureUnselect});\n");


        // Add map's controls
        scriptString.append("map.addControl(new OpenLayers.Control.LayerSwitcher());\n");
        scriptString.append("map.addControl(new OpenLayers.Control.MousePosition());\n");
        scriptString.append("map.addControl(new OpenLayers.Control.OverviewMap());\n");
        scriptString.append("map.addControl(new OpenLayers.Control.Navigation());\n");
        //scriptString.append("map.addControl(new OpenLayers.Control.MouseToolbar());\n");
        scriptString.append("map.addControl(new OpenLayers.Control.PanZoomBar());\n");
        
        scriptString.append("map.addControl(selectControl);\n");
        scriptString.append("selectControl.activate();\n");

        scriptString.append("}\n");

        // Create Attributes
        scriptString.append("function createAttrib(site, countryName, coordinates, state, locality, gathObs, responsible, initialDate,finalDate, scientificName) {\n");
        scriptString.append("attrib = {\n");
        scriptString.append("siteId: site,\n");
        scriptString.append("country: countryName,\n");
        scriptString.append("coordinate: coordinates,\n");
        scriptString.append("state: state,\n");
        scriptString.append("locality: locality,\n");
        scriptString.append("sGathObs: gathObs,\n");
        scriptString.append("sResponsible: responsible,\n");
        scriptString.append("sInitialDate: initialDate,\n");
        scriptString.append("sFinalDate: finalDate,\n");
        scriptString.append("sScientificName: scientificName\n");
        scriptString.append("};\n");
        scriptString.append("return attrib;\n");
        scriptString.append("};\n");

        // Add Point
        scriptString.append("function addPoint(x, y, attribute) {\n");
        scriptString.append("var attrib = attribute;\n");
        
        scriptString.append("var point = new OpenLayers.Geometry.Point(x, y);\n");
        scriptString.append("var feature = new OpenLayers.Feature.Vector(\n");
        //scriptString.append("new OpenLayers.Geometry.Point(x, y), attrib);\n");
        scriptString.append("point.transform(fromProjection,toProjection), attrib);\n");
        scriptString.append("vectorLayer.addFeatures(feature);\n");
        scriptString.append("}\n");

        // Event onPopupClose
        scriptString.append("function onPopupClose(evt) {\n");
        scriptString.append("selectControl.unselect(selectedFeature);\n");
        scriptString.append("}\n");


        // Event onFeatureSelect
        scriptString.append("function onFeatureSelect(feature) {\n");
        scriptString.append("selectedFeature = feature;\n");
        scriptString.append("var gatheringObservation = getScientificNames(feature.attributes.siteId, feature);\n");
        scriptString.append("popup = new OpenLayers.Popup.FramedCloud(\"point\",  \n");
        scriptString.append("feature.geometry.getBounds().getCenterLonLat(),\n");
        scriptString.append(" null,\n");
        scriptString.append("\"<div style='font-size:.8em; font-family:");
        scriptString.append("Arial Unicode MS'><b>");
        scriptString.append(country+":</b> \" + feature.attributes.country +");
        scriptString.append("\"<br><b>"+state +":</b> \" + feature.attributes.state +");
        scriptString.append("\"<br><b>"+locality +":</b> \" + feature.attributes.locality +");
        scriptString.append("\"<br><b>"+coordinate+":</b> \" + feature.attributes.coordinate+\"<br>\"+");
        scriptString.append("gatheringObservation");
        scriptString.append("+\"</div>\",");
        scriptString.append(" null, true, onPopupClose);\n");
        scriptString.append(" feature.popup = popup;\n");
        scriptString.append(" map.addPopup(popup);\n");
        scriptString.append(" }\n");


        //Get Gathering Observation and Scientific Names
        scriptString.append("function getScientificNames(siteId, feature)\n");
        scriptString.append("{\n");
        scriptString.append("var parameter = new Array();\n");
        scriptString.append("var url = \"../../../InventoryWebServiceService/InventoryWebService\";\n");
        scriptString.append("parameter[\"siteId\"]=siteId;\n");
        scriptString.append("var gathObs = SOAPClient.request(url, \"getGathObsBySiteId\", parameter);\n");
        scriptString.append("var gathObsXML=stringToXML(gathObs);\n");
        scriptString.append("var gatheringObservations =gathObsXML.getElementsByTagName(\"gathering\");\n");
        scriptString.append("var url = \"../../../TaxonomyWebServiceService/TaxonomyWebService\";\n");
        scriptString.append("var information = \"\";\n");
        scriptString.append("for(var gath = 0; gath < gatheringObservations.length; gath++)\n");
        scriptString.append("{\n");
        scriptString.append("var parameters = new Array();\n");
        scriptString.append("var id = gatheringObservations[gath].getElementsByTagName(\"id\")[0].childNodes[0].nodeValue;\n");
        scriptString.append("var responsible = gatheringObservations[gath].getElementsByTagName(\"responsible\")[0].childNodes[0].nodeValue;\n");
        scriptString.append("var initialDate = gatheringObservations[gath].getElementsByTagName(\"initialDate\")[0].childNodes[0].nodeValue;\n");
        scriptString.append("var finalDate = gatheringObservations[gath].getElementsByTagName(\"finalDate\")[0].childNodes[0].nodeValue;\n");
        scriptString.append("parameters[\"gathObsId\"]=id;\n");
        scriptString.append("var scientificNames = SOAPClient.request(url, \"getTaxonByGatheringObservation\", parameters);\n");
        scriptString.append("information += \"<br><b>\"+feature.attributes.sGathObs +\": </b>\"+id +\"<br>\";\n");
        scriptString.append("information += \"<b>\"+feature.attributes.sResponsible +\": </b>\"+responsible +\"<br>\";\n");
        scriptString.append("information += \"<b>\"+feature.attributes.sInitialDate +\": </b>\"+initialDate +\"<br>\";\n");
        scriptString.append("information += \"<b>\"+feature.attributes.sFinalDate +\": </b>\"+finalDate +\"<br>\";\n");
        scriptString.append("information += \"<b>\"+feature.attributes.sScientificName +\": </b>\"+scientificNames +\"<br>\";\n");
        scriptString.append("}\n");
        scriptString.append("return information;\n");
        scriptString.append("}\n");


        //Convert String to XML
        scriptString.append("function stringToXML(xmlData)\n");
        scriptString.append("{\n");
        scriptString.append("if (window.ActiveXObject) {\n");
        scriptString.append("xmlDoc=new ActiveXObject(\"Microsoft.XMLDOM\");\n");
        scriptString.append("xmlDoc.async=\"false\";\n");
        scriptString.append("xmlDoc.loadXML(xmlData);\n");
        scriptString.append("return xmlDoc;\n");
        scriptString.append("} else if (document.implementation && document.implementation.createDocument) {\n");
        scriptString.append("parser=new DOMParser();\n");
        scriptString.append("xmlDoc=parser.parseFromString(xmlData,\"text/xml\");\n");
        scriptString.append("return xmlDoc;\n");
        scriptString.append("}\n");
        scriptString.append("}\n");


        //Event onFeatureUnselect
        scriptString.append("function onFeatureUnselect(feature) { \n");
        scriptString.append("map.removePopup(feature.popup); \n");
        scriptString.append("feature.popup.destroy(); \n");
        scriptString.append("feature.popup = null; \n");
        scriptString.append(" }\n");


        scriptString.append("</script>\n");
        return scriptString.toString();
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