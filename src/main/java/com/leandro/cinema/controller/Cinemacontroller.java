package com.leandro.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.cinema.entities.Cadeira;
import com.leandro.cinema.entities.Pessoa;
import com.leandro.cinema.services.CinemaServices;

@RestController
@RequestMapping ("/cinema")
public class Cinemacontroller {

	@Autowired
	private CinemaServices cinemaServices;
	
	
	@PostMapping ("/reservar/{id}")
	public ResponseEntity<Cadeira> reservarCadeira (@PathVariable Long id, @RequestBody Pessoa pessoa) {
		Cadeira cadeiraReservada = cinemaServices.reservarCadeira(id, pessoa.getNome(), pessoa.getCpf());
		return ResponseEntity.ok(cadeiraReservada);
	}
}
