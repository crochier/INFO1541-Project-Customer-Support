package com.crochier.crochiercustomersupport.entities;

import jakarta.persistence.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.userdetails.User;

import java.io.Serializable;
import java.security.Principal;

@Entity
@Table(name = "UserPrincipal")
public class UserPrincipal implements Principal, Serializable
{
    private static final long serialVersionUID = 1L;
    private static final String SESSION_ATTRIBUTE_KEY = "com.crochier.crochiercustomersupport.userprincipal.principal";
    private long id;
    private String userName;
    private String name;
    private byte[] password;

    public static Principal getPrincipal(HttpSession session)
    {
        return session == null ? null : (Principal) session.getAttribute(SESSION_ATTRIBUTE_KEY);
    }

    public static void setPrincipal(HttpSession session, Principal principal) {
    }

    @Id
    @Column(name = "userId")
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @Basic
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Basic
    @Column(name = "hasheduserpassword")
    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof UserPrincipal)
        {
            UserPrincipal user = (UserPrincipal) obj;
            return user.getUserName().equals(userName);
        }
        else
        {
            return false;
        }
    }

    @Override
    public String toString()
    {
        return userName;
    }
}
