<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{species$speciesEdit.page1}" id="page1">
            <webuijsf:html binding="#{species$speciesEdit.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                    <script>
                        function getSelectedRowId( componentId) {
                            return document.getElementById("form1:table1:button1").getValue();
                        }
    				</script>
                </webuijsf:head>
                <webuijsf:body binding="#{species$speciesEdit.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido" style="position: relative; -rave-layout: grid">
                        <webuijsf:form binding="#{species$speciesEdit.form1}" id="form1">
                            <webuijsf:tabSet binding="#{species$speciesEdit.tabSet1}" id="tabSet1" style="border: 1px solid gray; height: 478px; left: 48px; top: 235px; position: absolute; width: 863px">
                                <webuijsf:tab actionExpression="#{species$speciesEdit.tab_Descriptions_action}"
                                    binding="#{species$speciesEdit.tab_Descriptions}" id="tab_Descriptions" text="#{resources.description}">
                                    <webuijsf:panelLayout binding="#{species$speciesEdit.layoutPanel1}" id="layoutPanel1" style="position: relative; width: 100%; -rave-layout: grid">
                                        <webuijsf:tree binding="#{species$speciesEdit.tree2}" clientSide="true" id="tree2" immediate="true"
                                            style="border: 1px solid gray; left: 24px; top: 24px; position: absolute; width: 262px" text="#{resources.categories}"/>
                                        <webuijsf:staticText binding="#{species$speciesEdit.st_CategoryName}" id="st_CategoryName" style="font-size: 12px; font-weight: bold; left: 432px; top: 24px; position: absolute; width: 240px"/>
                                        <h:panelGrid binding="#{species$speciesEdit.dynamicPanelForm}" id="dynamicPanelForm"
                                            style="border: 1px solid gray; height: 336px; left: 432px; top: 48px; position: absolute" width="408"/>
                                        <webuijsf:button actionExpression="#{species$speciesEdit.saveRecordData_action}"
                                            binding="#{species$speciesEdit.saveRecordDataButton}" id="saveRecordDataButton"
                                            style="left: 695px; top: 24px; position: absolute; width: 100px" text="#{resources.btnSave}"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                                <webuijsf:tab actionExpression="#{species$speciesEdit.tab_Audiences_action}" binding="#{species$speciesEdit.tab_Audiences}"
                                    id="tab_Audiences" text="#{resources.audiences}">
                                    <webuijsf:panelLayout binding="#{species$speciesEdit.layoutPanel2}" id="layoutPanel2" style="height: 276px; position: relative; width: 100%; -rave-layout: grid">
                                        <webuijsf:addRemove availableItemsLabel="#{resources.availables}:" binding="#{species$speciesEdit.ar_audience}"
                                            converter="#{species$speciesEdit.longConverter1}" id="ar_audience" items="#{species$speciesEdit.audienceOptions}"
                                            labelOnTop="true" selectAll="true" selected="#{species$SpeciesSessionBean.selectedAudience}"
                                            selectedItemsLabel="#{resources.selected}:" style="left: 24px; top: 48px; position: absolute; width: 386px" valueChangeListenerExpression="#{species$speciesEdit.ar_audience_processValueChange}"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                                <webuijsf:tab actionExpression="#{species$speciesEdit.tab_Authors_action}" binding="#{species$speciesEdit.tab_Authors}"
                                    id="tab_Authors" text="#{resources.authors}">
                                    <webuijsf:panelLayout binding="#{species$speciesEdit.layoutPanel3}" id="layoutPanel3" style="height: 276px; position: relative; width: 100%; -rave-layout: grid">
                                        <webuijsf:addRemove availableItemsLabel="#{resources.availables}:" binding="#{species$speciesEdit.addRemoveList1}"
                                            converter="#{species$speciesEdit.longConverter1}" id="addRemoveList1" items="#{species$speciesEdit.authorOptions}"
                                            selectAll="true" selected="#{species$SpeciesSessionBean.selectedSpeciesAuthor}"
                                            selectedItemsLabel="#{resources.selected}:" style="left: 20px; top: 15px; position: absolute"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                                <webuijsf:tab actionExpression="#{species$speciesEdit.tab_Institutions_action}"
                                    binding="#{species$speciesEdit.tab_Institutions}" id="tab_Institutions" text="#{resources.institutions}">
                                    <webuijsf:panelLayout binding="#{species$speciesEdit.layoutPanel4}" id="layoutPanel4" style="height: 276px; position: relative; width: 100%; -rave-layout: grid">
                                        <webuijsf:addRemove availableItemsLabel="#{resources.availables}:" binding="#{species$speciesEdit.addRemoveList2}"
                                            converter="#{species$speciesEdit.longConverter1}" id="addRemoveList2"
                                            items="#{species$speciesEdit.institutionOptions}" selectAll="true"
                                            selected="#{species$SpeciesSessionBean.selectedInstitution}" selectedItemsLabel="#{resources.selected}:" style="left: 20px; top: 15px; position: absolute"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                                <webuijsf:tab actionExpression="#{species$speciesEdit.tab_stages_action}" binding="#{species$speciesEdit.tab_stages}"
                                    disabled="true" id="tab_stages" text="#{resources.publications_history}">
                                    <webuijsf:panelLayout binding="#{species$speciesEdit.layoutPanel5}" id="layoutPanel5" style="height: 276px; position: relative; width: 100%; -rave-layout: grid">
                                        <webuijsf:listbox binding="#{species$speciesEdit.listbox1}" converter="#{species$speciesEdit.longConverter1}"
                                            disabled="true" id="listbox1" items="#{species$speciesEdit.taxonDescriptionStages}" selected=""
                                            style="height: 240px; left: 20px; top: 15px; position: absolute; width: 380px" visible="false"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                                <webuijsf:tab actionExpression="#{species$speciesEdit.tab_TaxonomicalHierarchy_action}"
                                    binding="#{species$speciesEdit.tab_TaxonomicalHierarchy}" id="tab_TaxonomicalHierarchy" text="#{resources.taxonomy_hierarchy}">
                                    <webuijsf:panelLayout binding="#{species$speciesEdit.layoutPanel6}" id="layoutPanel6" style="height: 276px; position: relative; width: 100%; -rave-layout: grid">
                                        <webuijsf:tree binding="#{species$speciesEdit.tree1}" clientSide="true" expandOnSelect="false" id="tree1" style="border: 1px solid gray; height: 238px; left: 20px; top: 15px; position: absolute; width: 418px"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                                <webuijsf:tab actionExpression="#{species$speciesEdit.tab_NomenclaturalGroups_action}"
                                    binding="#{species$speciesEdit.tab_NomenclaturalGroups}" disabled="true" id="tab_NomenclaturalGroups" text="#{resources.common_names}">
                                    <webuijsf:panelLayout binding="#{species$speciesEdit.layoutPanel7}" id="layoutPanel7" style="height: 276px; position: relative; width: 100%; -rave-layout: grid">
                                        <webuijsf:listbox binding="#{species$speciesEdit.listbox2}" id="listbox2"
                                            items="#{species$speciesEdit.listbox2DefaultOptions.options}" style="height: 240px; left: 20px; top: 15px; position: absolute; width: 380px"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                            </webuijsf:tabSet>
                            <webuijsf:panelLayout binding="#{species$speciesEdit.ly_Header}" id="ly_Header" style="height: 190px; left: 48px; top: 24px; position: absolute; width: 718px; -rave-layout: grid">
                                <webuijsf:label binding="#{species$speciesEdit.label1}" id="label1" style="left: 24px; top: 72px; position: absolute" text="#{resources.scientific_name}"/>
                                <webuijsf:label binding="#{species$speciesEdit.label2}" id="label2" style="left: 24px; top: 96px; position: absolute" text="#{resources.record_number}"/>
                                <webuijsf:label binding="#{species$speciesEdit.label4}" id="label4" style="left: 24px; top: 120px; position: absolute" text="#{resources.title}"/>
                                <webuijsf:label binding="#{species$speciesEdit.label5}" id="label5" style="left: 24px; top: 144px; position: absolute" text="#{resources.language}"/>
                                <webuijsf:textField binding="#{species$speciesEdit.txt_SpeciesVersion}" id="txt_SpeciesVersion" style="left: 192px; top: 96px; position: absolute"/>
                                <webuijsf:textField binding="#{species$speciesEdit.txt_Title}" id="txt_Title" style="left: 192px; top: 120px; position: absolute; width: 503px"/>
                                <webuijsf:dropDown binding="#{species$speciesEdit.dp_Language}" converter="#{species$speciesEdit.longConverter1}"
                                    id="dp_Language" items="#{species$speciesEdit.languageOptions}" selected="#{species$SpeciesSessionBean.selectedLanguage}" style="left: 192px; top: 144px; position: absolute; width: 199px"/>
                                <webuijsf:staticText binding="#{species$speciesEdit.staticText1}" id="staticText1"
                                    style="font-family: 'Arial','Helvetica',sans-serif; font-size: 24px; left: 0px; top: 24px; position: absolute" text="#{resources.edit_record}"/>
                                <webuijsf:staticText binding="#{species$speciesEdit.st_SpeciesName}" id="st_SpeciesName" style="color: rgb(0, 153, 51); font-family: 'Arial','Helvetica',sans-serif; font-size: 14px; font-weight: bold; left: 192px; top: 72px; position: absolute"/>
                                <webuijsf:button actionExpression="#{species$speciesEdit.btn_save_action}" binding="#{species$speciesEdit.btn_save}"
                                    id="btn_save" style="height: 23px; left: 455px; top: 72px; position: absolute; width: 70px" text="#{resources.btnSave}"/>
                                <h:messages binding="#{species$speciesEdit.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1"
                                    infoClass="infoMessage" style="left: 312px; top: 24px; position: absolute" warnClass="warnMessage"/>
                                <webuijsf:label binding="#{species$speciesEdit.label6}" id="label6" style="left: 24px; top: 168px; position: absolute"
                                    text="#{resources.stage}" visible="false"/>
                                <webuijsf:dropDown binding="#{species$speciesEdit.dp_stage}" converter="#{species$speciesEdit.longConverter1}" id="dp_stage"
                                    items="#{species$speciesEdit.taxonDescriptionStages}" selected="#{species$SpeciesSessionBean.selectedNewStage}"
                                    style="left: 192px; top: 168px; position: absolute" visible="false"/>
                                <webuijsf:label binding="#{species$speciesEdit.label7}" id="label7" style="left: 24px; top: 168px; position: absolute" text="#{resources.current_state}"/>
                                <webuijsf:staticText binding="#{species$speciesEdit.st_actualStageName}" id="st_actualStageName" style="color: gray; font-family: 'Arial','Helvetica',sans-serif; font-weight: bold; left: 192px; top: 168px; position: absolute"/>
                                <webuijsf:button actionExpression="#{species$speciesEdit.previewButton_action}" binding="#{species$speciesEdit.previewButton}"
                                    id="previewButton" style="height: 24px; left: 647px; top: 72px; position: absolute; width: 72px" text="#{resources.preview}"/>
                            </webuijsf:panelLayout>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <jsp:directive.include file="/footer.jspf"/>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
