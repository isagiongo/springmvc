package br.com.isagiongo.springmvc;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import br.com.isagiongo.springmvc.domain.Funcionario;
import br.com.isagiongo.springmvc.validator.FuncionarioValidator;

public class FuncionarioValidatorTest {

	private FuncionarioValidator funcionarioValidator;

	@Before
	public void setUp() {
		Funcionario funcionario = new Funcionario();
		LocalDate dataEntrada = 
	}

	@Test
	public void testDataSaidaNula() {
		funcionarioValidator.validate(object, errors);
	}

	@Test
	public void testDataSaidaMaiorQueDataEntrada() {
	}

	@Test
	public void testDataSaidaMenorQueDataEntrada() {
	}

}
