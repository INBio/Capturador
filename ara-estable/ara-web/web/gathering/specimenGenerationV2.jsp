<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
	<jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
	<f:view>
		<webuijsf:page binding="#{gathering$specimenGenerationV2.page1}" id="page1">
			<webuijsf:html binding="#{gathering$specimenGenerationV2.html1}" id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link binding="#{Header_Login.link1}" id="link1" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script  id="script1" type="text/JavaScript" url="/resources/js/footer.js"/>
                </webuijsf:head>
				<webuijsf:body binding="#{gathering$specimenGenerationV2.body1}" id="body1" style="-rave-layout: grid">
					<jsp:directive.include file="/Header.jspf"/>
					<webuijsf:panelLayout id="contenido">
						<webuijsf:form binding="#{gathering$specimenGenerationV2.form1}" id="form1">
							<webuijsf:label binding="#{gathering$specimenGenerationV2.label2}" id="label2"
											style="font-size: 24px; height: 22px; left: 48px; top: 24px; position: absolute; width: 334px" text="#{resources.sp_gen_and_identifications}"/>
							<webuijsf:staticText binding="#{gathering$specimenGenerationV2.st_gatheringDesc}" id="st_gatheringDesc" style="height: 22px; left: 168px; top: 72px; position: absolute; width: 358px"/>
							<webuijsf:label binding="#{gathering$specimenGenerationV2.label3}" id="label3"
											style="height: 24px; left: 48px; top: 72px; position: absolute; width: 94px" text="#{resources.gathering_observation}"/>
							<webuijsf:button actionExpression="#{gathering$specimenGenerationV2.btn_generate_action}"
											 binding="#{gathering$specimenGenerationV2.btn_generate}" id="btn_generate"
											 style="height: 24px; left: 575px; top: 72px; position: absolute; width: 72px" text="#{resources.generate}"/>
							<h:messages binding="#{gathering$specimenGenerationV2.messageList1}" errorClass="errorMessage" fatalClass="fatalMessage"
										id="messageList1" infoClass="infoMessage" style="left: 408px; top: 24px; position: absolute" warnClass="warnMessage"/>
							<webuijsf:tabSet binding="#{gathering$specimenGenerationV2.tabSet1}" id="tabSet1" selected="tab_specimenInfo" style="height: 334px; left: 48px; top: 120px; position: absolute; width: 766px">
								<webuijsf:tab binding="#{gathering$specimenGenerationV2.tab_specimenInfo}" id="tab_specimenInfo" text="#{resources.specimen}">
									<webuijsf:panelLayout binding="#{gathering$specimenGenerationV2.layoutPanel1}" id="layoutPanel1" style="height: 250px; position: relative; width: 767px; -rave-layout: grid">
										<webuijsf:tabSet binding="#{gathering$specimenGenerationV2.tabSet2}" id="tabSet2" selected="tab1" style="height: 286px; left: 0px; top: 0px; position: absolute; width: 766px">
											<webuijsf:tab actionExpression="#{gathering$specimenGenerationV2.tab1_action}"
														  binding="#{gathering$specimenGenerationV2.tab1}" id="tab1" text="#{resources.basic_information}">
												<webuijsf:panelLayout binding="#{gathering$specimenGenerationV2.layoutPanel3}" id="layoutPanel3" style="height: 250px; position: relative; width: 100%; -rave-layout: grid">
													<webuijsf:textField binding="#{gathering$specimenGenerationV2.txt_certaintyLevel}" id="txt_certaintyLevel" style="left: 456px; top: 72px; position: absolute"/>
													<webuijsf:dropDown binding="#{gathering$specimenGenerationV2.dd_extractionType}" id="dd_extractionType"
																	   items="#{gathering$SpecimenGenerationSessionBean.extractionMethod}"
																	   selected="#{gathering$SpecimenGenerationSessionBean.selectedExtractionMethod}" style="left: 144px; top: 216px; position: absolute"/>
													<webuijsf:label binding="#{gathering$specimenGenerationV2.label1}" id="label1"
																	style="left: 312px; top: 48px; position: absolute; width: 141px" text="#{resources.num_fragments}"/>
													<webuijsf:textField binding="#{gathering$specimenGenerationV2.txt_quantity}" columns="7" id="txt_quantity"
																		maxLength="7" style="left: 120px; top: 24px; position: absolute; width: 71px"/>
													<webuijsf:textField binding="#{gathering$specimenGenerationV2.txt_numberFragment}" id="txt_numberFragment"
																		maxLength="6" style="left: 456px; top: 48px; position: absolute; width: 71px"/>
													<webuijsf:dropDown binding="#{gathering$specimenGenerationV2.dd_preservationMedium}"
																	   id="dd_preservationMedium" items="#{gathering$SpecimenGenerationSessionBean.preservationMediumOption}"
																	   selected="#{gathering$SpecimenGenerationSessionBean.selectedPreservationMedium}" style="left: 144px; top: 144px; position: absolute"/>
													<webuijsf:label binding="#{gathering$specimenGenerationV2.label4}" id="label4"
																	style="left: 24px; top: 192px; position: absolute" text="#{resources.substrate}"/>
													<webuijsf:label binding="#{gathering$specimenGenerationV2.label5}" id="label5"
																	style="left: 24px; top: 216px; position: absolute" text="#{resources.extraction_method}"/>
													<webuijsf:listbox binding="#{gathering$specimenGenerationV2.lst_lifeForm}" id="lst_lifeForm"
																	  items="#{gathering$SpecimenGenerationSessionBean.lifeFormOption}" multiple="true" rows="4"
																	  selected="#{gathering$SpecimenGenerationSessionBean.selectedLifeForm}" separators="false" style="height: 72px; left: 456px; top: 168px; position: absolute; width: 141px"/>
													<webuijsf:label binding="#{gathering$specimenGenerationV2.label6}" id="label6"
																	style="left: 24px; top: 96px; position: absolute" text="#{resources.type}"/>
													<webuijsf:label binding="#{gathering$specimenGenerationV2.label7}" id="label7"
																	style="left: 312px; top: 72px; position: absolute" text="#{resources.certainty_level}"/>
													<webuijsf:label binding="#{gathering$specimenGenerationV2.label8}" id="label8"
																	style="left: 312px; top: 24px; position: absolute; width: 117px" text="#{resources.num_whole}"/>
													<webuijsf:label binding="#{gathering$specimenGenerationV2.label9}" id="label9"
																	style="left: 312px; top: 144px; position: absolute" text="#{resources.type}"/>
													<webuijsf:label binding="#{gathering$specimenGenerationV2.label10}" id="label10"
																	style="left: 24px; top: 120px; position: absolute" text="#{resources.origin}"/>
													<webuijsf:label binding="#{gathering$specimenGenerationV2.label11}" id="label11"
																	style="left: 24px; top: 24px; position: absolute" text="#{resources.quantity}"/>
													<webuijsf:dropDown binding="#{gathering$specimenGenerationV2.dd_specimenCategory}" id="dd_specimenCategory"
																	   items="#{gathering$SpecimenGenerationSessionBean.specimenCategoryOption}"
																	   onChange="webuijsf.suntheme.common.timeoutSubmitForm(this.form, 'tabSet1:tab_specimenInfo:layoutPanel1:tabSet2:tab1:layoutPanel3:dd_specimenCategory');"
																	   selected="#{gathering$SpecimenGenerationSessionBean.selectedSpecimenCategory}" style="left: 144px; top: 72px; position: absolute"/>
													<webuijsf:label binding="#{gathering$specimenGenerationV2.label12}" id="label12"
																	style="left: 24px; top: 168px; position: absolute" text="#{resources.storage}"/>
													<webuijsf:dropDown binding="#{gathering$specimenGenerationV2.dd_gatheringObservationMethod}"
																	   id="dd_gatheringObservationMethod" items="#{gathering$SpecimenGenerationSessionBean.gatheringMethods}"
																	   selected="#{gathering$SpecimenGenerationSessionBean.selectedGatheringMethod}" style="left: 144px; top: 48px; position: absolute"/>
													<webuijsf:textField binding="#{gathering$specimenGenerationV2.txt_numberWhole}" id="txt_numberWhole"
																		maxLength="6" style="left: 456px; top: 24px; position: absolute; width: 71px"/>
													<webuijsf:label binding="#{gathering$specimenGenerationV2.label13}" id="label13"
																	style="left: 24px; top: 72px; position: absolute" text="#{resources.category}"/>
													<webuijsf:calendar binding="#{gathering$specimenGenerationV2.cal_ObsDate}" id="cal_ObsDate" style="left: 456px; top: 96px; position: absolute" maxDate="#{ApplicationBean1.todayDate}" minDate="#{ApplicationBean1.minDate}" />
													<webuijsf:label binding="#{gathering$specimenGenerationV2.label14}" id="label14"
																	style="left: 24px; top: 144px; position: absolute" text="#{resources.preservation_medium}"/>
													<webuijsf:dropDown binding="#{gathering$specimenGenerationV2.dd_origin}" id="dd_origin"
																	   items="#{gathering$SpecimenGenerationSessionBean.originOption}"
																	   selected="#{gathering$SpecimenGenerationSessionBean.selectedOrigin}" style="left: 144px; top: 120px; position: absolute"/>
													<webuijsf:dropDown binding="#{gathering$specimenGenerationV2.dd_specimenType}" id="dd_specimenType"
																	   items="#{gathering$SpecimenGenerationSessionBean.specimenTypeOption}"
																	   selected="#{gathering$SpecimenGenerationSessionBean.selectedSpecimenType}" style="left: 144px; top: 96px; position: absolute"/>
													<webuijsf:label binding="#{gathering$specimenGenerationV2.label15}" id="label15"
																	style="left: 24px; top: 48px; position: absolute" text="#{resources.gath_method}"/>
													<webuijsf:label binding="#{gathering$specimenGenerationV2.label16}" id="label16"
																	style="left: 312px; top: 168px; position: absolute" text="#{resources.life_forms}"/>
													<webuijsf:textField binding="#{gathering$specimenGenerationV2.txt_ObsTime}" id="txt_ObsTime" style="left: 456px; top: 144px; position: absolute"/>
													<webuijsf:dropDown binding="#{gathering$specimenGenerationV2.dd_storageType}" id="dd_storageType"
																	   items="#{gathering$SpecimenGenerationSessionBean.storageTypeOption}"
																	   selected="#{gathering$SpecimenGenerationSessionBean.selectedStorageType}" style="left: 144px; top: 168px; position: absolute"/>
													<webuijsf:label binding="#{gathering$specimenGenerationV2.label17}" id="label17"
																	style="left: 312px; top: 96px; position: absolute" text="#{resources.date}"/>
													<webuijsf:dropDown binding="#{gathering$specimenGenerationV2.dd_substrate}" id="dd_substrate"
																	   items="#{gathering$SpecimenGenerationSessionBean.substrateOption}"
																	   selected="#{gathering$SpecimenGenerationSessionBean.selectedSubstrate}" style="left: 144px; top: 192px; position: absolute"/>
												</webuijsf:panelLayout>
											</webuijsf:tab>
											<webuijsf:tab binding="#{gathering$specimenGenerationV2.tab2}" id="tab2" text="#{resources.lf_sex}">
												<webuijsf:panelLayout binding="#{gathering$specimenGenerationV2.layoutPanel4}" id="layoutPanel4" style="height: 248px; position: relative; width: 765px; -rave-layout: grid">
													<webuijsf:textField binding="#{gathering$specimenGenerationV2.txt_ssQuantity}" columns="4"
																		id="txt_ssQuantity" maxLength="4" style="left: 96px; top: 72px; position: absolute; width: 47px"/>
													<webuijsf:label binding="#{gathering$specimenGenerationV2.label18}" id="label18"
																	style="left: 24px; top: 72px; position: absolute" text="#{resources.quantity}"/>
													<webuijsf:label binding="#{gathering$specimenGenerationV2.label19}" id="label19"
																	style="left: 24px; top: 48px; position: absolute" text="#{resources.sex}"/>
													<webuijsf:dropDown binding="#{gathering$specimenGenerationV2.dd_stadium}" id="dd_stadium"
																	   items="#{gathering$SpecimenGenerationSessionBean.lifeStageOption}"
																	   selected="#{gathering$SpecimenGenerationSessionBean.selectedLifeStage}" style="left: 96px; top: 24px; position: absolute"/>
													<webuijsf:table binding="#{gathering$specimenGenerationV2.t_stadiumSex1}" id="t_stadiumSex1"
																	paginateButton="true" paginationControls="true"
																	style="height: 42px; left: 216px; top: 24px; position: absolute; width: 203px" title="Seleccionados" width="203">
														<webuijsf:tableRowGroup binding="#{gathering$specimenGenerationV2.tableRowGroup1}" id="tableRowGroup1"
																				rows="4" sourceData="#{gathering$SpecimenGenerationSessionBean.lifeStageSexSimpleDataProvider}" sourceVar="currentRow">
															<webuijsf:tableColumn binding="#{gathering$specimenGenerationV2.tableColumn1}"
																				  headerText="#{resources.life_stage}" id="tableColumn1" width="113">
																<webuijsf:staticText binding="#{gathering$specimenGenerationV2.staticText1}" id="staticText1" text="#{currentRow.value['lifeStageName']}"/>
															</webuijsf:tableColumn>
															<webuijsf:tableColumn binding="#{gathering$specimenGenerationV2.tableColumn2}"
																				  headerText="#{resources.sex}" id="tableColumn2">
																<webuijsf:staticText binding="#{gathering$specimenGenerationV2.staticText2}" id="staticText2" text="#{currentRow.value['sexName']}"/>
															</webuijsf:tableColumn>
															<webuijsf:tableColumn binding="#{gathering$specimenGenerationV2.tableColumn3}"
																				  headerText="#{resources.quantity}" id="tableColumn3" width="56">
																<webuijsf:staticText binding="#{gathering$specimenGenerationV2.staticText3}" id="staticText3" text="#{currentRow.value['quantity']}"/>
															</webuijsf:tableColumn>
															<webuijsf:tableColumn binding="#{gathering$specimenGenerationV2.tableColumn4}" id="tableColumn4" width="17">
																<webuijsf:button
																	actionExpression="#{gathering$specimenGenerationV2.btn_removeStadiumSex1_action}"
																	binding="#{gathering$specimenGenerationV2.btn_removeStadiumSex}" id="btn_removeStadiumSex"
																	style="height: 23px; left: 95px;" text="X"/>
															</webuijsf:tableColumn>
														</webuijsf:tableRowGroup>
													</webuijsf:table>
													<webuijsf:button actionExpression="#{gathering$specimenGenerationV2.btn_addStadiumSex1_action}"
																	 binding="#{gathering$specimenGenerationV2.btn_addStadiumSex}" id="btn_addStadiumSex"
																	 style="height: 23px; left: 47px; top: 96px; position: absolute; width: 60px" text="#{resources.add}"/>
													<webuijsf:dropDown binding="#{gathering$specimenGenerationV2.dd_sex}" id="dd_sex"
																	   items="#{gathering$SpecimenGenerationSessionBean.sexOption}"
																	   selected="#{gathering$SpecimenGenerationSessionBean.selectedSex}" style="left: 96px; top: 48px; position: absolute"/>
													<webuijsf:label binding="#{gathering$specimenGenerationV2.label20}" id="label20"
																	style="left: 24px; top: 24px; position: absolute" text="#{resources.life_stage}"/>
												</webuijsf:panelLayout>
											</webuijsf:tab>
										</webuijsf:tabSet>
									</webuijsf:panelLayout>
								</webuijsf:tab>
								<webuijsf:tab binding="#{gathering$specimenGenerationV2.tab_identificationInfo}" id="tab_identificationInfo" text="#{resources.identification}">
									<webuijsf:panelLayout binding="#{gathering$specimenGenerationV2.layoutPanel2}" id="layoutPanel2" style="height: 298px; position: relative; width: 100%; -rave-layout: grid">
										<webuijsf:tabSet binding="#{gathering$specimenGenerationV2.tabSet3}" id="tabSet3" selected="tab3" style="height: 286px; left: 0px; top: 0px; position: absolute; width: 766px">
											<webuijsf:tab binding="#{gathering$specimenGenerationV2.tab3}" id="tab3" text="Identificación Taxonómica">
												<webuijsf:panelLayout binding="#{gathering$specimenGenerationV2.layoutPanel5}" id="layoutPanel5" style="height: 248px; position: relative; width: 100%; -rave-layout: grid">
													<webuijsf:label binding="#{gathering$specimenGenerationV2.label21}" id="label21"
																	style="left: 24px; top: 168px; position: absolute" text="#{resources.taxonomical_level}"/>
													<webuijsf:label binding="#{gathering$specimenGenerationV2.label22}" id="label22"
																	style="left: 24px; top: 24px; position: absolute" text="#{resources.identification_date}"/>
													<webuijsf:addRemove availableItemsLabel="#{resources.available}"
																		binding="#{gathering$specimenGenerationV2.ad_taxonList}" id="ad_taxonList"
																		items="#{identification$IdentificationSessionBean.taxonList}" rows="10"
																		selected="#{identification$IdentificationSessionBean.selectedTaxon}"
																		selectedItemsLabel="#{resources.selected}" style="height: 214px; left: 336px; top: 24px; position: absolute"/>
													<webuijsf:label binding="#{gathering$specimenGenerationV2.label23}" id="label23"
																	style="left: 24px; top: 144px; position: absolute" text="#{resources.type}"/>
													<webuijsf:label binding="#{gathering$specimenGenerationV2.label24}" id="label24"
																	style="left: 24px; top: 120px; position: absolute" text="Status"/>
													<webuijsf:label binding="#{gathering$specimenGenerationV2.label25}" id="label25"
																	style="left: 24px; top: 96px; position: absolute" text="#{resources.validator}"/>
													<webuijsf:dropDown binding="#{gathering$specimenGenerationV2.dd_taxonomicalCategory}"
																	   id="dd_taxonomicalCategory" items="#{identification$IdentificationSessionBean.taxonCategoryOption}"
																	   onChange="webuijsf.suntheme.common.timeoutSubmitForm(this.form, 'tabSet1:tab_identificationInfo:layoutPanel2:tabSet3:tab3:layoutPanel5:dd_taxonomicalCategory');"
																	   selected="#{identification$IdentificationSessionBean.selectedTaxonCategory}"
																	   style="left: 144px; top: 192px; position: absolute" valueChangeListenerExpression="#{gathering$specimenGenerationV2.dd_taxonomicalCategory1_processValueChange}"/>
													<webuijsf:dropDown binding="#{gathering$specimenGenerationV2.dd_validator}" id="dd_validator"
																	   items="#{identification$IdentificationSessionBean.identificationValidatorOption}"
																	   selected="#{identification$IdentificationSessionBean.selectedIdentificationValidator}"
																	   style="left: 144px; top: 96px; position: absolute" valueChangeListenerExpression="#{gathering$specimenGenerationV2.dd_validator1_processValueChange}"/>
													<webuijsf:dropDown binding="#{gathering$specimenGenerationV2.dd_identificationStatus}"
																	   id="dd_identificationStatus"
																	   items="#{identification$IdentificationSessionBean.identificationStatusOption}"
																	   selected="#{identification$IdentificationSessionBean.selectedIdentificationStatus}"
																	   style="left: 144px; top: 120px; position: absolute" valueChangeListenerExpression="#{gathering$specimenGenerationV2.dd_identificationStatus1_processValueChange}"/>
													<webuijsf:label binding="#{gathering$specimenGenerationV2.label26}" id="label26"
																	style="left: 24px; top: 192px; position: absolute" text="#{resources.category}"/>
													<webuijsf:dropDown binding="#{gathering$specimenGenerationV2.dd_taxonomicalRange}" id="dd_taxonomicalRange"
																	   items="#{identification$IdentificationSessionBean.taxonomicalRangeOption}"
																	   onChange="webuijsf.suntheme.common.timeoutSubmitForm(this.form, 'tabSet1:tab_identificationInfo:layoutPanel2:tabSet3:tab3:layoutPanel5:dd_taxonomicalRange');"
																	   selected="#{identification$IdentificationSessionBean.selectedTaxonomicalRange}"
																	   style="left: 144px; top: 168px; position: absolute" valueChangeListenerExpression="#{gathering$specimenGenerationV2.dd_taxonomicalRange1_processValueChange}"/>
													<webuijsf:dropDown binding="#{gathering$specimenGenerationV2.dd_identificationType}"
																	   id="dd_identificationType" items="#{identification$IdentificationSessionBean.identificationTypeOption}"
																	   selected="#{identification$IdentificationSessionBean.selectedIdentificationType}"
																	   style="left: 144px; top: 144px; position: absolute" valueChangeListenerExpression="#{gathering$specimenGenerationV2.dd_identificationType1_processValueChange}"/>
													<webuijsf:calendar binding="#{gathering$specimenGenerationV2.cal_identificationDate}" maxDate="#{ApplicationBean1.todayDate}" minDate="#{ApplicationBean1.minDate}" 
																	   dateFormatPattern="dd/MM/yyyy" dateFormatPatternHelp="dd/MM/yyyy" id="cal_identificationDate"
																	   selectedDate="#{identification$IdentificationSessionBean.identificationDate}"
																	   style="left: 24px; top: 48px; position: absolute" valueChangeListenerExpression="#{gathering$specimenGenerationV2.cal_identificationDate1_processValueChange}"/>
													<webuijsf:label binding="#{gathering$specimenGenerationV2.label27}" id="label27"
																	style="left: 264px; top: 24px; position: absolute" text="Taxa"/>
												</webuijsf:panelLayout>
											</webuijsf:tab>
											<webuijsf:tab binding="#{gathering$specimenGenerationV2.tab4}" id="tab4" text="#{resources.identifiers}">
												<webuijsf:panelLayout binding="#{gathering$specimenGenerationV2.layoutPanel6}" id="layoutPanel6" style="height: 248px; position: relative; width: 100%; -rave-layout: grid">
													<webuijsf:addRemove availableItemsLabel="Disponibles:"
																		binding="#{gathering$specimenGenerationV2.ar_identifier}" id="ar_identifier"
																		items="#{identification$IdentificationSessionBean.identifierOption}"
																		selected="#{identification$IdentificationSessionBean.selectedIdentifier}"
																		selectedItemsLabel="Seleccionados:" style="left: 24px; top: 24px; position: absolute"/>
												</webuijsf:panelLayout>
											</webuijsf:tab>
										</webuijsf:tabSet>
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
