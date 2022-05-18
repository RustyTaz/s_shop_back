package com.example.justshop.repository;

import com.example.justshop.entity.CompanyEntity;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepo extends CrudRepository <CompanyEntity,Long>{
    CompanyEntity findByCompanyname(String companyname);
}
