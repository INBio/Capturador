<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Welcome
    Created on : 23/09/2009, 02:47:09 PM
    Author     : esmata
-->
<jsp:root version="2.1" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head binding="#{Header_Login.head1}" id="head1">
                    <webuijsf:link id="link2" url="/resources/css/stylesheet.css"/>
                    <webuijsf:script type="text/javascript" url="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></webuijsf:script>
                    <webuijsf:script type="text/javascript" url="/resources/js/charts/js/highcharts.js"></webuijsf:script>
                    <webuijsf:script type="text/javascript" url="/resources/js/charts/js/modules/exporting.js"></webuijsf:script>
                    <webuijsf:script type="text/javascript" url="/resources/js/inbio/parseTable.js"></webuijsf:script>
                    <script type="text/javascript">

                        var specimenList = new Array();
                        var specimenTitle;
                        var speciesList = new Array();
                        var speciesTitle;
                        var chart;

                        $(document).ready(function() {

                            //Get data for specimens chart
                            /*specimenList.push(new Array('Insecta',1000));
                            specimenList.push(new Array('Plantae',200));
                            specimenList.push(new Array('Fungi',500));
                            specimenList.push(new Array('Mollusca',10));
                            specimenList.push(new Array('Chordata',59));*/
                            loadChartsData();

                            chart = new Highcharts.Chart({
                                chart: {
                                    renderTo: 'chartSpecimens',
                                    plotBackgroundColor: null,
                                    plotBorderWidth: null,
                                    plotShadow: false
                                },
                                title: {
                                    text: specimenTitle
                                },
                                tooltip: {
                                    formatter: function() {
                                        return '<b>'+ this.point.name +'</b>: '+ this.y;
                                    }
                                },
                                plotOptions: {
                                    pie: {
                                        allowPointSelect: true,
                                        cursor: 'pointer',
                                        dataLabels: {
                                            enabled: true,
                                            color: '#000000',
                                            connectorColor: '#000000',
                                            formatter: function() {
                                                return '<b>'+ this.point.name +'</b>: '+ this.y;
                                            }
                                        }
                                    }
                                },
                                series: [{
                                        type: 'pie',
                                        name: 'Browser share',
                                        data: specimenList
                                    }]
                            });

                            //Get data for species chart
                            /*speciesList.push(new Array('Insecta',650));
                            speciesList.push(new Array('Plantae',200));
                            speciesList.push(new Array('Fungi',500));
                            speciesList.push(new Array('Mollusca',10));
                            speciesList.push(new Array('Chordata',100));*/

                            chart = new Highcharts.Chart({
                                chart: {
                                    renderTo: 'chartSpecies',
                                    plotBackgroundColor: null,
                                    plotBorderWidth: null,
                                    plotShadow: false
                                },
                                title: {
                                    text: speciesTitle
                                },
                                tooltip: {
                                    formatter: function() {
                                        return '<b>'+ this.point.name +'</b>: '+ this.y;
                                    }
                                },
                                plotOptions: {
                                    pie: {
                                        allowPointSelect: true,
                                        cursor: 'pointer',
                                        dataLabels: {
                                            enabled: true,
                                            color: '#000000',
                                            connectorColor: '#000000',
                                            formatter: function() {
                                                return '<b>'+ this.point.name +'</b>: '+ this.y;
                                            }
                                        }
                                    }
                                },
                                series: [{
                                        type: 'pie',
                                        name: 'Browser share',
                                        data: speciesList
                                    }]
                            });
                        });

                        /**
                         * This function sets all the data to be rendered in the charts
                         */
                        function loadChartsData(){
                            //Set the titles for the charts
                            var spTitle = document.getElementById('contenido:form1:SystemStatistics:specimenTitle');
                            specimenTitle = spTitle.value;
                            var sp2Title = document.getElementById('contenido:form1:SystemStatistics:speciesTitle');
                            speciesTitle = sp2Title.value;
                            //Set the data values for specimens chart
                            var spTable = document.getElementById('contenido:form1:SystemStatistics:dataTableSpecimens');
                            specimenList = parseTable(spTable);
                            //Set the data values for species chart
                            var sp2Table = document.getElementById('contenido:form1:SystemStatistics:dataTableSpecies');
                            speciesList = parseTable(sp2Table);
                        }

                    </script>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <div id="pageFormated">
                        <jsp:directive.include file="/Header.jspf"/>
                        <webuijsf:panelLayout id="contenido">
                            <webuijsf:form id="form1">
                                <h:outputLabel id="lbTitle" style="height: 24px; left: 24px; top: 10px; position: relative; width: 840px;" styleClass="Page_title" value="#{resources.system_statistics}"/>
                                <jsp:directive.include file="/statistics/Statistics.jspf"/>
                            </webuijsf:form>
                        </webuijsf:panelLayout> <!-- contenido ends -->
                        <jsp:directive.include file="/Footer.jspf"/>
                    </div> <!-- pageFormated ends -->
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
