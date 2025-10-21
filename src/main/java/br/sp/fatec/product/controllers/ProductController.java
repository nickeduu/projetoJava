package br.sp.fatec.product.controllers; //pacote onde a classe está localizada

import org.springframework.web.bind.annotation.RequestMapping; //importa a anotação RequestMapping
import org.springframework.web.bind.annotation.RestController; //importa a anotação RestController
import br.sp.fatec.product.entities.Product;//importa a classe Product
import br.sp.fatec.product.repositories.ProductRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping; //importa a anotação GetMapping 


@RestController //indica que a classe é um controlador REST
@RequestMapping("/products") //products sempre no plural e em minúsculo

public class ProductController { //declaração da classe ProductController

    @Autowired
    private ProductRepository repository;
    
    @GetMapping //mapeia o método HTTP GET
    public List<Product> getAllProducts() { //método que retorna todos os produtos
        return repository.findAll(); //retorna a lista de produtos
    }

}

