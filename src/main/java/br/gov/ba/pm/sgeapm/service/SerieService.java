package br.gov.ba.pm.sgeapm.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.ba.pm.sgeapm.datatables.Datatables;
import br.gov.ba.pm.sgeapm.datatables.DatatablesColunas;
import br.gov.ba.pm.sgeapm.domain.Serie;
import br.gov.ba.pm.sgeapm.repository.SerieRepository;

@Service
public class SerieService {

	@Autowired
	private SerieRepository repository;
	@Autowired
	private Datatables datatables;

	@Transactional(readOnly = false)
	public void salvar(Serie serie) {
		
		repository.save(serie);
	}

	@Transactional(readOnly = true)
	public Map<String, Object> buscarSeries(HttpServletRequest request) {
		datatables.setRequest(request);
		datatables.setColunas(DatatablesColunas.SERIES);
		Page<?> page = datatables.getSearch().isEmpty()
				? repository.findAll(datatables.getPageable())
				: repository.findBySerieOrApelido(datatables.getSearch(), datatables.getPageable());
		return datatables.getResponse(page);
	}

	@Transactional(readOnly = true)
	public Serie buscarPorId(Long id) {
		
		return repository.findById(id).get();
	}

	@Transactional(readOnly = false)
	public void remover(Long id) {	
		repository.deleteById(id);
	}

	public Object buscarTodos() {
		return repository.findAll();
	}

		
}
