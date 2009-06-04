<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{site$editSite.page1}" id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <h:messages binding="#{site$editSite.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1"
                                infoClass="infoMessage" style="left: 552px; top: 24px; position: absolute" warnClass="warnMessage"/>
                            <webuijsf:label id="label1" style="font-size: 24px; height: 22px; left: 48px; top: 24px; position: absolute; width: 430px" text="#{resources.edit_site}"/>
                            <webuijsf:dropDown binding="#{site$editSite.dd_siteCalculationMethod}" id="dd_siteCalculationMethod"
                                items="#{site$SiteSessionBean.siteCalculationMethod}" selected="#{site$SiteSessionBean.selectedSiteCalculationMethod}" style="left: 216px; top: 216px; position: absolute"/>
                            <webuijsf:label id="label2" style="left: 48px; top: 288px; position: absolute" text="#{resources.datum}"/>
                            <webuijsf:tabSet id="tabSet1" selected="tab1" style="border: 1px solid gray; height: 35px; left: 48px; top: 336px; position: absolute; width: 766px">
                                <webuijsf:tab binding="#{site$editSite.tab1}" id="tab1" text="#{resources.coordinates}">
                                    <webuijsf:panelLayout binding="#{site$editSite.layoutPanel1}" id="layoutPanel1" style="border: 1px solid gray; height: 263px; position: relative; width: 100%; -rave-layout: grid">
                                        <webuijsf:label id="label3" style="left: 24px; top: 24px; position: absolute" text="#{resources.longitude}"/>
                                        <webuijsf:textField binding="#{site$editSite.txt_longitude_degrees}" id="txt_longitude_degrees" style="left: 120px; top: 48px; position: absolute; width: 120px"/>
                                        <webuijsf:label id="label4" style="left: 24px; top: 144px; position: absolute" text="#{resources.latitude}"/>
                                        <webuijsf:textField binding="#{site$editSite.txt_latitude_degrees}" id="txt_latitude_degrees" style="left: 120px; top: 168px; position: absolute; width: 120px"/>
                                        <webuijsf:button actionExpression="#{site$editSite.btn_addCoordinate_action}"
                                            binding="#{site$editSite.btn_addCoordinate}" id="btn_addCoordinate"
                                            style="height: 24px; left: 335px; top: 24px; position: absolute; width: 72px" text="#{resources.btnNew}"/>
                                        <webuijsf:table binding="#{site$editSite.table1}" id="table1" style="left: 336px; top: 72px; position: absolute"
                                            title="#{resources.actuals}" width="383">
                                            <webuijsf:tableRowGroup binding="#{site$editSite.tableRowGroup1}" id="tableRowGroup1"
                                                sourceData="#{site$SiteSessionBean.coordinateDataProvider}" sourceVar="currentRow">
                                                <webuijsf:tableColumn binding="#{site$editSite.tableColumn1}" headerText="#{resources.longitude}" id="tableColumn1">
                                                    <webuijsf:staticText binding="#{site$editSite.staticText1}" id="staticText1" text="#{currentRow.value['longitude']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn binding="#{site$editSite.tableColumn2}" headerText="#{resources.latitude}" id="tableColumn2">
                                                    <webuijsf:staticText binding="#{site$editSite.staticText2}" id="staticText2" text="#{currentRow.value['latitude']}"/>
                                                </webuijsf:tableColumn>
                                                <webuijsf:tableColumn binding="#{site$editSite.tableColumn3}" headerText="#{resources.actions}"
                                                    id="tableColumn3" sort="column3" style="text-align: center">
                                                    <webuijsf:button actionExpression="#{site$editSite.btn_removeCoord_action}"
                                                        binding="#{site$editSite.btn_removeCoord1}" id="btn_removeCoord1" text="#{resources.btnDelete}"/>
                                                </webuijsf:tableColumn>
                                            </webuijsf:tableRowGroup>
                                        </webuijsf:table>
                                        <webuijsf:textField binding="#{site$editSite.txt_longitude_minutes}" id="txt_longitude_minutes1"
                                            style="position: absolute; left: 120px; top: 72px; width: 144px; height: 24px" text="0"/>
                                        <webuijsf:textField binding="#{site$editSite.txt_longitude_seconds}" id="txt_longitude_seconds1"
                                            style="position: absolute; left: 120px; top: 96px; width: 144px; height: 24px" text="0"/>
                                        <webuijsf:textField binding="#{site$editSite.txt_latitude_minutes}" id="txt_latitude_minutes1"
                                            style="position: absolute; left: 120px; top: 192px; width: 144px; height: 24px" text="0"/>
                                        <webuijsf:textField binding="#{site$editSite.txt_latitude_seconds}" id="txt_latitude_seconds1"
                                            style="position: absolute; left: 120px; top: 216px; width: 144px; height: 24px" text="0"/>
                                        <webuijsf:label id="label12" requiredIndicator="true"
                                            style="position: absolute; left: 24px; top: 48px; width: 96px; height: 24px" text="#{resources.site_degrees}"/>
                                        <webuijsf:label id="label13" style="position: absolute; left: 24px; top: 72px; width: 96px; height: 24px" text="#{resources.site_minutes}"/>
                                        <webuijsf:label id="label14" style="position: absolute; left: 24px; top: 96px; width: 96px; height: 24px" text="#{resources.site_seconds}"/>
                                        <webuijsf:label id="label15" requiredIndicator="true"
                                            style="position: absolute; left: 24px; top: 168px; width: 96px; height: 24px" text="#{resources.site_degrees}"/>
                                        <webuijsf:label id="label16" style="position: absolute; left: 24px; top: 192px; width: 96px; height: 24px" text="#{resources.site_minutes}"/>
                                        <webuijsf:label id="label17" style="position: absolute; left: 24px; top: 216px; width: 96px; height: 24px" text="#{resources.site_seconds}"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                                <webuijsf:tab id="tab2" text="#{resources.politicDivision}">
                                    <webuijsf:panelLayout id="layoutPanel_tab2" style="border: 1px solid gray; height: 263px; position: relative; width: 100%; -rave-layout: grid">
                                        <webuijsf:label id="label_contry" requiredIndicator="true" style="left: 24px; top: 72px; position: absolute" text="#{resources.Country}"/>
                                        <webuijsf:dropDown actionExpression="#{site$SiteSessionBean.onCountryChange}" id="dd_country"
                                            items="#{site$SiteSessionBean.countriesDropDownData.options}" selected="#{site$SiteSessionBean.selectedCountryId}"
                                            style="left: 150px; top: 72px; position: absolute; width: 120px" submitForm="true"/>
                                        <webuijsf:label id="label_province" requiredIndicator="true" style="left: 24px; top: 96px; position: absolute" text="#{resources.province}"/>
                                        <webuijsf:dropDown id="dd_province" items="#{site$SiteSessionBean.provincesDropDownData.options}"
                                            selected="#{site$SiteSessionBean.selectedProvinceId}" style="left: 150px; top: 96px; position: absolute; width: 120px"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                            </webuijsf:tabSet>
                            <webuijsf:dropDown binding="#{site$editSite.dd_featureType}" id="dd_featureType" items="#{site$SiteSessionBean.featureTypeOption}"
                                selected="#{site$SiteSessionBean.selectedFeatureType}" style="left: 216px; top: 168px; position: absolute"/>
                            <webuijsf:label binding="#{site$editSite.label5}" id="label5" requiredIndicator="true"
                                style="left: 48px; top: 216px; position: absolute" text="#{resources.determination_method}"/>
                            <webuijsf:textField binding="#{site$editSite.txt_precision}" id="txt_precision" style="left: 216px; top: 240px; position: absolute" validatorExpression="#{util$ValidatorHelper.integerNumberFormatValidator}"/>
                            <webuijsf:label binding="#{site$editSite.label6}" id="label6" requiredIndicator="true"
                                style="left: 48px; top: 168px; position: absolute" text="#{resources.type}"/>
                            <webuijsf:label binding="#{site$editSite.label7}" id="label7" requiredIndicator="true"
                                style="left: 48px; top: 192px; position: absolute" text="#{resources.base_proyection}"/>
                            <webuijsf:textArea binding="#{site$editSite.txt_description}" id="txt_description" style="height: 48px; left: 216px; top: 96px; position: absolute; width: 648px"/>
                            <webuijsf:label binding="#{site$editSite.label8}" id="label8" requiredIndicator="true"
                                style="height: 24px; left: 48px; top: 96px; position: absolute; width: 24px" text="#{resources.description}"/>
                            <webuijsf:textField binding="#{site$editSite.txt_datum}" id="txt_datum" style="left: 216px; top: 288px; position: absolute" validatorExpression="#{util$ValidatorHelper.integerNumberFormatValidator}"/>
                            <webuijsf:dropDown binding="#{site$editSite.dd_originalProjection}" id="dd_originalProjection"
                                items="#{site$SiteSessionBean.originalProjection}" selected="#{site$SiteSessionBean.selectedOriginalProjection}" style="left: 216px; top: 264px; position: absolute"/>
                            <webuijsf:label binding="#{site$editSite.label9}" id="label9" requiredIndicator="true"
                                style="left: 48px; top: 264px; position: absolute" text="#{resources.orig_proyection}"/>
                            <webuijsf:dropDown binding="#{site$editSite.dd_baseProjection}" id="dd_baseProjection"
                                items="#{site$SiteSessionBean.projectionOption}" selected="#{site$SiteSessionBean.selectedProjection}" style="left: 216px; top: 192px; position: absolute"/>
                            <webuijsf:label binding="#{site$editSite.label10}" id="label10" style="left: 48px; top: 240px; position: absolute" text="#{resources.presition}"/>
                            <webuijsf:button actionExpression="#{site$editSite.btn_save_action}" binding="#{site$editSite.btn_save}" id="btn_save"
                                style="height: 24px; left: 407px; top: 96px; position: absolute; width: 96px" text="#{resources.btnSave}"/>
                            <webuijsf:label binding="#{site$editSite.label11}" id="label11" style="left: 48px; top: 72px; position: absolute" text="#{resources.id}"/>
                            <webuijsf:staticText binding="#{site$editSite.st_siteId}" id="st_siteId" style="left: 216px; top: 72px; position: absolute"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
