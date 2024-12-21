package com.leandro.cinema.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandro.cinema.entities.Cadeira;
import com.leandro.cinema.entities.Pessoa;
import com.leandro.cinema.repositories.Cadeirarepository;
import com.leandro.cinema.repositories.Pessoarepository;

import jakarta.transaction.Transactional;

@Service
public class CinemaServices {

	@Autowired
	Cadeirarepository cadeirarepository;

	@Autowired
	Pessoarepository pessoarepository;

	@Transactional
	public Cadeira reservarCadeira(Long id, String nomePessoa, String cpfPessoa) {
		Optional<Cadeira> cadeiraopOptional = cadeirarepository.findById(id);

		if (cadeiraopOptional.isEmpty()) {
			throw new RuntimeException("cadeira não encontrada");
		}

		Cadeira cadeira = cadeiraopOptional.get();

		if (!cadeira.getDisponivel()) {
			throw new RuntimeException("cadeira já está ocupada");
		}

		Pessoa pessoa = pessoarepository.findByCpf(cpfPessoa).orElseGet(() -> {

			Pessoa novaPessoa = new Pessoa();
			novaPessoa.setNome(nomePessoa);
			novaPessoa.setCpf(cpfPessoa);
			return pessoarepository.save(novaPessoa);
		});

		cadeira.setDisponivel(false);
		cadeira.setPessoa(pessoa);

		return cadeirarepository.save(cadeira);
	}
}
