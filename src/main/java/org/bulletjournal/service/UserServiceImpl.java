package org.bulletjournal.service;

import org.bulletjournal.dao.UserRepository;
import org.bulletjournal.model.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;

import static org.bulletjournal.PasswordEncrypter.encrypt;
import static org.bulletjournal.PasswordEncrypter.generateRandomSalt;

/**
 * @author Teodora Bobirneci
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {this.userRepository = userRepository;}

    @Override
    @Transactional
    public ApplicationUser createUser(ApplicationUser applicationUser) {
        ApplicationUser existing = userRepository.findByUsername(applicationUser.getUsername());
        if (existing != null) {
            throw new ValidationException("Username already taken!");
        }
        applicationUser.setSalt(generateRandomSalt());
        applicationUser.setEncryptedPassword(encrypt(applicationUser.getSalt(), applicationUser.getPassword()));
        return userRepository.saveUser(applicationUser);
    }

    @Override
    @Transactional
    public void updatePassword(ApplicationUser user, String newPassword) {
        throw new IllegalStateException("Not yet implemented!");
    }

    @Override
    public ApplicationUser getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


}
