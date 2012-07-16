<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : SelectCollection
    Created on : 22/09/2009, 04:33:55 PM
    Author     : esmata
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link id="link2" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <div id="pageFormated">
                        <jsp:directive.include file="/Header_Select.jspf"/>
                        <webuijsf:panelLayout id="contenido">
                            <webuijsf:form id="form1">
                                <h:outputLabel id="lbSelectCollTitle" style="height: 24px; left: 24px; top: 10px; position: relative; width: 670px"
                                    styleClass="Page_title" value="#{resources.titleCollectionSelect}"/>
                                <h:panelGrid columns="1" id="gridpMain" style="height: 24px; left: 24px; top: 20px; position: relative" width="600">
                                    <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msgl" infoClass="infoMessage"
                                        style="height: 30px; width: 600px" warnClass="warnMessage"/>
                                    <webuijsf:panelGroup id="grouppBotonera" style="height: 24px; width: 600px">
                                        <h:commandButton action="#{SelectCollection.btnSelectCollection_action}" id="btnSelectCollection"
                                            style="height: 24px; width: 160px" styleClass="Button_next" value="#{resources.next_collection}"/>
                                        <h:commandButton action="#{SelectCollection.btnExit_action}" id="btnExit"
                                            style="height: 24px; width: 160px;margin-left:24px;" styleClass="Button_exit" value="#{resources.btnExit}"/>
                                    </webuijsf:panelGroup>
                                    <webuijsf:panelLayout id="layoutpSelect" style="height: 320px; position: relative; width: 599px; -rave-layout: grid">
                                        <webuijsf:label for="listbTaxons" id="lbTaxons"
                                            style="font-size: 12px; font-weight: bold; height: 22px; left: 0px; top: 24px; position: absolute; width: 358px" text="#{resources.available_taxons}"/>
                                        <webuijsf:label for="listbNomenclatural" id="lbNomenclaturalG"
                                            style="font-size: 12px; font-weight: bold; height: 24px; left: 0px; top: 168px; position: absolute; width: 358px" text="#{resources.available_groups}"
                                            visible="false"/>
                                        <webuijsf:listbox binding="#{SelectCollection.collectionList}" id="listbTaxons"
                                            items="#{SelectCollection.taxonUserData.options}" rows="6" selected="#{SelectCollection.selectedCollection}"
                                            style="height: 130px; left: 0px; top: 48px; position: absolute" width="350px"/>
                                        <webuijsf:listbox binding="#{SelectCollection.nomenclaturalList}" id="listbNomenclatural"
                                            items="#{SelectCollection.nomenclaturalGroupData.options}" rows="6"
                                            selected="#{SelectCollection.selectedNomenclatural}"
                                            style="height: 130px; left: 0px; top: 192px; position: absolute" width="350px"
                                            disabled="true"
                                            visible="false"/>
                                    </webuijsf:panelLayout>
                                </h:panelGrid>
                            </webuijsf:form>
                        </webuijsf:panelLayout>
                        <jsp:directive.include file="/Footer.jspf"/>
                    </div>
                    <!-- pageFormated ends -->
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
