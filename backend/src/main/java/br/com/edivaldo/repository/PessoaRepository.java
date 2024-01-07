package br.com.edivaldo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.edivaldo.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
