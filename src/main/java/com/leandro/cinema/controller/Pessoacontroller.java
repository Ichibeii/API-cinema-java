package com.leandro.cinema.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.cinema.entities.Pessoa;
import com.leandro.cinema.services.Pessoaservices;

@RestController
@RequestMapping ("/cinema")
public class Pessoacontroller {

	@Autowired
	Pessoaservices pessoaservices;
	
	@PostMapping ("/pessoas")
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa) {
        Pessoa pessoaSalva = pessoaservices.salvarPessoa(pessoa);
        return ResponseEntity.ok(pessoaSalva);
    }

    @GetMapping ("/listar/pessoas")
    public ResponseEntity<List<Pessoa>> listarPessoas() {
        List<Pessoa> pessoas = pessoaservices.listarPessoas();
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/buscarpessoa/{id}")
    public ResponseEntity<Pessoa> buscarPessoaPorId(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaservices.buscarPessoaPorId(id);
        return pessoa.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/atualizacaopessoa/{id}")
    public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        pessoa.setId(id);
        Pessoa pessoaAtualizada = pessoaservices.salvarPessoa(pessoa);
        return ResponseEntity.ok(pessoaAtualizada);
    }
    
    @DeleteMapping("/deletarpessoa/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Long id) {
        pessoaservices.deletarPessoa(id);
        return ResponseEntity.noContent().build();
    }
}
