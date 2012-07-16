<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : NewFormatLabel
    Created on : 04/03/2010, 03:03:58 PM
    Author     : pcorrales
-->
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
                        theme_advanced_buttons1 : "bold,italic,|,justifyleft,justifycenter,justifyright,justifyfull,fontsizeselect,|,undo,redo",
                        theme_advanced_buttons2 : "",
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
<webuijsf:label id="lbTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px" styleClass="Page_title" text="Generación de Etiquetas"/>

<h:panelGrid columns="1" id="gridpMain" style="height: 288px; left: 24px; top: 72px; position: absolute" width="864">
<h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msgListSpecimen" infoClass="infoMessage"
                                    style="height: 40px; width: 574px" warnClass="warnMessage"/>
<webuijsf:panelGroup id="grouppBotonera" style="height: 24px; width: 840px">
<h:commandButton action="#{label$GenerationLabels.btnGenerated_action}" id="btnGenerated" style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.generateLabels}"/>
<h:commandButton action="#{label$GenerationLabels.btnPrint_action}" id="btnPrint" style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.printLabels}"/>
<h:commandButton action="#{label$GenerationLabels.btnExportWithoutFormat_action}" id="btnExport" style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.exportWithoutFormat}"/>
</webuijsf:panelGroup>

<webuijsf:panelLayout id="lnTitle" style="height: 122px; position: relative; width: 840px; -rave-layout: grid" styleClass="My_subpanel_blue">
<webuijsf:label id="lbTypeLabel" style="left: 0px; top: 24px; position: absolute; width: 116px" text="Tipo de Etiqueta"/>
<webuijsf:dropDown binding="#{label$GenerationLabels.ddTypeLabel}" id="dropdownLabelType" items="#{label$GenerationLabels.typeLabelData.options}" selected="#{label$LabelSessionBean.selectedTypeLabel}" style="left: 120px; top: 24px; position: absolute; width: 200px" submitForm="true" width="200px" required="true"/>
<webuijsf:label id="lbTypeFormat" style="left: 0px; top: 72px; position: absolute; width: 116px" text="Tipo de Formato"/>
<webuijsf:dropDown binding="#{label$GenerationLabels.ddTypeFormat}" id="dropdownFormatType" items="#{label$GenerationLabels.typeFormatLabelData.options}" selected="#{label$LabelSessionBean.selectedTypeFormat}" onChange="#{label$GenerationLabels.formatLabelContents}" style="left: 120px; top: 72px; position: absolute; width: 200px" submitForm="true" width="200px" required="true"/>
</webuijsf:panelLayout>
 <webuijsf:panelLayout id="lnPreviewLabel" style="height:250px; position: relative; width: 840px; -rave-layout: grid" styleClass="My_subpanel_blue">
     <h:inputTextarea binding="#{label$GenerationLabels.txaFormatLabel}" readonly="true"  id="txaLabel" style="height: 200px; width: 792px"/>
 </webuijsf:panelLayout>
<jsp:directive.include file="/Footer.jspf"/>
</h:panelGrid>
</webuijsf:form>
</webuijsf:panelLayout>
</webuijsf:body>
</webuijsf:html>
</webuijsf:page>
</f:view>
</jsp:root>