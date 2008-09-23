<html>
    <head>
        
        <!-- UTF-8 is the recommended encoding for your pages -->
        <meta http-equiv="content-type" content="text/xml; charset=utf-8" />
        <title></title>
        
        <!-- Loading Theme file(s) -->
        <link rel="stylesheet" href="http://www.zapatec.com/website/main/../ajax/zpcal/themes/aqua.css" />
        <link rel="stylesheet" href="http://www.zapatec.com/website/main/../ajax/zpcal/themes/layouts/small.css" />
        
        <!-- Loading Calendar JavaScript files -->
        <script type="text/javascript" src="http://www.zapatec.com/website/main/../ajax/zpcal/../utils/zapatec.js"></script>
        <script type="text/javascript" src="http://www.zapatec.com/website/main/../ajax/zpcal/src/calendar.js"></script>
        <!-- Loading language definition file -->
        <script type="text/javascript" src="http://www.zapatec.com/website/main/../ajax/zpcal/lang/calendar-en.js"></script>
        
    </head>
    <body>
        
        <input type="text" id="calendar" name="calendar" />
        <button id="trigger">...</button>
        <script type="text/javascript">//<![CDATA[
            Zapatec.Calendar.setup({
                firstDay          : 1,
                weekNumbers       : false,
                range             : [2008.01, 2009.12],
                electric          : false,
                inputField        : "calendar",
                button            : "trigger",
                ifFormat          : "%Y/%m/%d",
                daFormat          : "%Y/%m/%d"
            });
            //]]></script>
        <noscript>
            <br/>
            This page uses a <a href="http://www.zapatec.com/website/main/products/prod1/"> Javascript Calendar </a>, but
            your browser does not support Javascript. 
            <br/>
            Either enable Javascript in your Browser or upgrade to a newer version.
        </noscript>
        
        
    </body>
</html>
