package br.sp.fatec.product.controllers; //pacote onde a classe está localizada

import org.springframework.web.bind.annotation.RequestMapping; //importa a anotação RequestMapping
import org.springframework.web.bind.annotation.RestController; //importa a anotação RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.sp.fatec.product.dtos.ProductRequest;
import br.sp.fatec.product.dtos.ProductResponse;
import br.sp.fatec.product.services.ProductService;
import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping; //importa a anotação GetMapping 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController // indica que a classe é um controlador REST
@RequestMapping("/products") // products sempre no plural e em minúsculo

public class ProductController { // declaração da classe ProductController

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProducts() {
        return ResponseEntity.ok(service.getProducts());
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable long id) { //Serviço de busca de produto por id
        return ResponseEntity.ok(service.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<ProductResponse> saveProduct(@Valid @RequestBody ProductRequest request) { //Serviço de criação de produto
        ProductResponse response = service.saveProduct(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.id())
                .toUri();

        return ResponseEntity.created(location)
                .body(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable long id) {
        service.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateProduct(@Valid @PathVariable long id, //Serviço de atualização de produto
            @RequestBody ProductRequest request) {
        service.updateProduct(request, id);
        return ResponseEntity.noContent().build();
    }

}
