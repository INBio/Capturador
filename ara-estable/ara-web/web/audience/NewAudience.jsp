<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{audience$NewAudience.page1}" id="page1">
            <webuijsf:html binding="#{audience$NewAudience.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{audience$NewAudience.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{audience$NewAudience.form1}" id="form1">
                            <webuijsf:staticText binding="#{audience$NewAudience.staticText1}" id="staticText1"
                                style="color: rgb(0, 51, 153); font-family: 'Arial','Helvetica',sans-serif; font-size: 24px; font-style: normal; left: 48px; top: 24px; position: absolute; width: 406px" text="#{resources.new_audience}"/>
                            <webuijsf:tabSet binding="#{audience$NewAudience.tabSet}" id="tabSet" selected="basicInfoTab" style="border: 1px solid gray; height: 214px; left: 48px; top: 72px; position: absolute; width: 766px">
                                <webuijsf:tab actionExpression="#{audience$NewAudience.basicInfoTab_action}" binding="#{audience$NewAudience.basicInfoTab}"
                                    id="basicInfoTab" text="#{resources.basic_information}">
                                    <webuijsf:panelLayout binding="#{audience$NewAudience.layoutPanel1}" id="layoutPanel1" style="height: 177px; position: relative; width: 100%; -rave-layout: grid">
                                        <webuijsf:textField binding="#{audience$NewAudience.txt_name}" id="txt_name" style="left: 96px; top: 72px; position: absolute; width: 240px"/>
                                        <webuijsf:label binding="#{audience$NewAudience.label1}" id="label1" style="left: 24px; top: 96px; position: absolute" text="#{resources.description}"/>
                                        <webuijsf:label binding="#{audience$NewAudience.label2}" id="label2" style="left: 24px; top: 72px; position: absolute" text="#{resources.name}"/>
                                        <webuijsf:textArea binding="#{audience$NewAudience.txt_description}" id="txt_description" style="height: 45px; left: 96px; top: 96px; position: absolute; width: 240px"/>
										<webuijsf:button actionExpression="#{audience$NewAudience.btn_save_action}" binding="#{audience$NewAudience.btn_save}" id="btn_save"
                                style="height: 24px; left: 71px; top: 312px; position: absolute; width: 72px" text="#{resources.btnSave}"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                            </webuijsf:tabSet>
                            
                            <h:messages binding="#{audience$NewAudience.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1"
                                infoClass="infoMessage" style="left: 480px; top: 24px; position: absolute" warnClass="warnMessage"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
