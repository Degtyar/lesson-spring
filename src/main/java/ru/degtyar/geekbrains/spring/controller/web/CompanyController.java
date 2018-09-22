package ru.degtyar.geekbrains.spring.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.degtyar.geekbrains.spring.model.Company;
import ru.degtyar.geekbrains.spring.service.CompanyService;

import java.util.Optional;

@Controller
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("company-list")
    public String companyList (final Model model){
        final Iterable<Company> companies = companyService.findAll();
        model.addAttribute("companies", companies);
        return "company-list";
    }

    @GetMapping("company-edit/{id}")
    public String companyEdit (final Model model, @PathVariable("id") final String id){
        final Optional<Company> company = companyService.findById(id);
        company.ifPresent(p -> model.addAttribute("company", p));
        return "company-edit";
    }

    @PostMapping("company-save")
    public String companySave (@ModelAttribute("company") final Company company, final BindingResult bindingResult){
        if(!bindingResult.hasErrors()) companyService.save(company);
        return "redirect:/company-list";
    }

    @GetMapping("company-view/{id}")
    public String companyView (final Model model, @PathVariable ("id") final String id) {
        final Optional<Company> company = companyService.findById(id);
        company.ifPresent(p -> model.addAttribute("company", p));
        return "company-view";
    }

    @GetMapping("company-delete/{id}")
    public String companyDelete ( @PathVariable ("id") final String id){
        companyService.deleteById(id);
        return "redirect:/company-list";
    }

    @GetMapping("company-create")
    public String companyCreate(){
        final Company company = new Company();
        company.setName("New company");
        companyService.save(company);
        return "redirect:/company-list";
    }
}
