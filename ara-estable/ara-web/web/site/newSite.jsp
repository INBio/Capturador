<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
	<jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
	<f:view>
		<webuijsf:page binding="#{site$newSite.page1}" id="page1">
			<webuijsf:html binding="#{site$newSite.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
				<webuijsf:body binding="#{site$newSite.body1}" id="body1" style="-rave-layout: grid">
					<jsp:directive.include file="/Header.jspf"/>
					<webuijsf:panelLayout id="contenido">
						<webuijsf:form binding="#{site$newSite.form1}" id="form1">
								<webuijsf:label binding="#{site$newSite.label1}" id="label1"
											style="font-size: 24px; height: 22px; left: 48px; top: 24px; position: absolute; width: 430px" text="#{resources.new_site}"/>
							<h:messages binding="#{site$newSite.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage" id="messageList1"
										infoClass="infoMessage" style="left: 552px; top: 24px; position: absolute" warnClass="warnMessage"/>
							<webuijsf:label binding="#{site$newSite.label3}" id="label3" requiredIndicator="true"
											style="left: 48px; top: 72px; position: absolute" text="#{resources.description}"/>
							<webuijsf:textArea binding="#{site$newSite.txt_description}" id="txt_description" style="height: 48px; left: 168px; top: 72px; position: absolute; width: 648px"/>
							<webuijsf:label binding="#{site$newSite.label4}" id="label4" requiredIndicator="true"
											style="left: 48px; top: 120px; position: absolute" text="#{resources.type}"/>
							<webuijsf:dropDown binding="#{site$newSite.dd_featureType}" id="dd_featureType" items="#{site$SiteSessionBean.featureTypeOption}"
											   selected="#{site$SiteSessionBean.selectedFeatureType}" style="left: 168px; top: 120px; position: absolute"/>
							<webuijsf:label binding="#{site$newSite.label5}" id="label5" requiredIndicator="true"
											style="left: 48px; top: 144px; position: absolute" text="#{resources.base_proyection}"/>
							<webuijsf:dropDown binding="#{site$newSite.dd_baseProjection}" id="dd_baseProjection"
											   items="#{site$SiteSessionBean.projectionOption}" selected="#{site$SiteSessionBean.selectedProjection}" style="left: 168px; top: 144px; position: absolute"/>
							<webuijsf:label binding="#{site$newSite.label6}" id="label6" requiredIndicator="true"
											style="left: 48px; top: 168px; position: absolute" text="#{resources.determination_method}"/>
							<webuijsf:dropDown binding="#{site$newSite.dd_siteCalculationMethod}" id="dd_siteCalculationMethod"
											   items="#{site$SiteSessionBean.siteCalculationMethod}" selected="#{site$SiteSessionBean.selectedSiteCalculationMethod}" style="left: 168px; top: 168px; position: absolute"/>
							<webuijsf:label binding="#{site$newSite.label7}" id="label7" style="left: 48px; top: 192px; position: absolute" text="#{resources.presition}"/>
                            <webuijsf:textField binding="#{site$newSite.txt_precision}" id="txt_precision" style="left: 168px; top: 192px; position: absolute" validatorExpression="#{util$ValidatorHelper.integerNumberFormatValidator}"/>
							<webuijsf:label binding="#{site$newSite.label8}" id="label8" requiredIndicator="true"
											style="left: 48px; top: 216px; position: absolute" text="#{resources.orig_proyection}"/>
							<webuijsf:dropDown binding="#{site$newSite.dd_originalProjection}" id="dd_originalProjection"
											   items="#{site$SiteSessionBean.originalProjection}" selected="#{site$SiteSessionBean.selectedOriginalProjection}" style="left: 168px; top: 216px; position: absolute"/>
							<webuijsf:label binding="#{site$newSite.label9}" id="label9" style="left: 48px; top: 240px; position: absolute" text="#{resources.datum}"/>
                            <webuijsf:textField binding="#{site$newSite.txt_datum}" id="txt_datum" style="left: 168px; top: 240px; position: absolute" validatorExpression="#{util$ValidatorHelper.integerNumberFormatValidator}"/>
							<webuijsf:tabSet binding="#{site$newSite.tabSet1}" id="tabSet1" selected="tab1" style="border: 1px solid gray; height: 35px; left: 48px; top: 288px; position: absolute; width: 766px">
								<webuijsf:tab binding="#{site$newSite.tab1}" id="tab1" text="#{resources.coordinates}">
									<webuijsf:panelLayout binding="#{site$newSite.layoutPanel1}" id="layoutPanel1" style="height: 203px; position: relative; width: 100%; -rave-layout: grid">
										<webuijsf:label binding="#{site$newSite.label10}" id="label10" requiredIndicator="true"
														style="left: 24px; top: 72px; position: absolute" text="#{resources.longitude}"/>
										<webuijsf:textField binding="#{site$newSite.txt_longitude}" id="txt_longitude" style="left: 96px; top: 72px; position: absolute; width: 120px"/>
										<webuijsf:label binding="#{site$newSite.label11}" id="label11" requiredIndicator="true"
														style="left: 24px; top: 96px; position: absolute" text="#{resources.latitude}"/>
										<webuijsf:textField binding="#{site$newSite.txt_latitude}" id="txt_latitude" style="left: 96px; top: 96px; position: absolute; width: 120px"/>
										<webuijsf:button actionExpression="#{site$newSite.btn_addCoordinate_action}" binding="#{site$newSite.btn_addCoordinate}"
														 id="btn_addCoordinate" style="height: 24px; left: 95px; top: 120px; position: absolute; width: 72px" text="#{resources.btnNew}"/>
										<webuijsf:table binding="#{site$newSite.table1}" id="table1"
														style="left: 383px; top: 72px; position: absolute; width: 364px" title="#{resources.currents}" width="364">
											<webuijsf:tableRowGroup binding="#{site$newSite.tableRowGroup1}" id="tableRowGroup1" rows="4"
																	sourceData="#{site$SiteSessionBean.coordinateDataProvider}" sourceVar="currentRow">
												<webuijsf:tableColumn binding="#{site$newSite.tableColumn1}" headerText="#{resources.longitude}" id="tableColumn1">
													<webuijsf:staticText binding="#{site$newSite.staticText1}" id="staticText1" text="#{currentRow.value['longitude']}"/>
												</webuijsf:tableColumn>
												<webuijsf:tableColumn binding="#{site$newSite.tableColumn2}" headerText="#{resources.latitude}" id="tableColumn2">
													<webuijsf:staticText binding="#{site$newSite.staticText2}" id="staticText2" text="#{currentRow.value['latitude']}"/>
												</webuijsf:tableColumn>
												<webuijsf:tableColumn binding="#{site$newSite.tableColumn3}" headerText="#{resources.action}" id="tableColumn3"
																	  sort="column3" style="text-align: center">
													<webuijsf:button actionExpression="#{site$newSite.btn_removeCoord_action}"
																	 binding="#{site$newSite.btn_removeCoord}" id="btn_removeCoord" text="#{resources.btnDelete}"/>
												</webuijsf:tableColumn>
											</webuijsf:tableRowGroup>
										</webuijsf:table>
									</webuijsf:panelLayout>
								</webuijsf:tab>
                                <webuijsf:tab id="tab2" text="#{resources.politicDivision}">
                                    <webuijsf:panelLayout id="layoutPanel_tab2" style="height: 203px; position: relative; width: 100%; -rave-layout: grid">
                                        <webuijsf:label id="label_contry" requiredIndicator="true" style="left: 0px; top: 72px; position: absolute" text="#{resources.Country}"/>
                                        <webuijsf:dropDown id="dd_country" items="#{site$SiteSessionBean.countriesDropDownData.options}" submitForm="true" actionExpression="#{site$SiteSessionBean.onCountryChange}"
                                            selected="#{site$SiteSessionBean.selectedCountryId}" style="left: 150px; top: 72px; position: absolute; width: 120px"/>
                                            <webuijsf:label id="label_province" requiredIndicator="true" style="left: 0px; top: 96px; position: absolute" text="#{resources.province}"/>
                                        <webuijsf:dropDown id="dd_province" items="#{site$SiteSessionBean.provincesDropDownData.options}"
                                            selected="#{site$SiteSessionBean.selectedProvinceId}" style="left: 150px; top: 96px; position: absolute; width: 120px"/>
                                    </webuijsf:panelLayout>
                                </webuijsf:tab>
							</webuijsf:tabSet>
							<webuijsf:button actionExpression="#{site$newSite.btn_save_action}" binding="#{site$newSite.btn_save}" id="btn_save"
											 style="height: 24px; left: 383px; top: 144px; position: absolute; width: 71px" text="#{resources.btnSave}"/>
						</webuijsf:form>
					</webuijsf:panelLayout>
					<jsp:directive.include file="/footer.jspf"/>
				</webuijsf:body>
			</webuijsf:html>
		</webuijsf:page>
	</f:view>
</jsp:root>
