package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String nome;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @Size(max = 100)
    private String profissaoAtual;

    @ManyToMany
    @JoinTable(
            name = "user_learningpath",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "learningpath_id")
    )
    private Set<LearningPath> trilhasInscrito = new HashSet<>();

    // GETTERS e SETTERS

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getProfissaoAtual() { return profissaoAtual; }
    public void setProfissaoAtual(String profissaoAtual) { this.profissaoAtual = profissaoAtual; }

    public Set<LearningPath> getTrilhasInscrito() { return trilhasInscrito; }
    public void setTrilhasInscrito(Set<LearningPath> trilhasInscrito) { this.trilhasInscrito = trilhasInscrito; }
}
