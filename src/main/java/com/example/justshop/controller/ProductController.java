package com.example.justshop.controller;

import com.example.justshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ResponseEntity getProductByCompanyAndPriceBetween(@RequestBody String company, int firstnum, int secondnum) {
        try {
            return ResponseEntity.ok(productService.findByCompanyAndPriceBetween(company,firstnum,secondnum));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something wrong");
        }
    }
}
