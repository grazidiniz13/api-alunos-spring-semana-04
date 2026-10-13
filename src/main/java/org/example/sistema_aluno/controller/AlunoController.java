package org.example.sistema_aluno.controller;

import org.example.sistema_aluno.dto.AlunoRequest;
import org.example.sistema_aluno.dto.AlunoResponse;
import org.example.sistema_aluno.model.Aluno;
import org.example.sistema_aluno.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    // POST - Cadastrar aluno (201 Created)
    @PostMapping
    public ResponseEntity<AlunoResponse> create(@RequestBody AlunoRequest request) {
        Aluno aluno = new Aluno();
        aluno.setNome(request.getNome());
        aluno.setEmail(request.getEmail());
        aluno.setCurso(request.getCurso());

        Aluno alunoSalvo = alunoRepository.save(aluno);

        AlunoResponse response = new AlunoResponse(
                alunoSalvo.getId(),
                alunoSalvo.getNome(),
                alunoSalvo.getEmail(),
                alunoSalvo.getCurso()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // GET - Buscar por ID (200 OK ou 404 Not Found com Optional explícito)
    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponse> getById(@PathVariable Long id) {
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);

        if (optionalAluno.isPresent()) {
            Aluno aluno = optionalAluno.get();
            AlunoResponse response = new AlunoResponse(
                    aluno.getId(),
                    aluno.getNome(),
                    aluno.getEmail(),
                    aluno.getCurso()
            );
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // PUT - Atualizar aluno (204 No Content) utilizando findById().orElseThrow()
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody AlunoRequest request) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id));

        aluno.setNome(request.getNome());
        aluno.setEmail(request.getEmail());
        aluno.setCurso(request.getCurso());

        alunoRepository.save(aluno);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // DELETE - Remover aluno (204 No Content) utilizando existsById no if sem lambda
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!alunoRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        alunoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}