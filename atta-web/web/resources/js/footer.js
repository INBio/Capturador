var ns = (navigator.appName.indexOf("Netscape") != -1);
var d = document;
var px = document.layers ? "" : "px";
function JSFX_FloatDiv(id, sx, sy)
{
	var el=d.getElementById?d.getElementById(id):d.all?d.all[id]:d.layers[id];
	window[id + "_obj"] = el;
	if(d.layers)el.style=el;
	el.cx = el.sx = sx;el.cy = el.sy = sy;
	el.sP=function(x,y){this.style.left=x+px;this.style.top=y+px;};
	el.flt=function()
	{
		var pX, pY;
		pY = ns ? pageYOffset : document.documentElement && document.documentElement.scrollTop ?
		document.documentElement.scrollTop : document.body.scrollTop;
		if(this.sy<0)
		pY += ns ? innerHeight : document.documentElement && document.documentElement.clientHeight ?
		document.documentElement.clientHeight : document.body.clientHeight;
		this.cy += (pY + this.sy - this.cy)/2;
		this.sP(this.cx, this.cy);
		setTimeout(this.id + "_obj.flt()", 1);
	}
	return el;
}

sfHover = function() {
    var sfEls = document.getElementById("navbar").getElementsByTagName("li");
    for (var i=0; i<sfEls.length; i++) {
        sfEls[i].onmouseover=function() {
            this.className+=" hover";
        }
        sfEls[i].onmouseout=function() {
            this.className=this.className.replace(new RegExp(" hover\\b"), "");
        }
    }
}
