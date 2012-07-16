/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var specimenList = new Array();
var specimenTitle;
var speciesList = new Array();
var speciesTitle;
var chart;

$(document).ready(function() {

    //Get data for specimens and species charts
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

function parseTable(tableHTML){
    var result = new Array();
    var tRows = tableHTML.rows;
    for(var i = 0;i<tRows.length;i++){
        var row = tRows[i];
        var cells = row.cells;
        var node = new Array();
        node.push(cells[0].firstChild.nodeValue);
        node.push(parseInt(cells[1].firstChild.nodeValue));
        result.push(node);
    }
    return result;
}