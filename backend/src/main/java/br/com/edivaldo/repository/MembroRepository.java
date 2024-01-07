package br.com.edivaldo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.edivaldo.entity.Membro;
import br.com.edivaldo.entity.MembroIdentity;

public interface MembroRepository extends JpaRepository<Membro, MembroIdentity> {
}
