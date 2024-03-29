package br.gov.ba.pm.sgeapm.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.gov.ba.pm.sgeapm.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("select u from Usuario u where u.email like :email")
	Usuario findByEmail(@Param("email") String email);

	@Query("select distinct u from Usuario u "
			+ "join u.perfis p "
			+ "where u.email like :search% OR p.desc like :search%") 
	Page<Usuario> findByEmailOrPerfil(@Param("search")String search, Pageable pageable);

	@Query("select u from Usuario u "
			+ "join u.perfis p "
			+ "where u.id = :usuarioId AND p.id IN :perfisId") 
	Optional<Usuario> findByIdAndPerfis(@Param("usuarioId")Long usuarioId,@Param("perfisId") Long[] perfisId);

	@Query("select u from Usuario u where u.email like :email AND u.ativo = true")
	Optional<Usuario> findByEmailAndAtivo(@Param("email")String email);
}
