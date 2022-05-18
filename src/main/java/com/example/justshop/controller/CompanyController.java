package com.example.justshop.controller;

import com.example.justshop.entity.CompanyEntity;
import com.example.justshop.exception.CompanyAlreadyExistException;
import com.example.justshop.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("")
    public ResponseEntity getCompanies(){
        try{
            return ResponseEntity.ok("Server online");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Something wrong");
        }
    }

    @PostMapping
    public ResponseEntity addCompany(@RequestBody CompanyEntity companyEntity){
        try {
            companyService.addCompany(companyEntity);
            return ResponseEntity.ok("Новая компания добавлена");
        } catch (CompanyAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
