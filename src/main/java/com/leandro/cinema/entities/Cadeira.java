package com.leandro.cinema.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Cadeira {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String identificacao;
	
	@Column(nullable = false)
	private Boolean disponivel;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Pessoa pessoa;
	
	@ManyToOne
	private Sessao sessao;
	
	public Cadeira () {
		
	}
	
	public Cadeira (Long id, String identificacao, Boolean disponivel, Pessoa pessoa, Sessao sessao) {
		this.id = id;
		this.identificacao = identificacao;
		this.disponivel = disponivel;
		this.pessoa = pessoa;
		this.sessao = sessao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public Boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}
	
	
}
