package br.com.edivaldo.entity;

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
@Entity
public class Projeto implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome", nullable = false, length = 200)
	private String nome;

	@Column(name = "data_inicio")
	private Date dataInicio;

	@Column(name = "data_previsao_fim")
	private Date dataPrevisaoFim;

	@Column(name = "data_fim")
	private Date dataFim;

	@Column(name = "descricao", length = 500)
	private String descricao;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", length = 45)
	private StatusProjeto status;

	@Column(name = "orcamento")
	private Float orcamento;

	@Enumerated(EnumType.STRING)
	@Column(name = "risco", length = 45)
	private Risco risco;

	@Column(name = "idgerente")
	private Long idGerente;

}
