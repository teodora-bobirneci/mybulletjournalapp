package org.bulletjournal.service;

import org.bulletjournal.model.ApplicationUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

/**
 * @author Teodora Bobirneci
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void addAdminUser() {
        ApplicationUser admin = new ApplicationUser("teodora", "nimda", "admin@admin.com");
        userService.createUser(admin);

        ApplicationUser databaseUser = userService.getUserByUsername("nimda");
        assertNotNull(databaseUser);
        assertNotNull(databaseUser.getEncryptedPassword());
        assertNotNull(databaseUser.getSalt());
    }
}
