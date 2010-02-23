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
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
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
                                <webuijsf:panelGroup id="grouppBotoneraPassport" style="height: 24px; width: 840px">
                                    <h:commandButton action="#{germoplasma$NewPassport.savePassportButton_action}" id="savePassportButton"
                                        style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.save_passport}"/>
                                </webuijsf:panelGroup>
                                <!-- save button -->
                                <!-- Tab menu -->
                                <webuijsf:tabSet id="tabSet1" lite="true" selected="tabGeneralInformation" styleClass="My_panel_blue">
                                    <webuijsf:tab id="tabGeneralInformation" text="#{resources.general_information}">
                                        <h:panelGrid columns="1" id="gridTabSet1" style="position: relative" width="840">
                                            <h:panelGrid columns="4" id="gridDonors" style="position: relative" width="840">
                                                <!-- Componentes de relacionados con Donadores-->
                                                <webuijsf:label id="labelDonorPerson" style="width: 168px; height: 24px" text="#{resources.donor_person}"/>
                                                <webuijsf:dropDown binding="#{germoplasma$NewPassport.dropdownDonorPerson}" id="dropdownDonorPerson"
                                                    items="#{germoplasma$NewPassport.donorPersons.options}"
                                                    selected="#{germoplasma$PassportSessionBean.passportDTO.donorPersonId}" width="200px"/>
                                                <webuijsf:label id="labelDonorInstitution" style="width: 168px; height: 24px" text="#{resources.donor_institution}"/>
                                                <webuijsf:dropDown binding="#{germoplasma$NewPassport.dropdownDonorInstitution}" id="dropdownDonorInstitution"
                                                    items="#{germoplasma$NewPassport.donorInstitutions.options}"
                                                    selected="#{germoplasma$PassportSessionBean.passportDTO.donorInstitutionId}" width="200px"/>
                                                <webuijsf:label id="labelCollectionSource" style="width: 168px; height: 24px" text="#{resources.sle_gathering_source}"/>
                                                <webuijsf:dropDown binding="#{germoplasma$NewPassport.dropdownGatheringSource}" id="dropdownGatheringSource"
                                                    items="#{germoplasma$NewPassport.gatheringSource.options}"
                                                    selected="#{germoplasma$PassportSessionBean.passportDTO.gatheringSourceId}" width="200px"/>
                                                <webuijsf:label id="labelSoilColor" style="width: 168; height: 24px" text="#{resources.sle_soil_color}"/>
                                                <webuijsf:dropDown binding="#{germoplasma$NewPassport.dropdownSoilColor}" id="dropdownSoilColor"
                                                    items="#{germoplasma$NewPassport.soilColosr.options}"
                                                    selected="#{germoplasma$PassportSessionBean.passportDTO.soilColorId}" width="200px"/>
                                                <webuijsf:label id="labelRecoleccionAsociada" style="width: 260px; height: 24px" text="#{resources.gathering_associated}"/>
                                                <webuijsf:textField disabled="true" id="textFieldRecoleccionAsociada" style="width: 200px;" text="#{germoplasma$PassportSessionBean.passportDTO.gatheringId}"/>
                                                <webuijsf:label id="labelSoilTexture" style="width: 168px; height: 24px" text="#{resources.sle_soil_texture}"/>
                                                <webuijsf:dropDown binding="#{germoplasma$NewPassport.dropdownSoilTexture}" id="dropdownSoilTexture"
                                                    items="#{germoplasma$NewPassport.soilTextures.options}"
                                                    selected="#{germoplasma$PassportSessionBean.passportDTO.soilTextureId}" width="200px"/>
                                                <webuijsf:label id="labelMisionNumber" style="width: 260px; height: 24px" text="#{resources.mission_number}"/>
                                                <webuijsf:textField binding="#{germoplasma$NewPassport.textFieldMissionNumber}" id="textFieldMisionNumber"
                                                    style="width: 200px;" text="#{germoplasma$PassportSessionBean.passportDTO.missionNumber}"/>
                                                <webuijsf:label id="labelRemarks" style="width: 168px; height: 24px" text="#{resources.remarks}"/>
                                                <webuijsf:textArea binding="#{germoplasma$NewPassport.textAreaRemarks}" id="textAreaRemarks"
                                                    style="width: 200px; height: 55px" text="#{germoplasma$PassportSessionBean.passportDTO.remarks}"/>
                                            </h:panelGrid>
                                        </h:panelGrid>
                                    </webuijsf:tab>
                                    <webuijsf:tab id="tabCropAndSample" text="#{resources.sample_crop}">
                                        <h:panelGrid columns="1" id="gridTabSet2" style="position: relative;" width="840">
                                            <h:panelGrid columns="2" id="gridTaxonomy" style="position: relative;" styleClass="My_panel_blue" width="840">
                                                <h:panelGrid columns="2" id="gTaxonomy" style="position: relative;">
                                                    <webuijsf:label id="labelTaxonomicLevel" style="width: 168px; height: 24px" text="#{resources.taxonomic_level}"/>
                                                    <webuijsf:dropDown
                                                        actionExpression="#{germoplasma$NewPassport.updateNomenclaturalGroupListActionForTaxonomicalLevelChange}"
                                                        binding="#{germoplasma$NewPassport.dropdownTaxonomicaLevel}" id="dropdownTaxonomicLevel"
                                                        items="#{germoplasma$NewPassport.taxonomicLevels.options}"
                                                        selected="#{germoplasma$PassportSessionBean.selectedTaxonomicLevel}" submitForm="true" width="200px"/>
                                                    <webuijsf:label id="labelScientificName" style="width: 168px; height: 24px" text="#{resources.scientificname}"/>
                                                    <webuijsf:dropDown actionExpression="#{germoplasma$NewPassport.updateNomenclaturalGroupListAction}"
                                                        binding="#{germoplasma$NewPassport.dropdownScientificName}" id="dropdownScientificName"
                                                        items="#{germoplasma$NewPassport.scientificNames.options}"
                                                        selected="#{germoplasma$PassportSessionBean.passportDTO.taxonId}" submitForm="true" width="200px"/>
                                                </h:panelGrid>
                                                <h:panelGrid columns="1" id="gNG" style="position: relative; left:20px">
                                                    <!-- AddRemove Component -->
                                                    <h:panelGrid cellspacing="1" columns="1" id="gridpAddRemove" style="height: 144px;" styleClass="My_table" width="336">
                                                        <!-- Title -->
                                                        <h:panelGrid columns="1" id="gridpArTitle" styleClass="My_table_top" width="100%">
                                                            <h:outputLabel id="lbArTitle" value="#{germoplasma$PassportSessionBean.arNomenclaturalGroups.lbTitle}"/>
                                                        </h:panelGrid>
                                                        <!-- Add Remove body -->
                                                        <h:panelGrid cellspacing="1" columns="3">
                                                            <!-- Available List -->
                                                            <h:panelGrid cellspacing="1" columns="1">
                                                                <h:outputLabel id="lbAvailableTaxonOptions" styleClass="My_white_label" value="#{germoplasma$PassportSessionBean.arNomenclaturalGroups.lbAvailable}"/>
                                                                <h:selectManyListbox id="mlAvaibleList" size="7" style="width:154px;height:100px" value="#{germoplasma$PassportSessionBean.arNomenclaturalGroups.leftSelected}">
                                                                    <f:selectItems id="mlAvailableSelectItems" value="#{germoplasma$PassportSessionBean.arNomenclaturalGroups.leftOptions}"/>
                                                                </h:selectManyListbox>
                                                            </h:panelGrid>
                                                            <!-- Buttons Panel -->
                                                            <h:panelGrid cellspacing="1" columns="1">
                                                                <!-- boton Agregar -->
                                                                <h:commandButton
                                                                    action="#{germoplasma$PassportSessionBean.arNomenclaturalGroups.addSelectedOptions}"
                                                                    id="btnAddOptions" style="margin: 2px;height: 22px" styleClass="My_Button_add"/>
                                                                <!-- boton Remover -->
                                                                <h:commandButton
                                                                    action="#{germoplasma$PassportSessionBean.arNomenclaturalGroups.removeSelectedOptions}"
                                                                    id="btnRemoveOptions" style="margin: 2px;height: 22px" styleClass="My_Button_remove"/>
                                                            </h:panelGrid>
                                                            <!-- Selected List -->
                                                            <h:panelGrid cellspacing="1" columns="1">
                                                                <h:outputLabel id="lbSelectedTaxonOptions" styleClass="My_white_label" value="#{germoplasma$PassportSessionBean.arNomenclaturalGroups.lbSelected}"/>
                                                                <h:selectManyListbox id="mlSelectedList" size="7" style="width:154px;height:100px" value="#{germoplasma$PassportSessionBean.arNomenclaturalGroups.rightSelected}">
                                                                    <f:selectItems id="mlSelectedSelectItems" value="#{germoplasma$PassportSessionBean.arNomenclaturalGroups.rightOptions}"/>
                                                                </h:selectManyListbox>
                                                            </h:panelGrid>
                                                        </h:panelGrid>
                                                    </h:panelGrid>
                                                    <!-- End AddRemove Component -->
                                                </h:panelGrid>
                                            </h:panelGrid>
                                            <h:panelGrid columns="4" id="gridSampleAndCrop" style="position: relative; top:10" width="840">
                                                <webuijsf:label id="labelMaterialType" style="width: 168px; height: 24px" text="#{resources.sle_material_type}"/>
                                                <webuijsf:dropDown binding="#{germoplasma$NewPassport.dropdownMaterialType}" id="dropdownMaterialType"
                                                    items="#{germoplasma$NewPassport.materialTypes.options}"
                                                    selected="#{germoplasma$PassportSessionBean.passportDTO.materialTypeId}" width="200px"/>
                                                <webuijsf:label id="labelCropPractice" style="width: 168px; height: 24px" text="#{resources.sle_cultivation_practice}"/>
                                                <webuijsf:dropDown binding="#{germoplasma$NewPassport.dropdownCultivationPractice}"
                                                    id="dropdownultivationPractice" items="#{germoplasma$NewPassport.cultivationPractice.options}"
                                                    selected="#{germoplasma$PassportSessionBean.passportDTO.cultivationPracticeId}" width="200px"/>
                                                <webuijsf:label id="labelSampleStatus" style="width: 168px; height: 24px" text="#{resources.sle_sample_status}"/>
                                                <webuijsf:dropDown binding="#{germoplasma$NewPassport.dropdownSampleStatus}" id="dropdownSampleStatus"
                                                    items="#{germoplasma$NewPassport.sampleStatus.options}"
                                                    selected="#{germoplasma$PassportSessionBean.passportDTO.sampleStatusId}" width="200px"/>
                                                <webuijsf:label id="labelCropType" style="width: 168px; height: 24px" text="#{resources.sle_crop_type}"/>
                                                <webuijsf:dropDown binding="#{germoplasma$NewPassport.dropdownCropType}" id="dropdownCropType"
                                                    items="#{germoplasma$NewPassport.cropTypes.options}"
                                                    selected="#{germoplasma$PassportSessionBean.passportDTO.cropTypeId}" width="200px"/>
                                                <webuijsf:label id="labelPlantNursery" style="width: 168px; height: 24px" text="#{resources.plant_nursery_date}"/>
                                                <webuijsf:calendar binding="#{germoplasma$NewPassport.plantNurseryDate}" id="calendarPlantNursery" style="width: 200px"/>
                                                <webuijsf:label id="labelCropSystem" style="width: 168px; height: 24px" text="#{resources.sle_crop_system}"/>
                                                <webuijsf:dropDown binding="#{germoplasma$NewPassport.dropdownCropSystem}" id="dropdownCropSystem"
                                                    items="#{germoplasma$NewPassport.cropSystems.options}"
                                                    selected="#{germoplasma$PassportSessionBean.passportDTO.cropSystemId}" width="200px"/>
                                                <webuijsf:label id="labelPlantingDate" style="width: 168px; height: 24px" text="#{resources.plantation_date}"/>
                                                <webuijsf:calendar binding="#{germoplasma$NewPassport.plantationDate}" id="calendarPlantingDate" style="width: 200px"/>
                                                <webuijsf:label id="labelCropResistence" style="width: 168px; height: 24px" text="#{resources.resistence}"/>
                                                <webuijsf:textField binding="#{germoplasma$NewPassport.textFieldResist}" id="textFieldCropResistence"
                                                    style="width: 200px;" text="#{germoplasma$PassportSessionBean.passportDTO.resistant}"/>
                                                <webuijsf:label id="labelHarvestingDate" style="width: 168px; height: 24px" text="#{resources.harvesting_date}"/>
                                                <webuijsf:calendar binding="#{germoplasma$NewPassport.harvestingDate}" id="calendarHarvestingDate" style="width: 200px"/>
                                            </h:panelGrid>
                                        </h:panelGrid>
                                    </webuijsf:tab>
                                    <webuijsf:tab id="tabRecoleccion" text="#{resources.gathering}">
                                        <h:panelGrid columns="1" id="gridAgrupacion" style="position: relative" styleClass="My_panel_blue" width="850">
                                            <!-- Componentes relacionados con Busquedas-->
                                            <h:panelGrid columns="3" id="gridpSearch" style="height: 24px" width="719">
                                                <h:inputText binding="#{germoplasma$NewPassport.txSearch}" id="txSearch" style="height: 18px; width: 408px">
                                                    <f:validateLength maximum="100" minimum="0"/>
                                                </h:inputText>
                                                <h:commandButton action="#{germoplasma$NewPassport.btnGatheringSearch_action}"
                                                    binding="#{germoplasma$NewPassport.btnSeach}" id="btnGatheringSearch" style="height: 25px; width: 160px"
                                                    styleClass="My_Button" value="#{resources.search}"/>
                                                <h:commandButton action="#{germoplasma$NewPassport.btnAdvGatheringSearch_action}"
                                                    binding="#{germoplasma$NewPassport.btnAdvSeach}" id="btnAdvGatheringSearch"
                                                    style="height: 25px; width: 160px" styleClass="My_Button" value="#{resources.advanced_search}"/>
                                            </h:panelGrid>
                                            <h:panelGrid binding="#{germoplasma$NewPassport.gridpAdvancedSearch}" columns="1" id="gridpAdvancedSearch"
                                                rendered="false" style="height: 5px" styleClass="My_panel_blue" width="680">
                                                <h:panelGrid columns="4" id="gridpAdvancedSearch1" style="height: 24px" width="670">
                                                    <webuijsf:label for="initialDateCalendar" text="#{resources.initial_date}"/>
                                                    <webuijsf:calendar binding="#{germoplasma$NewPassport.initial_date}" columns="15"
                                                        dateFormatPattern="yyyy-MM-dd" id="initialDateCalendar"/>
                                                    <webuijsf:label for="finalDateCalendar" text="#{resources.final_date}"/>
                                                    <webuijsf:calendar binding="#{germoplasma$NewPassport.final_date}" columns="15"
                                                        dateFormatPattern="yyyy-MM-dd" id="finalDateCalendar"/>
                                                    <webuijsf:label for="txGatheringId" id="lbGatheringId" text="#{resources.gathering_observation_id}"/>
                                                    <webuijsf:textField binding="#{germoplasma$NewPassport.txGatheringId}" id="txGatheringId" validatorExpression="#{util$ValidatorBean.longNumberFormatValidator}"/>
                                                    <webuijsf:label for="txResponsible" id="lbResponsible" text="#{resources.person_in_charge}"/>
                                                    <webuijsf:textField binding="#{germoplasma$NewPassport.txResponsible}" id="txResponsible" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                                    <webuijsf:label for="ddCountry" id="lbCountry" text="#{resources.country}"/>
                                                    <webuijsf:dropDown actionExpression="#{germoplasma$NewPassport.setProvinces}"
                                                        binding="#{germoplasma$NewPassport.ddCountry}" id="ddCountry"
                                                        items="#{germoplasma$NewPassport.countryData.options}"
                                                        selected="#{germoplasma$PassportSessionBean.selectedCountry}" submitForm="true" width="154px"/>
                                                    <webuijsf:label for="ddProvince" id="lbProvince" text="#{resources.state}"/>
                                                    <webuijsf:dropDown binding="#{germoplasma$NewPassport.ddProvince}" id="ddProvince"
                                                        items="#{germoplasma$NewPassport.provincesData.options}"
                                                        selected="#{germoplasma$PassportSessionBean.selectedProvince}" width="154px"/>
                                                    <webuijsf:label for="txLocality" id="lblocality" text="#{resources.locality}"/>
                                                    <webuijsf:textField binding="#{germoplasma$NewPassport.txLocality}" id="txLocality" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                                </h:panelGrid>
                                                <h:panelGrid cellspacing="1" columns="2" id="panelpCoordinates" width="670">
                                                    <h:panelGrid columns="7" id="gridpanelCoor" style="height: 24px" styleClass="My_subpanel_blue" width="500">
                                                        <webuijsf:label for="txLatitudeShort" id="lbLatitudeShort" text="#{resources.latitude}"/>
                                                        <webuijsf:textField binding="#{germoplasma$NewPassport.txLatitudeShort}" columns="10"
                                                            id="txLatitudeShort" validatorExpression="#{util$ValidatorBean.doubleNumberFormatValidator}">
                                                            <f:validateDoubleRange maximum="90.000000" minimum="-90.000000"/>
                                                        </webuijsf:textField>
                                                        <webuijsf:label for="txLongitudeShort" id="lbLongitudeShort" text="#{resources.longitude}"/>
                                                        <webuijsf:textField binding="#{germoplasma$NewPassport.txLongitudeShort}" columns="10"
                                                            id="txLongitudeShort" validatorExpression="#{util$ValidatorBean.doubleNumberFormatValidator}">
                                                            <f:validateDoubleRange maximum="180.000000" minimum="-180.000000"/>
                                                        </webuijsf:textField>
                                                        <webuijsf:label for="txRadio" id="lbRadio" text="#{resources.coor_radio}"/>
                                                        <webuijsf:textField binding="#{germoplasma$NewPassport.txRadio}" columns="10" id="txRadio" validatorExpression="#{util$ValidatorBean.longNumberFormatValidator}">
                                                            <f:validateLongRange maximum="2147483647" minimum="0"/>
                                                        </webuijsf:textField>
                                                    </h:panelGrid>
                                                    <h:commandButton action="#{germoplasma$NewPassport.btnAdvSearchGO_action}" id="btnAdvSearchGO"
                                                        style="width: 160px" styleClass="My_Button" value="#{resources.button_proceed}"/>
                                                </h:panelGrid>
                                            </h:panelGrid>
                                            <!-- FIN Componentes relacionados con Busquedas-->
                                            <!-- Tabla que posee la lista de gatherings -->
                                            <h:panelGrid id="gridpGathering_Main" style="position: relative" width="850">
                                                <h:panelGrid cellspacing="1" columns="1" id="gridpTableMain" style="height: 24px" styleClass="My_table" width="840">
                                                    <webuijsf:panelGroup id="grouppButtons">
                                                        <h:panelGrid columns="1" id="gridpquantity" styleClass="My_table_top" width="840">
                                                            <h:outputLabel id="labelQuantity" value="#{germoplasma$NewPassport.quantityTotal}"/>
                                                        </h:panelGrid>
                                                        <webuijsf:panelGroup id="panelPaginacion" separator=" " style="margin-left:70px;">
                                                            <!-- Botones de paginacion -->
                                                            <h:commandButton action="#{germoplasma$PassportSessionBean.pagination.firstResults}" id="btnFirst"
                                                                rendered="#{germoplasma$PassportSessionBean.pagination.isVisiblePrevious}"
                                                                style="margin: 2px;height: 22px" styleClass="My_Button_first" value="#{resources.pagination_first}"/>
                                                            <h:commandButton action="#{germoplasma$PassportSessionBean.pagination.previousResults}"
                                                                id="btnPrevious" rendered="#{germoplasma$PassportSessionBean.pagination.isVisiblePrevious}"
                                                                style="margin: 2px;height: 22px" styleClass="My_Button_previous" value="#{resources.pagination_previous}"/>
                                                            <h:commandButton action="#{germoplasma$PassportSessionBean.pagination.nextResults}" id="btnNext"
                                                                rendered="#{germoplasma$PassportSessionBean.pagination.isVisibleNext}"
                                                                style="margin: 2px; height: 22px" styleClass="My_Button_next" value="#{resources.pagination_next}"/>
                                                            <h:commandButton action="#{germoplasma$PassportSessionBean.pagination.lastResults}" id="btnLast"
                                                                rendered="#{germoplasma$PassportSessionBean.pagination.isVisibleNext}"
                                                                style="margin: 2px;height: 22px" styleClass="My_Button_last" value="#{resources.pagination_last}"/>
                                                        </webuijsf:panelGroup>
                                                    </webuijsf:panelGroup>
                                                    <h:dataTable binding="#{germoplasma$NewPassport.dataTableGathering}" cellspacing="0"
                                                        columnClasses="list-columns" headerClass="list-header" id="dataTablegathering"
                                                        rowClasses="list-row-even,list-row-odd"
                                                        rows="#{germoplasma$PassportSessionBean.pagination.resultsPerPage}"
                                                        style="border-top: solid rgb(214, 218, 221) 2px; border-bottom: solid rgb(214, 218, 221) 2px; border-left: solid rgb(214, 218, 221) 2px; "
                                                        value="#{germoplasma$PassportSessionBean.pagination.dataProvider.list}" var="currentRow" width="839">
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