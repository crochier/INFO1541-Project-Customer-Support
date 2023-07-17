package com.crochier.crochiercustomersupport;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "sessionListServlet", value = "/sessions")
public class SessionListServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if (request.getSession().getAttribute("username") == null)
        {
            response.sendRedirect("login");
            return;
        }
        request.setAttribute("numSessions", SessionListUtility.getNumberOFSessions());
        request.setAttribute("sessionList", SessionListUtility.getAllSessions());
        request.getRequestDispatcher("WEB-INF/jsp/view/sessions.jsp").forward(request, response);
    }
}
