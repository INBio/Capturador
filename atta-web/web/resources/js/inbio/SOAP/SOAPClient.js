

function SOAPClient(){}


    SOAPClient.request = function(url, method, parameters)
    {
        var req = SOAPClient.getXMLHttp();
        req.open("GET", url+"?wsdl", false);
        /*req.onreadystatechange = function()
        {
            if (req.readyState == 4) {

                SOAPClient.sendLoadRequest(url, method, parameters, callback, req);
            }
        }*/
        req.send(null);
        var response;
         if (req.readyState == 4) {

             response = SOAPClient.sendLoadRequest(url, method, parameters, req);
         }
         return response;
    }


SOAPClient.sendLoadRequest = function(url, method, parameters, request)
{
    var wsdl = request.responseXML;
    var ns = (wsdl.documentElement.attributes["targetNamespace"] + "" == "undefined") ? wsdl.documentElement.attributes.getNamedItem("targetNamespace").nodeValue : wsdl.documentElement.attributes["targetNamespace"].value;    
    var sr = SOAPClient.createSOAPRequest(ns, method, parameters);
    var xmlHttp = SOAPClient.getXMLHttp();
    xmlHttp.open("POST", url, false);
    var soapaction;
    soapaction = ns + method;
    xmlHttp.setRequestHeader("SOAPAction", soapaction);
    xmlHttp.setRequestHeader("Content-Type", "text/xml; charset=utf-8");
   /* xmlHttp.onreadystatechange = function()
    {
            if(xmlHttp.readyState == 4)
            {
                var xmlResponse =xmlHttp.responseXML;                
                var xmlString = xmlResponse.getElementsByTagName("return")[0].childNodes[0].nodeValue;
                return xmlString;
                callback(xmlString);
            }
    }*/
    xmlHttp.send(sr);
    var xmlString
    if (request.status == 200)
    {
        var xmlResponse =xmlHttp.responseXML;
        //alert("Response del SOAP");
        //alert(xmlResponse);
        //var xmlString = xmlResponse.getElementsByTagName("return")[0].childNodes[0].nodeValue;
        xmlString = xmlResponse.getElementsByTagName("return");
        //alert(xmlString);
        
    }
    return xmlString;

    
}


SOAPClient.createSOAPRequest = function(ns, method, parameters)
{        
        var sr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        sr += "<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">";
        sr += "<S:Header/>";
        sr += "<S:Body>";
        sr += "<ns2:"+method+" xmlns:ns2= \""+ns+"\">";
        sr += SOAPClient.toXml(parameters);
        sr += "</ns2:"+method+">";
        sr += "</S:Body>";
        sr += "</S:Envelope>";
        return sr;
};

SOAPClient.toXml = function(parameters)
{
        var xml = "";
        for(var p in parameters)
                xml += "<" + p + ">" + SOAPClient.serialize(parameters[p]) + "</" + p + ">";
        return xml;
}

SOAPClient.serialize = function(o)
{
    var s = "";
    switch(typeof(o))
    {
        case "string":
            s += o.replace(/&/g, "&amp;").replace(/</g, "&lt;").replace(/>/g, "&gt;"); break;
        case "number":
        case "boolean":
            s += o.toString(); break;       
        default:
            throw new Error(500, "SOAPClientParameters: type '" + typeof(o) + "' is not supported");
    }
    return s;
}



SOAPClient.getXMLHttp =function ()
{
    var xmlHttp;
    if (typeof XMLHttpRequest != "undefined") {
       xmlHttp = new XMLHttpRequest();
   } else if (window.ActiveXObject) {
       xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
   }
   return xmlHttp
}




