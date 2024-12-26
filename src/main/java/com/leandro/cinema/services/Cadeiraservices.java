package com.leandro.cinema.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandro.cinema.entities.Cadeira;
import com.leandro.cinema.entities.Sala;
import com.leandro.cinema.repositories.Cadeirarepository;
import com.leandro.cinema.repositories.Salarepository;

@Service
public class Cadeiraservices {

	@Autowired
	Cadeirarepository cadeirarepository;

	@Autowired
	Salarepository salarepository;

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

	public List<Cadeira> gerarCadeirasPorSala(Sala sala) {
		List<Cadeira> cadeiras = new ArrayList<>();
		String[] fileiras = { "A", "B", "C" };
		int numCadeirasPorFileira = 10;

		for (String fileira : fileiras) {
			for (int i = 1; i <= numCadeirasPorFileira; i++) {
				String identificacao = fileira + i;
				Cadeira cadeira = new Cadeira();
				cadeira.setIdentificacao(identificacao);
				cadeira.setDisponivel(true);
				cadeira.setSala(sala);
				cadeiras.add(cadeira);
			}
		}
		return cadeiras;
	}

	public Sala salvarSala(Sala sala) {
		List<Cadeira> cadeiras = this.gerarCadeirasPorSala(sala);
		sala.setCadeiras(cadeiras);
		return salarepository.save(sala);
	}

}
