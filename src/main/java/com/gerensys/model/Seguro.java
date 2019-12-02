package com.gerensys.model;

import javax.persistence.*;

@Entity
public class Seguro {

	@Id
	private Long numeroApolice;
	
	private String nomeSeguradora;
	
	private String telefoneSeguradora;
	
	private String vencimentoSeguro;
	
	private String dataContratacao;
	
	private String valorSeguro;
	
	@OneToOne(mappedBy = "seguro", cascade = CascadeType.ALL, orphanRemoval = true)
	private Veiculo veiculo;
	
	@ManyToOne
	@JoinColumn(name = "FinancasIdFinancas")
	private Financas financas;

	public Long getNumeroApolice() {
		return numeroApolice;
	}

	public void setNumeroApolice(Long numeroApolice) {
		this.numeroApolice = numeroApolice;
	}

	public String getNomeSeguradora() {
		return nomeSeguradora;
	}

	public void setNomeSeguradora(String nomeSeguradora) {
		this.nomeSeguradora = nomeSeguradora;
	}

	public String getTelefoneSeguradora() {
		return telefoneSeguradora;
	}

	public void setTelefoneSeguradora(String telefoneSeguradora) {
		this.telefoneSeguradora = telefoneSeguradora;
	}

	public String getVencimentoSeguro() {
		return vencimentoSeguro;
	}

	public void setVencimentoSeguro(String vencimentoSeguro) {
		this.vencimentoSeguro = vencimentoSeguro;
	}

	public String getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(String dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public String getValorSeguro() {
		return valorSeguro;
	}

	public void setValorSeguro(String valorSeguro) {
		this.valorSeguro = valorSeguro;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Financas getFinancas() {
		return financas;
	}

	public void setFinancas(Financas financas) {
		this.financas = financas;
	}
}
