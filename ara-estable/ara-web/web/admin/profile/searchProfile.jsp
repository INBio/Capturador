<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{admin$profile$searchProfile.page1}" id="page1">
            <webuijsf:html binding="#{admin$profile$searchProfile.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{admin$profile$searchProfile.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{admin$profile$searchProfile.form1}" id="form1">
                            <webuijsf:label binding="#{admin$profile$searchProfile.label1}" id="label1"
                                style="font-size: 24px; left: 48px; top: 24px; position: absolute; width: 310px" text="#{resources.search_label}"/>
                            <webuijsf:panelLayout binding="#{admin$profile$searchProfile.layoutPanel1}" id="layoutPanel1" style="border: 2px groove black; height: 164px; left: 48px; top: 72px; position: absolute; width: 404px; -rave-layout: grid">
                                <webuijsf:label binding="#{admin$profile$searchProfile.name_label}" id="name_label"
                                    style="left: 24px; top: 24px; position: absolute" text="#{resources.name}"/>
                                <webuijsf:textField binding="#{admin$profile$searchProfile.profileNameTF}" id="profileNameTF" style="left: 168px; top: 24px; position: absolute; width: 215px"/>
                                <webuijsf:label binding="#{admin$profile$searchProfile.name_label1}" id="name_label1"
                                    style="left: 24px; top: 72px; position: absolute" text="#{resources.description}"/>
                                <webuijsf:textField binding="#{admin$profile$searchProfile.profileDescriptionTF}" id="profileDescriptionTF" style="left: 168px; top: 72px; position: absolute; width: 215px"/>
                                <webuijsf:button actionExpression="#{admin$profile$searchProfile.searchButton_action}"
                                    binding="#{admin$profile$searchProfile.searchButton}" id="searchButton"
                                    style="height: 24px; left: 119px; top: 120px; position: absolute; width: 72px" text="#{resources.btnSearch}"/>
                                <webuijsf:button actionExpression="#{admin$profile$searchProfile.cancelButton_action}"
                                    binding="#{admin$profile$searchProfile.cancelButton}" id="cancelButton"
                                    style="height: 24px; left: 215px; top: 120px; position: absolute; width: 72px" text="#{resources.btnCancel}"/>
                            </webuijsf:panelLayout>
                            <webuijsf:pageAlert binding="#{admin$profile$searchProfile.searchAlert}" id="searchAlert" rendered="false" style="left: 240px; top: 84px; position: absolute; width: 574px"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>

                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
