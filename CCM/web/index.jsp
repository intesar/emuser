<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
            "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Textarea Demo</title>
    <style type="text/css">
        @import "dojo/dijit/themes/tundra/tundra.css";
        @import "dojo/dojo/resources/dojo.css"
    </style>
    <script type="text/javascript" src="dojo/dojo/dojo.js" 
        djConfig="parseOnLoad: true"></script>
    <script type="text/javascript">
       dojo.require("dojo.parser");
       dojo.require("dijit.form.Textarea");
    </script>
</head>
<body class="tundra">
        <textarea dojoType="dijit.form.Textarea" style="width:300px">
            Click at the end of this paragraph and start typing.  
            You will be amazed!
        </textarea>
</body>
</html>