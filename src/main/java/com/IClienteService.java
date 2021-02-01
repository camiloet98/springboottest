package com;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

public interface IClienteService {
	public List<Cliente> listar();
	public Optional<Cliente> listarId(int id);
	public int insertar(Cliente c);
	public void modificar(Cliente c);
	public void eliminar(Integer id);
	public void delete(int id);
}
