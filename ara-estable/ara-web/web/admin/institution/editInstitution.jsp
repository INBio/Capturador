<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{admin$institution$editInstitution.page1}" id="page1">
            <webuijsf:html binding="#{admin$institution$editInstitution.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{admin$institution$editInstitution.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{admin$institution$editInstitution.form1}" id="form1">
                            <webuijsf:label binding="#{admin$institution$editInstitution.label1}" id="label1"
                                style="font-size: 24px; left: 48px; top: 24px; position: absolute; width: 334px" text="#{resources.edit_institution}"/>
                            <webuijsf:tabSet binding="#{admin$institution$editInstitution.institutionTabSet}" id="institutionTabSet" selected="basicInfoTab" style="border: 1px solid gray; height: 334px; left: 48px; top: 72px; position: absolute; width: 678px">
                                <webuijsf:tab actionExpression="#{admin$institution$editInstitution.basicInfoTab_action}"
                                    binding="#{admin$institution$editInstitution.basicInfoTab}" id="basicInfoTab" text="#{resources.basic_information}">
                                    <webuijsf:panelLayout binding="#{admin$institution$editInstitution.layoutPanel1}" id="layoutPanel1" style="height: 334px; position: relative; width: 100%; -rave-layout: grid">
                                        <webuijsf:staticText binding="#{admin$institution$editInstitution.staticText1}" id="staticText1"
                                            style="font-family: 'Arial','Helvetica',sans-serif; font-weight: bold; left: 48px; top: 24px; position: absolute" text="#{resources.name}"/>
                                        <webuijsf:staticText binding="#{admin$institution$editInstitution.staticText2}" id="staticText2"
                                            style="font-family: 'Arial','Helvetica',sans-serif; font-weight: bold; left: 48px; top: 48px; position: absolute" text="#{resources.phone}"/>
                                        <webuijsf:staticText binding="#{admin$institution$editInstitution.staticText3}" id="staticText3"
                                            style="font-family: 'Arial','Helvetica',sans-serif; font-weight: bold; left: 48px; top: 72px; position: absolute" text="#{resources.fax}"/>
                                        <webuijsf:staticText binding="#{admin$institution$editInstitution.staticText4}" id="staticText4"
                                            style="font-family: 'Arial','Helvetica',sans-serif; font-weight: bold; left: 48px; top: 96px; position: absolute" text="#{resources.country}"/>
                                        <webuijsf:staticText binding="#{admin$institution$editInstitution.staticText5}" id="staticText5"
                                            style="font-family: 'Arial','Helvetica',sans-serif; font-weight: bold; left: 384px; top: 72px; position: absolute" text="#{resources.state}"/>
                                        <webuijsf:staticText binding="#{admin$institution$editInstitution.staticText6}" id="staticText6"
                                            style="font-family: 'Arial','Helvetica',sans-serif; font-weight: bold; left: 384px; top: 96px; position: absolute" text="#{resources.city}"/>
                                        <webuijsf:staticText binding="#{admin$institution$editInstitution.staticText7}" id="staticText7"
                                            style="font-family: 'Arial','Helvetica',sans-serif; font-weight: bold; left: 48px; top: 144px; position: absolute" text="#{resources.address}"/>
                                        <webuijsf:textField binding="#{admin$institution$editInstitution.txt_name}" id="txt_name" label=" " maxLength="80"
                                            required="true" style="left: 168px; top: 24px; position: absolute"/>
                                        <webuijsf:textField binding="#{admin$institution$editInstitution.txt_telephone}" id="txt_telephone" maxLength="100" style="left: 168px; top: 48px; position: absolute"/>
                                        <webuijsf:textField binding="#{admin$institution$editInstitution.txt_fax}" id="txt_fax" maxLength="100" style="left: 168px; top: 72px; position: absolute"/>
                                        <webuijsf:textField binding="#{admin$institution$editInstitution.txt_country}" id="txt_country" maxLength="100" style="left: 168px; top: 96px; position: absolute"/>
                                        <webuijsf:textField binding="#{admin$institution$editInstitution.txt_state}" id="txt_state" maxLength="100" style="left: 480px; top: 72px; position: absolute"/>
                                        <webuijsf:textField binding="#{admin$institution$editInstitution.txt_city}" id="txt_city" maxLength="100" style="left: 480px; top: 96px; position: absolute"/>
                                        <webuijsf:textArea binding="#{admin$institution$editInstitution.txt_address}" id="txt_address" style="height: 60px; left: 168px; top: 144px; position: absolute"/>
                                        <webuijsf:staticText binding="#{admin$institution$editInstitution.staticText8}" id="staticText8"
                                            style="font-family: 'Arial','Helvetica',sans-serif; font-weight: bold; left: 384px; top: 24px; position: absolute" text="#{resources.acronym}"/>
                                        <webuijsf:staticText binding="#{admin$institution$editInstitution.staticText9}" id="staticText9"
                                            style="font-family: 'Arial','Helvetica',sans-serif; font-weight: bold; left: 384px; top: 48px; position: absolute" text="#{resources.web_site}"/>
                                        <webuijsf:textField binding="#{admin$institution$editInstitution.txt_acronym}" id="txt_acronym" maxLength="10" style="left: 480px; top: 24px; position: absolute"/>
                                        <webuijsf:textField binding="#{admin$institution$editInstitution.txt_url}" id="txt_url" maxLength="500" style="left: 480px; top: 48px; position: absolute"/>
                                        <webuijsf:button actionExpression="#{admin$institution$editInstitution.btn_save_action}"
                                            binding="#{admin$institution$editInstitution.btn_save}" id="btn_save"
                                            style="height: 30px; left: 48px; top: 240px; position: absolute; width: 79px" text="#{resources.btnSave}"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                            </webuijsf:tabSet>
                            <h:messages binding="#{admin$institution$editInstitution.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage"
                                id="messageList1" infoClass="infoMessage" style="left: 408px; top: 24px; position: absolute" warnClass="warnMessage"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
