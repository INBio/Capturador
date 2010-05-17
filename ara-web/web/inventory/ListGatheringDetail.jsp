<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ListGatheringDetail
    Created on : 02/09/2009, 09:07:15 AM
    Author     : esmata
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link2" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <webuijsf:label id="lbDetailTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px"
                                styleClass="Page_title" text="#{resources.collect_details}: #{inventory$GatheringDetailSessionBean.currentGathering.gatheringObservationId}"/>
                            <h:panelGrid id="gridpDetail" style="height: 24px; left: 24px; top: 48px; position: absolute" width="672">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msgListDetail" infoClass="infoMessage"
                                    style="height: 40px; width: 650px" warnClass="warnMessage"/>
                                <h:panelGrid cellspacing="1" columns="1" id="gridpTableMain" style="height: 24px" styleClass="My_table" width="650">
                                    <webuijsf:panelGroup id="grouppButtons">
                                        <h:panelGrid columns="1" id="gridpquantity" styleClass="My_table_top" width="650">
                                            <h:outputLabel id="labelQuantity" value="#{inventory$ListGatheringDetail.quantityTotal}"/>
                                        </h:panelGrid>
                                        <webuijsf:panelGroup id="panelPaginacion" separator=" " style="margin-left:70px;">
                                            <!-- Botones de acciones -->
                                            <h:commandButton action="#{inventory$ListGatheringDetail.btnNewDetail_action}" id="btnNewDetail"
                                                style="margin: 2px;height: 22px" styleClass="My_Button_table" value="#{resources.btnNew}"/>
                                            <h:commandButton action="#{inventory$ListGatheringDetail.btnEditDetail_action}" style="margin: 2px;height: 22px"
                                                styleClass="My_Button_table" value="#{resources.btnEdit}"/>
                                            <h:commandButton action="#{inventory$ListGatheringDetail.btnDeleteDetail_action}" style="margin: 2px;height: 22px"
                                                styleClass="My_Button_table" value="#{resources.btnDelete}"/>
                                            <!-- Botones de paginacion -->
                                            <h:commandButton action="#{inventory$GatheringDetailSessionBean.pagination.firstResults}" id="btnFirst"
                                                rendered="#{inventory$GatheringDetailSessionBean.pagination.isVisiblePrevious}" style="margin: 2px;height: 22px"
                                                styleClass="My_Button_first" value="#{resources.pagination_first}"/>
                                            <h:commandButton action="#{inventory$GatheringDetailSessionBean.pagination.previousResults}" id="btnPrevious"
                                                rendered="#{inventory$GatheringDetailSessionBean.pagination.isVisiblePrevious}" style="margin: 2px;height: 22px"
                                                styleClass="My_Button_previous" value="#{resources.pagination_previous}"/>
                                            <h:commandButton action="#{inventory$GatheringDetailSessionBean.pagination.nextResults}" id="btnNext"
                                                rendered="#{inventory$GatheringDetailSessionBean.pagination.isVisibleNext}" style="margin: 2px;height: 22px"
                                                styleClass="My_Button_next" value="#{resources.pagination_next}"/>
                                            <h:commandButton action="#{inventory$GatheringDetailSessionBean.pagination.lastResults}" id="btnLast"
                                                rendered="#{inventory$GatheringDetailSessionBean.pagination.isVisibleNext}" style="margin: 2px;height: 22px"
                                                styleClass="My_Button_last" value="#{resources.pagination_last}"/>
                                        </webuijsf:panelGroup>
                                    </webuijsf:panelGroup>
                                    <h:dataTable binding="#{inventory$ListGatheringDetail.dataTableGathering}" cellspacing="0" columnClasses="list-columns"
                                        headerClass="list-header" id="dataTableDetail" rowClasses="list-row-even,list-row-odd"
                                        rows="#{inventory$GatheringDetailSessionBean.pagination.resultsPerPage}"
                                        style="border-top: solid rgb(214, 218, 221) 2px; border-bottom: solid rgb(214, 218, 221) 2px; border-left: solid rgb(214, 218, 221) 2px; "
                                        value="#{inventory$GatheringDetailSessionBean.pagination.dataProvider.list}" var="currentRow" width="650">
                                        <h:column>
                                            <h:selectBooleanCheckbox id="checkbox1" value="#{currentRow['selected']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.gathering_observation_id}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['gatheringObservationId']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.person_in_charge}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['gatheringObservationDetailPersonName']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.gathering_number}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['gatheringObservationDetailNumber']}"/>
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
