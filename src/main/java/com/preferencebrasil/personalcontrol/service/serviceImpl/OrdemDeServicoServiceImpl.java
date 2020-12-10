package com.preferencebrasil.personalcontrol.service.serviceImpl;

import java.util.List;

import com.preferencebrasil.personalcontrol.model.OrdemDeServico;
import com.preferencebrasil.personalcontrol.repository.OrdemDeServicoRepository;
import com.preferencebrasil.personalcontrol.service.OrdemDeServicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdemDeServicoServiceImpl implements OrdemDeServicoService {

    @Autowired
    OrdemDeServicoRepository ordemDeServicoRepository;



    @Override
    public List<OrdemDeServico> findAll() {
        return ordemDeServicoRepository.findAll();
    }

    @Override
    public OrdemDeServico findById(long id) {
        return ordemDeServicoRepository.findById(id).get();
    }

    @Override
    public OrdemDeServico save(OrdemDeServico ordemdeservico) {
        return ordemDeServicoRepository.save(ordemdeservico);
    }
    
}
