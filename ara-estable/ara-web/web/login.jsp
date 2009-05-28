<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{login.page1}" id="page1">
            <webuijsf:html binding="#{login.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{login.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header_Login.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <h:messages binding="#{login.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1"
                                                infoClass="infoMessage" warnClass="warnMessage"/>
                        <table align="center" style="margin-top: 50px;" width="60%">
                            <thead></thead>
                            <tbody>
                                <tr>
                                    <th>
                                        <webuijsf:label binding="#{login.lb_title}" id="lb_title" text="#{resources.enter_system}"/>
                                    </th>
                                </tr>
                                <tr>
                                    <td align="CENTER">
                                        <webuijsf:form binding="#{login.form1}" id="form1" style="border-style: solid; border-color: rgb(216, 241, 139); text-align: center; vertical-align: middle; width: 258px">
                                            <h:panelGrid columns="1" id="gridPanel1">
                                                <webuijsf:label id="label1" text="#{resources.username}"/>
                                                <webuijsf:textField binding="#{login.txt_userName}" id="txt_userName" label="" maxLength="20" required="true"/>
                                                <webuijsf:label id="label2" text="#{resources.password}"/>
                                                <webuijsf:passwordField binding="#{login.txt_password}" id="txt_password" label="" required="true" valueChangeListenerExpression="#{login.txt_password_processValueChange}"/>
                                                <webuijsf:button id="btn_login" text="#{resources.enter}"/>
                                            </h:panelGrid>
                                        </webuijsf:form>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
