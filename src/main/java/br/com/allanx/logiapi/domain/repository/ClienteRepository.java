package br.com.allanx.logiapi.domain.repository;

import br.com.allanx.logiapi.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
