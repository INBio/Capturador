<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{species$speciesNew_v2.page1}" id="page1">
            <webuijsf:html binding="#{species$speciesNew_v2.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{species$speciesNew_v2.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{species$speciesNew_v2.form1}" id="form1">
							<webuijsf:panelLayout
                                binding="#{species$speciesNew_v2.ly_Header1}" id="ly_Header1" style="height: 190px; left: 48px; top: 70px; position: absolute; width: 718px; -rave-layout: grid">
                                <webuijsf:label binding="#{species$speciesNew_v2.label1}" id="label1" style="left: 24px; top: 24px; position: absolute" text="#{resources.scientific_name}"/>
                                <webuijsf:label binding="#{species$speciesNew_v2.label2}" id="label2" style="left: 24px; top: 48px; position: absolute" text="#{resources.record_number}"/>
                                <webuijsf:label binding="#{species$speciesNew_v2.label3}" id="label3" style="left: 24px; top: 72px; position: absolute" text="#{resources.title}"/>
                                <webuijsf:label binding="#{species$speciesNew_v2.label4}" id="label4" style="left: 24px; top: 96px; position: absolute" text="#{resources.language}"/>
                                <webuijsf:textField binding="#{species$speciesNew_v2.txt_SpeciesVersion1}" converter="#{species$speciesNew.longConverter1}"
                                    id="txt_SpeciesVersion1" style="left: 192px; top: 48px; position: absolute; width: 71px"/>
                                <webuijsf:textField binding="#{species$speciesNew_v2.txt_Title1}" id="txt_Title1" style="left: 192px; top: 72px; position: absolute; width: 503px"/>
                                <webuijsf:dropDown binding="#{species$speciesNew_v2.dp_Language1}" converter="#{species$speciesNew.longConverter1}"
                                    id="dp_Language1" items="#{species$speciesNew.languageOptions}" selected="#{species$SpeciesSessionBean.selectedLanguage}" style="left: 192px; top: 96px; position: absolute; width: 199px"/>
                                <webuijsf:staticText binding="#{species$speciesNew_v2.staticText1}" id="staticText1"
                                    style="font-family: 'Arial','Helvetica',sans-serif; font-size: 24px; left: 0px; top: -48px; position: absolute; width: 357px" text="#{resources.new_record}"/>
                                <webuijsf:button actionExpression="#{species$speciesNew_v2.btn_save_action}" binding="#{species$speciesNew_v2.btn_save1}"
                                    id="btn_save1" style="height: 23px; left: 23px; top: 144px; position: absolute; width: 70px" text="#{resources.btnSave}"/>
                                <h:messages binding="#{species$speciesNew_v2.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage"
                                    id="messageList1" infoClass="infoMessage" style="left: 384px; top: -48px; position: absolute" warnClass="warnMessage"/>
                                <webuijsf:label binding="#{species$speciesNew_v2.label5}" id="label5" style="left: 24px; top: 120px; position: absolute" text="#{resources.stage}"/>
                                <webuijsf:staticText binding="#{species$speciesNew_v2.staticText2}" id="staticText2"
                                    style="color: gray; font-family: 'Arial','Helvetica',sans-serif; font-weight: bold; left: 192px; top: 120px; position: absolute; width: 359px" text="#{resources.unpublished}"/>
                                <webuijsf:dropDown binding="#{species$speciesNew_v2.dd_species}" converter="#{species$speciesNew_v2.longConverter1}"
                                    id="dd_species" items="#{species$speciesNew_v2.speciesOptions}" selected="#{species$SpeciesSessionBean.selectedTaxonId}" style="left: 192px; top: 24px; position: absolute; width: 455px"/>
                            </webuijsf:panelLayout>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
