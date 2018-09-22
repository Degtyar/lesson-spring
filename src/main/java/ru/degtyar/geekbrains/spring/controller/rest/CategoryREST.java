package ru.degtyar.geekbrains.spring.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.degtyar.geekbrains.spring.dto.CategoryDTO;
import ru.degtyar.geekbrains.spring.dto.ResultDTO;
import ru.degtyar.geekbrains.spring.model.Category;
import ru.degtyar.geekbrains.spring.service.CategoryService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("CategoriesREST")
public class CategoryREST {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "getListCategory", produces = "application/json")
    public List<CategoryDTO> getListCategory(){
        try {
            Iterable<Category> categories = categoryService.findAll();
            return StreamSupport
                    .stream(categories.spliterator(), false)
                    .map(CategoryDTO::new)
                    .collect(Collectors.toList());
        }catch (final Exception e){
            return Collections.emptyList();
        }
    }

    @GetMapping(value = "createCategory", produces = "application/json")
    public CategoryDTO createCategory () {
        try {
            final Category category = new Category();
            category.setName("New Category");
            categoryService.save(category);
            return new CategoryDTO(category);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping(value = "getCategoryById/{id}", produces = "application/json")
    public CategoryDTO getCategoryById (@PathVariable("id") final String id){
        try {
            final Optional<Category> category = categoryService.findById(id);
            return category.map(CategoryDTO::new).orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping(value = "deleteCategoryById/{id}", produces = "application/json")
    public ResultDTO deleteCategoryById (@PathVariable("id") final String id){
        try {
            categoryService.deleteById(id);
            return new ResultDTO();
        } catch (Exception e) {
            return null;
        }
    }
}
