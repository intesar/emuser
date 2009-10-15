/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatroom.service;


import javax.servlet.http.HttpSession;
import org.directwebremoting.Browser;
import org.directwebremoting.ScriptSessions;

/**
 *
 * @author inmohamm
 */
public class ChatService {

    public ChatService() {
        System.out.println(" ChatService instantiated...");
    }

    public static void add(final String message, HttpSession session) {
//        WebContext webContext = WebContextFactory.get();
//        String currentPage = webContext.getCurrentPage();
//        Collection sessions = webContext.getScriptSessionsByPage(currentPage);
//        Util utilAll = new Util(sessions);
        String screenName = (String) session.getAttribute("chat_user_screen_name");
        if (screenName == null) {
            screenName = "annonymouse";
        }
        final String name = screenName;
        Browser.withCurrentPage(new Runnable() {
            public void run() {
                ScriptSessions.addFunctionCall("broadcastMessage", name + ": " + message);
            }
        });
//        utilAll.addFunctionCall("broadcastMessage", screenName + ": " + message);
    }
}
