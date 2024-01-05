package br.com.edivaldo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Pessoa implements Serializable {

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
