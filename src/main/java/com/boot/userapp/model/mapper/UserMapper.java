package com.boot.userapp.model.mapper;

import com.boot.userapp.model.dto.UserDto;
import com.boot.userapp.domain.entity.UserEntity;
import org.mapstruct.Mapper;
import java.util.List;



@Mapper(componentModel = "spring")
public interface UserMapper {
     UserDto toUserDto(UserEntity user);

     UserEntity toUserEntity(UserDto userDto);

     List<UserDto> toUserDto(List<UserEntity> users);
}
