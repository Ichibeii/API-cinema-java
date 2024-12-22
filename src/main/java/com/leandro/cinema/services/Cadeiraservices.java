package com.leandro.cinema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandro.cinema.entities.Cadeira;
import com.leandro.cinema.repositories.Cadeirarepository;

@Service
public class Cadeiraservices {

	@Autowired
	Cadeirarepository cadeirarepository;

	public Cadeira salvarCadeira(Cadeira cadeira) {
		return cadeirarepository.save(cadeira);
	}

	public List<Cadeira> listarCadeiras() {
		return cadeirarepository.findAll();
	}

	public Optional<Cadeira> buscarCadeiraPorId(Long id) {
		return cadeirarepository.findById(id);
	}

	public Cadeira atualizarDisponibilidade(Long id, boolean disponivel) {
		Cadeira cadeira = cadeirarepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Cadeira não encontrada!"));
		cadeira.setDisponivel(disponivel);
		return cadeirarepository.save(cadeira);
	}

	public void deletarCadeira(Long id) {
		if (!cadeirarepository.existsById(id)) {
			throw new RuntimeException("Cadeira com id não encontrada");
		}
		cadeirarepository.deleteById(id);
	}

}
