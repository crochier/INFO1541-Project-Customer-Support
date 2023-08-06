package com.crochier.crochiercustomersupport.site;

import com.crochier.crochiercustomersupport.entities.UserPrincipal;
import org.springframework.security.core.userdetails.User;

public interface AuthenticationService
{
    UserPrincipal authenticate(String username, String password);
    void saveUser(UserPrincipal principal, String newpassword);
}
