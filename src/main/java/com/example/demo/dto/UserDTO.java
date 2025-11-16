package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDTO {

    @NotBlank
    @Size(max = 100)
    public String nome;

    @Email
    @NotBlank
    public String email;

    @Size(max = 100)
    public String profissaoAtual;
}
