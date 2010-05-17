<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : NewPassport
    Created on : 18/01/2010, 03:24:13 PM
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
                            <webuijsf:label id="lbTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px" styleClass="Page_title" text="#{resources.new_passport}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 50px; width: 840px" warnClass="warnMessage"/>
                                <!--Aqui se empieza a introducir los componentes dela pagina-->
                                <!-- save button -->
                                <webuijsf:panelGroup id="grouppBotoneraPassport" style="height: 24px; width: 840px">
                                    <h:commandButton action="#{germplasm$NewPassport.savePassportButton_action}" id="savePassportButton"
                                        style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.save_passport}"/>
                                </webuijsf:panelGroup>
                                <!-- Tab menu -->
                                <webuijsf:tabSet id="tabSet1" lite="true" selected="tabGeneralInformation" styleClass="My_panel_blue">
                                    <webuijsf:tab id="tabGeneralInformation" text="#{resources.general_information}">
                                        <h:panelGrid columns="1" id="gridTabSet1" style="position: relative" width="840">
                                            <h:panelGrid columns="4" id="gridDonors" style="position: relative" width="840">
                                                <!-- Componentes de relacionados con Donadores-->
                                                <webuijsf:label id="labelDonorPerson" style="width: 168px; height: 24px" text="#{resources.donor_person}"/>
                                                <webuijsf:dropDown  id="dropdownDonorPerson"
                                                    items="#{germplasm$NewPassport.donorPersons.options}"
                                                    selected="#{germplasm$PassportSessionBean.passportDTO.donorPersonId}" width="200px"/>
                                                <webuijsf:label id="labelDonorInstitution" style="width: 168px; height: 24px" text="#{resources.donor_institution}"/>
                                                <webuijsf:dropDown id="dropdownDonorInstitution"
                                                    items="#{germplasm$NewPassport.donorInstitutions.options}"
                                                    selected="#{germplasm$PassportSessionBean.passportDTO.donorInstitutionId}" width="200px"/>
                                                <webuijsf:label id="labelCollectionSource" style="width: 168px; height: 24px" text="#{resources.sle_gathering_source}"/>
                                                <webuijsf:dropDown id="dropdownGatheringSource"
                                                    items="#{germplasm$NewPassport.gatheringSource.options}"
                                                    selected="#{germplasm$PassportSessionBean.passportDTO.gatheringSourceId}" width="200px"/>
                                                <webuijsf:label id="labelSoilColor" style="width: 168; height: 24px" text="#{resources.sle_soil_color}"/>
                                                <webuijsf:dropDown id="dropdownSoilColor"
                                                    items="#{germplasm$NewPassport.soilColosr.options}"
                                                    selected="#{germplasm$PassportSessionBean.passportDTO.soilColorId}" width="200px"/>
                                                <webuijsf:label id="labelRecoleccionAsociada" style="width: 260px; height: 24px" text="#{resources.gathering_associated}"/>
                                                <webuijsf:textField columns="27" disabled="true" id="textFieldRecoleccionAsociada" style="width: 200px;" text="#{germplasm$PassportSessionBean.passportDTO.gatheringId}"/>
                                                <webuijsf:label id="labelSoilTexture" style="width: 168px; height: 24px" text="#{resources.sle_soil_texture}"/>
                                                <webuijsf:dropDown id="dropdownSoilTexture"
                                                    items="#{germplasm$NewPassport.soilTextures.options}"
                                                    selected="#{germplasm$PassportSessionBean.passportDTO.soilTextureId}" width="200px"/>
                                                <webuijsf:label id="labelMisionNumber" style="width: 260px; height: 24px" text="#{resources.mission_number}"/>
                                                <webuijsf:textField columns="27"
                                                    id="textFieldMisionNumber" style="width: 200px;" text="#{germplasm$PassportSessionBean.passportDTO.missionNumber}">
                                                    <f:validateLongRange minimum="0"/>
                                                </webuijsf:textField>
                                                <webuijsf:label id="labelRemarks" style="width: 168px; height: 24px" text="#{resources.remarks}"/>
                                                <webuijsf:textArea columns="24" id="textAreaRemarks"
                                                    style="width: 200px; height: 55px" text="#{germplasm$PassportSessionBean.passportDTO.remarks}"/>
                                            </h:panelGrid>
                                        </h:panelGrid>
                                    </webuijsf:tab>
                                    <webuijsf:tab id="tabCropAndSample" text="#{resources.sample_crop}">
                                        <h:panelGrid columns="1" id="gridTabSet2" style="position: relative;" width="840">
                                            <h:panelGrid columns="2" id="gridTaxonomy" style="position: relative;" styleClass="My_panel_blue" width="840">
                                                <h:panelGrid columns="2" id="gTaxonomy" style="position: relative;">
                                                    <webuijsf:label id="labelTaxonomicLevel" style="width: 168px; height: 24px" text="#{resources.taxonomic_level}"/>
                                                    <webuijsf:dropDown
                                                        actionExpression="#{germplasm$NewPassport.updateNomenclaturalGroupListActionForTaxonomicalLevelChange}"
                                                        id="dropdownTaxonomicLevel"
                                                        items="#{germplasm$NewPassport.taxonomicLevels.options}"
                                                        selected="#{germplasm$PassportSessionBean.selectedTaxonomicLevel}" submitForm="true" width="200px"/>
                                                    <webuijsf:label id="labelScientificName" style="width: 168px; height: 24px" text="#{resources.scientificname}"/>
                                                    <webuijsf:dropDown actionExpression="#{germplasm$NewPassport.updateNomenclaturalGroupListAction}"
                                                        id="dropdownScientificName"
                                                        items="#{germplasm$NewPassport.scientificNames.options}"
                                                        selected="#{germplasm$PassportSessionBean.passportDTO.taxonId}" submitForm="true" width="200px"/>
                                                </h:panelGrid>
                                                <h:panelGrid columns="1" id="gNG" style="position: relative; left:20px">
                                                    <!-- AddRemove Component -->
                                                    <h:panelGrid cellspacing="1" columns="1" id="gridpAddRemove" style="height: 144px;" styleClass="My_table" width="336">
                                                        <!-- Title -->
                                                        <h:panelGrid columns="1" id="gridpArTitle" styleClass="My_table_top" width="100%">
                                                            <h:outputLabel id="lbArTitle" value="#{germplasm$PassportSessionBean.arNomenclaturalGroups.lbTitle}"/>
                                                        </h:panelGrid>
                                                        <!-- Add Remove body -->
                                                        <h:panelGrid cellspacing="1" columns="3">
                                                            <!-- Available List -->
                                                            <h:panelGrid cellspacing="1" columns="1">
                                                                <h:outputLabel id="lbAvailableTaxonOptions" styleClass="My_white_label" value="#{germplasm$PassportSessionBean.arNomenclaturalGroups.lbAvailable}"/>
                                                                <h:selectManyListbox id="mlAvaibleList" size="7" style="width:154px;height:100px" value="#{germplasm$PassportSessionBean.arNomenclaturalGroups.leftSelected}">
                                                                    <f:selectItems id="mlAvailableSelectItems" value="#{germplasm$PassportSessionBean.arNomenclaturalGroups.leftOptions}"/>
                                                                </h:selectManyListbox>
                                                            </h:panelGrid>
                                                            <!-- Buttons Panel -->
                                                            <h:panelGrid cellspacing="1" columns="1">
                                                                <!-- boton Agregar -->
                                                                <h:commandButton
                                                                    action="#{germplasm$PassportSessionBean.arNomenclaturalGroups.addSelectedOptions}"
                                                                    id="btnAddOptions" style="margin: 2px;height: 22px" styleClass="My_Button_add"/>
                                                                <!-- boton Remover -->
                                                                <h:commandButton
                                                                    action="#{germplasm$PassportSessionBean.arNomenclaturalGroups.removeSelectedOptions}"
                                                                    id="btnRemoveOptions" style="margin: 2px;height: 22px" styleClass="My_Button_remove"/>
                                                            </h:panelGrid>
                                                            <!-- Selected List -->
                                                            <h:panelGrid cellspacing="1" columns="1">
                                                                <h:outputLabel id="lbSelectedTaxonOptions" styleClass="My_white_label" value="#{germplasm$PassportSessionBean.arNomenclaturalGroups.lbSelected}"/>
                                                                <h:selectManyListbox id="mlSelectedList" size="7" style="width:154px;height:100px" value="#{germplasm$PassportSessionBean.arNomenclaturalGroups.rightSelected}">
                                                                    <f:selectItems id="mlSelectedSelectItems" value="#{germplasm$PassportSessionBean.arNomenclaturalGroups.rightOptions}"/>
                                                                </h:selectManyListbox>
                                                            </h:panelGrid>
                                                        </h:panelGrid>
                                                    </h:panelGrid>
                                                    <!-- End AddRemove Component -->
                                                </h:panelGrid>
                                            </h:panelGrid>
                                            <h:panelGrid columns="4" id="gridSampleAndCrop" style="position: relative; top:10" width="840">
                                                <webuijsf:label id="labelMaterialType" style="width: 168px; height: 24px" text="#{resources.sle_material_type}"/>
                                                <webuijsf:dropDown  id="dropdownMaterialType"
                                                    items="#{germplasm$NewPassport.materialTypes.options}"
                                                    selected="#{germplasm$PassportSessionBean.passportDTO.materialTypeId}" width="200px"/>
                                                <webuijsf:label id="labelCropPractice" style="width: 168px; height: 24px" text="#{resources.sle_cultivation_practice}"/>
                                                <webuijsf:dropDown 
                                                    id="dropdownultivationPractice" items="#{germplasm$NewPassport.cultivationPractice.options}"
                                                    selected="#{germplasm$PassportSessionBean.passportDTO.cultivationPracticeId}" width="200px"/>
                                                <webuijsf:label id="labelSampleStatus" style="width: 168px; height: 24px" text="#{resources.sle_sample_status}"/>
                                                <webuijsf:dropDown  id="dropdownSampleStatus"
                                                    items="#{germplasm$NewPassport.sampleStatus.options}"
                                                    selected="#{germplasm$PassportSessionBean.passportDTO.sampleStatusId}" width="200px"/>
                                                <webuijsf:label id="labelCropType" style="width: 168px; height: 24px" text="#{resources.sle_crop_type}"/>
                                                <webuijsf:dropDown id="dropdownCropType"
                                                    items="#{germplasm$NewPassport.cropTypes.options}"
                                                    selected="#{germplasm$PassportSessionBean.passportDTO.cropTypeId}" width="200px"/>
                                                <webuijsf:label id="labelPlantNursery" style="width: 168px; height: 24px" text="#{resources.plant_nursery_date}"/>
                                                <webuijsf:calendar binding="#{germplasm$NewPassport.plantNurseryDate}" id="calendarPlantNursery" style="width: 200px"/>
                                                <webuijsf:label id="labelCropSystem" style="width: 168px; height: 24px" text="#{resources.sle_crop_system}"/>
                                                <webuijsf:dropDown  id="dropdownCropSystem"
                                                    items="#{germplasm$NewPassport.cropSystems.options}"
                                                    selected="#{germplasm$PassportSessionBean.passportDTO.cropSystemId}" width="200px"/>
                                                <webuijsf:label id="labelPlantingDate" style="width: 168px; height: 24px" text="#{resources.plantation_date}"/>
                                                <webuijsf:calendar binding="#{germplasm$NewPassport.plantationDate}" id="calendarPlantingDate" style="width: 200px"/>
                                                <webuijsf:label id="labelCropResistence" style="width: 168px; height: 24px" text="#{resources.resistence}"/>
                                                <webuijsf:textField columns="27" id="textFieldCropResistence"
                                                    style="width: 200px;" text="#{germplasm$PassportSessionBean.passportDTO.resistant}"/>
                                                <webuijsf:label id="labelHarvestingDate" style="width: 168px; height: 24px" text="#{resources.harvesting_date}"/>
                                                <webuijsf:calendar binding="#{germplasm$NewPassport.harvestingDate}" id="calendarHarvestingDate" style="width: 200px"/>
                                            </h:panelGrid>
                                        </h:panelGrid>
                                    </webuijsf:tab>
                                    <webuijsf:tab id="tabRecoleccion" text="#{resources.gathering}">
                                        <h:panelGrid columns="1" id="gridAgrupacion" style="position: relative" styleClass="My_panel_blue" width="850">
                                            <!-- Componentes relacionados con Busquedas-->
                                            <h:panelGrid columns="3" id="gridpSearch" style="height: 24px" width="719">
                                                <h:inputText binding="#{germplasm$NewPassport.txSearch}" id="txSearch" style="height: 18px; width: 408px">
                                                    <f:validateLength maximum="100" minimum="0"/>
                                                </h:inputText>
                                                <h:commandButton action="#{germplasm$NewPassport.btnGatheringSearch_action}"
                                                    binding="#{germplasm$NewPassport.btnSeach}" id="btnGatheringSearch" style="height: 25px; width: 160px"
                                                    styleClass="My_Button" value="#{resources.search}"/>
                                                <h:commandButton action="#{germplasm$NewPassport.btnAdvGatheringSearch_action}"
                                                    binding="#{germplasm$NewPassport.btnAdvSeach}" id="btnAdvGatheringSearch" style="height: 25px; width: 160px"
                                                    styleClass="My_Button" value="#{resources.advanced_search}"/>
                                            </h:panelGrid>
                                            <h:panelGrid binding="#{germplasm$NewPassport.gridpAdvancedSearch}" columns="1" id="gridpAdvancedSearch"
                                                rendered="false" style="height: 5px" styleClass="My_panel_blue" width="680">
                                                <h:panelGrid columns="4" id="gridpAdvancedSearch1" style="height: 24px" width="670">
                                                    <webuijsf:label for="initialDateCalendar" text="#{resources.initial_date}"/>
                                                    <webuijsf:calendar binding="#{germplasm$NewPassport.initial_date}" columns="15"
                                                        dateFormatPattern="yyyy-MM-dd" id="initialDateCalendar"/>
                                                    <webuijsf:label for="finalDateCalendar" text="#{resources.final_date}"/>
                                                    <webuijsf:calendar binding="#{germplasm$NewPassport.final_date}" columns="15" dateFormatPattern="yyyy-MM-dd" id="finalDateCalendar"/>
                                                    <webuijsf:label for="txGatheringId" id="lbGatheringId" text="#{resources.gathering_observation_id}"/>
                                                    <webuijsf:textField binding="#{germplasm$NewPassport.txGatheringId}" id="txGatheringId" validatorExpression="#{util$ValidatorBean.longNumberFormatValidator}"/>
                                                    <webuijsf:label for="txResponsible" id="lbResponsible" text="#{resources.person_in_charge}"/>
                                                    <webuijsf:textField binding="#{germplasm$NewPassport.txResponsible}" id="txResponsible" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                                    <webuijsf:label for="ddCountry" id="lbCountry" text="#{resources.country}"/>
                                                    <webuijsf:dropDown actionExpression="#{germplasm$NewPassport.setProvinces}"
                                                        binding="#{germplasm$NewPassport.ddCountry}" id="ddCountry"
                                                        items="#{germplasm$NewPassport.countryData.options}"
                                                        selected="#{germplasm$PassportSessionBean.selectedCountry}" submitForm="true" width="154px"/>
                                                    <webuijsf:label for="ddProvince" id="lbProvince" text="#{resources.state}"/>
                                                    <webuijsf:dropDown binding="#{germplasm$NewPassport.ddProvince}" id="ddProvince"
                                                        items="#{germplasm$NewPassport.provincesData.options}"
                                                        selected="#{germplasm$PassportSessionBean.selectedProvince}" width="154px"/>
                                                    <webuijsf:label for="txLocality" id="lblocality" text="#{resources.locality}"/>
                                                    <webuijsf:textField binding="#{germplasm$NewPassport.txLocality}" id="txLocality" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                                </h:panelGrid>
                                                <h:panelGrid cellspacing="1" columns="2" id="panelpCoordinates" width="670">
                                                    <h:panelGrid columns="7" id="gridpanelCoor" style="height: 24px" styleClass="My_subpanel_blue" width="500">
                                                        <webuijsf:label for="txLatitudeShort" id="lbLatitudeShort" text="#{resources.latitude}"/>
                                                        <webuijsf:textField binding="#{germplasm$NewPassport.txLatitudeShort}" columns="10" id="txLatitudeShort" validatorExpression="#{util$ValidatorBean.doubleNumberFormatValidator}">
                                                            <f:validateDoubleRange maximum="90.000000" minimum="-90.000000"/>
                                                        </webuijsf:textField>
                                                        <webuijsf:label for="txLongitudeShort" id="lbLongitudeShort" text="#{resources.longitude}"/>
                                                        <webuijsf:textField binding="#{germplasm$NewPassport.txLongitudeShort}" columns="10"
                                                            id="txLongitudeShort" validatorExpression="#{util$ValidatorBean.doubleNumberFormatValidator}">
                                                            <f:validateDoubleRange maximum="180.000000" minimum="-180.000000"/>
                                                        </webuijsf:textField>
                                                        <webuijsf:label for="txRadio" id="lbRadio" text="#{resources.coor_radio}"/>
                                                        <webuijsf:textField binding="#{germplasm$NewPassport.txRadio}" columns="10" id="txRadio" validatorExpression="#{util$ValidatorBean.longNumberFormatValidator}">
                                                            <f:validateLongRange maximum="2147483647" minimum="0"/>
                                                        </webuijsf:textField>
                                                    </h:panelGrid>
                                                    <h:commandButton action="#{germplasm$NewPassport.btnAdvSearchGO_action}" id="btnAdvSearchGO"
                                                        style="width: 160px" styleClass="My_Button" value="#{resources.button_proceed}"/>
                                                </h:panelGrid>
                                            </h:panelGrid>
                                            <!-- FIN Componentes relacionados con Busquedas-->
                                            <!-- Tabla que posee la lista de gatherings -->
                                            <h:panelGrid id="gridpGathering_Main" style="position: relative" width="850">
                                                <h:panelGrid cellspacing="1" columns="1" id="gridpTableMain" style="height: 24px" styleClass="My_table" width="840">
                                                    <webuijsf:panelGroup id="grouppButtons">
                                                        <h:panelGrid columns="1" id="gridpquantity" styleClass="My_table_top" width="840">
                                                            <h:outputLabel id="labelQuantity" value="#{germplasm$NewPassport.quantityTotal}"/>
                                                        </h:panelGrid>
                                                        <webuijsf:panelGroup id="panelPaginacion" separator=" " style="margin-left:70px;">
                                                            <!-- Botones de paginacion -->
                                                            <h:commandButton action="#{germplasm$PassportSessionBean.pagination.firstResults}" id="btnFirst"
                                                                rendered="#{germplasm$PassportSessionBean.pagination.isVisiblePrevious}"
                                                                style="margin: 2px;height: 22px" styleClass="My_Button_first" value="#{resources.pagination_first}"/>
                                                            <h:commandButton action="#{germplasm$PassportSessionBean.pagination.previousResults}"
                                                                id="btnPrevious" rendered="#{germplasm$PassportSessionBean.pagination.isVisiblePrevious}"
                                                                style="margin: 2px;height: 22px" styleClass="My_Button_previous" value="#{resources.pagination_previous}"/>
                                                            <h:commandButton action="#{germplasm$PassportSessionBean.pagination.nextResults}" id="btnNext"
                                                                rendered="#{germplasm$PassportSessionBean.pagination.isVisibleNext}"
                                                                style="margin: 2px; height: 22px" styleClass="My_Button_next" value="#{resources.pagination_next}"/>
                                                            <h:commandButton action="#{germplasm$PassportSessionBean.pagination.lastResults}" id="btnLast"
                                                                rendered="#{germplasm$PassportSessionBean.pagination.isVisibleNext}"
                                                                style="margin: 2px;height: 22px" styleClass="My_Button_last" value="#{resources.pagination_last}"/>
                                                        </webuijsf:panelGroup>
                                                    </webuijsf:panelGroup>
                                                    <h:dataTable binding="#{germplasm$NewPassport.dataTableGathering}" cellspacing="0"
                                                        columnClasses="list-columns" headerClass="list-header" id="dataTablegathering"
                                                        rowClasses="list-row-even,list-row-odd"
                                                        rows="#{germplasm$PassportSessionBean.pagination.resultsPerPage}"
                                                        style="border-top: solid rgb(214, 218, 221) 2px; border-bottom: solid rgb(214, 218, 221) 2px; border-left: solid rgb(214, 218, 221) 2px; "
                                                        value="#{germplasm$PassportSessionBean.pagination.dataProvider.list}" var="currentRow" width="839">
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
                                                                <h:outputText value="#{resources.country}"/>
                                                            </f:facet>
                                                            <h:outputText value="#{currentRow['countryName']}"/>
                                                        </h:column>
                                                        <h:column>
                                                            <f:facet name="header">
                                                                <h:outputText value="#{resources.state}"/>
                                                            </f:facet>
                                                            <h:outputText value="#{currentRow['provinceName']}"/>
                                                        </h:column>
                                                        <h:column>
                                                            <f:facet name="header">
                                                                <h:outputText value="#{resources.locality}"/>
                                                            </f:facet>
                                                            <h:outputText value="#{currentRow['localityDescription']}"/>
                                                        </h:column>
                                                        <h:column>
                                                            <f:facet name="header">
                                                                <h:outputText value="#{resources.coordinates}"/>
                                                            </f:facet>
                                                            <h:outputText value="#{currentRow['coordinates']}"/>
                                                        </h:column>
                                                        <h:column>
                                                            <f:facet name="header">
                                                                <h:outputText value="#{resources.person_in_charge}"/>
                                                            </f:facet>
                                                            <h:outputText value="#{currentRow['responsibleName']}"/>
                                                        </h:column>
                                                        <h:column>
                                                            <f:facet name="header">
                                                                <h:outputText value="#{resources.initial_date}"/>
                                                            </f:facet>
                                                            <h:outputText value="#{currentRow['initialDateTime']}"/>
                                                        </h:column>
                                                        <h:column>
                                                            <f:facet name="header">
                                                                <h:outputText value="#{resources.final_date}"/>
                                                            </f:facet>
                                                            <h:outputText value="#{currentRow['finalDateTime']}"/>
                                                        </h:column>
                                                    </h:dataTable>
                                                </h:panelGrid>
                                            </h:panelGrid>
                                            <!-- FIN Tabla que posee la lista de gatherings -->
                                        </h:panelGrid>
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
