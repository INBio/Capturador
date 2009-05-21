<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{admin$person$editPerson.page1}" id="page1">
            <webuijsf:html binding="#{admin$person$editPerson.html1}" id="html1" lang="">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{admin$person$editPerson.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{admin$person$editPerson.form1}" id="form1">
                            <webuijsf:label binding="#{admin$person$editPerson.label1}" id="label1"
                                style="font-size: 24px; left: 48px; top: 24px; position: absolute; width: 310px" text="#{resources.edit_person}"/>
                            <webuijsf:tabSet binding="#{admin$person$editPerson.personTabSet1}" id="personTabSet1" mini="true" selected="personalInfoTab1" style="border: 1px solid gray; background-color: rgb(255, 255, 255); height: 358px; left: 48px; top: 72px; position: absolute; width: 790px">
                                <webuijsf:tab actionExpression="#{admin$person$editPerson.personalInfoTab_action}"
                                    binding="#{admin$person$editPerson.personalInfoTab1}" id="personalInfoTab1" target="_self" text="#{resources.personal_information}">
                                    <webuijsf:panelLayout binding="#{admin$person$editPerson.layoutPanel1}" id="layoutPanel1" style="height: 358px; position: relative; width: 791px; -rave-layout: grid">
                                        <webuijsf:label binding="#{admin$person$editPerson.label2}" id="label2"
                                            style="left: 48px; top: 48px; position: absolute" text="#{resources.name}"/>
                                        <webuijsf:label binding="#{admin$person$editPerson.label3}" id="label3"
                                            style="left: 48px; top: 72px; position: absolute" text="#{resources.last}"/>
                                        <webuijsf:label binding="#{admin$person$editPerson.label4}" id="label4"
                                            style="left: 48px; top: 96px; position: absolute" text="#{resources.second}"/>
                                        <webuijsf:textField binding="#{admin$person$editPerson.txt_firstName1}" id="txt_firstName1" label=" " maxLength="100"
                                            required="true" style="left: 168px; top: 48px; position: absolute"/>
                                        <webuijsf:textField binding="#{admin$person$editPerson.txt_lastName1}" id="txt_lastName1" label=" " maxLength="100"
                                            required="true" style="left: 168px; top: 72px; position: absolute"/>
                                        <webuijsf:textField binding="#{admin$person$editPerson.txt_secondLastName1}" id="txt_secondLastName1" maxLength="100" style="left: 168px; top: 96px; position: absolute"/>
                                        <webuijsf:label binding="#{admin$person$editPerson.label5}" id="label5"
                                            style="left: 48px; top: 120px; position: absolute" text="#{resources.initials}"/>
                                        <webuijsf:textField binding="#{admin$person$editPerson.txt_initials1}" id="txt_initials1" style="left: 168px; top: 120px; position: absolute; width: 40px"/>
                                        <webuijsf:label binding="#{admin$person$editPerson.label6}" id="label6"
                                            style="left: 48px; top: 168px; position: absolute" text="#{resources.birth_date}"/>
                                        <webuijsf:textField binding="#{admin$person$editPerson.txt_birthYear1}" columns="4" id="txt_birthYear1" maxLength="4"
                                            style="left: 168px; top: 168px; position: absolute" validatorExpression="#{util$ValidatorHelper.year_validate}"/>
                                        <webuijsf:label binding="#{admin$person$editPerson.label7}" id="label7"
                                            style="left: 48px; top: 192px; position: absolute" text="#{resources.death_date}"/>
                                        <webuijsf:textField binding="#{admin$person$editPerson.txt_deathYear1}" columns="4" id="txt_deathYear1" maxLength="4"
                                            style="left: 168px; top: 192px; position: absolute" validatorExpression="#{util$ValidatorHelper.year_validate}"/>
                                        <webuijsf:label binding="#{admin$person$editPerson.label8}" id="label8"
                                            style="left: 48px; top: 216px; position: absolute" text="#{resources.occupation}"/>
                                        <webuijsf:textField binding="#{admin$person$editPerson.txt_occupation1}" id="txt_occupation1" style="left: 168px; top: 216px; position: absolute"/>
                                        <webuijsf:message binding="#{admin$person$editPerson.message1}" for="txt_lastName1" id="message1" showDetail="false"
                                            showSummary="true" style="font-family: 'Arial','Helvetica',sans-serif; font-size: 10px; font-weight: bold; left: 360px; top: 72px; position: absolute; width: 198px"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                                <webuijsf:tab actionExpression="#{admin$person$editPerson.personalInfoTab_action}" binding="#{admin$person$editPerson.tab1}"
                                    id="tab1" text="#{resources.contact_information}">
                                    <webuijsf:panelLayout binding="#{admin$person$editPerson.layoutPanel2}" id="layoutPanel2" style="height: 292px; position: relative; width: 100%; -rave-layout: grid">
                                        <webuijsf:label binding="#{admin$person$editPerson.label9}" id="label9"
                                            style="left: 24px; top: 48px; position: absolute" text="#{resources.mail}"/>
                                        <webuijsf:label binding="#{admin$person$editPerson.label10}" id="label10"
                                            style="left: 24px; top: 72px; position: absolute" text="#{resources.web}"/>
                                        <webuijsf:label binding="#{admin$person$editPerson.label11}" id="label11"
                                            style="left: 24px; top: 96px; position: absolute" text="#{resources.phone_number}"/>
                                        <webuijsf:label binding="#{admin$person$editPerson.label12}" id="label12"
                                            style="left: 24px; top: 144px; position: absolute" text="#{resources.fax}"/>
                                        <webuijsf:label binding="#{admin$person$editPerson.label13}" id="label13"
                                            style="left: 24px; top: 168px; position: absolute" text="#{resources.address}"/>
                                        <webuijsf:label binding="#{admin$person$editPerson.label14}" id="label14"
                                            style="left: 24px; top: 216px; position: absolute" text="#{resources.city}"/>
                                        <webuijsf:label binding="#{admin$person$editPerson.label15}" id="label15"
                                            style="left: 24px; top: 264px; position: absolute" text="#{resources.state}"/>
                                        <webuijsf:label binding="#{admin$person$editPerson.label16}" id="label16"
                                            style="left: 24px; top: 288px; position: absolute" text="#{resources.country}"/>
                                        <webuijsf:textField binding="#{admin$person$editPerson.txt_email1}" id="txt_email1"
                                            style="left: 120px; top: 48px; position: absolute" validatorExpression="#{util$ValidatorHelper.txt_email_validate}"/>
                                        <webuijsf:textField binding="#{admin$person$editPerson.txt_url1}" id="txt_url1"
                                            style="left: 120px; top: 72px; position: absolute" validatorExpression="#{util$ValidatorHelper.url_validate}"/>
                                        <webuijsf:textField binding="#{admin$person$editPerson.txt_telephone1}" id="txt_telephone1"
                                            style="left: 120px; top: 96px; position: absolute" validatorExpression="#{util$ValidatorHelper.telephone_validate}"/>
                                        <webuijsf:textField binding="#{admin$person$editPerson.txt_fax1}" id="txt_fax1" style="left: 120px; top: 144px; position: absolute"/>
                                        <webuijsf:textArea binding="#{admin$person$editPerson.ta_streetAddress1}" id="ta_streetAddress1" style="height: 45px; left: 120px; top: 168px; position: absolute; width: 220px"/>
                                        <webuijsf:textField binding="#{admin$person$editPerson.txt_city1}" id="txt_city1" style="left: 120px; top: 216px; position: absolute"/>
                                        <webuijsf:textField binding="#{admin$person$editPerson.txt_state1}" id="txt_state1" style="left: 120px; top: 264px; position: absolute"/>
                                        <webuijsf:textField binding="#{admin$person$editPerson.txt_country1}" id="txt_country1" style="left: 120px; top: 288px; position: absolute"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                                <webuijsf:tab actionExpression="#{admin$person$editPerson.tab2_action}" binding="#{admin$person$editPerson.tab2}" id="tab2" text="#{resources.profiles}">
                                    <webuijsf:panelLayout binding="#{admin$person$editPerson.layoutPanel3}" id="layoutPanel3" style="height: 290px; position: relative; width: 739px; -rave-layout: grid">
                                        <webuijsf:addRemove availableItemsLabel="#{resources.availables}:"
                                            binding="#{admin$person$editPerson.addRemove_profile1}" id="addRemove_profile1"
                                            items="#{admin$person$editPerson.profileList}" labelOnTop="true" rows="14" selectAll="true"
                                            selected="#{admin$person$PersonSessionBean.selectedProfiles}" selectedItemsLabel="#{resources.selected}:"
                                            style="left: 20px; top: 15px; position: absolute; width: 498px" valueChangeListenerExpression="#{admin$person$editPerson.addRemove_profile1_processValueChange}"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                                <webuijsf:tab actionExpression="#{admin$person$editPerson.tab3_action}" binding="#{admin$person$editPerson.tab3}" id="tab3" text="#{resources.institutions}">
                                    <webuijsf:panelLayout binding="#{admin$person$editPerson.layoutPanel4}" id="layoutPanel4" style="height: 276px; position: relative; width: 100%; -rave-layout: grid">
                                        <webuijsf:addRemove availableItemsLabel="#{resources.availables}"
                                            binding="#{admin$person$editPerson.addRemove_institution1}" converter="#{admin$person$editPerson.longConverter1}"
                                            id="addRemove_institution1" items="#{admin$person$editPerson.institutionList}" labelOnTop="true" rows="14"
                                            selectAll="true" selected="#{admin$person$PersonSessionBean.selectedInstitutions}"
                                            selectedItemsLabel="#{resources.selected}" sorted="true" style="left: 20px; top: 15px; position: absolute; width: 498px"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                            </webuijsf:tabSet>
                            <webuijsf:button actionExpression="#{admin$person$editPerson.btn_save_action}" binding="#{admin$person$editPerson.btn_save1}"
                                id="btn_save1" primary="true" style="height: 30px; left: 312px; top: 456px; position: absolute; width: 79px" text="#{resources.save}"/>
                            <webuijsf:button actionExpression="#{admin$person$editPerson.btn_reset_action}" binding="#{admin$person$editPerson.btn_reset1}"
                                id="btn_reset1" reset="true" style="height: 30px; left: 408px; top: 456px; position: absolute; width: 79px" text="#{resources.clean}"/>
                            <h:messages binding="#{admin$person$editPerson.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1"
                                infoClass="infoMessage" style="left: 384px; top: 24px; position: absolute" warnClass="warnMessage"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
