<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{references$NewReference.page1}" id="page1">
            <webuijsf:html binding="#{references$NewReference.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{references$NewReference.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{references$NewReference.form1}" id="form1">
                            <webuijsf:label binding="#{references$NewReference.label1}" id="label1"
                                style="font-size: 24px; left: 48px; top: 24px; position: absolute; width: 334px" text="#{resources.new_reference}"/>
                            <h:messages binding="#{references$NewReference.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1"
                                infoClass="infoMessage" style="left: 408px; top: 24px; position: absolute" warnClass="warnMessage"/>
                            <webuijsf:label binding="#{references$NewReference.label2}" id="label2" style="left: 48px; top: 72px; position: absolute" text="#{resources.title}"/>
                            <webuijsf:textField binding="#{references$NewReference.txt_title}" id="txt_title" label="" maxLength="500" required="true" style="left: 168px; top: 72px; position: absolute; width: 360px"/>
                            <webuijsf:label binding="#{references$NewReference.label3}" id="label3" style="left: 48px; top: 96px; position: absolute" text="#{resources.description}"/>
                            <webuijsf:textArea binding="#{references$NewReference.txt_description}" id="txt_description" label="" required="true" style="height: 72px; left: 168px; top: 96px; position: absolute; width: 360px"/>
                            <webuijsf:label binding="#{references$NewReference.label4}" id="label4" style="left: 48px; top: 192px; position: absolute" text="#{resources.badge}"/>
                            <webuijsf:textField binding="#{references$NewReference.txt_identifier}" id="txt_identifier" label="" required="true" style="left: 168px; top: 192px; position: absolute; width: 360px"/>
                            <webuijsf:label binding="#{references$NewReference.label5}" id="label5" style="left: 48px; top: 216px; position: absolute" text="#{resources.publication_date}"/>
                            <webuijsf:label binding="#{references$NewReference.label6}" id="label6" style="left: 48px; top: 240px; position: absolute" text="#{resources.language}"/>
                            <webuijsf:dropDown binding="#{references$NewReference.dd_language}" converter="#{references$NewReference.longConverter1}"
                                id="dd_language" items="#{references$NewReference.languageOptions}" label="" required="true" style="left: 168px; top: 240px; position: absolute"/>
                            <webuijsf:label binding="#{references$NewReference.label7}" id="label7" style="left: 48px; top: 264px; position: absolute" text="#{resources.type}"/>
                            <webuijsf:dropDown binding="#{references$NewReference.dd_referenceType}" converter="#{references$NewReference.longConverter1}"
                                id="dd_referenceType" items="#{references$NewReference.referenceTypeOptions}" label="" required="true" style="left: 168px; top: 264px; position: absolute"/>
                            <webuijsf:button actionExpression="#{references$NewReference.btn_save_action}" binding="#{references$NewReference.btn_save}"
                                id="btn_save" style="height: 23px; left: 47px; top: 312px; position: absolute; width: 70px" text="#{resources.btnSave}"/>
                            <webuijsf:calendar binding="#{references$NewReference.cldr_publicationDate}" dateFormatPattern="dd/MM/yyyy"
                                id="cldr_publicationDate" style="left: 168px; top: 216px; position: absolute"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
