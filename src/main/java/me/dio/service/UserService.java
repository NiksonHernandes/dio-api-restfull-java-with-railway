package me.dio.service;

import me.dio.model.User;

public interface UserService {

    User findById(Long id);
    User createUser(User userToCreate);
}
