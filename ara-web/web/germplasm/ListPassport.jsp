<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : ListPassport
    Created on : 09/02/2010, 09:49:31 AM
    Author     : dasolano
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
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
                            <webuijsf:label id="lbTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px" styleClass="Page_title" text="#{resources.passports}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 50px; width: 840px" warnClass="warnMessage"/>


                                <h:panelGrid rendered="false" columns="1" id="panelAlert" binding="#{germplasm$ListPassport.alertMessage}" >
                                    <webuijsf:label text="#{resources.have_accesions}" style="color: red" />
                                    <h:panelGrid columns="2" id="butonsAlert" >
                                        <h:commandButton action="#{germplasm$ListPassport.btn_confirm_delete_action}"
                                            style="height: 25px; width: 160px"
                                            styleClass="My_Button" value="#{resources.acept}"/>
                                        <h:commandButton action="#{germplasm$ListPassport.btn_cancel_delete_action}"
                                            style="height: 25px; width: 160px"
                                            styleClass="My_Button" value="#{resources.cancel}"/>
                                    </h:panelGrid>
                                </h:panelGrid>

                                <!-- Cuerpo de la pagina -->
                                <!-- Tabla que posee la lista de passport -->
                                <h:panelGrid binding="#{germplasm$ListPassport.mainPanel}"
                                    id="gridpGathering_Main" style="position: relative" width="850">
                                    <!-- panel de busquedas -->
                                    <h:panelGrid columns="3" id="gridpSearch" style="height: 24px" width="719">
                                        <h:inputText binding="#{germplasm$ListPassport.txSearch}" id="txSearch" style="height: 18px; width: 408px">
                                            <f:validateLength maximum="100" minimum="0"/>
                                        </h:inputText>
                                        <h:commandButton action="#{germplasm$ListPassport.btnPassportSearch_action}"
                                            binding="#{germplasm$ListPassport.btnSearch}" id="btnGatheringSearch" style="height: 25px; width: 160px"
                                            styleClass="My_Button" value="#{resources.search}"/>
                                        <h:commandButton action="#{germplasm$ListPassport.btnAdvPassportSearch_action}"
                                            binding="#{germplasm$ListPassport.btnAdvSearch}" id="btnAdvGatheringSearch" style="height: 25px; width: 160px"
                                            styleClass="My_Button" value="#{resources.advanced_search}"/>
                                    </h:panelGrid>
                                    <h:panelGrid binding="#{germplasm$ListPassport.gridpAdvancedSearch}" columns="1" id="gridpAdvancedSearch" rendered="false"
                                        style="height: 5px" styleClass="My_panel_blue" width="680">
                                        <h:panelGrid columns="1" id="gridpAdvancedSearch1" style="height: 24px" width="780">
                                            <h:panelGrid columns="4" id="gridpAS1" style="height: 24px" width="780">
                                                <webuijsf:label id="labelPassportId" style="width: 168px; height: 24px" text="#{resources.passport_id}"/>
                                                <webuijsf:textField id="textFieldPassportId" style="width: 200px;" text="#{germplasm$PassportListSessionBean.queryPassportDTO.passportId}"/>
                                                <webuijsf:label id="labelPlantNusersryDate" text="#{resources.plant_nursery_date}"/>
                                                <webuijsf:calendar binding="#{germplasm$ListPassport.plantNurseryDate}" columns="15"
                                                    dateFormatPattern="dd-MM-yyyy" id="plantNusersryDate"/>
                                                <webuijsf:label id="labelGatheringId" style="width: 168px; height: 24px" text="#{resources.gathering_number}"/>
                                                <webuijsf:textField id="textFieldGatheringId" style="width: 200px;" text="#{germplasm$PassportListSessionBean.queryPassportDTO.gatheringId}"/>
                                                <webuijsf:label for="labelPlantingSeasonDate" text="#{resources.plantation_date}"/>
                                                <webuijsf:calendar binding="#{germplasm$ListPassport.plantingSeasonDate}" columns="15"
                                                    dateFormatPattern="dd-MM-yyyy" id="PlantingSeasonDate"/>
                                                <webuijsf:label id="labelMissionNumber" style="width: 168x; height: 24px" text="#{resources.mission_number}"/>
                                                <webuijsf:textField id="textFieldMissionNumber" style="width: 200px;" text="#{germplasm$PassportListSessionBean.queryPassportDTO.missionNumber}"/>
                                                <webuijsf:label for="labelHarvestingSeasonDate" text="#{resources.harvesting_date}"/>
                                                <webuijsf:calendar binding="#{germplasm$ListPassport.harvestingSeasonDate}" columns="15"
                                                    dateFormatPattern="dd-MM-yyyy" id="HarvestingSeasonDate"/>
                                                <webuijsf:label id="labelDonorPerson" style="width: 168px; height: 24px" text="#{resources.donor_person}"/>
                                                <webuijsf:dropDown id="dropdownDonorPerson" items="#{germplasm$ListPassport.donorPersons.options}"
                                                    selected="#{germplasm$PassportListSessionBean.queryPassportDTO.donorPersonId}" width="200px"/>
                                                <webuijsf:label id="labelMaterialType" style="width: 168px; height: 24px" text="#{resources.sle_material_type}"/>
                                                <webuijsf:dropDown id="dropdownMaterialType" items="#{germplasm$ListPassport.materialTypes.options}"
                                                    selected="#{germplasm$PassportListSessionBean.queryPassportDTO.materialTypeId}" width="200px"/>
                                                <webuijsf:label id="labelDonorInstitution" style="width: 168px; height: 24px" text="#{resources.donor_institution}"/>
                                                <webuijsf:dropDown id="dropdownDonorInstitution" items="#{germplasm$ListPassport.donorInstitutions.options}"
                                                    selected="#{germplasm$PassportListSessionBean.queryPassportDTO.donorInstitutionId}" width="200px"/>
                                                <webuijsf:label id="labelSampleStatus" style="width: 168px; height: 24px" text="#{resources.sle_sample_status}"/>
                                                <webuijsf:dropDown id="dropdownSampleStatus" items="#{germplasm$ListPassport.sampleStatus.options}"
                                                    selected="#{germplasm$PassportListSessionBean.queryPassportDTO.sampleStatusId}" width="200px"/>
                                            </h:panelGrid>
                                            <h:panelGrid columns="2" id="gridpAS2" style="height: 24px" width="390">
                                                <h:commandButton action="#{germplasm$ListPassport.btnAdvSearchPassport_action}" id="btnAdvSearchGO"
                                                    style="width: 160px" styleClass="My_Button" value="#{resources.button_proceed}"/>
                                            </h:panelGrid>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <h:panelGrid cellspacing="1" columns="1" id="gridpTableMain" style="height: 24px" styleClass="My_table" width="840">
                                        <webuijsf:panelGroup id="grouppButtons">
                                            <h:panelGrid columns="1" id="gridpquantity" styleClass="My_table_top" width="840">
                                                <h:outputLabel id="labelQuantity" value="#{germplasm$ListPassport.quantityTotal}"/>
                                            </h:panelGrid>
                                            <webuijsf:panelGroup id="panelPaginacion" separator=" " style="margin-left:70px;">
                                                <!-- Botones de acciones -->
                                                <h:commandButton action="#{germplasm$ListPassport.btn_new_action}" id="btn_new" style="margin: 2px;height: 22px"
                                                    styleClass="My_Button_table" value="#{resources.new}"/>
                                                <h:commandButton action="#{germplasm$ListPassport.btn_edit_action}" id="btn_edit"
                                                    style="margin: 2px;height: 22px" styleClass="My_Button_table" value="#{resources.btnEdit}"/>
                                                <h:commandButton action="#{germplasm$ListPassport.btn_delete_action}" id="btn_delete"
                                                        style="margin: 2px;height: 22px" styleClass="My_Button_table" value="#{resources.btnDelete}"/>
                                                    
                                                <!-- Botones de paginacion -->
                                                <h:commandButton action="#{germplasm$PassportListSessionBean.pagination.firstResults}" id="btnFirst"
                                                    rendered="#{germplasm$PassportListSessionBean.pagination.isVisiblePrevious}"
                                                    style="margin: 2px;height: 22px" styleClass="My_Button_first" value="#{resources.pagination_first}"/>
                                                <h:commandButton action="#{germplasm$PassportListSessionBean.pagination.previousResults}" id="btnPrevious"
                                                    rendered="#{germplasm$PassportListSessionBean.pagination.isVisiblePrevious}"
                                                    style="margin: 2px;height: 22px" styleClass="My_Button_previous" value="#{resources.pagination_previous}"/>
                                                <h:commandButton action="#{germplasm$PassportListSessionBean.pagination.nextResults}" id="btnNext"
                                                    rendered="#{germplasm$PassportListSessionBean.pagination.isVisibleNext}" style="margin: 2px; height: 22px"
                                                    styleClass="My_Button_next" value="#{resources.pagination_next}"/>
                                                <h:commandButton action="#{germplasm$PassportListSessionBean.pagination.lastResults}" id="btnLast"
                                                    rendered="#{germplasm$PassportListSessionBean.pagination.isVisibleNext}" style="margin: 2px;height: 22px"
                                                    styleClass="My_Button_last" value="#{resources.pagination_last}"/>
                                            </webuijsf:panelGroup>
                                        </webuijsf:panelGroup>
                                        <h:dataTable binding="#{germplasm$ListPassport.dataTablePassport}" cellspacing="0" columnClasses="list-columns"
                                            headerClass="list-header" id="dataTablegathering" rowClasses="list-row-even,list-row-odd"
                                            rows="#{germplasm$PassportListSessionBean.pagination.resultsPerPage}"
                                            style="border-top: solid rgb(214, 218, 221) 2px; border-bottom: solid rgb(214, 218, 221) 2px; border-left: solid rgb(214, 218, 221) 2px; "
                                            value="#{germplasm$PassportListSessionBean.pagination.dataProvider.list}" var="currentRow" width="839">
                                            <h:column>
                                                <h:selectBooleanCheckbox id="checkbox1" value="#{currentRow['selected']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.passport_id}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['passportId']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.donor_person}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['person']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.donor_institution}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['institution']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.gathering_observation_id}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['gatheringId']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.sle_material_type}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['materialType']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.plant_nursery_date}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['plantNurseryDate']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.plantation_date}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['plantingSeasonDate']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.harvesting_date}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['harvestingSeasonDate']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.mission_number}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['missionNumber']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.sle_sample_status}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['sampleStatus']}"/>
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
