package org.example.sistema_aluno.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AlunoResponse {
    private Long id;
    private String nome;
    private String email;
    private String curso;
}