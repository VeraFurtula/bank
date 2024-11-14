package com.learning.bank.service.impl;

import com.learning.bank.model.User;
import com.learning.bank.repository.UserRepository;
import com.learning.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findOneById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User delete(Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    if (!user.getAccounts().isEmpty()) {
                        throw new DataIntegrityViolationException("User has associated accounts.");
                    }
                    userRepository.delete(user);
                    return user;
                })
                .orElse(null);
    }
}
