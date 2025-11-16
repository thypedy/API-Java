package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "learning_paths")
public class LearningPath {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 150)
    private String titulo;

    @Size(max = 500)
    private String descricao;

    @Size(max = 300)
    private String competenciasFuturo;

    @ManyToMany(mappedBy = "trilhasInscrito")
    private Set<User> usuarios = new HashSet<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getCompetenciasFuturo() { return competenciasFuturo; }
    public void setCompetenciasFuturo(String competenciasFuturo) { this.competenciasFuturo = competenciasFuturo; }

    public Set<User> getUsuarios() { return usuarios; }
    public void setUsuarios(Set<User> usuarios) { this.usuarios = usuarios; }
}
