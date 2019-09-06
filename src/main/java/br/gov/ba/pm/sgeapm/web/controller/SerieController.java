package br.gov.ba.pm.sgeapm.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.gov.ba.pm.sgeapm.domain.Serie;
import br.gov.ba.pm.sgeapm.service.SerieService;

@Controller
@RequestMapping("series")
public class SerieController {
	
	@Autowired
	private SerieService service;

	@GetMapping({"", "/"})
	public String abrir(Serie serie) {
		return "serie/serie";
	}
	
	@PostMapping("/salvar")
	public String salvar(Serie serie, RedirectAttributes attr) {
		service.salvar(serie);
		attr.addFlashAttribute("sucesso", "Operação realizada com sucesso!");
		return "redirect:/series";
	}
	
	@GetMapping("/datatables/server")
	public ResponseEntity<?> getSeries(HttpServletRequest request) {
		return ResponseEntity.ok(service.buscarSeries(request));
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("serie", service.buscarPorId(id));
		return "serie/serie";
	}
	
	@GetMapping("/excluir/{id}")
	public String abrir(@PathVariable("id") Long id, RedirectAttributes attr) {
		service.remover(id);
		attr.addFlashAttribute("sucesso", "Operação realizada com sucesso.");
		return "redirect:/series";
	}
	

}
