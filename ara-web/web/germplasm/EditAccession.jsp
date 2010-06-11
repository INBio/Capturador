<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : EditAccession
    Created on : 09/03/2010, 11:57:22 AM
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
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <webuijsf:label binding="#{germplasm$EditAccession.lbTitle}" id="lbTitle"
                                style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px" styleClass="Page_title" text="#{resources.edit_accession}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 50px; width: 840px" warnClass="warnMessage"/>
                                <webuijsf:panelGroup id="grouppBotoneraPassport" style="height: 24px; width: 840px">
                                    <!-- update button -->
                                    <h:commandButton action="#{germplasm$EditAccession.updateAccessionButton_action}" id="updatePassportButton"
                                        style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.update}"/>
                                    <!-- movements button -->
                                    <h:commandButton action="#{germplasm$EditAccession.accession_movements_action}" id="accessionMovements"
                                        style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.movements}"/>
                                </webuijsf:panelGroup>
                                <webuijsf:tabSet id="tabSet1" lite="true" selected="tabGeneralInformation" styleClass="My_panel_blue">
                                    <webuijsf:tab id="tabGeneralInformation" text="#{resources.general_information}">
                                        <h:panelGrid columns="1" style="position: relative" width="850">
                                            <h:panelGrid columns="5" style="position: relative" width="850">
                                                <webuijsf:label id="labelAccessionNumber" style="width: 260px; height: 24px" text="#{resources.accession_number}"/>
                                                <webuijsf:textField columns="27" id="textFieldAccessionNumber" required="true" style="width: 220px;" text="#{germplasm$AccessionSessionBean.editAccessionDTO.accessionNumber}"/>
                                                <webuijsf:label id="labelPasaporteAsociado" style="width: 260px; height: 24px" text="#{resources.associated_passport}"/>
                                                <webuijsf:textField columns="27" disabled="true" id="textFieldPasaporteAsociado" style="width: 220px;" text="#{germplasm$AccessionSessionBean.editAccessionDTO.passportId}"/>
                                                <!-- clear passport button -->
                                                <h:commandButton action="#{germplasm$EditAccession.clearAssociatedPassport}" id="clearPassport"
                                                    style="height: 24px; width: 100px" styleClass="My_Button" value="#{resources.clear}"/>
                                                <webuijsf:label id="labelCollectionType" style="width: 168px; height: 24px" text="#{resources.collection_type}"/>
                                                <webuijsf:dropDown id="dropdownCollectionType" items="#{germplasm$EditAccession.collectionType.options}"
                                                    required="true" selected="#{germplasm$AccessionSessionBean.editAccessionDTO.collectionTypeId}" width="200px"/>
                                                <webuijsf:label id="labelAccessionParentNumber" style="width: 260px; height: 24px" text="#{resources.father_accession_number}"/>
                                                <webuijsf:textField columns="27" disabled="true" id="textFieldAccessionParentNumber" style="width: 220px;" text="#{germplasm$AccessionSessionBean.editAccessionDTO.accessionParent}"/>
                                                <!-- clear accession button -->
                                                <h:commandButton action="#{germplasm$EditAccession.clearAssociatedFatherAccession}" id="clearAccession"
                                                    style="height: 24px; width: 100px" styleClass="My_Button" value="#{resources.clear}"/>
                                                <webuijsf:label id="labelResponsablePerson" style="width: 168px; height: 24px" text="#{resources.responsable_person}"/>
                                                <webuijsf:dropDown id="dropdownResponsablePerson" items="#{germplasm$EditAccession.responsablePerson.options}"
                                                    selected="#{germplasm$AccessionSessionBean.editAccessionDTO.responsablePersonId}" width="200px"/>
                                                <webuijsf:label id="labelCurrentWeight" style="width: 260px; height: 24px" text="#{resources.current_weigth}"/>
                                                <webuijsf:textField columns="27" disabled="true" id="textFieldCurrentWeight" style="width: 220px;" text="#{germplasm$AccessionSessionBean.editAccessionDTO.currentWeigth}">
                                                    <f:validateLongRange minimum="0"/>
                                                </webuijsf:textField>
                                                <webuijsf:label id="empty1"/>
                                                <webuijsf:label id="labelPackages" style="width: 260px; height: 24px" text="#{resources.packages}"/>
                                                <webuijsf:textField columns="27" id="textFieldPackages" style="width: 220px;" text="#{germplasm$AccessionSessionBean.editAccessionDTO.packages}">
                                                    <f:validateLongRange minimum="0"/>
                                                </webuijsf:textField>
                                                <webuijsf:label id="labelOriginalWeigth" style="width: 260px; height: 24px" text="#{resources.original_weigth}"/>
                                                <webuijsf:textField columns="27" id="textFieldOriginalWeigth" style="width: 220px;" text="#{germplasm$AccessionSessionBean.editAccessionDTO.originalWeigth}">
                                                    <f:validateLongRange minimum="0"/>
                                                </webuijsf:textField>
                                                <webuijsf:label id="empty2"/>
                                                <webuijsf:label id="labelLocation" style="width: 168px; height: 24px" text="#{resources.location}"/>
                                                <webuijsf:textArea columns="24" id="textAreaLocation" style="width: 200px; height: 55px" text="#{germplasm$AccessionSessionBean.editAccessionDTO.location}"/>
                                                <webuijsf:label id="labelNotes" style="width: 168px; height: 24px" text="#{resources.notes}"/>
                                                <webuijsf:textArea columns="24" id="textAreaNotes" style="width: 200px; height: 55px" text="#{germplasm$AccessionSessionBean.editAccessionDTO.notes}"/>
                                                <webuijsf:label id="empty3"/>
                                            </h:panelGrid>
                                            <h:panelGrid columns="2" style="position: relative" width="850">
                                                <h:panelGrid columns="2" style="position: relative" styleClass="My_panel_blue" width="424">
                                                    <webuijsf:label id="labelGerminationDate" style="width: 168px; height: 24px" text="#{resources.germination_date}"/>
                                                    <webuijsf:calendar binding="#{germplasm$EditAccession.germinationDate}" id="calendarGerminationDate" style="width: 200px"/>
                                                    <webuijsf:label id="labelGerminationRate" style="width: 168px; height: 24px" text="#{resources.germination_rate}"/>
                                                    <webuijsf:textField columns="27" id="textFieldGerminationRate" style="width: 220px;" text="#{germplasm$AccessionSessionBean.editAccessionDTO.germinationRate}">
                                                        <f:validateLongRange minimum="0"/>
                                                    </webuijsf:textField>
                                                    <webuijsf:label id="labelGerminationViability" style="width: 168px; height: 24px" text="#{resources.germination_viablility}"/>
                                                    <webuijsf:textField columns="27" id="textFieldGerminationViability" style="width: 220px;" text="#{germplasm$AccessionSessionBean.editAccessionDTO.germinationViability}">
                                                        <f:validateLongRange minimum="0"/>
                                                    </webuijsf:textField>
                                                    <webuijsf:label id="labelGerminationMethodType" style="width: 168px; height: 24px" text="#{resources.germination_method_type}"/>
                                                    <webuijsf:dropDown id="dropdownGerminationMethodType"
                                                        items="#{germplasm$EditAccession.germinationMethodType.options}"
                                                        selected="#{germplasm$AccessionSessionBean.editAccessionDTO.germinationMethodTypeId}" width="200px"/>
                                                </h:panelGrid>
                                                <h:panelGrid columns="2" style="position: relative" styleClass="My_panel_blue" width="424">
                                                    <webuijsf:label id="labelStorageDate" style="width: 168px; height: 24px" text="#{resources.store_date}"/>
                                                    <webuijsf:calendar binding="#{germplasm$EditAccession.storageDate}" id="calendarStorageDate" style="width: 200px"/>
                                                    <webuijsf:label id="labelMoisture" style="width: 168px; height: 24px" text="#{resources.moisture}"/>
                                                    <webuijsf:textField columns="27" id="textFieldMoisture" style="width: 220px;" text="#{germplasm$AccessionSessionBean.editAccessionDTO.moisture}">
                                                        <f:validateLongRange minimum="0"/>
                                                    </webuijsf:textField>
                                                    <webuijsf:label id="labelMoistureMethodType" style="width: 168px; height: 24px" text="#{resources.moisture_method}"/>
                                                    <webuijsf:dropDown id="dropdownMoistureMethodType"
                                                        items="#{germplasm$EditAccession.moistureMethodType.options}"
                                                        selected="#{germplasm$AccessionSessionBean.editAccessionDTO.moistureMethodTypeId}" width="200px"/>
                                                    <webuijsf:label id="labelMultiplicationRegeneration" style="width: 168px; height: 24px" text="#{resources.multiplication_regeneration}"/>
                                                    <webuijsf:textField columns="27" id="textFieldMultiplicationRegeneration" style="width: 220px;" text="#{germplasm$AccessionSessionBean.editAccessionDTO.multiplicationRegeneration}">
                                                        <f:validateLongRange minimum="0"/>
                                                    </webuijsf:textField>
                                                </h:panelGrid>
                                            </h:panelGrid>
                                        </h:panelGrid>
                                    </webuijsf:tab>
                                    <webuijsf:tab id="tabPasaporteAsociado" text="#{resources.associated_passport}">
                                        <!-- Tabla que posee la lista de passport -->
                                        <h:panelGrid id="gridpGathering_Main" style="position: relative" width="850">
                                            <!-- panel de busquedas -->
                                            <h:panelGrid columns="3" id="gridpSearch" style="height: 24px" width="719">
                                                <h:inputText binding="#{germplasm$EditAccession.txSearch}" id="txSearch" style="height: 18px; width: 408px">
                                                    <f:validateLength maximum="100" minimum="0"/>
                                                </h:inputText>
                                                <h:commandButton action="#{germplasm$EditAccession.btnPassportSearch_action}"
                                                    binding="#{germplasm$EditAccession.btnSearch}" id="btnGatheringSearch" style="height: 25px; width: 160px"
                                                    styleClass="My_Button" value="#{resources.search}"/>
                                                <h:commandButton action="#{germplasm$EditAccession.btnAdvPassportSearch_action}"
                                                    binding="#{germplasm$EditAccession.btnAdvSearch}" id="btnAdvGatheringSearch"
                                                    style="height: 25px; width: 160px" styleClass="My_Button" value="#{resources.advanced_search}"/>
                                            </h:panelGrid>
                                            <h:panelGrid binding="#{germplasm$EditAccession.gridpAdvancedSearch}" columns="1" id="gridpAdvancedSearch"
                                                rendered="false" style="height: 5px" styleClass="My_panel_blue" width="680">
                                                <h:panelGrid columns="1" id="gridpAdvancedSearch1" style="height: 24px" width="780">
                                                    <h:panelGrid columns="4" id="gridpAS1" style="height: 24px" width="780">
                                                        <webuijsf:label id="labelPassportId" style="width: 168px; height: 24px" text="#{resources.passport_id}"/>
                                                        <webuijsf:textField id="textFieldPassportId" style="width: 200px;" text="#{germplasm$PassportListSessionBean.queryPassportDTO.passportId}"/>
                                                        <webuijsf:label id="labelPlantNusersryDate" text="#{resources.plant_nursery_date}"/>
                                                        <webuijsf:calendar binding="#{germplasm$EditAccession.plantNurseryDate}" columns="15"
                                                            dateFormatPattern="dd-MM-yyyy" id="plantNusersryDate"/>
                                                        <webuijsf:label id="labelGatheringId" style="width: 168px; height: 24px" text="#{resources.gathering_number}"/>
                                                        <webuijsf:textField id="textFieldGatheringId" style="width: 200px;" text="#{germplasm$PassportListSessionBean.queryPassportDTO.gatheringId}"/>
                                                        <webuijsf:label for="labelPlantingSeasonDate" text="#{resources.plantation_date}"/>
                                                        <webuijsf:calendar binding="#{germplasm$EditAccession.plantingSeasonDate}" columns="15"
                                                            dateFormatPattern="dd-MM-yyyy" id="PlantingSeasonDate"/>
                                                        <webuijsf:label id="labelMissionNumber" style="width: 168x; height: 24px" text="#{resources.mission_number}"/>
                                                        <webuijsf:textField id="textFieldMissionNumber" style="width: 200px;" text="#{germplasm$PassportListSessionBean.queryPassportDTO.missionNumber}"/>
                                                        <webuijsf:label for="labelHarvestingSeasonDate" text="#{resources.harvesting_date}"/>
                                                        <webuijsf:calendar binding="#{germplasm$EditAccession.harvestingSeasonDate}" columns="15"
                                                            dateFormatPattern="dd-MM-yyyy" id="HarvestingSeasonDate"/>
                                                        <webuijsf:label id="labelDonorPerson" style="width: 168px; height: 24px" text="#{resources.donor_person}"/>
                                                        <webuijsf:dropDown id="dropdownDonorPerson" items="#{germplasm$EditAccession.donorPersons.options}"
                                                            selected="#{germplasm$PassportListSessionBean.queryPassportDTO.donorPersonId}" width="200px"/>
                                                        <webuijsf:label id="labelMaterialType" style="width: 168px; height: 24px" text="#{resources.sle_material_type}"/>
                                                        <webuijsf:dropDown id="dropdownMaterialType" items="#{germplasm$EditAccession.materialTypes.options}"
                                                            selected="#{germplasm$PassportListSessionBean.queryPassportDTO.materialTypeId}" width="200px"/>
                                                        <webuijsf:label id="labelDonorInstitution" style="width: 168px; height: 24px" text="#{resources.donor_institution}"/>
                                                        <webuijsf:dropDown id="dropdownDonorInstitution"
                                                            items="#{germplasm$EditAccession.donorInstitutions.options}"
                                                            selected="#{germplasm$PassportListSessionBean.queryPassportDTO.donorInstitutionId}" width="200px"/>
                                                        <webuijsf:label id="labelSampleStatus" style="width: 168px; height: 24px" text="#{resources.sle_sample_status}"/>
                                                        <webuijsf:dropDown id="dropdownSampleStatus" items="#{germplasm$EditAccession.sampleStatus.options}"
                                                            selected="#{germplasm$PassportListSessionBean.queryPassportDTO.sampleStatusId}" width="200px"/>
                                                    </h:panelGrid>
                                                    <h:panelGrid columns="2" id="gridpAS2" style="height: 24px" width="390">
                                                        <h:commandButton action="#{germplasm$EditAccession.btnAdvSearchPassport_action}" id="btnAdvSearchGO"
                                                            style="width: 160px" styleClass="My_Button" value="#{resources.button_proceed}"/>
                                                    </h:panelGrid>
                                                </h:panelGrid>
                                            </h:panelGrid>
                                            <h:panelGrid cellspacing="1" columns="1" id="gridpTableMain" style="height: 24px" styleClass="My_table" width="840">
                                                <webuijsf:panelGroup id="grouppButtons">
                                                    <h:panelGrid columns="1" id="gridpquantity" styleClass="My_table_top" width="840">
                                                        <h:outputLabel id="labelQuantity" value="#{germplasm$EditAccession.quantityTotalPassport}"/>
                                                    </h:panelGrid>
                                                    <webuijsf:panelGroup id="panelPaginacion" separator=" " style="margin-left:70px;">
                                                        <!-- Botones de paginacion -->
                                                        <h:commandButton action="#{germplasm$PassportListSessionBean.pagination.firstResults}" id="btnFirst"
                                                            rendered="#{germplasm$PassportListSessionBean.pagination.isVisiblePrevious}"
                                                            style="margin: 2px;height: 22px" styleClass="My_Button_first" value="#{resources.pagination_first}"/>
                                                        <h:commandButton action="#{germplasm$PassportListSessionBean.pagination.previousResults}"
                                                            id="btnPrevious" rendered="#{germplasm$PassportListSessionBean.pagination.isVisiblePrevious}"
                                                            style="margin: 2px;height: 22px" styleClass="My_Button_previous" value="#{resources.pagination_previous}"/>
                                                        <h:commandButton action="#{germplasm$PassportListSessionBean.pagination.nextResults}" id="btnNext"
                                                            rendered="#{germplasm$PassportListSessionBean.pagination.isVisibleNext}"
                                                            style="margin: 2px; height: 22px" styleClass="My_Button_next" value="#{resources.pagination_next}"/>
                                                        <h:commandButton action="#{germplasm$PassportListSessionBean.pagination.lastResults}" id="btnLast"
                                                            rendered="#{germplasm$PassportListSessionBean.pagination.isVisibleNext}"
                                                            style="margin: 2px;height: 22px" styleClass="My_Button_last" value="#{resources.pagination_last}"/>
                                                    </webuijsf:panelGroup>
                                                </webuijsf:panelGroup>
                                                <h:dataTable binding="#{germplasm$EditAccession.dataTablePassport}" cellspacing="0" columnClasses="list-columns"
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
                                    </webuijsf:tab>
                                    <webuijsf:tab id="tabAccesionPadre" text="#{resources.accession_parent}">
                                        <!-- Tabla que posee la lista de accesiones -->
                                        <h:panelGrid id="gridpGathering_Main" style="position: relative" width="850">
                                            <!-- panel de busquedas -->
                                            <h:panelGrid columns="3" id="gridpSearchAccessions" style="height: 24px" width="719">
                                                <h:inputText binding="#{germplasm$EditAccession.txSearchAccession}" id="txSearchAccession" style="height: 18px; width: 408px">
                                                    <f:validateLength maximum="100" minimum="0"/>
                                                </h:inputText>
                                                <h:commandButton action="#{germplasm$EditAccession.btnAccessionSearch_action}"
                                                    binding="#{germplasm$EditAccession.btnSearchAccession}" id="btnAccessionSearch"
                                                    style="height: 25px; width: 160px" styleClass="My_Button" value="#{resources.search}"/>
                                                <h:commandButton action="#{germplasm$EditAccession.btnAdvAccessiontSearch_action}"
                                                    binding="#{germplasm$EditAccession.btnAdvSearchAccession}" id="btnAdvAccessionSearch"
                                                    style="height: 25px; width: 160px" styleClass="My_Button" value="#{resources.advanced_search}"/>
                                            </h:panelGrid>
                                            <h:panelGrid binding="#{germplasm$EditAccession.gridpAdvancedSearchAccession}" columns="1"
                                                id="gridpAdvancedSearchAccession" rendered="false" style="height: 5px" styleClass="My_panel_blue" width="680">
                                                <h:panelGrid columns="1" id="gridpAdvancedSearchAccession1" style="height: 24px" width="780">
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
                                                        <webuijsf:dropDown id="dropdownGerminationMethod"
                                                            items="#{germplasm$EditAccession.germinationMethodType.options}"
                                                            selected="#{germplasm$AccessionSessionBean.queryAccessionDTO.germinationMethodTypeId}" width="160px"/>
                                                        <webuijsf:label id="labelResponsablePerson" style="width: 168px; height: 24px" text="#{resources.responsable_person}"/>
                                                        <webuijsf:dropDown id="dropdownResponsablePerson"
                                                            items="#{germplasm$EditAccession.responsablePerson.options}"
                                                            selected="#{germplasm$AccessionSessionBean.queryAccessionDTO.responsablePersonId}" width="160px"/>
                                                        <webuijsf:label id="labelGerminationRate" style="width: 168px; height: 24px" text="#{resources.germination_rate}"/>
                                                        <webuijsf:textField id="textFieldGerminationRate" style="width: 200px;" text="#{germplasm$AccessionSessionBean.queryAccessionDTO.germinationRate}"/>
                                                        <webuijsf:label id="labelPackages" style="width: 168px; height: 24px" text="#{resources.packages}"/>
                                                        <webuijsf:textField id="textFieldPackages" style="width: 200px;" text="#{germplasm$AccessionSessionBean.queryAccessionDTO.packages}"/>
                                                    </h:panelGrid>
                                                    <h:panelGrid columns="2" id="gridpAS2" style="height: 24px" width="390">
                                                        <h:commandButton action="#{germplasm$EditAccession.btnAdvSearchAccession_action}" id="btnAdvSearchGO"
                                                            style="width: 160px" styleClass="My_Button" value="#{resources.button_proceed}"/>
                                                    </h:panelGrid>
                                                </h:panelGrid>
                                            </h:panelGrid>
                                            <h:panelGrid cellspacing="1" columns="1" id="gridpTableMainAcession" style="height: 24px" styleClass="My_table" width="840">
                                                <webuijsf:panelGroup id="grouppButtonsAcession">
                                                    <h:panelGrid columns="1" id="gridpquantityAcession" styleClass="My_table_top" width="840">
                                                        <h:outputLabel id="labelQuantityAcession" value="#{germplasm$EditAccession.quantityTotalAccession}"/>
                                                    </h:panelGrid>
                                                    <webuijsf:panelGroup id="panelPaginacionAcession" separator=" " style="margin-left:70px;">
                                                        <!-- Botones de paginacion -->
                                                        <h:commandButton action="#{germplasm$AccessionSessionBean.pagination.firstResults}"
                                                            id="btnFirstAcession" rendered="#{germplasm$AccessionSessionBean.pagination.isVisiblePrevious}"
                                                            style="margin: 2px;height: 22px" styleClass="My_Button_first" value="#{resources.pagination_first}"/>
                                                        <h:commandButton action="#{germplasm$AccessionSessionBean.pagination.previousResults}"
                                                            id="btnPreviousAcession" rendered="#{germplasm$AccessionSessionBean.pagination.isVisiblePrevious}"
                                                            style="margin: 2px;height: 22px" styleClass="My_Button_previous" value="#{resources.pagination_previous}"/>
                                                        <h:commandButton action="#{germplasm$AccessionSessionBean.pagination.nextResults}"
                                                            id="btnNextAcession" rendered="#{germplasm$AccessionSessionBean.pagination.isVisibleNext}"
                                                            style="margin: 2px; height: 22px" styleClass="My_Button_next" value="#{resources.pagination_next}"/>
                                                        <h:commandButton action="#{germplasm$AccessionSessionBean.pagination.lastResults}"
                                                            id="btnLastAcession" rendered="#{germplasm$AccessionSessionBean.pagination.isVisibleNext}"
                                                            style="margin: 2px;height: 22px" styleClass="My_Button_last" value="#{resources.pagination_last}"/>
                                                    </webuijsf:panelGroup>
                                                </webuijsf:panelGroup>
                                                <h:dataTable binding="#{germplasm$EditAccession.dataTableAccession}" cellspacing="0"
                                                    columnClasses="list-columns" headerClass="list-header" id="dataTablegatheringAcession"
                                                    rowClasses="list-row-even,list-row-odd" rows="#{germplasm$AccessionSessionBean.pagination.resultsPerPage}"
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
                                                        <h:outputText value="#{currentRow['accessionParentId']}"/>
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
                                    </webuijsf:tab>
                                </webuijsf:tabSet>
                                <jsp:directive.include file="/Footer.jspf"/>
                            </h:panelGrid>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
