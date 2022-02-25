package tst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.DescricaoEmBrancoException;
import app.NomeEmBrancoException;
import app.SimuladorIRPF;
import app.ValorDeducaoInvalidoException;

public class TotalTodasDeducoes {
	
	private SimuladorIRPF simulador;
	
	@Before
	public void setup() {
		simulador = new SimuladorIRPF();
	}

	@Test
	public void testeTotalDeducoes() throws DescricaoEmBrancoException, ValorDeducaoInvalidoException, NomeEmBrancoException {
		simulador.cadastrarDeducao("Previdencia Privada", 500f);
		simulador.cadastrarDeducao("Funpresp", 200f);
		simulador.cadastrarContribuicaoPrevidenciaria("INSS", 1500f);
		simulador.cadastrarContribuicaoPrevidenciaria("Contracheque", 700f);
		simulador.cadastrarPensaoAlimenticia(300f);
		simulador.cadastrarPensaoAlimenticia(100f);
		simulador.cadastrarDependente("joao", 170698f);
		simulador.cadastrarDependente("Marcos", 260898f);
		assertEquals(3000f, simulador.getTotalTodasDeducoes(), 0.1f);
	}

}
