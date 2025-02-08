package com.gino.simpleWebApp.controller;

import com.gino.simpleWebApp.model.products;
import com.gino.simpleWebApp.service.product_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class product_controller {

    @Autowired
    product_service product_service;

    @RequestMapping("/store")
    public List<products> products(){
        return product_service.getAllProducts();
    }

    @RequestMapping("/store/{prodId}")
    public products getProdById(@PathVariable int prodId){
        return product_service.getProd(prodId);
    }

    @PostMapping("/store") //URI we visit when we want to make this method happen, we can use the same one as before because the one is getmapping and this is post mapping
    public void addProduct(@RequestBody products prod){
        product_service.addProduct(prod);
    }

    @PutMapping("/store")
    public void updateProduct(@RequestBody products prod){ //any time we are passing in JSON as a parameter we want to use @RequestBody so it can serialize the json into an object
        product_service.updateProduct(prod);
    }

    @DeleteMapping("/store/{prodId}")
    public void deleteProduct(@PathVariable int prodId){
        product_service.deleteProduct(prodId);
    }

}
