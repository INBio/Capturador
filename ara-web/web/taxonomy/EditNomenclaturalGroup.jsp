<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : EditNomenclaturalGroup
    Created on : 23/11/2009, 06:07:19 PM
    Author     : esmata
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:link id="link2" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <webuijsf:label id="lbTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px" styleClass="Page_title" text="#{resources.titleNomenclaturalGroupEdit}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 50px; width: 840px" warnClass="warnMessage"/>
                                <!-- Botonera -->
                                <webuijsf:panelGroup id="grouppBotonera" style="height: 24px; width: 840px">
                                    <h:commandButton action="#{taxonomy$EditNomenclaturalGroup.btnEditNomenclaturalGroup_action}" id="btnEditNomenclaturalGroup"
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
                                    <webuijsf:textField binding="#{taxonomy$EditNomenclaturalGroup.txName}" columns="26" id="txName" required="true"
                                        style="height: 24px; left: 192px; top: 24px; position: absolute; width: 192px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                    <webuijsf:textArea binding="#{taxonomy$EditNomenclaturalGroup.txaDescription}" columns="24" id="txaDescription" style="height: 24px; left: 192px; top: 48px; position: absolute; width: 192px"/>
                                    <webuijsf:textArea binding="#{taxonomy$EditNomenclaturalGroup.txaNotes}" columns="24" id="txaNotes" style="height: 24px; left: 192px; top: 101px; position: absolute; width: 192px"/>
                                    <webuijsf:dropDown binding="#{taxonomy$EditNomenclaturalGroup.ddCollection}" id="ddCollection"
                                        items="#{taxonomy$EditNomenclaturalGroup.collectionDataEdit.options}"
                                        selected="#{taxonomy$NomenclaturalGroupSessionBean.currentNomenclaturalGroupDTO.collectionId}"
                                        style="height: 24px; left: 192px; top: 154px; position: absolute" width="195px"/>
                                    <webuijsf:dropDown binding="#{taxonomy$EditNomenclaturalGroup.ddCommonName}" id="ddCommonName"
                                        items="#{taxonomy$EditNomenclaturalGroup.commonNameDataEdit.options}" required="true"
                                        selected="#{taxonomy$NomenclaturalGroupSessionBean.currentNomenclaturalGroupDTO.commonName}"
                                        style="height: 24px; left: 600px; top: 24px; position: absolute" width="195px"/>
                                    <webuijsf:dropDown binding="#{taxonomy$EditNomenclaturalGroup.ddCertifier}" id="ddCertifier"
                                        items="#{taxonomy$EditNomenclaturalGroup.certifierDataEdit.options}"
                                        selected="#{taxonomy$NomenclaturalGroupSessionBean.currentNomenclaturalGroupDTO.certificatorPersonId}"
                                        style="position: absolute; left: 600px; top: 48px; height: 24px" width="195px"/>
                                    <webuijsf:textField binding="#{taxonomy$EditNomenclaturalGroup.txTemporality}" columns="26" id="txTemporality"
                                        style="position: absolute; left: 600px; top: 72px; width: 192px; height: 24px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                </webuijsf:panelLayout>
                                <webuijsf:tabSet id="tabSet1" lite="true" selected="tab1" style="height: 284px; width: 840px" styleClass="My_panel_blue">
                                    <webuijsf:tab id="tab1" text="#{resources.menuModuleTaxa}">
                                        <h:panelGrid columns="1" id="layoutpAudiences">
                                            <!-- AddRemove Component -->
                                            <h:panelGrid cellspacing="1" columns="1" id="gridpAddRemove" styleClass="My_table" width="830">
                                                <!-- Title -->
                                                <h:panelGrid columns="1" id="gridpArTitle" styleClass="My_table_top" width="100%">
                                                    <h:outputLabel id="lbArTitle" style="font-size: 14px" value="#{taxonomy$NomenclaturalGroupSessionBean.arTaxonsEdit.lbTitle}"/>
                                                </h:panelGrid>
                                                <!-- Add Remove body -->
                                                <h:panelGrid cellspacing="1" columns="3">
                                                    <!-- Available List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <h:outputLabel id="lbAvailableTaxonOptions" styleClass="My_white_label" value="#{taxonomy$NomenclaturalGroupSessionBean.arTaxonsEdit.lbAvailable}"/>
                                                        <h:selectManyListbox id="mlAvaibleList" size="11" style="width:390px" value="#{taxonomy$NomenclaturalGroupSessionBean.arTaxonsEdit.leftSelected}">
                                                            <f:selectItems id="mlAvailableSelectItems" value="#{taxonomy$NomenclaturalGroupSessionBean.arTaxonsEdit.leftOptions}"/>
                                                        </h:selectManyListbox>
                                                    </h:panelGrid>
                                                    <!-- Buttons Panel -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <!-- boton Agregar -->
                                                        <h:commandButton action="#{taxonomy$NomenclaturalGroupSessionBean.arTaxonsEdit.addSelectedOptions}"
                                                            id="btnAddOptions" style="margin: 2px;height: 22px" styleClass="My_Button_add"/>
                                                        <!-- boton Remover -->
                                                        <h:commandButton action="#{taxonomy$NomenclaturalGroupSessionBean.arTaxonsEdit.removeSelectedOptions}"
                                                            id="btnRemoveOptions" style="margin: 2px;height: 22px" styleClass="My_Button_remove"/>
                                                    </h:panelGrid>
                                                    <!-- Selected List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <h:outputLabel id="lbSelectedTaxonOptions" styleClass="My_white_label" value="#{taxonomy$NomenclaturalGroupSessionBean.arTaxonsEdit.lbSelected}"/>
                                                        <h:selectManyListbox id="mlSelectedList" size="11" style="width:390px" value="#{taxonomy$NomenclaturalGroupSessionBean.arTaxonsEdit.rightSelected}">
                                                            <f:selectItems id="mlSelectedSelectItems" value="#{taxonomy$NomenclaturalGroupSessionBean.arTaxonsEdit.rightOptions}"/>
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
                                                    <h:outputLabel id="lbArTitle" style="font-size: 14px" value="#{taxonomy$NomenclaturalGroupSessionBean.arRegionsEdit.lbTitle}"/>
                                                </h:panelGrid>
                                                <!-- Add Remove body -->
                                                <h:panelGrid cellspacing="1" columns="3">
                                                    <!-- Available List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <h:outputLabel id="lbAvailableTaxonOptions" styleClass="My_white_label" value="#{taxonomy$NomenclaturalGroupSessionBean.arRegionsEdit.lbAvailable}"/>
                                                        <h:selectManyListbox id="mlAvaibleList" size="11" style="width:390px" value="#{taxonomy$NomenclaturalGroupSessionBean.arRegionsEdit.leftSelected}">
                                                            <f:selectItems id="mlAvailableSelectItems" value="#{taxonomy$NomenclaturalGroupSessionBean.arRegionsEdit.leftOptions}"/>
                                                        </h:selectManyListbox>
                                                    </h:panelGrid>
                                                    <!-- Buttons Panel -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <!-- boton Agregar -->
                                                        <h:commandButton action="#{taxonomy$NomenclaturalGroupSessionBean.arRegionsEdit.addSelectedOptions}"
                                                            id="btnAddOptions" style="margin: 2px;height: 22px" styleClass="My_Button_add"/>
                                                        <!-- boton Remover -->
                                                        <h:commandButton action="#{taxonomy$NomenclaturalGroupSessionBean.arRegionsEdit.removeSelectedOptions}"
                                                            id="btnRemoveOptions" style="margin: 2px;height: 22px" styleClass="My_Button_remove"/>
                                                    </h:panelGrid>
                                                    <!-- Selected List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <h:outputLabel id="lbSelectedTaxonOptions" styleClass="My_white_label" value="#{taxonomy$NomenclaturalGroupSessionBean.arRegionsEdit.lbSelected}"/>
                                                        <h:selectManyListbox id="mlSelectedList" size="11" style="width:390px" value="#{taxonomy$NomenclaturalGroupSessionBean.arRegionsEdit.rightSelected}">
                                                            <f:selectItems id="mlSelectedSelectItems" value="#{taxonomy$NomenclaturalGroupSessionBean.arRegionsEdit.rightOptions}"/>
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
