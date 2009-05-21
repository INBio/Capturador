<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{stage$EditStages.page1}" id="page1">
            <webuijsf:html binding="#{stage$EditStages.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{stage$EditStages.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido" style="position: relative; -rave-layout: grid">
                        <webuijsf:form binding="#{stage$EditStages.form1}" id="form1">
                            <webuijsf:label binding="#{stage$EditStages.main_label}" id="main_label"
                                style="font-size: 24px; height: 22px; left: 48px; top: 24px; position: absolute; width: 358px" text="#{resources.edit_stage}"/>
                            <webuijsf:tabSet binding="#{stage$EditStages.tabSet1}" id="tabSet1" selected="tab3" style="border-width: 1px; border-style: solid; height: 358px; left: 48px; top: 72px; position: absolute; width: 744px">
                                <webuijsf:tab binding="#{stage$EditStages.tab3}" id="tab3" text="#{resources.edition}">
                                    <webuijsf:panelLayout binding="#{stage$EditStages.layoutPanel2}" id="layoutPanel2" style="height: 297px; width: 100%; -rave-layout: grid">
                                        <webuijsf:label binding="#{stage$EditStages.label3}" id="label3"
                                            style="height: 22px; left: 24px; top: 24px; position: absolute; width: 118px" text="#{resources.name}"/>
                                        <webuijsf:textField binding="#{stage$EditStages.name_field}" id="name_field" label=" " required="true"
                                            style="left: 168px; top: 24px; position: absolute; width: 264px" text="#{stage$EditStages.stageName}"/>
                                        <webuijsf:label binding="#{stage$EditStages.label4}" id="label4"
                                            style="height: 24px; left: 24px; top: 72px; position: absolute; width: 118px" text="#{resources.description}"/>
                                        <webuijsf:textArea binding="#{stage$EditStages.description_area}" id="description_area"
                                            style="height: 144px; left: 168px; top: 72px; position: absolute; width: 264px" text="#{stage$EditStages.stageDescription}"/>
                                        <webuijsf:button actionExpression="#{stage$EditStages.btn_edit_action}" binding="#{stage$EditStages.btn_edit1}"
                                            id="btn_edit1" style="height: 24px; left: 167px; top: 264px; position: absolute; width: 72px" text="#{resources.btnSave}"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                                <webuijsf:tab binding="#{stage$EditStages.tab1}" id="tab1" text="#{resources.transitions}">
                                    <h:panelGrid binding="#{stage$EditStages.digraph_gridPanel}" border="0" columns="1" id="digraph_gridPanel"
                                        style="height: 250px; text-align: center" width="383">
                                        <webuijsf:label binding="#{stage$EditStages.selectedStageName}" id="selectedStageName"
                                            style="font-size: 14px; font-weight: bold" text="#{stage$EditStages.stageName}"/>
                                        <webuijsf:addRemove availableItemsLabel="Available:" binding="#{stage$EditStages.addRemoveList1}" id="addRemoveList1"
                                            items="#{stage$EditStages.list_toDefaultOptions.options}" selected="#{stage$EditStages.selectedTo}"
                                            selectedItemsLabel="Selected:" sorted="true" style="width: 288px"/>
                                        <h:panelGrid binding="#{stage$EditStages.gridPanel1}" columns="2" id="gridPanel1" style="width: 100%; height: 100%;">
                                            <webuijsf:button actionExpression="#{stage$EditStages.btn_digraphSave_action}"
                                                binding="#{stage$EditStages.btn_save}" id="btn_save" style="height: 24px; width: 72px" text="#{resources.btnSave}"/>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                </webuijsf:tab>
                                <webuijsf:tab binding="#{stage$EditStages.tab2}" id="tab2" text="#{resources.autorization}">
                                    <h:panelGrid binding="#{stage$EditStages.auth_gridPanel}" columns="3" id="auth_gridPanel" style="height: 298px" width="743">
                                        <h:panelGrid binding="#{stage$EditStages.stage_gridPanel}" columns="1" id="stage_gridPanel" style="height: 94px" width="191">
                                            <webuijsf:label binding="#{stage$EditStages.label_stage}" id="label_stage" text="#{resources.stage}"/>
                                            <webuijsf:label binding="#{stage$EditStages.label1}" id="label1" style="font-size: 14px; font-weight: bold" text="#{stage$EditStages.stageName}"/>
                                        </h:panelGrid>
                                        <h:panelGrid binding="#{stage$EditStages.profile_gridPanel}" columns="1" id="profile_gridPanel" style="height: 94px" width="191">
                                            <webuijsf:label binding="#{stage$EditStages.label_profile}" id="label_profile" text="#{resources.profile}"/>
                                            <webuijsf:dropDown binding="#{stage$EditStages.profileDropDown}" id="profileDropDown"
                                                items="#{stage$EditStages.profileDropDownDefaultOptions.options}"
                                                onChange="webui.suntheme.common.timeoutSubmitForm(this.form, 'tabSet1:tab2:auth_gridPanel:profile_gridPanel:profileDropDown');"
                                                selected="#{AraRequestBean.selectedProfile}" style="width: 192px"/>
                                        </h:panelGrid>
                                        <webuijsf:listbox binding="#{stage$EditStages.auth_listbox}" id="auth_listbox"
                                            items="#{stage$EditStages.auth_listDefaultOptions.options}" label="#{resources.autorization}" labelOnTop="true"
                                            multiple="true" rows="3" selected="#{stage$EditStages.authSelections}" style="height: 48px; width: 173px"/>
                                        <webuijsf:staticText binding="#{stage$EditStages.staticText3}" id="staticText3"
                                            style="border-width: 1px; border-bottom-style: solid; height: 24px; width: 168px" text="#{resources.stage_to_edit}"/>
                                        <webuijsf:staticText binding="#{stage$EditStages.staticText4}" id="staticText4"
                                            style="border-width: 1px; border-bottom-style: solid; height: 24px; width: 168px" text="#{resources.privilege_to_assign}"/>
                                        <h:panelGrid binding="#{stage$EditStages.buttons_gridPanel}" columns="2" id="buttons_gridPanel" style="width: 100%; height: 100%;">
                                            <webuijsf:button actionExpression="#{stage$EditStages.btn_authSave_action}"
                                                binding="#{stage$EditStages.btn_guardar}" id="btn_guardar" style="height: 24px; width: 72px" text="#{resources.btnSave}"/>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                </webuijsf:tab>
                            </webuijsf:tabSet>
                            <h:messages binding="#{stage$EditStages.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1"
                                infoClass="infoMessage" style="left: 432px; top: 24px; position: absolute" warnClass="warnMessage"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
