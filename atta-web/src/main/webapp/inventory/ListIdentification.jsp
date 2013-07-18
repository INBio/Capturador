<?xml version="1.0" encoding="UTF-8"?>
<!--
	Document   : ListIdentification
	Created on : 14/08/2009, 10:35:00 PM
	Author     : asanabria
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:script id="scriptX" type="text/javascript">

                        /**
                         *
                         * variables globales para accesar el textField de CatalogNumber que contiene el texto de confirmación de borrado.
                         *
                         * NOTA: Es importante cambiar estas variables cada vez que la estructura de este JSP varíe.
                         */

                        var tfBarcode = 'contenido:form1:tfBarcode';
                        var btnAddBarcode = 'contenido:form1:btnAddBarcode';
                        var deleteConfirmationText = 'contenido:form1:deleteConfirmationText';
                        

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
                                var text = new String(document.getElementById(tfBarcode).value);
                                text = text.trim()
                                if(text != "")
                                    document.getElementById(btnAddBarcode).click();
                                else
                                    return false;
                            }
                            return true;
                        }

                        /**
                         *
                         * Función que pone el foco en el textField de CatalogNumber
                         */
                        function setFocusTfBarcode() {
                            var textField = document.getElementById(tfBarcode);
                            textField.focus();
                        }


                        /**
                         * Muestra un cuadro de dialogo para confirmación de eliminación
                         */
                         function deleteConfirmation() {
                            var confirmationText = document.getElementById(deleteConfirmationText).value;
                            return confirm(confirmationText);
                        }

            </webuijsf:script>
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link id="link2" url="/resources/css/stylesheet.css"/>

                </webuijsf:head>
                <webuijsf:body id="body1" onLoad="setFocusTfBarcode();" style="-rave-layout: grid">
                    <div id="pageFormated">
                        <jsp:directive.include file="/Header.jspf"/>
                        <webuijsf:panelLayout id="contenido">
                            <webuijsf:form id="form1">
                                <h:outputLabel id="lbIdentificationTitle" style="height: 24px; left: 24px; position: relative; width: 850px"
                                    styleClass="Page_title" value="#{resources.titleIdentificationList}"/>
                                <h:panelGrid id="gridpIdentification" style="height: 24px; position: relative;width:95%">
                                    <h:messages errorClass="errorMessage" fatalClass="fatalMessage" id="msgListIdentification" infoClass="infoMessage"
                                        style="height: 24px; width: 574px" warnClass="warnMessage"/>
                                    <h:panelGrid columns="4" id="gridpSearch" style="height: 24px" width="840">
                                        <h:inputText binding="#{inventory$ListIdentification.txSearch}" id="txIdentification" style="height: 18px; width: 342px"/>
                                        <h:commandButton action="#{inventory$ListIdentification.btnSearchAction}" binding="#{inventory$ListIdentification.btnSeach}"
                                            id="btnIdentificationSearch" style="height: 25px; width: 160px" styleClass="My_Button" value="#{resources.search_identification}"/>
                                        <h:commandButton action="#{inventory$ListIdentification.btnAdvSeachAction}"
                                            binding="#{inventory$ListIdentification.btnAdvSeach}" id="btnAdvIdentificationSearc" style="height: 25px; width: 160px"
                                            styleClass="My_Button" value="#{resources.advanced_search}"/>
                                        <h:commandButton action="#{inventory$ListIdentification.btnReIdentifyAction}"
                                            binding="#{inventory$ListIdentification.btnReIdentify}" id="btnReIdentification" style="height: 25px; width: 160px"
                                            styleClass="My_Button" value="#{resources.re_identify}"/>
                                    </h:panelGrid>
                                    <h:panelGrid binding="#{inventory$ListIdentification.gridpAdvancedSearch}" columns="1" id="gridpAdvancedSearch" rendered="false"
                                        style="height: 5px" styleClass="My_panel_blue" width="840">
                                        <h:panelGrid columns="4" id="gridpAdvancedSearchForm" style="height: 24px" width="745">
                                                                                       
                                            <webuijsf:label for="txGathObsDetail" id="lbGathObsDetail" binding="#{inventory$ListIdentification.lbGathObsDetail}" text="#{resources.record_number}"/>
                                            <webuijsf:textField binding="#{inventory$ListIdentification.txGathObsDetail}" id="txGathObsDetail"/>
                                            
                                            <webuijsf:label for="txGathObsDetCollector" id="lbGathObsDetCollector" binding="#{inventory$ListIdentification.lbGathObsDetCollector}" text="#{resources.collector}"/>
                                            <webuijsf:textField binding="#{inventory$ListIdentification.txGathObsDetCollector}" id="txGathObsDetCollector"/>
                                            
                                            <webuijsf:label for="txCatalogNumber" id="lbCatalogNumber" text="#{resources.catalognumber}"/>
                                            <webuijsf:textField binding="#{inventory$ListIdentification.txCatalogNumber}" id="txCatalogNumber"/>
                                            
                                            <webuijsf:label for="txTaxonName" id="lbTaxonName" text="#{resources.taxon_name}"/>
                                            <webuijsf:textField binding="#{inventory$ListIdentification.txTaxonName}" id="txTaxonName"/>
                                            <webuijsf:label for="txIdentifierName" id="lbIdentifierName" text="#{resources.person_identifier}"/>
                                            <webuijsf:textField binding="#{inventory$ListIdentification.txIdentifierName}" id="txIdentifierName"/>
                                            <webuijsf:label for="ddStatusName" id="lbStatusName" text="#{resources.status}"/>
                                            <webuijsf:dropDown id="ddStatusName"
                                                items="#{inventory$ListIdentification.ddStatusData.options}" selected="#{inventory$ListIdentification.ddStatusSelected}"/>
                                                                                    <webuijsf:label for="ddTypeName" id="lbTaxon" text="#{resources.type}"/>
                                            <webuijsf:dropDown id="ddTypeName"
                                                items="#{inventory$ListIdentification.ddTypeData.options}" selected="#{inventory$ListIdentification.ddTypeSelected}"/>
                                            <h:commandButton action="#{inventory$ListIdentification.btnProceedSearcAction}" id="btnAdvSearchGO1"
                                                style="width: 160px" styleClass="My_Button" value="#{resources.button_proceed}"/>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <h:panelGrid binding="#{inventory$ListIdentification.gridpReIdentify}" columns="1" id="gridpReidentify" rendered="false"
                                        style="height: 5px" styleClass="My_panel_blue" width="100%">
                                        <h:panelGrid columns="3" id="gridpReidentifyForm" style="height: 24px" width="100%">
                                            <!-- Column 1 -->
                                            <h:panelGrid cellspacing="1" columns="1" style="height: 24px" >

                                                <!-- Type -->
                                                <h:panelGrid cellspacing="1" columns="2" id="gridpIdentificationType">
                                                    <webuijsf:label for="ddTypeNameReidentify" id="lbTaxonReidentify" text="#{resources.type}"/>
                                                    <webuijsf:dropDown binding="#{inventory$ListIdentification.ddType}" id="ddTypeNameReidentify"
                                                                       items="#{inventory$ListIdentification.ddTypeData.options}"
                                                                       selected="#{inventory$ListIdentification.ddTypeSelected}"
                                                                       width="200px"/>
                                                </h:panelGrid>

                                                <!-- Taxonomical level -->
                                                <webuijsf:panelGroup id="grouppTaxaLevel" style="height: 24px; width: 384px">
                                                    <webuijsf:label for="ddTaxonomicLevel" id="lbTaxonomicLevel" text="#{resources.taxonomic_level}"/>
                                                    <webuijsf:dropDown binding="#{inventory$ListIdentification.ddTaxonomicalRange}"
                                                                                                  id="ddTaxonomicalRange"
                                                        items="#{inventory$ListIdentification.ddTaxonomicalRangeData.options}"
                                                        selected="#{inventory$ListIdentification.ddTaxonomicalRangeSelected}"
                                                                                                    actionExpression="#{inventory$ListIdentification.updateTaxonListAction}"
                                                                                                    submitForm="true"
                                                                                                    width="154px"/>
                                                </webuijsf:panelGroup>
                                            
                                                <!-- AddRemove Component (Taxon list) -->
                                                <h:panelGrid cellspacing="1" columns="1" id="gridpAddRemove" style="height: 24px" styleClass="My_table">
                                                    <!-- Title -->
                                                    <h:panelGrid columns="1" id="gridpArTitle" styleClass="My_table_top" width="100%">
                                                        <h:outputLabel id="lbArTitle" value="#{inventory$IdentificationSessionBean.arTaxonList.lbTitle}"/>
                                                    </h:panelGrid>
                                                    <!-- Add Remove body -->
                                                    <h:panelGrid cellspacing="1" columns="3">
                                                        <!-- Available List -->
                                                    <h:panelGrid cellspacing="1" columns="1">
                                                            <h:outputLabel id="lbAvailableTaxonOptions" styleClass="My_white_label" value="#{inventory$IdentificationSessionBean.arTaxonList.lbAvailable}"/>
                                                            <h:selectManyListbox id="mlAvaibleList" size="7" style="width:154px" value="#{inventory$IdentificationSessionBean.arTaxonList.leftSelected}" >
                                                                <f:selectItems id="mlAvailableSelectItems" value="#{inventory$IdentificationSessionBean.arTaxonList.leftOptions}"/>
                                                            </h:selectManyListbox>
                                                        </h:panelGrid>
                                                        <!-- Buttons Panel -->
                                                        <h:panelGrid cellspacing="1" columns="1">
                                                            <!-- boton Agregar -->
                                                            <h:commandButton action="#{inventory$IdentificationSessionBean.arTaxonList.addSelectedOptions}"
                                                            id="btnAddOptions"
                                                                             style="margin: 2px;height: 22px" styleClass="My_Button_add"/>
                                                            <!-- boton Remover -->
                                                            <h:commandButton action="#{inventory$IdentificationSessionBean.arTaxonList.removeSelectedOptions}"
                                                            id="btnRemoveOptions"
                                                                             style="margin: 2px;height: 22px" styleClass="My_Button_remove"/>
                                                        </h:panelGrid>
                                                        <!-- Selected List -->
                                                        <h:panelGrid cellspacing="1" columns="1">
                                                            <h:outputLabel id="lbSelectedTaxonOptions" styleClass="My_white_label" value="#{inventory$IdentificationSessionBean.arTaxonList.lbSelected}"/>
                                                            <h:selectManyListbox id="mlSelectedList" size="7" style="width:154px" value="#{inventory$IdentificationSessionBean.arTaxonList.rightSelected}">
                                                                <f:selectItems id="mlSelectedSelectItems" value="#{inventory$IdentificationSessionBean.arTaxonList.rightOptions}"/>
                                                            </h:selectManyListbox>
                                                        </h:panelGrid>


                                                    </h:panelGrid>
                                                </h:panelGrid>
                                                <!-- End AddRemove Component (Taxon list)-->
                                            </h:panelGrid>
                                            <h:panelGrid cellspacing="1" columns="1" style="height: 24px" >
                                                <!-- Validator -->
                                                <h:panelGrid cellspacing="1" columns="2" id="gridpValidator">
                                                    <webuijsf:label for="ddValidatorReidentify" id="lbValidatorReidentify" text="#{resources.validator}"/>
                                                    <webuijsf:dropDown id="ddValidatorReidentify"  binding="#{inventory$ListIdentification.ddValidatorsData}"
                                                                       items="#{inventory$ListIdentification.validatorsData.options}"
                                                                       selected="#{inventory$ListIdentification.ddValidatorSelected}"
                                                                       width="200px"/>
                                                </h:panelGrid>
                                                <!-- Status -->
                                                <h:panelGrid  cellspacing="1" columns="2" id="gridpStatus">
                                                    <webuijsf:label for="ddStatusNameReidentify" id="lbStatusNameReidentify" text="#{resources.status}"/>
                                                    <webuijsf:dropDown binding="#{inventory$ListIdentification.ddStatus}" id="ddStatusNameReidentify"
                                                                       items="#{inventory$ListIdentification.ddStatusData.options}"
                                                                       selected="#{inventory$ListIdentification.ddStatusSelected}"
                                                                       width="200px"/>
                                                </h:panelGrid>
                                                <!-- AddRemove Component (Identificador) -->
                                                <h:panelGrid cellspacing="1" columns="1" id="gridpAddRemoveIdentifier" style="height: 24px" styleClass="My_table">
                                                    <!-- Title -->
                                                    <h:panelGrid columns="1" id="gridpArIdentifierTitle" styleClass="My_table_top" width="100%">
                                                        <h:outputLabel id="lbArIdentifierTitle" value="#{inventory$IdentificationSessionBean.arIdentifierList.lbTitle}"/>
                                                    </h:panelGrid>
                                                    <!-- Add Remove body -->
                                                    <h:panelGrid cellspacing="1" columns="3">
                                                        <!-- Available List -->
                                                        <h:panelGrid cellspacing="1" columns="1">
                                                            <h:outputLabel id="lbAvailableIdentifierOptions" styleClass="My_white_label" value="#{inventory$IdentificationSessionBean.arIdentifierList.lbAvailable}"/>
                                                            <h:selectManyListbox id="mlAvaibleIdentifierList" size="7" style="width:154px" value="#{inventory$IdentificationSessionBean.arIdentifierList.leftSelected}">
                                                                                                                    <f:selectItems id="mlAvailableIdentifierSelectItems" value="#{inventory$IdentificationSessionBean.arIdentifierList.leftOptions}"/>
                                                            </h:selectManyListbox>
                                                        </h:panelGrid>
                                                        <!-- Buttons Panel -->
                                                        <h:panelGrid cellspacing="1" columns="1">
                                                            <!-- boton Agregar -->
                                                            <h:commandButton action="#{inventory$IdentificationSessionBean.arIdentifierList.addSelectedOptions}"
                                                                id="btnAddIdentifierOptions"
                                                                style="margin: 2px;height: 22px" styleClass="My_Button_add"/>
                                                            <!-- boton Remover -->
                                                            <h:commandButton action="#{inventory$IdentificationSessionBean.arIdentifierList.removeSelectedOptions}"
                                                                                                                                                 id="btnRemoveIdentifierOptions" style="margin: 2px;height: 22px" styleClass="My_Button_remove"/>
                                                        </h:panelGrid>
                                                        <!-- Selected List -->
                                                        <h:panelGrid cellspacing="1" columns="1">
                                                            <h:outputLabel id="lbSelectedIdentifierOptions" styleClass="My_white_label" value="#{inventory$IdentificationSessionBean.arIdentifierList.lbSelected}"/>
                                                            <h:selectManyListbox id="mlSelectedIdentifierList" size="7" style="width:154px" value="#{inventory$IdentificationSessionBean.arIdentifierList.rightSelected}">
                                                               <f:selectItems id="mlSelectedIdentifierSelectItems" value="#{inventory$IdentificationSessionBean.arIdentifierList.rightOptions}"/>
                                                            </h:selectManyListbox>
                                                        </h:panelGrid>
                                                    </h:panelGrid>
                                                </h:panelGrid>
                                                <!-- End AddRemove Component (Identificador)-->
                                                </h:panelGrid>
                                                <!-- Agrupados por códigos de barras -->
                                                <h:panelGrid cellspacing="1" columns="1" id="gridpBarcodeList" style="height: 24px" >
                                                    <webuijsf:label for="tfBarcode" text="#{resources.barCode}" />
                                                    <h:inputText id="tfBarcode" onkeypress="return isEnter(event)" value="#{inventory$IdentificationSessionBean.specimenBarcode}" />
