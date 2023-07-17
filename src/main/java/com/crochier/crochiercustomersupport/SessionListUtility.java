package com.crochier.crochiercustomersupport;

import jakarta.servlet.http.HttpSession;
import org.jboss.weld.context.http.Http;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class SessionListUtility
{
    private static final Map<String, HttpSession> SESSIONS = new Hashtable<>();
    public static void addSession (HttpSession session)
    {
        SESSIONS.put(session.getId(), session);
    }
    public static void updateSessionID (HttpSession session, String oldSessionID)
    {
        synchronized (SESSIONS)
        {
            SESSIONS.remove(oldSessionID);
            addSession(session);
        }
    }
    public static void removeSession (HttpSession session)
    {
        SESSIONS.remove(session.getId());
    }
    public static List<HttpSession> getAllSessions()
    {
        return new ArrayList<>(SESSIONS.values());
    }
    public static int getNumberOFSessions()
    {
        return SESSIONS.size();
    }
}
