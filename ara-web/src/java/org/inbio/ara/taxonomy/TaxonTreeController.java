/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.taxonomy;

/**
 *
 * @author gsulca
 */
public class TaxonTreeController {

     public String getTreeScript()
    {
        String scriptString = "";
        scriptString += "<script defer='defer' type='text/javascript'>\n";
        scriptString += "var currentIconMode;\n";
        scriptString += "var tree;\n";
        scriptString += "var rootNode;\n";
        scriptString += "var selectedNodeId;\n";
        scriptString += "var selectedNodeName;\n";
        scriptString += "var isLeaf;\n";
        scriptString += "var idRoot = 0;\n";
        scriptString += "var nodeId = 0;\n";
        scriptString += "var pathNode = [];\n";
        scriptString += "var hiddenCollecNomenclGroupId = 0;\n";
        scriptString += "var hiddenTypeGroup = 0;\n";


        scriptString += "function initTaxonomy(){\n";
        scriptString += "var expand = false;\n";
                //Se sacan los valores de las variables hidden
        scriptString += "nodeId = getHiddenTaxonNodeId();\n";
        scriptString += "var tmpPathNode = getHiddenPathTaxonNode();\n";
        scriptString += "pathNode = tmpPathNode.split(\",\");\n";
        scriptString += "hiddenCollecNomenclGroupId = getHiddenCollecNomenclGroupId();\n";
        scriptString += "hiddenTypeGroup = getHiddenTypeGroup();\n";

        //BORRAR ALERT
        //scriptString += "alert('nodeId = '+nodeId+ ' tmpPathNode = '+ tmpPathNode + ' hiddenCollecNomenGroup = '+hiddenCollecNomenclGroupId + ' hiddenTypeGroup '+hiddenTypeGroup );\n";

                //Creating the tree
        scriptString += "tree = new YAHOO.widget.TreeView('tree');\n";
                //Turn dynamic loading on for entire tree
        scriptString += "tree.setDynamicLoad(loadNodeData, currentIconMode);\n";
                //Getting a reference to the root element
        scriptString += "rootNode = tree.getRoot();\n";
        scriptString += "var rootInformation = getNodeRoot(hiddenTypeGroup, hiddenCollecNomenclGroupId);\n";
                //Set nodeId value 
        scriptString += "if(nodeId == -1)\n";
        scriptString += "{\n";

        //scriptString += "alert('nodeId == -1');\n";

        scriptString += "nodeId = rootInformation[1];\n";
        scriptString += "}\n";
                //If is different to root expand
        scriptString += "if(nodeId != rootInformation[1])\n";
        scriptString += "{\n";

        scriptString += "alert('nodeId != root, se debe expandir');\n";

        scriptString += "expand = true;\n";
        scriptString += "}\n";
                //Add the root element
        scriptString += "var tempNode = new YAHOO.widget.TextNode(rootInformation[1], rootNode, expand);\n";
        scriptString += "tempNode.data = rootInformation[0];\n";
        scriptString += "tree.subscribe('clickEvent',onClickEvent);\n";
        scriptString += "tree.render();\n";
        scriptString += "}\n\n";

        scriptString += "</script>\n";
        return scriptString;
    }
}
