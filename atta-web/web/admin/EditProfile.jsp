<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : EditProfile
    Created on : 06/10/2009, 08:37:03 AM
    Author     : esmata
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
                                <h:outputLabel id="lbTitle" style="height: 24px; left: 24px; position: relative; width: 850px" styleClass="Page_title" value="#{resources.title_profiles_edit}"/>
                                <h:panelGrid columns="1" id="gridpMain" style="left: 24px; position: relative" width="850">
                                    <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                        style="height: 30px; width: 840px" warnClass="warnMessage"/>
                                    <webuijsf:panelGroup id="grouppBotonera" style="height: 24px; width: 840px">
                                        <h:commandButton action="#{admin$EditProfile.btnUpdateProfile_action}" id="btnUpdateProfile"
                                            style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.update}"/>
                                    </webuijsf:panelGroup>
                                    <webuijsf:panelLayout id="layoutPanel1" style="height: 116px; position: relative; width: 800px; -rave-layout: grid" styleClass="My_panel_blue">
                                        <webuijsf:label for="txName" id="lbName" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 168px" text="#{resources.name}"/>
                                        <webuijsf:label for="txaDescription" id="lbDescription"
                                            style="height: 24px; left: 24px; top: 48px; position: absolute; width: 168px" text="#{resources.description}"/>
                                        <webuijsf:textField binding="#{admin$EditProfile.txName}" columns="55" id="txName" required="true"
                                            style="height: 24px; left: 192px; top: 24px; position: absolute; width: 192px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                        <webuijsf:textArea binding="#{admin$EditProfile.txaDescription}" columns="53" id="txaDescription" required="true"
                                            style="height: 24px; left: 192px; top: 48px; position: absolute; width: 192px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
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
