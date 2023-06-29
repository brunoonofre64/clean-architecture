package com.github.brunoonofre64.infra.data.mappers.impl;

import com.github.brunoonofre64.domain.entities.User;
import com.github.brunoonofre64.infra.data.entities.UserEntity;
import com.github.brunoonofre64.infra.data.mappers.UserDataMapper;
import org.springframework.stereotype.Component;

@Component
public class UserDataMapperImpl implements UserDataMapper {

    @Override
    public User toDomain(UserEntity userEntity) {
        return new User(userEntity.getUuid(), userEntity.getUsername(), userEntity.getPassword(), userEntity.getRoles());
    }

    @Override
    public UserEntity toEntity(User user) {
        return new UserEntity(user.getUuid(), user.getUsername(), user.getPassword(), user.getRoles());
    }
}
