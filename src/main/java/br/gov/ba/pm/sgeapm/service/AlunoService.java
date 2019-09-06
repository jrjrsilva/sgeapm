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
import br.gov.ba.pm.sgeapm.domain.Aluno;
import br.gov.ba.pm.sgeapm.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;
	@Autowired
	private Datatables datatables;
	@Autowired
	private EmailService emailService;
	
	@Transactional(readOnly = true)
	public Map<String, Object> buscarTodos(HttpServletRequest request) {
		datatables.setRequest(request);
		datatables.setColunas(DatatablesColunas.ALUNOS);
		Page<Aluno> page = datatables.getSearch().isEmpty()
				? repository.findAll(datatables.getPageable())
				: repository.findByAlunoNome(datatables.getSearch(),datatables.getPageable());
		return datatables.getResponse(page);
	}
	
	@Transactional(readOnly = true)
	public Map<String, Object> buscarTodosTurma(HttpServletRequest request,@PathVariable("id") Long id ) {
		datatables.setRequest(request);
		datatables.setColunas(DatatablesColunas.ALUNOS);
		Page<Aluno> page = datatables.getSearch().isEmpty()
				? repository.findAll(datatables.getPageable())
				: repository.findByAlunoNome(datatables.getSearch(),datatables.getPageable());
		return datatables.getResponse(page);
	}

	@Transactional(readOnly = false)
	public void salvar(Aluno aluno) {
		Aluno al = new Aluno();
		if(aluno.hasId()) {
			al = repository.findById(aluno.getId()).get();
		}else {
			al.setId(null);
		}
		al.setAlunoNome((aluno.getAlunoNome().equals("") ? "" : aluno.getAlunoNome().toUpperCase()));
		al.setNomeGuerra((aluno.getNomeGuerra().equals("") ? "" : aluno.getNomeGuerra().toUpperCase()));
		al.setNaturalidade((aluno.getNaturalidade().equals("") ? "" : aluno.getNaturalidade().toUpperCase()));
		al.setMatricula(aluno.getMatricula());
		repository.save(al); 	 	
	}

	@Transactional(readOnly = true)
	public Aluno buscarPorId(Long id) {
		
		return repository.findById(id).get();
	}


	@Transactional(readOnly = false)
	public void remover(Long id) {
		repository.deleteById(id);
	}

	public List<Aluno> findAll() {
		return repository.findAll();
	}
	
	
}
