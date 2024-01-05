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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.edivaldo.entity.Membro;
import br.com.edivaldo.entity.Projeto;
import br.com.edivaldo.exception.RestException;
import br.com.edivaldo.service.MembroService;
import br.com.edivaldo.service.ProjetoService;

@RestController
@RequestMapping("/membro")
public class MembroController {

	@Autowired
	private MembroService membroService;

	@PostMapping
	public ResponseEntity<Membro> salvar(@RequestBody Membro m) throws RestException {
		return membroService.salvar(m);
	}

	@GetMapping
	public ResponseEntity<Object> listar() {
		return membroService.listar();
	}
//
//	@GetMapping()
//	public ResponseEntity<Object> buscarPorId(
//			@RequestParam("idprojeto") Long idprojeto, 
//			@RequestParam("idpessoa") Long idpessoa) throws RestException {
//		return membroService.buscarProjeto(idprojeto, idpessoa);
//	}
	
	@DeleteMapping("/{idprojeto}/{idpessoa}")
	public ResponseEntity<Object> remover(
			@PathVariable("idprojeto") Long idprojeto,
			@PathVariable("idpessoa") Long idpessoa) throws Exception {
		return membroService.deleteMembro(idprojeto, idpessoa);
	}
//
//	@PutMapping("/{id}")
//	public ResponseEntity<Object> atualizar(@PathVariable("id") Long id, @RequestBody Projeto p) throws RestException {
//		return membroService.atualizar(id, p);
//	}

}
