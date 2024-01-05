package br.com.edivaldo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.edivaldo.entity.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
