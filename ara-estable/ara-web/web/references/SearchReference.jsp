<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{references$SearchReference.page1}" id="page1">
            <webuijsf:html binding="#{references$SearchReference.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{references$SearchReference.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{references$SearchReference.form1}" id="form1">
							|
							<webuijsf:label
                                binding="#{references$SearchReference.label1}" id="label1"
                                style="font-size: 24px; height: 22px; left: 48px; top: 24px; position: absolute; width: 406px" text="#{resources.search_references}"/>
                            <webuijsf:panelLayout binding="#{references$SearchReference.layoutPanel1}" id="layoutPanel1" style="border: 2px groove black; height: 214px; left: 48px; top: 72px; position: absolute; width: 452px; -rave-layout: grid">
                                <webuijsf:label binding="#{references$SearchReference.titleLabel}" id="titleLabel"
                                    style="left: 24px; top: 24px; position: absolute" text="#{resources.title}"/>
                                <webuijsf:textField binding="#{references$SearchReference.titleTF}" id="titleTF" style="left: 216px; top: 24px; position: absolute; width: 215px"/>
                                <webuijsf:label binding="#{references$SearchReference.descriptionLabel}" id="descriptionLabel"
                                    style="left: 24px; top: 48px; position: absolute" text="#{resources.description}"/>
                                <webuijsf:textField binding="#{references$SearchReference.descriptionTF}" id="descriptionTF" style="left: 216px; top: 48px; position: absolute; width: 215px"/>
                                <webuijsf:label binding="#{references$SearchReference.idLabel}" id="idLabel" style="left: 24px; top: 72px; position: absolute" text="#{resources.badge}"/>
                                <webuijsf:textField binding="#{references$SearchReference.identifierTF}" id="identifierTF" style="left: 216px; top: 72px; position: absolute; width: 215px"/>
                                <webuijsf:button actionExpression="#{references$SearchReference.searchButton_action}"
                                    binding="#{references$SearchReference.searchButton}" id="searchButton"
                                    style="height: 24px; left: 143px; top: 168px; position: absolute; width: 72px" text="#{resources.btnSearch}"/>
                                <webuijsf:label binding="#{references$SearchReference.languageLabel}" id="languageLabel"
                                    style="left: 24px; top: 96px; position: absolute" text="#{resources.language}"/>
                                <webuijsf:label binding="#{references$SearchReference.typeLabel}" id="typeLabel"
                                    style="left: 24px; top: 120px; position: absolute" text="#{resources.type}"/>
                                <webuijsf:dropDown binding="#{references$SearchReference.dd_referenceType}" id="dd_referenceType"
                                    items="#{references$SearchReference.dd_referenceTypeDefaultOptions.options}"
                                    selected="#{references$ReferenceSessionBean.selectedReferenceType}" style="height: 24px; left: 216px; top: 120px; position: absolute; width: 214px"/>
                                <webuijsf:dropDown binding="#{references$SearchReference.dd_language}" id="dd_language"
                                    items="#{references$SearchReference.dd_languageDefaultOptions.options}"
                                    selected="#{references$ReferenceSessionBean.selectedLanguage}" style="height: 24px; left: 216px; top: 96px; position: absolute; width: 214px"/>
                            </webuijsf:panelLayout>
                            <webuijsf:pageAlert binding="#{references$SearchReference.searchAlert}" id="searchAlert" rendered="false" style="height: 72px; left: 360px; top: 144px; position: absolute; width: 528px"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
				</webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
