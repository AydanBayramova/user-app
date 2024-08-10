package com.boot.usermanagementsystem.model.mapper;


import com.boot.usermanagementsystem.domain.entity.UserEntity;
import com.boot.usermanagementsystem.model.dto.UserDto;
import org.mapstruct.Mapper;

import java.util.List;



@Mapper(componentModel = "spring")
public interface UserMapper {
     UserDto toUserDto(UserEntity user);

     UserEntity toUserEntity(UserDto userDto);

     List<UserDto> toUserDto(List<UserEntity> users);
}
