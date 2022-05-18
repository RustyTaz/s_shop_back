package com.example.justshop.service;


import com.example.justshop.entity.ProductEntity;
import com.example.justshop.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<ProductEntity> findByCompanyAndPriceBetween(String company, int firstnum,int secnum)  {
        List <ProductEntity> product = (List<ProductEntity>) productRepo.findByCompanyAndPriceBetween(company,firstnum,secnum);
        return product;
    }

}
