package ch.bbw.km.hotelbooking.service;

import ch.bbw.km.hotelbooking.model.User;
import ch.bbw.km.hotelbooking.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired private UserRepository userRepository;

    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
    }

    public User getUserByUserName(String email) {
        return userRepository.getUserByEmail(email);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public User updateUser(int id, User user) {
        User userToUpdate = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
        userToUpdate.setFirstname(user.getFirstname());
        userToUpdate.setLastname(user.getLastname());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setRole(user.getRole());
        return userRepository.save(userToUpdate);
    }
    public void deleteUser(int id) {
        User userToDelete = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
        userRepository.delete(userToDelete);
    }


    public User loginUser(User user) {
        User userToLogin = userRepository.getUserByEmail(user.getEmail());
        if (userToLogin.getPassword().equals(user.getPassword())) {
            return userToLogin;
        } else {
            throw new RuntimeException("Wrong password");
        }
    }
}
