package br.gov.ba.pm.sgeapm.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.gov.ba.pm.sgeapm.domain.Agendamento;
import br.gov.ba.pm.sgeapm.domain.Horario;
import br.gov.ba.pm.sgeapm.repository.projection.HistoricoPaciente;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{

	@Query("select h "
			+ "from Horario h "
			+ "where not exists("
				+ "select a.horario.id "
					+ "from Agendamento a "
					+ "where "
						+ "a.medico.id = :id and "
						+ "a.dataConsulta = :data and "
						+ "a.horario.id = h.id "
			+ ") "
			+ "order by h.horaMinuto asc")
	List<Horario> findByMedicoIdAndDataNotHorarioAgendado(@Param("id")Long id,@Param("data") LocalDate data);

	@Query("select a.id as id,"
				+ "a.paciente as paciente,"
				+ "CONCAT(a.dataConsulta, ' ', a.horario.horaMinuto) as dataConsulta,"
				+ "a.medico as medico,"
				+ "a.especialidade as especialidade "
			+ "from Agendamento a "
			+ "where a.paciente.usuario.email like :email")
	Page<HistoricoPaciente> findHistoricoByPacienteEmail(@Param("email")String email, Pageable pageable);

	@Query("select a.id as id,"
			+ "a.paciente as paciente,"
			+ "CONCAT(a.dataConsulta, ' ', a.horario.horaMinuto) as dataConsulta,"
			+ "a.medico as medico,"
			+ "a.especialidade as especialidade "
		+ "from Agendamento a "
		+ "where a.medico.usuario.email like :email")	
	Page<HistoricoPaciente> findHistoricoByMedicoEmail(@Param("email")String email, Pageable pageable);

	@Query("select a from Agendamento a "
			+ "where "
			+ "	(a.id = :id AND a.paciente.usuario.email like :email) "
			+ " OR "
			+ " (a.id = :id AND a.medico.usuario.email like :email)")
	Optional<Agendamento> findByIdAndPacienteOrMedicoEmail(@Param("id")Long id,@Param("email") String email);

}
