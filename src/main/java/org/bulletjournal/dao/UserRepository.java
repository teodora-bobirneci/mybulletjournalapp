package org.bulletjournal.dao;

import org.bulletjournal.model.ApplicationUser;

/**
 * @author Teodora Bobirneci
 */
public interface UserRepository {

     ApplicationUser findByUsername(String username);

    ApplicationUser saveUser(ApplicationUser applicationUser);

}
