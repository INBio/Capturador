<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : EditSpecimen
    Created on : 04/08/2009, 10:46:32 AM
    Author     : esmata
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
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
                            <h:panelGrid id="gridpEditSpecimenMain" style="height: 24px; left: 24px; top: 24px; position: absolute" width="840">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msgEditSpecimen" infoClass="infoMessage"
                                    style="height: 24px; width: 574px" warnClass="warnMessage"/>
                                <h:panelGrid id="gridpTitleEdit" style="" styleClass="My_panel_title" width="840">
                                    <webuijsf:label binding="#{inventory$EditSpecimen.lbTitleEdit}" id="lbTitleEdit"
                                        style="height: 24px; text-align: center; width: 800px" styleClass="Page_title"/>
                                </h:panelGrid>
                                <webuijsf:panelGroup id="grouppBotonera" style="height: 24px; width: 840px">
                                    <h:commandButton action="#{inventory$EditSpecimen.btnSaveEdit_action}" id="btnSveEdit" style="height: 24px; width: 160px"
                                        styleClass="My_Button" value="#{resources.btnSave}"/>
                                </webuijsf:panelGroup>
                                <h:panelGrid columns="4" id="gridpEditSpecimen1" styleClass="My_panel_blue" width="840">
                                    <webuijsf:label for="txCatalogNumber" id="lbCatalogNumber" text="#{resources.catalognumber}"/>
                                    <webuijsf:textField binding="#{inventory$EditSpecimen.txCatalogNumber}" columns="25" disabled="true" id="txCatalogNumber"/>
                                    <webuijsf:label for="txInstitution" id="lbInstitution" text="#{resources.institution}"/>
                                    <webuijsf:textField binding="#{inventory$EditSpecimen.txInstitution}" columns="25" disabled="true" id="txInstitution"/>
                                    <webuijsf:label for="txCollection" id="lbCollection" text="#{resources.collection}"/>
                                    <webuijsf:textField binding="#{inventory$EditSpecimen.txCollection}" columns="25" disabled="true" id="txCollection"/>
                                    <webuijsf:label for="txGatheringId" id="lbGatheringId" text="#{resources.gath_obs_number}"/>
                                    <webuijsf:textField binding="#{inventory$EditSpecimen.txGatheringId}" columns="25" disabled="true" id="txGatheringId"/>
                                    <webuijsf:label for="ddCategory" id="lbCategory" text="#{resources.category}"/>
                                    <webuijsf:dropDown actionExpression="#{inventory$EditSpecimen.validateCategoryByStageAndSex}"
                                        binding="#{inventory$EditSpecimen.ddCategory}" id="ddCategory"
                                        items="#{inventory$EditSpecimen.specimenCategoryData.options}"
                                        selected="#{inventory$SpecimenSessionBean.currentSpecimenDTO.categoryId}" submitForm="true" width="186px"/>
                                    <webuijsf:label for="ddExtraction" id="lbExtraction" text="#{resources.extraction_method}"/>
                                    <webuijsf:dropDown binding="#{inventory$EditSpecimen.ddExtraction}" id="ddExtraction"
                                        items="#{inventory$EditSpecimen.stractionTypeData.options}"
                                        selected="#{inventory$SpecimenSessionBean.currentSpecimenDTO.extractionTypeId}" width="186px"/>
                                    <webuijsf:label for="ddType" id="lbType" text="#{resources.type}"/>
                                    <webuijsf:dropDown binding="#{inventory$EditSpecimen.ddType}" id="ddType"
                                        items="#{inventory$EditSpecimen.specimenTypeData.options}"
                                        selected="#{inventory$SpecimenSessionBean.currentSpecimenDTO.typeId}" width="186px"/>
                                    <webuijsf:label for="ddOrigin" id="lbOrigin" text="#{resources.origin}"/>
                                    <webuijsf:dropDown binding="#{inventory$EditSpecimen.ddOrigin}" id="ddOrigin"
                                        items="#{inventory$EditSpecimen.originData.options}"
                                        selected="#{inventory$SpecimenSessionBean.currentSpecimenDTO.originId}" width="186px"/>
                                    <webuijsf:label for="ddGatheringMethod" id="lbGatheringMethod" text="#{resources.gath_obs_method}"/>
                                    <webuijsf:dropDown binding="#{inventory$EditSpecimen.ddGatheringMethod}" id="ddGatheringMethod"
                                        items="#{inventory$EditSpecimen.gatheringObservationData.options}"
                                        selected="#{inventory$SpecimenSessionBean.currentSpecimenDTO.gatheringMethodId}" width="186px"/>
                                    <webuijsf:label for="ddPreservationMedium" id="lbPreservationMedium" text="#{resources.preservation_medium}"/>
                                    <webuijsf:dropDown binding="#{inventory$EditSpecimen.ddPreservationMedium}" id="ddPreservationMedium"
                                        items="#{inventory$EditSpecimen.preservationMediumData.options}"
                                        selected="#{inventory$SpecimenSessionBean.currentSpecimenDTO.preservationMediumId}" width="186px"/>
                                    <webuijsf:label for="ddSubstrate" id="lbSubstrate" text="#{resources.substrate}"/>
                                    <webuijsf:dropDown binding="#{inventory$EditSpecimen.ddSubstrate}" id="ddSubstrate"
                                        items="#{inventory$EditSpecimen.substrateData.options}"
                                        selected="#{inventory$SpecimenSessionBean.currentSpecimenDTO.substrateId}" width="186px"/>
                                    <webuijsf:label for="ddStorage" id="lbStorage" text="#{resources.storage}"/>
                                    <webuijsf:dropDown binding="#{inventory$EditSpecimen.ddStorage}" id="ddStorage"
                                        items="#{inventory$EditSpecimen.storageTypeData.options}"
                                        selected="#{inventory$SpecimenSessionBean.currentSpecimenDTO.storageTypeId}" width="186px"/>
                                    <webuijsf:label for="txWhole" id="lbWhole" text="#{resources.num_whole}"/>
                                    <webuijsf:textField binding="#{inventory$EditSpecimen.txWhole}" columns="25" id="txWhole" text="#{inventory$SpecimenSessionBean.currentSpecimenDTO.numberWhole}">
                                        <f:validateLongRange maximum="2147483647" minimum="0"/>
                                    </webuijsf:textField>
                                    <webuijsf:label for="txFragments" id="lbFragments" text="#{resources.num_fragments}"/>
                                    <webuijsf:textField binding="#{inventory$EditSpecimen.txFragments}" columns="25" id="txFragments" text="#{inventory$SpecimenSessionBean.currentSpecimenDTO.numberFragments}">
                                        <f:validateLongRange maximum="2147483647" minimum="0"/>
                                    </webuijsf:textField>
                                    <webuijsf:label id="lbDiscarded" text="#{resources.discarded}"/>
                                    <webuijsf:radioButtonGroup binding="#{inventory$EditSpecimen.rbDiscarded}" columns="2" id="rbDiscarded"
                                        selected="#{inventory$SpecimenSessionBean.currentSpecimenDTO.discarded}" style="width: 189px"/>
                                </h:panelGrid>
                                <h:panelGrid id="gridpEditSpecimen2" style="" width="840">
                                    <webuijsf:tabSet id="tabSetEditSpecimen" mini="true" selected="tabLifeStageSex" style="width: 833px" styleClass="My_tab_border">
                                        <webuijsf:tab id="tabLifeStageSex" text="#{resources.lf_sex}">
                                            <h:panelGrid columns="6" id="gridpLifeStageSex" style="" width="825">
                                                <webuijsf:label for="ddEstadio" id="lbEstadio" style="height: 22px; width: 120px" text="#{resources.stage}"/>
                                                <webuijsf:dropDown binding="#{inventory$EditSpecimen.ddStage}" id="ddEstadio"
                                                    items="#{inventory$EditSpecimen.lifeStageData.options}"
                                                    selected="#{inventory$EditSpecimen.invalidValueStage}" style="height: 24px" width="189px"/>
                                                <webuijsf:label for="ddSex" id="lbSex" text="#{resources.sex}"/>
                                                <webuijsf:dropDown binding="#{inventory$EditSpecimen.ddSex}" id="ddSex"
                                                    items="#{inventory$EditSpecimen.sexData.options}" selected="#{inventory$EditSpecimen.invalidValueSex}" width="189px"/>
                                                <webuijsf:label for="txCantidad" id="lbCantidad" text="#{resources.quantity}"/>
                                                <webuijsf:textField binding="#{inventory$EditSpecimen.txQuantity}" columns="25" id="txCantidad">
                                                    <f:validateLongRange maximum="2147483647" minimum="0"/>
                                                </webuijsf:textField>
                                                <h:commandButton action="#{inventory$EditSpecimen.btnAddStageSex_action}" id="btnAddStageSex"
                                                    styleClass="My_Button_dark" value="#{resources.btnNew}"/>
                                                <h:commandButton action="#{inventory$EditSpecimen.btnDeleteStageSex_action}" id="btnDeleteStageSex"
                                                    styleClass="My_Button_dark" value="#{resources.btnDelete}"/>
                                            </h:panelGrid>
                                            <h:panelGrid columns="1" id="gridpLifeStageSexTable" style="height: 20px" width="600">
                                                <h:dataTable binding="#{inventory$EditSpecimen.dataTableSexStage}" cellspacing="0" columnClasses="list-columns"
                                                    headerClass="list-header" id="dataTableSexStage" rowClasses="list-row-even,list-row-odd" rows="10"
                                                    style="border-top: solid rgb(214, 218, 221) 2px; border-bottom: solid rgb(214, 218, 221) 2px; border-left: solid rgb(214, 218, 221) 2px;"
                                                    value="#{inventory$SpecimenSessionBean.currentSpecimenDTO.lifeStageSexList}" var="currentRow" width="600">
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
                                    </webuijsf:tabSet>
                                </h:panelGrid>
                                <jsp:directive.include file="/Footer.jspf"/>
                            </h:panelGrid>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
