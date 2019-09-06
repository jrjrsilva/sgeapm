package br.gov.ba.pm.sgeapm.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.gov.ba.pm.sgeapm.domain.Matriculado;
import br.gov.ba.pm.sgeapm.service.MatriculadoService;

@Controller
@RequestMapping("matriculados")
public class MatriculadoController {
	
	@Autowired
	private MatriculadoService service;
	
    // abrir cadastro
    @GetMapping("/cadastro")
    public String cadastroNovo(Matriculado matriculado) {
        return "matriculado/cadastro";
    }
    
    // abrir lista
    @GetMapping("/lista")
    public String listar() {
        return "matriculado/lista";
    }  

    // listar usuarios na datatables
    @GetMapping("/datatables/server")
    public ResponseEntity<?> listarDatatables(HttpServletRequest request) {
        return ResponseEntity.ok(service.findAllMatriculados(request));
    } 
    
   /*@GetMapping("/datatables/server/{id}")
    public ResponseEntity<?> listarDatatablesTurma(HttpServletRequest request) {
        return ResponseEntity.ok(service.findAllMatriculados(request));
    } 
    */
    
    // salvar cadastro de usuarios por administrador
    @PostMapping("/salvar")
    public String salvar(Matriculado matriculado, RedirectAttributes attr) {
   		try {
    	service.salvar(matriculado);
    	attr.addFlashAttribute("sucesso", "Operação realizada com sucesso.");
		attr.addFlashAttribute("matriculado", matriculado);
   		}catch (DataIntegrityViolationException ex) {
			attr.addFlashAttribute("falha", "Matrícula já cadastrada.");
		}
    	return "redirect:/matriculados/cadastro";
    }
    
    
    @GetMapping("/editar/{id}")
    public ModelAndView preEditar(@PathVariable("id") Long id) {
        return new ModelAndView("matriculado/cadastro", "matriculado", service.buscarPorId(id));
    }
    
    @GetMapping("/excluir/{id}")
	public String abrir(@PathVariable("id") Long id, RedirectAttributes attr) {
		service.remover(id);
		attr.addFlashAttribute("sucesso", "Operação realizada com sucesso.");
		return "redirect:/matriculados/lista";
	}
}
