package com.leandro.cinema.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Sala {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String nome;

	@OneToMany(mappedBy = "sala", cascade = CascadeType.ALL)
	private List<Cadeira> cadeiras;

	public Sala() {

	}

	public Sala(Long id, String nome, List<Cadeira> cadeiras) {
		this.id = id;
		this.nome = nome;
		this.cadeiras = cadeiras;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cadeira> getCadeiras() {
		return cadeiras;
	}

	public void setCadeiras(List<Cadeira> cadeiras) {
		this.cadeiras = cadeiras;
	}

}
