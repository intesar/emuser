<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%-- Uncomment below lines to add portlet taglibs to jsp --%>
<%@ page import="javax.portlet.*"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />
<%PortletPreferences prefs = renderRequest.getPreferences();%> 


<script type='text/javascript' src='<%= renderResponse.encodeURL(renderRequest.getContextPath() + "/dwr/engine.js")%>'></script>
<script type='text/javascript' src='<%= renderResponse.encodeURL(renderRequest.getContextPath() + "/dwr/util.js")%>'></script>
<script type='text/javascript' src='<%= renderResponse.encodeURL(renderRequest.getContextPath() + "/dwr/interface/ChatService.js")%>'></script>

<script type="text/javascript">

    // edit this to match dom elements
    // call this to send chat message

    function sendMessage() {
        var msg = document.getElementById('chat_message').value;
        document.getElementById('chat_message').value='';
        ChatService.add(msg);
    }

    // edit this to match dom elements
    function broadcastMessage  (message) {
        document.getElementById('chat_messages').value=document.getElementById('chat_messages').value + "\n" + message;
    }    

</script>

</head>

<body onload="dwr.engine.setActiveReverseAjax(true);">
    <textarea id="chat_messages" cols="50" rows="3" ></textarea>
    <br/>
    <input type="text" id="chat_message" onkeydown="if (event.keyCode == 13) sendMessage();">
</body>

</html>
