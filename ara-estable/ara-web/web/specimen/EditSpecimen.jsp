<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page>
            <webuijsf:html>
                <webuijsf:head>
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
					<webuijsf:panelLayout id="contenido">
                    <webuijsf:form id="form1">
                        <webuijsf:staticText  id="staticText1"
                            style="font-family: 'Arial','Helvetica',sans-serif; font-size: 24px; font-style: normal; left: 24px; top: 24px; position: absolute; width: 238px" text="#{resources.edit_specimen}"/>
                        <webuijsf:panelLayout id="layoutPanel1" style="height: 214px; left: 24px; top: 72px; position: absolute; width: 910px; -rave-layout: grid">
                            <webuijsf:label id="gathSeqLabel" requiredIndicator="true"
                                style="height: 23px; left: 24px; top: 24px; position: absolute; width: 165px" text="#{resources.gath_obs_number}"/>
                            <webuijsf:textField binding="#{specimen$EditSpecimen.gathSeqInput}" columns="18" id="gathSeqInput"
                                style="left: 216px; top: 24px; position: absolute; width: 70px" validatorExpression="#{specimen$EditSpecimen.longRangeValidator2.validate}"/>
                            <webuijsf:label id="barCodeLabel" requiredIndicator="true"
                                style="height: 22px; left: 24px; top: 0px; position: absolute; width: 165px" text="#{resources.id}"/>
                            <webuijsf:textField binding="#{specimen$EditSpecimen.barCodeInput}" columns="18" disabled="true" id="barCodeInput"
                                style="left: 216px; top: 0px; position: absolute; width: 70px" validatorExpression="#{specimen$EditSpecimen.longRangeValidator1.validate}"/>
                            <webuijsf:label id="categoryLabel" requiredIndicator="true"
                                style="height: 23px; left: 24px; top: 96px; position: absolute; width: 165px" text="#{resources.category}"/>
                            <webuijsf:dropDown binding="#{specimen$EditSpecimen.categoryDD}" id="categoryDD"
                                items="#{specimen$EditSpecimen.categoryDDDefaultOptions.options}"
                                style="left: 216px; top: 96px; position: absolute; width: 118px" width="118"/>
                            <webuijsf:label id="collectionLabel" requiredIndicator="true"
                                style="height: 22px; left: 24px; top: 48px; position: absolute; width: 165px" text="#{resources.collection}"/>
                            <webuijsf:dropDown binding="#{specimen$EditSpecimen.collectionDD}" disabled="true" id="collectionDD"
                                items="#{specimen$EditSpecimen.collectionDDDefaultOptions.options}"
                                style="left: 216px; top: 48px; position: absolute; width: 118px" width="118"/>
                            <webuijsf:label  for="extractionDD" id="extractionLabel"
                                style="left: 24px; top: 72px; position: absolute; width: 165px" text="#{resources.extraction_method}"/>
                            <webuijsf:dropDown binding="#{specimen$EditSpecimen.extractionDD}" id="extractionDD"
                                items="#{specimen$EditSpecimen.extractionDDDefaultOptions.options}"
                                style="left: 216px; top: 72px; position: absolute; width: 118px" width="118"/>
                            <webuijsf:label for="gathObsMethodDD" id="gathObsMethodLabel"
                                style="left: 24px; top: 144px; position: absolute; width: 165px" text="#{resources.gath_obs_method}"/>
                            <webuijsf:dropDown binding="#{specimen$EditSpecimen.gathObsMethodDD}" id="gathObsMethodDD"
                                items="#{specimen$EditSpecimen.gathObsMethodDDDefaultOptions.options}"
                                style="left: 216px; top: 144px; position: absolute; width: 118px" width="118"/>
                            <webuijsf:label for="typeDD" id="typeLabel"
                                style="left: 24px; top: 120px; position: absolute; width: 165px" text="#{resources.type}"/>
                            <webuijsf:dropDown binding="#{specimen$EditSpecimenSessionBean.typeDD}" id="typeDD"
                                items="#{specimen$EditSpecimenSessionBean.typeDDDefaultOptions.options}"
                                style="left: 216px; top: 120px; position: absolute; width: 118px" width="118"/>
                            <webuijsf:label  for="originDD" id="originLabel"
                                style="left: 504px; top: 96px; position: absolute; width: 141px" text="#{resources.origin}"/>
                            <webuijsf:dropDown binding="#{specimen$EditSpecimen.originDD}" id="originDD"
                                items="#{specimen$EditSpecimen.originDDDefaultOptions.options}" separators="false"
                                style="left: 672px; top: 96px; position: absolute; width: 118px" width="118"/>
                            <webuijsf:label  for="preservationDD" id="preservationLabel"
                                style="left: 504px; top: 144px; position: absolute; width: 141px" text="#{resources.preservation_medium}"/>
                            <webuijsf:dropDown binding="#{specimen$EditSpecimen.preservationDD}" id="preservationDD"
                                items="#{specimen$EditSpecimen.preservationDDDefaultOptions.options}"
                                style="left: 672px; top: 144px; position: absolute; width: 118px" width="118"/>
                            <webuijsf:label  for="substrateDD" id="substrateLabel"
                                style="left: 504px; top: 120px; position: absolute; width: 141px" text="#{resources.substrate}"/>
                            <webuijsf:dropDown binding="#{specimen$EditSpecimen.substrateDD}" id="substrateDD"
                                items="#{specimen$EditSpecimen.substrateDDDefaultOptions.options}"
                                style="left: 672px; top: 120px; position: absolute; width: 118px" width="118"/>
                            <webuijsf:label for="storageDD" id="storageLabel"
                                style="left: 504px; top: 72px; position: absolute; width: 141px" text="#{resources.storage}"/>
                            <webuijsf:dropDown binding="#{specimen$EditSpecimen.storageDD}" id="storageDD"
                                items="#{specimen$EditSpecimen.storageDDDefaultOptions.options}"
                                style="left: 672px; top: 72px; position: absolute; width: 118px" width="118"/>
                            <webuijsf:label  id="discardedLabel" requiredIndicator="true"
                                style="height: 23px; left: 504px; top: 168px; position: absolute; width: 141px" text="#{resources.discarded}"/>
                            <webuijsf:radioButtonGroup binding="#{specimen$EditSpecimen.discardedRadioButton}" columns="2" id="discardedRadioButton"
                                items="#{specimen$EditSpecimen.discardedRadioButtonDefaultOptions.options}"
                                selected="#{specimen$EditSpecimen.discardedRadioButtonDefaultOptions.selectedValue}" style="height: 47px; left: 672px; top: 168px; position: absolute; width: 167px"/>
                            <webuijsf:label for="numWholeInput" id="numWholeLabel"
                                style="left: 504px; top: 0px; position: absolute; width: 141px" text="#{resources.num_whole}"/>
                            <webuijsf:textField binding="#{specimen$EditSpecimen.numWholeInput}" columns="18" id="numWholeInput"
                                style="left: 672px; top: 0px; position: absolute; width: 70px" validatorExpression="#{specimen$EditSpecimen.longRangeValidator3.validate}"/>
                            <webuijsf:label for="numFragmentsInput" id="numFragmentsLabel"
                                style="left: 504px; top: 48px; position: absolute; width: 141px" text="#{resources.num_fragments}"/>
                            <webuijsf:textField binding="#{specimen$EditSpecimen.numFragmentsInput}" columns="18" id="numFragmentsInput"
                                style="left: 672px; top: 48px; position: absolute; width: 70px" validatorExpression="#{specimen$EditSpecimen.longRangeValidator4.validate}"/>
                        </webuijsf:panelLayout>
                        <h:messages  errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1"
                            infoClass="infoMessage" style="left: 288px; top: 24px; position: absolute" warnClass="warnMessage"/>
                        <webuijsf:button actionExpression="#{specimen$EditSpecimen.btn_save_action}"
                            id="btn_update" primary="true" style="height: 24px; left: 23px; top: 504px; position: absolute; width: 96px" text="#{resources.btnUpdate}"/>
                        <!--<webuijsf:button actionExpression="#{specimen$EditSpecimen.btn_cancel_action}"
                            id="btn_cancel" style="height: 24px; left: 143px; top: 504px; position: absolute; width: 72px" text="#{resources.btnBack}"/>-->
                        <webuijsf:tabSet id="tabSet1" selected="tab1"
                            style="height: 286px; left: 24px; top: 432px; position: absolute; width: 790px" visible="false">
                            <webuijsf:tab id="tab1" text="estadios y sexos">
                                <webuijsf:panelLayout id="layoutPanel2" style="height: 225px; position: relative; width: 765px; -rave-layout: grid">
                                    <webuijsf:table augmentTitle="false" binding="#{specimen$EditSpecimen.table1}" id="table1"
                                        style="position: absolute; left: 48px; top: 24px; height: 168px" title="estadios y sexos" width="360">
                                        <webuijsf:tableRowGroup binding="#{specimen$EditSpecimen.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                            sourceData="#{specimen$EditSpecimen.defaultTableDataProvider}" sourceVar="currentRow">
                                            <webuijsf:tableColumn  headerText="Estadios" id="tableColumn1" sort="column1">
                                                <webuijsf:staticText id="staticText2" text="#{currentRow.value['column1']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn  headerText="sexos" id="tableColumn2" sort="column2">
                                                <webuijsf:staticText id="staticText3" text="#{currentRow.value['column2']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn  headerText="quantity" id="tableColumn3" sort="column3">
                                                <webuijsf:staticText id="staticText4" text="#{currentRow.value['column3']}"/>
                                            </webuijsf:tableColumn>
                                        </webuijsf:tableRowGroup>
                                    </webuijsf:table>
                                </webuijsf:panelLayout>
                            </webuijsf:tab>
                        </webuijsf:tabSet>
                        <!-- Esta es la parte de estadíos y sexos -->
                        <webuijsf:panelLayout id="lyt_stadiumSex1" style="border-width: 1px; height: 142px; left: 24px; top: 336px; position: absolute; width: 910px; -rave-layout: grid">
                            <webuijsf:table id="t_stadiumSex1" paginateButton="true" paginationControls="true"
                                style="height: 47px; left: 504px; top: 24px; position: absolute" title="#{resources.selected}" width="552">
                                <webuijsf:tableRowGroup binding="#{specimen$EditSpecimen.tableRowGroup1}" id="tableRowGroup1" rows="4"
                                    sourceData="#{specimen$EditSpecimenSessionBean.lifeStageSexDTODataProvier}" sourceVar="currentRow">
                                        <!-- -->
                                    <webuijsf:tableColumn headerText="#{resources.life_stage}" id="tableColumn4" width="113">
                                        <webuijsf:staticText id="staticText5" text="#{currentRow.value['lifeStageName']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="#{resources.sex}" id="tableColumn5">
                                        <webuijsf:staticText id="staticText6" text="#{currentRow.value['sexName']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn headerText="#{resources.quantity}" id="tableColumn6" width="56">
                                        <webuijsf:staticText id="staticText7" text="#{currentRow.value['quantity']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn id="tableColumn7" width="17">
                                        <webuijsf:button actionExpression="#{specimen$EditSpecimen.btn_removeStadiumSex1_action}" id="btn_removeStadiumSex1"
                                            style="height: 23px; left: 95px;" text="#{resources.btnDelete}"/>
                                    </webuijsf:tableColumn>
                                    <!-- -->
                                </webuijsf:tableRowGroup>
                            </webuijsf:table>
                            <webuijsf:label id="label1" style="left: 24px; top: 24px; position: absolute" text="#{resources.life_stage}"/>
                            <webuijsf:dropDown id="dd_stadium1" items="#{specimen$EditSpecimenSessionBean.lifeStageOption}"
                                selected="#{specimen$EditSpecimenSessionBean.actualLifeStageSexDTO.lifeStageKey}" style="left: 192px; top: 24px; position: absolute" width="118"/>
                            <webuijsf:label id="label2" style="left: 24px; top: 48px; position: absolute" text="#{resources.sex}"/>
                            <webuijsf:dropDown id="dd_sex1" items="#{specimen$EditSpecimenSessionBean.sexOption}"
                                selected="#{specimen$EditSpecimenSessionBean.actualLifeStageSexDTO.sexKey}" style="left: 192px; top: 48px; position: absolute" width="118"/>
                            <webuijsf:label id="label3" style="left: 24px; top: 72px; position: absolute" text="#{resources.quantity}"/>
                            <webuijsf:textField text="#{specimen$EditSpecimenSessionBean.actualLifeStageSexDTO.quantity}" columns="19" id="txt_ssQuantity" maxLength="4" style="left: 192px; top: 72px; position: absolute; width: 100px"/>
                            <webuijsf:button actionExpression="#{specimen$EditSpecimen.btn_addStadiumSex1_action}" id="btn_addStadiumSex1"
                                style="height: 23px; left: 191px; top: 96px; position: absolute; width: 60px" text="#{resources.btnNew}"/>
                            <webuijsf:staticText id="staticText8"
                                style="font-family: 'Arial','Helvetica',sans-serif; font-size: 14px; font-weight: bold; left: 0px; top: -24px; position: absolute" text="#{resources.lf_sex}"/>
                        </webuijsf:panelLayout>
                    </webuijsf:form>
                    </webuijsf:panelLayout>
					<jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
