package br.com.edivaldo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.edivaldo.entity.Membro;
import br.com.edivaldo.entity.MembroIdentity;
import br.com.edivaldo.entity.Pessoa;
import br.com.edivaldo.entity.Projeto;
import br.com.edivaldo.exception.AppError;
import br.com.edivaldo.exception.RestException;
import br.com.edivaldo.repository.MembroRepository;

@Service
public class MembroService {

	@Autowired
	private MembroRepository repository;
	
	@Autowired
	private ProjetoService projetoService;
	
	@Autowired
	private PessoaService pessoaService;
	
	public ResponseEntity<Membro> salvar(Membro m) throws RestException {
		Optional<Pessoa> pessoa = pessoaService.buscarPorId(m.getIdpessoa());
		Optional<Projeto> projeto = projetoService.buscarPorId(m.getIdprojeto());
		
		if(!projeto.isPresent()) {
			throw new RestException("Este projeto NÃO existe.");
		}
		if(!pessoa.isPresent()) {
			throw new RestException("Este membro NÃO existe.");
		}
		
		if(pessoa.isPresent() && projeto.isPresent()) {
			if(pessoa.get().isFuncionario()) {
				return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(m));
			}else {
				throw new RestException("Este membro NÃO é um funcionário.");
			}
		}
		throw new RestException("Verifique os parametros informaos!");
	}
	
	public ResponseEntity<Object> listar() {
		List<Membro> lista = repository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
	
	public Optional<Membro> buscarPorId(MembroIdentity id) {
		return repository.findById(id);
	}

	public void removerPorId(MembroIdentity id) {
		repository.deleteById(id);
	}

	public ResponseEntity<Object> buscarProjeto(Long idprojeto, Long idpesoa) throws RestException {
		Optional<Membro> buscarPorId = buscarPorId(new MembroIdentity(idprojeto, idpesoa));
		
		if(buscarPorId.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(buscarPorId);
		}else {
			throw new RestException("Membro/Projeto NÃO foi localizado.");
		}
		
	}

	public ResponseEntity<Object> deleteMembro(Long idprojeto, Long idpessoa) throws Exception {
		MembroIdentity membroIdentity = new MembroIdentity(idprojeto, idpessoa);
		Optional<Membro> buscarPorId = buscarPorId(membroIdentity);
		
		if(buscarPorId.isPresent()) {
			try {
				removerPorId(membroIdentity);
			}catch (Exception e) {
				throw new Exception();
			}
			return ResponseEntity.status(HttpStatus.OK).body(responseApp(200, "Membro excluido com sucesso!"));
		}else {
			throw new RestException("Membro/Projeto NÃO foi localizado.");
		}
	}
	
	private AppError responseApp(int codigo, String msg) {
		return new AppError(codigo, msg);
	}
}
