package com.gino.simpleWebApp.service;

import com.gino.simpleWebApp.model.products;
import com.gino.simpleWebApp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Service
public class product_service {

    @Autowired
    ProductRepo repo;

//    List<products> products = new ArrayList<>(Arrays.asList(new products(1,"Shirt", 25),
//            new products(2, "Pants", 10),
//            new products(3, "Hats", 5)));

    public List<products> getAllProducts() {
        return repo.findAll();
    }


    public products getProd(int prodId) {
        return repo.findById(prodId).orElse(new products()); //find by Id returns an optional, orElse makes it so it returns the orignal type of object if found and then if not found we can specify another type of object products to pass like an empty one if one isnt found, either way we are always returning a product now instead of an Optional<Products>
        //        return products.stream()
//                .filter(n -> n.getProd_id() == prodId)
//                .findFirst()
//                .get();
        //findFrist changes return to a optional and get works on optional
    }

    public void addProduct(products prod){
        repo.save(prod);
//        products.(prod); //our list name (products) that holds our product objects is 'products'
    }

    public void updateProduct(products prod) {
        repo.save(prod); //notice we done have a differnce from this and addProduct. The way this works is if there is a product that matches the Id then update it, if not it will add it to the database

        //        int index = 0;
//        for (int i = 0 ; i < products.size(); i++ ){
//             if (products.get(i).getProd_id() == prod.getProd_id()){ //get will return us the value at specified index, here the value is a object (prod), getprodID is a getter function of the product option that will return the id of a prod objrct. Then were just checking to see if ht e prod being passed mathces the same prod_id. If so then we will send call set. Set takes two parameters, the index of the element you want to update in the list and then what you want to update it with
//                 index = i;
//             }
//        }
//        products.set(index, prod);
    }

    public void deleteProduct(int prodId) {
        repo.deleteById(prodId);
//        int index = 0;
//        for (int i = 0; i < products.size(); i++){
//            if (products.get(i).getProd_id() == prodId){
//                index = i;
//            }
//        }
//        products.remove(index);
    }
}
