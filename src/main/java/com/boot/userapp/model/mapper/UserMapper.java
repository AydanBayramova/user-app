package com.boot.userapp.model.mapper;

import com.boot.userapp.model.dto.UserDto;
import com.boot.userapp.domain.entity.UserEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserDto toUserDto(UserEntity user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setAge(user.getAge());
        userDto.setImage(user.getImage());
        return userDto;
    }

    public static UserEntity toUserEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDto.getId());
        userEntity.setUsername(userDto.getUsername());
        userEntity.setAge(userDto.getAge());
        userEntity.setImage(userDto.getImage());
        userEntity.setCreateDate(LocalDate.now());
        userEntity.setUpdateDate(LocalDate.now());
        return userEntity;
    }

    public static List<UserDto> toUserDto(List<UserEntity> users) {
        return users.stream().
                map(UserMapper::toUserDto)
                .collect(Collectors.toList());

    }
}
