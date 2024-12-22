package com.leandro.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.cinema.entities.Cadeira;
import com.leandro.cinema.services.ReservarcadeiraServices;

@RestController
@RequestMapping("/cinema")
public class Reservarcadeiracontroller {

	@Autowired
	private ReservarcadeiraServices reservarcadeiraServices;

	@PostMapping("/cadeiras/{cadeiraId}/pessoas/{pessoaId}")
	public ResponseEntity<Cadeira> reservarCadeira(@PathVariable Long cadeiraId, @PathVariable Long pessoaId) {
		Cadeira cadeiraReservada = reservarcadeiraServices.reservarCadeira(cadeiraId, pessoaId);
		return ResponseEntity.ok(cadeiraReservada);
	}
}
