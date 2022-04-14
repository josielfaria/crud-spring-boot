package com.api.crudspringboot.services;

import com.api.crudspringboot.models.UserModel;
import com.api.crudspringboot.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserModel save(UserModel userModel) {
        return userRepository.save(userModel);
    }

    public boolean existUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public Page<UserModel> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public Optional<UserModel> findById(UUID id) {
        return userRepository.findById(id);
    }

    @Transactional
    public void delete(UserModel userModel) {
        userRepository.delete(userModel);
    }
}
