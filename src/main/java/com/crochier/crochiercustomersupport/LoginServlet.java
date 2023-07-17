package com.crochier.crochiercustomersupport;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

@WebServlet (name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet
{
    public static final Map<String, String> userDB = new Hashtable<>();
    static
    {
        userDB.put("christian", "admin123");
        userDB.put("john", "password123");
        userDB.put("suzie", "green123");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        if (request.getParameter("logout")  != null)
        {
            session.invalidate();
            response.sendRedirect("login");
            return;
        } else if (session.getAttribute("username") != null)
        {
            response.sendRedirect("tickets");
            return;
        }
        request.setAttribute("loginFailed", false);
        request.getRequestDispatcher("WEB-INF/jsp/view/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        if (session.getAttribute("username") != null)
        {
            response.sendRedirect("tickets");
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username == null || password == null || !LoginServlet.userDB.containsKey(username)
                || !password.equals(LoginServlet.userDB.get(username)))
        {
            request.setAttribute("loginFailed", true);
            request.getRequestDispatcher("WEB-INF/jsp/view/login.jsp").forward(request, response);
        }
        else
        {
            session.setAttribute("username", username);
            request.changeSessionId();
            response.sendRedirect("tickets");
        }
    }
}