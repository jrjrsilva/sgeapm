package br.gov.ba.pm.sgeapm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.gov.ba.pm.sgeapm.domain.Matriculado;
import br.gov.ba.pm.sgeapm.repository.projection.MatriculadoTurma;

public interface MatriculadoRepository extends JpaRepository<Matriculado, Long>{

	
	@Query("select m.id as id, m.ano as ano , m.numero as numero, "
			+ "m.aluno as aluno,"
			+ "m.serie as serie,"
			+ "m.turma as turma "
			+ "from Matriculado m "
			+ "where m.aluno.alunoNome like :search% ")
	Page<MatriculadoTurma> findByMatriculadoNome(@Param("search") String search, Pageable pageable);
	
	@Query("select m.id as id ,m.ano as ano , m.numero as numero,"
			+ "m.aluno as aluno,"
			+ "m.serie as serie,"
			+ "m.turma as turma "
			+ "from Matriculado m ")
	Page<MatriculadoTurma> findAllMatriculados(Pageable pageable);

}
