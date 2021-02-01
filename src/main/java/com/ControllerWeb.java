package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

import javax.validation.*;

@Controller
public class ControllerWeb {
	
	@Autowired
	public ControllerWeb(IClienteService iclienteservice) {
		this.repo = iclienteservice;
	}
	
	private IClienteService repo;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Cliente>clientes=repo.listar();
		model.addAttribute("clientes",clientes);
		return "index";
	}
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "crearcliente";
	}
	@PostMapping("/save")
	public String save(@Valid Cliente c, Model model) {
		repo.insertar(c);
		return "redirect:/listar";
	}
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Cliente>cliente=repo.listarId(id);
		model.addAttribute("cliente",cliente);
		return "crearcliente";
	}
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id, Model model) {
		repo.delete(id);
		return "redirect:/listar";
	}
	@GetMapping("/visualizar/{id}")
	public String visualizar(@PathVariable int id, Model model) {
		Optional<Cliente>cliente=repo.listarId(id);
		model.addAttribute("clientep",cliente);
		return "visualizar";
	}
	
}
