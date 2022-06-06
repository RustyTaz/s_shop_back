package com.example.justshop.repository;

import com.example.justshop.entity.CompanyEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyRepo extends CrudRepository <CompanyEntity,Long>{
    CompanyEntity findByCompanyname(String companyname);
}
