package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.LearningPath;
import com.example.demo.repository.LearningPathRepository;
import com.example.demo.service.LearningPathService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearningPathServiceImpl implements LearningPathService {

    private final LearningPathRepository repository;

    public LearningPathServiceImpl(LearningPathRepository repository) {
        this.repository = repository;
    }

    @Override
    public LearningPath create(LearningPath lp) {
        return repository.save(lp);
    }

    @Override
    public List<LearningPath> findAll() {
        return repository.findAll();
    }

    @Override
    public LearningPath findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LearningPath", "id", id));
    }

    @Override
    public LearningPath update(Long id, LearningPath lp) {
        LearningPath existing = findById(id);
        existing.setTitulo(lp.getTitulo());
        existing.setDescricao(lp.getDescricao());
        existing.setCompetenciasFuturo(lp.getCompetenciasFuturo());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        LearningPath existing = findById(id);
        repository.delete(existing);
    }
}
