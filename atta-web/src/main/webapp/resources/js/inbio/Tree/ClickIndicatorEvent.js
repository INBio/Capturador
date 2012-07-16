

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
   
}

