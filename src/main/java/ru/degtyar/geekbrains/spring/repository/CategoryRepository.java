package ru.degtyar.geekbrains.spring.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.degtyar.geekbrains.spring.model.Category;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, String>{

}
