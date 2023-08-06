package com.crochier.crochiercustomersupport.site;

import com.crochier.crochiercustomersupport.entities.UserPrincipal;

public interface UserPrincipalRepository extends GenericRepository<Long, UserPrincipal> {

    UserPrincipal getByUsername(String username);
}
