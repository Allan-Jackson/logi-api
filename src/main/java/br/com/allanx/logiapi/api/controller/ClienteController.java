package br.com.allanx.logiapi.api.controller;

import br.com.allanx.logiapi.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @PersistenceContext
    EntityManager manager;

    @GetMapping
    public List<Cliente> listar() {
        return manager.createQuery("from clientes", Cliente.class)
                .getResultList();
    }
}
