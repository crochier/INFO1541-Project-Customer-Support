package com.crochier.crochiercustomersupport.site;

import com.crochier.crochiercustomersupport.entities.UserPrincipal;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

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
        final Principal principal = UserPrincipal.getPrincipal(session);
        if (principal == null)
        {
            ((HttpServletResponse)servletResponse).sendRedirect(((HttpServletRequest)servletRequest).getContextPath() + "/login");
        }
        else
        {
            filterChain.doFilter(new HttpServletRequestWrapper((HttpServletRequest) servletRequest)
            {
                @Override
                public Principal getUserPrincipal()
                {
                    return principal;
                }
            }, servletResponse);
        }

    }

    @Override
    public void destroy()
    {

    }
}