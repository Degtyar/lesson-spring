package ru.degtyar.geekbrains.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.degtyar.geekbrains.spring.enume.RoleType;
import ru.degtyar.geekbrains.spring.model.Role;
import ru.degtyar.geekbrains.spring.model.User;
import ru.degtyar.geekbrains.spring.repository.UserRepository;

import java.security.Principal;

@Service
public class AuthService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Nullable
    public User getUser(final Principal principal){
        if (principal == null) return null;
        final String name = principal.getName();
        return userRepository.findByLogin(name);
    }

    @Transactional
    public void initUser(final String login, final String password, final String email){
        if (userRepository.countByLogin(login) > 0) return;
        createUser(login, password, email);
    }

    @Transactional
    public void initUser(final String login, final String password, final String email, final RoleType roleType){
        if (userRepository.countByLogin(login) > 0) return;
        createUser(login, password, email, roleType);
    }

    @Transactional
    public User createUser(final String login, final String password, final String email){
        final String passwordHash = passwordEncoder.encode(password);
        final User user = new User();
        user.setLogin(login);
        user.setPassword(passwordHash);
        user.setEmail(email);
        user.setDisabled(false);
        return (User)userRepository.save(user);
    }

    @Transactional
    public User createUser(final String login, final String password, final String email, final RoleType roleType){
        final User user = createUser(login, password, email);
        user.getRoles().add(new Role(user, roleType));
        return (User)userRepository.save(user);
    }
}