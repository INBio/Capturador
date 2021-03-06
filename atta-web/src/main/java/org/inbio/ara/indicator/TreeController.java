/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.indicator;

/**
 *
 * @author gsulca
 */
public class TreeController {


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


        scriptString += "function initIndicators(){\n";

        //scriptString += "alert('entro a crear el arbol');\n";
        
        scriptString += "var expand = false;\n";
        scriptString += "nodeId = getHiddenNodeId();\n";
        scriptString += "var tmpPathNode = getHiddenPathNode();\n";
        scriptString += "pathNode = tmpPathNode.split(\",\");\n";
                //Creating the tree
        scriptString += "tree = new YAHOO.widget.TreeView('tree');\n";
                //Turn dynamic loading on for entire tree
        scriptString += "tree.setDynamicLoad(loadNodeData, currentIconMode);\n";
                //Getting a reference to the root element
        scriptString += "rootNode = tree.getRoot();\n";
        scriptString += "var rootInformation = getNode(idRoot);\n";        
        scriptString += "if(nodeId != 0)\n";
        scriptString += "{\n";
        scriptString += "expand = true;\n";        
        scriptString += "}\n";
                //Add the root element
        scriptString += "var tempNode = new YAHOO.widget.TextNode(rootInformation[1], rootNode, expand);\n";
        scriptString += "tempNode.data = idRoot;\n";   
        scriptString += "tree.subscribe('clickEvent',onClickEvent);\n";        
        scriptString += "tree.render();\n";
        scriptString += "}\n\n";

        scriptString += "</script>\n";
        return scriptString;
    }
}
