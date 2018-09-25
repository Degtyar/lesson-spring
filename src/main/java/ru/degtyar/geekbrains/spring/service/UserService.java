package ru.degtyar.geekbrains.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.degtyar.geekbrains.spring.model.User;
import ru.degtyar.geekbrains.spring.repository.UserRepository;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> findAll(Sort sort) {
        return userRepository.findAll(sort);
    }

    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Transactional
    public <S extends User> S save(S s) {
        return (S) userRepository.save(s);
    }

    public <S extends User> Iterable<S> saveAll(Iterable<S> iterable) {
        return userRepository.saveAll(iterable);
    }

    public Optional<User> findById(String s) {
        return userRepository.findById(s);
    }

    public boolean existsById(String s) {
        return userRepository.existsById(s);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public Iterable<User> findAllById(Iterable<String> iterable) {
        return userRepository.findAllById(iterable);
    }

    public long count() {
        return userRepository.count();
    }

    public void deleteById(String s) {
        userRepository.deleteById(s);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public void deleteAll(Iterable<? extends User> iterable) {
        userRepository.deleteAll(iterable);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }
}
