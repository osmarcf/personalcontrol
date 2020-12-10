package com.preferencebrasil.personalcontrol.service.serviceImpl;

import java.util.List;

import com.preferencebrasil.personalcontrol.model.Cliente;
import com.preferencebrasil.personalcontrol.repository.ClienteRepository;
import com.preferencebrasil.personalcontrol.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;



    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(long id) {
        return clienteRepository.findById(id).get();
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente findBynomeClienteContainingIgnoreCase(Cliente nomeCliente) {
       return (Cliente) clienteRepository.findByNomeClienteContainingIgnoreCase(nomeCliente);
    }

    

    
    
}
