package de.pwa.api.service;

import de.pwa.api.entity.User;
import org.elasticsearch.ResourceNotFoundException;

import java.util.List;

public interface IUserService {

    List<User> getAllUsers();
    User save(User User);
    User getUserById(long id) throws ResourceNotFoundException;
    void delete(User user);
}
