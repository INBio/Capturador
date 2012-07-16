




function loadNodeData(node, fnLoadComplete){
    var parameter = new Array();
    var url = "../../../IndicatorWebServiceService/IndicatorWebService";
    //alert(node.data);
    parameter["indicatorId"]=node.data;
    var indicatorChildrenPost = SOAPClient.request(url, "getChildrenByIndicatorId", parameter);
    //alert(indicatorChildrenPost);
    /*
    var indicatorChildrenXML=stringToXML(indicatorChildrenPost);
    alert(indicatorChildrenXML.getElementsByTagName("indicatorChildren"));
    var indicatorChildren =indicatorChildrenXML.getElementsByTagName("indicator");
    */
    //var indicatorChildren =indicatorChildrenXML.getElementsByTagName("return");
    //alert(indicatorChildren.length);
    //var indicatorChildren = indicatorChildrenXML.childNodes;
    //alert(indicatorChildren);
    //alert(indicatorChildrenXML.childNodes.length);
    var focusNode = false;
    if(indicatorChildrenPost.length==0){
        node.isLeaf = true;
        isLeaf = "true";
    }
    else{
        isLeaf = "false";
    }
    for(var pos = 0; pos < indicatorChildrenPost.length; pos++)
    {
        //var id = indicatorChildren[pos].getElementsByTagName("id")[0].childNodes[0].nodeValue;
        //var name = indicatorChildren[pos].getElementsByTagName("name")[0].childNodes[0].nodeValue;
        var id = indicatorChildrenPost[pos].getElementsByTagName("indicatorId")[0].childNodes[0].nodeValue;
        var name = indicatorChildrenPost[pos].getElementsByTagName("name")[0].childNodes[0].nodeValue;
        var expand = false;
        if(isPath(id))
        {
            expand=true;
            //alert("expandir "+id);
        }
        var tempNode = new YAHOO.widget.TextNode(name, node, expand);
        tempNode.data = id;
        if(id==nodeId)
        {
         //tempNode.highlight(true);
         //tempNode.focus();
         //tree.root.children[0].children[0].focus();
        // alert(tree.root.children[0]);
         //alert(nodeId+" = "+id);
         focusNode = true;
        }
        //tempNode.collapseAll();

    }

   //var id =  2;
   //var name =  'nodo';
   //alert( tree.getNodeByProperty("data",nodeId));
   //tree.root.children[0].focus();
   //tree.getNodeByProperty("data",nodeId).focus();
  
   
   node.loadComplete();

    if(focusNode)
   {
        //alert(tree.getNodeByProperty("data",nodeId));
        tree.getNodeByProperty("data",nodeId).focus();
        //var tmpNodePath = tree.root.children[0].children[0];
        //alert(tmpNodePath.children[1].focus());
        //alert(tmpNodePath.children[1].children);
        //alert(tmpNodePath.children[1].children[0].children);
        //tmpNodePath.children[1].children[0].children[0].focus();
        //tree.root.children[0].children[0].children[0].focus();

   }

}

function onFocus(pathNode)
{

}

function isPath(pathNodeId)
{
    result = false;
    //alert(pathNode);
    for(var pos = 0; pos < pathNode.length-1;pos++)
    {
        //alert(pathNodeId +" = "+pathNode[pos]);
        if(pathNodeId == pathNode[pos])
        {
            result = true;
            break;
        }
    }
    return result;
}

function getPathNode(nodeChild)
{
    var result = "";
    var depthNode = nodeChild.depth;    
    var current = nodeChild;        
    result = current.data+result;
    for(var pos = 0; pos < depthNode; pos++)
    {
            current = current.parent;
            var tmp = result;
            result = current.data+","+tmp;          
            
    }
    return result;
}

function getNode(idNode){
    var result = [];
    var parameter = new Array();
    var url = "../../../IndicatorWebServiceService/IndicatorWebService";
    //alert(node.data);
    parameter["indicatorId"]=idNode;
    var indicatorNodePost = SOAPClient.request(url, "getIndicatorByIndicatorId", parameter);
    //var indicatorNodeXML=stringToXML(indicatorNodePost);
    var indicatorNodeXML=stringToXML(indicatorNodePost[0].childNodes[0].nodeValue);
    //alert(indicatorNodePost[0].childNodes[0].nodeValue);
    var indicatorNode =indicatorNodeXML.getElementsByTagName("indicator");
    result[0] = indicatorNode[0].getElementsByTagName("id")[0].childNodes[0].nodeValue;
    result[1] = indicatorNode[0].getElementsByTagName("name")[0].childNodes[0].nodeValue;
    return result;
}

function stringToXML(xmlData)
{
    var xmlDoc;
    if (window.ActiveXObject) {
        xmlDoc=new ActiveXObject('Microsoft.XMLDOM');
        xmlDoc.async='false';
        xmlDoc.loadXML(xmlData);
        //return xmlDoc
    } else if (document.implementation && document.implementation.createDocument) {
        parser=new DOMParser();
        xmlDoc=parser.parseFromString(xmlData,'text/xml');
        //return xmlDoc;
    }
    return xmlDoc;
}
        

function setHiddenNodeId(idNode)
{
    var hiddenNodeId = document.getElementById('contenido:form1:hiddenNodeId');
    hiddenNodeId.value = idNode;
    //alert(document.getElementById('contenido:form1:hiddenNodeId').value);
}

function setHiddenPathNode(path)
{
    var hiddenPathNode = document.getElementById('contenido:form1:hiddenPathNode');
    hiddenPathNode.value = path;
    
}

function getHiddenNodeId(idNode)
{
    var hiddenNodeId = document.getElementById('contenido:form1:hiddenNodeId');
    return hiddenNodeId.value;
    //alert(document.getElementById('contenido:form1:hiddenNodeId').value);
}

function getHiddenPathNode(path)
{
    var hiddenPathNode = document.getElementById('contenido:form1:hiddenPathNode');
    return hiddenPathNode.value;

}

