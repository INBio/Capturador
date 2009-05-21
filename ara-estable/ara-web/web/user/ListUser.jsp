<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
	<jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
	<f:view>
		<webuijsf:page id="Page">
			<webuijsf:html id="html">
				<webuijsf:head id="head">
					<webuijsf:link id="css" url="/resources/css/stylesheet.css"/>
					<webuijsf:script id="js" type="text/JavaScript" url="/resources/js/footer.js"/>
				</webuijsf:head>
				<webuijsf:body id="body" style="-rave-layout: grid">
					<jsp:directive.include file="/Header.jspf"/>
					<webuijsf:panelLayout id="contenido">
						<webuijsf:form id="form">
							<f:facet name="header"/>
							<h:messages errorClass="errorMessage" 
										fatalClass="fatalMessage"
										id="messageList"
										infoClass="infoMessage"
										style="left: 432px; top: 24px; position: absolute"
										warnClass="warnMessage"/>
							<webuijsf:label id="usersLabel"
											style="font-size: 24px; height: 28px; left: 48px; top: 24px; position: absolute; width: 334px"
											text="#{resources.users}"/>

							<webuijsf:table clearSortButton="true"
											deselectMultipleButton="true"
											id="UsersTable"
											paginateButton="true"
											paginationControls="true"
											style="left: 48px; top: 72px; position: absolute"
											title="#{resources.users}"
											width="864">
							<f:facet name="actionsTop">
								<f:subview id="actionsTop">
									<webuijsf:button actionExpression="#{user$ListUser.addAction}"
													 id="btnNew"
													 style="height: 24px; width: 71px"
													 text="#{resources.btnNew}"/>
								</f:subview>
							</f:facet>
							<webuijsf:tableRowGroup id="usersTableRowGroup"
													binding="#{user$ListUser.usersTableRowGroup}"
													rows="10"
													sourceData="#{UserSessionBean.userListDataProvider}"
													sourceVar="currentRow">
								<webuijsf:tableColumn headerText="#{resources.id}"
														id="idTableColumn"
														sort="id"
														width="89">
									<webuijsf:staticText id="userKeyText"
														 text="#{currentRow.value['userKey']}"/>
								</webuijsf:tableColumn>
									<webuijsf:tableColumn headerText="#{resources.username}"
														  id="userNameTableColumn"
														  noWrap="true"
														  sort="userName"
														  width="122">
										<webuijsf:staticText id="userNameText"
															 text="#{currentRow.value['userName']}"/>
									</webuijsf:tableColumn>
									<webuijsf:tableColumn headerText="#{resources.full_name}"
														  id="fullNameTableColumn"
														  noWrap="true"
														  sort="fullName"
														  width="188">
										<webuijsf:staticText id="fullNameText"
															 text="#{currentRow.value['fullName']}"/>
									</webuijsf:tableColumn>
									<webuijsf:tableColumn align="center"
														  headerText="#{resources.actions}"
														  id="buttonsTableColumn"
														  width="191">
										<webuijsf:button actionExpression="#{user$ListUser.editAction}"
														 id="btnEdit"
														text="#{resources.btnEdit}"/>
										<webuijsf:button actionExpression="#{user$ListUser.deleteAction}"
														 id="btnDelete"
														 text="#{resources.btnDelete}"/>
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
