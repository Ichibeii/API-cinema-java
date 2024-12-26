package com.leandro.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leandro.cinema.entities.Sala;

public interface Salarepository extends JpaRepository<Sala, Long> {

	
}
