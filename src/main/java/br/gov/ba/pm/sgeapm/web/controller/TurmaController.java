package br.gov.ba.pm.sgeapm.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.gov.ba.pm.sgeapm.domain.Turma;
import br.gov.ba.pm.sgeapm.service.AlunoService;
import br.gov.ba.pm.sgeapm.service.SerieService;
import br.gov.ba.pm.sgeapm.service.TurmaService;

@Controller
@RequestMapping("turmas")
public class TurmaController {
	
	@Autowired
	private TurmaService service;
	
	@Autowired
	private SerieService serieService;
	
	@Autowired
	private AlunoService alunoService;
	
    // abrir cadastro
    @GetMapping("/cadastro")
    public String cadastroNovo(Turma turma, ModelMap model) {
    	model.addAttribute("series", serieService.buscarTodos());
        return "turma/cadastro";
    }
        
    // abrir lista
    @GetMapping("/lista")
    public String listar() {
        return "turma/lista";
    }  

    // listar na datatables
    @GetMapping("/datatables/server")
    public ResponseEntity<?> listarDatatables(HttpServletRequest request) {
        return ResponseEntity.ok(service.buscarTodos(request));
    } 
    
    // salvar cadastro
    @PostMapping("/salvar")
    public String salvar(Turma turma, RedirectAttributes attr) {
   		try {
   			service.salvar(turma);
   			attr.addFlashAttribute("sucesso", "Operação realizada com sucesso.");
   			attr.addFlashAttribute("turma", turma);
   		}catch (DataIntegrityViolationException ex) {
			attr.addFlashAttribute("falha", "Turma já cadastrada.");
		}
    	return "redirect:/turmas/cadastro";
    }
    
    
    @GetMapping("/editar/{id}")
    public ModelAndView preEditar(@PathVariable("id") Long id) {
    	ModelAndView mv = new ModelAndView("turma/cadastro");
    	mv.addObject("turma", service.buscarPorId(id));
    	mv.addObject("series",serieService.buscarTodos());
        return mv ;
    }
    
    @GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		service.remover(id);
		attr.addFlashAttribute("sucesso", "Operação realizada com sucesso.");
		return "redirect:/turmas/lista";
	}
    
    @GetMapping("/matriculados/{id}")
    public ModelAndView preMatricular(@PathVariable("id") Long id) {
    	ModelAndView mv = new ModelAndView("turma/matricula");
    	mv.addObject("turma", service.buscarPorId(id));
    	//mv.addObject("series",alunoService.findAll());
        return mv ;
    }
}
