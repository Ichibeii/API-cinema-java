package com.leandro.cinema.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leandro.cinema.entities.Pessoa;

public interface Pessoarepository extends JpaRepository<Pessoa, Long> {

	 Optional<Pessoa> findByCpf(String cpf);
}
