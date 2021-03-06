package br.com.crescer.aula7.tema.controller;

import br.com.crescer.aula7.tema.entity.Cliente;
import br.com.crescer.aula7.tema.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Barizon
 */
@RestController
@RequestMapping("/cliente")
public class ClienteRest {
    @Autowired
    private ClienteService clienteService; 
    
    @GetMapping("/{id}")
    public Cliente findOne(@PathVariable("id") Long id) {
        return clienteService.loadById(id);
    }
    
    @GetMapping("/cpf/{cpf}")
    public Cliente findOne(@PathVariable("cpf") String cpf) {
        return clienteService.loadByCpf(cpf);
    }

    @ResponseBody
    @GetMapping
    public List<Cliente> findAll() {
        return clienteService.findAll();
    }
    
    @PostMapping("/save")
    public Cliente save(@RequestBody Cliente c){
        return clienteService.save(c);
    }
    
    @PostMapping("/remove")
    public void remove(@RequestBody Cliente c){
        clienteService.remove(c);
    }
    
    
    
}
