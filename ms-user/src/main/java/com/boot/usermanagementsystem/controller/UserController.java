package com.boot.usermanagementsystem.controller;


import com.boot.usermanagementsystem.model.dto.UserDto;
import com.boot.usermanagementsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j

public class UserController {

    private final UserService userService;


    @PostMapping
    public UserDto addUser(@RequestBody UserDto user) {
        log.info("add user");
        return userService.save(user);
    }

    @GetMapping("/all")
    public List<UserDto> getUsers() {
        log.info("get users");
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        log.info("get user by id");
        Optional<UserDto> byId = userService.getById(id);
        return byId.orElse(null);
    }

    @DeleteMapping("/all")
    public void deleteAllUsers() {
        log.info("delete all users");
        userService.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        log.info("delete user by id");
        userService.deleteById(id);
    }

    @PutMapping("/{id}")
    public UserDto updateUserById(@PathVariable Long id, @RequestBody UserDto user) {
        log.info("update user by id");
        return userService.update(id, user);
    }

    @PutMapping("/image/{id}")
    public UserDto updateImageById(@PathVariable Long id, @RequestBody UserDto user) {
        log.info("update image by id");
        return userService.updateImage(id, user);
    }

    @GetMapping("/countUsers")
    public long getUserCount() {
        log.info("get user count");
        return userService.countUsers();
    }
}
