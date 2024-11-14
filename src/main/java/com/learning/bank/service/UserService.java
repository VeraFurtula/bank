package com.learning.bank.service;

import com.learning.bank.model.User;

import java.util.List;

public interface UserService {
    User findOne(Long id);
    List<User> findAll();
    User save(User user);
    User update(User user);
    User delete(Long id);
}
