package ru.degtyar.geekbrains.spring.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.degtyar.geekbrains.spring.model.Article;
import ru.degtyar.geekbrains.spring.service.ArticleService;

import java.util.Optional;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("article-list")
    public String categoryList (final Model model){
        final Iterable<Article> articles = articleService.findAll();
        model.addAttribute("articles", articles);
        return "category-list";
    }

    @GetMapping("article-edit/{id}")
    public String categoryEdit (final Model model, @PathVariable("id") final String id){
        final Optional<Article> article = articleService.findById(id);
        article.ifPresent(p -> model.addAttribute("article", p));
        return "category-edit";
    }

    @PostMapping("article-save")
    public String categorySave (@ModelAttribute("article") final Article article, final BindingResult bindingResult){
        if(!bindingResult.hasErrors()) articleService.save(article);
        return "redirect:/article-list";
    }

    @GetMapping("article-view/{id}")
    public String categoryView (final Model model, @PathVariable ("id") final String id) {
        final Optional<Article> article = articleService.findById(id);
        article.ifPresent(p -> model.addAttribute("article", p));
        return "article-view";
    }

    @GetMapping("article-delete/{id}")
    public String categoryDelete ( @PathVariable ("id") final String id){
        articleService.deleteById(id);
        return "redirect:/article-list";
    }

    @GetMapping("article-create")
    public String categoryCreate(){
        final Article article = new Article();
        article.setName("New article");
        articleService.save(article);
        return "redirect:/article-list";
    }
}
