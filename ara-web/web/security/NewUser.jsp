<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : NewUser
    Created on : 23/09/2009, 05:18:45 PM
    Author     : esmata
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link id="link1" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <div id="pageFormated">
                        <jsp:directive.include file="/Header.jspf"/>
                        <webuijsf:panelLayout id="contenido">
                            <webuijsf:form id="form1">
                                <h:outputLabel id="lbNewTitle" style="height: 24px; left: 24px; position: relative; width: 850px" styleClass="Page_title" value="#{resources.new_user}"/>
                                <h:panelGrid columns="1" id="gridpGenerationMain" style="height: 24px; left: 24px; position: relative" width="768">
                                    <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglNew" infoClass="infoMessage"
                                        style="height: 50px; width: 750px" warnClass="warnMessage"/>
                                    <webuijsf:panelGroup id="grouppBotonera" style="height: 24px; width: 750px">
                                        <h:commandButton action="#{security$NewUser.btnSaveUser_action}" id="btnSaveUser" style="height: 24px; width: 175px"
                                            styleClass="My_Button" value="#{resources.btnSave}"/>
                                    </webuijsf:panelGroup>
                                    <webuijsf:panelLayout id="layoutPanelDetail" style="height: 128px; position: relative; width: 883px; -rave-layout: grid" styleClass="My_panel_blue">
                                        <webuijsf:label for="txFullName" id="lbFullName"
                                            style="height: 24px; left: 24px; top: 24px; position: absolute; width: 168px" text="#{resources.full_name}"/>
                                        <webuijsf:textField binding="#{security$NewUser.txFullName}" columns="24" id="txFullName" required="true"
                                            style="height: 24px; left: 192px; top: 24px; position: absolute; width: 168px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                        <webuijsf:label for="txUserName" id="lbUserName"
                                            style="height: 24px; left: 24px; top: 72px; position: absolute; width: 168px" text="#{resources.username}"/>
                                        <webuijsf:textField binding="#{security$NewUser.txUserName}" columns="24" id="txUserName" required="true"
                                            style="height: 24px; left: 192px; top: 72px; position: absolute; width: 168px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                        <webuijsf:label for="pfPassword" id="lbPassword"
                                            style="height: 24px; left: 432px; top: 24px; position: absolute; width: 168px" text="#{resources.password}"/>
                                        <webuijsf:passwordField binding="#{security$NewUser.pfPassword}" columns="24" id="pfPassword" required="true"
                                            style="height: 24px; left: 600px; top: 24px; position: absolute; width: 144px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}">
                                            <f:validateLength maximum="8" minimum="4"/>
                                        </webuijsf:passwordField>
                                        <webuijsf:label for="pfConfirmPass" id="lbConfirmPass"
                                            style="height: 24px; left: 432px; top: 72px; position: absolute; width: 168px" text="#{resources.confirm_new_password}"/>
                                        <webuijsf:passwordField binding="#{security$NewUser.pfConfirmPass}" columns="24" id="pfConfirmPass" required="true"
                                            style="height: 24px; left: 600px; top: 72px; position: absolute; width: 144px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}">
                                            <f:validateLength maximum="8" minimum="4"/>
                                        </webuijsf:passwordField>
                                    </webuijsf:panelLayout>
                                </h:panelGrid>
                            </webuijsf:form>
                        </webuijsf:panelLayout>
                        <!-- contenido ends -->
                        <jsp:directive.include file="/Footer.jspf"/>
                    </div>
                    <!-- pageFormated ends -->
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
