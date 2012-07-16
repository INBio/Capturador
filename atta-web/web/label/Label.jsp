<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : label
    Created on : 25/01/2010, 09:39:45 AM
    Author     : pcorrales
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                    <webuijsf:link id="link2" url="/resources/css/stylesheet.css"/>
                    <!-- TinyMCE -->
                    <webuijsf:script type="text/javascript" url="/resources/tinymce/jscripts/tiny_mce/tiny_mce.js"/>
−
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
                    <!-- /TinyMCE -->
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido" style="position: relative; -rave-layout: grid">
                        <webuijsf:form id="form1">
                            <webuijsf:label id="lbTitle" style="height: 24px; left: 24px; top:20px; position: absolute; width: 850px" styleClass="Page_title" text="#{resources.titleLabel}"/>
                            <h:panelGrid columns="1" id="gridLabelMain" style="height: 504px; left: 24px; top: 48px; position: absolute; z-index: 500" width="864">
                                <webuijsf:panelGroup id="grouppLabel" style="height: 24px; width: 840px">
                                    <h:commandButton action="#{label$Label.btnSearch_action}" id="btnSearchSpecimen" style="height: 24px;width: 175px"
                                        styleClass="My_Button" value="#{resources.search_specimen}"/>
                                    <h:commandButton action="#{label$Label.btnGenerationLabel_action}" id="btnGerationLabel" style="height: 24px; width: 175px"
                                        styleClass="My_Button" value="#{resources.generateLabels}"/>
                                </webuijsf:panelGroup>
                                <webuijsf:panelLayout id="layoutpEditGathDetails"
                                    style="height: 212px; top: 0px; position: relative; width: 835px; -rave-layout: grid" styleClass="My_panel_blue">
                                    <webuijsf:label id="lbIdSpecimen" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 180px" text=" #{resources.id}"/>
                                    <webuijsf:textField binding="#{label$Label.txSpecimen}" columns="25" id="textSpecimen"
                                        style="height: 24px; left: 168px; top:24px; position: absolute; width: 180px" validatorExpression="#{util$ValidatorBean.doubleNumberFormatValidator}"/>
                                    <webuijsf:label id="lbCatalogNumber" style="height: 24px; left: 24px; top: 72px; position: absolute; width: 140px" text="#{resources.category}"/>
                                    <webuijsf:textField columns="25" id="txCatalogNumber"
                                        style="height: 24px; left: 168px; top: 72px; position: absolute; width: 180px" text="#{label$LabelSessionBean.specimenDTO.catalogNumber}"/>
                                    <webuijsf:label id="lbCategory" style="height: 24px; left: 24px; top: 96px; position: absolute; width: 140px" text="#{resources.category}"/>
                                    <webuijsf:textField columns="25" id="txCategory"
                                        style="height: 24px; left: 168px; top: 96px; position: absolute; width: 180px" text="#{label$LabelSessionBean.specimenDTO.categoryName}"/>
                                    <webuijsf:label id="lbInstitution" style="height: 24px; left: 24px; top: 120px; position: absolute; width: 140px" text="#{resources.institution}"/>
                                    <webuijsf:textField columns="25" id="txInstitution"
                                        style="height: 24px; left: 168px; top: 120px; position: absolute; width: 180px" text="#{label$LabelSessionBean.specimenDTO.institutionCode}"/>
                                    <webuijsf:label id="lbCoordinates" style="height: 24px; left: 24px; top: 168px; position: absolute; width: 140px" text="#{resources.coordinates}"/>
                                    <webuijsf:textField columns="25" id="txCoordinates"
                                        style="height: 24px; left: 168px; top: 168px; position: absolute; width: 180px" text="#{label$LabelSessionBean.specimenDTO.coordinates}"/>
                                    <webuijsf:label id="lbOrigenName" style="height: 24px; left: 24px; top: 144px; position: absolute; width: 140px" text="#{resources.origin}"/>
                                    <webuijsf:textField columns="25" id="txOriginName"
                                        style="height: 24px; left: 168px; top: 144px; position: absolute; width: 180px" text="#{label$LabelSessionBean.specimenDTO.originName}"/>
                                </webuijsf:panelLayout>
                                <webuijsf:panelLayout id="layoutp" style="height: 214px; top: 0px; position: relative; width: 835px; -rave-layout: grid" styleClass="My_panel_blue">
                                    <h:inputTextarea binding="#{label$Label.txaLabelFormat}" cols="100" id="textArea1" style="height: 144px; width: 816px"/>
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
