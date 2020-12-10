package com.preferencebrasil.personalcontrol.controller;

import java.util.List;

import com.preferencebrasil.personalcontrol.model.Cliente;
import com.preferencebrasil.personalcontrol.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping(value="/mostrarclientes/{id}")
    public ModelAndView getMostrar(@PathVariable Long id) {
        Cliente cliente = clienteService.findById(id);
        ModelAndView modelAndView = new ModelAndView("mostrarclientes");
        modelAndView.addObject("cliente", cliente);
        return modelAndView;
    }

    @PostMapping(value="/mostrarclientes")
    public ModelAndView getMostrarClientes(@PathVariable Long id) {
        Cliente cliente = clienteService.findById(id);
        ModelAndView modelAndView = new ModelAndView("mostrarclientes");
        modelAndView.addObject("cliente", cliente);
        return modelAndView;
    }



    @GetMapping(value="/cadastrarclientes")
    public ModelAndView getCadastrar() {
        Cliente cliente = new Cliente();
        ModelAndView modelAndView = new ModelAndView("cadastrarclientes");
        modelAndView.addObject("cliente", cliente);
        return modelAndView;
    }

    @PostMapping(value="/cadastrarclientes")
    public ModelAndView postCadastrar(Cliente cliente) {
        Cliente clienteSalvo = clienteService.save(cliente);
        return getMostrar(clienteSalvo.getId());
    }

    
    @GetMapping(value="/editarcliente/{id}")
    public ModelAndView getEditar(@PathVariable Long id) {
        Cliente cliente = clienteService.findById(id);
        ModelAndView modelAndView = new ModelAndView("cadastrarclientes");
        modelAndView.addObject("cliente", cliente);
        return modelAndView;
    }
    @GetMapping(value="/buscarclientes")
    public ModelAndView getListar() {
        List<Cliente> lista = clienteService.findAll();
        ModelAndView modelAndView = new ModelAndView("buscarclientes");
        modelAndView.addObject("lista", lista);
        return modelAndView;
    }
    
    
    
}
