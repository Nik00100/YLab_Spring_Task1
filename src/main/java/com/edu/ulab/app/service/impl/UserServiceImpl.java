package com.edu.ulab.app.service.impl;

import com.edu.ulab.app.dto.UserDto;
import com.edu.ulab.app.entity.UserEntity;
import com.edu.ulab.app.mapper.UserMapperImpl;
import com.edu.ulab.app.service.UserService;
import com.edu.ulab.app.storage.Storage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserDto createUser(UserDto userDto) {
        // сгенерировать идентификатор
        // создать пользователя
        // вернуть сохраненного пользователя со всеми необходимыми полями id
        UserEntity userEntity = new UserMapperImpl().userDtoToUserEntity(userDto);
        userEntity = Storage.userEntityDAO.save(userEntity);
        userDto.setId(userEntity.getId());
        return userDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long userId) {
        UserEntity userEntity = new UserMapperImpl().userDtoToUserEntity(userDto);
        userEntity = Storage.userEntityDAO.update(userEntity,userId);
        userDto.setId(userEntity.getId());
        return userDto;
    }

    @Override
    public UserDto getUserById(Long id) {
        return new UserMapperImpl().userEntityToUserDto(Storage.userEntityDAO.get(id).get());
    }

    @Override
    public void deleteUserById(Long id) {
        UserEntity user = Storage.userEntityDAO.get(id).get();
        Storage.userEntityDAO.delete(user);
    }
}
