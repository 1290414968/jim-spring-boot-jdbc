package controller;

import domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import repository.UserRepository;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 用户 RestController on WebMVC
 **/
@RestController
public class UserController {

    private final UserRepository userRepository;

    private final ExecutorService executorService = Executors.newFixedThreadPool(5);


    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/web/mvc/user/save")
    public Boolean save(@RequestBody User user) {
        return userRepository.save(user);
    }

}
