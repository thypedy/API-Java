package com.example.demo.service;

import com.example.demo.model.LearningPath;

import java.util.List;

public interface LearningPathService {

    LearningPath create(LearningPath lp);
    List<LearningPath> findAll();
    LearningPath findById(Long id);
    LearningPath update(Long id, LearningPath lp);
    void delete(Long id);
}
