<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{specimen$SearchSpecimen.page1}" id="page1">
            <webuijsf:html binding="#{specimen$SearchSpecimen.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{specimen$SearchSpecimen.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido" style="position: relative; -rave-layout: grid">
                        <webuijsf:form binding="#{specimen$SearchSpecimen.form1}" id="form1">
                            <webuijsf:label binding="#{specimen$SearchSpecimen.label1}" id="label1"
                                style="font-size: 24px; height: 22px; left: 48px; top: 24px; position: absolute; width: 502px" text="#{resources.search_label}"/>
                            <webuijsf:pageAlert binding="#{specimen$SearchSpecimen.searchAlert}" id="searchAlert" rendered="false" style="height: 72px; left: 216px; top: 120px; position: absolute; width: 528px"/>
                            <webuijsf:panelLayout binding="#{specimen$SearchSpecimen.layoutPanel1}" id="layoutPanel1" style="border: 2px groove black; height: 212px; left: 48px; top: 72px; position: absolute; width: 428px; -rave-layout: grid">
                                <webuijsf:label binding="#{specimen$SearchSpecimen.idLabel}" id="idLabel" style="left: 24px; top: 24px; position: absolute" text="#{resources.id}"/>
                                <webuijsf:textField binding="#{specimen$SearchSpecimen.idTF}" id="idTF" style="left: 240px; top: 24px; position: absolute; width: 70px"/>
                                <webuijsf:label binding="#{specimen$SearchSpecimen.GOIdLabel}" id="GOIdLabel" style="left: 24px; top: 48px; position: absolute" text="#{resources.gath_obs_number}"/>
                                <webuijsf:textField binding="#{specimen$SearchSpecimen.GOIdTF}" id="GOIdTF" style="left: 240px; top: 48px; position: absolute; width: 70px"/>
                                <webuijsf:textField binding="#{specimen$SearchSpecimen.catalogNumberTF}" id="catalogNumberTF" style="left: 240px; top: 72px; position: absolute; width: 70px"/>
                                <webuijsf:label binding="#{specimen$SearchSpecimen.collectionLabel}" id="collectionLabel"
                                    style="left: 24px; top: 96px; position: absolute" text="#{resources.collection}"/>
                                <webuijsf:textField binding="#{specimen$SearchSpecimen.collectionTF}" id="collectionTF" style="left: 240px; top: 96px; position: absolute; width: 70px"/>
                                <webuijsf:label binding="#{specimen$SearchSpecimen.collectorObserverLabel}" id="collectorObserverLabel"
                                    style="left: 24px; top: 120px; position: absolute" text="#{resources.collector_observer}"/>
                                <webuijsf:textField binding="#{specimen$SearchSpecimen.collectorObserverTF}" id="collectorObserverTF" style="left: 240px; top: 120px; position: absolute; width: 70px"/>
                                <webuijsf:button actionExpression="#{specimen$SearchSpecimen.searchButton_action}"
                                    binding="#{specimen$SearchSpecimen.searchButton}" id="searchButton"
                                    style="height: 24px; left: 239px; top: 168px; position: absolute; width: 72px" text="#{resources.btnSearch}"/>
                                <webuijsf:label binding="#{specimen$SearchSpecimen.catalogNumberLabel}" id="catalogNumberLabel"
                                    style="left: 24px; top: 72px; position: absolute" text="#{resources.CatalogNumber}"/>
                            </webuijsf:panelLayout>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
