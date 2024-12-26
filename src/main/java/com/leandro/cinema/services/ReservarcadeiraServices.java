package com.leandro.cinema.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandro.cinema.entities.Cadeira;
import com.leandro.cinema.entities.Pessoa;
import com.leandro.cinema.repositories.Cadeirarepository;
import com.leandro.cinema.repositories.Pessoarepository;

import jakarta.transaction.Transactional;

@Service
public class ReservarcadeiraServices {

	@Autowired
	Cadeirarepository cadeirarepository;

	@Autowired
	Pessoarepository pessoarepository;

	@Transactional
	public Cadeira reservarCadeira(Long cadeiraId, Long pessoaId) {

		Cadeira cadeira = cadeirarepository.findById(cadeiraId)
				.orElseThrow(() -> new RuntimeException("Cadeira não encontrada!"));

		if (!cadeira.getDisponivel()) {
			throw new RuntimeException("Cadeira já reservada!");
		}

		Pessoa pessoa = pessoarepository.findById(pessoaId)
				.orElseThrow(() -> new RuntimeException("Pessoa não encontrada!"));

		cadeira.setDisponivel(false);
		cadeira.setPessoa(pessoa);

		return cadeirarepository.save(cadeira);
		
	}

	public List<Cadeira> listarCadeirasPorSessao(Long sessaoId) {

		return null;
	}

	public List<Cadeira> listarCadeiras() {
        return cadeirarepository.findAll();
    }
}
