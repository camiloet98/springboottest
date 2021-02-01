package com.camilo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class RestClientController implements IClienteService{
	
	@Autowired
	private IClienteRepository repositorio;
	
	@GetMapping
	public List<Cliente> listar(){
		return (List<Cliente>) repositorio.findAll();
	}
	
	@PostMapping
	public int insertar(@RequestBody Cliente c) {
		int res=0;
		Cliente cl = repositorio.save(c);
		if(!cl.equals(null)) res=1;
		return res;
	}
	
	@PutMapping
	public void modificar(@RequestBody Cliente c) {
		repositorio.save(c);
	}
	
	@DeleteMapping
	@RequestMapping(value="/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		repositorio.deleteById(id);
	}
	
	public void delete(int id) {
		repositorio.deleteById(id);
	}

	@Override
	public Optional<Cliente> listarId(int id) {
		return repositorio.findById(id);
	}
}
