<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : NewTransaction
    Created on : Feb 18, 2010, 4:53:29 PM
    Author     : echinchilla
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
                    <div id="pageFormated">
                        <jsp:directive.include file="/Header.jspf"/>
                        <webuijsf:panelLayout id="contenido">
                            <webuijsf:form id="form1">
                                <h:outputLabel id="lbTitle" style="height: 24px; left: 24px; position: relative; width: 850px" styleClass="Page_title" value="#{resources.title_transaction_new}"/>
                                <h:panelGrid columns="1" id="gridpMain" style="left: 24px; position: relative" width="850">
                                    <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                        style="height: 50px; width: 840px" warnClass="warnMessage"/>
                                    <webuijsf:panelGroup id="grouppBotonera" style="height: 24px; width: 650px">
                                        <h:commandButton action="#{transaction$NewTransaction.btnSaveTransaction_action}" id="btnUpdateTransaction"
                                            style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.new}"/>
                                    </webuijsf:panelGroup>
                                    <webuijsf:panelLayout id="lpNewTransaction" style="height: 188px; position: relative; width: 100%; -rave-layout: grid" styleClass="My_panel_blue">
                                        <webuijsf:label for="clTransactionDate" id="lbTransactionDate"
                                            style="height: 24px; left: 24px; top: 24px; position: absolute; width: 188px" text="#{resources.transaction_date} *"/>
                                        <webuijsf:label for="txInvoiceNumber" id="lbInvoiceNumber"
                                            style="height: 24px; left: 24px; top: 48px; position: absolute; width: 188px" text="#{resources.invoice_number}"/>
                                        <webuijsf:label for="txEstimatedNumberSpecimens" id="lbEstimatedNumberSpecimens"
                                            style="height: 24px; left: 24px; top: 72px; position: absolute; width: 188px" text="#{resources.estimated_specimen_count}"/>
                                        <webuijsf:label for="clExpirationDate" id="lbExpirationDate"
                                            style="height: 24px; left: 24px; top: 96px; position: absolute; width: 188px" text="#{resources.expiration_date}"/>
                                        <webuijsf:label for="txaDescription" id="lbDescription"
                                            style="height: 24px; left: 24px; top: 120px; position: absolute; width: 188px" text="#{resources.description}"/>
                                        <webuijsf:label for="ddSenderInstitution" id="lbSenderInstitutionId"
                                            style="height: 24px; left: 456px; top: 24px; position: absolute; width: 164px" text="#{resources.sender_institution} *"/>
                                        <webuijsf:label for="ddSenderPerson" id="lbSenderPersonId"
                                            style="height: 24px; left: 456px; top: 48px; position: absolute; width: 164px" text="#{resources.sender_person} *"/>
                                        <webuijsf:label for="ddReceiverInstitutionId" id="lbReceiverInstitutionId"
                                            style="height: 24px; left: 456px; top: 72px; position: absolute; width: 164px" text="#{resources.receiver_institution}"/>
                                        <webuijsf:label for="ddReceiverPerson" id="lbReceiverPersonId"
                                            style="height: 24px; left: 456px; top: 96px; position: absolute; width: 164px" text="#{resources.receiver_person}"/>
                                        <webuijsf:label for="txTransactionTypeId" id="lbTransactionTypeId"
                                            style="height: 24px; left: 456px; top: 120px; position: absolute; width: 164px" text="#{resources.transaction_type} *"/>
                                        <webuijsf:calendar binding="#{transaction$NewTransaction.clTransactionDate}" columns="22"
                                            dateFormatPattern="#{resources.date_format}" disabled="true" id="clTransactionDate" style="height: 24px; left: 206px; top: 24px; position: absolute; width: 192px"/>
                                        <webuijsf:textField columns="25" id="txInvoiceNumber"
                                            style="height: 24px; left: 216px; top: 48px; position: absolute; width: 192px" text="#{transaction$TransactionSessionBean.currentTransaction.invoiceNumber}"/>
                                        <webuijsf:textField columns="25" id="txEstimatedNumberSpecimens"
                                            style="height: 24px; left: 216px; top: 72px; position: absolute; width: 192px" text="#{transaction$TransactionSessionBean.currentTransaction.estimatedSpecimenCount}"/>
                                        <webuijsf:calendar binding="#{transaction$NewTransaction.clExpirationDate}" columns="22"
                                            dateFormatPattern="#{resources.date_format}" id="clExpirationDate" style="height: 24px; left: 206px; top: 96px; position: absolute; width: 192px"/>
                                        <webuijsf:textArea columns="23" id="txaDescription"
                                            style="height: 40px; left: 216px; top: 120px; position: absolute; width: 172px" text="#{transaction$TransactionSessionBean.currentTransaction.description}"/>
                                        <webuijsf:dropDown actionExpression="#{transaction$NewTransaction.updateSenderPersonListAction}" id="ddSenderInstitution"
                                            items="#{transaction$NewTransaction.institutionData.options}"
                                            selected="#{transaction$TransactionSessionBean.currentTransaction.senderInstitutionId}"
                                            style="height: 24px; left: 624px; top: 24px; position: absolute" submitForm="true" width="192px"/>
                                        <webuijsf:dropDown id="ddSenderPerson" items="#{transaction$NewTransaction.senderPersonData.options}"
                                            selected="#{transaction$TransactionSessionBean.currentTransaction.senderPersonId}"
                                            style="height: 24px; left: 624px; top: 48px; position: absolute" width="192px"/>
                                        <webuijsf:dropDown actionExpression="#{transaction$NewTransaction.updateReceiverPersonListAction}"
                                            id="ddReceiverInstitution" items="#{transaction$NewTransaction.institutionData.options}"
                                            selected="#{transaction$TransactionSessionBean.currentTransaction.receiverInstitutionId}"
                                            style="height: 24px; left: 624px; top: 72px; position: absolute" submitForm="true" width="192px"/>
                                        <webuijsf:dropDown id="ddReceiverPerson" items="#{transaction$NewTransaction.receiverPersonData.options}"
                                            selected="#{transaction$TransactionSessionBean.currentTransaction.receiverPersonId}"
                                            style="height: 24px; left: 624px; top: 96px; position: absolute" width="192px"/>
                                        <webuijsf:dropDown id="ddTransactionType" items="#{transaction$NewTransaction.transactionTypeData.options}"
                                            selected="#{transaction$TransactionSessionBean.currentTransaction.transactionTypeId}"
                                            style="height: 24px; left: 624px; top: 120px; position: absolute" width="192px"/>
                                    </webuijsf:panelLayout>
                                </h:panelGrid>
                            </webuijsf:form>
                        </webuijsf:panelLayout> <!-- contenido ends -->
                        <jsp:directive.include file="/Footer.jspf"/>
                    </div> <!-- pageFormated ends -->
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
