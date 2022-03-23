package de.pwa.api.service;

import de.pwa.api.entity.User;
import java.util.List;


public interface IUserService {

    List<User> getAllUsers();
    User save(final User User);
    User getUserById(final long id);
    void delete(final User user);
}
