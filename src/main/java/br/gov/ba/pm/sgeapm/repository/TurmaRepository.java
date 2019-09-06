package br.gov.ba.pm.sgeapm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.gov.ba.pm.sgeapm.domain.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long>{

	@Query("select t, t.serie as serie from Turma t order by t.ano desc")
	Page<Turma> findByAll(Pageable pageable);
	
	@Query("select t from Turma t order by t.ano desc")
	Page<Turma> findAll(Pageable pageable);
	
	@Query("select t, t.serie from Turma t where t.ano = :search ")
	Page<Turma> findBySerie(@Param("search") String search, Pageable pageable);
	
}