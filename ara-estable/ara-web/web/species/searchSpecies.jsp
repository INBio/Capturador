<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{species$searchSpecies.page1}" id="page1">
            <webuijsf:html binding="#{species$searchSpecies.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{species$searchSpecies.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{species$searchSpecies.form1}" id="form1">
                            <webuijsf:label binding="#{species$searchSpecies.label1}" id="label1"
                                style="font-size: 24px; left: 48px; top: 24px; position: absolute; width: 310px" text="#{resources.searchSpeciesLabel}"/>
                            <webuijsf:panelLayout binding="#{species$searchSpecies.layoutPanel1}" id="layoutPanel1" style="border: 2px groove black; height: 188px; left: 48px; top: 72px; position: absolute; width: 572px; -rave-layout: grid">
                                <webuijsf:label binding="#{species$searchSpecies.default_name_label}" id="default_name_label"
                                    style="left: 24px; top: 24px; position: absolute" text="#{resources.scientific_name}"/>
                                <webuijsf:textField binding="#{species$searchSpecies.scientificNameTF}" id="scientificNameTF" style="left: 192px; top: 24px; position: absolute; width: 215px"/>
                                <webuijsf:label binding="#{species$searchSpecies.kingdom_label}" id="kingdom_label"
                                    style="left: 24px; top: 48px; position: absolute" text="#{resources.kingdom}" visible="true"/>
                                <webuijsf:textField binding="#{species$searchSpecies.kingdomTF}" disabled="false" id="kingdomTF"
                                    style="left: 192px; top: 48px; position: absolute; width: 215px" visible="true"/>
                                <webuijsf:label binding="#{species$searchSpecies.family_label}" id="family_label"
                                    style="left: 24px; top: 72px; position: absolute" text="#{resources.family}" visible="true"/>
                                <webuijsf:textField binding="#{species$searchSpecies.familyTF}" id="familyTF"
                                    style="left: 192px; top: 72px; position: absolute; width: 215px" visible="true"/>
                                <webuijsf:button actionExpression="#{species$searchSpecies.searchButton_action}" binding="#{species$searchSpecies.searchButton}"
                                    id="searchButton" style="height: 24px; left: 24px; top: 120px; position: absolute; width: 72px" text="#{resources.btnSearch}"/>
                            </webuijsf:panelLayout>
                            <webuijsf:pageAlert binding="#{species$searchSpecies.searchAlert}" id="searchAlert" rendered="false" style="left: 240px; top: 96px; position: absolute; width: 574px"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
