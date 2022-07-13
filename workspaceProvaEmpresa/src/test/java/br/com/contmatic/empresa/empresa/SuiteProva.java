package br.com.contmatic.empresa.empresa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({EmpresaTest.class, FuncionarioTest.class, DepartamentoTest.class,
    ContatoTest.class, CelularTest.class, CidadeTest.class, 
    UfTest.class, EnderecoTest.class, AuditoriaTest.class })
public class SuiteProva {

}
