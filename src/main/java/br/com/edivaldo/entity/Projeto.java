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
public class Projeto implements Serializable {

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
        
        @Column(name = "status", length = 45)
        private String status;
        
        @Column(name = "orcamento")
        private Float orcamento;
        
        @Column(name = "risco", length = 45)
        private String risco;
        
        @Column(name = "idgerente")
        private Long idGerente;

}
