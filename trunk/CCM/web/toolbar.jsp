<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
    <style type="text/css">
        @import "dojo/dijit/themes/tundra/tundra.css";
        @import "dojo/dojo/resources/dojo.css"
    </style>
    <script type="text/javascript" src="dojo/dojo/dojo.js" 
        djConfig="parseOnLoad: true"></script>
    <script type="text/javascript">
       dojo.require("dojo.parser");
       dojo.require("dijit.form.Button");
       dojo.require("dijit.Toolbar");
       function bold() { 
           //console.debug("Bold!"); 
        window.location = "http://localhost:8084/CCM/index.jsp";
   }
       function cut() { console.debug("Cut!"); 
       window.location = "http://localhost:8084/CCM/index.jsp";}
       function copy() { console.debug("Copy!"); }
       function paste() { console.debug("Paste!"); }
       dojo.addOnLoad(function() {
           dojo.connect(dojo.byId("toolbar1.bold"),"onclick",bold);
           dojo.connect(dojo.byId("toolbar1.cut"),"onclick",cut);
           dojo.connect(dojo.byId("toolbar1.copy"),"onclick",copy);
           dojo.connect(dojo.byId("toolbar1.paste"),"onclick",paste);
       });
     </script>
</head>
<body class="tundra">
    <!-- Tags end on line afterwards to eliminate any whitespace -->
    <div id="toolbar1" dojoType="dijit.Toolbar"
        ><div dojoType="dijit.form.Button" id="toolbar1.cut" title="Cut" iconClass="dijitEditorIcon"   
            showLabel="true">Cut</div
        ><div dojoType="dijit.form.Button" id="toolbar1.copy" iconClass="dijitEditorIcon" 
            showLabel="false">Copy</div
        ><div dojoType="dijit.form.Button" id="toolbar1.paste" iconClass="dijitEditorIcon" 
            showLabel="false">Paste</div
        ><!-- The following adds a line between toolbar sections
            --><span dojoType="dijit.ToolbarSeparator"></span
         ><div dojoType="dijit.form.ToggleButton" id="toolbar1.bold" 
            iconClass="dijitEditorIcon" showLabel="false">Bold</div>
   </div>
</body></html>
