package com.example.justshop.controller;

import com.example.justshop.entity.CompanyEntity;
import com.example.justshop.exception.CompanyAlreadyExistException;
import com.example.justshop.exception.CompanyNotFoundException;
import com.example.justshop.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/test/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/all")
    public ResponseEntity getCompanies(){
        try{
            return ResponseEntity.ok(companyService.getAllCompanies());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Something wrong");
        }
    }

    @GetMapping("")
    public ResponseEntity getOneCompany(@RequestParam Long id){
        try {
            return ResponseEntity.ok(companyService.getOneCompany(id));
        } catch (CompanyNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
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

    @PutMapping
    public ResponseEntity updateCompany(@RequestParam Long id, @RequestBody CompanyEntity companyEntity){
        try {
            return ResponseEntity.ok(companyService.updateCompany(id,companyEntity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(companyService.deleteCompany(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

}
