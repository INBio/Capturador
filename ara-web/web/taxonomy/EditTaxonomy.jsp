<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : EditTaxonomy
    Created on : 17/11/2009, 09:53:45 AM
    Author     : asanabria
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link id="link1" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <!-- main panel -->
                    <webuijsf:panelLayout id="contenido">
                        <!-- title-->
                        <webuijsf:label id="lbTaxonomyTitle" styleClass="Page_title" text="#{resources.menuSubsystemTaxonomy}"/>
                        <!-- General message board -->
                        <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msgMessageBoard" infoClass="infoMessage" warnClass="warnMessage"/>
                        <!-- Data form -->
                        <webuijsf:form id="form1">
                            <h:panelGrid columns="2" id="gridpMain">
                                <!-- taxonomical hierarchy tree -->
                                <h:panelGrid cellspacing="1" columns="1" id="gridpHierarchyTree">
                                    <webuijsf:tree binding="#{taxonomy$EditTaxonomy.displayTree}" expandOnSelect="true" id="displayTree"
                                        style="height: 118px; width: 502px" text="#{resources.taxonomy_hierarchy}"/>
                                </h:panelGrid>
                                <h:panelGrid cellspacing="1" columns="2" id="gridpDataFrom">
                                    <!-- taxon name -->
                                    <webuijsf:label id="lbTaxonName" text="#{resources.taxon_name}"/>
                                    <webuijsf:textField columns="26" id="tfTaxonName" text="#{taxonomy$TaxonomySessionBean.taxonName}"/>
                                    <!-- hierarchy level -->
                                    <webuijsf:label id="lbTaxonomicalLevel" text="#{resources.taxonomic_level}"/>
                                    <webuijsf:staticText id="stTaxonomicalLevel" text="#{taxonomy$TaxonomySessionBean.taxonomicalLevel}"/>
                                    <!-- collection -->
                                    <webuijsf:label id="lbCollection" text="#{resources.collection}"/>
                                    <webuijsf:dropDown id="ddCollectionsList" items="#{taxonomy$TaxonomySessionBean.availableCollections}"
                                        selected="#{taxonomy$TaxonomySessionBean.selectedCollection}" width="200px"/>
                                    <!-- actions buttons -->
                                    <h:commandButton action="#{taxonomy$EditTaxonomy.btnAddAction}" disabled="false" id="btnAddTaxon" styleClass="My_Button" value="#{resources.btnNew}"/>
                                    <h:commandButton action="#{taxonomy$EditTaxonomy.btnDeleteAction}" disabled="false" id="btnDeleteTaxon"
                                        styleClass="My_Button" value="#{resources.btnDelete}"/>
                                    <h:commandButton action="#{taxonomy$EditTaxonomy.btnUpdateAction}" disabled="false" id="btnUpdateTaxon"
                                        styleClass="My_Button" value="#{resources.btnUpdate}"/>
                                </h:panelGrid>
                            </h:panelGrid>
                        </webuijsf:form>
                        <jsp:directive.include file="/Footer.jspf"/>
                    </webuijsf:panelLayout>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
