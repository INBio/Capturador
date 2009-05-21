<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{admin$institution$searchInstitution.page1}" id="page1">
            <webuijsf:html binding="#{admin$institution$searchInstitution.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{admin$institution$searchInstitution.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{admin$institution$searchInstitution.form1}" id="form1">
                            <webuijsf:label binding="#{admin$institution$searchInstitution.label1}" id="label1"
                                style="font-size: 24px; height: 46px; left: 48px; top: 24px; position: absolute; width: 334px" text="#{resources.titleInstitutionsSearch}"/>
                            <webuijsf:panelLayout binding="#{admin$institution$searchInstitution.layoutPanel1}" id="layoutPanel1" style="border: 2px groove black; height: 214px; left: 48px; top: 96px; position: absolute; width: 452px; -rave-layout: grid">
                                <webuijsf:label binding="#{admin$institution$searchInstitution.name_label}" id="name_label"
                                    style="left: 24px; top: 48px; position: absolute" text="#{resources.institution_name}"/>
                                <webuijsf:textField binding="#{admin$institution$searchInstitution.institutionNameTF}" id="institutionNameTF" style="left: 216px; top: 48px; position: absolute; width: 215px"/>
                                <webuijsf:label binding="#{admin$institution$searchInstitution.acronym_label}" id="acronym_label"
                                    style="left: 24px; top: 24px; position: absolute" text="#{resources.acronym}"/>
                                <webuijsf:textField binding="#{admin$institution$searchInstitution.acronymTF}" id="acronymTF" style="left: 216px; top: 24px; position: absolute; width: 215px"/>
                                <webuijsf:label binding="#{admin$institution$searchInstitution.city_label}" id="city_label"
                                    style="left: 24px; top: 72px; position: absolute" text="#{resources.city}"/>
                                <webuijsf:textField binding="#{admin$institution$searchInstitution.cityTF}" id="cityTF" style="left: 216px; top: 72px; position: absolute; width: 215px"/>
                                <webuijsf:label binding="#{admin$institution$searchInstitution.state_province}" id="state_province"
                                    style="left: 24px; top: 96px; position: absolute" text="#{resources.state}"/>
                                <webuijsf:textField binding="#{admin$institution$searchInstitution.stateProvinceTF}" id="stateProvinceTF" style="left: 216px; top: 96px; position: absolute; width: 215px"/>
                                <webuijsf:label binding="#{admin$institution$searchInstitution.country}" id="country"
                                    style="left: 24px; top: 120px; position: absolute" text="#{resources.country}"/>
                                <webuijsf:textField binding="#{admin$institution$searchInstitution.countryTF}" id="countryTF" style="left: 216px; top: 120px; position: absolute; width: 215px"/>
                                <webuijsf:button actionExpression="#{admin$institution$searchInstitution.searchButton_action}"
                                    binding="#{admin$institution$searchInstitution.searchButton}" id="searchButton"
                                    style="height: 24px; left: 143px; top: 168px; position: absolute; width: 72px" text="#{resources.btnSearch}"/>
                                <webuijsf:button actionExpression="#{admin$institution$searchInstitution.cancelButton_action}"
                                    binding="#{admin$institution$searchInstitution.cancelButton}" id="cancelButton"
                                    style="height: 24px; left: 239px; top: 168px; position: absolute; width: 72px" text="#{resources.btnBack}"/>
                            </webuijsf:panelLayout>
                            <webuijsf:pageAlert binding="#{admin$institution$searchInstitution.searchAlert}" id="searchAlert" rendered="false" style="height: 72px; left: 264px; top: 120px; position: absolute; width: 528px"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
