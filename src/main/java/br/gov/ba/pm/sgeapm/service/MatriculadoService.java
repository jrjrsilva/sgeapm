package br.gov.ba.pm.sgeapm.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import br.gov.ba.pm.sgeapm.datatables.Datatables;
import br.gov.ba.pm.sgeapm.datatables.DatatablesColunas;
import br.gov.ba.pm.sgeapm.domain.Matriculado;
import br.gov.ba.pm.sgeapm.repository.MatriculadoRepository;
import br.gov.ba.pm.sgeapm.repository.projection.MatriculadoTurma;

@Service
public class MatriculadoService {

	@Autowired
	private MatriculadoRepository repository;
	@Autowired
	private Datatables datatables;
	@Autowired
	private EmailService emailService;
	
	@Transactional(readOnly = true)
	public Map<String, Object> findAllMatriculados(HttpServletRequest request) {
		datatables.setRequest(request);
		datatables.setColunas(DatatablesColunas.MATRICULADOS);
		Page<MatriculadoTurma> page = datatables.getSearch().isEmpty()
				? repository.findAllMatriculados(datatables.getPageable())
				: repository.findByMatriculadoNome(datatables.getSearch(),datatables.getPageable());
		return datatables.getResponse(page);
	}
	
	/*@Transactional(readOnly = true)
	public Map<String, Object> buscarTodosTurma(HttpServletRequest request,@PathVariable("id") Long id ) {
		datatables.setRequest(request);
		datatables.setColunas(DatatablesColunas.ALUNOS);
		Page<MatriculadoTurma> page = datatables.getSearch().isEmpty()
				? repository.findAll(datatables.getPageable())
				: repository.findByMatriculadoNome(datatables.getSearch(),datatables.getPageable());
		return datatables.getResponse(page);
	}*/

	
	@Transactional(readOnly = false)
	public void salvar(Matriculado matriculado) {
	/*	Matriculado al = new Matriculado();
		if(matriculado.hasId()) {
			al = repository.findById(matriculado.getId()).get();
		}else {
			al.setId(null);
		}
		al.setMatriculadoNome((matriculado.getMatriculadoNome().equals("") ? "" : matriculado.getMatriculadoNome().toUpperCase()));
		al.setNomeGuerra((matriculado.getNomeGuerra().equals("") ? "" : matriculado.getNomeGuerra().toUpperCase()));
		al.setNaturalidade((matriculado.getNaturalidade().equals("") ? "" : matriculado.getNaturalidade().toUpperCase()));
		al.setMatricula(matriculado.getMatricula());
		repository.save(al);*/ 	 	
	}

	@Transactional(readOnly = true)
	public Matriculado buscarPorId(Long id) {
		
		return repository.findById(id).get();
	}


	@Transactional(readOnly = false)
	public void remover(Long id) {
		repository.deleteById(id);
	}

	public List<Matriculado> findAll() {
		return repository.findAll();
	}
	
	
}
