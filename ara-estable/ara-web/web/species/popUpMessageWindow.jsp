<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{species$popUpMessageWindow.page1}" id="page1">
            <webuijsf:html binding="#{species$popUpMessageWindow.html1}" id="html1">
                <webuijsf:head binding="#{species$popUpMessageWindow.head1}" id="head1">
                    <webuijsf:link binding="#{species$popUpMessageWindow.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{species$popUpMessageWindow.body1}" id="body1" onLoad="window.close();" style="-rave-layout: grid">
                    <webuijsf:form binding="#{species$popUpMessageWindow.form1}" id="form1">
                        <h:messages binding="#{species$popUpMessageWindow.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1"
                            infoClass="infoMessage" style="left: 360px; top: 48px; position: absolute" warnClass="warnMessage"/>
                        <webuijsf:button actionExpression="#{species$popUpMessageWindow.btn_closeWindow_action}"
                            binding="#{species$popUpMessageWindow.btn_closeWindow}" id="btn_closeWindow" onClick="window.close();"
                            style="left: 167px; top: 96px; position: absolute; width: 100px" text="#{resources.close_window}" visible="false"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
