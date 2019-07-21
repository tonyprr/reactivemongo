package com.biellcon.demos.reactive.controller;

import com.biellcon.demos.reactive.model.User;
import com.biellcon.demos.reactive.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/users")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public @ResponseBody
    Mono<User> addUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public @ResponseBody
    Flux<User> getAllUsers() {
        return userRepository.findAll();
    }
}
