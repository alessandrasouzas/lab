package le.com.br.service;

import static org.mockito.ArgumentMatchers.anyString;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import le.com.br.dto.AlunoDto;

public class EscolaServiceTest {
	
	@Mock
	private GerarMatriculaService matriculaService;

	@InjectMocks
	private EscolaService escolaService;
	
	private String retorno;
	
	@BeforeEach
	public void inicializar() {
		MockitoAnnotations.initMocks(this);		
		this.escolaService = new EscolaService(matriculaService);
	}
	

	@Test
	public void deveriaGerarNumeroDeMatricula() {
		
 		AlunoDto aluno = new AlunoDto();
		retorno = "20";
		
		Mockito.when(this.matriculaService.gerarMatricula(anyString())).thenReturn(retorno);
		aluno = this.escolaService.realizarMatricula();

		
		Assert.assertEquals("20", aluno.getMatricula() );
		
		
	}

}
