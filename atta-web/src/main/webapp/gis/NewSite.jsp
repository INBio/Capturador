<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : NewSite
    Created on : 18/11/2009, 09:16:37 AM
    Author     : esmata
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link id="link2" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <div id="pageFormated">
                        <jsp:directive.include file="/Header.jspf"/>
                        <webuijsf:panelLayout id="contenido">
                            <webuijsf:form id="form1">
                                <h:outputLabel id="lbTitle" style="height: 24px; left: 24px; position: relative; width: 840px" styleClass="Page_title" value="#{resources.titleLocationNew}"/>
                                <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; position: relative" width="840">
                                    <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                        style="height: 55px; width: 840px" warnClass="warnMessage"/>
                                    <!-- Botonera -->
                                    <webuijsf:panelGroup id="grouppBotonera" style="height: 24px; width: 840px">
                                        <h:commandButton action="#{gis$NewSite.btnNewSite_action}" id="btnNewSite" style="height: 24px; width: 175px"
                                            styleClass="My_Button" value="#{resources.btnSave}"/>
                                    </webuijsf:panelGroup>
                                    <!-- Panel de detalles del sitios -->
                                    <webuijsf:panelLayout id="PanelDetails" style="height: 100px; position: relative; width: 840px; -rave-layout: grid" styleClass="My_subpanel_blue">
                                        <webuijsf:label id="lbDescription" requiredIndicator="true"
                                                        style="height: 24px; left: 24px; top: 14px; position: absolute; width: 164px" text="#{resources.locality}"/>                                      
                                        
                                        
                                        <webuijsf:label for="ddType" id="lbType" style="height: 24px; left: 24px; top: 62px; position: absolute; width: 164px" text="#{resources.type}"/>
                                        <webuijsf:textArea binding="#{gis$NewSite.txaDescription}" columns="23" id="txaDescription" required="true"
                                            style="position: absolute; left: 192px; top: 14px; width: 168px; height: 24px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                        <webuijsf:dropDown binding="#{gis$NewSite.ddType}" id="ddType" items="#{gis$NewSite.typeData.options}" required="true"
                                            selected="#{gis$SiteSessionBean.selectedType}" 
                                            style="position: absolute; left: 192px; top: 62px; height: 24px" width="192px"/>
                                      
                                        
                                        <!--Segunda Columna -->
                                        <webuijsf:label for="txPresition" id="lbPresition"
                                            style="height: 24px; left: 432px; top: 14px; position: absolute; width: 164px" text="#{resources.presition}"/>
                                        <webuijsf:label for="ddDetermination" id="lbDetermination"
                                            style="height: 24px; left: 432px; top: 38px; position: absolute; width: 164px" text="#{resources.determination_method}"/>
                                        <webuijsf:label for="ddOrigProjection" id="lbProjection"
                                            style="height: 24px; left: 432px; top: 62px; position: absolute; width: 164px" text="#{resources.orig_proyection}"/>
                                        
                                        <webuijsf:textField binding="#{gis$NewSite.txPresition}" columns="25" id="txPresition"
                                            style="height: 24px; left: 600px; top: 14px; position: absolute; width: 192px" validatorExpression="#{util$ValidatorBean.longNumberFormatValidator}"/>
                                        
                                        <webuijsf:dropDown binding="#{gis$NewSite.ddDetermination}" id="ddDetermination"
                                            items="#{gis$NewSite.determinationMethodData.options}" required="true"
                                            selected="#{gis$SiteSessionBean.selectedDeterminationMethod}"
                                            style="height: 24px; left: 600px; top: 38px; position: absolute" width="192px"/>
                                        
                                        <webuijsf:dropDown  actionExpression="#{gis$NewSite.onChangeProjection_action}" visible="true" id="ddProjection" binding="#{gis$NewSite.ddProjection}" items="#{gis$NewSite.projectionData.options}"
                                                            selected="#{gis$SiteSessionBean.selectedProjection}" required="true"
                                                    style="height: 24px; left: 600px; top: 62px; position: absolute" width="192px" submitForm="true" />
                                        
                                    </webuijsf:panelLayout>
                                    <!-- Tab set para las coordenadas y division politica -->
                                    <webuijsf:tabSet id="tabSetSites" lite="true" selected="tabCoordinates" style="height: 440px; width: 840px" styleClass="My_tab_border">
                                        <webuijsf:tab  id="tabCoordinates" text="#{resources.coordinates}">
                                            <webuijsf:panelLayout id="lpCoordinates" style="height: 440px; position: relative; width: 100%; -rave-layout: grid">
                                               
                                                <webuijsf:label binding="#{gis$NewSite.lbWgs84Format}" id="lbWgs84Format" visible = "true"
                                                    style="font-size: 18px; font-style: normal; font-weight: bold; left: 20px; top: 30px; position: absolute" text="#{resources.wgs84format}"/>
                                                <webuijsf:dropDown  actionExpression="#{gis$NewSite.onChangeWGS84Format_action}" visible="true" id="ddWgs84Format" binding="#{gis$NewSite.ddWgs84Format}" items="#{gis$NewSite.wgs84FormatData.options}"
                                                                    selected="#{gis$SiteSessionBean.selectedWgs84Format}"
                                                    style="font-size: 14px; left: 125px; top: 30px; height: 24px; position: absolute" width="120px" submitForm="true" />
                                             
                                                <h:panelGrid columns="2" id="groupProjections" style="height: 440px; width: 840px;top: 60px; position: absolute">
                                                    <webuijsf:panelLayout id="pProjection" style="height: 440px; position: relative; -rave-layout: grid">
                                                        <!-- Panel generico -->
                                                        <webuijsf:panelLayout binding="#{gis$NewSite.panelGeneralProjection}" id="pCoordinates" style="height: 110px; position: relative; -rave-layout: grid">
                                                            <webuijsf:label id="labelLongitude"
                                                                            style="font-size: 16px; font-style: normal; font-weight: bold; left: 24px; top: 24px; position: absolute" text="#{resources.site_logitude}"/>
                                                            <webuijsf:textField binding="#{gis$NewSite.txLongitude}" id="txt_longitude" style="left: 120px; top: 24px; position: absolute; width: 120px"/>
                                                            <webuijsf:label id="labelLatitude"
                                                                            style="font-size: 16px; font-style: normal; font-weight: bold; left: 24px; top: 62px; position: absolute" text="#{resources.site_latitude}"/>
                                                            <webuijsf:textField binding="#{gis$NewSite.txLatitude}" id="txt_latitude" style="left: 120px; top: 62px; position: absolute; width: 120px"/>
                                                        </webuijsf:panelLayout>
                                                        <!-- Panel coordenadas -->
                                                        <webuijsf:panelLayout binding="#{gis$NewSite.panelWGS84Projection}" id="pCoordinatesProjection" style="height: 220px; position: relative;-rave-layout: grid">
                                                            <webuijsf:label id="label10"
                                                                style="font-size: 16px; font-style: normal; font-weight: bold; left: 24px; top: 36px; position: absolute" text="#{resources.longitude}"/>
                                                            <webuijsf:label id="labeldegrees" requiredIndicator="true"
                                                                style="height: 24px; left: 24px; top: 56px; position: absolute; width: 93px" text="#{resources.site_degrees}"/>
                                                            <webuijsf:label id="label12"
                                                                style="height: 24px; left: 24px; top: 80px; position: absolute; width: 93px" text="#{resources.site_minutes}"/>
                                                            <webuijsf:label id="label13"
                                                                style="height: 24px; left: 24px; top: 104px; position: absolute; width: 93px" text="#{resources.site_seconds}"/>
                                                            <webuijsf:label id="label11"
                                                                style="font-size: 16px; font-style: normal; font-weight: bold; left: 24px; top: 148px; position: absolute" text="#{resources.latitude}"/>
                                                            <webuijsf:label id="label14" requiredIndicator="true"
                                                                style="height: 24px; left: 24px; top: 172px; position: absolute; width: 93px" text="#{resources.site_degrees}"/>
                                                            <webuijsf:label id="label15"
                                                                style="height: 24px; left: 24px; top: 196px; position: absolute; width: 93px" text="#{resources.site_minutes}"/>
                                                            <webuijsf:label id="label16"
                                                                style="height: 24px; left: 24px; top: 220px; position: absolute; width: 93px" text="#{resources.site_seconds}"/>
                                                            <webuijsf:textField binding="#{gis$NewSite.txLongitudeDegrees}" id="txt_longitude_degrees"
                                                                style="position: absolute; left: 120px; top: 56px; width: 144px; height: 24px" text="0"/>
                                                            <webuijsf:textField binding="#{gis$NewSite.txLongitudeMinutes}" id="txt_longitude_minutes"
                                                                style="position: absolute; left: 120px; top: 80px; width: 144px; height: 24px" text="0"/>
                                                            <webuijsf:textField binding="#{gis$NewSite.txLongitudeSeconds}" id="txt_longitude_seconds"
                                                                style="position: absolute; left: 120px; top: 104px; width: 144px; height: 24px" text="0"/>
                                                            <webuijsf:textField binding="#{gis$NewSite.txLatitudeDegrees}" id="txt_latitude_degrees"
                                                                style="position: absolute; left: 120px; top: 172px; width: 144px; height: 24px" text="0"/>
                                                            <webuijsf:textField binding="#{gis$NewSite.txLatitudeMinutes}" id="txt_latitude_minutes"
                                                                style="position: absolute; left: 120px; top: 196px; width: 144px; height: 24px" text="0"/>
                                                            <webuijsf:textField binding="#{gis$NewSite.txLatitudeSeconds}" id="txt_latitude_seconds"
                                                                style="position: absolute; left: 120px; top: 220px; width: 144px; height: 24px" text="0"/>
                                                        </webuijsf:panelLayout>
                                                        <webuijsf:panelLayout binding="#{gis$NewSite.panelVerbatimCoordinates}" id="pVerbatimCoordinates" style="height: 265px; position: relative;-rave-layout: grid">
                                                            <webuijsf:label id="lbVerbatimCoordinate"
                                                                            style="font-size: 16px; font-style: normal; font-weight: bold; left: 24px; top: 36px; position: absolute" text="#{resources.site_verbatimCoordinates}"/>
                                                            <webuijsf:label id="lbVerbatimLongitude"
                                                                            style="height: 24px; left: 24px; top: 56px; position: absolute; width: 120px" text="#{resources.site_verbatimLongitude}"/>
                                                            <webuijsf:label id="lbVerbatimLatitude"
                                                                            style="height: 24px; left: 24px; top: 80px; position: absolute; width: 120px" text="#{resources.site_verbatimLatitude}"/>
                                                            <webuijsf:textField binding="#{gis$NewSite.txVerbatimLongitude}" id="txt_longitude_degrees"
                                                                style="position: absolute; left: 140px; top: 56px; width: 144px; height: 24px" text ="0" />
                                                            <webuijsf:textField binding="#{gis$NewSite.txVerbatimLatitude}" id="txt_longitude_minutes"
                                                                style="position: absolute; left: 140px; top: 80px; width: 144px; height: 24px" text ="0"/>
                                                        </webuijsf:panelLayout>
                                                    </webuijsf:panelLayout>
                                                    <webuijsf:panelLayout id="pCoordinatesTable" style="height: 440px; position: relative; -rave-layout: grid">
                                                        <h:commandButton action="#{gis$NewSite.btnAddCoordinate_action}" id="btnAddCoordinate"
                                                            style="height: 24px; left: 12px; top: 24px; position: absolute; width: 130px" value="#{resources.add_new}"/>
                                                        <h:commandButton action="#{gis$NewSite.btnRemoveCoord_action}" id="btnRemoveCoord"
                                                            style="height: 24px; left: 160px; top: 24px; position: absolute; width: 130px" value="#{resources.btnDelete}"/>
                                                        <h:dataTable binding="#{gis$NewSite.dataTableCoordinates}" cellspacing="0" columnClasses="list-columns"
                                                            headerClass="list-header" id="dataTableCoordinates" rowClasses="list-row-even,list-row-odd"
                                                            rows="10" style="border: 1px solid gray; left: 12px; top: 72px; position: absolute; width: 383px"
                                                            value="#{gis$SiteSessionBean.coordinateDataProvider}" var="currentRow" width="600">
                                                            <h:column>
                                                                <f:facet name="header">
                                                                    <h:outputLabel styleClass="My_search_icon" value="#{resources.longitude}"/>
                                                                </f:facet>
                                                                <h:outputText value="#{currentRow.longitude}"/>
                                                            </h:column>
                                                            <h:column>
                                                                <f:facet name="header">
                                                                    <h:outputLabel styleClass="My_search_icon" value="#{resources.latitude}"/>
                                                                </f:facet>
                                                                <h:outputText value="#{currentRow.latitude}"/>
                                                            </h:column>
                                                            <h:column>
                                                                <f:facet name="header">
                                                                    <h:outputLabel styleClass="My_search_icon" value="#{resources.site_verbatimLongitude}"/>
                                                                </f:facet>
                                                                <h:outputText value="#{currentRow.verbatimLongitude}"/>
                                                            </h:column>
                                                            <h:column>
                                                                <f:facet name="header">
                                                                    <h:outputLabel styleClass="My_search_icon" value="#{resources.site_verbatimLatitude}"/>
                                                                </f:facet>
                                                                <h:outputText value="#{currentRow.verbatimLatitude}"/>
                                                            </h:column>
                                                        </h:dataTable>
                                                    </webuijsf:panelLayout>
                                                </h:panelGrid>
                                            </webuijsf:panelLayout>
                                        </webuijsf:tab>
                                        <webuijsf:tab id="tab1" text="#{resources.politicDivision}">
                                            <webuijsf:panelLayout id="lpPoliticDivision" style="height: 263px; position: relative; width: 100%; -rave-layout: grid">
                                                <webuijsf:label id="label_contry" requiredIndicator="true" style="left: 24px; top: 72px; position: absolute" text="#{resources.country}"/>
                                                <webuijsf:dropDown actionExpression="#{gis$NewSite.onCountryChange}" id="dd_country"
                                                    items="#{gis$NewSite.countriesData.options}" selected="#{gis$SiteSessionBean.selectedCountryId}"
                                                    style="left: 168px; top: 72px; position: absolute; width: 120px" submitForm="true" width="192px"/>
                                                <webuijsf:label id="label_province" requiredIndicator="true" style="left: 24px; top: 120px; position: absolute" text="#{resources.state}"/>
                                                <webuijsf:dropDown id="dd_province" items="#{gis$NewSite.provincesData.options}"
                                                    selected="#{gis$SiteSessionBean.selectedProvinceId}"
                                                    style="left: 168px; top: 120px; position: absolute; width: 120px" width="192px"/>
                                            </webuijsf:panelLayout>
                                        </webuijsf:tab>
                                        <webuijsf:tab id="tabGeoreferenceSites" text="#{resources.georeferencing}" actionExpression="#{gis$NewSite.onChangeTab_action}">
                                            <webuijsf:panelLayout id="lpPGeoreferenceSites" style="height: 263px; position: relative; width: 100%; -rave-layout: grid">
                                                <webuijsf:label id="label_GeoreferencedSites" requiredIndicator="true" style="left: 24px; top: 72px; position: absolute" text="#{resources.country}"/>
                                                <h:dataTable binding="#{gis$NewSite.dataTableGeoreferencedSites}" cellspacing="0" columnClasses="list-columns"
                                                    headerClass="list-header" id="dataTableGeoreferencedSites" rowClasses="list-row-even,list-row-odd"
                                                    rows="10" style="border: 1px solid gray; left: 12px; top: 72px; position: absolute; width: 383px"
                                                    value="#{gis$SiteSessionBean.georeferencedSites}" var="currentRow" width="600">
                                                    <h:column>
                                                        <f:facet name="header">
                                                            <h:outputLabel styleClass="My_search_icon" value="#{resources.geographical_layer}"/>
                                                        </f:facet>
                                                        <h:outputText value="#{currentRow.layerName}"/>
                                                    </h:column>
                                                    <h:column>
                                                        <f:facet name="header">
                                                            <h:outputLabel styleClass="My_search_icon" value="#{resources.georeferenced_site}"/>
                                                        </f:facet>
                                                        <h:outputText value="#{currentRow.value}"/>
                                                    </h:column>                                                            
                                                </h:dataTable>
                                            </webuijsf:panelLayout>
                                        </webuijsf:tab> 
                                    </webuijsf:tabSet>
                                </h:panelGrid>
                            </webuijsf:form>
                        </webuijsf:panelLayout>
                        <!-- contenido ends -->
                        <jsp:directive.include file="/Footer.jspf"/>
                    </div>
                    <!-- pageFormated ends -->
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
