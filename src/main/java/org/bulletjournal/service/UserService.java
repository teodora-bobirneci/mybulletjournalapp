package org.bulletjournal.service;

import org.bulletjournal.model.ApplicationUser;

/**
 * @author Teodora Bobirneci
 */
public interface UserService {

    ApplicationUser createUser(ApplicationUser applicationUser);

    void updatePassword(ApplicationUser user, String newPassword);

    ApplicationUser getUserByUsername(String username);

}
