<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
	<jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
	<f:view>
		<webuijsf:page binding="#{admin$person$listPerson.page1}" id="page1">
			<webuijsf:html binding="#{admin$person$listPerson.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
				<webuijsf:body binding="#{admin$person$listPerson.body1}" id="body1" style="-rave-layout: grid">
					<jsp:directive.include file="/Header.jspf"/>
					<webuijsf:panelLayout id="contenido">
						<webuijsf:form binding="#{admin$person$listPerson.form1}" id="form1">
							<webuijsf:table binding="#{admin$person$listPerson.personTable}" clearSortButton="true" id="personTable" paginateButton="true"
											paginationControls="true" sortPanelToggleButton="true" style="left: 48px; top: 72px; position: absolute; width: 780px"
											title="#{resources.title}" width="780">
								<webuijsf:tableRowGroup binding="#{admin$person$listPerson.tableRowGroup1}" id="tableRowGroup1" rows="10"
														sourceData="#{admin$person$PersonSessionBean.personDataProvider}" sourceVar="currentRow">
									<webuijsf:tableColumn binding="#{admin$person$listPerson.tableColumn1}" headerText="#{resources.id}" id="tableColumn1" sort="id">
										<webuijsf:staticText binding="#{admin$person$listPerson.staticText1}" id="staticText1" text="#{currentRow.value['id']}"/>
									</webuijsf:tableColumn>
									<webuijsf:tableColumn binding="#{admin$person$listPerson.tableColumn2}" headerText="#{resources.name}" id="tableColumn2" sort="firstName">
										<webuijsf:staticText binding="#{admin$person$listPerson.staticText2}" id="staticText2" text="#{currentRow.value['firstName']}"/>
									</webuijsf:tableColumn>
									<webuijsf:tableColumn binding="#{admin$person$listPerson.tableColumn3}" headerText="#{resources.last}" id="tableColumn3" sort="lastName">
										<webuijsf:staticText binding="#{admin$person$listPerson.staticText3}" id="staticText3" text="#{currentRow.value['lastName']}"/>
									</webuijsf:tableColumn>
									<webuijsf:tableColumn binding="#{admin$person$listPerson.tableColumn4}" headerText="#{resources.second}" id="tableColumn4" sort="lastName">
										<webuijsf:staticText binding="#{admin$person$listPerson.staticText4}" id="staticText4" text="#{currentRow.value['secondLastName']}"/>
									</webuijsf:tableColumn>
									<webuijsf:tableColumn binding="#{admin$person$listPerson.tableColumn5}" headerText="#{resources.actions}" id="tableColumn5">
										<webuijsf:button actionExpression="#{admin$person$listPerson.button1_action}"
														 binding="#{admin$person$listPerson.button1}" id="button1" text="#{resources.btnEdit}"/>
										<webuijsf:button actionExpression="#{admin$person$listPerson.button2_action}"
														 binding="#{admin$person$listPerson.button2}" id="button2" text="#{resources.btnDelete}"/>
									</webuijsf:tableColumn>
								</webuijsf:tableRowGroup>
								<f:facet name="actionsTop">
									<webuijsf:panelGroup id="groupPanel1">
										<webuijsf:button actionExpression="#{admin$person$listPerson.btn_new_action}"
														 binding="#{admin$person$listPerson.btn_new}" id="btn_new" text="#{resources.btnNew}"/>
										<webuijsf:button actionExpression="#{admin$person$listPerson.btn_search_action}"
														 binding="#{admin$person$listPerson.btn_search}" id="btn_search" text="#{resources.btnSearch}"/>
										<webuijsf:button actionExpression="#{admin$person$listPerson.btn_showAll_action}"
														 binding="#{admin$person$listPerson.btn_showAll}" id="btn_reload" text="#{resources.btnUpdate}"/>
									</webuijsf:panelGroup>
								</f:facet>
							</webuijsf:table>
							<webuijsf:alert binding="#{admin$person$listPerson.personAlert}" id="personAlert"
											style="height: 46px; left: 192px; top: 96px; position: absolute; width: 670px" visible="false"/>
							<h:messages binding="#{admin$person$listPerson.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1"
										infoClass="infoMessage" layout="table" style="left: 432px; top: 24px; position: absolute" warnClass="warnMessage"/>
							<webuijsf:label binding="#{admin$person$listPerson.label1}" id="label1"
											style="font-size: 24px; height: 28px; left: 48px; top: 24px; position: absolute; width: 262px" text="#{resources.people}"/>
						</webuijsf:form>
					</webuijsf:panelLayout>
					<jsp:directive.include file="/footer.jspf"/>
				</webuijsf:body>
			</webuijsf:html>
		</webuijsf:page>
	</f:view>
</jsp:root>
