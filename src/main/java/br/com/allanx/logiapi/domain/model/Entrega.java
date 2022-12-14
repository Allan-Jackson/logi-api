package br.com.allanx.logiapi.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "entregas")
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne //faz um mapeamento de N entregas para 1 cliente; por padrão associa esse atributo a um campo "cliente_id"
    @JoinColumn(name = "cliente_id") //possibilita identificar um campo diferente de "cliente_id"
    private Cliente cliente;

    @Embedded //separa os campos em uma classe diferente, mas pertencentes a mesma tabela no banco de dados
    private Destinatario destinatario;

    private BigDecimal taxa;

    @Enumerated(EnumType.STRING)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private StatusEntrega status;

    //avoid client to pass value to this property (it must be set by the application)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dataPedido;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dataFinalizacao;
}





