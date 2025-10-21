package br.sp.fatec.product.entities; //pacote onde a classe está localizada

import java.io.Serializable;

import jakarta.persistence.Entity; //anotação que indica que a classe é uma entidade JPA
import jakarta.persistence.GeneratedValue; //anotação que indica que o valor do id será gerado automaticamente pelo banco de dados
import jakarta.persistence.GenerationType;//enumeração que define as estratégias de geração de valores para a chave primária
import jakarta.persistence.Id; //anotação que indica o atributo chave primária
import jakarta.persistence.Table; //anotação que indica o nome da tabela no banco de dados

@Entity //anotação que indica que a classe é uma entidade JPA
@Table(name = "TBL_PRODUCT") //anotação que indica o nome da tabela no banco de dados

public class Product implements Serializable { //classe Product que implementa a interface Serializable 

    @Id //anotação que indica que o atributo é a chave primária da tabela
    @GeneratedValue(strategy =  GenerationType.IDENTITY) //anotação que indica que o valor do id será gerado automaticamente pelo banco de dados
    private Long id; //atributo id do tipo Long
    private String name; //atributo name do tipo String
    private String description; //atributo description do tipo String
    private Double price; //atributo price do tipo Double

    public Product() { 
        
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

    @Override //método hashCode e equals para comparar objetos da classe Product
    public int hashCode() {
        final int prime = 31;
        int result = 1; //inicializa o resultado com 1
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null) 
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    

}
