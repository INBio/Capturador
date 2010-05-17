<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : NewIndicator
    Created on : 26/03/2010, 09:44:48 AM
    Author     : gsulca
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <jsp:directive.page import="org.inbio.ara.indicator.TreeController"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:link id="link3" url="http://yui.yahooapis.com/2.8.0r4/build/fonts/fonts-min.css"/>
                    <webuijsf:link id="link4" url="http://yui.yahooapis.com/2.8.0r4/build/treeview/assets/skins/sam/treeview.css"/>
                    <webuijsf:script id="script2" type="text/JavaScript" url="http://yui.yahooapis.com/2.8.0r4/build/yahoo-dom-event/yahoo-dom-event.js"/>
                    <webuijsf:script id="script3" type="text/JavaScript" url="http://yui.yahooapis.com/2.8.0r4/build/treeview/treeview-min.js"/>
                    <webuijsf:script id="script4" type="text/JavaScript" url="/resources/js/inbio/Tree/TreeIndicatorEvent.js"/>
                    <webuijsf:script id="script5" type="text/JavaScript" url="/resources/js/inbio/SOAP/SOAPClient.js"/>
                    <webuijsf:script id="script6" type="text/JavaScript" url="/resources/js/inbio/Tree/ClickIndicatorEvent.js"/>
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
                            <webuijsf:label id="lbTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px" styleClass="Page_title" text="#{resources.title_indicator_new}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 50px; width: 840px" warnClass="warnMessage"/>
                                <h:panelGrid columns="4" id="grouppBotoneraIndicator" style="height: 24px" width="540">
                                    <h:commandButton action="#{indicator$NewIndicator.btnSaveIndicator_action}" id="btnSaveIndicator"
                                        style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.btnSave}"/>
                                </h:panelGrid>
                                <webuijsf:tabSet id="tabSet1" lite="true" selected="tabNewIndicator" styleClass="My_panel_blue">
                                    <webuijsf:tab id="tabNewIndicator" text="#{resources.dataIndicator}">
                                        <h:panelGrid binding="#{indicator$NewIndicator.gridIndicator}" columns="2" id="gridIndicator" style="height: 24px" width="540">
                                            <div id="tree" style="width:200px; float:left; " title="Indicators Tree "></div>
                                            <h:panelGrid binding="#{indicator$NewIndicator.indicator}" columns="1" id="indicator" style="height: 124px; position: relative; width: 400px; -rave-layout: grid">
                                                <webuijsf:label for="txIndicatorName" id="lbIndicatorName" text="#{resources.indicator_name}"/>
                                                <webuijsf:textField columns="25" id="txIndicatorName" required="true" text="#{indicator$IndicatorSessionBean.currentIndicatorDTO.name}"/>
                                                <webuijsf:label for="txIndicatorDescription" id="lbIndicatorDescription" text="#{resources.indicator_description}"/>
                                                <webuijsf:textArea columns="25" id="txaIndicatorDescription" style="height: 24px;width: 189px" text="#{indicator$IndicatorSessionBean.currentIndicatorDTO.description}"/>
                                                <webuijsf:label for="txApplyinParts" id="lbIApplyinParts" text="#{resources.applying_to_parts}"/>
                                                <h:selectOneRadio id="myRadio" layout="pageDirection" value="#{indicator$IndicatorSessionBean.currentIndicatorDTO.appliesToParts}">
                                                    <f:selectItem itemLabel="#{resources.yes}" itemValue="1"/>
                                                    <f:selectItem itemLabel="#{resources.no}" itemValue="0"/>
                                                </h:selectOneRadio>
                                            </h:panelGrid>
                                        </h:panelGrid>
                                    </webuijsf:tab>
                                    <webuijsf:tab id="tabBibliographicReferences" text="#{resources.bibliographicReferences}">
                                        <h:panelGrid binding="#{indicator$NewIndicator.gridDublinCore}">
                                            <h:panelGrid columns="3" id="gridpSearch" style="height: 24px" width="719">
                                                <h:inputText binding="#{indicator$NewIndicator.txSearch}" id="txSearch" style="height: 18px; width: 408px">
                                                    <f:validateLength maximum="100" minimum="0"/>
                                                </h:inputText>
                                                <h:commandButton action="#{indicator$NewIndicator.btnDublinCoreSearch_action}" binding="#{indicator$NewIndicator.btnSearch}" id="btnDublinCoreSearch"
                                                    style="height: 25px; width: 160px" styleClass="My_Button" value="#{resources.search}"/>
                                                <h:commandButton action="#{indicator$NewIndicator.btnAdvDublinCoreSearch_action}" binding="#{indicator$NewIndicator.btnAdvSearch}" id="btnAdvDublinCoreSearch"
                                                    style="height: 25px; width: 160px" styleClass="My_Button" value="#{resources.advanced_search}"/>
                                            </h:panelGrid>

                                        </h:panelGrid>

                                    </webuijsf:tab>
                                </webuijsf:tabSet>
                                <h:inputHidden binding="#{indicator$NewIndicator.hiddenNodeId}" id="hiddenNodeId"/>
                                <h:inputHidden binding="#{indicator$NewIndicator.hiddenPathNode}" id="hiddenPathNode"/>
                                <jsp:directive.include file="/Footer.jspf"/>
                            </h:panelGrid>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
