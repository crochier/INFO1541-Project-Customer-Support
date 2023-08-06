package com.crochier.crochiercustomersupport.site;

import com.crochier.crochiercustomersupport.entities.UserPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultUserRepository extends GenericJpaRepository<Long, UserPrincipal> implements UserPrincipalRepository
{
    @Override
    public UserPrincipal getByUsername(String username)
    {
        return this.entityManager.createQuery("SELECT u FROM UserPrincipal u WHERE u.userName = : username",
                UserPrincipal.class).setParameter("username", username).getSingleResult();
    }
}
