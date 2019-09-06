package br.gov.ba.pm.sgeapm.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "matriculado")
public class Matriculado extends AbstractEntity {
	
	
	@Column(name = "DataMatricula")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataMatricula;
	
	@Column(name = "Ano")
	private Integer ano;
	@Column(name = "Turno")
	private String turno;
	@Column(name = "MotivoCancelamento")
	private String motivoCancelamento;
	@Column(name = "TransferenciaData")
	@Temporal(TemporalType.TIMESTAMP)
	private Date transferenciaData;
	
	@JoinColumn(name = "CodSerie", referencedColumnName = "id")
	@ManyToOne
	private Serie serie;
	
	public Serie getSerie() {
		return serie;
	}
	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	@Column(name = "DescSerie")
	private String descSerie;
	@Column(name = "Situacao")
	private String situacao;
	@Column(name = "Quant")
	private Integer quant;
	@Column(name = "Numero")
	private Integer numero;
	
	@JoinColumn(name = "CodAluno", referencedColumnName = "id")
	@ManyToOne
	private Aluno aluno;
	
	@ManyToOne
	@JoinColumn(name = "CodTurma", referencedColumnName = "id")
	private Turma turma;
	
	public Matriculado() {
		super();
	}
		
	public Date getDataMatricula() {
		return dataMatricula;
	}
	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	public String getMotivoCancelamento() {
		return motivoCancelamento;
	}
	public void setMotivoCancelamento(String motivoCancelamento) {
		this.motivoCancelamento = motivoCancelamento;
	}
	public Date getTransferenciaData() {
		return transferenciaData;
	}
	public void setTransferenciaData(Date transferenciaData) {
		this.transferenciaData = transferenciaData;
	}


	public String getDescSerie() {
		return descSerie;
	}
	public void setDescSerie(String descSerie) {
		this.descSerie = descSerie;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public Integer getQuant() {
		return quant;
	}
	public void setQuant(Integer quant) {
		this.quant = quant;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	
}
