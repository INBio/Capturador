<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : NewPerson
    Created on : 05/10/2010, 11:59:34 AM
    Author     : gsulca
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
                                <h:outputLabel id="lbTitle" style="height: 24px; left: 24px; position: relative; width: 850px" styleClass="Page_title" value="#{resources.editProject}"/>
                                <h:panelGrid columns="1" id="gridpMain" style="left: 24px; position: relative" width="650">
                                    <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                        style="height: 50px; width: 650px" warnClass="warnMessage"/>
                                    <webuijsf:panelGroup id="grouppBotonera" style="height: 24px; width: 650px">
                                             <h:commandButton action="#{admin$EditProject.btnUpdateProject_action}" id="btnUpdatePerson" style="height: 24px; width: 175px"
                                            styleClass="My_Button" value="#{resources.update}"/>
                                    </webuijsf:panelGroup>                                     
                                            <webuijsf:panelLayout id="lpPersonal" style="height: 180px; position: relative; width: 100%; -rave-layout: grid" styleClass="My_subpanel_blue">
                                                <!--
                                                <webuijsf:label for="txName" id="lbName" 
                                                    style="height: 24px; left: 24px; top: 24px; position: absolute; width: 192px" text="#{resources.name}"/>
                                                -->
                                                <webuijsf:label for="txDescription" id="lbDescription" requiredIndicator="true"
                                                                style="height: 24px; left: 24px; top: 48px; position: absolute; width: 192px" text="#{resources.description}"/>
                                                <webuijsf:label for="txProjectManager" id="lbProjectManager" requiredIndicator="true"
                                                                style="height: 24px; left: 24px; top: 85px; position: absolute; width: 192px" text="#{resources.projectManager}"/>
                                                <webuijsf:label for="txBirthDate" id="lbInitialDate"
                                                                style="height: 24px; left: 24px; top: 109px; position: absolute; width: 192px" text="#{resources.initial_date}"/>
                                                <webuijsf:label for="txDeathDate" id="lbFinalDate" 
                                                                style="height: 24px; left: 24px; top: 133px; position: absolute; width: 192px" text="#{resources.final_date}"/>
                                               
                                                <webuijsf:textArea binding="#{admin$EditProject.txDescription}"  columns="24" id="tx1lastName" required="true"
                                                    style="height: 24px; left: 198px; top: 48px; position: absolute; width: 192px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                                <webuijsf:textField binding="#{admin$EditProject.txProjectManager}" columns="25" id="tx2lastName" required="true"
                                                    style="height: 24px; left: 198px; top: 85px; position: absolute; width: 192px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                              
                                                <webuijsf:calendar binding="#{admin$EditProject.initial_date}" columns="25" dateFormatPattern="yyyy-MM-dd"
                                            id="calInitialDate"  style="height: 24px; left: 190px; top: 109px; position: absolute; width: 192px"/>
                                              
                                                <webuijsf:calendar binding="#{admin$EditProject.final_date}" columns="25" dateFormatPattern="yyyy-MM-dd"
                                            id="calFinalDate"  style="height: 24px; left: 190px; top: 133px; position: absolute; width: 192px"/>
                                            </webuijsf:panelLayout>
                                                                                        
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
