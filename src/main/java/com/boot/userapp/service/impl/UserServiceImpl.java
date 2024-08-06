package com.boot.userapp.service.impl;

import com.boot.userapp.domain.entity.UserEntity;
import com.boot.userapp.domain.repository.UserRepository;
import com.boot.userapp.exception.ResourceNotFoundException;
import com.boot.userapp.model.dto.UserDto;
import com.boot.userapp.model.mapper.UserMapper;
import com.boot.userapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto save(UserDto userDto) {
        return userMapper.toUserDto(userRepository.save(userMapper.toUserEntity(userDto)));
    }

    @Override
    public List<UserDto> getAll() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userMapper.toUserDto(userEntities);
    }

    @Override
    public Optional<UserDto> getById(Long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        return userEntity.map(userMapper::toUserDto);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isPresent()) {
            userRepository.deleteById(id);
        } else {
            System.out.println("id not found");
        }
    }

    @Override
    public UserDto update(Long id, UserDto userDto) {
        Optional<UserEntity> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            return userMapper.toUserDto(userRepository.save(userMapper.toUserEntity(userDto)));
        } else {
            throw new ResourceNotFoundException("User with id " + id + " not found");
        }
    }

    @Override
    public UserDto updateImage(Long id, UserDto userDto) {
        Optional<UserEntity> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            return userMapper.toUserDto(userRepository.save(userMapper.toUserEntity(userDto)));
        } else {
            throw new ResourceNotFoundException("User with id " + id + " not found");
        }
    }

    @Override
    public long countUsers() {
        return userRepository.count();
    }
}
