package br.sp.fatec.product.entities; //pacote onde a classe está localizada

public class Product {

    private Long id; //atributo id do tipo Long
    private String name; //atributo name do tipo String
    private String description; //atributo description do tipo String
    private Double price; //atributo price do tipo Double

    public Product(Long id, String name, String description, Double price) { //construtor da classe
        this.id = id; //this referencia o objeto atual, mesmo esquema para os outros atributos
        this.name = name;
        this.description = description;
        this.price = price;
    }
    public Long getId() { //método getter para o atributo id, mesmo esquema para os outros atributos
        return id;
    }
    public void setId(Long id) { //método setter para o atributo id, mesmo esquema para os outros atributos
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }


}
