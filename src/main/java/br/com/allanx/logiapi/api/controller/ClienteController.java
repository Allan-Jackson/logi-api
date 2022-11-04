package br.com.allanx.logiapi.api.controller;

import br.com.allanx.logiapi.domain.model.Cliente;
import br.com.allanx.logiapi.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor //Lombok generates the constructor using all class fields (ClienteRepository)
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteRepository repository;

    @GetMapping
    public List<Cliente> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable(name = "id") Long clienteId) {
        Optional<Cliente> cliente = repository.findById(clienteId);
        if(cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable("id") Long clienteId, @RequestBody Cliente cliente) {
        if(repository.existsById(clienteId)) {
            cliente.setId(clienteId);
            return ResponseEntity.ok(repository.save(cliente));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> remover(@PathVariable("id") Long clienteId) {
        if(repository.existsById(clienteId)) {
            repository.deleteById(clienteId);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
