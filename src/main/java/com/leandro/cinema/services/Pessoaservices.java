package com.leandro.cinema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandro.cinema.entities.Pessoa;
import com.leandro.cinema.repositories.Pessoarepository;

@Service
public class Pessoaservices {

	
	@Autowired
	Pessoarepository pessoarepository;
	
	public Pessoa salvarPessoa(Pessoa pessoa) {
        return pessoarepository.save(pessoa);
    }

    public List<Pessoa> listarPessoas() {
        return pessoarepository.findAll();
    }

    public Optional<Pessoa> buscarPessoaPorId(Long id) {
        return pessoarepository.findById(id);
    }
    
    public void deletarPessoa(Long id) {
		if (!pessoarepository.existsById(id)) {
			throw new RuntimeException("Pessoa com id não encontrada");
		}
		pessoarepository.deleteById(id);
	}
}