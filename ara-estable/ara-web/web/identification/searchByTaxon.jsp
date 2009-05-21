<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{identification$searchByTaxon.page1}" id="page1">
            <webuijsf:html binding="#{identification$searchByTaxon.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{identification$searchByTaxon.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{identification$searchByTaxon.form1}" id="form1">
                            <h:messages binding="#{identification$searchByTaxon.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage"
                                id="messageList1" infoClass="infoMessage" style="left: 408px; top: 24px; position: absolute" warnClass="warnMessage"/>
                            <webuijsf:label binding="#{identification$searchByTaxon.label1}" id="label1"
                                style="font-size: 24px; height: 22px; left: 48px; top: 24px; position: absolute; width: 334px" text="#{resources.re_identify}"/>
                            <webuijsf:label binding="#{identification$searchByTaxon.label2}" id="label2"
                                style="font-size: 14px; height: 24px; left: 48px; top: 48px; position: absolute; width: 334px" text="#{resources.search_specimens_by_taxon}"/>
                            <webuijsf:dropDown binding="#{identification$searchByTaxon.dd_taxonomicalRange1}" id="dd_taxonomicalRange1"
                                items="#{identification$IdentificationSearchSessionBean.taxonomicalRangeOption}"
                                onChange="webuijsf.suntheme.common.timeoutSubmitForm(this.form, 'tab_Identification:tab_reIdentify:tab_identification:layoutPanel2:dd_taxonomicalRange1');"
                                selected="#{identification$IdentificationSearchSessionBean.selectedTaxonomicalRange}"
                                style="left: 168px; top: 96px; position: absolute" valueChangeListenerExpression="#{identification$searchByTaxon.dd_taxonomicalRange1_processValueChange}"/>
                            <webuijsf:dropDown binding="#{identification$searchByTaxon.dd_taxonomicalCategory1}" id="dd_taxonomicalCategory1"
                                items="#{identification$IdentificationSearchSessionBean.taxonCategoryOption}"
                                onChange="webuijsf.suntheme.common.timeoutSubmitForm(this.form, 'tab_Identification:tab_reIdentify:tab_identification:layoutPanel2:dd_taxonomicalCategory1');"
                                selected="#{identification$IdentificationSearchSessionBean.selectedTaxonCategory}"
                                style="left: 168px; top: 120px; position: absolute" valueChangeListenerExpression="#{identification$searchByTaxon.dd_taxonomicalCategory1_processValueChange}"/>
                            <webuijsf:label binding="#{identification$searchByTaxon.label3}" id="label3" style="left: 48px; top: 120px; position: absolute" text="#{resources.category}"/>
                            <webuijsf:label binding="#{identification$searchByTaxon.label4}" id="label4" style="left: 48px; top: 96px; position: absolute" text="#{resources.taxonomic_level}"/>
                            <webuijsf:listbox binding="#{identification$searchByTaxon.lst_taxon}" id="lst_taxon"
                                items="#{identification$IdentificationSearchSessionBean.taxonList}"
                                onChange="webuijsf.suntheme.common.timeoutSubmitForm(this.form, 'lst_taxon');"
                                selected="#{identification$IdentificationSearchSessionBean.selectedTaxon}" style="height: 168px; left: 168px; top: 144px; position: absolute; width: 192px"/>
                            <webuijsf:label binding="#{identification$searchByTaxon.label5}" id="label5" style="left: 48px; top: 144px; position: absolute" text="#{resources.taxon}"/>
                            <webuijsf:button actionExpression="#{identification$searchByTaxon.btn_load_action}"
                                binding="#{identification$searchByTaxon.btn_load}" id="btn_load"
                                style="height: 24px; left: 47px; top: 408px; position: absolute; width: 120px" text="#{resources.load_specimens}"/>
                            <webuijsf:textField binding="#{identification$searchByTaxon.txt_specimenCount}" id="txt_specimenCount"
                                label="#{resources.specimens_quantity_found} :" readOnly="true"
                                style="height: 22px; left: 48px; top: 360px; position: absolute; width: 310px" text="#{identification$IdentificationSearchSessionBean.specimenCount}"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
