package br.com.edivaldo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "membros")
@IdClass(MembroIdentity.class)
public class Membro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private Long idprojeto;

	@Id
	@Column
	private Long idpessoa;

}
