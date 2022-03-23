package de.pwa.api.service;

import de.pwa.api.entity.User;
import de.pwa.api.repository.UserRepository;
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
    public void createAccount(User user) {

        userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(long id) {

        return userRepository.findById(id);
    }

    @Override
    public void deleteUserAccountById(final long id) {
        userRepository.deleteById(id);
    }


}
