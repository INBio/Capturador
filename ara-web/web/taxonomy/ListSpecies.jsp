<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ListSpecies
    Created on : 13/10/2009, 03:06:45 PM
    Author     : esmata
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link id="link1" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <webuijsf:label id="lbTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px" styleClass="Page_title" text="#{resources.species_records}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 30px; width: 840px" warnClass="warnMessage"/>
                                <h:panelGrid cellspacing="1" columns="1" id="gridpTableMain" style="height: 24px" styleClass="My_table" width="840">
                                    <webuijsf:panelGroup id="grouppButtons">
                                        <h:panelGrid columns="1" id="gridpquantity" styleClass="My_table_top" width="840">
                                            <h:outputLabel id="labelQuantity" value="#{taxonomy$ListSpecies.quantityTotal}"/>
                                        </h:panelGrid>
                                        <webuijsf:panelGroup id="panelPaginacion" separator=" " style="margin-left:70px;">
                                            <!-- Botones de acciones -->
                                            <h:commandButton action="#{taxonomy$ListSpecies.newButton_action}" id="newButton" style="margin: 2px;height: 22px"
                                                styleClass="My_Button_table" value="#{resources.btnNew}"/>
                                            <h:commandButton action="#{taxonomy$ListSpecies.editButton_action}" id="editButton" style="margin: 2px;height: 22px"
                                                styleClass="My_Button_table" value="#{resources.btnEdit}"/>
                                            <h:commandButton action="#{taxonomy$ListSpecies.deleteButton_action}" id="deleteButton"
                                                style="margin: 2px;height: 22px" styleClass="My_Button_table" value="#{resources.btnDelete}"/>
                                            <h:commandButton action="#{taxonomy$ListSpecies.previewButton_action}" id="previewButton"
                                            style="margin: 2px;height: 22px" styleClass="My_Button_table" value="#{resources.view_record}"/>
                                            <!-- Botones de paginacion -->
                                            <h:commandButton action="#{taxonomy$SpeciesSessionBean.pagination.firstResults}" id="btnFirst"
                                                rendered="#{taxonomy$SpeciesSessionBean.pagination.isVisiblePrevious}" style="margin: 2px;height: 22px"
                                                styleClass="My_Button_first" value="#{resources.pagination_first}"/>
                                            <h:commandButton action="#{taxonomy$SpeciesSessionBean.pagination.previousResults}" id="btnPrevious"
                                                rendered="#{taxonomy$SpeciesSessionBean.pagination.isVisiblePrevious}" style="margin: 2px;height: 22px"
                                                styleClass="My_Button_previous" value="#{resources.pagination_previous}"/>
                                            <h:commandButton action="#{taxonomy$SpeciesSessionBean.pagination.nextResults}" id="btnNext"
                                                rendered="#{taxonomy$SpeciesSessionBean.pagination.isVisibleNext}" style="margin: 2px; height: 22px"
                                                styleClass="My_Button_next" value="#{resources.pagination_next}"/>
                                            <h:commandButton action="#{taxonomy$SpeciesSessionBean.pagination.lastResults}" id="btnLast"
                                                rendered="#{taxonomy$SpeciesSessionBean.pagination.isVisibleNext}" style="margin: 2px;height: 22px"
                                                styleClass="My_Button_last" value="#{resources.pagination_last}"/>
                                        </webuijsf:panelGroup>
                                    </webuijsf:panelGroup>
                                    <h:dataTable binding="#{taxonomy$ListSpecies.taxonDescriptionTable}" cellspacing="0" columnClasses="list-columns"
                                        headerClass="list-header" id="dataTablegathering" rowClasses="list-row-even,list-row-odd"
                                        rows="#{taxonomy$SpeciesSessionBean.pagination.resultsPerPage}"
                                        style="border-top: solid rgb(214, 218, 221) 2px; border-bottom: solid rgb(214, 218, 221) 2px; border-left: solid rgb(214, 218, 221) 2px; "
                                        value="#{taxonomy$SpeciesSessionBean.pagination.dataProvider.list}" var="currentRow" width="839">
                                        <h:column>
                                            <h:selectBooleanCheckbox id="checkbox1" value="#{currentRow['selected']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <!-- Nombre cientifico -->
                                                <h:outputText value="#{resources.taxon_name}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['taxonDefaultName']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.kingdom}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['kingdomName']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.family}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['familyName']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.sequence}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['taxonDescriptionSequence']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.creation_date}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['creationDate']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.created_by}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['createdBy']}"/>
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
