package br.com.edivaldo.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.edivaldo.entity.Projeto;
import br.com.edivaldo.enuns.StatusProjeto;
import br.com.edivaldo.exception.AppError;
import br.com.edivaldo.exception.RestException;
import br.com.edivaldo.repository.ProjetoRepository;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository repository;
	@Autowired
	private ModelMapper modelMapper;

	public ResponseEntity<Projeto> salvar(Projeto p) {
		// return repository.save(p);
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(p));
	}

	public ResponseEntity<Object> listar() {
		List<Projeto> lista = repository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

	public Optional<Projeto> buscarPorId(Long id) {
		return repository.findById(id);
	}

	public ResponseEntity<Object> buscarProjeto(Long id) throws RestException {

		Optional<Projeto> p = buscarPorId(id);
		if (p.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(p);
		} else {
			throw new RestException("O Projeto NÃO foi localizado.");
		}
	}

	public ResponseEntity<Object> atualizar(Long id, Projeto p) throws RestException {

		buscarPorId(id).map(pBase -> {
			modelMapper.map(p, pBase);
			salvar(pBase);
			return Void.TYPE;
		}).orElseThrow(() -> new RestException("Projeto não encontrado."));

		return ResponseEntity.status(HttpStatus.OK).body(responseApp(200, "Projeto atualizado com sucesso!"));
	}

	public ResponseEntity<Object> deleteProjeto(Long id) throws RestException {

		Optional<Projeto> p = buscarPorId(id);
		if (p.isPresent()) {
			if (StatusProjeto.podeDeletar(p.get().getStatus())) {
				removerPorId(p.get().getId());
			} else {
				throw new RestException("O Projeto NÃO pode ser excluído, pois se encontra com status [ "
						+ p.get().getStatus().getDescricao() + " ]");
			}
		} else {
			throw new RestException("O Projeto NÃO foi localizado.");
		}

		return ResponseEntity.status(HttpStatus.OK).body(responseApp(200, "Projeto excluido com sucesso!"));
	}

	public void removerPorId(Long id) {
		repository.deleteById(id);
	}

	private AppError responseApp(int codigo, String msg) {
		return new AppError(codigo, msg);
	}
}
