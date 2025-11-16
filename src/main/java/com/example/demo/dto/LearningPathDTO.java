package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LearningPathDTO {

    @NotBlank
    @Size(max = 150)
    public String titulo;

    @Size(max = 500)
    public String descricao;

    @Size(max = 300)
    public String competenciasFuturo;
}
