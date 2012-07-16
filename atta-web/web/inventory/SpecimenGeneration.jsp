<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : SpecimenGeneration
    Created on : 02/09/2009, 09:09:05 AM
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

                                <!-- Buble help -->
                                <webuijsf:bubble id="bubble" style="left: 370px; top: 42px; position: absolute" title="#{resources.standard_bubble_title}">
                                    <webuijsf:staticText text="#{resources.generation_bubble_text}"/>
                                </webuijsf:bubble>

                                <h:outputLabel id="lbSpecimenGenTitle" style="height: 24px; left: 24px; position: relative; width: 850px"
                                    styleClass="Page_title" value="#{resources.sp_gen_and_identifications}"/>
                                <!-- Inicio panel principal -->
                                <h:panelGrid columns="1" id="gridpGenerationMain" style="height: 24px; left: 24px; position: relative" width="850">
                                    <h:panelGrid style="position: relative">
                                    <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglGeneration" infoClass="infoMessage"
                                        style="height: 60px; width: 840px" warnClass="warnMessage"/>
                                    </h:panelGrid>
                                    <h:panelGrid style="position: relative">
                                    <webuijsf:panelGroup id="grouppBotoneraGen" style="height: 24px; width: 840px">
                                        <h:commandButton action="#{inventory$SpecimenGeneration.btnSpecimenGeneration_action}" id="btnSpecimenGeneration"
                                            style="height: 24px; width: 250px" styleClass="My_Button" value="#{resources.generate}"/>
                                        <h:commandButton id="btnSeeGenerated" rendered="false" style="height: 24px; width: 250px" styleClass="My_Button" value="#{resources.view_generated_specimens}"/>
                                        <!-- Buble help -->
                                        <webuijsf:hyperlink id="hyperlink_help" onClick="return false;"
                                                onMouseDown="document.getElementById('contenido:form1:bubble').open(event);"
                                                onMouseOut="document.getElementById('contenido:form1:bubble').close();"
                                                onMouseOver="document.getElementById('contenido:form1:bubble').open(event);"
                                                style="height: 24px; width: 96px" text="#{resources.standard_bubble_title}">
                                        </webuijsf:hyperlink>
                                    </webuijsf:panelGroup>
                                    <!-- Inicio panel de detalles -->
                                    <webuijsf:panelLayout id="layoutpGenDetails" style="height: 191px; position: relative; width: 840px; -rave-layout: grid" styleClass="My_panel_blue">
                                        <webuijsf:label for="txQuantity" id="lbQuantity"
                                            style="height: 24px; left: 48px; top: 24px; position: absolute; width: 164px" text="#{resources.quantity}"/>
                                        <webuijsf:textField required="true" binding="#{inventory$SpecimenGeneration.txQuantity}" columns="22" id="txQuantity"
                                            style="height: 24px; left: 216px; top: 24px; position: absolute; width: 120px" validatorExpression="#{util$ValidatorBean.longNumberFormatValidator}"/>
                                        <webuijsf:label for="txInitialCatalog" id="lbInitialCatalog"
                                            style="height: 24px; left: 48px; top: 1px; position: absolute; width: 168px" text="#{resources.initial_catalog_number}"/>
                                        <webuijsf:textField binding="#{inventory$SpecimenGeneration.txInitialCatalog}" columns="22" id="txInitialCatalog"
                                            style="height: 24px; left: 216px; top: 1px; position: absolute; width: 120px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                        <webuijsf:label for="ddCategory" id="lbGatheringMethod"
                                            style="height: 24px; left: 48px; top: 48px; position: absolute; width: 164px" text="#{resources.gath_obs_method}"/>
                                        <webuijsf:dropDown binding="#{inventory$SpecimenGeneration.ddGatheringMethod}" id="ddGatheringMethod"
                                            items="#{inventory$SpecimenGeneration.gatheringMethodData.options}"
                                            selected="#{inventory$SpecimenGenerationSessionBean.specimenDTO.gatheringMethodId}"
                                            style="height: 24px; left: 216px; top: 48px; position: absolute" width="165px"/>
                                        <webuijsf:label for="ddCategory" id="lbCategory"
                                            style="height: 24px; left: 48px; top: 72px; position: absolute; width: 168px" text="#{resources.category}"/>
                                        <webuijsf:label for="ddOrigin" id="lbType" style="height: 24px; left: 48px; top: 96px; position: absolute; width: 168px" text="#{resources.type}"/>
                                        <webuijsf:label for="ddOrigin" id="lbOrigin" style="height: 24px; left: 48px; top: 120px; position: absolute; width: 168px" text="#{resources.origin}"/>
                                        <webuijsf:dropDown actionExpression="#{inventory$SpecimenGeneration.validateCategoryOptions}"
                                            binding="#{inventory$SpecimenGeneration.ddCategory}" id="ddCategory"
                                            items="#{inventory$SpecimenGeneration.categoryData.options}"
                                            selected="#{inventory$SpecimenGenerationSessionBean.specimenDTO.categoryId}"
                                            style="height: 24px; left: 216px; top: 72px; position: absolute" submitForm="true" width="165px"/>
                                        <webuijsf:dropDown binding="#{inventory$SpecimenGeneration.ddType}" id="ddType"
                                            items="#{inventory$SpecimenGeneration.typeData.options}"
                                            selected="#{inventory$SpecimenGenerationSessionBean.specimenDTO.typeId}"
                                            style="height: 24px; left: 216px; top: 96px; position: absolute" width="165px"/>
                                        <webuijsf:dropDown binding="#{inventory$SpecimenGeneration.ddOrigin}" id="ddOrigin"
                                            items="#{inventory$SpecimenGeneration.originData.options}"
                                            selected="#{inventory$SpecimenGenerationSessionBean.specimenDTO.originId}"
                                            style="height: 24px; left: 216px; top: 120px; position: absolute" width="165px"/>
                                        <webuijsf:label for="ddPreservationMediun" id="lbPreservationMediun"
                                            style="height: 24px; left: 48px; top: 144px; position: absolute; width: 164px" text="#{resources.preservation_medium}"/>
                                        <webuijsf:dropDown binding="#{inventory$SpecimenGeneration.ddPreservationMediun}" id="ddPreservationMediun"
                                            items="#{inventory$SpecimenGeneration.preservationMediunData.options}"
                                            selected="#{inventory$SpecimenGenerationSessionBean.specimenDTO.preservationMediumId}"
                                            style="height: 24px; left: 216px; top: 144px; position: absolute" width="165px"/>
                                        <webuijsf:label for="ddStorage" id="lbStorage"
                                            style="height: 24px; left: 48px; top: 168px; position: absolute; width: 168px" text="#{resources.storage}"/>
                                        <webuijsf:dropDown binding="#{inventory$SpecimenGeneration.ddStorage}" id="ddStorage"
                                            items="#{inventory$SpecimenGeneration.storageData.options}"
                                            selected="#{inventory$SpecimenGenerationSessionBean.specimenDTO.storageTypeId}"
                                            style="height: 24px; left: 216px; top: 168px; position: absolute" width="165px"/>
                                        <webuijsf:label for="ddSubtrate" id="lbSubtrate"
                                            style="height: 24px; left: 456px; top: 1px; position: absolute; width: 168px" text="#{resources.substrate}"/>
                                        <webuijsf:dropDown binding="#{inventory$SpecimenGeneration.ddSubtrate}" id="ddSubtrate"
                                            items="#{inventory$SpecimenGeneration.subtrateData.options}"
                                            selected="#{inventory$SpecimenGenerationSessionBean.specimenDTO.substrateId}"
                                            style="height: 24px; left: 624px; top: 1px; position: absolute" width="165px"/>
                                        <webuijsf:label for="ddExtraction" id="lbExtraction"
                                            style="height: 24px; left: 456px; top: 24px; position: absolute; width: 168px" text="#{resources.extraction_method}"/>
                                        <webuijsf:dropDown binding="#{inventory$SpecimenGeneration.ddExtraction}" id="ddExtraction"
                                            items="#{inventory$SpecimenGeneration.extractionData.options}"
                                            selected="#{inventory$SpecimenGenerationSessionBean.specimenDTO.extractionTypeId}"
                                            style="height: 24px; left: 624px; top: 24px; position: absolute" width="165px"/>
                                        <webuijsf:label for="txCertainty" id="lbCertainty"
                                            style="height: 24px; left: 456px; top: 48px; position: absolute; width: 168px" text="#{resources.certainty_level}"/>
                                        <webuijsf:textField binding="#{inventory$SpecimenGeneration.txCertainty}" columns="22" id="txCertainty"
                                            style="height: 24px; left: 624px; top: 48px; position: absolute; width: 120px" validatorExpression="#{util$ValidatorBean.longNumberFormatValidator}"/>
                                        <webuijsf:label for="ddInstitutions" id="lbInstitutions"
                                            style="height: 24px; left: 456px; top: 72px; position: absolute; width: 168px" text="#{resources.institution}"/>
                                        <webuijsf:dropDown required="true" binding="#{inventory$SpecimenGeneration.ddInstitutions}" id="ddInstitutions"
                                            items="#{inventory$SpecimenGeneration.institutionsData.options}"
                                            selected="#{inventory$SpecimenGenerationSessionBean.specimenDTO.institutionId}"
                                            style="height: 24px; left: 624px; top: 72px; position: absolute" width="165px"/>
                                        <webuijsf:label binding="#{inventory$SpecimenGeneration.lbDateObservation}" for="calDateObservation" id="lbDateObservation"
                                            rendered="false" style="height: 24px; left: 456px; top: 144px; position: absolute; width: 168px" text="#{resources.date_observation}"/>
                                        <webuijsf:calendar binding="#{inventory$SpecimenGeneration.calDateObservation}" columns="19" dateFormatPattern="yyyy-MM-dd"
                                            id="calDateObservation" rendered="false" style="height: 24px; left: 614px; top: 144px; position: absolute; width: 154px"/>
                                        <webuijsf:label binding="#{inventory$SpecimenGeneration.lbTimeObservation}" for="txWhole" id="lbTimeObservation"
                                            rendered="false" style="height: 24px; left: 456px; top: 168px; position: absolute; width: 168px" text="#{resources.time_observation}"/>
                                        <webuijsf:dropDown binding="#{inventory$SpecimenGeneration.ddHour}" id="ddHour"
                                            items="#{inventory$SpecimenGeneration.hourData.options}" rendered="false"
                                            selected="#{inventory$SpecimenGenerationSessionBean.selectedHour}"
                                            style="height: 24px; left: 624px; top: 168px; position: absolute" width="55px"/>
                                        <webuijsf:dropDown binding="#{inventory$SpecimenGeneration.ddMinutes}" id="ddMinutes"
                                            items="#{inventory$SpecimenGeneration.minutesData.options}" rendered="false"
                                            selected="#{inventory$SpecimenGenerationSessionBean.selectedMinute}"
                                            style="height: 24px; left: 696px; top: 168px; position: absolute" width="55px"/>
                                        <webuijsf:label binding="#{inventory$SpecimenGeneration.lbPoints}" id="lbPoints" rendered="false"
                                            style="height: 24px; left: 686px; top: 168px; position: absolute; width: 20px" text="   :"/>
                                        <webuijsf:label binding="#{inventory$SpecimenGeneration.lbWhole}" for="txFragments" id="lbWhole" rendered="false"
                                            style="height: 24px; left: 456px; top: 96px; position: absolute; width: 168px" text="#{resources.num_whole}"/>
                                        <webuijsf:textField binding="#{inventory$SpecimenGeneration.txWhole}" columns="22" id="txWhole" rendered="false"
                                            style="height: 24px; left: 624px; top: 96px; position: absolute; width: 144px" validatorExpression="#{util$ValidatorBean.longNumberFormatValidator}"/>
                                        <webuijsf:label binding="#{inventory$SpecimenGeneration.lbFragments}" for="txFragments" id="lbFragments" rendered="false"
                                            style="height: 24px; left: 456px; top: 120px; position: absolute; width: 168px" text="#{resources.num_fragments}"/>
                                        <webuijsf:textField binding="#{inventory$SpecimenGeneration.txFragments}" columns="22" id="txFragments" rendered="false"
                                            style="height: 24px; left: 624px; top: 120px; position: absolute; width: 160px" validatorExpression="#{util$ValidatorBean.longNumberFormatValidator}"/>
                                    </webuijsf:panelLayout>
                                    <!-- Fin panel de detalles -->
                                    <!-- Inicio del tab set -->
                                    <webuijsf:tabSet id="tabSetGenerateSpecimen" mini="true" selected="tabIdentification" style="width: 840px" styleClass="My_tab_border">
                                        <webuijsf:tab id="tabIdentification" text="#{resources.titleIdentificationList}">
                                            <webuijsf:panelLayout id="layoutpIdentifications" style="height: 248px; position: relative; width: 100%; -rave-layout: grid">
                                                <!--<webuijsf:label for="ddIdentificationCategory" id="lbCategory1"
                                                    style="height: 24px; left: 48px; top: 0px; position: absolute; width: 168px" text="#{resources.category}"/>
                                                <webuijsf:dropDown id="ddIdentificationCategory" items="#{inventory$SpecimenGeneration.taxonCategoryData.options}"
                                                     style="height: 24px; left: 216px; top: 0px; position: absolute" width="165px"/>-->
                                                <webuijsf:label for="ddValidator" id="lbValidator"
                                                    style="height: 24px; left: 48px; top: 24px; position: absolute; width: 168px" text="#{resources.validator}"/>
                                                <webuijsf:dropDown id="ddValidator" items="#{inventory$SpecimenGeneration.validatorsData.options}"
                                                    selected="#{inventory$SpecimenGenerationSessionBean.selecctedValidator}"
                                                    style="height: 24px; left: 216px; top: 24px; position: absolute" width="165px"/>
                                                <webuijsf:label for="ddTaxonomicLevel" id="lbTaxonomicLevel"
                                                    style="height: 24px; left: 48px; top: 48px; position: absolute; width: 168px" text="#{resources.taxonomic_level}"/>
                                                <webuijsf:dropDown actionExpression="#{inventory$SpecimenGeneration.updateTaxonListAction}" id="ddTaxonomicLevel"
                                                    items="#{inventory$SpecimenGeneration.ddTaxonomicalRangeData.options}"
                                                    selected="#{inventory$SpecimenGenerationSessionBean.selectedTaxonomicLevel}"
                                                    style="left: 216px; top: 48px; position: absolute" submitForm="true" width="165px"/>
                                                <webuijsf:label for="cidentificationDate" id="lbIdentificationDate"
                                                    style="height: 24px; left: 456px; top: 10px; position: absolute; width: 168px" text="#{resources.identification_date} (*)"/>
                                                <webuijsf:calendar binding="#{inventory$SpecimenGeneration.calIdentificationDate}" columns="19"
                                                    dateFormatPattern="yyyy-MM-dd" id="cidentificationDate" style="height: 24px; left: 614px; top: 10px; position: absolute; width: 168px"/>
                                                <webuijsf:label for="ddStatus" id="lbStatus"
                                                    style="height: 24px; left: 456px; top: 34px; position: absolute; width: 168px" text="#{resources.status} (*)"/>
                                                <webuijsf:dropDown id="ddStatus" items="#{inventory$SpecimenGeneration.statusIdentificationData.options}"
                                                    selected="#{inventory$SpecimenGenerationSessionBean.identificationDTO.statusId}"
                                                    style="height: 0px; left: 624px; top: 34px; position: absolute" width="165px"/>
                                                <webuijsf:label for="ddIdentificationType" id="lbIdentificationType"
                                                    style="height: 24px; left: 456px; top: 58px; position: absolute; width: 168px" text="#{resources.type}"/>
                                                <webuijsf:dropDown id="ddIdentificationType" items="#{inventory$SpecimenGeneration.typeIdentificationData.options}"
                                                    selected="#{inventory$SpecimenGenerationSessionBean.identificationDTO.typeId}"
                                                    style="height: 24px; left: 624px; top: 58px; position: absolute" width="165px"/>
                                                <!-- AddRemove Component -->
                                                <h:panelGrid cellspacing="1" columns="1" id="gridpAddRemove"
                                                    style="height: 144px; left: 48px; top: 85px; position: absolute" styleClass="My_table" width="336">
                                                    <!-- Title -->
                                                    <h:panelGrid columns="1" id="gridpArTitle" styleClass="My_table_top" width="100%">
                                                        <h:outputLabel id="lbArTitle" value="#{inventory$SpecimenGenerationSessionBean.arTaxonList.lbTitle}"/>
                                                    </h:panelGrid>
                                                    <!-- Add Remove body -->
                                                    <h:panelGrid cellspacing="1" columns="3">
                                                        <!-- Available List -->
                                                        <h:panelGrid cellspacing="1" columns="1">
                                                            <h:outputLabel id="lbAvailableTaxonOptions" styleClass="My_white_label" value="#{inventory$SpecimenGenerationSessionBean.arTaxonList.lbAvailable}"/>                                                            
                                                            <h:selectManyListbox id="mlAvaibleList" size="7" style="width:154px;height:100px;font-size:10px;" value="#{inventory$SpecimenGenerationSessionBean.arTaxonList.leftSelected}">
                                                                <f:selectItems id="mlAvailableSelectItems" value="#{inventory$SpecimenGenerationSessionBean.arTaxonList.leftOptions}"/>                                                                
                                                            </h:selectManyListbox>
                                                        </h:panelGrid>
                                                        <!-- Buttons Panel -->
                                                        <h:panelGrid cellspacing="1" columns="1">
                                                            <!-- boton Agregar -->
                                                            <h:commandButton action="#{inventory$SpecimenGenerationSessionBean.arTaxonList.addSelectedOptions}"
                                                                id="btnAddOptions" style="margin: 2px;height: 22px" styleClass="My_Button_add"/>
                                                            <!-- boton Remover -->
                                                            <h:commandButton action="#{inventory$SpecimenGenerationSessionBean.arTaxonList.removeSelectedOptions}"
                                                                id="btnRemoveOptions" style="margin: 2px;height: 22px" styleClass="My_Button_remove"/>
                                                        </h:panelGrid>
                                                        <!-- Selected List -->
                                                        <h:panelGrid cellspacing="1" columns="1">
                                                            <h:outputLabel id="lbSelectedTaxonOptions" styleClass="My_white_label" value="#{inventory$SpecimenGenerationSessionBean.arTaxonList.lbSelected}"/>
                                                            <h:selectManyListbox id="mlSelectedList" size="7" style="width:154px;height:100px;font-size:10px;" value="#{inventory$SpecimenGenerationSessionBean.arTaxonList.rightSelected}">
                                                                <f:selectItems id="mlSelectedSelectItems" value="#{inventory$SpecimenGenerationSessionBean.arTaxonList.rightOptions}"/>
                                                            </h:selectManyListbox>
                                                        </h:panelGrid>
                                                    </h:panelGrid>
                                                </h:panelGrid>
                                                <!-- End AddRemove Component -->
                                                <!-- AddRemove Component -->
                                                <h:panelGrid cellspacing="1" columns="1" id="gridpAddRemoveIdentifier"
                                                    style="height: 144px; left: 456px; top: 85px; position: absolute" styleClass="My_table" width="336">
                                                    <!-- Title -->
                                                    <h:panelGrid columns="1" id="gridpArIdentifierTitle" styleClass="My_table_top" width="100%">
                                                        <h:outputLabel id="lbArIdentifierTitle" value="#{inventory$SpecimenGenerationSessionBean.arIdentifierList.lbTitle}"/>
                                                    </h:panelGrid>
                                                    <!-- Add Remove body -->
                                                    <h:panelGrid cellspacing="1" columns="3">
                                                        <!-- Available List -->
                                                        <h:panelGrid cellspacing="1" columns="1">
                                                            <h:outputLabel id="lbAvailableIdentifierOptions" styleClass="My_white_label" value="#{inventory$SpecimenGenerationSessionBean.arIdentifierList.lbAvailable}"/>
                                                            <h:selectManyListbox id="mlAvaibleIdentifierList" size="7" style="width:154px;height:100px;font-size:10px;" value="#{inventory$SpecimenGenerationSessionBean.arIdentifierList.leftSelected}">
                                                                <f:selectItems id="mlAvailableIdentifierSelectItems" value="#{inventory$SpecimenGenerationSessionBean.arIdentifierList.leftOptions}"/>
                                                            </h:selectManyListbox>
                                                        </h:panelGrid>
                                                        <!-- Buttons Panel -->
                                                        <h:panelGrid cellspacing="1" columns="1">
                                                            <!-- boton Agregar -->
                                                            <h:commandButton action="#{inventory$SpecimenGenerationSessionBean.arIdentifierList.addSelectedOptions}"
                                                                id="btnAddIdentifierOptions" style="margin: 2px;height: 22px" styleClass="My_Button_add"/>
                                                            <!-- boton Remover -->
                                                            <h:commandButton
                                                                action="#{inventory$SpecimenGenerationSessionBean.arIdentifierList.removeSelectedOptions}"
                                                                id="btnRemoveIdentifierOptions" style="margin: 2px;height: 22px" styleClass="My_Button_remove"/>
                                                        </h:panelGrid>
                                                        <!-- Selected List -->
                                                        <h:panelGrid cellspacing="1" columns="1">
                                                            <h:outputLabel id="lbSelectedIdentifierOptions" styleClass="My_white_label" value="#{inventory$SpecimenGenerationSessionBean.arIdentifierList.lbSelected}"/>
                                                            <h:selectManyListbox id="mlSelectedIdentifierList" size="7" style="width:154px;height:100px;font-size:10px;" value="#{inventory$SpecimenGenerationSessionBean.arIdentifierList.rightSelected}">
                                                                <f:selectItems id="mlSelectedIdentifierSelectItems" value="#{inventory$SpecimenGenerationSessionBean.arIdentifierList.rightOptions}"/>
                                                            </h:selectManyListbox>
                                                        </h:panelGrid>
                                                    </h:panelGrid>
                                                </h:panelGrid>
                                                <!-- End AddRemove Component -->
                                            </webuijsf:panelLayout>
                                        </webuijsf:tab>
                                        <webuijsf:tab id="tabLifeStageSex" text="#{resources.lf_sex}">
                                            <h:panelGrid columns="6" id="gridpLifeStageSex" style="" width="825">
                                                <webuijsf:label for="ddEstadio" id="lbEstadio" style="height: 22px; width: 120px" text="#{resources.stage}"/>
                                                <webuijsf:dropDown binding="#{inventory$SpecimenGeneration.ddStage}" id="ddEstadio"
                                                    items="#{inventory$SpecimenGeneration.lifeStageData.options}"
                                                    selected="#{inventory$SpecimenGeneration.valueStage}" width="189px"/>
                                                <webuijsf:label for="ddSex" id="lbSex" text="#{resources.sex}"/>
                                                <webuijsf:dropDown binding="#{inventory$SpecimenGeneration.ddSex}" id="ddSex"
                                                    items="#{inventory$SpecimenGeneration.sexData.options}" selected="#{inventory$SpecimenGeneration.valueSex}" width="189px"/>
                                                <webuijsf:label for="txCantidad" id="lbCantidad" text="#{resources.quantity}"/>
                                                <webuijsf:textField binding="#{inventory$SpecimenGeneration.txQuantitySexStage}" columns="25" id="txCantidad">
                                                    <f:validateLongRange maximum="2147483647" minimum="0"/>
                                                </webuijsf:textField>
                                                <h:commandButton action="#{inventory$SpecimenGeneration.btnAddStageSex_action}" id="btnAddStageSex"
                                                    styleClass="My_Button_dark" value="#{resources.btnNew}"/>
                                                <h:commandButton action="#{inventory$SpecimenGeneration.btnDeleteStageSex_action}" id="btnDeleteStageSex"
                                                    styleClass="My_Button_dark" value="#{resources.btnDelete}"/>
                                            </h:panelGrid>
                                            <h:panelGrid columns="1" id="gridpLifeStageSexTable" style="height: 20px" width="600">
                                                <h:dataTable cellspacing="0" columnClasses="list-columns" headerClass="list-header" id="dataTableSexStage"
                                                    rowClasses="list-row-even,list-row-odd" rows="10"
                                                    style="border-top: solid rgb(214, 218, 221) 2px; border-bottom: solid rgb(214, 218, 221) 2px; border-left: solid rgb(214, 218, 221) 2px;"
                                                    value="#{inventory$SpecimenGenerationSessionBean.specimenDTO.lifeStageSexList}" var="currentRow" width="600">
                                                    <h:column>
                                                        <f:facet name="header">
                                                            <h:outputLabel styleClass="My_search_icon" value="#{resources.stage}"/>
                                                        </f:facet>
                                                        <h:outputText value="#{currentRow.lifeStageDTO.valueName}"/>
                                                    </h:column>
                                                    <h:column>
                                                        <f:facet name="header">
                                                            <h:outputLabel styleClass="My_search_icon" value="#{resources.sex}"/>
                                                        </f:facet>
                                                        <h:outputText value="#{currentRow.sexDTO.valueName}"/>
                                                    </h:column>
                                                    <h:column>
                                                        <f:facet name="header">
                                                            <h:outputLabel styleClass="My_search_icon" value="#{resources.quantity}"/>
                                                        </f:facet>
                                                        <h:outputText value="#{currentRow.quantity}"/>
                                                    </h:column>
                                                </h:dataTable>
                                            </h:panelGrid>
                                        </webuijsf:tab>
                                        <webuijsf:tab binding="#{inventory$SpecimenGeneration.tabLifeForm}" id="tabLifeForm" text="#{resources.life_forms}">
                                            <webuijsf:panelLayout id="layoutPanel1" style="height: 197px; position: relative; width: 100%; -rave-layout: grid">
                                                <!-- AddRemove Component -->
                                                <h:panelGrid cellspacing="1" columns="1" id="gridpAddRemoveLifeForm"
                                                    style="height: 168px; left: 192px; top: 14px; position: absolute" styleClass="My_table" width="336">
                                                    <!-- Title -->
                                                    <h:panelGrid columns="1" id="gridpArLifeFormTitle" styleClass="My_table_top" width="100%">
                                                        <h:outputLabel id="lbArLifeFormTitle" value="#{inventory$SpecimenGenerationSessionBean.arLifeFormList.lbTitle}"/>
                                                    </h:panelGrid>
                                                    <!-- Add Remove body -->
                                                    <h:panelGrid cellspacing="1" columns="3">
                                                        <!-- Available List -->
                                                        <h:panelGrid cellspacing="1" columns="1">
                                                            <h:outputLabel id="lbAvailableLifeFormOptions" styleClass="My_white_label" value="#{inventory$SpecimenGenerationSessionBean.arLifeFormList.lbAvailable}"/>
                                                            <h:selectManyListbox id="mlAvaibleLifeFormList" size="7" style="width:154px;height:100px;font-size:10px;" value="#{inventory$SpecimenGenerationSessionBean.arLifeFormList.leftSelected}">
                                                                <f:selectItems id="mlAvailableLifeFormSelectItems" value="#{inventory$SpecimenGenerationSessionBean.arLifeFormList.leftOptions}"/>
                                                            </h:selectManyListbox>
                                                        </h:panelGrid>
                                                        <!-- Buttons Panel -->
                                                        <h:panelGrid cellspacing="1" columns="1">
                                                            <!-- boton Agregar -->
                                                            <h:commandButton action="#{inventory$SpecimenGenerationSessionBean.arLifeFormList.addSelectedOptions}"
                                                                id="btnAddLifeFormOptions" style="margin: 2px;height: 22px" styleClass="My_Button_add"/>
                                                            <!-- boton Remover -->
                                                            <h:commandButton
                                                                action="#{inventory$SpecimenGenerationSessionBean.arLifeFormList.removeSelectedOptions}"
                                                                id="btnRemoveLifeFormOptions" style="margin: 2px;height: 22px" styleClass="My_Button_remove"/>
                                                        </h:panelGrid>
                                                        <!-- Selected List -->
                                                        <h:panelGrid cellspacing="1" columns="1">
                                                            <h:outputLabel id="lbSelectedLifeFormOptions" styleClass="My_white_label" value="#{inventory$SpecimenGenerationSessionBean.arLifeFormList.lbSelected}"/>
                                                            <h:selectManyListbox id="mlSelectedLifeFormList" size="7" style="width:154px;height:100px;font-size:10px;" value="#{inventory$SpecimenGenerationSessionBean.arLifeFormList.rightSelected}">
                                                                <f:selectItems id="mlSelectedLifeFormSelectItems" value="#{inventory$SpecimenGenerationSessionBean.arLifeFormList.rightOptions}"/>
                                                            </h:selectManyListbox>
                                                        </h:panelGrid>
                                                    </h:panelGrid>
                                                </h:panelGrid>
                                                <!-- End AddRemove Component -->
                                            </webuijsf:panelLayout>
                                        </webuijsf:tab>
                                    </webuijsf:tabSet>
                                    <!-- Final del tab set -->
                                    </h:panelGrid>
                                </h:panelGrid>
                                <!-- Final panel principal -->
                            </webuijsf:form>
                        </webuijsf:panelLayout> <!-- contenido ends -->
                        <jsp:directive.include file="/Footer.jspf"/>
                    </div> <!-- pageFormated ends -->
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
