package me.dio.controller;

import me.dio.model.User;
import me.dio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get-user-by-id")
    public ResponseEntity<User> getUserById(@RequestParam(name = "userId") Long userId) {
        return ResponseEntity.ok(userService.findById(userId));
    }

    @PostMapping("/create-user")
    public ResponseEntity<User> createUser(@RequestBody User userToCreate) {
        User userCreated = userService.createUser(userToCreate);
        URI locationUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();
        return ResponseEntity.created(locationUri).body(userCreated);
    }

}
