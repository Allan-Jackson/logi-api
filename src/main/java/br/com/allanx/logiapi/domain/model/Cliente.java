package br.com.allanx.logiapi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank //cannot be null or empty
    @Size(max = 60) //define max size of String
    private String nome;

    @NotBlank
    @Email //uses hibernate email validation implementation
    @Size(max = 255)
    private String email;

    @NotBlank
    @Size(max = 20)
    private String telefone;
}
