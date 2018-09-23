package br.com.isagiongo.springmvc.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.isagiongo.springmvc.domain.Cargo;
import br.com.isagiongo.springmvc.service.CargoService;

@Component
public class StringParaCargoConverter implements Converter<String, Cargo>{

	@Autowired
	private CargoService cargoService;
	
	@Override
	public Cargo convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return cargoService.buscarPorId(id);
	}

}
