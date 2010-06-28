

function onClickEvent(oArgs) {
    
    selectedNodeId = oArgs.node.data;
    selectedNodeName = oArgs.node.label;
    setHiddenNodeId(selectedNodeId);
    setHiddenPathNode(getPathNode(oArgs.node));
    if(oArgs.node.isLeaf){
        isLeaf = 'true';
    }
    else{
        isLeaf = 'false';
    }
     setInformation(selectedNodeId);
}

function setInformation(selectedNodeId)
{
    
    var parameter = new Array();
    var url = "../../../IndicatorWebServiceService/IndicatorWebService";
    //alert(node.data);
    parameter["indicatorId"]=selectedNodeId;
    var indicatorChildrenPost = SOAPClient.request(url, "getIndicatorByIndicatorId", parameter);
    var indicatorChildrenXML=stringToXML(indicatorChildrenPost);
    var indicatorChildren =indicatorChildrenXML.getElementsByTagName("indicator");
    var sname = indicatorChildren[0].getElementsByTagName("name")[0].childNodes[0].nodeValue;
    var sdescription = indicatorChildren[0].getElementsByTagName("description")[0].childNodes[0].nodeValue;
    var sapplyToParts = indicatorChildren[0].getElementsByTagName("applyToParts")[0].childNodes[0].nodeValue;    
    if(sdescription == 'null')
    {
        
        sdescription="";
    }
    var name = document.getElementById('contenido:form1:tabSet1:tabNewIndicator:txIndicatorName');
    name.setProps({value: sname});
    var description = document.getElementById('contenido:form1:tabSet1:tabNewIndicator:txaIndicatorDescription');
    description.setProps({value: sdescription});
    var applyToParts = document.getElementsByName('contenido:form1:tabSet1:tabNewIndicator:myRadio');
    applyToParts[sapplyToParts].checked = true;
    
    
}