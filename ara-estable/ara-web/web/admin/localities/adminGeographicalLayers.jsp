<?xml version="1.0" encoding="UTF-8"?>
<!-- 
	Document   : listSelectionList
	Created on : Feb 24, 2009, 9:49:20 AM
	Author     : jgutierrez
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <!-- Acá inicia el headerr -->
                            <f:facet name="header"/>
                            <f:facet name="header"/>
                            <f:facet name="header"/>
                            <!-- Fin del headerr -->

                            <!-- Mensajes de informacion/eror-->
                            <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1" infoClass="infoMessage"
                                style="left: 480px; top: 120px; position: absolute" warnClass="warnMessage"/>


                            <!-- Parte Superior -->
                            <webuijsf:label id="label1" style="font-size: 24px; height: 28px; left: 24px; top: 120px; position: absolute; width: 334px" text="#{resources.menuModuleGeographicalLayers}"/>
                            <webuijsf:dropDown id="geographicLayerDropDown"
                                    items="#{admin$localities$AdminGeographicLayersSessionBean.geographicLayers.options}"
                                    selected="#{admin$localities$AdminGeographicLayersSessionBean.selectedGeographicLayerDTO.geographicalLayerKey}"
                                    submitForm="true" actionExpression="#{admin$localities$AdminGeographicLayersSessionBean.onGeographicLayerChange}"
                                    style="left: 24px; top: 168px; position: absolute" />
                            <!-- Parte Superior -->

                            <!--Valorse para la capa seleccionada-->
                            <webuijsf:label id="label2" style="font-size: 24px; height: 28px; left: 24px; top: 240px; position: absolute; width: 574px" text="#{resources.valuesForSelectedGeographicLayer}"/>
                            <webuijsf:dropDown id="geographicLayerValueDropDown"
                                items="#{admin$localities$AdminGeographicLayersSessionBean.geographicLayerValues.options}"
                                selected="#{admin$localities$AdminGeographicLayersSessionBean.selectedGeographicLayerValueDTO.geographicLayerValueKey}"
                                submitForm="true" actionExpression="#{admin$localities$AdminGeographicLayersSessionBean.onGeographicLayerValueChange}"
                                style="left: 24px; top: 288px; position: absolute" />
                            <!-- fin Valorse para la capa seleccionada-->
                            <!-- Filtro de valores seleccionados -->
                            <webuijsf:label id="label3" style="height: 28px; left: 275px; top: 288px; position: absolute"
                                visible="#{admin$localities$AdminGeographicLayersSessionBean.hasAncestor}" text="#{resources.filterByCountry}"/>
                            <webuijsf:dropDown id="filterAncestorGeographicLayerValueDropDown" visible="#{admin$localities$AdminGeographicLayersSessionBean.hasAncestor}"
                                items="#{admin$localities$AdminGeographicLayersSessionBean.ancestorGeographicLayerValues.options}"
                                selected="#{admin$localities$AdminGeographicLayersSessionBean.selectedFilterAncestorGeographicLayerId}"
                                submitForm="true" actionExpression="#{admin$localities$AdminGeographicLayersSessionBean.onAncestorGeographicLayerValueChange}"
                                style="left: 424px; top: 288px; position: absolute" />
                            <!-- fin filtro -->

                            <!-- botones -->
                            <webuijsf:button actionExpression="#{admin$localities$AdminGeographicLayersSessionBean.newGeographicLayerValue}" id="btn_newValue"
                                style="left: 50px; top: 340px; position: absolute; width: 96px" text="#{resources.new}"/>
                            <webuijsf:button actionExpression="#{admin$localities$AdminGeographicLayersSessionBean.editGeographicLayerValue}" id="btn_editValue"
                                style="left: 170px; top: 340px; position: absolute; width: 96px" text="#{resources.edit}"/>
                            <!-- fin botones -->

                            <!-- Detalles-->
                            <!--<webuijsf:label id="label4" style="font-size: 24px; height: 28px; left: 24px; top: 340px; position: absolute; width: 574px" text="~Detalles:~"/>-->
                            <webuijsf:panelLayout id="editGeographicLayerValuePanel" visible="#{admin$localities$AdminGeographicLayersSessionBean.isEditingValue}">
                                <webuijsf:label id="label5" style="height: 28px; left: 150px; top: 388px; position: absolute; width: 574px" text="#{resources.name}"/>
                                <webuijsf:textField id="textField1" style="left: 300px; top: 388px; position: absolute" text="#{admin$localities$AdminGeographicLayersSessionBean.editingGeographicLayerValueDTO.name}"/>
                                <webuijsf:label id="label6" style="height: 28px; left: 150px; top: 438px; position: absolute; width: 574px" text="#{resources.country}" visible="#{admin$localities$AdminGeographicLayersSessionBean.hasAncestor}"/>
                                <webuijsf:dropDown id="ancestorGLValueDropDown" visible="#{admin$localities$AdminGeographicLayersSessionBean.hasAncestor}"
                                items="#{admin$localities$AdminGeographicLayersSessionBean.ancestorGeographicLayerValues.options}"
                                selected="#{admin$localities$AdminGeographicLayersSessionBean.selectedGeographicLayerValueDTO.ancestorGeographicLayerValueKey}"
                                    style="left: 300px; top: 438px; position: absolute" />
                                <webuijsf:button actionExpression="#{admin$localities$AdminGeographicLayersSessionBean.saveGeographicLayerValue}" id="btn_saveValue"
                                style="left: 225px; top: 488px; position: absolute; width: 96px" text="#{resources.save}"/>
                            </webuijsf:panelLayout>

                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
