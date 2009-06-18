<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{nomenclaturalgroup$editNomenclaturalGroup.page1}" id="page1">
            <webuijsf:html binding="#{nomenclaturalgroup$editNomenclaturalGroup.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
                <webuijsf:body binding="#{nomenclaturalgroup$editNomenclaturalGroup.body1}" id="body1" style="-rave-layout: grid">
                    <jsp:directive.include file="/Header.jspf"/>
                    <webuijsf:panelLayout id="contenido" style="position: relative; -rave-layout: grid">
                        <webuijsf:form binding="#{nomenclaturalgroup$editNomenclaturalGroup.form1}" id="form1">
                            <webuijsf:label binding="#{nomenclaturalgroup$editNomenclaturalGroup.label1}" id="label1"
                                style="font-size: 24px; height: 22px; left: 48px; top: 17px; position: absolute; width: 526px" text="#{resources.edit_nomenclatural_group}"/>
                            <webuijsf:textField binding="#{nomenclaturalgroup$editNomenclaturalGroup.txt_name}" columns="28" id="txt_name" style="left: 144px; top: 96px; position: absolute"/>
                            <webuijsf:textField binding="#{nomenclaturalgroup$editNomenclaturalGroup.txt_temporality}" columns="28" id="txt_temporality" style="left: 480px; top: 144px; position: absolute"/>
                            <webuijsf:label binding="#{nomenclaturalgroup$editNomenclaturalGroup.label2}" id="label2"
                                style="left: 384px; top: 144px; position: absolute" text="#{resources.temporality}"/>
                            <webuijsf:dropDown binding="#{nomenclaturalgroup$editNomenclaturalGroup.dd_collection}" id="dd_collection"
                                items="#{nomenclaturalgroup$NomenclaturalGroupSessionBean.collectionOption}"
                                onChange="webuijsf.suntheme.common.timeoutSubmitForm(this.form, 'dd_collection');"
                                selected="#{nomenclaturalgroup$NomenclaturalGroupSessionBean.selectedCollection}" style="left: 144px; top: 192px; position: absolute"/>
                            <!--
                            Este boton actualiza el valor de la colección que se selecciono, para
                            a su vez se actualicen los elementos gráficos que muestran los taxones y regiones
                            -->
                            <webuijsf:button actionExpression="#{nomenclaturalgroup$editNomenclaturalGroup.btn_update}" id="btn_actualizar"
                                style="height: 24px; left: 503px; top: 216px; position: absolute; width: 96px" text="#{resources.btnUpdate}"/>
                            <webuijsf:label binding="#{nomenclaturalgroup$editNomenclaturalGroup.label3}" id="label3"
                                style="left: 48px; top: 120px; position: absolute" text="#{resources.description}"/>
                            <webuijsf:dropDown binding="#{nomenclaturalgroup$editNomenclaturalGroup.dd_certificador}" id="dd_certificador"
                                items="#{nomenclaturalgroup$NomenclaturalGroupSessionBean.certificatorPersonOption}"
                                selected="#{nomenclaturalgroup$NomenclaturalGroupSessionBean.selectedCertificator}" style="left: 144px; top: 216px; position: absolute"/>
                            <webuijsf:label binding="#{nomenclaturalgroup$editNomenclaturalGroup.label4}" id="label4"
                                style="left: 48px; top: 192px; position: absolute" text="#{resources.colection}"/>
                            <h:messages binding="#{nomenclaturalgroup$editNomenclaturalGroup.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage"
                                id="messageList1" infoClass="infoMessage" style="left: 600px; top: 24px; position: absolute" warnClass="warnMessage"/>
                            <webuijsf:textArea binding="#{nomenclaturalgroup$editNomenclaturalGroup.txt_notes}" columns="25" id="txt_notes" style="height: 48px; left: 144px; top: 240px; position: absolute; width: 200px"/>
                            <webuijsf:button actionExpression="#{nomenclaturalgroup$editNomenclaturalGroup.btn_save_action}"
                                binding="#{nomenclaturalgroup$editNomenclaturalGroup.btn_save}" id="btn_save"
                                style="height: 24px; left: 383px; top: 216px; position: absolute; width: 96px" text="#{resources.btnSave}"/>
                            <webuijsf:label binding="#{nomenclaturalgroup$editNomenclaturalGroup.label5}" id="label5"
                                style="left: 48px; top: 96px; position: absolute" text="#{resources.name}"/>
                            <webuijsf:label binding="#{nomenclaturalgroup$editNomenclaturalGroup.label6}" id="label6"
                                style="left: 48px; top: 240px; position: absolute" text="#{resources.notes}"/>
                            <webuijsf:textArea binding="#{nomenclaturalgroup$editNomenclaturalGroup.txt_description}" columns="25" id="txt_description" style="height: 48px; left: 144px; top: 120px; position: absolute; width: 200px"/>
                            <webuijsf:label binding="#{nomenclaturalgroup$editNomenclaturalGroup.label7}" id="label7"
                                style="left: 48px; top: 216px; position: absolute" text="#{resources.certifier}"/>
                            <webuijsf:label binding="#{nomenclaturalgroup$editNomenclaturalGroup.label8}" id="label8"
                                style="left: 48px; top: 72px; position: absolute" text="#{resources.id}"/>
                            <webuijsf:staticText binding="#{nomenclaturalgroup$editNomenclaturalGroup.st_id}" id="st_id" style="left: 144px; top: 72px; position: absolute"/>
                            <webuijsf:tabSet binding="#{nomenclaturalgroup$editNomenclaturalGroup.tabSet1}" id="tabSet1" selected="tab_taxon1" style="border: 1px solid gray; height: 36px; left: 48px; top: 312px; position: absolute; width: 646px">
                                <webuijsf:tab binding="#{nomenclaturalgroup$editNomenclaturalGroup.tab_taxon1}" id="tab_taxon1" text="#{resources.taxon}">
                                    <webuijsf:panelLayout binding="#{nomenclaturalgroup$editNomenclaturalGroup.layoutPanel1}" id="layoutPanel1" style="border: 1px solid gray; height: 263px; position: relative; width: 645px; -rave-layout: grid">
                                        <webuijsf:addRemove availableItemsLabel="#{resources.availables}:"
                                            binding="#{nomenclaturalgroup$editNomenclaturalGroup.adr_taxon}" id="adr_taxon"
                                            items="#{nomenclaturalgroup$NomenclaturalGroupSessionBean.taxonOption}"
                                            selected="#{nomenclaturalgroup$NomenclaturalGroupSessionBean.selectedTaxon}"
                                            selectedItemsLabel="#{resources.selected}:" style="left: 24px; top: 24px; position: absolute"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                                <webuijsf:tab binding="#{nomenclaturalgroup$editNomenclaturalGroup.tab_region1}" id="tab_region1" text="#{resources.regions}">
                                    <webuijsf:panelLayout binding="#{nomenclaturalgroup$editNomenclaturalGroup.layoutPanel2}" id="layoutPanel2" style="border: 1px solid gray; height: 265px; position: relative; width: 645px; -rave-layout: grid">
                                        <webuijsf:addRemove availableItemsLabel="#{resources.availables}:"
                                            binding="#{nomenclaturalgroup$editNomenclaturalGroup.adr_region}" id="adr_region"
                                            items="#{nomenclaturalgroup$NomenclaturalGroupSessionBean.regionOption}"
                                            selected="#{nomenclaturalgroup$NomenclaturalGroupSessionBean.selectedRegion}"
                                            selectedItemsLabel="#{resources.selected}:" style="position: absolute; left: 24px; top: 24px"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
                            </webuijsf:tabSet>
                            <webuijsf:dropDown binding="#{nomenclaturalgroup$editNomenclaturalGroup.dd_commonName}" id="dd_commonName"
                                items="#{nomenclaturalgroup$editNomenclaturalGroup.dd_commonNameDefaultOptions.options}" label="#{resources.common_name}" style="left: 384px; top: 96px; position: absolute"/>
                        </webuijsf:form>
                    </webuijsf:panelLayout>
                    <!--<jsp:directive.include file="/footer.jspf"/>-->
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
