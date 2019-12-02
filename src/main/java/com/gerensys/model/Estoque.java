package com.gerensys.model;

import javax.persistence.*;

@Entity
public class Estoque {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nomeItem")
	private String nomeItem;
	
	private String descricaoPeca;
	
	private int quantidade;
	
	private String tipo;
	
	private double preco;
	
	@OneToOne(mappedBy = "estoque")
	private Financas financas;
	
	@ManyToOne
	@JoinColumn(name = "id_manutencao")
	private Manutencao manutencao; //Pq?? Se exluir manutencao irá excluir o estoque tbm



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public String getDescricaoPeca() {
		return descricaoPeca;
	}

	public void setDescricaoPeca(String descricaoPeca) {
		this.descricaoPeca = descricaoPeca;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Financas getFinancas() {
		return financas;
	}

	public void setFinancas(Financas financas) {
		this.financas = financas;
	}

	public Manutencao getManutencao() {
		return manutencao;
	}

	public void setManutencao(Manutencao manutencao) {
		this.manutencao = manutencao;
	}
	
}
