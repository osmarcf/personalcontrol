package com.preferencebrasil.personalcontrol.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import com.preferencebrasil.personalcontrol.model.Cliente;
import com.preferencebrasil.personalcontrol.model.OrdemDeServico;
import com.preferencebrasil.personalcontrol.model.Role;
import com.preferencebrasil.personalcontrol.model.User;
import com.preferencebrasil.personalcontrol.repository.ClienteRepository;
import com.preferencebrasil.personalcontrol.repository.OrdemDeServicoRepository;
import com.preferencebrasil.personalcontrol.repository.RoleRepository;
import com.preferencebrasil.personalcontrol.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DummyData {

    @Autowired
    OrdemDeServicoRepository ordemDeServicoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostConstruct
    public void saveUser() {
        Role role = new Role();
        role.setId(1);
        role.setRole("ADMIN");
        roleRepository.save(role);

        Set<Role> roles = new HashSet<Role>();
        roles.add(role);

        User user = new User();
        user.setActive(true);
        user.setName("name");
        user.setUserName("username");
        user.setLastName("lastname");
        user.setEmail("email@email.com");
        user.setPassword(bCryptPasswordEncoder.encode("12345"));
        user.setRoles(roles);
        userRepository.save(user);
    }

    //@PostConstruct
    public void saveClientes(){
        List<Cliente> clienteList = new ArrayList<>();
        Cliente cliente1 = new Cliente();
        cliente1.setNomeCliente("Rudi");
        cliente1.setTelefoneCliente("48484848");
        cliente1.setEmailCliente("rudi@meusovos.com.br");

        Cliente cliente2 = new Cliente();
        cliente2.setNomeCliente("Nei");
        cliente2.setTelefoneCliente("48484848");
        cliente2.setEmailCliente("nei@meusovos.com.br");
        

        clienteList.add(cliente1);
        clienteList.add(cliente2);

        for(Cliente cliente: clienteList) {
            Cliente clienteSaved = clienteRepository.save(cliente);
            System.out.println(clienteSaved.getId());
        }

    }

    //@PostConstruct
    public void saveOrdemDeServico(){
        List<OrdemDeServico> ordemDeServicoList = new ArrayList<>();
        OrdemDeServico ordemdeservico1 = new OrdemDeServico();
        ordemdeservico1.setNomeCliente("Rudi");
        ordemdeservico1.setDataInicio(LocalDate.now());
        ordemdeservico1.setDataFim(LocalDate.now());
        ordemdeservico1.setDescricaoServico("Mussum Ipsum, cacilds vidis litro abertis. Paisis, filhis, espiritis santis. Viva Forevis aptent taciti sociosqu ad litora torquent. Per aumento de cachacis, eu reclamis. Nec orci ornare consequat. Praesent lacinia ultrices consectetur. Sed non ipsum felis.");
        
        OrdemDeServico ordemdeservico2 = new OrdemDeServico();
        ordemdeservico2.setNomeCliente("Nei");
        ordemdeservico2.setDataInicio(LocalDate.now());
        ordemdeservico2.setDataFim(LocalDate.now());
        ordemdeservico2.setDescricaoServico("Suco de cevadiss, é um leite divinis, qui tem lupuliz, matis, aguis e fermentis. Mais vale um bebadis conhecidiss, que um alcoolatra anonimis. Detraxit consequat et quo num tendi nada. In elementis mé pra quem é amistosis quis leo.");
        

        ordemDeServicoList.add(ordemdeservico1);
        ordemDeServicoList.add(ordemdeservico2);

        for(OrdemDeServico ordemdeservico: ordemDeServicoList) {
            OrdemDeServico ordemdeservicoSaved = ordemDeServicoRepository.save(ordemdeservico);
            System.out.println(ordemdeservicoSaved.getId());
        }

    }






    
}
