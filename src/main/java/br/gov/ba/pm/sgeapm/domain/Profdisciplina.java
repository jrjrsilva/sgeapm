/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ba.pm.sgeapm.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "tprofdisciplina")
public class Profdisciplina extends AbstractEntity  {
   
    
  
    @JoinColumn(name = "CodDisciplina", referencedColumnName = "id")
    @ManyToOne
    private Disciplina disciplina;
    
    
    @JoinColumn(name = "CodSerie", referencedColumnName = "id")
    @ManyToOne
    private Serie serie;
    
    
    @JoinColumn(name = "CodTurma", referencedColumnName = "id")
    @ManyToOne
    private Turma turma;
    
    @Column(name = "Ano")
    private Integer ano;
    
    @JoinColumn(name = "CodProfessor", referencedColumnName = "id")
    @ManyToOne
    private Professor professor;

    public Profdisciplina() {
    }

   
    
    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

   
    public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}    
    
}
