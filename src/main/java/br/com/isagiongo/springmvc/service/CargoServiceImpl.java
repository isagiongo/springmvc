package br.com.isagiongo.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.isagiongo.springmvc.dao.CargoDao;
import br.com.isagiongo.springmvc.domain.Cargo;

@Service
@Transactional(readOnly=false)
public class CargoServiceImpl implements CargoService {

	@Autowired
	private CargoDao cargoDao;
	
	@Override
	public void salvar(Cargo cargo) {
		cargoDao.save(cargo);
	}

	@Override
	public void editar(Cargo cargo) {
		cargoDao.update(cargo);
	}

	@Override
	public void deletar(Long id) {
		cargoDao.delete(id);
		
	}

	@Override 
	@Transactional(readOnly = true)
	public Cargo buscarPorId(Long id) {
		return cargoDao.findById(id);
	}

	@Override 
	@Transactional(readOnly = true)
	public List<Cargo> buscarTodos() {
		return cargoDao.findAll();
	}

}
