package br.com.edivaldo.dtos;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.edivaldo.enuns.Risco;
import br.com.edivaldo.enuns.StatusProjeto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjetoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;

	private Date dataInicio;

	private Date dataPrevisaoFim;

	private Date dataFim;

	private String descricao;

	private StatusProjeto status;

	private Float orcamento;

	private Risco risco;

	private Long idGerente;

}
