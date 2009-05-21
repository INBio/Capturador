<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{species$newTaxonDescriptionRecord.page1}" id="page1">
            <webuijsf:html binding="#{species$newTaxonDescriptionRecord.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{species$newTaxonDescriptionRecord.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{species$newTaxonDescriptionRecord.form1}" id="form1">
                            <webuijsf:staticText binding="#{species$newTaxonDescriptionRecord.st_CategoryName1}" id="st_CategoryName1" style="left: 48px; top: 72px; position: absolute; width: 240px"/>
                            <h:panelGrid binding="#{species$newTaxonDescriptionRecord.dynamicPanelForm}" id="dynamicPanelForm"
                                style="border: 1px solid gray; height: 336px; left: 48px; top: 120px; position: absolute" width="408"/>
                            <webuijsf:button actionExpression="#{species$newTaxonDescriptionRecord.saveRecordData_action}"
                                binding="#{species$newTaxonDescriptionRecord.saveRecordDataButton}" id="saveRecordDataButton"
                                style="left: 311px; top: 72px; position: absolute; width: 100px" text="#{resource.btnSave}"/>
                            <webuijsf:staticText binding="#{species$newTaxonDescriptionRecord.staticText1}" id="staticText1"
                                style="font-family: 'Arial','Helvetica',sans-serif; font-size: 24px; left: 48px; top: 24px; position: absolute; width: 310px" text="#{resources.btnNew}"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
