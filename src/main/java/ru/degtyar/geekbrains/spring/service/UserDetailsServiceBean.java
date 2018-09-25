package ru.degtyar.geekbrains.spring.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.degtyar.geekbrains.spring.model.Role;
import ru.degtyar.geekbrains.spring.model.User;
import ru.degtyar.geekbrains.spring.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
public class UserDetailsServiceBean implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = findByLogin(username);
        if (user == null) new UsernameNotFoundException("User not found!");
        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        builder = org.springframework.security.core.userdetails.User.withUsername(username);
        builder.password(user.getPassword());
        final List<Role> userRoles = user.getRoles();
        final List<String> roles = new ArrayList<>();
        for (Role role: userRoles) roles.add(role.toString());
        builder.roles(roles.toArray(new String[] {}));
        return builder.build();
    }

    private User findByLogin(String username){
        if (username == null || username.isEmpty()) return null;
        return userRepository.findByLogin(username);
    }
}
