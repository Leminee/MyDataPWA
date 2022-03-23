package de.pwa.api.service;

import de.pwa.api.entity.User;
import java.util.List;
import java.util.Optional;


public interface IUserService {

    List<User> getAllUsers();
    void createAccount(final User User);
    Optional<User> getUserById(final long id);
    void deleteUserAccountById(final long id);
}
