package de.pwa.api.controller;

import de.pwa.api.entity.User;
import de.pwa.api.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin("*")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UserServiceImpl userService;

    public UserController(final UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/registration")
    public ResponseEntity<String> signIn(@Valid @RequestBody User user) {

        userService.createAccount(user);

        logger.info("User created: " + user);

        return new ResponseEntity<>("Account wurde erfolgreich angelegt!", HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable long userId) {

        logger.info("Id entered: " + userId);

        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") long id) {

        userService.deleteUserAccountById(id);

        return new ResponseEntity<>("Account wurde erfolgreich gelöscht", HttpStatus.ACCEPTED);
    }
}
