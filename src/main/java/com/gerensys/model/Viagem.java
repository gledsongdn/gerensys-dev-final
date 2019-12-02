package com.gerensys.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Viagem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idViagem;
	
	@OneToOne
	@JoinColumn(name = "idFuncionario")
	private Funcionario funcionario;
	
	@OneToOne(mappedBy = "viagem")
	private Relatorio relatorio;

	public Long getIdViagem() {
		return idViagem;
	}

	public void setIdViagem(Long idViagem) {
		this.idViagem = idViagem;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Relatorio getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(Relatorio relatorio) {
		this.relatorio = relatorio;
	}
	
	
}
