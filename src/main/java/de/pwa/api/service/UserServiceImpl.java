package de.pwa.api.service;

import de.pwa.api.entity.User;
import de.pwa.api.repository.UserRepository;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public User save(User user) {

        return this.userRepository.save(user);
    }

    @Override
    public User getUserById(long id) throws ResourceNotFoundException {
        Optional<User> optional = userRepository.findById(id);
        User user;
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new ResourceNotFoundException("User not found on :: " + id);
        }
        return user;
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }


}
