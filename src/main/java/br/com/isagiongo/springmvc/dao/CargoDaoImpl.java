package br.com.isagiongo.springmvc.dao;

import org.springframework.stereotype.Repository;

import br.com.isagiongo.springmvc.domain.Cargo;

@Repository
public class CargoDaoImpl extends AbstractDao<Cargo, Long> implements CargoDao {

}
