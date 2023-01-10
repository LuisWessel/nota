package com.example.nota.resources;

import com.example.nota.models.Nota;
import com.example.nota.repository.NotaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Classe API REST e vai receber a requisições http.
@RequestMapping(value = "/nota") // URI Padrão para a API
public class NotaResources {
    final // para utilizar os métodos para se conectar com o Banco de Dados.
    NotaRepository notaRepository;

    public NotaResources(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    @GetMapping("/") // Método que lista todos os produtos salvos no Banco de Dados
    public List<Nota> listaNotas() {
        return notaRepository.findAll();// Retorno

    }

    @GetMapping("/{id}") // Lista um único produto pelo código do Id = (1, 2, 3 ... )
    public Nota listaNota(@PathVariable(value = "id") long id) {
        Nota nota = notaRepository.findById(id); // pesquisa feita pelo Id.
        return nota;// Retorna a nota
    }

    @PostMapping("/") // Recebe um produto para salvar - O Produto vem no corpo da requisição. @RequestBody
    public Nota salvaNota(@RequestBody Nota cadastronota) {
        return notaRepository.save(cadastronota);// Retorna uma nota cadastrada que foi salva
    }

    @PutMapping("/")
    public Nota atualizaNota(@RequestBody Nota nota) {
        return notaRepository.save(nota);
    }

    @DeleteMapping("/")
    public void deletaNota(@RequestBody Nota nota) {
        notaRepository.delete(nota);
    }
}
