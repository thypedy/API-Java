package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<User>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody UserDTO dto) {
        User u = new User();
        u.setNome(dto.nome);
        u.setEmail(dto.email);
        u.setProfissaoAtual(dto.profissaoAtual);

        User saved = service.create(u);

        return ResponseEntity
                .created(URI.create("/api/users/" + saved.getId()))
                .body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @Valid @RequestBody UserDTO dto) {
        User user = new User();
        user.setNome(dto.nome);
        user.setEmail(dto.email);
        user.setProfissaoAtual(dto.profissaoAtual);

        return ResponseEntity.ok(service.update(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{userId}/enroll/{learningPathId}")
    public ResponseEntity<User> enroll(@PathVariable Long userId, @PathVariable Long learningPathId) {
        return ResponseEntity.ok(service.enrollInLearningPath(userId, learningPathId));
    }
}
