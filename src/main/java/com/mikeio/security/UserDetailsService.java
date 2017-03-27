package com.mikeio.security;

import com.mikeio.domain.User;
import com.mikeio.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Authenticate a user from the database.
 */
@Component("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(UserDetailsService.class);

    @Inject
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String login) {
        log.debug("Authenticating {}", login);
        String lowercaseLogin = login.toLowerCase(Locale.ENGLISH);


        Optional<User> userFromDatabase = null;
//        try {
            userFromDatabase = userRepository.findOneWithAuthoritiesByLogin(lowercaseLogin);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("");
//        }


        org.springframework.security.core.userdetails.User x =
                null;
        try {
            x = userFromDatabase.map(user -> {
               if (!user.getActivated()) {
                   throw new UserNotActivatedException("User " + lowercaseLogin + " was not activated");
               }
               List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
                       .map(authority ->
                               new SimpleGrantedAuthority(authority.getName()))
                       .collect(Collectors.toList());
                org.springframework.security.core.userdetails.User vx =  new org.springframework.security.core.userdetails.User(lowercaseLogin,
                       user.getPassword(),
                       grantedAuthorities);

                return vx;

           }).orElseThrow(() ->
                   new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the " +
                           "database"));
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            System.out.println("");
        }

        return x;
    }
}
