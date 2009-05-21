<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{admin$profile$newProfile.page1}" id="page1">
            <webuijsf:html binding="#{admin$profile$newProfile.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{admin$profile$newProfile.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{admin$profile$newProfile.form1}" id="form1">
                            <webuijsf:panelLayout binding="#{admin$profile$newProfile.layoutPanel}" id="layoutPanel" style="height: 22px; left: 408px; top: 24px; position: absolute; width: 382px; -rave-layout: grid">
                                <webuijsf:alert binding="#{admin$profile$newProfile.profileAlert}" id="profileAlert" style="left: 24px; top: 0px; position: absolute"/>
                            </webuijsf:panelLayout>
                            <webuijsf:label binding="#{admin$profile$newProfile.label}" id="label"
                                style="font-size: 24px; height: 22px; left: 48px; top: 24px; position: absolute; width: 334px" text="#{resources.new_profile}"/>
                            <webuijsf:tabSet binding="#{admin$profile$newProfile.tabSet}" id="tabSet" selected="basicInfoTab" style="border: 1px solid gray; height: 193px; left: 48px; top: 72px; position: absolute; width: 758px">
                                <webuijsf:tab actionExpression="#{admin$profile$newProfile.basicInfoTab_action}"
                                    binding="#{admin$profile$newProfile.basicInfoTab}" id="basicInfoTab" text="#{resources.basic_information}">
                                    <webuijsf:panelLayout binding="#{admin$profile$newProfile.layoutPanel2}" id="layoutPanel2" style="height: 156px; position: relative; width: 100%; -rave-layout: grid">
                                        <webuijsf:textField binding="#{admin$profile$newProfile.txt_name}" id="txt_name" style="left: 96px; top: 48px; position: absolute; width: 240px"/>
                                        <webuijsf:textArea binding="#{admin$profile$newProfile.txt_description}" id="txt_description" style="height: 45px; left: 96px; top: 72px; position: absolute; width: 240px"/>
                                        <webuijsf:label binding="#{admin$profile$newProfile.label2}" id="label2"
                                            style="left: 24px; top: 48px; position: absolute" text="#{resources.name}"/>
                                        <webuijsf:label binding="#{admin$profile$newProfile.label3}" id="label3"
                                            style="left: 24px; top: 72px; position: absolute" text="#{resources.description}"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                            </webuijsf:tabSet>
                            <webuijsf:button actionExpression="#{admin$profile$newProfile.btn_save_action}" binding="#{admin$profile$newProfile.btn_save}"
                                id="btn_save" style="height: 30px; left: 71px; top: 288px; position: absolute; width: 60px" text="#{resources.btnSave}"/>
                       </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
