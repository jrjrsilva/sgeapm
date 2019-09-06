package br.gov.ba.pm.sgeapm.repository.projection;

import br.gov.ba.pm.sgeapm.domain.Aluno;
import br.gov.ba.pm.sgeapm.domain.Serie;
import br.gov.ba.pm.sgeapm.domain.Turma;

public interface MatriculadoTurma {

	Long getId();
	
	Aluno getAluno();
	
	Integer getNumero();
	
	Serie getSerie();
	
	Integer getAno();
	
	Turma getTurma();
}
