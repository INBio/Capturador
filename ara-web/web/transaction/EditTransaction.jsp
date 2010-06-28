<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : EditTransaction
    Created on : Feb 18, 2010, 4:52:59 PM
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
                    <webuijsf:script id="scriptX" type="text/javascript">

                        /**
                         *
                         * variables globales para accesar el textField de CatalogNumber y el Button de AddTransactedSpecimen,
                         * además del HiddenField que contiene el texto de confirmación de borrado.
                         *
                         * NOTA: Es importante cambiar estas variables cada vez que la estructura de este JSP varíe.
                         */
                        var btnAddTransactedSpecimenId = 'contenido:form1:tabSetMain:tabAddTransactedSpecimen:btnAddTransactedSpecimen';
                        var txAddTransactedSpecimenId = 'contenido:form1:tabSetMain:tabAddTransactedSpecimen:txAddTransactedSpecimen';
                        var deleteConfirmationTextId = 'contenido:form1:lpTransactedSpecimensTable:grouppButtons:panelPaginacion:deleteConfirmationText';
                        var cbDescription = 'contenido:form1:tabSetMain:tabAddTransactedSpecimen:cbDescription';

                        /**
                         *
                         * Función que permite realizar trim() a un string
                         */
                        String.prototype.trim = function () {
                            return this.replace(/^\s*/, "").replace(/\s*$/, "");
                        }

                        /**
                         *
                         * Función que revisa si la tecla oprimida fue ENTER (KeyCode = 13)
                         */
                        function isEnter(e) {
                            var key = e.keyCode;
                            if (key == 13) {
                                var text = new String(document.getElementById(txAddTransactedSpecimenId).value);
                                text = text.trim()
                                if(text != "")
                                    document.getElementById(btnAddTransactedSpecimenId).click();
                                else
                                    return false;
                            }
                            return true;
                        }

                        /**
                         *
                         * Función que pone el foco en el textField de CatalogNumber
                         */
                        function setFocusTxCatalogNumber() {
                            var textField = document.getElementById(txAddTransactedSpecimenId);
                            textField.focus();
                        }

                        /**
                         *
                         * Función que pide confirmación de borrado al usuario
                         */
                        function deleteConfirmation() {
                            var confirmationText = document.getElementById(deleteConfirmationTextId).value;
                            return confirm(confirmationText);
                        }

                        /**
                         *
                         * Función que pide confirmación de edicion al usuario
                         */
                        function editConfirmation() {
                            var confirmationText = document.getElementById(deleteConfirmationTextId).value;
                            return confirm(confirmationText);
                        }

                        /**
                         *
                         * Función que se llama al seleccionar el checkBox de description
                         */
                        function checkBoxDescriptionSelected() {
                        }
                    </webuijsf:script>
                </webuijsf:head>
                <webuijsf:body id="body1" onLoad="setFocusTxCatalogNumber();" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <webuijsf:label binding="#{transaction$EditTransaction.lbTitle}" id="lbTitle"
                                style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px" styleClass="Page_title"/>
                            <h:panelGrid columns="1" id="gridpMain" style="left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 50px; width: 840px" warnClass="warnMessage"/>
                                <webuijsf:panelGroup id="grouppBotonera" style="height: 24px; width: 650px">
                                    <h:commandButton action="#{transaction$EditTransaction.btnUpdateTransaction_action}" id="btnUpdateTransaction"
                                        style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.update}"/>
                                </webuijsf:panelGroup>
                                <!-- Este tabSet no debe tener la propiedad selectedTab -->
                                <webuijsf:tabSet binding="#{transaction$EditTransaction.tabSet}" id="tabSetMain" lite="true" styleClass="My_panel_blue">
                                    <!--<webuijsf:tabSet id="tabSetMain" lite="true" selected="tabTransactionInfo" style="height: 100px; width: 835px" styleClass="My_panel_blue">-->
                                    <webuijsf:tab id="tabTransactionInfo" text="#{resources.transaction_information}">
                                        <webuijsf:panelLayout id="lpEditTransaction" style="height: 188px; position: relative; width: 835px; -rave-layout: grid">
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
                                            <webuijsf:calendar binding="#{transaction$EditTransaction.clTransactionDate}" columns="22"
                                                dateFormatPattern="#{resources.date_format}" disabled="true" id="clTransactionDate" style="height: 24px; left: 240px; top: 24px; position: absolute; width: 192px"/>
                                            <webuijsf:textField columns="25" id="txInvoiceNumber"
                                                style="height: 24px; left: 250px; top: 48px; position: absolute; width: 192px" text="#{transaction$TransactionSessionBean.currentTransaction.invoiceNumber}"/>
                                            <webuijsf:textField columns="25" id="txEstimatedNumberSpecimens"
                                                style="height: 24px; left: 250px; top: 72px; position: absolute; width: 192px" text="#{transaction$TransactionSessionBean.currentTransaction.estimatedSpecimenCount}"/>
                                            <webuijsf:calendar binding="#{transaction$EditTransaction.clExpirationDate}" columns="22"
                                                dateFormatPattern="#{resources.date_format}" id="clExpirationDate" style="height: 24px; left: 240px; top: 96px; position: absolute; width: 192px"/>
                                            <webuijsf:textArea columns="23" id="txaDescription"
                                                style="height: 40px; left: 250px; top: 120px; position: absolute; width: 172px" text="#{transaction$TransactionSessionBean.currentTransaction.description}"/>
                                            <webuijsf:dropDown actionExpression="#{transaction$EditTransaction.updateSenderPersonListAction}"
                                                id="ddSenderInstitution" items="#{transaction$EditTransaction.institutionData.options}"
                                                selected="#{transaction$TransactionSessionBean.currentTransaction.senderInstitutionId}"
                                                style="height: 24px; left: 600px; top: 24px; position: absolute" submitForm="true" width="192px"/>
                                            <webuijsf:dropDown id="ddSenderPerson" items="#{transaction$EditTransaction.senderPersonData.options}"
                                                selected="#{transaction$TransactionSessionBean.currentTransaction.senderPersonId}"
                                                style="height: 24px; left: 600px; top: 48px; position: absolute" width="192px"/>
                                            <webuijsf:dropDown actionExpression="#{transaction$EditTransaction.updateReceiverPersonListAction}"
                                                id="ddReceiverInstitution" items="#{transaction$EditTransaction.institutionData.options}"
                                                selected="#{transaction$TransactionSessionBean.currentTransaction.receiverInstitutionId}"
                                                style="height: 24px; left: 600px; top: 72px; position: absolute" submitForm="true" width="192px"/>
                                            <webuijsf:dropDown id="ddReceiverPerson" items="#{transaction$EditTransaction.receiverPersonData.options}"
                                                selected="#{transaction$TransactionSessionBean.currentTransaction.receiverPersonId}"
                                                style="height: 24px; left: 600px; top: 96px; position: absolute" width="192px"/>
                                            <webuijsf:dropDown id="ddTransactionType" items="#{transaction$EditTransaction.transactionTypeData.options}"
                                                selected="#{transaction$TransactionSessionBean.currentTransaction.transactionTypeId}"
                                                style="height: 24px; left: 600px; top: 120px; position: absolute" width="192px"/>
                                        </webuijsf:panelLayout>
                                    </webuijsf:tab>
                                    <webuijsf:tab binding="#{transaction$EditTransaction.tabAddTransactedSpecimens}" id="tabAddTransactedSpecimen" text="#{resources.add_transacted_specimen}">


                                        <!--<webuijsf:panelLayout id="lpAddTransactedSpecimen" style="height: 188px; position: relative; width: 100%; -rave-layout: grid">
                                            <webuijsf:label for="txAddTransactedSpecimen" id="lbAddTransactedSpecimen"
                                                style="height: 24px; left: 24px; top: 24px; position: absolute; width: 192px" text="#{resources.catalognumber}"/>
                                            <h:inputText onkeypress="return isEnter(event)" binding="#{transaction$EditTransaction.txCatalogNumber}" size="25" id="txAddTransactedSpecimen"
                                                style="left: 230px; top: 24px; position: absolute; width: 192px"></h:inputText>
                                            <h:commandButton action="#{transaction$EditTransaction.btnAddTransactedSpecimen_action}" id="btnAddTransactedSpecimen"
                                                style="height: 24px; width: 175px; top: 24px; left: 450px; position: absolute" styleClass="My_Button" value="#{resources.add_specimen}"/>
                                        </webuijsf:panelLayout>-->


                                        <h:panelGrid columns="1" id="pgAddTransactedSpecimen" style="height: 24px" width="800">
                                            <h:panelGrid columns="3" id="pgAddTransactedSpecimen2" style="height: 24px; margin-top: 20px; margin-left: 20px" width="700">
                                                <webuijsf:label for="txAddTransactedSpecimen" id="lbAddTransactedSpecimen" style="height: 24px; width: 192px" text="#{resources.catalognumber}"/>
                                                <h:inputText binding="#{transaction$EditTransaction.txCatalogNumber}" id="txAddTransactedSpecimen"
                                                    onkeypress="return isEnter(event)" size="25" style="width: 192px"/>
                                                <h:commandButton action="#{transaction$EditTransaction.btnAddTransactedSpecimen_action}"
                                                    id="btnAddTransactedSpecimen" style="height: 24px; width: 175px" styleClass="My_Button" value="#{resources.add_specimen}"/>
                                            </h:panelGrid>
                                            <h:panelGrid columns="4" id="pgDescription" style="height: 24px; margin-top: 10px; margin-left: 20px" width="700" styleClass="My_subpanel_blue">

                                                <webuijsf:label for="clDeliveryDate" id="lbDeliveryDate"
                                                    style="height: 24px; width: 192px" text="#{resources.delivery_date}"/>
                                                <webuijsf:calendar columns="22" binding="#{transaction$EditTransaction.clDeliveryDate}"
                                                    dateFormatPattern="#{resources.date_format}" id="clDeliveryDate" style="height: 24px; width: 192px"/>
                                                <webuijsf:label for="clReceivingDate" id="lbReceivingDate"
                                                    style="height: 24px; width: 192px" text="#{resources.receiving_date}"/>
                                                <webuijsf:calendar columns="22" binding="#{transaction$EditTransaction.clReceivingDate}"
                                                    dateFormatPattern="#{resources.date_format}" id="clReceivingDate" style="height: 24px; width: 192px"/>
                                                <webuijsf:label for="ddTransactedSpecimenStatus" id="lbTransactedSpecimenStatus"
                                                    style="height: 24px; width: 192px" text="#{resources.transacted_specimen_status}"/>
                                                <webuijsf:dropDown id="ddTransactedSpecimenStatus" items="#{transaction$EditTransaction.transactedSpecimenStatusData.options}"
                                                    selected="#{transaction$TransactionSessionBean.transactedSpecimenStatusId}"
                                                    style="height: 24px" width="192px"/>
                                                <webuijsf:label for="transactedSpecimenDescription" id="lbTransactedSpecimenDescription"
                                                    style="height: 24px; width: 192px" text="#{resources.description}"/>
                                                <webuijsf:textArea columns="23" id="transactedSpecimenDescription"
                                                    style="height: 40px; width: 172px" text="#{transaction$TransactionSessionBean.transactedSpecimenDescription}"/>
                                            </h:panelGrid>
                                        </h:panelGrid>
                                    </webuijsf:tab>
                                </webuijsf:tabSet>
                                <webuijsf:panelLayout id="lpTransactedSpecimensTable" style="height: 188px; position: relative; width: 100%; -rave-layout: grid">
                                    <webuijsf:label id="lbTransactedSpecimens" style="height: 24px; left: 24px; width: 850px" styleClass="Page_title" text="#{resources.transacted_specimens}"/>
                                    <h:panelGrid cellspacing="1" columns="1" id="gridpTableMain" style="height: 24px" styleClass="My_table" width="840">
                                        <webuijsf:panelGroup id="grouppButtons">
                                            <h:panelGrid columns="1" id="gridpquantity" styleClass="My_table_top" width="840">
                                                <h:outputLabel id="labelQuantity" value="#{transaction$EditTransaction.quantityTotal}"/>
                                            </h:panelGrid>
                                            <webuijsf:panelGroup id="panelPaginacion" separator=" " style="margin-left:70px;">
                                                <!-- Botones de acciones -->
                                                <h:commandButton action="#{transaction$EditTransaction.btnTransactedSpecimenDelete_action}" id="deleteButton"
                                                    onclick="return deleteConfirmation();" style="margin: 2px;height: 22px" styleClass="My_Button_table" value="#{resources.btnDelete}"/>
                                                <h:inputHidden binding="#{transaction$EditTransaction.deleteConfirmationText}" id="deleteConfirmationText"/>
                                                <!-- Botones de paginacion -->
                                                <h:commandButton action="#{transaction$EditTransaction.btnTransactedSpecimenEdit_action}" id="editButton"
                                                    onclick="return editConfirmation();" style="margin: 2px;height: 22px" styleClass="My_Button_table" value="#{resources.btnEdit}"/>
                                                <h:commandButton action="#{transaction$TransactionSessionBean.pagination.firstResults}" id="btnFirst"
                                                    rendered="#{transaction$TransactionSessionBean.pagination.isVisiblePrevious}"
                                                    style="margin: 2px;height: 22px" styleClass="My_Button_first" value="#{resources.pagination_first}"/>
                                                <h:commandButton action="#{transaction$TransactionSessionBean.pagination.previousResults}" id="btnPrevious"
                                                    rendered="#{transaction$TransactionSessionBean.pagination.isVisiblePrevious}"
                                                    style="margin: 2px;height: 22px" styleClass="My_Button_previous" value="#{resources.pagination_previous}"/>
                                                <h:commandButton action="#{transaction$TransactionSessionBean.nextResults}" id="btnNext"
                                                    rendered="#{transaction$TransactionSessionBean.pagination.isVisibleNext}" style="margin: 2px; height: 22px"
                                                    styleClass="My_Button_next" value="#{resources.pagination_next}"/>
                                                <h:commandButton action="#{transaction$TransactionSessionBean.pagination.lastResults}" id="btnLast"
                                                    rendered="#{transaction$TransactionSessionBean.pagination.isVisibleNext}" style="margin: 2px;height: 22px"
                                                    styleClass="My_Button_last" value="#{resources.pagination_last}"/>
                                            </webuijsf:panelGroup>
                                        </webuijsf:panelGroup>
                                        <h:dataTable binding="#{transaction$EditTransaction.transactedSpecimensTable}" cellspacing="0"
                                            columnClasses="list-columns" headerClass="list-header" id="dataTableTransactedSpecimens"
                                            rowClasses="list-row-even,list-row-odd" rows="#{transaction$TransactionSessionBean.pagination.resultsPerPage}"
                                            style="border-top: solid rgb(214, 218, 221) 2px; border-bottom: solid rgb(214, 218, 221) 2px; border-left: solid rgb(214, 218, 221) 2px; "
                                            value="#{transaction$TransactionSessionBean.pagination.dataProvider.list}" var="currentRow" width="839">
                                            <h:column>
                                                <h:selectBooleanCheckbox id="checkbox1" value="#{currentRow['selected']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.catalognumber}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['catalogNumber']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.delivery_date}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['deliveryDate']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.receiving_date}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['receivingDate']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.transacted_specimen_status}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['transactedSpecimenStatus']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.taxon_name}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['taxonName']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.description}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['description']}"/>
                                            </h:column>
                                        </h:dataTable>
                                    </h:panelGrid>
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
