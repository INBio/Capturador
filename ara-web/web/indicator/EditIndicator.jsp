<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : EditIndicator
    Created on : 15/04/2010, 12:55:19 PM
    Author     : gsulca
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <jsp:directive.page import="org.inbio.ara.indicator.TreeController"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:link id="link2" url="/resources/css/stylesheet.css"/>
                    <webuijsf:link id="link3" url="http://yui.yahooapis.com/2.8.0r4/build/fonts/fonts-min.css"/>
                    <webuijsf:link id="link4" url="http://yui.yahooapis.com/2.8.0r4/build/treeview/assets/skins/sam/treeview.css"/>
                    <webuijsf:script id="script2" type="text/JavaScript" url="http://yui.yahooapis.com/2.8.0r4/build/yahoo-dom-event/yahoo-dom-event.js"/>
                    <webuijsf:script id="script3" type="text/JavaScript" url="http://yui.yahooapis.com/2.8.0r4/build/treeview/treeview-min.js"/>
                    <webuijsf:script id="script4" type="text/JavaScript" url="/resources/js/inbio/Tree/TreeIndicatorEvent.js"/>
                    <webuijsf:script id="script5" type="text/JavaScript" url="/resources/js/inbio/SOAP/SOAPClient.js"/>
                    <webuijsf:script id="script6" type="text/JavaScript" url="/resources/js/inbio/Tree/ClickEditIndicatorEvent.js"/>
                    <jsp:scriptlet>
                        TreeController treeController = new TreeController();
                        String treeScript = treeController.getTreeScript();
                        out.write(treeScript);
                    </jsp:scriptlet>
                </webuijsf:head>
                <webuijsf:body id="body1" onLoad="initIndicators()" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <webuijsf:label id="lbTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px" styleClass="Page_title" text="#{resources.title_indicator_edit}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 50px; width: 840px" warnClass="warnMessage"/>
                                <h:panelGrid columns="4" id="grouppBotoneraIndicator" style="height: 24px" width="540">
                                    <h:commandButton action="#{indicator$EditIndicator.btnSaveIndicator_action}" id="btnSaveIndicator"
                                        style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.btnSave}"/>
                                </h:panelGrid>
                                <h:panelGrid binding="#{indicator$EditIndicator.gridIndicator}" columns="2" id="gridIndicator" style="height: 24px" width="540">
                                    <div id="tree" style="width:200px; float:left; " title="Indicators Tree "></div>
                                    <h:panelGrid binding="#{indicator$EditIndicator.indicator}" columns="1" id="indicator" style="height: 124px; position: relative; width: 400px; -rave-layout: grid">
                                        <webuijsf:label for="txIndicatorName" id="lbIndicatorName" text="#{resources.indicator_name}"/>
                                        <webuijsf:textField text="#{indicator$IndicatorSessionBean.currentIndicatorDTO.name}" columns="25" id="txIndicatorName"/>
                                        <webuijsf:label for="txIndicatorDescription" id="lbIndicatorDescription" text="#{resources.indicator_description}"/>
                                        <webuijsf:textArea text="#{indicator$IndicatorSessionBean.currentIndicatorDTO.description}" columns="25"
                                            id="txaIndicatorDescription" required="true" style="height: 24px;width: 189px"/>
                                        <webuijsf:label for="txApplyinParts" id="lbIApplyinParts" text="#{resources.applying_to_parts}"/>
                                        <webuijsf:radioButtonGroup id="radioButtonGroup" items="#{indicator$EditIndicator.radioData.options}"
                                                                   selected="#{indicator$IndicatorSessionBean.currentIndicatorDTO.appliesToParts}" style="font-size: 14px; height: 48px; width: 408px"/>
                                        <h:inputHidden binding="#{indicator$EditIndicator.hiddenNodeId}" id="hiddenNodeId"/>
                                        <h:inputHidden binding="#{indicator$EditIndicator.hiddenPathNode}" id="hiddenPathNode"/>
                                        <h:inputHidden binding="#{indicator$EditIndicator.hiddenAncestorNodeId}" id="hiddenAncestorNodeId"/>
                                    </h:panelGrid>
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
