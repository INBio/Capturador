<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ListDublinCore
    Created on : 23/09/2010, 02:57:30 PM
    Author     : dasolano
-->

<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head  binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link id="link1" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <div id="pageFormated">
                        <jsp:directive.include file="/Header.jspf"/>
                        <webuijsf:panelLayout id="contenido">
                            <webuijsf:form id="form1">
                                <h:outputLabel id="lbTitle" style="height: 24px; left: 24px; position: relative; width: 850px" styleClass="Page_title" value="#{resources.list_dublin_core}"/>
                                <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; position: relative;width:95%;">
                                    <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                        style="height: 50px; width: 840px" warnClass="warnMessage"/>

                                    <!-- Tabla que posee la lista de sementals -->
                                    <h:panelGrid id="gridpGathering_Main" style="position: relative;width:100%">

                                        <h:panelGrid binding="#{dublincore$ListDublinCore.gridDublinCore}">
                                                <!-- panelGrid que contiene los botones de búsquedas -->
                                                <h:panelGrid columns="3" id="gridpSearch" style="height: 24px;width:100%">
                                                    <h:inputText binding="#{dublincore$ListDublinCore.txSearch}" id="txSearch" style="height: 18px; width: 408px">
                                                        <f:validateLength maximum="100" minimum="0"/>
                                                    </h:inputText>
                                                    <h:commandButton action="#{dublincore$ListDublinCore.btnSimpleSearch_action}" binding="#{dublincore$ListDublinCore.btnSearch}" id="btnDublinCoreSearch"
                                                        style="height: 25px; width: 160px" styleClass="My_Button" value="#{resources.search}"/>
                                                    <h:commandButton action="#{dublincore$ListDublinCore.btnAdvSearch_action}" binding="#{dublincore$ListDublinCore.btnAdvSearch}" id="btnAdvDublinCoreSearch"
                                                        style="height: 25px; width: 160px" styleClass="My_Button" value="#{resources.advanced_search}"/>
                                                </h:panelGrid>
                                                <!-- panelGrid que contiene los elementos para la búsqueda avanzada -->
                                                <h:panelGrid binding="#{dublincore$ListDublinCore.gridpAdvancedSearch}" columns="1" id="gridpAdvancedSearch" rendered="false"
                                                    style="height: 5px;width:100%;" styleClass="My_panel_blue">
                                                    <!-- formulario para la búsqueda avanzada -->
                                                    <h:panelGrid columns="4" id="gridpAdvancedSearch1" style="height: 24px;width:100%;">
                                                        <webuijsf:label for="txTitle" id="lbTitle2" text="#{resources.title_dublin_core}"/>
                                                        <webuijsf:textField binding="#{dublincore$ListDublinCore.txTitle}" id="txTitle" />
                                                        <webuijsf:label for="txCreator" id="lbCreator" text="#{resources.author_dublin_core}"/>
                                                        <webuijsf:textField binding="#{dublincore$ListDublinCore.txCreator}" id="txCreator" />
                                                        <webuijsf:label for="txDate" id="lbDate" text="#{resources.year_dublin_core}"/>
                                                        <webuijsf:textField binding="#{dublincore$ListDublinCore.txYear}" id="txYear" />
                                                        <webuijsf:label for="txIdentifier" id="lbIdentifier" text="#{resources.identifier_dublin_core}"/>
                                                        <webuijsf:textField binding="#{dublincore$ListDublinCore.txIdentifier}" id="txIdentifier" />
                                                    </h:panelGrid>
                                                    <!-- panelGrid que con el botón "Proceder" -->
                                                    <h:panelGrid columns="2" id="gridpAS2" style="height: 24px;width:100%;">
                                                        <h:commandButton action="#{dublincore$ListDublinCore.btnProceedSearch_action}" id="btnAdvSearchGO"
                                                        style="width: 160px" styleClass="My_Button" value="#{resources.button_proceed}"/>
                                                    </h:panelGrid>
                                                </h:panelGrid>

                                            </h:panelGrid>
                                            <h:panelGrid cellspacing="1" columns="1" id="gridpTableMain" style="width:100%" styleClass="My_table">

                                                <webuijsf:panelGroup id="grouppButtons">

                                                    <h:panelGrid columns="1" id="gridpquantity" styleClass="My_table_top" style="width:100%">
                                                        <h:outputLabel id="labelQuantity" value="#{dublincore$ListDublinCore.quantityTotal}"/>
                                                    </h:panelGrid>

                                                    <webuijsf:panelGroup id="panelPaginacion" separator=" " style="margin-left:70px;">

                                                        <!-- Botones de acciones -->
                                                        <h:commandButton action="#{dublincore$ListDublinCore.btn_new_action}" id="btn_new"
                                                            style="margin: 2px;height: 22px" styleClass="My_Button_table" value="#{resources.new}"/>
                                                        <h:commandButton action="#{dublincore$ListDublinCore.btn_edit_action}" id="btn_edit"
                                                            style="margin: 2px;height: 22px" styleClass="My_Button_table" value="#{resources.btnEdit}"/>
                                                        <h:commandButton action="#{dublincore$ListDublinCore.btn_delete_action}" id="btn_delete"
                                                                style="margin: 2px;height: 22px" styleClass="My_Button_table" value="#{resources.btnDelete}"/>

                                                        <!-- Botones de paginacion -->
                                                        <h:commandButton action="#{dublincore$DublinCoreSessionBean.pagination.firstResults}" id="btnFirst"
                                                                         rendered="#{dublincore$DublinCoreSessionBean.pagination.isVisiblePrevious}"
                                                            style="margin: 2px;height: 22px" styleClass="My_Button_first" value="#{resources.pagination_first}"/>
                                                        <h:commandButton action="#{dublincore$DublinCoreSessionBean.pagination.previousResults}" id="btnPrevious"
                                                                         rendered="#{dublincore$DublinCoreSessionBean.pagination.isVisiblePrevious}"
                                                            style="margin: 2px;height: 22px" styleClass="My_Button_previous" value="#{resources.pagination_previous}"/>
                                                        <h:commandButton action="#{dublincore$DublinCoreSessionBean.pagination.nextResults}" id="btnNext"
                                                                         rendered="#{dublincore$DublinCoreSessionBean.pagination.isVisibleNext}" style="margin: 2px; height: 22px"
                                                            styleClass="My_Button_next" value="#{resources.pagination_next}"/>
                                                        <h:commandButton action="#{dublincore$DublinCoreSessionBean.pagination.lastResults}" id="btnLast"
                                                                         rendered="#{dublincore$DublinCoreSessionBean.pagination.isVisibleNext}" style="margin: 2px;height: 22px"
                                                            styleClass="My_Button_last" value="#{resources.pagination_last}"/>
                                                    </webuijsf:panelGroup>
                                                </webuijsf:panelGroup>

                                                <h:dataTable binding="#{dublincore$ListDublinCore.dataTableDublinCore}" cellspacing="0" columnClasses="list-columns"
                                                             headerClass="list-header" id="dataTablegathering" rowClasses="list-row-even,list-row-odd"
                                                             rows="#{dublincore$DublinCoreSessionBean.pagination.resultsPerPage}"
                                                             style="border-top: solid rgb(214, 218, 221) 2px; border-bottom: solid rgb(214, 218, 221) 2px; border-left: solid rgb(214, 218, 221) 2px;width:100%;"
                                                             value="#{dublincore$DublinCoreSessionBean.pagination.dataProvider.list}" var="currentRow">
                                                    <h:column>

                                                        <h:selectBooleanCheckbox id="checkbox1" value="#{currentRow.selected}"/>

                                                    </h:column>

                                                    <h:column>
                                                        <f:facet name="header">
                                                            <h:outputText value="#{resources.title_dublin_core}"/>
                                                        </f:facet>
                                                        <h:outputText value="#{currentRow.title}"/>
                                                    </h:column>

                                                    <h:column>
                                                        <f:facet name="header">
                                                            <h:outputText value="#{resources.author_dublin_core}"/>
                                                        </f:facet>
                                                        <h:outputText value="#{currentRow.creator}"/>
                                                    </h:column>
                                                    <h:column>
                                                        <f:facet name="header">
                                                            <h:outputText value="#{resources.identifier_dublin_core}"/>
                                                        </f:facet>
                                                        <h:outputText value="#{currentRow.identifier}"/>
                                                    </h:column>
                                                    <h:column>
                                                        <f:facet name="header">
                                                            <h:outputText value="#{resources.year_dublin_core}"/>
                                                        </f:facet>
                                                        <h:outputText value="#{currentRow.date}"/>
                                                    </h:column>

                                                </h:dataTable>
                                            </h:panelGrid>
                                    </h:panelGrid>
                                    <!-- FIN Tabla que posee la lista de breeds -->
                                </h:panelGrid>
                            </webuijsf:form>
                        </webuijsf:panelLayout> <!-- contenido ends -->
                        <jsp:directive.include file="/Footer.jspf"/>
                    </div> <!-- pageFormated ends -->
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
