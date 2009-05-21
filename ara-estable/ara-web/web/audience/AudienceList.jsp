<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
	<jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
	<f:view>
		<webuijsf:page binding="#{audience$AudienceList.page1}" id="page1">
			<webuijsf:html binding="#{audience$AudienceList.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
				<webuijsf:body binding="#{audience$AudienceList.body1}" id="body1" style="-rave-layout: grid">
					<jsp:directive.include file="/Header.jspf"/>
					<webuijsf:panelLayout id="contenido">
						<webuijsf:form binding="#{audience$AudienceList.form1}" id="form1">
							<webuijsf:table binding="#{audience$AudienceList.audienceTable}" clearSortButton="true" id="audienceTable" paginateButton="true"
											paginationControls="true" sortPanelToggleButton="true" style="left: 48px; top: 72px; position: absolute; width: 507px"
											title="#{resources.audiences_target_audiences}" width="507">
								<webuijsf:tableRowGroup binding="#{audience$AudienceList.tableRowGroup1}" id="tableRowGroup1" rows="10"
														sourceData="#{audience$AudienceSessionBean.audienceDataProvider}" sourceVar="currentRow">
									<webuijsf:tableColumn binding="#{audience$AudienceList.tableColumn1}" headerText="#{resources.id}" id="tableColumn1" sort="id">
										<webuijsf:staticText binding="#{audience$AudienceList.staticText1}" id="staticText1" text="#{currentRow.value['id']}"/>
									</webuijsf:tableColumn>
									<webuijsf:tableColumn binding="#{audience$AudienceList.tableColumn2}" headerText="#{resources.name}" id="tableColumn2" sort="name">
										<webuijsf:staticText binding="#{audience$AudienceList.staticText2}" id="staticText2" text="#{currentRow.value['name']}"/>
									</webuijsf:tableColumn>
									<webuijsf:tableColumn binding="#{audience$AudienceList.tableColumn3}" headerText="#{resources.description}"
														  id="tableColumn3" sort="description">
										<webuijsf:staticText binding="#{audience$AudienceList.staticText3}" id="staticText3" text="#{currentRow.value['description']}"/>
									</webuijsf:tableColumn>
									<webuijsf:tableColumn binding="#{audience$AudienceList.tableColumn4}" headerText="#{resources.actions}" id="tableColumn4" width="200">
										<webuijsf:button actionExpression="#{audience$AudienceList.btn_edit_action}" binding="#{audience$AudienceList.btn_edit}"
														 id="btn_edit" text="#{resources.btnEdit}"/>
										<webuijsf:button actionExpression="#{audience$AudienceList.btn_remove_action}"
														 binding="#{audience$AudienceList.btn_remove}" id="btn_remove" text="#{resources.btnDelete}"/>
									</webuijsf:tableColumn>
								</webuijsf:tableRowGroup>
								<f:facet name="actionsTop">
									<f:subview id="actionsTop">
										<webuijsf:button actionExpression="#{audience$AudienceList.btn_new_action}" binding="#{audience$AudienceList.btn_new}"
														 id="btn_new" text="#{resources.btnNew}"/>
									</f:subview>
								</f:facet>
							</webuijsf:table>
							<webuijsf:label binding="#{audience$AudienceList.label1}" id="label1"
											style="font-size: 24px; height: 22px; left: 48px; top: 24px; position: absolute; width: 310px" text="#{resources.audiences}"/>
							<h:messages binding="#{audience$AudienceList.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1"
										infoClass="infoMessage" style="left: 384px; top: 24px; position: absolute" warnClass="warnMessage"/>
						</webuijsf:form>
					</webuijsf:panelLayout>
					<jsp:directive.include file="/footer.jspf"/>

				</webuijsf:body>
			</webuijsf:html>
		</webuijsf:page>
	</f:view>
</jsp:root>
