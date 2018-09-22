package ru.degtyar.geekbrains.spring.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.degtyar.geekbrains.spring.dto.CategoryDTO;
import ru.degtyar.geekbrains.spring.dto.ResultDTO;
import ru.degtyar.geekbrains.spring.model.Category;
import ru.degtyar.geekbrains.spring.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


//Требует доработки
@RestController
@RequestMapping("api/category")
public class CategoryAPI {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(produces = "application/json")
    public List<CategoryDTO> get(){
        final Iterable<Category> categories = categoryService.findAll();
        return StreamSupport
                .stream(categories.spliterator(), false)
                .map(CategoryDTO::new)
                .collect(Collectors.toList());
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResultDTO post(final CategoryDTO[] categoryDTOS) {
        for (final CategoryDTO categoryDTO : categoryDTOS) {
      //не принимает команду
            //      categoryService.save(categoryDTO);
        }
        return new ResultDTO();
    }

}
