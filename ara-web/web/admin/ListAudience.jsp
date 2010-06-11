<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ListAudience
    Created on : 05/10/2009, 10:29:39 AM
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
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <webuijsf:label id="lbTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px"
                                            styleClass="Page_title" text="#{resources.menuModuleAudiences}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                            style="height: 30px; width: 840px" warnClass="warnMessage"/>

                               <h:panelGrid cellspacing="1" columns="1" id="gridpTableMain" style="height: 24px" styleClass="My_table" width="840">
                                    <webuijsf:panelGroup id="grouppButtons">
                                        <h:panelGrid columns="1" id="gridpquantity" styleClass="My_table_top" width="840">
                                            <h:outputLabel id="labelQuantity" value="#{admin$ListAudience.quantityTotal}"/>
                                        </h:panelGrid>
                                        <webuijsf:panelGroup id="panelPaginacion" separator=" " style="margin-left:70px;">
                                            <!-- Botones de acciones -->
                                            <h:commandButton id="newButton" value="#{resources.btnNew}" action="#{admin$ListAudience.btnAudienceNew}"
                                            style="margin: 2px;height: 22px" styleClass="My_Button_table"/>
                                            <h:commandButton id="editButton" value="#{resources.btnEdit}" action="#{admin$ListAudience.btnAudienceEdit}"
                                            style="margin: 2px;height: 22px" styleClass="My_Button_table"/>
                                            <h:commandButton id="deleteButton" value="#{resources.btnDelete}" action="#{admin$ListAudience.btnAudienceDelete}"
                                            style="margin: 2px;height: 22px" styleClass="My_Button_table"/>
                                            <!-- Botones de paginacion -->
                                            <h:commandButton action="#{admin$AudienceSessionBean.pagination.firstResults}" id="btnFirst"
                                                rendered="#{admin$AudienceSessionBean.pagination.isVisiblePrevious}" style="margin: 2px;height: 22px"
                                                styleClass="My_Button_first" value="#{resources.pagination_first}"/>
                                            <h:commandButton action="#{admin$AudienceSessionBean.pagination.previousResults}" id="btnPrevious"
                                                rendered="#{admin$AudienceSessionBean.pagination.isVisiblePrevious}" style="margin: 2px;height: 22px"
                                                styleClass="My_Button_previous" value="#{resources.pagination_previous}"/>
                                            <h:commandButton action="#{admin$AudienceSessionBean.pagination.nextResults}" id="btnNext"
                                                rendered="#{admin$AudienceSessionBean.pagination.isVisibleNext}" style="margin: 2px; height: 22px"
                                                styleClass="My_Button_next" value="#{resources.pagination_next}"/>
                                            <h:commandButton action="#{admin$AudienceSessionBean.pagination.lastResults}" id="btnLast"
                                                rendered="#{admin$AudienceSessionBean.pagination.isVisibleNext}" style="margin: 2px;height: 22px"
                                                styleClass="My_Button_last" value="#{resources.pagination_last}"/>
                                        </webuijsf:panelGroup>
                                    </webuijsf:panelGroup>
                                    <h:dataTable binding="#{admin$ListAudience.audiencesTable}" cellspacing="0" columnClasses="list-columns" headerClass="list-header" id="dataTablegathering"
                                        rowClasses="list-row-even,list-row-odd" rows="#{admin$AudienceSessionBean.pagination.resultsPerPage}"
                                        style="border-top: solid rgb(214, 218, 221) 2px; border-bottom: solid rgb(214, 218, 221) 2px; border-left: solid rgb(214, 218, 221) 2px; "
                                        value="#{admin$AudienceSessionBean.pagination.dataProvider.list}" var="currentRow" width="839">
                                        <h:column>
                                            <h:selectBooleanCheckbox id="checkbox1" value="#{currentRow['selected']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.name}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['name']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.description}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['description']}"/>
                                        </h:column>
                                    </h:dataTable>
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
