package ru.degtyar.geekbrains.spring.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.degtyar.geekbrains.spring.model.Company;

@Repository
public interface CompanyRepository extends PagingAndSortingRepository<Company, String> {

}
