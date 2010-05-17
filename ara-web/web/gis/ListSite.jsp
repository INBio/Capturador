<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <jsp:directive.page import="org.inbio.ara.gis.MapController"/>
    <f:view>
        <webuijsf:page binding="#{gis$ListSite.page1}" id="page1">
            <webuijsf:html binding="#{gis$ListSite.html1}" id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script id="script2" type="text/JavaScript" url="http://openlayers.org/api/OpenLayers.js"/>
                    <jsp:scriptlet>
                        MapController mapController = new MapController();
                        String mapScript = mapController.getMapScript();
                        out.write(mapScript);
                    </jsp:scriptlet>
                </webuijsf:head>
                <webuijsf:body binding="#{gis$ListSite.body1}" id="body1" onLoad="init()" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <webuijsf:label id="lbGatheringTitle" style="width: 600px" styleClass="Page_title" text="#{resources.localities}"/>
                            <h:panelGrid id="gridpGathering_Main" style=" width:600px">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msgListGathering" infoClass="infoMessage"
                                    style="height: 24px; width: 574px" warnClass="warnMessage"/>
                                <h:panelGrid columns="4" id="gridpSearch" style="height: 24px" width="719">
                                    <h:inputText binding="#{gis$ListSite.txSearch}" id="txSearch" style="height: 18px; width: 408px">
                                        <f:validateLength maximum="100" minimum="0"/>
                                    </h:inputText>
                                    <h:commandButton action="#{gis$ListSite.btnSiteSearch_action}" binding="#{gis$ListSite.btnSeach}" id="btnSiteSearch"
                                        style="height: 25px; width: 160px" styleClass="My_Button" value="#{resources.search}"/>
                                    <h:commandButton action="#{gis$ListSite.btnAdvSiteSearch_action}" binding="#{gis$ListSite.btnAdvSeach}"
                                        id="btnAdvSiteSearch" style="height: 25px; width: 160px" styleClass="My_Button" value="#{resources.advanced_search}"/>
                                    <h:commandButton action="#{gis$ListSite.btnShowAllLocalities_action}" binding="#{gis$ListSite.btnShowAllLocalities}"
                                        id="btnShowAllLocalities" style="height: 25px; width: 160px" styleClass="My_Button" value="#{resources.all_locations}"/>
                                </h:panelGrid>
                                <h:panelGrid binding="#{gis$ListSite.gridpAdvancedSearch}" columns="1" id="gridpAdvancedSearch" rendered="false"
                                    style="height: 5px" styleClass="My_panel_blue" width="680">
                                    <h:panelGrid columns="4" id="gridpAdvancedSearch1" style="height: 24px" width="670">
                                        <webuijsf:label for="ddCountry1" id="lbCountry1" text="#{resources.country}"/>
                                        <webuijsf:dropDown actionExpression="#{gis$ListSite.setProvinces}" binding="#{gis$ListSite.ddCountry}" id="ddCountry1"
                                            items="#{gis$ListSite.countriesData.options}" selected="#{gis$SiteSessionBean.selectedCountry}" submitForm="true" width="154px"/>
                                        <webuijsf:label for="ddProvince1" id="lbProvince1" text="#{resources.state}"/>
                                        <webuijsf:dropDown binding="#{gis$ListSite.ddProvince}" id="ddProvince1" items="#{gis$ListSite.provincesData.options}"
                                            selected="#{gis$SiteSessionBean.selectedProvince}" width="154px"/>
                                        <webuijsf:label for="txLocality" id="lblocality" text="#{resources.locality}"/>
                                        <webuijsf:textField binding="#{gis$ListSite.txLocality}" id="txLocality" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                        <webuijsf:label for="txTaxon" id="lbTaxon" text="#{resources.taxon_name}"/>
                                        <webuijsf:textField binding="#{gis$ListSite.txTaxonName}" id="txTaxon" validatorExpression="#{util$ValidatorBean.validateInputTaxon}"/>
                                    </h:panelGrid>
                                    <h:panelGrid cellspacing="1" columns="2" id="panelpCoordinates" width="670">
                                        <h:panelGrid columns="7" id="gridpanelCoor" style="height: 24px" styleClass="My_subpanel_blue" width="500">
                                            <webuijsf:label for="txLatitudeShort" id="lbLatitudeShort" text="#{resources.latitude}"/>
                                            <webuijsf:textField binding="#{gis$ListSite.txLatitudeShort}" columns="10" id="txLatitudeShort" validatorExpression="#{util$ValidatorBean.doubleNumberFormatValidator}">
                                                <f:validateDoubleRange maximum="90.000000" minimum="-90.000000"/>
                                            </webuijsf:textField>
                                            <webuijsf:label for="txLongitudeShort" id="lbLongitudeShort" text="#{resources.longitude}"/>
                                            <webuijsf:textField binding="#{gis$ListSite.txLongitudeShort}" columns="10" id="txLongitudeShort" validatorExpression="#{util$ValidatorBean.doubleNumberFormatValidator}">
                                                <f:validateDoubleRange maximum="180.000000" minimum="-180.000000"/>
                                            </webuijsf:textField>
                                            <webuijsf:label for="txRadio" id="lbRadio" text="#{resources.coor_radio}"/>
                                            <webuijsf:textField binding="#{gis$ListSite.txRadio}" columns="10" id="txRadio" validatorExpression="#{util$ValidatorBean.longNumberFormatValidator}">
                                                <f:validateLongRange maximum="2147483647" minimum="0"/>
                                            </webuijsf:textField>
                                        </h:panelGrid>
                                        <h:commandButton action="#{gis$ListSite.btnAdvSearchGO_action}" id="btnAdvSearchGO" style="width: 160px"
                                            styleClass="My_Button" value="#{resources.button_proceed}"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <h:panelGrid cellspacing="1" columns="2" id="gridpTableMain" style="height: 24px" styleClass="My_panel_sites" width="570">
                                    <h:panelGrid cellspacing="1" columns="1" id="gridpTableMain2" style="height: 24px" styleClass="My_table" width="570">
                                        <webuijsf:panelGroup id="grouppButtons">
                                            <h:panelGrid columns="1" id="gridpquantity" styleClass="My_table_top" width="570">
                                                <h:outputLabel id="labelQuantity" value="#{gis$ListSite.quantityTotal}"/>
                                            </h:panelGrid>
                                            <webuijsf:panelGroup id="panelPaginacion" separator=" " style="margin-left:70px;">
                                                <!-- Botones de acciones -->
                                                <h:commandButton action="#{gis$ListSite.btn_new_action}" id="btn_new" style="margin: 2px;height: 22px"
                                                    styleClass="My_Button_table" value="#{resources.new}"/>
                                                <h:commandButton action="#{gis$ListSite.btn_edit_action}" style="margin: 2px;height: 22px"
                                                    styleClass="My_Button_table" value="#{resources.btnEdit}"/>
                                                <h:commandButton action="#{gis$ListSite.btn_delete_action}" style="margin: 2px;height: 22px"
                                                    styleClass="My_Button_table" value="#{resources.btnDelete}"/>
                                                <!-- Botones de paginacion -->
                                                <h:commandButton action="#{gis$SiteSessionBean.pagination.firstResults}" id="btnFirst"
                                                    rendered="#{gis$SiteSessionBean.pagination.isVisiblePrevious}" style="margin: 2px;height: 22px"
                                                    styleClass="My_Button_first" value="#{resources.pagination_first}"/>
                                                <h:commandButton action="#{gis$SiteSessionBean.pagination.previousResults}" id="btnPrevious"
                                                    rendered="#{gis$SiteSessionBean.pagination.isVisiblePrevious}" style="margin: 2px;height: 22px"
                                                    styleClass="My_Button_previous" value="#{resources.pagination_previous}"/>
                                                <h:commandButton action="#{gis$SiteSessionBean.pagination.nextResults}" id="btnNext"
                                                    rendered="#{gis$SiteSessionBean.pagination.isVisibleNext}" style="margin: 2px; height: 22px"
                                                    styleClass="My_Button_next" value="#{resources.pagination_next}"/>
                                                <h:commandButton action="#{gis$SiteSessionBean.pagination.lastResults}" id="btnLast"
                                                    rendered="#{gis$SiteSessionBean.pagination.isVisibleNext}" style="margin: 2px;height: 22px"
                                                    styleClass="My_Button_last" value="#{resources.pagination_last}"/>
                                            </webuijsf:panelGroup>
                                        </webuijsf:panelGroup>
                                        <h:dataTable binding="#{gis$ListSite.dataTableSite}" cellspacing="0" columnClasses="list-columns"
                                            headerClass="list-header" id="dataTablesite" rowClasses="list-row-even,list-row-odd"
                                            rows="#{gis$SiteSessionBean.pagination.resultsPerPage}"
                                            style="border-top: solid rgb(214, 218, 221) 2px; border-bottom: solid rgb(214, 218, 221) 2px; border-left: solid rgb(214, 218, 221) 2px; "
                                            value="#{gis$SiteSessionBean.pagination.dataProvider.list}" var="currentRow" width="570">
                                            <h:column>
                                                <h:selectBooleanCheckbox id="checkbox1" value="#{currentRow['selected']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.country}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['countryName']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.state}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['provinceName']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.locality}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['description']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.coordinates}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['coordinates']}"/>
                                            </h:column>
                                        </h:dataTable>
                                    </h:panelGrid>
                                    <div id="map" style="width:500px; height:350px; float:left" title="Mapa Mundial"></div>
                                </h:panelGrid>
                                <jsp:directive.include file="/Footer.jspf"/>
                            </h:panelGrid>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
