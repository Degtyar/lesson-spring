package ru.degtyar.geekbrains.spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.degtyar.geekbrains.spring.model.Article;
import ru.degtyar.geekbrains.spring.repository.ArticleRepository;

import java.util.Optional;

@Service
@Transactional
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Iterable<Article> findAll(Sort sort) {
        return articleRepository.findAll(sort);
    }

    public Page<Article> findAll(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    public <S extends Article> S save(S s) {
        return articleRepository.save(s);
    }

    public <S extends Article> Iterable<S> saveAll(Iterable<S> iterable) {
        return articleRepository.saveAll(iterable);
    }

    public Optional<Article> findById(String s) {
        return articleRepository.findById(s);
    }

    public boolean existsById(String s) {
        return articleRepository.existsById(s);
    }

    public Iterable<Article> findAll() {
        return articleRepository.findAll();
    }

    public Iterable<Article> findAllById(Iterable<String> iterable) {
        return articleRepository.findAllById(iterable);
    }

    public long count() {
        return articleRepository.count();
    }

    public void deleteById(String s) {
        articleRepository.deleteById(s);
    }

    public void delete(Article article) {
        articleRepository.delete(article);
    }

    public void deleteAll(Iterable<? extends Article> iterable) {
        articleRepository.deleteAll(iterable);
    }

    public void deleteAll() {
        articleRepository.deleteAll();
    }
}
