<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{audience$EditAudience.page1}" id="page1">
            <webuijsf:html binding="#{audience$EditAudience.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{audience$EditAudience.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{audience$EditAudience.form1}" id="form1">
                            <webuijsf:button actionExpression="#{audience$EditAudience.btn_save_action}" binding="#{audience$EditAudience.btn_save}"
                                id="btn_save" style="height: 30px; left: 95px; top: 288px; position: absolute; width: 60px" text="#{resources.btnSave}"/>
                            <webuijsf:tabSet binding="#{audience$EditAudience.tabSet1}" id="tabSet1" selected="basicInfoTab" style="border: 1px solid gray; height: 193px; left: 48px; top: 72px; position: absolute; width: 758px">
                                <webuijsf:tab actionExpression="#{audience$EditAudience.basicInfoTab_action}" binding="#{audience$EditAudience.basicInfoTab}"
                                    id="basicInfoTab" text="#{resources.basic_information}">
                                    <webuijsf:panelLayout binding="#{audience$EditAudience.layoutPanel2}" id="layoutPanel2" style="height: 156px; position: relative; width: 100%; -rave-layout: grid">
                                        <webuijsf:textField binding="#{audience$EditAudience.txt_name}" id="txt_name" style="left: 96px; top: 48px; position: absolute; width: 240px"/>
                                        <webuijsf:textArea binding="#{audience$EditAudience.txt_description}" id="txt_description" style="height: 45px; left: 96px; top: 72px; position: absolute; width: 240px"/>
                                        <webuijsf:label binding="#{audience$EditAudience.label1}" id="label1" style="left: 24px; top: 48px; position: absolute" text="#{resources.name}"/>
                                        <webuijsf:label binding="#{audience$EditAudience.label2}" id="label2" style="left: 24px; top: 72px; position: absolute" text="#{resources.description}"/>
                                        <webuijsf:label binding="#{audience$EditAudience.label3}" id="label3" style="left: 24px; top: 24px; position: absolute" text="#{resources.id}"/>
                                        <webuijsf:staticText binding="#{audience$EditAudience.st_id}" id="st_id" style="left: 96px; top: 24px; position: absolute"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                            </webuijsf:tabSet>
                            <webuijsf:label binding="#{audience$EditAudience.label4}" id="label4"
                                style="font-size: 24px; height: 28px; left: 48px; top: 24px; position: absolute; width: 358px" text="#{resources.edit_audience}"/>
                            <h:messages binding="#{audience$EditAudience.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1"
                                infoClass="infoMessage" style="left: 432px; top: 24px; position: absolute" warnClass="warnMessage"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>

                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
