package com.vector.authorbook.service;

import com.vector.authorbook.entity.User;

import java.util.Optional;

public interface UserService {


    User save(User user);


    Optional<User> findByEmail(String email);
}
