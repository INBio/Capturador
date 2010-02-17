<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : AdminGeographicalLayers
    Created on : 16/11/2009, 04:09:01 PM
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
                            <webuijsf:label id="lbTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px" styleClass="Page_title" text="#{resources.admin_geographic_layers}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; top: 48px; position: absolute" width="624">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 30px; width: 550px" warnClass="warnMessage"/>
                                <!-- Botonera -->
                                <webuijsf:panelGroup id="grouppBotonera" style="height: 24px; width: 650px">
                                    <h:commandButton action="#{admin$AdminGeographicalLayers.btn_newValue_action}" binding="#{admin$AdminGeographicalLayers.btnNew}" id="btn_newValue" style="width: 175px"
                                        styleClass="My_Button" value="#{resources.btnNew}"/>
                                        <h:commandButton action="#{admin$AdminGeographicalLayers.btn_editValue_action}" binding="#{admin$AdminGeographicalLayers.btnEdit}" id="btn_editValue" style="width: 175px"
                                        styleClass="My_Button" value="#{resources.btnEdit}"/>
                                </webuijsf:panelGroup>
                                <!-- Fin de la botonera -->
                                <!-- Parte Superior -->
                                <webuijsf:label id="label1" style="font-size: 16px;" styleClass="Page_title" text="#{resources.menuModuleGeographicalLayers}"/>
                                <webuijsf:dropDown actionExpression="#{admin$AdminGeographicalLayers.onGeographicLayerChange}" id="geographicLayerDropDown"
                                    items="#{admin$AdminGeographicLayersSessionBean.geographicLayers.options}"
                                    selected="#{admin$AdminGeographicLayersSessionBean.selectedGeographicLayerDTO.geographicalLayerKey}" submitForm="true" width="175px"/>
                                <!-- Parte Superior -->
                                <webuijsf:label id="label2" style="font-size: 16px;" styleClass="Page_title" text="#{resources.valuesForSelectedGeographicLayer}"/>
                                <webuijsf:panelGroup id="pg1" style="height: 24px; width: 650px">
                                    <!--Valores para la capa seleccionada-->
                                    <webuijsf:dropDown actionExpression="#{admin$AdminGeographicalLayers.onGeographicLayerValueChange}"
                                        id="geographicLayerValueDropDown" items="#{admin$AdminGeographicLayersSessionBean.geographicLayerValues.options}"
                                        selected="#{admin$AdminGeographicLayersSessionBean.selectedGeographicLayerValueDTO.geographicLayerValueKey}"
                                        submitForm="true" width="175px"/>
                                    <!-- fin Valorse para la capa seleccionada-->
                                    <!-- Filtro de valores seleccionados -->
                                    <webuijsf:label id="label3" text="#{resources.filterByCountry}" visible="#{admin$AdminGeographicLayersSessionBean.hasAncestor}"/>
                                    <webuijsf:dropDown actionExpression="#{admin$AdminGeographicalLayers.onAncestorGeographicLayerValueChange}"
                                        id="filterAncestorGeographicLayerValueDropDown"
                                        items="#{admin$AdminGeographicLayersSessionBean.ancestorGeographicLayerValues.options}"
                                        selected="#{admin$AdminGeographicLayersSessionBean.selectedFilterAncestorGeographicLayerId}" submitForm="true"
                                        visible="#{admin$AdminGeographicLayersSessionBean.hasAncestor}" width="175px"/>
                                    <!-- fin filtro -->
                                </webuijsf:panelGroup>
                                <!-- Detalles de creación y edición -->
                                <webuijsf:panelLayout id="editGeographicLayerValuePanel"
                                    style="height: 115px; position: relative; width: 370px; -rave-layout: grid" styleClass="My_subpanel_blue" visible="#{admin$AdminGeographicLayersSessionBean.isEditingValue}">
                                    <webuijsf:label id="label5" style="height: 28px; left: 10px; top: 10px; position: absolute; width:150px" text="#{resources.name}"/>
                                    <webuijsf:textField columns="22" id="textField1" style="left: 160px; top: 10px; position: absolute" text="#{admin$AdminGeographicLayersSessionBean.editingGeographicLayerValueDTO.name}"/>
                                    <webuijsf:label id="label6" style="height: 28px; left: 10px; top: 48px; position: absolute; width: 150px"
                                        text="#{resources.country}" visible="#{admin$AdminGeographicLayersSessionBean.hasAncestor}"/>
                                    <webuijsf:dropDown id="ancestorGLValueDropDown"
                                        items="#{admin$AdminGeographicLayersSessionBean.ancestorGeographicLayerValues.options}"
                                        selected="#{admin$AdminGeographicLayersSessionBean.editingGeographicLayerValueDTO.ancestorGeographicLayerValueKey}"
                                        style="left: 160px; top: 48px; position: absolute" visible="#{admin$AdminGeographicLayersSessionBean.hasAncestor}"/>
                                    <h:commandButton action="#{admin$AdminGeographicalLayers.saveGeographicLayerValue}" id="btn_saveValue"
                                        style="left:160px; top: 82px; position: absolute; width: 175px" value="#{resources.btnSave}"/>
                                </webuijsf:panelLayout>
                                <!-- Fin de detalles -->
                                <jsp:directive.include file="/Footer.jspf"/>
                            </h:panelGrid>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
