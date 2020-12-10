package com.preferencebrasil.personalcontrol.repository;

import java.util.List;

import com.preferencebrasil.personalcontrol.model.OrdemDeServico;

import org.springframework.data.repository.CrudRepository;

public interface OrdemDeServicoRepository extends CrudRepository<OrdemDeServico, Long> {
    List<OrdemDeServico> findByNomeClienteContainingIgnoreCase(String nomeCliente);
    List<OrdemDeServico> findAll();
}
