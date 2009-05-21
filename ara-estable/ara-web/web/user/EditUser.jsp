<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page">
            <webuijsf:html id="html">
                <webuijsf:head id="head">
                    <webuijsf:link id="link" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script id="script" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body id="body" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form">
                            <h:messages errorClass="errorMessage"
										fatalClass="fatalMessage"
										id="messageList"
										infoClass="infoMessage"
										style="left: 456px; top: 24px; position: absolute"
										warnClass="warnMessage"/>
                            <webuijsf:staticText id="Label"
												style="font-family: 'Arial','Helvetica',sans-serif; font-size: 24px; left: 48px; top: 24px; position: absolute; width: 382px"
												text="#{resources.edit_user}"/>
                            <webuijsf:label id="userNamelabel"
											style="left: 48px; top: 72px; position: absolute"
											text="#{resources.username}"/>
							<webuijsf:textField binding="#{UserSessionBean.userNameTextField}"
												style="left: 192px; top: 72px; position: absolute"/>
                            <webuijsf:label id="fullNameLabel"
											style="left: 48px; top: 96px; position: absolute"
											text="#{resources.full_name}"/>
							<webuijsf:textField binding="#{UserSessionBean.fullNameTextField}"
												id="fullNameTextField"
												style="left: 192px; top: 96px; position: absolute"/>
                            <webuijsf:label id="groupLabel"
											style="left: 48px; top: 120px; position: absolute"
											text="#{resources.group}"/>
                            <webuijsf:dropDown  id="groupsList"
												items="#{UserSessionBean.groupList}"
												selected="#{UserSessionBean.selectedGroup}"
												style="left: 192px; top: 120px; position: absolute"/>
                            <webuijsf:button actionExpression="#{user$EditUser.saveAction}"
												id="saveButton"
												style="height: 24px; left: 407px; top: 96px; position: absolute; width: 72px"
												text="#{resources.btnSave}"/>
                            <webuijsf:tabSet id="tabSet"
											style="border: 1px solid gray; height: 622px; left: 48px; top: 164px; position: absolute; width: 800px">
                                <webuijsf:tab	id="uniqueTab"
												text="#{resources.taxons_and_nomenclatural_groups}">
                                    <webuijsf:panelLayout  id="panel"
															style="height: 587px; position: relative; width: 100%; -rave-layout: grid">
                                        <webuijsf:addRemove availableItemsLabel="#{resources.availables}:" 
															id="taxonListSelection"
															items="#{UserSessionBean.availableTaxa}"
															selected="#{UserSessionBean.selectedTaxa}"
															labelOnTop="true"
															label="#{resources.taxons}"
															selectedItemsLabel="#{resources.selected}:"
															style="left: 48px; top: 24px; position: absolute"/>
                                        <webuijsf:addRemove availableItemsLabel="#{resources.availables}:" 
															id="groupListSelection"
															items="#{UserSessionBean.availableGroups}"
															selected="#{UserSessionBean.selectedGroups}"
															label="#{resources.nomenclatural_groups}"
															labelOnTop="true"
															selectedItemsLabel="#{resources.selected}:"
															style="left: 48px; top: 312px; position: absolute"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                            </webuijsf:tabSet>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
