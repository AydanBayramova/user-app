package com.boot.userapp.service;

import com.boot.userapp.model.dto.UserDto;


import java.util.List;
import java.util.Optional;


public interface UserService {

    UserDto save(UserDto userDto);

    List<UserDto> getAll();

    Optional<UserDto> getById(Long id);

    void deleteAll();

    void deleteById(Long id);

    UserDto update(Long id, UserDto userDto);

    UserDto updateImage(Long id, UserDto userDto);

    long countUsers();
}
