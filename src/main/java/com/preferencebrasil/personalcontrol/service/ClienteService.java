package com.preferencebrasil.personalcontrol.service;

import java.util.List;

import com.preferencebrasil.personalcontrol.model.Cliente;

public interface ClienteService {
    List<Cliente> findAll();
    Cliente findById(long id);
    Cliente save(Cliente cliente);
    Cliente findBynomeClienteContainingIgnoreCase(Cliente nomeCliente);
    
}
