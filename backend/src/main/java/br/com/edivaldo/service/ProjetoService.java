package br.com.edivaldo.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.edivaldo.dtos.ProjetoDto;
import br.com.edivaldo.entity.Projeto;
import br.com.edivaldo.enuns.StatusProjeto;
import br.com.edivaldo.exception.AppError;
import br.com.edivaldo.exception.RestException;
import br.com.edivaldo.mappers.ProjetosMapper;
import br.com.edivaldo.repository.ProjetoRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjetoService {

	@Autowired
	private ProjetoRepository repository;
	@Autowired
	private ModelMapper modelMapper;
	//@Autowired
	//private ProjetosMapper projetoMapper;// = Mappers.getMapper(ProjetosMapper.class);

	public ResponseEntity<Projeto> salvar(Projeto p) {
		Projeto projeto = repository.save(p);
		return ResponseEntity.created(URI.create("/projetos/" +projeto.getId())).body(projeto);
	}

	public ResponseEntity<Object> listar() {
		List<Projeto> lista = repository.findAll();
		//List<ProjetoDto> projetoDtos = projetoMapper.toProjetoDtos(lista);
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
	
	public ProjetoDto criarProjetoDto(ProjetoDto rojetoDto) {
		return rojetoDto;
	}
}
