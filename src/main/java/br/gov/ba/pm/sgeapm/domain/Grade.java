package br.gov.ba.pm.sgeapm.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "titemturma")
public class Grade extends AbstractEntity  {
    
   
    @JoinColumn(name = "CodTurma", referencedColumnName = "id")
    @ManyToOne
    private Turma turma;
    
    @Column(name = "Turma1")
    private String turma1;
    
    @Column(name = "Disciplina1")
    private String disciplina1;
    
    @Column(name = "Abreviatura")
    private String abreviatura;
    
    
    @JoinColumn(name = "CodSerie", referencedColumnName = "id")
    @ManyToOne
    private Serie serie;
    
    @Column(name = "Ano")
    private Integer ano;
    
    @Column(name = "Diversificada")
    private String diversificada;
    
    @Column(name = "ImpAta")
    private String impAta;
    
    @Column(name = "Semestre")
    private String semestre;
    
    @Column(name = "Peso")
    private String peso;
    
    
    @JoinColumn(name = "CodDisciplina", referencedColumnName = "id")
    @ManyToOne
    private Disciplina disciplina;

	public Grade() {
		super();
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public String getTurma1() {
		return turma1;
	}

	public void setTurma1(String turma1) {
		this.turma1 = turma1;
	}

	public String getDisciplina1() {
		return disciplina1;
	}

	public void setDisciplina1(String disciplina1) {
		this.disciplina1 = disciplina1;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}


	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getDiversificada() {
		return diversificada;
	}

	public void setDiversificada(String diversificada) {
		this.diversificada = diversificada;
	}

	public String getImpAta() {
		return impAta;
	}

	public void setImpAta(String impAta) {
		this.impAta = impAta;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
    
}
