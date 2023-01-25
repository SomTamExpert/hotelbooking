package ch.bbw.km.hotelbooking.controller;

import ch.bbw.km.hotelbooking.model.User;
import ch.bbw.km.hotelbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Class UserController
 * @author Marco Karpf
 * @version 25.01.2023
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * get all users
     * @return Iterable<User>
     */
    @GetMapping
    public Iterable<User> getAllUsers() {
        return userService.getUsers();
    }

    /**
     * create user
     * @param user
     * @return user
     */
    @PostMapping("/signup")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    /**
     * get user by id
     * @param id
     * @return user
     */
    @GetMapping("/{id}")
    public User getUserById( @PathVariable int id) {
        return userService.getUserById(id);
    }

    /**
     * update user
     * @param id
     * @param user
     * @return user
     */
    @PutMapping("/{id}")
    public User updateUser( @PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    /**
     * delete user
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable int id) {
        userService.deleteUser(id);
    }

    /**
     * login user
     * @param user
     * @return user
     */
    @PostMapping("/login")
    public User loginUser(@RequestBody User user) {
        return userService.loginUser(user);
    }

    /**
     * get user by lastname
     * @param lastname
     * @return Iterable<User>
     */
    @GetMapping("/search/{lastname}")
    public Iterable<User> getUsersByLastname(@PathVariable String lastname) {
        return userService.getUsersByLastname(lastname);
    }
}
