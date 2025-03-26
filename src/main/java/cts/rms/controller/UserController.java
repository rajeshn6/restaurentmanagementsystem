package cts.rms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cts.rms.dto.Users;
import cts.rms.service.UserService;

@RestController
@RequestMapping("/user-api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable int id) {
        Optional<Users> user = userService.getUserById(id);
        return user.get();
    }
    @GetMapping("/email/{email}")
    public Users getMethodName(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }
    @PostMapping
    public Users createUser(@RequestBody Users user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
