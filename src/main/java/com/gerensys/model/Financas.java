package com.gerensys.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Financas {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idFinancas")
	private Long idFinancas;
	
	private double pgtoFuncionario;
	
	private double despesasGerais;
	
	private double pecas;
	
	@OneToOne
	@JoinColumn(name = "Estoque_codigoItem")
	private Estoque estoque;
	
	@OneToMany(mappedBy = "financas")
	private List<Seguro> seguros;
	
	
	//Pq colocar Funcionario_matricula e veiculo_renavam?
	
	

	public Long getIdFinancas() {
		return idFinancas;
	}

	public void setIdFinancas(Long idFinancas) {
		this.idFinancas = idFinancas;
	}

	public double getPgtoFuncionario() {
		return pgtoFuncionario;
	}

	public void setPgtoFuncionario(double pgtoFuncionario) {
		this.pgtoFuncionario = pgtoFuncionario;
	}

	public double getDespesasGerais() {
		return despesasGerais;
	}

	public void setDespesasGerais(double despesasGerais) {
		this.despesasGerais = despesasGerais;
	}

	public double getPecas() {
		return pecas;
	}

	public void setPecas(double pecas) {
		this.pecas = pecas;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public List<Seguro> getSeguros() {
		return seguros;
	}

	public void setSeguros(List<Seguro> seguros) {
		this.seguros = seguros;
	}
}
