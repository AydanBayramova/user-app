package com.boot.userapp.service.impl;

import com.boot.userapp.domain.entity.UserEntity;
import com.boot.userapp.domain.repository.UserRepository;
import com.boot.userapp.exception.ResourceNotFoundException;
import com.boot.userapp.model.dto.UserDto;
import com.boot.userapp.model.mapper.UserMapper;
import com.boot.userapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDto save(UserDto userDto) {
        UserEntity userEntity = UserMapper.toUserEntity(userDto);
        userEntity.setUsername(userDto.getUsername());
        userEntity.setId(userDto.getId());
        userEntity.setAge(userDto.getAge());
        userEntity.setImage(userDto.getImage());

        return UserMapper.toUserDto(userRepository.save(userEntity));
    }

    @Override
    public List<UserDto> getAll() {
        List<UserEntity> userEntities = userRepository.findAll();
        return UserMapper.toUserDto(userEntities);
    }

    @Override
    public Optional<UserDto> getById(Long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isPresent()) {
            return Optional.of(UserMapper.toUserDto(userEntity.get()));
        } else {
            return Optional.empty();
        }
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
            UserEntity userEntity = existingUser.get();
            userEntity.setUsername(userDto.getUsername());
            userEntity.setAge(userDto.getAge());
            userEntity.setImage(userDto.getImage());
            userEntity.setUpdateDate(LocalDate.now());
            return UserMapper.toUserDto(userRepository.save(userEntity));
        } else {
            throw new ResourceNotFoundException("User with id " + id + " not found");
        }
    }

    @Override
    public UserDto updateImage(Long id, UserDto userDto) {
        Optional<UserEntity> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            UserEntity userEntity = existingUser.get();
            userEntity.setImage(userDto.getImage());
            userEntity.setUpdateDate(LocalDate.now());
            return UserMapper.toUserDto(userRepository.save(userEntity));
        } else {
            throw new ResourceNotFoundException("User with id " + id + " not found");
        }
    }

    @Override
    public long countUsers() {
        return userRepository.count();
    }
}
