<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ListIndicator
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
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:link id="link2" url="/resources/css/stylesheet.css"/>
                    <webuijsf:link id="link3" url="/resources/js/yui/build/fonts/fonts-min.css"/>
                    <webuijsf:link id="link4" url="/resources/js/yui/build/treeview/assets/skins/sam/treeview.css"/>
                    <webuijsf:script id="script2" type="text/JavaScript" url="/resources/js/yui/build/yahoo-dom-event/yahoo-dom-event.js"/>
                    <webuijsf:script id="script3" type="text/JavaScript" url="/resources/js/yui/build/treeview/treeview-min.js"/>
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
                    <div id="pageFormated">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <h:outputLabel id="lbTitle" style="height: 24px; left: 24px; position: relative; width: 850px" styleClass="Page_title" value="#{resources.title_indicator}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; position: relative" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 50px; width: 840px" warnClass="warnMessage"/>
                               <h:panelGrid columns="4" id="grouppBotoneraIndicator" style="height: 24px" width="540">
                                    <h:commandButton action="#{indicator$ListIndicator.btnNewIndicator_action}" id="btnNewIndicator"
                                        style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.btnNew}"/>
                                    <h:commandButton action="#{indicator$ListIndicator.btnEditIndicator_action}" id="btnEditIndicator"
                                        style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.btnEdit}"/>
                                    <h:commandButton action="#{indicator$ListIndicator.btnDeleteIndicator_action}" id="btnDeleteIndicator"
                                        style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.btnDelete}"/>
                               </h:panelGrid>
                                <h:panelGrid binding="#{indicator$ListIndicator.gridIndicator}" columns="2" id="gridIndicator" style="height: 24px" width="540">
                                    <div id="tree" style="width:100%; float:left; " title="Indicators Tree "></div>
                                    <h:panelGrid binding="#{indicator$ListIndicator.indicator}" columns="1" id="indicator">                                                                               
                                        <h:inputHidden binding="#{indicator$ListIndicator.hiddenNodeId}" id="hiddenNodeId"/>
                                        <h:inputHidden binding="#{indicator$ListIndicator.hiddenPathNode}" id="hiddenPathNode"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                    
                            </h:panelGrid>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/Footer.jspf"/>
                    </div> <!-- pageFormated ends -->
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
