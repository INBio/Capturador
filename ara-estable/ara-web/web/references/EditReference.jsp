<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{references$EditReference.page1}" id="page1">
            <webuijsf:html binding="#{references$EditReference.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{references$EditReference.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{references$EditReference.form1}" id="form1">
							|
							<webuijsf:textField
                                binding="#{references$EditReference.txt_title}" id="txt_title" label="" required="true" style="left: 168px; top: 96px; position: absolute; width: 360px"/>
                            <webuijsf:label binding="#{references$EditReference.label1}" id="label1" style="left: 48px; top: 120px; position: absolute" text="#{resources.description}"/>
                            <webuijsf:label binding="#{references$EditReference.label2}" id="label2" style="left: 48px; top: 192px; position: absolute" text="#{resources.badge}"/>
                            <webuijsf:label binding="#{references$EditReference.label3}" id="label3" style="left: 48px; top: 264px; position: absolute" text="#{resources.type}"/>
                            <webuijsf:label binding="#{references$EditReference.label4}" id="label4" style="left: 48px; top: 96px; position: absolute" text="#{resources.title}"/>
                            <webuijsf:dropDown binding="#{references$EditReference.dd_language}" converter="#{references$EditReference.longConverter1}"
                                id="dd_language" items="#{references$ReferenceSessionBean.languageOptions}" label="" required="true"
                                selected="#{references$ReferenceSessionBean.selectedLanguage}" style="left: 168px; top: 240px; position: absolute"/>
                            <h:messages binding="#{references$EditReference.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1"
                                infoClass="infoMessage" style="left: 432px; top: 24px; position: absolute" warnClass="warnMessage"/>
                            <webuijsf:label binding="#{references$EditReference.label5}" id="label5" style="left: 48px; top: 216px; position: absolute" text="#{resources.publication_date}"/>
                            <webuijsf:button actionExpression="#{references$EditReference.btn_save_action}" binding="#{references$EditReference.btn_save}"
                                id="btn_save" style="height: 24px; left: 359px; top: 240px; position: absolute; width: 70px" text="#{resources.btnSave}"/>
                            <webuijsf:textField binding="#{references$EditReference.txt_identifier}" id="txt_identifier" label="" required="true" style="left: 168px; top: 192px; position: absolute; width: 360px"/>
                            <webuijsf:calendar binding="#{references$EditReference.cldr_publicationDate}" dateFormatPattern="dd/MM/yyyy" maxDate="#{ApplicationBean1.todayDate}" minDate="#{ApplicationBean1.minDate}"
                                id="cldr_publicationDate" style="left: 168px; top: 216px; position: absolute"/>
                            <webuijsf:dropDown binding="#{references$EditReference.dd_referenceType}" converter="#{references$EditReference.longConverter1}"
                                id="dd_referenceType" items="#{references$ReferenceSessionBean.referenceTypeOptions}" label="" required="true"
                                selected="#{references$ReferenceSessionBean.selectedReferenceType}" style="left: 168px; top: 264px; position: absolute"/>
                            <webuijsf:label binding="#{references$EditReference.label6}" id="label6"
                                style="font-size: 24px; left: 48px; top: 24px; position: absolute; width: 358px" text="#{resources.edit_reference}"/>
                            <webuijsf:textArea binding="#{references$EditReference.txt_description}" id="txt_description" label="" required="true" style="height: 72px; left: 168px; top: 120px; position: absolute; width: 360px"/>
                            <webuijsf:label binding="#{references$EditReference.label7}" id="label7" style="left: 48px; top: 240px; position: absolute" text="#{resources.language}"/>
                            <webuijsf:label binding="#{references$EditReference.label8}" id="label8" style="left: 48px; top: 72px; position: absolute" text="#{resources.id}"/>
                            <webuijsf:staticText binding="#{references$EditReference.st_referenceId}" id="st_referenceId" style="left: 168px; top: 72px; position: absolute"/>
                            <webuijsf:tree binding="#{references$EditReference.tree1}" clientSide="true" id="tree1" immediate="true"
                                style="border: 1px solid gray; left: 48px; top: 312px; position: absolute; width: 262px" text="#{resources.another_data}"/>
                            <webuijsf:textArea binding="#{references$EditReference.txt_data}" id="txt_data"
                                style="height: 216px; left: 336px; top: 312px; position: absolute; width: 360px" valueChangeListenerExpression="#{references$EditReference.txt_data_processValueChange}"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>

                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
