package br.com.allanx.logiapi.api.controller;

import br.com.allanx.logiapi.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @GetMapping
    public List<Cliente> listar() {
        var cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setEmail("joao.example@mail.com");
        cliente1.setTelefone("11 9999-9999");
        cliente1.setNome("Joãozin Examplão");

        var cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setEmail("maria.example@mail.com");
        cliente2.setTelefone("11 9899-9999");
        cliente2.setNome("Maria Examplão");

        return List.of(cliente1, cliente2);
    }
}
