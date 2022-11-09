package br.com.allanx.logiapi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Entrega {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne //faz um mapeamento de N entregas para 1 cliente; por padrão associa esse atributo a um campo "cliente_id"
    @JoinColumn(name = "cliente_id") //possibilita identificar um campo diferente de "cliente_id"
    private Cliente cliente;

    @Embedded //separa os campos em uma classe diferente, mas pertencentes a mesma tabela no banco de dados
    private Destinatario destinatario;


    private BigDecimal taxa;

    @Enumerated(EnumType.STRING)
    private StatusEntrega status;


    private LocalDateTime dataPedido;
    private LocalDateTime dataFinalizacao;
}
