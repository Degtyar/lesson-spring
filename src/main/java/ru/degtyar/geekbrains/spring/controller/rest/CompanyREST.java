package ru.degtyar.geekbrains.spring.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.degtyar.geekbrains.spring.dto.CompanyDTO;
import ru.degtyar.geekbrains.spring.dto.ResultDTO;
import ru.degtyar.geekbrains.spring.model.Company;
import ru.degtyar.geekbrains.spring.service.CompanyService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("CompanyREST")
public class CompanyREST {

    @Autowired
    private CompanyService companyService;

    @GetMapping(value = "getListCategory", produces = "application/json")
    public List<CompanyDTO> getListCategory(){
        try {
            Iterable<Company> companies = companyService.findAll();
            return StreamSupport
                    .stream(companies.spliterator(), false)
                    .map(CompanyDTO::new)
                    .collect(Collectors.toList());
        }catch (final Exception e){
            return Collections.emptyList();
        }
    }

    @GetMapping(value = "createCompany", produces = "application/json")
    public CompanyDTO createCompany () {
        try {
            final Company company = new Company();
            company.setName("New Category");
            companyService.save(company);
            return new CompanyDTO(company);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping(value = "getCompanyById/{id}", produces = "application/json")
    public CompanyDTO getCompanyById (@PathVariable("id") final String id){
        try {
            final Optional<Company> company = companyService.findById(id);
            return company.map(CompanyDTO::new).orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping(value = "deleteCompanyById/{id}", produces = "application/json")
    public ResultDTO deleteCompanyById (@PathVariable("id") final String id){
        try {
            companyService.deleteById(id);
            return new ResultDTO();
        } catch (Exception e) {
            return null;
        }
    }
}
