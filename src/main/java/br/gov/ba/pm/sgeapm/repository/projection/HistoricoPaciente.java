package br.gov.ba.pm.sgeapm.repository.projection;

import br.gov.ba.pm.sgeapm.domain.Especialidade;
import br.gov.ba.pm.sgeapm.domain.Medico;
import br.gov.ba.pm.sgeapm.domain.Paciente;

public interface HistoricoPaciente {

	Long getId();
	
	Paciente getPaciente();
	
	String getDataConsulta();
	
	Medico getMedico();
	
	Especialidade getEspecialidade();
}
