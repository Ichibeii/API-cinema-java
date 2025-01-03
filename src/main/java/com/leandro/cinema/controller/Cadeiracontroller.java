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

import com.leandro.cinema.entities.Cadeira;
import com.leandro.cinema.entities.Sala;
import com.leandro.cinema.repositories.Salarepository;
import com.leandro.cinema.services.Cadeiraservices;

@RestController
@RequestMapping ("/cinema")
public class Cadeiracontroller {

	@Autowired
	Cadeiraservices cadeiraservices;
	
	@Autowired
	Salarepository salarepository;
	
	
	@PostMapping("/salas/{salaId}/cadeiras")
	public ResponseEntity<List<Cadeira>> adicionarCadeirasASala(@PathVariable Long salaId) {
	    Sala sala = salarepository.findById(salaId)
	        .orElseThrow(() -> new RuntimeException("Sala não encontrada!"));

	    List<Cadeira> cadeiras = cadeiraservices.gerarCadeirasPorSala(sala);
	    sala.setCadeiras(cadeiras);
	    salarepository.save(sala);
	    
	    return ResponseEntity.ok(cadeiras);
	}

	
	@GetMapping ("/listar/cadeiras")
    public ResponseEntity<List<Cadeira>> listarCadeiras() {
		List<Cadeira> cadeiras = cadeiraservices.listarCadeiras();
        return ResponseEntity.ok(cadeiras);
    }

    @GetMapping("/buscarcadeira/{id}")
    public ResponseEntity<Cadeira> buscarCadeiraPorId(@PathVariable Long id) {
        Optional<Cadeira> cadeira = cadeiraservices.buscarCadeiraPorId(id);
        return cadeira.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/atualizacaocadeira/{id}")
    public ResponseEntity<Cadeira> atualizarCadeira(@PathVariable Long id, @RequestBody Cadeira cadeira) {
        cadeira.setId(id);
        Cadeira cadeiraAtualizada = cadeiraservices.salvarCadeira(cadeira);
        return ResponseEntity.ok(cadeiraAtualizada);
    }

    @DeleteMapping("/deletarcadeira/{id}")
    public ResponseEntity<Void> deletarCadeira(@PathVariable Long id) {
        cadeiraservices.deletarCadeira(id);
        return ResponseEntity.noContent().build();
    }

}
