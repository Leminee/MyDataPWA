package de.pwa.api.controller;

import de.pwa.api.entity.User;
import de.pwa.api.service.UserServiceImpl;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user/")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("registration")
    public User create(@Valid @RequestBody User user) throws ResourceNotFoundException {
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public User getUserBy(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) throws ResourceNotFoundException {

        final User user = getUserBy(id);
        userService.delete(user);
    }

}
