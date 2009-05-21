<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{species$speciesList.page1}" id="page1">
            <webuijsf:html binding="#{species$speciesList.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{species$speciesList.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido" style="position: relative; -rave-layout: grid">
                        <webuijsf:form binding="#{species$speciesList.form1}" id="form1">
                            <webuijsf:table binding="#{species$speciesList.table1}" clearSortButton="true" id="table1" paginateButton="true"
                                paginationControls="true" sortPanelToggleButton="true" style="left: 48px; top: 72px; position: absolute; width: 672px"
                                title="#{resources.species_records}" width="672">
                                <webuijsf:tableRowGroup binding="#{species$speciesList.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                    sourceData="#{species$SpeciesSessionBean.taxonDescriptionDataProvider}" sourceVar="currentRow">
                                    <webuijsf:tableColumn binding="#{species$speciesList.tableColumn1}" headerText="#{resources.taxon_id}" id="tableColumn1" sort="taxonId">
                                        <webuijsf:staticText binding="#{species$speciesList.staticText1}" id="staticText1" text="#{currentRow.value['taxonId']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{species$speciesList.tableColumn6}" headerText="#{resources.sequence}" id="tableColumn6" sort="sequence">
                                        <webuijsf:staticText binding="#{species$speciesList.staticText6}" id="staticText6" text="#{currentRow.value['sequence']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{species$speciesList.tableColumn3}" headerText="#{resources.kingdom}" id="tableColumn3">
                                        <webuijsf:staticText binding="#{species$speciesList.staticText3}" id="staticText3" text="#{currentRow.value['kingdom']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{species$speciesList.tableColumn4}" headerText="#{resources.family}" id="tableColumn4">
                                        <webuijsf:staticText binding="#{species$speciesList.staticText4}" id="staticText4" text="#{currentRow.value['family']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{species$speciesList.tableColumn2}" headerText="#{resources.scientific_name}"
                                        id="tableColumn2" sort="defaultName">
                                        <webuijsf:staticText binding="#{species$speciesList.staticText2}" id="staticText2" text="#{currentRow.value['defaultName']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{species$speciesList.tableColumn5}" headerText="#{resources.common_name}" id="tableColumn5">
                                        <webuijsf:staticText binding="#{species$speciesList.staticText5}" id="staticText5" text="#{resources.unknown}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{species$speciesList.tableColumn7}" headerText="#{resources.edit}" id="tableColumn7">
                                        <webuijsf:button actionExpression="#{species$speciesList.showDetailBtn_action}" binding="#{species$speciesList.button2}"
                                            id="button2" text="#{resources.btnEdit}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{species$speciesList.tableColumn8}" headerText="#{resources.delete}" id="tableColumn8" width="200">
                                        <webuijsf:button actionExpression="#{species$speciesList.btn_remove_action}" binding="#{species$speciesList.btn_remove}"
                                            id="btn_remove" text="#{resources.btnDelete}"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                                <f:facet name="actionsTop">
                                    <webuijsf:panelGroup id="groupPanel2">
                                        <webuijsf:button actionExpression="#{species$speciesList.btn_search_action}" binding="#{species$speciesList.btn_search}"
                                            id="btn_search" text="#{resources.btnSearch}"/>
                                        <webuijsf:button actionExpression="#{species$speciesList.button3_action}" binding="#{species$speciesList.button3}"
                                            id="button3" text="#{resources.btnNew}"/>
                                    </webuijsf:panelGroup>
                                </f:facet>
                            </webuijsf:table>
                            <h:messages binding="#{species$speciesList.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1"
                                infoClass="infoMessage" style="left: 384px; top: 24px; position: absolute" warnClass="warnMessage"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
