<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : ListTaxonomy
    Created on : 19/07/2010, 04:44:48 PM
    Author     : gsulca
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <jsp:directive.page import="org.inbio.ara.taxonomy.TaxonTreeController"/>
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
                    <webuijsf:script id="script4" type="text/JavaScript" url="/resources/js/inbio/Tree/TreeTaxonomyEvent.js"/>
                    <webuijsf:script id="script5" type="text/JavaScript" url="/resources/js/inbio/SOAP/SOAPClient.js"/>
                    <webuijsf:script id="script6" type="text/JavaScript" url="/resources/js/inbio/Tree/ClickTaxonomyEvent.js"/>
                    <jsp:scriptlet>
                        TaxonTreeController treeController = new TaxonTreeController();
                        String treeScript = treeController.getTreeScript();
                        out.write(treeScript);
                    </jsp:scriptlet>
                </webuijsf:head>
                <webuijsf:body id="body1" onLoad="initTaxonomy()" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <webuijsf:label id="lbTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px" styleClass="Page_title" text="#{resources.taxon}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 50px; width: 840px" warnClass="warnMessage"/>
                                <h:panelGrid columns="4" id="grouppBotoneraIndicator" style="height: 24px" width="540">
                                    <h:commandButton action="#{taxonomy$ListTaxonomy.btnNewIndicator_action}" id="btnNewIndicator"
                                        style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.btnNew}"/>
                                    <h:commandButton action="#{taxonomy$ListTaxonomy.btnEditIndicator_action}" id="btnEditIndicator"
                                        style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.btnEdit}"/>
                                    <h:commandButton action="#{taxonomy$ListTaxonomy.btnDeleteIndicator_action}" id="btnDeleteIndicator"
                                        style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.btnDelete}"/>
                                </h:panelGrid>
                                <h:panelGrid binding="#{taxonomy$ListTaxonomy.gridIndicator}" columns="2" id="gridIndicator" style="height: 24px" width="540">
                                    <div id="tree" style="width:200px; float:left; " title="Indicators Tree "></div>
                                    <h:panelGrid binding="#{taxonomy$ListTaxonomy.indicator}" columns="1" id="indicator">
                                        <h:inputHidden binding="#{taxonomy$ListTaxonomy.hiddenTaxonNodeId}" id="hiddenTaxonNodeId"/>
                                        <h:inputHidden binding="#{taxonomy$ListTaxonomy.hiddenPathTaxonNode}" id="hiddenPathTaxonNode"/>
                                        <h:inputHidden binding="#{taxonomy$ListTaxonomy.hiddenCollecNomenclGroupId}" id="hiddenCollecNomenclGroupId"/>
                                        <h:inputHidden binding="#{taxonomy$ListTaxonomy.hiddenTypeGroup}" id="hiddenTypeGroup"/>
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
