package br.com.edivaldo;

import br.com.edivaldo.dtos.ProjetoDto;
import br.com.edivaldo.entity.Pessoa;
import br.com.edivaldo.entity.Projeto;
import br.com.edivaldo.enuns.Risco;
import br.com.edivaldo.enuns.StatusProjeto;
import br.com.edivaldo.exception.RestException;
import br.com.edivaldo.repository.PessoaRepository;
import br.com.edivaldo.repository.ProjetoRepository;
import br.com.edivaldo.service.PessoaService;
import br.com.edivaldo.service.ProjetoService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.Column;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PessoaServiceTests {
	String nome = "Maria das rosas";
	@Autowired
	private PessoaService pessoaService;
	@Autowired
	private PessoaRepository pessoaRepository;
	@Test
	@Order(1)
	void deve_salvar_uma_pessoa(){
		Pessoa p = new Pessoa(1L,nome,new java.sql.Date(Calendar.getInstance().getTime().getTime()),"12345678900",true);
		int size = pessoaRepository.findAll().size();
		Pessoa pSalvo = pessoaService.salvar(p);
		Assertions.assertNotNull(pSalvo);
	}
	@Test
	void deve_listar_pessoas(){

		Pessoa p = new Pessoa(1L,nome,new java.sql.Date(Calendar.getInstance().getTime().getTime()),"12345678900",true);
		Pessoa pSalvo = pessoaService.salvar(p);
		Pessoa p2 = new Pessoa(2L,nome,new java.sql.Date(Calendar.getInstance().getTime().getTime()),"12345678900",true);
		Pessoa pSalvo2 = pessoaService.salvar(p2);
		List<Pessoa> pessoas = pessoaService.listar();
		int size = pessoaRepository.findAll().size();
		Assertions.assertEquals(pessoas.size(), size);
	}

	@Test
	void deve_buscar_Por_Id_a_pessoa() throws RestException {
		Pessoa p = new Pessoa(1L,nome,new java.sql.Date(Calendar.getInstance().getTime().getTime()),"12345678900",true);
		Pessoa pSalvo = pessoaService.salvar(p);
		Pessoa p2 = new Pessoa(2L,nome,new java.sql.Date(Calendar.getInstance().getTime().getTime()),"12345678900",true);
		Pessoa pSalvo2 = pessoaService.salvar(p2);
		Optional<Pessoa> pOptional = pessoaService.buscarPorId(pSalvo2.getId());
		Assertions.assertTrue(pOptional.isPresent());
	}

	@Test
	void deve_deletar_um_projeto_em_andamento() throws RestException {
		Pessoa p = new Pessoa(1L,nome,new java.sql.Date(Calendar.getInstance().getTime().getTime()),"12345678900",true);
		Pessoa pSalvo = pessoaService.salvar(p);
		Pessoa p2 = new Pessoa(2L,nome,new java.sql.Date(Calendar.getInstance().getTime().getTime()),"12345678900",true);
		Pessoa pSalvo2 = pessoaService.salvar(p2);
		int size = pessoaService.listar().size();
		if(pSalvo != null){
			pessoaService.removerPorId(pSalvo.getId());
		}

		int sizePos = pessoaService.listar().size();
		Assertions.assertEquals(sizePos, size-1);
	}
}
