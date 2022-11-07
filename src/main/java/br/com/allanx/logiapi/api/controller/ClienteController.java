package br.com.allanx.logiapi.api.controller;

import br.com.allanx.logiapi.domain.model.Cliente;
import br.com.allanx.logiapi.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
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
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
        return repository.save(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable("id") Long clienteId, @RequestBody Cliente cliente) {
        if(!repository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }
        cliente.setId(clienteId);
        return ResponseEntity.ok(repository.save(cliente));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> remover(@PathVariable("id") Long clienteId) {
        if(!repository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(clienteId);
        return ResponseEntity.noContent().build();
    }
}
