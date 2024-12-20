package com.leandro.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leandro.cinema.entities.Cadeira;

public interface Cadeirarepository extends JpaRepository<Cadeira, Long> {

}
