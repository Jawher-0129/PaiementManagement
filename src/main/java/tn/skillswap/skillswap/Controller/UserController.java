package tn.skillswap.skillswap.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.skillswap.skillswap.Entity.User;
import tn.skillswap.skillswap.Service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }
}
