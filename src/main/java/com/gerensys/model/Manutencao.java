package com.gerensys.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Manutencao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idManutencao")
	private Long idManutencao;
	
	@Column(name = "descricaoProblema")
	private String descricaoProblema;
	
	@OneToMany(mappedBy = "manutencao", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Estoque> estoques;
	
	@OneToOne
	@JoinColumn(name = "veiculo_renavam")
	private Veiculo veiculo;

	public Long getIdManutencao() {
		return idManutencao;
	}

	public void setIdManutencao(Long idManutencao) {
		this.idManutencao = idManutencao;
	}

	public String getDescricaoProblema() {
		return descricaoProblema;
	}

	public void setDescricaoProblema(String descricaoProblema) {
		this.descricaoProblema = descricaoProblema;
	}

	public List<Estoque> getEstoques() {
		return estoques;
	}

	public void setEstoques(List<Estoque> estoques) {
		this.estoques = estoques;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
}
