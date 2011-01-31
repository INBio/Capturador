<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ListAccession
    Created on : 03/03/2010, 11:38:54 AM
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
                                <h:outputLabel id="lbTitle" style="height: 24px; left: 24px; position: relative; width: 850px" styleClass="Page_title" value="#{resources.accessions}"/>
                                <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; position: relative" width="850">
                                    <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                        style="height: 50px; width: 840px" warnClass="warnMessage"/>

                                    <h:panelGrid rendered="false" columns="1" id="panelAlert" binding="#{germplasm$ListAccession.alertMessage}" >
                                        <webuijsf:label text="#{resources.have_accesions}" style="color: red" />
                                        <h:panelGrid columns="2" id="butonsAlert" >
                                            <h:commandButton action="#{germplasm$ListAccession.btn_confirm_delete_action}"
                                                style="height: 25px; width: 160px"
                                                styleClass="My_Button" value="#{resources.acept}"/>
                                            <h:commandButton action="#{germplasm$ListAccession.btn_cancel_delete_action}"
                                                style="height: 25px; width: 160px"
                                                styleClass="My_Button" value="#{resources.cancel}"/>
                                        </h:panelGrid>
                                    </h:panelGrid>

                                    <!-- Tabla que posee la lista de accesiones -->
                                    <h:panelGrid binding="#{germplasm$ListAccession.mainPanel}" id="gridpGathering_Main" style="position: relative" width="850">
                                        <!-- panel de busquedas -->
                                        <h:panelGrid columns="3" id="gridpSearch" style="height: 24px" width="719">
                                            <h:inputText binding="#{germplasm$ListAccession.txSearchAccession}" id="txSearchAccession" style="height: 18px; width: 408px">
                                                <f:validateLength maximum="100" minimum="0"/>
                                            </h:inputText>
                                            <h:commandButton action="#{germplasm$ListAccession.btnAccessionSearch_action}"
                                                binding="#{germplasm$ListAccession.btnSearchAccession}" id="btnAccessionSearch" style="height: 25px; width: 160px"
                                                styleClass="My_Button" value="#{resources.search}"/>
                                            <h:commandButton action="#{germplasm$ListAccession.btnAdvAccessiontSearch_action}"
                                                binding="#{germplasm$ListAccession.btnAdvSearchAccession}" id="btnAdvAccessionSearch"
                                                style="height: 25px; width: 160px" styleClass="My_Button" value="#{resources.advanced_search}"/>
                                        </h:panelGrid>
                                        <h:panelGrid binding="#{germplasm$ListAccession.gridpAdvancedSearchAccession}" columns="1" id="gridpAdvancedSearch"
                                            rendered="false" style="height: 5px" styleClass="My_panel_blue" width="680">
                                            <h:panelGrid columns="1" id="gridpAdvancedSearch1" style="height: 24px" width="780">
                                                <h:panelGrid columns="4" id="gridpAS1" style="height: 24px" width="780">
                                                    <webuijsf:label id="labelAcessionNumber" style="width: 168px; height: 24px" text="#{resources.accession_number}"/>
                                                    <webuijsf:textField id="textFieldAcessionNumber" style="width: 200px;" text="#{germplasm$AccessionSessionBean.queryAccessionDTO.accessionNumber}"/>
                                                    <webuijsf:label id="labelOriginalWeigth" style="width: 168px; height: 24px" text="#{resources.original_weigth}"/>
                                                    <webuijsf:textField id="textFieldOriginalWeigth" style="width: 200px;" text="#{germplasm$AccessionSessionBean.queryAccessionDTO.originalWeigth}"/>
                                                    <webuijsf:label id="labelFatherAccession" style="width: 168px; height: 24px" text="#{resources.accession_parent}"/>
                                                    <webuijsf:textField id="textFieldFatherAccession" style="width: 200px;" text="#{germplasm$AccessionSessionBean.queryAccessionDTO.accessionParentId}"/>
                                                    <webuijsf:label id="labelCurrentWeigth" style="width: 168px; height: 24px" text="#{resources.current_weigth}"/>
                                                    <webuijsf:textField id="textFieldCurrentWeigth" style="width: 200px;" text="#{germplasm$AccessionSessionBean.queryAccessionDTO.currentWeigth}"/>
                                                    <webuijsf:label id="labelPassport" style="width: 168px; height: 24px" text="#{resources.passport_id}"/>
                                                    <webuijsf:textField id="textFieldPassport" style="width: 200px;" text="#{germplasm$AccessionSessionBean.queryAccessionDTO.passportId}"/>
                                                    <webuijsf:label id="labelGerminationMethod" style="width: 168px; height: 24px" text="#{resources.germination_method_type}"/>
                                                    <webuijsf:dropDown id="dropdownGerminationMethod" items="#{germplasm$ListAccession.germinationMethod.options}"
                                                        selected="#{germplasm$AccessionSessionBean.queryAccessionDTO.germinationMethodTypeId}" width="160px"/>
                                                    <webuijsf:label id="labelResponsablePerson" style="width: 168px; height: 24px" text="#{resources.responsable_person}"/>
                                                    <webuijsf:dropDown id="dropdownResponsablePerson" items="#{germplasm$ListAccession.responsablePerson.options}"
                                                        selected="#{germplasm$AccessionSessionBean.queryAccessionDTO.responsablePersonId}" width="160px"/>
                                                    <webuijsf:label id="labelGerminationRate" style="width: 168px; height: 24px" text="#{resources.germination_rate}"/>
                                                    <webuijsf:textField id="textFieldGerminationRate" style="width: 200px;" text="#{germplasm$AccessionSessionBean.queryAccessionDTO.germinationRate}"/>
                                                    <webuijsf:label id="labelPackages" style="width: 168px; height: 24px" text="#{resources.packages}"/>
                                                    <webuijsf:textField id="textFieldPackages" style="width: 200px;" text="#{germplasm$AccessionSessionBean.queryAccessionDTO.packages}"/>
                                                </h:panelGrid>
                                                <h:panelGrid columns="2" id="gridpAS2" style="height: 24px" width="390">
                                                    <h:commandButton action="#{germplasm$ListAccession.btnAdvSearchAccession_action}" id="btnAdvSearchGO"
                                                        style="width: 160px" styleClass="My_Button" value="#{resources.button_proceed}"/>
                                                </h:panelGrid>
                                            </h:panelGrid>
                                        </h:panelGrid>
                                        <h:panelGrid cellspacing="1" columns="1" id="gridpTableMainAcession" style="height: 24px" styleClass="My_table" width="840">
                                            <webuijsf:panelGroup id="grouppButtonsAcession">
                                                <h:panelGrid columns="1" id="gridpquantityAcession" styleClass="My_table_top" width="840">
                                                    <h:outputLabel id="labelQuantityAcession" value="#{germplasm$ListAccession.quantityTotalAccession}"/>
                                                </h:panelGrid>
                                                <webuijsf:panelGroup id="panelPaginacionAcession" separator=" " style="margin-left:70px;">
                                                    <!-- Botones de acciones -->
                                                    <h:commandButton action="#{germplasm$ListAccession.btn_new_action}" id="btn_new"
                                                        style="margin: 2px;height: 22px" styleClass="My_Button_table" value="#{resources.new}"/>
                                                    <h:commandButton action="#{germplasm$ListAccession.btn_edit_action}" id="btn_edit"
                                                        style="margin: 2px;height: 22px" styleClass="My_Button_table" value="#{resources.btnEdit}"/>
                                                    -<h:commandButton action="#{germplasm$ListAccession.btn_delete_action}" id="btn_delete"
                                                                style="margin: 2px;height: 22px" styleClass="My_Button_table" value="#{resources.btnDelete}"/>

                                                    <!-- Botones de paginacion -->
                                                    <h:commandButton action="#{germplasm$AccessionSessionBean.pagination.firstResults}" id="btnFirstAcession"
                                                        rendered="#{germplasm$AccessionSessionBean.pagination.isVisiblePrevious}" style="margin: 2px;height: 22px"
                                                        styleClass="My_Button_first" value="#{resources.pagination_first}"/>
                                                    <h:commandButton action="#{germplasm$AccessionSessionBean.pagination.previousResults}"
                                                        id="btnPreviousAcession" rendered="#{germplasm$AccessionSessionBean.pagination.isVisiblePrevious}"
                                                        style="margin: 2px;height: 22px" styleClass="My_Button_previous" value="#{resources.pagination_previous}"/>
                                                    <h:commandButton action="#{germplasm$AccessionSessionBean.pagination.nextResults}" id="btnNextAcession"
                                                        rendered="#{germplasm$AccessionSessionBean.pagination.isVisibleNext}" style="margin: 2px; height: 22px"
                                                        styleClass="My_Button_next" value="#{resources.pagination_next}"/>
                                                    <h:commandButton action="#{germplasm$AccessionSessionBean.pagination.lastResults}" id="btnLastAcession"
                                                        rendered="#{germplasm$AccessionSessionBean.pagination.isVisibleNext}" style="margin: 2px;height: 22px"
                                                        styleClass="My_Button_last" value="#{resources.pagination_last}"/>
                                                </webuijsf:panelGroup>
                                            </webuijsf:panelGroup>
                                            <h:dataTable binding="#{germplasm$ListAccession.dataTableAccession}" cellspacing="0" columnClasses="list-columns"
                                                headerClass="list-header" id="dataTablegatheringAcession" rowClasses="list-row-even,list-row-odd"
                                                rows="#{germplasm$AccessionSessionBean.pagination.resultsPerPage}"
                                                style="border-top: solid rgb(214, 218, 221) 2px; border-bottom: solid rgb(214, 218, 221) 2px; border-left: solid rgb(214, 218, 221) 2px; "
                                                value="#{germplasm$AccessionSessionBean.pagination.dataProvider.list}" var="currentRow" width="839">
                                                <h:column>
                                                    <h:selectBooleanCheckbox id="checkbox1Acession" value="#{currentRow['selected']}"/>
                                                </h:column>
                                                <h:column>
                                                    <f:facet name="header">
                                                        <h:outputText value="#{resources.accession_number}"/>
                                                    </f:facet>
                                                    <h:outputText value="#{currentRow['accessionNumber']}"/>
                                                </h:column>
                                                <h:column>
                                                    <f:facet name="header">
                                                        <h:outputText value="#{resources.packages}"/>
                                                    </f:facet>
                                                    <h:outputText value="#{currentRow['packages']}"/>
                                                </h:column>
                                                <h:column>
                                                    <f:facet name="header">
                                                        <h:outputText value="#{resources.original_weigth}"/>
                                                    </f:facet>
                                                    <h:outputText value="#{currentRow['originalWeigth']}"/>
                                                </h:column>
                                                <h:column>
                                                    <f:facet name="header">
                                                        <h:outputText value="#{resources.current_weigth}"/>
                                                    </f:facet>
                                                    <h:outputText value="#{currentRow['currentWeigth']}"/>
                                                </h:column>
                                                <h:column>
                                                    <f:facet name="header">
                                                        <h:outputText value="#{resources.responsable_person}"/>
                                                    </f:facet>
                                                    <h:outputText value="#{currentRow['responsablePerson']}"/>
                                                </h:column>
                                                <h:column>
                                                    <f:facet name="header">
                                                        <h:outputText value="#{resources.passport_id}"/>
                                                    </f:facet>
                                                    <h:outputText value="#{currentRow['passportId']}"/>
                                                </h:column>
                                                <h:column>
                                                    <f:facet name="header">
                                                        <h:outputText value="#{resources.accession_parent}"/>
                                                    </f:facet>
                                                    <h:outputText value="#{currentRow['accessionParent']}"/>
                                                </h:column>
                                                <h:column>
                                                    <f:facet name="header">
                                                        <h:outputText value="#{resources.germination_method_type}"/>
                                                    </f:facet>
                                                    <h:outputText value="#{currentRow['germinationMethodType']}"/>
                                                </h:column>
                                                <h:column>
                                                    <f:facet name="header">
                                                        <h:outputText value="#{resources.germination_rate}"/>
                                                    </f:facet>
                                                    <h:outputText value="#{currentRow['germinationRate']}"/>
                                                </h:column>
                                            </h:dataTable>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <!-- FIN Tabla que posee la lista de accesiones -->
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
