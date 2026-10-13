package org.example.sistema_aluno.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlunoRequest {
    private String nome;
    private String email;
    private String curso;
}