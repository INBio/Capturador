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
   
}
