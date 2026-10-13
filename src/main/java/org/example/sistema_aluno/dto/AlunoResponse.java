package org.example.sistema_aluno.dto;

public class AlunoResponse {
    private Long id;
    private String nome;
    private String email;
    private String curso;

    public AlunoResponse(Long id, String nome, String email, String curso) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.curso = curso;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getCurso() { return curso; }
}
