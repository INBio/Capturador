<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ListPerson
    Created on : 06/10/2009, 02:34:27 PM
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
                                <h:outputLabel id="lbTitle" style="height: 24px; left: 24px; position: relative; width: 850px"
                                                styleClass="Page_title" value="#{resources.menuModulePeople}"/>
                                <h:panelGrid columns="1" id="gridpMain" style="left: 24px; position: relative;width:95%">
                                    <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                                style="height: 30px; width: 840px" warnClass="warnMessage"/>
                                    <h:panelGrid columns="2" id="gridpSearch" style="height: 24px">
                                        <h:inputText binding="#{admin$ListPerson.txSimpleSearch}" id="txSimpleSearch" style="height: 18px; width: 408px">
                                            <f:validateLength maximum="100" minimum="0"/>
                                        </h:inputText>
                                        <h:commandButton action="#{admin$ListPerson.btnSimpleSearch_action}"
                                                         binding="#{admin$ListPerson.btnSimpleSearch}" id="btnSimpleSearch" style="height: 25px; width: 160px"
                                                         styleClass="My_Button" value="#{resources.search}">
                                        </h:commandButton>
                                    </h:panelGrid>                                    
                                   <h:panelGrid cellspacing="1" columns="1" id="gridpTableMain" style="width:100%" styleClass="My_table">
                                        <webuijsf:panelGroup id="grouppButtons">
                                            <h:panelGrid columns="1" id="gridpquantity" styleClass="My_table_top" style="width:100%">
                                                <h:outputLabel id="labelQuantity" value="#{admin$ListPerson.quantityTotal}"/>
                                            </h:panelGrid>
                                            <webuijsf:panelGroup id="panelPaginacion" separator=" " style="margin-left:70px;">
                                                <!-- Botones de acciones -->
                                                <h:commandButton id="newButton" value="#{resources.btnNew}" action="#{admin$ListPerson.btnPersonNew}"
                                                style="margin: 2px;height: 22px" styleClass="My_Button_table"/>
                                                <h:commandButton id="editButton" value="#{resources.btnEdit}" action="#{admin$ListPerson.btnPersonEdit}"
                                                style="margin: 2px;height: 22px" styleClass="My_Button_table"/>
                                                <h:commandButton id="deleteButton" value="#{resources.btnDelete}" action="#{admin$ListPerson.btnPersonDelete}"
                                                style="margin: 2px;height: 22px" styleClass="My_Button_table"/>
                                                <!-- Botones de paginacion -->
                                                <h:commandButton action="#{admin$PersonSessionBean.pagination.firstResults}" id="btnFirst"
                                                    rendered="#{admin$PersonSessionBean.pagination.isVisiblePrevious}" style="margin: 2px;height: 22px"
                                                    styleClass="My_Button_first" value="#{resources.pagination_first}"/>
                                                <h:commandButton action="#{admin$PersonSessionBean.pagination.previousResults}" id="btnPrevious"
                                                    rendered="#{admin$PersonSessionBean.pagination.isVisiblePrevious}" style="margin: 2px;height: 22px"
                                                    styleClass="My_Button_previous" value="#{resources.pagination_previous}"/>
                                                <h:commandButton action="#{admin$PersonSessionBean.pagination.nextResults}" id="btnNext"
                                                    rendered="#{admin$PersonSessionBean.pagination.isVisibleNext}" style="margin: 2px; height: 22px"
                                                    styleClass="My_Button_next" value="#{resources.pagination_next}"/>
                                                <h:commandButton action="#{admin$PersonSessionBean.pagination.lastResults}" id="btnLast"
                                                    rendered="#{admin$PersonSessionBean.pagination.isVisibleNext}" style="margin: 2px;height: 22px"
                                                    styleClass="My_Button_last" value="#{resources.pagination_last}"/>
                                            </webuijsf:panelGroup>
                                        </webuijsf:panelGroup>
                                        <h:dataTable binding="#{admin$ListPerson.personTable}" cellspacing="0" columnClasses="list-columns" headerClass="list-header" id="dataTablegathering"
                                            rowClasses="list-row-even,list-row-odd" rows="#{admin$PersonSessionBean.pagination.resultsPerPage}"
                                            style="border-top: solid rgb(214, 218, 221) 2px; border-bottom: solid rgb(214, 218, 221) 2px; border-left: solid rgb(214, 218, 221) 2px;width:100%;"
                                            value="#{admin$PersonSessionBean.pagination.dataProvider.list}" var="currentRow">
                                            <h:column>
                                                <h:selectBooleanCheckbox id="checkbox1" value="#{currentRow['selected']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.name}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['firstName']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.last_name}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['lastName']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.second_last_name}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['secondLastName']}"/>
                                            </h:column>
                                        </h:dataTable>
                                    </h:panelGrid>
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
