package br.com.isagiongo.springmvc.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.isagiongo.springmvc.dao.FuncionarioDao;
import br.com.isagiongo.springmvc.domain.Funcionario;

@Service
@Transactional
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioDao funcionarioDao;
	
	@Override
	public void salvar(Funcionario funcionario) {
		funcionarioDao.save(funcionario);
	}

	@Override
	public void editar(Funcionario funcionario) {
		funcionarioDao.update(funcionario);
	}

	@Override
	public void deletar(Long id) {
		funcionarioDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Funcionario buscarPorId(Long id) {
		return funcionarioDao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Funcionario> buscarTodos() {
		return funcionarioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Funcionario> buscarPorNome(String nome) {
		return funcionarioDao.findByNome(nome);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Funcionario> buscarPorCargo(Long id) {
		return funcionarioDao.findByCargoId(id);
	}

	@Override
	@Transactional(readOnly = true)
    public List<Funcionario> buscarPorDatas(LocalDate entrada, LocalDate saida) {
	    if (entrada != null && saida != null) {	    	
            return funcionarioDao.findByDataEntradaDataSaida(entrada, saida);
        } else if (entrada != null) {        	
	        return funcionarioDao.findByDataEntrada(entrada);
        } else if (saida != null) {        	
	        return funcionarioDao.findByDataSaida(saida);
        } else {
        	return new ArrayList<>();
        }
    }

}
