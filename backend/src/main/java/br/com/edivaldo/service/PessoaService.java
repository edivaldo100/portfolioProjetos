package br.com.edivaldo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edivaldo.entity.Pessoa;
import br.com.edivaldo.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	public Pessoa salvar(Pessoa p) {
		return repository.save(p);
	}

	public List<Pessoa> listar() {
		return repository.findAll();
	}

	public Optional<Pessoa> buscarPorId(Long id) {
		return repository.findById(id);
	}

	public void removerPorId(Long id) {
		repository.deleteById(id);
	}

	public List<Pessoa> listaPessoaFuncionarios() {
		return repository.findAll().stream().filter(p -> p.isFuncionario()).collect(Collectors.toList());
	}
}
