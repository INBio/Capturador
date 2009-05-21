<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{moduleList.page1}" id="page1">
            <webuijsf:html binding="#{moduleList.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{moduleList.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido" style="position: relative; -rave-layout: grid">
                        <webuijsf:form binding="#{moduleList.form1}" id="form1">
                            <h:dataTable binding="#{moduleList.dataTable1}" id="dataTable1" rowClasses="list-row-even,list-row-odd"
                                style="border: 1px solid olive; background-color: rgb(153, 153, 0); color: rgb(204, 102, 0); font-family: 'Arial','Helvetica',sans-serif; font-size: 12px; font-style: normal; font-weight: bold; left: 48px; top: 24px; position: absolute" width="288">
                                <h:column binding="#{moduleList.column1}" id="column1">
                                    <f:facet name="header">
                                        <h:outputText binding="#{moduleList.outputText1}" id="outputText1"
                                            style="background-color: rgb(153, 153, 0); color: rgb(255, 255, 255); left: 100px" title="#{resources.modules}" value="#{resources.modules}"/>
                                    </f:facet>
                                </h:column>
                            </h:dataTable>
                            <webuijsf:table augmentTitle="false" binding="#{moduleList.t_module}" id="t_module"
                                style="left: 48px; top: 48px; position: absolute" width="288">
                                <webuijsf:tableRowGroup binding="#{moduleList.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                    sourceData="#{SessionManager.moduleDataProvider}" sourceVar="currentRow">
                                    <webuijsf:tableColumn binding="#{moduleList.tableColumn1}" id="tableColumn1" sort="column1" style="background-color: rgb(255, 255, 153); color: rgb(153, 51, 0); font-family: Arial,Helvetica,sans-serif; font-size: 12px; font-weight: bold; text-align: center">
                                        <webuijsf:hyperlink actionExpression="#{moduleList.hlink_module_action}" binding="#{moduleList.hyperlink1}"
                                            id="hyperlink1" text="#{resources[currentRow.value['name']]}"/>
                                    </webuijsf:tableColumn>
                                </webuijsf:tableRowGroup>
                            </webuijsf:table>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
