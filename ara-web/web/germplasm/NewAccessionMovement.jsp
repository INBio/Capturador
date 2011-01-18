<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : NewAccessionMovement
    Created on : 11/03/2010, 03:18:20 PM
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
                    <div id="pageFormated">
                        <jsp:directive.include file="/Header.jspf"/>
                        <webuijsf:panelLayout id="contenido">
                            <webuijsf:form id="form1">
                                <webuijsf:label binding="#{germplasm$NewAccessionMovement.lbTitle}" id="lbTitle"
                                    style="height: 24px; left: 24px; position: relative; width: 850px" styleClass="Page_title" text="#{resources.new_accession_movement}"/>
                                <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; position: relative" width="850">
                                    <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                        style="height: 50px; width: 840px" warnClass="warnMessage"/>
                                    <!-- save button -->
                                    <webuijsf:panelGroup id="grouppBotoneraPassport" style="height: 24px; width: 840px">
                                        <h:commandButton action="#{germplasm$NewAccessionMovement.saveAccessionMovement_button_action}" id="savePassportButton"
                                            style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.save_accession_movement}"/>
                                    </webuijsf:panelGroup>
                                    <h:panelGrid columns="2" id="movement" styleClass="My_panel_blue" width="500">
                                        <webuijsf:label id="labelWeight" style="width: 168px; height: 26px" text="#{resources.weight}"/>
                                        <webuijsf:textField columns="28" id="textFieldWeigh" required="true" style="width: 200px;" text="#{germplasm$AccessionMovementSessionBean.accessionMovementDTO.weight}">
                                            <f:validateLongRange minimum="0"/>
                                        </webuijsf:textField>
                                        <webuijsf:label id="labelAccessionMovementType" style="width: 168px; height: 24px" text="#{resources.accession_movement_type}"/>
                                        <webuijsf:dropDown id="dropdownAccessionMovementType"
                                            items="#{germplasm$NewAccessionMovement.accessionMovementType.options}" required="true"
                                            selected="#{germplasm$AccessionMovementSessionBean.accessionMovementDTO.accessionMovementTypeId}" width="200px"/>
                                        <webuijsf:label id="labelResponsablePerson" style="width: 168px; height: 24px" text="#{resources.responsable_person}"/>
                                        <webuijsf:dropDown id="dropdownResponsablePerson" items="#{germplasm$NewAccessionMovement.responsablePerson.options}"
                                            required="true" selected="#{germplasm$AccessionMovementSessionBean.accessionMovementDTO.responsablePersonId}" width="200px"/>
                                        <webuijsf:label id="labelNotes" style="width: 168px; height: 24px" text="#{resources.notes}"/>
                                        <webuijsf:textArea columns="25" id="textAreaNotes" text="#{germplasm$AccessionMovementSessionBean.accessionMovementDTO.notes}"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                            </webuijsf:form>
                        </webuijsf:panelLayout> <!-- contenido ends -->
                        <jsp:directive.include file="/Footer.jspf"/>
                    </div> <!-- pageFormated ends -->
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
