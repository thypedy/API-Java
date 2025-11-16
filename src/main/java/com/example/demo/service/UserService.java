package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    User create(User user);
    List<User> findAll();
    User findById(Long id);
    User update(Long id, User user);
    void delete(Long id);

    User enrollInLearningPath(Long userId, Long learningPathId);
}
