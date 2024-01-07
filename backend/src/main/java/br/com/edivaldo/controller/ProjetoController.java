package br.com.edivaldo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edivaldo.entity.Projeto;
import br.com.edivaldo.exception.RestException;
import br.com.edivaldo.service.ProjetoService;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

	@Autowired
	private ProjetoService projetoService;

	@PostMapping
	public ResponseEntity<Projeto> salvar(@RequestBody Projeto p) {
		return projetoService.salvar(p);
	}

	@GetMapping
	public ResponseEntity<Object> listar() {
		return projetoService.listar();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") Long id) throws RestException {
		return projetoService.buscarProjeto(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> remover(@PathVariable("id") Long id) throws RestException {
		return projetoService.deleteProjeto(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> atualizar(@PathVariable("id") Long id, @RequestBody Projeto p) throws RestException {
		return projetoService.atualizar(id, p);
	}

}
