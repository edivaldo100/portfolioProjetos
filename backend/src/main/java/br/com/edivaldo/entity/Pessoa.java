package br.com.edivaldo.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Pessoa implements Serializable {

        /**
	 * 
	 */
		private static final long serialVersionUID = 1L;

		@Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(name = "nome", nullable = false, length = 100)
        private String nome;

        @Column(name = "datanascimento")
        private Date datanascimento;

        @Column(name = "cpf", length = 14)
        private String cpf;
        
        @Column(name = "funcionario")
        private boolean funcionario;

}
