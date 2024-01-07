package br.com.edivaldo.mappers;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import br.com.edivaldo.dtos.ProjetoDto;
import br.com.edivaldo.entity.Projeto;
import br.com.edivaldo.service.ProjetoService;

@Mapper(uses = ProjetoService.class, injectionStrategy = InjectionStrategy.FIELD, componentModel = "spring")
public interface ProjetosMapper {

	Projeto toProjeto(ProjetoDto projetoDto);

	ProjetoDto toProjetoDto(Projeto projeto);

	List<ProjetoDto> toProjetoDtos(List<Projeto> projetos);
}
