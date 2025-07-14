package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Optional<User> findById(Long id);
    User save(User user);
    Optional<User> findByEmail(String email);
    List<User> findAll();
    void delete(Long id);
}
