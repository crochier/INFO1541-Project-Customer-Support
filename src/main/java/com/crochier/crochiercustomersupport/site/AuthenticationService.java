package com.crochier.crochiercustomersupport.site;

import com.crochier.crochiercustomersupport.entities.UserPrincipal;

public interface AuthenticationService {
    UserPrincipal authenticate(String username, String password);

    void saveUser(UserPrincipal principal, String newPassword);
}
