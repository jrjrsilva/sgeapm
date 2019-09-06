package br.gov.ba.pm.sgeapm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "serie")
public class Serie extends AbstractEntity {

	 	@Column(name = "CodSerie")
	    private String codSerie;
	    
	    @Column(name = "nome")
	    private String nome;
	    @Column(name = "Ano")
	    private Integer ano;
	    @Column(name = "Apelido")
	    private String apelido;

	    public Serie() {
	    }

		

		public String getCodSerie() {
			return codSerie;
		}

		public void setCodSerie(String codSerie) {
			this.codSerie = codSerie;
		}

		
		public String getNome() {
			return nome;
		}



		public void setNome(String nome) {
			this.nome = nome;
		}



		public Integer getAno() {
			return ano;
		}

		public void setAno(Integer ano) {
			this.ano = ano;
		}

		public String getApelido() {
			return apelido;
		}

		public void setApelido(String apelido) {
			this.apelido = apelido;
		}
}
