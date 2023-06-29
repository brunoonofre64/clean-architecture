package com.github.brunoonofre64.infra.data.adapters;

import com.github.brunoonofre64.domain.entities.User;
import com.github.brunoonofre64.domain.interfaces.IUserRepository;
import com.github.brunoonofre64.infra.data.entities.UserEntity;
import com.github.brunoonofre64.infra.data.enums.ErrorInfraDataMessage;
import com.github.brunoonofre64.infra.data.mappers.UserDataMapper;
import com.github.brunoonofre64.infra.data.repositories.UserRepository;
import com.github.brunoonofre64.infra.data.validations.InfraDataExceptionValidations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryAdapter implements IUserRepository {

    private final UserRepository userRepository;
    private final UserDataMapper mapper;

    public UserRepositoryAdapter(UserRepository userRepository, UserDataMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Optional<User> findByUsername(String username) {
        UserEntity userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new InfraDataExceptionValidations(ErrorInfraDataMessage.USER_NOT_FOUND));

        User user = mapper.toDomain(userEntity);

        return Optional.ofNullable(user);
    }

    @Override
    @Transactional
    public void save(User user) {
        UserEntity userEntity = mapper.toEntity(user);
        userRepository.save(userEntity);
    }

    @Override
    @Transactional
    public List<User> findAll() {
        List<UserEntity> userList = userRepository.findAll();

        return userList
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    @Transactional
    public void delete(User user) {
        UserEntity userEntity = mapper.toEntity(user);

        try {
            userRepository.delete(userEntity);
        } catch (Exception ex) {
            throw new InfraDataExceptionValidations(ErrorInfraDataMessage.USER_NOT_FOUND);
        }
    }
}
