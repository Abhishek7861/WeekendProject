package com.example.demo.controller;

import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.demo.repository.ProductRepository;
import com.example.demo.model.Product;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/allProducts")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getProduct(@RequestHeader("Authorization") long authId)
    {
        System.out.println(authId);
        return productService.getProduct();
    }

    @GetMapping("/myProducts")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getProductByID(@RequestHeader("Authorization") long authId){
        return productService.getProductID(authId);
    }

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    private Product addProduct(@RequestBody Product product,@RequestHeader("Authorization") long authId)
    {
        return productService.addProduct(product);
    }

    @PutMapping("/product")
    @ResponseStatus(HttpStatus.OK)
    private Product updateProduct(@RequestBody Product product,@RequestHeader("Authorization") long authId)
    {
        return productService.addProduct(product);
    }

    @DeleteMapping("/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void deleteProduct(@PathVariable long id,@RequestHeader("Authorization") long authId)
    {
        productService.deleteProduct(id, authId);
    }


}
