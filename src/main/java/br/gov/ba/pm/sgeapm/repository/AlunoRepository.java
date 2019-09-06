package br.gov.ba.pm.sgeapm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.gov.ba.pm.sgeapm.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	Page<Aluno> findByCurso(Pageable pageable);

	Page<Aluno> findByAlunoNome(Pageable pageable);

	@Query("select a from Aluno a where a.alunoNome like :search% ")
	Page<Aluno> findByAlunoNome(@Param("search") String search, Pageable pageable);
	
	@Query("select a from Aluno a where a.alunoNome like :search% or matricula like :search%")
	Page<Aluno> findByAlunoNomeOrMatricula(@Param("search") String search, Pageable pageable);
	
	@Query("select a from Aluno a where a.alunoNome = :id ")
	Page<Aluno> findAllTurma(@Param("id") Long id, Pageable pageable);

}
