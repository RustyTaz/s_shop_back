package com.example.justshop.repository;

import com.example.justshop.entity.CompanyEntity;
import com.example.justshop.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<ProductEntity,Long> {
    ProductEntity findByCompanyAndPriceBetween(String companyname,int firstnum,int secondnum);
}
