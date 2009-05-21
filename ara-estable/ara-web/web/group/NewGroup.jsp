<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{group$NewGroup.page1}" id="page1">
            <webuijsf:html binding="#{group$NewGroup.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{group$NewGroup.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{group$NewGroup.form1}" id="form1">
                            <webuijsf:tabSet binding="#{group$NewGroup.userTabSet1}" id="userTabSet1" immediate="true" selected="userTab1" style="border: 1px solid gray; height: 313px; left: 48px; top: 72px; position: absolute; width: 1006px">
                                <webuijsf:tab actionExpression="#{group$NewGroup.userTab_action}" binding="#{group$NewGroup.userTab1}" id="userTab1" text="#{resources.group_information}">
                                    <webuijsf:panelLayout binding="#{group$NewGroup.layoutPanel1}" id="layoutPanel1" style="height: 277px; position: relative; width: 100%; -rave-layout: grid">
                                        <webuijsf:textField binding="#{group$NewGroup.userName1}" id="userName1" label="#{resources.name}" style="left: 120px; top: 120px; position: absolute; width: 286px"/>
                                        <webuijsf:textField binding="#{group$NewGroup.fullName1}" id="fullName1" label="#{resources.description}" style="left: 120px; top: 144px; position: absolute; width: 288px"/>
                                        <webuijsf:message binding="#{group$NewGroup.messageFullName1}" for="fullName1" id="messageFullName1" showDetail="false"
                                            showSummary="true" style="left: 432px; top: 144px; position: absolute; width: 190px"/>
                                        <webuijsf:message binding="#{group$NewGroup.messageUserName1}" for="userName1" id="messageUserName1" showDetail="false"
                                            showSummary="true" style="left: 432px; top: 120px; position: absolute; width: 190px"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                                <webuijsf:tab actionExpression="#{group$NewGroup.privilegiesTab_action}" binding="#{group$NewGroup.privilegiesTab1}"
                                    id="privilegiesTab1" text="#{resources.access_privileges}">
                                    <webuijsf:panelLayout binding="#{group$NewGroup.layoutPanel2}" id="layoutPanel2" style="height: 277px; position: relative; width: 719px; -rave-layout: grid">
                                        <webuijsf:addRemove availableItemsLabel="#{resources.availables}" binding="#{group$NewGroup.addRemovePrivilegies1}"
                                            id="addRemovePrivilegies1" items="#{group$NewGroup.userOptionList}" required="true" selectAll="true"
                                            selected="#{group$GroupSessionBean.selectedOptions}" selectedItemsLabel="#{resources.selected}"
                                            style="left: 24px; top: 24px; position: absolute; width: 334px" valueChangeListenerExpression="#{group$NewGroup.addRemovePrivilegies1_processValueChange}"/>
                                        <webuijsf:message binding="#{group$NewGroup.messagePrivilegies1}" for="addRemovePrivilegies" id="messagePrivilegies1"
                                            showDetail="false" showSummary="true" style="left: 20px; top: 250px; position: absolute"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                            </webuijsf:tabSet>
                            <webuijsf:button actionExpression="#{group$NewGroup.save_action}" binding="#{group$NewGroup.save1}" id="save1" primary="true"
                                style="height: 32px; left: 71px; top: 408px; position: absolute; width: 80px" tabIndex="3" text="#{resources.btnSave}"/>
                            <webuijsf:staticText binding="#{group$NewGroup.staticText1}" id="staticText1"
                                style="color: rgb(0, 51, 153); font-family: 'Arial','Helvetica',sans-serif; font-size: 24px; font-style: normal; left: 48px; top: 24px; position: absolute; width: 334px" text="#{resources.new_group}"/>
                            <h:messages binding="#{group$NewGroup.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1"
                                infoClass="infoMessage" style="left: 408px; top: 24px; position: absolute" warnClass="warnMessage"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
