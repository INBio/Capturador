<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : NewNomenclaturalGroup
    Created on : 23/11/2009, 04:32:47 PM
    Author     : esmata
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <webuijsf:label id="lbTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px" styleClass="Page_title" text="#{resources.titleNomenclaturalGroupNew}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 50px; width: 840px" warnClass="warnMessage"/>
                                <!-- Botonera -->
                                <webuijsf:panelGroup id="grouppBotonera" style="height: 24px; width: 840px">
                                    <h:commandButton action="#{taxonomy$NewNomenclaturalGroup.btnNewNomenclaturalGroup_action}" id="btnNewNomenclaturalGroup"
                                        style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.btnSave}"/>
                                </webuijsf:panelGroup>
                                <!-- Panel de detalles del sitios -->
                                <webuijsf:panelLayout id="PanelDetails" style="height: 192px; position: relative; width: 840px; -rave-layout: grid" styleClass="My_subpanel_blue">
                                    <webuijsf:label for="txName" id="lbName" style="height: 24px; left: 48px; top: 24px; position: absolute; width: 146px" text="#{resources.name}"/>
                                    <webuijsf:label for="txaDescription" id="lbDescription"
                                        style="height: 24px; left: 48px; top: 48px; position: absolute; width: 146px" text="#{resources.description}"/>
                                    <webuijsf:label id="lbNotes" style="height: 24px; left: 48px; top: 101px; position: absolute; width: 146px" text="#{resources.notes}"/>
                                    <webuijsf:label for="ddCollection" id="lbCollection"
                                        style="height: 24px; left: 48px; top: 154px; position: absolute; width: 146px" text="#{resources.colection}"/>
                                    <webuijsf:label for="ddCommonName" id="lbCommonName"
                                        style="height: 24px; left: 456px; top: 24px; position: absolute; width: 140px" text="#{resources.common_name}"/>
                                    <webuijsf:label for="ddCertifier" id="lbCertifier"
                                        style="height: 24px; left: 456px; top: 48px; position: absolute; width: 140px" text="#{resources.certifier}"/>
                                    <webuijsf:label for="txTemporality" id="lbTemporality"
                                        style="height: 24px; left: 456px; top: 72px; position: absolute; width: 140px" text="#{resources.temporal}"/>
                                    <webuijsf:textField binding="#{taxonomy$NewNomenclaturalGroup.txName}" columns="26" id="txName" required="true"
                                        style="height: 24px; left: 192px; top: 24px; position: absolute; width: 192px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                    <webuijsf:textArea binding="#{taxonomy$NewNomenclaturalGroup.txaDescription}" columns="24" id="txaDescription"
                                        style="height: 24px; left: 192px; top: 48px; position: absolute; width: 192px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                    <webuijsf:textArea binding="#{taxonomy$NewNomenclaturalGroup.txaNotes}" columns="24" id="txaNotes"
                                        style="height: 24px; left: 192px; top: 101px; position: absolute; width: 192px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                    <webuijsf:dropDown binding="#{taxonomy$NewNomenclaturalGroup.ddCollection}" id="ddCollection"
                                        items="#{taxonomy$NewNomenclaturalGroup.collectionData.options}"
                                        selected="#{taxonomy$NomenclaturalGroupSessionBean.selectedCollection}"
                                        style="height: 24px; left: 192px; top: 154px; position: absolute" width="195px"/>
                                    <webuijsf:dropDown binding="#{taxonomy$NewNomenclaturalGroup.ddCommonName}" id="ddCommonName"
                                        items="#{taxonomy$NewNomenclaturalGroup.commonNameData.options}" required="true"
                                        selected="#{taxonomy$NomenclaturalGroupSessionBean.selectedCommon}"
                                        style="height: 24px; left: 600px; top: 24px; position: absolute" width="195px"/>
                                    <webuijsf:dropDown binding="#{taxonomy$NewNomenclaturalGroup.ddCertifier}" id="ddCertifier"
                                        items="#{taxonomy$NewNomenclaturalGroup.certifierData.options}"
                                        selected="#{taxonomy$NomenclaturalGroupSessionBean.selectedCertifier}"
                                        style="position: absolute; left: 600px; top: 48px; height: 24px" width="195px"/>
                                    <webuijsf:textField binding="#{taxonomy$NewNomenclaturalGroup.txTemporality}" columns="26" id="txTemporality"
                                        style="position: absolute; left: 600px; top: 72px; width: 192px; height: 24px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                </webuijsf:panelLayout>
                                <webuijsf:tabSet id="tabSet1" lite="true" selected="tab1" style="height: 284px; width: 840px" styleClass="My_panel_blue">
                                    <webuijsf:tab id="tab1" text="#{resources.menuModuleTaxa}">
                                        <h:panelGrid columns="1" id="layoutpAudiences">
                                            <!-- AddRemove Component -->
                                            <h:panelGrid cellspacing="1" columns="1" id="gridpAddRemove" styleClass="My_table" width="830">
                                                <!-- Title -->
                                                <h:panelGrid columns="1" id="gridpArTitle" styleClass="My_table_top" width="100%">
                                                    <h:outputLabel id="lbArTitle" style="font-size: 14px" value="#{taxonomy$NomenclaturalGroupSessionBean.arTaxons.lbTitle}"/>
                                                </h:panelGrid>
                                                <!-- Add Remove body -->
                                                <h:panelGrid cellspacing="1" columns="3">
                                                    <!-- Available List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <h:outputLabel id="lbAvailableTaxonOptions" styleClass="My_white_label" value="#{taxonomy$NomenclaturalGroupSessionBean.arTaxons.lbAvailable}"/>
                                                        <h:selectManyListbox id="mlAvaibleList" size="11" style="width:390px" value="#{taxonomy$NomenclaturalGroupSessionBean.arTaxons.leftSelected}">
                                                            <f:selectItems id="mlAvailableSelectItems" value="#{taxonomy$NomenclaturalGroupSessionBean.arTaxons.leftOptions}"/>
                                                        </h:selectManyListbox>
                                                    </h:panelGrid>
                                                    <!-- Buttons Panel -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <!-- boton Agregar -->
                                                        <h:commandButton action="#{taxonomy$NomenclaturalGroupSessionBean.arTaxons.addSelectedOptions}"
                                                            id="btnAddOptions" style="margin: 2px;height: 22px" styleClass="My_Button_add"/>
                                                        <!-- boton Remover -->
                                                        <h:commandButton action="#{taxonomy$NomenclaturalGroupSessionBean.arTaxons.removeSelectedOptions}"
                                                            id="btnRemoveOptions" style="margin: 2px;height: 22px" styleClass="My_Button_remove"/>
                                                    </h:panelGrid>
                                                    <!-- Selected List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <h:outputLabel id="lbSelectedTaxonOptions" styleClass="My_white_label" value="#{taxonomy$NomenclaturalGroupSessionBean.arTaxons.lbSelected}"/>
                                                        <h:selectManyListbox id="mlSelectedList" size="11" style="width:390px" value="#{taxonomy$NomenclaturalGroupSessionBean.arTaxons.rightSelected}">
                                                            <f:selectItems id="mlSelectedSelectItems" value="#{taxonomy$NomenclaturalGroupSessionBean.arTaxons.rightOptions}"/>
                                                        </h:selectManyListbox>
                                                    </h:panelGrid>
                                                </h:panelGrid>
                                            </h:panelGrid>
                                            <!-- End AddRemove Component -->
                                        </h:panelGrid>
                                    </webuijsf:tab>
                                    <webuijsf:tab id="tabAudiences" text="#{resources.regions}">
                                        <h:panelGrid columns="1" id="layoutpAudiences">
                                            <!-- AddRemove Component -->
                                            <h:panelGrid cellspacing="1" columns="1" id="gridpAddRemove" styleClass="My_table" width="830">
                                                <!-- Title -->
                                                <h:panelGrid columns="1" id="gridpArTitle" styleClass="My_table_top" width="100%">
                                                    <h:outputLabel id="lbArTitle" style="font-size: 14px" value="#{taxonomy$NomenclaturalGroupSessionBean.arRegions.lbTitle}"/>
                                                </h:panelGrid>
                                                <!-- Add Remove body -->
                                                <h:panelGrid cellspacing="1" columns="3">
                                                    <!-- Available List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <h:outputLabel id="lbAvailableTaxonOptions" styleClass="My_white_label" value="#{taxonomy$NomenclaturalGroupSessionBean.arRegions.lbAvailable}"/>
                                                        <h:selectManyListbox id="mlAvaibleList" size="11" style="width:390px" value="#{taxonomy$NomenclaturalGroupSessionBean.arRegions.leftSelected}">
                                                            <f:selectItems id="mlAvailableSelectItems" value="#{taxonomy$NomenclaturalGroupSessionBean.arRegions.leftOptions}"/>
                                                        </h:selectManyListbox>
                                                    </h:panelGrid>
                                                    <!-- Buttons Panel -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <!-- boton Agregar -->
                                                        <h:commandButton action="#{taxonomy$NomenclaturalGroupSessionBean.arRegions.addSelectedOptions}"
                                                            id="btnAddOptions" style="margin: 2px;height: 22px" styleClass="My_Button_add"/>
                                                        <!-- boton Remover -->
                                                        <h:commandButton action="#{taxonomy$NomenclaturalGroupSessionBean.arRegions.removeSelectedOptions}"
                                                            id="btnRemoveOptions" style="margin: 2px;height: 22px" styleClass="My_Button_remove"/>
                                                    </h:panelGrid>
                                                    <!-- Selected List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <h:outputLabel id="lbSelectedTaxonOptions" styleClass="My_white_label" value="#{taxonomy$NomenclaturalGroupSessionBean.arRegions.lbSelected}"/>
                                                        <h:selectManyListbox id="mlSelectedList" size="11" style="width:390px" value="#{taxonomy$NomenclaturalGroupSessionBean.arRegions.rightSelected}">
                                                            <f:selectItems id="mlSelectedSelectItems" value="#{taxonomy$NomenclaturalGroupSessionBean.arRegions.rightOptions}"/>
                                                        </h:selectManyListbox>
                                                    </h:panelGrid>
                                                </h:panelGrid>
                                            </h:panelGrid>
                                            <!-- End AddRemove Component -->
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
