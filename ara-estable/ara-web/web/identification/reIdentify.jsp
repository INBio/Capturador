<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{identification$reIdentify.page1}" id="page1">
            <webuijsf:html binding="#{identification$reIdentify.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{identification$reIdentify.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{identification$reIdentify.form1}" id="form1">
                            <webuijsf:label binding="#{identification$reIdentify.label1}" id="label1"
                                style="font-size: 24px; height: 22px; left: 48px; top: 24px; position: absolute; width: 310px" text="#{resources.re_identify}"/>
                            <h:messages binding="#{identification$reIdentify.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage"
                                id="messageList1" infoClass="infoMessage" style="left: 384px; top: 24px; position: absolute" warnClass="warnMessage"/>
                            <webuijsf:textField binding="#{identification$reIdentify.txt_specimenId}" columns="25" id="txt_specimenId"
                                style="left: 48px; top: 96px; position: absolute; width: 120px" valueChangeListenerExpression="#{identification$reIdentify.txt_specimenId_processValueChange}"/>
                            <webuijsf:listbox binding="#{identification$reIdentify.lst_specimen}" converter="#{identification$reIdentify.longConverter1}"
                                id="lst_specimen" items="#{identification$IdentificationSessionBean.specimenList}" labelLevel="3" labelOnTop="true"
                                onChange="webuijsf.suntheme.common.timeoutSubmitForm(this.form, 'lst_specimen');"
                                selected="#{identification$IdentificationSessionBean.selectedSpecimenId}"
                                style="height: 192px; left: 48px; top: 168px; position: absolute; width: 150px" valueChangeListenerExpression="#{identification$reIdentify.lst_specimen_processValueChange}"/>
                            <webuijsf:tabSet binding="#{identification$reIdentify.tab_Identification}" id="tab_Identification" selected="tab_actualInformation" style="border: 1px solid gray; height: 454px; left: 264px; top: 144px; position: absolute; width: 718px">
                                <webuijsf:tab binding="#{identification$reIdentify.tab_actualInformation}" id="tab_actualInformation" text="Información actual de especímen seleccionado">
                                    <webuijsf:label binding="#{identification$reIdentify.label14}" id="label14"
                                        style="left: 24px; top: 48px; position: absolute" text="ID. Especimen"/>
                                    <webuijsf:staticText binding="#{identification$reIdentify.st_specimenId}" id="st_specimenId" style="left: 120px; top: 48px; position: absolute"/>
                                    <webuijsf:label binding="#{identification$reIdentify.label16}" id="label16"
                                        style="left: 24px; top: 72px; position: absolute" text="#{resources.category}"/>
                                    <webuijsf:staticText binding="#{identification$reIdentify.st_specimenCategory}" id="st_specimenCategory"
                                        style="color: rgb(0, 153, 51); font-family: 'Arial','Helvetica',sans-serif; font-weight: bold; left: 120px; top: 72px; position: absolute" text="#{identification$IdentificationSessionBean.currentSpecimenCategoryName}"/>
                                    <webuijsf:table binding="#{identification$reIdentify.table_actualIdentification1}" clearSortButton="true"
                                        id="table_actualIdentification1" paginateButton="true" paginationControls="true" sortPanelToggleButton="true"
                                        style="left: 24px; top: 168px; position: absolute" title="#{resources.current_identifications}" width="671">
                                        <webuijsf:tableRowGroup binding="#{identification$reIdentify.tableRowGroup2}" id="tableRowGroup2" rows="4"
                                            sourceData="#{identification$IdentificationSessionBean.identificationFilteredDataProvider}" sourceVar="currentRow">
                                            <webuijsf:tableColumn binding="#{identification$reIdentify.tableColumn6}" headerText="#{resources.taxon}"
                                                id="tableColumn6" sort="taxonName">
                                                <webuijsf:staticText binding="#{identification$reIdentify.staticText5}" id="staticText5" text="#{currentRow.value['taxonName']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn binding="#{identification$reIdentify.tableColumn7}" headerText="#{resources.sequence}"
                                                id="tableColumn7" sort="identificationSequence">
                                                <webuijsf:staticText binding="#{identification$reIdentify.staticText6}" id="staticText6" text="#{currentRow.value['identificationSequence']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn binding="#{identification$reIdentify.tableColumn8}"
                                                headerText="#{resources.identification_date}" id="tableColumn8" sort="identificationDate">
                                                <webuijsf:staticText binding="#{identification$reIdentify.staticText7}" id="staticText7" text="#{currentRow.value['identificationDate']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn binding="#{identification$reIdentify.tableColumn9}" headerText="#{resources.badge}"
                                                id="tableColumn9" sort="identifierPersonName">
                                                <webuijsf:staticText binding="#{identification$reIdentify.staticText8}" id="staticText8" text="#{currentRow.value['identifierPersonName']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn binding="#{identification$reIdentify.tableColumn10}" headerText="#{resources.status}"
                                                id="tableColumn10" sort="identificationStatusName">
                                                <webuijsf:staticText binding="#{identification$reIdentify.staticText9}" id="staticText9" text="#{currentRow.value['identificationStatusName']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn binding="#{identification$reIdentify.tableColumn11}" headerText="#{resources.type}"
                                                id="tableColumn11" sort="identificationTypeName">
                                                <webuijsf:staticText binding="#{identification$reIdentify.staticText10}" id="staticText10" text="#{currentRow.value['identificationTypeName']}"/>
                                            </webuijsf:tableColumn>
                                        </webuijsf:tableRowGroup>
                                    </webuijsf:table>
                                    <webuijsf:staticText binding="#{identification$reIdentify.st_gatheringObservation}" id="st_gatheringObservation" style="height: 46px; left: 120px; top: 96px; position: absolute; width: 573px"/>
                                    <webuijsf:label binding="#{identification$reIdentify.label15}" id="label15"
                                        style="left: 24px; top: 96px; position: absolute" text="#{resources.recolection}"/>
                                    <webuijsf:table binding="#{identification$reIdentify.t_stadiumSex2}" id="t_stadiumSex2" paginateButton="true"
                                        paginationControls="true" style="height: 42px; left: 24px; top: 312px; position: absolute; width: 671px"
                                        title="#{resouces.current_sex_and_stages}" width="671">
                                        <webuijsf:tableRowGroup binding="#{identification$reIdentify.tableRowGroup3}" id="tableRowGroup3" rows="4"
                                            sourceData="#{identification$IdentificationSessionBean.lifeStageSexFilteredDataProvider}" sourceVar="currentRow">
                                            <webuijsf:tableColumn binding="#{identification$reIdentify.tableColumn12}" headerText="#{resources.stage}"
                                                id="tableColumn12" width="113">
                                                <webuijsf:staticText binding="#{identification$reIdentify.staticText11}" id="staticText11" text="#{currentRow.value['lifeStageName']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn binding="#{identification$reIdentify.tableColumn13}" headerText="#{resources.sex}" id="tableColumn13">
                                                <webuijsf:staticText binding="#{identification$reIdentify.staticText12}" id="staticText12" text="#{currentRow.value['sexName']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn binding="#{identification$reIdentify.tableColumn14}" headerText="#{resources.quantity}"
                                                id="tableColumn14" width="56">
                                                <webuijsf:staticText binding="#{identification$reIdentify.staticText13}" id="staticText13" text="#{currentRow.value['quantity']}"/>
                                            </webuijsf:tableColumn>
                                        </webuijsf:tableRowGroup>
                                    </webuijsf:table>
                                </webuijsf:tab>
                                <webuijsf:tab binding="#{identification$reIdentify.tab_reIdentify}" id="tab_reIdentify" text="#{resources.information_to_asign}">
                                    <webuijsf:tab binding="#{identification$reIdentify.tab_identification}" id="tab_identification" text="#{resources.taxonomic_identification}">
                                        <webuijsf:panelLayout binding="#{identification$reIdentify.layoutPanel2}" id="layoutPanel2" style="height: 3px; position: relative; width: 100%; -rave-layout: grid">
                                            <webuijsf:dropDown binding="#{identification$reIdentify.dd_identificationType1}" id="dd_identificationType1"
                                                items="#{identification$IdentificationSessionBean.identificationTypeOption}"
                                                selected="#{identification$IdentificationSessionBean.selectedIdentificationType}"
                                                style="left: 504px; top: 72px; position: absolute" valueChangeListenerExpression="#{identification$reIdentify.dd_identificationType1_processValueChange}"/>
                                            <webuijsf:dropDown binding="#{identification$reIdentify.dd_taxonomicalCategory1}" id="dd_taxonomicalCategory1"
                                                items="#{identification$IdentificationSessionBean.taxonCategoryOption}"
                                                onChange="webui.suntheme.common.timeoutSubmitForm(this.form, 'tab_Identification:tab_reIdentify:tab_identification:layoutPanel2:dd_taxonomicalCategory1');"
                                                selected="#{identification$IdentificationSessionBean.selectedTaxonCategory}"
                                                style="left: 504px; top: 96px; position: absolute" valueChangeListenerExpression="#{identification$reIdentify.dd_taxonomicalCategory1_processValueChange}"/>
                                            <webuijsf:label binding="#{identification$reIdentify.label5}" id="label5"
                                                style="left: 384px; top: 96px; position: absolute" text="#{resources.category}"/>
                                            <webuijsf:dropDown binding="#{identification$reIdentify.dd_validator1}" id="dd_validator1"
                                                items="#{identification$IdentificationSessionBean.identificationValidatorOption}"
                                                selected="#{identification$IdentificationSessionBean.selectedIdentificationValidator}"
                                                style="left: 504px; top: 24px; position: absolute" valueChangeListenerExpression="#{identification$reIdentify.dd_validator1_processValueChange}"/>
                                            <webuijsf:label binding="#{identification$reIdentify.label6}" id="label6"
                                                style="left: 384px; top: 72px; position: absolute" text="#{resources.identification_type}"/>
                                            <webuijsf:label binding="#{identification$reIdentify.label7}" id="label7"
                                                style="left: 24px; top: 144px; position: absolute" text="#{resources.taxons}"/>
                                            <webuijsf:calendar binding="#{identification$reIdentify.cal_identificationDate1}" dateFormatPattern="dd/MM/yyyy"
                                                dateFormatPatternHelp="dd/MM/yyyy" id="cal_identificationDate1" maxDate="#{ApplicationBean1.todayDate}"
                                                minDate="#{ApplicationBean1.minDate}"
                                                selectedDate="#{identification$IdentificationSessionBean.identificationDate}"
                                                style="left: 168px; top: 24px; position: absolute" valueChangeListenerExpression="#{identification$reIdentify.cal_identificationDate1_processValueChange}"/>
                                            <webuijsf:label binding="#{identification$reIdentify.label8}" id="label8"
                                                style="left: 384px; top: 24px; position: absolute" text="#{resources.validator}"/>
                                            <webuijsf:dropDown binding="#{identification$reIdentify.dd_identificationStatus1}" id="dd_identificationStatus1"
                                                items="#{identification$IdentificationSessionBean.identificationStatusOption}"
                                                selected="#{identification$IdentificationSessionBean.selectedIdentificationStatus}"
                                                style="left: 168px; top: 72px; position: absolute" valueChangeListenerExpression="#{identification$reIdentify.dd_identificationStatus1_processValueChange}"/>
                                            <webuijsf:addRemove availableItemsLabel="#{resources.availables}:"
                                                binding="#{identification$reIdentify.ad_taxonList1}" id="ad_taxonList1"
                                                items="#{identification$IdentificationSessionBean.taxonList}" rows="10"
                                                selected="#{identification$IdentificationSessionBean.selectedTaxon}" selectedItemsLabel="#{resources.selected}:" style="height: 190px; left: 24px; top: 168px; position: absolute"/>
                                            <webuijsf:label binding="#{identification$reIdentify.label9}" id="label9"
                                                style="left: 24px; top: 24px; position: absolute" text="#{resources.identification_date}"/>
                                            <webuijsf:label binding="#{identification$reIdentify.label10}" id="label10"
                                                style="left: 24px; top: 72px; position: absolute" text="#{resources.status}"/>
                                            <webuijsf:label binding="#{identification$reIdentify.label11}" id="label11"
                                                style="left: 24px; top: 96px; position: absolute" text="#{resources.taxonomic_level}"/>
                                            <webuijsf:dropDown binding="#{identification$reIdentify.dd_taxonomicalRange1}" id="dd_taxonomicalRange1"
                                                items="#{identification$IdentificationSessionBean.taxonomicalRangeOption}"
                                                onChange="webui.suntheme.common.timeoutSubmitForm(this.form, 'tab_Identification:tab_reIdentify:tab_identification:layoutPanel2:dd_taxonomicalRange1');"
                                                selected="#{identification$IdentificationSessionBean.selectedTaxonomicalRange}"
                                                style="left: 168px; top: 96px; position: absolute" valueChangeListenerExpression="#{identification$reIdentify.dd_taxonomicalRange1_processValueChange}"/>
                                            <webuijsf:label binding="#{identification$reIdentify.label17}" id="label17"
                                                style="left: 24px; top: 120px; position: absolute" text="#{resources.type}"/>
                                            <webuijsf:label binding="#{identification$reIdentify.label18}" id="label18"
                                                style="left: 384px; top: 120px; position: absolute" text="#{resources.deposited}"/>
                                            <webuijsf:dropDown binding="#{identification$reIdentify.dd_typeSpecimenType}" id="dd_typeSpecimenType"
                                                items="#{identification$IdentificationSessionBean.typeSpecimenTypeOption}"
                                                selected="#{identification$IdentificationSessionBean.selectedTypeSpecimenTypeOption}" style="left: 168px; top: 120px; position: absolute"/>
                                            <webuijsf:dropDown binding="#{identification$reIdentify.dd_institution}" id="dd_institution"
                                                items="#{identification$IdentificationSessionBean.institutionOption}"
                                                selected="#{identification$IdentificationSessionBean.selectedInstitution}" style="left: 504px; top: 120px; position: absolute"/>
                                        </webuijsf:panelLayout>
                                    </webuijsf:tab>
                                    <webuijsf:tab binding="#{identification$reIdentify.tab_identifier}" id="tab_identifier" text="#{resources.identifiers}">
                                        <webuijsf:panelLayout binding="#{identification$reIdentify.layoutPanel3}" id="layoutPanel3" style="height: 3px; position: relative; width: 100%; -rave-layout: grid">
                                            <webuijsf:addRemove availableItemsLabel="#{resources.availables}:"
                                                binding="#{identification$reIdentify.ar_identifier1}" id="ar_identifier1"
                                                items="#{identification$IdentificationSessionBean.identifierOption}"
                                                selected="#{identification$IdentificationSessionBean.selectedIdentifier}"
                                                selectedItemsLabel="#{resources.selected}:" style="left: 24px; top: 48px; position: absolute"/>
                                        </webuijsf:panelLayout>
                                    </webuijsf:tab>
                                    <webuijsf:tab binding="#{identification$reIdentify.tab_lifeStageSex}" id="tab_lifeStageSex" text="#{resources.sex_and_stages}">
                                        <webuijsf:panelLayout binding="#{identification$reIdentify.layoutPanel1}" id="layoutPanel1" style="height: 3px; position: relative; width: 100%; -rave-layout: grid">
                                            <webuijsf:table binding="#{identification$reIdentify.t_stadiumSex1}" id="t_stadiumSex1" paginateButton="true"
                                                paginationControls="true" style="height: 42px; left: 312px; top: 96px; position: absolute; width: 384px"
                                                title="#{resouces.selected}" width="384">
                                                <webuijsf:tableRowGroup binding="#{identification$reIdentify.tableRowGroup1}" id="tableRowGroup1" rows="8"
                                                    sourceData="#{identification$IdentificationSessionBean.lifeStageSexSimpleDataProvider}" sourceVar="currentRow">
                                                    <webuijsf:tableColumn binding="#{identification$reIdentify.tableColumn1}" headerText="#{resources.stage}"
                                                        id="tableColumn1" width="113">
                                                        <webuijsf:staticText binding="#{identification$reIdentify.staticText1}" id="staticText1" text="#{currentRow.value['lifeStageName']}"/>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn binding="#{identification$reIdentify.tableColumn2}" headerText="#{resources.sex}" id="tableColumn2">
                                                        <webuijsf:staticText binding="#{identification$reIdentify.staticText2}" id="staticText2" text="#{currentRow.value['sexName']}"/>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn binding="#{identification$reIdentify.tableColumn3}" headerText="#{resources.quantity}"
                                                        id="tableColumn3" width="56">
                                                        <webuijsf:staticText binding="#{identification$reIdentify.staticText3}" id="staticText3" text="#{currentRow.value['quantity']}"/>
                                                    </webuijsf:tableColumn>
                                                    <webuijsf:tableColumn binding="#{identification$reIdentify.tableColumn4}" id="tableColumn4" width="17">
                                                        <webuijsf:button actionExpression="#{identification$reIdentify.btn_removeStadiumSex1_action}"
                                                            binding="#{identification$reIdentify.btn_removeStadiumSex1}" id="btn_removeStadiumSex1"
                                                            style="height: 23px; left: 95px;" text="#{resources.btnDelete}"/>
                                                    </webuijsf:tableColumn>
                                                </webuijsf:tableRowGroup>
                                            </webuijsf:table>
                                            <webuijsf:dropDown binding="#{identification$reIdentify.dd_stadium1}" id="dd_stadium1"
                                                items="#{identification$IdentificationSessionBean.lifeStageOption}"
                                                selected="#{identification$IdentificationSessionBean.selectedLifeStage}"
                                                style="left: 96px; top: 96px; position: absolute" valueChangeListenerExpression="#{identification$reIdentify.dd_stadium1_processValueChange}"/>
                                            <webuijsf:dropDown binding="#{identification$reIdentify.dd_sex1}" id="dd_sex1"
                                                items="#{identification$IdentificationSessionBean.sexOption}"
                                                selected="#{identification$IdentificationSessionBean.selectedSex}"
                                                style="left: 96px; top: 120px; position: absolute" valueChangeListenerExpression="#{identification$reIdentify.dd_sex1_processValueChange}"/>
                                            <webuijsf:label binding="#{identification$reIdentify.label2}" id="label2"
                                                style="left: 24px; top: 144px; position: absolute" text="#{resources.quantity}"/>
                                            <webuijsf:label binding="#{identification$reIdentify.label3}" id="label3"
                                                style="left: 24px; top: 96px; position: absolute" text="#{resources.stage}"/>
                                            <webuijsf:label binding="#{identification$reIdentify.label4}" id="label4"
                                                style="left: 24px; top: 120px; position: absolute" text="#{resources.sex}"/>
                                            <webuijsf:button actionExpression="#{identification$reIdentify.btn_addStadiumSex1_action}"
                                                binding="#{identification$reIdentify.btn_addStadiumSex1}" id="btn_addStadiumSex1"
                                                style="height: 23px; left: 23px; top: 192px; position: absolute; width: 72px" text="#{resources.btnNew}"/>
                                            <webuijsf:textField binding="#{identification$reIdentify.txt_ssQuantity1}" columns="4" id="txt_ssQuantity1"
                                                maxLength="4" style="left: 96px; top: 144px; position: absolute; width: 47px" valueChangeListenerExpression="#{identification$reIdentify.txt_ssQuantity1_processValueChange}"/>
                                        </webuijsf:panelLayout>
                                    </webuijsf:tab>
                                </webuijsf:tab>
                            </webuijsf:tabSet>
                            <webuijsf:label binding="#{identification$reIdentify.label12}" id="label12" style="left: 48px; top: 72px; position: absolute" text="#{resources.specimen_id}"/>
                            <webuijsf:button actionExpression="#{identification$reIdentify.btn_taxonomySearch_action}"
                                binding="#{identification$reIdentify.btn_taxonomySearch}" disabled="true" id="btn_taxonomySearch"
                                style="height: 24px; left: 47px; top: 600px; position: absolute; width: 72px" text="#{resources.btnSearch}" visible="false"/>
                            <webuijsf:label binding="#{identification$reIdentify.label13}" id="label13" style="left: 24px; top: 480px; position: absolute"
                                text="#{resources.search_specimens_by}" visible="false"/>
                            <webuijsf:radioButtonGroup binding="#{identification$reIdentify.radioButtonGroup1}" id="radioButtonGroup1"
                                items="#{identification$reIdentify.radioButtonGroup1DefaultOptions.options}"
                                style="left: 24px; top: 456px; position: absolute; width: 168px" visible="false"/>
                            <webuijsf:checkbox binding="#{identification$reIdentify.chck_dataEntryError}" id="chck_dataEntryError"
                                label="#{resources.mark_identifications}" selectedValue="y" style="left: 264px; top: 72px; position: absolute"/>
                            <webuijsf:button actionExpression="#{identification$reIdentify.btn_reIdentify_action}"
                                binding="#{identification$reIdentify.btn_reIdentify}" id="btn_reIdentify"
                                style="height: 24px; left: 263px; top: 96px; position: absolute; width: 96px" text="#{resources.re_identify}"/>
                            <webuijsf:button actionExpression="#{identification$reIdentify.btn_add_action}" binding="#{identification$reIdentify.btn_add}"
                                id="btn_add" style="left: 47px; top: 144px; position: absolute; width: 72px" text="#{resources.btnAdd}"/>
                            <webuijsf:button actionExpression="#{identification$reIdentify.btn_remove_action}" binding="#{identification$reIdentify.btn_remove}"
                                id="btn_remove" style="height: 24px; left: 47px; top: 408px; position: absolute; width: 120px" text="#{resources.btnDelete}"/>
                            <webuijsf:button actionExpression="#{identification$reIdentify.btn_clean_action}" binding="#{identification$reIdentify.btn_clean}"
                                id="btn_clean" style="height: 24px; left: 47px; top: 456px; position: absolute; width: 120px" text="#{resources.btnClean}"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <!--<jsp:directive.include file="/footer.jspf"/>-->
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
