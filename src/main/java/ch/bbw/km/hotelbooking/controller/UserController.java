package ch.bbw.km.hotelbooking.controller;

import ch.bbw.km.hotelbooking.model.User;
import ch.bbw.km.hotelbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public Iterable<User> getAllUsers() {
        return userService.getUsers();
    }

    @PostMapping("/signup")
    public User createUser(@RequestBody User user) {
        System.out.println("user email: " + user.getEmail() + "user password: " + user.getPassword() + "user role: " + user.getRole() + "user firstname: " + user.getFirstname() + "user lastname: " + user.getLastname());
        return userService.createUser(user);
    }
    @GetMapping("/{id}")
    public User getUserById( @PathVariable int id) {
        return userService.getUserById(id);
    }
    @PutMapping("/{id}")
    public User updateUser( @PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user) {
        return userService.loginUser(user);
    }
}
