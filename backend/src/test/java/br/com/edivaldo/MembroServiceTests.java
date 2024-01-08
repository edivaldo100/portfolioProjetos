package br.com.edivaldo;

import br.com.edivaldo.entity.Membro;
import br.com.edivaldo.entity.MembroIdentity;
import br.com.edivaldo.entity.Pessoa;
import br.com.edivaldo.entity.Projeto;
import br.com.edivaldo.enuns.Risco;
import br.com.edivaldo.enuns.StatusProjeto;
import br.com.edivaldo.exception.RestException;
import br.com.edivaldo.repository.MembroRepository;
import br.com.edivaldo.repository.PessoaRepository;
import br.com.edivaldo.repository.ProjetoRepository;
import br.com.edivaldo.service.MembroService;
import br.com.edivaldo.service.PessoaService;
import br.com.edivaldo.service.ProjetoService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MembroServiceTests {
	String nome = "Maria das rosas";
	@Autowired
	private MembroService membroService;
	@Autowired
	private MembroRepository membroRepository;

	@Autowired
	private ProjetoService projetoService;
	@Autowired
	private ProjetoRepository projetoRepository;
	@Autowired
	private PessoaService pessoaService;
	@Autowired
	private PessoaRepository pessoaRepository;
	@Test
	@Order(1)
	void deve_salvar_um_membro() throws RestException {
		String nome = "JAVA PROJETO 1";
		Projeto projeto = new Projeto(1L, nome, new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), "simples projeto", StatusProjeto.EM_ANDAMENTO, 10000F, Risco.ALTO, 2L);
		Projeto pSalvar = projetoService.salvar(projeto).getBody();
		Pessoa p = new Pessoa(1L,nome,new java.sql.Date(Calendar.getInstance().getTime().getTime()),"12345678900",true);
		Pessoa pSalvo = pessoaService.salvar(p);

		Membro m = new Membro(pSalvar.getId(), pSalvo.getId());
		Membro mSalvo = membroService.salvar(m).getBody();
		int size = membroRepository.findAll().size();
		Assertions.assertEquals(1, size);
	}

	@Test
	void deve_Exception_ao_salvar_um_membro_projeto_NAO_existe() throws RestException {

		Pessoa p = new Pessoa(1L,nome,new java.sql.Date(Calendar.getInstance().getTime().getTime()),"12345678900",true);
		Pessoa pSalvo = pessoaService.salvar(p);

		Membro m = new Membro(123L, pSalvo.getId());
		Exception exception = Assertions.assertThrows(RestException.class, () -> {
			membroService.salvar(m);
		});
		String expectedMessage = "Este projeto NÃO existe.";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void deve_Exception_ao_salvar_um_membro_pessoa_NAO_existe() throws RestException {
		String nome = "JAVA PROJETO 1";
		Projeto projeto = new Projeto(1L, nome, new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), "simples projeto", StatusProjeto.EM_ANDAMENTO, 10000F, Risco.ALTO, 2L);
		Projeto pSalvar = projetoService.salvar(projeto).getBody();
		Membro m = new Membro(pSalvar.getId(), 22L);
		Exception exception = Assertions.assertThrows(RestException.class, () -> {
			membroService.salvar(m);
		});
		String expectedMessage = "Este membro NÃO existe.";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void deve_Exception_ao_salvar_um_membro_pessoa_NAO_funcionario() throws RestException {
		String nome = "JAVA PROJETO 1";
		Projeto projeto = new Projeto(1L, nome, new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), "simples projeto", StatusProjeto.EM_ANDAMENTO, 10000F, Risco.ALTO, 2L);
		Projeto pSalvar = projetoService.salvar(projeto).getBody();
		Pessoa p = new Pessoa(1L,nome,new java.sql.Date(Calendar.getInstance().getTime().getTime()),"12345678900",false);
		Pessoa pSalvo = pessoaService.salvar(p);

		Membro m = new Membro(pSalvar.getId(), pSalvo.getId());
		Exception exception = Assertions.assertThrows(RestException.class, () -> {
			membroService.salvar(m);
		});
		String expectedMessage = "Este membro NÃO é um funcionário.";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void deve_listar_membros() throws RestException {
		String nome = "JAVA PROJETO 1";
		Projeto projeto = new Projeto(1L, nome, new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), "simples projeto", StatusProjeto.EM_ANDAMENTO, 10000F, Risco.ALTO, 2L);
		Projeto pSalvar = projetoService.salvar(projeto).getBody();
		Pessoa p = new Pessoa(1L,nome,new java.sql.Date(Calendar.getInstance().getTime().getTime()),"12345678900",true);
		Pessoa pSalvo = pessoaService.salvar(p);
		Membro m = new Membro(pSalvar.getId(), pSalvo.getId());
		Membro mSalvo = membroService.salvar(m).getBody();

		List<Membro> list = (List<Membro>) membroService.listar().getBody();
		int size = membroRepository.findAll().size();
		Assertions.assertEquals(list.size(), size);
	}

	@Test
	void deve_busca_membros_by_id() throws RestException {
		String nome = "JAVA PROJETO 1";
		Projeto projeto = new Projeto(1L, nome, new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), "simples projeto", StatusProjeto.EM_ANDAMENTO, 10000F, Risco.ALTO, 2L);
		Projeto pSalvar = projetoService.salvar(projeto).getBody();
		Pessoa p = new Pessoa(1L,nome,new java.sql.Date(Calendar.getInstance().getTime().getTime()),"12345678900",true);
		Pessoa pSalvo = pessoaService.salvar(p);
		Membro m = new Membro(pSalvar.getId(), pSalvo.getId());
		Membro mSalvo = membroService.salvar(m).getBody();

		MembroIdentity membroIdentity = new MembroIdentity(pSalvar.getId(), pSalvo.getId());
		Optional<Membro> membro = membroService.buscarPorId(membroIdentity);

		Assertions.assertTrue(membro.isPresent());
	}

	@Test
	void deve_eletar_um_membro() throws Exception {
		String nome = "JAVA PROJETO 1";
		Projeto projeto = new Projeto(1L, nome, new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), "simples projeto", StatusProjeto.EM_ANDAMENTO, 10000F, Risco.ALTO, 2L);
		Projeto pSalvar = projetoService.salvar(projeto).getBody();
		Pessoa p = new Pessoa(1L,nome,new java.sql.Date(Calendar.getInstance().getTime().getTime()),"12345678900",true);
		Pessoa pSalvo = pessoaService.salvar(p);

		Membro m = new Membro(pSalvar.getId(), pSalvo.getId());
		Membro mSalvo = membroService.salvar(m).getBody();
		int size = membroRepository.findAll().size();
		membroService.deleteMembro(mSalvo.getIdprojeto(), mSalvo.getIdpessoa());
		int sizeApos = membroRepository.findAll().size();
		Assertions.assertEquals(sizeApos, size-1);
	}
	@Test
	void deve_Exception_ao_deletar_um_membro_nao_localizado() throws Exception {
		String nome = "JAVA PROJETO 1";
		Projeto projeto = new Projeto(1L, nome, new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), "simples projeto", StatusProjeto.EM_ANDAMENTO, 10000F, Risco.ALTO, 2L);
		Projeto pSalvar = projetoService.salvar(projeto).getBody();
		Pessoa p = new Pessoa(1L,nome,new java.sql.Date(Calendar.getInstance().getTime().getTime()),"12345678900",true);
		Pessoa pSalvo = pessoaService.salvar(p);

		Membro m = new Membro(pSalvar.getId(), pSalvo.getId());
		Membro mSalvo = membroService.salvar(m).getBody();



		Exception exception = Assertions.assertThrows(RestException.class, () -> {
			membroService.deleteMembro(mSalvo.getIdprojeto(), mSalvo.getIdpessoa()+1);
		});
		String expectedMessage = "Membro/Projeto NÃO foi localizado.";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));

	}

}