<!--
                                                    <h:commandButton id="btnAddBarcode"
                                                                  style="width: 160px"
                                                                  styleClass="My_Button"
                                                                  value="#{resources.add}"
                                                                  action="#{inventory$ListIdentification.btnAddBarcodeAction}"  />
                                                    <h:commandButton id="btnDelBarcode"
                                                                  style="width: 160px"
                                                                  styleClass="My_Button"
                                                                  value="#{resources.delete}"
                                                                  action="#{inventory$ListIdentification.btnDeleteBarcodeAction}"  />
-->
                                                    <webuijsf:label for="mlSelectedBarcodeList" text="#{resources.barCodeList}"/>

                                                    <h:selectManyListbox id="mlSelectedBarcodeList" size="7" style="width:154px" value="#{inventory$IdentificationSessionBean.specimenBarcodeSelected}" >
                                                     <f:selectItems id="mlSelectedBarcodeListItems" value ="#{inventory$IdentificationSessionBean.specimenBarcodeList}"/>
                                                    </h:selectManyListbox>
                                                </h:panelGrid>
                                                <!-- Proceed button -->
                                                <h:commandButton action="#{inventory$ListIdentification.btnProceedReIdentifyAction}" id="btnAdvSearchGO2"
                                                    style="width: 160px" styleClass="My_Button" value="#{resources.button_proceed}"  onclick="return deleteConfirmation();"  />
                                            </h:panelGrid>
                                        <h:inputHidden id="deleteConfirmationText" binding="#{inventory$ListIdentification.deleteConfirmationText}"/>
                                    </h:panelGrid>
                                    <h:panelGrid cellspacing="1" columns="1" id="gridpTableButtons" style="width:100%" styleClass="My_table">
                                        <webuijsf:panelGroup id="grouppButtons">
                                            <h:panelGrid columns="1" id="gridpquantity" styleClass="My_table_top" style="width:100%">
                                                <h:outputLabel id="labelQuantity" value="#{inventory$ListIdentification.quantityTotal}"/>
                                            </h:panelGrid>
                                            <webuijsf:panelGroup id="panelPaginacion" separator=" " style="margin-left:70px;">
                                                <h:commandButton action="#{inventory$IdentificationSessionBean.pagination.firstResults}" id="btnFirst"
                                                    rendered="#{inventory$IdentificationSessionBean.pagination.isVisiblePrevious}" style="margin: 2px;height: 22px"
                                                    styleClass="My_Button_first" value="#{resources.pagination_first}"/>
                                                <h:commandButton action="#{inventory$IdentificationSessionBean.pagination.previousResults}" id="btnPrevious"
                                                    rendered="#{inventory$IdentificationSessionBean.pagination.isVisiblePrevious}" style="margin: 2px;height: 22px"
                                                    styleClass="My_Button_previous" value="#{resources.pagination_previous}"/>
                                                <h:commandButton action="#{inventory$IdentificationSessionBean.pagination.nextResults}" id="btnNext"
                                                    rendered="#{inventory$IdentificationSessionBean.pagination.isVisibleNext}" style="margin: 2px; height: 22px"
                                                    styleClass="My_Button_next" value="#{resources.pagination_next}"/>
                                                <h:commandButton action="#{inventory$IdentificationSessionBean.pagination.lastResults}" id="btnLast"
                                                    rendered="#{inventory$IdentificationSessionBean.pagination.isVisibleNext}" style="margin: 2px;height: 22px"
                                                    styleClass="My_Button_last" value="#{resources.pagination_last}"/>
                                            </webuijsf:panelGroup>
                                        </webuijsf:panelGroup>
                                        <h:dataTable binding="#{inventory$ListIdentification.dataTableIdentifications}" cellspacing="0" columnClasses="list-columns"
                                            headerClass="list-header" id="dataTableIdentifications" rowClasses="list-row-even,list-row-odd"
                                            rows="#{inventory$IdentificationSessionBean.pagination.resultsPerPage}"
                                            style="border-top: solid rgb(214, 218, 221) 2px; border-bottom: solid rgb(214, 218, 221) 2px; border-left: solid rgb(214, 218, 221) 2px;width:100%;"
                                            value="#{inventory$IdentificationSessionBean.pagination.dataProvider.list}" var="currentRow">
                                            <h:column>
                                                <h:selectBooleanCheckbox id="checkbox1" value="#{currentRow['selected']}"/>
                                            </h:column>
                                            <h:column binding="#{inventory$ListIdentification.catgNumberColumnFirst}">
                                                <f:facet name="header">
                                                    <h:commandLink id="menuSubsystemInventory" styleClass="My_search_icon" value="#{resources.catalognumber}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['catalogNumber']}"/>
                                            </h:column>
                                            <h:column binding="#{inventory$ListIdentification.gathObsDetailColumn}">
                                                <f:facet name="header">
                                                    <h:commandLink id="gatheringObsDetail" styleClass="My_search_icon" value="#{resources.record_number}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['gathObsDetailNumber']}"/>
                                            </h:column>
                                            <h:column binding="#{inventory$ListIdentification.collectorGathObsDetailColumn}">
                                                <f:facet name="header">
                                                    <h:commandLink id="collectorGathObsDetail" styleClass="My_search_icon" value="#{resources.collector}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['collectorNameGathObsDetail']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:commandLink id="gatheringObservation" styleClass="My_search_icon" value="#{resources.gathering}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['gatheringObservationId']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.taxon_name}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['taxonString']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.person_identifier}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['identifierString']}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.status}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['statusName']}"/>
                                            </h:column>
                                            <h:column rendered="false">
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.type}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['typeName']}"/>
                                            </h:column>
                                            <h:column rendered="false">
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.validator}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['valuerPersonName']}"/>
                                            </h:column>
                                             <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="#{resources.identification_date}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['identificationDate']}"/>
                                            </h:column>
                                            <h:column binding="#{inventory$ListIdentification.catgNumberColumnLast}">
                                                <f:facet name="header">
                                                    <h:commandLink id="catalogNumberLast" styleClass="My_search_icon" value="#{resources.catalognumber}"/>
                                                </f:facet>
                                                <h:outputText value="#{currentRow['catalogNumber']}"/>
                                            </h:column>
                                        </h:dataTable>
                                    </h:panelGrid>
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
