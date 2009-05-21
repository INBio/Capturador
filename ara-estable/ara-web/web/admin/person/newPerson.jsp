<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{admin$person$newPerson.page1}" id="page1">
            <webuijsf:html binding="#{admin$person$newPerson.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{admin$person$newPerson.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido">
                        <webuijsf:form binding="#{admin$person$newPerson.form1}" id="form1">
                            <webuijsf:tabSet binding="#{admin$person$newPerson.personTabSet}" id="personTabSet" mini="true" selected="personalInfoTab" style="border: 1px solid gray; background-color: rgb(255, 255, 255); height: 328px; left: 48px; top: 72px; position: absolute; width: 778px">
                                <webuijsf:tab actionExpression="#{admin$person$newPerson.personalInfoTab_action}"
                                    binding="#{admin$person$newPerson.personalInfoTab}" id="personalInfoTab" target="_self" text="#{resources.personal_information}">
                                    <webuijsf:panelLayout binding="#{admin$person$newPerson.layoutPanel1}" id="layoutPanel1" style="height: 334px; position: relative; width: 767px; -rave-layout: grid">
                                        <webuijsf:label binding="#{admin$person$newPerson.label1}" id="label1" style="left: 24px; top: 48px; position: absolute" text="#{resources.name}"/>
                                        <webuijsf:label binding="#{admin$person$newPerson.label2}" id="label2" style="left: 24px; top: 72px; position: absolute" text="#{resources.last}"/>
                                        <webuijsf:label binding="#{admin$person$newPerson.label3}" id="label3" style="left: 24px; top: 96px; position: absolute" text="#{resources.second}"/>
                                        <webuijsf:textField binding="#{admin$person$newPerson.txt_firstName}" id="txt_firstName" label=" " maxLength="100"
                                            required="true" style="left: 144px; top: 48px; position: absolute"/>
                                        <webuijsf:textField binding="#{admin$person$newPerson.txt_lastName}" id="txt_lastName" label=" " maxLength="100"
                                            required="true" style="left: 144px; top: 72px; position: absolute"/>
                                        <webuijsf:textField binding="#{admin$person$newPerson.txt_secondLastName}" id="txt_secondLastName" maxLength="100" style="left: 144px; top: 96px; position: absolute"/>
                                        <webuijsf:label binding="#{admin$person$newPerson.label4}" id="label4"
                                            style="left: 24px; top: 120px; position: absolute" text="#{resources.initials}"/>
                                        <webuijsf:textField binding="#{admin$person$newPerson.txt_initials}" id="txt_initials" style="left: 144px; top: 120px; position: absolute; width: 40px"/>
                                        <webuijsf:label binding="#{admin$person$newPerson.label5}" id="label5"
                                            style="left: 24px; top: 168px; position: absolute" text="#{resources.birth_date}"/>
                                        <webuijsf:textField binding="#{admin$person$newPerson.txt_birthYear}" columns="4" id="txt_birthYear" maxLength="4"
                                            style="left: 144px; top: 168px; position: absolute" validatorExpression="#{util$ValidatorHelper.year_validate}"/>
                                        <webuijsf:label binding="#{admin$person$newPerson.label6}" id="label6"
                                            style="left: 24px; top: 192px; position: absolute" text="#{resources.death_date}"/>
                                        <webuijsf:textField binding="#{admin$person$newPerson.txt_deathYear}" columns="4" id="txt_deathYear" maxLength="4"
                                            style="left: 144px; top: 192px; position: absolute" validatorExpression="#{util$ValidatorHelper.year_validate}"/>
                                        <webuijsf:label binding="#{admin$person$newPerson.label11}" id="label11"
                                            style="left: 24px; top: 216px; position: absolute" text="#{resources.occupation}"/>
                                        <webuijsf:textField binding="#{admin$person$newPerson.txt_occupation}" id="txt_occupation" style="left: 144px; top: 216px; position: absolute"/>
                                        <webuijsf:message binding="#{admin$person$newPerson.message1}" for="txt_lastName" id="message1" showDetail="false"
                                            showSummary="true" style="font-family: 'Arial','Helvetica',sans-serif; font-size: 10px; font-weight: bold; left: 384px; top: 72px; position: absolute"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                                <webuijsf:tab actionExpression="#{admin$person$newPerson.personalInfoTab_action}" binding="#{admin$person$newPerson.tab1}"
                                    id="tab1" text="#{resources.contact_information}">
                                    <webuijsf:panelLayout binding="#{admin$person$newPerson.layoutPanel2}" id="layoutPanel2" style="height: 292px; position: relative; width: 100%; -rave-layout: grid">
                                        <webuijsf:label binding="#{admin$person$newPerson.label7}" id="label7" style="position: absolute; left: 20px; top: 15px" text="#{resources.mail}"/>
                                        <webuijsf:label binding="#{admin$person$newPerson.label8}" id="label8" style="position: absolute; left: 20px; top: 45px" text="#{resources.web}"/>
                                        <webuijsf:label binding="#{admin$person$newPerson.label9}" id="label9" style="position: absolute; left: 20px; top: 75px" text="#{resources.phone_number}"/>
                                        <webuijsf:label binding="#{admin$person$newPerson.label10}" id="label10"
                                            style="position: absolute; left: 20px; top: 105px" text="#{resources.fax}"/>
                                        <webuijsf:label binding="#{admin$person$newPerson.label12}" id="label12"
                                            style="position: absolute; left: 20px; top: 135px" text="#{resources.address}"/>
                                        <webuijsf:label binding="#{admin$person$newPerson.label13}" id="label13"
                                            style="position: absolute; left: 20px; top: 195px" text="#{resources.city}"/>
                                        <webuijsf:label binding="#{admin$person$newPerson.label14}" id="label14"
                                            style="position: absolute; left: 20px; top: 225px" text="#{resources.state}"/>
                                        <webuijsf:label binding="#{admin$person$newPerson.label15}" id="label15"
                                            style="position: absolute; left: 20px; top: 255px" text="#{resources.country}"/>
                                        <webuijsf:textField binding="#{admin$person$newPerson.txt_email}" id="txt_email"
                                            style="left: 100px; top: 15px; position: absolute" validatorExpression="#{util$ValidatorHelper.txt_email_validate}"/>
                                        <webuijsf:textField binding="#{admin$person$newPerson.txt_url}" id="txt_url"
                                            style="position: absolute; left: 100px; top: 45px" validatorExpression="#{util$ValidatorHelper.url_validate}"/>
                                        <webuijsf:textField binding="#{admin$person$newPerson.txt_telephone}" id="txt_telephone"
                                            style="position: absolute; left: 100px; top: 75px" validatorExpression="#{util$ValidatorHelper.telephone_validate}"/>
                                        <webuijsf:textField binding="#{admin$person$newPerson.txt_fax}" id="txt_fax" style="position: absolute; left: 100px; top: 105px"/>
                                        <webuijsf:textArea binding="#{admin$person$newPerson.ta_streetAddress}" id="ta_streetAddress" style="height: 45px; left: 100px; top: 135px; position: absolute; width: 220px"/>
                                        <webuijsf:textField binding="#{admin$person$newPerson.txt_city}" id="txt_city" style="position: absolute; left: 100px; top: 195px"/>
                                        <webuijsf:textField binding="#{admin$person$newPerson.txt_state}" id="txt_state" style="position: absolute; left: 100px; top: 225px"/>
                                        <webuijsf:textField binding="#{admin$person$newPerson.txt_country}" id="txt_country" style="position: absolute; left: 100px; top: 255px"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                                <webuijsf:tab actionExpression="#{admin$person$newPerson.tab2_action}" binding="#{admin$person$newPerson.tab2}" id="tab2" text="#{resources.profiles}">
                                    <webuijsf:panelLayout binding="#{admin$person$newPerson.layoutPanel3}" id="layoutPanel3" style="height: 290px; position: relative; width: 100%; -rave-layout: grid">
                                        <webuijsf:addRemove availableItemsLabel="#{resources.availables}" binding="#{admin$person$newPerson.addRemove_profile}"
                                            id="addRemove_profile" items="#{admin$person$newPerson.profileList}" labelOnTop="true" rows="14" selectAll="true"
                                            selected="#{admin$person$PersonSessionBean.selectedProfiles}" selectedItemsLabel="#{resources.selected}" style="position: absolute; left: 20px; top: 15px"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                                <webuijsf:tab actionExpression="#{admin$person$newPerson.tab3_action}" binding="#{admin$person$newPerson.tab3}" id="tab3" text="#{resources.institutions}">
                                    <webuijsf:panelLayout binding="#{admin$person$newPerson.layoutPanel4}" id="layoutPanel4" style="height: 297px; position: relative; width: 100%; -rave-layout: grid">
                                        <webuijsf:addRemove availableItemsLabel="#{resources.availables}"
                                            binding="#{admin$person$newPerson.addRemove_institution}" id="addRemove_institution"
                                            items="#{admin$person$newPerson.institutionList}" labelOnTop="true" rows="14" selectAll="true"
                                            selected="#{admin$person$PersonSessionBean.selectedInstitutions}" selectedItemsLabel="#{resources.selected}" style="position: absolute; left: 20px; top: 15px"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                            </webuijsf:tabSet>
                            <webuijsf:button actionExpression="#{admin$person$newPerson.btn_save_action}" binding="#{admin$person$newPerson.btn_save}"
                                id="btn_save" primary="true" style="height: 30px; left: 47px; top: 408px; position: absolute; width: 79px" text="#{resources.btnSave}"/>
                            <webuijsf:button actionExpression="#{admin$person$newPerson.btn_reset_action}" binding="#{admin$person$newPerson.btn_reset}"
                                id="btn_reset" reset="true" style="height: 30px; left: 143px; top: 408px; position: absolute; width: 79px" text="#{resources.btnClean}"/>
                            <webuijsf:label binding="#{admin$person$newPerson.label16}" id="label16"
                                style="font-size: 24px; height: 22px; left: 48px; top: 24px; position: absolute; width: 358px" text="#{resources.new_person}"/>
                            <h:messages binding="#{admin$person$newPerson.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1"
                                infoClass="infoMessage" style="left: 432px; top: 24px; position: absolute" warnClass="warnMessage"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
