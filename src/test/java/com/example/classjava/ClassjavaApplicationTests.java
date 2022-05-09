package com.example.classjava;

import com.example.classjava.Oder.Oder;
import com.example.classjava.Oder.OderService;
import com.example.classjava.Product.Product;
import com.example.classjava.Product.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@SpringBootTest
class ClassjavaApplicationTests {
    @Autowired
    OderService oderService;
    @Autowired
    ProductService productService;
    @Test
    void contextLoads() {
        Optional<Oder> optionaloder = oderService.findById(2);
        Optional<Product> optionalproduct = productService.findById(2);
        if (!optionaloder.isPresent() || !optionaloder.isPresent()){
            System.out.println("404");
        }
        boolean result = oderService.Addoderdetail(optionaloder.get(),optionalproduct.get(),2);
        if (!result){
            System.out.println("500");
        }else{
            System.out.println("ok");
        }

    }

}
