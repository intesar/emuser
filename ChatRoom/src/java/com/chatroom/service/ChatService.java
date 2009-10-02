/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatroom.service;

import java.util.Collection;

import javax.servlet.http.HttpSession;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.proxy.dwr.Util;

/**
 *
 * @author inmohamm
 */
public class ChatService {

    public ChatService() {
        System.out.println(" ChatService instantiated...");
    }

    public static void add(String message, HttpSession session) {
        WebContext webContext = WebContextFactory.get();
        String currentPage = webContext.getCurrentPage();
        Collection sessions = webContext.getScriptSessionsByPage(currentPage);
        Util utilAll = new Util(sessions);
        String screenName = (String) session.getAttribute("chat_user_screen_name");
        if (screenName == null) {
            screenName = "annonymouse";
        }
        utilAll.addFunctionCall("broadcastMessage", screenName + ": " + message);
    }
}
