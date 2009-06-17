<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page">
            <webuijsf:html id="html">
                <webuijsf:head id="head">
                    <webuijsf:link id="link" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script id="script" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <webuijsf:tabSet id="userTabSet1" style="border: 1px solid gray; height: 238px; left: 48px; top: 48px; position: absolute; width: 598px">
                                <webuijsf:tab id="userTab1" text="#{resources.change_password}">
                                    <webuijsf:panelLayout id="layoutPanel" style="height: 203px; position: relative; width: 597px; -rave-layout: grid">
                                        <webuijsf:staticText id="Label"
                                            style="color: rgb(0, 51, 153); font-family: 'Arial','Helvetica',sans-serif; font-size: 22px; font-style: normal; height: 22px; left: 48px; top: 24px; position: absolute; width: 286px" text="#{resources.change_password}"/>
                                        <webuijsf:staticText id="fullNameLabel" style="left: 72px; top: 72px; position: absolute; font-weight: bold;" text="#{resources.full_name}"/>
                                        <webuijsf:textField binding="#{user$ChangePassword.fullNameTextField}" disabled="true" id="txt_fullName" label=" " style="left: 220px; top: 72px; position: absolute"/>
                                        <webuijsf:staticText id="userNameLabel" style="left: 72px; top: 96px; position: absolute; font-weight: bold;" text="#{resources.username}"/>
                                        <webuijsf:textField binding="#{user$ChangePassword.userNameTextField}" disabled="true" id="txt_userName" label=" " style="left: 220px; top: 96px; position: absolute"/>
                                        <webuijsf:staticText id="currentPasswordLabel" style="left: 72px; top: 120px; position: absolute; font-weight: bold;" text="#{resources.actual_password}"/>
                                        <webuijsf:passwordField binding="#{user$ChangePassword.currentPasswordTextField}" id="currentPasswordTextField"
                                            label=" " style="left: 220px; top: 120px; position: absolute"/>
                                        <webuijsf:staticText id="newPasswordLabel" style="left: 72px; top: 144px; position: absolute; font-weight: bold;" text="#{resources.new_password}"/>
                                        <webuijsf:passwordField binding="#{user$ChangePassword.newPasswordTextField}" id="newPasswordTextField" label=" " style="left: 220px; top: 144px; position: absolute"/>
                                        <webuijsf:staticText id="confirmNewPasswordLabel" style="left: 72px; top: 168px; position: absolute; font-weight: bold;" text="#{resources.confirm_new_password}"/>
                                        <webuijsf:passwordField binding="#{user$ChangePassword.confirmNewPasswordTextField}" id="confirmNewPasswordTextField"
                                            label=" " style="left: 220px; top: 168px; position: absolute"/>
                                        <webuijsf:message for="currentPasswordTextField" id="message1" showDetail="false" showSummary="true" style="left: 336px; top: 72px; position: absolute"/>
                                        <webuijsf:message for="newPasswordTextField" id="message2" showDetail="false" showSummary="true" style="left: 336px; top: 120px; position: absolute"/>
                                        <webuijsf:alert binding="#{user$ChangePassword.userAlert1}" id="userAlert1" style="height: 22px; left: 408px; top: 24px; position: absolute; text-align: justify; width: 286px"/>
                                        <webuijsf:button actionExpression="#{user$ChangePassword.saveAction}" id="btn_save"
                                            style="height: 24px; left: 479px; top: 216px; position: absolute; width: 120px" text="#{resources.change}"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                            </webuijsf:tabSet>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <!--<jsp:directive.include file="/footer.jspf"/>-->
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
