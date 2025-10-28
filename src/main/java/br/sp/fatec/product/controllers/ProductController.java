package br.sp.fatec.product.controllers; //pacote onde a classe está localizada

import org.springframework.web.bind.annotation.RequestMapping; //importa a anotação RequestMapping
import org.springframework.web.bind.annotation.RestController; //importa a anotação RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.sp.fatec.product.entities.Product;//importa a classe Product
import br.sp.fatec.product.services.ProductService;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping; //importa a anotação GetMapping 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController // indica que a classe é um controlador REST
@RequestMapping("/products") // products sempre no plural e em minúsculo

public class ProductController { // declaração da classe ProductController

    @Autowired
    private ProductService service;

    @GetMapping // mapeia o método HTTP GET
    public ResponseEntity<List<Product>> getProducts() { // declaração do método getAllProducts
        return ResponseEntity.ok(service.getProducts()); // chama o método getProducts() do serviço
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id) {
        return ResponseEntity.ok(service.getProductById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable long id) {
        service.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping // mapeia o método HTTP POST
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) { // declaração do método saveProduct
        Product newProduct = service.saveProduct(product);

        URI location = ServletUriComponentsBuilder // constrói a URI do novo recurso criado
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newProduct.getId())
                .toUri();
        return ResponseEntity.created(location) // retorna o status 201 Created
                .body(newProduct); // retorna o novo produto criado no corpo da resposta
    }

}
