package com.crochier.crochiercustomersupport.site;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(value ={"/", "/tickets/*", "/sessions"})
public class LoginFilter implements Filter
{
    @Override
    public void init (FilterConfig filterConfig) throws ServletException
    {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession(false);
        if (session == null || session.getAttribute("username") == null)
        {
            ((HttpServletResponse)servletResponse).sendRedirect(((HttpServletRequest)servletRequest).getContextPath() + "/login");
        }
        else
        {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy()
    {

    }
}