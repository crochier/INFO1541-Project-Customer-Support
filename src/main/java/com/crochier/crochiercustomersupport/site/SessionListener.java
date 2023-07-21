package com.crochier.crochiercustomersupport.site;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionIdListener;
import jakarta.servlet.http.HttpSessionListener;
@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionIdListener {
    @Override
    public void sessionIdChanged(HttpSessionEvent se, String oldID)
    {
        System.out.println(oldID + " ID Updated to " + se.getSession().getId());
        SessionListUtility.updateSessionID(se.getSession(), oldID);
    }

    @Override
    public void sessionCreated(HttpSessionEvent se)
    {
        System.out.println(se.getSession().getId() + " Created");
        SessionListUtility.addSession(se.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se)
    {
        System.out.println(se.getSession().getId() + " Removed");
        SessionListUtility.removeSession(se.getSession());
    }
}
