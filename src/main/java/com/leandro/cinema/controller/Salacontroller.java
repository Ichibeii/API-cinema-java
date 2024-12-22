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

import com.leandro.cinema.entities.Sala;
import com.leandro.cinema.services.Salaservices;

@RestController
@RequestMapping ("/cinema")
public class Salacontroller {

	
	@Autowired
	Salaservices salaservices;
	
	
	 @PostMapping ("/salas")
	    public ResponseEntity<Sala> criarSala(@RequestBody Sala sala) {
	        Sala salaSalva = salaservices.salvarSala(sala);
	        return ResponseEntity.ok(salaSalva);
	    }

	    @GetMapping ("/listar/salas")
	    public ResponseEntity<List<Sala>> listarSalas() {
	        List<Sala> salas = salaservices.listarSalas();
	        return ResponseEntity.ok(salas);
	    }

	    @GetMapping("/buscarsala/{id}")
	    public ResponseEntity<Sala> buscarSalaPorId(@PathVariable Long id) {
	        Optional<Sala> sala = salaservices.buscarSalaPorId(id);
	        return sala.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PutMapping("/atualizacaosala/{id}")
	    public ResponseEntity<Sala> atualizarSala(@PathVariable Long id, @RequestBody Sala sala) {
	        sala.setId(id);
	        Sala salaAtualizada = salaservices.salvarSala(sala);
	        return ResponseEntity.ok(salaAtualizada);
	    }
	    
	    @DeleteMapping("/deletarsala/{id}")
	    public ResponseEntity<Void> deletarSala(@PathVariable Long id) {
	        salaservices.deletarSala(id);
	        return ResponseEntity.noContent().build();
	    }
}
