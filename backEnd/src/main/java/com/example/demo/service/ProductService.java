package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getProduct(){
        return productRepository.findAll();
    }

    public List<Product> getProductID(long id){
        return productRepository.findByUserid(id);
    }


    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public String deleteProduct(long id,long authId) {
        Product p = productRepository.getById(id);
        if(p.getUserid() == authId) {
            productRepository.deleteById(id);
            return "success";
        }
        else{
            return "failure";
        }
    }
}
