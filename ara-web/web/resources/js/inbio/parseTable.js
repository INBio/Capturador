/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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