package com.chatroom.portlet;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import javax.portlet.GenericPortlet;
import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;
import java.io.IOException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;

/**
 * ChatRoom Portlet Class
 */
public class ChatRoom extends GenericPortlet {

    public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException {
    }

    public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        response.setContentType("text/html");
        configureUserId(request);
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/ChatRoom_view.jsp");
        dispatcher.include(request, response);
    }

    public void doEdit(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        response.setContentType("text/html");
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/ChatRoom_edit.jsp");
        dispatcher.include(request, response);
    }

    public void doHelp(RenderRequest request, RenderResponse response) throws PortletException, IOException {

        response.setContentType("text/html");
        PortletRequestDispatcher dispatcher =
                getPortletContext().getRequestDispatcher("/WEB-INF/jsp/ChatRoom_help.jsp");
        dispatcher.include(request, response);
    }

    public void configureUserId(RenderRequest request) {
        try {
            User user = PortalUtil.getUser(request);
            String name = (String) request.getPortletSession().getAttribute("chat_user_name", PortletSession.APPLICATION_SCOPE);
            if (name == null || name.length() < 1) {
                request.getPortletSession().setAttribute("chat_user_name", user.getFullName(), PortletSession.APPLICATION_SCOPE);
            }
            String screenName = (String) request.getPortletSession().getAttribute("chat_user_screen_name", PortletSession.APPLICATION_SCOPE);
            if (screenName == null || screenName.length() < 1) {
                request.getPortletSession().setAttribute("chat_user_screen_name", user.getScreenName(), PortletSession.APPLICATION_SCOPE);
            }
        } catch (PortalException ex) {
            //ex.printStackTrace();
        } catch (SystemException ex) {
            //ex.printStackTrace();
        } catch (RuntimeException re) {
            // re.printStackTrace();
        }
    }
}
