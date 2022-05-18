package com.example.justshop.service;

import com.example.justshop.entity.CompanyEntity;
import com.example.justshop.exception.CompanyAlreadyExistException;
import com.example.justshop.repository.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepo companyRepo;

    public CompanyEntity addCompany(CompanyEntity company) throws CompanyAlreadyExistException {
        if(companyRepo.findByCompanyname(company.getCompanyname())!=null){
            throw new CompanyAlreadyExistException("Компания с таким именем уже сужествует!");
        }
        return companyRepo.save(company);
    }
}
