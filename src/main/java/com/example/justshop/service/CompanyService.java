package com.example.justshop.service;

import com.example.justshop.entity.CompanyEntity;
import com.example.justshop.exception.CompanyAlreadyExistException;
import com.example.justshop.exception.CompanyNotFoundException;
import com.example.justshop.repository.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<CompanyEntity> getAllCompanies() {
        List<CompanyEntity> companyEntityList;
        companyEntityList = (List<CompanyEntity>) companyRepo.findAll();
        return companyEntityList;
    }


    public CompanyEntity getOneCompany(Long id) throws CompanyNotFoundException {
        CompanyEntity company = companyRepo.findById(id).get();
        if (company == null) {
            throw new CompanyNotFoundException("Компания не найдена");
        }
        return company;
    }

    public Long deleteCompany(Long id) {
        companyRepo.deleteById(id);
        return id;
    }

    public CompanyEntity updateCompany(Long id, CompanyEntity companyEntity){
        CompanyEntity company = companyRepo.findById(id).get();
        company.setCompanyname(companyEntity.getCompanyname());
        company.setCountry(companyEntity.getCountry());
        company.setDescription(companyEntity.getDescription());
        companyRepo.save(company);
        return company;
    }


}
