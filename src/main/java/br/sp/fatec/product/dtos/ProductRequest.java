package br.sp.fatec.product.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;

public record ProductRequest(

        @NotBlank(message = "Name is required")
        @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
        String name,

        @NotBlank(message = "Description is required")
        @Size(min = 3, max = 200, message = "Description must be between 3 and 200 characters")
        String description,

        @Min(value = 0, message = "Price must be greater than or equal to 0")
        Double price
) {

  

}
    
