
function onClickEvent(oArgs) {
    selectedNodeId = oArgs.node.data;
    selectedNodeName = oArgs.node.label;
    setHiddenTaxonNodeId(selectedNodeId);
    setHiddenPathTaxonNode(getPathNode(oArgs.node));
    if(oArgs.node.isLeaf){
        isLeaf = 'true';
    }
    else{
        isLeaf = 'false';
    }

    alert(getHiddenTaxonNodeId());
    setInformation(selectedNodeId);
}


function setInformation(selectedNodeId)
{

    var parameter = new Array();
    var url = "../../../TaxonomyWebServiceService/TaxonomyWebService";
    //alert(node.data);
    parameter["taxonId"]=selectedNodeId;
    var taxonRangesChildrenPost = SOAPClient.request(url, "getNextLevelsByTaxon", parameter);
    var taxonRangesChildrenXML=stringToXML(taxonRangesChildrenPost);
    var taxonRangeChildren =taxonRangesChildrenXML.getElementsByTagName("taxonRange");
    //var sid = taxonRangeChildren[0].getElementsByTagName("id")[0].childNodes[0].nodeValue;
    //var sname = taxonRangeChildren[0].getElementsByTagName("name")[0].childNodes[0].nodeValue;
    //alert(taxonRangesChildrenPost);
    var ddRangeList = document.getElementById('contenido:form1:tabSet1:tabNewTaxonomy:ddRange');
    //alert(ddRangeList.value);
    //alert(ddRangeList.options);
    //var copia = ddRangeList.firstChild.cloneNode();
    var copia;
    removeOptions(ddRangeList);
    addOptions(ddRangeList, taxonRangeChildren, copia);
    //alert(copia);
    //name.setProps({value: sname});
    var tab = document.getElementById('contenido:form1:tabSet1:tabNewTaxonomy:rangePanel');
    alert(tab.innerHTML);
    alert("El valor del NodeId de la pagina es = "+getHiddenTaxonNodeId());
    
}

function removeOptions(dropDownList)
{  
    var i;
    for (i = dropDownList.length - 1; i>=0; i--) {

        dropDownList.remove(i)
    
    }   
}

function addOptions(dropDownList, newOptionList, copia)
{
    //alert(newOptionList);
    var i;
    for(i= 0; i < newOptionList.length; i++)
    {
        var sid = newOptionList[i].getElementsByTagName("id")[0].childNodes[0].nodeValue;
        var sname = newOptionList[i].getElementsByTagName("name")[0].childNodes[0].nodeValue;
        var newOption = document.createElement('Option');
        newOption.text = sname;
        newOption.value = sid;
        //alert(newOption);
        
        try {
          dropDownList.add(newOption, null); // standards compliant; doesn't work in IE
        }
        catch(ex) {
          dropDownList.add(newOption); // IE only
        }

        

    }
    //alert(dropDownList.innerHTML);

}


