<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{admin$person$searchPerson.page1}" id="page1">
            <webuijsf:html binding="#{admin$person$searchPerson.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{admin$person$searchPerson.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido" style="position: relative; -rave-layout: grid">
                        <webuijsf:form binding="#{admin$person$searchPerson.form1}" id="form1">
                            <webuijsf:label binding="#{admin$person$searchPerson.label1}" id="label1"
                                style="font-size: 24px; left: 48px; top: 24px; position: absolute; width: 310px" text="#{resources.search_label}"/>
                            <webuijsf:panelLayout binding="#{admin$person$searchPerson.layoutPanel1}" id="layoutPanel1" style="border: 2px groove black; height: 308px; left: 48px; top: 72px; position: absolute; width: 428px; -rave-layout: grid">
                                <webuijsf:label binding="#{admin$person$searchPerson.label2}" id="label2" style="left: 24px; top: 48px; position: absolute" text="#{resources.id}"/>
                                <webuijsf:label binding="#{admin$person$searchPerson.label3}" id="label3" style="left: 24px; top: 24px; position: absolute" text="#{resources.name}"/>
                                <webuijsf:label binding="#{admin$person$searchPerson.label4}" id="label4" style="left: 24px; top: 72px; position: absolute" text="#{resources.last}"/>
                                <webuijsf:label binding="#{admin$person$searchPerson.label9}" id="label9" style="left: 24px; top: 96px; position: absolute" text="#{resources.second}"/>
                                <webuijsf:label binding="#{admin$person$searchPerson.label5}" id="label5" style="left: 24px; top: 120px; position: absolute" text="#{resources.initials}"/>
                                <webuijsf:label binding="#{admin$person$searchPerson.label8}" id="label8" style="left: 24px; top: 144px; position: absolute" text="#{resources.occupation}"/>
                                <webuijsf:label binding="#{admin$person$searchPerson.label10}" id="label10" style="left: 24px; top: 168px; position: absolute" text="#{resources.city}"/>
                                <webuijsf:label binding="#{admin$person$searchPerson.label11}" id="label11" style="left: 24px; top: 192px; position: absolute" text="#{resources.state}"/>
                                <webuijsf:label binding="#{admin$person$searchPerson.label12}" id="label12" style="left: 24px; top: 216px; position: absolute" text="#{resources.country}"/>
                                <webuijsf:textField binding="#{admin$person$searchPerson.personIdTF}" id="personIdTF" style="left: 192px; top: 48px; position: absolute; width: 215px"/>
                                <webuijsf:textField binding="#{admin$person$searchPerson.firstNameTF}" id="firstNameTF" style="left: 192px; top: 24px; position: absolute; width: 215px"/>
                                <webuijsf:textField binding="#{admin$person$searchPerson.lastNameTF}" id="lastNameTF" style="left: 192px; top: 72px; position: absolute; width: 215px"/>
                                <webuijsf:textField binding="#{admin$person$searchPerson.secondLastNameTF}" id="secondLastNameTF" style="left: 192px; top: 96px; position: absolute; width: 215px"/>
                                <webuijsf:textField binding="#{admin$person$searchPerson.initialsTF}" id="initialsTF" style="left: 192px; top: 120px; position: absolute; width: 215px"/>
                                <webuijsf:textField binding="#{admin$person$searchPerson.occupationTF}" id="occupationTF" style="left: 192px; top: 144px; position: absolute; width: 215px"/>
                                <webuijsf:textField binding="#{admin$person$searchPerson.cityTF}" id="cityTF" style="left: 192px; top: 168px; position: absolute; width: 215px"/>
                                <webuijsf:textField binding="#{admin$person$searchPerson.stateNameTF}" id="stateNameTF" style="left: 192px; top: 192px; position: absolute; width: 215px"/>
                                <webuijsf:textField binding="#{admin$person$searchPerson.countryTF}" id="countryTF" style="left: 192px; top: 216px; position: absolute; width: 215px"/>
                                <webuijsf:button actionExpression="#{admin$person$searchPerson.searchButton_action}"
                                    binding="#{admin$person$searchPerson.searchButton}" id="searchButton"
                                    style="height: 24px; left: 167px; top: 264px; position: absolute; width: 72px" text="#{resources.btnSearch}"/>
                            </webuijsf:panelLayout>
                            <webuijsf:pageAlert binding="#{admin$person$searchPerson.searchAlert}" id="searchAlert" rendered="false" style="position: absolute; left: 264px; top: 96px; width: 528px; height: 72px"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
