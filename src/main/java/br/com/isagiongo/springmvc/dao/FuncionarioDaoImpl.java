package br.com.isagiongo.springmvc.dao;

import org.springframework.stereotype.Repository;

import br.com.isagiongo.springmvc.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

}
