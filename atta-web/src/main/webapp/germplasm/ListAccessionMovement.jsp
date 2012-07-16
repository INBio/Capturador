<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : AccessionMovement
    Created on : 10/03/2010, 04:04:21 PM
    Author     : dasolano
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
                                <webuijsf:label binding="#{germplasm$ListAccessionMovement.lbTitle}" id="lbTitle"
                                    style="height: 24px; left: 24px; position: relative; width: 850px" styleClass="Page_title" text="#{resources.accession_movements}"/>
                                <webuijsf:label binding="#{germplasm$ListAccessionMovement.lbTitle2}" id="lbTitle2"
                                    style="height: 24px; left: 24px; position: relative; width: 850px" styleClass="Page_title" text="#{resources.current_weigth}"/>
                                <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; position: relative" width="850">
                                    <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                        style="height: 50px; width: 840px" warnClass="warnMessage"/>
                                    <!-- Cuerpo de la pagina -->
                                    <!-- Tabla que posee la lista de accessionmovements -->
                                    <h:panelGrid id="gridpGathering_Main" style="position: relative" width="850">
                                        <!-- panel de busquedas -->

                                        <h:panelGrid cellspacing="1" columns="1" id="gridpTableMain" style="height: 24px" styleClass="My_table" width="840">
                                            <webuijsf:panelGroup id="grouppButtons">
                                                <h:panelGrid columns="1" id="gridpquantity" styleClass="My_table_top" width="840">
                                                    <h:outputLabel id="labelQuantity" value="#{germplasm$ListAccessionMovement.quantityTotal}"/>
                                                </h:panelGrid>
                                                <webuijsf:panelGroup id="panelPaginacion" separator=" " style="margin-left:70px;">
                                                    <!-- Botones de acciones -->
                                                    <h:commandButton action="#{germplasm$ListAccessionMovement.btn_new_action}" id="btn_new"
                                                        style="margin: 2px;height: 22px" styleClass="My_Button_table" value="#{resources.new}"/>
                                                    <h:commandButton action="#{germplasm$ListAccessionMovement.btn_edit_action}" id="btn_edit"
                                                        style="margin: 2px;height: 22px" styleClass="My_Button_table" value="#{resources.btnEdit}"/>
                                                    <h:commandButton action="#{germplasm$ListAccessionMovement.btn_delete_action}" id="btn_delete"
                                                            style="margin: 2px;height: 22px" styleClass="My_Button_table" value="#{resources.btnDelete}"/>
                                                    <!-- Botones de paginacion -->
                                                    <h:commandButton action="#{germplasm$AccessionMovementSessionBean.pagination.firstResults}" id="btnFirst"
                                                        rendered="#{germplasm$AccessionMovementSessionBean.pagination.isVisiblePrevious}"
                                                        style="margin: 2px;height: 22px" styleClass="My_Button_first" value="#{resources.pagination_first}"/>
                                                    <h:commandButton action="#{germplasm$AccessionMovementSessionBean.pagination.previousResults}"
                                                        id="btnPrevious" rendered="#{germplasm$AccessionMovementSessionBean.pagination.isVisiblePrevious}"
                                                        style="margin: 2px;height: 22px" styleClass="My_Button_previous" value="#{resources.pagination_previous}"/>
                                                    <h:commandButton action="#{germplasm$AccessionMovementSessionBean.pagination.nextResults}" id="btnNext"
                                                        rendered="#{germplasm$AccessionMovementSessionBean.pagination.isVisibleNext}"
                                                        style="margin: 2px; height: 22px" styleClass="My_Button_next" value="#{resources.pagination_next}"/>
                                                    <h:commandButton action="#{germplasm$AccessionMovementSessionBean.pagination.lastResults}" id="btnLast"
                                                        rendered="#{germplasm$AccessionMovementSessionBean.pagination.isVisibleNext}"
                                                        style="margin: 2px;height: 22px" styleClass="My_Button_last" value="#{resources.pagination_last}"/>
                                                </webuijsf:panelGroup>
                                            </webuijsf:panelGroup>
                                            <h:dataTable binding="#{germplasm$ListAccessionMovement.dataTableAccessionMovements}" cellspacing="0"
                                                columnClasses="list-columns" headerClass="list-header" id="dataTablegathering"
                                                rowClasses="list-row-even,list-row-odd" rows="#{germplasm$AccessionMovementSessionBean.pagination.resultsPerPage}"
                                                style="border-top: solid rgb(214, 218, 221) 2px; border-bottom: solid rgb(214, 218, 221) 2px; border-left: solid rgb(214, 218, 221) 2px; "
                                                value="#{germplasm$AccessionMovementSessionBean.pagination.dataProvider.list}" var="currentRow" width="839">
                                                <h:column>
                                                    <h:selectBooleanCheckbox id="checkbox1" value="#{currentRow['selected']}"/>
                                                </h:column>
                                                <h:column>
                                                    <f:facet name="header">
                                                        <h:outputText value="#{resources.accession_movement_date}"/>
                                                    </f:facet>
                                                    <h:outputText value="#{currentRow['accessionMovementDate']}"/>
                                                </h:column>
                                                <h:column>
                                                    <f:facet name="header">
                                                        <h:outputText value="#{resources.weight}"/>
                                                    </f:facet>
                                                    <h:outputText value="#{currentRow['weight']}"/>
                                                </h:column>
                                                <h:column>
                                                    <f:facet name="header">
                                                        <h:outputText value="#{resources.accession_movement_type}"/>
                                                    </f:facet>
                                                    <h:outputText value="#{currentRow['accessionMovementType']}"/>
                                                </h:column>
                                                <h:column>
                                                    <f:facet name="header">
                                                        <h:outputText value="#{resources.responsable_person}"/>
                                                    </f:facet>
                                                    <h:outputText value="#{currentRow['responsablePerson']}"/>
                                                </h:column>
                                                <h:column>
                                                    <f:facet name="header">
                                                        <h:outputText value="#{resources.notes}"/>
                                                    </f:facet>
                                                    <h:outputText value="#{currentRow['notes']}"/>
                                                </h:column>
                                            </h:dataTable>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <!-- FIN Tabla que posee la lista de accessiones -->
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
