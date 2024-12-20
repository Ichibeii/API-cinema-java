package com.leandro.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leandro.cinema.entities.Sessao;

public interface Sessaorepository extends JpaRepository<Sessao, Long> {

}
