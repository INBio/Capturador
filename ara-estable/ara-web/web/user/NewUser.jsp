<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page">
            <webuijsf:html id="html">
                <webuijsf:head  id="head">
                    <webuijsf:link id="link" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script id="script" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body id="body" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form id="form">
                            <webuijsf:staticText id="Label"
                                style="color: rgb(0, 51, 153); font-family: 'Arial','Helvetica',sans-serif; font-size: 24px; font-style: normal; left: 48px; top: 24px; position: absolute; width: 310px"
								text="#{resources.new_user}"/>
                            <webuijsf:button actionExpression="#{user$NewUser.saveAction}"
											 id="save"
											 primary="true"
											 style="height: 32px; left: 71px; top: 384px; position: absolute; width: 80px"
											 tabIndex="3"
											 text="#{resources.btnSave}"/>
                            <webuijsf:tabSet id="userTabSet"
											 style="border: 1px solid gray; height: 304px; left: 48px; top: 72px; position: absolute; width: 598px">
                                <webuijsf:tab actionExpression="#{user$NewUser.userTab_action}"
											  id="userTab"
											  text="#{resources.user_information}">
                                    <webuijsf:panelLayout
											  id="layoutPanel1"
											  style="height: 173px; position: relative; width: 100%; -rave-layout: grid">

										<webuijsf:staticText id="fullNameLabel"
															style="left: 72px; top: 72px; position: absolute; font-weight: bold;"
															text="#{resources.full_name}" />
                                        <webuijsf:textField binding="#{user$NewUser.fullName}"
															label=" "
															required="true"
															id="fullName"
															style="left: 220px; top: 72px; position: absolute; width: 290px"	/>

										<webuijsf:staticText id="userNameLabel"
															style="left: 72px; top: 96px; position: absolute; font-weight: bold;"
															text="#{resources.username}" />
                                        <webuijsf:textField binding="#{user$NewUser.userName}"
															label=" "
															required="true"
															id="userName"
															style="left: 220px; top: 96px; position: absolute"/>

										<webuijsf:staticText id="passwordLabel"
															style="left: 72px; top: 120px; position: absolute; font-weight: bold;"
															text="#{resources.password}" />
                                        <webuijsf:passwordField binding="#{user$NewUser.password}"
															required="true"
															label=" "
															id="password"
															style="left: 220px; top: 120px; position: absolute"/>

										<webuijsf:staticText id="confirmPasswordLabel"
															style="left: 72px; top: 144px; position: absolute; font-weight: bold;"
															text="#{resources.confirm_password}" />
                                        <webuijsf:passwordField binding="#{user$NewUser.password_confirmed}"
															required="true"
															label=" "
															id="password_confirmed"
															style="left: 220px; top: 144px; position: absolute"/>


										<webuijsf:staticText id="st_group"
															style="font-weight: bold; left: 72px; top: 168px; position: absolute"
															text="#{resources.group}"/>

                                        <webuijsf:dropDown 	binding="#{user$NewUser.userGroup1}"
															id="userGroup1"
															items="#{UserSessionBean.groupList}"
															onChange=""
															selected="#{UserSessionBean.selectedGroup}"
															style="left: 227px; top: 168px; position: absolute; width: 173px"/>
                                        <webuijsf:message 
															for="fullName"
															id="messageFullName"
															showDetail="false"
															showSummary="true"
															style="left: 360px; top: 72px; position: absolute"/>

                                        <webuijsf:message 
															for="userName"
															id="messageUserName"
															showDetail="false"
															showSummary="true"
															style="left: 360px; top: 96px; position: absolute"/>

                                        <webuijsf:message 
															for="password"
															id="messagePassword"
															showDetail="false"
															showSummary="true"
															style="left: 360px; top: 120px; position: absolute"/>

                                        <webuijsf:message 
															for="password_confirmed"
															id="messagePasswordConfirmation"
															showDetail="false"
															showSummary="true"
															style="left: 360px; top: 144px; position: absolute"/>

									
                                        <webuijsf:message 
															for="userGroup1"
															id="messageGroup"
															showDetail="false"
															showSummary="true"
															style="height: 47px; left: 360px; top: 192px; position: absolute; width: 66px"/>
                                        
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                            </webuijsf:tabSet>
                            <webuijsf:alert binding="#{user$NewUser.userAlert}"
											id="userAlert"
											style="height: 22px; left: 384px; top: 24px; position: absolute; text-align: justify; width: 358px"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
