<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : NewTransaction
    Created on : Feb 18, 2010, 4:53:29 PM
    Author     : echinchilla

    NOTA: VERSION DE RESPALDO DE NewTransacion.jsp, NO ES TRANSACTEDSPECIMENS...
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:link id="link2" url="/resources/css/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <webuijsf:label id="lbTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px" styleClass="Page_title" text="#{resources.title_transaction_new}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 50px; width: 840px" warnClass="warnMessage"/>
                                <webuijsf:panelGroup id="grouppBotonera" style="height: 24px; width: 650px">
                                    <h:commandButton action="#{transaction$NewTransaction.btnSaveTransaction_action}" id="btnUpdateTransaction"
                                        style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.new}"/>
                                    <!--<h:commandButton binding="#{transaction$NewTransaction.btnAddSpecimens}" id="btnAddSpecimens"
                                        style="height: 24px; width: 175px" styleClass="My_Button" value="Agregar Especímenes"/>-->
                                </webuijsf:panelGroup>
                                <webuijsf:tabSet id="tabSetMain" binding="#{transaction$NewTransaction.tabSet}" lite="true" selected="tabTransactionInfo"
                                    style="height: 220px; width: 835px" styleClass="My_panel_blue">
                                    <!--<webuijsf:tabSet id="tabSetMain" lite="true" selected="tabTransactionInfo" style="height: 100px; width: 835px" styleClass="My_panel_blue">-->
                                    <webuijsf:tab id="tabTransactionInfo" text="#{resources.transaction_information}">
                                        <webuijsf:panelLayout id="lpNewTransaction" style="height: 188px; position: relative; width: 100%; -rave-layout: grid">
                                            <webuijsf:label for="clTransactionDate" id="lbTransactionDate"
                                                style="height: 24px; left: 24px; top: 24px; position: absolute; width: 192px" text="#{resources.transaction_date}"/>
                                            <webuijsf:label for="txInvoiceNumber" id="lbInvoiceNumber"
                                                style="height: 24px; left: 24px; top: 48px; position: absolute; width: 192px" text="#{resources.invoice_number}"/>
                                            <webuijsf:label for="txEstimatedNumberSpecimens" id="lbEstimatedNumberSpecimens"
                                                style="height: 24px; left: 24px; top: 72px; position: absolute; width: 225px" text="#{resources.estimated_specimen_count}"/>
                                            <webuijsf:label for="clExpirationDate" id="lbExpirationDate"
                                                style="height: 24px; left: 24px; top: 96px; position: absolute; width: 192px" text="#{resources.expiration_date}"/>
                                            <webuijsf:label for="txaDescription" id="lbDescription"
                                                style="height: 24px; left: 24px; top: 120px; position: absolute; width: 192px" text="#{resources.description}"/>
                                            <webuijsf:label for="ddSenderInstitution" id="lbSenderInstitutionId"
                                                style="height: 24px; left: 456px; top: 24px; position: absolute; width: 192px" text="#{resources.sender_institution}"/>
                                            <webuijsf:label for="ddSenderPerson" id="lbSenderPersonId"
                                                style="height: 24px; left: 456px; top: 48px; position: absolute; width: 192px" text="#{resources.sender_person}"/>
                                            <webuijsf:label for="ddReceiverInstitutionId" id="lbReceiverInstitutionId"
                                                style="height: 24px; left: 456px; top: 72px; position: absolute; width: 192px" text="#{resources.receiver_institution}"/>
                                            <webuijsf:label for="ddReceiverPerson" id="lbReceiverPersonId"
                                                style="height: 24px; left: 456px; top: 96px; position: absolute; width: 192px" text="#{resources.receiver_person}"/>
                                            <webuijsf:label for="txTransactionTypeId" id="lbTransactionTypeId"
                                                style="height: 24px; left: 456px; top: 120px; position: absolute; width: 192px" text="#{resources.transaction_type}"/>
                                            <webuijsf:calendar binding="#{transaction$NewTransaction.clTransactionDate}" columns="22" disabled="true"
                                                dateFormatPattern="#{resources.date_format}" id="clTransactionDate" style="height: 24px; left: 240px; top: 24px; position: absolute; width: 192px"/>
                                            <webuijsf:textField columns="25" id="txInvoiceNumber"
                                                style="height: 24px; left: 250px; top: 48px; position: absolute; width: 192px" text="#{transaction$TransactionSessionBean.currentTransaction.invoiceNumber}"/>
                                            <webuijsf:textField columns="25" id="txEstimatedNumberSpecimens"
                                                style="height: 24px; left: 250px; top: 72px; position: absolute; width: 192px" text="#{transaction$TransactionSessionBean.currentTransaction.estimatedSpecimenCount}"/>
                                            <webuijsf:calendar binding="#{transaction$NewTransaction.clExpirationDate}" columns="22"
                                                dateFormatPattern="#{resources.date_format}" id="clExpirationDate" style="height: 24px; left: 240px; top: 96px; position: absolute; width: 192px"/>
                                            <webuijsf:textArea columns="23" id="txaDescription"
                                                style="height: 40px; left: 250px; top: 120px; position: absolute; width: 172px" text="#{transaction$TransactionSessionBean.currentTransaction.description}"/>
                                            <webuijsf:dropDown actionExpression="#{transaction$NewTransaction.updateSenderPersonListAction}"
                                                id="ddSenderInstitution1" items="#{transaction$NewTransaction.institutionData.options}"
                                                selected="#{transaction$TransactionSessionBean.currentTransaction.senderInstitutionId}"
                                                style="height: 24px; left: 600px; top: 24px; position: absolute" submitForm="true" width="192px"/>
                                            <webuijsf:dropDown id="ddSenderPerson1" items="#{transaction$NewTransaction.senderPersonData.options}"
                                                selected="#{transaction$TransactionSessionBean.currentTransaction.senderPersonId}"
                                                style="height: 24px; left: 600px; top: 48px; position: absolute" width="192px"/>
                                            <webuijsf:dropDown actionExpression="#{transaction$NewTransaction.updateReceiverPersonListAction}"
                                                id="ddReceiverInstitution1" items="#{transaction$NewTransaction.institutionData.options}"
                                                selected="#{transaction$TransactionSessionBean.currentTransaction.receiverInstitutionId}"
                                                style="height: 24px; left: 600px; top: 72px; position: absolute" submitForm="true" width="192px"/>
                                            <webuijsf:dropDown id="ddReceiverPerson1" items="#{transaction$NewTransaction.receiverPersonData.options}"
                                                selected="#{transaction$TransactionSessionBean.currentTransaction.receiverPersonId}"
                                                style="height: 24px; left: 600px; top: 96px; position: absolute" width="192px"/>
                                            <webuijsf:dropDown id="ddTransactionType" items="#{transaction$NewTransaction.transactionTypeData.options}"
                                                selected="#{transaction$TransactionSessionBean.currentTransaction.transactionTypeId}"
                                                style="height: 24px; left: 600px; top: 120px; position: absolute" width="192px"/>
                                        </webuijsf:panelLayout>
                                    </webuijsf:tab>
                                    <webuijsf:tab id="tabAddTransactedSpecimen" text="#{resources.add_transacted_specimen}" binding="#{transaction$NewTransaction.tabAddTransactedSpecimens}">
                                        <webuijsf:panelLayout id="lpAddTransactedSpecimen" style="height: 188px; position: relative; width: 100%; -rave-layout: grid">
                                            <webuijsf:label for="clTransactionDate2" id="lbTransactionDate2"
                                                style="height: 24px; left: 24px; top: 24px; position: absolute; width: 192px" text="Numero de Catálogo"/>
                                            <webuijsf:textField columns="25" id="txInvoiceNumber2" style="height: 24px; left: 230px; top: 24px; position: absolute; width: 192px"/>
                                            <h:commandButton id="btnUpdateTransaction3"
                                                style="height: 24px; width: 175px; top: 24px; left: 450px; position: absolute" styleClass="My_Button" value="Agregar"/>
                                        </webuijsf:panelLayout>
                                    </webuijsf:tab>
                                </webuijsf:tabSet>
                                <webuijsf:panelLayout id="layoutpEditGathDetails2" style="height: 188px; position: relative; width: 100%; -rave-layout: grid">
                                    <webuijsf:label id="lbTransactedSpecimens" style="height: 24px; left: 24px; width: 850px" styleClass="Page_title" text="#{resources.transacted_specimens}"/>
                                    <h:dataTable cellspacing="0" columnClasses="list-columns" headerClass="list-header" id="dataTableTransactedSpecimens"
                                        rowClasses="list-row-even,list-row-odd"
                                        style="border-top: solid rgb(214, 218, 221) 2px; border-bottom: solid rgb(214, 218, 221) 2px; border-left: solid rgb(214, 218, 221) 2px; "
                                        var="currentRow" width="839">
                                        <h:column>
                                            <h:selectBooleanCheckbox id="checkbox1" value="#{currentRow['selected']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="Número de Catálogo"/>
                                            </f:facet>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="Fecha de Envío"/>
                                            </f:facet>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="Fecha de Retorno"/>
                                            </f:facet>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="Taxón"/>
                                            </f:facet>
                                        </h:column>
                                    </h:dataTable>
                                </webuijsf:panelLayout>
                                <jsp:directive.include file="/Footer.jspf"/>
                            </h:panelGrid>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
