package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.LearningPath;
import com.example.demo.model.User;
import com.example.demo.repository.LearningPathRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final LearningPathRepository learningPathRepository;

    public UserServiceImpl(UserRepository userRepository,
                           LearningPathRepository learningPathRepository) {
        this.userRepository = userRepository;
        this.learningPathRepository = learningPathRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }

    @Override
    public User update(Long id, User user) {
        User existing = findById(id);
        existing.setNome(user.getNome());
        existing.setEmail(user.getEmail());
        existing.setProfissaoAtual(user.getProfissaoAtual());
        return userRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        User existing = findById(id);
        userRepository.delete(existing);
    }

    @Override
    @Transactional
    public User enrollInLearningPath(Long userId, Long learningPathId) {
        User user = findById(userId);
        LearningPath lp = learningPathRepository.findById(learningPathId)
                .orElseThrow(() -> new ResourceNotFoundException("LearningPath", "id", learningPathId));
        user.getTrilhasInscrito().add(lp);
        return userRepository.save(user);
    }
}
