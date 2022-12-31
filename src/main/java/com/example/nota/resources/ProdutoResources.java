package com.example.nota.resources;

import com.example.nota.models.Produto;
import com.example.nota.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoResources {
    final
    ProdutoRepository produtoRepository;

    public ProdutoResources(ProdutoRepository produtoRepository){ this.produtoRepository = produtoRepository;}

    @GetMapping("/")
    public List<Produto> listaProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Produto listaProduto(@PathVariable(value = "id") long id){
        Produto produto =  produtoRepository.findById(id);
        return produto; }

    @PostMapping("/")
    public Produto salvaProduto(@RequestBody Produto cadastroProduto){
        return produtoRepository.save(cadastroProduto); }

    @PutMapping("/")
    public Produto atualizaProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/")
    public void deletaProduto(@RequestBody Produto produto){
        produtoRepository.delete(produto);
    }
}
