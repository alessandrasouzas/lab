package le.com.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import le.com.br.dto.AlunoDto;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EscolaService {
	
	private GerarMatriculaService gerar;
	
	@Autowired
	public EscolaService(GerarMatriculaService gerar) {
		this.gerar = gerar;
	}
	
	public AlunoDto realizarMatricula() {
	
		AlunoDto aluno = new AlunoDto();
		aluno.setNome("Bruno");
		aluno.setDocumento("0123");
		
		String resultMatricula = gerar.gerarMatricula(aluno.getNome());
		aluno.setMatricula(resultMatricula);
		
		log.info("realizada a matricula: {} para {}", aluno.getNome(), aluno.getMatricula());
		return aluno;
	}
	
	public void atualizarMatricula() {
		
		log.info("atualizada a matricula");
	}
	
}