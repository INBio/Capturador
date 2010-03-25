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
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:link id="link2" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <webuijsf:label binding="#{germplasm$ListAccessionMovement.lbTitle}" id="lbTitle"
                                style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px" styleClass="Page_title" text="#{resources.accession_movements}"/>
                            <webuijsf:label binding="#{germplasm$ListAccessionMovement.lbTitle2}" id="lbTitle2"
                                style="height: 24px; left: 24px; top: 50px; position: absolute; width: 850px" styleClass="Page_title" text="#{resources.current_weigth}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; top: 80px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 50px; width: 840px" warnClass="warnMessage"/>
                                <!-- Cuerpo de la pagina -->
                                <!-- Tabla que posee la lista de accessionmovements -->
                                <h:panelGrid id="gridpGathering_Main" style="position: relative" width="850">
                                    <!-- panel de busquedas -->
                                    <!-- <h:panelGrid columns="3" id="gridpSearch" style="height: 24px" width="719">
                                            <h:inputText binding="#{germplasm$ListPassport.txSearch}" id="txSearch" style="height: 18px; width: 408px">
                                                <f:validateLength maximum="100" minimum="0"/>
                                            </h:inputText>
                                            <h:commandButton action="#{germplasm$ListPassport.btnPassportSearch_action}" binding="#{germplasm$ListPassport.btnSearch}"
                                                id="btnGatheringSearch" style="height: 25px; width: 160px" styleClass="My_Button" value="#{resources.search}"/>
                                            <h:commandButton action="#{germplasm$ListPassport.btnAdvPassportSearch_action}"
                                                             binding="#{germplasm$ListPassport.btnAdvSearch}" id="btnAdvGatheringSearch" style="height: 25px; width: 160px"
                                                styleClass="My_Button" value="#{resources.advanced_search}"/>
                                        </h:panelGrid>
                                        <h:panelGrid binding="#{germplasm$ListPassport.gridpAdvancedSearch}" columns="1" id="gridpAdvancedSearch"
                                            rendered="false" style="height: 5px" styleClass="My_panel_blue" width="680">

                                            <h:panelGrid columns="1" id="gridpAdvancedSearch1" style="height: 24px" width="780">

                                                <h:panelGrid columns="4" id="gridpAS1" style="height: 24px" width="780">

                                                    <webuijsf:label id="labelPassportId" style="width: 168px; height: 24px"
                                                                text="#{resources.passport_id}"/>
                                                    <webuijsf:textField
                                                                        id="textFieldPassportId" style="width: 200px;"
                                                                        text="#{germplasm$PassportListSessionBean.queryPassportDTO.passportId}"/>


                                                    <webuijsf:label id="labelSampleStatus" style="width: 168px; height: 24px" text="#{resources.sle_sample_status}"/>
                                                    <webuijsf:dropDown id="dropdownSampleStatus"
                                                                       items="#{germplasm$ListPassport.sampleStatus.options}"
                                                                       selected="#{germplasm$PassportListSessionBean.queryPassportDTO.sampleStatusId}" width="200px"/>


                                                </h:panelGrid>

                                                <h:panelGrid columns="2" id="gridpAS2" style="height: 24px" width="390">



                                                    <h:commandButton action="#{germplasm$ListPassport.btnAdvSearchPassport_action}" id="btnAdvSearchGO"
                                                    style="width: 160px" styleClass="My_Button" value="#{resources.button_proceed}"/>

                                                </h:panelGrid>

                                            </h:panelGrid>

                                        </h:panelGrid>-->
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
                                                <!--<h:commandButton action="#{inventory$ListGathering.btnGatheringDelete}" id="btn_delete"
                                                        style="margin: 2px;height: 22px" styleClass="My_Button_table" value="#{resources.btnDelete}"/>
                                                    -->
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
                                <!-- FIN Tabla que posee la lista de passport -->
                                <jsp:directive.include file="/Footer.jspf"/>
                            </h:panelGrid>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
