package br.com.isagiongo.springmvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.isagiongo.springmvc.domain.Departamento;
import br.com.isagiongo.springmvc.service.DepartamentoService;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

	@Autowired
	private DepartamentoService departamentoService;

	@GetMapping("/cadastrar")
	public String cadastrar(Departamento departamento) {
		return "departamento/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("departamentos", departamentoService.buscarTodos());
		return "departamento/lista";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Departamento departamento, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "departamento/cadastro";
		}
		departamentoService.salvar(departamento);
		attr.addFlashAttribute("success","Departamento incluído com sucesso!");
		return "redirect:/departamentos/cadastrar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("departamento", departamentoService.buscarPorId(id));
		return "departamento/cadastro";
	}

	@PostMapping("/editar")
	public String editar(@Valid Departamento departamento, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "departamento/cadastro";
		}
		departamentoService.editar(departamento);
		attr.addFlashAttribute("success","Departamento alterado com sucesso!");
		return "redirect:/departamentos/listar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		if (departamentoService.departamentoTemCargo(id)) {
			model.addAttribute("fail", "Departamento não pode ser excluído. Possui cargos vinculados.");
		} else {
			departamentoService.deletar(id);
			model.addAttribute("success", "Departamento excluído com sucesso!");
		}
		return listar(model);
	}
}
