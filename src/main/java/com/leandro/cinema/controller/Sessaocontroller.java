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

import com.leandro.cinema.entities.Sessao;
import com.leandro.cinema.services.Sessaoservices;

@RestController
@RequestMapping ("/cinema")
public class Sessaocontroller {

	
	@Autowired
	Sessaoservices sessaoservices;
	
	
	@PostMapping ("/sessoes")
    public ResponseEntity<Sessao> criarSessao(@RequestBody Sessao sessao) {
        Sessao sessaoSalva = sessaoservices.salvarSessao(sessao);
        return ResponseEntity.ok(sessaoSalva);
    }

    @GetMapping ("/listar/sessoes")
    public ResponseEntity<List<Sessao>> listarSessoes() {
        List<Sessao> sessoes = sessaoservices.listarSessoes();
        return ResponseEntity.ok(sessoes);
    }

    @GetMapping("/buscarsessao/{id}")
    public ResponseEntity<Sessao> buscarSessaoPorId(@PathVariable Long id) {
        Optional<Sessao> sessao = sessaoservices.buscarSessaoPorId(id);
        return sessao.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/atualizacaosessao/{id}")
    public ResponseEntity<Sessao> atualizarSessao(@PathVariable Long id, @RequestBody Sessao sessao) {
        sessao.setId(id);
        Sessao sessaoAtualizada = sessaoservices.salvarSessao(sessao);
        return ResponseEntity.ok(sessaoAtualizada);
    }
    
    @DeleteMapping("/deletarsessao/{id}")
    public ResponseEntity<Void> deletarSessao(@PathVariable Long id) {
        sessaoservices.deletarSessao(id);
        return ResponseEntity.noContent().build();
    }
}
