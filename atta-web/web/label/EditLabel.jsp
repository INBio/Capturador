<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : EditLabel
    Created on : 22/04/2010, 03:03:58 PM
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
                        theme_advanced_toolbar_align : "center",
                        readonly : true ,
                        editor_selector : "mceAdvanced"
                        });

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
                        theme_advanced_toolbar_align : "center",
                        editor_selector : "mceSimple"
                        });

                    function imprSelec(nombre)
                        {
                          var ficha = document.getElementById(nombre);
                          var ventimp = window.open(' ', 'popimpr');
                          ventimp.document.write( ficha.innerHTML );
                          ventimp.document.close();
                          ventimp.print( );
                          ventimp.close();
                        }
                    </webuijsf:script>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <webuijsf:label binding="#{label$EditLabel.labelTitle}" id="lbTitle"
                                style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px" styleClass="Page_title" text="#{resources.visualizerLabel}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="height: 576px; left: 24px; top: 72px; position: absolute" width="864">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 30px; width: 840px" warnClass="warnMessage"/>
                                <webuijsf:panelGroup id="grouppBotonera" style="height: 24px; width: 840px">
                                    <h:commandButton action="#{label$EditLabel.btnSaveCorrectionLabel}" binding="#{label$EditLabel.btnCancel}" id="btnSaveLabel"
                                        style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.btnSave}"/>
                                    <h:commandButton id="btnCancel" style="height: 24px; width: 200px" styleClass="My_Button" value="#{resources.btnCancel}"/>
                                </webuijsf:panelGroup>
                                <webuijsf:tabSet binding="#{label$EditLabel.tabSet}" id="tabSet" lite="true" selected="tabLabel"
                                    style="height: 428px; width: 859px" styleClass="My_panel_blue">
                                    <webuijsf:tab binding="#{label$EditLabel.tabLabel}" id="tabLabel" text="#{resources.actualLabel}">
                                        <h:panelGrid id="layoutpLabel" style="height: 190px; left: 52px; top: 200px; position: absolute" width="810">
                                            <h:inputTextarea binding="#{label$EditLabel.txaLabel}" id="txaLabel" style="height: 120px; width: 792px" styleClass="mceAdvanced"/>
                                        </h:panelGrid>
                                    </webuijsf:tab>
                                    <webuijsf:tab actionExpression="#{label$EditLabel.selectCorrectionLabel}" id="tabReviserLabel" text="#{resources.correctLabel}">
                                        <h:panelGrid columns="2" id="layoutCorrectores" style="left: 28px; top: 200px; position: absolute" width="810">
                                            <h:panelGrid cellspacing="1" columns="1" id="gridpTableButtonsReviser" style="left: 15px; height: 55px  top: 200px "
                                                styleClass="My_table" width="400">
                                                <webuijsf:panelLayout id="contents">
                                                    <h:panelGrid cellspacing="1" columns="1" id="gridpTableButtonsReviser" styleClass="My_table" width="360">
                                                        <webuijsf:panelGroup id="grouppButtonsReviser">
                                                            <h:panelGrid columns="1" id="gridpquantitty" styleClass="My_table_top" width="400">
                                                                <h:outputLabel id="labelQuantity" value="#{label$EditLabel.quantityTotal}"/>
                                                            </h:panelGrid>
                                                            <h:commandButton action="#{label$EditLabel.btnViewCorrectionLabelAction}"
                                                                id="btnEditCorrectionLabel" style="margin: 2px; height: 22px" styleClass="My_Button_table" value="#{resources.view_record}"/>
                                                            <h:commandButton action="#{label$EditLabel.btnNewCorrectionLabelAction}" id="btnNewCorrectionLabel"
                                                                style="margin: 2px; height: 22px" styleClass="My_Button_table" value="#{resources.new}"/>
                                                            <webuijsf:panelGroup id="panelPaginaciont" separator=" " style="margin-left:70px;">
                                                                <h:commandButton action="#{label$LabelSessionBean.pagination.firstResults}" id="btnFirst"
                                                                    rendered="#{label$LabelSessionBean.pagination.isVisiblePrevious}"
                                                                    style="margin: 2px;height: 22px" styleClass="My_Button_first" value="#{resources.pagination_first}"/>
                                                                <h:commandButton action="#{label$LabelSessionBean.pagination.previousResults}" id="btnPrevioust"
                                                                    rendered="#{label$LabelSessionBean.pagination.isVisiblePrevious}"
                                                                    style="margin: 2px;height: 22px" styleClass="My_Button_previous" value="#{resources.pagination_previous}"/>
                                                                <h:commandButton action="#{label$LabelSessionBean.pagination.nextResults}" id="btnNextt"
                                                                    rendered="#{label$LabelSessionBean.pagination.isVisibleNext}"
                                                                    style="margin: 2px;height: 22px" styleClass="My_Button_next" value="#{resources.pagination_next}"/>
                                                                <h:commandButton action="#{label$LabelSessionBean.pagination.lastResults}" id="btnLastt"
                                                                    rendered="#{label$LabelSessionBean.pagination.isVisibleNext}"
                                                                    style="margin: 2px;height: 22px" styleClass="My_Button_last" value="#{resources.pagination_last}"/>
                                                            </webuijsf:panelGroup>
                                                        </webuijsf:panelGroup>
                                                        <h:dataTable binding="#{label$EditLabel.dataTableReviserLabels}" cellspacing="0"
                                                            columnClasses="list-columns" headerClass="list-header" id="dataTableHistoryLabel"
                                                            rowClasses="list-row-even,list-row-odd" rows="#{label$LabelSessionBean.pagination.resultsPerPage}"
                                                            style="border-top: solid rgb(214, 218, 221) 2px; border-bottom: solid rgb(214, 218, 221) 2px; border-left: solid rgb(214, 218, 221) 2px; "
                                                            value="#{label$LabelSessionBean.pagination.dataProvider.list}" var="currentRow" width="400">
                                                            <h:column>
                                                                <h:selectBooleanCheckbox id="checkbox1" value="#{currentRow['selected']}"/>
                                                            </h:column>
                                                            <h:column>
                                                                <f:facet name="header">
                                                                    <h:outputText value="#{resources.creation_date}"/>
                                                                </f:facet>
                                                                <h:outputText value="#{currentRow['initialTimestand']}"/>
                                                            </h:column>
                                                            <h:column>
                                                                <f:facet name="header">
                                                                    <h:outputText value="#{resources.validator}"/>
                                                                </f:facet>
                                                                <h:outputText value="#{currentRow['userName']}"/>
                                                            </h:column>
                                                        </h:dataTable>
                                                    </h:panelGrid>
                                                </webuijsf:panelLayout>
                                            </h:panelGrid>
                                            <h:panelGrid cellspacing="1" columns="1" id="gridpLabel" style="height: 37px" width="407">
                                                <h:panelGrid>
                                                    <h:inputTextarea binding="#{label$EditLabel.txaCorrectLabel}" id="txaEditCorrector"
                                                        style="height: 120px; width: 400px" styleClass="mceAdvanced"/>
                                                </h:panelGrid>
                                            </h:panelGrid>
                                        </h:panelGrid>
                                    </webuijsf:tab>
                                    <webuijsf:tab actionExpression="#{label$EditLabel.selectLabelHistory}" binding="#{label$EditLabel.tabHistory}"
                                        id="tabHistoryLabel" text="#{resources.labelHistory}">
                                        <h:panelGrid columns="2" id="layoutpHistoryLabel" style="left: 28px; top: 200px; position: absolute" width="810">
                                            <h:panelGrid cellspacing="1" columns="1" id="gridpTableButtonsHistory" style="left: 25px; height: 55px  top: 200px "
                                                styleClass="My_table" width="400">
                                                <webuijsf:panelLayout id="contents">
                                                    <h:panelGrid cellspacing="1" columns="1" id="gridpTableButtonsHistory" styleClass="My_table" width="360">
                                                        <webuijsf:panelGroup id="grouppButtonst">
                                                            <h:panelGrid columns="1" id="gridpquantitty" styleClass="My_table_top" width="400">
                                                                <h:outputLabel id="labelQuantity" value="#{label$EditLabel.quantityTotal}"/>
                                                            </h:panelGrid>
                                                            <h:commandButton action="#{label$EditLabel.btnViewLabelHistoryAction}" id="btnViewHistoryLabel"
                                                                style="margin: 2px; height: 22px" styleClass="My_Button_table" value="#{resources.view_record}"/>
                                                            <webuijsf:panelGroup id="panelPaginaciont" separator=" " style="margin-left:70px;">
                                                                <h:commandButton action="#{label$LabelSessionBean.pagination.firstResults}" id="btnFirst"
                                                                    rendered="#{label$LabelSessionBean.pagination.isVisiblePrevious}"
                                                                    style="margin: 2px;height: 22px" styleClass="My_Button_first" value="#{resources.pagination_first}"/>
                                                                <h:commandButton action="#{label$LabelSessionBean.pagination.previousResults}" id="btnPrevioust"
                                                                    rendered="#{label$LabelSessionBean.pagination.isVisiblePrevious}"
                                                                    style="margin: 2px;height: 22px" styleClass="My_Button_previous" value="#{resources.pagination_previous}"/>
                                                                <h:commandButton action="#{label$LabelSessionBean.pagination.nextResults}" id="btnNextt"
                                                                    rendered="#{label$LabelSessionBean.pagination.isVisibleNext}"
                                                                    style="margin: 2px;height: 22px" styleClass="My_Button_next" value="#{resources.pagination_next}"/>
                                                                <h:commandButton action="#{label$LabelSessionBean.pagination.lastResults}" id="btnLastt"
                                                                    rendered="#{label$LabelSessionBean.pagination.isVisibleNext}"
                                                                    style="margin: 2px;height: 22px" styleClass="My_Button_last" value="#{resources.pagination_last}"/>
                                                            </webuijsf:panelGroup>
                                                        </webuijsf:panelGroup>
                                                        <h:dataTable binding="#{label$EditLabel.dataTableHistoryLabels}" cellspacing="0"
                                                            columnClasses="list-columns" headerClass="list-header" id="dataTableHistoryLabel"
                                                            rowClasses="list-row-even,list-row-odd" rows="#{label$LabelSessionBean.pagination.resultsPerPage}"
                                                            style="border-top: solid rgb(214, 218, 221) 2px; border-bottom: solid rgb(214, 218, 221) 2px; border-left: solid rgb(214, 218, 221) 2px; "
                                                            value="#{label$LabelSessionBean.pagination.dataProvider.list}" var="currentRow" width="400">
                                                            <h:column>
                                                                <h:selectBooleanCheckbox id="checkbox1" value="#{currentRow['selected']}"/>
                                                            </h:column>
                                                            <h:column>
                                                                <f:facet name="header">
                                                                    <h:outputText value="#{resources.creation_date}"/>
                                                                </f:facet>
                                                                <h:outputText value="#{currentRow['initialTimestand']}"/>
                                                            </h:column>
                                                            <h:column>
                                                                <f:facet name="header">
                                                                    <h:outputText value="#{resources.validator}"/>
                                                                </f:facet>
                                                                <h:outputText value="#{currentRow['userName']}"/>
                                                            </h:column>
                                                        </h:dataTable>
                                                    </h:panelGrid>
                                                </webuijsf:panelLayout>
                                            </h:panelGrid>
                                            <h:panelGrid cellspacing="1" columns="1" id="gridpEditLabelHistory" style="height: 200px" width="350">
                                                <h:panelGrid>
                                                    <h:inputTextarea binding="#{label$EditLabel.txaLabelHistory}" id="txaEditHistory"
                                                        style="height: 120px; width: 400px" styleClass="mceAdvanced"/>
                                                </h:panelGrid>
                                            </h:panelGrid>
                                        </h:panelGrid>
                                    </webuijsf:tab>
                                    <webuijsf:tab actionExpression="#{label$EditLabel.btnEditOriginalAction}" binding="#{label$EditLabel.tabOriginal}"
                                        id="tabOriginalLabel" text="#{resources.originalLabel}">
                                        <h:panelGrid id="layoutpOriginalLabel" style="height: 190px; left: 52px; top: 200px; position: absolute" width="810">
                                            <h:inputTextarea binding="#{label$EditLabel.txaOriginalLabel}" id="txaOriginalLabel" readonly="true"
                                                style="height: 120px; width: 792px" styleClass="mceAdvanced"/>
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
