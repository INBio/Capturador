<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : NewFormatLabel
    Created on : 04/03/2010, 03:03:58 PM
    Author     : pcorrales
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
                    <webuijsf:script type="text/javascript" url="/resources/tinymce/jscripts/tiny_mce/tiny_mce.js"/>
                    <webuijsf:script type="text/javascript">
                        tinyMCE.init({
                        mode : "textareas",
                        theme : "advanced",
                        plugins : "table",
                        // Theme options
                        theme_advanced_buttons1 : "bold,italic,underline,|,justifyleft,justifycenter,justifyright,justifyfull,|,formatselect,fontsizeselect,|,undo,redo",
                        theme_advanced_buttons2 : "bullist,numlist, |,tablecontrols",
                        theme_advanced_buttons3 : "",
                        theme_advanced_buttons4 : "",
                        theme_advanced_toolbar_location : "top",
                        theme_advanced_toolbar_align : "center"
                        });
                    </webuijsf:script>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <webuijsf:label id="lbTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px" styleClass="Page_title" text="Formato de Etiqueta"/>
                            <h:panelGrid columns="1" id="gridpMain" style="height: 456px; left: 24px; top: 48px; position: absolute" width="888">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 30px; width: 840px" warnClass="warnMessage"/>
                                <webuijsf:panelGroup id="grouppBotonera" style="height: 24px; width: 840px">
                                    <h:commandButton action="#{label$NewFormatLabel.btnSaveFormatLabel_action}" id="btnEditFormatLabel"
                                                     style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.btnEdit}"/>
                                    <h:commandButton action="#{label$NewFormatLabel.btnSaveFormatLabel_action}" id="btnCancelFormat"
                                                     style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.btnCancel}"/>
                                </webuijsf:panelGroup>
                                <webuijsf:panelLayout id="lnTitle" style="height: 68px; position: relative; width: 840px; -rave-layout: grid" styleClass="My_subpanel_blue">
                                    <webuijsf:label id="lbNameFormat" style="left: 0px; top: 24px; position: absolute; width: 68px" text="#{resources.name}"/>
                                </webuijsf:panelLayout>
                                <webuijsf:tabSet id="tabLabelFormat" lite="true" selected="tabAuthors23" style="height: 259px; width: 859px" styleClass="My_panel_blue">
                                    <webuijsf:tab id="tabElements" text="Elements">
                                        <h:panelGrid columns="1" id="layoutpElements">
                                            <!-- AddRemove Component -->
                                            <h:panelGrid cellspacing="1" columns="1" id="gridpAddRemove" styleClass="My_table" width="830">
                                                <!-- Title -->
                                                <h:panelGrid columns="1" id="gridpElements" styleClass="My_table_top" width="100%">
                                                    <h:outputLabel id="lbETitle" style="font-size: 14px" value="#{label$SpeciesSessionBean.arDarwinCoreElements.lbTitle}"/>
                                                </h:panelGrid>
                                                <!-- Add Remove body -->
                                                <h:panelGrid cellspacing="1" columns="3">
                                                    <!-- Available List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <h:outputLabel id="lbAvailableElements" styleClass="My_white_label" value="#{label$LabelSessionBean.arDarwinCoreElements.lbAvailable}"/>
                                                        <h:selectManyListbox id="mlAvaibleList" size="11" style="width:390px" value="#{label$LabelSessionBean.arDarwinCoreElements.leftSelected}">
                                                            <f:selectItems id="mlAvailableSelectItems" value="#{label$LabelSessionBean.arDarwinCoreElements.leftOptions}"/>
                                                        </h:selectManyListbox>
                                                    </h:panelGrid>
                                                    <!-- Buttons Panel -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <!-- boton Agregar -->
                                                        <h:commandButton action="#{label$LabelSessionBean.arDarwinCoreElements.addSelectedOptions}"
                                                            id="btnAddOptions" style="margin: 2px;height: 22px" styleClass="My_Button_add"/>
                                                        <!-- boton Remover -->
                                                        <h:commandButton action="#{label$LabelSessionBean.arDarwinCoreElements.removeSelectedOptions}"
                                                            id="btnRemoveOptions" style="margin: 2px;height: 22px" styleClass="My_Button_remove"/>
                                                    </h:panelGrid>
                                                    <!-- Selected List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                        <h:outputLabel id="lbSelectedTaxonOptions" styleClass="My_white_label" value="#{label$LabelSessionBean.arDarwinCoreElements.lbSelected}"/>
                                                        <h:selectManyListbox id="mlSelectedList" size="11" style="width:390px" value="#{label$LabelSessionBean.arDarwinCoreElements.rightSelected}">
                                                            <f:selectItems id="mlSelectedSelectItems" value="#{label$LabelSessionBean.arDarwinCoreElements.rightOptions}"/>
                                                        </h:selectManyListbox>
                                                    </h:panelGrid>
                                                </h:panelGrid>
                                            </h:panelGrid>
                                        </h:panelGrid>
                                    </webuijsf:tab>
                                    <webuijsf:tab id="tabAtributes" text="Atributes format">
                                        <h:panelGrid id="layoutpAtributes" style="height: 175px" width="766">
                                            <webuijsf:panelLayout id="contenido">
                                                <webuijsf:textField columns="15" id="txMarginLeft" style="left: 120px; top: -48px; position: absolute; width: 120px"/>
                                                <webuijsf:label id="lbMarginLeft" style="height: 24px; left: 24px; top: -48px; position: absolute; width: 94px" text="#{resources.MarginLeft}"/>
                                                <webuijsf:textField columns="15" id="txMarginRigth" style="left: 120px; top: -24px; position: absolute; width: 120px"/>
                                                <webuijsf:label id="lbMarginRigth" style="height: 24px; left: 24px; top: -24px; position: absolute; width: 94px" text="#{resources.MarginRigth}"/>
                                                <webuijsf:textField columns="15" id="txMarginTop" style="left: 120px; top: 0px; position: absolute; width: 120px"/>
                                                <webuijsf:label id="lbMarginTop" style="height: 24px; left: 24px; top: 0px; position: absolute; width: 94px" text="#{resources.MarginTop}"/>
                                                <webuijsf:textField columns="15" id="txMarginBottom" style="left: 120px; top: 24px; position: absolute; width: 120px"/>
                                                <webuijsf:label id="lbMarginBottom" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 94px" text="#{resources.MarginBottom}"/>
                                                <webuijsf:textField columns="15" id="txHeigth" style="left: 432px; top: -48px; position: absolute; width: 120px"/>
                                                <webuijsf:label id="lbHeigth" style="height: 24px; left: 336px; top: -48px; position: absolute; width: 94px" text="#{resources.HeigthLabel}"/>
                                                <webuijsf:textField columns="15" id="txWidth" style="left: 432px; top: -24px; position: absolute; width: 120px"/>
                                                <webuijsf:label id="lbWidth" style="height: 24px; left: 336px; top: -24px; position: absolute; width: 94px" text="#{resources.WidthLabel}"/>
                                            </webuijsf:panelLayout>
                                        </h:panelGrid>
                                    </webuijsf:tab>
                                    <webuijsf:tab id="tabAuthors23" text="Preview">
                                        <h:panelGrid id="layoutpAuthors" style="height: 144px" width="838">
                                            <h:inputTextarea binding="#{label$NewFormatLabel.abstractText}" id="txaHT" style="height: 192px; width: 840px"/>
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
