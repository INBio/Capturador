<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : EditSite
    Created on : 18/11/2009, 09:17:16 AM
    Author     : esmata
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:link id="link2" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <webuijsf:label id="lbTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px" styleClass="Page_title" text="#{resources.titleLocationEdit}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 55px; width: 840px" warnClass="warnMessage"/>
                                <!-- Botonera -->
                                <webuijsf:panelGroup id="grouppBotonera" style="height: 24px; width: 840px">
                                    <h:commandButton action="#{gis$EditSite.btnNewSite_action}" id="btnNewSite" style="height: 24px; width: 175px"
                                        styleClass="My_Button" value="#{resources.btnSave}"/>
                                </webuijsf:panelGroup>
                                <!-- Panel de detalles del sitios -->
                                <webuijsf:panelLayout id="PanelDetails" style="height: 164px; position: relative; width: 840px; -rave-layout: grid" styleClass="My_subpanel_blue">
                                    <webuijsf:label id="lbDescription" requiredIndicator="true"
                                        style="height: 24px; left: 48px; top: 24px; position: absolute; width: 164px" text="#{resources.description}"/>
                                    <webuijsf:label for="ddType" id="lbType" style="height: 24px; left: 48px; top: 77px; position: absolute; width: 164px" text="#{resources.type}"/>
                                    <webuijsf:label for="ddBaseProjection" id="lbBaseProy"
                                        style="height: 24px; left: 48px; top: 101px; position: absolute; width: 164px" text="#{resources.base_proyection}"/>
                                    <webuijsf:label for="ddDetermination" id="lbDetermination"
                                        style="height: 24px; left: 48px; top: 125px; position: absolute; width: 164px" text="#{resources.determination_method}"/>

                                    <!-- <webuijsf:textArea binding="#{gis$EditSite.txaDescription}" columns="23" id="txaDescription" required="true"
                                        style="position: absolute; left: 216px; top: 24px; width: 168px; height: 24px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>-->
                                    <webuijsf:textArea binding="#{gis$EditSite.txaDescription}" columns="23" id="txaDescription" required="true"
                                        style="position: absolute; left: 216px; top: 24px; width: 168px; height: 24px"/>
                                        
                                    <webuijsf:dropDown binding="#{gis$EditSite.ddType}" id="ddType" items="#{gis$EditSite.typeData.options}" required="true"
                                        selected="#{gis$SiteSessionBean.currentSiteDTO.featureTypeId}"
                                        style="position: absolute; left: 216px; top: 77px; height: 24px" width="192px"/>
                                    <webuijsf:dropDown binding="#{gis$EditSite.ddBaseProjection}" id="ddBaseProjection"
                                        items="#{gis$EditSite.baseProjectionData.options}" required="true"
                                        selected="#{gis$SiteSessionBean.currentSiteDTO.baseProjectionId}"
                                        style="position: absolute; left: 216px; top: 101px; height: 24px" width="192px"/>
                                    <webuijsf:dropDown binding="#{gis$EditSite.ddDetermination}" id="ddDetermination"
                                        items="#{gis$EditSite.determinationMethodData.options}" required="true"
                                        selected="#{gis$SiteSessionBean.currentSiteDTO.siteCalculationMethodId}"
                                        style="position: absolute; left: 216px; top: 125px; height: 24px" width="192px"/>
                                    <webuijsf:label for="txPresition" id="lbPresition"
                                        style="height: 24px; left: 432px; top: 24px; position: absolute; width: 164px" text="#{resources.presition}"/>
                                    <webuijsf:label for="ddOrigProjection" id="lbProjection"
                                        style="height: 20px; left: 432px; top: 48px; position: absolute; width: 164px" text="#{resources.orig_proyection}"/>
                                    <webuijsf:label for="txDatum" id="lbDatum" style="height: 24px; left: 432px; top: 72px; position: absolute; width: 164px" text="#{resources.datum}"/>
                                    <webuijsf:textField binding="#{gis$EditSite.txPresition}" columns="25" id="txPresition"
                                        style="height: 24px; left: 600px; top: 24px; position: absolute; width: 192px" validatorExpression="#{util$ValidatorBean.longNumberFormatValidator}"/>
                                    <webuijsf:dropDown binding="#{gis$EditSite.ddOrigProjection}" id="ddOrigProjection"
                                        items="#{gis$EditSite.originProjectionData.options}" required="true"
                                        selected="#{gis$SiteSessionBean.currentSiteDTO.originalProjectionId}"
                                        style="height: 24px; left: 600px; top: 48px; position: absolute" width="192px"/>
                                    <webuijsf:textField binding="#{gis$EditSite.txDatum}" columns="25" id="txDatum"
                                        style="height: 24px; left: 600px; top: 72px; position: absolute; width: 192px" validatorExpression="#{util$ValidatorBean.longNumberFormatValidator}"/>
                                </webuijsf:panelLayout>
                                <!-- Tab set para las coordenadas y division politica -->
                                <webuijsf:tabSet id="tabSetSites" lite="true" selected="tabCoordinates" style="height: 284px; width: 840px" styleClass="My_tab_border">
                                    <webuijsf:tab id="tabCoordinates" text="#{resources.coordinates}">
                                        <webuijsf:panelLayout id="lpCoordinates" style="height: 263px; position: relative; width: 100%; -rave-layout: grid">
                                            <webuijsf:label id="label10"
                                                style="font-size: 16px; font-style: normal; font-weight: bold; left: 24px; top: 24px; position: absolute" text="#{resources.longitude}"/>
                                            <webuijsf:textField binding="#{gis$EditSite.txLongitudeDegrees}" id="txt_longitude_degrees" style="left: 120px; top: 48px; position: absolute; width: 120px"/>
                                            <webuijsf:label id="label11"
                                                style="font-size: 16px; font-style: normal; font-weight: bold; left: 24px; top: 144px; position: absolute" text="#{resources.latitude}"/>
                                            <webuijsf:textField binding="#{gis$EditSite.txLatitudeDegrees}" id="txt_latitude_degrees" style="left: 120px; top: 168px; position: absolute; width: 120px"/>
                                            <h:commandButton action="#{gis$EditSite.btnAddCoordinate_action}" id="btnAddCoordinate"
                                                style="height: 24px; left: 336px; top: 24px; position: absolute; width: 130px" value="#{resources.add_new}"/>
                                            <h:commandButton action="#{gis$EditSite.btnRemoveCoord_action}" id="btnRemoveCoord"
                                                style="height: 24px; left: 480px; top: 24px; position: absolute; width: 130px" value="#{resources.btnDelete}"/>
                                            <h:dataTable binding="#{gis$EditSite.dataTableCoordinates}" cellspacing="0" columnClasses="list-columns"
                                                headerClass="list-header" id="dataTableCoordinates" rowClasses="list-row-even,list-row-odd" rows="10"
                                                style="border: 1px solid gray; left: 336px; top: 72px; position: absolute; width: 383px"
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
                                            </h:dataTable>
                                            <webuijsf:label id="labelgrados" requiredIndicator="true"
                                                style="height: 24px; left: 24px; top: 48px; position: absolute; width: 93px" text="#{resources.site_degrees}"/>
                                            <webuijsf:label id="label12" style="height: 24px; left: 24px; top: 72px; position: absolute; width: 93px" text="#{resources.site_minutes}"/>
                                            <webuijsf:label id="label13" style="height: 24px; left: 24px; top: 96px; position: absolute; width: 93px" text="#{resources.site_seconds}"/>
                                            <webuijsf:label id="label14" requiredIndicator="true"
                                                style="height: 24px; left: 24px; top: 168px; position: absolute; width: 93px" text="#{resources.site_degrees}"/>
                                            <webuijsf:label id="label15" style="height: 24px; left: 24px; top: 192px; position: absolute; width: 93px" text="#{resources.site_minutes}"/>
                                            <webuijsf:label id="label16" style="height: 24px; left: 24px; top: 216px; position: absolute; width: 93px" text="#{resources.site_seconds}"/>
                                            <webuijsf:textField binding="#{gis$EditSite.txLongitudeMinutes}" id="txt_longitude_minutes"
                                                style="position: absolute; left: 120px; top: 72px; width: 144px; height: 24px" text="0"/>
                                            <webuijsf:textField binding="#{gis$EditSite.txLongitudeSeconds}" id="txt_longitude_seconds"
                                                style="position: absolute; left: 120px; top: 96px; width: 144px; height: 24px" text="0"/>
                                            <webuijsf:textField binding="#{gis$EditSite.txLatitudeMinutes}" id="txt_latitude_minutes"
                                                style="position: absolute; left: 120px; top: 192px; width: 144px; height: 24px" text="0"/>
                                            <webuijsf:textField binding="#{gis$EditSite.txLatitudeSeconds}" id="txt_latitude_seconds"
                                                style="position: absolute; left: 120px; top: 216px; width: 144px; height: 24px" text="0"/>
                                        </webuijsf:panelLayout>
                                    </webuijsf:tab>
                                    <webuijsf:tab id="tab1" text="#{resources.politicDivision}">
                                        <webuijsf:panelLayout id="lpPoliticDivision" style="height: 263px; position: relative; width: 100%; -rave-layout: grid">
                                            <webuijsf:label id="label_contry" requiredIndicator="true" style="left: 24px; top: 72px; position: absolute" text="#{resources.country}"/>
                                            <webuijsf:dropDown actionExpression="#{gis$EditSite.onCountryChange}" id="dd_country"
                                                items="#{gis$EditSite.countriesData.options}" selected="#{gis$SiteSessionBean.selectedCountryId}"
                                                style="left: 168px; top: 72px; position: absolute; width: 120px" submitForm="true" width="192px"/>
                                            <webuijsf:label id="label_province" requiredIndicator="true" style="left: 24px; top: 120px; position: absolute" text="#{resources.state}"/>
                                            <webuijsf:dropDown id="dd_province" items="#{gis$EditSite.provincesData.options}"
                                                selected="#{gis$SiteSessionBean.selectedProvinceId}"
                                                style="left: 168px; top: 120px; position: absolute; width: 120px" width="192px"/>
                                        </webuijsf:panelLayout>
                                    </webuijsf:tab>
                                </webuijsf:tabSet>
                                <jsp:directive.include file="/Footer.jspf"/>
                            </h:panelGrid>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
