package com.leandro.cinema.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Sessao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	 @Column(nullable = false)
	private String filme;
	 
	 @Column(nullable = false)
	private LocalDateTime horario;

	 @OneToMany(mappedBy = "sessao", cascade = CascadeType.ALL)
	private List<Cadeira> cadeiras;

	public Sessao() {

	}

	public Sessao(Long id, String filme, LocalDateTime horario) {
		this.id = id;
		this.filme = filme;
		this.horario = horario;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFilme() {
		return filme;
	}

	public void setFilme(String filme) {
		this.filme = filme;
	}

	public LocalDateTime getHorario() {
		return horario;
	}

	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
	}

	public List<Cadeira> getCadeiras() {
		return cadeiras;
	}

	public void setCadeiras(List<Cadeira> cadeiras) {
		this.cadeiras = cadeiras;
	}

}
