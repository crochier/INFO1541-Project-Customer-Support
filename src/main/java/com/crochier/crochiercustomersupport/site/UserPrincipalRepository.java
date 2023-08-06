package com.crochier.crochiercustomersupport.site;

import com.crochier.crochiercustomersupport.entities.UserPrincipal;

public interface UserPrincipalRepository extends GenericRepository<Long, UserPrincipal>
{
    UserPrincipal getByUsername(String username);

//    void add(UserPrincipal principal);
//
//    void update(UserPrincipal principal);
}
