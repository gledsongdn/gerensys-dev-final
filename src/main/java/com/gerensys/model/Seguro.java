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
	
	private double valorSeguro;
	
	@OneToOne(mappedBy = "seguro", cascade = CascadeType.ALL, orphanRemoval = true)
	private Veiculo veiculo;

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

	public double getValorSeguro() {
		return valorSeguro;
	}

	public void setValorSeguro(double valorSeguro) {
		this.valorSeguro = valorSeguro;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
}
