package com.example.nota.resources;

import com.example.nota.models.Cliente;
import com.example.nota.repository.ClienteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Classe API REST e vai receber a requisições http.
@RequestMapping(value = "/cliente") // URI Padrão para a API
public class ClienteResources {

    final // para utilizar os métodos para se conectar com o Banco de Dados.
    ClienteRepository clienteRepository;

    public ClienteResources(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/") // Método que lista todos os clientes salvos no Banco de Dados
    public List<Cliente> listaClientes() {
        return clienteRepository.findAll();// Retorno
        //http://localhost:8080/cliente/  link da pagina Web.
    }

    @GetMapping("/{id}") // Lista um único cliente pelo código do Id = (1, 2, 3 ... )
    public Cliente listaclienteUnico(@PathVariable(value = "id") long id) {
        return clienteRepository.findById(id);// Retorna a pesquisa feita pelo Id.
        //http://localhost:8080/cliente/1  link da pagina Web.
    }

    @PostMapping("/") // Recebe um produto para salvar - O Produto vem no corpo da requisição. @RequestBody
    public Cliente salvaCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);// Retorna uma nota cadastrada que foi salva
        //http://localhost:8080/cliente/
    }

    @PutMapping("/")
    public Cliente atualizaCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);// Retorna uma nota cadastrada que foi salva
        //http://localhost:8080/cliente/
    }

    @DeleteMapping("/")
    public void deletaCliente(@RequestBody Cliente cliente) {
        clienteRepository.delete(cliente);
        //http://localhost:8080/cliente/
    }
}
