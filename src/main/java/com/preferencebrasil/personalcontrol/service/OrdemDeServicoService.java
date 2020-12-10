package com.preferencebrasil.personalcontrol.service;

import java.util.List;

import com.preferencebrasil.personalcontrol.model.OrdemDeServico;

public interface OrdemDeServicoService {

    List<OrdemDeServico> findAll();
    OrdemDeServico findById(long id);
    OrdemDeServico save(OrdemDeServico ordemdeservico);
    
}
