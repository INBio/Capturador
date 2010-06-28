<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ListTransaction
    Created on : Feb 18, 2010, 4:52:31 PM
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
                         * variable del HiddenField que contiene el texto de confirmación de borrado.
                         *
                         * NOTA: Es importante cambiar estaa variable cada vez que la estructura de este JSP varíe.
                         */
                        var deleteConfirmationTextId = 'contenido:form1:grouppButtons:panelPaginacion:deleteConfirmationText';

                        /**
                         *
                         * Función que pide confirmación de borrado al usuario
                         */
                        function deleteConfirmation() {
                            var confirmationText = document.getElementById(deleteConfirmationTextId).value;
                            return confirm(confirmationText);
                        }
                    </webuijsf:script>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form1">
                            <webuijsf:label id="lbTitle" style="height: 24px; left: 24px; top: 24px; position: absolute; width: 850px"
                                styleClass="Page_title" text="#{resources.menuModuleTransaction}"/>
                            <h:panelGrid columns="1" id="gridpMain" style="left: 24px; top: 48px; position: absolute" width="850">
                                <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msglMessages" infoClass="infoMessage"
                                    style="height: 30px; width: 840px" warnClass="warnMessage"/>
                                <h:panelGrid columns="3" id="gridpSearch" style="height: 24px" width="719">
                                    <h:inputText binding="#{transaction$ListTransaction.txSearch}" id="txSearch" style="height: 18px; width: 408px">
                                        <f:validateLength maximum="100" minimum="0"/>
                                    </h:inputText>
                                    <h:commandButton action="#{transaction$ListTransaction.btnTransactionSearch_action}" binding="#{transaction$ListTransaction.btnTransactionSearch}"
                                        id="btnTransactionSearch" style="height: 25px; width: 160px" styleClass="My_Button" value="#{resources.search}"/>
                                    <h:commandButton action="#{transaction$ListTransaction.btnAdvTransactionSearch_action}"
                                        binding="#{transaction$ListTransaction.btnAdvTransactionSearch}" id="btnAdvTransactionSearch" style="height: 25px; width: 160px"
                                        styleClass="My_Button" value="#{resources.advanced_search}"/>
                                </h:panelGrid>
                                <h:panelGrid binding="#{transaction$ListTransaction.pgAdvancedSearch}" columns="1" id="pgAdvancedSearch" rendered="false"
                                    style="height: 5px" styleClass="My_panel_blue" width="850">
                                    <h:panelGrid columns="2" style="height: 5px" width="840">
                                        <h:panelGrid columns="2" id="pgAdvancedSearchCol1" style="height: 24px" width="400" >

                                            <!-- ********** Transaction Number ********** -->
                                            <webuijsf:label for="txTransactionNumber" text="#{resources.transaction_number}"/>
                                            <webuijsf:textField columns="25" id="txTransactionNumber" text="#{transaction$TransactionSessionBean.searchDataDTO.transactionId}"/>

                                            <!-- ********** Transaction Date ********** -->
                                            <!--<webuijsf:label for="clTransactionDate" text="#{resources.transaction_date}"/>
                                            <webuijsf:calendar binding="#{transaction$ListTransaction.clTransactionDate}" columns="22"
                                                    dateFormatPattern="#{resources.date_format}" id="clTransactionDate"/>-->

                                            <!-- ********** Invoice Number ********** -->
                                            <webuijsf:label for="txInvoiceNumber" text="#{resources.invoice_number}"/>
                                            <webuijsf:textField columns="25" id="txInvoiceNumber" text="#{transaction$TransactionSessionBean.searchDataDTO.invoiceNumber}"/>

                                            <!-- ********** Estimated Specimen Count ********** -->
                                            <webuijsf:label for="txEstimatedSpecimenCount" text="#{resources.estimated_specimen_count}"/>
                                            <webuijsf:textField columns="25" id="txEstimatedSpecimenCount" text="#{transaction$TransactionSessionBean.searchDataDTO.estimatedSpecimenCount}"/>

                                            <!-- ********** Expiration Date ********** -->
                                            <!--<webuijsf:label for="clExpirationDate" text="#{resources.expiration_date}"/>
                                            <webuijsf:calendar binding="#{transaction$ListTransaction.clExpirationDate}" columns="22"
                                                dateFormatPattern="#{resources.date_format}" id="clExpirationDate"/>-->

                                            <!-- ********** Description ********** -->
                                            <webuijsf:label for="txaDescription" text="#{resources.description}"/>
                                            <webuijsf:textArea columns="23" id="txaDescription" text="#{transaction$TransactionSessionBean.searchDataDTO.description}"/>
                                            <!--<h:commandButton id="btnAdvSearchGO" action="#{transaction$ListTransaction.btnAdvSearchGO_action}"
                                                style="width: 160px" styleClass="My_Button" value="#{resources.button_proceed}"/>-->
                                        </h:panelGrid>
                                        <h:panelGrid columns="2" id="pgAdvancedSearchCol2" style="height: 24px" width="400" >

                                            <!-- ********** Sender Institution ********** -->
                                            <webuijsf:label for="ddSenderInstitution" text="#{resources.sender_institution}"/>
                                            <webuijsf:dropDown actionExpression="#{transaction$ListTransaction.updateSenderPersonListAction}" id="ddSenderInstitution"
                                                items="#{transaction$ListTransaction.institutionData.options}" submitForm="true"
                                                selected="#{transaction$TransactionSessionBean.searchDataDTO.senderInstitutionId}" width="192px"/>

                                            <!-- ********** Sender Person ********** -->
                                            <webuijsf:label for="ddSenderPerson" text="#{resources.sender_person}"/>
                                            <webuijsf:dropDown id="ddSenderPerson" items="#{transaction$ListTransaction.senderPersonData.options}"
                                                selected="#{transaction$TransactionSessionBean.searchDataDTO.senderPersonId}" width="192px"/>

                                            <!-- ********** Receiver Institution ********** -->
                                            <webuijsf:label for="ddReceiverInstitutionId" text="#{resources.receiver_institution}"/>
                                            <webuijsf:dropDown actionExpression="#{transaction$ListTransaction.updateReceiverPersonListAction}" id="ddReceiverInstitution"
                                                items="#{transaction$ListTransaction.institutionData.options}" submitForm="true"
                                                selected="#{transaction$TransactionSessionBean.searchDataDTO.receiverInstitutionId}" width="192px"/>

                                            <!-- ********** Receiver Person ********** -->
                                            <webuijsf:label for="ddReceiverPerson" text="#{resources.receiver_person}"/>
                                            <webuijsf:dropDown id="ddReceiverPerson" items="#{transaction$ListTransaction.receiverPersonData.options}"
                                                selected="#{transaction$TransactionSessionBean.searchDataDTO.receiverPersonId}" width="192px"/>

                                            <!-- ********** Transaction Type ********** -->
                                            <webuijsf:label for="txTransactionTypeId" text="#{resources.transaction_type}"/>
                                            <webuijsf:dropDown id="ddTransactionType" items="#{transaction$ListTransaction.transactionTypeData.options}"
                                                selected="#{transaction$TransactionSessionBean.searchDataDTO.transactionTypeId}" width="192px"/>
                                        </h:panelGrid>

                                        <h:panelGrid columns="2" id="pgAdvancedSearchCol12" style="height: 24px" styleClass="My_subpanel_blue" width="400" >

                                            <!-- ********** Initial Transaction Date ********** -->
                                            <webuijsf:label for="clInitialTransactionDate" text="Fecha Inicial"/>
                                            <webuijsf:calendar binding="#{transaction$ListTransaction.clInitialTransactionDate}" columns="14"
                                                dateFormatPattern="#{resources.date_format}" id="clInitialTransactionDate"/>

                                            <!-- ********** Final Transaction Date ********** -->
                                            <webuijsf:label for="clFinalTransactionDate" text="Fecha Final"/>
                                            <webuijsf:calendar binding="#{transaction$ListTransaction.clFinalTransactionDate}" columns="14"
                                                dateFormatPattern="#{resources.date_format}" id="clFinalTransactionDate"/>

                                        </h:panelGrid>
                                        <h:panelGrid columns="2" id="pgAdvancedSearchCol22" style="height: 24px" styleClass="My_subpanel_blue" width="400" >

                                            <!-- ********** Initial Expiration Date ********** -->
                                            <webuijsf:label for="clInitialExpirationDate" text="Fecha de Expiración Inicial"/>
                                            <webuijsf:calendar binding="#{transaction$ListTransaction.clInitialExpirationDate}" columns="14"
                                                dateFormatPattern="#{resources.date_format}" id="clInitialExpirationDate"/>

                                            <!-- ********** Final Expiration Date ********** -->
                                            <webuijsf:label for="clFinalExpirationDate" text="Fecha de Expiración Final"/>
                                            <webuijsf:calendar binding="#{transaction$ListTransaction.clFinalExpirationDate}" columns="14"
                                                dateFormatPattern="#{resources.date_format}" id="clFinalExpirationDate"/>

                                        </h:panelGrid>

                                            <h:panelGrid columns="2" id="pgAdvancedSearchCol31" style="height: 24px" width="400" >
                                                <webuijsf:label for="txCatalogNumber" id="lbCatalogNumber" style="height: 24px; width: 192px" text="#{resources.catalognumber}"/>
                                                <webuijsf:textField id="txCatalogNumber" text="#{transaction$TransactionSessionBean.searchDataDTO.catalogNumber}" columns="25"/>
                                            </h:panelGrid>

                                    </h:panelGrid>
                                        
                                    <h:commandButton id="btnAdvSearchGO" action="#{transaction$ListTransaction.btnAdvSearchGO_action}"
                                        style="width: 160px" styleClass="My_Button" value="#{resources.button_proceed}"/>
                                    <!--</h:panelGrid>-->






                                </h:panelGrid>
                                <h:panelGrid cellspacing="1" columns="1" id="gridpTableMain" style="height: 24px" styleClass="My_table" width="840">
                                    <webuijsf:panelGroup id="grouppButtons">
                                        <h:panelGrid columns="1" id="gridpquantity" styleClass="My_table_top" width="840">
                                            <h:outputLabel id="labelQuantity" value="#{transaction$ListTransaction.quantityTotal}"/>
                                        </h:panelGrid>
                                        <webuijsf:panelGroup id="panelPaginacion" separator=" " style="margin-left:70px;">
                                            <!-- Botones de acciones -->
                                            <h:commandButton id="newButton" value="#{resources.btnNew}" action="#{transaction$ListTransaction.btnTransactionNew_action}"
                                            style="margin: 2px;height: 22px" styleClass="My_Button_table"/>
                                            <h:commandButton id="editButton" value="#{resources.btnEdit}" action="#{transaction$ListTransaction.btnTransactionEdit_action}"
                                            style="margin: 2px;height: 22px" styleClass="My_Button_table"/>
                                            <h:commandButton id="deleteButton" value="#{resources.btnDelete}" onclick="return deleteConfirmation();"
                                            action="#{transaction$ListTransaction.btnTransactionDelete_action}"
                                            style="margin: 2px;height: 22px" styleClass="My_Button_table"/>
                                            <h:inputHidden binding="#{transaction$ListTransaction.deleteConfirmationText}" id="deleteConfirmationText"/>
                                            <!-- Botones de paginacion -->
                                            <h:commandButton action="#{transaction$TransactionSessionBean.pagination.firstResults}" id="btnFirst"
                                                rendered="#{transaction$TransactionSessionBean.pagination.isVisiblePrevious}" style="margin: 2px;height: 22px"
                                                styleClass="My_Button_first" value="#{resources.pagination_first}"/>
                                            <h:commandButton action="#{transaction$TransactionSessionBean.pagination.previousResults}" id="btnPrevious"
                                                rendered="#{transaction$TransactionSessionBean.pagination.isVisiblePrevious}" style="margin: 2px;height: 22px"
                                                styleClass="My_Button_previous" value="#{resources.pagination_previous}"/>
                                            <h:commandButton action="#{transaction$TransactionSessionBean.pagination.nextResults}" id="btnNext"
                                                rendered="#{transaction$TransactionSessionBean.pagination.isVisibleNext}" style="margin: 2px; height: 22px"
                                                styleClass="My_Button_next" value="#{resources.pagination_next}"/>
                                            <h:commandButton action="#{transaction$TransactionSessionBean.pagination.lastResults}" id="btnLast"
                                                rendered="#{transaction$TransactionSessionBean.pagination.isVisibleNext}" style="margin: 2px;height: 22px"
                                                styleClass="My_Button_last" value="#{resources.pagination_last}"/>
                                        </webuijsf:panelGroup>
                                    </webuijsf:panelGroup>
                                    <h:dataTable binding="#{transaction$ListTransaction.transactionTable}" cellspacing="0" columnClasses="list-columns" headerClass="list-header" id="dataTablegathering"
                                        rowClasses="list-row-even,list-row-odd" rows="#{transaction$TransactionSessionBean.pagination.resultsPerPage}"
                                        style="border-top: solid rgb(214, 218, 221) 2px; border-bottom: solid rgb(214, 218, 221) 2px; border-left: solid rgb(214, 218, 221) 2px; "
                                        value="#{transaction$TransactionSessionBean.pagination.dataProvider.list}" var="currentRow" width="839">
                                        <h:column>
                                            <h:selectBooleanCheckbox id="checkbox1" value="#{currentRow['selected']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.transaction_number}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['transactionId']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.transaction_date}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['transactionDate']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.invoice_number}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['invoiceNumber']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.estimated_specimen_count}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['estimatedSpecimenCount']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.description}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['description']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.expiration_date}"/>
                                            </f:facet>
                                            <h:outputText value="#{currentRow['expirationDate']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.sender_person}"/>
                                            </f:facet>
                                            <!--<h:outputText value="#{currentRow['senderPersonId']}"/>-->
                                            <h:outputText value="#{currentRow['senderPersonName']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.sender_institution}"/>
                                            </f:facet>
                                            <!--<h:outputText value="#{currentRow['senderInstitutionId']}"/>-->
                                            <h:outputText value="#{currentRow['senderInstitutionName']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.receiver_person}"/>
                                            </f:facet>
                                            <!--<h:outputText value="#{currentRow['receiverPersonId']}"/>-->
                                            <h:outputText value="#{currentRow['receiverPersonName']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.receiver_institution}"/>
                                            </f:facet>
                                            <!--<h:outputText value="#{currentRow['receiverInstitutionId']}"/>-->
                                            <h:outputText value="#{currentRow['receiverInstitutionName']}"/>
                                        </h:column>
                                        <h:column>
                                            <f:facet name="header">
                                                <h:outputText value="#{resources.transaction_type}"/>
                                            </f:facet>
                                            <!--<h:outputText value="#{currentRow['transactionTypeId']}"/>-->
                                            <h:outputText value="#{currentRow['transactionType']}"/>
                                        </h:column>


                                    </h:dataTable>
                                </h:panelGrid>

                                <jsp:directive.include file="/Footer.jspf"/>
                            </h:panelGrid>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>

