package com.leandro.cinema.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leandro.cinema.entities.Cadeira;
import com.leandro.cinema.entities.Sessao;

public interface Cadeirarepository extends JpaRepository<Cadeira, Long> {

}
