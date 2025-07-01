package me.dio.service.impl;

import me.dio.model.User;
import me.dio.repository.UserRepository;
import me.dio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Usuário não encontrado no banco de dados. Id:" + id));
    }

    @Override
    public User createUser(User userToCreate) {
        if (userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())) {
            throw new IllegalArgumentException("Este usuário já existe");
        }

        if (userToCreate.getName().isEmpty()) {
            throw new RuntimeException("O nome do usuário não pode ser nulo");
        }

        if (userToCreate.getAccount().getNumber() != null && userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("Account number já existe");
        }

        return userRepository.save(userToCreate);
    }
}
