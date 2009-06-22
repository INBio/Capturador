<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{gathering$specimenGeneration.page1}" id="page1">
            <webuijsf:html binding="#{gathering$specimenGeneration.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{gathering$specimenGeneration.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido" style="position: relative; -rave-layout: grid">
                        <webuijsf:form binding="#{gathering$specimenGeneration.form1}" id="form1">
                            <h:messages binding="#{gathering$specimenGeneration.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage"
                                id="messageList1" infoClass="infoMessage" style="left: 400px; top: 24px; position: absolute; width: 216px" warnClass="warnMessage"/>
                            <webuijsf:label binding="#{gathering$specimenGeneration.label1}" id="label1"
                                style="font-size: 24px; height: 22px; left: 24px; top: 24px; position: absolute; width: 358px" text="#{resources.sp_gen_and_identifications}"/>
                            <webuijsf:label binding="#{gathering$specimenGeneration.label2}" id="label2"
                                style="color: #e8e41f; height: 24px; left: 24px; top: 72px; position: absolute; width: 94px"
                                text="#{resources.gathering_observation}" visible="false"/>
                            <webuijsf:staticText binding="#{gathering$specimenGeneration.st_gatheringDesc}" id="st_gatheringDesc"
                                style="height: 46px; left: 144px; top: 72px; position: absolute; width: 358px" visible="false"/>
                            <webuijsf:button actionExpression="#{gathering$specimenGeneration.btn_generate_action}"
                                binding="#{gathering$specimenGeneration.btn_generate}" id="btn_generate"
                                style="height: 24px; left: 647px; top: 24px; position: absolute; width: 144px" text="#{resources.generate}"/>
                            <webuijsf:panelLayout binding="#{gathering$specimenGeneration.lyt_basicOptions1}" id="lyt_basicOptions1" style="border: 1px solid gray; height: 190px; left: 24px; top: 120px; position: absolute; width: 886px; -rave-layout: grid">
                                <webuijsf:label binding="#{gathering$specimenGeneration.label_specimensQuantity}" id="label_specimensQuantity"
                                    style="left: 24px; top: 24px; position: absolute" text="#{resources.quantity}"/>
                                <webuijsf:textField binding="#{gathering$specimenGeneration.txt_quantity1}" columns="14" id="txt_quantity1" maxLength="7" style="left: 192px; top: 24px; position: absolute; width: 100px"/>
                                <webuijsf:label binding="#{gathering$specimenGeneration.label_specimenCategory}" id="label_specimenCategory"
                                    style="height: 27px; left: 24px; top: 72px; position: absolute" text="#{resources.category}"/>
                                <webuijsf:dropDown binding="#{gathering$specimenGeneration.dd_specimenCategory1}" id="dd_specimenCategory1"
                                    items="#{gathering$SpecimenGenerationSessionBean.specimenCategoryOption}"
                                    onChange="webui.suntheme.common.timeoutSubmitForm(this.form, 'lyt_basicOptions1:dd_specimenCategory1');"
                                    selected="#{gathering$SpecimenGenerationSessionBean.selectedSpecimenCategory}"
                                    style="left: 192px; top: 72px; position: absolute"
                                    valueChangeListenerExpression="#{gathering$specimenGeneration.dd_specimenCategory1_processValueChange}" width="118px"/>
                                <webuijsf:label binding="#{gathering$specimenGeneration.label_specimenType}" id="label_specimenType"
                                    style="left: 24px; top: 96px; position: absolute" text="#{resources.type}"/>
                                <webuijsf:dropDown binding="#{gathering$specimenGeneration.dd_specimenType1}" id="dd_specimenType1"
                                    items="#{gathering$SpecimenGenerationSessionBean.specimenTypeOption}"
                                    selected="#{gathering$SpecimenGenerationSessionBean.selectedSpecimenType}"
                                    style="left: 192px; top: 96px; position: absolute" width="118px"/>
                                <webuijsf:label binding="#{gathering$specimenGeneration.label_specimenOrigin}" id="label_specimenOrigin"
                                    style="left: 24px; top: 120px; position: absolute" text="#{resources.origin}"/>
                                <webuijsf:dropDown binding="#{gathering$specimenGeneration.dd_origin1}" id="dd_origin1"
                                    items="#{gathering$SpecimenGenerationSessionBean.originOption}"
                                    selected="#{gathering$SpecimenGenerationSessionBean.selectedOrigin}" style="left: 192px; top: 120px; position: absolute" width="118px"/>
                                <webuijsf:label id="label_catalogNumber" style="left: 24px; top: 144px; position: absolute" text="#{resources.initial_catalog_number}"/>
                                <webuijsf:textField binding="#{gathering$specimenGeneration.txt_initCatalogNumber}" columns="13" id="txt_initCatalogNumber" style="left: 192px; top: 144px; position: absolute; width: 100px"/>
                                <webuijsf:label binding="#{gathering$specimenGeneration.label_preservationMedium}" id="label_preservationMedium"
                                    style="left: 336px; top: 24px; position: absolute" text="#{resources.preservation_medium}"/>
                                <webuijsf:dropDown binding="#{gathering$specimenGeneration.dd_preservationMedium1}" id="dd_preservationMedium1"
                                    items="#{gathering$SpecimenGenerationSessionBean.preservationMediumOption}"
                                    selected="#{gathering$SpecimenGenerationSessionBean.selectedPreservationMedium}"
                                    style="left: 480px; top: 24px; position: absolute" width="118px"/>
                                <webuijsf:label binding="#{gathering$specimenGeneration.label_Storage}" id="label_Storage"
                                    style="height: 36px; left: 336px; top: 48px; position: absolute" text="#{resources.storage}"/>
                                <webuijsf:dropDown binding="#{gathering$specimenGeneration.dd_storageType1}" id="dd_storageType1"
                                    items="#{gathering$SpecimenGenerationSessionBean.storageTypeOption}"
                                    selected="#{gathering$SpecimenGenerationSessionBean.selectedStorageType}" style="left: 480px; top: 48px; position: absolute" width="118px"/>
                                <webuijsf:label binding="#{gathering$specimenGeneration.label_Substrate}" id="label_Substrate"
                                    style="left: 336px; top: 72px; position: absolute" text="#{resources.substrate}"/>
                                <webuijsf:dropDown binding="#{gathering$specimenGeneration.dd_substrate1}" id="dd_substrate1"
                                    items="#{gathering$SpecimenGenerationSessionBean.substrateOption}"
                                    selected="#{gathering$SpecimenGenerationSessionBean.selectedSubstrate}" style="left: 480px; top: 72px; position: absolute" width="118px"/>
                                <webuijsf:label binding="#{gathering$specimenGeneration.label_extractionMethod}" id="label_extractionMethod"
                                    style="left: 336px; top: 96px; position: absolute" text="#{resources.extraction_method}"/>
                                <webuijsf:dropDown binding="#{gathering$specimenGeneration.dd_extractionType}" id="dd_extractionType"
                                    items="#{gathering$SpecimenGenerationSessionBean.extractionMethod}"
                                    selected="#{gathering$SpecimenGenerationSessionBean.selectedExtractionMethod}"
                                    style="left: 480px; top: 96px; position: absolute"
                                    valueChangeListenerExpression="#{gathering$specimenGeneration.dd_extractionType_processValueChange}" width="118px"/>
                                <webuijsf:label binding="#{gathering$specimenGeneration.label_gatheringMethod}" id="label_gatheringMethod"
                                    style="left: 24px; top: 48px; position: absolute" text="#{resources.gath_method}"/>
                                <webuijsf:dropDown binding="#{gathering$specimenGeneration.dd_gatheringObservationMethod}" id="dd_gatheringObservationMethod"
                                    items="#{gathering$SpecimenGenerationSessionBean.gatheringMethods}"
                                    selected="#{gathering$SpecimenGenerationSessionBean.selectedGatheringMethod}"
                                    style="left: 192px; top: 48px; position: absolute" width="118px"/>
                                <webuijsf:label binding="#{gathering$specimenGeneration.label_certaintyLevel}" id="label_certaintyLevel"
                                    style="left: 336px; top: 120px; position: absolute" text="#{resources.certainty_level}"/>
                                <webuijsf:textField binding="#{gathering$specimenGeneration.txt_certaintyLevel1}" columns="13" id="txt_certaintyLevel1" style="left: 480px; top: 120px; position: absolute; weight: 100.0px"/>
                                <webuijsf:label id="label_institution" style="left: 336px; top: 144px; position: absolute" text="#{resources.institution}"/>
                                <webuijsf:dropDown id="dd_institution" items="#{gathering$SpecimenGenerationSessionBean.institution}"
                                    selected="#{gathering$SpecimenGenerationSessionBean.selectedInstitution}"
                                    style="height: 24px; left: 480px; top: 144px; position: absolute" width="118px"/>
                                <webuijsf:label binding="#{gathering$specimenGeneration.label_observationDate}" id="label_observationDate"
                                    style="height: 29px; left: 624px; top: 24px; position: absolute" text="#{resources.date}"/>
                                <webuijsf:calendar binding="#{gathering$specimenGeneration.cal_ObsDate1}" dateFormatPattern="dd/MM/yyyy"
                                    dateFormatPatternHelp="dd/mm/yyyy" id="cal_ObsDate1" maxDate="#{ApplicationBean1.todayDate}"
                                    minDate="#{ApplicationBean1.minDate}" selectedDate="#{gathering$SpecimenGenerationSessionBean.observationDate}" style="left: 690px; top: 24px; position: absolute"/>
                                <webuijsf:label binding="#{gathering$specimenGeneration.label_observationTime}" id="label_observationTime"
                                    style="left: 624px; top: 72px; position: absolute" text="#{resources.time}"/>
                                <webuijsf:dropDown binding="#{gathering$specimenGeneration.dd_hour}" id="dd_hour"
                                    items="#{gathering$specimenGeneration.dd_hourDefaultOptions.options}"
                                    selected="#{gathering$SpecimenGenerationSessionBean.hour}" style="left: 696px; top: 72px; position: absolute" width="40px"/>
                                <webuijsf:dropDown binding="#{gathering$specimenGeneration.dd_minute}" id="dd_minute"
                                    items="#{gathering$specimenGeneration.dd_minuteDefaultOptions.options}"
                                    selected="#{gathering$SpecimenGenerationSessionBean.minute}" style="left: 768px; top: 72px; position: absolute" width="40px"/>
                            </webuijsf:panelLayout>
                            <webuijsf:button actionExpression="#{gathering$specimenGeneration.btn_showSpecimenList_action}"
                                binding="#{gathering$specimenGeneration.btn_showSpecimenList}" id="btn_showSpecimenList"
                                style="height: 24px; left: 647px; top: 72px; position: absolute; width: 192px" text="#{resources.view_generated_specimens}"/>
                            <webuijsf:panelLayout id="layoutPanel_specimenGenerationOption" panelLayout="flow" style="height: 430px; left: 24px; top: 336px; position: absolute; width: 886px">
                                <webuijsf:tabSet id="tabSet_specimenGeneratorOption" selected="tab_Identification" style="border: 1px solid gray; width: 887px">
                                    <webuijsf:tab id="tab_Identification" tabIndex="1" text="#{resources.identification}">
                                        <webuijsf:panelLayout id="layoutPanel_Identification" style="height: 529px; position: relative; width: 815px; -rave-layout: grid">
                                            <webuijsf:label binding="#{gathering$specimenGeneration.label_taxonomicalRange}" id="label_taxonomicalRange"
                                                style="left: 24px; top: 24px; position: absolute; width: 142px" text="#{resources.taxonomical_level}"/>
                                            <webuijsf:label binding="#{gathering$specimenGeneration.label_taxonCategory}" id="label_taxonCategory"
                                                style="left: 24px; top: 48px; position: absolute; width: 142px" text="#{resources.category}"/>
                                            <webuijsf:dropDown binding="#{gathering$specimenGeneration.dd_taxonomicalRange1}" id="dd_taxonomicalRange1"
                                                items="#{gathering$SpecimenGenerationSessionBean.taxonomicalRangeOption}"
                                                onChange="webui.suntheme.common.timeoutSubmitForm(this.form, 'layoutPanel1:dd_taxonomicalRange1');"
                                                selected="#{gathering$SpecimenGenerationSessionBean.selectedTaxonomicalRange}"
                                                style="left: 192px; top: 24px; position: absolute" valueChangeListenerExpression="#{gathering$specimenGeneration.dd_taxonomicalRange1_processValueChange}"/>
                                            <webuijsf:dropDown binding="#{gathering$specimenGeneration.dd_taxonomicalCategory1}" id="dd_taxonomicalCategory1"
                                                items="#{gathering$SpecimenGenerationSessionBean.taxonCategoryOption}"
                                                onChange="webui.suntheme.common.timeoutSubmitForm(this.form, 'layoutPanel1:dd_taxonomicalCategory1');"
                                                selected="#{gathering$SpecimenGenerationSessionBean.selectedTaxonCategory}"
                                                style="left: 192px; top: 48px; position: absolute" valueChangeListenerExpression="#{gathering$specimenGeneration.dd_taxonomicalCategory1_processValueChange}"/>
                                            <webuijsf:addRemove availableItemsLabel="#{resources.available}"
                                                binding="#{gathering$specimenGeneration.ad_taxonList1}" id="ad_taxonList1"
                                                items="#{gathering$SpecimenGenerationSessionBean.taxonList}" rows="7"
                                                selected="#{gathering$SpecimenGenerationSessionBean.selectedTaxon}" selectedItemsLabel="#{resources.selected}" style="left: 24px; top: 144px; position: absolute"/>
                                            <webuijsf:label binding="#{gathering$specimenGeneration.label_identificationDate}" id="label_identificationDate"
                                                style="left: 480px; top: 24px; position: absolute; width: 118px" text="#{resources.identification_date}"/>
                                            <webuijsf:label binding="#{gathering$specimenGeneration.label_identificationType}" id="label_identificationType"
                                                style="left: 480px; top: 96px; position: absolute; width: 118px" text="#{resources.type}"/>
                                            <webuijsf:label binding="#{gathering$specimenGeneration.label_identificationValidator}"
                                                id="label_identificationValidator" style="left: 24px; top: 72px; position: absolute; width: 142px" text="#{resources.validator}"/>
                                            <webuijsf:addRemove availableItemsLabel="Disponibles:" binding="#{gathering$specimenGeneration.ar_identifier1}"
                                                id="ar_identifier1" items="#{gathering$SpecimenGenerationSessionBean.identifierOption}" rows="7"
                                                selected="#{gathering$SpecimenGenerationSessionBean.selectedIdentifier}" selectedItemsLabel="Seleccionados:" style="height: 166px; left: 24px; top: 336px; position: absolute"/>
                                            <webuijsf:label binding="#{gathering$specimenGeneration.label_identifiers}" id="label_identifiers"
                                                style="left: 24px; top: 312px; position: absolute" text="#{resources.identifiers}"/>
                                            <webuijsf:label binding="#{gathering$specimenGeneration.label_Status}" id="label_Status"
                                                style="left: 480px; top: 72px; position: absolute" text="Status"/>
                                            <webuijsf:label binding="#{gathering$specimenGeneration.label_Taxa}" id="label_Taxa"
                                                style="left: 24px; top: 120px; position: absolute" text="Taxones"/>
                                            <webuijsf:calendar binding="#{gathering$specimenGeneration.cal_identificationDate1}" dateFormatPattern="dd/MM/yyyy"
                                                dateFormatPatternHelp="dd/MM/yyyy" id="cal_identificationDate1" maxDate="#{ApplicationBean1.todayDate}"
                                                minDate="#{ApplicationBean1.minDate}" style="left: 614px; top: 24px; position: absolute; text-align: left"/>
                                            <webuijsf:dropDown binding="#{gathering$specimenGeneration.dd_validator1}" id="dd_validator1"
                                                items="#{gathering$SpecimenGenerationSessionBean.identificationValidatorOption}"
                                                selected="#{gathering$SpecimenGenerationSessionBean.selectedIdentificationValidator}" style="left: 192px; top: 72px; position: absolute"/>
                                            <webuijsf:dropDown binding="#{gathering$specimenGeneration.dd_identificationStatus1}" id="dd_identificationStatus1"
                                                items="#{gathering$SpecimenGenerationSessionBean.identificationStatusOption}" onChange=""
                                                selected="#{gathering$SpecimenGenerationSessionBean.selectedIdentificationStatus}" style="left: 624px; top: 72px; position: absolute"/>
                                            <webuijsf:dropDown binding="#{gathering$specimenGeneration.dd_identificationType1}" id="dd_identificationType1"
                                                items="#{gathering$SpecimenGenerationSessionBean.identificationTypeOption}" onChange=""
                                                selected="#{gathering$SpecimenGenerationSessionBean.selectedIdentificationType}" style="left: 624px; top: 96px; position: absolute"/>
                                        </webuijsf:panelLayout>
                                    </webuijsf:tab>
                                    <webuijsf:tab id="tab_stadiumSex" tabIndex="2" text="#{resources.sexesandstages}">
                                        <webuijsf:panelLayout id="layoutPanel_stadiumSex" style="height: 193px; position: relative; width: 100%; -rave-layout: grid">
                                            <webuijsf:label binding="#{gathering$specimenGeneration.label_Stadium}" id="label_Stadium"
                                                style="left: 24px; top: 24px; position: absolute; width: 94px" text="#{resources.life_stage}"/>
                                            <webuijsf:dropDown binding="#{gathering$specimenGeneration.dd_sex1}" id="dd_sex1"
                                                items="#{gathering$SpecimenGenerationSessionBean.sexOption}"
                                                selected="#{gathering$SpecimenGenerationSessionBean.selectedSex}" style="left: 144px; top: 48px; position: absolute"/>
                                            <webuijsf:dropDown binding="#{gathering$specimenGeneration.dd_stadium1}" id="dd_stadium1"
                                                items="#{gathering$SpecimenGenerationSessionBean.lifeStageOption}"
                                                selected="#{gathering$SpecimenGenerationSessionBean.selectedLifeStage}" style="left: 144px; top: 24px; position: absolute"/>
                                            <webuijsf:label binding="#{gathering$specimenGeneration.label_Sex}" id="label_Sex"
                                                style="left: 24px; top: 48px; position: absolute; width: 94px" text="#{resources.sex}"/>
                                            <webuijsf:button actionExpression="#{gathering$specimenGeneration.btn_addStadiumSex1_action}"
                                                binding="#{gathering$specimenGeneration.btn_addStadiumSex1}" id="btn_addStadiumSex1"
                                                style="height: 23px; left: 71px; top: 144px; position: absolute; width: 60px" text="#{resources.btnNew}"/>
                                            <webuijsf:table binding="#{gathering$specimenGeneration.t_stadiumSex1}" id="t_stadiumSex1" paginateButton="true"
                                                paginationControls="true" style="height: 42px; left: 360px; top: 24px; position: absolute; width: 301px"
                                                title="#{resources.selected}" width="301">
                                                <webuijsf:tableRowGroup binding="#{gathering$specimenGeneration.tableRowGroup1}" id="tableRowGroup1" rows="4"
                                                    sourceData="#{gathering$SpecimenGenerationSessionBean.lifeStageSexSimpleDataProvider}" sourceVar="currentRow">
                                                    <webuijsf:tableColumn binding="#{gathering$specimenGeneration.tableColumn1}"
                                                        headerText="#{resources.life_stage}" id="tableColumn1" width="113">
                                                        <webuijsf:staticText binding="#{gathering$specimenGeneration.staticText3}" id="staticText3" text="#{currentRow.value['lifeStageName']}"/>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn binding="#{gathering$specimenGeneration.tableColumn2}" headerText="#{resources.sex}" id="tableColumn2">
                                                        <webuijsf:staticText binding="#{gathering$specimenGeneration.staticText4}" id="staticText4" text="#{currentRow.value['sexName']}"/>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn binding="#{gathering$specimenGeneration.tableColumn3}"
                                                        headerText="#{resources.quantity}" id="tableColumn3" width="56">
                                                        <webuijsf:staticText binding="#{gathering$specimenGeneration.staticText5}" id="staticText5" text="#{currentRow.value['quantity']}"/>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn binding="#{gathering$specimenGeneration.tableColumn4}" id="tableColumn4" width="17">
                                                        <webuijsf:button actionExpression="#{gathering$specimenGeneration.btn_removeStadiumSex1_action}"
                                                            binding="#{gathering$specimenGeneration.btn_removeStadiumSex1}" id="btn_removeStadiumSex1"
                                                            style="height: 23px; left: 95px;" text="#{resources.btnDelete}"/>
                                                    </webuijsf:tableColumn>
                                                </webuijsf:tableRowGroup>
                                            </webuijsf:table>
                                            <webuijsf:label binding="#{gathering$specimenGeneration.specimensQuantity}" id="specimensQuantity"
                                                style="left: 24px; top: 96px; position: absolute; width: 94px" text="#{resources.quantity}"/>
                                            <webuijsf:textField binding="#{gathering$specimenGeneration.txt_ssQuantity}" columns="4" id="txt_ssQuantity"
                                                maxLength="4" style="left: 144px; top: 96px; position: absolute"/>
                                        </webuijsf:panelLayout>
                                    </webuijsf:tab>
                                    <webuijsf:tab id="tab_lifeForm" tabIndex="3" text="#{resources.life_forms}">
                                        <webuijsf:panelLayout id="layoutPanel_lifeForm" style="width: 100%; height: 128px;">
                                            <webuijsf:label binding="#{gathering$specimenGeneration.label_lifeForm}" id="label_lifeForm"
                                                style="left: 24px; top: 48px; position: absolute" text="#{resources.life_forms}"/>
                                            <webuijsf:listbox binding="#{gathering$specimenGeneration.lst_lifeForm1}" id="lst_lifeForm1"
                                                items="#{gathering$SpecimenGenerationSessionBean.lifeFormOption}" multiple="true" rows="4"
                                                selected="#{gathering$SpecimenGenerationSessionBean.selectedLifeForm}" separators="false"
                                                style="left: 120px; top: 48px; position: absolute" width="100"/>
                                        </webuijsf:panelLayout>
                                    </webuijsf:tab>
                                    <webuijsf:tab id="tab_fragmentsAndWholes" tabIndex="4" text="#{resources.wholesandfragments}">
                                        <webuijsf:panelLayout id="layoutPanel_fragmentsAndWholes" style="height: 145px; position: relative; width: 100%; -rave-layout: grid">
                                            <webuijsf:label binding="#{gathering$specimenGeneration.label_Fragments}" id="label_Fragments"
                                                style="left: 24px; top: 96px; position: absolute; width: 141px" text="#{resources.num_fragments}"/>
                                            <webuijsf:textField binding="#{gathering$specimenGeneration.txt_numberWhole1}" id="txt_numberWhole1" maxLength="6" style="left: 192px; top: 48px; position: absolute"/>
                                            <webuijsf:textField binding="#{gathering$specimenGeneration.txt_numberFragment1}" id="txt_numberFragment1"
                                                maxLength="6" style="left: 192px; top: 96px; position: absolute"/>
                                            <webuijsf:label binding="#{gathering$specimenGeneration.label_Wholes}" id="label_Wholes"
                                                style="left: 24px; top: 48px; position: absolute; width: 142px" text="#{resources.num_whole}"/>
                                        </webuijsf:panelLayout>
                                    </webuijsf:tab>
                                </webuijsf:tabSet>
                            </webuijsf:panelLayout>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
