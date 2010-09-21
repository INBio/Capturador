function loadNodeData(node, fnLoadComplete){
    var parameter = new Array();
    var url = "../../../TaxonomyWebServiceService/TaxonomyWebService";
    parameter["taxonId"]=node.data;
    var taxonomyChildrenPost = SOAPClient.request(url, "getChildrenByTaxonId", parameter);
    //alert(taxonomyChildrenPost);
    //var taxonomyChildrenXML=stringToXML(taxonomyChildrenPost);
    //var taxonomyChildren =taxonomyChildrenXML.getElementsByTagName("taxon");
    var focusNode = false;
    if(taxonomyChildrenPost.length==0){
        node.isLeaf = true;
        isLeaf = "true";
    }
    else{
        isLeaf = "false";
    }
    for(var pos = 0; pos < taxonomyChildrenPost.length; pos++)
    {
        //var id = taxonomyChildren[pos].getElementsByTagName("id")[0].childNodes[0].nodeValue;
        //var name = taxonomyChildren[pos].getElementsByTagName("name")[0].childNodes[0].nodeValue;
       //var name = getCDATA(taxonomyChildren[pos].getElementsByTagName("name")[0]);
       var id = taxonomyChildrenPost[pos].getElementsByTagName("taxonKey")[0].childNodes[0].nodeValue;
       var name = taxonomyChildrenPost[pos].getElementsByTagName("currentName")[0].childNodes[0].nodeValue;
        //alert(name);
        var expand = false;
        if(isPath(id))
        {
            expand=true;

        }
        var tempNode = new YAHOO.widget.TextNode(name, node, expand);
        tempNode.data = id;
        if(id==nodeId)
        {
         focusNode = true;
        }
    }


   node.loadComplete();

    if(focusNode)
   {
        tree.getNodeByProperty("data",nodeId).focus();

   }
   
}


function getCDATA(element){

    var ie = (typeof window.ActiveXObject != 'undefined');
    var returnText;

    if(ie){
        if(element.hasChildNodes){
            returnText = element.childNodes[0].nodeValue;
        }
    }
    else{

        if(element.hasChildNodes){

        //alert(element.childNodes[0].nodeValue);
        returnText = element.childNodes[0].nodeValue;
        //returnText = element.texContent;
        }
    }

    return returnText;

}


function getNodeRoot(type, idCollecionNomencGroup){
    //alert("tipo = "+ type + " , id = "+idCollecionNomencGroup);
    var result = [];
    var parameter = new Array();
    var url = "../../../TaxonomyWebServiceService/TaxonomyWebService";
    var taxonomyRootPost;
    var taxonomyNodeXML;
    var taxonomyRootNode;
    //alert(node.data);
    if(type == 0)
    {
        //alert("Es coleccion");
        parameter["collectionId"]=idCollecionNomencGroup;
        taxonomyRootPost = SOAPClient.request(url, "getTaxonRootByCollectionId", parameter);
        //taxonomyNodeXML=stringToXML(taxonomyRootPost);
        taxonomyNodeXML=stringToXML(taxonomyRootPost[0].childNodes[0].nodeValue);
        taxonomyRootNode =taxonomyNodeXML.getElementsByTagName("taxonRoot");
    }
    else
    {
        //alert("Es grupo nomenclatural");
        parameter["rangeId"]=0; //de momento apunta a la raiz del arbol
        taxonomyRootPost = SOAPClient.request(url, "getAllTaxonByRange", parameter);
        //alert(taxonomyRootPost);
        //taxonomyNodeXML=stringToXML(taxonomyRootPost)
        taxonomyNodeXML=stringToXML(taxonomyRootPost[0].childNodes[0].nodeValue);
        taxonomyRootNode =taxonomyNodeXML.getElementsByTagName("taxon");
    }

    result[0] = taxonomyRootNode[0].getElementsByTagName("id")[0].childNodes[0].nodeValue;
    result[1] = taxonomyRootNode[0].getElementsByTagName("name")[0].childNodes[0].nodeValue;
    return result;
}

function getHiddenCollecNomenclGroupId()
{
    var hiddenData = document.getElementById('contenido:form1:hiddenCollecNomenclGroupId');
    return hiddenData.value;
    //alert(document.getElementById('contenido:form1:hiddenNodeId').value);
}

function getHiddenTypeGroup()
{
    var hiddenData = document.getElementById('contenido:form1:hiddenTypeGroup');
    //alert("tipo de grupo = "+hiddenData.value);
    return hiddenData.value;
    //alert(document.getElementById('contenido:form1:hiddenNodeId').value);
}



function setHiddenTaxonNodeId(idNode)
{
    //alert("entro a Cambiar la variable NodeId");
    var hiddenTaxonNodeId = document.getElementById('contenido:form1:hiddenTaxonNodeId');
    hiddenTaxonNodeId.value = idNode;
    //alert(document.getElementById('contenido:form1:hiddenNodeId').value);
}

function setHiddenPathTaxonNode(path)
{
    var hiddenPathTaxonNode = document.getElementById('contenido:form1:hiddenPathTaxonNode');
    hiddenPathTaxonNode.value = path;

}

function setHiddenTaxonNodeName(path)
{
    var hiddenTaxonNodeName = document.getElementById('contenido:form1:hiddenTaxonNodeName');
    hiddenTaxonNodeName.value = path;

}

function getHiddenTaxonNodeId()
{
    var hiddenTaxonNodeId = document.getElementById('contenido:form1:hiddenTaxonNodeId');
    return hiddenTaxonNodeId.value;
    //alert(document.getElementById('contenido:form1:hiddenNodeId').value);
}

function getHiddenPathTaxonNode(path)
{
    var hiddenPathTaxonNode = document.getElementById('contenido:form1:hiddenPathTaxonNode');
    return hiddenPathTaxonNode.value;

}

function getHiddenTaxonNodeName(path)
{
    var hiddenTaxonNodeName = document.getElementById('contenido:form1:hiddenTaxonNodeName');
    return hiddenTaxonNodeName.value;

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


