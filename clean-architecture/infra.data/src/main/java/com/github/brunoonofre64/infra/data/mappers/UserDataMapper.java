package com.github.brunoonofre64.infra.data.mappers;

import com.github.brunoonofre64.domain.entities.User;
import com.github.brunoonofre64.infra.data.entities.UserEntity;

public interface UserDataMapper {
    User toDomain(UserEntity userEntity);
    UserEntity toEntity(User user);
}
