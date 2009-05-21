<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{nomenclaturalgroup$listNomenclaturalGroup.page1}" id="page1">
            <webuijsf:html binding="#{nomenclaturalgroup$listNomenclaturalGroup.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{nomenclaturalgroup$listNomenclaturalGroup.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{nomenclaturalgroup$listNomenclaturalGroup.form1}" id="form1">
                            <webuijsf:label binding="#{nomenclaturalgroup$listNomenclaturalGroup.label1}" id="label1"
                                style="font-size: 24px; height: 22px; left: 48px; top: 24px; position: absolute; width: 334px" text="#{resources.nomenclatural_groups}"/>
                            <h:messages binding="#{nomenclaturalgroup$listNomenclaturalGroup.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage"
                                id="messageList1" infoClass="infoMessage" style="left: 408px; top: 24px; position: absolute" warnClass="warnMessage"/>
                            <webuijsf:table binding="#{nomenclaturalgroup$listNomenclaturalGroup.table1}" clearSortButton="true" id="table1"
                                paginateButton="true" paginationControls="true" style="left: 48px; top: 72px; position: absolute; width: 832px"
                                title="#{resources.nomenclatural_groups}" width="832">
                                <webuijsf:tableRowGroup binding="#{nomenclaturalgroup$listNomenclaturalGroup.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                    sourceData="#{nomenclaturalgroup$NomenclaturalGroupSessionBean.nomenclaturalGroupDataProvider}" sourceVar="currentRow">
                                    <webuijsf:tableColumn binding="#{nomenclaturalgroup$listNomenclaturalGroup.tableColumn1}" headerText="#{resources.id}"
                                        id="tableColumn1" sort="id">
                                        <webuijsf:staticText binding="#{nomenclaturalgroup$listNomenclaturalGroup.staticText1}" id="staticText1" text="#{currentRow.value['id']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{nomenclaturalgroup$listNomenclaturalGroup.tableColumn2}" headerText="#{resources.name}"
                                        id="tableColumn2" sort="name">
                                        <webuijsf:staticText binding="#{nomenclaturalgroup$listNomenclaturalGroup.staticText2}" id="staticText2" text="#{currentRow.value['name']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{nomenclaturalgroup$listNomenclaturalGroup.tableColumn3}"
                                        headerText="#{resources.temporality}" id="tableColumn3" sort="temporality">
                                        <webuijsf:staticText binding="#{nomenclaturalgroup$listNomenclaturalGroup.staticText3}" id="staticText3" text="#{currentRow.value['temporality']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{nomenclaturalgroup$listNomenclaturalGroup.tableColumn4}"
                                        headerText="#{resources.certifier}" id="tableColumn4" sort="certificatorPersonName" width="200">
                                        <webuijsf:staticText binding="#{nomenclaturalgroup$listNomenclaturalGroup.staticText4}" id="staticText4" text="#{currentRow.value['certificatorPersonName']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn binding="#{nomenclaturalgroup$listNomenclaturalGroup.tableColumn5}"
                                        headerText="#{resources.colection}" id="tableColumn5" sort="collectionName" width="200">
                                        <webuijsf:staticText binding="#{nomenclaturalgroup$listNomenclaturalGroup.staticText5}" id="staticText5" text="#{currentRow.value['collectionName']}"/>
                                    </webuijsf:tableColumn>
                                    <webuijsf:tableColumn align="center" binding="#{nomenclaturalgroup$listNomenclaturalGroup.tableColumn7}"
                                        headerText="#{resources.actions}" id="tableColumn7" width="200">
                                        <webuijsf:button actionExpression="#{nomenclaturalgroup$listNomenclaturalGroup.btn_edit_action}"
                                            binding="#{nomenclaturalgroup$listNomenclaturalGroup.btn_edit}" id="btn_edit" style="height: 24px; width: 47px" text="#{resources.btnEdit}"/>
                                        <webuijsf:button actionExpression="#{nomenclaturalgroup$listNomenclaturalGroup.btn_remove_action}"
                                            binding="#{nomenclaturalgroup$listNomenclaturalGroup.btn_remove}" id="btn_remove" style="height: 24px; width: 47px" text="#{resources.btnDelete}"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                                <f:facet name="actionsTop">
                                    <webuijsf:button actionExpression="#{nomenclaturalgroup$listNomenclaturalGroup.btn_new_action}"
                                        binding="#{nomenclaturalgroup$listNomenclaturalGroup.btn_new}" id="btn_new" style="height: 24px; width: 47px" text="#{resources.btnNew}"/>
                                </f:facet>
                            </webuijsf:table>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
