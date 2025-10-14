package br.sp.fatec.product.controllers; //pacote onde a classe está localizada

import org.springframework.web.bind.annotation.RequestMapping; //importa a anotação RequestMapping
import org.springframework.web.bind.annotation.RestController; //importa a anotação RestController
import br.sp.fatec.product.entities.Product;//importa a classe Product
import jakarta.persistence.EntityNotFoundException;

import java.util.ArrayList;//importa a classe ArrayList
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping; //importa a anotação GetMapping 
import org.springframework.web.bind.annotation.PathVariable;


@RestController //indica que a classe é um controlador REST
@RequestMapping("/products") //products sempre no plural e em minúsculo

public class ProductController { //classe controladora sempre terá o nome da classe

     private ArrayList<Product> list = new ArrayList<Product>(); //lista de produtos para simular um banco de dados

        public ProductController() {
        list.add(new Product(1L, "product 1", "description 1", 100.0)); //adiciona produtos na lista
        list.add(new Product(2L, "product 2", "description 2", 200.0)); //adiciona produtos na lista
        list.add(new Product(3L, "product 3", "description 3", 300.0)); //adiciona produtos na lista

    }

    @GetMapping //mapeia o método HTTP GET
    public List<Product> getAllProducts() { //método que retorna todos os produtos
        return list; //retorna a lista de produtos
    }

    @GetMapping("{id}") //mapeia o método HTTP GET com parâmetro id
    public Product getProductById(@PathVariable long id) { //método que retorna um produto pelo id
        return list.stream() //stream serve para percorrer a lista de produtos
                 .filter( p -> p.getId() == id) //filtra o produto pelo id, comparando o id do produto com o id passado
                 .findFirst() //retorna o primeiro produto encontrado
                 .orElseThrow( () -> new EntityNotFoundException("Não cadastrado")); //se não encontrar, coloca uma mensagem de erro
    }

}

