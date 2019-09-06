package br.gov.ba.pm.sgeapm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.gov.ba.pm.sgeapm.domain.Serie;

public interface SerieRepository extends JpaRepository<Serie, Long>{

	@Query("select s from Serie s where s.nome like :search% or s.apelido like :search%")
	Page<Serie> findBySerieOrApelido(@Param("search") String search, Pageable pageable);

}
