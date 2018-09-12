package ru.degtyar.geekbrains.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.degtyar.geekbrains.spring.model.Company;
import ru.degtyar.geekbrains.spring.repository.CompanyRepository;

import java.util.Optional;

@Service
@Transactional
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Iterable<Company> findAll(Sort sort) {
        return companyRepository.findAll(sort);
    }

    public Page<Company> findAll(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }

    public <S extends Company> S save(S s) {
        return companyRepository.save(s);
    }

    public <S extends Company> Iterable<S> saveAll(Iterable<S> iterable) {
        return companyRepository.saveAll(iterable);
    }

    public Optional<Company> findById(String s) {
        return companyRepository.findById(s);
    }

    public boolean existsById(String s) {
        return companyRepository.existsById(s);
    }

    public Iterable<Company> findAll() {
        return companyRepository.findAll();
    }

    public Iterable<Company> findAllById(Iterable<String> iterable) {
        return companyRepository.findAllById(iterable);
    }

    public long count() {
        return companyRepository.count();
    }

    public void deleteById(String s) {
        companyRepository.deleteById(s);
    }

    public void delete(Company company) {
        companyRepository.delete(company);
    }

    public void deleteAll(Iterable<? extends Company> iterable) {
        companyRepository.deleteAll(iterable);
    }

    public void deleteAll() {
        companyRepository.deleteAll();
    }
}
