package ru.degtyar.geekbrains.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.degtyar.geekbrains.spring.dto.CategoryDTO;
import ru.degtyar.geekbrains.spring.model.Category;
import ru.degtyar.geekbrains.spring.repository.CategoryRepository;

import java.util.Optional;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Iterable<Category> findAll(Sort sort) {
        return categoryRepository.findAll(sort);
    }

    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    public <S extends Category> S save(S s) {
        return categoryRepository.save(s);
    }

    public <S extends Category> Iterable<S> saveAll(Iterable<S> iterable) {
        return categoryRepository.saveAll(iterable);
    }

    public Optional<Category> findById(String s) {
        return categoryRepository.findById(s);
    }

    public boolean existsById(String s) {
        return categoryRepository.existsById(s);
    }

    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Iterable<Category> findAllById(Iterable<String> iterable) {
        return categoryRepository.findAllById(iterable);
    }

    public long count() {
        return categoryRepository.count();
    }

    public void deleteById(String s) {
        categoryRepository.deleteById(s);
    }

    public void delete(Category category) {
        categoryRepository.delete(category);
    }

    public void deleteAll(Iterable<? extends Category> iterable) {
        categoryRepository.deleteAll(iterable);
    }

    public void deleteAll() {
        categoryRepository.deleteAll();
    }
}
