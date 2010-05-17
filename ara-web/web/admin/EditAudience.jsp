<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : EditAudience
    Created on : 05/10/2009, 10:30:23 AM
    Author     : esmata
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link2" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <webuijsf:label id="lbTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px" styleClass="Page_title" text="#{resources.title_audience_edit}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 30px; width: 840px" warnClass="warnMessage"/>
                                <webuijsf:panelGroup id="grouppBotonera" style="height: 24px; width: 840px">
                                    <h:commandButton action="#{admin$EditAudience.btnUpdateAudience_action}" id="btnUpdateAudience"
                                        style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.update}"/>
                                </webuijsf:panelGroup>
                                <webuijsf:panelLayout id="layoutPanel1" style="height: 116px; position: relative; width: 431px; -rave-layout: grid" styleClass="My_panel_blue">
                                    <webuijsf:label for="txName" id="lbName" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 168px" text="#{resources.name}"/>
                                    <webuijsf:label for="txaDescription" id="lbDescription"
                                        style="height: 24px; left: 24px; top: 48px; position: absolute; width: 168px" text="#{resources.description}"/>
                                    <webuijsf:textField binding="#{admin$EditAudience.txName}" columns="29" id="txName" required="true"
                                        style="height: 24px; left: 192px; top: 24px; position: absolute; width: 192px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                    <webuijsf:textArea binding="#{admin$EditAudience.txaDescription}" columns="27" id="txaDescription" required="true"
                                        style="height: 24px; left: 192px; top: 48px; position: absolute; width: 192px" validatorExpression="#{util$ValidatorBean.validateInputStringGeneric}"/>
                                </webuijsf:panelLayout>
                                <jsp:directive.include file="/Footer.jspf"/>
                            </h:panelGrid>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
