package ru.degtyar.geekbrains.spring.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.degtyar.geekbrains.spring.dto.ArticleDTO;
import ru.degtyar.geekbrains.spring.dto.ResultDTO;
import ru.degtyar.geekbrains.spring.model.Article;
import ru.degtyar.geekbrains.spring.service.ArticleService;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("ArticleREST")
public class ArticleREST {

    @Autowired
    private ArticleService articleService;

    @GetMapping(value = "getListArticle", produces = "application/json")
    public List<ArticleDTO> getListArticle() {
        try {
            Iterable<Article> articles = articleService.findAll();
            return StreamSupport
                    .stream(articles.spliterator(), false)
                    .map(ArticleDTO::new)
                    .collect(Collectors.toList());
        } catch (final Exception e) {
            return Collections.emptyList();
        }
    }

    @GetMapping(value = "createArticle", produces = "application/json")
    public ArticleDTO createCategory() {
        try {
            final Article article = new Article();
            article.setName("New Article");
            article.setPhoneNumber("000 000 00 00");
            article.setNoticeText("New Article");
            articleService.save(article);
            return new ArticleDTO(article);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping(value = "getArticleById/{id}", produces = "application/json")
    public ArticleDTO getArticleById(@PathVariable("id") final String id) {
        try {
            final Optional<Article> article = articleService.findById(id);
            return article.map(ArticleDTO::new).orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping(value = "deleteArticleById/{id}", produces = "application/json")
    public ResultDTO deleteArticleById(@PathVariable("id") final String id) {
        try {
            articleService.deleteById(id);
            return new ResultDTO();
        } catch (Exception e) {
            return null;
        }
    }
}