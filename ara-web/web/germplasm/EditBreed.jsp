<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : EditBreed
    Created on : 08/04/2010, 09:28:47 AM
    Author     : dasolano
-->

<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link id="link2" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <webuijsf:label binding="#{germplasm$EditBreed.lbTitle}" id="lbTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px" styleClass="Page_title" text="#{resources.edit_breed}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 50px; width: 840px" warnClass="warnMessage"/>

                                <!-- save button -->
                                <webuijsf:panelGroup id="grouppBotoneraPassport" style="height: 24px; width: 840px">
                                    <h:commandButton  id="saveBreedButton"
                                                      action="#{germplasm$EditBreed.updateBreed}"
                                        style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.update_breed}"/>
                                </webuijsf:panelGroup>
                                <h:panelGrid id="content" columns="2" style="position:absoulte">
                                    <webuijsf:label id="labelTaxonName" style="width: 168px; height: 24px" text="#{resources.taxon_name}"/>
                                    <webuijsf:dropDown id="dropdownTaxonName"  width="200px" required="true"
                                                       items="#{germplasm$EditBreed.scientificName.options}"
                                                       selected="#{germplasm$BreedSessionBean.breedDTO.taxonId}"/>

                                    <webuijsf:label id="labelBreed" style="width: 168px; height: 24px" text="#{resources.breed}"/>
                                    <webuijsf:textField required="true" columns="27" id="textFieldBreed" style="width: 200px;" text="#{germplasm$BreedSessionBean.breedDTO.name}"/>

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
