package br.com.allanx.logiapi.domain.service;

import br.com.allanx.logiapi.domain.exception.NegocioException;
import br.com.allanx.logiapi.domain.model.Cliente;
import br.com.allanx.logiapi.domain.model.Entrega;
import br.com.allanx.logiapi.domain.model.StatusEntrega;
import br.com.allanx.logiapi.domain.repository.ClienteRepository;
import br.com.allanx.logiapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

    private EntregaRepository entregaRepository;
    private ClienteRepository clienteRepository;

    @Transactional
    public Entrega solicitar(Entrega entrega) {
        //verify if cliente exists by id
        Cliente cliente = clienteRepository.findById(entrega.getCliente().getId())
                            .orElseThrow(
                                () -> new NegocioException
                                        ("Cliente não encontrado.")
                            );
        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());
        return entregaRepository.save(entrega);
    }
}
