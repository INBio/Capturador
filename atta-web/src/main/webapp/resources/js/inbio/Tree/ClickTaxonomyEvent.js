function onClickEvent(oArgs) {
    selectedNodeId = oArgs.node.data;
    selectedNodeName = oArgs.node.label;
    setHiddenTaxonNodeId(selectedNodeId);
    setHiddenPathTaxonNode(getPathNode(oArgs.node));
    setHiddenTaxonNodeName(selectedNodeName);
    //alert(selectedNodeId);
    //alert(getPathNode(oArgs.node));
    //alert(selectedNodeName);
    if(oArgs.node.isLeaf){
        isLeaf = 'true';
    }
    else{
        isLeaf = 'false';
    }
   
}
