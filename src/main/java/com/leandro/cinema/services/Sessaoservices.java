package com.leandro.cinema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandro.cinema.entities.Sessao;
import com.leandro.cinema.repositories.Sessaorepository;

@Service
public class Sessaoservices {

	
	@Autowired
	Sessaorepository sessaorepository;
	
	
	public Sessao salvarSessao(Sessao sessao) {
        return sessaorepository.save(sessao);
    }

    public List<Sessao> listarSessoes() {
        return sessaorepository.findAll();
    }

    public Optional<Sessao> buscarSessaoPorId(Long id) {
        return sessaorepository.findById(id);
    }
    
    public void deletarSessao(Long id) {
		if (!sessaorepository.existsById(id)) {
			throw new RuntimeException("sessão com id não encontrada");
		}
		sessaorepository.deleteById(id);
	}
}

