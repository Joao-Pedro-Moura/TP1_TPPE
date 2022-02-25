package tst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.DescricaoEmBrancoException;
import app.NomeEmBrancoException;
import app.SimuladorIRPF;
import app.ValorDeducaoInvalidoException;
import app.ValorRendimentoInvalidoException;

public class BaseDeCalculo {
	private SimuladorIRPF simulador;
	
	@Before
	public void setup() {
		simulador = new SimuladorIRPF();
	}
	

	@Test
	public void testeBaseDeCalculo() throws DescricaoEmBrancoException, ValorDeducaoInvalidoException, ValorRendimentoInvalidoException, NomeEmBrancoException {
		simulador.cadastrarRendimento("Salario", 10000f);
		simulador.cadastrarDeducao("Previdencia Privada", 500f);
		simulador.cadastrarDeducao("Funpresp", 200f);
		simulador.cadastrarContribuicaoPrevidenciaria("INSS", 800f);
		simulador.cadastrarContribuicaoPrevidenciaria("Contracheque", 700f);
		simulador.cadastrarPensaoAlimenticia(300f);
		simulador.cadastrarPensaoAlimenticia(120.82f);
		simulador.cadastrarDependente("joao", 170698f);
		simulador.cadastrarDependente("Marcos", 260898f);
		assertEquals(7000f, simulador.getBaseDeCalculo(), 0.1f);
	}


}
