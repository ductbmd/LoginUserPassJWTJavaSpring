package auth.simple.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import auth.simple.model.User;
import auth.simple.repository.UserRepository;





@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
   
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with userName : " + userName)
        );
       
        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(int id) {
        User user = userRepository.findByUserId(id).orElseThrow(
            () -> new UsernameNotFoundException("User not found")
        );
        return UserPrincipal.create(user);
    }
}