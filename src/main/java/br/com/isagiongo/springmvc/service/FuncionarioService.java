package br.com.isagiongo.springmvc.service;

import java.util.List;

import br.com.isagiongo.springmvc.domain.Funcionario;

public interface FuncionarioService {

	void salvar(Funcionario funcionario);
	
	void editar(Funcionario funcionario);
	
	void deletar(Long id);
	
	Funcionario buscarPorId(Long id);
	
	List<Funcionario> buscarTodos();
}
