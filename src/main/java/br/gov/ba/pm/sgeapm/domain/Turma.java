package br.gov.ba.pm.sgeapm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "turma")
public class Turma extends AbstractEntity {

	@JoinColumn(name = "CodSerie", referencedColumnName = "id")
	@ManyToOne
	private Serie serie;

	@Column(name = "letra")
	private String letra;
	
	@Column(name = "Ano")
	private Integer ano;
	
	@Column(name = "Pel")
	private String pel;
	
	@Column(name="descricao")
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getPel() {
		return pel;
	}

	public void setPel(String pel) {
		this.pel = pel;
	}
	
}
