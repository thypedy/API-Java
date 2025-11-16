package com.example.demo.controller;

import com.example.demo.dto.LearningPathDTO;
import com.example.demo.model.LearningPath;
import com.example.demo.service.LearningPathService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/paths")
public class LearningPathController {

    private final LearningPathService service;

    public LearningPathController(LearningPathService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<LearningPath>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LearningPath> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<LearningPath> create(@Valid @RequestBody LearningPathDTO dto) {
        LearningPath lp = new LearningPath();
        lp.setTitulo(dto.titulo);
        lp.setDescricao(dto.descricao);
        lp.setCompetenciasFuturo(dto.competenciasFuturo);

        LearningPath saved = service.create(lp);
        return ResponseEntity
                .created(URI.create("/api/paths/" + saved.getId()))
                .body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LearningPath> update(@PathVariable Long id, @Valid @RequestBody LearningPathDTO dto) {
        LearningPath lp = new LearningPath();
        lp.setTitulo(dto.titulo);
        lp.setDescricao(dto.descricao);
        lp.setCompetenciasFuturo(dto.competenciasFuturo);

        return ResponseEntity.ok(service.update(id, lp));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
