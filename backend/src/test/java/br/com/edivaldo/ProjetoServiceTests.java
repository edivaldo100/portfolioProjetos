package br.com.edivaldo;

import br.com.edivaldo.dtos.ProjetoDto;
import br.com.edivaldo.entity.Projeto;
import br.com.edivaldo.enuns.Risco;
import br.com.edivaldo.enuns.StatusProjeto;
import br.com.edivaldo.exception.RestException;
import br.com.edivaldo.repository.PessoaRepository;
import br.com.edivaldo.repository.ProjetoRepository;
import br.com.edivaldo.service.ProjetoService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProjetoServiceTests {

	@Autowired
	private ProjetoService projetoService;
	@Autowired
	private ProjetoRepository projetoRepository;
	@Test
	@Order(1)
	void deve_salvar_um_projeto(){
		String nome = "JAVA PROJETO 1";
		Projeto projeto = new Projeto(1L, nome, new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), "simples projeto", StatusProjeto.EM_ANDAMENTO, 10000F, Risco.ALTO, 2L);
		ResponseEntity<Projeto> salvar = projetoService.salvar(projeto);

		int size = projetoRepository.findAll().size();
		String nomeReturn = projetoRepository.findById(salvar.getBody().getId()).get().getNome();

		Assertions.assertEquals(1, size);
		Assertions.assertEquals(nome, nomeReturn);
	}
	@Test
	void deve_listar_os_projetos(){
		String nome = "JAVA PROJETO 1";
		Projeto projeto = new Projeto(1L, nome, new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), "simples projeto", StatusProjeto.EM_ANDAMENTO, 10000F, Risco.ALTO, 2L);
		ResponseEntity<Projeto> salvar = projetoService.salvar(projeto);
		Projeto projeto2 = new Projeto(2L, nome, new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), "simples projeto", StatusProjeto.EM_ANDAMENTO, 10000F, Risco.ALTO, 2L);
		projetoService.salvar(projeto2);

		ResponseEntity<Object> lista = projetoService.listar();
		List<ProjetoDto> listaDto = (List<ProjetoDto>) lista.getBody();
		int size = projetoRepository.findAll().size();
		Assertions.assertEquals(listaDto.size(), size);
	}

	@Test
	void deve_buscar_Por_Id_o_projeto() throws RestException {
		String nome = "JAVA PROJETO 1";
		Projeto projeto = new Projeto(1L, nome, new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), "simples projeto", StatusProjeto.EM_ANDAMENTO, 10000F, Risco.ALTO, 2L);
		ResponseEntity<Projeto> salvar = projetoService.salvar(projeto);
		Projeto projeto2 = new Projeto(2L, nome, new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), "simples projeto", StatusProjeto.EM_ANDAMENTO, 10000F, Risco.ALTO, 2L);
		projetoService.salvar(projeto2);
		ResponseEntity<Object> objectResponseEntity = projetoService.buscarProjeto(salvar.getBody().getId());
		int status = objectResponseEntity.getStatusCodeValue();
		Assertions.assertEquals(status, 200);
	}

	@Test
	void deve_atuailzar_o_projeto() throws RestException {
		String nome = "JAVA PROJETO 1";
		Projeto projeto = new Projeto(1L, nome, new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), "simples projeto", StatusProjeto.EM_ANDAMENTO, 10000F, Risco.ALTO, 2L);
		ResponseEntity<Projeto> salvar = projetoService.salvar(projeto);
		Projeto body = salvar.getBody();
		if(body != null){
			body.setNome("ANGULAR PROJETO 1");
			ResponseEntity<Object> atualizar = projetoService.atualizar(body.getId(), body);
			int statusCodeValue = atualizar.getStatusCodeValue();
			Assertions.assertEquals(statusCodeValue, 200);
		}
	}

	@Test
	void deve_deletar_um_projeto_em_andamento() throws RestException {
		String nome = "JAVA PROJETO 1";
		Projeto projeto = new Projeto(1L, nome, new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), "simples projeto", StatusProjeto.ANALISE_REALIZADA, 10000F, Risco.ALTO, 2L);
		ResponseEntity<Projeto> salvar = projetoService.salvar(projeto);
		Projeto projeto2 = new Projeto(2L, nome, new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), "simples projeto", StatusProjeto.ANALISE_REALIZADA, 10000F, Risco.ALTO, 2L);
		projetoService.salvar(projeto2);
		int size = projetoRepository.findAll().size();
		projetoService.deleteProjeto(salvar.getBody().getId());
		int sizePos = projetoRepository.findAll().size();
		Assertions.assertEquals(sizePos, size -1);
	}
	@Test
	void deve_exception_ao_deletar_um_projeto_em_andamento() {
		String nome = "JAVA PROJETO 1";
		Projeto projeto = new Projeto(1L, nome, new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), "simples projeto", StatusProjeto.EM_ANDAMENTO, 10000F, Risco.ALTO, 2L);
		ResponseEntity<Projeto> salvar = projetoService.salvar(projeto);
		Projeto projeto2 = new Projeto(2L, nome, new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), "simples projeto", StatusProjeto.EM_ANDAMENTO, 10000F, Risco.ALTO, 2L);
		projetoService.salvar(projeto2);

		Exception exception = Assertions.assertThrows(RestException.class, () -> {
			projetoService.deleteProjeto(projeto.getId());
		});
		String expectedMessage = "O Projeto NÃO pode ser excluído, pois se encontra com status [ em andamento ]";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void deve_exception_ao_deletar_um_projeto_em_Iniciado() {
		String nome = "JAVA PROJETO 1";
		Projeto projeto = new Projeto(1L, nome, new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), "simples projeto", StatusProjeto.INICIADO, 10000F, Risco.ALTO, 2L);
		ResponseEntity<Projeto> salvar = projetoService.salvar(projeto);
		Projeto projeto2 = new Projeto(2L, nome, new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), "simples projeto", StatusProjeto.INICIADO, 10000F, Risco.ALTO, 2L);
		projetoService.salvar(projeto2);

		Exception exception = Assertions.assertThrows(RestException.class, () -> {
			projetoService.deleteProjeto(projeto.getId());
		});
		String expectedMessage = "O Projeto NÃO pode ser excluído, pois se encontra com status [ iniciado ]";
		String actualMessage = exception.getMessage();
		assertNotNull(exception);
	}

	@Test
	void deve_exception_ao_deletar_um_projeto_em_Encerrado() {
		String nome = "JAVA PROJETO 1";
		Projeto projeto = new Projeto(1L, nome, new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), "simples projeto", StatusProjeto.ENCERRADO, 10000F, Risco.ALTO, 2L);
		ResponseEntity<Projeto> salvar = projetoService.salvar(projeto);
		Projeto projeto2 = new Projeto(2L, nome, new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), new java.sql.Date(Calendar.getInstance().getTime().getTime()), "simples projeto", StatusProjeto.ENCERRADO, 10000F, Risco.ALTO, 2L);
		projetoService.salvar(projeto2);

		Exception exception = Assertions.assertThrows(RestException.class, () -> {
			projetoService.deleteProjeto(projeto.getId());
		});
		String expectedMessage = "O Projeto NÃO pode ser excluído, pois se encontra com status [ encerrado ]";
		String actualMessage = exception.getMessage();
		assertNotNull(exception);
	}

}
