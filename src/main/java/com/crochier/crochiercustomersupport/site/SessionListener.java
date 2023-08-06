package com.crochier.crochiercustomersupport.site;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionIdListener;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionIdListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println(se.getSession().getId() + " created");
        SessionListUtility.addSession(se.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println(se.getSession().getId() + " removed");
        SessionListUtility.removeSession(se.getSession());
    }

    @Override
    public void sessionIdChanged(HttpSessionEvent se, String oldId) {
        System.out.println(oldId + " ID updated to " + se.getSession().getId() );
        SessionListUtility.updateSessionId(se.getSession(), oldId);
    }
}
