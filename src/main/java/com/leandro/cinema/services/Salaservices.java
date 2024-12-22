package com.leandro.cinema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandro.cinema.entities.Sala;
import com.leandro.cinema.repositories.Salarepository;

@Service
public class Salaservices {

	@Autowired
	Salarepository salarepository;
	
	
	 public Sala salvarSala(Sala sala) {
	        return salarepository.save(sala);
	    }

	    public List<Sala> listarSalas() {
	        return salarepository.findAll();
	    }

	    public Optional<Sala> buscarSalaPorId(Long id) {
	        return salarepository.findById(id);
	    }
	    
	    public void deletarSala(Long id) {
			if (!salarepository.existsById(id)) {
				throw new RuntimeException("Sala com id não encontrada");
			}
			salarepository.deleteById(id);
		}
	}

