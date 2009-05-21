<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{species$speciesNew.page1}" id="page1">
            <webuijsf:html binding="#{species$speciesNew.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{species$speciesNew.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{species$speciesNew.form1}" id="form1">
                             <webuijsf:panelLayout binding="#{species$speciesNew.ly_Header1}" id="ly_Header1" style="height: 238px; left: 48px; top: 24px; position: absolute; width: 718px; -rave-layout: grid">
                                <webuijsf:label binding="#{species$speciesNew.label1}" id="label1" style="left: 48px; top: 72px; position: absolute" text="#{resources.scientific_name}"/>
                                <webuijsf:label binding="#{species$speciesNew.label2}" id="label2" style="left: 48px; top: 96px; position: absolute" text="#{resources.record_number}"/>
                                <webuijsf:label binding="#{species$speciesNew.label4}" id="label4" style="left: 48px; top: 120px; position: absolute" text="#{resources.title}"/>
                                <webuijsf:label binding="#{species$speciesNew.label5}" id="label5" style="left: 48px; top: 144px; position: absolute" text="#{resources.language}"/>
                                <webuijsf:textField binding="#{species$speciesNew.txt_SpeciesVersion}" converter="#{species$speciesNew.longConverter1}"
                                    id="txt_SpeciesVersion" style="left: 216px; top: 96px; position: absolute; width: 71px"/>
                                <webuijsf:textField binding="#{species$speciesNew.txt_Title}" id="txt_Title" style="left: 216px; top: 120px; position: absolute; width: 503px"/>
                                <webuijsf:dropDown binding="#{species$speciesNew.dp_Language}" converter="#{species$speciesNew.longConverter1}" id="dp_Language"
                                    items="#{species$speciesNew.languageOptions}" selected="#{species$SpeciesSessionBean.selectedLanguage}" style="left: 216px; top: 144px; position: absolute; width: 199px"/>
                                <webuijsf:staticText binding="#{species$speciesNew.staticText1}" id="staticText1"
                                    style="font-family: 'Arial','Helvetica',sans-serif; font-size: 24px; left: 24px; top: 24px; position: absolute; width: 285px" text="#{resources.new_record}"/>
                                <webuijsf:button actionExpression="#{species$speciesNew.btn_save_action}" binding="#{species$speciesNew.btn_save}" id="btn_save"
                                    style="height: 23px; left: 47px; top: 192px; position: absolute; width: 70px" text="#{resources.btnSave}"/>

                                <h:messages binding="#{species$speciesNew.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1"
                                    infoClass="infoMessage" style="left: 360px; top: 24px; position: absolute" warnClass="warnMessage"/>
                                <webuijsf:label binding="#{species$speciesNew.label6}" id="label6" style="left: 48px; top: 168px; position: absolute" text="#{resources.stage}"/>
                                <webuijsf:staticText binding="#{species$speciesNew.staticText2}" id="staticText2"
                                    style="color: gray; font-family: 'Arial','Helvetica',sans-serif; font-weight: bold; left: 216px; top: 168px; position: absolute; width: 359px" text="#{resouces.unpublished}"/>
                                <webuijsf:dropDown binding="#{species$speciesNew.dd_species}" converter="#{species$speciesNew.longConverter1}" id="dd_species"
                                    items="#{species$speciesNew.speciesOptions}" selected="#{species$SpeciesSessionBean.selectedTaxonId}" style="left: 216px; top: 72px; position: absolute; width: 431px"/>
                            </webuijsf:panelLayout>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
