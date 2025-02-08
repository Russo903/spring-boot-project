package com.gino.simpleWebApp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@Entity
public class products {
    @Id
    private int prod_id;
    private String prod_name;
    private int prod_price;

    public products(int prod_id, String prod_name, int prod_price) {
        this.prod_id = prod_id;
        this.prod_name = prod_name;
        this.prod_price = prod_price;
    }

    public products() {

    }
}
