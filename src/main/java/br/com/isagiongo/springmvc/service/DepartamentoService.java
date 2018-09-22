package br.com.isagiongo.springmvc.service;

import java.util.List;

import br.com.isagiongo.springmvc.domain.Departamento;

public interface DepartamentoService {

	void salvar(Departamento departamento);

	void editar(Departamento departamento);

	void deletar(Long id);

	Departamento buscarPorId(Long id);

	List<Departamento> buscarTodos();

	boolean departamentoTemCargo(Long id);
}
