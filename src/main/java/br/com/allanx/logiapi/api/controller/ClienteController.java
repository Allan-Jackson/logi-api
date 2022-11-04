package br.com.allanx.logiapi.api.controller;

import br.com.allanx.logiapi.domain.model.Cliente;
import br.com.allanx.logiapi.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@AllArgsConstructor //Lombok generates the constructor using all class fields (ClienteRepository)
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteRepository repository;

    @GetMapping
    public List<Cliente> listar() {
        return repository.findAll();
    }
}
