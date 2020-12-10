package com.preferencebrasil.personalcontrol.repository;

import java.util.List;

import com.preferencebrasil.personalcontrol.model.Cliente;

import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    List<Cliente> findByNomeClienteContainingIgnoreCase(Cliente nomeCliente);
    List<Cliente> findAll();
}
