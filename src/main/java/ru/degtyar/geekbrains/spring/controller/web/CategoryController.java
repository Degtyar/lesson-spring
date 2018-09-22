package ru.degtyar.geekbrains.spring.controller.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.degtyar.geekbrains.spring.model.Category;
import ru.degtyar.geekbrains.spring.service.CategoryService;

import java.util.Optional;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("category-list")
    public String categoryList (final Model model){
        final Iterable<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "category-list";
    }

    @GetMapping("category-edit/{id}")
    public String categoryEdit (final Model model, @PathVariable ("id") final String id){
        final Optional<Category> category = categoryService.findById(id);
        category.ifPresent(p -> model.addAttribute("category", p));
        return "category-edit";
    }

    @PostMapping("category-save")
    public String categorySave (@ModelAttribute("category") final Category category, final BindingResult bindingResult){
        if(!bindingResult.hasErrors()) categoryService.save(category);
        return "redirect:/category-list";
    }

    @GetMapping("category-view/{id}")
    public String categoryView (final Model model, @PathVariable ("id") final String id) {
        final Optional<Category> category = categoryService.findById(id);
        category.ifPresent(p -> model.addAttribute("category", p));
        return "category-view";
    }

    @GetMapping("category-delete/{id}")
    public String categoryDelete ( @PathVariable ("id") final String id){
        categoryService.deleteById(id);
        return "redirect:/category-list";
    }

    @GetMapping("category-create")
    public String categoryCreate(){
        final Category category = new Category();
        category.setName("New category");
        categoryService.save(category);
        return "redirect:/category-list";
    }
}
