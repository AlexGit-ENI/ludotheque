package fr.eni.ludotheque.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if(! "Jesus".equals(username)){
            throw new UsernameNotFoundException("Jesus not found");
        }

        UserDetails user = User.withUsername("Jesus").password("azerty1996wxcvbn76k2!").roles("UTILISATEUR").build();

        return user;
    }
}
