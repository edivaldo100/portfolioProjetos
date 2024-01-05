package br.com.edivaldo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edivaldo.entity.Pessoa;
import br.com.edivaldo.entity.Projeto;
import br.com.edivaldo.repository.PessoaRepository;
import br.com.edivaldo.repository.ProjetoRepository;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository repository;

	public Projeto salvar(Projeto p) {
		return repository.save(p);
	}

	public List<Projeto> listar() {
		return repository.findAll();
	}

	public Optional<Projeto> buscarPorId(Long id) {
		return repository.findById(id);
	}

	public void removerPorId(Long id) {
		repository.deleteById(id);
	}
}
