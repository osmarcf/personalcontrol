package com.preferencebrasil.personalcontrol.controller;

import java.util.List;

import com.preferencebrasil.personalcontrol.model.OrdemDeServico;
import com.preferencebrasil.personalcontrol.service.OrdemDeServicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrdemServicoController {

    @Autowired
    OrdemDeServicoService ordemDeServicoService;

    @GetMapping(value="/mostraros/{id}")
    public ModelAndView getMostrar(@PathVariable Long id) {
        OrdemDeServico ordemDeServico = ordemDeServicoService.findById(id);
        ModelAndView modelAndView = new ModelAndView("mostraros");
        modelAndView.addObject("ordemdeservico", ordemDeServico);
        return modelAndView;
    }

    @PostMapping(value="/mostraros")
    public ModelAndView getMostrarClientes(@PathVariable Long id) {
        OrdemDeServico ordemDeServico = ordemDeServicoService.findById(id);
        ModelAndView modelAndView = new ModelAndView("mostraros");
        modelAndView.addObject("ordemdeservico", ordemDeServico);
        return modelAndView;
    }
    @GetMapping(value="/cadastraros")
    public ModelAndView getCadastrar() {
        //retorna o formulário para o usuário para preencher
        OrdemDeServico ordemDeServico = new OrdemDeServico();
        ModelAndView modelAndView = new ModelAndView("cadastraros");
        modelAndView.addObject("ordemdeservico", ordemDeServico);
        return modelAndView;
    }

    @PostMapping(value="/cadastraros")
    public ModelAndView postCadastrar(OrdemDeServico ordemDeServico) {
        OrdemDeServico ordemServicoSalva = ordemDeServicoService.save(ordemDeServico);
        return getMostrar(ordemServicoSalva.getId());
    }

   // @GetMapping(value="/deletaros/{id}")
   // public String getDeletar(@PathVariable Long id) {
        // deleta a bebida referente ao id
   //     ordemDeServicoService.deleteById(id).get();
   //     return "redirect:/buscaros";
   // }

    @GetMapping(value="/editaros/{id}")
    public ModelAndView getEditar(@PathVariable Long id) {
        OrdemDeServico ordemDeServico = ordemDeServicoService.findById(id);
        ModelAndView modelAndView = new ModelAndView("cadastraros");
        modelAndView.addObject("ordemdeservico", ordemDeServico);
        return modelAndView;
    }
    @GetMapping(value="/buscaros")
    public ModelAndView getListar() {
        List<OrdemDeServico> lista = ordemDeServicoService.findAll();
        ModelAndView modelAndView = new ModelAndView("buscaros");
        modelAndView.addObject("lista", lista);
        return modelAndView;
    }
    
}
