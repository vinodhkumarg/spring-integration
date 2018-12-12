package com.test.service;



import com.test.model.User;
import com.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     *
     * @param user
     * @return
     */
    @RequestMapping("/save")
    User createUser(User user) {
        userRepository.save(user);
        return user;
    }

    @RequestMapping("/user")
    User getUser(int id) {
        return userRepository.findOne(id);
    }

    @RequestMapping("/users")
    Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
