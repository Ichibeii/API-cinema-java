package com.leandro.cinema.services;

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
        // Buscar cadeira pelo ID
        Cadeira cadeira = cadeirarepository.findById(cadeiraId)
                .orElseThrow(() -> new RuntimeException("Cadeira não encontrada!"));

        // Verificar se a cadeira está disponível
        if (!cadeira.getDisponivel()) {
            throw new RuntimeException("Cadeira já reservada!");
        }

        // Buscar pessoa pelo ID
        Pessoa pessoa = pessoarepository.findById(pessoaId)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada!"));

        // Atualizar a disponibilidade e associar à pessoa
        cadeira.setDisponivel(false);
        cadeira.setPessoa(pessoa); // Supondo que exista o campo `pessoa` em `Cadeira`

        return cadeirarepository.save(cadeira);
    }
}
